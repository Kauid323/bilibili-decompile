package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer$CC;
import j$.util.function.DoubleConsumer$CC;
import j$.util.function.IntConsumer$CC;
import j$.util.function.LongConsumer$CC;
import j$.util.stream.Node;
import j$.util.stream.Sink;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;

/* JADX INFO: Access modifiers changed from: package-private */
public interface Node<T> {
    T[] asArray(IntFunction<T[]> intFunction);

    void copyInto(T[] tArr, int i);

    long count();

    void forEach(Consumer<? super T> consumer);

    Node<T> getChild(int i);

    int getChildCount();

    StreamShape getShape();

    Spliterator<T> spliterator();

    Node<T> truncate(long j, long j2, IntFunction<T[]> intFunction);

    /* renamed from: j$.util.stream.Node$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public final /* synthetic */ class CC {
        public static int $default$getChildCount(Node _this) {
            return 0;
        }

        public static Node $default$getChild(Node _this, int i) {
            throw new IndexOutOfBoundsException();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<T> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Node$Builder != java.util.stream.Node$Builder<T> */
        public static Node $default$truncate(Node _this, long from, long to, IntFunction intFunction) {
            if (from == 0 && to == _this.count()) {
                return _this;
            }
            Spliterator<T> spliterator = _this.spliterator();
            long size = to - from;
            Builder builder = Nodes.builder(size, intFunction);
            builder.begin(size);
            for (int i = 0; i < from && spliterator.tryAdvance(new Consumer() { // from class: j$.util.stream.Node$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    Node.CC.lambda$truncate$0(obj);
                }

                @Override // java.util.function.Consumer
                public /* synthetic */ Consumer andThen(Consumer consumer) {
                    return Consumer$CC.$default$andThen(this, consumer);
                }
            }); i++) {
            }
            if (to == _this.count()) {
                spliterator.forEachRemaining(builder);
            } else {
                for (int i2 = 0; i2 < size && spliterator.tryAdvance(builder); i2++) {
                }
            }
            builder.end();
            return builder.build();
        }

        public static /* synthetic */ void lambda$truncate$0(Object e) {
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public interface Builder<T> extends Sink<T> {
        Node<T> build();

        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public interface OfInt extends Builder<Integer>, Sink.OfInt {
            @Override // j$.util.stream.Node.Builder
            Node<Integer> build();

            /* renamed from: j$.util.stream.Node$Builder$OfInt$-CC  reason: invalid class name */
            /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
            public final /* synthetic */ class CC {
            }
        }

        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public interface OfLong extends Builder<Long>, Sink.OfLong {
            @Override // j$.util.stream.Node.Builder
            Node<Long> build();

            /* renamed from: j$.util.stream.Node$Builder$OfLong$-CC  reason: invalid class name */
            /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
            public final /* synthetic */ class CC {
            }
        }

        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public interface OfDouble extends Builder<Double>, Sink.OfDouble {
            @Override // j$.util.stream.Node.Builder
            Node<Double> build();

            /* renamed from: j$.util.stream.Node$Builder$OfDouble$-CC  reason: invalid class name */
            /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
            public final /* synthetic */ class CC {
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public interface OfPrimitive<T, T_CONS, T_ARR, T_SPLITR extends Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>, T_NODE extends OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, T_NODE>> extends Node<T> {
        @Override // j$.util.stream.Node
        T[] asArray(IntFunction<T[]> intFunction);

        T_ARR asPrimitiveArray();

        void copyInto(T_ARR t_arr, int i);

        void forEach(T_CONS t_cons);

        @Override // j$.util.stream.Node
        T_NODE getChild(int i);

        T_ARR newArray(int i);

        @Override // j$.util.stream.Node
        T_SPLITR spliterator();

        @Override // j$.util.stream.Node
        T_NODE truncate(long j, long j2, IntFunction<T[]> intFunction);

        /* renamed from: j$.util.stream.Node$OfPrimitive$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public final /* synthetic */ class CC {
            public static OfPrimitive $default$getChild(OfPrimitive _this, int i) {
                throw new IndexOutOfBoundsException();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static Object[] $default$asArray(OfPrimitive _this, IntFunction intFunction) {
                if (Tripwire.ENABLED) {
                    Tripwire.trip(_this.getClass(), "{0} calling Node.OfPrimitive.asArray");
                }
                long size = _this.count();
                if (size >= 2147483639) {
                    throw new IllegalArgumentException("Stream size exceeds max array size");
                }
                Object[] objArr = (Object[]) intFunction.apply((int) _this.count());
                _this.copyInto(objArr, 0);
                return objArr;
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public interface OfInt extends OfPrimitive<Integer, IntConsumer, int[], Spliterator.OfInt, OfInt> {
        void copyInto(Integer[] numArr, int i);

        @Override // j$.util.stream.Node
        void forEach(Consumer<? super Integer> consumer);

        @Override // j$.util.stream.Node
        StreamShape getShape();

        @Override // j$.util.stream.Node.OfPrimitive
        int[] newArray(int i);

        @Override // j$.util.stream.Node.OfPrimitive, j$.util.stream.Node
        OfInt truncate(long j, long j2, IntFunction<Integer[]> intFunction);

        /* renamed from: j$.util.stream.Node$OfInt$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public final /* synthetic */ class CC {
            public static void $default$forEach(OfInt _this, Consumer consumer) {
                if (consumer instanceof IntConsumer) {
                    _this.forEach((OfInt) ((IntConsumer) consumer));
                    return;
                }
                if (Tripwire.ENABLED) {
                    Tripwire.trip(_this.getClass(), "{0} calling Node.OfInt.forEachRemaining(Consumer)");
                }
                _this.spliterator().forEachRemaining((Consumer<? super Integer>) consumer);
            }

            public static void $default$copyInto(OfInt _this, Integer[] boxed, int offset) {
                if (Tripwire.ENABLED) {
                    Tripwire.trip(_this.getClass(), "{0} calling Node.OfInt.copyInto(Integer[], int)");
                }
                int[] array = _this.asPrimitiveArray();
                for (int i = 0; i < array.length; i++) {
                    boxed[offset + i] = Integer.valueOf(array[i]);
                }
            }

            /* JADX WARN: Type inference failed for: r4v7, types: [j$.util.stream.Node$OfInt] */
            public static OfInt $default$truncate(OfInt _this, long from, long to, IntFunction intFunction) {
                if (from == 0 && to == _this.count()) {
                    return _this;
                }
                long size = to - from;
                Spliterator.OfInt spliterator = _this.spliterator();
                Builder.OfInt nodeBuilder = Nodes.intBuilder(size);
                nodeBuilder.begin(size);
                for (int i = 0; i < from && spliterator.tryAdvance(new IntConsumer() { // from class: j$.util.stream.Node$OfInt$$ExternalSyntheticLambda0
                    @Override // java.util.function.IntConsumer
                    public final void accept(int i2) {
                        Node.OfInt.CC.lambda$truncate$0(i2);
                    }

                    @Override // java.util.function.IntConsumer
                    public /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
                        return IntConsumer$CC.$default$andThen(this, intConsumer);
                    }
                }); i++) {
                }
                if (to == _this.count()) {
                    spliterator.forEachRemaining((IntConsumer) nodeBuilder);
                } else {
                    for (int i2 = 0; i2 < size && spliterator.tryAdvance((IntConsumer) nodeBuilder); i2++) {
                    }
                }
                nodeBuilder.end();
                return nodeBuilder.build();
            }

            public static /* synthetic */ void lambda$truncate$0(int e) {
            }

            /* renamed from: $default$newArray  reason: collision with other method in class */
            public static int[] m60$default$newArray(OfInt _this, int count) {
                return new int[count];
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public interface OfLong extends OfPrimitive<Long, LongConsumer, long[], Spliterator.OfLong, OfLong> {
        void copyInto(Long[] lArr, int i);

        @Override // j$.util.stream.Node
        void forEach(Consumer<? super Long> consumer);

        @Override // j$.util.stream.Node
        StreamShape getShape();

        @Override // j$.util.stream.Node.OfPrimitive
        long[] newArray(int i);

        @Override // j$.util.stream.Node.OfPrimitive, j$.util.stream.Node
        OfLong truncate(long j, long j2, IntFunction<Long[]> intFunction);

        /* renamed from: j$.util.stream.Node$OfLong$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public final /* synthetic */ class CC {
            public static void $default$forEach(OfLong _this, Consumer consumer) {
                if (consumer instanceof LongConsumer) {
                    _this.forEach((OfLong) ((LongConsumer) consumer));
                    return;
                }
                if (Tripwire.ENABLED) {
                    Tripwire.trip(_this.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
                }
                _this.spliterator().forEachRemaining((Consumer<? super Long>) consumer);
            }

            public static void $default$copyInto(OfLong _this, Long[] boxed, int offset) {
                if (Tripwire.ENABLED) {
                    Tripwire.trip(_this.getClass(), "{0} calling Node.OfInt.copyInto(Long[], int)");
                }
                long[] array = _this.asPrimitiveArray();
                for (int i = 0; i < array.length; i++) {
                    boxed[offset + i] = Long.valueOf(array[i]);
                }
            }

            /* JADX WARN: Type inference failed for: r4v7, types: [j$.util.stream.Node$OfLong] */
            public static OfLong $default$truncate(OfLong _this, long from, long to, IntFunction intFunction) {
                if (from == 0 && to == _this.count()) {
                    return _this;
                }
                long size = to - from;
                Spliterator.OfLong spliterator = _this.spliterator();
                Builder.OfLong nodeBuilder = Nodes.longBuilder(size);
                nodeBuilder.begin(size);
                for (int i = 0; i < from && spliterator.tryAdvance(new LongConsumer() { // from class: j$.util.stream.Node$OfLong$$ExternalSyntheticLambda0
                    @Override // java.util.function.LongConsumer
                    public final void accept(long j) {
                        Node.OfLong.CC.lambda$truncate$0(j);
                    }

                    @Override // java.util.function.LongConsumer
                    public /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
                        return LongConsumer$CC.$default$andThen(this, longConsumer);
                    }
                }); i++) {
                }
                if (to == _this.count()) {
                    spliterator.forEachRemaining((LongConsumer) nodeBuilder);
                } else {
                    for (int i2 = 0; i2 < size && spliterator.tryAdvance((LongConsumer) nodeBuilder); i2++) {
                    }
                }
                nodeBuilder.end();
                return nodeBuilder.build();
            }

            public static /* synthetic */ void lambda$truncate$0(long e) {
            }

            /* renamed from: $default$newArray  reason: collision with other method in class */
            public static long[] m63$default$newArray(OfLong _this, int count) {
                return new long[count];
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public interface OfDouble extends OfPrimitive<Double, DoubleConsumer, double[], Spliterator.OfDouble, OfDouble> {
        void copyInto(Double[] dArr, int i);

        @Override // j$.util.stream.Node
        void forEach(Consumer<? super Double> consumer);

        @Override // j$.util.stream.Node
        StreamShape getShape();

        @Override // j$.util.stream.Node.OfPrimitive
        double[] newArray(int i);

        @Override // j$.util.stream.Node.OfPrimitive, j$.util.stream.Node
        OfDouble truncate(long j, long j2, IntFunction<Double[]> intFunction);

        /* renamed from: j$.util.stream.Node$OfDouble$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public final /* synthetic */ class CC {
            public static void $default$forEach(OfDouble _this, Consumer consumer) {
                if (consumer instanceof DoubleConsumer) {
                    _this.forEach((OfDouble) ((DoubleConsumer) consumer));
                    return;
                }
                if (Tripwire.ENABLED) {
                    Tripwire.trip(_this.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
                }
                _this.spliterator().forEachRemaining((Consumer<? super Double>) consumer);
            }

            public static void $default$copyInto(OfDouble _this, Double[] boxed, int offset) {
                if (Tripwire.ENABLED) {
                    Tripwire.trip(_this.getClass(), "{0} calling Node.OfDouble.copyInto(Double[], int)");
                }
                double[] array = _this.asPrimitiveArray();
                for (int i = 0; i < array.length; i++) {
                    boxed[offset + i] = Double.valueOf(array[i]);
                }
            }

            /* JADX WARN: Type inference failed for: r4v7, types: [j$.util.stream.Node$OfDouble] */
            public static OfDouble $default$truncate(OfDouble _this, long from, long to, IntFunction intFunction) {
                if (from == 0 && to == _this.count()) {
                    return _this;
                }
                long size = to - from;
                Spliterator.OfDouble spliterator = _this.spliterator();
                Builder.OfDouble nodeBuilder = Nodes.doubleBuilder(size);
                nodeBuilder.begin(size);
                for (int i = 0; i < from && spliterator.tryAdvance(new DoubleConsumer() { // from class: j$.util.stream.Node$OfDouble$$ExternalSyntheticLambda0
                    @Override // java.util.function.DoubleConsumer
                    public final void accept(double d) {
                        Node.OfDouble.CC.lambda$truncate$0(d);
                    }

                    @Override // java.util.function.DoubleConsumer
                    public /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
                        return DoubleConsumer$CC.$default$andThen(this, doubleConsumer);
                    }
                }); i++) {
                }
                if (to == _this.count()) {
                    spliterator.forEachRemaining((DoubleConsumer) nodeBuilder);
                } else {
                    for (int i2 = 0; i2 < size && spliterator.tryAdvance((DoubleConsumer) nodeBuilder); i2++) {
                    }
                }
                nodeBuilder.end();
                return nodeBuilder.build();
            }

            public static /* synthetic */ void lambda$truncate$0(double e) {
            }

            /* renamed from: $default$newArray  reason: collision with other method in class */
            public static double[] m57$default$newArray(OfDouble _this, int count) {
                return new double[count];
            }
        }
    }
}