package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PasswordLoginPageState.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.PasswordLoginStateMachine", f = "PasswordLoginPageState.kt", i = {0}, l = {BR.followLottieAnimationVisible}, m = "handlePwdLogin", n = {"inState"}, s = {"L$0"}, v = 1)
public final class PasswordLoginStateMachine$handlePwdLogin$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PasswordLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PasswordLoginStateMachine$handlePwdLogin$1(PasswordLoginStateMachine passwordLoginStateMachine, Continuation<? super PasswordLoginStateMachine$handlePwdLogin$1> continuation) {
        super(continuation);
        this.this$0 = passwordLoginStateMachine;
    }

    public final Object invokeSuspend(Object obj) {
        Object handlePwdLogin;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        handlePwdLogin = this.this$0.handlePwdLogin(null, (Continuation) this);
        return handlePwdLogin;
    }
}