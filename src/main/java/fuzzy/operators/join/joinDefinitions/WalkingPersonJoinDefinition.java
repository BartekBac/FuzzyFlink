package fuzzy.operators.join.joinDefinitions;

import fuzzy.dtos.Person;
import fuzzy.dtos.WalkVelocity;
import fuzzy.operators.join.projections.WalkingPersonProjection;
import org.apache.flink.api.common.functions.JoinFunction;

public class WalkingPersonJoinDefinition implements IFuzzyJoinDefinition<WalkingPersonProjection, Person, WalkVelocity> {
    @Override
    public JoinFunction<Person, WalkVelocity, WalkingPersonProjection> getFunction() {
        return new JoinFunction<Person, WalkVelocity, WalkingPersonProjection>() {
            @Override
            public WalkingPersonProjection join(Person object, WalkVelocity joined) {
                return new WalkingPersonProjection(object, joined);
            }
        };
    }
}
