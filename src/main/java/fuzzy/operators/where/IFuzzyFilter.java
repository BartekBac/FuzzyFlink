package fuzzy.operators.where;

import java.io.Serializable;
import java.util.function.Function;

public interface IFuzzyFilter<T> extends Function<T, Boolean>, Serializable {}
