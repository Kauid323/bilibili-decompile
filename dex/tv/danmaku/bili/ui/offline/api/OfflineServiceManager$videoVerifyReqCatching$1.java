package tv.danmaku.bili.ui.offline.api;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineServiceManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.offline.api.OfflineServiceManager", f = "OfflineServiceManager.kt", i = {}, l = {34}, m = "videoVerifyReqCatching-0E7RQCE", n = {}, s = {}, v = 1)
public final class OfflineServiceManager$videoVerifyReqCatching$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfflineServiceManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineServiceManager$videoVerifyReqCatching$1(OfflineServiceManager offlineServiceManager, Continuation<? super OfflineServiceManager$videoVerifyReqCatching$1> continuation) {
        super(continuation);
        this.this$0 = offlineServiceManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m1375videoVerifyReqCatching0E7RQCE = this.this$0.m1375videoVerifyReqCatching0E7RQCE(null, 0, (Continuation) this);
        return m1375videoVerifyReqCatching0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m1375videoVerifyReqCatching0E7RQCE : Result.box-impl(m1375videoVerifyReqCatching0E7RQCE);
    }
}