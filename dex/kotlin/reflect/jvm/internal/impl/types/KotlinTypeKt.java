package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;

/* compiled from: KotlinType.kt */
public final class KotlinTypeKt {
    public static final boolean isNullable(KotlinType $this$isNullable) {
        Intrinsics.checkNotNullParameter($this$isNullable, "<this>");
        return TypeUtils.isNullableType($this$isNullable);
    }

    public static final boolean isError(KotlinType $this$isError) {
        Intrinsics.checkNotNullParameter($this$isError, "<this>");
        UnwrappedType unwrapped = $this$isError.unwrap();
        return (unwrapped instanceof ErrorType) || ((unwrapped instanceof FlexibleType) && (((FlexibleType) unwrapped).getDelegate() instanceof ErrorType));
    }
}