package fuzzy.operators.interfaces;

public interface IFilteringStrategy {
    boolean filter(double lowerBound, double upperBound, double membershipCoefficient, double filteredValue);
}
