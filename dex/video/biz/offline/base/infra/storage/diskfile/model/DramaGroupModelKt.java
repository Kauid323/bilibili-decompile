package video.biz.offline.base.infra.storage.diskfile.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: DramaGroupModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"convert2DramaItem", "Lvideo/biz/offline/base/infra/storage/diskfile/model/DramaItemModel;", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "infra_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DramaGroupModelKt {
    public static final DramaItemModel convert2DramaItem(OfflineVideoEntity $this$convert2DramaItem) {
        Intrinsics.checkNotNullParameter($this$convert2DramaItem, "<this>");
        return new DramaItemModel($this$convert2DramaItem.getAid(), $this$convert2DramaItem.getCid(), $this$convert2DramaItem.getVideoTitle(), $this$convert2DramaItem.getVideoIndex(), $this$convert2DramaItem.getPageIndex());
    }
}