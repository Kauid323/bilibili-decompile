package j$.util.stream;

import j$.util.ConversionRuntimeException;
import j$.util.function.Function$CC;
import j$.util.stream.Stream;
import java.util.function.Function;

public class StackWalkerApiFlips {
    public static Function<?, ?> flipFunctionStream(Function<?, ?> stackWalker) {
        return new FunctionStreamWrapper(stackWalker);
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

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.StackWalkerApiFlips$FunctionStreamWrapper != java.util.stream.StackWalkerApiFlips$FunctionStreamWrapper<T, R> */
        public FunctionStreamWrapper(Function<T, R> function) {
            this.function = function;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.StackWalkerApiFlips$FunctionStreamWrapper != java.util.stream.StackWalkerApiFlips$FunctionStreamWrapper<T, R> */
        private T flipStream(T maybeStream) {
            if (maybeStream == null) {
                return null;
            }
            if (maybeStream instanceof Stream) {
                return (T) Stream.Wrapper.convert((Stream) maybeStream);
            }
            if (maybeStream instanceof java.util.stream.Stream) {
                return (T) Stream.VivifiedWrapper.convert((java.util.stream.Stream) maybeStream);
            }
            throw ConversionRuntimeException.exception("java.util.stream.Stream", maybeStream.getClass());
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.StackWalkerApiFlips$FunctionStreamWrapper != java.util.stream.StackWalkerApiFlips$FunctionStreamWrapper<T, R> */
        @Override // java.util.function.Function
        public R apply(T arg) {
            return this.function.apply(flipStream(arg));
        }
    }
}