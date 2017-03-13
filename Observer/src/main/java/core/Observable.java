package core;

import com.sun.istack.internal.NotNull;

/**
 *
 * @param <T>
 */
public interface Observable<T> {
    void register(@NotNull Observer<T> observer);
    void unregister(@NotNull Observer<T> observer);
    void disposeAll();
    void notifyObserver();
}
