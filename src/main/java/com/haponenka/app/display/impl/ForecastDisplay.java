package com.haponenka.app.display.impl;

import com.haponenka.app.display.DisplayElement;
import com.haponenka.app.observer.Observer;
import com.haponenka.app.subject.impl.WeatherData; // или com.haponenka.app.subject.impl.WeatherData
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ForecastDisplay implements Observer, DisplayElement {
    private float currentPressure = 29.92f;
    private float lastPressure;
    private final WeatherData weatherData;

    private final static Logger LOGGER= LogManager.getLogger(ForecastDisplay.class);


    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public void update() {
        lastPressure = currentPressure;
        currentPressure = weatherData.getPressure();

        display();
    }

    @Override
    public void display() {
        String forecast;
        if (currentPressure > lastPressure) {
            forecast = "Improving weather on the way!";
        } else if (Float.compare(currentPressure,lastPressure) == 0) {
            forecast = "More of the same";
        } else {
            forecast = "Watch out for cooler, rainy weather";
        }
        LOGGER.info("Forecast: {}", forecast);
    }
}