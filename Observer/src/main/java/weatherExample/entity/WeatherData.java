package weatherExample.entity;

/*
 * Just a data wrapper
 */
public class WeatherData {

    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(int temperature, float humidity, float pressure){
        this.temperature=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
    }

    public float getCelsiusTemperature(){
        return temperature;
    }

    public float getFahrenheitTemperature(){
        return temperature*1.8f+35;
    }

    public float getHumidity(){
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

}
