package fuzzy.operators.join.numeric_obsolete;

public interface IJoiningStrategy {
    boolean join(double maxDistance, double membershipCoefficient, double valueFrom, double valueTo);
}
