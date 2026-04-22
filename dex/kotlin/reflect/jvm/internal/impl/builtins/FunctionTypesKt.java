package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKindExtractor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: functionTypes.kt */
public final class FunctionTypesKt {
    public static final FunctionTypeKind getFunctionTypeKind(KotlinType $this$functionTypeKind) {
        Intrinsics.checkNotNullParameter($this$functionTypeKind, "<this>");
        ClassifierDescriptor mo1171getDeclarationDescriptor = $this$functionTypeKind.getConstructor().mo1171getDeclarationDescriptor();
        if (mo1171getDeclarationDescriptor != null) {
            return getFunctionTypeKind(mo1171getDeclarationDescriptor);
        }
        return null;
    }

    public static final boolean isFunctionType(KotlinType $this$isFunctionType) {
        Intrinsics.checkNotNullParameter($this$isFunctionType, "<this>");
        return Intrinsics.areEqual(getFunctionTypeKind($this$isFunctionType), FunctionTypeKind.Function.INSTANCE);
    }

    public static final boolean isSuspendFunctionType(KotlinType $this$isSuspendFunctionType) {
        Intrinsics.checkNotNullParameter($this$isSuspendFunctionType, "<this>");
        return Intrinsics.areEqual(getFunctionTypeKind($this$isSuspendFunctionType), FunctionTypeKind.SuspendFunction.INSTANCE);
    }

    public static final boolean isBuiltinFunctionalType(KotlinType $this$isBuiltinFunctionalType) {
        Intrinsics.checkNotNullParameter($this$isBuiltinFunctionalType, "<this>");
        ClassifierDescriptor mo1171getDeclarationDescriptor = $this$isBuiltinFunctionalType.getConstructor().mo1171getDeclarationDescriptor();
        return mo1171getDeclarationDescriptor != null && isBuiltinFunctionalClassDescriptor(mo1171getDeclarationDescriptor);
    }

    public static final boolean isBuiltinFunctionalClassDescriptor(DeclarationDescriptor $this$isBuiltinFunctionalClassDescriptor) {
        Intrinsics.checkNotNullParameter($this$isBuiltinFunctionalClassDescriptor, "<this>");
        FunctionTypeKind functionalClassKind = getFunctionTypeKind($this$isBuiltinFunctionalClassDescriptor);
        return Intrinsics.areEqual(functionalClassKind, FunctionTypeKind.Function.INSTANCE) || Intrinsics.areEqual(functionalClassKind, FunctionTypeKind.SuspendFunction.INSTANCE);
    }

    public static final boolean isBuiltinExtensionFunctionalType(KotlinType $this$isBuiltinExtensionFunctionalType) {
        Intrinsics.checkNotNullParameter($this$isBuiltinExtensionFunctionalType, "<this>");
        return isBuiltinFunctionalType($this$isBuiltinExtensionFunctionalType) && isTypeAnnotatedWithExtensionFunctionType($this$isBuiltinExtensionFunctionalType);
    }

    private static final boolean isTypeAnnotatedWithExtensionFunctionType(KotlinType $this$isTypeAnnotatedWithExtensionFunctionType) {
        return $this$isTypeAnnotatedWithExtensionFunctionType.getAnnotations().mo1162findAnnotation(StandardNames.FqNames.extensionFunctionType) != null;
    }

    public static final boolean isNumberedFunctionClassFqName(FqNameUnsafe fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return fqName.startsWith(StandardNames.BUILT_INS_PACKAGE_NAME) && Intrinsics.areEqual(getFunctionTypeKind(fqName), FunctionTypeKind.Function.INSTANCE);
    }

    public static final FunctionTypeKind getFunctionTypeKind(DeclarationDescriptor $this$getFunctionTypeKind) {
        Intrinsics.checkNotNullParameter($this$getFunctionTypeKind, "<this>");
        if (($this$getFunctionTypeKind instanceof ClassDescriptor) && KotlinBuiltIns.isUnderKotlinPackage($this$getFunctionTypeKind)) {
            return getFunctionTypeKind(DescriptorUtilsKt.getFqNameUnsafe($this$getFunctionTypeKind));
        }
        return null;
    }

    private static final FunctionTypeKind getFunctionTypeKind(FqNameUnsafe $this$getFunctionTypeKind) {
        if (!$this$getFunctionTypeKind.isSafe() || $this$getFunctionTypeKind.isRoot()) {
            return null;
        }
        FunctionTypeKindExtractor functionTypeKindExtractor = FunctionTypeKindExtractor.Companion.getDefault();
        FqName parent = $this$getFunctionTypeKind.toSafe().parent();
        String asString = $this$getFunctionTypeKind.shortName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        return functionTypeKindExtractor.getFunctionalClassKind(parent, asString);
    }

    public static final int contextFunctionTypeParamsCount(KotlinType $this$contextFunctionTypeParamsCount) {
        Intrinsics.checkNotNullParameter($this$contextFunctionTypeParamsCount, "<this>");
        AnnotationDescriptor annotationDescriptor = $this$contextFunctionTypeParamsCount.getAnnotations().mo1162findAnnotation(StandardNames.FqNames.contextFunctionTypeParams);
        if (annotationDescriptor == null) {
            return 0;
        }
        ConstantValue constantValue = (ConstantValue) MapsKt.getValue(annotationDescriptor.getAllValueArguments(), StandardNames.CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME);
        Intrinsics.checkNotNull(constantValue, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.constants.IntValue");
        return ((IntValue) constantValue).getValue().intValue();
    }

    public static final KotlinType getReceiverTypeFromFunctionType(KotlinType $this$getReceiverTypeFromFunctionType) {
        Intrinsics.checkNotNullParameter($this$getReceiverTypeFromFunctionType, "<this>");
        if (!isBuiltinFunctionalType($this$getReceiverTypeFromFunctionType)) {
            throw new AssertionError("Not a function type: " + $this$getReceiverTypeFromFunctionType);
        }
        if (!isTypeAnnotatedWithExtensionFunctionType($this$getReceiverTypeFromFunctionType)) {
            return null;
        }
        int index = contextFunctionTypeParamsCount($this$getReceiverTypeFromFunctionType);
        return $this$getReceiverTypeFromFunctionType.getArguments().get(index).getType();
    }

    public static final List<KotlinType> getContextReceiverTypesFromFunctionType(KotlinType $this$getContextReceiverTypesFromFunctionType) {
        Intrinsics.checkNotNullParameter($this$getContextReceiverTypesFromFunctionType, "<this>");
        if (!isBuiltinFunctionalType($this$getContextReceiverTypesFromFunctionType)) {
            throw new AssertionError("Not a function type: " + $this$getContextReceiverTypesFromFunctionType);
        }
        int contextReceiversCount = contextFunctionTypeParamsCount($this$getContextReceiverTypesFromFunctionType);
        if (contextReceiversCount == 0) {
            return CollectionsKt.emptyList();
        }
        Iterable $this$map$iv = $this$getContextReceiverTypesFromFunctionType.getArguments().subList(0, contextReceiversCount);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            TypeProjection it = (TypeProjection) item$iv$iv;
            destination$iv$iv.add(it.getType());
        }
        return (List) destination$iv$iv;
    }

    public static final KotlinType getReturnTypeFromFunctionType(KotlinType $this$getReturnTypeFromFunctionType) {
        Intrinsics.checkNotNullParameter($this$getReturnTypeFromFunctionType, "<this>");
        if (!isBuiltinFunctionalType($this$getReturnTypeFromFunctionType)) {
            throw new AssertionError("Not a function type: " + $this$getReturnTypeFromFunctionType);
        }
        KotlinType type = ((TypeProjection) CollectionsKt.last((List<? extends Object>) $this$getReturnTypeFromFunctionType.getArguments())).getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return type;
    }

    public static final List<TypeProjection> getValueParameterTypesFromFunctionType(KotlinType $this$getValueParameterTypesFromFunctionType) {
        Intrinsics.checkNotNullParameter($this$getValueParameterTypesFromFunctionType, "<this>");
        if (!isBuiltinFunctionalType($this$getValueParameterTypesFromFunctionType)) {
            throw new AssertionError("Not a function type: " + $this$getValueParameterTypesFromFunctionType);
        }
        List arguments = $this$getValueParameterTypesFromFunctionType.getArguments();
        int first = contextFunctionTypeParamsCount($this$getValueParameterTypesFromFunctionType) + (isBuiltinExtensionFunctionalType($this$getValueParameterTypesFromFunctionType) ? 1 : 0);
        int last = arguments.size() - 1;
        if (!(first <= last)) {
            throw new AssertionError("Not an exact function type: " + $this$getValueParameterTypesFromFunctionType);
        }
        return arguments.subList(first, last);
    }

    public static final Name extractParameterNameFromFunctionTypeArgument(KotlinType $this$extractParameterNameFromFunctionTypeArgument) {
        String it;
        Intrinsics.checkNotNullParameter($this$extractParameterNameFromFunctionTypeArgument, "<this>");
        AnnotationDescriptor annotation = $this$extractParameterNameFromFunctionTypeArgument.getAnnotations().mo1162findAnnotation(StandardNames.FqNames.parameterName);
        if (annotation == null) {
            return null;
        }
        Object singleOrNull = CollectionsKt.singleOrNull(annotation.getAllValueArguments().values());
        StringValue stringValue = singleOrNull instanceof StringValue ? (StringValue) singleOrNull : null;
        if (stringValue != null && (it = stringValue.getValue()) != null) {
            if (!Name.isValidIdentifier(it)) {
                it = null;
            }
            if (it != null) {
                String name = it;
                return Name.identifier(name);
            }
        }
        return null;
    }

    public static final List<TypeProjection> getFunctionTypeArgumentProjections(KotlinType receiverType, List<? extends KotlinType> contextReceiverTypes, List<? extends KotlinType> parameterTypes, List<Name> list, KotlinType returnType, KotlinBuiltIns builtIns) {
        Intrinsics.checkNotNullParameter(contextReceiverTypes, "contextReceiverTypes");
        Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        ArrayList arguments = new ArrayList(parameterTypes.size() + contextReceiverTypes.size() + (receiverType != null ? 1 : 0) + 1);
        List<? extends KotlinType> $this$map$iv = contextReceiverTypes;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KotlinType it = (KotlinType) item$iv$iv;
            destination$iv$iv.add(TypeUtilsKt.asTypeProjection(it));
        }
        arguments.addAll((List) destination$iv$iv);
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(arguments, receiverType != null ? TypeUtilsKt.asTypeProjection(receiverType) : null);
        List<? extends KotlinType> $this$mapIndexedTo$iv = parameterTypes;
        ArrayList destination$iv = arguments;
        int index$iv = 0;
        for (Object item$iv : $this$mapIndexedTo$iv) {
            int index$iv2 = index$iv + 1;
            if (index$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            KotlinType type = (KotlinType) item$iv;
            int index = index$iv;
            Name it2 = (list == null || (it2 = list.get(index)) == null || it2.isSpecial()) ? null : null;
            Name name = it2;
            if (name != null) {
                FqName fqName = StandardNames.FqNames.parameterName;
                Name name2 = StandardNames.NAME;
                String asString = name.asString();
                Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
                BuiltInAnnotationDescriptor parameterNameAnnotation = new BuiltInAnnotationDescriptor(builtIns, fqName, MapsKt.mapOf(TuplesKt.to(name2, new StringValue(asString))), false, 8, null);
                type = TypeUtilsKt.replaceAnnotations(type, Annotations.Companion.create(CollectionsKt.plus(type.getAnnotations(), parameterNameAnnotation)));
            }
            KotlinType typeToUse = type;
            destination$iv.add(TypeUtilsKt.asTypeProjection(typeToUse));
            index$iv = index$iv2;
        }
        arguments.add(TypeUtilsKt.asTypeProjection(returnType));
        return arguments;
    }

    public static /* synthetic */ SimpleType createFunctionType$default(KotlinBuiltIns kotlinBuiltIns, Annotations annotations, KotlinType kotlinType, List list, List list2, List list3, KotlinType kotlinType2, boolean z, int i, Object obj) {
        boolean z2;
        if ((i & 128) == 0) {
            z2 = z;
        } else {
            z2 = false;
        }
        return createFunctionType(kotlinBuiltIns, annotations, kotlinType, list, list2, list3, kotlinType2, z2);
    }

    public static final SimpleType createFunctionType(KotlinBuiltIns builtIns, Annotations annotations, KotlinType receiverType, List<? extends KotlinType> contextReceiverTypes, List<? extends KotlinType> parameterTypes, List<Name> list, KotlinType returnType, boolean suspendFunction) {
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(contextReceiverTypes, "contextReceiverTypes");
        Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        List arguments = getFunctionTypeArgumentProjections(receiverType, contextReceiverTypes, parameterTypes, list, returnType, builtIns);
        int parameterCount = parameterTypes.size() + contextReceiverTypes.size() + (receiverType == null ? 0 : 1);
        ClassDescriptor classDescriptor = getFunctionDescriptor(builtIns, parameterCount, suspendFunction);
        Annotations typeAnnotations = annotations;
        if (receiverType != null) {
            typeAnnotations = withExtensionFunctionAnnotation(typeAnnotations, builtIns);
        }
        if (!contextReceiverTypes.isEmpty()) {
            typeAnnotations = withContextReceiversFunctionAnnotation(typeAnnotations, builtIns, contextReceiverTypes.size());
        }
        return KotlinTypeFactory.simpleNotNullType(TypeAttributesKt.toDefaultAttributes(typeAnnotations), classDescriptor, arguments);
    }

    public static final Annotations withExtensionFunctionAnnotation(Annotations $this$withExtensionFunctionAnnotation, KotlinBuiltIns builtIns) {
        Intrinsics.checkNotNullParameter($this$withExtensionFunctionAnnotation, "<this>");
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        if ($this$withExtensionFunctionAnnotation.hasAnnotation(StandardNames.FqNames.extensionFunctionType)) {
            return $this$withExtensionFunctionAnnotation;
        }
        return Annotations.Companion.create(CollectionsKt.plus($this$withExtensionFunctionAnnotation, new BuiltInAnnotationDescriptor(builtIns, StandardNames.FqNames.extensionFunctionType, MapsKt.emptyMap(), false, 8, null)));
    }

    public static final Annotations withContextReceiversFunctionAnnotation(Annotations $this$withContextReceiversFunctionAnnotation, KotlinBuiltIns builtIns, int contextReceiversCount) {
        Intrinsics.checkNotNullParameter($this$withContextReceiversFunctionAnnotation, "<this>");
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        if ($this$withContextReceiversFunctionAnnotation.hasAnnotation(StandardNames.FqNames.contextFunctionTypeParams)) {
            return $this$withContextReceiversFunctionAnnotation;
        }
        return Annotations.Companion.create(CollectionsKt.plus($this$withContextReceiversFunctionAnnotation, new BuiltInAnnotationDescriptor(builtIns, StandardNames.FqNames.contextFunctionTypeParams, MapsKt.mapOf(TuplesKt.to(StandardNames.CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME, new IntValue(contextReceiversCount))), false, 8, null)));
    }

    public static final ClassDescriptor getFunctionDescriptor(KotlinBuiltIns builtIns, int parameterCount, boolean isSuspendFunction) {
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        ClassDescriptor suspendFunction = isSuspendFunction ? builtIns.getSuspendFunction(parameterCount) : builtIns.getFunction(parameterCount);
        Intrinsics.checkNotNull(suspendFunction);
        return suspendFunction;
    }
}