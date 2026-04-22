package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.AbstractKType;

/* compiled from: KTypes.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0007¨\u0006\u0007"}, d2 = {"withNullability", "Lkotlin/reflect/KType;", "nullable", "", "isSubtypeOf", "other", "isSupertypeOf", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class KTypes {
    public static final KType withNullability(KType $this$withNullability, boolean nullable) {
        Intrinsics.checkNotNullParameter($this$withNullability, "<this>");
        return ((AbstractKType) $this$withNullability).makeNullableAsSpecified(nullable);
    }

    public static final boolean isSubtypeOf(KType $this$isSubtypeOf, KType other) {
        Intrinsics.checkNotNullParameter($this$isSubtypeOf, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return ((AbstractKType) $this$isSubtypeOf).isSubtypeOf((AbstractKType) other);
    }

    public static final boolean isSupertypeOf(KType $this$isSupertypeOf, KType other) {
        Intrinsics.checkNotNullParameter($this$isSupertypeOf, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return isSubtypeOf(other, $this$isSupertypeOf);
    }
}