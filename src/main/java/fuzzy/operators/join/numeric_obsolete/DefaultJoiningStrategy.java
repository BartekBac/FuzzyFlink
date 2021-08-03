package fuzzy.operators.join.numeric_obsolete;

import java.io.Serializable;

public class DefaultJoiningStrategy implements IJoiningStrategy, Serializable {
    @Override
    public boolean join(double lowerBound, double upperBound, double membershipCoefficient, double valueA, double valueB) {
        // lowerBound = 13
        // upperBound = 20
        // membershipCoefficient = 0.5 (0;1>
        // valueA = 14
        // valueB = 15


        // center = 16.5
        // distanceBetween = 1
        // acceptanceArea = 16.5 - 13 = 3.5
        // remainingAcceptanceArea 3.5 - 1 = 2.5 (how far is the distance to the border)
        // resultCoefficient = 2.5 / 3.5 = 0.7142857142857143

        double center = (upperBound - lowerBound) / 2 + lowerBound;
        double distanceBetween = Math.abs(valueA - valueB);
        double acceptanceArea = center - lowerBound;

        double remainingAcceptanceArea = acceptanceArea - distanceBetween;

        if (remainingAcceptanceArea < 0.0) {
            return false;
        }

        double resultCoefficient = remainingAcceptanceArea / acceptanceArea;

        return resultCoefficient > membershipCoefficient;
    }
}
