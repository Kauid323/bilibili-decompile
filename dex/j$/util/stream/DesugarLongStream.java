package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.Spliterators;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;
import java.util.function.LongUnaryOperator;

public final class DesugarLongStream {
    private DesugarLongStream() {
    }

    public static LongStream iterate(final long seed, final LongPredicate hasNext, final LongUnaryOperator next) {
        Objects.requireNonNull(next);
        Objects.requireNonNull(hasNext);
        Spliterator.OfLong spliterator = new Spliterators.AbstractLongSpliterator(Long.MAX_VALUE, 1296) { // from class: j$.util.stream.DesugarLongStream.1
            boolean finished;
            long prev;
            boolean started;

            @Override // j$.util.Spliterators.AbstractLongSpliterator, j$.util.Spliterator.OfPrimitive
            public boolean tryAdvance(LongConsumer action) {
                long t;
                Objects.requireNonNull(action);
                if (this.finished) {
                    return false;
                }
                if (this.started) {
                    t = next.applyAsLong(this.prev);
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

            @Override // j$.util.Spliterators.AbstractLongSpliterator, j$.util.Spliterator.OfPrimitive
            public void forEachRemaining(LongConsumer action) {
                Objects.requireNonNull(action);
                if (this.finished) {
                    return;
                }
                this.finished = true;
                long t = this.started ? next.applyAsLong(this.prev) : seed;
                while (hasNext.test(t)) {
                    action.accept(t);
                    t = next.applyAsLong(t);
                }
            }
        };
        return StreamSupport.longStream(spliterator, false);
    }
}