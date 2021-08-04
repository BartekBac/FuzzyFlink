package fuzzy.operators.join.numeric_obsolete2;

import org.apache.flink.api.common.functions.JoinFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStream;

public interface IFuzzyNumericJoin<T, K> {
    DataStream transform(DataStream<T> input, DataStream<K> joinStream, KeySelector<T, Boolean> objectKeySelector, KeySelector<K, Boolean> joinedKeySelector, JoinFunction joinFunction);
}

/*
* usage:
		IFuzzyNumericJoin<Person, WalkVelocity> fuzzyNumericJoin = new FuzzyNumericJoin();
		NumericJoinSelector numericJoinSelector = new NumericJoinSelector();
		numericJoinSelector.setMaxDistance(3);
		numericJoinSelector.setMemberCoefficient(0.5);
		DataStream<WalkingPersonProjection> outJoinDataStream = fuzzyNumericJoin.transform(inputDataStream, inputWalkVelocityDataStream, person -> numericJoinSelector.checkSecond(person.age), walkVelocity -> numericJoinSelector.setFirst(walkVelocity.age), joinDefinition.getFunction());
* */