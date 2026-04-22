package kotlin.reflect.jvm.internal.impl.km.internal.extensions;

import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: ExtensionNodes.kt */
public final class KmExtensionType {
    private final KClass<? extends KmExtension> klass;

    public KmExtensionType(KClass<? extends KmExtension> klass) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        this.klass = klass;
    }

    public boolean equals(Object other) {
        return (other instanceof KmExtensionType) && Intrinsics.areEqual(this.klass, ((KmExtensionType) other).klass);
    }

    public int hashCode() {
        return this.klass.hashCode();
    }

    public String toString() {
        String name = JvmClassMappingKt.getJavaClass((KClass) this.klass).getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
    }
}