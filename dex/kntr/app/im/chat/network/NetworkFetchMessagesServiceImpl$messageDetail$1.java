package kntr.app.im.chat.network;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetworkFetchMessagesServiceImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.network.NetworkFetchMessagesServiceImpl", f = "NetworkFetchMessagesServiceImpl.kt", i = {0, 0, 0, 0}, l = {64}, m = "messageDetail-gIAlu-s", n = {"ids", "req", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-NetworkFetchMessagesServiceImpl$messageDetail$2"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
public final class NetworkFetchMessagesServiceImpl$messageDetail$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkFetchMessagesServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkFetchMessagesServiceImpl$messageDetail$1(NetworkFetchMessagesServiceImpl networkFetchMessagesServiceImpl, Continuation<? super NetworkFetchMessagesServiceImpl$messageDetail$1> continuation) {
        super(continuation);
        this.this$0 = networkFetchMessagesServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo1361messageDetailgIAlus = this.this$0.mo1361messageDetailgIAlus(null, (Continuation) this);
        return mo1361messageDetailgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo1361messageDetailgIAlus : Result.box-impl(mo1361messageDetailgIAlus);
    }
}