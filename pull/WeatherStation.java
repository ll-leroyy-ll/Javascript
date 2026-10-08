package pull;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        new CurrentConditionsDisplay(weatherData);
        new StatisticsDisplay(weatherData);
        ForecastDisplay forecast = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        System.out.println();
        weatherData.setMeasurements(82, 70, 29.2f);

        System.out.println("\n-- forecast removed --");
        weatherData.removeObserver(forecast);
        weatherData.setMeasurements(78, 90, 29.2f);

        System.out.println("\n-- HeatIndexDisplay added --");
        new HeatIndexDisplay(weatherData);
        weatherData.setMeasurements(80, 65, 30.4f);
    }
}
