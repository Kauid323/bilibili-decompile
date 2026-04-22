package kotlinx.serialization.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.SerializationException;

/* compiled from: AbstractPolymorphicSerializer.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0001\u001a \u0010\u0000\u001a\u00020\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0001¨\u0006\u0007"}, d2 = {"throwSubtypeNotRegistered", "", "subClassName", "", "baseClass", "Lkotlin/reflect/KClass;", "subClass", "kotlinx-serialization-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AbstractPolymorphicSerializerKt {
    public static final Void throwSubtypeNotRegistered(String subClassName, KClass<?> baseClass) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        String scope = "in the scope of '" + baseClass.getSimpleName() + '\'';
        throw new SerializationException(subClassName == null ? "Class discriminator was missing and no default polymorphic serializers were registered " + scope : "Class '" + subClassName + "' is not registered for polymorphic serialization " + scope + ".\nTo be registered automatically, class '" + subClassName + "' has to be '@Serializable', and the base class '" + baseClass.getSimpleName() + "' has to be sealed and '@Serializable'.\nAlternatively, register the serializer for '" + subClassName + "' explicitly in a corresponding SerializersModule.");
    }

    public static final Void throwSubtypeNotRegistered(KClass<?> subClass, KClass<?> baseClass) {
        Intrinsics.checkNotNullParameter(subClass, "subClass");
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        String simpleName = subClass.getSimpleName();
        if (simpleName == null) {
            simpleName = String.valueOf(subClass);
        }
        throwSubtypeNotRegistered(simpleName, baseClass);
        throw new KotlinNothingValueException();
    }
}