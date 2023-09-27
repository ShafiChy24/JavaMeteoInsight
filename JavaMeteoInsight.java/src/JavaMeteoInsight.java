// JavaMeteoInsight.java
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JavaMeteoInsight {

    private static final String API_KEY = "7d4e26e3458174ed873fc3586823f944";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=London&units=metric&appid=";

    public static void main(String[] args) throws Exception {
        URL url = new URL(BASE_URL + API_KEY);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        System.out.println(response.toString()); // Prints the entire JSON response
    }
}
