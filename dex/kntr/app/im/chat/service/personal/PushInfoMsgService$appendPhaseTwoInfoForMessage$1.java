package kntr.app.im.chat.service.personal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PushInfoMsgService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.personal.PushInfoMsgService", f = "PushInfoMsgService.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {93, 110}, m = "appendPhaseTwoInfoForMessage", n = {"info", "messageSequence", "relatedTimeStamp", "info", "messageSequence", "relatedTimeStamp", "currentInfo", "paragraph", "hintMessage", "messageEntity", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-PushInfoMsgService$appendPhaseTwoInfoForMessage$2"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1"}, v = 1)
public final class PushInfoMsgService$appendPhaseTwoInfoForMessage$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PushInfoMsgService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushInfoMsgService$appendPhaseTwoInfoForMessage$1(PushInfoMsgService pushInfoMsgService, Continuation<? super PushInfoMsgService$appendPhaseTwoInfoForMessage$1> continuation) {
        super(continuation);
        this.this$0 = pushInfoMsgService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.appendPhaseTwoInfoForMessage(null, null, null, (Continuation) this);
    }
}