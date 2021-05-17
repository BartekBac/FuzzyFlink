package fuzzy.operators.interfaces;

import fuzzy.dtos.Person;
import org.apache.flink.streaming.api.datastream.DataStream;

public interface IFuzzySelect<T> {
    DataStream<T> transform(DataStream<Person> input, IFuzzyProjection<T> output);
}
