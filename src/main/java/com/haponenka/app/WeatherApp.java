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
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.registerObserver(currentDisplay);
        weatherData.registerObserver(statisticsDisplay);
        weatherData.registerObserver(forecastDisplay);

        LOGGER.info("Первый замер (все экраны)");
        weatherData.setMeasurements(80, 65, 30.4f);

        weatherData.removeObserver(statisticsDisplay);

        LOGGER.info("Второй замер (без статистики)");
        weatherData.setMeasurements(82, 70, 29.2f);
    }
}
