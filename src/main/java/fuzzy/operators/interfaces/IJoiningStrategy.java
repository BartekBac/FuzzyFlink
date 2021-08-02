package fuzzy.operators.interfaces;

public interface IJoiningStrategy {
    boolean join(double lowerBound, double upperBound, double membershipCoefficient, double valueA, double valueB);
}
