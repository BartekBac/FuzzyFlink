package fuzzy.operators.join.numeric_obsolete2;

import fuzzy.operators.join.numeric_obsolete.DefaultJoiningStrategy;
import fuzzy.operators.join.numeric_obsolete.IJoiningStrategy;

import java.io.Serializable;

public class NumericJoinSelector implements Serializable {
    private IJoiningStrategy joiningStrategy = new DefaultJoiningStrategy();

    private static Double firstValue = null;
    private double membershipCoefficient = 1.0;
    private double maxDistance = 0.0;

    public synchronized void setMemberCoefficient(double value) {
        this.membershipCoefficient = value;
    }

    public synchronized void setMaxDistance(double value) {
        this.maxDistance = value;
    }

    public synchronized boolean setFirst(double value) {
        this.firstValue = value;
        System.out.println("First set to: " + this.firstValue.doubleValue() + ", " + this.hashCode());
        return true;
    }

    public synchronized boolean checkSecond(double value) {
        boolean joinable = false;
        if(firstValue != null) {
            joinable = joiningStrategy.join(maxDistance, membershipCoefficient, firstValue, value);
        } else {
            System.out.println("First value not present, " + this.hashCode());
        }
        firstValue = null; // reset for further processing
        return joinable;
    }

}
