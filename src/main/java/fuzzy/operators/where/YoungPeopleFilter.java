package fuzzy.operators.where;

import fuzzy.dtos.Person;
import fuzzy.operators.where.IFuzzyFilter;

import java.io.Serializable;

public class YoungPeopleFilter implements IFuzzyFilter<Person>, Serializable {
    private double lowerBound;
    private double upperBound;
    private double membershipCoefficient;

    @Override
    public double getLowerBound() {
        return lowerBound;
    }

    @Override
    public double getUpperBound() {
        return upperBound;
    }

    @Override
    public double getMembershipCoefficient() {
        return membershipCoefficient;
    }

    @Override
    public void setLowerBound(double value) {
        lowerBound = value;
    }

    @Override
    public void setUpperBound(double value) {
        upperBound = value;
    }

    @Override
    public void setMembershipCoefficient(double value) {
        membershipCoefficient = value;
    }

    @Override
    public double getFilteredValue(Person person) {
        return person.age;
    }
}
