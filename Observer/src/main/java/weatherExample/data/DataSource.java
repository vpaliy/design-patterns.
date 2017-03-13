package weatherExample.data;


import weatherExample.entity.WeatherData;
import com.sun.istack.internal.NotNull;
import core.Observable;
import core.Observer;

public interface  DataSource extends Observable<WeatherData> {
    WeatherData fetchData();
    void disposeAll();
    void register(@NotNull Observer<WeatherData> observer);
    void unregister(@NotNull Observer<WeatherData> observer);
    void notifyObserver();
}
