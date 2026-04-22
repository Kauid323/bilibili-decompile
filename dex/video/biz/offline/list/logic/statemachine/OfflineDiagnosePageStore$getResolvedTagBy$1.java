package video.biz.offline.list.logic.statemachine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineDiagnosePageStore.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineDiagnosePageStore", f = "OfflineDiagnosePageStore.kt", i = {0}, l = {132}, m = "getResolvedTagBy", n = {"videoEntity"}, s = {"L$0"}, v = 1)
public final class OfflineDiagnosePageStore$getResolvedTagBy$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfflineDiagnosePageStore this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineDiagnosePageStore$getResolvedTagBy$1(OfflineDiagnosePageStore offlineDiagnosePageStore, Continuation<? super OfflineDiagnosePageStore$getResolvedTagBy$1> continuation) {
        super(continuation);
        this.this$0 = offlineDiagnosePageStore;
    }

    public final Object invokeSuspend(Object obj) {
        Object resolvedTagBy;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        resolvedTagBy = this.this$0.getResolvedTagBy(null, (Continuation) this);
        return resolvedTagBy;
    }
}