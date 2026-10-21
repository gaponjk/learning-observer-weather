package com.haponenka.app.subject;

import com.haponenka.app.observer.Observer;

public interface Subject {
  void registerObserver(Observer observer);

  void removeObserver(Observer observer);

  void notifyObservers();
}
