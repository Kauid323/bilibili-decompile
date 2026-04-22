package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;

/* compiled from: utils.kt */
public final class UtilsKt {
    public static final DescriptorVisibility toDescriptorVisibility(Visibility $this$toDescriptorVisibility) {
        Intrinsics.checkNotNullParameter($this$toDescriptorVisibility, "<this>");
        DescriptorVisibility descriptorVisibility = JavaDescriptorVisibilities.toDescriptorVisibility($this$toDescriptorVisibility);
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "toDescriptorVisibility(...)");
        return descriptorVisibility;
    }

    public static final boolean isJspecifyEnabledInStrictMode(JavaTypeEnhancementState javaTypeEnhancementState) {
        Intrinsics.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
        return javaTypeEnhancementState.getGetReportLevelForAnnotation().invoke(JavaNullabilityAnnotationSettingsKt.getJSPECIFY_ANNOTATIONS_PACKAGE()) == ReportLevel.STRICT;
    }

    public static final boolean hasErasedValueParameters(CallableMemberDescriptor memberDescriptor) {
        Intrinsics.checkNotNullParameter(memberDescriptor, "memberDescriptor");
        return (memberDescriptor instanceof FunctionDescriptor) && Intrinsics.areEqual(memberDescriptor.getUserData(JavaMethodDescriptor.HAS_ERASED_VALUE_PARAMETERS), (Object) true);
    }

    public static final AnnotationDescriptor extractNullabilityAnnotationOnBoundedWildcard(LazyJavaResolverContext c, JavaWildcardType wildcardType) {
        AnnotationDescriptor annotationDescriptor;
        Object[] $this$any$iv;
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(wildcardType, "wildcardType");
        if (wildcardType.getBound() != null) {
            Iterator<AnnotationDescriptor> it = new LazyJavaAnnotations(c, wildcardType, false, 4, null).iterator();
            while (true) {
                if (!it.hasNext()) {
                    annotationDescriptor = null;
                    break;
                }
                annotationDescriptor = it.next();
                AnnotationDescriptor annotation = annotationDescriptor;
                Object[] $this$any$iv2 = JavaNullabilityAnnotationSettingsKt.getRXJAVA3_ANNOTATIONS();
                int length = $this$any$iv2.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        Object element$iv = $this$any$iv2[i];
                        if (Intrinsics.areEqual(annotation.getFqName(), element$iv)) {
                            $this$any$iv = 1;
                            continue;
                            break;
                        }
                        i++;
                    } else {
                        $this$any$iv = null;
                        continue;
                        break;
                    }
                }
                if ($this$any$iv != null) {
                    break;
                }
            }
            return annotationDescriptor;
        }
        throw new IllegalArgumentException("Nullability annotations on unbounded wildcards aren't supported".toString());
    }
}