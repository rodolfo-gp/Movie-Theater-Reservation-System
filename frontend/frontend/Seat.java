package frontend;
public class Seat {
    private char row;
    private int number;
    private boolean booked;

    public Seat(char row, int number) {
        this.row = row;
        this.number = number;
        this.booked = false;
    }

    public char getRow() {
        return this.row;
    }

    public int getNumber() {
        return this.number;
    }

    public boolean getBooked() {
        return this.booked;
    }

    public void setBooked(boolean booking) {
        this.booked = booking;
    }

    public static void getSeatsForShowtime(String showtime) {
        try {
            // The URL to your seat endpoint, including the showtime path variable
            URL url = new URL("http://localhost:8080/seat/" + showtime);
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
            } else {
                System.out.println("GET request failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  

}
