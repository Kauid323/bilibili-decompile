package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;

/* compiled from: SpecialTypes.kt */
public final class SpecialTypesKt {
    public static final AbbreviatedType getAbbreviatedType(KotlinType $this$getAbbreviatedType) {
        Intrinsics.checkNotNullParameter($this$getAbbreviatedType, "<this>");
        UnwrappedType unwrap = $this$getAbbreviatedType.unwrap();
        if (unwrap instanceof AbbreviatedType) {
            return (AbbreviatedType) unwrap;
        }
        return null;
    }

    public static final SimpleType getAbbreviation(KotlinType $this$getAbbreviation) {
        Intrinsics.checkNotNullParameter($this$getAbbreviation, "<this>");
        AbbreviatedType abbreviatedType = getAbbreviatedType($this$getAbbreviation);
        if (abbreviatedType != null) {
            return abbreviatedType.getAbbreviation();
        }
        return null;
    }

    public static final SimpleType withAbbreviation(SimpleType $this$withAbbreviation, SimpleType abbreviatedType) {
        Intrinsics.checkNotNullParameter($this$withAbbreviation, "<this>");
        Intrinsics.checkNotNullParameter(abbreviatedType, "abbreviatedType");
        return KotlinTypeKt.isError($this$withAbbreviation) ? $this$withAbbreviation : new AbbreviatedType($this$withAbbreviation, abbreviatedType);
    }

    public static final boolean isDefinitelyNotNullType(KotlinType $this$isDefinitelyNotNullType) {
        Intrinsics.checkNotNullParameter($this$isDefinitelyNotNullType, "<this>");
        return $this$isDefinitelyNotNullType.unwrap() instanceof DefinitelyNotNullType;
    }

    public static /* synthetic */ SimpleType makeSimpleTypeDefinitelyNotNullOrNotNull$default(SimpleType simpleType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return makeSimpleTypeDefinitelyNotNullOrNotNull(simpleType, z);
    }

    public static final SimpleType makeSimpleTypeDefinitelyNotNullOrNotNull(SimpleType $this$makeSimpleTypeDefinitelyNotNullOrNotNull, boolean useCorrectedNullabilityForTypeParameters) {
        Intrinsics.checkNotNullParameter($this$makeSimpleTypeDefinitelyNotNullOrNotNull, "<this>");
        DefinitelyNotNullType makeDefinitelyNotNull$default = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$default(DefinitelyNotNullType.Companion, $this$makeSimpleTypeDefinitelyNotNullOrNotNull, useCorrectedNullabilityForTypeParameters, false, 4, null);
        if (makeDefinitelyNotNull$default != null) {
            return makeDefinitelyNotNull$default;
        }
        SimpleType makeIntersectionTypeDefinitelyNotNullOrNotNull = makeIntersectionTypeDefinitelyNotNullOrNotNull($this$makeSimpleTypeDefinitelyNotNullOrNotNull);
        return makeIntersectionTypeDefinitelyNotNullOrNotNull == null ? $this$makeSimpleTypeDefinitelyNotNullOrNotNull.makeNullableAsSpecified(false) : makeIntersectionTypeDefinitelyNotNullOrNotNull;
    }

    public static final NewCapturedType withNotNullProjection(NewCapturedType $this$withNotNullProjection) {
        Intrinsics.checkNotNullParameter($this$withNotNullProjection, "<this>");
        return new NewCapturedType($this$withNotNullProjection.getCaptureStatus(), $this$withNotNullProjection.getConstructor(), $this$withNotNullProjection.getLowerType(), $this$withNotNullProjection.getAttributes(), $this$withNotNullProjection.isMarkedNullable(), true);
    }

    public static /* synthetic */ UnwrappedType makeDefinitelyNotNullOrNotNull$default(UnwrappedType unwrappedType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return makeDefinitelyNotNullOrNotNull(unwrappedType, z);
    }

    public static final UnwrappedType makeDefinitelyNotNullOrNotNull(UnwrappedType $this$makeDefinitelyNotNullOrNotNull, boolean useCorrectedNullabilityForTypeParameters) {
        Intrinsics.checkNotNullParameter($this$makeDefinitelyNotNullOrNotNull, "<this>");
        UnwrappedType makeDefinitelyNotNull$default = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$default(DefinitelyNotNullType.Companion, $this$makeDefinitelyNotNullOrNotNull, useCorrectedNullabilityForTypeParameters, false, 4, null);
        return (makeDefinitelyNotNull$default == null && (makeDefinitelyNotNull$default = makeIntersectionTypeDefinitelyNotNullOrNotNull($this$makeDefinitelyNotNullOrNotNull)) == null) ? $this$makeDefinitelyNotNullOrNotNull.makeNullableAsSpecified(false) : makeDefinitelyNotNull$default;
    }

    private static final SimpleType makeIntersectionTypeDefinitelyNotNullOrNotNull(KotlinType $this$makeIntersectionTypeDefinitelyNotNullOrNotNull) {
        IntersectionTypeConstructor definitelyNotNullConstructor;
        TypeConstructor constructor = $this$makeIntersectionTypeDefinitelyNotNullOrNotNull.getConstructor();
        IntersectionTypeConstructor typeConstructor = constructor instanceof IntersectionTypeConstructor ? (IntersectionTypeConstructor) constructor : null;
        if (typeConstructor == null || (definitelyNotNullConstructor = makeDefinitelyNotNullOrNotNull(typeConstructor)) == null) {
            return null;
        }
        return definitelyNotNullConstructor.createType();
    }

    private static final IntersectionTypeConstructor makeDefinitelyNotNullOrNotNull(IntersectionTypeConstructor $this$makeDefinitelyNotNullOrNotNull) {
        boolean z;
        UnwrappedType unwrappedType;
        boolean z2 = false;
        boolean changed$iv = false;
        Iterable $this$map$iv$iv = $this$makeDefinitelyNotNullOrNotNull.mo1172getSupertypes();
        Collection destination$iv$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv, 10));
        Iterator<T> it = $this$map$iv$iv.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object item$iv$iv$iv = it.next();
            KotlinType it$iv = (KotlinType) item$iv$iv$iv;
            if (TypeUtils.isNullableType(it$iv)) {
                changed$iv = true;
                z = z2;
                unwrappedType = makeDefinitelyNotNullOrNotNull$default(it$iv.unwrap(), false, 1, null);
            } else {
                z = z2;
                unwrappedType = it$iv;
            }
            destination$iv$iv$iv.add(unwrappedType);
            z2 = z;
        }
        List newSupertypes$iv = (List) destination$iv$iv$iv;
        if (changed$iv) {
            KotlinType alternative$iv = $this$makeDefinitelyNotNullOrNotNull.getAlternativeType();
            return new IntersectionTypeConstructor(newSupertypes$iv).setAlternative(alternative$iv != null ? TypeUtils.isNullableType(alternative$iv) ? makeDefinitelyNotNullOrNotNull$default(alternative$iv.unwrap(), false, 1, null) : alternative$iv : null);
        }
        return null;
    }
}