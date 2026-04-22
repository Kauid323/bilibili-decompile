package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator;

/* compiled from: TypeAttributes.kt */
public final class TypeAttributesKt {
    public static final TypeAttributes toDefaultAttributes(Annotations $this$toDefaultAttributes) {
        Intrinsics.checkNotNullParameter($this$toDefaultAttributes, "<this>");
        return TypeAttributeTranslator.DefaultImpls.toAttributes$default(DefaultTypeAttributeTranslator.INSTANCE, $this$toDefaultAttributes, null, null, 6, null);
    }

    public static final TypeAttributes replaceAnnotations(TypeAttributes $this$replaceAnnotations, Annotations newAnnotations) {
        TypeAttributes withoutAnnotations;
        Intrinsics.checkNotNullParameter($this$replaceAnnotations, "<this>");
        Intrinsics.checkNotNullParameter(newAnnotations, "newAnnotations");
        if (AnnotationsTypeAttributeKt.getAnnotations($this$replaceAnnotations) == newAnnotations) {
            return $this$replaceAnnotations;
        }
        AnnotationsTypeAttribute it = AnnotationsTypeAttributeKt.getAnnotationsAttribute($this$replaceAnnotations);
        if (it == null || (withoutAnnotations = $this$replaceAnnotations.remove(it)) == null) {
            withoutAnnotations = $this$replaceAnnotations;
        }
        return (newAnnotations.iterator().hasNext() || !newAnnotations.isEmpty()) ? withoutAnnotations.plus(new AnnotationsTypeAttribute(newAnnotations)) : withoutAnnotations;
    }
}