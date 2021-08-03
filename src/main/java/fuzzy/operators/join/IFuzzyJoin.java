package fuzzy.operators.join;

import org.apache.flink.api.common.functions.JoinFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStream;

public interface IFuzzyJoin<T, K> {
    DataStream transform(DataStream<T> input, DataStream<K> joinStream, KeySelector<T, String> objectKeySelector, KeySelector<K, String> joinedKeySelector, JoinFunction joinFunction);
}
