package kntr.app.im.chat.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FusionFetchMessagesServiceImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.FusionFetchMessagesServiceImpl", f = "FusionFetchMessagesServiceImpl.kt", i = {0, 0}, l = {503}, m = "performAckSession", n = {"$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-FusionFetchMessagesServiceImpl$performAckSession$2"}, s = {"I$0", "I$1"}, v = 1)
public final class FusionFetchMessagesServiceImpl$performAckSession$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FusionFetchMessagesServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FusionFetchMessagesServiceImpl$performAckSession$1(FusionFetchMessagesServiceImpl fusionFetchMessagesServiceImpl, Continuation<? super FusionFetchMessagesServiceImpl$performAckSession$1> continuation) {
        super(continuation);
        this.this$0 = fusionFetchMessagesServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        Object performAckSession;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        performAckSession = this.this$0.performAckSession((Continuation) this);
        return performAckSession;
    }
}