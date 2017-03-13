package WeatherExample;

import WeatherExample.data.WeatherDataProvider;
import WeatherExample.entity.SmartPhone;
import WeatherExample.entity.SmartWatch;
import WeatherExample.entity.Tablet;

public class WeatherApp {
    public static void main(String[] args){
        WeatherDataProvider provider=new WeatherDataProvider();
        provider.register(new SmartPhone());
        provider.register(new Tablet());
        provider.register(new SmartWatch());
    }
}
