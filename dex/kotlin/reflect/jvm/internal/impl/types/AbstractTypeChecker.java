package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContextContextualKt;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* compiled from: AbstractTypeChecker.kt */
public final class AbstractTypeChecker {
    public static final AbstractTypeChecker INSTANCE = new AbstractTypeChecker();
    public static boolean RUN_SLOW_ASSERTIONS;

    /* compiled from: AbstractTypeChecker.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TypeVariance.values().length];
            try {
                iArr[TypeVariance.INV.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[TypeVariance.OUT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[TypeVariance.IN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[TypeCheckerState.LowerCapturedTypePolicy.values().length];
            try {
                iArr2[TypeCheckerState.LowerCapturedTypePolicy.CHECK_ONLY_LOWER.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr2[TypeCheckerState.LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr2[TypeCheckerState.LowerCapturedTypePolicy.SKIP_LOWER.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public final boolean isSubtypeOf(TypeCheckerState state, KotlinTypeMarker subType, KotlinTypeMarker superType) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(superType, "superType");
        return isSubtypeOf$default(this, state, subType, superType, false, 8, null);
    }

    private AbstractTypeChecker() {
    }

    public static /* synthetic */ boolean isSubtypeOf$default(AbstractTypeChecker abstractTypeChecker, TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return abstractTypeChecker.isSubtypeOf(typeCheckerState, kotlinTypeMarker, kotlinTypeMarker2, z);
    }

    public final boolean isSubtypeOf(TypeCheckerState state, KotlinTypeMarker subType, KotlinTypeMarker superType, boolean isFromNullabilityConstraint) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(superType, "superType");
        if (subType == superType) {
            return true;
        }
        if (state.customIsSubtypeOf(subType, superType)) {
            TypeSystemContext $this$isSubtypeOf_u24lambda_u240_u240 = state.getTypeSystemContext();
            return INSTANCE.completeIsSubTypeOf(state, $this$isSubtypeOf_u24lambda_u240_u240, subType, superType, isFromNullabilityConstraint);
        }
        return false;
    }

    public final boolean equalTypes(TypeCheckerState state, KotlinTypeMarker a, KotlinTypeMarker b) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        TypeSystemContext $this$equalTypes_u24lambda_u240 = state.getTypeSystemContext();
        if (a == b) {
            return true;
        }
        if (INSTANCE.isCommonDenotableType($this$equalTypes_u24lambda_u240, a) && INSTANCE.isCommonDenotableType($this$equalTypes_u24lambda_u240, b)) {
            KotlinTypeMarker refinedA = state.prepareType(state.refineType(a));
            KotlinTypeMarker refinedB = state.prepareType(state.refineType(b));
            RigidTypeMarker simpleA = $this$equalTypes_u24lambda_u240.lowerBoundIfFlexible(refinedA);
            if (!$this$equalTypes_u24lambda_u240.areEqualTypeConstructors($this$equalTypes_u24lambda_u240.typeConstructor(refinedA), $this$equalTypes_u24lambda_u240.typeConstructor(refinedB))) {
                return false;
            }
            if ($this$equalTypes_u24lambda_u240.argumentsCount(simpleA) == 0) {
                return $this$equalTypes_u24lambda_u240.hasFlexibleNullability(refinedA) || $this$equalTypes_u24lambda_u240.hasFlexibleNullability(refinedB) || $this$equalTypes_u24lambda_u240.isMarkedNullable(simpleA) == $this$equalTypes_u24lambda_u240.isMarkedNullable($this$equalTypes_u24lambda_u240.lowerBoundIfFlexible(refinedB));
            }
        }
        return isSubtypeOf$default(INSTANCE, state, a, b, false, 8, null) && isSubtypeOf$default(INSTANCE, state, b, a, false, 8, null);
    }

    private final boolean completeIsSubTypeOf(TypeCheckerState state, TypeSystemContext c, KotlinTypeMarker subType, KotlinTypeMarker superType, boolean isFromNullabilityConstraint) {
        KotlinTypeMarker preparedSubType = state.prepareType(state.refineType(subType));
        KotlinTypeMarker preparedSuperType = state.prepareType(state.refineType(superType));
        if (state.isDnnTypesEqualToFlexible() && TypeSystemContextContextualKt.isFlexible(c, preparedSubType) && TypeSystemContextContextualKt.isDefinitelyNotNullType(c, preparedSuperType)) {
            FlexibleTypeMarker asFlexibleType = TypeSystemContextContextualKt.asFlexibleType(c, preparedSubType);
            Intrinsics.checkNotNull(asFlexibleType);
            RigidTypeMarker lowerBound = TypeSystemContextContextualKt.lowerBound(c, asFlexibleType);
            RigidTypeMarker asRigidType = TypeSystemContextContextualKt.asRigidType(c, preparedSuperType);
            Intrinsics.checkNotNull(asRigidType);
            return completeIsSubTypeOf(state, c, lowerBound, TypeSystemContextContextualKt.originalIfDefinitelyNotNullable(c, asRigidType), isFromNullabilityConstraint);
        }
        Boolean checkSubtypeForSpecialCases = checkSubtypeForSpecialCases(state, c, TypeSystemContextContextualKt.lowerBoundIfFlexible(c, preparedSubType), TypeSystemContextContextualKt.upperBoundIfFlexible(c, preparedSuperType));
        if (checkSubtypeForSpecialCases != null) {
            boolean it = checkSubtypeForSpecialCases.booleanValue();
            state.addSubtypeConstraint(preparedSubType, preparedSuperType, isFromNullabilityConstraint);
            return it;
        }
        Boolean addSubtypeConstraint = state.addSubtypeConstraint(preparedSubType, preparedSuperType, isFromNullabilityConstraint);
        if (addSubtypeConstraint != null) {
            boolean it2 = addSubtypeConstraint.booleanValue();
            return it2;
        }
        return isSubtypeOfForSingleClassifierType(state, c, TypeSystemContextContextualKt.lowerBoundIfFlexible(c, preparedSubType), TypeSystemContextContextualKt.upperBoundIfFlexible(c, preparedSuperType));
    }

    private final Boolean checkSubtypeForIntegerLiteralType(TypeCheckerState state, TypeSystemContext c, RigidTypeMarker subType, RigidTypeMarker superType) {
        if (TypeSystemContextContextualKt.isIntegerLiteralType(c, subType) || TypeSystemContextContextualKt.isIntegerLiteralType(c, superType)) {
            if (checkSubtypeForIntegerLiteralType$isIntegerLiteralTypeOrCapturedOne(c, subType) && checkSubtypeForIntegerLiteralType$isIntegerLiteralTypeOrCapturedOne(c, superType)) {
                return true;
            }
            if (TypeSystemContextContextualKt.isIntegerLiteralType(c, subType)) {
                if (checkSubtypeForIntegerLiteralType$isTypeInIntegerLiteralType(c, state, subType, superType, false)) {
                    return true;
                }
            } else if (TypeSystemContextContextualKt.isIntegerLiteralType(c, superType) && (checkSubtypeForIntegerLiteralType$isIntegerLiteralTypeInIntersectionComponents(c, subType) || checkSubtypeForIntegerLiteralType$isTypeInIntegerLiteralType(c, state, superType, subType, true))) {
                return true;
            }
            return null;
        }
        return null;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$isTypeInIntegerLiteralType(TypeSystemContext $c, TypeCheckerState $state, RigidTypeMarker integerLiteralType, RigidTypeMarker type, boolean checkSupertypes) {
        boolean z;
        Iterable $this$any$iv = TypeSystemContextContextualKt.possibleIntegerTypes($c, integerLiteralType);
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            KotlinTypeMarker possibleType = (KotlinTypeMarker) element$iv;
            if (Intrinsics.areEqual(TypeSystemContextContextualKt.typeConstructor($c, possibleType), TypeSystemContextContextualKt.typeConstructor($c, type)) || (checkSupertypes && isSubtypeOf$default(INSTANCE, $state, type, possibleType, false, 8, null))) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$isIntegerLiteralTypeInIntersectionComponents(TypeSystemContext $c, RigidTypeMarker type) {
        Iterable $this$any$iv;
        KotlinTypeMarker it;
        TypeConstructorMarker typeConstructor = TypeSystemContextContextualKt.typeConstructor($c, type);
        if (typeConstructor instanceof IntersectionTypeConstructorMarker) {
            Iterable $this$any$iv2 = TypeSystemContextContextualKt.supertypes($c, typeConstructor);
            if (!($this$any$iv2 instanceof Collection) || !((Collection) $this$any$iv2).isEmpty()) {
                Iterator<T> it2 = $this$any$iv2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        Object element$iv = it2.next();
                        KotlinTypeMarker it3 = (KotlinTypeMarker) element$iv;
                        RigidTypeMarker asRigidType = TypeSystemContextContextualKt.asRigidType($c, it3);
                        if (asRigidType == null || !TypeSystemContextContextualKt.isIntegerLiteralType($c, asRigidType)) {
                            it = null;
                            continue;
                        } else {
                            it = 1;
                            continue;
                        }
                        if (it != null) {
                            $this$any$iv = 1;
                            break;
                        }
                    } else {
                        $this$any$iv = null;
                        break;
                    }
                }
            } else {
                $this$any$iv = null;
            }
            return $this$any$iv != null;
        }
        return false;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$isCapturedIntegerLiteralType(TypeSystemContext $c, RigidTypeMarker type) {
        RigidTypeMarker upperBoundIfFlexible;
        if (type instanceof CapturedTypeMarker) {
            TypeArgumentMarker projection = TypeSystemContextContextualKt.projection($c, TypeSystemContextContextualKt.typeConstructor($c, (CapturedTypeMarker) type));
            KotlinTypeMarker type2 = TypeSystemContextContextualKt.getType($c, projection);
            return (type2 == null || (upperBoundIfFlexible = TypeSystemContextContextualKt.upperBoundIfFlexible($c, type2)) == null || !TypeSystemContextContextualKt.isIntegerLiteralType($c, upperBoundIfFlexible)) ? false : true;
        }
        return false;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$isIntegerLiteralTypeOrCapturedOne(TypeSystemContext $c, RigidTypeMarker type) {
        return TypeSystemContextContextualKt.isIntegerLiteralType($c, type) || checkSubtypeForIntegerLiteralType$isCapturedIntegerLiteralType($c, type);
    }

    private final boolean hasNothingSupertype(TypeCheckerState state, TypeSystemContext c, RigidTypeMarker type) {
        TypeConstructorMarker typeConstructor = TypeSystemContextContextualKt.typeConstructor(c, type);
        if (TypeSystemContextContextualKt.isClassTypeConstructor(c, typeConstructor)) {
            return TypeSystemContextContextualKt.isNothingConstructor(c, typeConstructor);
        }
        if (TypeSystemContextContextualKt.isNothingConstructor(c, TypeSystemContextContextualKt.typeConstructor(c, type))) {
            return true;
        }
        state.initialize();
        ArrayDeque deque$iv = state.getSupertypesDeque();
        Intrinsics.checkNotNull(deque$iv);
        Set visitedSupertypes$iv = state.getSupertypesSet();
        Intrinsics.checkNotNull(visitedSupertypes$iv);
        deque$iv.push(type);
        while (!deque$iv.isEmpty()) {
            RigidTypeMarker current$iv = deque$iv.pop();
            Intrinsics.checkNotNull(current$iv);
            if (visitedSupertypes$iv.add(current$iv)) {
                TypeCheckerState.SupertypesPolicy.LowerIfFlexible lowerIfFlexible = TypeSystemContextContextualKt.isClassType(c, current$iv) ? TypeCheckerState.SupertypesPolicy.None.INSTANCE : TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                TypeCheckerState.SupertypesPolicy it$iv = lowerIfFlexible;
                if (Intrinsics.areEqual(it$iv, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) {
                    lowerIfFlexible = null;
                }
                if (lowerIfFlexible == null) {
                    continue;
                } else {
                    TypeCheckerState.SupertypesPolicy policy$iv = lowerIfFlexible;
                    TypeSystemContext $this$anySupertype_u24lambda_u241$iv = state.getTypeSystemContext();
                    Collection supertypes$iv = $this$anySupertype_u24lambda_u241$iv.supertypes($this$anySupertype_u24lambda_u241$iv.typeConstructor(current$iv));
                    for (KotlinTypeMarker supertype$iv : supertypes$iv) {
                        RigidTypeMarker newType$iv = policy$iv.mo1175transformType(state, supertype$iv);
                        if (TypeSystemContextContextualKt.isNothingConstructor(c, TypeSystemContextContextualKt.typeConstructor(c, newType$iv))) {
                            state.clear();
                            return true;
                        }
                        deque$iv.add(newType$iv);
                    }
                    continue;
                }
            }
        }
        state.clear();
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:201:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0186  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isSubtypeOfForSingleClassifierType(TypeCheckerState state, TypeSystemContext c, RigidTypeMarker subType, RigidTypeMarker superType) {
        ArrayList destination$iv;
        Collection supertypesWithSameConstructor;
        TypeConstructorMarker superConstructor;
        boolean anyNonOutParameter;
        KotlinTypeMarker type;
        boolean z = true;
        if (RUN_SLOW_ASSERTIONS) {
            if (!(TypeSystemContextContextualKt.isSingleClassifierType(c, subType) || TypeSystemContextContextualKt.isIntersection(c, TypeSystemContextContextualKt.typeConstructor(c, subType)) || state.isAllowedTypeVariable(subType))) {
                throw new AssertionError("Not singleClassifierType and not intersection subType: " + subType);
            }
            if (!(TypeSystemContextContextualKt.isSingleClassifierType(c, superType) || state.isAllowedTypeVariable(superType))) {
                throw new AssertionError("Not singleClassifierType superType: " + superType);
            }
        }
        if (AbstractNullabilityChecker.INSTANCE.isPossibleSubtype(state, subType, superType)) {
            Boolean checkSubtypeForIntegerLiteralType = checkSubtypeForIntegerLiteralType(state, c, subType, superType);
            if (checkSubtypeForIntegerLiteralType != null) {
                boolean it = checkSubtypeForIntegerLiteralType.booleanValue();
                TypeCheckerState.addSubtypeConstraint$default(state, subType, superType, false, 4, null);
                return it;
            }
            TypeConstructorMarker superConstructor2 = TypeSystemContextContextualKt.typeConstructor(c, superType);
            if ((c.areEqualTypeConstructors(TypeSystemContextContextualKt.typeConstructor(c, subType), superConstructor2) && TypeSystemContextContextualKt.parametersCount(c, superConstructor2) == 0) || TypeSystemContextContextualKt.isAnyConstructor(c, TypeSystemContextContextualKt.typeConstructor(c, superType))) {
                return true;
            }
            List $this$isSubtypeOfForSingleClassifierType_u24lambda_u243 = findCorrespondingSupertypes(state, subType, superConstructor2);
            int i = 10;
            if ($this$isSubtypeOfForSingleClassifierType_u24lambda_u243.size() > 1) {
                TypeSystemContext typeSystemContext = state.getTypeSystemContext();
                TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext = typeSystemContext instanceof TypeSystemInferenceExtensionContext ? (TypeSystemInferenceExtensionContext) typeSystemContext : null;
                if (typeSystemInferenceExtensionContext != null && typeSystemInferenceExtensionContext.isK2()) {
                    List $this$mapTo$iv = $this$isSubtypeOfForSingleClassifierType_u24lambda_u243;
                    destination$iv = new LinkedHashSet();
                    for (Object item$iv : $this$mapTo$iv) {
                        RigidTypeMarker it2 = (RigidTypeMarker) item$iv;
                        RigidTypeMarker asRigidType = TypeSystemContextContextualKt.asRigidType(c, state.prepareType(it2));
                        if (asRigidType == null) {
                            asRigidType = it2;
                        }
                        destination$iv.add(asRigidType);
                    }
                    supertypesWithSameConstructor = destination$iv;
                    switch (supertypesWithSameConstructor.size()) {
                        case 0:
                            return hasNothingSupertype(state, c, subType);
                        case 1:
                            return isSubtypeForSameConstructor(state, c, TypeSystemContextContextualKt.asArgumentList(c, (RigidTypeMarker) CollectionsKt.first(supertypesWithSameConstructor)), superType);
                        default:
                            ArgumentList newArguments = new ArgumentList(TypeSystemContextContextualKt.parametersCount(c, superConstructor2));
                            boolean anyNonOutParameter2 = false;
                            int index = 0;
                            int parametersCount = TypeSystemContextContextualKt.parametersCount(c, superConstructor2);
                            while (index < parametersCount) {
                                boolean anyNonOutParameter3 = (anyNonOutParameter2 || TypeSystemContextContextualKt.getVariance(c, TypeSystemContextContextualKt.getParameter(c, superConstructor2, index)) != TypeVariance.OUT) ? z : false;
                                if (anyNonOutParameter3) {
                                    superConstructor = superConstructor2;
                                    anyNonOutParameter = anyNonOutParameter3;
                                } else {
                                    Collection $this$map$iv = supertypesWithSameConstructor;
                                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, i));
                                    for (Object item$iv$iv : $this$map$iv) {
                                        RigidTypeMarker it3 = (RigidTypeMarker) item$iv$iv;
                                        TypeArgumentMarker it4 = TypeSystemContextContextualKt.getArgumentOrNull(c, it3, index);
                                        if (it4 != null) {
                                            TypeConstructorMarker superConstructor3 = superConstructor2;
                                            boolean anyNonOutParameter4 = anyNonOutParameter3;
                                            TypeArgumentMarker typeArgumentMarker = TypeSystemContextContextualKt.getVariance(c, it4) == TypeVariance.INV ? it4 : null;
                                            if (typeArgumentMarker != null && (type = TypeSystemContextContextualKt.getType(c, typeArgumentMarker)) != null) {
                                                destination$iv$iv.add(type);
                                                anyNonOutParameter3 = anyNonOutParameter4;
                                                superConstructor2 = superConstructor3;
                                            }
                                        }
                                        throw new IllegalStateException(("Incorrect type: " + it3 + ", subType: " + subType + ", superType: " + superType).toString());
                                        break;
                                    }
                                    superConstructor = superConstructor2;
                                    anyNonOutParameter = anyNonOutParameter3;
                                    List allProjections = (List) destination$iv$iv;
                                    TypeArgumentMarker intersection = TypeSystemContextContextualKt.asTypeArgument(c, c.intersectTypes(allProjections));
                                    newArguments.add(intersection);
                                }
                                index++;
                                anyNonOutParameter2 = anyNonOutParameter;
                                superConstructor2 = superConstructor;
                                z = true;
                                i = 10;
                            }
                            if (anyNonOutParameter2 || !isSubtypeForSameConstructor(state, c, newArguments, superType)) {
                                return state.runForkingPoint(new Function1(supertypesWithSameConstructor, state, c, superType) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker$$Lambda$0
                                    private final Collection arg$0;
                                    private final TypeCheckerState arg$1;
                                    private final TypeSystemContext arg$2;
                                    private final RigidTypeMarker arg$3;

                                    {
                                        this.arg$0 = supertypesWithSameConstructor;
                                        this.arg$1 = state;
                                        this.arg$2 = c;
                                        this.arg$3 = superType;
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public Object invoke(Object obj) {
                                        Unit isSubtypeOfForSingleClassifierType$lambda$5;
                                        isSubtypeOfForSingleClassifierType$lambda$5 = AbstractTypeChecker.isSubtypeOfForSingleClassifierType$lambda$5(this.arg$0, this.arg$1, this.arg$2, this.arg$3, (TypeCheckerState.ForkPointContext) obj);
                                        return isSubtypeOfForSingleClassifierType$lambda$5;
                                    }
                                });
                            }
                            return true;
                    }
                }
            }
            List $this$map$iv2 = $this$isSubtypeOfForSingleClassifierType_u24lambda_u243;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            for (Object item$iv$iv2 : $this$map$iv2) {
                RigidTypeMarker it5 = (RigidTypeMarker) item$iv$iv2;
                RigidTypeMarker asRigidType2 = TypeSystemContextContextualKt.asRigidType(c, state.prepareType(it5));
                if (asRigidType2 == null) {
                    asRigidType2 = it5;
                }
                destination$iv$iv2.add(asRigidType2);
            }
            destination$iv = (List) destination$iv$iv2;
            supertypesWithSameConstructor = destination$iv;
            switch (supertypesWithSameConstructor.size()) {
            }
        } else {
            return false;
        }
    }

    public static final Unit isSubtypeOfForSingleClassifierType$lambda$5(Collection $supertypesWithSameConstructor, TypeCheckerState $state, TypeSystemContext $c, RigidTypeMarker $superType, TypeCheckerState.ForkPointContext runForkingPoint) {
        Intrinsics.checkNotNullParameter(runForkingPoint, "$this$runForkingPoint");
        Iterator it = $supertypesWithSameConstructor.iterator();
        while (it.hasNext()) {
            RigidTypeMarker subTypeArguments = (RigidTypeMarker) it.next();
            runForkingPoint.fork(new Function0($state, $c, subTypeArguments, $superType) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker$$Lambda$1
                private final TypeCheckerState arg$0;
                private final TypeSystemContext arg$1;
                private final RigidTypeMarker arg$2;
                private final RigidTypeMarker arg$3;

                {
                    this.arg$0 = $state;
                    this.arg$1 = $c;
                    this.arg$2 = subTypeArguments;
                    this.arg$3 = $superType;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    boolean isSubtypeOfForSingleClassifierType$lambda$5$0;
                    isSubtypeOfForSingleClassifierType$lambda$5$0 = AbstractTypeChecker.isSubtypeOfForSingleClassifierType$lambda$5$0(this.arg$0, this.arg$1, this.arg$2, this.arg$3);
                    return Boolean.valueOf(isSubtypeOfForSingleClassifierType$lambda$5$0);
                }
            });
        }
        return Unit.INSTANCE;
    }

    public static final boolean isSubtypeOfForSingleClassifierType$lambda$5$0(TypeCheckerState $state, TypeSystemContext $c, RigidTypeMarker $subTypeArguments, RigidTypeMarker $superType) {
        return INSTANCE.isSubtypeForSameConstructor($state, $c, TypeSystemContextContextualKt.asArgumentList($c, $subTypeArguments), $superType);
    }

    private final boolean isTypeVariableAgainstStarProjectionForSelfType(TypeSystemContext context, KotlinTypeMarker subArgumentType, KotlinTypeMarker superArgumentType, TypeConstructorMarker selfConstructor) {
        TypeParameterMarker typeParameter;
        RigidTypeMarker simpleSubArgumentType = TypeSystemContextContextualKt.asRigidType(context, subArgumentType);
        if ((simpleSubArgumentType instanceof CapturedTypeMarker) && !TypeSystemContextContextualKt.isOldCapturedType(context, (CapturedTypeMarker) simpleSubArgumentType) && TypeSystemContextContextualKt.isStarProjection(context, TypeSystemContextContextualKt.projection(context, TypeSystemContextContextualKt.typeConstructor(context, (CapturedTypeMarker) simpleSubArgumentType))) && TypeSystemContextContextualKt.captureStatus(context, (CapturedTypeMarker) simpleSubArgumentType) == CaptureStatus.FOR_SUBTYPING) {
            TypeConstructorMarker typeConstructor = TypeSystemContextContextualKt.typeConstructor(context, superArgumentType);
            TypeVariableTypeConstructorMarker typeVariableConstructor = typeConstructor instanceof TypeVariableTypeConstructorMarker ? (TypeVariableTypeConstructorMarker) typeConstructor : null;
            return (typeVariableConstructor == null || (typeParameter = TypeSystemContextContextualKt.getTypeParameter(context, typeVariableConstructor)) == null || !TypeSystemContextContextualKt.hasRecursiveBounds(context, typeParameter, selfConstructor)) ? false : true;
        }
        return false;
    }

    public final boolean isSubtypeForSameConstructor(TypeCheckerState state, TypeSystemContext c, TypeArgumentListMarker capturedSubArguments, RigidTypeMarker superType) {
        boolean z;
        int i;
        int i2;
        TypeCheckerState this_$iv;
        int index;
        boolean equalTypes;
        int i3;
        AbstractTypeChecker abstractTypeChecker = this;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(capturedSubArguments, "capturedSubArguments");
        Intrinsics.checkNotNullParameter(superType, "superType");
        TypeConstructorMarker superTypeConstructor = TypeSystemContextContextualKt.typeConstructor(c, superType);
        int argumentsCount = TypeSystemContextContextualKt.size(c, capturedSubArguments);
        int parametersCount = TypeSystemContextContextualKt.parametersCount(c, superTypeConstructor);
        if (argumentsCount != parametersCount || argumentsCount != TypeSystemContextContextualKt.argumentsCount(c, superType)) {
            return false;
        }
        int index2 = 0;
        while (index2 < parametersCount) {
            TypeArgumentMarker superProjection = TypeSystemContextContextualKt.getArgument(c, superType, index2);
            KotlinTypeMarker superArgumentType = TypeSystemContextContextualKt.getType(c, superProjection);
            if (superArgumentType == null) {
                index = index2;
            } else {
                TypeArgumentMarker it = TypeSystemContextContextualKt.get(c, capturedSubArguments, index2);
                if (!(TypeSystemContextContextualKt.getVariance(c, it) == TypeVariance.INV)) {
                    throw new AssertionError("Incorrect sub argument: " + it);
                }
                KotlinTypeMarker subArgumentType = TypeSystemContextContextualKt.getType(c, it);
                Intrinsics.checkNotNull(subArgumentType);
                TypeVariance variance = abstractTypeChecker.effectiveVariance(TypeSystemContextContextualKt.getVariance(c, TypeSystemContextContextualKt.getParameter(c, superTypeConstructor, index2)), TypeSystemContextContextualKt.getVariance(c, superProjection));
                if (variance != null) {
                    if (variance == TypeVariance.INV) {
                        z = abstractTypeChecker.isTypeVariableAgainstStarProjectionForSelfType(c, subArgumentType, superArgumentType, superTypeConstructor) || abstractTypeChecker.isTypeVariableAgainstStarProjectionForSelfType(c, superArgumentType, subArgumentType, superTypeConstructor);
                    } else {
                        z = false;
                    }
                    boolean isTypeVariableAgainstStarProjectionForSelfType = z;
                    if (!isTypeVariableAgainstStarProjectionForSelfType) {
                        i = state.argumentsDepth;
                        if (i <= 100) {
                            i2 = state.argumentsDepth;
                            state.argumentsDepth = i2 + 1;
                            switch (WhenMappings.$EnumSwitchMapping$0[variance.ordinal()]) {
                                case 1:
                                    this_$iv = state;
                                    index = index2;
                                    equalTypes = INSTANCE.equalTypes(state, subArgumentType, superArgumentType);
                                    break;
                                case 2:
                                    this_$iv = state;
                                    index = index2;
                                    equalTypes = isSubtypeOf$default(INSTANCE, state, subArgumentType, superArgumentType, false, 8, null);
                                    break;
                                case 3:
                                    this_$iv = state;
                                    index = index2;
                                    equalTypes = isSubtypeOf$default(INSTANCE, state, superArgumentType, subArgumentType, false, 8, null);
                                    break;
                                default:
                                    throw new NoWhenBranchMatchedException();
                            }
                            boolean correctArgument = equalTypes;
                            i3 = this_$iv.argumentsDepth;
                            this_$iv.argumentsDepth = i3 - 1;
                            if (!correctArgument) {
                                return false;
                            }
                        } else {
                            throw new IllegalStateException(("Arguments depth is too high. Some related argument: " + subArgumentType).toString());
                        }
                    } else {
                        index = index2;
                    }
                } else {
                    return state.isErrorTypeEqualsToAnything();
                }
            }
            index2 = index + 1;
            abstractTypeChecker = this;
        }
        return true;
    }

    private final boolean isCommonDenotableType(TypeSystemContext context, KotlinTypeMarker $this$isCommonDenotableType) {
        return (!TypeSystemContextContextualKt.isDenotable(context, TypeSystemContextContextualKt.typeConstructor(context, $this$isCommonDenotableType)) || TypeSystemContextContextualKt.isDynamic(context, $this$isCommonDenotableType) || TypeSystemContextContextualKt.isDefinitelyNotNullType(context, $this$isCommonDenotableType) || TypeSystemContextContextualKt.isNotNullTypeParameter(context, $this$isCommonDenotableType) || TypeSystemContextContextualKt.isFlexibleWithDifferentTypeConstructors(context, $this$isCommonDenotableType)) ? false : true;
    }

    public final TypeVariance effectiveVariance(TypeVariance declared, TypeVariance useSite) {
        Intrinsics.checkNotNullParameter(declared, "declared");
        Intrinsics.checkNotNullParameter(useSite, "useSite");
        if (declared == TypeVariance.INV) {
            return useSite;
        }
        if (useSite == TypeVariance.INV || declared == useSite) {
            return declared;
        }
        return null;
    }

    private final boolean isStubTypeSubtypeOfAnother(TypeSystemContext context, RigidTypeMarker a, RigidTypeMarker b) {
        if (TypeSystemContextContextualKt.typeConstructor(context, a) != TypeSystemContextContextualKt.typeConstructor(context, b)) {
            return false;
        }
        if (TypeSystemContextContextualKt.isDefinitelyNotNullType(context, a) || !TypeSystemContextContextualKt.isDefinitelyNotNullType(context, b)) {
            return !TypeSystemContextContextualKt.isMarkedNullable(context, a) || TypeSystemContextContextualKt.isMarkedNullable(context, b);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:192:0x0178, code lost:
        if (r7 != false) goto L75;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Boolean checkSubtypeForSpecialCases(TypeCheckerState state, TypeSystemContext c, RigidTypeMarker subType, RigidTypeMarker superType) {
        KotlinTypeMarker nullableLowerType;
        boolean z = false;
        if (TypeSystemContextContextualKt.isError(c, subType) || TypeSystemContextContextualKt.isError(c, superType)) {
            if (state.isErrorTypeEqualsToAnything()) {
                return true;
            }
            if (!TypeSystemContextContextualKt.isMarkedNullable(c, subType) || TypeSystemContextContextualKt.isMarkedNullable(c, superType)) {
                return Boolean.valueOf(AbstractStrictEqualityTypeChecker.INSTANCE.strictEqualTypes(c, TypeSystemContextContextualKt.withNullability(c, subType, false), TypeSystemContextContextualKt.withNullability(c, superType, false)));
            }
            return false;
        } else if (TypeSystemContextContextualKt.isStubTypeForBuilderInference(c, subType) && TypeSystemContextContextualKt.isStubTypeForBuilderInference(c, superType)) {
            if (isStubTypeSubtypeOfAnother(c, subType, superType) || state.isStubTypeEqualsToAnything()) {
                z = true;
            }
            return Boolean.valueOf(z);
        } else if (TypeSystemContextContextualKt.isStubType(c, subType) || TypeSystemContextContextualKt.isStubType(c, superType)) {
            return Boolean.valueOf(state.isStubTypeEqualsToAnything());
        } else {
            CapturedTypeMarker superTypeCaptured = TypeSystemContextContextualKt.asCapturedTypeUnwrappingDnn(c, superType);
            KotlinTypeMarker lowerType = superTypeCaptured != null ? TypeSystemContextContextualKt.lowerType(c, superTypeCaptured) : null;
            if (superTypeCaptured != null && lowerType != null) {
                if (TypeSystemContextContextualKt.isMarkedNullable(c, superType)) {
                    nullableLowerType = TypeSystemContextContextualKt.withNullability(c, lowerType, true);
                } else {
                    nullableLowerType = TypeSystemContextContextualKt.isDefinitelyNotNullType(c, superType) ? TypeSystemContextContextualKt.makeDefinitelyNotNullOrNotNull(c, lowerType) : lowerType;
                }
                switch (WhenMappings.$EnumSwitchMapping$1[state.getLowerCapturedTypePolicy(subType, superTypeCaptured).ordinal()]) {
                    case 1:
                        return Boolean.valueOf(isSubtypeOf$default(this, state, subType, nullableLowerType, false, 8, null));
                    case 2:
                        if (isSubtypeOf$default(this, state, subType, nullableLowerType, false, 8, null)) {
                            return true;
                        }
                        break;
                    case 3:
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
            TypeConstructorMarker superTypeConstructor = TypeSystemContextContextualKt.typeConstructor(c, superType);
            if (TypeSystemContextContextualKt.isIntersection(c, superTypeConstructor)) {
                if (TypeSystemContextContextualKt.isMarkedNullable(c, superType)) {
                    throw new AssertionError("Intersection type should not be marked nullable!: " + superType);
                }
                Iterable $this$all$iv = TypeSystemContextContextualKt.supertypes(c, superTypeConstructor);
                if (($this$all$iv instanceof Collection) && ((Collection) $this$all$iv).isEmpty()) {
                    z = true;
                } else {
                    Iterator<T> it = $this$all$iv.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Object element$iv = it.next();
                            KotlinTypeMarker it2 = (KotlinTypeMarker) element$iv;
                            if (!isSubtypeOf$default(INSTANCE, state, subType, it2, false, 8, null)) {
                            }
                        } else {
                            z = true;
                        }
                    }
                }
                return Boolean.valueOf(z);
            }
            TypeConstructorMarker subTypeConstructor = TypeSystemContextContextualKt.typeConstructor(c, subType);
            if (!(subType instanceof CapturedTypeMarker)) {
                if (TypeSystemContextContextualKt.isIntersection(c, subTypeConstructor)) {
                    Iterable $this$all$iv2 = TypeSystemContextContextualKt.supertypes(c, subTypeConstructor);
                    if (($this$all$iv2 instanceof Collection) && ((Collection) $this$all$iv2).isEmpty()) {
                        z = true;
                    } else {
                        Iterator<T> it3 = $this$all$iv2.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                Object element$iv2 = it3.next();
                                KotlinTypeMarker it4 = (KotlinTypeMarker) element$iv2;
                                if (!(it4 instanceof CapturedTypeMarker)) {
                                }
                            } else {
                                z = true;
                            }
                        }
                    }
                }
                return null;
            }
            TypeParameterMarker typeParameter = getTypeParameterForArgumentInBaseIfItEqualToTarget(c, superType, subType);
            if (typeParameter != null && TypeSystemContextContextualKt.hasRecursiveBounds(c, typeParameter, TypeSystemContextContextualKt.typeConstructor(c, superType))) {
                return true;
            }
            return null;
        }
    }

    private final TypeParameterMarker getTypeParameterForArgumentInBaseIfItEqualToTarget(TypeSystemContext context, KotlinTypeMarker baseType, KotlinTypeMarker targetType) {
        KotlinTypeMarker typeArgument;
        int i = 0;
        int argumentsCount = TypeSystemContextContextualKt.argumentsCount(context, baseType);
        while (true) {
            if (i >= argumentsCount) {
                return null;
            }
            TypeArgumentMarker it = TypeSystemContextContextualKt.getArgument(context, baseType, i);
            TypeArgumentMarker typeArgumentMarker = TypeSystemContextContextualKt.isStarProjection(context, it) ? null : it;
            if (typeArgumentMarker != null && (typeArgument = TypeSystemContextContextualKt.getType(context, typeArgumentMarker)) != null) {
                boolean areBothTypesCaptured = TypeSystemContextContextualKt.isCapturedType(context, TypeSystemContextContextualKt.lowerBoundIfFlexible(context, typeArgument)) && TypeSystemContextContextualKt.isCapturedType(context, TypeSystemContextContextualKt.lowerBoundIfFlexible(context, targetType));
                if (Intrinsics.areEqual(typeArgument, targetType) || (areBothTypesCaptured && Intrinsics.areEqual(TypeSystemContextContextualKt.typeConstructor(context, typeArgument), TypeSystemContextContextualKt.typeConstructor(context, targetType)))) {
                    break;
                }
                TypeParameterMarker it2 = getTypeParameterForArgumentInBaseIfItEqualToTarget(context, typeArgument, targetType);
                if (it2 != null) {
                    return it2;
                }
            }
            i++;
        }
        return TypeSystemContextContextualKt.getParameter(context, TypeSystemContextContextualKt.typeConstructor(context, baseType), i);
    }

    private final List<RigidTypeMarker> collectAllSupertypesWithGivenTypeConstructor(TypeCheckerState state, TypeSystemContext c, RigidTypeMarker subType, TypeConstructorMarker superConstructor) {
        TypeCheckerState.SupertypesPolicy.LowerIfFlexible substitutionSupertypePolicy;
        List it = TypeSystemContextContextualKt.fastCorrespondingSupertypes(c, subType, superConstructor);
        if (it != null) {
            return it;
        }
        if (TypeSystemContextContextualKt.isClassTypeConstructor(c, superConstructor) || !TypeSystemContextContextualKt.isClassType(c, subType)) {
            if (TypeSystemContextContextualKt.isCommonFinalClassConstructor(c, superConstructor)) {
                if (c.areEqualTypeConstructors(TypeSystemContextContextualKt.typeConstructor(c, subType), superConstructor)) {
                    RigidTypeMarker captureFromArguments = c.captureFromArguments(subType, CaptureStatus.FOR_SUBTYPING);
                    if (captureFromArguments == null) {
                        captureFromArguments = subType;
                    }
                    return CollectionsKt.listOf(captureFromArguments);
                }
                return CollectionsKt.emptyList();
            }
            List result = new SmartList();
            state.initialize();
            ArrayDeque deque$iv = state.getSupertypesDeque();
            Intrinsics.checkNotNull(deque$iv);
            Set visitedSupertypes$iv = state.getSupertypesSet();
            Intrinsics.checkNotNull(visitedSupertypes$iv);
            deque$iv.push(subType);
            while (!deque$iv.isEmpty()) {
                RigidTypeMarker current$iv = deque$iv.pop();
                Intrinsics.checkNotNull(current$iv);
                if (visitedSupertypes$iv.add(current$iv)) {
                    RigidTypeMarker current = c.captureFromArguments(current$iv, CaptureStatus.FOR_SUBTYPING);
                    if (current == null) {
                        current = current$iv;
                    }
                    if (!c.areEqualTypeConstructors(TypeSystemContextContextualKt.typeConstructor(c, current), superConstructor)) {
                        if (TypeSystemContextContextualKt.argumentsCount(c, current) == 0) {
                            substitutionSupertypePolicy = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                        } else {
                            substitutionSupertypePolicy = state.getTypeSystemContext().substitutionSupertypePolicy(current);
                        }
                    } else {
                        result.add(current);
                        substitutionSupertypePolicy = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
                    }
                    TypeCheckerState.SupertypesPolicy it$iv = substitutionSupertypePolicy;
                    if (Intrinsics.areEqual(it$iv, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) {
                        substitutionSupertypePolicy = null;
                    }
                    if (substitutionSupertypePolicy != null) {
                        TypeCheckerState.SupertypesPolicy policy$iv = substitutionSupertypePolicy;
                        TypeSystemContext $this$anySupertype_u24lambda_u241$iv = state.getTypeSystemContext();
                        Collection supertypes$iv = $this$anySupertype_u24lambda_u241$iv.supertypes($this$anySupertype_u24lambda_u241$iv.typeConstructor(current$iv));
                        for (KotlinTypeMarker supertype$iv : supertypes$iv) {
                            RigidTypeMarker newType$iv = policy$iv.mo1175transformType(state, supertype$iv);
                            deque$iv.add(newType$iv);
                        }
                    }
                }
            }
            state.clear();
            return result;
        }
        return CollectionsKt.emptyList();
    }

    private final List<RigidTypeMarker> collectAndFilter(TypeCheckerState state, TypeSystemContext c, RigidTypeMarker classType, TypeConstructorMarker constructor) {
        return selectOnlyPureKotlinSupertypes(c, collectAllSupertypesWithGivenTypeConstructor(state, c, classType, constructor));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<RigidTypeMarker> selectOnlyPureKotlinSupertypes(TypeSystemContext c, List<? extends RigidTypeMarker> list) {
        boolean z;
        Iterable $this$filterTo$iv$iv;
        if (list.size() < 2) {
            return list;
        }
        List<? extends RigidTypeMarker> $this$filter$iv = list;
        boolean z2 = false;
        Collection destination$iv$iv = new ArrayList();
        Iterable $this$filterTo$iv$iv2 = $this$filter$iv;
        for (Object element$iv$iv : $this$filterTo$iv$iv2) {
            RigidTypeMarker it = (RigidTypeMarker) element$iv$iv;
            TypeArgumentListMarker $this$all$iv = TypeSystemContextContextualKt.asArgumentList(c, it);
            int size = c.size($this$all$iv);
            boolean z3 = false;
            Iterable $this$filter$iv2 = $this$filter$iv;
            int i = 0;
            while (true) {
                if (i < size) {
                    int index$iv = i;
                    z = z2;
                    $this$filterTo$iv$iv = $this$filterTo$iv$iv2;
                    TypeArgumentMarker it2 = c.get($this$all$iv, index$iv);
                    KotlinTypeMarker type = TypeSystemContextContextualKt.getType(c, it2);
                    if (!((type != null ? TypeSystemContextContextualKt.asFlexibleType(c, type) : null) == null)) {
                        break;
                    }
                    i++;
                    $this$filterTo$iv$iv2 = $this$filterTo$iv$iv;
                    z2 = z;
                } else {
                    z = z2;
                    $this$filterTo$iv$iv = $this$filterTo$iv$iv2;
                    z3 = true;
                    break;
                }
            }
            if (z3) {
                destination$iv$iv.add(element$iv$iv);
            }
            $this$filter$iv = $this$filter$iv2;
            $this$filterTo$iv$iv2 = $this$filterTo$iv$iv;
            z2 = z;
        }
        List allPureSupertypes = (List) destination$iv$iv;
        return !allPureSupertypes.isEmpty() ? allPureSupertypes : list;
    }

    public final List<RigidTypeMarker> findCorrespondingSupertypes(TypeCheckerState state, RigidTypeMarker subType, TypeConstructorMarker superConstructor) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(superConstructor, "superConstructor");
        TypeSystemContext $this$findCorrespondingSupertypes_u24lambda_u240_u240 = state.getTypeSystemContext();
        return INSTANCE.findCorrespondingSupertypes(state, $this$findCorrespondingSupertypes_u24lambda_u240_u240, subType, superConstructor);
    }

    public final List<RigidTypeMarker> findCorrespondingSupertypes(TypeCheckerState state, TypeSystemContext c, RigidTypeMarker subType, TypeConstructorMarker superConstructor) {
        TypeCheckerState.SupertypesPolicy.LowerIfFlexible lowerIfFlexible;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(superConstructor, "superConstructor");
        if (TypeSystemContextContextualKt.isClassType(c, subType)) {
            return collectAndFilter(state, c, subType, superConstructor);
        }
        if (!TypeSystemContextContextualKt.isClassTypeConstructor(c, superConstructor) && !TypeSystemContextContextualKt.isIntegerLiteralTypeConstructor(c, superConstructor)) {
            return collectAllSupertypesWithGivenTypeConstructor(state, c, subType, superConstructor);
        }
        SmartList classTypeSupertypes = new SmartList();
        state.initialize();
        ArrayDeque deque$iv = state.getSupertypesDeque();
        Intrinsics.checkNotNull(deque$iv);
        Set visitedSupertypes$iv = state.getSupertypesSet();
        Intrinsics.checkNotNull(visitedSupertypes$iv);
        deque$iv.push(subType);
        while (!deque$iv.isEmpty()) {
            RigidTypeMarker current$iv = deque$iv.pop();
            Intrinsics.checkNotNull(current$iv);
            if (visitedSupertypes$iv.add(current$iv)) {
                if (TypeSystemContextContextualKt.isClassType(c, current$iv)) {
                    classTypeSupertypes.add(current$iv);
                    lowerIfFlexible = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
                } else {
                    lowerIfFlexible = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                }
                TypeCheckerState.SupertypesPolicy it$iv = lowerIfFlexible;
                if (Intrinsics.areEqual(it$iv, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) {
                    lowerIfFlexible = null;
                }
                if (lowerIfFlexible != null) {
                    TypeCheckerState.SupertypesPolicy policy$iv = lowerIfFlexible;
                    TypeSystemContext $this$anySupertype_u24lambda_u241$iv = state.getTypeSystemContext();
                    Collection supertypes$iv = $this$anySupertype_u24lambda_u241$iv.supertypes($this$anySupertype_u24lambda_u241$iv.typeConstructor(current$iv));
                    for (KotlinTypeMarker supertype$iv : supertypes$iv) {
                        RigidTypeMarker newType$iv = policy$iv.mo1175transformType(state, supertype$iv);
                        deque$iv.add(newType$iv);
                    }
                }
            }
        }
        state.clear();
        SmartList $this$flatMap$iv = classTypeSupertypes;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            RigidTypeMarker it = (RigidTypeMarker) element$iv$iv;
            AbstractTypeChecker abstractTypeChecker = INSTANCE;
            Intrinsics.checkNotNull(it);
            Iterable list$iv$iv = abstractTypeChecker.collectAndFilter(state, c, it, superConstructor);
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        return (List) destination$iv$iv;
    }
}