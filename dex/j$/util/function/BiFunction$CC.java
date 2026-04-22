package j$.util.function;

import j$.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

/* renamed from: j$.util.function.BiFunction$-CC  reason: invalid class name */
public final /* synthetic */ class BiFunction$CC {
    public static BiFunction $default$andThen(final BiFunction _this, final Function function) {
        Objects.requireNonNull(function);
        return new BiFunction() { // from class: j$.util.function.BiFunction$$ExternalSyntheticLambda0
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function2) {
                return BiFunction$CC.$default$andThen(this, function2);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Object apply;
                apply = function.apply(BiFunction.this.apply(obj, obj2));
                return apply;
            }
        };
    }
}