package java.util.function;

public interface DoubleConsumer {
    void accept(double d);

    DoubleConsumer andThen(DoubleConsumer doubleConsumer);
}