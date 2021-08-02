package fuzzy.operators;

/*TODO: Bartłomiej C*/

import fuzzy.dtos.Person;
import fuzzy.dtos.WalkVelocity;
import fuzzy.operators.interfaces.IFilteringStrategy;
import fuzzy.operators.interfaces.IFuzzyJoinProjection;
import fuzzy.operators.interfaces.IJoiningStrategy;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.JoinFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.windowing.assigners.EventTimeSessionWindows;
import org.apache.flink.streaming.api.windowing.time.Time;

public class FuzzyNumericJoin<T> {
    public DataStream<T> transform(DataStream<Person> input, DataStream<WalkVelocity> joinStream, IFuzzyJoinProjection<T, Person, WalkVelocity> projection) {

        /*
        Podejście pierwsze:
           Nie da się po użyciu funkcji apply (której wymaga join) rzutować wyniku na generyczną klasę
        DataStream<T> joined = input.join(joinStream)
                .where(new KeySelector<Person, Object>() {
                    @Override
                    public Object getKey(Person person) throws Exception {
                        return true;
                    }
                })
                .equalTo(new KeySelector<WalkVelocity, Object>() {
                    @Override
                    public Object getKey(WalkVelocity walkVelocity) throws Exception {
                        return true;
                    }
                })
                .window(EventTimeSessionWindows.withGap(Time.milliseconds(10000)))
                .apply(new JoinFunction<Person, WalkVelocity, T>(){
                    @Override
                    public T join(Person person, WalkVelocity walkVelocity) {
                        return projection.create(person, walkVelocity);
                    }
                });

                */

        /*
        Podejście drugie:
            Nie da się do mapy przekazać równolegle dwóch różnych klas, do tego przewidzany został join
        MapFunction<Person, T> mapFunction1 = new MapFunction<Person, T>() {
            @Override
            public T map(Person person) {
                MapFunction<WalkVelocity, T> mapFunction2 = new MapFunction<WalkVelocity, T>() {
                    @Override
                    public T map(WalkVelocity walkVelocity) {

                        return projection.create(person, walkVelocity);
                    }
                };
                input.map(mapFunction2).returns((Class<T>) projection.getClass());
                return projection.create(person, walk);
            }
        };*/

        return null;
    }
}
