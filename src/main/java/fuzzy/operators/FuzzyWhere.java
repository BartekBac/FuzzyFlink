package fuzzy.operators;

/*TODO: Jakub */

import fuzzy.operators.interfaces.IFilteringStrategy;
import fuzzy.operators.interfaces.IFuzzyFilter;
import fuzzy.operators.interfaces.IFuzzyWhere;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.streaming.api.datastream.DataStream;

public class FuzzyWhere<T> implements IFuzzyWhere<T> {
    @Override
    public DataStream<T> transform(DataStream<T> input, IFuzzyFilter<T> fuzzyFilter) {
        IFilteringStrategy filteringStrategy = new DefaultFilteringStrategy();
            FilterFunction<T> filterFunction = new FilterFunction<T>() {
            @Override
            public boolean filter(T object) throws Exception {
                return filteringStrategy.filter(
                        fuzzyFilter.getLowerBound(),
                        fuzzyFilter.getUpperBound(),
                        fuzzyFilter.getMembershipCoefficient(),
                        fuzzyFilter.getFilteredValue(object));
            }
        };

        return input.filter(filterFunction);
    }
}
