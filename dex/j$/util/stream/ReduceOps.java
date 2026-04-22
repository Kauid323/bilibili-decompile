package j$.util.stream;

import j$.util.Objects;
import j$.util.Optional;
import j$.util.OptionalDouble;
import j$.util.OptionalInt;
import j$.util.OptionalLong;
import j$.util.Spliterator;
import j$.util.function.Consumer$CC;
import j$.util.function.DoubleConsumer$CC;
import j$.util.function.IntConsumer$CC;
import j$.util.function.LongConsumer$CC;
import j$.util.stream.Collector;
import j$.util.stream.Sink;
import j$.util.stream.TerminalOp;
import java.util.concurrent.CountedCompleter;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

final class ReduceOps {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public interface AccumulatingSink<T, R, K extends AccumulatingSink<T, R, K>> extends TerminalSink<T, R> {
        void combine(K k);
    }

    private ReduceOps() {
    }

    public static <T, U> TerminalOp<T, U> makeRef(final U seed, final BiFunction<U, ? super T, U> reducer, final BinaryOperator<U> combiner) {
        Objects.requireNonNull(reducer);
        Objects.requireNonNull(combiner);
        return new ReduceOp<T, U, C1ReducingSink>(StreamShape.REFERENCE) { // from class: j$.util.stream.ReduceOps.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // j$.util.stream.ReduceOps.ReduceOp
            public C1ReducingSink makeSink() {
                return new C1ReducingSink(seed, reducer, combiner);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T, U] */
    /* renamed from: j$.util.stream.ReduceOps$1ReducingSink  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public class C1ReducingSink<T, U> extends Box<U> implements AccumulatingSink<T, U, C1ReducingSink> {
        final /* synthetic */ BinaryOperator val$combiner;
        final /* synthetic */ BiFunction val$reducer;
        final /* synthetic */ Object val$seed;

        @Override // j$.util.stream.Sink, java.util.function.DoubleConsumer
        public /* synthetic */ void accept(double d) {
            Sink.CC.$default$accept(this, d);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void accept(int i) {
            Sink.CC.$default$accept((Sink) this, i);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void accept(long j) {
            Sink.CC.$default$accept((Sink) this, j);
        }

        @Override // java.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer$CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ boolean cancellationRequested() {
            return Sink.CC.$default$cancellationRequested(this);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void end() {
            Sink.CC.$default$end(this);
        }

        C1ReducingSink(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
            this.val$seed = obj;
            this.val$reducer = biFunction;
            this.val$combiner = binaryOperator;
        }

        @Override // j$.util.stream.Sink
        public void begin(long size) {
            this.state = (U) this.val$seed;
        }

        @Override // java.util.function.Consumer
        public void accept(T t) {
            this.state = (U) this.val$reducer.apply(this.state, t);
        }

        @Override // j$.util.stream.ReduceOps.AccumulatingSink
        public void combine(C1ReducingSink other) {
            this.state = (U) this.val$combiner.apply(this.state, other.state);
        }
    }

    public static <T> TerminalOp<T, Optional<T>> makeRef(final BinaryOperator<T> operator) {
        Objects.requireNonNull(operator);
        return new ReduceOp<T, Optional<T>, C2ReducingSink>(StreamShape.REFERENCE) { // from class: j$.util.stream.ReduceOps.2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [j$.util.stream.ReduceOps$2ReducingSink] */
            @Override // j$.util.stream.ReduceOps.ReduceOp
            public C2ReducingSink makeSink() {
                final BinaryOperator binaryOperator = operator;
                return new AccumulatingSink<T, Optional<T>, C2ReducingSink>() { // from class: j$.util.stream.ReduceOps.2ReducingSink
                    private boolean empty;
                    private T state;

                    @Override // j$.util.stream.Sink, java.util.function.DoubleConsumer
                    public /* synthetic */ void accept(double d) {
                        Sink.CC.$default$accept(this, d);
                    }

                    @Override // j$.util.stream.Sink
                    public /* synthetic */ void accept(int i) {
                        Sink.CC.$default$accept((Sink) this, i);
                    }

                    @Override // j$.util.stream.Sink
                    public /* synthetic */ void accept(long j) {
                        Sink.CC.$default$accept((Sink) this, j);
                    }

                    @Override // java.util.function.Consumer
                    public /* synthetic */ Consumer andThen(Consumer consumer) {
                        return Consumer$CC.$default$andThen(this, consumer);
                    }

                    @Override // j$.util.stream.Sink
                    public /* synthetic */ boolean cancellationRequested() {
                        return Sink.CC.$default$cancellationRequested(this);
                    }

                    @Override // j$.util.stream.Sink
                    public /* synthetic */ void end() {
                        Sink.CC.$default$end(this);
                    }

                    @Override // j$.util.stream.Sink
                    public void begin(long size) {
                        this.empty = true;
                        this.state = null;
                    }

                    @Override // java.util.function.Consumer
                    public void accept(T t) {
                        if (this.empty) {
                            this.empty = false;
                            this.state = t;
                            return;
                        }
                        this.state = BinaryOperator.this.apply(this.state, t);
                    }

                    @Override // java.util.function.Supplier
                    public Optional<T> get() {
                        return this.empty ? Optional.empty() : Optional.of(this.state);
                    }

                    @Override // j$.util.stream.ReduceOps.AccumulatingSink
                    public void combine(C2ReducingSink other) {
                        if (!other.empty) {
                            accept((C2ReducingSink<T>) other.state);
                        }
                    }
                };
            }
        };
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Collector != java.util.stream.Collector<? super T, I, ?> */
    public static <T, I> TerminalOp<T, I> makeRef(final Collector<? super T, I, ?> collector) {
        final Supplier<I> supplier = ((Collector) Objects.requireNonNull(collector)).supplier();
        final BiConsumer<I, ? super T> accumulator = collector.accumulator();
        final BinaryOperator<I> combiner = collector.combiner();
        return new ReduceOp<T, I, C3ReducingSink>(StreamShape.REFERENCE) { // from class: j$.util.stream.ReduceOps.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // j$.util.stream.ReduceOps.ReduceOp
            public C3ReducingSink makeSink() {
                return new C3ReducingSink(supplier, accumulator, combiner);
            }

            @Override // j$.util.stream.ReduceOps.ReduceOp, j$.util.stream.TerminalOp
            public int getOpFlags() {
                if (collector.characteristics().contains(Collector.Characteristics.UNORDERED)) {
                    return StreamOpFlag.NOT_ORDERED;
                }
                return 0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T, I] */
    /* renamed from: j$.util.stream.ReduceOps$3ReducingSink  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public class C3ReducingSink<I, T> extends Box<I> implements AccumulatingSink<T, I, C3ReducingSink> {
        final /* synthetic */ BiConsumer val$accumulator;
        final /* synthetic */ BinaryOperator val$combiner;
        final /* synthetic */ Supplier val$supplier;

        @Override // j$.util.stream.Sink, java.util.function.DoubleConsumer
        public /* synthetic */ void accept(double d) {
            Sink.CC.$default$accept(this, d);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void accept(int i) {
            Sink.CC.$default$accept((Sink) this, i);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void accept(long j) {
            Sink.CC.$default$accept((Sink) this, j);
        }

        @Override // java.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer$CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ boolean cancellationRequested() {
            return Sink.CC.$default$cancellationRequested(this);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void end() {
            Sink.CC.$default$end(this);
        }

        C3ReducingSink(Supplier supplier, BiConsumer biConsumer, BinaryOperator binaryOperator) {
            this.val$supplier = supplier;
            this.val$accumulator = biConsumer;
            this.val$combiner = binaryOperator;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [U, java.lang.Object] */
        @Override // j$.util.stream.Sink
        public void begin(long size) {
            this.state = this.val$supplier.get();
        }

        @Override // java.util.function.Consumer
        public void accept(T t) {
            this.val$accumulator.accept(this.state, t);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [U, java.lang.Object] */
        @Override // j$.util.stream.ReduceOps.AccumulatingSink
        public void combine(C3ReducingSink other) {
            this.state = this.val$combiner.apply(this.state, other.state);
        }
    }

    public static <T, R> TerminalOp<T, R> makeRef(final Supplier<R> seedFactory, final BiConsumer<R, ? super T> accumulator, final BiConsumer<R, R> reducer) {
        Objects.requireNonNull(seedFactory);
        Objects.requireNonNull(accumulator);
        Objects.requireNonNull(reducer);
        return new ReduceOp<T, R, C4ReducingSink>(StreamShape.REFERENCE) { // from class: j$.util.stream.ReduceOps.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // j$.util.stream.ReduceOps.ReduceOp
            public C4ReducingSink makeSink() {
                return new C4ReducingSink(seedFactory, accumulator, reducer);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R, T] */
    /* renamed from: j$.util.stream.ReduceOps$4ReducingSink  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public class C4ReducingSink<R, T> extends Box<R> implements AccumulatingSink<T, R, C4ReducingSink> {
        final /* synthetic */ BiConsumer val$accumulator;
        final /* synthetic */ BiConsumer val$reducer;
        final /* synthetic */ Supplier val$seedFactory;

        @Override // j$.util.stream.Sink, java.util.function.DoubleConsumer
        public /* synthetic */ void accept(double d) {
            Sink.CC.$default$accept(this, d);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void accept(int i) {
            Sink.CC.$default$accept((Sink) this, i);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void accept(long j) {
            Sink.CC.$default$accept((Sink) this, j);
        }

        @Override // java.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer$CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ boolean cancellationRequested() {
            return Sink.CC.$default$cancellationRequested(this);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void end() {
            Sink.CC.$default$end(this);
        }

        C4ReducingSink(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
            this.val$seedFactory = supplier;
            this.val$accumulator = biConsumer;
            this.val$reducer = biConsumer2;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [U, java.lang.Object] */
        @Override // j$.util.stream.Sink
        public void begin(long size) {
            this.state = this.val$seedFactory.get();
        }

        @Override // java.util.function.Consumer
        public void accept(T t) {
            this.val$accumulator.accept(this.state, t);
        }

        @Override // j$.util.stream.ReduceOps.AccumulatingSink
        public void combine(C4ReducingSink other) {
            this.val$reducer.accept(this.state, other.state);
        }
    }

    public static <T> TerminalOp<T, Long> makeRefCounting() {
        return new ReduceOp<T, Long, CountingSink<T>>(StreamShape.REFERENCE) { // from class: j$.util.stream.ReduceOps.5
            @Override // j$.util.stream.ReduceOps.ReduceOp
            public CountingSink<T> makeSink() {
                return new CountingSink.OfRef();
            }

            /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<T> */
            @Override // j$.util.stream.ReduceOps.ReduceOp, j$.util.stream.TerminalOp
            public <P_IN> Long evaluateSequential(PipelineHelper<T> pipelineHelper, Spliterator<P_IN> spliterator) {
                if (StreamOpFlag.SIZED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return Long.valueOf(spliterator.getExactSizeIfKnown());
                }
                return (Long) super.evaluateSequential((PipelineHelper) pipelineHelper, (Spliterator) spliterator);
            }

            /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<T> */
            @Override // j$.util.stream.ReduceOps.ReduceOp, j$.util.stream.TerminalOp
            public <P_IN> Long evaluateParallel(PipelineHelper<T> pipelineHelper, Spliterator<P_IN> spliterator) {
                if (StreamOpFlag.SIZED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return Long.valueOf(spliterator.getExactSizeIfKnown());
                }
                return (Long) super.evaluateParallel((PipelineHelper) pipelineHelper, (Spliterator) spliterator);
            }

            @Override // j$.util.stream.ReduceOps.ReduceOp, j$.util.stream.TerminalOp
            public int getOpFlags() {
                return StreamOpFlag.NOT_ORDERED;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j$.util.stream.ReduceOps$5ReducingSink  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public class C5ReducingSink implements AccumulatingSink<Integer, Integer, C5ReducingSink>, Sink.OfInt {
        private int state;
        final /* synthetic */ int val$identity;
        final /* synthetic */ IntBinaryOperator val$operator;

        @Override // j$.util.stream.Sink, java.util.function.DoubleConsumer
        public /* synthetic */ void accept(double d) {
            Sink.CC.$default$accept(this, d);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void accept(long j) {
            Sink.CC.$default$accept((Sink) this, j);
        }

        @Override // j$.util.stream.Sink.OfInt
        public /* synthetic */ void accept(Integer num) {
            Sink.OfInt.CC.$default$accept((Sink.OfInt) this, num);
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(Object obj) {
            Sink.OfInt.CC.$default$accept(this, obj);
        }

        @Override // java.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer$CC.$default$andThen(this, consumer);
        }

        @Override // java.util.function.IntConsumer
        public /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
            return IntConsumer$CC.$default$andThen(this, intConsumer);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ boolean cancellationRequested() {
            return Sink.CC.$default$cancellationRequested(this);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void end() {
            Sink.CC.$default$end(this);
        }

        C5ReducingSink(int i, IntBinaryOperator intBinaryOperator) {
            this.val$identity = i;
            this.val$operator = intBinaryOperator;
        }

        @Override // j$.util.stream.Sink
        public void begin(long size) {
            this.state = this.val$identity;
        }

        @Override // j$.util.stream.Sink
        public void accept(int t) {
            this.state = this.val$operator.applyAsInt(this.state, t);
        }

        @Override // java.util.function.Supplier
        public Integer get() {
            return Integer.valueOf(this.state);
        }

        @Override // j$.util.stream.ReduceOps.AccumulatingSink
        public void combine(C5ReducingSink other) {
            accept(other.state);
        }
    }

    public static TerminalOp<Integer, Integer> makeInt(final int identity, final IntBinaryOperator operator) {
        Objects.requireNonNull(operator);
        return new ReduceOp<Integer, Integer, C5ReducingSink>(StreamShape.INT_VALUE) { // from class: j$.util.stream.ReduceOps.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // j$.util.stream.ReduceOps.ReduceOp
            public C5ReducingSink makeSink() {
                return new C5ReducingSink(identity, operator);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j$.util.stream.ReduceOps$6ReducingSink  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public class C6ReducingSink implements AccumulatingSink<Integer, OptionalInt, C6ReducingSink>, Sink.OfInt {
        private boolean empty;
        private int state;
        final /* synthetic */ IntBinaryOperator val$operator;

        @Override // j$.util.stream.Sink, java.util.function.DoubleConsumer
        public /* synthetic */ void accept(double d) {
            Sink.CC.$default$accept(this, d);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void accept(long j) {
            Sink.CC.$default$accept((Sink) this, j);
        }

        @Override // j$.util.stream.Sink.OfInt
        public /* synthetic */ void accept(Integer num) {
            Sink.OfInt.CC.$default$accept((Sink.OfInt) this, num);
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(Object obj) {
            Sink.OfInt.CC.$default$accept(this, obj);
        }

        @Override // java.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer$CC.$default$andThen(this, consumer);
        }

        @Override // java.util.function.IntConsumer
        public /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
            return IntConsumer$CC.$default$andThen(this, intConsumer);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ boolean cancellationRequested() {
            return Sink.CC.$default$cancellationRequested(this);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void end() {
            Sink.CC.$default$end(this);
        }

        C6ReducingSink(IntBinaryOperator intBinaryOperator) {
            this.val$operator = intBinaryOperator;
        }

        @Override // j$.util.stream.Sink
        public void begin(long size) {
            this.empty = true;
            this.state = 0;
        }

        @Override // j$.util.stream.Sink
        public void accept(int t) {
            if (this.empty) {
                this.empty = false;
                this.state = t;
                return;
            }
            this.state = this.val$operator.applyAsInt(this.state, t);
        }

        @Override // java.util.function.Supplier
        public OptionalInt get() {
            return this.empty ? OptionalInt.empty() : OptionalInt.of(this.state);
        }

        @Override // j$.util.stream.ReduceOps.AccumulatingSink
        public void combine(C6ReducingSink other) {
            if (!other.empty) {
                accept(other.state);
            }
        }
    }

    public static TerminalOp<Integer, OptionalInt> makeInt(final IntBinaryOperator operator) {
        Objects.requireNonNull(operator);
        return new ReduceOp<Integer, OptionalInt, C6ReducingSink>(StreamShape.INT_VALUE) { // from class: j$.util.stream.ReduceOps.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // j$.util.stream.ReduceOps.ReduceOp
            public C6ReducingSink makeSink() {
                return new C6ReducingSink(operator);
            }
        };
    }

    public static <R> TerminalOp<Integer, R> makeInt(final Supplier<R> supplier, final ObjIntConsumer<R> accumulator, final BinaryOperator<R> combiner) {
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(accumulator);
        Objects.requireNonNull(combiner);
        return new ReduceOp<Integer, R, C7ReducingSink>(StreamShape.INT_VALUE) { // from class: j$.util.stream.ReduceOps.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // j$.util.stream.ReduceOps.ReduceOp
            public C7ReducingSink makeSink() {
                return new C7ReducingSink(supplier, accumulator, combiner);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* renamed from: j$.util.stream.ReduceOps$7ReducingSink  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public class C7ReducingSink<R> extends Box<R> implements AccumulatingSink<Integer, R, C7ReducingSink>, Sink.OfInt {
        final /* synthetic */ ObjIntConsumer val$accumulator;
        final /* synthetic */ BinaryOperator val$combiner;
        final /* synthetic */ Supplier val$supplier;

        @Override // j$.util.stream.Sink, java.util.function.DoubleConsumer
        public /* synthetic */ void accept(double d) {
            Sink.CC.$default$accept(this, d);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void accept(long j) {
            Sink.CC.$default$accept((Sink) this, j);
        }

        @Override // j$.util.stream.Sink.OfInt
        public /* synthetic */ void accept(Integer num) {
            Sink.OfInt.CC.$default$accept((Sink.OfInt) this, num);
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(Object obj) {
            Sink.OfInt.CC.$default$accept(this, obj);
        }

        @Override // java.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer$CC.$default$andThen(this, consumer);
        }

        @Override // java.util.function.IntConsumer
        public /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
            return IntConsumer$CC.$default$andThen(this, intConsumer);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ boolean cancellationRequested() {
            return Sink.CC.$default$cancellationRequested(this);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void end() {
            Sink.CC.$default$end(this);
        }

        C7ReducingSink(Supplier supplier, ObjIntConsumer objIntConsumer, BinaryOperator binaryOperator) {
            this.val$supplier = supplier;
            this.val$accumulator = objIntConsumer;
            this.val$combiner = binaryOperator;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [U, java.lang.Object] */
        @Override // j$.util.stream.Sink
        public void begin(long size) {
            this.state = this.val$supplier.get();
        }

        @Override // j$.util.stream.Sink
        public void accept(int t) {
            this.val$accumulator.accept(this.state, t);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [U, java.lang.Object] */
        @Override // j$.util.stream.ReduceOps.AccumulatingSink
        public void combine(C7ReducingSink other) {
            this.state = this.val$combiner.apply(this.state, other.state);
        }
    }

    public static TerminalOp<Integer, Long> makeIntCounting() {
        return new ReduceOp<Integer, Long, CountingSink<Integer>>(StreamShape.INT_VALUE) { // from class: j$.util.stream.ReduceOps.9
            @Override // j$.util.stream.ReduceOps.ReduceOp, j$.util.stream.TerminalOp
            public /* bridge */ /* synthetic */ Object evaluateParallel(PipelineHelper pipelineHelper, Spliterator spliterator) {
                return evaluateParallel((PipelineHelper<Integer>) pipelineHelper, spliterator);
            }

            @Override // j$.util.stream.ReduceOps.ReduceOp, j$.util.stream.TerminalOp
            public /* bridge */ /* synthetic */ Object evaluateSequential(PipelineHelper pipelineHelper, Spliterator spliterator) {
                return evaluateSequential((PipelineHelper<Integer>) pipelineHelper, spliterator);
            }

            @Override // j$.util.stream.ReduceOps.ReduceOp
            public CountingSink<Integer> makeSink() {
                return new CountingSink.OfInt();
            }

            /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<java.lang.Integer> */
            @Override // j$.util.stream.ReduceOps.ReduceOp, j$.util.stream.TerminalOp
            public <P_IN> Long evaluateSequential(PipelineHelper<Integer> pipelineHelper, Spliterator<P_IN> spliterator) {
                if (StreamOpFlag.SIZED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return Long.valueOf(spliterator.getExactSizeIfKnown());
                }
                return (Long) super.evaluateSequential((PipelineHelper) pipelineHelper, (Spliterator) spliterator);
            }

            /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<java.lang.Integer> */
            @Override // j$.util.stream.ReduceOps.ReduceOp, j$.util.stream.TerminalOp
            public <P_IN> Long evaluateParallel(PipelineHelper<Integer> pipelineHelper, Spliterator<P_IN> spliterator) {
                if (StreamOpFlag.SIZED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return Long.valueOf(spliterator.getExactSizeIfKnown());
                }
                return (Long) super.evaluateParallel((PipelineHelper) pipelineHelper, (Spliterator) spliterator);
            }

            @Override // j$.util.stream.ReduceOps.ReduceOp, j$.util.stream.TerminalOp
            public int getOpFlags() {
                return StreamOpFlag.NOT_ORDERED;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j$.util.stream.ReduceOps$8ReducingSink  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public class C8ReducingSink implements AccumulatingSink<Long, Long, C8ReducingSink>, Sink.OfLong {
        private long state;
        final /* synthetic */ long val$identity;
        final /* synthetic */ LongBinaryOperator val$operator;

        @Override // j$.util.stream.Sink, java.util.function.DoubleConsumer
        public /* synthetic */ void accept(double d) {
            Sink.CC.$default$accept(this, d);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void accept(int i) {
            Sink.CC.$default$accept((Sink) this, i);
        }

        @Override // j$.util.stream.Sink.OfLong
        public /* synthetic */ void accept(Long l) {
            Sink.OfLong.CC.$default$accept((Sink.OfLong) this, l);
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(Object obj) {
            Sink.OfLong.CC.$default$accept(this, obj);
        }

        @Override // java.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer$CC.$default$andThen(this, consumer);
        }

        @Override // java.util.function.LongConsumer
        public /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
            return LongConsumer$CC.$default$andThen(this, longConsumer);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ boolean cancellationRequested() {
            return Sink.CC.$default$cancellationRequested(this);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void end() {
            Sink.CC.$default$end(this);
        }

        C8ReducingSink(long j, LongBinaryOperator longBinaryOperator) {
            this.val$identity = j;
            this.val$operator = longBinaryOperator;
        }

        @Override // j$.util.stream.Sink
        public void begin(long size) {
            this.state = this.val$identity;
        }

        @Override // j$.util.stream.Sink
        public void accept(long t) {
            this.state = this.val$operator.applyAsLong(this.state, t);
        }

        @Override // java.util.function.Supplier
        public Long get() {
            return Long.valueOf(this.state);
        }

        @Override // j$.util.stream.ReduceOps.AccumulatingSink
        public void combine(C8ReducingSink other) {
            accept(other.state);
        }
    }

    public static TerminalOp<Long, Long> makeLong(final long identity, final LongBinaryOperator operator) {
        Objects.requireNonNull(operator);
        return new ReduceOp<Long, Long, C8ReducingSink>(StreamShape.LONG_VALUE) { // from class: j$.util.stream.ReduceOps.10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // j$.util.stream.ReduceOps.ReduceOp
            public C8ReducingSink makeSink() {
                return new C8ReducingSink(identity, operator);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j$.util.stream.ReduceOps$9ReducingSink  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public class C9ReducingSink implements AccumulatingSink<Long, OptionalLong, C9ReducingSink>, Sink.OfLong {
        private boolean empty;
        private long state;
        final /* synthetic */ LongBinaryOperator val$operator;

        @Override // j$.util.stream.Sink, java.util.function.DoubleConsumer
        public /* synthetic */ void accept(double d) {
            Sink.CC.$default$accept(this, d);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void accept(int i) {
            Sink.CC.$default$accept((Sink) this, i);
        }

        @Override // j$.util.stream.Sink.OfLong
        public /* synthetic */ void accept(Long l) {
            Sink.OfLong.CC.$default$accept((Sink.OfLong) this, l);
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(Object obj) {
            Sink.OfLong.CC.$default$accept(this, obj);
        }

        @Override // java.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer$CC.$default$andThen(this, consumer);
        }

        @Override // java.util.function.LongConsumer
        public /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
            return LongConsumer$CC.$default$andThen(this, longConsumer);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ boolean cancellationRequested() {
            return Sink.CC.$default$cancellationRequested(this);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void end() {
            Sink.CC.$default$end(this);
        }

        C9ReducingSink(LongBinaryOperator longBinaryOperator) {
            this.val$operator = longBinaryOperator;
        }

        @Override // j$.util.stream.Sink
        public void begin(long size) {
            this.empty = true;
            this.state = 0L;
        }

        @Override // j$.util.stream.Sink
        public void accept(long t) {
            if (this.empty) {
                this.empty = false;
                this.state = t;
                return;
            }
            this.state = this.val$operator.applyAsLong(this.state, t);
        }

        @Override // java.util.function.Supplier
        public OptionalLong get() {
            return this.empty ? OptionalLong.empty() : OptionalLong.of(this.state);
        }

        @Override // j$.util.stream.ReduceOps.AccumulatingSink
        public void combine(C9ReducingSink other) {
            if (!other.empty) {
                accept(other.state);
            }
        }
    }

    public static TerminalOp<Long, OptionalLong> makeLong(final LongBinaryOperator operator) {
        Objects.requireNonNull(operator);
        return new ReduceOp<Long, OptionalLong, C9ReducingSink>(StreamShape.LONG_VALUE) { // from class: j$.util.stream.ReduceOps.11
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // j$.util.stream.ReduceOps.ReduceOp
            public C9ReducingSink makeSink() {
                return new C9ReducingSink(operator);
            }
        };
    }

    public static <R> TerminalOp<Long, R> makeLong(final Supplier<R> supplier, final ObjLongConsumer<R> accumulator, final BinaryOperator<R> combiner) {
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(accumulator);
        Objects.requireNonNull(combiner);
        return new ReduceOp<Long, R, C10ReducingSink>(StreamShape.LONG_VALUE) { // from class: j$.util.stream.ReduceOps.12
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // j$.util.stream.ReduceOps.ReduceOp
            public C10ReducingSink makeSink() {
                return new C10ReducingSink(supplier, accumulator, combiner);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* renamed from: j$.util.stream.ReduceOps$10ReducingSink  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public class C10ReducingSink<R> extends Box<R> implements AccumulatingSink<Long, R, C10ReducingSink>, Sink.OfLong {
        final /* synthetic */ ObjLongConsumer val$accumulator;
        final /* synthetic */ BinaryOperator val$combiner;
        final /* synthetic */ Supplier val$supplier;

        @Override // j$.util.stream.Sink, java.util.function.DoubleConsumer
        public /* synthetic */ void accept(double d) {
            Sink.CC.$default$accept(this, d);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void accept(int i) {
            Sink.CC.$default$accept((Sink) this, i);
        }

        @Override // j$.util.stream.Sink.OfLong
        public /* synthetic */ void accept(Long l) {
            Sink.OfLong.CC.$default$accept((Sink.OfLong) this, l);
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(Object obj) {
            Sink.OfLong.CC.$default$accept(this, obj);
        }

        @Override // java.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer$CC.$default$andThen(this, consumer);
        }

        @Override // java.util.function.LongConsumer
        public /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
            return LongConsumer$CC.$default$andThen(this, longConsumer);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ boolean cancellationRequested() {
            return Sink.CC.$default$cancellationRequested(this);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void end() {
            Sink.CC.$default$end(this);
        }

        C10ReducingSink(Supplier supplier, ObjLongConsumer objLongConsumer, BinaryOperator binaryOperator) {
            this.val$supplier = supplier;
            this.val$accumulator = objLongConsumer;
            this.val$combiner = binaryOperator;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [U, java.lang.Object] */
        @Override // j$.util.stream.Sink
        public void begin(long size) {
            this.state = this.val$supplier.get();
        }

        @Override // j$.util.stream.Sink
        public void accept(long t) {
            this.val$accumulator.accept(this.state, t);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [U, java.lang.Object] */
        @Override // j$.util.stream.ReduceOps.AccumulatingSink
        public void combine(C10ReducingSink other) {
            this.state = this.val$combiner.apply(this.state, other.state);
        }
    }

    public static TerminalOp<Long, Long> makeLongCounting() {
        return new ReduceOp<Long, Long, CountingSink<Long>>(StreamShape.LONG_VALUE) { // from class: j$.util.stream.ReduceOps.13
            @Override // j$.util.stream.ReduceOps.ReduceOp, j$.util.stream.TerminalOp
            public /* bridge */ /* synthetic */ Object evaluateParallel(PipelineHelper pipelineHelper, Spliterator spliterator) {
                return evaluateParallel((PipelineHelper<Long>) pipelineHelper, spliterator);
            }

            @Override // j$.util.stream.ReduceOps.ReduceOp, j$.util.stream.TerminalOp
            public /* bridge */ /* synthetic */ Object evaluateSequential(PipelineHelper pipelineHelper, Spliterator spliterator) {
                return evaluateSequential((PipelineHelper<Long>) pipelineHelper, spliterator);
            }

            @Override // j$.util.stream.ReduceOps.ReduceOp
            public CountingSink<Long> makeSink() {
                return new CountingSink.OfLong();
            }

            /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<java.lang.Long> */
            @Override // j$.util.stream.ReduceOps.ReduceOp, j$.util.stream.TerminalOp
            public <P_IN> Long evaluateSequential(PipelineHelper<Long> pipelineHelper, Spliterator<P_IN> spliterator) {
                if (StreamOpFlag.SIZED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return Long.valueOf(spliterator.getExactSizeIfKnown());
                }
                return (Long) super.evaluateSequential((PipelineHelper) pipelineHelper, (Spliterator) spliterator);
            }

            /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<java.lang.Long> */
            @Override // j$.util.stream.ReduceOps.ReduceOp, j$.util.stream.TerminalOp
            public <P_IN> Long evaluateParallel(PipelineHelper<Long> pipelineHelper, Spliterator<P_IN> spliterator) {
                if (StreamOpFlag.SIZED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return Long.valueOf(spliterator.getExactSizeIfKnown());
                }
                return (Long) super.evaluateParallel((PipelineHelper) pipelineHelper, (Spliterator) spliterator);
            }

            @Override // j$.util.stream.ReduceOps.ReduceOp, j$.util.stream.TerminalOp
            public int getOpFlags() {
                return StreamOpFlag.NOT_ORDERED;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j$.util.stream.ReduceOps$11ReducingSink  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public class C11ReducingSink implements AccumulatingSink<Double, Double, C11ReducingSink>, Sink.OfDouble {
        private double state;
        final /* synthetic */ double val$identity;
        final /* synthetic */ DoubleBinaryOperator val$operator;

        @Override // j$.util.stream.Sink
        public /* synthetic */ void accept(int i) {
            Sink.CC.$default$accept((Sink) this, i);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void accept(long j) {
            Sink.CC.$default$accept((Sink) this, j);
        }

        @Override // j$.util.stream.Sink.OfDouble
        public /* synthetic */ void accept(Double d) {
            Sink.OfDouble.CC.$default$accept((Sink.OfDouble) this, d);
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(Object obj) {
            Sink.OfDouble.CC.$default$accept(this, obj);
        }

        @Override // java.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer$CC.$default$andThen(this, consumer);
        }

        @Override // java.util.function.DoubleConsumer
        public /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
            return DoubleConsumer$CC.$default$andThen(this, doubleConsumer);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ boolean cancellationRequested() {
            return Sink.CC.$default$cancellationRequested(this);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void end() {
            Sink.CC.$default$end(this);
        }

        C11ReducingSink(double d, DoubleBinaryOperator doubleBinaryOperator) {
            this.val$identity = d;
            this.val$operator = doubleBinaryOperator;
        }

        @Override // j$.util.stream.Sink
        public void begin(long size) {
            this.state = this.val$identity;
        }

        @Override // j$.util.stream.Sink, java.util.function.DoubleConsumer
        public void accept(double t) {
            this.state = this.val$operator.applyAsDouble(this.state, t);
        }

        @Override // java.util.function.Supplier
        public Double get() {
            return Double.valueOf(this.state);
        }

        @Override // j$.util.stream.ReduceOps.AccumulatingSink
        public void combine(C11ReducingSink other) {
            accept(other.state);
        }
    }

    public static TerminalOp<Double, Double> makeDouble(final double identity, final DoubleBinaryOperator operator) {
        Objects.requireNonNull(operator);
        return new ReduceOp<Double, Double, C11ReducingSink>(StreamShape.DOUBLE_VALUE) { // from class: j$.util.stream.ReduceOps.14
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // j$.util.stream.ReduceOps.ReduceOp
            public C11ReducingSink makeSink() {
                return new C11ReducingSink(identity, operator);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j$.util.stream.ReduceOps$12ReducingSink  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public class C12ReducingSink implements AccumulatingSink<Double, OptionalDouble, C12ReducingSink>, Sink.OfDouble {
        private boolean empty;
        private double state;
        final /* synthetic */ DoubleBinaryOperator val$operator;

        @Override // j$.util.stream.Sink
        public /* synthetic */ void accept(int i) {
            Sink.CC.$default$accept((Sink) this, i);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void accept(long j) {
            Sink.CC.$default$accept((Sink) this, j);
        }

        @Override // j$.util.stream.Sink.OfDouble
        public /* synthetic */ void accept(Double d) {
            Sink.OfDouble.CC.$default$accept((Sink.OfDouble) this, d);
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(Object obj) {
            Sink.OfDouble.CC.$default$accept(this, obj);
        }

        @Override // java.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer$CC.$default$andThen(this, consumer);
        }

        @Override // java.util.function.DoubleConsumer
        public /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
            return DoubleConsumer$CC.$default$andThen(this, doubleConsumer);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ boolean cancellationRequested() {
            return Sink.CC.$default$cancellationRequested(this);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void end() {
            Sink.CC.$default$end(this);
        }

        C12ReducingSink(DoubleBinaryOperator doubleBinaryOperator) {
            this.val$operator = doubleBinaryOperator;
        }

        @Override // j$.util.stream.Sink
        public void begin(long size) {
            this.empty = true;
            this.state = 0.0d;
        }

        @Override // j$.util.stream.Sink, java.util.function.DoubleConsumer
        public void accept(double t) {
            if (this.empty) {
                this.empty = false;
                this.state = t;
                return;
            }
            this.state = this.val$operator.applyAsDouble(this.state, t);
        }

        @Override // java.util.function.Supplier
        public OptionalDouble get() {
            return this.empty ? OptionalDouble.empty() : OptionalDouble.of(this.state);
        }

        @Override // j$.util.stream.ReduceOps.AccumulatingSink
        public void combine(C12ReducingSink other) {
            if (!other.empty) {
                accept(other.state);
            }
        }
    }

    public static TerminalOp<Double, OptionalDouble> makeDouble(final DoubleBinaryOperator operator) {
        Objects.requireNonNull(operator);
        return new ReduceOp<Double, OptionalDouble, C12ReducingSink>(StreamShape.DOUBLE_VALUE) { // from class: j$.util.stream.ReduceOps.15
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // j$.util.stream.ReduceOps.ReduceOp
            public C12ReducingSink makeSink() {
                return new C12ReducingSink(operator);
            }
        };
    }

    public static <R> TerminalOp<Double, R> makeDouble(final Supplier<R> supplier, final ObjDoubleConsumer<R> accumulator, final BinaryOperator<R> combiner) {
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(accumulator);
        Objects.requireNonNull(combiner);
        return new ReduceOp<Double, R, C13ReducingSink>(StreamShape.DOUBLE_VALUE) { // from class: j$.util.stream.ReduceOps.16
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // j$.util.stream.ReduceOps.ReduceOp
            public C13ReducingSink makeSink() {
                return new C13ReducingSink(supplier, accumulator, combiner);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* renamed from: j$.util.stream.ReduceOps$13ReducingSink  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public class C13ReducingSink<R> extends Box<R> implements AccumulatingSink<Double, R, C13ReducingSink>, Sink.OfDouble {
        final /* synthetic */ ObjDoubleConsumer val$accumulator;
        final /* synthetic */ BinaryOperator val$combiner;
        final /* synthetic */ Supplier val$supplier;

        @Override // j$.util.stream.Sink
        public /* synthetic */ void accept(int i) {
            Sink.CC.$default$accept((Sink) this, i);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void accept(long j) {
            Sink.CC.$default$accept((Sink) this, j);
        }

        @Override // j$.util.stream.Sink.OfDouble
        public /* synthetic */ void accept(Double d) {
            Sink.OfDouble.CC.$default$accept((Sink.OfDouble) this, d);
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(Object obj) {
            Sink.OfDouble.CC.$default$accept(this, obj);
        }

        @Override // java.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer$CC.$default$andThen(this, consumer);
        }

        @Override // java.util.function.DoubleConsumer
        public /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
            return DoubleConsumer$CC.$default$andThen(this, doubleConsumer);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ boolean cancellationRequested() {
            return Sink.CC.$default$cancellationRequested(this);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void end() {
            Sink.CC.$default$end(this);
        }

        C13ReducingSink(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BinaryOperator binaryOperator) {
            this.val$supplier = supplier;
            this.val$accumulator = objDoubleConsumer;
            this.val$combiner = binaryOperator;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [U, java.lang.Object] */
        @Override // j$.util.stream.Sink
        public void begin(long size) {
            this.state = this.val$supplier.get();
        }

        @Override // j$.util.stream.Sink, java.util.function.DoubleConsumer
        public void accept(double t) {
            this.val$accumulator.accept(this.state, t);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [U, java.lang.Object] */
        @Override // j$.util.stream.ReduceOps.AccumulatingSink
        public void combine(C13ReducingSink other) {
            this.state = this.val$combiner.apply(this.state, other.state);
        }
    }

    public static TerminalOp<Double, Long> makeDoubleCounting() {
        return new ReduceOp<Double, Long, CountingSink<Double>>(StreamShape.DOUBLE_VALUE) { // from class: j$.util.stream.ReduceOps.17
            @Override // j$.util.stream.ReduceOps.ReduceOp, j$.util.stream.TerminalOp
            public /* bridge */ /* synthetic */ Object evaluateParallel(PipelineHelper pipelineHelper, Spliterator spliterator) {
                return evaluateParallel((PipelineHelper<Double>) pipelineHelper, spliterator);
            }

            @Override // j$.util.stream.ReduceOps.ReduceOp, j$.util.stream.TerminalOp
            public /* bridge */ /* synthetic */ Object evaluateSequential(PipelineHelper pipelineHelper, Spliterator spliterator) {
                return evaluateSequential((PipelineHelper<Double>) pipelineHelper, spliterator);
            }

            @Override // j$.util.stream.ReduceOps.ReduceOp
            public CountingSink<Double> makeSink() {
                return new CountingSink.OfDouble();
            }

            /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<java.lang.Double> */
            @Override // j$.util.stream.ReduceOps.ReduceOp, j$.util.stream.TerminalOp
            public <P_IN> Long evaluateSequential(PipelineHelper<Double> pipelineHelper, Spliterator<P_IN> spliterator) {
                if (StreamOpFlag.SIZED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return Long.valueOf(spliterator.getExactSizeIfKnown());
                }
                return (Long) super.evaluateSequential((PipelineHelper) pipelineHelper, (Spliterator) spliterator);
            }

            /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<java.lang.Double> */
            @Override // j$.util.stream.ReduceOps.ReduceOp, j$.util.stream.TerminalOp
            public <P_IN> Long evaluateParallel(PipelineHelper<Double> pipelineHelper, Spliterator<P_IN> spliterator) {
                if (StreamOpFlag.SIZED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return Long.valueOf(spliterator.getExactSizeIfKnown());
                }
                return (Long) super.evaluateParallel((PipelineHelper) pipelineHelper, (Spliterator) spliterator);
            }

            @Override // j$.util.stream.ReduceOps.ReduceOp, j$.util.stream.TerminalOp
            public int getOpFlags() {
                return StreamOpFlag.NOT_ORDERED;
            }
        };
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static abstract class CountingSink<T> extends Box<Long> implements AccumulatingSink<T, Long, CountingSink<T>> {
        long count;

        @Override // j$.util.stream.Sink, java.util.function.DoubleConsumer
        public /* synthetic */ void accept(double d) {
            Sink.CC.$default$accept(this, d);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void accept(int i) {
            Sink.CC.$default$accept((Sink) this, i);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void accept(long j) {
            Sink.CC.$default$accept((Sink) this, j);
        }

        @Override // java.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer$CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ boolean cancellationRequested() {
            return Sink.CC.$default$cancellationRequested(this);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void end() {
            Sink.CC.$default$end(this);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReduceOps$CountingSink != java.util.stream.ReduceOps$CountingSink<T> */
        CountingSink() {
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReduceOps$CountingSink != java.util.stream.ReduceOps$CountingSink<T> */
        @Override // j$.util.stream.ReduceOps.AccumulatingSink
        public /* bridge */ /* synthetic */ void combine(AccumulatingSink accumulatingSink) {
            combine((CountingSink) ((CountingSink) accumulatingSink));
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReduceOps$CountingSink != java.util.stream.ReduceOps$CountingSink<T> */
        @Override // j$.util.stream.Sink
        public void begin(long size) {
            this.count = 0L;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReduceOps$CountingSink != java.util.stream.ReduceOps$CountingSink<T> */
        @Override // j$.util.stream.ReduceOps.Box, java.util.function.Supplier
        public Long get() {
            return Long.valueOf(this.count);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReduceOps$CountingSink != java.util.stream.ReduceOps$CountingSink<T> */
        public void combine(CountingSink<T> countingSink) {
            this.count += countingSink.count;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public static final class OfRef<T> extends CountingSink<T> {
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReduceOps$CountingSink$OfRef != java.util.stream.ReduceOps$CountingSink$OfRef<T> */
            OfRef() {
            }

            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReduceOps$CountingSink$OfRef != java.util.stream.ReduceOps$CountingSink$OfRef<T> */
            @Override // java.util.function.Consumer
            public void accept(T t) {
                this.count++;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public static final class OfInt extends CountingSink<Integer> implements Sink.OfInt {
            @Override // j$.util.stream.Sink.OfInt
            public /* synthetic */ void accept(Integer num) {
                Sink.OfInt.CC.$default$accept((Sink.OfInt) this, num);
            }

            @Override // java.util.function.Consumer
            public /* bridge */ /* synthetic */ void accept(Object obj) {
                Sink.OfInt.CC.$default$accept(this, obj);
            }

            @Override // java.util.function.IntConsumer
            public /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
                return IntConsumer$CC.$default$andThen(this, intConsumer);
            }

            OfInt() {
            }

            @Override // j$.util.stream.ReduceOps.CountingSink, j$.util.stream.Sink
            public void accept(int t) {
                this.count++;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public static final class OfLong extends CountingSink<Long> implements Sink.OfLong {
            @Override // j$.util.stream.Sink.OfLong
            public /* synthetic */ void accept(Long l) {
                Sink.OfLong.CC.$default$accept((Sink.OfLong) this, l);
            }

            @Override // java.util.function.Consumer
            public /* bridge */ /* synthetic */ void accept(Object obj) {
                Sink.OfLong.CC.$default$accept(this, obj);
            }

            @Override // java.util.function.LongConsumer
            public /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
                return LongConsumer$CC.$default$andThen(this, longConsumer);
            }

            OfLong() {
            }

            @Override // j$.util.stream.ReduceOps.CountingSink, j$.util.stream.Sink
            public void accept(long t) {
                this.count++;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public static final class OfDouble extends CountingSink<Double> implements Sink.OfDouble {
            @Override // j$.util.stream.Sink.OfDouble
            public /* synthetic */ void accept(Double d) {
                Sink.OfDouble.CC.$default$accept((Sink.OfDouble) this, d);
            }

            @Override // java.util.function.Consumer
            public /* bridge */ /* synthetic */ void accept(Object obj) {
                Sink.OfDouble.CC.$default$accept(this, obj);
            }

            @Override // java.util.function.DoubleConsumer
            public /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
                return DoubleConsumer$CC.$default$andThen(this, doubleConsumer);
            }

            OfDouble() {
            }

            @Override // j$.util.stream.ReduceOps.CountingSink, j$.util.stream.Sink, java.util.function.DoubleConsumer
            public void accept(double t) {
                this.count++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static abstract class Box<U> {
        U state;

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReduceOps$Box != java.util.stream.ReduceOps$Box<U> */
        Box() {
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReduceOps$Box != java.util.stream.ReduceOps$Box<U> */
        public U get() {
            return this.state;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static abstract class ReduceOp<T, R, S extends AccumulatingSink<T, R, S>> implements TerminalOp<T, R> {
        private final StreamShape inputShape;

        @Override // j$.util.stream.TerminalOp
        public /* synthetic */ int getOpFlags() {
            return TerminalOp.CC.$default$getOpFlags(this);
        }

        public abstract S makeSink();

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReduceOps$ReduceOp != java.util.stream.ReduceOps$ReduceOp<T, R, S extends j$.util.stream.ReduceOps$AccumulatingSink<T, R, S>> */
        ReduceOp(StreamShape shape) {
            this.inputShape = shape;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReduceOps$ReduceOp != java.util.stream.ReduceOps$ReduceOp<T, R, S extends j$.util.stream.ReduceOps$AccumulatingSink<T, R, S>> */
        @Override // j$.util.stream.TerminalOp
        public StreamShape inputShape() {
            return this.inputShape;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<T> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReduceOps$ReduceOp != java.util.stream.ReduceOps$ReduceOp<T, R, S extends j$.util.stream.ReduceOps$AccumulatingSink<T, R, S>> */
        @Override // j$.util.stream.TerminalOp
        public <P_IN> R evaluateSequential(PipelineHelper<T> pipelineHelper, Spliterator<P_IN> spliterator) {
            return ((AccumulatingSink) pipelineHelper.wrapAndCopyInto(makeSink(), spliterator)).get();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<T> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReduceOps$ReduceOp != java.util.stream.ReduceOps$ReduceOp<T, R, S extends j$.util.stream.ReduceOps$AccumulatingSink<T, R, S>> */
        @Override // j$.util.stream.TerminalOp
        public <P_IN> R evaluateParallel(PipelineHelper<T> pipelineHelper, Spliterator<P_IN> spliterator) {
            return ((AccumulatingSink) new ReduceTask(this, pipelineHelper, spliterator).invoke()).get();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static final class ReduceTask<P_IN, P_OUT, R, S extends AccumulatingSink<P_OUT, R, S>> extends AbstractTask<P_IN, P_OUT, S, ReduceTask<P_IN, P_OUT, R, S>> {
        private final ReduceOp<P_OUT, R, S> op;

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<P_OUT> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReduceOps$ReduceOp != java.util.stream.ReduceOps$ReduceOp<P_OUT, R, S extends j$.util.stream.ReduceOps$AccumulatingSink<P_OUT, R, S>> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReduceOps$ReduceTask != java.util.stream.ReduceOps$ReduceTask<P_IN, P_OUT, R, S extends j$.util.stream.ReduceOps$AccumulatingSink<P_OUT, R, S>> */
        ReduceTask(ReduceOp<P_OUT, R, S> reduceOp, PipelineHelper<P_OUT> pipelineHelper, Spliterator<P_IN> spliterator) {
            super(pipelineHelper, spliterator);
            this.op = reduceOp;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReduceOps$ReduceTask != java.util.stream.ReduceOps$ReduceTask<P_IN, P_OUT, R, S extends j$.util.stream.ReduceOps$AccumulatingSink<P_OUT, R, S>> */
        ReduceTask(ReduceTask<P_IN, P_OUT, R, S> reduceTask, Spliterator<P_IN> spliterator) {
            super(reduceTask, spliterator);
            this.op = reduceTask.op;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReduceOps$ReduceTask != java.util.stream.ReduceOps$ReduceTask<P_IN, P_OUT, R, S extends j$.util.stream.ReduceOps$AccumulatingSink<P_OUT, R, S>> */
        @Override // j$.util.stream.AbstractTask
        public ReduceTask<P_IN, P_OUT, R, S> makeChild(Spliterator<P_IN> spliterator) {
            return new ReduceTask<>(this, spliterator);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReduceOps$ReduceTask != java.util.stream.ReduceOps$ReduceTask<P_IN, P_OUT, R, S extends j$.util.stream.ReduceOps$AccumulatingSink<P_OUT, R, S>> */
        @Override // j$.util.stream.AbstractTask
        public S doLeaf() {
            return (S) this.helper.wrapAndCopyInto(this.op.makeSink(), this.spliterator);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReduceOps$ReduceTask != java.util.stream.ReduceOps$ReduceTask<P_IN, P_OUT, R, S extends j$.util.stream.ReduceOps$AccumulatingSink<P_OUT, R, S>> */
        @Override // j$.util.stream.AbstractTask, java.util.concurrent.CountedCompleter
        public void onCompletion(CountedCompleter<?> caller) {
            if (!isLeaf()) {
                AccumulatingSink accumulatingSink = (AccumulatingSink) ((ReduceTask) this.leftChild).getLocalResult();
                accumulatingSink.combine((AccumulatingSink) ((ReduceTask) this.rightChild).getLocalResult());
                setLocalResult(accumulatingSink);
            }
            super.onCompletion(caller);
        }
    }
}