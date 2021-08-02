package fuzzy.operators.interfaces;

import fuzzy.dtos.Person;
import fuzzy.dtos.WalkVelocity;
import fuzzy.operators.projections.WalkingPersonProjection;
import org.apache.flink.api.common.functions.JoinFunction;

public interface IFuzzyJoinProjection<T, K, P> {
    T create(K object, P joined);
}
