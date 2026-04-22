package video.biz.offline.list.logic.list;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineResolveDataProvider.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.list.ResolveDescProvider", f = "OfflineResolveDataProvider.kt", i = {0, 0, 0, 1, 1, 1}, l = {130, 131}, m = "getDamageCannotRetryDesc", n = {"videoEntity", "$this$getDamageCannotRetryDesc_u24lambda_u240", "$i$a$-buildString-ResolveDescProvider$getDamageCannotRetryDesc$2", "videoEntity", "$this$getDamageCannotRetryDesc_u24lambda_u240", "$i$a$-buildString-ResolveDescProvider$getDamageCannotRetryDesc$2"}, s = {"L$0", "L$2", "I$0", "L$0", "L$2", "I$0"}, v = 1)
public final class ResolveDescProvider$getDamageCannotRetryDesc$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ResolveDescProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResolveDescProvider$getDamageCannotRetryDesc$1(ResolveDescProvider resolveDescProvider, Continuation<? super ResolveDescProvider$getDamageCannotRetryDesc$1> continuation) {
        super(continuation);
        this.this$0 = resolveDescProvider;
    }

    public final Object invokeSuspend(Object obj) {
        Object damageCannotRetryDesc;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        damageCannotRetryDesc = this.this$0.getDamageCannotRetryDesc(null, (Continuation) this);
        return damageCannotRetryDesc;
    }
}