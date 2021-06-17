package fuzzy.operators.projections;

import fuzzy.dtos.Person;
import fuzzy.dtos.WalkVelocity;
import fuzzy.operators.interfaces.IFuzzyProjection;
import fuzzy.variables.LinguisticAge;

import java.io.Serializable;

public class WalkingPersonProjection implements Serializable {

    public String name;
    public String description;
    public int age;

    public WalkingPersonProjection() {
        this.name = "";
        this.description = "";
        this.age = 0;
    }

    public WalkingPersonProjection(Person person, WalkVelocity walkVelocity) {
        this.name = person.name;
        this.age = person.age;
        this.description = walkVelocity.description;
    }

    public WalkingPersonProjection create(Person person, WalkVelocity walkVelocity) {
        this.name = person.name;
        this.age = person.age;
        this.description = walkVelocity.description;
        return this;
    }

    @Override
    public String toString() {
        return "WalkingPersonProjection{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", age=" + age +
                '}';
    }
}
