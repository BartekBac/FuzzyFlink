package fuzzy.operators.interfaces;

import fuzzy.dtos.Person;

public interface IFuzzyProjection<T> {
    T create(Person person);
}
