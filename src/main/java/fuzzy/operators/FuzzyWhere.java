package fuzzy.operators;

/*TODO: Jakub */

import fuzzy.dtos.Person;
import fuzzy.operators.interfaces.IFilteringStrategy;
import fuzzy.operators.interfaces.IFuzzyFilter;
import fuzzy.operators.interfaces.IFuzzyWhere;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.streaming.api.datastream.DataStream;

public class FuzzyWhere implements IFuzzyWhere {
    @Override
    public DataStream transform(DataStream input, IFuzzyFilter fuzzyFilter) {
        IFilteringStrategy filteringStrategy = new DefaultFilteringStrategy();
            FilterFunction<Person> filterFunction = new FilterFunction<Person>() {
            @Override
            public boolean filter(Person person) throws Exception {
                return filteringStrategy.filter(
                        fuzzyFilter.getLowerBound(),
                        fuzzyFilter.getUpperBound(),
                        fuzzyFilter.getMembershipCoefficient(),
                        fuzzyFilter.getFilteredValue(person));
            }
        };

        return input.filter(filterFunction);
    }
}
