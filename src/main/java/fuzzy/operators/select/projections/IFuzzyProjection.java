package fuzzy.operators.select.projections;

import java.io.Serializable;

public interface IFuzzyProjection<T, K> extends Serializable {
    T create(K object);
}
