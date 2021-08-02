package fuzzy.operators;

/* TODO Tomasz */

import fuzzy.dtos.Person;
import fuzzy.dtos.WalkVelocity;
import fuzzy.operators.interfaces.IFuzzyGroupBy;
import fuzzy.operators.projections.WalkingPersonProjection;
import org.apache.flink.api.common.functions.JoinFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.windowing.assigners.EventTimeSessionWindows;
import org.apache.flink.streaming.api.windowing.time.Time;

public class FuzzyGroupBy<T, K> implements IFuzzyGroupBy<T, K> {
    public DataStream transform(DataStream<T> input, KeySelector<T, K> keySelector) {

        return input.keyBy(keySelector);
    }
}
