package j$.util.function;

import j$.util.Objects;
import java.util.function.Function;

/* renamed from: j$.util.function.Function$-CC  reason: invalid class name */
public final /* synthetic */ class Function$CC {
    public static Function $default$compose(final Function _this, final Function function) {
        Objects.requireNonNull(function);
        return new Function() { // from class: j$.util.function.Function$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function2) {
                return Function$CC.$default$andThen(this, function2);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Object apply;
                apply = Function.this.apply(function.apply(obj));
                return apply;
            }

            @Override // java.util.function.Function
            public /* synthetic */ Function compose(Function function2) {
                return Function$CC.$default$compose(this, function2);
            }
        };
    }

    public static Function $default$andThen(final Function _this, final Function function) {
        Objects.requireNonNull(function);
        return new Function() { // from class: j$.util.function.Function$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function2) {
                return Function$CC.$default$andThen(this, function2);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Object apply;
                apply = function.apply(Function.this.apply(obj));
                return apply;
            }

            @Override // java.util.function.Function
            public /* synthetic */ Function compose(Function function2) {
                return Function$CC.$default$compose(this, function2);
            }
        };
    }

    public static <T> Function<T, T> identity() {
        return new Function() { // from class: j$.util.function.Function$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Function$CC.lambda$identity$2(obj);
            }

            @Override // java.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function$CC.$default$compose(this, function);
            }
        };
    }

    public static /* synthetic */ Object lambda$identity$2(Object t) {
        return t;
    }
}