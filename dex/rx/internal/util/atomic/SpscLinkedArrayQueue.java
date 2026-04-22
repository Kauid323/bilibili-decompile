package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.Pow2;

public final class SpscLinkedArrayQueue<T> implements Queue<T> {
    AtomicReferenceArray<Object> consumerBuffer;
    final AtomicLong consumerIndex;
    int consumerMask;
    AtomicReferenceArray<Object> producerBuffer;
    final AtomicLong producerIndex;
    long producerLookAhead;
    int producerLookAheadStep;
    int producerMask;
    static final int MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object HAS_NEXT = new Object();

    public SpscLinkedArrayQueue(int bufferSize) {
        int p2capacity = Pow2.roundToPowerOfTwo(bufferSize);
        int mask = p2capacity - 1;
        AtomicReferenceArray<Object> buffer = new AtomicReferenceArray<>(p2capacity + 1);
        this.producerBuffer = buffer;
        this.producerMask = mask;
        adjustLookAheadStep(p2capacity);
        this.consumerBuffer = buffer;
        this.consumerMask = mask;
        this.producerLookAhead = mask - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
    }

    @Override // java.util.Queue
    public boolean offer(T e) {
        AtomicReferenceArray<Object> buffer = this.producerBuffer;
        long index = lpProducerIndex();
        int mask = this.producerMask;
        int offset = calcWrappedOffset(index, mask);
        if (index < this.producerLookAhead) {
            return writeToQueue(buffer, e, index, offset);
        }
        int lookAheadStep = this.producerLookAheadStep;
        int lookAheadElementOffset = calcWrappedOffset(lookAheadStep + index, mask);
        if (lvElement(buffer, lookAheadElementOffset) == null) {
            this.producerLookAhead = (lookAheadStep + index) - 1;
            return writeToQueue(buffer, e, index, offset);
        } else if (lvElement(buffer, calcWrappedOffset(1 + index, mask)) == null) {
            return writeToQueue(buffer, e, index, offset);
        } else {
            resize(buffer, index, offset, e, mask);
            return true;
        }
    }

    private boolean writeToQueue(AtomicReferenceArray<Object> buffer, T e, long index, int offset) {
        soElement(buffer, offset, e);
        soProducerIndex(1 + index);
        return true;
    }

    private void resize(AtomicReferenceArray<Object> oldBuffer, long currIndex, int offset, T e, long mask) {
        int capacity = oldBuffer.length();
        AtomicReferenceArray<Object> newBuffer = new AtomicReferenceArray<>(capacity);
        this.producerBuffer = newBuffer;
        this.producerLookAhead = (currIndex + mask) - 1;
        soElement(newBuffer, offset, e);
        soNext(oldBuffer, newBuffer);
        soElement(oldBuffer, offset, HAS_NEXT);
        soProducerIndex(1 + currIndex);
    }

    private void soNext(AtomicReferenceArray<Object> curr, AtomicReferenceArray<Object> next) {
        soElement(curr, calcDirectOffset(curr.length() - 1), next);
    }

    private AtomicReferenceArray<Object> lvNext(AtomicReferenceArray<Object> curr) {
        return (AtomicReferenceArray) lvElement(curr, calcDirectOffset(curr.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> buffer = this.consumerBuffer;
        long index = lpConsumerIndex();
        int mask = this.consumerMask;
        int offset = calcWrappedOffset(index, mask);
        T t = (T) lvElement(buffer, offset);
        boolean isNextBuffer = t == HAS_NEXT;
        if (t != null && !isNextBuffer) {
            soElement(buffer, offset, null);
            soConsumerIndex(1 + index);
            return t;
        } else if (!isNextBuffer) {
            return null;
        } else {
            return newBufferPoll(lvNext(buffer), index, mask);
        }
    }

    private T newBufferPoll(AtomicReferenceArray<Object> nextBuffer, long index, int mask) {
        this.consumerBuffer = nextBuffer;
        int offsetInNew = calcWrappedOffset(index, mask);
        T n = (T) lvElement(nextBuffer, offsetInNew);
        if (n == null) {
            return null;
        }
        soElement(nextBuffer, offsetInNew, null);
        soConsumerIndex(1 + index);
        return n;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> buffer = this.consumerBuffer;
        long index = lpConsumerIndex();
        int mask = this.consumerMask;
        int offset = calcWrappedOffset(index, mask);
        T t = (T) lvElement(buffer, offset);
        if (t == HAS_NEXT) {
            return newBufferPeek(lvNext(buffer), index, mask);
        }
        return t;
    }

    @Override // java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    private T newBufferPeek(AtomicReferenceArray<Object> nextBuffer, long index, int mask) {
        this.consumerBuffer = nextBuffer;
        int offsetInNew = calcWrappedOffset(index, mask);
        return (T) lvElement(nextBuffer, offsetInNew);
    }

    @Override // java.util.Collection
    public int size() {
        long before;
        long currentProducerIndex;
        long after = lvConsumerIndex();
        do {
            before = after;
            currentProducerIndex = lvProducerIndex();
            after = lvConsumerIndex();
        } while (before != after);
        return (int) (currentProducerIndex - after);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return lvProducerIndex() == lvConsumerIndex();
    }

    private void adjustLookAheadStep(int capacity) {
        this.producerLookAheadStep = Math.min(capacity / 4, MAX_LOOK_AHEAD_STEP);
    }

    private long lvProducerIndex() {
        return this.producerIndex.get();
    }

    private long lvConsumerIndex() {
        return this.consumerIndex.get();
    }

    private long lpProducerIndex() {
        return this.producerIndex.get();
    }

    private long lpConsumerIndex() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long v) {
        this.producerIndex.lazySet(v);
    }

    private void soConsumerIndex(long v) {
        this.consumerIndex.lazySet(v);
    }

    private static int calcWrappedOffset(long index, int mask) {
        return calcDirectOffset(((int) index) & mask);
    }

    private static int calcDirectOffset(int index) {
        return index;
    }

    private static void soElement(AtomicReferenceArray<Object> buffer, int offset, Object e) {
        buffer.lazySet(offset, e);
    }

    private static <E> Object lvElement(AtomicReferenceArray<Object> buffer, int offset) {
        return buffer.get(offset);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public <E> E[] toArray(E[] a) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(T e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T element() {
        throw new UnsupportedOperationException();
    }

    public boolean offer(T first, T second) {
        AtomicReferenceArray<Object> buffer = this.producerBuffer;
        long p = lvProducerIndex();
        int m = this.producerMask;
        if (lvElement(buffer, calcWrappedOffset(p + 2, m)) == null) {
            int pi = calcWrappedOffset(p, m);
            soElement(buffer, pi + 1, second);
            soElement(buffer, pi, first);
            soProducerIndex(2 + p);
            return true;
        }
        int capacity = buffer.length();
        AtomicReferenceArray<Object> newBuffer = new AtomicReferenceArray<>(capacity);
        this.producerBuffer = newBuffer;
        int pi2 = calcWrappedOffset(p, m);
        soElement(newBuffer, pi2 + 1, second);
        soElement(newBuffer, pi2, first);
        soNext(buffer, newBuffer);
        soElement(buffer, pi2, HAS_NEXT);
        soProducerIndex(2 + p);
        return true;
    }
}