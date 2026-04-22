package java.util.function;

public interface IntUnaryOperator {
    IntUnaryOperator andThen(IntUnaryOperator intUnaryOperator);

    int applyAsInt(int i);

    IntUnaryOperator compose(IntUnaryOperator intUnaryOperator);
}