package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* compiled from: specialBuiltinMembers.kt */
public final class BuiltinMethodsWithDifferentJvmName extends SpecialGenericSignatures {
    public static final BuiltinMethodsWithDifferentJvmName INSTANCE = new BuiltinMethodsWithDifferentJvmName();

    private BuiltinMethodsWithDifferentJvmName() {
    }

    public final Name getJvmName(SimpleFunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        Map<String, Name> signature_to_jvm_representation_name = SpecialGenericSignatures.Companion.getSIGNATURE_TO_JVM_REPRESENTATION_NAME();
        String computeJvmSignature = MethodSignatureMappingKt.computeJvmSignature(functionDescriptor);
        if (computeJvmSignature == null) {
            return null;
        }
        return signature_to_jvm_representation_name.get(computeJvmSignature);
    }

    public final boolean isBuiltinFunctionWithDifferentNameInJvm(final SimpleFunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        return KotlinBuiltIns.isBuiltIn(functionDescriptor) && DescriptorUtilsKt.firstOverridden$default(functionDescriptor, false, new Function1(functionDescriptor) { // from class: kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName$$Lambda$0
            private final SimpleFunctionDescriptor arg$0;

            {
                this.arg$0 = functionDescriptor;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                boolean isBuiltinFunctionWithDifferentNameInJvm$lambda$0;
                isBuiltinFunctionWithDifferentNameInJvm$lambda$0 = BuiltinMethodsWithDifferentJvmName.isBuiltinFunctionWithDifferentNameInJvm$lambda$0(this.arg$0, (CallableMemberDescriptor) obj);
                return Boolean.valueOf(isBuiltinFunctionWithDifferentNameInJvm$lambda$0);
            }
        }, 1, null) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isBuiltinFunctionWithDifferentNameInJvm$lambda$0(SimpleFunctionDescriptor $functionDescriptor, CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return SpecialGenericSignatures.Companion.getSIGNATURE_TO_JVM_REPRESENTATION_NAME().containsKey(MethodSignatureMappingKt.computeJvmSignature($functionDescriptor));
    }

    public final boolean isRemoveAtByIndex(SimpleFunctionDescriptor $this$isRemoveAtByIndex) {
        Intrinsics.checkNotNullParameter($this$isRemoveAtByIndex, "<this>");
        return Intrinsics.areEqual($this$isRemoveAtByIndex.getName().asString(), "removeAt") && Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmSignature($this$isRemoveAtByIndex), SpecialGenericSignatures.Companion.getREMOVE_AT_NAME_AND_SIGNATURE().getSignature());
    }
}