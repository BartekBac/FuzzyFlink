package fuzzy.operators.groupby;

/* TODO Tomasz */

import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStream;

public class FuzzyGroupBy<T, K> implements IFuzzyGroupBy<T, K> {
    public DataStream transform(DataStream<T> input, KeySelector<T, K> objectKeySelector) {

        return input.keyBy(objectKeySelector);
    }
}
