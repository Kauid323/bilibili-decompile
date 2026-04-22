package video.biz.offline.base.facade;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.facade.client.VideoDownloadClientV2Kt;

/* compiled from: OfflineFacadeImpl.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001c\u0010\u0000\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"OfflineFacadeImpl", "Lvideo/biz/offline/base/facade/IOfflineFacade;", "getOfflineFacadeImpl$annotations", "()V", "getOfflineFacadeImpl", "()Lvideo/biz/offline/base/facade/IOfflineFacade;", "facade_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineFacadeImpl_androidKt {
    private static final IOfflineFacade OfflineFacadeImpl = VideoDownloadClientV2Kt.getClient();

    public static /* synthetic */ void getOfflineFacadeImpl$annotations() {
    }

    public static final IOfflineFacade getOfflineFacadeImpl() {
        return OfflineFacadeImpl;
    }
}