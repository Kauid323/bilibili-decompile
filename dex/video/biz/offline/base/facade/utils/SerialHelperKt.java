package video.biz.offline.base.facade.utils;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.json.Json;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.LogKt;
import video.biz.offline.base.infra.utils.EntryScannerKt;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: SerialHelper.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¨\u0006\u0007"}, d2 = {"parseEntity", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "entityString", "", "parseEntityList", "", "entityListString", "facade_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SerialHelperKt {
    public static final OfflineVideoEntity parseEntity(String entityString) {
        String str = entityString;
        if (str == null || str.length() == 0) {
            LogKt.getVBLog().info("key is null or empty");
            return null;
        }
        try {
            Json this_$iv = EntryScannerKt.getOfflineJson();
            this_$iv.getSerializersModule();
            return (OfflineVideoEntity) this_$iv.decodeFromString(OfflineVideoEntity.Companion.serializer(), entityString);
        } catch (Exception e) {
            LogKt.getVBLog().error("parse entity error", e);
            return null;
        }
    }

    public static final List<OfflineVideoEntity> parseEntityList(String entityListString) {
        LogKt.getVBLog().info("parseEntityList: " + entityListString);
        String str = entityListString;
        if (str == null || str.length() == 0) {
            LogKt.getVBLog().info("entityList is null or empty");
            return CollectionsKt.emptyList();
        }
        try {
            Json this_$iv = EntryScannerKt.getOfflineJson();
            this_$iv.getSerializersModule();
            return (List) this_$iv.decodeFromString(new ArrayListSerializer(OfflineVideoEntity.Companion.serializer()), entityListString);
        } catch (Exception e) {
            LogKt.getVBLog().error("parse entity list error", e);
            return CollectionsKt.emptyList();
        }
    }
}