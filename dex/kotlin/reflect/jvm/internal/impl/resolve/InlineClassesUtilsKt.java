package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;

/* compiled from: inlineClassesUtils.kt */
public final class InlineClassesUtilsKt {
    private static final FqName JVM_INLINE_ANNOTATION_FQ_NAME = new FqName("kotlin.jvm.JvmInline");
    private static final ClassId JVM_INLINE_ANNOTATION_CLASS_ID = ClassId.Companion.topLevel(JVM_INLINE_ANNOTATION_FQ_NAME);
    private static final FqName JVM_NAME_ANNOTATION_FQ_NAME = new FqName("kotlin.jvm.JvmName");

    public static final boolean isInlineClass(DeclarationDescriptor $this$isInlineClass) {
        Intrinsics.checkNotNullParameter($this$isInlineClass, "<this>");
        return ($this$isInlineClass instanceof ClassDescriptor) && (((ClassDescriptor) $this$isInlineClass).getValueClassRepresentation() instanceof InlineClassRepresentation);
    }

    public static final boolean isMultiFieldValueClass(DeclarationDescriptor $this$isMultiFieldValueClass) {
        Intrinsics.checkNotNullParameter($this$isMultiFieldValueClass, "<this>");
        return ($this$isMultiFieldValueClass instanceof ClassDescriptor) && (((ClassDescriptor) $this$isMultiFieldValueClass).getValueClassRepresentation() instanceof MultiFieldValueClassRepresentation);
    }

    public static final boolean isValueClass(DeclarationDescriptor $this$isValueClass) {
        Intrinsics.checkNotNullParameter($this$isValueClass, "<this>");
        return isInlineClass($this$isValueClass) || isMultiFieldValueClass($this$isValueClass);
    }

    public static final KotlinType unsubstitutedUnderlyingType(KotlinType $this$unsubstitutedUnderlyingType) {
        InlineClassRepresentation<SimpleType> inlineClassRepresentation;
        Intrinsics.checkNotNullParameter($this$unsubstitutedUnderlyingType, "<this>");
        ClassifierDescriptor mo1171getDeclarationDescriptor = $this$unsubstitutedUnderlyingType.getConstructor().mo1171getDeclarationDescriptor();
        SimpleType simpleType = null;
        ClassDescriptor classDescriptor = mo1171getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) mo1171getDeclarationDescriptor : null;
        if (classDescriptor != null && (inlineClassRepresentation = DescriptorUtilsKt.getInlineClassRepresentation(classDescriptor)) != null) {
            simpleType = inlineClassRepresentation.getUnderlyingType();
        }
        return simpleType;
    }

    public static final boolean isInlineClassType(KotlinType $this$isInlineClassType) {
        Intrinsics.checkNotNullParameter($this$isInlineClassType, "<this>");
        ClassifierDescriptor mo1171getDeclarationDescriptor = $this$isInlineClassType.getConstructor().mo1171getDeclarationDescriptor();
        if (mo1171getDeclarationDescriptor != null) {
            return isInlineClass(mo1171getDeclarationDescriptor);
        }
        return false;
    }

    public static final boolean isValueClassType(KotlinType $this$isValueClassType) {
        Intrinsics.checkNotNullParameter($this$isValueClassType, "<this>");
        ClassifierDescriptor mo1171getDeclarationDescriptor = $this$isValueClassType.getConstructor().mo1171getDeclarationDescriptor();
        if (mo1171getDeclarationDescriptor != null) {
            return isValueClass(mo1171getDeclarationDescriptor);
        }
        return false;
    }

    public static final boolean needsMfvcFlattening(KotlinType $this$needsMfvcFlattening) {
        Intrinsics.checkNotNullParameter($this$needsMfvcFlattening, "<this>");
        ClassifierDescriptor $this$needsMfvcFlattening_u24lambda_u240 = $this$needsMfvcFlattening.getConstructor().mo1171getDeclarationDescriptor();
        if ($this$needsMfvcFlattening_u24lambda_u240 != null) {
            return ((!isMultiFieldValueClass($this$needsMfvcFlattening_u24lambda_u240) || SimpleClassicTypeSystemContext.INSTANCE.isNullableType($this$needsMfvcFlattening)) ? null : 1) == 1;
        }
        return false;
    }

    public static final boolean isGetterOfUnderlyingPropertyOfValueClass(CallableDescriptor $this$isGetterOfUnderlyingPropertyOfValueClass) {
        Intrinsics.checkNotNullParameter($this$isGetterOfUnderlyingPropertyOfValueClass, "<this>");
        if ($this$isGetterOfUnderlyingPropertyOfValueClass instanceof PropertyGetterDescriptor) {
            PropertyDescriptor correspondingProperty = ((PropertyGetterDescriptor) $this$isGetterOfUnderlyingPropertyOfValueClass).getCorrespondingProperty();
            Intrinsics.checkNotNullExpressionValue(correspondingProperty, "getCorrespondingProperty(...)");
            if (isUnderlyingPropertyOfValueClass(correspondingProperty)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isUnderlyingPropertyOfInlineClass(VariableDescriptor $this$isUnderlyingPropertyOfInlineClass) {
        InlineClassRepresentation<SimpleType> inlineClassRepresentation;
        Intrinsics.checkNotNullParameter($this$isUnderlyingPropertyOfInlineClass, "<this>");
        if ($this$isUnderlyingPropertyOfInlineClass.getExtensionReceiverParameter() == null) {
            DeclarationDescriptor containingDeclaration = $this$isUnderlyingPropertyOfInlineClass.getContainingDeclaration();
            Name name = null;
            ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
            if (classDescriptor != null && (inlineClassRepresentation = DescriptorUtilsKt.getInlineClassRepresentation(classDescriptor)) != null) {
                name = inlineClassRepresentation.getUnderlyingPropertyName();
            }
            if (Intrinsics.areEqual(name, $this$isUnderlyingPropertyOfInlineClass.getName())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean isUnderlyingPropertyOfValueClass(VariableDescriptor $this$isUnderlyingPropertyOfValueClass) {
        boolean z;
        ValueClassRepresentation<SimpleType> valueClassRepresentation;
        Intrinsics.checkNotNullParameter($this$isUnderlyingPropertyOfValueClass, "<this>");
        if ($this$isUnderlyingPropertyOfValueClass.getExtensionReceiverParameter() != null) {
            return false;
        }
        DeclarationDescriptor containingDeclaration = $this$isUnderlyingPropertyOfValueClass.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor != null && (valueClassRepresentation = classDescriptor.getValueClassRepresentation()) != null) {
            Name name = $this$isUnderlyingPropertyOfValueClass.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            if (valueClassRepresentation.containsPropertyWithName(name)) {
                z = true;
                return !z;
            }
        }
        z = false;
        if (!z) {
        }
    }
}