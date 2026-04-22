package video.biz.offline.base.infra.download;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.common.resolver.model.VodInfo;

/* compiled from: DownloadProgressCallback.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH&J$\u0010\r\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000e\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0006H&J\u0016\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0014¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lvideo/biz/offline/base/infra/download/DownloadProgressCallback;", "", "addDownload", "", "videos", "", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "playViewDidResolved", "entity", "vodInfo", "Lvideo/common/resolver/model/VodInfo;", IjkMediaPlayer.OnNativeInvokeListener.ARG_QN, "", "updateVideo", "force", "", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadComplete", "video", "downloadError", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface DownloadProgressCallback {
    void addDownload(List<OfflineVideoEntity> list);

    void downloadComplete(OfflineVideoEntity offlineVideoEntity);

    Object downloadError(OfflineVideoEntity offlineVideoEntity, Continuation<? super Unit> continuation);

    void playViewDidResolved(OfflineVideoEntity offlineVideoEntity, VodInfo vodInfo, int i);

    Object updateVideo(List<OfflineVideoEntity> list, boolean z, Continuation<? super Unit> continuation);
}