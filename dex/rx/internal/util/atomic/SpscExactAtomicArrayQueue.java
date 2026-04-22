package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.Pow2;

public final class SpscExactAtomicArrayQueue<T> extends AtomicReferenceArray<T> implements Queue<T> {
    private static final long serialVersionUID = 6210984603741293445L;
    final int capacitySkip;
    final AtomicLong consumerIndex;
    final int mask;
    final AtomicLong producerIndex;

    public SpscExactAtomicArrayQueue(int capacity) {
        super(Pow2.roundToPowerOfTwo(capacity));
        int len = length();
        this.mask = len - 1;
        this.capacitySkip = len - capacity;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
    }

    @Override // java.util.Queue
    public boolean offer(T value) {
        if (value == null) {
            throw new NullPointerException();
        }
        long pi = this.producerIndex.get();
        int m = this.mask;
        int fullCheck = ((int) (this.capacitySkip + pi)) & m;
        if (get(fullCheck) != null) {
            return false;
        }
        int offset = ((int) pi) & m;
        this.producerIndex.lazySet(1 + pi);
        lazySet(offset, value);
        return true;
    }

    @Override // java.util.Queue
    public T poll() {
        long ci = this.consumerIndex.get();
        int offset = ((int) ci) & this.mask;
        T value = get(offset);
        if (value == null) {
            return null;
        }
        this.consumerIndex.lazySet(1 + ci);
        lazySet(offset, null);
        return value;
    }

    @Override // java.util.Queue
    public T peek() {
        return get(((int) this.consumerIndex.get()) & this.mask);
    }

    @Override // java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.producerIndex == this.consumerIndex;
    }

    @Override // java.util.Collection
    public int size() {
        long ci = this.consumerIndex.get();
        while (true) {
            long pi = this.producerIndex.get();
            long ci2 = this.consumerIndex.get();
            if (ci == ci2) {
                return (int) (pi - ci2);
            }
            ci = ci2;
        }
    }

    @Override // java.util.Collection
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
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
}