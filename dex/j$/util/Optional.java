package j$.util;

import j$.util.stream.Stream;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class Optional<T> {
    private static final Optional<?> EMPTY = new Optional<>();
    private final T value;

    /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<T> */
    private Optional() {
        this.value = null;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<T> */
    public static <T> Optional<T> empty() {
        return (Optional<T>) EMPTY;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<T> */
    private Optional(T value) {
        this.value = (T) Objects.requireNonNull(value);
    }

    public static <T> Optional<T> of(T value) {
        return new Optional<>(value);
    }

    public static <T> Optional<T> ofNullable(T value) {
        return value == null ? empty() : of(value);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<T> */
    public T get() {
        if (this.value == null) {
            throw new NoSuchElementException("No value present");
        }
        return this.value;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<T> */
    public boolean isPresent() {
        return this.value != null;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<T> */
    public boolean isEmpty() {
        return this.value == null;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<T> */
    public void ifPresent(Consumer<? super T> action) {
        if (this.value != null) {
            action.accept((T) this.value);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<T> */
    public void ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction) {
        if (this.value != null) {
            action.accept((T) this.value);
        } else {
            emptyAction.run();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<T> */
    public Optional<T> filter(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        if (isPresent()) {
            return predicate.test((T) this.value) ? this : empty();
        }
        return this;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<T> */
    public <U> Optional<U> map(Function<? super T, ? extends U> mapper) {
        Objects.requireNonNull(mapper);
        if (!isPresent()) {
            return empty();
        }
        return ofNullable(mapper.apply((T) this.value));
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<T> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<U> */
    public <U> Optional<U> flatMap(Function<? super T, ? extends Optional<? extends U>> function) {
        Objects.requireNonNull(function);
        if (!isPresent()) {
            return empty();
        }
        return (Optional) Objects.requireNonNull(function.apply((T) this.value));
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<T> */
    public Optional<T> or(Supplier<? extends Optional<? extends T>> supplier) {
        Objects.requireNonNull(supplier);
        if (isPresent()) {
            return this;
        }
        return (Optional) Objects.requireNonNull(supplier.get());
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<T> */
    public Stream<T> stream() {
        if (!isPresent()) {
            return Stream.CC.empty();
        }
        return Stream.CC.of(this.value);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<T> */
    public T orElse(T other) {
        return this.value != null ? this.value : other;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<T> */
    public T orElseGet(Supplier<? extends T> supplier) {
        return this.value != null ? this.value : supplier.get();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<T> */
    public T orElseThrow() {
        if (this.value == null) {
            throw new NoSuchElementException("No value present");
        }
        return this.value;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<T> */
    public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) {
        if (this.value != null) {
            return this.value;
        }
        throw exceptionSupplier.get();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<?> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<T> */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Optional)) {
            return false;
        }
        return Objects.equals(this.value, ((Optional) obj).value);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<T> */
    public int hashCode() {
        return Objects.hashCode(this.value);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<T> */
    public String toString() {
        return this.value != null ? String.format("Optional[%s]", this.value) : "Optional.empty";
    }
}