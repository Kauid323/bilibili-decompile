package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public final class DesugarStream {
    private DesugarStream() {
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<T> */
    public static <T> Stream<T> iterate(final T seed, final Predicate<? super T> hasNext, final UnaryOperator<T> next) {
        Objects.requireNonNull(next);
        Objects.requireNonNull(hasNext);
        return StreamSupport.stream(new Spliterators.AbstractSpliterator<T>(Long.MAX_VALUE, 1040) { // from class: j$.util.stream.DesugarStream.1
            boolean finished;
            T prev;
            boolean started;

            @Override // j$.util.Spliterator
            public boolean tryAdvance(Consumer<? super T> action) {
                T t;
                Objects.requireNonNull(action);
                if (this.finished) {
                    return false;
                }
                if (this.started) {
                    t = next.apply(this.prev);
                } else {
                    t = (T) seed;
                    this.started = true;
                }
                if (!hasNext.test(t)) {
                    this.prev = null;
                    this.finished = true;
                    return false;
                }
                this.prev = t;
                action.accept(t);
                return true;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // j$.util.Spliterators.AbstractSpliterator, j$.util.Spliterator
            public void forEachRemaining(Consumer<? super T> action) {
                Objects.requireNonNull(action);
                if (this.finished) {
                    return;
                }
                this.finished = true;
                Object apply = this.started ? next.apply(this.prev) : seed;
                this.prev = null;
                while (hasNext.test(apply)) {
                    action.accept(apply);
                    apply = next.apply(apply);
                }
            }
        }, false);
    }
}