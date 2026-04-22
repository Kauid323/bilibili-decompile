package java.util.function;

public interface DoublePredicate {
    DoublePredicate and(DoublePredicate doublePredicate);

    DoublePredicate negate();

    DoublePredicate or(DoublePredicate doublePredicate);

    boolean test(double d);
}