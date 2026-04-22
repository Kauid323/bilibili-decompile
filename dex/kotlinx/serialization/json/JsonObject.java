package kotlinx.serialization.json;

import j$.util.Map;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import kotlinx.serialization.json.internal.StringOpsKt;

/* compiled from: JsonElement.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u0000 !2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002:\u0001!B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0001H\u0096\u0001J\u0013\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0017\u001a\u00020\u0003H\u0096\u0003J\b\u0010\u001e\u001a\u00020\u000eH\u0016J\t\u0010\u001f\u001a\u00020\u0016H\u0096\u0001J\b\u0010 \u001a\u00020\u0003H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\b0\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0012\u0010\r\u001a\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0012X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lkotlinx/serialization/json/JsonObject;", "Lkotlinx/serialization/json/JsonElement;", "", "", "content", "(Ljava/util/Map;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "containsKey", "", "key", "containsValue", "value", "equals", "other", "", "get", "hashCode", "isEmpty", "toString", "Companion", "kotlinx-serialization-json"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable(with = JsonObjectSerializer.class)
public final class JsonObject extends JsonElement implements Map<String, JsonElement>, KMappedMarker, j$.util.Map {
    public static final Companion Companion = new Companion(null);
    private final Map<String, JsonElement> content;

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ JsonElement compute(String str, BiFunction<? super String, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: compute  reason: avoid collision after fix types in other method */
    public JsonElement compute2(String str, BiFunction<? super String, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ JsonElement computeIfAbsent(String str, Function<? super String, ? extends JsonElement> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: computeIfAbsent  reason: avoid collision after fix types in other method */
    public JsonElement computeIfAbsent2(String str, Function<? super String, ? extends JsonElement> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ JsonElement computeIfPresent(String str, BiFunction<? super String, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: computeIfPresent  reason: avoid collision after fix types in other method */
    public JsonElement computeIfPresent2(String str, BiFunction<? super String, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean containsKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.content.containsKey(key);
    }

    public boolean containsValue(JsonElement value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return this.content.containsValue(value);
    }

    @Override // java.util.Map
    public /* synthetic */ void forEach(BiConsumer<? super String, ? super JsonElement> biConsumer) {
        Map.-CC.$default$forEach(this, biConsumer);
    }

    public JsonElement get(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.content.get(key);
    }

    public Set<Map.Entry<String, JsonElement>> getEntries() {
        return this.content.entrySet();
    }

    public Set<String> getKeys() {
        return this.content.keySet();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.serialization.json.JsonElement, java.lang.Object] */
    @Override // java.util.Map
    public /* synthetic */ JsonElement getOrDefault(Object obj, JsonElement jsonElement) {
        return Map.-CC.$default$getOrDefault(this, obj, jsonElement);
    }

    public int getSize() {
        return this.content.size();
    }

    public Collection<JsonElement> getValues() {
        return this.content.values();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.content.isEmpty();
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ JsonElement merge(String str, JsonElement jsonElement, BiFunction<? super JsonElement, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: merge  reason: avoid collision after fix types in other method */
    public JsonElement merge2(String str, JsonElement jsonElement, BiFunction<? super JsonElement, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ JsonElement put(String str, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: put  reason: avoid collision after fix types in other method */
    public JsonElement put2(String str, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(java.util.Map<? extends String, ? extends JsonElement> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ JsonElement putIfAbsent(String str, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: putIfAbsent  reason: avoid collision after fix types in other method */
    public JsonElement putIfAbsent2(String str, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public JsonElement remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ JsonElement replace(String str, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: replace  reason: avoid collision after fix types in other method */
    public JsonElement replace2(String str, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ boolean replace(String str, JsonElement jsonElement, JsonElement jsonElement2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: replace  reason: avoid collision after fix types in other method */
    public boolean replace2(String str, JsonElement jsonElement, JsonElement jsonElement2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super String, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* compiled from: JsonElement.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lkotlinx/serialization/json/JsonObject$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonObject;", "kotlinx-serialization-json"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<JsonObject> serializer() {
            return JsonObjectSerializer.INSTANCE;
        }
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsKey(Object key) {
        if (key instanceof String) {
            return containsKey((String) key);
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object value) {
        if (value instanceof JsonElement) {
            return containsValue((JsonElement) value);
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<String, JsonElement>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ JsonElement get(Object key) {
        if (key instanceof String) {
            return get((String) key);
        }
        return null;
    }

    @Override // java.util.Map
    /* renamed from: get  reason: avoid collision after fix types in other method */
    public final /* bridge */ JsonElement get2(Object key) {
        if (key instanceof String) {
            return get((String) key);
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<JsonElement> values() {
        return getValues();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public JsonObject(java.util.Map<String, ? extends JsonElement> content) {
        super(null);
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
    }

    @Override // java.util.Map
    public boolean equals(Object other) {
        return Intrinsics.areEqual(this.content, other);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.content.hashCode();
    }

    public String toString() {
        return CollectionsKt.joinToString$default(this.content.entrySet(), ",", "{", "}", 0, null, new Function1<Map.Entry<? extends String, ? extends JsonElement>, CharSequence>() { // from class: kotlinx.serialization.json.JsonObject$toString$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends JsonElement> entry) {
                return invoke2((Map.Entry<String, ? extends JsonElement>) entry);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final CharSequence invoke2(Map.Entry<String, ? extends JsonElement> entry) {
                Intrinsics.checkNotNullParameter(entry, "<name for destructuring parameter 0>");
                String k = entry.getKey();
                JsonElement v = entry.getValue();
                StringBuilder $this$invoke_u24lambda_u240 = new StringBuilder();
                StringOpsKt.printQuoted($this$invoke_u24lambda_u240, k);
                $this$invoke_u24lambda_u240.append(AbstractJsonLexerKt.COLON);
                $this$invoke_u24lambda_u240.append(v);
                String sb = $this$invoke_u24lambda_u240.toString();
                Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().apply(builderAction).toString()");
                return sb;
            }
        }, 24, null);
    }
}