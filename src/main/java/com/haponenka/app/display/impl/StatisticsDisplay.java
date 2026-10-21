package com.haponenka.app.display.impl;

import com.haponenka.app.display.DisplayElement;
import com.haponenka.app.observer.Observer;
import com.haponenka.app.subject.impl.WeatherData; // или com.haponenka.app.subject.impl.WeatherData
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StatisticsDisplay implements Observer, DisplayElement {
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum = 0.0f;
    private int numReadings;
    private WeatherData weatherData;

    private final static Logger LOGGER= LogManager.getLogger(StatisticsDisplay.class);

    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        tempSum += temperature;
        numReadings++;
        if (temperature > maxTemp) {
            maxTemp = temperature;
        }
        if (temperature < minTemp) {
            minTemp = temperature;
        }
        display();
    }

    @Override
    public void display() {
        LOGGER.info("Avg/Max/Min temperature = {}/{}/{} ", (tempSum / numReadings), maxTemp, minTemp);
    }
}