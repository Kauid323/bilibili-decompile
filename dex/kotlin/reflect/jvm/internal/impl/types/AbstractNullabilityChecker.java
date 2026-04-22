package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

/* compiled from: AbstractTypeChecker.kt */
public final class AbstractNullabilityChecker {
    public static final AbstractNullabilityChecker INSTANCE = new AbstractNullabilityChecker();

    private AbstractNullabilityChecker() {
    }

    public final boolean isPossibleSubtype(TypeCheckerState state, RigidTypeMarker subType, RigidTypeMarker superType) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(superType, "superType");
        return runIsPossibleSubtype(state, subType, superType);
    }

    private final boolean runIsPossibleSubtype(TypeCheckerState state, RigidTypeMarker subType, RigidTypeMarker superType) {
        TypeSystemContext $this$runIsPossibleSubtype_u24lambda_u240 = state.getTypeSystemContext();
        if (AbstractTypeChecker.RUN_SLOW_ASSERTIONS) {
            if (!($this$runIsPossibleSubtype_u24lambda_u240.isSingleClassifierType(subType) || $this$runIsPossibleSubtype_u24lambda_u240.isIntersection($this$runIsPossibleSubtype_u24lambda_u240.typeConstructor(subType)) || state.isAllowedTypeVariable(subType))) {
                throw new AssertionError("Not singleClassifierType and not intersection subType: " + subType);
            }
            if (!($this$runIsPossibleSubtype_u24lambda_u240.isSingleClassifierType(superType) || state.isAllowedTypeVariable(superType))) {
                throw new AssertionError("Not singleClassifierType superType: " + superType);
            }
        }
        if ($this$runIsPossibleSubtype_u24lambda_u240.isMarkedNullable(superType) || $this$runIsPossibleSubtype_u24lambda_u240.isNotNullTypeParameter(subType) || $this$runIsPossibleSubtype_u24lambda_u240.isDefinitelyNotNullType(subType)) {
            return true;
        }
        if (((subType instanceof CapturedTypeMarker) && $this$runIsPossibleSubtype_u24lambda_u240.isProjectionNotNull((CapturedTypeMarker) subType)) || INSTANCE.hasNotNullSupertype(state, subType, TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE)) {
            return true;
        }
        if ($this$runIsPossibleSubtype_u24lambda_u240.isDefinitelyNotNullType(superType) || INSTANCE.hasNotNullSupertype(state, superType, TypeCheckerState.SupertypesPolicy.UpperIfFlexible.INSTANCE) || $this$runIsPossibleSubtype_u24lambda_u240.isClassType(subType)) {
            return false;
        }
        return INSTANCE.hasPathByNotMarkedNullableNodes(state, subType, $this$runIsPossibleSubtype_u24lambda_u240.typeConstructor(superType));
    }

    public final boolean hasNotNullSupertype(TypeCheckerState $this$hasNotNullSupertype, RigidTypeMarker type, TypeCheckerState.SupertypesPolicy supertypesPolicy) {
        Intrinsics.checkNotNullParameter($this$hasNotNullSupertype, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(supertypesPolicy, "supertypesPolicy");
        TypeSystemContext $this$hasNotNullSupertype_u24lambda_u240 = $this$hasNotNullSupertype.getTypeSystemContext();
        if (($this$hasNotNullSupertype_u24lambda_u240.isClassType(type) && !$this$hasNotNullSupertype_u24lambda_u240.isMarkedNullable(type)) || $this$hasNotNullSupertype_u24lambda_u240.isDefinitelyNotNullType(type)) {
            return true;
        }
        $this$hasNotNullSupertype.initialize();
        ArrayDeque deque$iv = $this$hasNotNullSupertype.getSupertypesDeque();
        Intrinsics.checkNotNull(deque$iv);
        Set visitedSupertypes$iv = $this$hasNotNullSupertype.getSupertypesSet();
        Intrinsics.checkNotNull(visitedSupertypes$iv);
        deque$iv.push(type);
        while (!deque$iv.isEmpty()) {
            RigidTypeMarker current$iv = deque$iv.pop();
            Intrinsics.checkNotNull(current$iv);
            if (visitedSupertypes$iv.add(current$iv)) {
                TypeCheckerState.SupertypesPolicy.None none = $this$hasNotNullSupertype_u24lambda_u240.isMarkedNullable(current$iv) ? TypeCheckerState.SupertypesPolicy.None.INSTANCE : supertypesPolicy;
                TypeCheckerState.SupertypesPolicy it$iv = none;
                if (Intrinsics.areEqual(it$iv, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) {
                    none = null;
                }
                if (none == null) {
                    continue;
                } else {
                    TypeCheckerState.SupertypesPolicy policy$iv = none;
                    TypeSystemContext $this$anySupertype_u24lambda_u241$iv = $this$hasNotNullSupertype.getTypeSystemContext();
                    Collection supertypes$iv = $this$anySupertype_u24lambda_u241$iv.supertypes($this$anySupertype_u24lambda_u241$iv.typeConstructor(current$iv));
                    for (KotlinTypeMarker supertype$iv : supertypes$iv) {
                        RigidTypeMarker newType$iv = policy$iv.mo1175transformType($this$hasNotNullSupertype, supertype$iv);
                        if (($this$hasNotNullSupertype_u24lambda_u240.isClassType(newType$iv) && !$this$hasNotNullSupertype_u24lambda_u240.isMarkedNullable(newType$iv)) || $this$hasNotNullSupertype_u24lambda_u240.isDefinitelyNotNullType(newType$iv)) {
                            $this$hasNotNullSupertype.clear();
                            return true;
                        }
                        deque$iv.add(newType$iv);
                    }
                }
            }
        }
        $this$hasNotNullSupertype.clear();
        return false;
    }

    public final boolean hasPathByNotMarkedNullableNodes(TypeCheckerState state, RigidTypeMarker start, TypeConstructorMarker end) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        TypeSystemContext $this$hasPathByNotMarkedNullableNodes_u24lambda_u240 = state.getTypeSystemContext();
        if (INSTANCE.isApplicableAsEndNode(state, start, end)) {
            return true;
        }
        state.initialize();
        ArrayDeque deque$iv = state.getSupertypesDeque();
        Intrinsics.checkNotNull(deque$iv);
        Set visitedSupertypes$iv = state.getSupertypesSet();
        Intrinsics.checkNotNull(visitedSupertypes$iv);
        deque$iv.push(start);
        while (!deque$iv.isEmpty()) {
            RigidTypeMarker current$iv = deque$iv.pop();
            Intrinsics.checkNotNull(current$iv);
            if (visitedSupertypes$iv.add(current$iv)) {
                TypeCheckerState.SupertypesPolicy it$iv = $this$hasPathByNotMarkedNullableNodes_u24lambda_u240.isMarkedNullable(current$iv) ? TypeCheckerState.SupertypesPolicy.None.INSTANCE : TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                if (Intrinsics.areEqual(it$iv, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) {
                    it$iv = null;
                }
                if (it$iv == null) {
                    continue;
                } else {
                    TypeCheckerState.SupertypesPolicy policy$iv = it$iv;
                    TypeSystemContext $this$anySupertype_u24lambda_u241$iv = state.getTypeSystemContext();
                    Collection supertypes$iv = $this$anySupertype_u24lambda_u241$iv.supertypes($this$anySupertype_u24lambda_u241$iv.typeConstructor(current$iv));
                    for (KotlinTypeMarker supertype$iv : supertypes$iv) {
                        RigidTypeMarker newType$iv = policy$iv.mo1175transformType(state, supertype$iv);
                        TypeSystemContext $this$hasPathByNotMarkedNullableNodes_u24lambda_u2402 = $this$hasPathByNotMarkedNullableNodes_u24lambda_u240;
                        if (INSTANCE.isApplicableAsEndNode(state, newType$iv, end)) {
                            state.clear();
                            return true;
                        }
                        deque$iv.add(newType$iv);
                        $this$hasPathByNotMarkedNullableNodes_u24lambda_u240 = $this$hasPathByNotMarkedNullableNodes_u24lambda_u2402;
                    }
                }
            }
        }
        state.clear();
        return false;
    }

    private final boolean isApplicableAsEndNode(TypeCheckerState state, RigidTypeMarker type, TypeConstructorMarker end) {
        TypeSystemContext $this$isApplicableAsEndNode_u24lambda_u240 = state.getTypeSystemContext();
        if ($this$isApplicableAsEndNode_u24lambda_u240.isNothing(type)) {
            return true;
        }
        if ($this$isApplicableAsEndNode_u24lambda_u240.isMarkedNullable(type)) {
            return false;
        }
        if (state.isStubTypeEqualsToAnything() && $this$isApplicableAsEndNode_u24lambda_u240.isStubType(type)) {
            return true;
        }
        return $this$isApplicableAsEndNode_u24lambda_u240.areEqualTypeConstructors($this$isApplicableAsEndNode_u24lambda_u240.typeConstructor(type), end);
    }
}