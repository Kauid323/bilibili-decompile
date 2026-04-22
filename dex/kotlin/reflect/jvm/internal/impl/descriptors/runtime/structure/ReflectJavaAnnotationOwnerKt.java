package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: ReflectJavaAnnotationOwner.kt */
public final class ReflectJavaAnnotationOwnerKt {
    public static final List<ReflectJavaAnnotation> getAnnotations(Annotation[] $this$getAnnotations) {
        Intrinsics.checkNotNullParameter($this$getAnnotations, "<this>");
        Collection destination$iv$iv = new ArrayList($this$getAnnotations.length);
        for (Annotation annotation : $this$getAnnotations) {
            destination$iv$iv.add(new ReflectJavaAnnotation(annotation));
        }
        return (List) destination$iv$iv;
    }

    public static final ReflectJavaAnnotation findAnnotation(Annotation[] $this$findAnnotation, FqName fqName) {
        Annotation annotation;
        Intrinsics.checkNotNullParameter($this$findAnnotation, "<this>");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        int length = $this$findAnnotation.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                annotation = null;
                break;
            }
            annotation = $this$findAnnotation[i];
            if (Intrinsics.areEqual(ReflectClassUtilKt.getClassId(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation))).asSingleFqName(), fqName)) {
                break;
            }
            i++;
        }
        if (annotation != null) {
            Annotation p0 = annotation;
            return new ReflectJavaAnnotation(p0);
        }
        return null;
    }
}