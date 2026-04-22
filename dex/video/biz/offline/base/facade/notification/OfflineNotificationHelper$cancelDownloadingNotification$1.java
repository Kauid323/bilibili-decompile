package video.biz.offline.base.facade.notification;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineNotificationHelper.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.facade.notification.OfflineNotificationHelper", f = "OfflineNotificationHelper.kt", i = {}, l = {100, 101}, m = "cancelDownloadingNotification", n = {}, s = {}, v = 1)
public final class OfflineNotificationHelper$cancelDownloadingNotification$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfflineNotificationHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineNotificationHelper$cancelDownloadingNotification$1(OfflineNotificationHelper offlineNotificationHelper, Continuation<? super OfflineNotificationHelper$cancelDownloadingNotification$1> continuation) {
        super(continuation);
        this.this$0 = offlineNotificationHelper;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.cancelDownloadingNotification((Continuation) this);
    }
}