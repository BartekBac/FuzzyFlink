package fuzzy.operators.interfaces;

import fuzzy.dtos.Person;

public interface IFuzzyFilter {
    double getLowerBound();
    double getUpperBound();
    double getMembershipCoefficient();

    void setLowerBound(double value);
    void setUpperBound(double value);
    void setMembershipCoefficient(double value);

    double getFilteredValue(Person person);
}
