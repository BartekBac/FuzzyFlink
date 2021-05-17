package fuzzy.operators;

/*TODO: Bartłomiej K*/

import fuzzy.dtos.Person;
import fuzzy.operators.interfaces.IFuzzyProjection;
import fuzzy.operators.interfaces.IFuzzySelect;
import fuzzy.variables.AlphabeticCharacter;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.streaming.api.datastream.DataStream;

public class FuzzySelect<T> implements IFuzzySelect<T> {
    @Override
    public DataStream<T> transform(DataStream<Person> input, IFuzzyProjection<T> output /*MapFunction<K, T> mapFunction*/) {
        MapFunction<Person, T> mapFunction = new MapFunction<Person, T>() {
            @Override
            public T map(Person value) {
                return output.create(value);
            }
        };

        return input.map(mapFunction);
    }
}
