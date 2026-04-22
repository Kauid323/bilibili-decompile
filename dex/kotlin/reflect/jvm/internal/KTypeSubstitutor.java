package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import kotlin.reflect.full.KClassifiers;

/* compiled from: KTypeSubstitutor.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u0014\u0010\u000b\u001a\u00020\n*\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\f\u0010\r\u001a\u00020\u0005*\u00020\u0005H\u0002J\f\u0010\u000e\u001a\u00020\u0005*\u00020\u0005H\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeSubstitutor;", "", "substitution", "", "Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/KTypeProjection;", "<init>", "(Ljava/util/Map;)V", "substitute", "type", "Lkotlin/reflect/KType;", "withNullabilityOf", "other", "lowerBoundIfFlexible", "upperBoundIfFlexible", "Companion", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KTypeSubstitutor {
    public static final Companion Companion = new Companion(null);
    private final Map<KTypeParameter, KTypeProjection> substitution;

    public KTypeSubstitutor(Map<KTypeParameter, KTypeProjection> substitution) {
        Intrinsics.checkNotNullParameter(substitution, "substitution");
        this.substitution = substitution;
    }

    public final KTypeProjection substitute(KType type) {
        KTypeProjection star;
        Intrinsics.checkNotNullParameter(type, "type");
        AbstractKType abstractKType = type instanceof AbstractKType ? (AbstractKType) type : null;
        AbstractKType lowerBound = abstractKType != null ? abstractKType.lowerBoundIfFlexible() : null;
        AbstractKType abstractKType2 = type instanceof AbstractKType ? (AbstractKType) type : null;
        AbstractKType upperBound = abstractKType2 != null ? abstractKType2.upperBoundIfFlexible() : null;
        if (lowerBound != null && upperBound != null) {
            KTypeProjection substitutedLower = lowerBoundIfFlexible(substitute(lowerBound));
            KTypeProjection substitutedUpper = upperBoundIfFlexible(substitute(upperBound));
            KVariance variance = substitutedLower.getVariance();
            KType type2 = substitutedLower.getType();
            Intrinsics.checkNotNull(type2);
            KType type3 = substitutedUpper.getType();
            Intrinsics.checkNotNull(type3);
            return new KTypeProjection(variance, TypeOfImplKt.createPlatformKType(type2, type3));
        }
        KClassifier classifier = type.getClassifier();
        if (classifier == null) {
            return KTypeProjection.Companion.invariant(type);
        }
        KTypeProjection result = this.substitution.get(classifier);
        if (result != null) {
            KVariance variance2 = result.component1();
            KType resultingType = result.component2();
            return resultingType == null ? result : new KTypeProjection(variance2, withNullabilityOf(resultingType, type));
        }
        KTypeProjection.Companion companion = KTypeProjection.Companion;
        Iterable $this$map$iv = type.getArguments();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KType type4 = ((KTypeProjection) item$iv$iv).component2();
            if (type4 == null || (star = substitute(type4)) == null) {
                star = KTypeProjection.Companion.getSTAR();
            }
            destination$iv$iv.add(star);
        }
        return companion.invariant(KClassifiers.createType$default(classifier, (List) destination$iv$iv, type.isMarkedNullable(), null, 4, null));
    }

    private final KType withNullabilityOf(KType $this$withNullabilityOf, KType other) {
        Intrinsics.checkNotNull($this$withNullabilityOf, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.AbstractKType");
        AbstractKType abstractKType = (AbstractKType) $this$withNullabilityOf;
        boolean z = false;
        AbstractKType makeNullableAsSpecified = ((AbstractKType) $this$withNullabilityOf).makeNullableAsSpecified(other.isMarkedNullable() || $this$withNullabilityOf.isMarkedNullable());
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.AbstractKType");
        if (((AbstractKType) other).isDefinitelyNotNullType() || (((AbstractKType) $this$withNullabilityOf).isDefinitelyNotNullType() && !other.isMarkedNullable())) {
            z = true;
        }
        return makeNullableAsSpecified.makeDefinitelyNotNullAsSpecified(z);
    }

    private final KTypeProjection lowerBoundIfFlexible(KTypeProjection $this$lowerBoundIfFlexible) {
        AbstractKType it;
        KType type = $this$lowerBoundIfFlexible.getType();
        AbstractKType abstractKType = type instanceof AbstractKType ? (AbstractKType) type : null;
        return (abstractKType == null || (it = abstractKType.lowerBoundIfFlexible()) == null) ? $this$lowerBoundIfFlexible : new KTypeProjection($this$lowerBoundIfFlexible.getVariance(), it);
    }

    private final KTypeProjection upperBoundIfFlexible(KTypeProjection $this$upperBoundIfFlexible) {
        AbstractKType it;
        KType type = $this$upperBoundIfFlexible.getType();
        AbstractKType abstractKType = type instanceof AbstractKType ? (AbstractKType) type : null;
        return (abstractKType == null || (it = abstractKType.upperBoundIfFlexible()) == null) ? $this$upperBoundIfFlexible : new KTypeProjection($this$upperBoundIfFlexible.getVariance(), it);
    }

    /* compiled from: KTypeSubstitutor.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeSubstitutor$Companion;", "", "<init>", "()V", "create", "Lkotlin/reflect/jvm/internal/KTypeSubstitutor;", "klass", "Lkotlin/reflect/KClass;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KTypeSubstitutor create(KClass<?> klass, List<KTypeProjection> arguments) {
            Intrinsics.checkNotNullParameter(klass, "klass");
            Intrinsics.checkNotNullParameter(arguments, "arguments");
            return new KTypeSubstitutor(MapsKt.toMap(CollectionsKt.zip(klass.getTypeParameters(), arguments)));
        }
    }
}