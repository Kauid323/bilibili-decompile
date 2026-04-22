package video.biz.offline.list.logic.list;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineResolveDataProvider.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.list.OfflineResolveDataProviderKt", f = "OfflineResolveDataProvider.kt", i = {0}, l = {416}, m = "isNotInDB", n = {"$this$isNotInDB"}, s = {"L$0"}, v = 1)
public final class OfflineResolveDataProviderKt$isNotInDB$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfflineResolveDataProviderKt$isNotInDB$1(Continuation<? super OfflineResolveDataProviderKt$isNotInDB$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return OfflineResolveDataProviderKt.isNotInDB(null, (Continuation) this);
    }
}