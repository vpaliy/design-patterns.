package core;

import com.sun.istack.internal.NotNull;

/**
 * @param <T> the data that will be received (entities, wrappers, etc)
 */

public interface Observer<T> {
    void update(@NotNull T data);
}
