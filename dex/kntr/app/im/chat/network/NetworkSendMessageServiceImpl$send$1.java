package kntr.app.im.chat.network;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetworkSendMessageServiceImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.network.NetworkSendMessageServiceImpl", f = "NetworkSendMessageServiceImpl.kt", i = {0, 0, 0, 0, 0}, l = {30}, m = "send-gIAlu-s", n = {"message", "entityMsg", "req", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-NetworkSendMessageServiceImpl$send$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
public final class NetworkSendMessageServiceImpl$send$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkSendMessageServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkSendMessageServiceImpl$send$1(NetworkSendMessageServiceImpl networkSendMessageServiceImpl, Continuation<? super NetworkSendMessageServiceImpl$send$1> continuation) {
        super(continuation);
        this.this$0 = networkSendMessageServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo1362sendgIAlus = this.this$0.mo1362sendgIAlus(null, (Continuation) this);
        return mo1362sendgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo1362sendgIAlus : Result.box-impl(mo1362sendgIAlus);
    }
}