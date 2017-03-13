package weatherExample;

import weatherExample.data.WeatherDataProvider;
import weatherExample.entity.SmartPhone;
import weatherExample.entity.SmartWatch;
import weatherExample.entity.Tablet;

public class WeatherApp {
    public static void main(String[] args){
        WeatherDataProvider provider=new WeatherDataProvider();
        provider.register(new SmartPhone());
        provider.register(new Tablet());
        provider.register(new SmartWatch());
    }
}
