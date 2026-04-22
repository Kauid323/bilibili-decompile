package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypeCapabilities.kt */
public final class TypeCapabilitiesKt {
    public static final boolean isCustomTypeParameter(KotlinType $this$isCustomTypeParameter) {
        Intrinsics.checkNotNullParameter($this$isCustomTypeParameter, "<this>");
        UnwrappedType unwrap = $this$isCustomTypeParameter.unwrap();
        CustomTypeParameter customTypeParameter = unwrap instanceof CustomTypeParameter ? (CustomTypeParameter) unwrap : null;
        if (customTypeParameter != null) {
            return customTypeParameter.isTypeParameter();
        }
        return false;
    }

    public static final CustomTypeParameter getCustomTypeParameter(KotlinType $this$getCustomTypeParameter) {
        Intrinsics.checkNotNullParameter($this$getCustomTypeParameter, "<this>");
        UnwrappedType unwrap = $this$getCustomTypeParameter.unwrap();
        CustomTypeParameter it = unwrap instanceof CustomTypeParameter ? (CustomTypeParameter) unwrap : null;
        if (it == null || !it.isTypeParameter()) {
            return null;
        }
        return it;
    }
}