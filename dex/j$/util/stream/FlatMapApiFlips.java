package j$.util.stream;

import j$.util.ConversionRuntimeException;
import j$.util.function.Function$CC;
import j$.util.stream.DoubleStream;
import j$.util.stream.IntStream;
import j$.util.stream.LongStream;
import j$.util.stream.Stream;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.LongFunction;

public class FlatMapApiFlips {
    public static Function<?, ?> flipFunctionReturningStream(Function<?, ?> function) {
        return new FunctionStreamWrapper(function);
    }

    public static IntFunction<?> flipFunctionReturningStream(IntFunction<?> function) {
        return new IntFunctionStreamWrapper(function);
    }

    public static DoubleFunction<?> flipFunctionReturningStream(DoubleFunction<?> function) {
        return new DoubleFunctionStreamWrapper(function);
    }

    public static LongFunction<?> flipFunctionReturningStream(LongFunction<?> function) {
        return new LongFunctionStreamWrapper(function);
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static class FunctionStreamWrapper<T, R> implements Function<T, R> {
        public Function<T, R> function;

        @Override // java.util.function.Function
        public /* synthetic */ Function andThen(Function function) {
            return Function$CC.$default$andThen(this, function);
        }

        @Override // java.util.function.Function
        public /* synthetic */ Function compose(Function function) {
            return Function$CC.$default$compose(this, function);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FlatMapApiFlips$FunctionStreamWrapper != java.util.stream.FlatMapApiFlips$FunctionStreamWrapper<T, R> */
        public FunctionStreamWrapper(Function<T, R> function) {
            this.function = function;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FlatMapApiFlips$FunctionStreamWrapper != java.util.stream.FlatMapApiFlips$FunctionStreamWrapper<T, R> */
        private R flipStream(R maybeStream) {
            if (maybeStream == null) {
                return null;
            }
            if (maybeStream instanceof Stream) {
                return (R) Stream.Wrapper.convert((Stream) maybeStream);
            }
            if (maybeStream instanceof java.util.stream.Stream) {
                return (R) Stream.VivifiedWrapper.convert((java.util.stream.Stream) maybeStream);
            }
            if (maybeStream instanceof IntStream) {
                return (R) IntStream.Wrapper.convert((IntStream) maybeStream);
            }
            if (maybeStream instanceof java.util.stream.IntStream) {
                return (R) IntStream.VivifiedWrapper.convert((java.util.stream.IntStream) maybeStream);
            }
            if (maybeStream instanceof DoubleStream) {
                return (R) DoubleStream.Wrapper.convert((DoubleStream) maybeStream);
            }
            if (maybeStream instanceof java.util.stream.DoubleStream) {
                return (R) DoubleStream.VivifiedWrapper.convert((java.util.stream.DoubleStream) maybeStream);
            }
            if (maybeStream instanceof LongStream) {
                return (R) LongStream.Wrapper.convert((LongStream) maybeStream);
            }
            if (maybeStream instanceof java.util.stream.LongStream) {
                return (R) LongStream.VivifiedWrapper.convert((java.util.stream.LongStream) maybeStream);
            }
            throw ConversionRuntimeException.exception("java.util.stream.*Stream", maybeStream.getClass());
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FlatMapApiFlips$FunctionStreamWrapper != java.util.stream.FlatMapApiFlips$FunctionStreamWrapper<T, R> */
        @Override // java.util.function.Function
        public R apply(T arg) {
            return flipStream(this.function.apply(arg));
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static class IntFunctionStreamWrapper<R> implements IntFunction<R> {
        public IntFunction<R> function;

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FlatMapApiFlips$IntFunctionStreamWrapper != java.util.stream.FlatMapApiFlips$IntFunctionStreamWrapper<R> */
        public IntFunctionStreamWrapper(IntFunction<R> function) {
            this.function = function;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FlatMapApiFlips$IntFunctionStreamWrapper != java.util.stream.FlatMapApiFlips$IntFunctionStreamWrapper<R> */
        private R flipStream(R maybeStream) {
            if (maybeStream == null) {
                return null;
            }
            if (maybeStream instanceof IntStream) {
                return (R) IntStream.Wrapper.convert((IntStream) maybeStream);
            }
            if (maybeStream instanceof java.util.stream.IntStream) {
                return (R) IntStream.VivifiedWrapper.convert((java.util.stream.IntStream) maybeStream);
            }
            throw ConversionRuntimeException.exception("java.util.stream.IntStream", maybeStream.getClass());
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FlatMapApiFlips$IntFunctionStreamWrapper != java.util.stream.FlatMapApiFlips$IntFunctionStreamWrapper<R> */
        @Override // java.util.function.IntFunction
        public R apply(int arg) {
            return flipStream(this.function.apply(arg));
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static class DoubleFunctionStreamWrapper<R> implements DoubleFunction<R> {
        public DoubleFunction<R> function;

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FlatMapApiFlips$DoubleFunctionStreamWrapper != java.util.stream.FlatMapApiFlips$DoubleFunctionStreamWrapper<R> */
        public DoubleFunctionStreamWrapper(DoubleFunction<R> function) {
            this.function = function;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FlatMapApiFlips$DoubleFunctionStreamWrapper != java.util.stream.FlatMapApiFlips$DoubleFunctionStreamWrapper<R> */
        private R flipStream(R maybeStream) {
            if (maybeStream == null) {
                return null;
            }
            if (maybeStream instanceof DoubleStream) {
                return (R) DoubleStream.Wrapper.convert((DoubleStream) maybeStream);
            }
            if (maybeStream instanceof java.util.stream.DoubleStream) {
                return (R) DoubleStream.VivifiedWrapper.convert((java.util.stream.DoubleStream) maybeStream);
            }
            throw ConversionRuntimeException.exception("java.util.stream.DoubleStream", maybeStream.getClass());
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FlatMapApiFlips$DoubleFunctionStreamWrapper != java.util.stream.FlatMapApiFlips$DoubleFunctionStreamWrapper<R> */
        @Override // java.util.function.DoubleFunction
        public R apply(double arg) {
            return flipStream(this.function.apply(arg));
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static class LongFunctionStreamWrapper<R> implements LongFunction<R> {
        public LongFunction<R> function;

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FlatMapApiFlips$LongFunctionStreamWrapper != java.util.stream.FlatMapApiFlips$LongFunctionStreamWrapper<R> */
        public LongFunctionStreamWrapper(LongFunction<R> function) {
            this.function = function;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FlatMapApiFlips$LongFunctionStreamWrapper != java.util.stream.FlatMapApiFlips$LongFunctionStreamWrapper<R> */
        private R flipStream(R maybeStream) {
            if (maybeStream == null) {
                return null;
            }
            if (maybeStream instanceof LongStream) {
                return (R) LongStream.Wrapper.convert((LongStream) maybeStream);
            }
            if (maybeStream instanceof java.util.stream.LongStream) {
                return (R) LongStream.VivifiedWrapper.convert((java.util.stream.LongStream) maybeStream);
            }
            throw ConversionRuntimeException.exception("java.util.stream.LongStream", maybeStream.getClass());
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.FlatMapApiFlips$LongFunctionStreamWrapper != java.util.stream.FlatMapApiFlips$LongFunctionStreamWrapper<R> */
        @Override // java.util.function.LongFunction
        public R apply(long arg) {
            return flipStream(this.function.apply(arg));
        }
    }
}