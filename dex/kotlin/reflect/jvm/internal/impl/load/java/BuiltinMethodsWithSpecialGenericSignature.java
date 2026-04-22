package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* compiled from: specialBuiltinMembers.kt */
public final class BuiltinMethodsWithSpecialGenericSignature extends SpecialGenericSignatures {
    public static final BuiltinMethodsWithSpecialGenericSignature INSTANCE = new BuiltinMethodsWithSpecialGenericSignature();

    private BuiltinMethodsWithSpecialGenericSignature() {
    }

    private final boolean getHasErasedValueParametersInJava(CallableMemberDescriptor $this$hasErasedValueParametersInJava) {
        return CollectionsKt.contains(SpecialGenericSignatures.Companion.getERASED_VALUE_PARAMETERS_SIGNATURES(), MethodSignatureMappingKt.computeJvmSignature($this$hasErasedValueParametersInJava));
    }

    @JvmStatic
    public static final FunctionDescriptor getOverriddenBuiltinFunctionWithErasedValueParametersInJava(FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = INSTANCE;
        Name name = functionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        if (builtinMethodsWithSpecialGenericSignature.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            return (FunctionDescriptor) DescriptorUtilsKt.firstOverridden$default(functionDescriptor, false, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature$$Lambda$0
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    boolean overriddenBuiltinFunctionWithErasedValueParametersInJava$lambda$0;
                    overriddenBuiltinFunctionWithErasedValueParametersInJava$lambda$0 = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava$lambda$0((CallableMemberDescriptor) obj);
                    return Boolean.valueOf(overriddenBuiltinFunctionWithErasedValueParametersInJava$lambda$0);
                }
            }, 1, null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getOverriddenBuiltinFunctionWithErasedValueParametersInJava$lambda$0(CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return INSTANCE.getHasErasedValueParametersInJava(it);
    }

    public final boolean getSameAsBuiltinMethodWithErasedValueParameters(Name $this$sameAsBuiltinMethodWithErasedValueParameters) {
        Intrinsics.checkNotNullParameter($this$sameAsBuiltinMethodWithErasedValueParameters, "<this>");
        return SpecialGenericSignatures.Companion.getERASED_VALUE_PARAMETERS_SHORT_NAMES().contains($this$sameAsBuiltinMethodWithErasedValueParameters);
    }

    @JvmStatic
    public static final SpecialGenericSignatures.SpecialSignatureInfo getSpecialSignatureInfo(CallableMemberDescriptor $this$getSpecialSignatureInfo) {
        CallableMemberDescriptor firstOverridden$default;
        String builtinSignature;
        Intrinsics.checkNotNullParameter($this$getSpecialSignatureInfo, "<this>");
        if (!SpecialGenericSignatures.Companion.getERASED_VALUE_PARAMETERS_SHORT_NAMES().contains($this$getSpecialSignatureInfo.getName()) || (firstOverridden$default = DescriptorUtilsKt.firstOverridden$default($this$getSpecialSignatureInfo, false, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature$$Lambda$2
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                boolean specialSignatureInfo$lambda$0;
                specialSignatureInfo$lambda$0 = BuiltinMethodsWithSpecialGenericSignature.getSpecialSignatureInfo$lambda$0((CallableMemberDescriptor) obj);
                return Boolean.valueOf(specialSignatureInfo$lambda$0);
            }
        }, 1, null)) == null || (builtinSignature = MethodSignatureMappingKt.computeJvmSignature(firstOverridden$default)) == null) {
            return null;
        }
        return SpecialGenericSignatures.Companion.getSpecialSignatureInfo(builtinSignature);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getSpecialSignatureInfo$lambda$0(CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (it instanceof FunctionDescriptor) && INSTANCE.getHasErasedValueParametersInJava(it);
    }
}