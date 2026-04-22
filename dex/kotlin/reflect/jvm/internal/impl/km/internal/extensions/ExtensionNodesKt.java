package kotlin.reflect.jvm.internal.impl.km.internal.extensions;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.KmClass;
import kotlin.reflect.jvm.internal.impl.km.KmConstructor;
import kotlin.reflect.jvm.internal.impl.km.KmFunction;
import kotlin.reflect.jvm.internal.impl.km.KmPackage;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeParameter;

/* compiled from: ExtensionNodes.kt */
public final class ExtensionNodesKt {
    public static final KmClassExtension getExtension(KmClass $this$getExtension, KmExtensionType type) {
        Intrinsics.checkNotNullParameter($this$getExtension, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return (KmClassExtension) singleOfType($this$getExtension.getExtensions$kotlin_metadata(), type);
    }

    public static final KmPackageExtension getExtension(KmPackage $this$getExtension, KmExtensionType type) {
        Intrinsics.checkNotNullParameter($this$getExtension, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return (KmPackageExtension) singleOfType($this$getExtension.getExtensions$kotlin_metadata(), type);
    }

    public static final KmFunctionExtension getExtension(KmFunction $this$getExtension, KmExtensionType type) {
        Intrinsics.checkNotNullParameter($this$getExtension, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return (KmFunctionExtension) singleOfType($this$getExtension.getExtensions$kotlin_metadata(), type);
    }

    public static final KmPropertyExtension getExtension(KmProperty $this$getExtension, KmExtensionType type) {
        Intrinsics.checkNotNullParameter($this$getExtension, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return (KmPropertyExtension) singleOfType($this$getExtension.getExtensions$kotlin_metadata(), type);
    }

    public static final KmConstructorExtension getExtension(KmConstructor $this$getExtension, KmExtensionType type) {
        Intrinsics.checkNotNullParameter($this$getExtension, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return (KmConstructorExtension) singleOfType($this$getExtension.getExtensions$kotlin_metadata(), type);
    }

    public static final KmTypeParameterExtension getExtension(KmTypeParameter $this$getExtension, KmExtensionType type) {
        Intrinsics.checkNotNullParameter($this$getExtension, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return (KmTypeParameterExtension) singleOfType($this$getExtension.getExtensions$kotlin_metadata(), type);
    }

    public static final KmTypeExtension getExtension(KmType $this$getExtension, KmExtensionType type) {
        Intrinsics.checkNotNullParameter($this$getExtension, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return (KmTypeExtension) singleOfType($this$getExtension.getExtensions$kotlin_metadata(), type);
    }

    private static final <N extends KmExtension> N singleOfType(Collection<? extends N> collection, KmExtensionType type) {
        N n = null;
        for (N n2 : collection) {
            if (Intrinsics.areEqual(n2.getType(), type)) {
                if (n != null) {
                    throw new IllegalStateException("Multiple extensions handle the same extension type: " + type);
                }
                n = n2;
            }
        }
        if (n == null) {
            throw new IllegalStateException("No extensions handle the extension type: " + type);
        }
        return n;
    }
}