package frontend;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Showtime {

    private int id;
    private double ticketPrice;
    private int theaterId;
    private int showroomNum;
    private String movieName;
    private Date_time showTime;

    // Constructor
    public Showtime(int id, double ticketPrice, int theaterId, int showroomNum, String movieName, Date_time showTime) {
        this.id = id;
        this.ticketPrice = ticketPrice;
        this.theaterId = theaterId;
        this.showroomNum = showroomNum;
        this.movieName = movieName;
        this.showTime = showTime;
    }

    // Getters
    public int getId() {
        return id;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public int getShowroomNum() {
        return showroomNum;
    }

    public String getMovieName() {
        return movieName;
    }

    public Date_time getShowTime() {
        return showTime;
    }

    // Static method to fetch showtimes for a given movie and theater
    public static ArrayList<Showtime> getShowTimes(Movie selectedMovie, Theater selectedTheater) {
        ArrayList<Showtime> showtimes = new ArrayList<>();

        try {
            String urlStr = "http://localhost:8080/shows/movie-and-theater/" +
                    selectedMovie.getName().replace(" ", "%20") + "/" +
                    selectedTheater.getTheaterId();

            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder content = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }

                in.close();
                conn.disconnect();

                // Parse the JSON response manually
                String jsonString = content.toString();
                jsonString = jsonString.trim().substring(1, jsonString.length() - 1);  // Remove [ and ] from the JSON array
                String[] showObjects = jsonString.split("\\},\\{");

                for (String showJson : showObjects) {
                    if (!showJson.startsWith("{")) showJson = "{" + showJson;
                    if (!showJson.endsWith("}")) showJson = showJson + "}";

                    int id = Integer.parseInt(extractJsonValue(showJson, "id"));
                    double ticketPrice = Double.parseDouble(extractJsonValue(showJson, "ticketPrice"));
                    int theaterId = Integer.parseInt(extractJsonValue(showJson, "theaterId"));
                    int showroomNum = Integer.parseInt(extractJsonValue(showJson, "showroomId"));
                    String movieName = extractJsonValue(showJson, "movieName");
                    String dateAndTimeStr = extractJsonValue(showJson, "dateAndTime");

                    String[] dateTimeParts = dateAndTimeStr.split("T");
                    String[] dateParts = dateTimeParts[0].split("-");
                    String[] timeParts = dateTimeParts[1].split(":");

                    int year = Integer.parseInt(dateParts[0]);
                    int month = Integer.parseInt(dateParts[1]);
                    int day = Integer.parseInt(dateParts[2]);
                    int hour = Integer.parseInt(timeParts[0]);
                    int minute = Integer.parseInt(timeParts[1]);

                    Date_time showTime = new Date_time(year, month, day, hour, minute);

                    showtimes.add(new Showtime(id, ticketPrice, theaterId, showroomNum, movieName, showTime));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showtimes;
    }

    // Helper method to extract a value from a JSON string
    private static String extractJsonValue(String json, String key) {
        String keyPattern = "\"" + key + "\":";
        int startIndex = json.indexOf(keyPattern) + keyPattern.length();
        char delimiter = json.charAt(startIndex) == '"' ? '"' : ',';
        startIndex += (delimiter == '"' ? 1 : 0);
        int endIndex = json.indexOf(delimiter, startIndex);
        return json.substring(startIndex, endIndex).replaceAll("[\"}]", "");
    }

    // Main method to test the getShowTimes method
    public static void main(String[] args) {
        Movie selectedMovie = new Movie("Boss Baby", new Date_time(2024, 12, 24), "Tom McGrath");
        Theater selectedTheater = new Theater( "Cineplex Calgary", "123 Default St", 1);

        ArrayList<Showtime> showtimes = Showtime.getShowTimes(selectedMovie, selectedTheater);

        System.out.println("Showtimes for movie: " + selectedMovie.getName());
        System.out.println("At theater: " + selectedTheater.getName() + ", " + selectedTheater.getLocation());
        System.out.println("------------------------------------------------");

        for (Showtime showtime : showtimes) {
            System.out.println("Show ID: " + showtime.getId());
            System.out.println("Movie: " + showtime.getMovieName());
            System.out.println("Showroom: " + showtime.getShowroomNum());
            System.out.println("Ticket Price: $" + showtime.getTicketPrice());
            System.out.println("Date & Time: " + showtime.getShowTime().toString());
            System.out.println("------------------------------------------------");
        }
    }
}
