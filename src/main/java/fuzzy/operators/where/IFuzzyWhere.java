package fuzzy.operators.where;

import org.apache.flink.streaming.api.datastream.DataStream;

public interface IFuzzyWhere<T> {
    DataStream<T> transform(DataStream<T> input, IFuzzyFilter<T> filter);
}
