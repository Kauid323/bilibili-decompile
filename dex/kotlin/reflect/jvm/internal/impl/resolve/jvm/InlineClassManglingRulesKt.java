package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: inlineClassManglingRules.kt */
public final class InlineClassManglingRulesKt {
    public static final boolean shouldHideConstructorDueToValueClassTypeValueParameters(CallableMemberDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        ClassConstructorDescriptor constructorDescriptor = descriptor instanceof ClassConstructorDescriptor ? (ClassConstructorDescriptor) descriptor : null;
        if (constructorDescriptor == null || DescriptorVisibilities.isPrivate(constructorDescriptor.getVisibility())) {
            return false;
        }
        ClassDescriptor constructedClass = constructorDescriptor.getConstructedClass();
        Intrinsics.checkNotNullExpressionValue(constructedClass, "getConstructedClass(...)");
        if (InlineClassesUtilsKt.isValueClass(constructedClass) || DescriptorUtils.isSealedClass(constructorDescriptor.getConstructedClass())) {
            return false;
        }
        Iterable valueParameters = constructorDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        Iterable $this$any$iv = valueParameters;
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            ValueParameterDescriptor it = (ValueParameterDescriptor) element$iv;
            KotlinType type = it.getType();
            Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            if (requiresFunctionNameManglingInParameterTypes(type)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isValueClassThatRequiresMangling(DeclarationDescriptor $this$isValueClassThatRequiresMangling) {
        Intrinsics.checkNotNullParameter($this$isValueClassThatRequiresMangling, "<this>");
        return InlineClassesUtilsKt.isValueClass($this$isValueClassThatRequiresMangling) && !isDontMangleClass((ClassDescriptor) $this$isValueClassThatRequiresMangling);
    }

    public static final boolean isValueClassThatRequiresMangling(KotlinType $this$isValueClassThatRequiresMangling) {
        Intrinsics.checkNotNullParameter($this$isValueClassThatRequiresMangling, "<this>");
        ClassifierDescriptor it = $this$isValueClassThatRequiresMangling.getConstructor().mo1171getDeclarationDescriptor();
        if (it != null) {
            return (((!InlineClassesUtilsKt.isInlineClass(it) || !isValueClassThatRequiresMangling(it)) && !InlineClassesUtilsKt.needsMfvcFlattening($this$isValueClassThatRequiresMangling)) ? null : 1) == 1;
        }
        return false;
    }

    private static final boolean requiresFunctionNameManglingInParameterTypes(KotlinType $this$requiresFunctionNameManglingInParameterTypes) {
        return isValueClassThatRequiresMangling($this$requiresFunctionNameManglingInParameterTypes) || isTypeParameterWithUpperBoundThatRequiresMangling($this$requiresFunctionNameManglingInParameterTypes, true);
    }

    private static final boolean isDontMangleClass(ClassDescriptor classDescriptor) {
        return Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(classDescriptor), StandardNames.RESULT_FQ_NAME);
    }

    private static final boolean isTypeParameterWithUpperBoundThatRequiresMangling(KotlinType $this$isTypeParameterWithUpperBoundThatRequiresMangling, boolean includeMfvc) {
        ClassifierDescriptor mo1171getDeclarationDescriptor = $this$isTypeParameterWithUpperBoundThatRequiresMangling.getConstructor().mo1171getDeclarationDescriptor();
        TypeParameterDescriptor descriptor = mo1171getDeclarationDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) mo1171getDeclarationDescriptor : null;
        if (descriptor == null) {
            return false;
        }
        return (includeMfvc || !InlineClassesUtilsKt.isMultiFieldValueClass(descriptor)) && requiresFunctionNameManglingInParameterTypes(TypeUtilsKt.getRepresentativeUpperBound(descriptor));
    }
}