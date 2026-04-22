package j$.util.function;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/* renamed from: j$.util.function.UnaryOperator$-CC  reason: invalid class name */
public final /* synthetic */ class UnaryOperator$CC {
    public static <T> UnaryOperator<T> identity() {
        return new UnaryOperator() { // from class: j$.util.function.UnaryOperator$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return UnaryOperator$CC.lambda$identity$0(obj);
            }

            @Override // java.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function$CC.$default$compose(this, function);
            }
        };
    }

    public static /* synthetic */ Object lambda$identity$0(Object t) {
        return t;
    }
}