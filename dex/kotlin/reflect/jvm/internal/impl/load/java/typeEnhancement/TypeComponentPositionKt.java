package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypeComponentPosition.kt */
public final class TypeComponentPositionKt {
    public static final boolean shouldEnhance(TypeComponentPosition $this$shouldEnhance) {
        Intrinsics.checkNotNullParameter($this$shouldEnhance, "<this>");
        return $this$shouldEnhance != TypeComponentPosition.INFLEXIBLE;
    }
}