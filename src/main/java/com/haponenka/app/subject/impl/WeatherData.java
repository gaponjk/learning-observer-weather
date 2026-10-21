package com.haponenka.app.subject.impl;

import com.haponenka.app.observer.Observer;
import com.haponenka.app.subject.Subject;
import java.util.ArrayList;

public class WeatherData implements Subject {
  private final ArrayList<Observer> observers = new ArrayList<>();
  private float temperature;
  private float humidity;
  private float pressure;

  public WeatherData() {}

  @Override
  public void registerObserver(Observer observer) {
    this.observers.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    this.observers.remove(observer);
  }

  @Override
  public void notifyObservers() {
    observers.forEach(Observer::update);
  }

  public void measurementsChanged() {
    notifyObservers();
  }

  public void setMeasurements(float temperature, float humidity, float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementsChanged();
  }

  public float getTemperature() {
    return temperature;
  }

  public float getHumidity() {
    return humidity;
  }

  public float getPressure() {
    return pressure;
  }
}
