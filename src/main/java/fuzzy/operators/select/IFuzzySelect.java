package fuzzy.operators.select;

import fuzzy.operators.select.projections.IFuzzyProjection;
import org.apache.flink.streaming.api.datastream.DataStream;

public interface IFuzzySelect<T, K> {
    DataStream<T> transform(DataStream<K> input, IFuzzyProjection<T, K> projection);
}
