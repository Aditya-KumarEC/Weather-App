# 🌦️ Weather App in Java

A beginner-friendly Java project that fetches **real-time weather information** from [OpenWeatherMap API](https://openweathermap.org/api).  
It has both a **Console version** and a **GUI version (Swing)** included in this repository.

---

## 📂 Project Structure

Your folder should contain the following files:

| File Name              | Description                                      |
|------------------------|--------------------------------------------------|
| `WeatherApp.java`      | Console-based weather application                |
| `WeatherAppGUI.java`   | GUI-based weather app using Java Swing           |
| `json-20210307.jar`    | Required external JSON library for parsing API   |

---

## 🎯 Features

✅ Get current temperature (°C)  
✅ See humidity percentage  
✅ Get short weather description (like clear sky, rain)  
✅ Simple GUI for easy interaction  
✅ Uses `org.json` library for JSON parsing

---

## 🧑‍💻 Technologies Used

- ✅ Java (JDK 8 or above)
- ✅ OpenWeatherMap API
- ✅ Swing (for GUI)
- ✅ org.json (via `json-20210307.jar`)

---

## 🔑 How to Get API Key

You need a free API key from OpenWeatherMap:

1. Visit: [https://openweathermap.org/api](https://openweathermap.org/api)
2. Sign up or log in
3. Copy your **API key**
4. Paste your API key into both files in place of `"your_api_key"`:
   ```java
   String apiKey = "your_api_key";


## 🌐 Console Version
- Input city name via terminal
- Displays temperature, humidity, and weather condition

## 💻 GUI Version (Swing)
- Enter city name in a GUI
- Weather info shown in an output box

### 📦 Requirements
- Java 8+
- Internet Connection
- `json-20210307.jar` (already included)

📦 How to Run (Windows CMD or PowerShell)

▶️ Run Console Version
javac -cp .;json-20210307.jar WeatherApp.java
java -cp .;json-20210307.jar WeatherApp

🖥️ Run GUI Version
javac -cp .;json-20210307.jar WeatherAppGUI.java
java -cp .;json-20210307.jar WeatherAppGUI

## 👤 Author

**Aditya Kumar**  
🔗 GitHub: [@Aditya-KumarEC](https://github.com/Aditya-KumarEC)

## 📃 License
Free to use for learning and academic purposes.


