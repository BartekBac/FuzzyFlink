package fuzzy.operators.join.numeric_obsolete;

public interface IJoiningStrategy {
    boolean join(double lowerBound, double upperBound, double membershipCoefficient, double valueA, double valueB);
}
