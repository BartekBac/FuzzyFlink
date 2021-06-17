package fuzzy.operators;

/*TODO: Bartłomiej C*/

import fuzzy.dtos.Person;
import fuzzy.dtos.WalkVelocity;
import fuzzy.operators.projections.WalkingPersonProjection;
import org.apache.flink.streaming.api.windowing.assigners.EventTimeSessionWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.common.functions.JoinFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;

public class FuzzyJoin {
    public DataStream transform(DataStream<Person> input, DataStream<WalkVelocity> joinStream, KeySelector<Person, Integer> personKeySelector, KeySelector<WalkVelocity, Integer> walkVelocityKeySelector) {

        return input.join(joinStream)
                .where(personKeySelector)
                .equalTo(walkVelocityKeySelector)
                .window(EventTimeSessionWindows.withGap(Time.milliseconds(10000)))
                .apply(new JoinFunction<Person, WalkVelocity, WalkingPersonProjection>(){
                    @Override
                    public WalkingPersonProjection join(Person person, WalkVelocity walkVelocity) {
                        return new WalkingPersonProjection(person, walkVelocity);
                    }
                });
    }
}
