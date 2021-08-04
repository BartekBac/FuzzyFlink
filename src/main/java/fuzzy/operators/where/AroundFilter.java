package fuzzy.operators.where;

import fuzzy.dtos.Person;

import java.io.Serializable;

public abstract class AroundFilter<T> implements Serializable {
    protected IFilteringStrategy filteringStrategy = new DefaultFilteringStrategy();
    protected double lowerBound;
    protected double upperBound;
    protected double membershipCoefficient;

    public void setLowerBound(double value) {
        lowerBound = value;
    }

    public void setUpperBound(double value) {
        upperBound = value;
    }

    public void setMembershipCoefficient(double value) {
        membershipCoefficient = value;
    }

    public abstract boolean filter(T object);
}
