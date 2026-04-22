package video.biz.offline.list.logic.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.wauth.WAuthErrorMsg;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineAuthApi.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.utils.OfflineAuthApiKt", f = "OfflineAuthApi.kt", i = {0, 0}, l = {69}, m = "tryAddAvAuthResult", n = {"cachePlayAvs", WAuthErrorMsg.ERROR_MESSAGE_REQUEST}, s = {"L$0", "L$1"}, v = 1)
public final class OfflineAuthApiKt$tryAddAvAuthResult$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfflineAuthApiKt$tryAddAvAuthResult$1(Continuation<? super OfflineAuthApiKt$tryAddAvAuthResult$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object tryAddAvAuthResult;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        tryAddAvAuthResult = OfflineAuthApiKt.tryAddAvAuthResult(null, (Continuation) this);
        return tryAddAvAuthResult;
    }
}