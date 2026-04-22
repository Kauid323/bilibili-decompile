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
@DebugMetadata(c = "kntr.app.im.chat.network.NetworkFetchMessagesServiceImpl", f = "NetworkFetchMessagesServiceImpl.kt", i = {0, 0, 0, 0}, l = {46}, m = "load-0E7RQCE", n = {"policy", "beginSequenceNumber", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-NetworkFetchMessagesServiceImpl$load$2"}, s = {"L$0", "J$0", "I$0", "I$1"}, v = 1)
public final class NetworkFetchMessagesServiceImpl$load$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkFetchMessagesServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkFetchMessagesServiceImpl$load$1(NetworkFetchMessagesServiceImpl networkFetchMessagesServiceImpl, Continuation<? super NetworkFetchMessagesServiceImpl$load$1> continuation) {
        super(continuation);
        this.this$0 = networkFetchMessagesServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo1360load0E7RQCE = this.this$0.mo1360load0E7RQCE(0L, null, (Continuation) this);
        return mo1360load0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo1360load0E7RQCE : Result.box-impl(mo1360load0E7RQCE);
    }
}