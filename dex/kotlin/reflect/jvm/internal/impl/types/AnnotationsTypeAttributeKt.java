package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;

/* compiled from: AnnotationsTypeAttribute.kt */
public final class AnnotationsTypeAttributeKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(AnnotationsTypeAttributeKt.class, "annotationsAttribute", "getAnnotationsAttribute(Lorg/jetbrains/kotlin/types/TypeAttributes;)Lorg/jetbrains/kotlin/types/AnnotationsTypeAttribute;", 1))};
    private static final ReadOnlyProperty annotationsAttribute$delegate;

    public static final AnnotationsTypeAttribute getAnnotationsAttribute(TypeAttributes $this$annotationsAttribute) {
        Intrinsics.checkNotNullParameter($this$annotationsAttribute, "<this>");
        return (AnnotationsTypeAttribute) annotationsAttribute$delegate.getValue($this$annotationsAttribute, $$delegatedProperties[0]);
    }

    public static final Annotations getAnnotations(TypeAttributes $this$annotations) {
        Annotations annotations;
        Intrinsics.checkNotNullParameter($this$annotations, "<this>");
        AnnotationsTypeAttribute annotationsAttribute = getAnnotationsAttribute($this$annotations);
        return (annotationsAttribute == null || (annotations = annotationsAttribute.getAnnotations()) == null) ? Annotations.Companion.getEMPTY() : annotations;
    }

    static {
        TypeAttributes.Companion this_$iv = TypeAttributes.Companion;
        ReadOnlyProperty generateNullableAccessor = this_$iv.generateNullableAccessor(Reflection.getOrCreateKotlinClass(AnnotationsTypeAttribute.class));
        Intrinsics.checkNotNull(generateNullableAccessor, "null cannot be cast to non-null type kotlin.properties.ReadOnlyProperty<org.jetbrains.kotlin.types.TypeAttributes, T of org.jetbrains.kotlin.types.TypeAttributes.Companion.attributeAccessor?>");
        annotationsAttribute$delegate = generateNullableAccessor;
    }
}