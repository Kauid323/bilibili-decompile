package kntr.app.im.chat.stateMachine.builder;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OperateMessage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.OperateMessageKt", f = "OperateMessage.kt", i = {0, 0, 0, 1, 1, 1, 1, 1}, l = {129, 134}, m = "recallMessage", n = {"$this$recallMessage", "operateMessageService", "msgId", "$this$recallMessage", "operateMessageService", "msgId", "it", "$i$a$-fold-OperateMessageKt$recallMessage$3"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
public final class OperateMessageKt$recallMessage$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OperateMessageKt$recallMessage$1(Continuation<? super OperateMessageKt$recallMessage$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object recallMessage;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        recallMessage = OperateMessageKt.recallMessage(null, null, null, (Continuation) this);
        return recallMessage;
    }
}