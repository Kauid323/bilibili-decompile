package java.util.function;

public interface LongConsumer {
    void accept(long j);

    LongConsumer andThen(LongConsumer longConsumer);
}