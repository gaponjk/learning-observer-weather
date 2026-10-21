package com.haponenka.app.display.impl;

import com.haponenka.app.display.DisplayElement;
import com.haponenka.app.observer.Observer;
import com.haponenka.app.subject.impl.WeatherData; // или com.haponenka.app.subject.impl.WeatherData
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StatisticsDisplay implements Observer, DisplayElement {
    private float maxTemp = Float.NEGATIVE_INFINITY;
    private float minTemp = Float.POSITIVE_INFINITY;
    private float tempSum = 0.0f;
    private int numReadings = 0;
    private final WeatherData weatherData;

    private final static Logger LOGGER= LogManager.getLogger(StatisticsDisplay.class);

    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public void update() {
        float temp = weatherData.getTemperature();
        tempSum += temp;
        numReadings++;
        if (temp > maxTemp) {
            maxTemp = temp;
        }
        if (temp < minTemp) {
            minTemp = temp;
        }
        display();
    }

    @Override
    public void display() {
        LOGGER.info("Avg/Max/Min temperature = {}/{}/{} ", (tempSum / numReadings), maxTemp, minTemp);
    }
}