package fuzzy.operators.join.joinDefinitions;

import org.apache.flink.api.common.functions.JoinFunction;

public interface IFuzzyJoinDefinition<T, K, P> {
    JoinFunction<K, P, T> getFunction();
    /*public JoinFunction<K, P, WalkingPersonProjection> getFunction(IFuzzyJoinProjection<T, K, P> projection) {
        return new JoinFunction<K, P, WalkingPersonProjection>(){
            @Override
            public WalkingPersonProjection join(K object, P joined) {
                //return projection.create(object,  joined);
                return  new WalkingPersonProjection((Person) object, (WalkVelocity) joined);
            }
        };
    }*/
}
