package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.Spliterators;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;

public final class DesugarIntStream {
    private DesugarIntStream() {
    }

    public static IntStream iterate(final int seed, final IntPredicate hasNext, final IntUnaryOperator next) {
        Objects.requireNonNull(next);
        Objects.requireNonNull(hasNext);
        Spliterator.OfInt spliterator = new Spliterators.AbstractIntSpliterator(Long.MAX_VALUE, 1296) { // from class: j$.util.stream.DesugarIntStream.1
            boolean finished;
            int prev;
            boolean started;

            @Override // j$.util.Spliterators.AbstractIntSpliterator, j$.util.Spliterator.OfPrimitive
            public boolean tryAdvance(IntConsumer action) {
                int t;
                Objects.requireNonNull(action);
                if (this.finished) {
                    return false;
                }
                if (this.started) {
                    t = next.applyAsInt(this.prev);
                } else {
                    t = seed;
                    this.started = true;
                }
                if (!hasNext.test(t)) {
                    this.finished = true;
                    return false;
                }
                this.prev = t;
                action.accept(t);
                return true;
            }

            @Override // j$.util.Spliterators.AbstractIntSpliterator, j$.util.Spliterator.OfPrimitive
            public void forEachRemaining(IntConsumer action) {
                Objects.requireNonNull(action);
                if (this.finished) {
                    return;
                }
                this.finished = true;
                int t = this.started ? next.applyAsInt(this.prev) : seed;
                while (hasNext.test(t)) {
                    action.accept(t);
                    t = next.applyAsInt(t);
                }
            }
        };
        return StreamSupport.intStream(spliterator, false);
    }
}