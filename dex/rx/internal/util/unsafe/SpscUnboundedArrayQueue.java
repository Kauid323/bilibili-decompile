package rx.internal.util.unsafe;

import java.lang.reflect.Field;
import java.util.Iterator;

public class SpscUnboundedArrayQueue<E> extends SpscUnboundedArrayQueueConsumerField<E> implements QueueProgressIndicators {
    private static final long C_INDEX_OFFSET;
    private static final long P_INDEX_OFFSET;
    private static final long REF_ARRAY_BASE;
    private static final int REF_ELEMENT_SHIFT;
    static final int MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object HAS_NEXT = new Object();

    static {
        int scale = UnsafeAccess.UNSAFE.arrayIndexScale(Object[].class);
        if (4 == scale) {
            REF_ELEMENT_SHIFT = 2;
        } else if (8 == scale) {
            REF_ELEMENT_SHIFT = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        REF_ARRAY_BASE = UnsafeAccess.UNSAFE.arrayBaseOffset(Object[].class);
        try {
            Field iField = SpscUnboundedArrayQueueProducerFields.class.getDeclaredField("producerIndex");
            P_INDEX_OFFSET = UnsafeAccess.UNSAFE.objectFieldOffset(iField);
            try {
                Field iField2 = SpscUnboundedArrayQueueConsumerField.class.getDeclaredField("consumerIndex");
                C_INDEX_OFFSET = UnsafeAccess.UNSAFE.objectFieldOffset(iField2);
            } catch (NoSuchFieldException e) {
                InternalError ex = new InternalError();
                ex.initCause(e);
                throw ex;
            }
        } catch (NoSuchFieldException e2) {
            InternalError ex2 = new InternalError();
            ex2.initCause(e2);
            throw ex2;
        }
    }

    public SpscUnboundedArrayQueue(int bufferSize) {
        int p2capacity = Pow2.roundToPowerOfTwo(bufferSize);
        long mask = p2capacity - 1;
        E[] buffer = (E[]) new Object[p2capacity + 1];
        this.producerBuffer = buffer;
        this.producerMask = mask;
        adjustLookAheadStep(p2capacity);
        this.consumerBuffer = buffer;
        this.consumerMask = mask;
        this.producerLookAhead = mask - 1;
        soProducerIndex(0L);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public final boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        E[] buffer = this.producerBuffer;
        long index = this.producerIndex;
        long mask = this.producerMask;
        long offset = calcWrappedOffset(index, mask);
        if (index < this.producerLookAhead) {
            return writeToQueue(buffer, e, index, offset);
        }
        int lookAheadStep = this.producerLookAheadStep;
        long lookAheadElementOffset = calcWrappedOffset(lookAheadStep + index, mask);
        if (lvElement(buffer, lookAheadElementOffset) == null) {
            this.producerLookAhead = (lookAheadStep + index) - 1;
            return writeToQueue(buffer, e, index, offset);
        } else if (lvElement(buffer, calcWrappedOffset(1 + index, mask)) != null) {
            return writeToQueue(buffer, e, index, offset);
        } else {
            resize(buffer, index, offset, e, mask);
            return true;
        }
    }

    private boolean writeToQueue(E[] buffer, E e, long index, long offset) {
        soElement(buffer, offset, e);
        soProducerIndex(1 + index);
        return true;
    }

    private void resize(E[] oldBuffer, long currIndex, long offset, E e, long mask) {
        int capacity = oldBuffer.length;
        E[] newBuffer = (E[]) new Object[capacity];
        this.producerBuffer = newBuffer;
        this.producerLookAhead = (currIndex + mask) - 1;
        soElement(newBuffer, offset, e);
        soNext(oldBuffer, newBuffer);
        soElement(oldBuffer, offset, HAS_NEXT);
        soProducerIndex(1 + currIndex);
    }

    private void soNext(E[] curr, E[] next) {
        soElement(curr, calcDirectOffset(curr.length - 1), next);
    }

    private E[] lvNext(E[] curr) {
        return (E[]) ((Object[]) lvElement(curr, calcDirectOffset(curr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] buffer = this.consumerBuffer;
        long index = this.consumerIndex;
        long mask = this.consumerMask;
        long offset = calcWrappedOffset(index, mask);
        E e = (E) lvElement(buffer, offset);
        boolean isNextBuffer = e == HAS_NEXT;
        if (e != null && !isNextBuffer) {
            soElement(buffer, offset, null);
            soConsumerIndex(1 + index);
            return e;
        } else if (!isNextBuffer) {
            return null;
        } else {
            return newBufferPoll(lvNext(buffer), index, mask);
        }
    }

    private E newBufferPoll(E[] nextBuffer, long index, long mask) {
        this.consumerBuffer = nextBuffer;
        long offsetInNew = calcWrappedOffset(index, mask);
        E n = (E) lvElement(nextBuffer, offsetInNew);
        if (n == null) {
            return null;
        }
        soElement(nextBuffer, offsetInNew, null);
        soConsumerIndex(1 + index);
        return n;
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] buffer = this.consumerBuffer;
        long index = this.consumerIndex;
        long mask = this.consumerMask;
        long offset = calcWrappedOffset(index, mask);
        E e = (E) lvElement(buffer, offset);
        if (e == HAS_NEXT) {
            return newBufferPeek(lvNext(buffer), index, mask);
        }
        return e;
    }

    private E newBufferPeek(E[] nextBuffer, long index, long mask) {
        this.consumerBuffer = nextBuffer;
        long offsetInNew = calcWrappedOffset(index, mask);
        return (E) lvElement(nextBuffer, offsetInNew);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
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

    private void adjustLookAheadStep(int capacity) {
        this.producerLookAheadStep = Math.min(capacity / 4, MAX_LOOK_AHEAD_STEP);
    }

    private long lvProducerIndex() {
        return UnsafeAccess.UNSAFE.getLongVolatile(this, P_INDEX_OFFSET);
    }

    private long lvConsumerIndex() {
        return UnsafeAccess.UNSAFE.getLongVolatile(this, C_INDEX_OFFSET);
    }

    private void soProducerIndex(long v) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, P_INDEX_OFFSET, v);
    }

    private void soConsumerIndex(long v) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, C_INDEX_OFFSET, v);
    }

    private static long calcWrappedOffset(long index, long mask) {
        return calcDirectOffset(index & mask);
    }

    private static long calcDirectOffset(long index) {
        return REF_ARRAY_BASE + (index << REF_ELEMENT_SHIFT);
    }

    private static void soElement(Object[] buffer, long offset, Object e) {
        UnsafeAccess.UNSAFE.putOrderedObject(buffer, offset, e);
    }

    private static <E> Object lvElement(E[] buffer, long offset) {
        return UnsafeAccess.UNSAFE.getObjectVolatile(buffer, offset);
    }

    @Override // rx.internal.util.unsafe.QueueProgressIndicators
    public long currentProducerIndex() {
        return lvProducerIndex();
    }

    @Override // rx.internal.util.unsafe.QueueProgressIndicators
    public long currentConsumerIndex() {
        return lvConsumerIndex();
    }
}