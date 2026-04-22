package j$.util.stream;

import j$.util.DesugarArrays;
import j$.util.DoubleSummaryStatistics;
import j$.util.DoubleSummaryStatisticsConversions;
import j$.util.Objects;
import j$.util.OptionalConversions;
import j$.util.OptionalDouble;
import j$.util.PrimitiveIterator;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.stream.BaseStream;
import j$.util.stream.IntStream;
import j$.util.stream.LongStream;
import j$.util.stream.Stream;
import j$.util.stream.StreamSpliterators;
import j$.util.stream.Streams;
import j$.util.stream.WhileOps;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;

public interface DoubleStream extends BaseStream<Double, DoubleStream> {

    /* compiled from: D8$$SyntheticClass */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public final /* synthetic */ class VivifiedWrapper implements DoubleStream {
        public final /* synthetic */ java.util.stream.DoubleStream wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.stream.DoubleStream doubleStream) {
            this.wrappedValue = doubleStream;
        }

        public static /* synthetic */ DoubleStream convert(java.util.stream.DoubleStream doubleStream) {
            if (doubleStream == null) {
                return null;
            }
            return doubleStream instanceof Wrapper ? DoubleStream.this : new VivifiedWrapper(doubleStream);
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ boolean allMatch(DoublePredicate doublePredicate) {
            return this.wrappedValue.allMatch(doublePredicate);
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ boolean anyMatch(DoublePredicate doublePredicate) {
            return this.wrappedValue.anyMatch(doublePredicate);
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ OptionalDouble average() {
            return OptionalConversions.convert(this.wrappedValue.average());
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ Stream boxed() {
            return Stream.VivifiedWrapper.convert(this.wrappedValue.boxed());
        }

        @Override // j$.util.stream.BaseStream, java.lang.AutoCloseable
        public /* synthetic */ void close() {
            this.wrappedValue.close();
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer) {
            return this.wrappedValue.collect(supplier, objDoubleConsumer, biConsumer);
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ long count() {
            return this.wrappedValue.count();
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ DoubleStream distinct() {
            return convert(this.wrappedValue.distinct());
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ DoubleStream dropWhile(DoublePredicate doublePredicate) {
            return convert(this.wrappedValue.dropWhile(doublePredicate));
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.stream.DoubleStream doubleStream = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return doubleStream.equals(obj);
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ DoubleStream filter(DoublePredicate doublePredicate) {
            return convert(this.wrappedValue.filter(doublePredicate));
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ OptionalDouble findAny() {
            return OptionalConversions.convert(this.wrappedValue.findAny());
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ OptionalDouble findFirst() {
            return OptionalConversions.convert(this.wrappedValue.findFirst());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ DoubleStream flatMap(DoubleFunction doubleFunction) {
            return convert(this.wrappedValue.flatMap(FlatMapApiFlips.flipFunctionReturningStream(doubleFunction)));
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ void forEach(DoubleConsumer doubleConsumer) {
            this.wrappedValue.forEach(doubleConsumer);
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ void forEachOrdered(DoubleConsumer doubleConsumer) {
            this.wrappedValue.forEachOrdered(doubleConsumer);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }

        @Override // j$.util.stream.BaseStream
        public /* synthetic */ boolean isParallel() {
            return this.wrappedValue.isParallel();
        }

        @Override // j$.util.stream.DoubleStream, j$.util.stream.BaseStream
        public /* synthetic */ Iterator<Double> iterator() {
            return PrimitiveIterator.OfDouble.VivifiedWrapper.convert(this.wrappedValue.iterator());
        }

        @Override // j$.util.stream.BaseStream
        /* renamed from: iterator */
        public /* synthetic */ Iterator<Double> iterator2() {
            return this.wrappedValue.iterator();
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ DoubleStream limit(long j) {
            return convert(this.wrappedValue.limit(j));
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ DoubleStream map(DoubleUnaryOperator doubleUnaryOperator) {
            return convert(this.wrappedValue.map(doubleUnaryOperator));
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ IntStream mapToInt(DoubleToIntFunction doubleToIntFunction) {
            return IntStream.VivifiedWrapper.convert(this.wrappedValue.mapToInt(doubleToIntFunction));
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ LongStream mapToLong(DoubleToLongFunction doubleToLongFunction) {
            return LongStream.VivifiedWrapper.convert(this.wrappedValue.mapToLong(doubleToLongFunction));
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ Stream mapToObj(DoubleFunction doubleFunction) {
            return Stream.VivifiedWrapper.convert(this.wrappedValue.mapToObj(doubleFunction));
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ OptionalDouble max() {
            return OptionalConversions.convert(this.wrappedValue.max());
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ OptionalDouble min() {
            return OptionalConversions.convert(this.wrappedValue.min());
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ boolean noneMatch(DoublePredicate doublePredicate) {
            return this.wrappedValue.noneMatch(doublePredicate);
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [j$.util.stream.DoubleStream, j$.util.stream.BaseStream] */
        @Override // j$.util.stream.BaseStream
        public /* synthetic */ DoubleStream onClose(Runnable runnable) {
            return BaseStream.VivifiedWrapper.convert(this.wrappedValue.onClose(runnable));
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [j$.util.stream.DoubleStream, j$.util.stream.BaseStream] */
        @Override // j$.util.stream.BaseStream
        public /* synthetic */ DoubleStream parallel() {
            return BaseStream.VivifiedWrapper.convert(this.wrappedValue.parallel());
        }

        @Override // j$.util.stream.DoubleStream, j$.util.stream.BaseStream
        /* renamed from: parallel */
        public /* synthetic */ DoubleStream parallel2() {
            return convert(this.wrappedValue.parallel());
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ DoubleStream peek(DoubleConsumer doubleConsumer) {
            return convert(this.wrappedValue.peek(doubleConsumer));
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ double reduce(double d, DoubleBinaryOperator doubleBinaryOperator) {
            return this.wrappedValue.reduce(d, doubleBinaryOperator);
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ OptionalDouble reduce(DoubleBinaryOperator doubleBinaryOperator) {
            return OptionalConversions.convert(this.wrappedValue.reduce(doubleBinaryOperator));
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [j$.util.stream.DoubleStream, j$.util.stream.BaseStream] */
        @Override // j$.util.stream.BaseStream
        public /* synthetic */ DoubleStream sequential() {
            return BaseStream.VivifiedWrapper.convert(this.wrappedValue.sequential());
        }

        @Override // j$.util.stream.DoubleStream, j$.util.stream.BaseStream
        /* renamed from: sequential */
        public /* synthetic */ DoubleStream sequential2() {
            return convert(this.wrappedValue.sequential());
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ DoubleStream skip(long j) {
            return convert(this.wrappedValue.skip(j));
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ DoubleStream sorted() {
            return convert(this.wrappedValue.sorted());
        }

        @Override // j$.util.stream.DoubleStream, j$.util.stream.BaseStream
        public /* synthetic */ Spliterator<Double> spliterator() {
            return Spliterator.OfDouble.VivifiedWrapper.convert(this.wrappedValue.spliterator());
        }

        @Override // j$.util.stream.BaseStream
        /* renamed from: spliterator */
        public /* synthetic */ Spliterator<Double> spliterator2() {
            return Spliterator.VivifiedWrapper.convert(this.wrappedValue.spliterator());
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ double sum() {
            return this.wrappedValue.sum();
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ DoubleSummaryStatistics summaryStatistics() {
            return DoubleSummaryStatisticsConversions.convert(this.wrappedValue.summaryStatistics());
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ DoubleStream takeWhile(DoublePredicate doublePredicate) {
            return convert(this.wrappedValue.takeWhile(doublePredicate));
        }

        @Override // j$.util.stream.DoubleStream
        public /* synthetic */ double[] toArray() {
            return this.wrappedValue.toArray();
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [j$.util.stream.DoubleStream, j$.util.stream.BaseStream] */
        @Override // j$.util.stream.BaseStream
        public /* synthetic */ DoubleStream unordered() {
            return BaseStream.VivifiedWrapper.convert(this.wrappedValue.unordered());
        }
    }

    /* compiled from: D8$$SyntheticClass */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public final /* synthetic */ class Wrapper implements java.util.stream.DoubleStream {
        private /* synthetic */ Wrapper() {
            DoubleStream.this = r1;
        }

        public static /* synthetic */ java.util.stream.DoubleStream convert(DoubleStream doubleStream) {
            if (doubleStream == null) {
                return null;
            }
            return doubleStream instanceof VivifiedWrapper ? ((VivifiedWrapper) doubleStream).wrappedValue : new Wrapper();
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ boolean allMatch(DoublePredicate doublePredicate) {
            return DoubleStream.this.allMatch(doublePredicate);
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ boolean anyMatch(DoublePredicate doublePredicate) {
            return DoubleStream.this.anyMatch(doublePredicate);
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.OptionalDouble average() {
            return OptionalConversions.convert(DoubleStream.this.average());
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.stream.Stream boxed() {
            return Stream.Wrapper.convert(DoubleStream.this.boxed());
        }

        @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
        public /* synthetic */ void close() {
            DoubleStream.this.close();
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer) {
            return DoubleStream.this.collect(supplier, objDoubleConsumer, biConsumer);
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ long count() {
            return DoubleStream.this.count();
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.stream.DoubleStream distinct() {
            return convert(DoubleStream.this.distinct());
        }

        public /* synthetic */ java.util.stream.DoubleStream dropWhile(DoublePredicate doublePredicate) {
            return convert(DoubleStream.this.dropWhile(doublePredicate));
        }

        public /* synthetic */ boolean equals(Object obj) {
            DoubleStream doubleStream = DoubleStream.this;
            if (obj instanceof Wrapper) {
                obj = DoubleStream.this;
            }
            return doubleStream.equals(obj);
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.stream.DoubleStream filter(DoublePredicate doublePredicate) {
            return convert(DoubleStream.this.filter(doublePredicate));
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.OptionalDouble findAny() {
            return OptionalConversions.convert(DoubleStream.this.findAny());
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.OptionalDouble findFirst() {
            return OptionalConversions.convert(DoubleStream.this.findFirst());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.stream.DoubleStream flatMap(DoubleFunction doubleFunction) {
            return convert(DoubleStream.this.flatMap(FlatMapApiFlips.flipFunctionReturningStream(doubleFunction)));
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ void forEach(DoubleConsumer doubleConsumer) {
            DoubleStream.this.forEach(doubleConsumer);
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ void forEachOrdered(DoubleConsumer doubleConsumer) {
            DoubleStream.this.forEachOrdered(doubleConsumer);
        }

        public /* synthetic */ int hashCode() {
            return DoubleStream.this.hashCode();
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ boolean isParallel() {
            return DoubleStream.this.isParallel();
        }

        @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
        public /* synthetic */ Iterator<Double> iterator() {
            return DoubleStream.this.iterator();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [j$.util.PrimitiveIterator$OfDouble] */
        @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
        /* renamed from: iterator */
        public /* synthetic */ Iterator<Double> iterator2() {
            return PrimitiveIterator.OfDouble.Wrapper.convert(DoubleStream.this.iterator());
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.stream.DoubleStream limit(long j) {
            return convert(DoubleStream.this.limit(j));
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.stream.DoubleStream map(DoubleUnaryOperator doubleUnaryOperator) {
            return convert(DoubleStream.this.map(doubleUnaryOperator));
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.stream.IntStream mapToInt(DoubleToIntFunction doubleToIntFunction) {
            return IntStream.Wrapper.convert(DoubleStream.this.mapToInt(doubleToIntFunction));
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.stream.LongStream mapToLong(DoubleToLongFunction doubleToLongFunction) {
            return LongStream.Wrapper.convert(DoubleStream.this.mapToLong(doubleToLongFunction));
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.stream.Stream mapToObj(DoubleFunction doubleFunction) {
            return Stream.Wrapper.convert(DoubleStream.this.mapToObj(doubleFunction));
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.OptionalDouble max() {
            return OptionalConversions.convert(DoubleStream.this.max());
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.OptionalDouble min() {
            return OptionalConversions.convert(DoubleStream.this.min());
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ boolean noneMatch(DoublePredicate doublePredicate) {
            return DoubleStream.this.noneMatch(doublePredicate);
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [java.util.stream.BaseStream, java.util.stream.DoubleStream] */
        @Override // java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.DoubleStream onClose(Runnable runnable) {
            return BaseStream.Wrapper.convert(DoubleStream.this.onClose(runnable));
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.stream.BaseStream, java.util.stream.DoubleStream] */
        @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.DoubleStream parallel() {
            return BaseStream.Wrapper.convert(DoubleStream.this.parallel());
        }

        @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
        /* renamed from: parallel */
        public /* synthetic */ java.util.stream.DoubleStream parallel2() {
            return convert(DoubleStream.this.parallel());
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.stream.DoubleStream peek(DoubleConsumer doubleConsumer) {
            return convert(DoubleStream.this.peek(doubleConsumer));
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ double reduce(double d, DoubleBinaryOperator doubleBinaryOperator) {
            return DoubleStream.this.reduce(d, doubleBinaryOperator);
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.OptionalDouble reduce(DoubleBinaryOperator doubleBinaryOperator) {
            return OptionalConversions.convert(DoubleStream.this.reduce(doubleBinaryOperator));
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.stream.BaseStream, java.util.stream.DoubleStream] */
        @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.DoubleStream sequential() {
            return BaseStream.Wrapper.convert(DoubleStream.this.sequential());
        }

        @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
        /* renamed from: sequential */
        public /* synthetic */ java.util.stream.DoubleStream sequential2() {
            return convert(DoubleStream.this.sequential());
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.stream.DoubleStream skip(long j) {
            return convert(DoubleStream.this.skip(j));
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.stream.DoubleStream sorted() {
            return convert(DoubleStream.this.sorted());
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [j$.util.Spliterator$OfDouble] */
        @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
        public /* synthetic */ java.util.Spliterator<Double> spliterator() {
            return Spliterator.OfDouble.Wrapper.convert(DoubleStream.this.spliterator());
        }

        @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
        /* renamed from: spliterator */
        public /* synthetic */ java.util.Spliterator<Double> spliterator2() {
            return Spliterator.Wrapper.convert(DoubleStream.this.spliterator());
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ double sum() {
            return DoubleStream.this.sum();
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.DoubleSummaryStatistics summaryStatistics() {
            return DoubleSummaryStatisticsConversions.convert(DoubleStream.this.summaryStatistics());
        }

        public /* synthetic */ java.util.stream.DoubleStream takeWhile(DoublePredicate doublePredicate) {
            return convert(DoubleStream.this.takeWhile(doublePredicate));
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ double[] toArray() {
            return DoubleStream.this.toArray();
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.stream.BaseStream, java.util.stream.DoubleStream] */
        @Override // java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.DoubleStream unordered() {
            return BaseStream.Wrapper.convert(DoubleStream.this.unordered());
        }
    }

    boolean allMatch(DoublePredicate doublePredicate);

    boolean anyMatch(DoublePredicate doublePredicate);

    OptionalDouble average();

    Stream<Double> boxed();

    <R> R collect(Supplier<R> supplier, ObjDoubleConsumer<R> objDoubleConsumer, BiConsumer<R, R> biConsumer);

    long count();

    DoubleStream distinct();

    DoubleStream dropWhile(DoublePredicate doublePredicate);

    DoubleStream filter(DoublePredicate doublePredicate);

    OptionalDouble findAny();

    OptionalDouble findFirst();

    DoubleStream flatMap(DoubleFunction<? extends DoubleStream> doubleFunction);

    void forEach(DoubleConsumer doubleConsumer);

    void forEachOrdered(DoubleConsumer doubleConsumer);

    @Override // j$.util.stream.BaseStream
    Iterator<Double> iterator();

    DoubleStream limit(long j);

    DoubleStream map(DoubleUnaryOperator doubleUnaryOperator);

    IntStream mapToInt(DoubleToIntFunction doubleToIntFunction);

    LongStream mapToLong(DoubleToLongFunction doubleToLongFunction);

    <U> Stream<U> mapToObj(DoubleFunction<? extends U> doubleFunction);

    OptionalDouble max();

    OptionalDouble min();

    boolean noneMatch(DoublePredicate doublePredicate);

    @Override // j$.util.stream.BaseStream
    DoubleStream parallel();

    DoubleStream peek(DoubleConsumer doubleConsumer);

    double reduce(double d, DoubleBinaryOperator doubleBinaryOperator);

    OptionalDouble reduce(DoubleBinaryOperator doubleBinaryOperator);

    @Override // j$.util.stream.BaseStream
    DoubleStream sequential();

    DoubleStream skip(long j);

    DoubleStream sorted();

    @Override // j$.util.stream.BaseStream
    Spliterator<Double> spliterator();

    double sum();

    DoubleSummaryStatistics summaryStatistics();

    DoubleStream takeWhile(DoublePredicate doublePredicate);

    double[] toArray();

    /* renamed from: j$.util.stream.DoubleStream$-CC */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public final /* synthetic */ class CC {
        /* JADX WARN: Type inference failed for: r1v0, types: [j$.util.Spliterator$OfDouble] */
        public static DoubleStream $default$takeWhile(DoubleStream _this, DoublePredicate predicate) {
            Objects.requireNonNull(predicate);
            return StreamSupport.doubleStream(new WhileOps.UnorderedWhileSpliterator.OfDouble.Taking(_this.spliterator(), true, predicate), _this.isParallel()).onClose(new DoubleStream$$ExternalSyntheticLambda0(_this));
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [j$.util.Spliterator$OfDouble] */
        public static DoubleStream $default$dropWhile(DoubleStream _this, DoublePredicate predicate) {
            Objects.requireNonNull(predicate);
            return StreamSupport.doubleStream(new WhileOps.UnorderedWhileSpliterator.OfDouble.Dropping(_this.spliterator(), true, predicate), _this.isParallel()).onClose(new DoubleStream$$ExternalSyntheticLambda0(_this));
        }

        public static Builder builder() {
            return new Streams.DoubleStreamBuilderImpl();
        }

        public static DoubleStream empty() {
            return StreamSupport.doubleStream(Spliterators.emptyDoubleSpliterator(), false);
        }

        public static DoubleStream of(double t) {
            return StreamSupport.doubleStream(new Streams.DoubleStreamBuilderImpl(t), false);
        }

        public static DoubleStream of(double... values) {
            return DesugarArrays.stream(values);
        }

        public static DoubleStream iterate(final double seed, final DoubleUnaryOperator f) {
            Objects.requireNonNull(f);
            Spliterator.OfDouble spliterator = new Spliterators.AbstractDoubleSpliterator(Long.MAX_VALUE, 1296) { // from class: j$.util.stream.DoubleStream.1
                double prev;
                boolean started;

                @Override // j$.util.Spliterators.AbstractDoubleSpliterator, j$.util.Spliterator.OfPrimitive
                public boolean tryAdvance(DoubleConsumer action) {
                    double t;
                    Objects.requireNonNull(action);
                    if (this.started) {
                        t = f.applyAsDouble(this.prev);
                    } else {
                        t = seed;
                        this.started = true;
                    }
                    this.prev = t;
                    action.accept(t);
                    return true;
                }
            };
            return StreamSupport.doubleStream(spliterator, false);
        }

        public static DoubleStream iterate(final double seed, final DoublePredicate hasNext, final DoubleUnaryOperator next) {
            Objects.requireNonNull(next);
            Objects.requireNonNull(hasNext);
            Spliterator.OfDouble spliterator = new Spliterators.AbstractDoubleSpliterator(Long.MAX_VALUE, 1296) { // from class: j$.util.stream.DoubleStream.2
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

        public static DoubleStream generate(DoubleSupplier s) {
            Objects.requireNonNull(s);
            return StreamSupport.doubleStream(new StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble(Long.MAX_VALUE, s), false);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [j$.util.Spliterator$OfDouble] */
        /* JADX WARN: Type inference failed for: r2v0, types: [j$.util.Spliterator$OfDouble] */
        public static DoubleStream concat(DoubleStream a, DoubleStream b) {
            Objects.requireNonNull(a);
            Objects.requireNonNull(b);
            Spliterator.OfDouble split = new Streams.ConcatSpliterator.OfDouble(a.spliterator(), b.spliterator());
            DoubleStream stream = StreamSupport.doubleStream(split, a.isParallel() || b.isParallel());
            return stream.onClose(Streams.composedClose(a, b));
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public interface Builder extends DoubleConsumer {
        @Override // java.util.function.DoubleConsumer
        void accept(double d);

        Builder add(double d);

        DoubleStream build();

        /* renamed from: j$.util.stream.DoubleStream$Builder$-CC */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public final /* synthetic */ class CC {
            /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
                java.lang.NullPointerException
                */
            public static j$.util.stream.DoubleStream.Builder $default$add(j$.util.stream.DoubleStream.Builder r0, double r1) {
                /*
                    r0.accept(r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.DoubleStream.Builder.CC.$default$add(j$.util.stream.DoubleStream$Builder, double):j$.util.stream.DoubleStream$Builder");
            }
        }
    }
}