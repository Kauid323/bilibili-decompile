package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: JavaIncompatibilityRulesOverridabilityCondition.kt */
public final class JavaIncompatibilityRulesOverridabilityCondition implements ExternalOverridabilityCondition {
    public static final Companion Companion = new Companion(null);

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Result isOverridable(CallableDescriptor superDescriptor, CallableDescriptor subDescriptor, ClassDescriptor subClassDescriptor) {
        Intrinsics.checkNotNullParameter(superDescriptor, "superDescriptor");
        Intrinsics.checkNotNullParameter(subDescriptor, "subDescriptor");
        if (isIncompatibleInAccordanceWithBuiltInOverridabilityRules(superDescriptor, subDescriptor, subClassDescriptor)) {
            return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
        }
        if (Companion.doesJavaOverrideHaveIncompatibleValueParameterKinds(superDescriptor, subDescriptor)) {
            return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
        }
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }

    private final boolean isIncompatibleInAccordanceWithBuiltInOverridabilityRules(CallableDescriptor superDescriptor, CallableDescriptor subDescriptor, ClassDescriptor subClassDescriptor) {
        if ((superDescriptor instanceof CallableMemberDescriptor) && (subDescriptor instanceof FunctionDescriptor) && !KotlinBuiltIns.isBuiltIn(subDescriptor)) {
            BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
            Name name = ((FunctionDescriptor) subDescriptor).getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            if (!builtinMethodsWithSpecialGenericSignature.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
                SpecialGenericSignatures.Companion companion = SpecialGenericSignatures.Companion;
                Name name2 = ((FunctionDescriptor) subDescriptor).getName();
                Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                if (!companion.getSameAsRenamedInJvmBuiltin(name2)) {
                    return false;
                }
            }
            CallableMemberDescriptor overriddenBuiltin = SpecialBuiltinMembers.getOverriddenSpecialBuiltin((CallableMemberDescriptor) superDescriptor);
            FunctionDescriptor functionDescriptor = superDescriptor instanceof FunctionDescriptor ? (FunctionDescriptor) superDescriptor : null;
            boolean isOneOfDescriptorsHidden = !(functionDescriptor != null && ((FunctionDescriptor) subDescriptor).isHiddenToOvercomeSignatureClash() == functionDescriptor.isHiddenToOvercomeSignatureClash());
            if (!isOneOfDescriptorsHidden || (overriddenBuiltin != null && ((FunctionDescriptor) subDescriptor).isHiddenToOvercomeSignatureClash())) {
                if (!(subClassDescriptor instanceof JavaClassDescriptor) || ((FunctionDescriptor) subDescriptor).getInitialSignatureDescriptor() != null || overriddenBuiltin == null || SpecialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(subClassDescriptor, overriddenBuiltin)) {
                    return false;
                }
                if ((overriddenBuiltin instanceof FunctionDescriptor) && (superDescriptor instanceof FunctionDescriptor) && BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava((FunctionDescriptor) overriddenBuiltin) != null) {
                    String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default((FunctionDescriptor) subDescriptor, false, false, 2, null);
                    FunctionDescriptor original = ((FunctionDescriptor) superDescriptor).getOriginal();
                    Intrinsics.checkNotNullExpressionValue(original, "getOriginal(...)");
                    if (Intrinsics.areEqual(computeJvmDescriptor$default, MethodSignatureMappingKt.computeJvmDescriptor$default(original, false, false, 2, null))) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Contract getContract() {
        return ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY;
    }

    /* compiled from: JavaIncompatibilityRulesOverridabilityCondition.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean doesJavaOverrideHaveIncompatibleValueParameterKinds(CallableDescriptor superDescriptor, CallableDescriptor subDescriptor) {
            Intrinsics.checkNotNullParameter(superDescriptor, "superDescriptor");
            Intrinsics.checkNotNullParameter(subDescriptor, "subDescriptor");
            if ((subDescriptor instanceof JavaMethodDescriptor) && (superDescriptor instanceof FunctionDescriptor)) {
                if (!(((JavaMethodDescriptor) subDescriptor).getValueParameters().size() == ((FunctionDescriptor) superDescriptor).getValueParameters().size())) {
                    throw new AssertionError("External overridability condition with CONFLICTS_ONLY should not be run with different value parameters size");
                }
                List<ValueParameterDescriptor> valueParameters = ((JavaMethodDescriptor) subDescriptor).getOriginal().getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
                List<ValueParameterDescriptor> valueParameters2 = ((FunctionDescriptor) superDescriptor).getOriginal().getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
                for (Pair pair : CollectionsKt.zip(valueParameters, valueParameters2)) {
                    ValueParameterDescriptor subParameter = (ValueParameterDescriptor) pair.component1();
                    ValueParameterDescriptor superParameter = (ValueParameterDescriptor) pair.component2();
                    Intrinsics.checkNotNull(subParameter);
                    boolean isSubPrimitive = mapValueParameterType((FunctionDescriptor) subDescriptor, subParameter) instanceof JvmType.Primitive;
                    Intrinsics.checkNotNull(superParameter);
                    boolean isSuperPrimitive = mapValueParameterType((FunctionDescriptor) superDescriptor, superParameter) instanceof JvmType.Primitive;
                    if (isSubPrimitive != isSuperPrimitive) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        private final JvmType mapValueParameterType(FunctionDescriptor f, ValueParameterDescriptor valueParameterDescriptor) {
            if (MethodSignatureMappingKt.forceSingleValueParameterBoxing(f) || isPrimitiveCompareTo(f)) {
                KotlinType type = valueParameterDescriptor.getType();
                Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                return MethodSignatureMappingKt.mapToJvmType(TypeUtilsKt.makeNullable(type));
            }
            KotlinType type2 = valueParameterDescriptor.getType();
            Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
            return MethodSignatureMappingKt.mapToJvmType(type2);
        }

        private final boolean isPrimitiveCompareTo(FunctionDescriptor f) {
            if (f.getValueParameters().size() != 1) {
                return false;
            }
            DeclarationDescriptor containingDeclaration = f.getContainingDeclaration();
            ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
            if (classDescriptor == null) {
                return false;
            }
            List<ValueParameterDescriptor> valueParameters = f.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
            ClassifierDescriptor mo1171getDeclarationDescriptor = ((ValueParameterDescriptor) CollectionsKt.single((List<? extends Object>) valueParameters)).getType().getConstructor().mo1171getDeclarationDescriptor();
            ClassDescriptor classDescriptor2 = mo1171getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) mo1171getDeclarationDescriptor : null;
            if (classDescriptor2 == null) {
                return false;
            }
            ClassDescriptor parameterClass = classDescriptor2;
            return KotlinBuiltIns.isPrimitiveClass(classDescriptor) && Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(classDescriptor), DescriptorUtilsKt.getFqNameSafe(parameterClass));
        }
    }
}