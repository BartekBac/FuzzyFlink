package fuzzy.operators.projections;

import fuzzy.dtos.Person;
import fuzzy.operators.interfaces.IFuzzyProjection;
import fuzzy.variables.LinguisticAge;

import java.io.Serializable;

public class PersonProjection implements IFuzzyProjection<PersonProjection, Person>, Serializable {

    public String name;
    public String linguisticAge;

    public PersonProjection() {
        this.name = "";
        this.linguisticAge = "";
    }

    @Override
    public PersonProjection create(Person person) {
        this.name = person.name;
        this.linguisticAge = new LinguisticAge(person.age).linguisticValue;
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
