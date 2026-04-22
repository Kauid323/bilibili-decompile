package video.biz.offline.base.infra.model;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.model.VideoPlayInfo;
import video.common.resolver.model.DashMedia;

/* compiled from: DeprecatedIndexModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"update", "", "Lvideo/biz/offline/base/model/model/VideoPlayInfo;", "indexModel", "Lvideo/biz/offline/base/infra/model/DeprecatedIndexModel;", "infra_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DeprecatedIndexModelKt {
    public static final void update(VideoPlayInfo $this$update, DeprecatedIndexModel indexModel) {
        Intrinsics.checkNotNullParameter($this$update, "<this>");
        Intrinsics.checkNotNullParameter(indexModel, "indexModel");
        DashMedia it = (DashMedia) CollectionsKt.firstOrNull(indexModel.getVideo());
        if (it != null) {
            $this$update.setVideoId(it.getId());
            $this$update.setVideoMd5(it.getMd5());
            $this$update.setVideoCodecid(it.getCodecid());
            $this$update.setQn(it.getId());
        }
        DashMedia it2 = (DashMedia) CollectionsKt.firstOrNull(indexModel.getAudio());
        if (it2 != null) {
            $this$update.setAudioId(it2.getId());
            $this$update.setAudioMd5(it2.getMd5());
            $this$update.setAudioCodecid(it2.getCodecid());
        }
    }
}