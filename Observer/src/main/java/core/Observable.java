package core;

import com.sun.istack.internal.NotNull;

/**
 * This interface represents an emitter of data
 * @param <T> type of data, usually a wrapper
 */
public interface Observable<T> {
    void register(@NotNull Observer<T> observer);
    void unregister(@NotNull Observer<T> observer);
    void disposeAll();
    void notifyObserver();
}
