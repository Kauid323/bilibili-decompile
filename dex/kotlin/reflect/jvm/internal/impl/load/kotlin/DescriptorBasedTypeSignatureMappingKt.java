package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.ExpandedTypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSubstitutorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.io.FilenameUtils;

/* compiled from: descriptorBasedTypeSignatureMapping.kt */
public final class DescriptorBasedTypeSignatureMappingKt {
    public static /* synthetic */ Object mapType$default(KotlinType kotlinType, JvmTypeFactory jvmTypeFactory, TypeMappingMode typeMappingMode, TypeMappingConfiguration typeMappingConfiguration, JvmDescriptorTypeWriter jvmDescriptorTypeWriter, Function3 function3, int i, Object obj) {
        Function3<Object, Object, Object, Unit> function32;
        if ((i & 32) == 0) {
            function32 = function3;
        } else {
            function32 = FunctionsKt.getDO_NOTHING_3();
        }
        return mapType(kotlinType, jvmTypeFactory, typeMappingMode, typeMappingConfiguration, jvmDescriptorTypeWriter, function32);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v31, types: [T, java.lang.Object] */
    public static final <T> T mapType(KotlinType kotlinType, JvmTypeFactory<T> factory, TypeMappingMode mode, final TypeMappingConfiguration<? extends T> typeMappingConfiguration, JvmDescriptorTypeWriter<T> jvmDescriptorTypeWriter, Function3<? super KotlinType, ? super T, ? super TypeMappingMode, Unit> writeGenericType) {
        T jvmType;
        ClassDescriptor enumClassIfEnumEntry;
        KotlinType expandedType;
        Object arrayElementType;
        Intrinsics.checkNotNullParameter(kotlinType, "kotlinType");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(typeMappingConfiguration, "typeMappingConfiguration");
        Intrinsics.checkNotNullParameter(writeGenericType, "writeGenericType");
        KotlinType newType = typeMappingConfiguration.preprocessType(kotlinType);
        if (newType != null) {
            return (T) mapType(newType, factory, mode, typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
        }
        if (FunctionTypesKt.isSuspendFunctionType(kotlinType)) {
            return (T) mapType(SuspendFunctionTypesKt.transformSuspendFunctionToRuntimeFunctionType(kotlinType), factory, mode, typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
        }
        SimpleClassicTypeSystemContext $this$mapType_u24lambda_u241 = SimpleClassicTypeSystemContext.INSTANCE;
        Object builtInType = TypeSignatureMappingKt.mapBuiltInType($this$mapType_u24lambda_u241, kotlinType, factory, mode);
        if (builtInType != null) {
            ?? r3 = (Object) TypeSignatureMappingKt.boxTypeIfNeeded(factory, builtInType, mode.getNeedPrimitiveBoxing());
            writeGenericType.invoke(kotlinType, r3, mode);
            return r3;
        }
        TypeConstructor constructor = kotlinType.getConstructor();
        if (constructor instanceof IntersectionTypeConstructor) {
            KotlinType alternativeType = ((IntersectionTypeConstructor) constructor).getAlternativeType();
            if (alternativeType == null) {
                alternativeType = typeMappingConfiguration.commonSupertype(((IntersectionTypeConstructor) constructor).mo1172getSupertypes());
            }
            KotlinType intersectionType = alternativeType;
            return (T) mapType(TypeUtilsKt.replaceArgumentsWithStarProjections(intersectionType), factory, mode, typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
        }
        ClassifierDescriptor descriptor = constructor.mo1171getDeclarationDescriptor();
        if (descriptor == null) {
            throw new UnsupportedOperationException("no descriptor for type constructor of " + kotlinType);
        }
        if (ErrorUtils.isError(descriptor)) {
            T t = (T) factory.createObjectType("error/NonExistentClass");
            typeMappingConfiguration.processErrorType(kotlinType, (ClassDescriptor) descriptor);
            if (jvmDescriptorTypeWriter != 0) {
                jvmDescriptorTypeWriter.writeClass(t);
            }
            return t;
        } else if ((descriptor instanceof ClassDescriptor) && KotlinBuiltIns.isArray(kotlinType)) {
            if (kotlinType.getArguments().size() != 1) {
                throw new UnsupportedOperationException("arrays must have one type argument");
            }
            TypeProjection memberProjection = kotlinType.getArguments().get(0);
            KotlinType memberType = memberProjection.getType();
            Intrinsics.checkNotNullExpressionValue(memberType, "getType(...)");
            if (memberProjection.getProjectionKind() == Variance.IN_VARIANCE) {
                arrayElementType = factory.createObjectType("java/lang/Object");
                if (jvmDescriptorTypeWriter != 0) {
                    jvmDescriptorTypeWriter.writeArrayType();
                    jvmDescriptorTypeWriter.writeClass(arrayElementType);
                    jvmDescriptorTypeWriter.writeArrayEnd();
                }
            } else {
                if (jvmDescriptorTypeWriter != 0) {
                    jvmDescriptorTypeWriter.writeArrayType();
                }
                Variance projectionKind = memberProjection.getProjectionKind();
                Intrinsics.checkNotNullExpressionValue(projectionKind, "getProjectionKind(...)");
                arrayElementType = mapType(memberType, factory, mode.toGenericArgumentMode(projectionKind, true), typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
                if (jvmDescriptorTypeWriter != 0) {
                    jvmDescriptorTypeWriter.writeArrayEnd();
                }
            }
            return (T) factory.createFromString(AbstractJsonLexerKt.BEGIN_LIST + factory.toString(arrayElementType));
        } else if (descriptor instanceof ClassDescriptor) {
            if (InlineClassesUtilsKt.isInlineClass(descriptor) && !mode.getNeedInlineClassWrapping() && (expandedType = (KotlinType) ExpandedTypeUtilsKt.computeExpandedTypeForInlineClass(new ClassicTypeSystemContext() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.DescriptorBasedTypeSignatureMappingKt$mapType$typeSystemContext$1
                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
                public KotlinTypeMarker makeNullable(KotlinTypeMarker $this$makeNullable) {
                    RigidTypeMarker withNullability;
                    Intrinsics.checkNotNullParameter($this$makeNullable, "<this>");
                    RigidTypeMarker asRigidType = asRigidType($this$makeNullable);
                    return (asRigidType == null || (withNullability = withNullability(asRigidType, true)) == null) ? $this$makeNullable : withNullability;
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean areEqualTypeConstructors(TypeConstructorMarker c1, TypeConstructorMarker c2) {
                    return ClassicTypeSystemContext.DefaultImpls.areEqualTypeConstructors(this, c1, c2);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ int argumentsCount(KotlinTypeMarker $this$argumentsCount) {
                    return ClassicTypeSystemContext.DefaultImpls.argumentsCount(this, $this$argumentsCount);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
                public /* bridge */ SimpleTypeMarker arrayType(KotlinTypeMarker componentType) {
                    return ClassicTypeSystemContext.DefaultImpls.arrayType(this, componentType);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ TypeArgumentListMarker asArgumentList(RigidTypeMarker $this$asArgumentList) {
                    return ClassicTypeSystemContext.DefaultImpls.asArgumentList(this, $this$asArgumentList);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ CapturedTypeMarker asCapturedType(SimpleTypeMarker $this$asCapturedType) {
                    return ClassicTypeSystemContext.DefaultImpls.asCapturedType(this, $this$asCapturedType);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ DefinitelyNotNullTypeMarker asDefinitelyNotNullType(RigidTypeMarker $this$asDefinitelyNotNullType) {
                    return ClassicTypeSystemContext.DefaultImpls.asDefinitelyNotNullType(this, $this$asDefinitelyNotNullType);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ DynamicTypeMarker asDynamicType(FlexibleTypeMarker $this$asDynamicType) {
                    return ClassicTypeSystemContext.DefaultImpls.asDynamicType(this, $this$asDynamicType);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ FlexibleTypeMarker asFlexibleType(KotlinTypeMarker $this$asFlexibleType) {
                    return ClassicTypeSystemContext.DefaultImpls.asFlexibleType(this, $this$asFlexibleType);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ SimpleTypeMarker asRigidType(KotlinTypeMarker $this$asRigidType) {
                    return ClassicTypeSystemContext.DefaultImpls.asRigidType(this, $this$asRigidType);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ TypeArgumentMarker asTypeArgument(KotlinTypeMarker $this$asTypeArgument) {
                    return ClassicTypeSystemContext.DefaultImpls.asTypeArgument(this, $this$asTypeArgument);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ SimpleType captureFromArguments(RigidTypeMarker type, CaptureStatus status) {
                    return ClassicTypeSystemContext.DefaultImpls.captureFromArguments(this, type, status);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ CaptureStatus captureStatus(CapturedTypeMarker $this$captureStatus) {
                    return ClassicTypeSystemContext.DefaultImpls.captureStatus(this, $this$captureStatus);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext
                public /* bridge */ KotlinTypeMarker createFlexibleType(RigidTypeMarker lowerBound, RigidTypeMarker upperBound) {
                    return ClassicTypeSystemContext.DefaultImpls.createFlexibleType(this, lowerBound, upperBound);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ TypeArgumentMarker getArgument(KotlinTypeMarker $this$getArgument, int index) {
                    return ClassicTypeSystemContext.DefaultImpls.getArgument(this, $this$getArgument, index);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ List<TypeArgumentMarker> getArguments(KotlinTypeMarker $this$getArguments) {
                    return ClassicTypeSystemContext.DefaultImpls.getArguments(this, $this$getArguments);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
                public /* bridge */ FqNameUnsafe getClassFqNameUnsafe(TypeConstructorMarker $this$getClassFqNameUnsafe) {
                    return ClassicTypeSystemContext.DefaultImpls.getClassFqNameUnsafe(this, $this$getClassFqNameUnsafe);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ TypeParameterMarker getParameter(TypeConstructorMarker $this$getParameter, int index) {
                    return ClassicTypeSystemContext.DefaultImpls.getParameter(this, $this$getParameter, index);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ List<TypeParameterMarker> getParameters(TypeConstructorMarker $this$getParameters) {
                    return ClassicTypeSystemContext.DefaultImpls.getParameters(this, $this$getParameters);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
                public /* bridge */ PrimitiveType getPrimitiveArrayType(TypeConstructorMarker $this$getPrimitiveArrayType) {
                    return ClassicTypeSystemContext.DefaultImpls.getPrimitiveArrayType(this, $this$getPrimitiveArrayType);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
                public /* bridge */ PrimitiveType getPrimitiveType(TypeConstructorMarker $this$getPrimitiveType) {
                    return ClassicTypeSystemContext.DefaultImpls.getPrimitiveType(this, $this$getPrimitiveType);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
                public /* bridge */ KotlinTypeMarker getRepresentativeUpperBound(TypeParameterMarker $this$getRepresentativeUpperBound) {
                    return ClassicTypeSystemContext.DefaultImpls.getRepresentativeUpperBound(this, $this$getRepresentativeUpperBound);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ KotlinTypeMarker getType(TypeArgumentMarker $this$getType) {
                    return ClassicTypeSystemContext.DefaultImpls.getType(this, $this$getType);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ TypeConstructorMarker getTypeConstructor(TypeParameterMarker $this$getTypeConstructor) {
                    return ClassicTypeSystemContext.DefaultImpls.getTypeConstructor(this, $this$getTypeConstructor);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ TypeParameterMarker getTypeParameter(TypeVariableTypeConstructorMarker $this$typeParameter) {
                    return ClassicTypeSystemContext.DefaultImpls.getTypeParameter(this, $this$typeParameter);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ TypeParameterMarker getTypeParameterClassifier(TypeConstructorMarker $this$getTypeParameterClassifier) {
                    return ClassicTypeSystemContext.DefaultImpls.getTypeParameterClassifier(this, $this$getTypeParameterClassifier);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
                public /* bridge */ KotlinTypeMarker getUnsubstitutedUnderlyingType(KotlinTypeMarker $this$getUnsubstitutedUnderlyingType) {
                    return ClassicTypeSystemContext.DefaultImpls.getUnsubstitutedUnderlyingType(this, $this$getUnsubstitutedUnderlyingType);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ List<KotlinTypeMarker> getUpperBounds(TypeParameterMarker $this$getUpperBounds) {
                    return ClassicTypeSystemContext.DefaultImpls.getUpperBounds(this, $this$getUpperBounds);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ TypeVariance getVariance(TypeArgumentMarker $this$getVariance) {
                    return ClassicTypeSystemContext.DefaultImpls.getVariance(this, $this$getVariance);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ TypeVariance getVariance(TypeParameterMarker $this$getVariance) {
                    return ClassicTypeSystemContext.DefaultImpls.getVariance(this, $this$getVariance);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
                public /* bridge */ boolean hasAnnotation(KotlinTypeMarker $this$hasAnnotation, FqName fqName) {
                    return ClassicTypeSystemContext.DefaultImpls.hasAnnotation(this, $this$hasAnnotation, fqName);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean hasRecursiveBounds(TypeParameterMarker $this$hasRecursiveBounds, TypeConstructorMarker selfConstructor) {
                    return ClassicTypeSystemContext.DefaultImpls.hasRecursiveBounds(this, $this$hasRecursiveBounds, selfConstructor);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemOptimizationContext
                public /* bridge */ boolean identicalArguments(RigidTypeMarker a, RigidTypeMarker b) {
                    return ClassicTypeSystemContext.DefaultImpls.identicalArguments(this, a, b);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ KotlinTypeMarker intersectTypes(Collection<? extends KotlinTypeMarker> collection) {
                    return ClassicTypeSystemContext.DefaultImpls.intersectTypes(this, collection);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isAnyConstructor(TypeConstructorMarker $this$isAnyConstructor) {
                    return ClassicTypeSystemContext.DefaultImpls.isAnyConstructor(this, $this$isAnyConstructor);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
                public /* bridge */ boolean isArrayOrNullableArray(KotlinTypeMarker $this$isArrayOrNullableArray) {
                    return ClassicTypeSystemContext.DefaultImpls.isArrayOrNullableArray(this, $this$isArrayOrNullableArray);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isClassTypeConstructor(TypeConstructorMarker $this$isClassTypeConstructor) {
                    return ClassicTypeSystemContext.DefaultImpls.isClassTypeConstructor(this, $this$isClassTypeConstructor);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isCommonFinalClassConstructor(TypeConstructorMarker $this$isCommonFinalClassConstructor) {
                    return ClassicTypeSystemContext.DefaultImpls.isCommonFinalClassConstructor(this, $this$isCommonFinalClassConstructor);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isDenotable(TypeConstructorMarker $this$isDenotable) {
                    return ClassicTypeSystemContext.DefaultImpls.isDenotable(this, $this$isDenotable);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isError(KotlinTypeMarker $this$isError) {
                    return ClassicTypeSystemContext.DefaultImpls.isError(this, $this$isError);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
                public /* bridge */ boolean isInlineClass(TypeConstructorMarker $this$isInlineClass) {
                    return ClassicTypeSystemContext.DefaultImpls.isInlineClass(this, $this$isInlineClass);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isIntegerLiteralTypeConstructor(TypeConstructorMarker $this$isIntegerLiteralTypeConstructor) {
                    return ClassicTypeSystemContext.DefaultImpls.isIntegerLiteralTypeConstructor(this, $this$isIntegerLiteralTypeConstructor);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isIntersection(TypeConstructorMarker $this$isIntersection) {
                    return ClassicTypeSystemContext.DefaultImpls.isIntersection(this, $this$isIntersection);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext
                public /* bridge */ boolean isK2() {
                    return ClassicTypeSystemContext.DefaultImpls.isK2(this);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isMarkedNullable(KotlinTypeMarker $this$isMarkedNullable) {
                    return ClassicTypeSystemContext.DefaultImpls.isMarkedNullable(this, $this$isMarkedNullable);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isNotNullTypeParameter(KotlinTypeMarker $this$isNotNullTypeParameter) {
                    return ClassicTypeSystemContext.DefaultImpls.isNotNullTypeParameter(this, $this$isNotNullTypeParameter);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isNothingConstructor(TypeConstructorMarker $this$isNothingConstructor) {
                    return ClassicTypeSystemContext.DefaultImpls.isNothingConstructor(this, $this$isNothingConstructor);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isNullableType(KotlinTypeMarker $this$isNullableType) {
                    return ClassicTypeSystemContext.DefaultImpls.isNullableType(this, $this$isNullableType);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isOldCapturedType(CapturedTypeMarker $this$isOldCapturedType) {
                    return ClassicTypeSystemContext.DefaultImpls.isOldCapturedType(this, $this$isOldCapturedType);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isPrimitiveType(SimpleTypeMarker $this$isPrimitiveType) {
                    return ClassicTypeSystemContext.DefaultImpls.isPrimitiveType(this, $this$isPrimitiveType);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isProjectionNotNull(CapturedTypeMarker $this$isProjectionNotNull) {
                    return ClassicTypeSystemContext.DefaultImpls.isProjectionNotNull(this, $this$isProjectionNotNull);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isRawType(KotlinTypeMarker $this$isRawType) {
                    return ClassicTypeSystemContext.DefaultImpls.isRawType(this, $this$isRawType);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isSingleClassifierType(RigidTypeMarker $this$isSingleClassifierType) {
                    return ClassicTypeSystemContext.DefaultImpls.isSingleClassifierType(this, $this$isSingleClassifierType);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isStarProjection(TypeArgumentMarker $this$isStarProjection) {
                    return ClassicTypeSystemContext.DefaultImpls.isStarProjection(this, $this$isStarProjection);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isStubType(RigidTypeMarker $this$isStubType) {
                    return ClassicTypeSystemContext.DefaultImpls.isStubType(this, $this$isStubType);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isStubTypeForBuilderInference(RigidTypeMarker $this$isStubTypeForBuilderInference) {
                    return ClassicTypeSystemContext.DefaultImpls.isStubTypeForBuilderInference(this, $this$isStubTypeForBuilderInference);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isTypeVariableType(KotlinTypeMarker $this$isTypeVariableType) {
                    return ClassicTypeSystemContext.DefaultImpls.isTypeVariableType(this, $this$isTypeVariableType);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
                public /* bridge */ boolean isUnderKotlinPackage(TypeConstructorMarker $this$isUnderKotlinPackage) {
                    return ClassicTypeSystemContext.DefaultImpls.isUnderKotlinPackage(this, $this$isUnderKotlinPackage);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ SimpleTypeMarker lowerBound(FlexibleTypeMarker $this$lowerBound) {
                    return ClassicTypeSystemContext.DefaultImpls.lowerBound(this, $this$lowerBound);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ KotlinTypeMarker lowerType(CapturedTypeMarker $this$lowerType) {
                    return ClassicTypeSystemContext.DefaultImpls.lowerType(this, $this$lowerType);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ KotlinTypeMarker makeDefinitelyNotNullOrNotNull(KotlinTypeMarker $this$makeDefinitelyNotNullOrNotNull, boolean preserveAttributes) {
                    return ClassicTypeSystemContext.DefaultImpls.makeDefinitelyNotNullOrNotNull(this, $this$makeDefinitelyNotNullOrNotNull, preserveAttributes);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeCheckerProviderContext
                public /* bridge */ TypeCheckerState newTypeCheckerState(boolean errorTypesEqualToAnything, boolean stubTypesEqualToAnything, boolean dnnTypesEqualToFlexible) {
                    return ClassicTypeSystemContext.DefaultImpls.newTypeCheckerState(this, errorTypesEqualToAnything, stubTypesEqualToAnything, dnnTypesEqualToFlexible);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
                public /* bridge */ SimpleTypeMarker nullableAnyType() {
                    return ClassicTypeSystemContext.DefaultImpls.nullableAnyType(this);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ SimpleTypeMarker original(DefinitelyNotNullTypeMarker $this$original) {
                    return ClassicTypeSystemContext.DefaultImpls.original(this, $this$original);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ int parametersCount(TypeConstructorMarker $this$parametersCount) {
                    return ClassicTypeSystemContext.DefaultImpls.parametersCount(this, $this$parametersCount);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ Collection<KotlinTypeMarker> possibleIntegerTypes(RigidTypeMarker $this$possibleIntegerTypes) {
                    return ClassicTypeSystemContext.DefaultImpls.possibleIntegerTypes(this, $this$possibleIntegerTypes);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ TypeArgumentMarker projection(CapturedTypeConstructorMarker $this$projection) {
                    return ClassicTypeSystemContext.DefaultImpls.projection(this, $this$projection);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ KotlinTypeMarker safeSubstitute(TypeSubstitutorMarker $this$safeSubstitute, KotlinTypeMarker type) {
                    return ClassicTypeSystemContext.DefaultImpls.safeSubstitute(this, $this$safeSubstitute, type);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(RigidTypeMarker type) {
                    return ClassicTypeSystemContext.DefaultImpls.substitutionSupertypePolicy(this, type);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ Collection<KotlinTypeMarker> supertypes(TypeConstructorMarker $this$supertypes) {
                    return ClassicTypeSystemContext.DefaultImpls.supertypes(this, $this$supertypes);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ CapturedTypeConstructorMarker typeConstructor(CapturedTypeMarker $this$typeConstructor) {
                    return ClassicTypeSystemContext.DefaultImpls.typeConstructor((ClassicTypeSystemContext) this, $this$typeConstructor);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ TypeConstructorMarker typeConstructor(RigidTypeMarker $this$typeConstructor) {
                    return ClassicTypeSystemContext.DefaultImpls.typeConstructor(this, $this$typeConstructor);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
                public /* bridge */ TypeSubstitutorMarker typeSubstitutorForUnderlyingType(Map<TypeConstructorMarker, ? extends KotlinTypeMarker> map) {
                    return ClassicTypeSystemContext.DefaultImpls.typeSubstitutorForUnderlyingType(this, map);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ SimpleTypeMarker upperBound(FlexibleTypeMarker $this$upperBound) {
                    return ClassicTypeSystemContext.DefaultImpls.upperBound(this, $this$upperBound);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ KotlinTypeMarker withNullability(KotlinTypeMarker $this$withNullability, boolean nullable) {
                    return ClassicTypeSystemContext.DefaultImpls.withNullability(this, $this$withNullability, nullable);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ SimpleTypeMarker withNullability(RigidTypeMarker $this$withNullability, boolean nullable) {
                    return ClassicTypeSystemContext.DefaultImpls.withNullability((ClassicTypeSystemContext) this, $this$withNullability, nullable);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext
                public KotlinBuiltIns getBuiltIns() {
                    KotlinBuiltIns builtIns = typeMappingConfiguration.getBuiltIns();
                    return builtIns == null ? ClassicTypeSystemContext.DefaultImpls.getBuiltIns(this) : builtIns;
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public CapturedTypeMarker asCapturedTypeUnwrappingDnn(RigidTypeMarker $this$asCapturedTypeUnwrappingDnn) {
                    Intrinsics.checkNotNullParameter($this$asCapturedTypeUnwrappingDnn, "<this>");
                    return asCapturedType(originalIfDefinitelyNotNullable($this$asCapturedTypeUnwrappingDnn));
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public boolean isCapturedType(KotlinTypeMarker $this$isCapturedType) {
                    Intrinsics.checkNotNullParameter($this$isCapturedType, "<this>");
                    RigidTypeMarker asRigidType = asRigidType($this$isCapturedType);
                    return (asRigidType != null ? asCapturedTypeUnwrappingDnn(asRigidType) : null) != null;
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public SimpleTypeMarker originalIfDefinitelyNotNullable(RigidTypeMarker $this$originalIfDefinitelyNotNullable) {
                    SimpleTypeMarker original;
                    Intrinsics.checkNotNullParameter($this$originalIfDefinitelyNotNullable, "<this>");
                    DefinitelyNotNullTypeMarker asDefinitelyNotNullType = asDefinitelyNotNullType($this$originalIfDefinitelyNotNullable);
                    return (asDefinitelyNotNullType == null || (original = original(asDefinitelyNotNullType)) == null) ? (SimpleTypeMarker) $this$originalIfDefinitelyNotNullable : original;
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public KotlinTypeMarker makeDefinitelyNotNullOrNotNull(KotlinTypeMarker $this$makeDefinitelyNotNullOrNotNull) {
                    Intrinsics.checkNotNullParameter($this$makeDefinitelyNotNullOrNotNull, "<this>");
                    return makeDefinitelyNotNullOrNotNull($this$makeDefinitelyNotNullOrNotNull, false);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public TypeArgumentMarker getArgumentOrNull(RigidTypeMarker $this$getArgumentOrNull, int index) {
                    Intrinsics.checkNotNullParameter($this$getArgumentOrNull, "<this>");
                    boolean z = false;
                    if (index >= 0 && index < argumentsCount($this$getArgumentOrNull)) {
                        z = true;
                    }
                    if (z) {
                        return getArgument($this$getArgumentOrNull, index);
                    }
                    return null;
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public RigidTypeMarker lowerBoundIfFlexible(KotlinTypeMarker $this$lowerBoundIfFlexible) {
                    RigidTypeMarker lowerBound;
                    Intrinsics.checkNotNullParameter($this$lowerBoundIfFlexible, "<this>");
                    FlexibleTypeMarker asFlexibleType = asFlexibleType($this$lowerBoundIfFlexible);
                    if (asFlexibleType == null || (lowerBound = lowerBound(asFlexibleType)) == null) {
                        RigidTypeMarker asRigidType = asRigidType($this$lowerBoundIfFlexible);
                        Intrinsics.checkNotNull(asRigidType);
                        return asRigidType;
                    }
                    return lowerBound;
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public RigidTypeMarker upperBoundIfFlexible(KotlinTypeMarker $this$upperBoundIfFlexible) {
                    RigidTypeMarker upperBound;
                    Intrinsics.checkNotNullParameter($this$upperBoundIfFlexible, "<this>");
                    FlexibleTypeMarker asFlexibleType = asFlexibleType($this$upperBoundIfFlexible);
                    if (asFlexibleType == null || (upperBound = upperBound(asFlexibleType)) == null) {
                        RigidTypeMarker asRigidType = asRigidType($this$upperBoundIfFlexible);
                        Intrinsics.checkNotNull(asRigidType);
                        return asRigidType;
                    }
                    return upperBound;
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public boolean isFlexibleWithDifferentTypeConstructors(KotlinTypeMarker $this$isFlexibleWithDifferentTypeConstructors) {
                    Intrinsics.checkNotNullParameter($this$isFlexibleWithDifferentTypeConstructors, "<this>");
                    return !Intrinsics.areEqual(typeConstructor(lowerBoundIfFlexible($this$isFlexibleWithDifferentTypeConstructors)), typeConstructor(upperBoundIfFlexible($this$isFlexibleWithDifferentTypeConstructors)));
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public boolean isFlexible(KotlinTypeMarker $this$isFlexible) {
                    Intrinsics.checkNotNullParameter($this$isFlexible, "<this>");
                    return asFlexibleType($this$isFlexible) != null;
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public boolean isDynamic(KotlinTypeMarker $this$isDynamic) {
                    Intrinsics.checkNotNullParameter($this$isDynamic, "<this>");
                    FlexibleTypeMarker asFlexibleType = asFlexibleType($this$isDynamic);
                    return (asFlexibleType != null ? asDynamicType(asFlexibleType) : null) != null;
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public boolean isDefinitelyNotNullType(KotlinTypeMarker $this$isDefinitelyNotNullType) {
                    Intrinsics.checkNotNullParameter($this$isDefinitelyNotNullType, "<this>");
                    RigidTypeMarker asRigidType = asRigidType($this$isDefinitelyNotNullType);
                    return (asRigidType != null ? asDefinitelyNotNullType(asRigidType) : null) != null;
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public boolean isDefinitelyNotNullType(RigidTypeMarker $this$isDefinitelyNotNullType) {
                    Intrinsics.checkNotNullParameter($this$isDefinitelyNotNullType, "<this>");
                    return asDefinitelyNotNullType($this$isDefinitelyNotNullType) != null;
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public boolean hasFlexibleNullability(KotlinTypeMarker $this$hasFlexibleNullability) {
                    Intrinsics.checkNotNullParameter($this$hasFlexibleNullability, "<this>");
                    return isMarkedNullable(lowerBoundIfFlexible($this$hasFlexibleNullability)) != isMarkedNullable(upperBoundIfFlexible($this$hasFlexibleNullability));
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public TypeConstructorMarker typeConstructor(KotlinTypeMarker $this$typeConstructor) {
                    Intrinsics.checkNotNullParameter($this$typeConstructor, "<this>");
                    RigidTypeMarker asRigidType = asRigidType($this$typeConstructor);
                    if (asRigidType == null) {
                        asRigidType = lowerBoundIfFlexible($this$typeConstructor);
                    }
                    return typeConstructor(asRigidType);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public boolean isNothing(KotlinTypeMarker $this$isNothing) {
                    Intrinsics.checkNotNullParameter($this$isNothing, "<this>");
                    return isNothingConstructor(typeConstructor($this$isNothing)) && !isNullableType($this$isNothing);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public boolean isClassType(RigidTypeMarker $this$isClassType) {
                    Intrinsics.checkNotNullParameter($this$isClassType, "<this>");
                    return isClassTypeConstructor(typeConstructor($this$isClassType));
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public List<SimpleTypeMarker> fastCorrespondingSupertypes(RigidTypeMarker $this$fastCorrespondingSupertypes, TypeConstructorMarker constructor2) {
                    Intrinsics.checkNotNullParameter($this$fastCorrespondingSupertypes, "<this>");
                    Intrinsics.checkNotNullParameter(constructor2, "constructor");
                    return null;
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public boolean isIntegerLiteralType(RigidTypeMarker $this$isIntegerLiteralType) {
                    Intrinsics.checkNotNullParameter($this$isIntegerLiteralType, "<this>");
                    return isIntegerLiteralTypeConstructor(typeConstructor($this$isIntegerLiteralType));
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public TypeArgumentMarker get(TypeArgumentListMarker $this$get, int index) {
                    Intrinsics.checkNotNullParameter($this$get, "<this>");
                    if ($this$get instanceof SimpleTypeMarker) {
                        return getArgument((KotlinTypeMarker) $this$get, index);
                    }
                    if ($this$get instanceof ArgumentList) {
                        TypeArgumentMarker typeArgumentMarker = ((ArgumentList) $this$get).get(index);
                        Intrinsics.checkNotNullExpressionValue(typeArgumentMarker, "get(...)");
                        return typeArgumentMarker;
                    }
                    throw new IllegalStateException(("unknown type argument list type: " + $this$get + ", " + Reflection.getOrCreateKotlinClass($this$get.getClass())).toString());
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public int size(TypeArgumentListMarker $this$size) {
                    Intrinsics.checkNotNullParameter($this$size, "<this>");
                    if ($this$size instanceof RigidTypeMarker) {
                        return argumentsCount((KotlinTypeMarker) $this$size);
                    }
                    if ($this$size instanceof ArgumentList) {
                        return ((ArgumentList) $this$size).size();
                    }
                    throw new IllegalStateException(("unknown type argument list type: " + $this$size + ", " + Reflection.getOrCreateKotlinClass($this$size.getClass())).toString());
                }
            }, kotlinType)) != null) {
                return (T) mapType(expandedType, factory, mode.wrapInlineClassesMode(), typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
            }
            if (mode.isForAnnotationParameter() && KotlinBuiltIns.isKClass((ClassDescriptor) descriptor)) {
                jvmType = (Object) factory.getJavaLangClassType();
            } else {
                ClassDescriptor original = ((ClassDescriptor) descriptor).getOriginal();
                Intrinsics.checkNotNullExpressionValue(original, "getOriginal(...)");
                jvmType = typeMappingConfiguration.getPredefinedTypeForClass(original);
                if (jvmType == null) {
                    if (((ClassDescriptor) descriptor).getKind() == ClassKind.ENUM_ENTRY) {
                        DeclarationDescriptor containingDeclaration = ((ClassDescriptor) descriptor).getContainingDeclaration();
                        Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        enumClassIfEnumEntry = (ClassDescriptor) containingDeclaration;
                    } else {
                        enumClassIfEnumEntry = (ClassDescriptor) descriptor;
                    }
                    ClassDescriptor original2 = enumClassIfEnumEntry.getOriginal();
                    Intrinsics.checkNotNullExpressionValue(original2, "getOriginal(...)");
                    jvmType = (Object) factory.createObjectType(computeInternalName(original2, typeMappingConfiguration));
                }
            }
            writeGenericType.invoke(kotlinType, jvmType, mode);
            return (T) jvmType;
        } else if (descriptor instanceof TypeParameterDescriptor) {
            KotlinType upperBound = TypeUtilsKt.getRepresentativeUpperBound((TypeParameterDescriptor) descriptor);
            T t2 = (T) mapType(kotlinType.isMarkedNullable() ? TypeUtilsKt.makeNullable(upperBound) : upperBound, factory, mode, typeMappingConfiguration, null, FunctionsKt.getDO_NOTHING_3());
            if (jvmDescriptorTypeWriter != 0) {
                Name name = descriptor.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                jvmDescriptorTypeWriter.writeTypeVariable(name, t2);
            }
            return t2;
        } else if ((descriptor instanceof TypeAliasDescriptor) && mode.getMapTypeAliases()) {
            return (T) mapType(((TypeAliasDescriptor) descriptor).getExpandedType(), factory, mode, typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
        } else {
            throw new UnsupportedOperationException("Unknown type " + kotlinType);
        }
    }

    public static final boolean hasVoidReturnType(CallableDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (descriptor instanceof ConstructorDescriptor) {
            return true;
        }
        KotlinType returnType = descriptor.getReturnType();
        Intrinsics.checkNotNull(returnType);
        if (KotlinBuiltIns.isUnit(returnType)) {
            KotlinType returnType2 = descriptor.getReturnType();
            Intrinsics.checkNotNull(returnType2);
            if (!TypeUtils.isNullableType(returnType2) && !(descriptor instanceof PropertyGetterDescriptor)) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ String computeInternalName$default(ClassDescriptor classDescriptor, TypeMappingConfiguration typeMappingConfiguration, int i, Object obj) {
        if ((i & 2) != 0) {
            typeMappingConfiguration = TypeMappingConfigurationImpl.INSTANCE;
        }
        return computeInternalName(classDescriptor, typeMappingConfiguration);
    }

    public static final String computeInternalName(ClassDescriptor klass, TypeMappingConfiguration<?> typeMappingConfiguration) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        Intrinsics.checkNotNullParameter(typeMappingConfiguration, "typeMappingConfiguration");
        String it = typeMappingConfiguration.getPredefinedFullInternalNameForClass(klass);
        if (it != null) {
            return it;
        }
        DeclarationDescriptor container = klass.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(container, "getContainingDeclaration(...)");
        String name = SpecialNames.safeIdentifier(klass.getName()).getIdentifier();
        Intrinsics.checkNotNullExpressionValue(name, "getIdentifier(...)");
        if (container instanceof PackageFragmentDescriptor) {
            FqName fqName = ((PackageFragmentDescriptor) container).getFqName();
            return fqName.isRoot() ? name : StringsKt.replace$default(fqName.asString(), (char) FilenameUtils.EXTENSION_SEPARATOR, '/', false, 4, (Object) null) + '/' + name;
        }
        ClassDescriptor containerClass = container instanceof ClassDescriptor ? (ClassDescriptor) container : null;
        if (containerClass == null) {
            throw new IllegalArgumentException("Unexpected container: " + container + " for " + klass);
        }
        String containerInternalName = typeMappingConfiguration.getPredefinedInternalNameForClass(containerClass);
        if (containerInternalName == null) {
            containerInternalName = computeInternalName(containerClass, typeMappingConfiguration);
        }
        return containerInternalName + Typography.dollar + name;
    }
}