package j$.util.function;

import j$.util.Objects;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/* renamed from: j$.util.function.BinaryOperator$-CC  reason: invalid class name */
public final /* synthetic */ class BinaryOperator$CC {
    public static <T> BinaryOperator<T> minBy(final Comparator<? super T> comparator) {
        Objects.requireNonNull(comparator);
        return new BinaryOperator() { // from class: j$.util.function.BinaryOperator$$ExternalSyntheticLambda1
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return BinaryOperator$CC.lambda$minBy$0(comparator, obj, obj2);
            }
        };
    }

    public static /* synthetic */ Object lambda$minBy$0(Comparator comparator, Object a, Object b) {
        return comparator.compare(a, b) <= 0 ? a : b;
    }

    public static <T> BinaryOperator<T> maxBy(final Comparator<? super T> comparator) {
        Objects.requireNonNull(comparator);
        return new BinaryOperator() { // from class: j$.util.function.BinaryOperator$$ExternalSyntheticLambda0
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return BinaryOperator$CC.lambda$maxBy$1(comparator, obj, obj2);
            }
        };
    }

    public static /* synthetic */ Object lambda$maxBy$1(Comparator comparator, Object a, Object b) {
        return comparator.compare(a, b) >= 0 ? a : b;
    }
}