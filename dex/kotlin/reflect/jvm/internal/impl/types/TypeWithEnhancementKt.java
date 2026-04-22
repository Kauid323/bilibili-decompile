package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypeWithEnhancement.kt */
public final class TypeWithEnhancementKt {
    public static final KotlinType getEnhancement(KotlinType $this$getEnhancement) {
        Intrinsics.checkNotNullParameter($this$getEnhancement, "<this>");
        if ($this$getEnhancement instanceof TypeWithEnhancement) {
            return ((TypeWithEnhancement) $this$getEnhancement).getEnhancement();
        }
        return null;
    }

    public static final UnwrappedType inheritEnhancement(UnwrappedType $this$inheritEnhancement, KotlinType origin, Function1<? super KotlinType, ? extends KotlinType> transform) {
        Intrinsics.checkNotNullParameter($this$inheritEnhancement, "<this>");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(transform, "transform");
        KotlinType enhancement = getEnhancement(origin);
        return wrapEnhancement($this$inheritEnhancement, enhancement != null ? transform.invoke(enhancement) : null);
    }

    public static final UnwrappedType inheritEnhancement(UnwrappedType $this$inheritEnhancement, KotlinType origin) {
        Intrinsics.checkNotNullParameter($this$inheritEnhancement, "<this>");
        Intrinsics.checkNotNullParameter(origin, "origin");
        return wrapEnhancement($this$inheritEnhancement, getEnhancement(origin));
    }

    public static final UnwrappedType wrapEnhancement(UnwrappedType $this$wrapEnhancement, KotlinType enhancement) {
        Intrinsics.checkNotNullParameter($this$wrapEnhancement, "<this>");
        if ($this$wrapEnhancement instanceof TypeWithEnhancement) {
            return wrapEnhancement(((TypeWithEnhancement) $this$wrapEnhancement).getOrigin(), enhancement);
        }
        if (enhancement == null || Intrinsics.areEqual(enhancement, $this$wrapEnhancement)) {
            return $this$wrapEnhancement;
        }
        if ($this$wrapEnhancement instanceof SimpleType) {
            return new SimpleTypeWithEnhancement((SimpleType) $this$wrapEnhancement, enhancement);
        }
        if ($this$wrapEnhancement instanceof FlexibleType) {
            return new FlexibleTypeWithEnhancement((FlexibleType) $this$wrapEnhancement, enhancement);
        }
        throw new NoWhenBranchMatchedException();
    }
}