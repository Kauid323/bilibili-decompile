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
@DebugMetadata(c = "kntr.app.im.chat.network.NetworkOperateMessageServiceImpl", f = "NetworkOperateMessageServiceImpl.kt", i = {0, 0, 0, 1, 1, 1}, l = {35, 37}, m = "recallMessage-gIAlu-s", n = {"messageId", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-NetworkOperateMessageServiceImpl$recallMessage$2", "messageId", "it", "$i$a$-onSuccess-NetworkOperateMessageServiceImpl$recallMessage$3"}, s = {"L$0", "I$0", "I$1", "L$0", "L$2", "I$0"}, v = 1)
public final class NetworkOperateMessageServiceImpl$recallMessage$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkOperateMessageServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkOperateMessageServiceImpl$recallMessage$1(NetworkOperateMessageServiceImpl networkOperateMessageServiceImpl, Continuation<? super NetworkOperateMessageServiceImpl$recallMessage$1> continuation) {
        super(continuation);
        this.this$0 = networkOperateMessageServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo1365recallMessagegIAlus = this.this$0.mo1365recallMessagegIAlus(null, (Continuation) this);
        return mo1365recallMessagegIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo1365recallMessagegIAlus : Result.box-impl(mo1365recallMessagegIAlus);
    }
}