package fuzzy.operators.interfaces;

import fuzzy.dtos.Person;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStream;

public interface IFuzzyGroupBy<T, K> {
    DataStream<T> transform(DataStream<T> input, KeySelector<T, K> personKeySelector);
}