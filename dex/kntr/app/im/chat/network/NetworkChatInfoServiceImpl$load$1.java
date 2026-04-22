package kntr.app.im.chat.network;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetworkChatInfoServiceImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.network.NetworkChatInfoServiceImpl", f = "NetworkChatInfoServiceImpl.kt", i = {0, 0}, l = {24}, m = "load-IoAF18A", n = {"$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-NetworkChatInfoServiceImpl$load$2"}, s = {"I$0", "I$1"}, v = 1)
public final class NetworkChatInfoServiceImpl$load$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkChatInfoServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkChatInfoServiceImpl$load$1(NetworkChatInfoServiceImpl networkChatInfoServiceImpl, Continuation<? super NetworkChatInfoServiceImpl$load$1> continuation) {
        super(continuation);
        this.this$0 = networkChatInfoServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo1359loadIoAF18A = this.this$0.mo1359loadIoAF18A((Continuation) this);
        return mo1359loadIoAF18A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo1359loadIoAF18A : Result.box-impl(mo1359loadIoAF18A);
    }
}