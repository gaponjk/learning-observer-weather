package com.haponenka.app.display.impl;

import com.haponenka.app.display.DisplayElement;
import com.haponenka.app.observer.Observer;
import com.haponenka.app.subject.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    private final static Logger LOGGER= LogManager.getLogger(CurrentConditionsDisplay.class);

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        LOGGER.info("Current conditions: {}F degrees and {}% humidity",temperature,humidity );
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature= temperature;
        this.humidity=humidity;
        display();
    }
}
