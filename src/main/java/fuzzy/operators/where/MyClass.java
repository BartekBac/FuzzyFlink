package fuzzy.operators.where;

import fuzzy.dtos.Person;

import java.util.function.Function;

public class MyClass implements MyFilter<Person> {
    @Override
    public boolean filter(Person object) {
        return false;
    }

    @Override
    public Boolean apply(Person person) {
        return person.age == 26;
    }

    @Override
    public <V> Function<V, Boolean> compose(Function<? super V, ? extends Person> before) {
        return MyFilter.super.compose(before);
    }

    @Override
    public <V> Function<Person, V> andThen(Function<? super Boolean, ? extends V> after) {
        return MyFilter.super.andThen(after);
    }
}
