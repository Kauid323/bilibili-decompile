package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: JavaTypeResolver.kt */
public final class JavaTypeResolver {
    private final LazyJavaResolverContext c;
    private final RawProjectionComputer projectionComputer;
    private final TypeParameterResolver typeParameterResolver;
    private final TypeParameterUpperBoundEraser typeParameterUpperBoundEraser;

    public JavaTypeResolver(LazyJavaResolverContext c, TypeParameterResolver typeParameterResolver) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(typeParameterResolver, "typeParameterResolver");
        this.c = c;
        this.typeParameterResolver = typeParameterResolver;
        this.projectionComputer = new RawProjectionComputer();
        this.typeParameterUpperBoundEraser = new TypeParameterUpperBoundEraser(this.projectionComputer, null, 2, null);
    }

    public final KotlinType transformJavaType(JavaType javaType, JavaTypeAttributes attr) {
        KotlinType transformJavaType;
        Intrinsics.checkNotNullParameter(attr, "attr");
        if (javaType instanceof JavaPrimitiveType) {
            PrimitiveType primitiveType = ((JavaPrimitiveType) javaType).getType();
            SimpleType primitiveKotlinType = primitiveType != null ? this.c.getModule().getBuiltIns().getPrimitiveKotlinType(primitiveType) : this.c.getModule().getBuiltIns().getUnitType();
            Intrinsics.checkNotNull(primitiveKotlinType);
            return primitiveKotlinType;
        } else if (javaType instanceof JavaClassifierType) {
            return transformJavaClassifierType((JavaClassifierType) javaType, attr);
        } else {
            if (javaType instanceof JavaArrayType) {
                return transformArrayType$default(this, (JavaArrayType) javaType, attr, false, 4, null);
            }
            if (!(javaType instanceof JavaWildcardType)) {
                if (javaType == null) {
                    SimpleType defaultBound = this.c.getModule().getBuiltIns().getDefaultBound();
                    Intrinsics.checkNotNullExpressionValue(defaultBound, "getDefaultBound(...)");
                    return defaultBound;
                }
                throw new UnsupportedOperationException("Unsupported type: " + javaType);
            }
            JavaType it = ((JavaWildcardType) javaType).getBound();
            if (it == null || (transformJavaType = transformJavaType(it, attr)) == null) {
                SimpleType defaultBound2 = this.c.getModule().getBuiltIns().getDefaultBound();
                Intrinsics.checkNotNullExpressionValue(defaultBound2, "getDefaultBound(...)");
                return defaultBound2;
            }
            return transformJavaType;
        }
    }

    public static /* synthetic */ KotlinType transformArrayType$default(JavaTypeResolver javaTypeResolver, JavaArrayType javaArrayType, JavaTypeAttributes javaTypeAttributes, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return javaTypeResolver.transformArrayType(javaArrayType, javaTypeAttributes, z);
    }

    public final KotlinType transformArrayType(JavaArrayType arrayType, JavaTypeAttributes attr, boolean isVararg) {
        Intrinsics.checkNotNullParameter(arrayType, "arrayType");
        Intrinsics.checkNotNullParameter(attr, "attr");
        JavaType javaComponentType = arrayType.getComponentType();
        JavaPrimitiveType javaPrimitiveType = javaComponentType instanceof JavaPrimitiveType ? (JavaPrimitiveType) javaComponentType : null;
        PrimitiveType primitiveType = javaPrimitiveType != null ? javaPrimitiveType.getType() : null;
        LazyJavaAnnotations annotations = new LazyJavaAnnotations(this.c, arrayType, true);
        if (primitiveType != null) {
            SimpleType it = this.c.getModule().getBuiltIns().getPrimitiveArrayKotlinType(primitiveType);
            Intrinsics.checkNotNull(it);
            KotlinType replaceAnnotations = TypeUtilsKt.replaceAnnotations(it, new CompositeAnnotations(it.getAnnotations(), annotations));
            Intrinsics.checkNotNull(replaceAnnotations, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
            SimpleType kotlinType = (SimpleType) replaceAnnotations;
            if (!attr.isForAnnotationParameter()) {
                return KotlinTypeFactory.flexibleType(kotlinType, kotlinType.makeNullableAsSpecified(true));
            }
            return kotlinType;
        }
        KotlinType componentType = transformJavaType(javaComponentType, JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, attr.isForAnnotationParameter(), false, null, 6, null));
        if (attr.isForAnnotationParameter()) {
            Variance projectionKind = isVararg ? Variance.OUT_VARIANCE : Variance.INVARIANT;
            SimpleType arrayType2 = this.c.getModule().getBuiltIns().getArrayType(projectionKind, componentType, annotations);
            Intrinsics.checkNotNullExpressionValue(arrayType2, "getArrayType(...)");
            return arrayType2;
        }
        SimpleType arrayType3 = this.c.getModule().getBuiltIns().getArrayType(Variance.INVARIANT, componentType, annotations);
        Intrinsics.checkNotNullExpressionValue(arrayType3, "getArrayType(...)");
        return KotlinTypeFactory.flexibleType(arrayType3, this.c.getModule().getBuiltIns().getArrayType(Variance.OUT_VARIANCE, componentType, annotations).makeNullableAsSpecified(true));
    }

    private static final ErrorType transformJavaClassifierType$errorType(JavaClassifierType $javaType) {
        return ErrorUtils.createErrorType(ErrorTypeKind.UNRESOLVED_JAVA_CLASS, $javaType.getPresentableText());
    }

    private final KotlinType transformJavaClassifierType(JavaClassifierType javaType, JavaTypeAttributes attr) {
        boolean useFlexible = (attr.isForAnnotationParameter() || attr.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) ? false : true;
        boolean isRaw = javaType.isRaw();
        if (isRaw || useFlexible) {
            SimpleType lower = computeSimpleJavaClassifierType(javaType, attr.withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND), null);
            if (lower == null) {
                return transformJavaClassifierType$errorType(javaType);
            }
            SimpleType upper = computeSimpleJavaClassifierType(javaType, attr.withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND), lower);
            if (upper == null) {
                return transformJavaClassifierType$errorType(javaType);
            }
            if (isRaw) {
                return new RawTypeImpl(lower, upper);
            }
            return KotlinTypeFactory.flexibleType(lower, upper);
        }
        SimpleType computeSimpleJavaClassifierType = computeSimpleJavaClassifierType(javaType, attr, null);
        if (computeSimpleJavaClassifierType == null) {
            computeSimpleJavaClassifierType = transformJavaClassifierType$errorType(javaType);
        }
        return computeSimpleJavaClassifierType;
    }

    private final SimpleType computeSimpleJavaClassifierType(JavaClassifierType javaType, JavaTypeAttributes attr, SimpleType lowerResult) {
        TypeAttributes defaultAttributes;
        if (lowerResult == null || (defaultAttributes = lowerResult.getAttributes()) == null) {
            defaultAttributes = TypeAttributesKt.toDefaultAttributes(new LazyJavaAnnotations(this.c, javaType, false, 4, null));
        }
        TypeAttributes attributes = defaultAttributes;
        TypeConstructor constructor = computeTypeConstructor(javaType, attr);
        if (constructor == null) {
            return null;
        }
        boolean isNullable = isNullable(attr);
        if (Intrinsics.areEqual(lowerResult != null ? lowerResult.getConstructor() : null, constructor) && !javaType.isRaw() && isNullable) {
            return lowerResult.makeNullableAsSpecified(true);
        }
        List arguments = computeArguments(javaType, attr, constructor);
        return KotlinTypeFactory.simpleType$default(attributes, constructor, arguments, isNullable, (KotlinTypeRefiner) null, 16, (Object) null);
    }

    private final TypeConstructor computeTypeConstructor(JavaClassifierType javaType, JavaTypeAttributes attr) {
        TypeConstructor typeConstructor;
        JavaClassifier classifier = javaType.getClassifier();
        if (classifier == null) {
            return createNotFoundClass(javaType);
        }
        if (classifier instanceof JavaClass) {
            FqName fqName = ((JavaClass) classifier).getFqName();
            if (fqName != null) {
                ClassDescriptor classData = mapKotlinClass(javaType, attr, fqName);
                if (classData == null) {
                    classData = this.c.getComponents().getModuleClassResolver().resolveClass((JavaClass) classifier);
                }
                return (classData == null || (typeConstructor = classData.getTypeConstructor()) == null) ? createNotFoundClass(javaType) : typeConstructor;
            }
            throw new AssertionError("Class type should have a FQ name: " + classifier);
        } else if (classifier instanceof JavaTypeParameter) {
            TypeParameterDescriptor resolveTypeParameter = this.typeParameterResolver.resolveTypeParameter((JavaTypeParameter) classifier);
            if (resolveTypeParameter != null) {
                return resolveTypeParameter.getTypeConstructor();
            }
            return null;
        } else {
            throw new IllegalStateException("Unknown classifier kind: " + classifier);
        }
    }

    private final TypeConstructor createNotFoundClass(JavaClassifierType javaType) {
        ClassId classId = ClassId.Companion.topLevel(new FqName(javaType.getClassifierQualifiedName()));
        TypeConstructor typeConstructor = this.c.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses().getClass(classId, CollectionsKt.listOf(0)).getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
        return typeConstructor;
    }

    private final ClassDescriptor mapKotlinClass(JavaClassifierType javaType, JavaTypeAttributes attr, FqName fqName) {
        if (attr.isForAnnotationParameter() && Intrinsics.areEqual(fqName, JavaTypeResolverKt.access$getJAVA_LANG_CLASS_FQ_NAME$p())) {
            return this.c.getComponents().getReflectionTypes().getKClass();
        }
        JavaToKotlinClassMapper javaToKotlin = JavaToKotlinClassMapper.INSTANCE;
        ClassDescriptor kotlinDescriptor = JavaToKotlinClassMapper.mapJavaToKotlin$default(javaToKotlin, fqName, this.c.getModule().getBuiltIns(), null, 4, null);
        if (kotlinDescriptor == null) {
            return null;
        }
        if (javaToKotlin.isReadOnly(kotlinDescriptor) && (attr.getFlexibility() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || attr.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE || argumentsMakeSenseOnlyForMutableContainer(javaType, kotlinDescriptor))) {
            return javaToKotlin.convertReadOnlyToMutable(kotlinDescriptor);
        }
        return kotlinDescriptor;
    }

    private final boolean argumentsMakeSenseOnlyForMutableContainer(JavaClassifierType $this$argumentsMakeSenseOnlyForMutableContainer, ClassDescriptor readOnlyContainer) {
        Variance mutableLastParameterVariance;
        if (JavaTypesKt.isSuperWildcard((JavaType) CollectionsKt.lastOrNull((List<? extends Object>) $this$argumentsMakeSenseOnlyForMutableContainer.getTypeArguments()))) {
            List<TypeParameterDescriptor> parameters = JavaToKotlinClassMapper.INSTANCE.convertReadOnlyToMutable(readOnlyContainer).getTypeConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) CollectionsKt.lastOrNull((List<? extends Object>) parameters);
            return (typeParameterDescriptor == null || (mutableLastParameterVariance = typeParameterDescriptor.getVariance()) == null || mutableLastParameterVariance == Variance.OUT_VARIANCE) ? false : true;
        }
        return false;
    }

    private final List<TypeProjection> computeRawTypeArguments(final JavaClassifierType javaType, List<? extends TypeParameterDescriptor> list, final TypeConstructor constructor, final JavaTypeAttributes attr) {
        Iterable $this$map$iv;
        int $i$f$map;
        Iterable $this$mapTo$iv$iv;
        TypeProjection computeProjection;
        List<? extends TypeParameterDescriptor> $this$map$iv2 = list;
        int $i$f$map2 = 0;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        Iterable $this$mapTo$iv$iv2 = $this$map$iv2;
        for (Object item$iv$iv : $this$mapTo$iv$iv2) {
            final TypeParameterDescriptor parameter = (TypeParameterDescriptor) item$iv$iv;
            if (TypeUtilsKt.hasTypeParameterRecursiveBounds(parameter, null, attr.getVisitedTypeParameters())) {
                computeProjection = TypeUtils.makeStarProjection(parameter, attr);
                $this$map$iv = $this$map$iv2;
                $i$f$map = $i$f$map2;
                $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
            } else {
                $this$map$iv = $this$map$iv2;
                $i$f$map = $i$f$map2;
                $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                LazyWrappedType erasedUpperBound = new LazyWrappedType(this.c.getStorageManager(), new Function0(this, parameter, attr, constructor, javaType) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$$Lambda$0
                    private final JavaTypeResolver arg$0;
                    private final TypeParameterDescriptor arg$1;
                    private final JavaTypeAttributes arg$2;
                    private final TypeConstructor arg$3;
                    private final JavaClassifierType arg$4;

                    {
                        this.arg$0 = this;
                        this.arg$1 = parameter;
                        this.arg$2 = attr;
                        this.arg$3 = constructor;
                        this.arg$4 = javaType;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public Object invoke() {
                        KotlinType computeRawTypeArguments$lambda$0$0;
                        computeRawTypeArguments$lambda$0$0 = JavaTypeResolver.computeRawTypeArguments$lambda$0$0(this.arg$0, this.arg$1, this.arg$2, this.arg$3, this.arg$4);
                        return computeRawTypeArguments$lambda$0$0;
                    }
                });
                computeProjection = this.projectionComputer.computeProjection(parameter, attr.markIsRaw(javaType.isRaw()), this.typeParameterUpperBoundEraser, erasedUpperBound);
            }
            destination$iv$iv.add(computeProjection);
            $this$map$iv2 = $this$map$iv;
            $i$f$map2 = $i$f$map;
            $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KotlinType computeRawTypeArguments$lambda$0$0(JavaTypeResolver this$0, TypeParameterDescriptor $parameter, JavaTypeAttributes $attr, TypeConstructor $constructor, JavaClassifierType $javaType) {
        TypeParameterUpperBoundEraser typeParameterUpperBoundEraser = this$0.typeParameterUpperBoundEraser;
        ClassifierDescriptor mo1171getDeclarationDescriptor = $constructor.mo1171getDeclarationDescriptor();
        return typeParameterUpperBoundEraser.getErasedUpperBound($parameter, $attr.withDefaultType(mo1171getDeclarationDescriptor != null ? mo1171getDeclarationDescriptor.getDefaultType() : null).markIsRaw($javaType.isRaw()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0021, code lost:
        if (r5.isEmpty() == false) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<TypeProjection> computeArguments(JavaClassifierType javaType, JavaTypeAttributes attr, TypeConstructor constructor) {
        boolean eraseTypeParameters;
        boolean isRaw = javaType.isRaw();
        if (!isRaw) {
            if (javaType.getTypeArguments().isEmpty()) {
                List<TypeParameterDescriptor> parameters = constructor.getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
            }
            eraseTypeParameters = false;
            List typeParameters = constructor.getParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "getParameters(...)");
            if (eraseTypeParameters) {
                if (typeParameters.size() != javaType.getTypeArguments().size()) {
                    List $this$map$iv = typeParameters;
                    int $i$f$map = 0;
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        TypeParameterDescriptor p = (TypeParameterDescriptor) item$iv$iv;
                        Iterable $this$map$iv2 = $this$map$iv;
                        ErrorTypeKind errorTypeKind = ErrorTypeKind.MISSED_TYPE_ARGUMENT_FOR_TYPE_PARAMETER;
                        int $i$f$map2 = $i$f$map;
                        String asString = p.getName().asString();
                        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
                        destination$iv$iv.add(new TypeProjectionImpl(ErrorUtils.createErrorType(errorTypeKind, asString)));
                        isRaw = isRaw;
                        $this$map$iv = $this$map$iv2;
                        eraseTypeParameters = eraseTypeParameters;
                        $i$f$map = $i$f$map2;
                    }
                    return CollectionsKt.toList((List) destination$iv$iv);
                }
                Iterable $this$map$iv3 = CollectionsKt.withIndex(javaType.getTypeArguments());
                boolean z = false;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                for (Object item$iv$iv2 : $this$map$iv3) {
                    IndexedValue indexedArgument = (IndexedValue) item$iv$iv2;
                    int i = indexedArgument.component1();
                    JavaType javaTypeArgument = (JavaType) indexedArgument.component2();
                    Iterable $this$map$iv4 = $this$map$iv3;
                    if (!(i < typeParameters.size())) {
                        throw new AssertionError("Argument index should be less then type parameters count, but " + i + " > " + typeParameters.size());
                    }
                    TypeParameterDescriptor parameter = typeParameters.get(i);
                    boolean z2 = z;
                    JavaTypeAttributes attributes$default = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null);
                    Intrinsics.checkNotNull(parameter);
                    destination$iv$iv2.add(transformToTypeProjection(javaTypeArgument, attributes$default, parameter));
                    $this$map$iv3 = $this$map$iv4;
                    z = z2;
                }
                return CollectionsKt.toList((List) destination$iv$iv2);
            }
            return computeRawTypeArguments(javaType, typeParameters, constructor, attr);
        }
        eraseTypeParameters = true;
        List typeParameters2 = constructor.getParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters2, "getParameters(...)");
        if (eraseTypeParameters) {
        }
    }

    private final TypeProjection transformToTypeProjection(JavaType javaType, JavaTypeAttributes attr, TypeParameterDescriptor typeParameter) {
        if (javaType instanceof JavaWildcardType) {
            JavaType bound = ((JavaWildcardType) javaType).getBound();
            Variance projectionKind = ((JavaWildcardType) javaType).isExtends() ? Variance.OUT_VARIANCE : Variance.IN_VARIANCE;
            if (bound == null || isConflictingArgumentFor(projectionKind, typeParameter)) {
                TypeProjection makeStarProjection = TypeUtils.makeStarProjection(typeParameter, attr);
                Intrinsics.checkNotNullExpressionValue(makeStarProjection, "makeStarProjection(...)");
                return makeStarProjection;
            }
            AnnotationDescriptor nullabilityAnnotationOnWildcard = UtilsKt.extractNullabilityAnnotationOnBoundedWildcard(this.c, (JavaWildcardType) javaType);
            KotlinType it = transformJavaType(bound, JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null));
            if (nullabilityAnnotationOnWildcard != null) {
                it = TypeUtilsKt.replaceAnnotations(it, Annotations.Companion.create(CollectionsKt.plus(it.getAnnotations(), nullabilityAnnotationOnWildcard)));
            }
            return TypeUtilsKt.createProjection(it, projectionKind, typeParameter);
        }
        return new TypeProjectionImpl(Variance.INVARIANT, transformJavaType(javaType, attr));
    }

    private final boolean isConflictingArgumentFor(Variance $this$isConflictingArgumentFor, TypeParameterDescriptor typeParameter) {
        return (typeParameter.getVariance() == Variance.INVARIANT || $this$isConflictingArgumentFor == typeParameter.getVariance()) ? false : true;
    }

    private final boolean isNullable(JavaTypeAttributes $this$isNullable) {
        return ($this$isNullable.getFlexibility() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || $this$isNullable.isForAnnotationParameter() || $this$isNullable.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) ? false : true;
    }
}