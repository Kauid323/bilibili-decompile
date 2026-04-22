package j$.util.stream;

import j$.lang.Iterable;
import j$.util.DesugarArrays;
import j$.util.Objects;
import j$.util.PrimitiveIterator;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.Consumer$CC;
import j$.util.function.DoubleConsumer$CC;
import j$.util.function.IntConsumer$CC;
import j$.util.function.LongConsumer$CC;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;

/* JADX INFO: Access modifiers changed from: package-private */
public class SpinedBuffer<E> extends AbstractSpinedBuffer implements Consumer<E>, Iterable<E>, Iterable<E> {
    private static final int SPLITERATOR_CHARACTERISTICS = 16464;
    protected E[] curChunk;
    protected E[][] spine;

    @Override // java.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return Spliterator.Wrapper.convert(spliterator());
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer != java.util.stream.SpinedBuffer<E> */
    SpinedBuffer(int initialCapacity) {
        super(initialCapacity);
        this.curChunk = (E[]) new Object[1 << this.initialChunkPower];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer != java.util.stream.SpinedBuffer<E> */
    public SpinedBuffer() {
        this.curChunk = (E[]) new Object[1 << this.initialChunkPower];
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer != java.util.stream.SpinedBuffer<E> */
    protected long capacity() {
        if (this.spineIndex == 0) {
            return this.curChunk.length;
        }
        return this.priorElementCount[this.spineIndex] + this.spine[this.spineIndex].length;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer != java.util.stream.SpinedBuffer<E> */
    private void inflateSpine() {
        if (this.spine == null) {
            this.spine = (E[][]) new Object[8];
            this.priorElementCount = new long[8];
            this.spine[0] = this.curChunk;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer != java.util.stream.SpinedBuffer<E> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void ensureCapacity(long targetSize) {
        long capacity = capacity();
        if (targetSize > capacity) {
            inflateSpine();
            int i = this.spineIndex;
            while (true) {
                i++;
                if (targetSize > capacity) {
                    if (i >= this.spine.length) {
                        int newSpineSize = this.spine.length * 2;
                        this.spine = (E[][]) ((Object[][]) Arrays.copyOf(this.spine, newSpineSize));
                        this.priorElementCount = Arrays.copyOf(this.priorElementCount, newSpineSize);
                    }
                    int nextChunkSize = chunkSize(i);
                    this.spine[i] = new Object[nextChunkSize];
                    this.priorElementCount[i] = this.priorElementCount[i - 1] + this.spine[i - 1].length;
                    capacity += nextChunkSize;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer != java.util.stream.SpinedBuffer<E> */
    protected void increaseCapacity() {
        ensureCapacity(capacity() + 1);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer != java.util.stream.SpinedBuffer<E> */
    public E get(long index) {
        if (this.spineIndex == 0) {
            if (index < this.elementIndex) {
                return this.curChunk[(int) index];
            }
            throw new IndexOutOfBoundsException(Long.toString(index));
        } else if (index >= count()) {
            throw new IndexOutOfBoundsException(Long.toString(index));
        } else {
            for (int j = 0; j <= this.spineIndex; j++) {
                if (index < this.priorElementCount[j] + this.spine[j].length) {
                    return this.spine[j][(int) (index - this.priorElementCount[j])];
                }
            }
            throw new IndexOutOfBoundsException(Long.toString(index));
        }
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer != java.util.stream.SpinedBuffer<E> */
    public void copyInto(E[] array, int offset) {
        long finalOffset = offset + count();
        if (finalOffset > array.length || finalOffset < offset) {
            throw new IndexOutOfBoundsException("does not fit");
        }
        if (this.spineIndex == 0) {
            System.arraycopy(this.curChunk, 0, array, offset, this.elementIndex);
            return;
        }
        for (int i = 0; i < this.spineIndex; i++) {
            System.arraycopy(this.spine[i], 0, array, offset, this.spine[i].length);
            offset += this.spine[i].length;
        }
        int i2 = this.elementIndex;
        if (i2 > 0) {
            System.arraycopy(this.curChunk, 0, array, offset, this.elementIndex);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer != java.util.stream.SpinedBuffer<E> */
    public E[] asArray(IntFunction<E[]> arrayFactory) {
        long size = count();
        if (size >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        E[] result = arrayFactory.apply((int) size);
        copyInto(result, 0);
        return result;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer != java.util.stream.SpinedBuffer<E> */
    @Override // j$.util.stream.AbstractSpinedBuffer
    public void clear() {
        if (this.spine != null) {
            this.curChunk = this.spine[0];
            for (int i = 0; i < this.curChunk.length; i++) {
                this.curChunk[i] = null;
            }
            this.spine = null;
            this.priorElementCount = null;
        } else {
            for (int i2 = 0; i2 < this.elementIndex; i2++) {
                this.curChunk[i2] = null;
            }
        }
        this.elementIndex = 0;
        this.spineIndex = 0;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer != java.util.stream.SpinedBuffer<E> */
    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return Spliterators.iterator(spliterator());
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer != java.util.stream.SpinedBuffer<E> */
    public void forEach(Consumer<? super E> consumer) {
        for (int j = 0; j < this.spineIndex; j++) {
            for (E e : this.spine[j]) {
                consumer.accept((Object) e);
            }
        }
        for (int i = 0; i < this.elementIndex; i++) {
            consumer.accept((Object) this.curChunk[i]);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer != java.util.stream.SpinedBuffer<E> */
    public void accept(E e) {
        if (this.elementIndex == this.curChunk.length) {
            inflateSpine();
            if (this.spineIndex + 1 >= this.spine.length || this.spine[this.spineIndex + 1] == null) {
                increaseCapacity();
            }
            this.elementIndex = 0;
            this.spineIndex++;
            this.curChunk = this.spine[this.spineIndex];
        }
        E[] eArr = this.curChunk;
        int i = this.elementIndex;
        this.elementIndex = i + 1;
        eArr[i] = e;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer != java.util.stream.SpinedBuffer<E> */
    public String toString() {
        final List<E> list = new ArrayList<>();
        Objects.requireNonNull(list);
        forEach(new Consumer() { // from class: j$.util.stream.SpinedBuffer$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                list.add(obj);
            }

            @Override // java.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer$CC.$default$andThen(this, consumer);
            }
        });
        return "SpinedBuffer:" + list.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j$.util.stream.SpinedBuffer$1Splitr  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public class C1Splitr implements j$.util.Spliterator<E> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final int lastSpineElementFence;
        final int lastSpineIndex;
        E[] splChunk;
        int splElementIndex;
        int splSpineIndex;

        @Override // j$.util.Spliterator
        public /* synthetic */ Comparator getComparator() {
            return Spliterator.CC.$default$getComparator(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return Spliterator.CC.$default$getExactSizeIfKnown(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Spliterator.CC.$default$hasCharacteristics(this, i);
        }

        C1Splitr(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
            this.splSpineIndex = firstSpineIndex;
            this.lastSpineIndex = lastSpineIndex;
            this.splElementIndex = firstSpineElementIndex;
            this.lastSpineElementFence = lastSpineElementFence;
            this.splChunk = SpinedBuffer.this.spine == null ? SpinedBuffer.this.curChunk : SpinedBuffer.this.spine[firstSpineIndex];
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            if (this.splSpineIndex == this.lastSpineIndex) {
                return this.lastSpineElementFence - this.splElementIndex;
            }
            return ((SpinedBuffer.this.priorElementCount[this.lastSpineIndex] + this.lastSpineElementFence) - SpinedBuffer.this.priorElementCount[this.splSpineIndex]) - this.splElementIndex;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return SpinedBuffer.SPLITERATOR_CHARACTERISTICS;
        }

        @Override // j$.util.Spliterator
        public boolean tryAdvance(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            if (this.splSpineIndex < this.lastSpineIndex || (this.splSpineIndex == this.lastSpineIndex && this.splElementIndex < this.lastSpineElementFence)) {
                int i = this.splElementIndex;
                this.splElementIndex = i + 1;
                consumer.accept((Object) this.splChunk[i]);
                if (this.splElementIndex == this.splChunk.length) {
                    this.splElementIndex = 0;
                    this.splSpineIndex++;
                    if (SpinedBuffer.this.spine != null && this.splSpineIndex <= this.lastSpineIndex) {
                        this.splChunk = SpinedBuffer.this.spine[this.splSpineIndex];
                    }
                }
                return true;
            }
            return false;
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            if (this.splSpineIndex < this.lastSpineIndex || (this.splSpineIndex == this.lastSpineIndex && this.splElementIndex < this.lastSpineElementFence)) {
                int i = this.splElementIndex;
                for (int sp = this.splSpineIndex; sp < this.lastSpineIndex; sp++) {
                    E[] chunk = SpinedBuffer.this.spine[sp];
                    while (i < chunk.length) {
                        consumer.accept((Object) chunk[i]);
                        i++;
                    }
                    i = 0;
                }
                int sp2 = this.splSpineIndex;
                E[] chunk2 = sp2 == this.lastSpineIndex ? this.splChunk : SpinedBuffer.this.spine[this.lastSpineIndex];
                int hElementIndex = this.lastSpineElementFence;
                while (i < hElementIndex) {
                    consumer.accept((Object) chunk2[i]);
                    i++;
                }
                this.splSpineIndex = this.lastSpineIndex;
                this.splElementIndex = this.lastSpineElementFence;
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<E> */
        @Override // j$.util.Spliterator
        public j$.util.Spliterator<E> trySplit() {
            int t;
            if (this.splSpineIndex < this.lastSpineIndex) {
                C1Splitr c1Splitr = new C1Splitr(this.splSpineIndex, this.lastSpineIndex - 1, this.splElementIndex, SpinedBuffer.this.spine[this.lastSpineIndex - 1].length);
                this.splSpineIndex = this.lastSpineIndex;
                this.splElementIndex = 0;
                this.splChunk = SpinedBuffer.this.spine[this.splSpineIndex];
                return c1Splitr;
            } else if (this.splSpineIndex != this.lastSpineIndex || (t = (this.lastSpineElementFence - this.splElementIndex) / 2) == 0) {
                return null;
            } else {
                j$.util.Spliterator<E> spliterator = DesugarArrays.spliterator(this.splChunk, this.splElementIndex, this.splElementIndex + t);
                this.splElementIndex += t;
                return spliterator;
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer != java.util.stream.SpinedBuffer<E> */
    public j$.util.Spliterator<E> spliterator() {
        return new C1Splitr(0, this.spineIndex, 0, this.elementIndex);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static abstract class OfPrimitive<E, T_ARR, T_CONS> extends AbstractSpinedBuffer implements Iterable<E>, Iterable<E> {
        T_ARR curChunk;
        T_ARR[] spine;

        protected abstract void arrayForEach(T_ARR t_arr, int i, int i2, T_CONS t_cons);

        protected abstract int arrayLength(T_ARR t_arr);

        public abstract void forEach(Consumer<? super E> consumer);

        public abstract Iterator<E> iterator();

        public abstract T_ARR newArray(int i);

        protected abstract T_ARR[] newArrayArray(int i);

        @Override // java.lang.Iterable
        public /* synthetic */ java.util.Spliterator spliterator() {
            return Spliterator.Wrapper.convert(spliterator());
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer$OfPrimitive != java.util.stream.SpinedBuffer$OfPrimitive<E, T_ARR, T_CONS> */
        OfPrimitive(int initialCapacity) {
            super(initialCapacity);
            this.curChunk = newArray(1 << this.initialChunkPower);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer$OfPrimitive != java.util.stream.SpinedBuffer$OfPrimitive<E, T_ARR, T_CONS> */
        OfPrimitive() {
            this.curChunk = newArray(1 << this.initialChunkPower);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer$OfPrimitive != java.util.stream.SpinedBuffer$OfPrimitive<E, T_ARR, T_CONS> */
        public j$.util.Spliterator<E> spliterator() {
            return Spliterators.spliteratorUnknownSize(iterator(), 0);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer$OfPrimitive != java.util.stream.SpinedBuffer$OfPrimitive<E, T_ARR, T_CONS> */
        protected long capacity() {
            if (this.spineIndex == 0) {
                return arrayLength(this.curChunk);
            }
            return this.priorElementCount[this.spineIndex] + arrayLength(this.spine[this.spineIndex]);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer$OfPrimitive != java.util.stream.SpinedBuffer$OfPrimitive<E, T_ARR, T_CONS> */
        private void inflateSpine() {
            if (this.spine == null) {
                this.spine = newArrayArray(8);
                this.priorElementCount = new long[8];
                this.spine[0] = this.curChunk;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer$OfPrimitive != java.util.stream.SpinedBuffer$OfPrimitive<E, T_ARR, T_CONS> */
        public final void ensureCapacity(long targetSize) {
            long capacity = capacity();
            if (targetSize > capacity) {
                inflateSpine();
                int i = this.spineIndex;
                while (true) {
                    i++;
                    if (targetSize > capacity) {
                        if (i >= this.spine.length) {
                            int newSpineSize = this.spine.length * 2;
                            this.spine = (T_ARR[]) Arrays.copyOf(this.spine, newSpineSize);
                            this.priorElementCount = Arrays.copyOf(this.priorElementCount, newSpineSize);
                        }
                        int nextChunkSize = chunkSize(i);
                        this.spine[i] = newArray(nextChunkSize);
                        this.priorElementCount[i] = this.priorElementCount[i - 1] + arrayLength(this.spine[i - 1]);
                        capacity += nextChunkSize;
                    } else {
                        return;
                    }
                }
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer$OfPrimitive != java.util.stream.SpinedBuffer$OfPrimitive<E, T_ARR, T_CONS> */
        protected void increaseCapacity() {
            ensureCapacity(capacity() + 1);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer$OfPrimitive != java.util.stream.SpinedBuffer$OfPrimitive<E, T_ARR, T_CONS> */
        protected int chunkFor(long index) {
            if (this.spineIndex == 0) {
                if (index < this.elementIndex) {
                    return 0;
                }
                throw new IndexOutOfBoundsException(Long.toString(index));
            } else if (index >= count()) {
                throw new IndexOutOfBoundsException(Long.toString(index));
            } else {
                for (int j = 0; j <= this.spineIndex; j++) {
                    if (index < this.priorElementCount[j] + arrayLength(this.spine[j])) {
                        return j;
                    }
                }
                throw new IndexOutOfBoundsException(Long.toString(index));
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer$OfPrimitive != java.util.stream.SpinedBuffer$OfPrimitive<E, T_ARR, T_CONS> */
        public void copyInto(T_ARR array, int offset) {
            long finalOffset = offset + count();
            if (finalOffset > arrayLength(array) || finalOffset < offset) {
                throw new IndexOutOfBoundsException("does not fit");
            }
            if (this.spineIndex == 0) {
                System.arraycopy(this.curChunk, 0, array, offset, this.elementIndex);
                return;
            }
            for (int i = 0; i < this.spineIndex; i++) {
                System.arraycopy(this.spine[i], 0, array, offset, arrayLength(this.spine[i]));
                offset += arrayLength(this.spine[i]);
            }
            int i2 = this.elementIndex;
            if (i2 > 0) {
                System.arraycopy(this.curChunk, 0, array, offset, this.elementIndex);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer$OfPrimitive != java.util.stream.SpinedBuffer$OfPrimitive<E, T_ARR, T_CONS> */
        public T_ARR asPrimitiveArray() {
            long size = count();
            if (size >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            T_ARR result = newArray((int) size);
            copyInto(result, 0);
            return result;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer$OfPrimitive != java.util.stream.SpinedBuffer$OfPrimitive<E, T_ARR, T_CONS> */
        protected void preAccept() {
            if (this.elementIndex == arrayLength(this.curChunk)) {
                inflateSpine();
                if (this.spineIndex + 1 >= this.spine.length || this.spine[this.spineIndex + 1] == null) {
                    increaseCapacity();
                }
                this.elementIndex = 0;
                this.spineIndex++;
                this.curChunk = this.spine[this.spineIndex];
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer$OfPrimitive != java.util.stream.SpinedBuffer$OfPrimitive<E, T_ARR, T_CONS> */
        @Override // j$.util.stream.AbstractSpinedBuffer
        public void clear() {
            if (this.spine != null) {
                this.curChunk = this.spine[0];
                this.spine = null;
                this.priorElementCount = null;
            }
            this.elementIndex = 0;
            this.spineIndex = 0;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer$OfPrimitive != java.util.stream.SpinedBuffer$OfPrimitive<E, T_ARR, T_CONS> */
        public void forEach(T_CONS consumer) {
            for (int j = 0; j < this.spineIndex; j++) {
                arrayForEach(this.spine[j], 0, arrayLength(this.spine[j]), consumer);
            }
            arrayForEach(this.curChunk, 0, this.elementIndex, consumer);
        }

        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        abstract class BaseSpliterator<T_SPLITR extends Spliterator.OfPrimitive<E, T_CONS, T_SPLITR>> implements Spliterator.OfPrimitive<E, T_CONS, T_SPLITR> {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            final int lastSpineElementFence;
            final int lastSpineIndex;
            T_ARR splChunk;
            int splElementIndex;
            int splSpineIndex;

            abstract void arrayForOne(T_ARR t_arr, int i, T_CONS t_cons);

            abstract T_SPLITR arraySpliterator(T_ARR t_arr, int i, int i2);

            @Override // j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Spliterator.CC.$default$forEachRemaining(this, consumer);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ Comparator getComparator() {
                return Spliterator.CC.$default$getComparator(this);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ long getExactSizeIfKnown() {
                return Spliterator.CC.$default$getExactSizeIfKnown(this);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ boolean hasCharacteristics(int i) {
                return Spliterator.CC.$default$hasCharacteristics(this, i);
            }

            abstract T_SPLITR newSpliterator(int i, int i2, int i3, int i4);

            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer$OfPrimitive$BaseSpliterator != java.util.stream.SpinedBuffer$OfPrimitive<E, T_ARR, T_CONS>$BaseSpliterator<T_SPLITR extends j$.util.Spliterator$OfPrimitive<E, T_CONS, T_SPLITR>> */
            BaseSpliterator(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                this.splSpineIndex = firstSpineIndex;
                this.lastSpineIndex = lastSpineIndex;
                this.splElementIndex = firstSpineElementIndex;
                this.lastSpineElementFence = lastSpineElementFence;
                this.splChunk = OfPrimitive.this.spine == null ? OfPrimitive.this.curChunk : OfPrimitive.this.spine[firstSpineIndex];
            }

            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer$OfPrimitive$BaseSpliterator != java.util.stream.SpinedBuffer$OfPrimitive<E, T_ARR, T_CONS>$BaseSpliterator<T_SPLITR extends j$.util.Spliterator$OfPrimitive<E, T_CONS, T_SPLITR>> */
            @Override // j$.util.Spliterator
            public long estimateSize() {
                if (this.splSpineIndex == this.lastSpineIndex) {
                    return this.lastSpineElementFence - this.splElementIndex;
                }
                return ((OfPrimitive.this.priorElementCount[this.lastSpineIndex] + this.lastSpineElementFence) - OfPrimitive.this.priorElementCount[this.splSpineIndex]) - this.splElementIndex;
            }

            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer$OfPrimitive$BaseSpliterator != java.util.stream.SpinedBuffer$OfPrimitive<E, T_ARR, T_CONS>$BaseSpliterator<T_SPLITR extends j$.util.Spliterator$OfPrimitive<E, T_CONS, T_SPLITR>> */
            @Override // j$.util.Spliterator
            public int characteristics() {
                return SpinedBuffer.SPLITERATOR_CHARACTERISTICS;
            }

            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer$OfPrimitive$BaseSpliterator != java.util.stream.SpinedBuffer$OfPrimitive<E, T_ARR, T_CONS>$BaseSpliterator<T_SPLITR extends j$.util.Spliterator$OfPrimitive<E, T_CONS, T_SPLITR>> */
            @Override // j$.util.Spliterator.OfPrimitive
            public boolean tryAdvance(T_CONS consumer) {
                Objects.requireNonNull(consumer);
                if (this.splSpineIndex < this.lastSpineIndex || (this.splSpineIndex == this.lastSpineIndex && this.splElementIndex < this.lastSpineElementFence)) {
                    T_ARR t_arr = this.splChunk;
                    int i = this.splElementIndex;
                    this.splElementIndex = i + 1;
                    arrayForOne(t_arr, i, consumer);
                    if (this.splElementIndex == OfPrimitive.this.arrayLength(this.splChunk)) {
                        this.splElementIndex = 0;
                        this.splSpineIndex++;
                        if (OfPrimitive.this.spine != null && this.splSpineIndex <= this.lastSpineIndex) {
                            this.splChunk = OfPrimitive.this.spine[this.splSpineIndex];
                        }
                    }
                    return true;
                }
                return false;
            }

            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer$OfPrimitive$BaseSpliterator != java.util.stream.SpinedBuffer$OfPrimitive<E, T_ARR, T_CONS>$BaseSpliterator<T_SPLITR extends j$.util.Spliterator$OfPrimitive<E, T_CONS, T_SPLITR>> */
            @Override // j$.util.Spliterator.OfPrimitive
            public void forEachRemaining(T_CONS consumer) {
                Objects.requireNonNull(consumer);
                if (this.splSpineIndex < this.lastSpineIndex || (this.splSpineIndex == this.lastSpineIndex && this.splElementIndex < this.lastSpineElementFence)) {
                    int i = this.splElementIndex;
                    for (int sp = this.splSpineIndex; sp < this.lastSpineIndex; sp++) {
                        T_ARR chunk = OfPrimitive.this.spine[sp];
                        OfPrimitive.this.arrayForEach(chunk, i, OfPrimitive.this.arrayLength(chunk), consumer);
                        i = 0;
                    }
                    int sp2 = this.splSpineIndex;
                    OfPrimitive.this.arrayForEach(sp2 == this.lastSpineIndex ? this.splChunk : OfPrimitive.this.spine[this.lastSpineIndex], i, this.lastSpineElementFence, consumer);
                    this.splSpineIndex = this.lastSpineIndex;
                    this.splElementIndex = this.lastSpineElementFence;
                }
            }

            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.SpinedBuffer$OfPrimitive$BaseSpliterator != java.util.stream.SpinedBuffer$OfPrimitive<E, T_ARR, T_CONS>$BaseSpliterator<T_SPLITR extends j$.util.Spliterator$OfPrimitive<E, T_CONS, T_SPLITR>> */
            @Override // j$.util.Spliterator
            public T_SPLITR trySplit() {
                int t;
                if (this.splSpineIndex < this.lastSpineIndex) {
                    T_SPLITR ret = newSpliterator(this.splSpineIndex, this.lastSpineIndex - 1, this.splElementIndex, OfPrimitive.this.arrayLength(OfPrimitive.this.spine[this.lastSpineIndex - 1]));
                    this.splSpineIndex = this.lastSpineIndex;
                    this.splElementIndex = 0;
                    this.splChunk = OfPrimitive.this.spine[this.splSpineIndex];
                    return ret;
                } else if (this.splSpineIndex != this.lastSpineIndex || (t = (this.lastSpineElementFence - this.splElementIndex) / 2) == 0) {
                    return null;
                } else {
                    T_SPLITR ret2 = arraySpliterator(this.splChunk, this.splElementIndex, t);
                    this.splElementIndex += t;
                    return ret2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static class OfInt extends OfPrimitive<Integer, int[], IntConsumer> implements IntConsumer {
        @Override // java.util.function.IntConsumer
        public /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
            return IntConsumer$CC.$default$andThen(this, intConsumer);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public OfInt() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public OfInt(int initialCapacity) {
            super(initialCapacity);
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive, java.lang.Iterable, j$.lang.Iterable
        public void forEach(Consumer<? super Integer> consumer) {
            if (consumer instanceof IntConsumer) {
                forEach((OfInt) consumer);
                return;
            }
            if (Tripwire.ENABLED) {
                Tripwire.trip(getClass(), "{0} calling SpinedBuffer.OfInt.forEach(Consumer)");
            }
            spliterator().forEachRemaining(consumer);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // j$.util.stream.SpinedBuffer.OfPrimitive
        public int[][] newArrayArray(int size) {
            return new int[size];
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive
        public int[] newArray(int size) {
            return new int[size];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // j$.util.stream.SpinedBuffer.OfPrimitive
        public int arrayLength(int[] array) {
            return array.length;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // j$.util.stream.SpinedBuffer.OfPrimitive
        public void arrayForEach(int[] array, int from, int to, IntConsumer consumer) {
            for (int i = from; i < to; i++) {
                consumer.accept(array[i]);
            }
        }

        public void accept(int i) {
            preAccept();
            int i2 = this.elementIndex;
            this.elementIndex = i2 + 1;
            ((int[]) this.curChunk)[i2] = i;
        }

        public int get(long index) {
            int ch = chunkFor(index);
            if (this.spineIndex == 0 && ch == 0) {
                return ((int[]) this.curChunk)[(int) index];
            }
            return ((int[][]) this.spine)[ch][(int) (index - this.priorElementCount[ch])];
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive, java.lang.Iterable
        public PrimitiveIterator.OfInt iterator() {
            return Spliterators.iterator(spliterator());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: j$.util.stream.SpinedBuffer$OfInt$1Splitr  reason: invalid class name */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public class C1Splitr extends OfPrimitive<Integer, int[], IntConsumer>.BaseSpliterator<Spliterator.OfInt> implements Spliterator.OfInt {
            @Override // j$.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator, j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Spliterator.OfInt.CC.$default$forEachRemaining((Spliterator.OfInt) this, consumer);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ boolean tryAdvance(Consumer consumer) {
                return Spliterator.OfInt.CC.$default$tryAdvance((Spliterator.OfInt) this, consumer);
            }

            @Override // j$.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
                super.forEachRemaining((C1Splitr) intConsumer);
            }

            @Override // j$.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
                return super.tryAdvance((C1Splitr) intConsumer);
            }

            @Override // j$.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator, j$.util.Spliterator.OfPrimitive, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfInt trySplit() {
                return (Spliterator.OfInt) super.trySplit();
            }

            C1Splitr(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                super(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // j$.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            public Spliterator.OfInt newSpliterator(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                return new C1Splitr(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // j$.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            public void arrayForOne(int[] array, int index, IntConsumer consumer) {
                consumer.accept(array[index]);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // j$.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            public Spliterator.OfInt arraySpliterator(int[] array, int offset, int len) {
                return DesugarArrays.spliterator(array, offset, offset + len);
            }
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive, java.lang.Iterable, j$.lang.Iterable
        public Spliterator.OfInt spliterator() {
            return new C1Splitr(0, this.spineIndex, 0, this.elementIndex);
        }

        public String toString() {
            int[] array = asPrimitiveArray();
            if (array.length < 200) {
                return String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(array.length), Integer.valueOf(this.spineIndex), Arrays.toString(array));
            }
            int[] array2 = Arrays.copyOf(array, 200);
            return String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(array.length), Integer.valueOf(this.spineIndex), Arrays.toString(array2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static class OfLong extends OfPrimitive<Long, long[], LongConsumer> implements LongConsumer {
        @Override // java.util.function.LongConsumer
        public /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
            return LongConsumer$CC.$default$andThen(this, longConsumer);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public OfLong() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public OfLong(int initialCapacity) {
            super(initialCapacity);
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive, java.lang.Iterable, j$.lang.Iterable
        public void forEach(Consumer<? super Long> consumer) {
            if (consumer instanceof LongConsumer) {
                forEach((OfLong) consumer);
                return;
            }
            if (Tripwire.ENABLED) {
                Tripwire.trip(getClass(), "{0} calling SpinedBuffer.OfLong.forEach(Consumer)");
            }
            spliterator().forEachRemaining(consumer);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // j$.util.stream.SpinedBuffer.OfPrimitive
        public long[][] newArrayArray(int size) {
            return new long[size];
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive
        public long[] newArray(int size) {
            return new long[size];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // j$.util.stream.SpinedBuffer.OfPrimitive
        public int arrayLength(long[] array) {
            return array.length;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // j$.util.stream.SpinedBuffer.OfPrimitive
        public void arrayForEach(long[] array, int from, int to, LongConsumer consumer) {
            for (int i = from; i < to; i++) {
                consumer.accept(array[i]);
            }
        }

        public void accept(long i) {
            preAccept();
            int i2 = this.elementIndex;
            this.elementIndex = i2 + 1;
            ((long[]) this.curChunk)[i2] = i;
        }

        public long get(long index) {
            int ch = chunkFor(index);
            if (this.spineIndex == 0 && ch == 0) {
                return ((long[]) this.curChunk)[(int) index];
            }
            return ((long[][]) this.spine)[ch][(int) (index - this.priorElementCount[ch])];
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive, java.lang.Iterable
        public PrimitiveIterator.OfLong iterator() {
            return Spliterators.iterator(spliterator());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: j$.util.stream.SpinedBuffer$OfLong$1Splitr  reason: invalid class name */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public class C1Splitr extends OfPrimitive<Long, long[], LongConsumer>.BaseSpliterator<Spliterator.OfLong> implements Spliterator.OfLong {
            @Override // j$.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator, j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Spliterator.OfLong.CC.$default$forEachRemaining((Spliterator.OfLong) this, consumer);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ boolean tryAdvance(Consumer consumer) {
                return Spliterator.OfLong.CC.$default$tryAdvance((Spliterator.OfLong) this, consumer);
            }

            @Override // j$.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
                super.forEachRemaining((C1Splitr) longConsumer);
            }

            @Override // j$.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
                return super.tryAdvance((C1Splitr) longConsumer);
            }

            @Override // j$.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator, j$.util.Spliterator.OfPrimitive, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfLong trySplit() {
                return (Spliterator.OfLong) super.trySplit();
            }

            C1Splitr(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                super(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // j$.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            public Spliterator.OfLong newSpliterator(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                return new C1Splitr(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // j$.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            public void arrayForOne(long[] array, int index, LongConsumer consumer) {
                consumer.accept(array[index]);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // j$.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            public Spliterator.OfLong arraySpliterator(long[] array, int offset, int len) {
                return DesugarArrays.spliterator(array, offset, offset + len);
            }
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive, java.lang.Iterable, j$.lang.Iterable
        public Spliterator.OfLong spliterator() {
            return new C1Splitr(0, this.spineIndex, 0, this.elementIndex);
        }

        public String toString() {
            long[] array = asPrimitiveArray();
            if (array.length < 200) {
                return String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(array.length), Integer.valueOf(this.spineIndex), Arrays.toString(array));
            }
            long[] array2 = Arrays.copyOf(array, 200);
            return String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(array.length), Integer.valueOf(this.spineIndex), Arrays.toString(array2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static class OfDouble extends OfPrimitive<Double, double[], DoubleConsumer> implements DoubleConsumer {
        @Override // java.util.function.DoubleConsumer
        public /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
            return DoubleConsumer$CC.$default$andThen(this, doubleConsumer);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public OfDouble() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public OfDouble(int initialCapacity) {
            super(initialCapacity);
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive, java.lang.Iterable, j$.lang.Iterable
        public void forEach(Consumer<? super Double> consumer) {
            if (consumer instanceof DoubleConsumer) {
                forEach((OfDouble) consumer);
                return;
            }
            if (Tripwire.ENABLED) {
                Tripwire.trip(getClass(), "{0} calling SpinedBuffer.OfDouble.forEach(Consumer)");
            }
            spliterator().forEachRemaining(consumer);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // j$.util.stream.SpinedBuffer.OfPrimitive
        public double[][] newArrayArray(int size) {
            return new double[size];
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive
        public double[] newArray(int size) {
            return new double[size];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // j$.util.stream.SpinedBuffer.OfPrimitive
        public int arrayLength(double[] array) {
            return array.length;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // j$.util.stream.SpinedBuffer.OfPrimitive
        public void arrayForEach(double[] array, int from, int to, DoubleConsumer consumer) {
            for (int i = from; i < to; i++) {
                consumer.accept(array[i]);
            }
        }

        public void accept(double i) {
            preAccept();
            int i2 = this.elementIndex;
            this.elementIndex = i2 + 1;
            ((double[]) this.curChunk)[i2] = i;
        }

        public double get(long index) {
            int ch = chunkFor(index);
            if (this.spineIndex == 0 && ch == 0) {
                return ((double[]) this.curChunk)[(int) index];
            }
            return ((double[][]) this.spine)[ch][(int) (index - this.priorElementCount[ch])];
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive, java.lang.Iterable
        public PrimitiveIterator.OfDouble iterator() {
            return Spliterators.iterator(spliterator());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: j$.util.stream.SpinedBuffer$OfDouble$1Splitr  reason: invalid class name */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public class C1Splitr extends OfPrimitive<Double, double[], DoubleConsumer>.BaseSpliterator<Spliterator.OfDouble> implements Spliterator.OfDouble {
            @Override // j$.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator, j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Spliterator.OfDouble.CC.$default$forEachRemaining((Spliterator.OfDouble) this, consumer);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ boolean tryAdvance(Consumer consumer) {
                return Spliterator.OfDouble.CC.$default$tryAdvance((Spliterator.OfDouble) this, consumer);
            }

            @Override // j$.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
                super.forEachRemaining((C1Splitr) doubleConsumer);
            }

            @Override // j$.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
                return super.tryAdvance((C1Splitr) doubleConsumer);
            }

            @Override // j$.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator, j$.util.Spliterator.OfPrimitive, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfDouble trySplit() {
                return (Spliterator.OfDouble) super.trySplit();
            }

            C1Splitr(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                super(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // j$.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            public Spliterator.OfDouble newSpliterator(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                return new C1Splitr(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // j$.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            public void arrayForOne(double[] array, int index, DoubleConsumer consumer) {
                consumer.accept(array[index]);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // j$.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            public Spliterator.OfDouble arraySpliterator(double[] array, int offset, int len) {
                return DesugarArrays.spliterator(array, offset, offset + len);
            }
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive, java.lang.Iterable, j$.lang.Iterable
        public Spliterator.OfDouble spliterator() {
            return new C1Splitr(0, this.spineIndex, 0, this.elementIndex);
        }

        public String toString() {
            double[] array = asPrimitiveArray();
            if (array.length < 200) {
                return String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(array.length), Integer.valueOf(this.spineIndex), Arrays.toString(array));
            }
            double[] array2 = Arrays.copyOf(array, 200);
            return String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(array.length), Integer.valueOf(this.spineIndex), Arrays.toString(array2));
        }
    }
}