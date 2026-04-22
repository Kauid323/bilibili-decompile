package im.session.service;

import com.tencent.smtt.sdk.TbsListener;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMMessageSummaryService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.service.IMSummaryCacheService", f = "IMMessageSummaryService.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {TbsListener.ErrorCode.THROWABLE_INITX5CORE, 187}, m = "observe$session_debug", n = {"session", "$this$withLock_u24default$iv", "$i$f$withLock", "session", "$this$withLock_u24default$iv", "$this$getOrPut$iv", "key$iv", "value$iv", "rawFlow", "$i$f$withLock", "$i$a$-withLock$default-IMSummaryCacheService$observe$2", "$i$f$getOrPut", "$i$a$-getOrPut-IMSummaryCacheService$observe$2$1"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2", "I$3"}, v = 1)
public final class IMSummaryCacheService$observe$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IMSummaryCacheService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSummaryCacheService$observe$1(IMSummaryCacheService iMSummaryCacheService, Continuation<? super IMSummaryCacheService$observe$1> continuation) {
        super(continuation);
        this.this$0 = iMSummaryCacheService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.observe$session_debug(null, (Continuation) this);
    }
}