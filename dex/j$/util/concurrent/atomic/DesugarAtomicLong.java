package j$.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;

public class DesugarAtomicLong {
    private DesugarAtomicLong() {
    }

    public static long getAndUpdate(AtomicLong atomic, LongUnaryOperator updateFunction) {
        long prev;
        long next;
        do {
            prev = atomic.get();
            next = updateFunction.applyAsLong(prev);
        } while (!atomic.compareAndSet(prev, next));
        return prev;
    }

    public static long updateAndGet(AtomicLong atomic, LongUnaryOperator updateFunction) {
        long prev;
        long next;
        do {
            prev = atomic.get();
            next = updateFunction.applyAsLong(prev);
        } while (!atomic.compareAndSet(prev, next));
        return next;
    }

    public static long getAndAccumulate(AtomicLong atomic, long x, LongBinaryOperator accumulatorFunction) {
        long prev;
        long next;
        do {
            prev = atomic.get();
            next = accumulatorFunction.applyAsLong(prev, x);
        } while (!atomic.compareAndSet(prev, next));
        return prev;
    }

    public static long accumulateAndGet(AtomicLong atomic, long x, LongBinaryOperator accumulatorFunction) {
        long prev;
        long next;
        do {
            prev = atomic.get();
            next = accumulatorFunction.applyAsLong(prev, x);
        } while (!atomic.compareAndSet(prev, next));
        return next;
    }
}