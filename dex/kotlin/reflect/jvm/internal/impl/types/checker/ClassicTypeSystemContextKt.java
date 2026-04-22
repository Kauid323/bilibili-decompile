package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: ClassicTypeSystemContext.kt */
public final class ClassicTypeSystemContextKt {
    public static final /* synthetic */ UnwrappedType access$makeDefinitelyNotNullOrNotNullInternal(UnwrappedType type) {
        return makeDefinitelyNotNullOrNotNullInternal(type);
    }

    public static final UnwrappedType makeDefinitelyNotNullOrNotNullInternal(UnwrappedType type) {
        return SpecialTypesKt.makeDefinitelyNotNullOrNotNull$default(type, false, 1, null);
    }
}