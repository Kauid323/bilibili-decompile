package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.Spliterators;
import java.util.function.DoubleConsumer;
import java.util.function.DoublePredicate;
import java.util.function.DoubleUnaryOperator;

public final class DesugarDoubleStream {
    private DesugarDoubleStream() {
    }

    public static DoubleStream iterate(final double seed, final DoublePredicate hasNext, final DoubleUnaryOperator next) {
        Objects.requireNonNull(next);
        Objects.requireNonNull(hasNext);
        Spliterator.OfDouble spliterator = new Spliterators.AbstractDoubleSpliterator(Long.MAX_VALUE, 1296) { // from class: j$.util.stream.DesugarDoubleStream.1
            boolean finished;
            double prev;
            boolean started;

            @Override // j$.util.Spliterators.AbstractDoubleSpliterator, j$.util.Spliterator.OfPrimitive
            public boolean tryAdvance(DoubleConsumer action) {
                double t;
                Objects.requireNonNull(action);
                if (this.finished) {
                    return false;
                }
                if (this.started) {
                    t = next.applyAsDouble(this.prev);
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

            @Override // j$.util.Spliterators.AbstractDoubleSpliterator, j$.util.Spliterator.OfPrimitive
            public void forEachRemaining(DoubleConsumer action) {
                Objects.requireNonNull(action);
                if (this.finished) {
                    return;
                }
                this.finished = true;
                double t = this.started ? next.applyAsDouble(this.prev) : seed;
                while (hasNext.test(t)) {
                    action.accept(t);
                    t = next.applyAsDouble(t);
                }
            }
        };
        return StreamSupport.doubleStream(spliterator, false);
    }
}