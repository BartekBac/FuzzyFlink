package fuzzy.operators.join;

/*TODO: Bartłomiej C*/

import org.apache.flink.streaming.api.windowing.assigners.EventTimeSessionWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.common.functions.JoinFunction;
import org.apache.flink.streaming.api.datastream.DataStream;

public class FuzzyJoin<T, K> implements IFuzzyJoin<T, K> {
    public DataStream transform(DataStream<T> input, DataStream<K> joinStream, KeySelector<T, String> objectKeySelector, KeySelector<K, String> joinedKeySelector, JoinFunction joinFunction) {

        return input.join(joinStream)
                .where(objectKeySelector)
                .equalTo(joinedKeySelector)
                .window(EventTimeSessionWindows.withGap(Time.milliseconds(10000)))
                .apply(joinFunction);
        // Nie da się wprowadzić generycznego podejścia bo po funkcji apply nie da się wykorzytać funkcji returns, która umożliwiłaby zrzutowanie wyniku do generycznej klasy
        // Pojawia się błąd:
        //   Exception in thread "main" org.apache.flink.api.common.functions.InvalidTypesException: Type of TypeVariable 'T' in 'class fuzzy.operators.join.numeric.FuzzyNumericJoin' could not be determined.
        //   This is most likely a type erasure problem. The type extraction currently supports types with generic variables only in cases where all variables in the return type
        //   can be deduced from the input type(s). Otherwise the type has to be specified explicitly using type information.
    }
}
