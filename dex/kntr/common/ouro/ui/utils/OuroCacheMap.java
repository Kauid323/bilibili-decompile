package kntr.common.ouro.ui.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnotatedStringUtils.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B3\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\t\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\f¢\u0006\u0002\u0010\rJ\u0006\u0010\u000e\u001a\u00020\u000fR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/common/ouro/ui/utils/OuroCacheMap;", "K", "V", "", "oldValueMap", "", "newValueMap", "<init>", "(Ljava/util/Map;Ljava/util/Map;)V", "getOrPut", "key", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "update", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroCacheMap<K, V> {
    public static final int $stable = 8;
    private Map<K, V> newValueMap;
    private Map<K, V> oldValueMap;

    public OuroCacheMap() {
        this(null, null, 3, null);
    }

    public OuroCacheMap(Map<K, V> map, Map<K, V> map2) {
        Intrinsics.checkNotNullParameter(map, "oldValueMap");
        Intrinsics.checkNotNullParameter(map2, "newValueMap");
        this.oldValueMap = map;
        this.newValueMap = map2;
    }

    public /* synthetic */ OuroCacheMap(LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new LinkedHashMap() : linkedHashMap, (i & 2) != 0 ? new LinkedHashMap() : linkedHashMap2);
    }

    public final V getOrPut(K k, Function0<? extends V> function0) {
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        V v = this.oldValueMap.get(k);
        if (v == null) {
            V v2 = (V) function0.invoke();
            this.newValueMap.put(k, v2);
            return v2;
        }
        this.newValueMap.put(k, v);
        return v;
    }

    public final void update() {
        this.oldValueMap = this.newValueMap;
        this.newValueMap = new LinkedHashMap();
    }
}