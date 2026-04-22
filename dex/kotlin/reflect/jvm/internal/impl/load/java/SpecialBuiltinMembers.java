package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedure;

/* compiled from: specialBuiltinMembers.kt */
public final class SpecialBuiltinMembers {
    public static final <T extends CallableMemberDescriptor> T getOverriddenBuiltinWithDifferentJvmName(T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        if (SpecialGenericSignatures.Companion.getORIGINAL_SHORT_NAMES().contains(t.getName()) || BuiltinSpecialProperties.INSTANCE.getSPECIAL_SHORT_NAMES().contains(DescriptorUtilsKt.getPropertyIfAccessor(t).getName())) {
            if ((t instanceof PropertyDescriptor) || (t instanceof PropertyAccessorDescriptor)) {
                return (T) DescriptorUtilsKt.firstOverridden$default(t, false, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers$$Lambda$0
                    @Override // kotlin.jvm.functions.Function1
                    public Object invoke(Object obj) {
                        boolean overriddenBuiltinWithDifferentJvmName$lambda$0;
                        overriddenBuiltinWithDifferentJvmName$lambda$0 = SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName$lambda$0((CallableMemberDescriptor) obj);
                        return Boolean.valueOf(overriddenBuiltinWithDifferentJvmName$lambda$0);
                    }
                }, 1, null);
            }
            if (t instanceof SimpleFunctionDescriptor) {
                return (T) DescriptorUtilsKt.firstOverridden$default(t, false, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers$$Lambda$1
                    @Override // kotlin.jvm.functions.Function1
                    public Object invoke(Object obj) {
                        boolean overriddenBuiltinWithDifferentJvmName$lambda$1;
                        overriddenBuiltinWithDifferentJvmName$lambda$1 = SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName$lambda$1((CallableMemberDescriptor) obj);
                        return Boolean.valueOf(overriddenBuiltinWithDifferentJvmName$lambda$1);
                    }
                }, 1, null);
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getOverriddenBuiltinWithDifferentJvmName$lambda$0(CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ClassicBuiltinSpecialProperties.INSTANCE.hasBuiltinSpecialPropertyFqName(DescriptorUtilsKt.getPropertyIfAccessor(it));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getOverriddenBuiltinWithDifferentJvmName$lambda$1(CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return BuiltinMethodsWithDifferentJvmName.INSTANCE.isBuiltinFunctionWithDifferentNameInJvm((SimpleFunctionDescriptor) it);
    }

    public static final boolean doesOverrideBuiltinWithDifferentJvmName(CallableMemberDescriptor $this$doesOverrideBuiltinWithDifferentJvmName) {
        Intrinsics.checkNotNullParameter($this$doesOverrideBuiltinWithDifferentJvmName, "<this>");
        return getOverriddenBuiltinWithDifferentJvmName($this$doesOverrideBuiltinWithDifferentJvmName) != null;
    }

    public static final <T extends CallableMemberDescriptor> T getOverriddenSpecialBuiltin(T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        T t2 = (T) getOverriddenBuiltinWithDifferentJvmName(t);
        if (t2 != null) {
            return t2;
        }
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
        Name name = t.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        if (builtinMethodsWithSpecialGenericSignature.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            return (T) DescriptorUtilsKt.firstOverridden$default(t, false, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers$$Lambda$2
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    boolean overriddenSpecialBuiltin$lambda$1;
                    overriddenSpecialBuiltin$lambda$1 = SpecialBuiltinMembers.getOverriddenSpecialBuiltin$lambda$1((CallableMemberDescriptor) obj);
                    return Boolean.valueOf(overriddenSpecialBuiltin$lambda$1);
                }
            }, 1, null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getOverriddenSpecialBuiltin$lambda$1(CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return KotlinBuiltIns.isBuiltIn(it) && BuiltinMethodsWithSpecialGenericSignature.getSpecialSignatureInfo(it) != null;
    }

    public static final String getJvmMethodNameIfSpecial(CallableMemberDescriptor callableMemberDescriptor) {
        CallableMemberDescriptor overriddenBuiltin;
        Name jvmName;
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "callableMemberDescriptor");
        CallableMemberDescriptor overriddenBuiltinThatAffectsJvmName = getOverriddenBuiltinThatAffectsJvmName(callableMemberDescriptor);
        if (overriddenBuiltinThatAffectsJvmName == null || (overriddenBuiltin = DescriptorUtilsKt.getPropertyIfAccessor(overriddenBuiltinThatAffectsJvmName)) == null) {
            return null;
        }
        if (overriddenBuiltin instanceof PropertyDescriptor) {
            return ClassicBuiltinSpecialProperties.INSTANCE.getBuiltinSpecialPropertyGetterName(overriddenBuiltin);
        }
        if (!(overriddenBuiltin instanceof SimpleFunctionDescriptor) || (jvmName = BuiltinMethodsWithDifferentJvmName.INSTANCE.getJvmName((SimpleFunctionDescriptor) overriddenBuiltin)) == null) {
            return null;
        }
        return jvmName.asString();
    }

    private static final CallableMemberDescriptor getOverriddenBuiltinThatAffectsJvmName(CallableMemberDescriptor callableMemberDescriptor) {
        if (KotlinBuiltIns.isBuiltIn(callableMemberDescriptor)) {
            return getOverriddenBuiltinWithDifferentJvmName(callableMemberDescriptor);
        }
        return null;
    }

    public static final boolean hasRealKotlinSuperClassWithOverrideOf(ClassDescriptor $this$hasRealKotlinSuperClassWithOverrideOf, CallableDescriptor specialCallableDescriptor) {
        Intrinsics.checkNotNullParameter($this$hasRealKotlinSuperClassWithOverrideOf, "<this>");
        Intrinsics.checkNotNullParameter(specialCallableDescriptor, "specialCallableDescriptor");
        DeclarationDescriptor containingDeclaration = specialCallableDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        SimpleType builtinContainerDefaultType = ((ClassDescriptor) containingDeclaration).getDefaultType();
        Intrinsics.checkNotNullExpressionValue(builtinContainerDefaultType, "getDefaultType(...)");
        ClassDescriptor superClassDescriptor = DescriptorUtils.getSuperClassDescriptor($this$hasRealKotlinSuperClassWithOverrideOf);
        while (true) {
            if (superClassDescriptor == null) {
                return false;
            }
            if (!(superClassDescriptor instanceof JavaClassDescriptor)) {
                boolean doesOverrideBuiltinDeclaration = TypeCheckingProcedure.findCorrespondingSupertype(superClassDescriptor.getDefaultType(), builtinContainerDefaultType) != null;
                if (doesOverrideBuiltinDeclaration) {
                    return !KotlinBuiltIns.isBuiltIn(superClassDescriptor);
                }
            }
            superClassDescriptor = DescriptorUtils.getSuperClassDescriptor(superClassDescriptor);
        }
    }

    public static final boolean isFromJava(CallableMemberDescriptor $this$isFromJava) {
        Intrinsics.checkNotNullParameter($this$isFromJava, "<this>");
        CallableMemberDescriptor descriptor = DescriptorUtilsKt.getPropertyIfAccessor($this$isFromJava);
        return descriptor.getContainingDeclaration() instanceof JavaClassDescriptor;
    }

    public static final boolean isFromJavaOrBuiltins(CallableMemberDescriptor $this$isFromJavaOrBuiltins) {
        Intrinsics.checkNotNullParameter($this$isFromJavaOrBuiltins, "<this>");
        return isFromJava($this$isFromJavaOrBuiltins) || KotlinBuiltIns.isBuiltIn($this$isFromJavaOrBuiltins);
    }
}