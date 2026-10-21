package com.haponenka.app.display.impl;

import com.haponenka.app.display.DisplayElement;
import com.haponenka.app.observer.Observer;
import com.haponenka.app.subject.impl.WeatherData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private final WeatherData weatherData;

    private final static Logger LOGGER= LogManager.getLogger(CurrentConditionsDisplay.class);

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public void display() {
        LOGGER.info("Current conditions: {}F degrees and {}% humidity",temperature,humidity );
    }

    @Override
    public void update() {
        this.temperature= weatherData.getTemperature();
        this.humidity=weatherData.getHumidity();
        display();
    }
}
