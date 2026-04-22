package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;

/* compiled from: utils.kt */
public final class UtilsKt {
    public static final KotlinType findCorrespondingSupertype(KotlinType subtype, KotlinType supertype, TypeCheckingProcedureCallbacks typeCheckingProcedureCallbacks) {
        boolean z;
        boolean z2;
        boolean z3;
        KotlinType safeSubstitute;
        Intrinsics.checkNotNullParameter(subtype, "subtype");
        Intrinsics.checkNotNullParameter(supertype, "supertype");
        Intrinsics.checkNotNullParameter(typeCheckingProcedureCallbacks, "typeCheckingProcedureCallbacks");
        ArrayDeque queue = new ArrayDeque();
        queue.add(new SubtypePathNode(subtype, null));
        TypeConstructor supertypeConstructor = supertype.getConstructor();
        while (!queue.isEmpty()) {
            SubtypePathNode lastPathNode = (SubtypePathNode) queue.poll();
            KotlinType currentSubtype = lastPathNode.getType();
            TypeConstructor constructor = currentSubtype.getConstructor();
            if (typeCheckingProcedureCallbacks.assertEqualTypeConstructors(constructor, supertypeConstructor)) {
                KotlinType substituted = currentSubtype;
                boolean isAnyMarkedNullable = currentSubtype.isMarkedNullable();
                for (SubtypePathNode currentPathNode = lastPathNode.getPrevious(); currentPathNode != null; currentPathNode = currentPathNode.getPrevious()) {
                    KotlinType currentType = currentPathNode.getType();
                    Iterable $this$any$iv = currentType.getArguments();
                    if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                        Iterator<T> it = $this$any$iv.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = false;
                                break;
                            }
                            Object element$iv = it.next();
                            TypeProjection it2 = (TypeProjection) element$iv;
                            if (it2.getProjectionKind() != Variance.INVARIANT) {
                                z = true;
                                break;
                            }
                        }
                    } else {
                        z = false;
                    }
                    if (z) {
                        z2 = true;
                        z3 = false;
                        KotlinType safeSubstitute2 = CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(TypeConstructorSubstitution.Companion.create(currentType), false, 1, null).buildSubstitutor().safeSubstitute(substituted, Variance.INVARIANT);
                        Intrinsics.checkNotNullExpressionValue(safeSubstitute2, "safeSubstitute(...)");
                        safeSubstitute = approximate(safeSubstitute2);
                    } else {
                        z2 = true;
                        z3 = false;
                        safeSubstitute = TypeConstructorSubstitution.Companion.create(currentType).buildSubstitutor().safeSubstitute(substituted, Variance.INVARIANT);
                        Intrinsics.checkNotNull(safeSubstitute);
                    }
                    substituted = safeSubstitute;
                    if (!isAnyMarkedNullable && !currentType.isMarkedNullable()) {
                        z2 = z3;
                    }
                    isAnyMarkedNullable = z2;
                }
                TypeConstructor substitutedConstructor = substituted.getConstructor();
                if (typeCheckingProcedureCallbacks.assertEqualTypeConstructors(substitutedConstructor, supertypeConstructor)) {
                    return TypeUtils.makeNullableAsSpecified(substituted, isAnyMarkedNullable);
                }
                throw new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + debugInfo(substitutedConstructor) + ", \n\nsupertype: " + debugInfo(supertypeConstructor) + " \n" + typeCheckingProcedureCallbacks.assertEqualTypeConstructors(substitutedConstructor, supertypeConstructor));
            }
            for (KotlinType immediateSupertype : constructor.mo1172getSupertypes()) {
                Intrinsics.checkNotNull(immediateSupertype);
                queue.add(new SubtypePathNode(immediateSupertype, lastPathNode));
            }
        }
        return null;
    }

    private static final KotlinType approximate(KotlinType $this$approximate) {
        return CapturedTypeApproximationKt.approximateCapturedTypes($this$approximate).getUpper();
    }

    private static final String debugInfo(TypeConstructor $this$debugInfo) {
        StringBuilder $this$debugInfo_u24lambda_u240 = new StringBuilder();
        debugInfo$lambda$0$unaryPlus("type: " + $this$debugInfo, $this$debugInfo_u24lambda_u240);
        debugInfo$lambda$0$unaryPlus("hashCode: " + $this$debugInfo.hashCode(), $this$debugInfo_u24lambda_u240);
        debugInfo$lambda$0$unaryPlus("javaClass: " + $this$debugInfo.getClass().getCanonicalName(), $this$debugInfo_u24lambda_u240);
        for (ClassifierDescriptor declarationDescriptor = $this$debugInfo.mo1171getDeclarationDescriptor(); declarationDescriptor != null; declarationDescriptor = declarationDescriptor.getContainingDeclaration()) {
            debugInfo$lambda$0$unaryPlus("fqName: " + DescriptorRenderer.FQ_NAMES_IN_TYPES.render(declarationDescriptor), $this$debugInfo_u24lambda_u240);
            debugInfo$lambda$0$unaryPlus("javaClass: " + declarationDescriptor.getClass().getCanonicalName(), $this$debugInfo_u24lambda_u240);
        }
        return $this$debugInfo_u24lambda_u240.toString();
    }

    private static final StringBuilder debugInfo$lambda$0$unaryPlus(String $this$debugInfo_u24lambda_u240_u24unaryPlus, StringBuilder $this_buildString) {
        Intrinsics.checkNotNullParameter($this$debugInfo_u24lambda_u240_u24unaryPlus, "<this>");
        return $this_buildString.append($this$debugInfo_u24lambda_u240_u24unaryPlus).append('\n');
    }
}