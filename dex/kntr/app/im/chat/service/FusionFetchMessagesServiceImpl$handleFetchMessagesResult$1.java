package kntr.app.im.chat.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FusionFetchMessagesServiceImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.FusionFetchMessagesServiceImpl", f = "FusionFetchMessagesServiceImpl.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {475, 478}, m = "handleFetchMessagesResult", n = {"state", "result", "stateScope", "currentRange", "resultRange", "entityMessages", "ghostMessages", "tempMsgs", "needAck", "performAck", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-FusionFetchMessagesServiceImpl$handleFetchMessagesResult$updateIds$1", "state", "result", "stateScope", "currentRange", "resultRange", "entityMessages", "ghostMessages", "tempMsgs", "needAck", "performAck", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-FusionFetchMessagesServiceImpl$handleFetchMessagesResult$updateIds$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "Z$1", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "Z$1", "I$0", "I$1"}, v = 1)
public final class FusionFetchMessagesServiceImpl$handleFetchMessagesResult$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FusionFetchMessagesServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FusionFetchMessagesServiceImpl$handleFetchMessagesResult$1(FusionFetchMessagesServiceImpl fusionFetchMessagesServiceImpl, Continuation<? super FusionFetchMessagesServiceImpl$handleFetchMessagesResult$1> continuation) {
        super(continuation);
        this.this$0 = fusionFetchMessagesServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        Object handleFetchMessagesResult;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        handleFetchMessagesResult = this.this$0.handleFetchMessagesResult(null, null, false, null, (Continuation) this);
        return handleFetchMessagesResult;
    }
}