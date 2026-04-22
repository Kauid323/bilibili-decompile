package io.ktor.serialization.kotlinx;

import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.InternalAPI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KType;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: SerializerLookup.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\b\u0003\u001a\u001f\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a/\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0003\"\b\b\u0000\u0010\u0007*\u00020\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\f\u0010\r\u001a#\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0003*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u000b\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lkotlinx/serialization/modules/SerializersModule;", "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "Lkotlinx/serialization/KSerializer;", "serializerForTypeInfo", "(Lkotlinx/serialization/modules/SerializersModule;Lio/ktor/util/reflect/TypeInfo;)Lkotlinx/serialization/KSerializer;", "", "T", "maybeNullable", "(Lkotlinx/serialization/KSerializer;Lio/ktor/util/reflect/TypeInfo;)Lkotlinx/serialization/KSerializer;", "value", "module", "guessSerializer", "(Ljava/lang/Object;Lkotlinx/serialization/modules/SerializersModule;)Lkotlinx/serialization/KSerializer;", "", "elementSerializer", "(Ljava/util/Collection;Lkotlinx/serialization/modules/SerializersModule;)Lkotlinx/serialization/KSerializer;", "ktor-serialization-kotlinx"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SerializerLookupKt {
    @ExperimentalSerializationApi
    @InternalSerializationApi
    public static final KSerializer<?> serializerForTypeInfo(SerializersModule $this$serializerForTypeInfo, TypeInfo typeInfo) {
        KSerializer<?> serializerOrNull;
        Intrinsics.checkNotNullParameter($this$serializerForTypeInfo, "<this>");
        Intrinsics.checkNotNullParameter(typeInfo, "typeInfo");
        KType type = typeInfo.getKotlinType();
        if (type != null) {
            if (type.getArguments().isEmpty()) {
                serializerOrNull = null;
            } else {
                serializerOrNull = SerializersKt.serializerOrNull($this$serializerForTypeInfo, type);
            }
            if (serializerOrNull != null) {
                return serializerOrNull;
            }
        }
        KSerializer contextual$default = SerializersModule.getContextual$default($this$serializerForTypeInfo, typeInfo.getType(), (List) null, 2, (Object) null);
        return contextual$default != null ? maybeNullable(contextual$default, typeInfo) : maybeNullable(SerializersKt.serializer(typeInfo.getType()), typeInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> KSerializer<?> maybeNullable(KSerializer<T> kSerializer, TypeInfo typeInfo) {
        KType kotlinType = typeInfo.getKotlinType();
        boolean z = false;
        if (kotlinType != null && kotlinType.isMarkedNullable()) {
            z = true;
        }
        return z ? BuiltinSerializersKt.getNullable(kSerializer) : kSerializer;
    }

    @InternalAPI
    public static final KSerializer<Object> guessSerializer(Object value, SerializersModule module) {
        KSerializer keySerializer;
        Intrinsics.checkNotNullParameter(module, "module");
        if (value == null) {
            keySerializer = BuiltinSerializersKt.getNullable(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE));
        } else if (value instanceof List) {
            keySerializer = BuiltinSerializersKt.ListSerializer(elementSerializer((Collection) value, module));
        } else if (value instanceof Object[]) {
            Object it = ArraysKt.firstOrNull((Object[]) value);
            if (it == null || (keySerializer = guessSerializer(it, module)) == null) {
                keySerializer = BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE));
            }
        } else if (value instanceof Set) {
            keySerializer = BuiltinSerializersKt.SetSerializer(elementSerializer((Collection) value, module));
        } else if (value instanceof Map) {
            KSerializer keySerializer2 = elementSerializer(((Map) value).keySet(), module);
            KSerializer valueSerializer = elementSerializer(((Map) value).values(), module);
            keySerializer = BuiltinSerializersKt.MapSerializer(keySerializer2, valueSerializer);
        } else {
            keySerializer = SerializersModule.getContextual$default(module, Reflection.getOrCreateKotlinClass(value.getClass()), (List) null, 2, (Object) null);
            if (keySerializer == null) {
                keySerializer = SerializersKt.serializer(Reflection.getOrCreateKotlinClass(value.getClass()));
            }
        }
        Intrinsics.checkNotNull(keySerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
        return keySerializer;
    }

    private static final KSerializer<?> elementSerializer(Collection<?> collection, SerializersModule module) {
        Object it;
        Iterable $this$map$iv = CollectionsKt.filterNotNull(collection);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(guessSerializer(item$iv$iv, module));
        }
        Iterable $this$distinctBy$iv = (List) destination$iv$iv;
        HashSet set$iv = new HashSet();
        ArrayList list$iv = new ArrayList();
        for (Object e$iv : $this$distinctBy$iv) {
            KSerializer it2 = (KSerializer) e$iv;
            if (set$iv.add(it2.getDescriptor().getSerialName())) {
                list$iv.add(e$iv);
            }
        }
        ArrayList serializers = list$iv;
        boolean z = true;
        if (serializers.size() > 1) {
            StringBuilder append = new StringBuilder().append("Serializing collections of different element types is not yet supported. Selected serializers: ");
            ArrayList $this$map$iv2 = serializers;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            for (Object item$iv$iv2 : $this$map$iv2) {
                KSerializer it3 = (KSerializer) item$iv$iv2;
                destination$iv$iv2.add(it3.getDescriptor().getSerialName());
            }
            throw new IllegalStateException(append.append((List) destination$iv$iv2).toString().toString());
        }
        KSerializer selected = (KSerializer) CollectionsKt.singleOrNull(serializers);
        if (selected == null) {
            selected = BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE);
        }
        if (selected.getDescriptor().isNullable()) {
            return selected;
        }
        Intrinsics.checkNotNull(selected, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
        Collection<?> $this$any$iv = collection;
        if (!($this$any$iv instanceof Collection) || !$this$any$iv.isEmpty()) {
            Iterator<T> it4 = $this$any$iv.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    z = false;
                    break;
                }
                Object element$iv = it4.next();
                if (element$iv == null) {
                    it = 1;
                    continue;
                } else {
                    it = null;
                    continue;
                }
                if (it != null) {
                    break;
                }
            }
        } else {
            z = false;
        }
        return z ? BuiltinSerializersKt.getNullable(selected) : selected;
    }
}