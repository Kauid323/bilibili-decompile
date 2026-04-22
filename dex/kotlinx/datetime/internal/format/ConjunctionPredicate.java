package kotlinx.datetime.internal.format;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Predicate.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\tR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlinx/datetime/internal/format/ConjunctionPredicate;", "T", "Lkotlinx/datetime/internal/format/Predicate;", "predicates", "", "(Ljava/util/List;)V", "test", "", "value", "(Ljava/lang/Object;)Z", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ConjunctionPredicate<T> implements Predicate<T> {
    private final List<Predicate<T>> predicates;

    /* JADX WARN: Multi-variable type inference failed */
    public ConjunctionPredicate(List<? extends Predicate<? super T>> predicates) {
        Intrinsics.checkNotNullParameter(predicates, "predicates");
        this.predicates = predicates;
    }

    @Override // kotlinx.datetime.internal.format.Predicate
    public boolean test(T t) {
        Iterable $this$all$iv = this.predicates;
        if (($this$all$iv instanceof Collection) && ((Collection) $this$all$iv).isEmpty()) {
            return true;
        }
        for (Object element$iv : $this$all$iv) {
            Predicate it = (Predicate) element$iv;
            if (!it.test(t)) {
                return false;
            }
        }
        return true;
    }
}