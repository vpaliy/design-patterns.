package weatherExample.data;


import weatherExample.entity.WeatherData;
import com.sun.istack.internal.NotNull;
import core.Observer;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Emitter of data
 */
public class WeatherDataProvider implements ContinuousUpdater,DataSource {

    private static final int DELAY_TIME=5000;
    private final ExecutorService executor=Executors.newSingleThreadExecutor();
    private final ConcurrentLinkedQueue<Observer<WeatherData>> observerList;
    private WeatherData updatedData;

    public WeatherDataProvider(){
        this.observerList=new ConcurrentLinkedQueue<>();
    }

    @Override
    public void update() {
        while(!observerList.isEmpty()){
            updatedData=fetchData();
            notifyObserver();
        }
    }

    @Override
    public WeatherData fetchData() {
        Random random=new Random();
        try {
            //simulate network request
            Thread.sleep(DELAY_TIME);
            return new WeatherData(random.nextInt(30),
                    random.nextInt(80),random.nextInt(100));
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        return null;
    }


    @Override
    public void disposeAll() {
        observerList.clear();
    }

    @Override
    public void notifyObserver() {
        for(Observer<WeatherData> observer:observerList){
            observer.update(updatedData);
        }
    }

    @Override
    public  void register(@NotNull Observer<WeatherData> observer) {
        observerList.add(observer);
        if(observerList.size()==1){
            executor.execute(this::update);
        }
    }

    @Override
    public void unregister(@NotNull Observer<WeatherData> observer) {
        observerList.remove(observer);
    }
}
