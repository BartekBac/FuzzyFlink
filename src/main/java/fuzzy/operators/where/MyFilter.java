package fuzzy.operators.where;

import java.io.Serializable;
import java.util.function.Function;

public interface MyFilter<T> extends Function<T, Boolean>, Serializable {
    boolean filter(T object);
}
