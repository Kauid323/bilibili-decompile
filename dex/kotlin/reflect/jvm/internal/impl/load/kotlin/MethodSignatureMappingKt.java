package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: methodSignatureMapping.kt */
public final class MethodSignatureMappingKt {
    public static final String computeJvmDescriptor(FunctionDescriptor $this$computeJvmDescriptor, boolean withReturnType, boolean withName) {
        String asString;
        Intrinsics.checkNotNullParameter($this$computeJvmDescriptor, "<this>");
        StringBuilder $this$computeJvmDescriptor_u24lambda_u240 = new StringBuilder();
        if (withName) {
            if ($this$computeJvmDescriptor instanceof ConstructorDescriptor) {
                asString = "<init>";
            } else {
                asString = $this$computeJvmDescriptor.getName().asString();
                Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
            }
            $this$computeJvmDescriptor_u24lambda_u240.append(asString);
        }
        $this$computeJvmDescriptor_u24lambda_u240.append("(");
        ReceiverParameterDescriptor it = $this$computeJvmDescriptor.getExtensionReceiverParameter();
        if (it != null) {
            KotlinType type = it.getType();
            Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            appendErasedType($this$computeJvmDescriptor_u24lambda_u240, type);
        }
        for (ValueParameterDescriptor parameter : $this$computeJvmDescriptor.getValueParameters()) {
            KotlinType type2 = parameter.getType();
            Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
            appendErasedType($this$computeJvmDescriptor_u24lambda_u240, type2);
        }
        $this$computeJvmDescriptor_u24lambda_u240.append(")");
        if (withReturnType) {
            if (DescriptorBasedTypeSignatureMappingKt.hasVoidReturnType($this$computeJvmDescriptor)) {
                $this$computeJvmDescriptor_u24lambda_u240.append("V");
            } else {
                KotlinType returnType = $this$computeJvmDescriptor.getReturnType();
                Intrinsics.checkNotNull(returnType);
                appendErasedType($this$computeJvmDescriptor_u24lambda_u240, returnType);
            }
        }
        return $this$computeJvmDescriptor_u24lambda_u240.toString();
    }

    public static /* synthetic */ String computeJvmDescriptor$default(FunctionDescriptor functionDescriptor, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return computeJvmDescriptor(functionDescriptor, z, z2);
    }

    public static final boolean forceSingleValueParameterBoxing(CallableDescriptor f) {
        FunctionDescriptor overridden;
        Intrinsics.checkNotNullParameter(f, "f");
        if ((f instanceof FunctionDescriptor) && Intrinsics.areEqual(((FunctionDescriptor) f).getName().asString(), "remove") && ((FunctionDescriptor) f).getValueParameters().size() == 1 && !SpecialBuiltinMembers.isFromJavaOrBuiltins((CallableMemberDescriptor) f)) {
            List<ValueParameterDescriptor> valueParameters = ((FunctionDescriptor) f).getOriginal().getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
            KotlinType type = ((ValueParameterDescriptor) CollectionsKt.single((List<? extends Object>) valueParameters)).getType();
            Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            JvmType mapToJvmType = mapToJvmType(type);
            JvmType.Primitive primitive = mapToJvmType instanceof JvmType.Primitive ? (JvmType.Primitive) mapToJvmType : null;
            if ((primitive != null ? primitive.getJvmPrimitiveType() : null) == JvmPrimitiveType.INT && (overridden = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava((FunctionDescriptor) f)) != null) {
                List<ValueParameterDescriptor> valueParameters2 = overridden.getOriginal().getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
                KotlinType type2 = ((ValueParameterDescriptor) CollectionsKt.single((List<? extends Object>) valueParameters2)).getType();
                Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                JvmType overriddenParameterType = mapToJvmType(type2);
                DeclarationDescriptor containingDeclaration = overridden.getContainingDeclaration();
                Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
                return Intrinsics.areEqual(DescriptorUtilsKt.getFqNameUnsafe(containingDeclaration), StandardNames.FqNames.mutableCollection.toUnsafe()) && (overriddenParameterType instanceof JvmType.Object) && Intrinsics.areEqual(((JvmType.Object) overriddenParameterType).getInternalName(), "java/lang/Object");
            }
            return false;
        }
        return false;
    }

    public static final String computeJvmSignature(CallableDescriptor $this$computeJvmSignature) {
        Intrinsics.checkNotNullParameter($this$computeJvmSignature, "<this>");
        SignatureBuildingComponents $this$computeJvmSignature_u24lambda_u240 = SignatureBuildingComponents.INSTANCE;
        if (DescriptorUtils.isLocal($this$computeJvmSignature)) {
            return null;
        }
        DeclarationDescriptor containingDeclaration = $this$computeJvmSignature.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor == null || classDescriptor.getName().isSpecial()) {
            return null;
        }
        CallableDescriptor original = $this$computeJvmSignature.getOriginal();
        SimpleFunctionDescriptor simpleFunctionDescriptor = original instanceof SimpleFunctionDescriptor ? (SimpleFunctionDescriptor) original : null;
        if (simpleFunctionDescriptor == null) {
            return null;
        }
        return MethodSignatureBuildingUtilsKt.signature($this$computeJvmSignature_u24lambda_u240, classDescriptor, computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 3, null));
    }

    public static final String getInternalName(ClassDescriptor $this$internalName) {
        Intrinsics.checkNotNullParameter($this$internalName, "<this>");
        ClassId it = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(DescriptorUtilsKt.getFqNameSafe($this$internalName).toUnsafe());
        if (it != null) {
            String internalNameByClassId = JvmClassName.internalNameByClassId(it);
            Intrinsics.checkNotNullExpressionValue(internalNameByClassId, "internalNameByClassId(...)");
            return internalNameByClassId;
        }
        return DescriptorBasedTypeSignatureMappingKt.computeInternalName$default($this$internalName, null, 2, null);
    }

    private static final void appendErasedType(StringBuilder $this$appendErasedType, KotlinType type) {
        $this$appendErasedType.append(mapToJvmType(type));
    }

    public static final JvmType mapToJvmType(KotlinType $this$mapToJvmType) {
        Intrinsics.checkNotNullParameter($this$mapToJvmType, "<this>");
        return (JvmType) DescriptorBasedTypeSignatureMappingKt.mapType$default($this$mapToJvmType, JvmTypeFactoryImpl.INSTANCE, TypeMappingMode.DEFAULT, TypeMappingConfigurationImpl.INSTANCE, null, null, 32, null);
    }
}