package fuzzy.operators.where.around;

import java.io.Serializable;

public class Around implements Serializable {
    private IComputingMethod filteringStrategy;

    public Around() {
        this(new TriangleMethod());
    }

    public Around(IComputingMethod filteringStrategy)  {
        this.filteringStrategy = filteringStrategy;
    }

    public boolean filter(double value) {
        return filteringStrategy.filter(0.0, 1.0, 0.5, value);
    }

    public boolean filter(double value, double membershipCoefficient) {
        return filteringStrategy.filter(0.0, 1.0, membershipCoefficient, value);
    }

    public boolean filter(double value, double membershipCoefficient, double lowerBound, double upperBound) {
        return filteringStrategy.filter(lowerBound, upperBound, membershipCoefficient, value);
    }
}
