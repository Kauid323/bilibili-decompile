package im.session;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionStateMachine.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine", f = "IMSessionStateMachine.kt", i = {0, 0, 1, 1, 1, 1}, l = {863, 872}, m = "pinOrNot", n = {"$this$pinOrNot", "session", "$this$pinOrNot", "session", "it", "$i$a$-fold-IMSessionStateMachine$pinOrNot$3"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "I$0"}, v = 1)
public final class IMSessionStateMachine$pinOrNot$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$pinOrNot$1(IMSessionStateMachine iMSessionStateMachine, Continuation<? super IMSessionStateMachine$pinOrNot$1> continuation) {
        super(continuation);
        this.this$0 = iMSessionStateMachine;
    }

    public final Object invokeSuspend(Object obj) {
        Object pinOrNot;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        pinOrNot = this.this$0.pinOrNot(null, null, (Continuation) this);
        return pinOrNot;
    }
}