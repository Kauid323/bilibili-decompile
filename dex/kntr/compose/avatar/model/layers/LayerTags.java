package kntr.compose.avatar.model.layers;

import com.bapis.bilibili.dagw.component.avatar.v1.KLayerTagConfig;
import java.util.LinkedHashMap;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Configs.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u00002\u00020\u0001B-\u0012$\b\u0002\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0086\u0002¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\f\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0013J\u0013\u0010\u001d\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0004HÖ\u0001R*\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006X\u0080\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u001b\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016\u0088\u0001\u0002\u0092\u0001\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006¨\u0006\""}, d2 = {"Lkntr/compose/avatar/model/layers/LayerTags;", "", "map", "Ljava/util/LinkedHashMap;", "", "Lcom/bapis/bilibili/dagw/component/avatar/v1/KLayerTagConfig;", "Lkotlin/collections/LinkedHashMap;", "constructor-impl", "(Ljava/util/LinkedHashMap;)Ljava/util/LinkedHashMap;", "get", "key", "Lkntr/compose/avatar/model/layers/ConfigKey;", "get-impl", "(Ljava/util/LinkedHashMap;Lkntr/compose/avatar/model/layers/ConfigKey;)Lcom/bapis/bilibili/dagw/component/avatar/v1/KLayerTagConfig;", "(Ljava/util/LinkedHashMap;Ljava/lang/String;)Lcom/bapis/bilibili/dagw/component/avatar/v1/KLayerTagConfig;", "containsKey", "", "containsKey-impl", "(Ljava/util/LinkedHashMap;Lkntr/compose/avatar/model/layers/ConfigKey;)Z", "(Ljava/util/LinkedHashMap;Ljava/lang/String;)Z", "isBackground", "isBackground-impl", "(Ljava/util/LinkedHashMap;)Z", "isAvatar", "isAvatar-impl", "isPendant", "isPendant-impl", "isIcon", "isIcon-impl", "equals", "other", "hashCode", "", "toString", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@JvmInline
public final class LayerTags {
    private final LinkedHashMap<String, KLayerTagConfig> map;

    /* renamed from: box-impl */
    public static final /* synthetic */ LayerTags m2543boximpl(LinkedHashMap linkedHashMap) {
        return new LayerTags(linkedHashMap);
    }

    /* renamed from: constructor-impl */
    public static LinkedHashMap<String, KLayerTagConfig> m2544constructorimpl(LinkedHashMap<String, KLayerTagConfig> linkedHashMap) {
        Intrinsics.checkNotNullParameter(linkedHashMap, "map");
        return linkedHashMap;
    }

    /* renamed from: equals-impl */
    public static boolean m2548equalsimpl(LinkedHashMap<String, KLayerTagConfig> linkedHashMap, Object obj) {
        return (obj instanceof LayerTags) && Intrinsics.areEqual(linkedHashMap, ((LayerTags) obj).m2558unboximpl());
    }

    /* renamed from: equals-impl0 */
    public static final boolean m2549equalsimpl0(LinkedHashMap<String, KLayerTagConfig> linkedHashMap, LinkedHashMap<String, KLayerTagConfig> linkedHashMap2) {
        return Intrinsics.areEqual(linkedHashMap, linkedHashMap2);
    }

    /* renamed from: hashCode-impl */
    public static int m2552hashCodeimpl(LinkedHashMap<String, KLayerTagConfig> linkedHashMap) {
        return linkedHashMap.hashCode();
    }

    /* renamed from: toString-impl */
    public static String m2557toStringimpl(LinkedHashMap<String, KLayerTagConfig> linkedHashMap) {
        return "LayerTags(map=" + linkedHashMap + ")";
    }

    public boolean equals(Object obj) {
        return m2548equalsimpl(this.map, obj);
    }

    public int hashCode() {
        return m2552hashCodeimpl(this.map);
    }

    public String toString() {
        return m2557toStringimpl(this.map);
    }

    /* renamed from: unbox-impl */
    public final /* synthetic */ LinkedHashMap m2558unboximpl() {
        return this.map;
    }

    private /* synthetic */ LayerTags(LinkedHashMap map) {
        this.map = map;
    }

    /* renamed from: constructor-impl$default */
    public static /* synthetic */ LinkedHashMap m2545constructorimpl$default(LinkedHashMap linkedHashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            linkedHashMap = new LinkedHashMap();
        }
        return m2544constructorimpl(linkedHashMap);
    }

    /* renamed from: get-impl */
    public static final KLayerTagConfig m2551getimpl(LinkedHashMap<String, KLayerTagConfig> linkedHashMap, ConfigKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return linkedHashMap.get(key.getKey());
    }

    /* renamed from: get-impl */
    public static final KLayerTagConfig m2550getimpl(LinkedHashMap<String, KLayerTagConfig> linkedHashMap, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return linkedHashMap.get(key);
    }

    /* renamed from: containsKey-impl */
    public static final boolean m2547containsKeyimpl(LinkedHashMap<String, KLayerTagConfig> linkedHashMap, ConfigKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return linkedHashMap.containsKey(key.getKey());
    }

    /* renamed from: containsKey-impl */
    public static final boolean m2546containsKeyimpl(LinkedHashMap<String, KLayerTagConfig> linkedHashMap, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return linkedHashMap.containsKey(key);
    }

    /* renamed from: isBackground-impl */
    public static final boolean m2554isBackgroundimpl(LinkedHashMap<String, KLayerTagConfig> linkedHashMap) {
        return m2547containsKeyimpl(linkedHashMap, ConfigKey.Background);
    }

    /* renamed from: isAvatar-impl */
    public static final boolean m2553isAvatarimpl(LinkedHashMap<String, KLayerTagConfig> linkedHashMap) {
        return m2547containsKeyimpl(linkedHashMap, ConfigKey.Avatar);
    }

    /* renamed from: isPendant-impl */
    public static final boolean m2556isPendantimpl(LinkedHashMap<String, KLayerTagConfig> linkedHashMap) {
        return m2547containsKeyimpl(linkedHashMap, ConfigKey.Pendant);
    }

    /* renamed from: isIcon-impl */
    public static final boolean m2555isIconimpl(LinkedHashMap<String, KLayerTagConfig> linkedHashMap) {
        return m2547containsKeyimpl(linkedHashMap, ConfigKey.Icon);
    }
}