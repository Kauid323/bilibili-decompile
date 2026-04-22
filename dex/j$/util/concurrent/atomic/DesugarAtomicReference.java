package j$.util.concurrent.atomic;

import j$.util.concurrent.ConcurrentHashMap$SearchEntriesTask$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class DesugarAtomicReference {
    private DesugarAtomicReference() {
    }

    public static <V> V getAndUpdate(AtomicReference<V> atomic, UnaryOperator<V> updateFunction) {
        V prev;
        do {
            prev = atomic.get();
        } while (!ConcurrentHashMap$SearchEntriesTask$$ExternalSyntheticBackportWithForwarding0.m(atomic, prev, updateFunction.apply(prev)));
        return prev;
    }

    public static <V> V updateAndGet(AtomicReference<V> atomic, UnaryOperator<V> updateFunction) {
        V prev;
        V next;
        do {
            prev = atomic.get();
            next = (V) updateFunction.apply(prev);
        } while (!ConcurrentHashMap$SearchEntriesTask$$ExternalSyntheticBackportWithForwarding0.m(atomic, prev, next));
        return next;
    }

    public static <V> V getAndAccumulate(AtomicReference<V> atomic, V x, BinaryOperator<V> accumulatorFunction) {
        V prev;
        do {
            prev = atomic.get();
        } while (!ConcurrentHashMap$SearchEntriesTask$$ExternalSyntheticBackportWithForwarding0.m(atomic, prev, accumulatorFunction.apply(prev, x)));
        return prev;
    }

    public static <V> V accumulateAndGet(AtomicReference<V> atomic, V x, BinaryOperator<V> accumulatorFunction) {
        V prev;
        V next;
        do {
            prev = atomic.get();
            next = (V) accumulatorFunction.apply(prev, x);
        } while (!ConcurrentHashMap$SearchEntriesTask$$ExternalSyntheticBackportWithForwarding0.m(atomic, prev, next));
        return next;
    }
}