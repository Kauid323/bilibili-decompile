package im.session;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionStateMachine.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine", f = "IMSessionStateMachine.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {835, 836}, m = "receive", n = {"$this$receive", "result", "it", "byNext", "overrideQuickLink", "$i$a$-fold-IMSessionStateMachine$receive$3", "$this$receive", "result", "it", "errorString", "byNext", "overrideQuickLink", "$i$a$-fold-IMSessionStateMachine$receive$3"}, s = {"L$0", "L$1", "L$2", "Z$0", "Z$1", "I$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1", "I$0"}, v = 1)
public final class IMSessionStateMachine$receive$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$receive$1(IMSessionStateMachine iMSessionStateMachine, Continuation<? super IMSessionStateMachine$receive$1> continuation) {
        super(continuation);
        this.this$0 = iMSessionStateMachine;
    }

    public final Object invokeSuspend(Object obj) {
        Object receive;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        receive = this.this$0.receive(null, null, false, false, (Continuation) this);
        return receive;
    }
}