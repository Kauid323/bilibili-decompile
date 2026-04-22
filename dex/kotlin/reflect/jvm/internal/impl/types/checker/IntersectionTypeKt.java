package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* compiled from: IntersectionType.kt */
public final class IntersectionTypeKt {
    public static final UnwrappedType intersectTypes(Collection<? extends UnwrappedType> types) {
        SimpleType lowerBound;
        Intrinsics.checkNotNullParameter(types, "types");
        switch (types.size()) {
            case 0:
                throw new IllegalStateException("Expected some types".toString());
            case 1:
                return (UnwrappedType) CollectionsKt.single(types);
            default:
                boolean hasFlexibleTypes = false;
                boolean hasErrorType = false;
                Collection<? extends UnwrappedType> $this$map$iv = types;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    UnwrappedType it = (UnwrappedType) item$iv$iv;
                    hasErrorType = hasErrorType || KotlinTypeKt.isError(it);
                    if (it instanceof SimpleType) {
                        lowerBound = (SimpleType) it;
                    } else if (!(it instanceof FlexibleType)) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        if (DynamicTypesKt.isDynamic(it)) {
                            return it;
                        }
                        hasFlexibleTypes = true;
                        lowerBound = ((FlexibleType) it).getLowerBound();
                    }
                    destination$iv$iv.add(lowerBound);
                }
                List lowerBounds = (List) destination$iv$iv;
                if (hasErrorType) {
                    return ErrorUtils.createErrorType(ErrorTypeKind.INTERSECTION_OF_ERROR_TYPES, types.toString());
                }
                if (!hasFlexibleTypes) {
                    return TypeIntersector.INSTANCE.intersectTypes$descriptors(lowerBounds);
                }
                Collection<? extends UnwrappedType> $this$map$iv2 = types;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                for (Object item$iv$iv2 : $this$map$iv2) {
                    destination$iv$iv2.add(FlexibleTypesKt.upperIfFlexible((UnwrappedType) item$iv$iv2));
                }
                List upperBounds = (List) destination$iv$iv2;
                return KotlinTypeFactory.flexibleType(TypeIntersector.INSTANCE.intersectTypes$descriptors(lowerBounds), TypeIntersector.INSTANCE.intersectTypes$descriptors(upperBounds));
        }
    }
}