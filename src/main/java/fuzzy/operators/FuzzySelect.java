package fuzzy.operators;

/*TODO: Bartłomiej K*/

import fuzzy.operators.interfaces.IFuzzyProjection;
import fuzzy.operators.interfaces.IFuzzySelect;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;

public class FuzzySelect<T, K> implements IFuzzySelect<T, K> {
    @Override
    public DataStream<T> transform(DataStream<K> input, IFuzzyProjection<T, K> projection) {
        MapFunction<K, T> mapFunction = new MapFunction<K, T>() {
            @Override
            public T map(K object) {
                return projection.create(object);
            }
        };

        return input.map(mapFunction).returns((Class<T>) projection.getClass());
    }
}
