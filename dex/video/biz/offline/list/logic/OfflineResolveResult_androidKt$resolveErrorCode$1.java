package video.biz.offline.list.logic;

import com.bapis.bilibili.app.dynamic.v2.DynModuleType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineResolveResult.android.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.OfflineResolveResult_androidKt", f = "OfflineResolveResult.android.kt", i = {0}, l = {DynModuleType.module_author_for_subscribe_VALUE}, m = "resolveErrorCode", n = {"videoEntity"}, s = {"L$0"}, v = 1)
public final class OfflineResolveResult_androidKt$resolveErrorCode$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfflineResolveResult_androidKt$resolveErrorCode$1(Continuation<? super OfflineResolveResult_androidKt$resolveErrorCode$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return OfflineResolveResult_androidKt.resolveErrorCode(null, (Continuation) this);
    }
}