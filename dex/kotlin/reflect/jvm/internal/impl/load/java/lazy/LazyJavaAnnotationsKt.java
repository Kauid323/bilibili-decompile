package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;

/* compiled from: LazyJavaAnnotations.kt */
public final class LazyJavaAnnotationsKt {
    public static final Annotations resolveAnnotations(LazyJavaResolverContext $this$resolveAnnotations, JavaAnnotationOwner annotationsOwner) {
        Intrinsics.checkNotNullParameter($this$resolveAnnotations, "<this>");
        Intrinsics.checkNotNullParameter(annotationsOwner, "annotationsOwner");
        return new LazyJavaAnnotations($this$resolveAnnotations, annotationsOwner, false, 4, null);
    }
}