import java.util.Scanner;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONObject;

public class WeatherApp {

    // Replace this with your actual API key
    private static final String API_KEY = "445c6ee3b83d04955c2831d7fd8dd166";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("🌍 Welcome to the Real-Time Weather App");

        System.out.print("Enter city name: ");
        String city = scanner.nextLine().trim();

        getWeather(city);
        scanner.close();
    }

    public static void getWeather(String city) {
        try {
            String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" +
                    city + "&appid=" + API_KEY + "&units=metric";

            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream())
            );
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject json = new JSONObject(response.toString());

            String cityName = json.getString("name");
            double temp = json.getJSONObject("main").getDouble("temp");
            String weather = json.getJSONArray("weather")
                                 .getJSONObject(0)
                                 .getString("description");

            System.out.println("\n✅ Weather Info:");
            System.out.println("City: " + cityName);
            System.out.println("Temperature: " + temp + "°C");
            System.out.println("Condition: " + weather);

        } catch (Exception e) {
            System.out.println("❌ Unable to get weather. Please check city name or API key.");
            System.out.println("Error: " + e.getMessage());
        }
    }
}
