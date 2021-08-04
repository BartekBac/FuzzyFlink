package fuzzy.operators.where;

import fuzzy.dtos.Person;

public class PersonAgeFilter extends AroundFilter<Person> {
    @Override
    public boolean filter(Person person) {
        return filteringStrategy.filter(lowerBound, upperBound, membershipCoefficient, person.age);
    }
}
