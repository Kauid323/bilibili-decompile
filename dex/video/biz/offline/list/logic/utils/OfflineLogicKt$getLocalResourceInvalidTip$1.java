package video.biz.offline.list.logic.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineLogic.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.utils.OfflineLogicKt", f = "OfflineLogic.kt", i = {0}, l = {PlayerToastConfig.QUEUE_REFRESH}, m = "getLocalResourceInvalidTip", n = {"videoEntity"}, s = {"L$0"}, v = 1)
public final class OfflineLogicKt$getLocalResourceInvalidTip$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfflineLogicKt$getLocalResourceInvalidTip$1(Continuation<? super OfflineLogicKt$getLocalResourceInvalidTip$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return OfflineLogicKt.getLocalResourceInvalidTip(null, (Continuation) this);
    }
}