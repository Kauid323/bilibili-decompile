package video.biz.offline.base.infra.migrate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.utils.DataLog;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: MigrationValidateHelper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0006"}, d2 = {"validateVideos", "", "cachedVideos", "", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "dbVideoRecords", "infra_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MigrationValidateHelperKt {
    public static final boolean validateVideos(List<OfflineVideoEntity> list, List<OfflineVideoEntity> list2) {
        Intrinsics.checkNotNullParameter(list, "cachedVideos");
        Intrinsics.checkNotNullParameter(list2, "dbVideoRecords");
        DataLog dataLog = new DataLog();
        int size = list.size();
        dataLog.info("validateVideos, cachedVideos size: " + size + ", dbVideoRecords size: " + list2.size());
        if (list.size() != list2.size()) {
            DataLog dataLog2 = new DataLog();
            int size2 = list.size();
            dataLog2.error("DB and cached videos size not match, cachedVideos size: " + size2 + ", dbVideoRecords size: " + list2.size());
            return false;
        }
        List<OfflineVideoEntity> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            OfflineVideoEntity it = (OfflineVideoEntity) item$iv$iv;
            destination$iv$iv.add(new VideoEntityKeyProperty(it.getKey()));
        }
        Set cachedSet = CollectionsKt.toSet((List) destination$iv$iv);
        List<OfflineVideoEntity> $this$map$iv2 = list2;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            OfflineVideoEntity it2 = (OfflineVideoEntity) item$iv$iv2;
            destination$iv$iv2.add(new VideoEntityKeyProperty(it2.getKey()));
        }
        Set dbSet = CollectionsKt.toSet((List) destination$iv$iv2);
        if (!Intrinsics.areEqual(cachedSet, dbSet)) {
            new DataLog().error("DB and cached videos are inconsistent");
            return false;
        }
        return true;
    }
}