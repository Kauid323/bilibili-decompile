package kntr.app.deepsearch.history.service;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DSHistoryLoadService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.history.service.DSHistoryLoadService", f = "DSHistoryLoadService.kt", i = {0, 0}, l = {AdditionVote2.TIPS_FIELD_NUMBER}, m = "load-gIAlu-s$history_debug", n = {"cursor", "$i$a$-runCatching-DSHistoryLoadService$load$2"}, s = {"L$0", "I$0"}, v = 1)
public final class DSHistoryLoadService$load$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DSHistoryLoadService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DSHistoryLoadService$load$1(DSHistoryLoadService dSHistoryLoadService, Continuation<? super DSHistoryLoadService$load$1> continuation) {
        super(continuation);
        this.this$0 = dSHistoryLoadService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m641loadgIAlus$history_debug = this.this$0.m641loadgIAlus$history_debug(null, (Continuation) this);
        return m641loadgIAlus$history_debug == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m641loadgIAlus$history_debug : Result.box-impl(m641loadgIAlus$history_debug);
    }
}