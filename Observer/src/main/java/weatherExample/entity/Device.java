package weatherExample.entity;

import com.sun.istack.internal.NotNull;
import core.Observer;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Device implements Observer<WeatherData> {

    private static Logger logger=Logger.getAnonymousLogger();

    public abstract void update(@NotNull WeatherData data);
    public abstract void showWeather();

    protected void log(@NotNull WeatherData weatherData){
        String clazz=this.getClass().getSimpleName();
        String message="Temp:"+Float.toString(weatherData.getCelsiusTemperature())
                +'\n'+"Pressure:"+Float.toString(weatherData.getPressure())+
                +'\n'+"Humidity:"+Float.toString(weatherData.getHumidity())+
                +'\n';
        System.out.println(clazz+":"+message);
        System.out.println("_______________________________________________________________________");
        logger.log(Level.ALL,clazz,message);
    }
}
