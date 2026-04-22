package j$.util;

import j$.util.Spliterator;
import j$.util.function.IntConsumer$CC;
import j$.util.stream.DoubleStream;
import j$.util.stream.IntStream;
import j$.util.stream.LongStream;
import j$.util.stream.Stream;
import j$.util.stream.StreamSupport;
import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;

public final /* synthetic */ class DesugarArrays {
    private DesugarArrays() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean deepEquals0(Object e1, Object e2) {
        if (e1 == null) {
            throw new NullPointerException("e1 is null!");
        }
        if ((e1 instanceof Object[]) && (e2 instanceof Object[])) {
            boolean eq = Arrays.deepEquals((Object[]) e1, (Object[]) e2);
            return eq;
        }
        boolean eq2 = e1 instanceof byte[];
        if (eq2 && (e2 instanceof byte[])) {
            boolean eq3 = Arrays.equals((byte[]) e1, (byte[]) e2);
            return eq3;
        }
        boolean eq4 = e1 instanceof short[];
        if (eq4 && (e2 instanceof short[])) {
            boolean eq5 = Arrays.equals((short[]) e1, (short[]) e2);
            return eq5;
        }
        boolean eq6 = e1 instanceof int[];
        if (eq6 && (e2 instanceof int[])) {
            boolean eq7 = Arrays.equals((int[]) e1, (int[]) e2);
            return eq7;
        }
        boolean eq8 = e1 instanceof long[];
        if (eq8 && (e2 instanceof long[])) {
            boolean eq9 = Arrays.equals((long[]) e1, (long[]) e2);
            return eq9;
        }
        boolean eq10 = e1 instanceof char[];
        if (eq10 && (e2 instanceof char[])) {
            boolean eq11 = Arrays.equals((char[]) e1, (char[]) e2);
            return eq11;
        }
        boolean eq12 = e1 instanceof float[];
        if (eq12 && (e2 instanceof float[])) {
            boolean eq13 = Arrays.equals((float[]) e1, (float[]) e2);
            return eq13;
        }
        boolean eq14 = e1 instanceof double[];
        if (eq14 && (e2 instanceof double[])) {
            boolean eq15 = Arrays.equals((double[]) e1, (double[]) e2);
            return eq15;
        }
        boolean eq16 = e1 instanceof boolean[];
        if (eq16 && (e2 instanceof boolean[])) {
            boolean eq17 = Arrays.equals((boolean[]) e1, (boolean[]) e2);
            return eq17;
        }
        boolean eq18 = e1.equals(e2);
        return eq18;
    }

    public static <T> void setAll(T[] array, IntFunction<? extends T> generator) {
        Objects.requireNonNull(generator);
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.apply(i);
        }
    }

    public static <T> void parallelSetAll(final T[] array, final IntFunction<? extends T> generator) {
        Objects.requireNonNull(generator);
        IntStream.CC.range(0, array.length).parallel().forEach(new IntConsumer() { // from class: j$.util.DesugarArrays$$ExternalSyntheticLambda0
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                DesugarArrays.lambda$parallelSetAll$0(array, generator, i);
            }

            @Override // java.util.function.IntConsumer
            public /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
                return IntConsumer$CC.$default$andThen(this, intConsumer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$parallelSetAll$0(Object[] array, IntFunction generator, int i) {
        array[i] = generator.apply(i);
    }

    public static void setAll(int[] array, IntUnaryOperator generator) {
        Objects.requireNonNull(generator);
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.applyAsInt(i);
        }
    }

    public static void parallelSetAll(final int[] array, final IntUnaryOperator generator) {
        Objects.requireNonNull(generator);
        IntStream.CC.range(0, array.length).parallel().forEach(new IntConsumer() { // from class: j$.util.DesugarArrays$$ExternalSyntheticLambda3
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                DesugarArrays.lambda$parallelSetAll$1(array, generator, i);
            }

            @Override // java.util.function.IntConsumer
            public /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
                return IntConsumer$CC.$default$andThen(this, intConsumer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$parallelSetAll$1(int[] array, IntUnaryOperator generator, int i) {
        array[i] = generator.applyAsInt(i);
    }

    public static void setAll(long[] array, IntToLongFunction generator) {
        Objects.requireNonNull(generator);
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.applyAsLong(i);
        }
    }

    public static void parallelSetAll(final long[] array, final IntToLongFunction generator) {
        Objects.requireNonNull(generator);
        IntStream.CC.range(0, array.length).parallel().forEach(new IntConsumer() { // from class: j$.util.DesugarArrays$$ExternalSyntheticLambda2
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                DesugarArrays.lambda$parallelSetAll$2(array, generator, i);
            }

            @Override // java.util.function.IntConsumer
            public /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
                return IntConsumer$CC.$default$andThen(this, intConsumer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$parallelSetAll$2(long[] array, IntToLongFunction generator, int i) {
        array[i] = generator.applyAsLong(i);
    }

    public static void setAll(double[] array, IntToDoubleFunction generator) {
        Objects.requireNonNull(generator);
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.applyAsDouble(i);
        }
    }

    public static void parallelSetAll(final double[] array, final IntToDoubleFunction generator) {
        Objects.requireNonNull(generator);
        IntStream.CC.range(0, array.length).parallel().forEach(new IntConsumer() { // from class: j$.util.DesugarArrays$$ExternalSyntheticLambda1
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                DesugarArrays.lambda$parallelSetAll$3(array, generator, i);
            }

            @Override // java.util.function.IntConsumer
            public /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
                return IntConsumer$CC.$default$andThen(this, intConsumer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$parallelSetAll$3(double[] array, IntToDoubleFunction generator, int i) {
        array[i] = generator.applyAsDouble(i);
    }

    public static <T> Spliterator<T> spliterator(T[] array) {
        return Spliterators.spliterator(array, 1040);
    }

    public static <T> Spliterator<T> spliterator(T[] array, int startInclusive, int endExclusive) {
        return Spliterators.spliterator(array, startInclusive, endExclusive, 1040);
    }

    public static Spliterator.OfInt spliterator(int[] array) {
        return Spliterators.spliterator(array, 1040);
    }

    public static Spliterator.OfInt spliterator(int[] array, int startInclusive, int endExclusive) {
        return Spliterators.spliterator(array, startInclusive, endExclusive, 1040);
    }

    public static Spliterator.OfLong spliterator(long[] array) {
        return Spliterators.spliterator(array, 1040);
    }

    public static Spliterator.OfLong spliterator(long[] array, int startInclusive, int endExclusive) {
        return Spliterators.spliterator(array, startInclusive, endExclusive, 1040);
    }

    public static Spliterator.OfDouble spliterator(double[] array) {
        return Spliterators.spliterator(array, 1040);
    }

    public static Spliterator.OfDouble spliterator(double[] array, int startInclusive, int endExclusive) {
        return Spliterators.spliterator(array, startInclusive, endExclusive, 1040);
    }

    public static <T> Stream<T> stream(T[] array) {
        return stream(array, 0, array.length);
    }

    public static <T> Stream<T> stream(T[] array, int startInclusive, int endExclusive) {
        return StreamSupport.stream(spliterator(array, startInclusive, endExclusive), false);
    }

    public static IntStream stream(int[] array) {
        return stream(array, 0, array.length);
    }

    public static IntStream stream(int[] array, int startInclusive, int endExclusive) {
        return StreamSupport.intStream(spliterator(array, startInclusive, endExclusive), false);
    }

    public static LongStream stream(long[] array) {
        return stream(array, 0, array.length);
    }

    public static LongStream stream(long[] array, int startInclusive, int endExclusive) {
        return StreamSupport.longStream(spliterator(array, startInclusive, endExclusive), false);
    }

    public static DoubleStream stream(double[] array) {
        return stream(array, 0, array.length);
    }

    public static DoubleStream stream(double[] array, int startInclusive, int endExclusive) {
        return StreamSupport.doubleStream(spliterator(array, startInclusive, endExclusive), false);
    }
}