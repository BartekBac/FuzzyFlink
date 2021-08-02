package fuzzy.operators.interfaces;

import fuzzy.dtos.Person;
import org.apache.flink.streaming.api.datastream.DataStream;

public interface IFuzzySelect<T, K> {
    DataStream<T> transform(DataStream<K> input, IFuzzyProjection<T, K> projection);
}
