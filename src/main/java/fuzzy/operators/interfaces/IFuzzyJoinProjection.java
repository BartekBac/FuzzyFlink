package fuzzy.operators.interfaces;

import fuzzy.dtos.Person;
import fuzzy.dtos.WalkVelocity;

public interface IFuzzyJoinProjection<T> {
    T create(Person person, WalkVelocity walkVelocity);
}
