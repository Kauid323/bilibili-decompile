package video.biz.offline.base.facade.client;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.facade.IOfflineFacade;

/* compiled from: VideoDownloadClientV2.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"client", "Lvideo/biz/offline/base/facade/IOfflineFacade;", "getClient", "()Lvideo/biz/offline/base/facade/IOfflineFacade;", "client$delegate", "Lkotlin/Lazy;", "BIND_SERVICE_TIMEOUT", "", "BIND_MAX_RETRY_LIMIT", "facade_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VideoDownloadClientV2Kt {
    private static final int BIND_MAX_RETRY_LIMIT = 5;
    private static final int BIND_SERVICE_TIMEOUT = 20;
    private static final Lazy client$delegate = LazyKt.lazy(new Function0() { // from class: video.biz.offline.base.facade.client.VideoDownloadClientV2Kt$$ExternalSyntheticLambda0
        public final Object invoke() {
            VideoDownloadClientV2 client_delegate$lambda$0;
            client_delegate$lambda$0 = VideoDownloadClientV2Kt.client_delegate$lambda$0();
            return client_delegate$lambda$0;
        }
    });

    public static final IOfflineFacade getClient() {
        return (IOfflineFacade) client$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoDownloadClientV2 client_delegate$lambda$0() {
        return new VideoDownloadClientV2();
    }
}