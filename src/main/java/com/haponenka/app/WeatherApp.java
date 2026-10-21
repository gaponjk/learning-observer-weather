package com.haponenka.app;

import com.haponenka.app.display.impl.CurrentConditionsDisplay;
import com.haponenka.app.display.impl.ForecastDisplay;
import com.haponenka.app.display.impl.StatisticsDisplay;
import com.haponenka.app.subject.impl.WeatherData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WeatherApp {
    private static final Logger LOGGER = LogManager.getLogger(WeatherApp.class);

    public static void main(String[] args) {
        WeatherData weatherData=new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay=new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay=new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay=new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);

    }
}
