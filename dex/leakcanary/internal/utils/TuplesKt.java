package leakcanary.internal.utils;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Tuples.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aJ\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u0006\u001a\u0002H\u0004H\u0080\u0004¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"to", "Lkotlin/Triple;", "A", "B", "C", "Lkotlin/Pair;", "that", "(Lkotlin/Pair;Ljava/lang/Object;)Lkotlin/Triple;", "leakcanary-android-core_release"}, k = 2, mv = {1, 4, 1})
public final class TuplesKt {
    public static final <A, B, C> Triple<A, B, C> to(Pair<? extends A, ? extends B> to, C c) {
        Intrinsics.checkParameterIsNotNull(to, "$this$to");
        return new Triple<>(to.getFirst(), to.getSecond(), c);
    }
}