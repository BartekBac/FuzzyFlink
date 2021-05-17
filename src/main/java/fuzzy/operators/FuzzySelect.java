package fuzzy.operators;

/*TODO: Bartłomiej K*/

import fuzzy.operators.interfaces.IFuzzySelect;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;

public class FuzzySelect<T, K> implements IFuzzySelect<T, K> {
    @Override
    public DataStream<T> transform(DataStream<K> input, MapFunction<K, T> mapFunction) {
        return input.map(mapFunction);
    }
}
