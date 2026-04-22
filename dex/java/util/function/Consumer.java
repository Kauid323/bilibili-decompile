package java.util.function;

public interface Consumer<T> {
    void accept(T t);

    Consumer<T> andThen(Consumer<? super T> consumer);
}