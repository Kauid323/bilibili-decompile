package kotlin.reflect.jvm.internal.impl.types;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.util.AttributeArrayOwner;
import kotlin.reflect.jvm.internal.impl.util.TypeRegistry;

/* compiled from: TypeAttributes.kt */
public final class TypeAttributes extends AttributeArrayOwner<TypeAttribute<?>, TypeAttribute<?>> implements Iterable<TypeAttribute<?>>, KMappedMarker {
    public static final Companion Companion = new Companion(null);
    private static final TypeAttributes Empty = new TypeAttributes(CollectionsKt.emptyList());

    public /* synthetic */ TypeAttributes(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(list);
    }

    private TypeAttributes(List<? extends TypeAttribute<?>> list) {
        for (TypeAttribute attribute : list) {
            registerComponent(attribute.getKey(), (KClass<? extends Object>) attribute);
        }
    }

    /* compiled from: TypeAttributes.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion extends TypeRegistry<TypeAttribute<?>, TypeAttribute<?>> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.TypeRegistry
        public int customComputeIfAbsent(ConcurrentHashMap<String, Integer> concurrentHashMap, String key, Function1<? super String, Integer> compute) {
            int intValue;
            Intrinsics.checkNotNullParameter(concurrentHashMap, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(compute, "compute");
            Integer num = (Integer) concurrentHashMap.get(key);
            if (num != null) {
                return num.intValue();
            }
            synchronized (concurrentHashMap) {
                Integer num2 = (Integer) concurrentHashMap.get(key);
                if (num2 != null) {
                    intValue = num2.intValue();
                } else {
                    Integer invoke = compute.invoke(key);
                    int it = invoke.intValue();
                    concurrentHashMap.putIfAbsent(key, Integer.valueOf(it));
                    intValue = invoke.intValue();
                }
            }
            return intValue;
        }

        public final TypeAttributes getEmpty() {
            return TypeAttributes.Empty;
        }

        public final TypeAttributes create(List<? extends TypeAttribute<?>> attributes) {
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            if (attributes.isEmpty()) {
                return getEmpty();
            }
            return new TypeAttributes(attributes, null);
        }
    }

    private TypeAttributes(TypeAttribute<?> typeAttribute) {
        this(CollectionsKt.listOf(typeAttribute));
    }

    public final TypeAttributes intersect(TypeAttributes other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (isEmpty() && other.isEmpty()) {
            return this;
        }
        List attributes$iv = new ArrayList();
        for (Number number : Companion.getIndices()) {
            int index$iv = number.intValue();
            TypeAttribute a$iv = getArrayMap().get(index$iv);
            TypeAttribute b$iv = other.getArrayMap().get(index$iv);
            TypeAttribute $this$intersect_u24lambda_u240 = a$iv == null ? b$iv != null ? b$iv.intersect(a$iv) : null : a$iv.intersect(b$iv);
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(attributes$iv, $this$intersect_u24lambda_u240);
        }
        return Companion.create(attributes$iv);
    }

    public final TypeAttributes add(TypeAttributes other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (isEmpty() && other.isEmpty()) {
            return this;
        }
        List attributes$iv = new ArrayList();
        for (Number number : Companion.getIndices()) {
            int index$iv = number.intValue();
            TypeAttribute a$iv = getArrayMap().get(index$iv);
            TypeAttribute b$iv = other.getArrayMap().get(index$iv);
            TypeAttribute $this$add_u24lambda_u240 = a$iv == null ? b$iv != null ? b$iv.add(a$iv) : null : a$iv.add(b$iv);
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(attributes$iv, $this$add_u24lambda_u240);
        }
        return Companion.create(attributes$iv);
    }

    public final boolean contains(TypeAttribute<?> attribute) {
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        int index = Companion.getId(attribute.getKey());
        return getArrayMap().get(index) != null;
    }

    public final TypeAttributes plus(TypeAttribute<?> attribute) {
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        if (contains(attribute)) {
            return this;
        }
        if (isEmpty()) {
            return new TypeAttributes(attribute);
        }
        List newAttributes = CollectionsKt.plus((Collection<? extends TypeAttribute<?>>) CollectionsKt.toList(this), attribute);
        return Companion.create(newAttributes);
    }

    public final TypeAttributes remove(TypeAttribute<?> attribute) {
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        if (isEmpty()) {
            return this;
        }
        Iterable $this$filter$iv = getArrayMap();
        Collection destination$iv$iv = new ArrayList();
        for (TypeAttribute typeAttribute : $this$filter$iv) {
            TypeAttribute it = typeAttribute;
            if (!Intrinsics.areEqual(it, attribute)) {
                destination$iv$iv.add(typeAttribute);
            }
        }
        List attributes = (List) destination$iv$iv;
        return attributes.size() == getArrayMap().getSize() ? this : Companion.create(attributes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner
    protected TypeRegistry<TypeAttribute<?>, TypeAttribute<?>> getTypeRegistry() {
        return Companion;
    }
}