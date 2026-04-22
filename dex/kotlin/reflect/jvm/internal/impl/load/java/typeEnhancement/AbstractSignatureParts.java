package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;

/* compiled from: AbstractSignatureParts.kt */
public abstract class AbstractSignatureParts<TAnnotation> {
    public abstract boolean forceWarning(TAnnotation tannotation, KotlinTypeMarker kotlinTypeMarker);

    public abstract AbstractAnnotationTypeQualifierResolver<TAnnotation> getAnnotationTypeQualifierResolver();

    public abstract Iterable<TAnnotation> getAnnotations(KotlinTypeMarker kotlinTypeMarker);

    public abstract Iterable<TAnnotation> getContainerAnnotations();

    public abstract AnnotationQualifierApplicabilityType getContainerApplicabilityType();

    public abstract JavaTypeQualifiersByElementType getContainerDefaultTypeQualifiers();

    public abstract boolean getContainerIsVarargParameter();

    protected abstract NullabilityQualifierWithMigrationStatus getDefaultNullability(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, JavaDefaultQualifiers javaDefaultQualifiers);

    public abstract boolean getEnableImprovementsInStrictMode();

    public abstract KotlinTypeMarker getEnhancedForWarnings(KotlinTypeMarker kotlinTypeMarker);

    public abstract FqNameUnsafe getFqNameUnsafe(KotlinTypeMarker kotlinTypeMarker);

    public abstract boolean getSkipRawTypeArguments();

    public abstract TypeSystemContext getTypeSystem();

    public abstract boolean isArrayOrPrimitiveArray(KotlinTypeMarker kotlinTypeMarker);

    public abstract boolean isCovariant();

    public abstract boolean isEqual(KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2);

    public abstract boolean isFromJava(TypeParameterMarker typeParameterMarker);

    public boolean getForceOnlyHeadTypeConstructor() {
        return false;
    }

    public boolean isNotNullTypeParameterCompat(KotlinTypeMarker $this$isNotNullTypeParameterCompat) {
        Intrinsics.checkNotNullParameter($this$isNotNullTypeParameterCompat, "<this>");
        return false;
    }

    public boolean getShouldPropagateBoundNullness(KotlinTypeMarker $this$shouldPropagateBoundNullness) {
        Intrinsics.checkNotNullParameter($this$shouldPropagateBoundNullness, "<this>");
        return true;
    }

    private final NullabilityQualifier getNullabilityQualifier(KotlinTypeMarker $this$nullabilityQualifier) {
        TypeSystemContext $this$_get_nullabilityQualifier__u24lambda_u240 = getTypeSystem();
        if ($this$_get_nullabilityQualifier__u24lambda_u240.isMarkedNullable($this$_get_nullabilityQualifier__u24lambda_u240.lowerBoundIfFlexible($this$nullabilityQualifier))) {
            return NullabilityQualifier.NULLABLE;
        }
        if ($this$_get_nullabilityQualifier__u24lambda_u240.isMarkedNullable($this$_get_nullabilityQualifier__u24lambda_u240.upperBoundIfFlexible($this$nullabilityQualifier))) {
            return null;
        }
        return NullabilityQualifier.NOT_NULL;
    }

    private final JavaTypeQualifiers extractQualifiers(KotlinTypeMarker $this$extractQualifiers) {
        NullabilityQualifier forErrorsOrWarnings;
        NullabilityQualifier forErrors = getNullabilityQualifier($this$extractQualifiers);
        MutabilityQualifier mutability = null;
        if (forErrors == null) {
            KotlinTypeMarker enhancedForWarnings = getEnhancedForWarnings($this$extractQualifiers);
            forErrorsOrWarnings = enhancedForWarnings != null ? getNullabilityQualifier(enhancedForWarnings) : null;
        } else {
            forErrorsOrWarnings = forErrors;
        }
        TypeSystemContext $this$extractQualifiers_u24lambda_u240 = getTypeSystem();
        if (JavaToKotlinClassMap.INSTANCE.isReadOnly(getFqNameUnsafe($this$extractQualifiers_u24lambda_u240.lowerBoundIfFlexible($this$extractQualifiers)))) {
            mutability = MutabilityQualifier.READ_ONLY;
        } else if (JavaToKotlinClassMap.INSTANCE.isMutable(getFqNameUnsafe($this$extractQualifiers_u24lambda_u240.upperBoundIfFlexible($this$extractQualifiers)))) {
            mutability = MutabilityQualifier.MUTABLE;
        }
        TypeSystemContext $this$extractQualifiers_u24lambda_u241 = getTypeSystem();
        boolean isNotNullTypeParameter = $this$extractQualifiers_u24lambda_u241.isDefinitelyNotNullType($this$extractQualifiers) || isNotNullTypeParameterCompat($this$extractQualifiers);
        return new JavaTypeQualifiers(forErrorsOrWarnings, mutability, isNotNullTypeParameter, forErrorsOrWarnings != forErrors);
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x0196, code lost:
        if (r3.isForWarningOnly() == true) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0139, code lost:
        if ((r12 != null && r12.getDefinitelyNotNull()) != false) goto L78;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0179  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final JavaTypeQualifiers extractQualifiersFromAnnotations(final TypeAndDefaultQualifiers $this$extractQualifiersFromAnnotations) {
        List emptyList;
        Iterable plus;
        AnnotationQualifierApplicabilityType applicabilityType;
        boolean definitelyNotNull;
        TypeParameterMarker typeParameterForArgument;
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus;
        NullabilityQualifierWithMigrationStatus it;
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus2;
        NullabilityQualifierWithMigrationStatus result;
        TypeConstructorMarker typeConstructor;
        if ($this$extractQualifiersFromAnnotations.getType() == null) {
            TypeSystemContext $this$extractQualifiersFromAnnotations_u24lambda_u240 = getTypeSystem();
            TypeParameterMarker typeParameterForArgument2 = $this$extractQualifiersFromAnnotations.getTypeParameterForArgument();
            if ((typeParameterForArgument2 != null ? $this$extractQualifiersFromAnnotations_u24lambda_u240.getVariance(typeParameterForArgument2) : null) == TypeVariance.IN) {
                return JavaTypeQualifiers.Companion.getNONE();
            }
        }
        boolean z = true;
        boolean isHeadTypeConstructor = $this$extractQualifiersFromAnnotations.getTypeParameterForArgument() == null;
        KotlinTypeMarker type = $this$extractQualifiersFromAnnotations.getType();
        if (type == null || (emptyList = getAnnotations(type)) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        TypeSystemContext $this$extractQualifiersFromAnnotations_u24lambda_u241 = getTypeSystem();
        KotlinTypeMarker type2 = $this$extractQualifiersFromAnnotations.getType();
        TypeParameterMarker typeParameterUse = (type2 == null || (typeConstructor = $this$extractQualifiersFromAnnotations_u24lambda_u241.typeConstructor(type2)) == null) ? null : $this$extractQualifiersFromAnnotations_u24lambda_u241.getTypeParameterClassifier(typeConstructor);
        boolean typeParameterBounds = getContainerApplicabilityType() == AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS;
        if (isHeadTypeConstructor) {
            if (!typeParameterBounds && getEnableImprovementsInStrictMode()) {
                KotlinTypeMarker type3 = $this$extractQualifiersFromAnnotations.getType();
                if (type3 != null && isArrayOrPrimitiveArray(type3)) {
                    Iterable $this$filter$iv = getContainerAnnotations();
                    Collection destination$iv$iv = new ArrayList();
                    for (TAnnotation tannotation : $this$filter$iv) {
                        if (!getAnnotationTypeQualifierResolver().isTypeUseAnnotation(tannotation)) {
                            destination$iv$iv.add(tannotation);
                        }
                    }
                    plus = CollectionsKt.plus((Collection) ((List) destination$iv$iv), (Iterable) emptyList);
                }
            }
            plus = CollectionsKt.plus((Iterable) getContainerAnnotations(), (Iterable) emptyList);
        } else {
            plus = emptyList;
        }
        MutabilityQualifier annotationsMutability = getAnnotationTypeQualifierResolver().extractMutability(plus);
        NullabilityQualifierWithMigrationStatus annotationsNullability = getAnnotationTypeQualifierResolver().extractNullability(plus, (Function1) new Function1(this, $this$extractQualifiersFromAnnotations) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$$Lambda$0
            private final AbstractSignatureParts arg$0;
            private final AbstractSignatureParts.TypeAndDefaultQualifiers arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = $this$extractQualifiersFromAnnotations;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                boolean extractQualifiersFromAnnotations$lambda$3;
                extractQualifiersFromAnnotations$lambda$3 = AbstractSignatureParts.extractQualifiersFromAnnotations$lambda$3(this.arg$0, this.arg$1, obj);
                return Boolean.valueOf(extractQualifiersFromAnnotations$lambda$3);
            }
        });
        if (annotationsNullability != null) {
            return new JavaTypeQualifiers(annotationsNullability.getQualifier(), annotationsMutability, (annotationsNullability.getQualifier() != NullabilityQualifier.NOT_NULL || typeParameterUse == null) ? false : false, annotationsNullability.isForWarningOnly());
        }
        if (isHeadTypeConstructor || typeParameterBounds) {
            applicabilityType = getContainerApplicabilityType();
        } else {
            applicabilityType = AnnotationQualifierApplicabilityType.TYPE_USE;
        }
        JavaTypeQualifiersByElementType defaultQualifiers = $this$extractQualifiersFromAnnotations.getDefaultQualifiers();
        JavaDefaultQualifiers defaultTypeQualifier = defaultQualifiers != null ? defaultQualifiers.get(applicabilityType) : null;
        NullabilityQualifierWithMigrationStatus referencedParameterBoundsNullability = typeParameterUse != null ? getBoundsNullability(typeParameterUse) : null;
        NullabilityQualifierWithMigrationStatus defaultNullability = getDefaultNullability(referencedParameterBoundsNullability, defaultTypeQualifier);
        if ((referencedParameterBoundsNullability != null ? referencedParameterBoundsNullability.getQualifier() : null) != NullabilityQualifier.NOT_NULL) {
            if (typeParameterUse != null) {
            }
            definitelyNotNull = false;
            typeParameterForArgument = $this$extractQualifiersFromAnnotations.getTypeParameterForArgument();
            if (typeParameterForArgument == null) {
                it = getBoundsNullability(typeParameterForArgument);
                if (it != null) {
                    if (it.getQualifier() == NullabilityQualifier.NULLABLE) {
                        nullabilityQualifierWithMigrationStatus2 = null;
                        it = NullabilityQualifierWithMigrationStatus.copy$default(it, NullabilityQualifier.FORCE_FLEXIBILITY, false, 2, null);
                    } else {
                        nullabilityQualifierWithMigrationStatus2 = null;
                    }
                    NullabilityQualifierWithMigrationStatus substitutedParameterBoundsNullability = it;
                    result = mostSpecific(substitutedParameterBoundsNullability, defaultNullability);
                    NullabilityQualifier nullabilityQualifier = nullabilityQualifierWithMigrationStatus2;
                    if (result != null) {
                        nullabilityQualifier = result.getQualifier();
                    }
                    boolean z2 = result != null;
                    return new JavaTypeQualifiers(nullabilityQualifier, annotationsMutability, definitelyNotNull, z2);
                }
                nullabilityQualifierWithMigrationStatus = null;
            } else {
                nullabilityQualifierWithMigrationStatus = null;
            }
            it = nullabilityQualifierWithMigrationStatus;
            nullabilityQualifierWithMigrationStatus2 = nullabilityQualifierWithMigrationStatus;
            NullabilityQualifierWithMigrationStatus substitutedParameterBoundsNullability2 = it;
            result = mostSpecific(substitutedParameterBoundsNullability2, defaultNullability);
            NullabilityQualifier nullabilityQualifier2 = nullabilityQualifierWithMigrationStatus2;
            if (result != null) {
            }
            if (result != null) {
            }
            return new JavaTypeQualifiers(nullabilityQualifier2, annotationsMutability, definitelyNotNull, z2);
        }
        definitelyNotNull = true;
        typeParameterForArgument = $this$extractQualifiersFromAnnotations.getTypeParameterForArgument();
        if (typeParameterForArgument == null) {
        }
        it = nullabilityQualifierWithMigrationStatus;
        nullabilityQualifierWithMigrationStatus2 = nullabilityQualifierWithMigrationStatus;
        NullabilityQualifierWithMigrationStatus substitutedParameterBoundsNullability22 = it;
        result = mostSpecific(substitutedParameterBoundsNullability22, defaultNullability);
        NullabilityQualifier nullabilityQualifier22 = nullabilityQualifierWithMigrationStatus2;
        if (result != null) {
        }
        if (result != null) {
        }
        return new JavaTypeQualifiers(nullabilityQualifier22, annotationsMutability, definitelyNotNull, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean extractQualifiersFromAnnotations$lambda$3(AbstractSignatureParts this$0, TypeAndDefaultQualifiers $this_extractQualifiersFromAnnotations, Object extractNullability) {
        Intrinsics.checkNotNullParameter(extractNullability, "$this$extractNullability");
        return this$0.forceWarning(extractNullability, $this_extractQualifiersFromAnnotations.getType());
    }

    private final NullabilityQualifierWithMigrationStatus mostSpecific(NullabilityQualifierWithMigrationStatus a, NullabilityQualifierWithMigrationStatus b) {
        return a == null ? b : b == null ? a : (!a.isForWarningOnly() || b.isForWarningOnly()) ? (a.isForWarningOnly() || !b.isForWarningOnly()) ? a.getQualifier().compareTo(b.getQualifier()) < 0 ? b : a.getQualifier().compareTo(b.getQualifier()) > 0 ? a : b : a : b;
    }

    private final NullabilityQualifierWithMigrationStatus getBoundsNullability(TypeParameterMarker $this$boundsNullability) {
        Iterable $this$all$iv;
        Iterable $this$none$iv;
        Iterable enhancedBounds;
        Iterable $this$all$iv2;
        Iterable $this$none$iv2;
        TypeSystemContext $this$_get_boundsNullability__u24lambda_u240 = getTypeSystem();
        if (isFromJava($this$boundsNullability)) {
            final List bounds = $this$_get_boundsNullability__u24lambda_u240.getUpperBounds($this$boundsNullability);
            List $this$all$iv3 = bounds;
            if (!($this$all$iv3 instanceof Collection) || !$this$all$iv3.isEmpty()) {
                Iterator<T> it = $this$all$iv3.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object element$iv = it.next();
                        KotlinTypeMarker it2 = (KotlinTypeMarker) element$iv;
                        if (!$this$_get_boundsNullability__u24lambda_u240.isError(it2)) {
                            $this$all$iv = null;
                            break;
                        }
                    } else {
                        $this$all$iv = 1;
                        break;
                    }
                }
            } else {
                $this$all$iv = 1;
            }
            if ($this$all$iv != null) {
                return null;
            }
            List $this$filter$iv = bounds;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                KotlinTypeMarker it3 = (KotlinTypeMarker) element$iv$iv;
                KotlinTypeMarker it4 = getNullabilityQualifier(it3) != null ? 1 : null;
                if (it4 != null) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable haveNullabilityQualifier = (List) destination$iv$iv;
            Lazy haveEnhancedForWarnings$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0(bounds, this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$$Lambda$1
                private final List arg$0;
                private final AbstractSignatureParts arg$1;

                {
                    this.arg$0 = bounds;
                    this.arg$1 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List _get_boundsNullability_$lambda$0$2;
                    _get_boundsNullability_$lambda$0$2 = AbstractSignatureParts._get_boundsNullability_$lambda$0$2(this.arg$0, this.arg$1);
                    return _get_boundsNullability_$lambda$0$2;
                }
            });
            if (!((Collection) haveNullabilityQualifier).isEmpty()) {
                Iterable $this$none$iv3 = haveNullabilityQualifier;
                if (!($this$none$iv3 instanceof Collection) || !((Collection) $this$none$iv3).isEmpty()) {
                    Iterator it5 = $this$none$iv3.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            Object element$iv2 = it5.next();
                            KotlinTypeMarker it6 = (KotlinTypeMarker) element$iv2;
                            if (getShouldPropagateBoundNullness(it6)) {
                                $this$none$iv2 = null;
                                break;
                            }
                        } else {
                            $this$none$iv2 = 1;
                            break;
                        }
                    }
                } else {
                    $this$none$iv2 = 1;
                }
                if ($this$none$iv2 != null) {
                    return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.FORCE_FLEXIBILITY, false);
                }
                enhancedBounds = bounds;
            } else if (_get_boundsNullability_$lambda$0$3(haveEnhancedForWarnings$delegate).isEmpty()) {
                return null;
            } else {
                Iterable $this$none$iv4 = _get_boundsNullability_$lambda$0$3(haveEnhancedForWarnings$delegate);
                if (!($this$none$iv4 instanceof Collection) || !((Collection) $this$none$iv4).isEmpty()) {
                    Iterator<T> it7 = $this$none$iv4.iterator();
                    while (true) {
                        if (it7.hasNext()) {
                            Object element$iv3 = it7.next();
                            KotlinTypeMarker it8 = (KotlinTypeMarker) element$iv3;
                            if (getShouldPropagateBoundNullness(it8)) {
                                $this$none$iv = null;
                                break;
                            }
                        } else {
                            $this$none$iv = 1;
                            break;
                        }
                    }
                } else {
                    $this$none$iv = 1;
                }
                if ($this$none$iv != null) {
                    return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.FORCE_FLEXIBILITY, true);
                }
                enhancedBounds = _get_boundsNullability_$lambda$0$3(haveEnhancedForWarnings$delegate);
            }
            Iterable $this$all$iv4 = enhancedBounds;
            if (!($this$all$iv4 instanceof Collection) || !((Collection) $this$all$iv4).isEmpty()) {
                Iterator<T> it9 = $this$all$iv4.iterator();
                while (true) {
                    if (it9.hasNext()) {
                        Object element$iv4 = it9.next();
                        KotlinTypeMarker it10 = (KotlinTypeMarker) element$iv4;
                        if (!$this$_get_boundsNullability__u24lambda_u240.isNullableType(it10)) {
                            $this$all$iv2 = null;
                            break;
                        }
                    } else {
                        $this$all$iv2 = 1;
                        break;
                    }
                }
            } else {
                $this$all$iv2 = 1;
            }
            NullabilityQualifier qualifier = $this$all$iv2 != null ? NullabilityQualifier.NULLABLE : NullabilityQualifier.NOT_NULL;
            return new NullabilityQualifierWithMigrationStatus(qualifier, enhancedBounds != bounds);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _get_boundsNullability_$lambda$0$2(List $bounds, AbstractSignatureParts this$0) {
        List $this$mapNotNull$iv = $bounds;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            KotlinTypeMarker it = this$0.getEnhancedForWarnings((KotlinTypeMarker) element$iv$iv$iv);
            if (it != null) {
                destination$iv$iv.add(it);
            }
        }
        return (List) destination$iv$iv;
    }

    private static final List<KotlinTypeMarker> _get_boundsNullability_$lambda$0$3(Lazy<? extends List<? extends KotlinTypeMarker>> lazy) {
        return (List) lazy.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x007f, code lost:
        if (r5 != false) goto L65;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Function1<Integer, JavaTypeQualifiers> computeIndexedQualifiers(KotlinTypeMarker $this$computeIndexedQualifiers, Iterable<? extends KotlinTypeMarker> overrides, final TypeEnhancementInfo predefined, boolean ignoreDeclarationNullabilityAnnotations) {
        boolean onlyHeadTypeConstructor;
        int treeSize;
        int i;
        KotlinTypeMarker type;
        boolean z;
        Intrinsics.checkNotNullParameter($this$computeIndexedQualifiers, "<this>");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        List indexedThisType = toIndexed($this$computeIndexedQualifiers);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault(overrides, 10));
        for (Object item$iv$iv : overrides) {
            KotlinTypeMarker it = (KotlinTypeMarker) item$iv$iv;
            destination$iv$iv.add(toIndexed(it));
        }
        Iterable indexedFromSupertypes = (List) destination$iv$iv;
        if (!getForceOnlyHeadTypeConstructor()) {
            if (isCovariant()) {
                if (!(overrides instanceof Collection) || !((Collection) overrides).isEmpty()) {
                    Iterator<? extends KotlinTypeMarker> it2 = overrides.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = false;
                            break;
                        }
                        Object element$iv = it2.next();
                        KotlinTypeMarker it3 = (KotlinTypeMarker) element$iv;
                        if (!isEqual($this$computeIndexedQualifiers, it3)) {
                            z = true;
                            break;
                        }
                    }
                } else {
                    z = false;
                }
            }
            onlyHeadTypeConstructor = false;
            treeSize = !onlyHeadTypeConstructor ? 1 : indexedThisType.size();
            final JavaTypeQualifiers[] computedResult = new JavaTypeQualifiers[treeSize];
            i = 0;
            while (i < treeSize) {
                JavaTypeQualifiers qualifiers = extractQualifiersFromAnnotations(indexedThisType.get(i));
                Iterable $this$mapNotNull$iv = indexedFromSupertypes;
                Collection destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    List it4 = (List) element$iv$iv$iv;
                    TypeAndDefaultQualifiers typeAndDefaultQualifiers = (TypeAndDefaultQualifiers) CollectionsKt.getOrNull(it4, i);
                    JavaTypeQualifiers extractQualifiers = (typeAndDefaultQualifiers == null || (type = typeAndDefaultQualifiers.getType()) == null) ? null : extractQualifiers(type);
                    if (extractQualifiers != null) {
                        destination$iv$iv2.add(extractQualifiers);
                    }
                }
                List superQualifiers = (List) destination$iv$iv2;
                computedResult[i] = TypeEnhancementUtilsKt.computeQualifiersForOverride(qualifiers, superQualifiers, i == 0 && isCovariant(), i == 0 && getContainerIsVarargParameter(), ignoreDeclarationNullabilityAnnotations);
                i++;
            }
            return new Function1(predefined, computedResult) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$$Lambda$2
                private final TypeEnhancementInfo arg$0;
                private final JavaTypeQualifiers[] arg$1;

                {
                    this.arg$0 = predefined;
                    this.arg$1 = computedResult;
                }

                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    JavaTypeQualifiers computeIndexedQualifiers$lambda$3;
                    computeIndexedQualifiers$lambda$3 = AbstractSignatureParts.computeIndexedQualifiers$lambda$3(this.arg$0, this.arg$1, ((Number) obj).intValue());
                    return computeIndexedQualifiers$lambda$3;
                }
            };
        }
        onlyHeadTypeConstructor = true;
        if (!onlyHeadTypeConstructor) {
        }
        final JavaTypeQualifiers[] computedResult2 = new JavaTypeQualifiers[treeSize];
        i = 0;
        while (i < treeSize) {
        }
        return new Function1(predefined, computedResult2) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$$Lambda$2
            private final TypeEnhancementInfo arg$0;
            private final JavaTypeQualifiers[] arg$1;

            {
                this.arg$0 = predefined;
                this.arg$1 = computedResult2;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                JavaTypeQualifiers computeIndexedQualifiers$lambda$3;
                computeIndexedQualifiers$lambda$3 = AbstractSignatureParts.computeIndexedQualifiers$lambda$3(this.arg$0, this.arg$1, ((Number) obj).intValue());
                return computeIndexedQualifiers$lambda$3;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JavaTypeQualifiers computeIndexedQualifiers$lambda$3(TypeEnhancementInfo $predefined, JavaTypeQualifiers[] $computedResult, int index) {
        Map<Integer, JavaTypeQualifiers> map;
        JavaTypeQualifiers javaTypeQualifiers;
        if ($predefined == null || (map = $predefined.getMap()) == null || (javaTypeQualifiers = map.get(Integer.valueOf(index))) == null) {
            boolean z = false;
            if (index >= 0 && index < $computedResult.length) {
                z = true;
            }
            return z ? $computedResult[index] : JavaTypeQualifiers.Companion.getNONE();
        }
        return javaTypeQualifiers;
    }

    private final <T> void flattenTree(T t, List<T> list, Function1<? super T, ? extends Iterable<? extends T>> function1) {
        list.add(t);
        Iterable<T> $this$forEach$iv = function1.invoke(t);
        if ($this$forEach$iv == null) {
            return;
        }
        for (T t2 : $this$forEach$iv) {
            flattenTree(t2, list, function1);
        }
    }

    private final <T> List<T> flattenTree(T t, Function1<? super T, ? extends Iterable<? extends T>> function1) {
        ArrayList it = new ArrayList(1);
        flattenTree(t, it, function1);
        return it;
    }

    private final JavaTypeQualifiersByElementType extractAndMergeDefaultQualifiers(KotlinTypeMarker $this$extractAndMergeDefaultQualifiers, JavaTypeQualifiersByElementType oldQualifiers) {
        return getAnnotationTypeQualifierResolver().extractAndMergeDefaultQualifiers(oldQualifiers, getAnnotations($this$extractAndMergeDefaultQualifiers));
    }

    private final List<TypeAndDefaultQualifiers> toIndexed(KotlinTypeMarker $this$toIndexed) {
        final TypeSystemContext $this$toIndexed_u24lambda_u240 = getTypeSystem();
        return flattenTree(new TypeAndDefaultQualifiers($this$toIndexed, extractAndMergeDefaultQualifiers($this$toIndexed, getContainerDefaultTypeQualifiers()), null), new Function1(this, $this$toIndexed_u24lambda_u240) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$$Lambda$3
            private final AbstractSignatureParts arg$0;
            private final TypeSystemContext arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = $this$toIndexed_u24lambda_u240;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Iterable indexed$lambda$0$0;
                indexed$lambda$0$0 = AbstractSignatureParts.toIndexed$lambda$0$0(this.arg$0, this.arg$1, (AbstractSignatureParts.TypeAndDefaultQualifiers) obj);
                return indexed$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable toIndexed$lambda$0$0(AbstractSignatureParts this$0, TypeSystemContext $this_with, TypeAndDefaultQualifiers it) {
        TypeConstructorMarker typeConstructor;
        Iterable parameters;
        TypeAndDefaultQualifiers typeAndDefaultQualifiers;
        Intrinsics.checkNotNullParameter(it, "it");
        ArrayList arrayList = null;
        if (this$0.getSkipRawTypeArguments()) {
            KotlinTypeMarker type = it.getType();
            boolean z = false;
            if (type != null && $this_with.isRawType(type)) {
                z = true;
            }
            if (z) {
                return null;
            }
        }
        KotlinTypeMarker type2 = it.getType();
        if (type2 != null && (typeConstructor = $this_with.typeConstructor(type2)) != null && (parameters = $this_with.getParameters(typeConstructor)) != null) {
            Iterable $this$zip$iv = parameters;
            Iterable other$iv = $this_with.getArguments(it.getType());
            Iterator first$iv = $this$zip$iv.iterator();
            Iterator second$iv = other$iv.iterator();
            ArrayList list$iv = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault($this$zip$iv, 10), CollectionsKt.collectionSizeOrDefault(other$iv, 10)));
            while (first$iv.hasNext() && second$iv.hasNext()) {
                Object next = first$iv.next();
                TypeArgumentMarker arg = (TypeArgumentMarker) second$iv.next();
                TypeParameterMarker parameter = (TypeParameterMarker) next;
                KotlinTypeMarker type3 = $this_with.getType(arg);
                if (type3 == null) {
                    typeAndDefaultQualifiers = new TypeAndDefaultQualifiers(null, it.getDefaultQualifiers(), parameter);
                } else {
                    typeAndDefaultQualifiers = new TypeAndDefaultQualifiers(type3, this$0.extractAndMergeDefaultQualifiers(type3, it.getDefaultQualifiers()), parameter);
                }
                list$iv.add(typeAndDefaultQualifiers);
            }
            arrayList = list$iv;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractSignatureParts.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class TypeAndDefaultQualifiers {
        private final JavaTypeQualifiersByElementType defaultQualifiers;
        private final KotlinTypeMarker type;
        private final TypeParameterMarker typeParameterForArgument;

        public TypeAndDefaultQualifiers(KotlinTypeMarker type, JavaTypeQualifiersByElementType defaultQualifiers, TypeParameterMarker typeParameterForArgument) {
            this.type = type;
            this.defaultQualifiers = defaultQualifiers;
            this.typeParameterForArgument = typeParameterForArgument;
        }

        public final KotlinTypeMarker getType() {
            return this.type;
        }

        public final JavaTypeQualifiersByElementType getDefaultQualifiers() {
            return this.defaultQualifiers;
        }

        public final TypeParameterMarker getTypeParameterForArgument() {
            return this.typeParameterForArgument;
        }
    }
}