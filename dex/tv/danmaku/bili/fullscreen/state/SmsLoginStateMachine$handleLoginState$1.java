package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmsLoginPageState.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine", f = "SmsLoginPageState.kt", i = {0, 0}, l = {BR.vipBarVisible}, m = "handleLoginState", n = {AuthResultCbHelper.ARGS_STATE, "current"}, s = {"L$0", "L$1"}, v = 1)
public final class SmsLoginStateMachine$handleLoginState$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SmsLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmsLoginStateMachine$handleLoginState$1(SmsLoginStateMachine smsLoginStateMachine, Continuation<? super SmsLoginStateMachine$handleLoginState$1> continuation) {
        super(continuation);
        this.this$0 = smsLoginStateMachine;
    }

    public final Object invokeSuspend(Object obj) {
        Object handleLoginState;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        handleLoginState = this.this$0.handleLoginState(null, (Continuation) this);
        return handleLoginState;
    }
}