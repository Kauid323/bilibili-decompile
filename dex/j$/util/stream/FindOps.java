package j$.util.stream;

import j$.util.Optional;
import j$.util.OptionalDouble;
import j$.util.OptionalInt;
import j$.util.OptionalLong;
import j$.util.Spliterator;
import j$.util.function.Consumer$CC;
import j$.util.function.DoubleConsumer$CC;
import j$.util.function.IntConsumer$CC;
import j$.util.function.LongConsumer$CC;
import j$.util.function.Predicate$CC;
import j$.util.stream.FindOps;
import j$.util.stream.Sink;
import java.util.concurrent.CountedCompleter;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

final class FindOps {
    private FindOps() {
    }

    public static <T> TerminalOp<T, Optional<T>> makeRef(boolean mustFindFirst) {
        return mustFindFirst ? (TerminalOp<T, Optional<T>>) FindSink.OfRef.OP_FIND_FIRST : (TerminalOp<T, Optional<T>>) FindSink.OfRef.OP_FIND_ANY;
    }

    public static TerminalOp<Integer, OptionalInt> makeInt(boolean mustFindFirst) {
        return mustFindFirst ? FindSink.OfInt.OP_FIND_FIRST : FindSink.OfInt.OP_FIND_ANY;
    }

    public static TerminalOp<Long, OptionalLong> makeLong(boolean mustFindFirst) {
        return mustFindFirst ? FindSink.OfLong.OP_FIND_FIRST : FindSink.OfLong.OP_FIND_ANY;
    }

    public static TerminalOp<Double, OptionalDouble> makeDouble(boolean mustFindFirst) {
        return mustFindFirst ? FindSink.OfDouble.OP_FIND_FIRST : FindSink.OfDouble.OP_FIND_ANY;
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    private static final class FindOp<T, O> implements TerminalOp<T, O> {
        final O emptyValue;
        final int opFlags;
        final Predicate<O> presentPredicate;
        private final StreamShape shape;
        final Supplier<TerminalSink<T, O>> sinkSupplier;

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FindOps$FindOp != java.util.stream.FindOps$FindOp<T, O> */
        FindOp(boolean mustFindFirst, StreamShape shape, O emptyValue, Predicate<O> presentPredicate, Supplier<TerminalSink<T, O>> supplier) {
            this.opFlags = StreamOpFlag.IS_SHORT_CIRCUIT | (mustFindFirst ? 0 : StreamOpFlag.NOT_ORDERED);
            this.shape = shape;
            this.emptyValue = emptyValue;
            this.presentPredicate = presentPredicate;
            this.sinkSupplier = supplier;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FindOps$FindOp != java.util.stream.FindOps$FindOp<T, O> */
        @Override // j$.util.stream.TerminalOp
        public int getOpFlags() {
            return this.opFlags;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FindOps$FindOp != java.util.stream.FindOps$FindOp<T, O> */
        @Override // j$.util.stream.TerminalOp
        public StreamShape inputShape() {
            return this.shape;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<S> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FindOps$FindOp != java.util.stream.FindOps$FindOp<T, O> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // j$.util.stream.TerminalOp
        public <S> O evaluateSequential(PipelineHelper<T> pipelineHelper, Spliterator<S> spliterator) {
            O result = (O) ((TerminalSink) pipelineHelper.wrapAndCopyInto(this.sinkSupplier.get(), spliterator)).get();
            return result != null ? result : this.emptyValue;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FindOps$FindOp != java.util.stream.FindOps$FindOp<T, O> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<T> */
        @Override // j$.util.stream.TerminalOp
        public <P_IN> O evaluateParallel(PipelineHelper<T> pipelineHelper, Spliterator<P_IN> spliterator) {
            boolean mustFindFirst = StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags());
            return (O) new FindTask(this, mustFindFirst, pipelineHelper, spliterator).invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static abstract class FindSink<T, O> implements TerminalSink<T, O> {
        boolean hasValue;
        T value;

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
        public /* synthetic */ void begin(long j) {
            Sink.CC.$default$begin(this, j);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void end() {
            Sink.CC.$default$end(this);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FindOps$FindSink != java.util.stream.FindOps$FindSink<T, O> */
        FindSink() {
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FindOps$FindSink != java.util.stream.FindOps$FindSink<T, O> */
        @Override // java.util.function.Consumer
        public void accept(T value) {
            if (!this.hasValue) {
                this.hasValue = true;
                this.value = value;
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FindOps$FindSink != java.util.stream.FindOps$FindSink<T, O> */
        @Override // j$.util.stream.Sink
        public boolean cancellationRequested() {
            return this.hasValue;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public static final class OfRef<T> extends FindSink<T, Optional<T>> {
            static final TerminalOp<?, ?> OP_FIND_FIRST = new FindOp(true, StreamShape.REFERENCE, Optional.empty(), new Predicate() { // from class: j$.util.stream.FindOps$FindSink$OfRef$$ExternalSyntheticLambda0
                @Override // java.util.function.Predicate
                public /* synthetic */ Predicate and(Predicate predicate) {
                    return Predicate$CC.$default$and(this, predicate);
                }

                @Override // java.util.function.Predicate
                public /* synthetic */ Predicate negate() {
                    return Predicate$CC.$default$negate(this);
                }

                @Override // java.util.function.Predicate
                public /* synthetic */ Predicate or(Predicate predicate) {
                    return Predicate$CC.$default$or(this, predicate);
                }

                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((Optional) obj).isPresent();
                }
            }, new Supplier() { // from class: j$.util.stream.FindOps$FindSink$OfRef$$ExternalSyntheticLambda1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return new FindOps.FindSink.OfRef();
                }
            });
            static final TerminalOp<?, ?> OP_FIND_ANY = new FindOp(false, StreamShape.REFERENCE, Optional.empty(), new Predicate() { // from class: j$.util.stream.FindOps$FindSink$OfRef$$ExternalSyntheticLambda0
                @Override // java.util.function.Predicate
                public /* synthetic */ Predicate and(Predicate predicate) {
                    return Predicate$CC.$default$and(this, predicate);
                }

                @Override // java.util.function.Predicate
                public /* synthetic */ Predicate negate() {
                    return Predicate$CC.$default$negate(this);
                }

                @Override // java.util.function.Predicate
                public /* synthetic */ Predicate or(Predicate predicate) {
                    return Predicate$CC.$default$or(this, predicate);
                }

                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((Optional) obj).isPresent();
                }
            }, new Supplier() { // from class: j$.util.stream.FindOps$FindSink$OfRef$$ExternalSyntheticLambda1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return new FindOps.FindSink.OfRef();
                }
            });

            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FindOps$FindSink$OfRef != java.util.stream.FindOps$FindSink$OfRef<T> */
            @Override // java.util.function.Supplier
            public Optional<T> get() {
                if (this.hasValue) {
                    return Optional.of(this.value);
                }
                return null;
            }
        }

        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        static final class OfInt extends FindSink<Integer, OptionalInt> implements Sink.OfInt {
            static final TerminalOp<Integer, OptionalInt> OP_FIND_FIRST = new FindOp(true, StreamShape.INT_VALUE, OptionalInt.empty(), new Predicate() { // from class: j$.util.stream.FindOps$FindSink$OfInt$$ExternalSyntheticLambda0
                @Override // java.util.function.Predicate
                public /* synthetic */ Predicate and(Predicate predicate) {
                    return Predicate$CC.$default$and(this, predicate);
                }

                @Override // java.util.function.Predicate
                public /* synthetic */ Predicate negate() {
                    return Predicate$CC.$default$negate(this);
                }

                @Override // java.util.function.Predicate
                public /* synthetic */ Predicate or(Predicate predicate) {
                    return Predicate$CC.$default$or(this, predicate);
                }

                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((OptionalInt) obj).isPresent();
                }
            }, new Supplier() { // from class: j$.util.stream.FindOps$FindSink$OfInt$$ExternalSyntheticLambda1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return new FindOps.FindSink.OfInt();
                }
            });
            static final TerminalOp<Integer, OptionalInt> OP_FIND_ANY = new FindOp(false, StreamShape.INT_VALUE, OptionalInt.empty(), new Predicate() { // from class: j$.util.stream.FindOps$FindSink$OfInt$$ExternalSyntheticLambda0
                @Override // java.util.function.Predicate
                public /* synthetic */ Predicate and(Predicate predicate) {
                    return Predicate$CC.$default$and(this, predicate);
                }

                @Override // java.util.function.Predicate
                public /* synthetic */ Predicate negate() {
                    return Predicate$CC.$default$negate(this);
                }

                @Override // java.util.function.Predicate
                public /* synthetic */ Predicate or(Predicate predicate) {
                    return Predicate$CC.$default$or(this, predicate);
                }

                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((OptionalInt) obj).isPresent();
                }
            }, new Supplier() { // from class: j$.util.stream.FindOps$FindSink$OfInt$$ExternalSyntheticLambda1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return new FindOps.FindSink.OfInt();
                }
            });

            @Override // java.util.function.IntConsumer
            public /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
                return IntConsumer$CC.$default$andThen(this, intConsumer);
            }

            @Override // j$.util.stream.Sink.OfInt
            public /* bridge */ /* synthetic */ void accept(Integer num) {
                super.accept((OfInt) num);
            }

            @Override // j$.util.stream.FindOps.FindSink, j$.util.stream.Sink
            public void accept(int value) {
                accept((OfInt) Integer.valueOf(value));
            }

            @Override // java.util.function.Supplier
            public OptionalInt get() {
                if (this.hasValue) {
                    return OptionalInt.of(((Integer) this.value).intValue());
                }
                return null;
            }
        }

        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        static final class OfLong extends FindSink<Long, OptionalLong> implements Sink.OfLong {
            static final TerminalOp<Long, OptionalLong> OP_FIND_FIRST = new FindOp(true, StreamShape.LONG_VALUE, OptionalLong.empty(), new Predicate() { // from class: j$.util.stream.FindOps$FindSink$OfLong$$ExternalSyntheticLambda0
                @Override // java.util.function.Predicate
                public /* synthetic */ Predicate and(Predicate predicate) {
                    return Predicate$CC.$default$and(this, predicate);
                }

                @Override // java.util.function.Predicate
                public /* synthetic */ Predicate negate() {
                    return Predicate$CC.$default$negate(this);
                }

                @Override // java.util.function.Predicate
                public /* synthetic */ Predicate or(Predicate predicate) {
                    return Predicate$CC.$default$or(this, predicate);
                }

                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((OptionalLong) obj).isPresent();
                }
            }, new Supplier() { // from class: j$.util.stream.FindOps$FindSink$OfLong$$ExternalSyntheticLambda1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return new FindOps.FindSink.OfLong();
                }
            });
            static final TerminalOp<Long, OptionalLong> OP_FIND_ANY = new FindOp(false, StreamShape.LONG_VALUE, OptionalLong.empty(), new Predicate() { // from class: j$.util.stream.FindOps$FindSink$OfLong$$ExternalSyntheticLambda0
                @Override // java.util.function.Predicate
                public /* synthetic */ Predicate and(Predicate predicate) {
                    return Predicate$CC.$default$and(this, predicate);
                }

                @Override // java.util.function.Predicate
                public /* synthetic */ Predicate negate() {
                    return Predicate$CC.$default$negate(this);
                }

                @Override // java.util.function.Predicate
                public /* synthetic */ Predicate or(Predicate predicate) {
                    return Predicate$CC.$default$or(this, predicate);
                }

                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((OptionalLong) obj).isPresent();
                }
            }, new Supplier() { // from class: j$.util.stream.FindOps$FindSink$OfLong$$ExternalSyntheticLambda1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return new FindOps.FindSink.OfLong();
                }
            });

            @Override // java.util.function.LongConsumer
            public /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
                return LongConsumer$CC.$default$andThen(this, longConsumer);
            }

            @Override // j$.util.stream.Sink.OfLong
            public /* bridge */ /* synthetic */ void accept(Long l) {
                super.accept((OfLong) l);
            }

            @Override // j$.util.stream.FindOps.FindSink, j$.util.stream.Sink
            public void accept(long value) {
                accept((OfLong) Long.valueOf(value));
            }

            @Override // java.util.function.Supplier
            public OptionalLong get() {
                if (this.hasValue) {
                    return OptionalLong.of(((Long) this.value).longValue());
                }
                return null;
            }
        }

        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        static final class OfDouble extends FindSink<Double, OptionalDouble> implements Sink.OfDouble {
            static final TerminalOp<Double, OptionalDouble> OP_FIND_FIRST = new FindOp(true, StreamShape.DOUBLE_VALUE, OptionalDouble.empty(), new Predicate() { // from class: j$.util.stream.FindOps$FindSink$OfDouble$$ExternalSyntheticLambda0
                @Override // java.util.function.Predicate
                public /* synthetic */ Predicate and(Predicate predicate) {
                    return Predicate$CC.$default$and(this, predicate);
                }

                @Override // java.util.function.Predicate
                public /* synthetic */ Predicate negate() {
                    return Predicate$CC.$default$negate(this);
                }

                @Override // java.util.function.Predicate
                public /* synthetic */ Predicate or(Predicate predicate) {
                    return Predicate$CC.$default$or(this, predicate);
                }

                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((OptionalDouble) obj).isPresent();
                }
            }, new Supplier() { // from class: j$.util.stream.FindOps$FindSink$OfDouble$$ExternalSyntheticLambda1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return new FindOps.FindSink.OfDouble();
                }
            });
            static final TerminalOp<Double, OptionalDouble> OP_FIND_ANY = new FindOp(false, StreamShape.DOUBLE_VALUE, OptionalDouble.empty(), new Predicate() { // from class: j$.util.stream.FindOps$FindSink$OfDouble$$ExternalSyntheticLambda0
                @Override // java.util.function.Predicate
                public /* synthetic */ Predicate and(Predicate predicate) {
                    return Predicate$CC.$default$and(this, predicate);
                }

                @Override // java.util.function.Predicate
                public /* synthetic */ Predicate negate() {
                    return Predicate$CC.$default$negate(this);
                }

                @Override // java.util.function.Predicate
                public /* synthetic */ Predicate or(Predicate predicate) {
                    return Predicate$CC.$default$or(this, predicate);
                }

                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((OptionalDouble) obj).isPresent();
                }
            }, new Supplier() { // from class: j$.util.stream.FindOps$FindSink$OfDouble$$ExternalSyntheticLambda1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return new FindOps.FindSink.OfDouble();
                }
            });

            @Override // java.util.function.DoubleConsumer
            public /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
                return DoubleConsumer$CC.$default$andThen(this, doubleConsumer);
            }

            @Override // j$.util.stream.Sink.OfDouble
            public /* bridge */ /* synthetic */ void accept(Double d) {
                super.accept((OfDouble) d);
            }

            @Override // j$.util.stream.FindOps.FindSink, j$.util.stream.Sink, java.util.function.DoubleConsumer
            public void accept(double value) {
                accept((OfDouble) Double.valueOf(value));
            }

            @Override // java.util.function.Supplier
            public OptionalDouble get() {
                if (this.hasValue) {
                    return OptionalDouble.of(((Double) this.value).doubleValue());
                }
                return null;
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    private static final class FindTask<P_IN, P_OUT, O> extends AbstractShortCircuitTask<P_IN, P_OUT, O, FindTask<P_IN, P_OUT, O>> {
        private final boolean mustFindFirst;
        private final FindOp<P_OUT, O> op;

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FindOps$FindOp != java.util.stream.FindOps$FindOp<P_OUT, O> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FindOps$FindTask != java.util.stream.FindOps$FindTask<P_IN, P_OUT, O> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<P_OUT> */
        FindTask(FindOp<P_OUT, O> findOp, boolean mustFindFirst, PipelineHelper<P_OUT> pipelineHelper, Spliterator<P_IN> spliterator) {
            super(pipelineHelper, spliterator);
            this.mustFindFirst = mustFindFirst;
            this.op = findOp;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FindOps$FindTask != java.util.stream.FindOps$FindTask<P_IN, P_OUT, O> */
        FindTask(FindTask<P_IN, P_OUT, O> findTask, Spliterator<P_IN> spliterator) {
            super(findTask, spliterator);
            this.mustFindFirst = findTask.mustFindFirst;
            this.op = findTask.op;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FindOps$FindTask != java.util.stream.FindOps$FindTask<P_IN, P_OUT, O> */
        @Override // j$.util.stream.AbstractTask
        public FindTask<P_IN, P_OUT, O> makeChild(Spliterator<P_IN> spliterator) {
            return new FindTask<>(this, spliterator);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FindOps$FindTask != java.util.stream.FindOps$FindTask<P_IN, P_OUT, O> */
        @Override // j$.util.stream.AbstractShortCircuitTask
        protected O getEmptyResult() {
            return this.op.emptyValue;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FindOps$FindTask != java.util.stream.FindOps$FindTask<P_IN, P_OUT, O> */
        private void foundResult(O answer) {
            if (isLeftmostNode()) {
                shortCircuit(answer);
            } else {
                cancelLaterNodes();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FindOps$FindTask != java.util.stream.FindOps$FindTask<P_IN, P_OUT, O> */
        @Override // j$.util.stream.AbstractTask
        public O doLeaf() {
            O result = (O) ((TerminalSink) this.helper.wrapAndCopyInto(this.op.sinkSupplier.get(), this.spliterator)).get();
            if (!this.mustFindFirst) {
                if (result != null) {
                    shortCircuit(result);
                }
                return null;
            } else if (result != null) {
                foundResult(result);
                return result;
            } else {
                return null;
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FindOps$FindTask != java.util.stream.FindOps$FindTask<P_IN, P_OUT, O> */
        @Override // j$.util.stream.AbstractTask, java.util.concurrent.CountedCompleter
        public void onCompletion(CountedCompleter<?> caller) {
            if (this.mustFindFirst) {
                FindTask findTask = (FindTask) this.leftChild;
                FindTask findTask2 = null;
                while (true) {
                    if (findTask != findTask2) {
                        O result = findTask.getLocalResult();
                        if (result == null || !this.op.presentPredicate.test(result)) {
                            findTask2 = findTask;
                            findTask = (FindTask) this.rightChild;
                        } else {
                            setLocalResult(result);
                            foundResult(result);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            super.onCompletion(caller);
        }
    }
}