package fuzzy.operators.where.around;

public interface IComputingMethod {
    boolean filter(double lowerBound, double upperBound, double membershipCoefficient, double filteredValue);
}
