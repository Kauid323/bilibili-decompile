package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.KmClass;
import kotlin.reflect.jvm.internal.impl.km.KmConstructor;
import kotlin.reflect.jvm.internal.impl.km.KmFunction;
import kotlin.reflect.jvm.internal.impl.km.KmPackage;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeParameter;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.ExtensionNodesKt;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmClassExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmConstructorExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmFunctionExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPackageExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPropertyExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeParameterExtension;

/* compiled from: JvmExtensionNodes.kt */
public final class JvmExtensionNodesKt {
    public static final JvmClassExtension getJvm(KmClass $this$jvm) {
        Intrinsics.checkNotNullParameter($this$jvm, "<this>");
        KmClassExtension extension = ExtensionNodesKt.getExtension($this$jvm, JvmClassExtension.Companion.getTYPE());
        Intrinsics.checkNotNull(extension, "null cannot be cast to non-null type kotlin.metadata.jvm.internal.JvmClassExtension");
        return (JvmClassExtension) extension;
    }

    public static final JvmPackageExtension getJvm(KmPackage $this$jvm) {
        Intrinsics.checkNotNullParameter($this$jvm, "<this>");
        KmPackageExtension extension = ExtensionNodesKt.getExtension($this$jvm, JvmPackageExtension.TYPE);
        Intrinsics.checkNotNull(extension, "null cannot be cast to non-null type kotlin.metadata.jvm.internal.JvmPackageExtension");
        return (JvmPackageExtension) extension;
    }

    public static final JvmFunctionExtension getJvm(KmFunction $this$jvm) {
        Intrinsics.checkNotNullParameter($this$jvm, "<this>");
        KmFunctionExtension extension = ExtensionNodesKt.getExtension($this$jvm, JvmFunctionExtension.TYPE);
        Intrinsics.checkNotNull(extension, "null cannot be cast to non-null type kotlin.metadata.jvm.internal.JvmFunctionExtension");
        return (JvmFunctionExtension) extension;
    }

    public static final JvmPropertyExtension getJvm(KmProperty $this$jvm) {
        Intrinsics.checkNotNullParameter($this$jvm, "<this>");
        KmPropertyExtension extension = ExtensionNodesKt.getExtension($this$jvm, JvmPropertyExtension.TYPE);
        Intrinsics.checkNotNull(extension, "null cannot be cast to non-null type kotlin.metadata.jvm.internal.JvmPropertyExtension");
        return (JvmPropertyExtension) extension;
    }

    public static final JvmConstructorExtension getJvm(KmConstructor $this$jvm) {
        Intrinsics.checkNotNullParameter($this$jvm, "<this>");
        KmConstructorExtension extension = ExtensionNodesKt.getExtension($this$jvm, JvmConstructorExtension.TYPE);
        Intrinsics.checkNotNull(extension, "null cannot be cast to non-null type kotlin.metadata.jvm.internal.JvmConstructorExtension");
        return (JvmConstructorExtension) extension;
    }

    public static final JvmTypeParameterExtension getJvm(KmTypeParameter $this$jvm) {
        Intrinsics.checkNotNullParameter($this$jvm, "<this>");
        KmTypeParameterExtension extension = ExtensionNodesKt.getExtension($this$jvm, JvmTypeParameterExtension.TYPE);
        Intrinsics.checkNotNull(extension, "null cannot be cast to non-null type kotlin.metadata.jvm.internal.JvmTypeParameterExtension");
        return (JvmTypeParameterExtension) extension;
    }

    public static final JvmTypeExtension getJvm(KmType $this$jvm) {
        Intrinsics.checkNotNullParameter($this$jvm, "<this>");
        KmTypeExtension extension = ExtensionNodesKt.getExtension($this$jvm, JvmTypeExtension.TYPE);
        Intrinsics.checkNotNull(extension, "null cannot be cast to non-null type kotlin.metadata.jvm.internal.JvmTypeExtension");
        return (JvmTypeExtension) extension;
    }
}