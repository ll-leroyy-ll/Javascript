import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private float temperature, humidity, pressure;

    public void registerObserver(Observer o) { observers.add(o); }
    public void removeObserver(Observer o)   { observers.remove(o); }

    public void notifyObservers() {
        for (Observer o : observers)
            o.update(temperature, humidity, pressure);
    }

    public void setMeasurements(float t, float h, float p) {
        temperature = t; humidity = h; pressure = p;
        notifyObservers();   // fire the update on every change
    }

    public float getTemperature() { return temperature; }
    public float getHumidity()    { return humidity; }
    public float getPressure()    { return pressure; }
}