package io.ktor.util.collections;

import com.bilibili.playset.playlist.helper.ReportHelper;
import j$.util.Map;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.concurrent.ConcurrentMap;
import j$.util.function.Function;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* compiled from: ConcurrentMapJvm.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000b\u001a\u00028\u00012\u0006\u0010\b\u001a\u00028\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u001a\u0010\u0012\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0019\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001d\u001a\u00020\u00162\u0014\u0010\u001c\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u001f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001f\u0010\u0013J\u001f\u0010\u001f\u001a\u00020\r2\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010#H\u0096\u0002¢\u0006\u0004\b%\u0010\u000fJ\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(R \u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\"R&\u00102\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010/0.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00101R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00028\u0001058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107¨\u00069"}, d2 = {"Lio/ktor/util/collections/ConcurrentMap;", "Key", "Value", "", "", "initialCapacity", "<init>", "(I)V", "key", "Lkotlin/Function0;", "block", "computeIfAbsent", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "", "containsKey", "(Ljava/lang/Object;)Z", "value", "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "()Z", "", ReportHelper.EventValue.REPORT_EVENT_VALUE_CLEAR_INVALID_CLEAR, "()V", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "", "from", "putAll", "(Ljava/util/Map;)V", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "hashCode", "()I", "", "other", "equals", "", "toString", "()Ljava/lang/String;", "j$/util/concurrent/ConcurrentHashMap", "delegate", "Lj$/util/concurrent/ConcurrentHashMap;", "getSize", "size", "", "", "getEntries", "()Ljava/util/Set;", "entries", "getKeys", "keys", "", "getValues", "()Ljava/util/Collection;", "values", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ConcurrentMap<Key, Value> implements Map<Key, Value>, KMutableMap, j$.util.Map {
    private final ConcurrentHashMap<Key, Value> delegate;

    public ConcurrentMap() {
        this(0, 1, null);
    }

    @Override // java.util.Map
    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return Map.-CC.$default$compute(this, obj, biFunction);
    }

    @Override // java.util.Map
    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return Map.-CC.$default$computeIfAbsent(this, obj, function);
    }

    @Override // java.util.Map
    public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return Map.-CC.$default$computeIfPresent(this, obj, biFunction);
    }

    @Override // java.util.Map
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.-CC.$default$forEach(this, biConsumer);
    }

    @Override // java.util.Map
    public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return Map.-CC.$default$getOrDefault(this, obj, obj2);
    }

    @Override // java.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.-CC.$default$merge(this, obj, obj2, biFunction);
    }

    @Override // java.util.Map
    public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return Map.-CC.$default$putIfAbsent(this, obj, obj2);
    }

    @Override // java.util.Map
    public /* synthetic */ Object replace(Object obj, Object obj2) {
        return Map.-CC.$default$replace(this, obj, obj2);
    }

    @Override // java.util.Map
    public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        return Map.-CC.$default$replace(this, obj, obj2, obj3);
    }

    @Override // java.util.Map
    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        Map.-CC.$default$replaceAll(this, biFunction);
    }

    public ConcurrentMap(int initialCapacity) {
        this.delegate = new ConcurrentHashMap<>(initialCapacity);
    }

    public /* synthetic */ ConcurrentMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 32 : i);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<Key, Value>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Key> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<Value> values() {
        return getValues();
    }

    public final Value computeIfAbsent(Key key, final Function0<? extends Value> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        ConcurrentHashMap<Key, Value> concurrentHashMap = this.delegate;
        final Function1 function1 = new Function1() { // from class: io.ktor.util.collections.ConcurrentMap$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Object invoke;
                invoke = function0.invoke();
                return invoke;
            }
        };
        return (Value) ConcurrentMap.-EL.computeIfAbsent(concurrentHashMap, key, new Function() { // from class: io.ktor.util.collections.ConcurrentMap$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function.-CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Object invoke;
                invoke = function1.invoke(obj);
                return invoke;
            }

            @Override // java.util.function.Function
            public /* synthetic */ java.util.function.Function compose(java.util.function.Function function) {
                return Function.-CC.$default$compose(this, function);
            }
        });
    }

    public int getSize() {
        return this.delegate.size();
    }

    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return this.delegate.containsKey(key);
    }

    @Override // java.util.Map
    public boolean containsValue(Object value) {
        return this.delegate.containsValue(value);
    }

    @Override // java.util.Map
    public Value get(Object key) {
        return (Value) this.delegate.get(key);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    public Set<Map.Entry<Key, Value>> getEntries() {
        Set<Map.Entry<Key, Value>> entrySet = this.delegate.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "<get-entries>(...)");
        return entrySet;
    }

    public Set<Key> getKeys() {
        Set<Key> keySet = this.delegate.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
        return keySet;
    }

    public Collection<Value> getValues() {
        Collection<Value> values = this.delegate.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        return values;
    }

    @Override // java.util.Map
    public void clear() {
        this.delegate.clear();
    }

    @Override // java.util.Map
    public Value put(Key key, Value value) {
        return (Value) this.delegate.put(key, value);
    }

    @Override // java.util.Map
    public void putAll(java.util.Map<? extends Key, ? extends Value> map) {
        Intrinsics.checkNotNullParameter(map, "from");
        this.delegate.putAll(map);
    }

    @Override // java.util.Map
    public Value remove(Object key) {
        return (Value) this.delegate.remove(key);
    }

    @Override // java.util.Map
    public boolean remove(Object key, Object value) {
        return this.delegate.remove(key, value);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.delegate.hashCode();
    }

    @Override // java.util.Map
    public boolean equals(Object other) {
        if (other instanceof java.util.Map) {
            return Intrinsics.areEqual(other, this.delegate);
        }
        return false;
    }

    public String toString() {
        return "ConcurrentMapJvm by " + this.delegate;
    }
}