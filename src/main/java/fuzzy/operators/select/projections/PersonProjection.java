package fuzzy.operators.select.projections;

import fuzzy.dtos.Person;
import fuzzy.variables.LinguisticAge;

public class PersonProjection implements IFuzzyProjection<PersonProjection, Person> {

    public String name;
    public String linguisticAge;

    public PersonProjection() {
        this.name = "";
        this.linguisticAge = "";
    }

    @Override
    public PersonProjection create(Person person) {
        this.name = person.name;
        this.linguisticAge = new LinguisticAge(person.age).linguisticValue();
        return this;
    }

    @Override
    public String toString() {
        return "PersonProjection{" +
                "name='" + name + '\'' +
                ", linguisticAge='" + linguisticAge + '\'' +
                '}';
    }
}
