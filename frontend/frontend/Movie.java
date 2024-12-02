package frontend;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Movie {
    private String name;
    public Date_time release_Date;
    private String director;
    private ArrayList<Showtime> showtimes;

    // Default constructor
    public Movie() {
        this.showtimes = new ArrayList<>();
    }

    // Parameterized constructor
    public Movie(String name, Date_time release_Date, String director) {
        this.name = name;
        this.release_Date = release_Date;
        this.director = director;
        this.showtimes = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public Date_time getRelease_date() {
        return this.release_Date;
    }

    public String getDirector() {
        return this.director;
    }
    public ArrayList<Showtime> getShowTimes(){
        return showtimes;
    }
    public void setShowtimes(ArrayList<Showtime> showtimes){
        this.showtimes = showtimes;
    }

    // Method to print movie info
    public void printMovieInfo() {
        System.out.println("Movie Name: " + this.name);
        System.out.println("Release Date: " + (this.release_Date != null ? this.release_Date.toString() : "N/A"));
        System.out.println("Director: " + this.director);
    }

    // Method to fetch movies from the API and return a list of Movie objects
    public static ArrayList<Movie> getMovies() {
        ArrayList<Movie> movies = new ArrayList<>();
        try {
            URL url = new URL("http://localhost:8080/movies/");
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
                jsonString = jsonString.trim().substring(1, jsonString.length() - 1); // Remove [ and ] from the JSON array

                String[] movieObjects = jsonString.split("\\},\\{"); // Split the JSON array into individual movie JSONs

                for (String movieJson : movieObjects) {
                    // Clean up the JSON strings to ensure each JSON object is valid
                    if (!movieJson.startsWith("{")) movieJson = "{" + movieJson;
                    if (!movieJson.endsWith("}")) movieJson = movieJson + "}";

                    // Extract fields from each movie JSON
                    String movieName = extractJsonValue(movieJson, "movieName");
                    String director = extractJsonValue(movieJson, "director");
                    String releaseDateStr = extractJsonValue(movieJson, "releaseDate");

                    String[] dateParts = releaseDateStr.split("-");
                    int year = Integer.parseInt(dateParts[0]);
                    int month = Integer.parseInt(dateParts[1]);
                    int day = Integer.parseInt(dateParts[2]);

                    Date_time releaseDate = new Date_time(year, month, day);

                    movies.add(new Movie(movieName, releaseDate, director));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }

    // Helper method to extract a value from a JSON string
    private static String extractJsonValue(String json, String key) {
        String keyPattern = "\"" + key + "\":\"";
        int startIndex = json.indexOf(keyPattern) + keyPattern.length();
        int endIndex = json.indexOf("\"", startIndex);
        return json.substring(startIndex, endIndex);
    }

    public static void main(String[] args) {
        // Fetch movies from the API
        ArrayList<Movie> movies = Movie.getMovies();

        // Print the details of each movie
        for (Movie movie : movies) {
            movie.printMovieInfo();
            System.out.println("--------------");
        }
    }
}
