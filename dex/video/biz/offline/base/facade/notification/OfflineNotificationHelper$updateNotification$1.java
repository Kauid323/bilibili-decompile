package video.biz.offline.base.facade.notification;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineNotificationHelper.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.facade.notification.OfflineNotificationHelper", f = "OfflineNotificationHelper.kt", i = {0, 0}, l = {143}, m = "updateNotification", n = {"entity", "completed"}, s = {"L$0", "L$1"}, v = 1)
public final class OfflineNotificationHelper$updateNotification$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfflineNotificationHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineNotificationHelper$updateNotification$1(OfflineNotificationHelper offlineNotificationHelper, Continuation<? super OfflineNotificationHelper$updateNotification$1> continuation) {
        super(continuation);
        this.this$0 = offlineNotificationHelper;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateNotification(null, (Continuation) this);
    }
}