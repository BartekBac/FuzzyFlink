package fuzzy.operators.join.numeric_obsolete;

import java.io.Serializable;

public class DefaultJoiningStrategy implements IJoiningStrategy, Serializable {
    @Override
    public boolean join(double maxDistance, double membershipCoefficient, double valueFrom, double valueTo) {
        // maxDistance = 3.5
        // membershipCoefficient = 0.5 (0;1>
        // valueA = 14
        // valueB = 15

        // distanceBetween = 1
        // resultCoefficient = 1 - (1 / 3.5) = 1 - (0.285...) = 0.714...
        // return true

        double distanceBetween = Math.abs(valueTo - valueFrom);

        if (distanceBetween > maxDistance) {
            return false;
        }

        double resultCoefficient = 1 - (distanceBetween / maxDistance);

        return resultCoefficient > membershipCoefficient;
    }
}
