package im.session.service;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMClearSessionService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.service.IMClearSessionService", f = "IMClearSessionService.kt", i = {0, 0, 0}, l = {22}, m = "clearSession-gIAlu-s$session_debug", n = {"pageType", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-IMClearSessionService$clearSession$2"}, s = {"L$0", "I$0", "I$1"}, v = 1)
public final class IMClearSessionService$clearSession$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IMClearSessionService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMClearSessionService$clearSession$1(IMClearSessionService iMClearSessionService, Continuation<? super IMClearSessionService$clearSession$1> continuation) {
        super(continuation);
        this.this$0 = iMClearSessionService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m3340clearSessiongIAlus$session_debug = this.this$0.m3340clearSessiongIAlus$session_debug(null, (Continuation) this);
        return m3340clearSessiongIAlus$session_debug == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m3340clearSessiongIAlus$session_debug : Result.box-impl(m3340clearSessiongIAlus$session_debug);
    }
}