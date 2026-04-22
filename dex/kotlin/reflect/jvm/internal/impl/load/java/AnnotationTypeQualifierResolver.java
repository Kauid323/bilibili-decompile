package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* compiled from: AnnotationTypeQualifierResolver.kt */
public final class AnnotationTypeQualifierResolver extends AbstractAnnotationTypeQualifierResolver<AnnotationDescriptor> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnotationTypeQualifierResolver(JavaTypeEnhancementState javaTypeEnhancementState) {
        super(javaTypeEnhancementState);
        Intrinsics.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    public boolean isK2() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    public Iterable<AnnotationDescriptor> getMetaAnnotations(AnnotationDescriptor $this$metaAnnotations) {
        Iterable<AnnotationDescriptor> emptyList;
        Intrinsics.checkNotNullParameter($this$metaAnnotations, "<this>");
        ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass($this$metaAnnotations);
        if (annotationClass == null || (emptyList = annotationClass.getAnnotations()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        return emptyList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    public Object getKey(AnnotationDescriptor $this$key) {
        Intrinsics.checkNotNullParameter($this$key, "<this>");
        ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass($this$key);
        Intrinsics.checkNotNull(annotationClass);
        return annotationClass;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    public FqName getFqName(AnnotationDescriptor $this$fqName) {
        Intrinsics.checkNotNullParameter($this$fqName, "<this>");
        return $this$fqName.getFqName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    public Iterable<String> enumArguments(AnnotationDescriptor $this$enumArguments, boolean onlyValue) {
        Iterable enumNames;
        Intrinsics.checkNotNullParameter($this$enumArguments, "<this>");
        Map $this$flatMap$iv = $this$enumArguments.getAllValueArguments();
        Collection destination$iv$iv = new ArrayList();
        for (Map.Entry element$iv$iv : $this$flatMap$iv.entrySet()) {
            Name parameter = element$iv$iv.getKey();
            ConstantValue<?> argument = element$iv$iv.getValue();
            if (!onlyValue || Intrinsics.areEqual(parameter, JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME)) {
                enumNames = toEnumNames(argument);
            } else {
                enumNames = CollectionsKt.emptyList();
            }
            Iterable list$iv$iv = enumNames;
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        return (List) destination$iv$iv;
    }

    private final List<String> toEnumNames(ConstantValue<?> constantValue) {
        if (!(constantValue instanceof ArrayValue)) {
            return constantValue instanceof EnumValue ? CollectionsKt.listOf(((EnumValue) constantValue).getEnumEntryName().getIdentifier()) : CollectionsKt.emptyList();
        }
        Iterable $this$flatMap$iv = ((ArrayValue) constantValue).getValue();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            ConstantValue it = (ConstantValue) element$iv$iv;
            Iterable list$iv$iv = toEnumNames(it);
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        return (List) destination$iv$iv;
    }
}