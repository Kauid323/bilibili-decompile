package kotlin.reflect.jvm.internal.impl.name;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: StandardClassIds.kt */
public final class StandardClassIdsKt {
    public static final /* synthetic */ ClassId access$annotationId(String $receiver) {
        return annotationId($receiver);
    }

    public static final /* synthetic */ ClassId access$atomicsId(String $receiver) {
        return atomicsId($receiver);
    }

    public static final /* synthetic */ ClassId access$baseId(String $receiver) {
        return baseId($receiver);
    }

    public static final /* synthetic */ ClassId access$collectionsId(String $receiver) {
        return collectionsId($receiver);
    }

    public static final /* synthetic */ ClassId access$coroutinesId(String $receiver) {
        return coroutinesId($receiver);
    }

    public static final /* synthetic */ ClassId access$enumsId(String $receiver) {
        return enumsId($receiver);
    }

    public static final /* synthetic */ Map access$inverseMap(Map $receiver) {
        return inverseMap($receiver);
    }

    public static final /* synthetic */ ClassId access$primitiveArrayId(Name $receiver) {
        return primitiveArrayId($receiver);
    }

    public static final /* synthetic */ ClassId access$rangesId(String $receiver) {
        return rangesId($receiver);
    }

    public static final /* synthetic */ ClassId access$reflectId(String $receiver) {
        return reflectId($receiver);
    }

    public static final /* synthetic */ ClassId access$unsignedId(ClassId $receiver) {
        return unsignedId($receiver);
    }

    public static final ClassId baseId(String $this$baseId) {
        FqName base_kotlin_package = StandardClassIds.INSTANCE.getBASE_KOTLIN_PACKAGE();
        Name identifier = Name.identifier($this$baseId);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        return new ClassId(base_kotlin_package, identifier);
    }

    public static final ClassId unsignedId(ClassId $this$unsignedId) {
        FqName base_kotlin_package = StandardClassIds.INSTANCE.getBASE_KOTLIN_PACKAGE();
        Name identifier = Name.identifier('U' + $this$unsignedId.getShortClassName().getIdentifier());
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        return new ClassId(base_kotlin_package, identifier);
    }

    public static final ClassId reflectId(String $this$reflectId) {
        FqName base_reflect_package = StandardClassIds.INSTANCE.getBASE_REFLECT_PACKAGE();
        Name identifier = Name.identifier($this$reflectId);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        return new ClassId(base_reflect_package, identifier);
    }

    public static final ClassId primitiveArrayId(Name $this$primitiveArrayId) {
        FqName packageFqName = StandardClassIds.INSTANCE.getArray().getPackageFqName();
        Name identifier = Name.identifier($this$primitiveArrayId.getIdentifier() + StandardClassIds.INSTANCE.getArray().getShortClassName().getIdentifier());
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        return new ClassId(packageFqName, identifier);
    }

    public static final ClassId collectionsId(String $this$collectionsId) {
        FqName base_collections_package = StandardClassIds.INSTANCE.getBASE_COLLECTIONS_PACKAGE();
        Name identifier = Name.identifier($this$collectionsId);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        return new ClassId(base_collections_package, identifier);
    }

    public static final ClassId rangesId(String $this$rangesId) {
        FqName base_ranges_package = StandardClassIds.INSTANCE.getBASE_RANGES_PACKAGE();
        Name identifier = Name.identifier($this$rangesId);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        return new ClassId(base_ranges_package, identifier);
    }

    public static final ClassId annotationId(String $this$annotationId) {
        FqName base_annotation_package = StandardClassIds.INSTANCE.getBASE_ANNOTATION_PACKAGE();
        Name identifier = Name.identifier($this$annotationId);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        return new ClassId(base_annotation_package, identifier);
    }

    public static final ClassId coroutinesId(String $this$coroutinesId) {
        FqName base_coroutines_package = StandardClassIds.INSTANCE.getBASE_COROUTINES_PACKAGE();
        Name identifier = Name.identifier($this$coroutinesId);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        return new ClassId(base_coroutines_package, identifier);
    }

    public static final ClassId enumsId(String $this$enumsId) {
        FqName base_enums_package = StandardClassIds.INSTANCE.getBASE_ENUMS_PACKAGE();
        Name identifier = Name.identifier($this$enumsId);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        return new ClassId(base_enums_package, identifier);
    }

    public static final ClassId atomicsId(String $this$atomicsId) {
        FqName base_concurrent_atomics_package = StandardClassIds.INSTANCE.getBASE_CONCURRENT_ATOMICS_PACKAGE();
        Name identifier = Name.identifier($this$atomicsId);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        return new ClassId(base_concurrent_atomics_package, identifier);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<V, K> inverseMap(Map<K, ? extends V> map) {
        Iterable $this$associate$iv = map.entrySet();
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associate$iv) {
            Map.Entry entry = (Map.Entry) element$iv$iv;
            Object k = entry.getKey();
            Object v = entry.getValue();
            Pair pair = TuplesKt.to(v, k);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}