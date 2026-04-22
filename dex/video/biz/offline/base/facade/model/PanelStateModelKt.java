package video.biz.offline.base.facade.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: PanelStateModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"convert2PanelModel", "Lvideo/biz/offline/base/facade/model/PanelStateModel;", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "facade_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PanelStateModelKt {
    public static final PanelStateModel convert2PanelModel(OfflineVideoEntity $this$convert2PanelModel) {
        Intrinsics.checkNotNullParameter($this$convert2PanelModel, "<this>");
        return new PanelStateModel($this$convert2PanelModel.getVideoId(), $this$convert2PanelModel.getPageId(), $this$convert2PanelModel.getState());
    }
}