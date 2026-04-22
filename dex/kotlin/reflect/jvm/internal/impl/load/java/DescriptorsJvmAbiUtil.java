package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMappingUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;

public final class DescriptorsJvmAbiUtil {
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[3];
        switch (i) {
            case 1:
            case 2:
                objArr[0] = "companionObject";
                break;
            case 3:
                objArr[0] = "memberDescriptor";
                break;
            default:
                objArr[0] = "propertyDescriptor";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/DescriptorsJvmAbiUtil";
        switch (i) {
            case 1:
                objArr[2] = "isClassCompanionObjectWithBackingFieldsInOuter";
                break;
            case 2:
                objArr[2] = "isMappedIntrinsicCompanionObject";
                break;
            case 3:
                objArr[2] = "hasJvmFieldAnnotation";
                break;
            default:
                objArr[2] = "isPropertyWithBackingFieldInOuterClass";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static boolean isPropertyWithBackingFieldInOuterClass(PropertyDescriptor propertyDescriptor) {
        if (propertyDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        if (propertyDescriptor.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            return false;
        }
        if (isClassCompanionObjectWithBackingFieldsInOuter(propertyDescriptor.getContainingDeclaration())) {
            return true;
        }
        return DescriptorUtils.isCompanionObject(propertyDescriptor.getContainingDeclaration()) && hasJvmFieldAnnotation(propertyDescriptor);
    }

    public static boolean isClassCompanionObjectWithBackingFieldsInOuter(DeclarationDescriptor companionObject) {
        if (companionObject == null) {
            $$$reportNull$$$0(1);
        }
        return DescriptorUtils.isCompanionObject(companionObject) && DescriptorUtils.isClassOrEnumClass(companionObject.getContainingDeclaration()) && !isMappedIntrinsicCompanionObject((ClassDescriptor) companionObject);
    }

    public static boolean isMappedIntrinsicCompanionObject(ClassDescriptor companionObject) {
        if (companionObject == null) {
            $$$reportNull$$$0(2);
        }
        return CompanionObjectMappingUtilsKt.isMappedIntrinsicCompanionObject(CompanionObjectMapping.INSTANCE, companionObject);
    }

    public static boolean hasJvmFieldAnnotation(CallableMemberDescriptor memberDescriptor) {
        FieldDescriptor field;
        if (memberDescriptor == null) {
            $$$reportNull$$$0(3);
        }
        if ((memberDescriptor instanceof PropertyDescriptor) && (field = ((PropertyDescriptor) memberDescriptor).getBackingField()) != null && field.getAnnotations().hasAnnotation(JvmAbi.JVM_FIELD_ANNOTATION_FQ_NAME)) {
            return true;
        }
        return memberDescriptor.getAnnotations().hasAnnotation(JvmAbi.JVM_FIELD_ANNOTATION_FQ_NAME);
    }
}