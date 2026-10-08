package pull;

public class HeatIndexDisplay implements Observer, DisplayElement {
    private float heatIndex = 0.0f;
    private WeatherData weatherData;

    public HeatIndexDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update() {
        float t = weatherData.getTemperature();
        float rh = weatherData.getHumidity();
        this.heatIndex = computeHeatIndex(t, rh);
        display();
    }

    private float computeHeatIndex(float t, float rh) {
        return (float) (
            (16.923 + (1.85212 * Math.pow(10, -1) * t))
            + (5.37941 * rh)
            - (1.00254 * Math.pow(10, -1) * t * rh)
            + (9.41695 * Math.pow(10, -3) * (t * t))
            + (7.28898 * Math.pow(10, -3) * (rh * rh))
            + (3.45372 * Math.pow(10, -4) * (t * t * rh))
            - (8.14971 * Math.pow(10, -4) * (t * rh * rh))
            + (1.02102 * Math.pow(10, -5) * (t * t * (rh * rh)))
            - (3.8646 * Math.pow(10, -5) * (t * t * t))
            + (2.91583 * Math.pow(10, -5) * (rh * rh * rh))
            + (1.42721 * Math.pow(10, -6) * (t * t * t * rh))
            + (1.97483 * Math.pow(10, -7) * (t * rh * rh * rh))
            - (2.18429 * Math.pow(10, -8) * (t * t * t * rh * rh))
            + (8.43296 * Math.pow(10, -10) * (t * t * (rh * rh * rh)))
            - (4.81975 * Math.pow(10, -11) * (t * t * t * (rh * rh * rh))));
    }

    public void display() {
        System.out.println("Heat index is " + heatIndex);
    }
}