package kntr.app.im.chat.network;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetworkOperateMessageServiceImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.network.NetworkOperateMessageServiceImpl", f = "NetworkOperateMessageServiceImpl.kt", i = {0, 0, 0}, l = {25}, m = "deleteMessage-gIAlu-s", n = {"messageIds", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-NetworkOperateMessageServiceImpl$deleteMessage$2"}, s = {"L$0", "I$0", "I$1"}, v = 1)
public final class NetworkOperateMessageServiceImpl$deleteMessage$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkOperateMessageServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkOperateMessageServiceImpl$deleteMessage$1(NetworkOperateMessageServiceImpl networkOperateMessageServiceImpl, Continuation<? super NetworkOperateMessageServiceImpl$deleteMessage$1> continuation) {
        super(continuation);
        this.this$0 = networkOperateMessageServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo1364deleteMessagegIAlus = this.this$0.mo1364deleteMessagegIAlus(null, (Continuation) this);
        return mo1364deleteMessagegIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo1364deleteMessagegIAlus : Result.box-impl(mo1364deleteMessagegIAlus);
    }
}