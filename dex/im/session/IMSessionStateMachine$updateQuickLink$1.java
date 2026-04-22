package im.session;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionStateMachine.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine", f = "IMSessionStateMachine.kt", i = {0, 1, 1, 1}, l = {935, 944}, m = "updateQuickLink", n = {"$this$updateQuickLink", "$this$updateQuickLink", "it", "$i$a$-fold-IMSessionStateMachine$updateQuickLink$3"}, s = {"L$0", "L$0", "L$1", "I$0"}, v = 1)
public final class IMSessionStateMachine$updateQuickLink$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$updateQuickLink$1(IMSessionStateMachine iMSessionStateMachine, Continuation<? super IMSessionStateMachine$updateQuickLink$1> continuation) {
        super(continuation);
        this.this$0 = iMSessionStateMachine;
    }

    public final Object invokeSuspend(Object obj) {
        Object updateQuickLink;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        updateQuickLink = this.this$0.updateQuickLink(null, (Continuation) this);
        return updateQuickLink;
    }
}