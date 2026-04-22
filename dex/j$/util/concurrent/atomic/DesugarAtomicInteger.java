package j$.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

public class DesugarAtomicInteger {
    private DesugarAtomicInteger() {
    }

    public static int getAndUpdate(AtomicInteger atomic, IntUnaryOperator updateFunction) {
        int prev;
        int next;
        do {
            prev = atomic.get();
            next = updateFunction.applyAsInt(prev);
        } while (!atomic.compareAndSet(prev, next));
        return prev;
    }

    public static int updateAndGet(AtomicInteger atomic, IntUnaryOperator updateFunction) {
        int prev;
        int next;
        do {
            prev = atomic.get();
            next = updateFunction.applyAsInt(prev);
        } while (!atomic.compareAndSet(prev, next));
        return next;
    }

    public static int getAndAccumulate(AtomicInteger atomic, int x, IntBinaryOperator accumulatorFunction) {
        int prev;
        int next;
        do {
            prev = atomic.get();
            next = accumulatorFunction.applyAsInt(prev, x);
        } while (!atomic.compareAndSet(prev, next));
        return prev;
    }

    public static int accumulateAndGet(AtomicInteger atomic, int x, IntBinaryOperator accumulatorFunction) {
        int prev;
        int next;
        do {
            prev = atomic.get();
            next = accumulatorFunction.applyAsInt(prev, x);
        } while (!atomic.compareAndSet(prev, next));
        return next;
    }
}