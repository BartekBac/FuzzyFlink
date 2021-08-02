package fuzzy.operators.interfaces;

import fuzzy.dtos.Person;
import org.apache.flink.streaming.api.datastream.DataStream;

public interface IFuzzyWhere<T> {
    DataStream<T> transform(DataStream<T> input, IFuzzyFilter<T> filter);
}
