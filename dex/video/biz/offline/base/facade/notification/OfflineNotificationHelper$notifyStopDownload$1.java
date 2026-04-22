package video.biz.offline.base.facade.notification;

import android.app.NotificationManager;
import androidx.collection.ArrayMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.LogKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineNotificationHelper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.facade.notification.OfflineNotificationHelper$notifyStopDownload$1", f = "OfflineNotificationHelper.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineNotificationHelper$notifyStopDownload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $keys;
    final /* synthetic */ boolean $removeCompletedNotification;
    int label;
    final /* synthetic */ OfflineNotificationHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineNotificationHelper$notifyStopDownload$1(boolean z, OfflineNotificationHelper offlineNotificationHelper, List<String> list, Continuation<? super OfflineNotificationHelper$notifyStopDownload$1> continuation) {
        super(2, continuation);
        this.$removeCompletedNotification = z;
        this.this$0 = offlineNotificationHelper;
        this.$keys = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflineNotificationHelper$notifyStopDownload$1(this.$removeCompletedNotification, this.this$0, this.$keys, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object safeAccessCompletedNotificationMap;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$removeCompletedNotification) {
                    OfflineNotificationHelper offlineNotificationHelper = this.this$0;
                    final List<String> list = this.$keys;
                    final OfflineNotificationHelper offlineNotificationHelper2 = this.this$0;
                    this.label = 1;
                    safeAccessCompletedNotificationMap = offlineNotificationHelper.safeAccessCompletedNotificationMap(new Function1() { // from class: video.biz.offline.base.facade.notification.OfflineNotificationHelper$notifyStopDownload$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            Unit invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = OfflineNotificationHelper$notifyStopDownload$1.invokeSuspend$lambda$0(list, offlineNotificationHelper2, (ArrayMap) obj);
                            return invokeSuspend$lambda$0;
                        }
                    }, (Continuation) this);
                    if (safeAccessCompletedNotificationMap == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(List $keys, OfflineNotificationHelper this$0, ArrayMap map) {
        NotificationManager notificationManager;
        List $this$forEach$iv = $keys;
        for (Object element$iv : $this$forEach$iv) {
            String key = (String) element$iv;
            Integer num = (Integer) map.remove(key);
            if (num != null) {
                int it = num.intValue();
                LogKt.getVBLog().info("OfflineNotificationHelper cancel completed notification: " + key + " id=" + it);
                notificationManager = this$0.getNotificationManager();
                if (notificationManager != null) {
                    notificationManager.cancel(it);
                }
            }
        }
        return Unit.INSTANCE;
    }
}