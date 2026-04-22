package tv.danmaku.bili.ui.garb.api;

import android.util.ArrayMap;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: CollectionReporterHelper.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0010J1\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u0005¢\u0006\u0002\u0010\u001bJ1\u0010\u001c\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u0005¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Ltv/danmaku/bili/ui/garb/api/CollectionReporterHelper;", "", "<init>", "()V", "COLLECTION_ROOM_PV", "", "COLLECTION_ROOM_SETTING_CLICK", "COLLECTION_ROOM_SETTING_ITEM_CLICK", "COLLECTION_ROOM_SETTING_ALL_CLICK", "COLLECTION_ROOM_TOP_SHOW", "COLLECTION_ROOM_TOP_CLICK", "COLLECTION_ROOM_ALL_SHOW", "COLLECTION_ROOM_ALL_CLICK", "COLLECTION_ROOM_BOTTOM_SHOW", "COLLECTION_ROOM_BOTTOM_CLICK", "reportCollectionSettingClick", "", "reportCollectionSettingItemClick", "partId", "", "reportCollectionSettingAllClick", "reportCollectionTopClick", "id", "isMe", "", "index", "type", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "reportCollectionTopShow", "reportCollectionAllShow", "reportCollectionBottomClick", "reportCollectionBottomShow", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CollectionReporterHelper {
    public static final int $stable = 0;
    public static final String COLLECTION_ROOM_ALL_CLICK = "sqzz.dressing-collection.all.click";
    public static final String COLLECTION_ROOM_ALL_SHOW = "sqzz.dressing-collection.all.show";
    public static final String COLLECTION_ROOM_BOTTOM_CLICK = "sqzz.dressing-collection.bottom.click";
    public static final String COLLECTION_ROOM_BOTTOM_SHOW = "sqzz.dressing-collection.bottom.show";
    public static final String COLLECTION_ROOM_PV = "sqzz.dressing-collection.0.0.pv";
    public static final String COLLECTION_ROOM_SETTING_ALL_CLICK = "sqzz.dressing.collection.setting-all.click";
    public static final String COLLECTION_ROOM_SETTING_CLICK = "sqzz.dressing.collection.setting.click";
    public static final String COLLECTION_ROOM_SETTING_ITEM_CLICK = "sqzz.dressing.collection.setting-set.click";
    public static final String COLLECTION_ROOM_TOP_CLICK = "sqzz.dressing-collection.top.click";
    public static final String COLLECTION_ROOM_TOP_SHOW = "sqzz.dressing-collection.top.0.show";
    public static final CollectionReporterHelper INSTANCE = new CollectionReporterHelper();

    private CollectionReporterHelper() {
    }

    public final void reportCollectionSettingClick() {
        ArrayMap params = new ArrayMap();
        params.put("f_source", "collection");
        params.put("from", "collection_asset");
        Neurons.reportClick(false, COLLECTION_ROOM_SETTING_CLICK, params);
    }

    public static /* synthetic */ void reportCollectionSettingItemClick$default(CollectionReporterHelper collectionReporterHelper, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        collectionReporterHelper.reportCollectionSettingItemClick(i);
    }

    public final void reportCollectionSettingItemClick(int partId) {
        ArrayMap params = new ArrayMap();
        params.put("part_id", String.valueOf(partId));
        Neurons.reportClick(false, COLLECTION_ROOM_SETTING_ITEM_CLICK, params);
    }

    public final void reportCollectionSettingAllClick() {
        ArrayMap params = new ArrayMap();
        params.put("f_source", "collection");
        params.put("from", "collection_asset");
        Neurons.reportClick(false, COLLECTION_ROOM_SETTING_ALL_CLICK, params);
    }

    public final void reportCollectionTopClick(String id, Boolean isMe, String index, String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        ArrayMap params = new ArrayMap();
        if (id != null) {
            params.put("id", id);
        }
        if (isMe != null) {
            boolean it = isMe.booleanValue();
            params.put(AuthResultCbHelper.ARGS_STATE, it ? "1" : "2");
        }
        params.put("type", type);
        if (index != null) {
            params.put("num", index);
        }
        Neurons.reportClick(false, COLLECTION_ROOM_TOP_CLICK, params);
    }

    public final void reportCollectionTopShow(String id, Boolean isMe, String index, String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        ArrayMap params = new ArrayMap();
        if (id != null) {
            params.put("id", id);
        }
        if (isMe != null) {
            boolean it = isMe.booleanValue();
            params.put(AuthResultCbHelper.ARGS_STATE, it ? "1" : "2");
        }
        params.put("type", type);
        if (index != null) {
            params.put("num", index);
        }
        Neurons.reportExposure$default(false, COLLECTION_ROOM_TOP_SHOW, params, (List) null, 8, (Object) null);
    }

    public final void reportCollectionAllShow(String id, boolean isMe) {
        Intrinsics.checkNotNullParameter(id, "id");
        ArrayMap params = new ArrayMap();
        params.put("id", id);
        params.put(AuthResultCbHelper.ARGS_STATE, isMe ? "1" : "2");
        Neurons.reportExposure$default(false, COLLECTION_ROOM_ALL_SHOW, params, (List) null, 8, (Object) null);
    }

    public final void reportCollectionBottomClick(boolean isMe) {
        ArrayMap params = new ArrayMap();
        params.put(AuthResultCbHelper.ARGS_STATE, isMe ? "1" : "2");
        Neurons.reportClick(false, COLLECTION_ROOM_BOTTOM_CLICK, params);
    }

    public final void reportCollectionBottomShow(boolean isMe) {
        ArrayMap params = new ArrayMap();
        params.put(AuthResultCbHelper.ARGS_STATE, isMe ? "1" : "2");
        Neurons.reportExposure$default(false, COLLECTION_ROOM_BOTTOM_SHOW, params, (List) null, 8, (Object) null);
    }
}