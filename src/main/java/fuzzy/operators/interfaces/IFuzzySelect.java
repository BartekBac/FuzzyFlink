package fuzzy.operators.interfaces;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;

public interface IFuzzySelect<T, K> {
    DataStream<T> transform(DataStream<K> input, MapFunction<K, T> mapFunction);
}
