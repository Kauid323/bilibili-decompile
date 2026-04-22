package im.session;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionStateMachine.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine", f = "IMSessionStateMachine.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {915, 919, 924}, m = "broadcastReceived", n = {"notify", "state", "$this$forEach$iv", "element$iv", "it", "command", "$i$f$forEach", "$i$a$-forEach-IMSessionStateMachine$broadcastReceived$2", "notify", "state", "$this$forEach$iv", "element$iv", "it", "command", "$i$f$forEach", "$i$a$-forEach-IMSessionStateMachine$broadcastReceived$2", "notify", "state", "$this$forEach$iv", "element$iv", "it", "command", "sessionId", "$i$f$forEach", "$i$a$-forEach-IMSessionStateMachine$broadcastReceived$2", "$i$a$-let-IMSessionStateMachine$broadcastReceived$2$1"}, s = {"L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2"}, v = 1)
public final class IMSessionStateMachine$broadcastReceived$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$broadcastReceived$1(IMSessionStateMachine iMSessionStateMachine, Continuation<? super IMSessionStateMachine$broadcastReceived$1> continuation) {
        super(continuation);
        this.this$0 = iMSessionStateMachine;
    }

    public final Object invokeSuspend(Object obj) {
        Object broadcastReceived;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        broadcastReceived = this.this$0.broadcastReceived(null, null, (Continuation) this);
        return broadcastReceived;
    }
}