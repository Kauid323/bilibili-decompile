package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: KotlinTypePreparator.kt */
public abstract class KotlinTypePreparator extends AbstractTypePreparator {
    private final SimpleType transformToNewType(SimpleType type) {
        KotlinType type2;
        TypeConstructor constructor = type.getConstructor();
        IntersectionTypeConstructor intersectionTypeConstructor = null;
        r4 = null;
        UnwrappedType unwrappedType = null;
        KotlinType updatedAlternative$iv = null;
        if (constructor instanceof CapturedTypeConstructorImpl) {
            TypeProjection it = ((CapturedTypeConstructorImpl) constructor).getProjection();
            if (!(it.getProjectionKind() == Variance.IN_VARIANCE)) {
                it = null;
            }
            if (it != null && (type2 = it.getType()) != null) {
                unwrappedType = type2.unwrap();
            }
            UnwrappedType lowerType = unwrappedType;
            if (((CapturedTypeConstructorImpl) constructor).getNewTypeConstructor() == null) {
                CapturedTypeConstructorImpl capturedTypeConstructorImpl = (CapturedTypeConstructorImpl) constructor;
                TypeProjection projection = ((CapturedTypeConstructorImpl) constructor).getProjection();
                Iterable $this$map$iv = ((CapturedTypeConstructorImpl) constructor).mo1172getSupertypes();
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    KotlinType it2 = (KotlinType) item$iv$iv;
                    destination$iv$iv.add(it2.unwrap());
                }
                capturedTypeConstructorImpl.setNewTypeConstructor(new NewCapturedTypeConstructor(projection, (List) destination$iv$iv, null, 4, null));
            }
            CaptureStatus captureStatus = CaptureStatus.FOR_SUBTYPING;
            NewCapturedTypeConstructor newTypeConstructor = ((CapturedTypeConstructorImpl) constructor).getNewTypeConstructor();
            Intrinsics.checkNotNull(newTypeConstructor);
            return new NewCapturedType(captureStatus, newTypeConstructor, lowerType, type.getAttributes(), type.isMarkedNullable(), false, 32, null);
        } else if (constructor instanceof IntegerValueTypeConstructor) {
            Iterable $this$map$iv2 = ((IntegerValueTypeConstructor) constructor).mo1172getSupertypes();
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            for (Object item$iv$iv2 : $this$map$iv2) {
                KotlinType it3 = (KotlinType) item$iv$iv2;
                KotlinType makeNullableAsSpecified = TypeUtils.makeNullableAsSpecified(it3, type.isMarkedNullable());
                Intrinsics.checkNotNullExpressionValue(makeNullableAsSpecified, "makeNullableAsSpecified(...)");
                destination$iv$iv2.add(makeNullableAsSpecified);
            }
            IntersectionTypeConstructor newConstructor = new IntersectionTypeConstructor((List) destination$iv$iv2);
            return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(type.getAttributes(), newConstructor, CollectionsKt.emptyList(), false, type.getMemberScope());
        } else if ((constructor instanceof IntersectionTypeConstructor) && type.isMarkedNullable()) {
            IntersectionTypeConstructor $this$transformComponents_u24default$iv = (IntersectionTypeConstructor) constructor;
            boolean changed$iv = false;
            Iterable $this$map$iv$iv = $this$transformComponents_u24default$iv.mo1172getSupertypes();
            Collection destination$iv$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv, 10));
            for (Object item$iv$iv$iv : $this$map$iv$iv) {
                KotlinType it$iv = (KotlinType) item$iv$iv$iv;
                changed$iv = true;
                KotlinType it4 = TypeUtilsKt.makeNullable(it$iv);
                destination$iv$iv$iv.add(it4);
            }
            List newSupertypes$iv = (List) destination$iv$iv$iv;
            if (changed$iv) {
                KotlinType alternative$iv = $this$transformComponents_u24default$iv.getAlternativeType();
                if (alternative$iv != null) {
                    KotlinType it5 = TypeUtilsKt.makeNullable(alternative$iv);
                    updatedAlternative$iv = it5;
                }
                intersectionTypeConstructor = new IntersectionTypeConstructor(newSupertypes$iv).setAlternative(updatedAlternative$iv);
            }
            if (intersectionTypeConstructor == null) {
                intersectionTypeConstructor = (IntersectionTypeConstructor) constructor;
            }
            IntersectionTypeConstructor newConstructor2 = intersectionTypeConstructor;
            return newConstructor2.createType();
        } else {
            return type;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator
    public UnwrappedType prepareType(KotlinTypeMarker type) {
        SimpleType flexibleType;
        Intrinsics.checkNotNullParameter(type, "type");
        if (!(type instanceof KotlinType)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        UnwrappedType unwrappedType = ((KotlinType) type).unwrap();
        if (unwrappedType instanceof SimpleType) {
            flexibleType = transformToNewType((SimpleType) unwrappedType);
        } else if (!(unwrappedType instanceof FlexibleType)) {
            throw new NoWhenBranchMatchedException();
        } else {
            SimpleType newLower = transformToNewType(((FlexibleType) unwrappedType).getLowerBound());
            SimpleType newUpper = transformToNewType(((FlexibleType) unwrappedType).getUpperBound());
            if (newLower != ((FlexibleType) unwrappedType).getLowerBound() || newUpper != ((FlexibleType) unwrappedType).getUpperBound()) {
                flexibleType = KotlinTypeFactory.flexibleType(newLower, newUpper);
            } else {
                flexibleType = unwrappedType;
            }
        }
        return TypeWithEnhancementKt.inheritEnhancement(flexibleType, unwrappedType, new KotlinTypePreparator$prepareType$1(this));
    }

    /* compiled from: KotlinTypePreparator.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Default extends KotlinTypePreparator {
        public static final Default INSTANCE = new Default();

        private Default() {
        }
    }
}