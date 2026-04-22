package tv.danmaku.bili.inner;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InnerLoginStateMachine.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.inner.InnerLoginStateMachine", f = "InnerLoginStateMachine.kt", i = {0, 0, 0, 1, 1, 1, 2, 2}, l = {BR.constellationAndAge, BR.count, BR.dialogStyleType}, m = "getLoginState", n = {"context", "skipFastLogin", "skipQuickLogin", "context", "infoLogin", "skipQuickLogin", "context", "infoLogin"}, s = {"L$0", "Z$0", "Z$1", "L$0", "L$1", "Z$0", "L$0", "L$1"}, v = 1)
public final class InnerLoginStateMachine$getLoginState$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InnerLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerLoginStateMachine$getLoginState$1(InnerLoginStateMachine innerLoginStateMachine, Continuation<? super InnerLoginStateMachine$getLoginState$1> continuation) {
        super(continuation);
        this.this$0 = innerLoginStateMachine;
    }

    public final Object invokeSuspend(Object obj) {
        Object loginState;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        loginState = this.this$0.getLoginState(false, false, (Continuation) this);
        return loginState;
    }
}