package im.session;

import com.freeletics.flowredux.dsl.State;
import im.session.model.IMSessionCard;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionStateMachine.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine", f = "IMSessionStateMachine.kt", i = {0, 0}, l = {649}, m = "markSessionAsRead", n = {"$this$markSessionAsRead", "session"}, s = {"L$0", "L$1"}, v = 1)
public final class IMSessionStateMachine$markSessionAsRead$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$markSessionAsRead$1(IMSessionStateMachine iMSessionStateMachine, Continuation<? super IMSessionStateMachine$markSessionAsRead$1> continuation) {
        super(continuation);
        this.this$0 = iMSessionStateMachine;
    }

    public final Object invokeSuspend(Object obj) {
        Object markSessionAsRead;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        markSessionAsRead = this.this$0.markSessionAsRead((State<IMState>) null, (IMSessionCard) null, (Continuation) this);
        return markSessionAsRead;
    }
}