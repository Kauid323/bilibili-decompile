package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* compiled from: typeEnhancementUtils.kt */
public final class TypeEnhancementUtilsKt {
    private static final <T> T select(Set<? extends T> set, T t, T t2, T t3, boolean isCovariant) {
        Object it;
        if (isCovariant) {
            T t4 = set.contains(t) ? t : set.contains(t2) ? t2 : null;
            if (Intrinsics.areEqual(t4, t) && Intrinsics.areEqual(t3, t2)) {
                return null;
            }
            return t3 == null ? t4 : t3;
        }
        if (t3 == null || (it = CollectionsKt.toSet(SetsKt.plus(set, t3))) == null) {
            it = set;
        }
        return (T) CollectionsKt.singleOrNull((Iterable) it);
    }

    private static final NullabilityQualifier select(Set<? extends NullabilityQualifier> set, NullabilityQualifier own, boolean isCovariant) {
        if (own == NullabilityQualifier.FORCE_FLEXIBILITY) {
            return NullabilityQualifier.FORCE_FLEXIBILITY;
        }
        return (NullabilityQualifier) select(set, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, own, isCovariant);
    }

    private static final NullabilityQualifier getNullabilityForErrors(JavaTypeQualifiers $this$nullabilityForErrors) {
        if ($this$nullabilityForErrors.isNullabilityQualifierForWarning()) {
            return null;
        }
        return $this$nullabilityForErrors.getNullability();
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0146, code lost:
        if (r10 != null) goto L68;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final JavaTypeQualifiers computeQualifiersForOverride(JavaTypeQualifiers $this$computeQualifiersForOverride, Collection<JavaTypeQualifiers> superQualifiers, boolean isCovariant, boolean isForVarargParameter, boolean ignoreDeclarationNullabilityAnnotations) {
        NullabilityQualifier newNullability;
        Iterable $this$any$iv;
        Iterable $this$mapNotNull$iv;
        Intrinsics.checkNotNullParameter($this$computeQualifiersForOverride, "<this>");
        Intrinsics.checkNotNullParameter(superQualifiers, "superQualifiers");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : superQualifiers) {
            JavaTypeQualifiers it = (JavaTypeQualifiers) element$iv$iv$iv;
            NullabilityQualifier nullabilityForErrors = getNullabilityForErrors(it);
            if (nullabilityForErrors != null) {
                destination$iv$iv.add(nullabilityForErrors);
            }
        }
        NullabilityQualifier newNullabilityForErrors = select(CollectionsKt.toSet((List) destination$iv$iv), getNullabilityForErrors($this$computeQualifiersForOverride), isCovariant);
        if (newNullabilityForErrors == null) {
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv$iv2 : superQualifiers) {
                JavaTypeQualifiers it2 = (JavaTypeQualifiers) element$iv$iv$iv2;
                NullabilityQualifier nullability = it2.getNullability();
                if (nullability != null) {
                    destination$iv$iv2.add(nullability);
                }
            }
            newNullability = select(CollectionsKt.toSet((List) destination$iv$iv2), $this$computeQualifiersForOverride.getNullability(), isCovariant);
        } else {
            newNullability = newNullabilityForErrors;
        }
        Collection<JavaTypeQualifiers> $this$mapNotNull$iv2 = superQualifiers;
        Collection destination$iv$iv3 = new ArrayList();
        for (Object element$iv$iv$iv3 : $this$mapNotNull$iv2) {
            JavaTypeQualifiers it3 = (JavaTypeQualifiers) element$iv$iv$iv3;
            MutabilityQualifier mutability = it3.getMutability();
            if (mutability != null) {
                $this$mapNotNull$iv = $this$mapNotNull$iv2;
                destination$iv$iv3.add(mutability);
            } else {
                $this$mapNotNull$iv = $this$mapNotNull$iv2;
            }
            $this$mapNotNull$iv2 = $this$mapNotNull$iv;
        }
        MutabilityQualifier newMutability = (MutabilityQualifier) select(CollectionsKt.toSet((List) destination$iv$iv3), MutabilityQualifier.MUTABLE, MutabilityQualifier.READ_ONLY, $this$computeQualifiersForOverride.getMutability(), isCovariant);
        NullabilityQualifier realNullability = null;
        boolean definitelyNotNull = true;
        if (newNullability != null) {
            NullabilityQualifier it4 = newNullability;
            NullabilityQualifier it5 = (ignoreDeclarationNullabilityAnnotations || (isForVarargParameter && it4 == NullabilityQualifier.NULLABLE)) ? 1 : null;
            if (it5 == null) {
                realNullability = newNullability;
            }
        }
        boolean isForWarning = realNullability != null && newNullabilityForErrors == null;
        if (realNullability == NullabilityQualifier.NOT_NULL) {
            if (!isDefinitelyNotNullAndSameSeverity($this$computeQualifiersForOverride, isForWarning)) {
                Collection<JavaTypeQualifiers> $this$any$iv2 = superQualifiers;
                if (!$this$any$iv2.isEmpty()) {
                    Iterator<T> it6 = $this$any$iv2.iterator();
                    while (true) {
                        if (!it6.hasNext()) {
                            $this$any$iv = null;
                            break;
                        }
                        Object element$iv = it6.next();
                        JavaTypeQualifiers it7 = (JavaTypeQualifiers) element$iv;
                        if (isDefinitelyNotNullAndSameSeverity(it7, isForWarning)) {
                            $this$any$iv = 1;
                            break;
                        }
                    }
                } else {
                    $this$any$iv = null;
                }
            }
            return new JavaTypeQualifiers(realNullability, newMutability, definitelyNotNull, isForWarning);
        }
        definitelyNotNull = false;
        return new JavaTypeQualifiers(realNullability, newMutability, definitelyNotNull, isForWarning);
    }

    private static final boolean isDefinitelyNotNullAndSameSeverity(JavaTypeQualifiers $this$isDefinitelyNotNullAndSameSeverity, boolean isForWarning) {
        return $this$isDefinitelyNotNullAndSameSeverity.isNullabilityQualifierForWarning() == isForWarning && $this$isDefinitelyNotNullAndSameSeverity.getDefinitelyNotNull();
    }

    public static final boolean hasEnhancedNullability(TypeSystemCommonBackendContext $this$hasEnhancedNullability, KotlinTypeMarker type) {
        Intrinsics.checkNotNullParameter($this$hasEnhancedNullability, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        FqName ENHANCED_NULLABILITY_ANNOTATION = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(ENHANCED_NULLABILITY_ANNOTATION, "ENHANCED_NULLABILITY_ANNOTATION");
        return $this$hasEnhancedNullability.hasAnnotation(type, ENHANCED_NULLABILITY_ANNOTATION);
    }
}