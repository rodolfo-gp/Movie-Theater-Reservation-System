package frontend;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Seat {
    private char row;
    private int cloumn;
    private boolean booked;

    public Seat(char row, int cloumn, boolean booked) {
        this.row = row;
        this.cloumn = cloumn;
        this.booked = booked;
    }

    public char getRow() {
        return this.row;
    }

    public int getCloumn() {
        return this.cloumn;
    }

    public boolean getBooked() {
        return this.booked;
    }

    public void setBooked(boolean booking) {
        this.booked = booking;
    }

    public static ArrayList<Seat> getSeatsForShowtime(String showtime) {
        ArrayList<Seat> seats = new ArrayList<Seat>();
        try {
            // The URL to your seat endpoint, including the showtime path variable
            String urlStr = "http://localhost:8080/seat/" + showtime.replace(" ", "%20") + "/";
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            
            
            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            
            if (responseCode == HttpURLConnection.HTTP_OK) { //if connect is good 
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                
                // Close connections
                in.close();
                conn.disconnect();
                
                System.out.println("Seats: " + content.toString());

                // Parse the JSON response manually
                String jsonString = content.toString();
                jsonString = jsonString.trim().substring(1, jsonString.length() - 1); // Remove [ and ] from the JSON array

                String[] seatObjects = jsonString.split("\\},\\{"); // Split the JSON array into individual seat JSONs

                for (String seatJson : seatObjects) {
                    // Clean up the JSON strings to ensure each JSON object is valid
                    if (!seatJson.startsWith("{")) seatJson = "{" + seatJson;
                    if (!seatJson.endsWith("}")) seatJson = seatJson + "}";

                    // Extract fields from each movie JSON
                    boolean status = Boolean.parseBoolean(extractJsonValue(seatJson, "booked"));
                    int row = Integer.parseInt(extractJsonValue(seatJson, "seatRow"));
                    char rowchar = (char)('A' + row);
                    int column = Integer.parseInt(extractJsonValue(seatJson, "seatColumn"));
                    Seat newseat = new Seat(rowchar,column,status);
                    seats.add(newseat);
                }
                
            } else {
                System.out.println("GET request failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seats;
    }

    // Helper method to extract a value from a JSON string
    private static String extractJsonValue(String json, String key) {
        String keyPattern = "\"" + key + "\":\"";
        int startIndex = json.indexOf(keyPattern) + keyPattern.length();
        int endIndex = json.indexOf("\"", startIndex);
        return json.substring(startIndex, endIndex);
    }

}
