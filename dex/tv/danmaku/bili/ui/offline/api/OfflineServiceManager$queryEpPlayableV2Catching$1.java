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
@DebugMetadata(c = "tv.danmaku.bili.ui.offline.api.OfflineServiceManager", f = "OfflineServiceManager.kt", i = {}, l = {98}, m = "queryEpPlayableV2Catching-gIAlu-s", n = {}, s = {}, v = 1)
public final class OfflineServiceManager$queryEpPlayableV2Catching$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfflineServiceManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineServiceManager$queryEpPlayableV2Catching$1(OfflineServiceManager offlineServiceManager, Continuation<? super OfflineServiceManager$queryEpPlayableV2Catching$1> continuation) {
        super(continuation);
        this.this$0 = offlineServiceManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m1374queryEpPlayableV2CatchinggIAlus = this.this$0.m1374queryEpPlayableV2CatchinggIAlus(null, (Continuation) this);
        return m1374queryEpPlayableV2CatchinggIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m1374queryEpPlayableV2CatchinggIAlus : Result.box-impl(m1374queryEpPlayableV2CatchinggIAlus);
    }
}