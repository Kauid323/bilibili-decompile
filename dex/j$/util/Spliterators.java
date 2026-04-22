package j$.util;

import j$.util.Iterator;
import j$.util.PrimitiveIterator;
import j$.util.Spliterator;
import j$.util.function.Consumer$CC;
import j$.util.function.DoubleConsumer$CC;
import j$.util.function.IntConsumer$CC;
import j$.util.function.LongConsumer$CC;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

public final class Spliterators {
    private static final Spliterator<Object> EMPTY_SPLITERATOR = new EmptySpliterator.OfRef();
    private static final Spliterator.OfInt EMPTY_INT_SPLITERATOR = new EmptySpliterator.OfInt();
    private static final Spliterator.OfLong EMPTY_LONG_SPLITERATOR = new EmptySpliterator.OfLong();
    private static final Spliterator.OfDouble EMPTY_DOUBLE_SPLITERATOR = new EmptySpliterator.OfDouble();

    private Spliterators() {
    }

    public static <T> Spliterator<T> emptySpliterator() {
        return (Spliterator<T>) EMPTY_SPLITERATOR;
    }

    public static Spliterator.OfInt emptyIntSpliterator() {
        return EMPTY_INT_SPLITERATOR;
    }

    public static Spliterator.OfLong emptyLongSpliterator() {
        return EMPTY_LONG_SPLITERATOR;
    }

    public static Spliterator.OfDouble emptyDoubleSpliterator() {
        return EMPTY_DOUBLE_SPLITERATOR;
    }

    public static <T> Spliterator<T> spliterator(Object[] array, int additionalCharacteristics) {
        return new ArraySpliterator((Object[]) Objects.requireNonNull(array), additionalCharacteristics);
    }

    public static <T> Spliterator<T> spliterator(Object[] array, int fromIndex, int toIndex, int additionalCharacteristics) {
        checkFromToBounds(((Object[]) Objects.requireNonNull(array)).length, fromIndex, toIndex);
        return new ArraySpliterator(array, fromIndex, toIndex, additionalCharacteristics);
    }

    public static Spliterator.OfInt spliterator(int[] array, int additionalCharacteristics) {
        return new IntArraySpliterator((int[]) Objects.requireNonNull(array), additionalCharacteristics);
    }

    public static Spliterator.OfInt spliterator(int[] array, int fromIndex, int toIndex, int additionalCharacteristics) {
        checkFromToBounds(((int[]) Objects.requireNonNull(array)).length, fromIndex, toIndex);
        return new IntArraySpliterator(array, fromIndex, toIndex, additionalCharacteristics);
    }

    public static Spliterator.OfLong spliterator(long[] array, int additionalCharacteristics) {
        return new LongArraySpliterator((long[]) Objects.requireNonNull(array), additionalCharacteristics);
    }

    public static Spliterator.OfLong spliterator(long[] array, int fromIndex, int toIndex, int additionalCharacteristics) {
        checkFromToBounds(((long[]) Objects.requireNonNull(array)).length, fromIndex, toIndex);
        return new LongArraySpliterator(array, fromIndex, toIndex, additionalCharacteristics);
    }

    public static Spliterator.OfDouble spliterator(double[] array, int additionalCharacteristics) {
        return new DoubleArraySpliterator((double[]) Objects.requireNonNull(array), additionalCharacteristics);
    }

    public static Spliterator.OfDouble spliterator(double[] array, int fromIndex, int toIndex, int additionalCharacteristics) {
        checkFromToBounds(((double[]) Objects.requireNonNull(array)).length, fromIndex, toIndex);
        return new DoubleArraySpliterator(array, fromIndex, toIndex, additionalCharacteristics);
    }

    private static void checkFromToBounds(int arrayLength, int origin, int fence) {
        if (origin > fence) {
            throw new ArrayIndexOutOfBoundsException("origin(" + origin + ") > fence(" + fence + ")");
        }
        if (origin < 0) {
            throw new ArrayIndexOutOfBoundsException(origin);
        }
        if (fence > arrayLength) {
            throw new ArrayIndexOutOfBoundsException(fence);
        }
    }

    public static <T> Spliterator<T> spliterator(java.util.Collection<? extends T> c, int characteristics) {
        return new IteratorSpliterator((java.util.Collection) Objects.requireNonNull(c), characteristics);
    }

    public static <T> Spliterator<T> spliterator(java.util.Iterator<? extends T> iterator, long size, int characteristics) {
        return new IteratorSpliterator((java.util.Iterator) Objects.requireNonNull(iterator), size, characteristics);
    }

    public static <T> Spliterator<T> spliteratorUnknownSize(java.util.Iterator<? extends T> iterator, int characteristics) {
        return new IteratorSpliterator((java.util.Iterator) Objects.requireNonNull(iterator), characteristics);
    }

    public static Spliterator.OfInt spliterator(PrimitiveIterator.OfInt iterator, long size, int characteristics) {
        return new IntIteratorSpliterator((PrimitiveIterator.OfInt) Objects.requireNonNull(iterator), size, characteristics);
    }

    public static Spliterator.OfInt spliteratorUnknownSize(PrimitiveIterator.OfInt iterator, int characteristics) {
        return new IntIteratorSpliterator((PrimitiveIterator.OfInt) Objects.requireNonNull(iterator), characteristics);
    }

    public static Spliterator.OfLong spliterator(PrimitiveIterator.OfLong iterator, long size, int characteristics) {
        return new LongIteratorSpliterator((PrimitiveIterator.OfLong) Objects.requireNonNull(iterator), size, characteristics);
    }

    public static Spliterator.OfLong spliteratorUnknownSize(PrimitiveIterator.OfLong iterator, int characteristics) {
        return new LongIteratorSpliterator((PrimitiveIterator.OfLong) Objects.requireNonNull(iterator), characteristics);
    }

    public static Spliterator.OfDouble spliterator(PrimitiveIterator.OfDouble iterator, long size, int characteristics) {
        return new DoubleIteratorSpliterator((PrimitiveIterator.OfDouble) Objects.requireNonNull(iterator), size, characteristics);
    }

    public static Spliterator.OfDouble spliteratorUnknownSize(PrimitiveIterator.OfDouble iterator, int characteristics) {
        return new DoubleIteratorSpliterator((PrimitiveIterator.OfDouble) Objects.requireNonNull(iterator), characteristics);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: j$.util.Spliterators$1Adapter  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    class C1Adapter<T> implements java.util.Iterator<T>, Consumer<T> {
        T nextElement;
        final /* synthetic */ Spliterator val$spliterator;
        boolean valueReady = false;

        @Override // java.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer$CC.$default$andThen(this, consumer);
        }

        C1Adapter(Spliterator spliterator) {
            this.val$spliterator = spliterator;
        }

        @Override // java.util.function.Consumer
        public void accept(T t) {
            this.valueReady = true;
            this.nextElement = t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.valueReady) {
                this.val$spliterator.tryAdvance(this);
            }
            return this.valueReady;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.valueReady && !hasNext()) {
                throw new NoSuchElementException();
            }
            this.valueReady = false;
            return this.nextElement;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<? extends T> */
    public static <T> java.util.Iterator<T> iterator(Spliterator<? extends T> spliterator) {
        Objects.requireNonNull(spliterator);
        return new C1Adapter(spliterator);
    }

    /* renamed from: j$.util.Spliterators$2Adapter  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    class C2Adapter implements PrimitiveIterator.OfInt, IntConsumer, Iterator {
        int nextElement;
        final /* synthetic */ Spliterator.OfInt val$spliterator;
        boolean valueReady = false;

        @Override // java.util.function.IntConsumer
        public /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
            return IntConsumer$CC.$default$andThen(this, intConsumer);
        }

        @Override // j$.util.PrimitiveIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
            PrimitiveIterator.OfInt.CC.$default$forEachRemaining((PrimitiveIterator.OfInt) this, (Object) intConsumer);
        }

        @Override // j$.util.PrimitiveIterator.OfInt, java.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            PrimitiveIterator.OfInt.CC.$default$forEachRemaining((PrimitiveIterator.OfInt) this, consumer);
        }

        @Override // j$.util.PrimitiveIterator.OfInt
        /* renamed from: forEachRemaining  reason: avoid collision after fix types in other method */
        public /* synthetic */ void forEachRemaining2(IntConsumer intConsumer) {
            PrimitiveIterator.OfInt.CC.$default$forEachRemaining((PrimitiveIterator.OfInt) this, intConsumer);
        }

        @Override // j$.util.PrimitiveIterator.OfInt, java.util.Iterator
        public /* synthetic */ Integer next() {
            return PrimitiveIterator.OfInt.CC.$default$next((PrimitiveIterator.OfInt) this);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return PrimitiveIterator.OfInt.CC.m44$default$next((PrimitiveIterator.OfInt) this);
        }

        C2Adapter(Spliterator.OfInt ofInt) {
            this.val$spliterator = ofInt;
        }

        @Override // java.util.function.IntConsumer
        public void accept(int t) {
            this.valueReady = true;
            this.nextElement = t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.valueReady) {
                this.val$spliterator.tryAdvance((IntConsumer) this);
            }
            return this.valueReady;
        }

        @Override // j$.util.PrimitiveIterator.OfInt
        public int nextInt() {
            if (!this.valueReady && !hasNext()) {
                throw new NoSuchElementException();
            }
            this.valueReady = false;
            return this.nextElement;
        }
    }

    public static PrimitiveIterator.OfInt iterator(Spliterator.OfInt spliterator) {
        Objects.requireNonNull(spliterator);
        return new C2Adapter(spliterator);
    }

    /* renamed from: j$.util.Spliterators$3Adapter  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    class C3Adapter implements PrimitiveIterator.OfLong, LongConsumer, Iterator {
        long nextElement;
        final /* synthetic */ Spliterator.OfLong val$spliterator;
        boolean valueReady = false;

        @Override // java.util.function.LongConsumer
        public /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
            return LongConsumer$CC.$default$andThen(this, longConsumer);
        }

        @Override // j$.util.PrimitiveIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
            PrimitiveIterator.OfLong.CC.$default$forEachRemaining((PrimitiveIterator.OfLong) this, (Object) longConsumer);
        }

        @Override // j$.util.PrimitiveIterator.OfLong, java.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            PrimitiveIterator.OfLong.CC.$default$forEachRemaining((PrimitiveIterator.OfLong) this, consumer);
        }

        @Override // j$.util.PrimitiveIterator.OfLong
        /* renamed from: forEachRemaining  reason: avoid collision after fix types in other method */
        public /* synthetic */ void forEachRemaining2(LongConsumer longConsumer) {
            PrimitiveIterator.OfLong.CC.$default$forEachRemaining((PrimitiveIterator.OfLong) this, longConsumer);
        }

        @Override // j$.util.PrimitiveIterator.OfLong, java.util.Iterator
        public /* synthetic */ Long next() {
            return PrimitiveIterator.OfLong.CC.$default$next((PrimitiveIterator.OfLong) this);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return PrimitiveIterator.OfLong.CC.m45$default$next((PrimitiveIterator.OfLong) this);
        }

        C3Adapter(Spliterator.OfLong ofLong) {
            this.val$spliterator = ofLong;
        }

        @Override // java.util.function.LongConsumer
        public void accept(long t) {
            this.valueReady = true;
            this.nextElement = t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.valueReady) {
                this.val$spliterator.tryAdvance((LongConsumer) this);
            }
            return this.valueReady;
        }

        @Override // j$.util.PrimitiveIterator.OfLong
        public long nextLong() {
            if (!this.valueReady && !hasNext()) {
                throw new NoSuchElementException();
            }
            this.valueReady = false;
            return this.nextElement;
        }
    }

    public static PrimitiveIterator.OfLong iterator(Spliterator.OfLong spliterator) {
        Objects.requireNonNull(spliterator);
        return new C3Adapter(spliterator);
    }

    /* renamed from: j$.util.Spliterators$4Adapter  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    class C4Adapter implements PrimitiveIterator.OfDouble, DoubleConsumer, Iterator {
        double nextElement;
        final /* synthetic */ Spliterator.OfDouble val$spliterator;
        boolean valueReady = false;

        @Override // java.util.function.DoubleConsumer
        public /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
            return DoubleConsumer$CC.$default$andThen(this, doubleConsumer);
        }

        @Override // j$.util.PrimitiveIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
            PrimitiveIterator.OfDouble.CC.$default$forEachRemaining((PrimitiveIterator.OfDouble) this, (Object) doubleConsumer);
        }

        @Override // j$.util.PrimitiveIterator.OfDouble, java.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            PrimitiveIterator.OfDouble.CC.$default$forEachRemaining((PrimitiveIterator.OfDouble) this, consumer);
        }

        @Override // j$.util.PrimitiveIterator.OfDouble
        /* renamed from: forEachRemaining  reason: avoid collision after fix types in other method */
        public /* synthetic */ void forEachRemaining2(DoubleConsumer doubleConsumer) {
            PrimitiveIterator.OfDouble.CC.$default$forEachRemaining((PrimitiveIterator.OfDouble) this, doubleConsumer);
        }

        @Override // j$.util.PrimitiveIterator.OfDouble, java.util.Iterator
        public /* synthetic */ Double next() {
            return PrimitiveIterator.OfDouble.CC.$default$next((PrimitiveIterator.OfDouble) this);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return PrimitiveIterator.OfDouble.CC.m43$default$next((PrimitiveIterator.OfDouble) this);
        }

        C4Adapter(Spliterator.OfDouble ofDouble) {
            this.val$spliterator = ofDouble;
        }

        @Override // java.util.function.DoubleConsumer
        public void accept(double t) {
            this.valueReady = true;
            this.nextElement = t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.valueReady) {
                this.val$spliterator.tryAdvance((DoubleConsumer) this);
            }
            return this.valueReady;
        }

        @Override // j$.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            if (!this.valueReady && !hasNext()) {
                throw new NoSuchElementException();
            }
            this.valueReady = false;
            return this.nextElement;
        }
    }

    public static PrimitiveIterator.OfDouble iterator(Spliterator.OfDouble spliterator) {
        Objects.requireNonNull(spliterator);
        return new C4Adapter(spliterator);
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    private static abstract class EmptySpliterator<T, S extends Spliterator<T>, C> {
        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$EmptySpliterator != java.util.Spliterators$EmptySpliterator<T, S extends j$.util.Spliterator<T>, C> */
        EmptySpliterator() {
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$EmptySpliterator != java.util.Spliterators$EmptySpliterator<T, S extends j$.util.Spliterator<T>, C> */
        public S trySplit() {
            return null;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$EmptySpliterator != java.util.Spliterators$EmptySpliterator<T, S extends j$.util.Spliterator<T>, C> */
        public boolean tryAdvance(C consumer) {
            Objects.requireNonNull(consumer);
            return false;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$EmptySpliterator != java.util.Spliterators$EmptySpliterator<T, S extends j$.util.Spliterator<T>, C> */
        public void forEachRemaining(C consumer) {
            Objects.requireNonNull(consumer);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$EmptySpliterator != java.util.Spliterators$EmptySpliterator<T, S extends j$.util.Spliterator<T>, C> */
        public long estimateSize() {
            return 0L;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$EmptySpliterator != java.util.Spliterators$EmptySpliterator<T, S extends j$.util.Spliterator<T>, C> */
        public int characteristics() {
            return 16448;
        }

        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        private static final class OfRef<T> extends EmptySpliterator<T, Spliterator<T>, Consumer<? super T>> implements Spliterator<T> {
            @Override // j$.util.Spliterator
            public /* synthetic */ java.util.Comparator getComparator() {
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

            /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$EmptySpliterator$OfRef != java.util.Spliterators$EmptySpliterator$OfRef<T> */
            @Override // j$.util.Spliterator
            public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
                super.forEachRemaining((OfRef<T>) consumer);
            }

            /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$EmptySpliterator$OfRef != java.util.Spliterators$EmptySpliterator$OfRef<T> */
            @Override // j$.util.Spliterator
            public /* bridge */ /* synthetic */ boolean tryAdvance(Consumer consumer) {
                return super.tryAdvance((OfRef<T>) consumer);
            }

            /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$EmptySpliterator$OfRef != java.util.Spliterators$EmptySpliterator$OfRef<T> */
            OfRef() {
            }
        }

        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        private static final class OfInt extends EmptySpliterator<Integer, Spliterator.OfInt, IntConsumer> implements Spliterator.OfInt {
            @Override // j$.util.Spliterator.OfInt, j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Spliterator.OfInt.CC.$default$forEachRemaining((Spliterator.OfInt) this, consumer);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ java.util.Comparator getComparator() {
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

            @Override // j$.util.Spliterator.OfInt, j$.util.Spliterator
            public /* synthetic */ boolean tryAdvance(Consumer consumer) {
                return Spliterator.OfInt.CC.$default$tryAdvance((Spliterator.OfInt) this, consumer);
            }

            @Override // j$.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
                super.forEachRemaining((OfInt) intConsumer);
            }

            @Override // j$.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
                return super.tryAdvance((OfInt) intConsumer);
            }

            @Override // j$.util.Spliterators.EmptySpliterator, j$.util.Spliterator.OfDouble, j$.util.Spliterator.OfPrimitive, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfInt trySplit() {
                return (Spliterator.OfInt) super.trySplit();
            }

            @Override // j$.util.Spliterators.EmptySpliterator, j$.util.Spliterator.OfDouble, j$.util.Spliterator.OfPrimitive, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
                return (Spliterator.OfPrimitive) super.trySplit();
            }

            OfInt() {
            }
        }

        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        private static final class OfLong extends EmptySpliterator<Long, Spliterator.OfLong, LongConsumer> implements Spliterator.OfLong {
            @Override // j$.util.Spliterator.OfLong, j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Spliterator.OfLong.CC.$default$forEachRemaining((Spliterator.OfLong) this, consumer);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ java.util.Comparator getComparator() {
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

            @Override // j$.util.Spliterator.OfLong, j$.util.Spliterator
            public /* synthetic */ boolean tryAdvance(Consumer consumer) {
                return Spliterator.OfLong.CC.$default$tryAdvance((Spliterator.OfLong) this, consumer);
            }

            @Override // j$.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
                super.forEachRemaining((OfLong) longConsumer);
            }

            @Override // j$.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
                return super.tryAdvance((OfLong) longConsumer);
            }

            @Override // j$.util.Spliterators.EmptySpliterator, j$.util.Spliterator.OfDouble, j$.util.Spliterator.OfPrimitive, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfLong trySplit() {
                return (Spliterator.OfLong) super.trySplit();
            }

            @Override // j$.util.Spliterators.EmptySpliterator, j$.util.Spliterator.OfDouble, j$.util.Spliterator.OfPrimitive, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
                return (Spliterator.OfPrimitive) super.trySplit();
            }

            OfLong() {
            }
        }

        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        private static final class OfDouble extends EmptySpliterator<Double, Spliterator.OfDouble, DoubleConsumer> implements Spliterator.OfDouble {
            @Override // j$.util.Spliterator.OfDouble, j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Spliterator.OfDouble.CC.$default$forEachRemaining((Spliterator.OfDouble) this, consumer);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ java.util.Comparator getComparator() {
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

            @Override // j$.util.Spliterator.OfDouble, j$.util.Spliterator
            public /* synthetic */ boolean tryAdvance(Consumer consumer) {
                return Spliterator.OfDouble.CC.$default$tryAdvance((Spliterator.OfDouble) this, consumer);
            }

            @Override // j$.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
                super.forEachRemaining((OfDouble) doubleConsumer);
            }

            @Override // j$.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
                return super.tryAdvance((OfDouble) doubleConsumer);
            }

            @Override // j$.util.Spliterators.EmptySpliterator, j$.util.Spliterator.OfDouble, j$.util.Spliterator.OfPrimitive, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfDouble trySplit() {
                return (Spliterator.OfDouble) super.trySplit();
            }

            @Override // j$.util.Spliterators.EmptySpliterator, j$.util.Spliterator.OfDouble, j$.util.Spliterator.OfPrimitive, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
                return (Spliterator.OfPrimitive) super.trySplit();
            }

            OfDouble() {
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class ArraySpliterator<T> implements Spliterator<T> {
        private final Object[] array;
        private final int characteristics;
        private final int fence;
        private int index;

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return Spliterator.CC.$default$getExactSizeIfKnown(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Spliterator.CC.$default$hasCharacteristics(this, i);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$ArraySpliterator != java.util.Spliterators$ArraySpliterator<T> */
        public ArraySpliterator(Object[] array, int additionalCharacteristics) {
            this(array, 0, array.length, additionalCharacteristics);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$ArraySpliterator != java.util.Spliterators$ArraySpliterator<T> */
        public ArraySpliterator(Object[] array, int origin, int fence, int additionalCharacteristics) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.characteristics = additionalCharacteristics | 64 | Spliterator.SUBSIZED;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$ArraySpliterator != java.util.Spliterators$ArraySpliterator<T> */
        @Override // j$.util.Spliterator
        public Spliterator<T> trySplit() {
            int lo = this.index;
            int mid = (this.fence + lo) >>> 1;
            if (lo >= mid) {
                return null;
            }
            Object[] objArr = this.array;
            this.index = mid;
            return new ArraySpliterator(objArr, lo, mid, this.characteristics);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$ArraySpliterator != java.util.Spliterators$ArraySpliterator<T> */
        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer<? super T> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            Object[] a = this.array;
            int length = a.length;
            int hi = this.fence;
            if (length >= hi) {
                int i = this.index;
                int i2 = i;
                if (i >= 0) {
                    this.index = hi;
                    if (i2 < hi) {
                        do {
                            action.accept(a[i2]);
                            i2++;
                        } while (i2 < hi);
                    }
                }
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$ArraySpliterator != java.util.Spliterators$ArraySpliterator<T> */
        @Override // j$.util.Spliterator
        public boolean tryAdvance(Consumer<? super T> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            if (this.index >= 0 && this.index < this.fence) {
                Object[] objArr = this.array;
                int i = this.index;
                this.index = i + 1;
                action.accept(objArr[i]);
                return true;
            }
            return false;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$ArraySpliterator != java.util.Spliterators$ArraySpliterator<T> */
        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$ArraySpliterator != java.util.Spliterators$ArraySpliterator<T> */
        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$ArraySpliterator != java.util.Spliterators$ArraySpliterator<T> */
        @Override // j$.util.Spliterator
        public java.util.Comparator<? super T> getComparator() {
            if (hasCharacteristics(4)) {
                return null;
            }
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static final class IntArraySpliterator implements Spliterator.OfInt {
        private final int[] array;
        private final int characteristics;
        private final int fence;
        private int index;

        @Override // j$.util.Spliterator.OfInt, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Spliterator.OfInt.CC.$default$forEachRemaining((Spliterator.OfInt) this, consumer);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return Spliterator.CC.$default$getExactSizeIfKnown(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Spliterator.CC.$default$hasCharacteristics(this, i);
        }

        @Override // j$.util.Spliterator.OfInt, j$.util.Spliterator
        public /* synthetic */ boolean tryAdvance(Consumer consumer) {
            return Spliterator.OfInt.CC.$default$tryAdvance((Spliterator.OfInt) this, consumer);
        }

        public IntArraySpliterator(int[] array, int additionalCharacteristics) {
            this(array, 0, array.length, additionalCharacteristics);
        }

        public IntArraySpliterator(int[] array, int origin, int fence, int additionalCharacteristics) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.characteristics = additionalCharacteristics | 64 | Spliterator.SUBSIZED;
        }

        @Override // j$.util.Spliterator
        public Spliterator.OfInt trySplit() {
            int lo = this.index;
            int mid = (this.fence + lo) >>> 1;
            if (lo >= mid) {
                return null;
            }
            int[] iArr = this.array;
            this.index = mid;
            return new IntArraySpliterator(iArr, lo, mid, this.characteristics);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        public void forEachRemaining(IntConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            int[] a = this.array;
            int length = a.length;
            int hi = this.fence;
            if (length >= hi) {
                int i = this.index;
                int i2 = i;
                if (i >= 0) {
                    this.index = hi;
                    if (i2 < hi) {
                        do {
                            action.accept(a[i2]);
                            i2++;
                        } while (i2 < hi);
                    }
                }
            }
        }

        @Override // j$.util.Spliterator.OfPrimitive
        public boolean tryAdvance(IntConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            if (this.index >= 0 && this.index < this.fence) {
                int[] iArr = this.array;
                int i = this.index;
                this.index = i + 1;
                action.accept(iArr[i]);
                return true;
            }
            return false;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // j$.util.Spliterator
        public java.util.Comparator<? super Integer> getComparator() {
            if (hasCharacteristics(4)) {
                return null;
            }
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static final class LongArraySpliterator implements Spliterator.OfLong {
        private final long[] array;
        private final int characteristics;
        private final int fence;
        private int index;

        @Override // j$.util.Spliterator.OfLong, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Spliterator.OfLong.CC.$default$forEachRemaining((Spliterator.OfLong) this, consumer);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return Spliterator.CC.$default$getExactSizeIfKnown(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Spliterator.CC.$default$hasCharacteristics(this, i);
        }

        @Override // j$.util.Spliterator.OfLong, j$.util.Spliterator
        public /* synthetic */ boolean tryAdvance(Consumer consumer) {
            return Spliterator.OfLong.CC.$default$tryAdvance((Spliterator.OfLong) this, consumer);
        }

        public LongArraySpliterator(long[] array, int additionalCharacteristics) {
            this(array, 0, array.length, additionalCharacteristics);
        }

        public LongArraySpliterator(long[] array, int origin, int fence, int additionalCharacteristics) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.characteristics = additionalCharacteristics | 64 | Spliterator.SUBSIZED;
        }

        @Override // j$.util.Spliterator
        public Spliterator.OfLong trySplit() {
            int lo = this.index;
            int mid = (this.fence + lo) >>> 1;
            if (lo >= mid) {
                return null;
            }
            long[] jArr = this.array;
            this.index = mid;
            return new LongArraySpliterator(jArr, lo, mid, this.characteristics);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        public void forEachRemaining(LongConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            long[] a = this.array;
            int length = a.length;
            int hi = this.fence;
            if (length >= hi) {
                int i = this.index;
                int i2 = i;
                if (i >= 0) {
                    this.index = hi;
                    if (i2 < hi) {
                        do {
                            action.accept(a[i2]);
                            i2++;
                        } while (i2 < hi);
                    }
                }
            }
        }

        @Override // j$.util.Spliterator.OfPrimitive
        public boolean tryAdvance(LongConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            if (this.index >= 0 && this.index < this.fence) {
                long[] jArr = this.array;
                int i = this.index;
                this.index = i + 1;
                action.accept(jArr[i]);
                return true;
            }
            return false;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // j$.util.Spliterator
        public java.util.Comparator<? super Long> getComparator() {
            if (hasCharacteristics(4)) {
                return null;
            }
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static final class DoubleArraySpliterator implements Spliterator.OfDouble {
        private final double[] array;
        private final int characteristics;
        private final int fence;
        private int index;

        @Override // j$.util.Spliterator.OfDouble, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Spliterator.OfDouble.CC.$default$forEachRemaining((Spliterator.OfDouble) this, consumer);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return Spliterator.CC.$default$getExactSizeIfKnown(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Spliterator.CC.$default$hasCharacteristics(this, i);
        }

        @Override // j$.util.Spliterator.OfDouble, j$.util.Spliterator
        public /* synthetic */ boolean tryAdvance(Consumer consumer) {
            return Spliterator.OfDouble.CC.$default$tryAdvance((Spliterator.OfDouble) this, consumer);
        }

        public DoubleArraySpliterator(double[] array, int additionalCharacteristics) {
            this(array, 0, array.length, additionalCharacteristics);
        }

        public DoubleArraySpliterator(double[] array, int origin, int fence, int additionalCharacteristics) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.characteristics = additionalCharacteristics | 64 | Spliterator.SUBSIZED;
        }

        @Override // j$.util.Spliterator
        public Spliterator.OfDouble trySplit() {
            int lo = this.index;
            int mid = (this.fence + lo) >>> 1;
            if (lo >= mid) {
                return null;
            }
            double[] dArr = this.array;
            this.index = mid;
            return new DoubleArraySpliterator(dArr, lo, mid, this.characteristics);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        public void forEachRemaining(DoubleConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            double[] a = this.array;
            int length = a.length;
            int hi = this.fence;
            if (length >= hi) {
                int i = this.index;
                int i2 = i;
                if (i >= 0) {
                    this.index = hi;
                    if (i2 < hi) {
                        do {
                            action.accept(a[i2]);
                            i2++;
                        } while (i2 < hi);
                    }
                }
            }
        }

        @Override // j$.util.Spliterator.OfPrimitive
        public boolean tryAdvance(DoubleConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            if (this.index >= 0 && this.index < this.fence) {
                double[] dArr = this.array;
                int i = this.index;
                this.index = i + 1;
                action.accept(dArr[i]);
                return true;
            }
            return false;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // j$.util.Spliterator
        public java.util.Comparator<? super Double> getComparator() {
            if (hasCharacteristics(4)) {
                return null;
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static abstract class AbstractSpliterator<T> implements Spliterator<T> {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private int batch;
        private final int characteristics;
        private long est;

        @Override // j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Spliterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ java.util.Comparator getComparator() {
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

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$AbstractSpliterator != java.util.Spliterators$AbstractSpliterator<T> */
        public AbstractSpliterator(long est, int additionalCharacteristics) {
            int i;
            this.est = est;
            if ((additionalCharacteristics & 64) != 0) {
                i = additionalCharacteristics | Spliterator.SUBSIZED;
            } else {
                i = additionalCharacteristics;
            }
            this.characteristics = i;
        }

        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        static final class HoldingConsumer<T> implements Consumer<T> {
            Object value;

            @Override // java.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer$CC.$default$andThen(this, consumer);
            }

            /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$AbstractSpliterator$HoldingConsumer != java.util.Spliterators$AbstractSpliterator$HoldingConsumer<T> */
            HoldingConsumer() {
            }

            /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$AbstractSpliterator$HoldingConsumer != java.util.Spliterators$AbstractSpliterator$HoldingConsumer<T> */
            @Override // java.util.function.Consumer
            public void accept(T value) {
                this.value = value;
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$AbstractSpliterator != java.util.Spliterators$AbstractSpliterator<T> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$AbstractSpliterator$HoldingConsumer != java.util.Spliterators$AbstractSpliterator$HoldingConsumer<T> */
        @Override // j$.util.Spliterator
        public Spliterator<T> trySplit() {
            HoldingConsumer holdingConsumer = new HoldingConsumer();
            long s = this.est;
            if (s > 1 && tryAdvance(holdingConsumer)) {
                int n = this.batch + 1024;
                if (n > s) {
                    n = (int) s;
                }
                if (n > MAX_BATCH) {
                    n = MAX_BATCH;
                }
                Object[] a = new Object[n];
                int j = 0;
                do {
                    a[j] = holdingConsumer.value;
                    j++;
                    if (j >= n) {
                        break;
                    }
                } while (tryAdvance(holdingConsumer));
                this.batch = j;
                if (this.est != Long.MAX_VALUE) {
                    this.est -= j;
                }
                return new ArraySpliterator(a, 0, j, characteristics());
            }
            return null;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$AbstractSpliterator != java.util.Spliterators$AbstractSpliterator<T> */
        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$AbstractSpliterator != java.util.Spliterators$AbstractSpliterator<T> */
        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static abstract class AbstractIntSpliterator implements Spliterator.OfInt {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private int batch;
        private final int characteristics;
        private long est;

        @Override // j$.util.Spliterator.OfPrimitive
        public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
            forEachRemaining((IntConsumer) intConsumer);
        }

        @Override // j$.util.Spliterator.OfInt, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Spliterator.OfInt.CC.$default$forEachRemaining((Spliterator.OfInt) this, consumer);
        }

        @Override // j$.util.Spliterator.OfInt
        /* renamed from: forEachRemaining  reason: avoid collision after fix types in other method */
        public /* synthetic */ void forEachRemaining2(IntConsumer intConsumer) {
            Spliterator.OfInt.CC.$default$forEachRemaining((Spliterator.OfInt) this, intConsumer);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ java.util.Comparator getComparator() {
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

        @Override // j$.util.Spliterator.OfPrimitive
        public /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
            boolean tryAdvance;
            tryAdvance = tryAdvance((IntConsumer) intConsumer);
            return tryAdvance;
        }

        @Override // j$.util.Spliterator.OfInt, j$.util.Spliterator
        public /* synthetic */ boolean tryAdvance(Consumer consumer) {
            return Spliterator.OfInt.CC.$default$tryAdvance((Spliterator.OfInt) this, consumer);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public AbstractIntSpliterator(long est, int additionalCharacteristics) {
            int i;
            this.est = est;
            if ((additionalCharacteristics & 64) != 0) {
                i = additionalCharacteristics | Spliterator.SUBSIZED;
            } else {
                i = additionalCharacteristics;
            }
            this.characteristics = i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public static final class HoldingIntConsumer implements IntConsumer {
            int value;

            @Override // java.util.function.IntConsumer
            public /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
                return IntConsumer$CC.$default$andThen(this, intConsumer);
            }

            HoldingIntConsumer() {
            }

            @Override // java.util.function.IntConsumer
            public void accept(int value) {
                this.value = value;
            }
        }

        @Override // j$.util.Spliterator
        public Spliterator.OfInt trySplit() {
            HoldingIntConsumer holder = new HoldingIntConsumer();
            long s = this.est;
            if (s > 1 && tryAdvance((IntConsumer) holder)) {
                int n = this.batch + 1024;
                if (n > s) {
                    n = (int) s;
                }
                if (n > MAX_BATCH) {
                    n = MAX_BATCH;
                }
                int[] a = new int[n];
                int j = 0;
                do {
                    a[j] = holder.value;
                    j++;
                    if (j >= n) {
                        break;
                    }
                } while (tryAdvance((IntConsumer) holder));
                this.batch = j;
                if (this.est != Long.MAX_VALUE) {
                    this.est -= j;
                }
                return new IntArraySpliterator(a, 0, j, characteristics());
            }
            return null;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static abstract class AbstractLongSpliterator implements Spliterator.OfLong {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private int batch;
        private final int characteristics;
        private long est;

        @Override // j$.util.Spliterator.OfPrimitive
        public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
            forEachRemaining((LongConsumer) longConsumer);
        }

        @Override // j$.util.Spliterator.OfLong, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Spliterator.OfLong.CC.$default$forEachRemaining((Spliterator.OfLong) this, consumer);
        }

        @Override // j$.util.Spliterator.OfLong
        /* renamed from: forEachRemaining  reason: avoid collision after fix types in other method */
        public /* synthetic */ void forEachRemaining2(LongConsumer longConsumer) {
            Spliterator.OfLong.CC.$default$forEachRemaining((Spliterator.OfLong) this, longConsumer);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ java.util.Comparator getComparator() {
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

        @Override // j$.util.Spliterator.OfPrimitive
        public /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
            boolean tryAdvance;
            tryAdvance = tryAdvance((LongConsumer) longConsumer);
            return tryAdvance;
        }

        @Override // j$.util.Spliterator.OfLong, j$.util.Spliterator
        public /* synthetic */ boolean tryAdvance(Consumer consumer) {
            return Spliterator.OfLong.CC.$default$tryAdvance((Spliterator.OfLong) this, consumer);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public AbstractLongSpliterator(long est, int additionalCharacteristics) {
            int i;
            this.est = est;
            if ((additionalCharacteristics & 64) != 0) {
                i = additionalCharacteristics | Spliterator.SUBSIZED;
            } else {
                i = additionalCharacteristics;
            }
            this.characteristics = i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public static final class HoldingLongConsumer implements LongConsumer {
            long value;

            @Override // java.util.function.LongConsumer
            public /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
                return LongConsumer$CC.$default$andThen(this, longConsumer);
            }

            HoldingLongConsumer() {
            }

            @Override // java.util.function.LongConsumer
            public void accept(long value) {
                this.value = value;
            }
        }

        @Override // j$.util.Spliterator
        public Spliterator.OfLong trySplit() {
            HoldingLongConsumer holder = new HoldingLongConsumer();
            long s = this.est;
            if (s > 1 && tryAdvance((LongConsumer) holder)) {
                int n = this.batch + 1024;
                if (n > s) {
                    n = (int) s;
                }
                if (n > MAX_BATCH) {
                    n = MAX_BATCH;
                }
                long[] a = new long[n];
                int j = 0;
                do {
                    a[j] = holder.value;
                    j++;
                    if (j >= n) {
                        break;
                    }
                } while (tryAdvance((LongConsumer) holder));
                this.batch = j;
                if (this.est != Long.MAX_VALUE) {
                    this.est -= j;
                }
                return new LongArraySpliterator(a, 0, j, characteristics());
            }
            return null;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static abstract class AbstractDoubleSpliterator implements Spliterator.OfDouble {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private int batch;
        private final int characteristics;
        private long est;

        @Override // j$.util.Spliterator.OfPrimitive
        public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
            forEachRemaining((DoubleConsumer) doubleConsumer);
        }

        @Override // j$.util.Spliterator.OfDouble, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Spliterator.OfDouble.CC.$default$forEachRemaining((Spliterator.OfDouble) this, consumer);
        }

        @Override // j$.util.Spliterator.OfDouble
        /* renamed from: forEachRemaining  reason: avoid collision after fix types in other method */
        public /* synthetic */ void forEachRemaining2(DoubleConsumer doubleConsumer) {
            Spliterator.OfDouble.CC.$default$forEachRemaining((Spliterator.OfDouble) this, doubleConsumer);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ java.util.Comparator getComparator() {
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

        @Override // j$.util.Spliterator.OfPrimitive
        public /* bridge */ /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
            boolean tryAdvance;
            tryAdvance = tryAdvance((DoubleConsumer) doubleConsumer);
            return tryAdvance;
        }

        @Override // j$.util.Spliterator.OfDouble, j$.util.Spliterator
        public /* synthetic */ boolean tryAdvance(Consumer consumer) {
            return Spliterator.OfDouble.CC.$default$tryAdvance((Spliterator.OfDouble) this, consumer);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public AbstractDoubleSpliterator(long est, int additionalCharacteristics) {
            int i;
            this.est = est;
            if ((additionalCharacteristics & 64) != 0) {
                i = additionalCharacteristics | Spliterator.SUBSIZED;
            } else {
                i = additionalCharacteristics;
            }
            this.characteristics = i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public static final class HoldingDoubleConsumer implements DoubleConsumer {
            double value;

            @Override // java.util.function.DoubleConsumer
            public /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
                return DoubleConsumer$CC.$default$andThen(this, doubleConsumer);
            }

            HoldingDoubleConsumer() {
            }

            @Override // java.util.function.DoubleConsumer
            public void accept(double value) {
                this.value = value;
            }
        }

        @Override // j$.util.Spliterator
        public Spliterator.OfDouble trySplit() {
            HoldingDoubleConsumer holder = new HoldingDoubleConsumer();
            long s = this.est;
            if (s > 1 && tryAdvance((DoubleConsumer) holder)) {
                int n = this.batch + 1024;
                if (n > s) {
                    n = (int) s;
                }
                if (n > MAX_BATCH) {
                    n = MAX_BATCH;
                }
                double[] a = new double[n];
                int j = 0;
                do {
                    a[j] = holder.value;
                    j++;
                    if (j >= n) {
                        break;
                    }
                } while (tryAdvance((DoubleConsumer) holder));
                this.batch = j;
                if (this.est != Long.MAX_VALUE) {
                    this.est -= j;
                }
                return new DoubleArraySpliterator(a, 0, j, characteristics());
            }
            return null;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static class IteratorSpliterator<T> implements Spliterator<T> {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private int batch;
        private final int characteristics;
        private final java.util.Collection<? extends T> collection;
        private long est;
        private java.util.Iterator<? extends T> it;

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return Spliterator.CC.$default$getExactSizeIfKnown(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Spliterator.CC.$default$hasCharacteristics(this, i);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$IteratorSpliterator != java.util.Spliterators$IteratorSpliterator<T> */
        public IteratorSpliterator(java.util.Collection<? extends T> collection, int characteristics) {
            int i;
            this.collection = collection;
            this.it = null;
            if ((characteristics & Spliterator.CONCURRENT) == 0) {
                i = characteristics | 64 | Spliterator.SUBSIZED;
            } else {
                i = characteristics;
            }
            this.characteristics = i;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$IteratorSpliterator != java.util.Spliterators$IteratorSpliterator<T> */
        public IteratorSpliterator(java.util.Iterator<? extends T> iterator, long size, int characteristics) {
            int i;
            this.collection = null;
            this.it = iterator;
            this.est = size;
            if ((characteristics & Spliterator.CONCURRENT) == 0) {
                i = characteristics | 64 | Spliterator.SUBSIZED;
            } else {
                i = characteristics;
            }
            this.characteristics = i;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$IteratorSpliterator != java.util.Spliterators$IteratorSpliterator<T> */
        public IteratorSpliterator(java.util.Iterator<? extends T> iterator, int characteristics) {
            this.collection = null;
            this.it = iterator;
            this.est = Long.MAX_VALUE;
            this.characteristics = characteristics & (-16449);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$IteratorSpliterator != java.util.Spliterators$IteratorSpliterator<T> */
        @Override // j$.util.Spliterator
        public Spliterator<T> trySplit() {
            long s;
            java.util.Iterator<? extends T> it = this.it;
            java.util.Iterator<? extends T> i = it;
            if (it == null) {
                java.util.Iterator<? extends T> it2 = this.collection.iterator();
                this.it = it2;
                i = it2;
                s = this.collection.size();
                this.est = s;
            } else {
                s = this.est;
            }
            if (s > 1 && i.hasNext()) {
                int n = this.batch + 1024;
                if (n > s) {
                    n = (int) s;
                }
                if (n > MAX_BATCH) {
                    n = MAX_BATCH;
                }
                Object[] a = new Object[n];
                int j = 0;
                do {
                    a[j] = i.next();
                    j++;
                    if (j >= n) {
                        break;
                    }
                } while (i.hasNext());
                this.batch = j;
                if (this.est != Long.MAX_VALUE) {
                    this.est -= j;
                }
                return new ArraySpliterator(a, 0, j, this.characteristics);
            }
            return null;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$IteratorSpliterator != java.util.Spliterators$IteratorSpliterator<T> */
        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer<? super T> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            java.util.Iterator<? extends T> it = this.it;
            java.util.Iterator<? extends T> i = it;
            if (it == null) {
                java.util.Iterator<? extends T> it2 = this.collection.iterator();
                this.it = it2;
                i = it2;
                this.est = this.collection.size();
            }
            Iterator.EL.forEachRemaining(i, action);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$IteratorSpliterator != java.util.Spliterators$IteratorSpliterator<T> */
        @Override // j$.util.Spliterator
        public boolean tryAdvance(Consumer<? super T> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            if (this.it == null) {
                this.it = this.collection.iterator();
                this.est = this.collection.size();
            }
            if (this.it.hasNext()) {
                action.accept((T) this.it.next());
                return true;
            }
            return false;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$IteratorSpliterator != java.util.Spliterators$IteratorSpliterator<T> */
        @Override // j$.util.Spliterator
        public long estimateSize() {
            if (this.it == null) {
                this.it = this.collection.iterator();
                long size = this.collection.size();
                this.est = size;
                return size;
            }
            return this.est;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$IteratorSpliterator != java.util.Spliterators$IteratorSpliterator<T> */
        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterators$IteratorSpliterator != java.util.Spliterators$IteratorSpliterator<T> */
        @Override // j$.util.Spliterator
        public java.util.Comparator<? super T> getComparator() {
            if (hasCharacteristics(4)) {
                return null;
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class IntIteratorSpliterator implements Spliterator.OfInt {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private int batch;
        private final int characteristics;
        private long est;
        private PrimitiveIterator.OfInt it;

        @Override // j$.util.Spliterator.OfInt, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Spliterator.OfInt.CC.$default$forEachRemaining((Spliterator.OfInt) this, consumer);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return Spliterator.CC.$default$getExactSizeIfKnown(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Spliterator.CC.$default$hasCharacteristics(this, i);
        }

        @Override // j$.util.Spliterator.OfInt, j$.util.Spliterator
        public /* synthetic */ boolean tryAdvance(Consumer consumer) {
            return Spliterator.OfInt.CC.$default$tryAdvance((Spliterator.OfInt) this, consumer);
        }

        public IntIteratorSpliterator(PrimitiveIterator.OfInt iterator, long size, int characteristics) {
            int i;
            this.it = iterator;
            this.est = size;
            if ((characteristics & Spliterator.CONCURRENT) == 0) {
                i = characteristics | 64 | Spliterator.SUBSIZED;
            } else {
                i = characteristics;
            }
            this.characteristics = i;
        }

        public IntIteratorSpliterator(PrimitiveIterator.OfInt iterator, int characteristics) {
            this.it = iterator;
            this.est = Long.MAX_VALUE;
            this.characteristics = characteristics & (-16449);
        }

        @Override // j$.util.Spliterator
        public Spliterator.OfInt trySplit() {
            PrimitiveIterator.OfInt i = this.it;
            long s = this.est;
            if (s > 1 && i.hasNext()) {
                int n = this.batch + 1024;
                if (n > s) {
                    n = (int) s;
                }
                if (n > MAX_BATCH) {
                    n = MAX_BATCH;
                }
                int[] a = new int[n];
                int j = 0;
                do {
                    a[j] = i.nextInt();
                    j++;
                    if (j >= n) {
                        break;
                    }
                } while (i.hasNext());
                this.batch = j;
                if (this.est != Long.MAX_VALUE) {
                    this.est -= j;
                }
                return new IntArraySpliterator(a, 0, j, this.characteristics);
            }
            return null;
        }

        @Override // j$.util.Spliterator.OfPrimitive
        public void forEachRemaining(IntConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            this.it.forEachRemaining(action);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        public boolean tryAdvance(IntConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            if (this.it.hasNext()) {
                action.accept(this.it.nextInt());
                return true;
            }
            return false;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // j$.util.Spliterator
        public java.util.Comparator<? super Integer> getComparator() {
            if (hasCharacteristics(4)) {
                return null;
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class LongIteratorSpliterator implements Spliterator.OfLong {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private int batch;
        private final int characteristics;
        private long est;
        private PrimitiveIterator.OfLong it;

        @Override // j$.util.Spliterator.OfLong, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Spliterator.OfLong.CC.$default$forEachRemaining((Spliterator.OfLong) this, consumer);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return Spliterator.CC.$default$getExactSizeIfKnown(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Spliterator.CC.$default$hasCharacteristics(this, i);
        }

        @Override // j$.util.Spliterator.OfLong, j$.util.Spliterator
        public /* synthetic */ boolean tryAdvance(Consumer consumer) {
            return Spliterator.OfLong.CC.$default$tryAdvance((Spliterator.OfLong) this, consumer);
        }

        public LongIteratorSpliterator(PrimitiveIterator.OfLong iterator, long size, int characteristics) {
            int i;
            this.it = iterator;
            this.est = size;
            if ((characteristics & Spliterator.CONCURRENT) == 0) {
                i = characteristics | 64 | Spliterator.SUBSIZED;
            } else {
                i = characteristics;
            }
            this.characteristics = i;
        }

        public LongIteratorSpliterator(PrimitiveIterator.OfLong iterator, int characteristics) {
            this.it = iterator;
            this.est = Long.MAX_VALUE;
            this.characteristics = characteristics & (-16449);
        }

        @Override // j$.util.Spliterator
        public Spliterator.OfLong trySplit() {
            PrimitiveIterator.OfLong i = this.it;
            long s = this.est;
            if (s > 1 && i.hasNext()) {
                int n = this.batch + 1024;
                if (n > s) {
                    n = (int) s;
                }
                if (n > MAX_BATCH) {
                    n = MAX_BATCH;
                }
                long[] a = new long[n];
                int j = 0;
                do {
                    a[j] = i.nextLong();
                    j++;
                    if (j >= n) {
                        break;
                    }
                } while (i.hasNext());
                this.batch = j;
                if (this.est != Long.MAX_VALUE) {
                    this.est -= j;
                }
                return new LongArraySpliterator(a, 0, j, this.characteristics);
            }
            return null;
        }

        @Override // j$.util.Spliterator.OfPrimitive
        public void forEachRemaining(LongConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            this.it.forEachRemaining(action);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        public boolean tryAdvance(LongConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            if (this.it.hasNext()) {
                action.accept(this.it.nextLong());
                return true;
            }
            return false;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // j$.util.Spliterator
        public java.util.Comparator<? super Long> getComparator() {
            if (hasCharacteristics(4)) {
                return null;
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class DoubleIteratorSpliterator implements Spliterator.OfDouble {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private int batch;
        private final int characteristics;
        private long est;
        private PrimitiveIterator.OfDouble it;

        @Override // j$.util.Spliterator.OfDouble, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Spliterator.OfDouble.CC.$default$forEachRemaining((Spliterator.OfDouble) this, consumer);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return Spliterator.CC.$default$getExactSizeIfKnown(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Spliterator.CC.$default$hasCharacteristics(this, i);
        }

        @Override // j$.util.Spliterator.OfDouble, j$.util.Spliterator
        public /* synthetic */ boolean tryAdvance(Consumer consumer) {
            return Spliterator.OfDouble.CC.$default$tryAdvance((Spliterator.OfDouble) this, consumer);
        }

        public DoubleIteratorSpliterator(PrimitiveIterator.OfDouble iterator, long size, int characteristics) {
            int i;
            this.it = iterator;
            this.est = size;
            if ((characteristics & Spliterator.CONCURRENT) == 0) {
                i = characteristics | 64 | Spliterator.SUBSIZED;
            } else {
                i = characteristics;
            }
            this.characteristics = i;
        }

        public DoubleIteratorSpliterator(PrimitiveIterator.OfDouble iterator, int characteristics) {
            this.it = iterator;
            this.est = Long.MAX_VALUE;
            this.characteristics = characteristics & (-16449);
        }

        @Override // j$.util.Spliterator
        public Spliterator.OfDouble trySplit() {
            PrimitiveIterator.OfDouble i = this.it;
            long s = this.est;
            if (s > 1 && i.hasNext()) {
                int n = this.batch + 1024;
                if (n > s) {
                    n = (int) s;
                }
                if (n > MAX_BATCH) {
                    n = MAX_BATCH;
                }
                double[] a = new double[n];
                int j = 0;
                do {
                    a[j] = i.nextDouble();
                    j++;
                    if (j >= n) {
                        break;
                    }
                } while (i.hasNext());
                this.batch = j;
                if (this.est != Long.MAX_VALUE) {
                    this.est -= j;
                }
                return new DoubleArraySpliterator(a, 0, j, this.characteristics);
            }
            return null;
        }

        @Override // j$.util.Spliterator.OfPrimitive
        public void forEachRemaining(DoubleConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            this.it.forEachRemaining(action);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        public boolean tryAdvance(DoubleConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            if (this.it.hasNext()) {
                action.accept(this.it.nextDouble());
                return true;
            }
            return false;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // j$.util.Spliterator
        public java.util.Comparator<? super Double> getComparator() {
            if (hasCharacteristics(4)) {
                return null;
            }
            throw new IllegalStateException();
        }
    }
}