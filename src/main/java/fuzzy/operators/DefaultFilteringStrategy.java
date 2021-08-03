package fuzzy.operators;

import fuzzy.operators.interfaces.IFilteringStrategy;

import java.io.Serializable;

public class DefaultFilteringStrategy implements IFilteringStrategy, Serializable {
    @Override
    public boolean filter(double lowerBound, double upperBound, double membershipCoefficient, double filteredValue) {
        // lowerBound = 13
        // upperBound = 20
        // membershipCoefficient = 0.5 (0;1>
        // filteredValue = 14


        // center = 16.5
        // distanceFromCenter = 2.5
        // acceptanceArea = 16.5 - 13 = 3.5
        // resultCoefficient = 1 - (2.5 / 3.5) = 1 - (0.7142857142857143) = 0.285...
        // return true

        double center = (upperBound - lowerBound) / 2 + lowerBound;
        double distanceFromCenter = Math.abs(filteredValue - center);
        double acceptanceArea = center - lowerBound;

        if (distanceFromCenter > acceptanceArea) {
            return false;
        }

        double resultCoefficient = 1 - (distanceFromCenter / acceptanceArea);

        return resultCoefficient > membershipCoefficient;
    }
}
