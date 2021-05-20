package fuzzy.operators;

/*TODO: Bartłomiej K*/

import fuzzy.dtos.Person;
import fuzzy.operators.interfaces.IFuzzyProjection;
import fuzzy.operators.interfaces.IFuzzySelect;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;

public class FuzzySelect<T> implements IFuzzySelect<T> {
    @Override
    public DataStream<T> transform(DataStream<Person> input, IFuzzyProjection<T> projection) {
        MapFunction<Person, T> mapFunction = new MapFunction<Person, T>() {
            @Override
            public T map(Person value) {
                return projection.create(value);
            }
        };

        return input.map(mapFunction).returns((Class<T>) projection.getClass());
    }
}
