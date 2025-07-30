import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class WeatherAppGUI {

    private static final String API_KEY = "445c6ee3b83d04955c2831d7fd8dd166";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Weather App");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel cityLabel = new JLabel("Enter City:");
        JTextField cityField = new JTextField(20);
        JButton getWeatherButton = new JButton("Get Weather");
        JTextArea resultArea = new JTextArea(8, 30);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setEditable(false);

        frame.add(cityLabel);
        frame.add(cityField);
        frame.add(getWeatherButton);
        frame.add(new JScrollPane(resultArea));

        getWeatherButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String city = cityField.getText().trim();
                if (!city.isEmpty()) {
                    String result = getWeather(city);
                    resultArea.setText(result);
                } else {
                    resultArea.setText("❌ Please enter a city name.");
                }
            }
        });

        frame.setVisible(true);
    }

    private static String getWeather(String city) {
        try {
            String urlStr = "http://api.openweathermap.org/data/2.5/weather?q=" +
                    city + "&appid=" + API_KEY + "&units=metric";
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            Scanner sc = new Scanner(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            while (sc.hasNext()) {
                response.append(sc.nextLine());
            }
            sc.close();

            JSONObject json = new JSONObject(response.toString());
            String cityName = json.getString("name");
            double temp = json.getJSONObject("main").getDouble("temp");
            String condition = json.getJSONArray("weather").getJSONObject(0).getString("description");

            return "✅ Weather Info:\nCity: " + cityName + "\nTemperature: " + temp + "°C\nCondition: " + condition;
        } catch (Exception e) {
            return "❌ Unable to get weather data. Check the city name or your internet connection.";
        }
    }
}
