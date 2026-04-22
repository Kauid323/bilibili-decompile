package im.session.service;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMClearUnreadService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.service.IMClearUnreadService", f = "IMClearUnreadService.kt", i = {0, 0, 0, 0}, l = {37}, m = "clearSessionUnread-0E7RQCE", n = {"pageType", "session", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-IMClearUnreadService$clearSessionUnread$2"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
public final class IMClearUnreadService$clearSessionUnread$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IMClearUnreadService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMClearUnreadService$clearSessionUnread$1(IMClearUnreadService iMClearUnreadService, Continuation<? super IMClearUnreadService$clearSessionUnread$1> continuation) {
        super(continuation);
        this.this$0 = iMClearUnreadService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m3342clearSessionUnread0E7RQCE = this.this$0.m3342clearSessionUnread0E7RQCE(null, null, (Continuation) this);
        return m3342clearSessionUnread0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m3342clearSessionUnread0E7RQCE : Result.box-impl(m3342clearSessionUnread0E7RQCE);
    }
}