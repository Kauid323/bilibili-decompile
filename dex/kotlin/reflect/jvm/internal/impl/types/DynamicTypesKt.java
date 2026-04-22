package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: dynamicTypes.kt */
public final class DynamicTypesKt {
    public static final boolean isDynamic(KotlinType $this$isDynamic) {
        Intrinsics.checkNotNullParameter($this$isDynamic, "<this>");
        return $this$isDynamic.unwrap() instanceof DynamicType;
    }
}