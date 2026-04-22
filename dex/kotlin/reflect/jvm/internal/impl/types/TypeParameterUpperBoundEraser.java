package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.types.checker.IntersectionTypeKt;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: TypeParameterUpperBoundEraser.kt */
public final class TypeParameterUpperBoundEraser {
    public static final Companion Companion = new Companion(null);
    private final Lazy erroneousErasedBound$delegate;
    private final MemoizedFunctionToNotNull<DataToEraseUpperBound, KotlinType> getErasedUpperBound;
    private final TypeParameterErasureOptions options;
    private final ErasureProjectionComputer projectionComputer;
    private final LockBasedStorageManager storage;

    public TypeParameterUpperBoundEraser(ErasureProjectionComputer projectionComputer, TypeParameterErasureOptions options) {
        Intrinsics.checkNotNullParameter(projectionComputer, "projectionComputer");
        Intrinsics.checkNotNullParameter(options, "options");
        this.projectionComputer = projectionComputer;
        this.options = options;
        this.storage = new LockBasedStorageManager("Type parameter upper bound erasure results");
        this.erroneousErasedBound$delegate = LazyKt.lazy(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser$$Lambda$0
            private final TypeParameterUpperBoundEraser arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                ErrorType erroneousErasedBound_delegate$lambda$0;
                erroneousErasedBound_delegate$lambda$0 = TypeParameterUpperBoundEraser.erroneousErasedBound_delegate$lambda$0(this.arg$0);
                return erroneousErasedBound_delegate$lambda$0;
            }
        });
        MemoizedFunctionToNotNull<DataToEraseUpperBound, KotlinType> createMemoizedFunction = this.storage.createMemoizedFunction(new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser$$Lambda$1
            private final TypeParameterUpperBoundEraser arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                KotlinType erasedUpperBound$lambda$0;
                erasedUpperBound$lambda$0 = TypeParameterUpperBoundEraser.getErasedUpperBound$lambda$0(this.arg$0, (TypeParameterUpperBoundEraser.DataToEraseUpperBound) obj);
                return erasedUpperBound$lambda$0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(createMemoizedFunction, "createMemoizedFunction(...)");
        this.getErasedUpperBound = createMemoizedFunction;
    }

    public /* synthetic */ TypeParameterUpperBoundEraser(ErasureProjectionComputer erasureProjectionComputer, TypeParameterErasureOptions typeParameterErasureOptions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(erasureProjectionComputer, (i & 2) != 0 ? new TypeParameterErasureOptions(false, false) : typeParameterErasureOptions);
    }

    private final ErrorType getErroneousErasedBound() {
        return (ErrorType) this.erroneousErasedBound$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ErrorType erroneousErasedBound_delegate$lambda$0(TypeParameterUpperBoundEraser this$0) {
        return ErrorUtils.createErrorType(ErrorTypeKind.CANNOT_COMPUTE_ERASED_BOUND, this$0.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TypeParameterUpperBoundEraser.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class DataToEraseUpperBound {
        private final ErasureTypeAttributes typeAttr;
        private final TypeParameterDescriptor typeParameter;

        public String toString() {
            return "DataToEraseUpperBound(typeParameter=" + this.typeParameter + ", typeAttr=" + this.typeAttr + ')';
        }

        public DataToEraseUpperBound(TypeParameterDescriptor typeParameter, ErasureTypeAttributes typeAttr) {
            Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
            Intrinsics.checkNotNullParameter(typeAttr, "typeAttr");
            this.typeParameter = typeParameter;
            this.typeAttr = typeAttr;
        }

        public final TypeParameterDescriptor getTypeParameter() {
            return this.typeParameter;
        }

        public final ErasureTypeAttributes getTypeAttr() {
            return this.typeAttr;
        }

        public boolean equals(Object other) {
            return (other instanceof DataToEraseUpperBound) && Intrinsics.areEqual(((DataToEraseUpperBound) other).typeParameter, this.typeParameter) && Intrinsics.areEqual(((DataToEraseUpperBound) other).typeAttr, this.typeAttr);
        }

        public int hashCode() {
            int result = this.typeParameter.hashCode();
            return result + (result * 31) + this.typeAttr.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KotlinType getErasedUpperBound$lambda$0(TypeParameterUpperBoundEraser this$0, DataToEraseUpperBound it) {
        return this$0.getErasedUpperBoundInternal(it.getTypeParameter(), it.getTypeAttr());
    }

    public final KotlinType getErasedUpperBound(TypeParameterDescriptor typeParameter, ErasureTypeAttributes typeAttr) {
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        Intrinsics.checkNotNullParameter(typeAttr, "typeAttr");
        KotlinType invoke = this.getErasedUpperBound.invoke(new DataToEraseUpperBound(typeParameter, typeAttr));
        Intrinsics.checkNotNullExpressionValue(invoke, "invoke(...)");
        return invoke;
    }

    private final KotlinType getDefaultType(ErasureTypeAttributes typeAttr) {
        KotlinType replaceArgumentsWithStarProjections;
        SimpleType defaultType = typeAttr.getDefaultType();
        return (defaultType == null || (replaceArgumentsWithStarProjections = TypeUtilsKt.replaceArgumentsWithStarProjections(defaultType)) == null) ? getErroneousErasedBound() : replaceArgumentsWithStarProjections;
    }

    private final KotlinType getErasedUpperBoundInternal(TypeParameterDescriptor typeParameter, ErasureTypeAttributes typeAttr) {
        TypeProjection computeProjection;
        Set visitedTypeParameters = typeAttr.getVisitedTypeParameters();
        if (visitedTypeParameters != null && visitedTypeParameters.contains(typeParameter.getOriginal())) {
            return getDefaultType(typeAttr);
        }
        SimpleType defaultType = typeParameter.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
        Iterable $this$associate$iv = TypeUtilsKt.extractTypeParametersFromUpperBounds(defaultType, visitedTypeParameters);
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associate$iv) {
            TypeParameterDescriptor it = (TypeParameterDescriptor) element$iv$iv;
            if (visitedTypeParameters == null || !visitedTypeParameters.contains(it)) {
                computeProjection = this.projectionComputer.computeProjection(it, typeAttr, this, getErasedUpperBound(it, typeAttr.withNewVisitedTypeParameter(typeParameter)));
            } else {
                computeProjection = TypeUtils.makeStarProjection(it, typeAttr);
                Intrinsics.checkNotNullExpressionValue(computeProjection, "makeStarProjection(...)");
            }
            TypeProjection boundProjection = computeProjection;
            Pair pair = TuplesKt.to(it.getTypeConstructor(), boundProjection);
            destination$iv$iv.put(pair.getFirst(), pair.getSecond());
        }
        TypeSubstitutor erasedTypeParametersSubstitutor = TypeSubstitutor.create(TypeConstructorSubstitution.Companion.createByConstructorsMap$default(TypeConstructorSubstitution.Companion, destination$iv$iv, false, 2, null));
        Intrinsics.checkNotNullExpressionValue(erasedTypeParametersSubstitutor, "create(...)");
        List<KotlinType> upperBounds = typeParameter.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
        Set erasedUpperBounds = substituteErasedUpperBounds(erasedTypeParametersSubstitutor, upperBounds, typeAttr);
        if (!erasedUpperBounds.isEmpty()) {
            if (!this.options.getIntersectUpperBounds()) {
                if (erasedUpperBounds.size() == 1) {
                    return (KotlinType) CollectionsKt.single(erasedUpperBounds);
                }
                throw new IllegalArgumentException("Should only be one computed upper bound if no need to intersect all bounds".toString());
            }
            Iterable $this$map$iv = CollectionsKt.toList(erasedUpperBounds);
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                destination$iv$iv2.add(((KotlinType) item$iv$iv).unwrap());
            }
            return IntersectionTypeKt.intersectTypes((List) destination$iv$iv2);
        }
        return getDefaultType(typeAttr);
    }

    private final Set<KotlinType> substituteErasedUpperBounds(TypeSubstitutor $this$substituteErasedUpperBounds, List<? extends KotlinType> list, ErasureTypeAttributes typeAttr) {
        Set $this$substituteErasedUpperBounds_u24lambda_u240 = SetsKt.createSetBuilder();
        for (KotlinType upperBound : list) {
            ClassifierDescriptor declaration = upperBound.getConstructor().mo1171getDeclarationDescriptor();
            if (declaration instanceof ClassDescriptor) {
                $this$substituteErasedUpperBounds_u24lambda_u240.add(Companion.replaceArgumentsOfUpperBound(upperBound, $this$substituteErasedUpperBounds, typeAttr.getVisitedTypeParameters(), this.options.getLeaveNonTypeParameterTypes()));
            } else if (declaration instanceof TypeParameterDescriptor) {
                Set<TypeParameterDescriptor> visitedTypeParameters = typeAttr.getVisitedTypeParameters();
                boolean z = false;
                if (visitedTypeParameters != null && visitedTypeParameters.contains(declaration)) {
                    z = true;
                }
                if (z) {
                    $this$substituteErasedUpperBounds_u24lambda_u240.add(getDefaultType(typeAttr));
                } else {
                    List<KotlinType> upperBounds = ((TypeParameterDescriptor) declaration).getUpperBounds();
                    Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
                    $this$substituteErasedUpperBounds_u24lambda_u240.addAll(substituteErasedUpperBounds($this$substituteErasedUpperBounds, upperBounds, typeAttr));
                }
            }
            if (!this.options.getIntersectUpperBounds()) {
                break;
            }
        }
        return SetsKt.build($this$substituteErasedUpperBounds_u24lambda_u240);
    }

    /* compiled from: TypeParameterUpperBoundEraser.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KotlinType replaceArgumentsOfUpperBound(KotlinType $this$replaceArgumentsOfUpperBound, TypeSubstitutor substitutor, Set<? extends TypeParameterDescriptor> set, boolean leaveNonTypeParameterTypes) {
            SimpleType simpleType;
            Iterable $this$map$iv$iv$iv;
            StarProjectionImpl starProjectionImpl;
            KotlinType type;
            Iterable $this$map$iv$iv$iv2;
            StarProjectionImpl starProjectionImpl2;
            KotlinType type2;
            KotlinType $this$replaceArgumentsByParametersWith$iv;
            StarProjectionImpl starProjectionImpl3;
            KotlinType type3;
            Set<? extends TypeParameterDescriptor> set2 = set;
            Intrinsics.checkNotNullParameter($this$replaceArgumentsOfUpperBound, "<this>");
            Intrinsics.checkNotNullParameter(substitutor, "substitutor");
            KotlinType $this$replaceArgumentsByParametersWith$iv2 = $this$replaceArgumentsOfUpperBound;
            boolean z = false;
            UnwrappedType unwrapped$iv = $this$replaceArgumentsByParametersWith$iv2.unwrap();
            if (unwrapped$iv instanceof FlexibleType) {
                SimpleType $this$replaceArgumentsByParametersWith$iv$iv = ((FlexibleType) unwrapped$iv).getLowerBound();
                if (!$this$replaceArgumentsByParametersWith$iv$iv.getConstructor().getParameters().isEmpty() && $this$replaceArgumentsByParametersWith$iv$iv.getConstructor().mo1171getDeclarationDescriptor() != null) {
                    Iterable parameters = $this$replaceArgumentsByParametersWith$iv$iv.getConstructor().getParameters();
                    Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
                    Iterable $this$map$iv$iv$iv3 = parameters;
                    Collection destination$iv$iv$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv$iv3, 10));
                    for (Object item$iv$iv$iv$iv : $this$map$iv$iv$iv3) {
                        TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) item$iv$iv$iv$iv;
                        TypeProjection argument = (TypeProjection) CollectionsKt.getOrNull($this$replaceArgumentsOfUpperBound.getArguments(), typeParameterDescriptor.getIndex());
                        if (leaveNonTypeParameterTypes) {
                            if ((argument == null || (type3 = argument.getType()) == null || TypeUtilsKt.containsTypeParameter(type3)) ? false : true) {
                                $this$replaceArgumentsByParametersWith$iv = $this$replaceArgumentsByParametersWith$iv2;
                                destination$iv$iv$iv$iv.add(argument);
                                $this$replaceArgumentsByParametersWith$iv2 = $this$replaceArgumentsByParametersWith$iv;
                            }
                        }
                        boolean isTypeParameterVisited = set2 != null && set2.contains(typeParameterDescriptor);
                        if (argument == null || isTypeParameterVisited) {
                            $this$replaceArgumentsByParametersWith$iv = $this$replaceArgumentsByParametersWith$iv2;
                        } else {
                            $this$replaceArgumentsByParametersWith$iv = $this$replaceArgumentsByParametersWith$iv2;
                            TypeSubstitution substitution = substitutor.getSubstitution();
                            KotlinType type4 = argument.getType();
                            Intrinsics.checkNotNullExpressionValue(type4, "getType(...)");
                            if (substitution.mo1176get(type4) != null) {
                                starProjectionImpl3 = argument;
                                argument = starProjectionImpl3;
                                destination$iv$iv$iv$iv.add(argument);
                                $this$replaceArgumentsByParametersWith$iv2 = $this$replaceArgumentsByParametersWith$iv;
                            }
                        }
                        starProjectionImpl3 = new StarProjectionImpl(typeParameterDescriptor);
                        argument = starProjectionImpl3;
                        destination$iv$iv$iv$iv.add(argument);
                        $this$replaceArgumentsByParametersWith$iv2 = $this$replaceArgumentsByParametersWith$iv;
                    }
                    List newArguments$iv$iv = (List) destination$iv$iv$iv$iv;
                    $this$replaceArgumentsByParametersWith$iv$iv = TypeSubstitutionKt.replace$default($this$replaceArgumentsByParametersWith$iv$iv, newArguments$iv$iv, null, 2, null);
                }
                SimpleType $this$replaceArgumentsByParametersWith$iv$iv2 = ((FlexibleType) unwrapped$iv).getUpperBound();
                boolean z2 = false;
                if (!$this$replaceArgumentsByParametersWith$iv$iv2.getConstructor().getParameters().isEmpty() && $this$replaceArgumentsByParametersWith$iv$iv2.getConstructor().mo1171getDeclarationDescriptor() != null) {
                    Iterable parameters2 = $this$replaceArgumentsByParametersWith$iv$iv2.getConstructor().getParameters();
                    Intrinsics.checkNotNullExpressionValue(parameters2, "getParameters(...)");
                    Iterable $this$map$iv$iv$iv4 = parameters2;
                    Collection destination$iv$iv$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv$iv4, 10));
                    for (Object item$iv$iv$iv$iv2 : $this$map$iv$iv$iv4) {
                        TypeParameterDescriptor typeParameterDescriptor2 = (TypeParameterDescriptor) item$iv$iv$iv$iv2;
                        boolean z3 = z2;
                        List<TypeProjection> arguments = $this$replaceArgumentsOfUpperBound.getArguments();
                        boolean z4 = z;
                        int $i$f$replaceArgumentsByParametersWith = typeParameterDescriptor2.getIndex();
                        TypeProjection argument2 = (TypeProjection) CollectionsKt.getOrNull(arguments, $i$f$replaceArgumentsByParametersWith);
                        if (leaveNonTypeParameterTypes) {
                            if ((argument2 == null || (type2 = argument2.getType()) == null || TypeUtilsKt.containsTypeParameter(type2)) ? false : true) {
                                $this$map$iv$iv$iv2 = $this$map$iv$iv$iv4;
                                destination$iv$iv$iv$iv2.add(argument2);
                                z2 = z3;
                                z = z4;
                                $this$map$iv$iv$iv4 = $this$map$iv$iv$iv2;
                            }
                        }
                        boolean isTypeParameterVisited2 = set2 != null && set2.contains(typeParameterDescriptor2);
                        if (argument2 == null || isTypeParameterVisited2) {
                            $this$map$iv$iv$iv2 = $this$map$iv$iv$iv4;
                        } else {
                            TypeSubstitution substitution2 = substitutor.getSubstitution();
                            $this$map$iv$iv$iv2 = $this$map$iv$iv$iv4;
                            KotlinType type5 = argument2.getType();
                            Intrinsics.checkNotNullExpressionValue(type5, "getType(...)");
                            if (substitution2.mo1176get(type5) != null) {
                                starProjectionImpl2 = argument2;
                                argument2 = starProjectionImpl2;
                                destination$iv$iv$iv$iv2.add(argument2);
                                z2 = z3;
                                z = z4;
                                $this$map$iv$iv$iv4 = $this$map$iv$iv$iv2;
                            }
                        }
                        starProjectionImpl2 = new StarProjectionImpl(typeParameterDescriptor2);
                        argument2 = starProjectionImpl2;
                        destination$iv$iv$iv$iv2.add(argument2);
                        z2 = z3;
                        z = z4;
                        $this$map$iv$iv$iv4 = $this$map$iv$iv$iv2;
                    }
                    List newArguments$iv$iv2 = (List) destination$iv$iv$iv$iv2;
                    $this$replaceArgumentsByParametersWith$iv$iv2 = TypeSubstitutionKt.replace$default($this$replaceArgumentsByParametersWith$iv$iv2, newArguments$iv$iv2, null, 2, null);
                }
                simpleType = KotlinTypeFactory.flexibleType($this$replaceArgumentsByParametersWith$iv$iv, $this$replaceArgumentsByParametersWith$iv$iv2);
            } else if (!(unwrapped$iv instanceof SimpleType)) {
                throw new NoWhenBranchMatchedException();
            } else {
                SimpleType $this$replaceArgumentsByParametersWith$iv$iv3 = (SimpleType) unwrapped$iv;
                boolean z5 = false;
                if (!$this$replaceArgumentsByParametersWith$iv$iv3.getConstructor().getParameters().isEmpty() && $this$replaceArgumentsByParametersWith$iv$iv3.getConstructor().mo1171getDeclarationDescriptor() != null) {
                    Iterable parameters3 = $this$replaceArgumentsByParametersWith$iv$iv3.getConstructor().getParameters();
                    Intrinsics.checkNotNullExpressionValue(parameters3, "getParameters(...)");
                    Iterable $this$map$iv$iv$iv5 = parameters3;
                    Collection destination$iv$iv$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv$iv5, 10));
                    for (Object item$iv$iv$iv$iv3 : $this$map$iv$iv$iv5) {
                        TypeParameterDescriptor typeParameterDescriptor3 = (TypeParameterDescriptor) item$iv$iv$iv$iv3;
                        List<TypeProjection> arguments2 = $this$replaceArgumentsOfUpperBound.getArguments();
                        boolean z6 = z5;
                        int $i$f$replaceArgumentsByParametersWith2 = typeParameterDescriptor3.getIndex();
                        TypeProjection argument3 = (TypeProjection) CollectionsKt.getOrNull(arguments2, $i$f$replaceArgumentsByParametersWith2);
                        if (leaveNonTypeParameterTypes) {
                            if ((argument3 == null || (type = argument3.getType()) == null || TypeUtilsKt.containsTypeParameter(type)) ? false : true) {
                                $this$map$iv$iv$iv = $this$map$iv$iv$iv5;
                                destination$iv$iv$iv$iv3.add(argument3);
                                set2 = set;
                                z5 = z6;
                                $this$map$iv$iv$iv5 = $this$map$iv$iv$iv;
                            }
                        }
                        boolean isTypeParameterVisited3 = set2 != null && set2.contains(typeParameterDescriptor3);
                        if (argument3 == null || isTypeParameterVisited3) {
                            $this$map$iv$iv$iv = $this$map$iv$iv$iv5;
                        } else {
                            TypeSubstitution substitution3 = substitutor.getSubstitution();
                            $this$map$iv$iv$iv = $this$map$iv$iv$iv5;
                            KotlinType type6 = argument3.getType();
                            Intrinsics.checkNotNullExpressionValue(type6, "getType(...)");
                            if (substitution3.mo1176get(type6) != null) {
                                starProjectionImpl = argument3;
                                argument3 = starProjectionImpl;
                                destination$iv$iv$iv$iv3.add(argument3);
                                set2 = set;
                                z5 = z6;
                                $this$map$iv$iv$iv5 = $this$map$iv$iv$iv;
                            }
                        }
                        starProjectionImpl = new StarProjectionImpl(typeParameterDescriptor3);
                        argument3 = starProjectionImpl;
                        destination$iv$iv$iv$iv3.add(argument3);
                        set2 = set;
                        z5 = z6;
                        $this$map$iv$iv$iv5 = $this$map$iv$iv$iv;
                    }
                    List newArguments$iv$iv3 = (List) destination$iv$iv$iv$iv3;
                    $this$replaceArgumentsByParametersWith$iv$iv3 = TypeSubstitutionKt.replace$default($this$replaceArgumentsByParametersWith$iv$iv3, newArguments$iv$iv3, null, 2, null);
                }
                simpleType = $this$replaceArgumentsByParametersWith$iv$iv3;
            }
            KotlinType replacedArguments = TypeWithEnhancementKt.inheritEnhancement(simpleType, unwrapped$iv);
            KotlinType safeSubstitute = substitutor.safeSubstitute(replacedArguments, Variance.OUT_VARIANCE);
            Intrinsics.checkNotNullExpressionValue(safeSubstitute, "safeSubstitute(...)");
            return safeSubstitute;
        }
    }
}