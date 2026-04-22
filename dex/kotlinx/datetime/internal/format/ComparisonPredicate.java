package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Predicate.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\u0006\u0010\u0004\u001a\u00028\u0001\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\fR\u0010\u0010\u0004\u001a\u00028\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/datetime/internal/format/ComparisonPredicate;", "T", "E", "Lkotlinx/datetime/internal/format/Predicate;", "expectedValue", "getter", "Lkotlin/Function1;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Ljava/lang/Object;", "test", "", "value", "(Ljava/lang/Object;)Z", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ComparisonPredicate<T, E> implements Predicate<T> {
    private final E expectedValue;
    private final Function1<T, E> getter;

    /* JADX WARN: Multi-variable type inference failed */
    public ComparisonPredicate(E e, Function1<? super T, ? extends E> getter) {
        Intrinsics.checkNotNullParameter(getter, "getter");
        this.expectedValue = e;
        this.getter = getter;
    }

    @Override // kotlinx.datetime.internal.format.Predicate
    public boolean test(T t) {
        return Intrinsics.areEqual(this.getter.invoke(t), this.expectedValue);
    }
}