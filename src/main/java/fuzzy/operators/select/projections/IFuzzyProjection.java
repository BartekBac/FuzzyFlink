package fuzzy.operators.select.projections;

import fuzzy.dtos.Person;

public interface IFuzzyProjection<T, K> {
    T create(K object);
}
