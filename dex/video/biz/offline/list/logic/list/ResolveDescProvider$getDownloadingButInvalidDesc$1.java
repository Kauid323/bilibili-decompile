package video.biz.offline.list.logic.list;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineResolveDataProvider.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.list.ResolveDescProvider", f = "OfflineResolveDataProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {89, 90}, m = "getDownloadingButInvalidDesc", n = {"videoEntity", "validateCode", "$this$getDownloadingButInvalidDesc_u24lambda_u240", "$i$a$-buildString-ResolveDescProvider$getDownloadingButInvalidDesc$2", "videoEntity", "validateCode", "$this$getDownloadingButInvalidDesc_u24lambda_u240", "$i$a$-buildString-ResolveDescProvider$getDownloadingButInvalidDesc$2"}, s = {"L$0", "L$1", "L$3", "I$0", "L$0", "L$1", "L$3", "I$0"}, v = 1)
public final class ResolveDescProvider$getDownloadingButInvalidDesc$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ResolveDescProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResolveDescProvider$getDownloadingButInvalidDesc$1(ResolveDescProvider resolveDescProvider, Continuation<? super ResolveDescProvider$getDownloadingButInvalidDesc$1> continuation) {
        super(continuation);
        this.this$0 = resolveDescProvider;
    }

    public final Object invokeSuspend(Object obj) {
        Object downloadingButInvalidDesc;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        downloadingButInvalidDesc = this.this$0.getDownloadingButInvalidDesc(null, null, (Continuation) this);
        return downloadingButInvalidDesc;
    }
}