package core;

import com.sun.istack.internal.NotNull;

import java.util.LinkedList;
import java.util.List;

public class FakeObservable implements Observable<String> {

    private List<Observer<String>> observers;
    private String data;

    public FakeObservable(@NotNull String data){
        this.observers=new LinkedList<>();
        this.data=data;
    }

    @Override
    public void notifyObserver() {
        for(Observer<String> observer:observers){
            observer.update(data);
        }
    }

    public void updateData(@NotNull String freshData){
        this.data=freshData;
        notifyObserver();
    }

    public List<Observer<String>> getObservers(){
        return observers;
    }

    @Override
    public void disposeAll() {
        observers.clear();
    }

    @Override
    public void register(@NotNull Observer<String> observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(@NotNull Observer<String> observer) {
        observers.remove(observer);
    }
}
