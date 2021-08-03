package fuzzy.operators.join.projections;

public interface IFuzzyJoinProjection<T, K, P> {
    T create(K object, P joined);
}
