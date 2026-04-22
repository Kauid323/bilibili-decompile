package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: NewCapturedType.kt */
public final class NewCapturedTypeKt {
    public static final SimpleType captureFromArguments(SimpleType type, CaptureStatus status) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(status, "status");
        List it = captureArguments(type, status);
        if (it != null) {
            return replaceArguments(type, it);
        }
        return null;
    }

    private static final SimpleType replaceArguments(UnwrappedType $this$replaceArguments, List<? extends TypeProjection> list) {
        return KotlinTypeFactory.simpleType$default($this$replaceArguments.getAttributes(), $this$replaceArguments.getConstructor(), list, $this$replaceArguments.isMarkedNullable(), (KotlinTypeRefiner) null, 16, (Object) null);
    }

    private static final List<TypeProjection> captureArguments(UnwrappedType type, CaptureStatus status) {
        TypeProjection it;
        List arguments;
        UnwrappedType lowerType;
        if (type.getArguments().size() != type.getConstructor().getParameters().size()) {
            return null;
        }
        List arguments2 = type.getArguments();
        List $this$all$iv = arguments2;
        boolean z = true;
        if (!($this$all$iv instanceof Collection) || !$this$all$iv.isEmpty()) {
            Iterator<T> it2 = $this$all$iv.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object element$iv = it2.next();
                TypeProjection it3 = (TypeProjection) element$iv;
                if (it3.getProjectionKind() == Variance.INVARIANT) {
                    it = 1;
                    continue;
                } else {
                    it = null;
                    continue;
                }
                if (it == null) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            return null;
        }
        List<TypeParameterDescriptor> parameters = type.getConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
        Iterable $this$map$iv = CollectionsKt.zip(arguments2, parameters);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Pair pair = (Pair) item$iv$iv;
            TypeProjection projection = (TypeProjection) pair.component1();
            TypeParameterDescriptor parameter = (TypeParameterDescriptor) pair.component2();
            if (projection.getProjectionKind() != Variance.INVARIANT) {
                if (!projection.isStarProjection() && projection.getProjectionKind() == Variance.IN_VARIANCE) {
                    lowerType = projection.getType().unwrap();
                } else {
                    lowerType = null;
                }
                Intrinsics.checkNotNull(parameter);
                projection = TypeUtilsKt.asTypeProjection(new NewCapturedType(status, lowerType, projection, parameter));
            }
            destination$iv$iv.add(projection);
        }
        List capturedArguments = (List) destination$iv$iv;
        TypeSubstitutor substitutor = TypeConstructorSubstitution.Companion.create(type.getConstructor(), capturedArguments).buildSubstitutor();
        int index = 0;
        int size = arguments2.size();
        while (index < size) {
            TypeProjection oldProjection = arguments2.get(index);
            TypeProjection newProjection = (TypeProjection) capturedArguments.get(index);
            if (oldProjection.getProjectionKind() == Variance.INVARIANT) {
                arguments = arguments2;
            } else {
                Iterable upperBounds = type.getConstructor().getParameters().get(index).getUpperBounds();
                Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
                Iterable $this$mapTo$iv = upperBounds;
                Collection destination$iv = (List) new ArrayList();
                for (Object item$iv : $this$mapTo$iv) {
                    KotlinType it4 = (KotlinType) item$iv;
                    destination$iv.add(KotlinTypePreparator.Default.INSTANCE.prepareType((KotlinTypeMarker) substitutor.safeSubstitute(it4, Variance.INVARIANT).unwrap()));
                    arguments2 = arguments2;
                }
                arguments = arguments2;
                List capturedTypeSupertypes = (List) destination$iv;
                if (!oldProjection.isStarProjection() && oldProjection.getProjectionKind() == Variance.OUT_VARIANCE) {
                    capturedTypeSupertypes.add(KotlinTypePreparator.Default.INSTANCE.prepareType((KotlinTypeMarker) oldProjection.getType().unwrap()));
                }
                KotlinType type2 = newProjection.getType();
                Intrinsics.checkNotNull(type2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
                NewCapturedType capturedType = (NewCapturedType) type2;
                capturedType.getConstructor().initializeSupertypes(capturedTypeSupertypes);
            }
            index++;
            arguments2 = arguments;
        }
        return capturedArguments;
    }
}