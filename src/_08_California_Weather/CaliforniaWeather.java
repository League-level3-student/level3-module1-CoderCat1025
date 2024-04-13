package _08_California_Weather;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 �F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 * 
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api
 */

public class CaliforniaWeather implements ActionListener {
	JPanel panel;
	JFrame frame;
	JButton CButton;
	JButton WButton;
	JButton TButton;

	void setup() {
		panel = new JPanel();
		frame = new JFrame();
		CButton = new JButton();
		WButton = new JButton();
		TButton = new JButton();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		panel.add(CButton);
		panel.add(TButton);
		panel.add(WButton);

		frame.setName("California Weather");
		CButton.setText("Search by City Name");
		WButton.setText("Search by Weather Condition");
		TButton.setText("Search by Temperature");

		CButton.addActionListener(this);
		WButton.addActionListener(this);
		TButton.addActionListener(this);

		frame.pack();

	}

	void nameSearch() {
		HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();

		// All city keys have the first letter capitalized of each word
		String cityName = JOptionPane.showInputDialog(null, "Input a city name (capitalized).");
		WeatherData datum = weatherData.get(cityName);

		if( datum == null ) {
			JOptionPane.showMessageDialog(null, "Unable to find weather data for: " + cityName);
		} else {
			JOptionPane.showMessageDialog(null, cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
		}
	}

	void weatherSearch() {
		HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();

		String weather = JOptionPane.showInputDialog(null, "Input a weather condition.");

		String cities = "Cities with " + weather + " weather: ";
		Set <String> keys = weatherData.keySet();
		int count = 0;
		for (String i : keys) {
			if (i.contains("0") || i.contains("1") || i.contains("2") || i.contains("3") || i.contains("4") || i.contains("5") || i.contains("6") || i.contains("7") || i.contains("8") || i.contains("9")) {

			} else {
				if (weatherData.get(i).weatherSummary.equals(weather)) {
					cities = cities + i + ", ";
					count++;
					if (count%10 == 0) {
						cities = cities + "\n";
					}
				}
			}
		}

		if (cities.equals("Cities with " + weather + " weather: ")) {
			JOptionPane.showMessageDialog(null, "There are no cities with that weather condition.");
		} else {
			JOptionPane.showMessageDialog(null, cities);
		}
	}

	void tempSearch() {
		HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();

		String a = JOptionPane.showInputDialog(null, "Input a minimuum temperature.");
		String b = JOptionPane.showInputDialog(null, "Input a maximum temperature.");

		int min = Integer.parseInt(a);
		int max = Integer.parseInt(b);

		String cities = "Cities with " + min + " to " + max + " temperature: ";
		Set <String> keys = weatherData.keySet();
		int count = 0;
		for (String i : keys) {
			if (i.contains("0") || i.contains("1") || i.contains("2") || i.contains("3") || i.contains("4") || i.contains("5") || i.contains("6") || i.contains("7") || i.contains("8") || i.contains("9")) {

			} else {
				if (weatherData.get(i).temperatureF < max && weatherData.get(i).temperatureF > min) {
					cities = cities + i + ", ";
					count++;
					if (count%10 == 0) {
						cities = cities + "\n";
					}
				}
			}
		}

		if (cities.equals("Cities with " + min + " to " + max + " temperature: ")) {
			JOptionPane.showMessageDialog(null, "There are no cities within the temperature range.");
		} else {
			JOptionPane.showMessageDialog(null, cities);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == CButton) {
			nameSearch();
		} else if (e.getSource() == WButton) {
			weatherSearch();
		} else if (e.getSource() == TButton) {
			tempSearch();
		}

	}
}
