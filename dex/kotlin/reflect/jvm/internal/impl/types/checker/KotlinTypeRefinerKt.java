package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* compiled from: KotlinTypeRefiner.kt */
public final class KotlinTypeRefinerKt {
    private static final ModuleCapability<Ref<TypeRefinementSupport>> REFINER_CAPABILITY = new ModuleCapability<>("KotlinTypeRefiner");

    public static final List<KotlinType> refineTypes(KotlinTypeRefiner $this$refineTypes, Iterable<? extends KotlinType> types) {
        Intrinsics.checkNotNullParameter($this$refineTypes, "<this>");
        Intrinsics.checkNotNullParameter(types, "types");
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault(types, 10));
        for (Object item$iv$iv : types) {
            KotlinType it = (KotlinType) item$iv$iv;
            destination$iv$iv.add($this$refineTypes.refineType((KotlinTypeMarker) it));
        }
        return (List) destination$iv$iv;
    }

    public static final ModuleCapability<Ref<TypeRefinementSupport>> getREFINER_CAPABILITY() {
        return REFINER_CAPABILITY;
    }
}