package fuzzy.operators.interfaces;

import fuzzy.operators.projections.WalkingPersonProjection;
import org.apache.flink.api.common.functions.JoinFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStream;

public interface IFuzzyJoin<T, K> {
    DataStream transform(DataStream<T> input, DataStream<K> joinStream, KeySelector<T, String> personKeySelector, KeySelector<K, String> walkVelocityKeySelector, JoinFunction joinFunction);
}
