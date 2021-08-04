package fuzzy.operators.where;

/*TODO: Jakub */

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.streaming.api.datastream.DataStream;

import java.util.function.Function;

public class FuzzyWhere<T> implements IFuzzyWhere<T> {
    @Override
    public DataStream<T> transform(DataStream<T> input, MyFilter<T> conditions) {
        IFilteringStrategy filteringStrategy = new DefaultFilteringStrategy();
            FilterFunction<T> filterFunction = new FilterFunction<T>() {
            @Override
            public boolean filter(T object) throws Exception {
                return conditions.apply(object);
                /*return filteringStrategy.filter(
                        fuzzyFilter.getLowerBound(),
                        fuzzyFilter.getUpperBound(),
                        fuzzyFilter.getMembershipCoefficient(),
                        fuzzyFilter.getFilteredValue(object));*/
            }
        };

        return input.filter(filterFunction);
    }
}
