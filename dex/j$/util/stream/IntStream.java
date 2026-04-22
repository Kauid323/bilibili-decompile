package j$.util.stream;

import j$.util.DesugarArrays;
import j$.util.IntSummaryStatistics;
import j$.util.IntSummaryStatisticsConversions;
import j$.util.Objects;
import j$.util.OptionalConversions;
import j$.util.OptionalDouble;
import j$.util.OptionalInt;
import j$.util.PrimitiveIterator;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.stream.BaseStream;
import j$.util.stream.DoubleStream;
import j$.util.stream.LongStream;
import j$.util.stream.Stream;
import j$.util.stream.StreamSpliterators;
import j$.util.stream.Streams;
import j$.util.stream.WhileOps;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;

public interface IntStream extends BaseStream<Integer, IntStream> {

    /* compiled from: D8$$SyntheticClass */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public final /* synthetic */ class VivifiedWrapper implements IntStream {
        public final /* synthetic */ java.util.stream.IntStream wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.stream.IntStream intStream) {
            this.wrappedValue = intStream;
        }

        public static /* synthetic */ IntStream convert(java.util.stream.IntStream intStream) {
            if (intStream == null) {
                return null;
            }
            return intStream instanceof Wrapper ? IntStream.this : new VivifiedWrapper(intStream);
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ boolean allMatch(IntPredicate intPredicate) {
            return this.wrappedValue.allMatch(intPredicate);
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ boolean anyMatch(IntPredicate intPredicate) {
            return this.wrappedValue.anyMatch(intPredicate);
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ DoubleStream asDoubleStream() {
            return DoubleStream.VivifiedWrapper.convert(this.wrappedValue.asDoubleStream());
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ LongStream asLongStream() {
            return LongStream.VivifiedWrapper.convert(this.wrappedValue.asLongStream());
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ OptionalDouble average() {
            return OptionalConversions.convert(this.wrappedValue.average());
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ Stream boxed() {
            return Stream.VivifiedWrapper.convert(this.wrappedValue.boxed());
        }

        @Override // j$.util.stream.BaseStream, java.lang.AutoCloseable
        public /* synthetic */ void close() {
            this.wrappedValue.close();
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer) {
            return this.wrappedValue.collect(supplier, objIntConsumer, biConsumer);
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ long count() {
            return this.wrappedValue.count();
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ IntStream distinct() {
            return convert(this.wrappedValue.distinct());
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ IntStream dropWhile(IntPredicate intPredicate) {
            return convert(this.wrappedValue.dropWhile(intPredicate));
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.stream.IntStream intStream = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return intStream.equals(obj);
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ IntStream filter(IntPredicate intPredicate) {
            return convert(this.wrappedValue.filter(intPredicate));
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ OptionalInt findAny() {
            return OptionalConversions.convert(this.wrappedValue.findAny());
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ OptionalInt findFirst() {
            return OptionalConversions.convert(this.wrappedValue.findFirst());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // j$.util.stream.IntStream
        public /* synthetic */ IntStream flatMap(IntFunction intFunction) {
            return convert(this.wrappedValue.flatMap(FlatMapApiFlips.flipFunctionReturningStream(intFunction)));
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ void forEach(IntConsumer intConsumer) {
            this.wrappedValue.forEach(intConsumer);
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ void forEachOrdered(IntConsumer intConsumer) {
            this.wrappedValue.forEachOrdered(intConsumer);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }

        @Override // j$.util.stream.BaseStream
        public /* synthetic */ boolean isParallel() {
            return this.wrappedValue.isParallel();
        }

        @Override // j$.util.stream.IntStream, j$.util.stream.BaseStream
        public /* synthetic */ Iterator<Integer> iterator() {
            return PrimitiveIterator.OfInt.VivifiedWrapper.convert(this.wrappedValue.iterator());
        }

        @Override // j$.util.stream.BaseStream
        /* renamed from: iterator */
        public /* synthetic */ Iterator<Integer> iterator2() {
            return this.wrappedValue.iterator();
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ IntStream limit(long j) {
            return convert(this.wrappedValue.limit(j));
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ IntStream map(IntUnaryOperator intUnaryOperator) {
            return convert(this.wrappedValue.map(intUnaryOperator));
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ DoubleStream mapToDouble(IntToDoubleFunction intToDoubleFunction) {
            return DoubleStream.VivifiedWrapper.convert(this.wrappedValue.mapToDouble(intToDoubleFunction));
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ LongStream mapToLong(IntToLongFunction intToLongFunction) {
            return LongStream.VivifiedWrapper.convert(this.wrappedValue.mapToLong(intToLongFunction));
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ Stream mapToObj(IntFunction intFunction) {
            return Stream.VivifiedWrapper.convert(this.wrappedValue.mapToObj(intFunction));
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ OptionalInt max() {
            return OptionalConversions.convert(this.wrappedValue.max());
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ OptionalInt min() {
            return OptionalConversions.convert(this.wrappedValue.min());
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ boolean noneMatch(IntPredicate intPredicate) {
            return this.wrappedValue.noneMatch(intPredicate);
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [j$.util.stream.IntStream, j$.util.stream.BaseStream] */
        @Override // j$.util.stream.BaseStream
        public /* synthetic */ IntStream onClose(Runnable runnable) {
            return BaseStream.VivifiedWrapper.convert(this.wrappedValue.onClose(runnable));
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [j$.util.stream.IntStream, j$.util.stream.BaseStream] */
        @Override // j$.util.stream.BaseStream
        public /* synthetic */ IntStream parallel() {
            return BaseStream.VivifiedWrapper.convert(this.wrappedValue.parallel());
        }

        @Override // j$.util.stream.IntStream, j$.util.stream.BaseStream
        /* renamed from: parallel */
        public /* synthetic */ IntStream parallel2() {
            return convert(this.wrappedValue.parallel());
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ IntStream peek(IntConsumer intConsumer) {
            return convert(this.wrappedValue.peek(intConsumer));
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ int reduce(int i, IntBinaryOperator intBinaryOperator) {
            return this.wrappedValue.reduce(i, intBinaryOperator);
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ OptionalInt reduce(IntBinaryOperator intBinaryOperator) {
            return OptionalConversions.convert(this.wrappedValue.reduce(intBinaryOperator));
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [j$.util.stream.IntStream, j$.util.stream.BaseStream] */
        @Override // j$.util.stream.BaseStream
        public /* synthetic */ IntStream sequential() {
            return BaseStream.VivifiedWrapper.convert(this.wrappedValue.sequential());
        }

        @Override // j$.util.stream.IntStream, j$.util.stream.BaseStream
        /* renamed from: sequential */
        public /* synthetic */ IntStream sequential2() {
            return convert(this.wrappedValue.sequential());
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ IntStream skip(long j) {
            return convert(this.wrappedValue.skip(j));
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ IntStream sorted() {
            return convert(this.wrappedValue.sorted());
        }

        @Override // j$.util.stream.IntStream, j$.util.stream.BaseStream
        public /* synthetic */ Spliterator<Integer> spliterator() {
            return Spliterator.OfInt.VivifiedWrapper.convert(this.wrappedValue.spliterator());
        }

        @Override // j$.util.stream.BaseStream
        /* renamed from: spliterator */
        public /* synthetic */ Spliterator<Integer> spliterator2() {
            return Spliterator.VivifiedWrapper.convert(this.wrappedValue.spliterator());
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ int sum() {
            return this.wrappedValue.sum();
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ IntSummaryStatistics summaryStatistics() {
            return IntSummaryStatisticsConversions.convert(this.wrappedValue.summaryStatistics());
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ IntStream takeWhile(IntPredicate intPredicate) {
            return convert(this.wrappedValue.takeWhile(intPredicate));
        }

        @Override // j$.util.stream.IntStream
        public /* synthetic */ int[] toArray() {
            return this.wrappedValue.toArray();
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [j$.util.stream.IntStream, j$.util.stream.BaseStream] */
        @Override // j$.util.stream.BaseStream
        public /* synthetic */ IntStream unordered() {
            return BaseStream.VivifiedWrapper.convert(this.wrappedValue.unordered());
        }
    }

    /* compiled from: D8$$SyntheticClass */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public final /* synthetic */ class Wrapper implements java.util.stream.IntStream {
        private /* synthetic */ Wrapper() {
            IntStream.this = r1;
        }

        public static /* synthetic */ java.util.stream.IntStream convert(IntStream intStream) {
            if (intStream == null) {
                return null;
            }
            return intStream instanceof VivifiedWrapper ? ((VivifiedWrapper) intStream).wrappedValue : new Wrapper();
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ boolean allMatch(IntPredicate intPredicate) {
            return IntStream.this.allMatch(intPredicate);
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ boolean anyMatch(IntPredicate intPredicate) {
            return IntStream.this.anyMatch(intPredicate);
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.DoubleStream asDoubleStream() {
            return DoubleStream.Wrapper.convert(IntStream.this.asDoubleStream());
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.LongStream asLongStream() {
            return LongStream.Wrapper.convert(IntStream.this.asLongStream());
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.OptionalDouble average() {
            return OptionalConversions.convert(IntStream.this.average());
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.Stream boxed() {
            return Stream.Wrapper.convert(IntStream.this.boxed());
        }

        @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
        public /* synthetic */ void close() {
            IntStream.this.close();
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer) {
            return IntStream.this.collect(supplier, objIntConsumer, biConsumer);
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ long count() {
            return IntStream.this.count();
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.IntStream distinct() {
            return convert(IntStream.this.distinct());
        }

        public /* synthetic */ java.util.stream.IntStream dropWhile(IntPredicate intPredicate) {
            return convert(IntStream.this.dropWhile(intPredicate));
        }

        public /* synthetic */ boolean equals(Object obj) {
            IntStream intStream = IntStream.this;
            if (obj instanceof Wrapper) {
                obj = IntStream.this;
            }
            return intStream.equals(obj);
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.IntStream filter(IntPredicate intPredicate) {
            return convert(IntStream.this.filter(intPredicate));
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.OptionalInt findAny() {
            return OptionalConversions.convert(IntStream.this.findAny());
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.OptionalInt findFirst() {
            return OptionalConversions.convert(IntStream.this.findFirst());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.IntStream flatMap(IntFunction intFunction) {
            return convert(IntStream.this.flatMap(FlatMapApiFlips.flipFunctionReturningStream(intFunction)));
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ void forEach(IntConsumer intConsumer) {
            IntStream.this.forEach(intConsumer);
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ void forEachOrdered(IntConsumer intConsumer) {
            IntStream.this.forEachOrdered(intConsumer);
        }

        public /* synthetic */ int hashCode() {
            return IntStream.this.hashCode();
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ boolean isParallel() {
            return IntStream.this.isParallel();
        }

        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        public /* synthetic */ Iterator<Integer> iterator() {
            return IntStream.this.iterator();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [j$.util.PrimitiveIterator$OfInt] */
        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        /* renamed from: iterator */
        public /* synthetic */ Iterator<Integer> iterator2() {
            return PrimitiveIterator.OfInt.Wrapper.convert(IntStream.this.iterator());
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.IntStream limit(long j) {
            return convert(IntStream.this.limit(j));
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.IntStream map(IntUnaryOperator intUnaryOperator) {
            return convert(IntStream.this.map(intUnaryOperator));
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.DoubleStream mapToDouble(IntToDoubleFunction intToDoubleFunction) {
            return DoubleStream.Wrapper.convert(IntStream.this.mapToDouble(intToDoubleFunction));
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.LongStream mapToLong(IntToLongFunction intToLongFunction) {
            return LongStream.Wrapper.convert(IntStream.this.mapToLong(intToLongFunction));
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.Stream mapToObj(IntFunction intFunction) {
            return Stream.Wrapper.convert(IntStream.this.mapToObj(intFunction));
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.OptionalInt max() {
            return OptionalConversions.convert(IntStream.this.max());
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.OptionalInt min() {
            return OptionalConversions.convert(IntStream.this.min());
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ boolean noneMatch(IntPredicate intPredicate) {
            return IntStream.this.noneMatch(intPredicate);
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [java.util.stream.IntStream, java.util.stream.BaseStream] */
        @Override // java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.IntStream onClose(Runnable runnable) {
            return BaseStream.Wrapper.convert(IntStream.this.onClose(runnable));
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.stream.IntStream, java.util.stream.BaseStream] */
        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.IntStream parallel() {
            return BaseStream.Wrapper.convert(IntStream.this.parallel());
        }

        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        /* renamed from: parallel */
        public /* synthetic */ java.util.stream.IntStream parallel2() {
            return convert(IntStream.this.parallel());
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.IntStream peek(IntConsumer intConsumer) {
            return convert(IntStream.this.peek(intConsumer));
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ int reduce(int i, IntBinaryOperator intBinaryOperator) {
            return IntStream.this.reduce(i, intBinaryOperator);
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.OptionalInt reduce(IntBinaryOperator intBinaryOperator) {
            return OptionalConversions.convert(IntStream.this.reduce(intBinaryOperator));
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.stream.IntStream, java.util.stream.BaseStream] */
        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.IntStream sequential() {
            return BaseStream.Wrapper.convert(IntStream.this.sequential());
        }

        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        /* renamed from: sequential */
        public /* synthetic */ java.util.stream.IntStream sequential2() {
            return convert(IntStream.this.sequential());
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.IntStream skip(long j) {
            return convert(IntStream.this.skip(j));
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.IntStream sorted() {
            return convert(IntStream.this.sorted());
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [j$.util.Spliterator$OfInt] */
        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        public /* synthetic */ java.util.Spliterator<Integer> spliterator() {
            return Spliterator.OfInt.Wrapper.convert(IntStream.this.spliterator());
        }

        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        /* renamed from: spliterator */
        public /* synthetic */ java.util.Spliterator<Integer> spliterator2() {
            return Spliterator.Wrapper.convert(IntStream.this.spliterator());
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ int sum() {
            return IntStream.this.sum();
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.IntSummaryStatistics summaryStatistics() {
            return IntSummaryStatisticsConversions.convert(IntStream.this.summaryStatistics());
        }

        public /* synthetic */ java.util.stream.IntStream takeWhile(IntPredicate intPredicate) {
            return convert(IntStream.this.takeWhile(intPredicate));
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ int[] toArray() {
            return IntStream.this.toArray();
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.stream.IntStream, java.util.stream.BaseStream] */
        @Override // java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.IntStream unordered() {
            return BaseStream.Wrapper.convert(IntStream.this.unordered());
        }
    }

    boolean allMatch(IntPredicate intPredicate);

    boolean anyMatch(IntPredicate intPredicate);

    DoubleStream asDoubleStream();

    LongStream asLongStream();

    OptionalDouble average();

    Stream<Integer> boxed();

    <R> R collect(Supplier<R> supplier, ObjIntConsumer<R> objIntConsumer, BiConsumer<R, R> biConsumer);

    long count();

    IntStream distinct();

    IntStream dropWhile(IntPredicate intPredicate);

    IntStream filter(IntPredicate intPredicate);

    OptionalInt findAny();

    OptionalInt findFirst();

    IntStream flatMap(IntFunction<? extends IntStream> intFunction);

    void forEach(IntConsumer intConsumer);

    void forEachOrdered(IntConsumer intConsumer);

    @Override // j$.util.stream.BaseStream
    Iterator<Integer> iterator();

    IntStream limit(long j);

    IntStream map(IntUnaryOperator intUnaryOperator);

    DoubleStream mapToDouble(IntToDoubleFunction intToDoubleFunction);

    LongStream mapToLong(IntToLongFunction intToLongFunction);

    <U> Stream<U> mapToObj(IntFunction<? extends U> intFunction);

    OptionalInt max();

    OptionalInt min();

    boolean noneMatch(IntPredicate intPredicate);

    @Override // j$.util.stream.BaseStream
    IntStream parallel();

    IntStream peek(IntConsumer intConsumer);

    int reduce(int i, IntBinaryOperator intBinaryOperator);

    OptionalInt reduce(IntBinaryOperator intBinaryOperator);

    @Override // j$.util.stream.BaseStream
    IntStream sequential();

    IntStream skip(long j);

    IntStream sorted();

    @Override // j$.util.stream.BaseStream
    Spliterator<Integer> spliterator();

    int sum();

    IntSummaryStatistics summaryStatistics();

    IntStream takeWhile(IntPredicate intPredicate);

    int[] toArray();

    /* renamed from: j$.util.stream.IntStream$-CC */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public final /* synthetic */ class CC {
        /* JADX WARN: Type inference failed for: r1v0, types: [j$.util.Spliterator$OfInt] */
        public static IntStream $default$takeWhile(IntStream _this, IntPredicate predicate) {
            Objects.requireNonNull(predicate);
            return StreamSupport.intStream(new WhileOps.UnorderedWhileSpliterator.OfInt.Taking(_this.spliterator(), true, predicate), _this.isParallel()).onClose(new IntStream$$ExternalSyntheticLambda0(_this));
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [j$.util.Spliterator$OfInt] */
        public static IntStream $default$dropWhile(IntStream _this, IntPredicate predicate) {
            Objects.requireNonNull(predicate);
            return StreamSupport.intStream(new WhileOps.UnorderedWhileSpliterator.OfInt.Dropping(_this.spliterator(), true, predicate), _this.isParallel()).onClose(new IntStream$$ExternalSyntheticLambda0(_this));
        }

        public static Builder builder() {
            return new Streams.IntStreamBuilderImpl();
        }

        public static IntStream empty() {
            return StreamSupport.intStream(Spliterators.emptyIntSpliterator(), false);
        }

        public static IntStream of(int t) {
            return StreamSupport.intStream(new Streams.IntStreamBuilderImpl(t), false);
        }

        public static IntStream of(int... values) {
            return DesugarArrays.stream(values);
        }

        public static IntStream iterate(final int seed, final IntUnaryOperator f) {
            Objects.requireNonNull(f);
            Spliterator.OfInt spliterator = new Spliterators.AbstractIntSpliterator(Long.MAX_VALUE, 1296) { // from class: j$.util.stream.IntStream.1
                int prev;
                boolean started;

                @Override // j$.util.Spliterators.AbstractIntSpliterator, j$.util.Spliterator.OfPrimitive
                public boolean tryAdvance(IntConsumer action) {
                    int t;
                    Objects.requireNonNull(action);
                    if (this.started) {
                        t = f.applyAsInt(this.prev);
                    } else {
                        t = seed;
                        this.started = true;
                    }
                    this.prev = t;
                    action.accept(t);
                    return true;
                }
            };
            return StreamSupport.intStream(spliterator, false);
        }

        public static IntStream iterate(final int seed, final IntPredicate hasNext, final IntUnaryOperator next) {
            Objects.requireNonNull(next);
            Objects.requireNonNull(hasNext);
            Spliterator.OfInt spliterator = new Spliterators.AbstractIntSpliterator(Long.MAX_VALUE, 1296) { // from class: j$.util.stream.IntStream.2
                boolean finished;
                int prev;
                boolean started;

                @Override // j$.util.Spliterators.AbstractIntSpliterator, j$.util.Spliterator.OfPrimitive
                public boolean tryAdvance(IntConsumer action) {
                    int t;
                    Objects.requireNonNull(action);
                    if (this.finished) {
                        return false;
                    }
                    if (this.started) {
                        t = next.applyAsInt(this.prev);
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

                @Override // j$.util.Spliterators.AbstractIntSpliterator, j$.util.Spliterator.OfPrimitive
                public void forEachRemaining(IntConsumer action) {
                    Objects.requireNonNull(action);
                    if (this.finished) {
                        return;
                    }
                    this.finished = true;
                    int t = this.started ? next.applyAsInt(this.prev) : seed;
                    while (hasNext.test(t)) {
                        action.accept(t);
                        t = next.applyAsInt(t);
                    }
                }
            };
            return StreamSupport.intStream(spliterator, false);
        }

        public static IntStream generate(IntSupplier s) {
            Objects.requireNonNull(s);
            return StreamSupport.intStream(new StreamSpliterators.InfiniteSupplyingSpliterator.OfInt(Long.MAX_VALUE, s), false);
        }

        public static IntStream range(int startInclusive, int endExclusive) {
            if (startInclusive >= endExclusive) {
                return empty();
            }
            return StreamSupport.intStream(new Streams.RangeIntSpliterator(startInclusive, endExclusive, false), false);
        }

        public static IntStream rangeClosed(int startInclusive, int endInclusive) {
            if (startInclusive > endInclusive) {
                return empty();
            }
            return StreamSupport.intStream(new Streams.RangeIntSpliterator(startInclusive, endInclusive, true), false);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [j$.util.Spliterator$OfInt] */
        /* JADX WARN: Type inference failed for: r2v0, types: [j$.util.Spliterator$OfInt] */
        public static IntStream concat(IntStream a, IntStream b) {
            Objects.requireNonNull(a);
            Objects.requireNonNull(b);
            Spliterator.OfInt split = new Streams.ConcatSpliterator.OfInt(a.spliterator(), b.spliterator());
            IntStream stream = StreamSupport.intStream(split, a.isParallel() || b.isParallel());
            return stream.onClose(Streams.composedClose(a, b));
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public interface Builder extends IntConsumer {
        @Override // java.util.function.IntConsumer
        void accept(int i);

        Builder add(int i);

        IntStream build();

        /* renamed from: j$.util.stream.IntStream$Builder$-CC */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public final /* synthetic */ class CC {
            /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
                java.lang.NullPointerException
                */
            public static j$.util.stream.IntStream.Builder $default$add(j$.util.stream.IntStream.Builder r0, int r1) {
                /*
                    r0.accept(r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.IntStream.Builder.CC.$default$add(j$.util.stream.IntStream$Builder, int):j$.util.stream.IntStream$Builder");
            }
        }
    }
}