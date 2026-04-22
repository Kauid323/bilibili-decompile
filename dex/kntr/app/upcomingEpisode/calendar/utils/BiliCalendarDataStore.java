package kntr.app.upcomingEpisode.calendar.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* compiled from: BiliCalendarDataStore.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\b\n\u0002\u0010\u001f\n\u0002\b\u0003\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B@\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0003H\u0096\u0001J\u0016\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0012H\u0096\u0001J \u0010\u0017\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u00102\u0014\u0010\u001a\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u001bH\u0096\u0001J\u0018\u0010\u001c\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\u0003H\u0096\u0001¢\u0006\u0002\u0010\u000eR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u001f0\u001eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b \u0010!R\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b#\u0010!R\u0012\u0010$\u001a\u00020\u0003X\u0096\u0005¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0018\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000(X\u0096\u0005¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lkntr/app/upcomingEpisode/calendar/utils/BiliCalendarDataStore;", "V", "", "", "store", "create", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "offset", "<init>", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "get", "key", "(I)Ljava/lang/Object;", "clear", "", "containsKey", "", "containsValue", "value", "(Ljava/lang/Object;)Z", "isEmpty", "put", "(ILjava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "", "remove", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "size", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BiliCalendarDataStore<V> implements Map<Integer, V>, KMutableMap {
    public static final int $stable = 8;
    private final Function1<Integer, V> create;
    private final Map<Integer, V> store;

    @Override // java.util.Map
    public void clear() {
        this.store.clear();
    }

    public boolean containsKey(int i) {
        return this.store.containsKey(Integer.valueOf(i));
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.store.containsValue(obj);
    }

    public Set<Map.Entry<Integer, V>> getEntries() {
        return this.store.entrySet();
    }

    public Set<Integer> getKeys() {
        return this.store.keySet();
    }

    public int getSize() {
        return this.store.size();
    }

    public Collection<V> getValues() {
        return this.store.values();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.store.isEmpty();
    }

    public V put(int i, V v) {
        return this.store.put(Integer.valueOf(i), v);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Integer, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "from");
        this.store.putAll(map);
    }

    public V remove(int i) {
        return this.store.remove(Integer.valueOf(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BiliCalendarDataStore(Map<Integer, V> map, Function1<? super Integer, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(map, "store");
        Intrinsics.checkNotNullParameter(function1, "create");
        this.store = map;
        this.create = function1;
    }

    public /* synthetic */ BiliCalendarDataStore(HashMap hashMap, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new HashMap() : hashMap, function1);
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsKey(Object key) {
        if (key instanceof Integer) {
            return containsKey(((Number) key).intValue());
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<Integer, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final /* bridge */ V get(Object key) {
        if (key instanceof Integer) {
            return get(((Number) key).intValue());
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Integer> keySet() {
        return getKeys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(Integer num, Object value) {
        return put(num.intValue(), (int) value);
    }

    @Override // java.util.Map
    public final /* bridge */ V remove(Object key) {
        if (key instanceof Integer) {
            return remove(((Number) key).intValue());
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public V get(int key) {
        V v = this.store.get(Integer.valueOf(key));
        if (v == null) {
            V v2 = (V) this.create.invoke(Integer.valueOf(key));
            put(key, (int) v2);
            return v2;
        }
        return v;
    }
}