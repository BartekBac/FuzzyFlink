package fuzzy.operators.where;

import org.apache.flink.streaming.api.datastream.DataStream;

import java.util.function.Function;

public interface IFuzzyWhere<T> {
    DataStream<T> transform(DataStream<T> input, Function<T, Boolean> conditions);
}
