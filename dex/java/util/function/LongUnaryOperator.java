package java.util.function;

public interface LongUnaryOperator {
    LongUnaryOperator andThen(LongUnaryOperator longUnaryOperator);

    long applyAsLong(long j);

    LongUnaryOperator compose(LongUnaryOperator longUnaryOperator);
}