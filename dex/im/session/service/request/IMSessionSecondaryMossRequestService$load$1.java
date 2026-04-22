package im.session.service.request;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionSecondaryMossRequestService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.service.request.IMSessionSecondaryMossRequestService", f = "IMSessionSecondaryMossRequestService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1}, l = {45, 33}, m = "load", n = {"param", "req", "$this$iv", "request$iv", "reqSerializer$iv", "respSerializer$iv", "$i$f$sessionSecondary", "$i$f$suspendCall", "$i$f$suspendCancellableCoroutine", "param", "req", "resp"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2"}, v = 1)
public final class IMSessionSecondaryMossRequestService$load$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IMSessionSecondaryMossRequestService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionSecondaryMossRequestService$load$1(IMSessionSecondaryMossRequestService iMSessionSecondaryMossRequestService, Continuation<? super IMSessionSecondaryMossRequestService$load$1> continuation) {
        super(continuation);
        this.this$0 = iMSessionSecondaryMossRequestService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.load(null, (Continuation) this);
    }
}