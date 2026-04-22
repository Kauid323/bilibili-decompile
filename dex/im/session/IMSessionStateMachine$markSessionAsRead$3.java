package im.session;

import im.session.model.IMSessionCard;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionStateMachine.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine", f = "IMSessionStateMachine.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {661}, m = "markSessionAsRead", n = {"$this$markSessionAsRead", "session", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "s", "$i$f$map", "$i$f$mapTo", "$i$a$-map-IMSessionStateMachine$markSessionAsRead$sessions$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "I$0", "I$1", "I$2"}, v = 1)
public final class IMSessionStateMachine$markSessionAsRead$3 extends ContinuationImpl {
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
    Object L$8;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$markSessionAsRead$3(IMSessionStateMachine iMSessionStateMachine, Continuation<? super IMSessionStateMachine$markSessionAsRead$3> continuation) {
        super(continuation);
        this.this$0 = iMSessionStateMachine;
    }

    public final Object invokeSuspend(Object obj) {
        Object markSessionAsRead;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        markSessionAsRead = this.this$0.markSessionAsRead((IMState) null, (IMSessionCard) null, (Continuation) this);
        return markSessionAsRead;
    }
}