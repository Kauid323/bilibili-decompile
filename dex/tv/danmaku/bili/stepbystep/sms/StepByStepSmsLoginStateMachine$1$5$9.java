package tv.danmaku.bili.stepbystep.sms;

import bili.resource.account.R;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.stepbystep.IStepByStepLoginAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StepByStepSmsLoginStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "<unused var>", "Ltv/danmaku/bili/stepbystep/IStepByStepLoginAction$LoginAction;", AuthResultCbHelper.ARGS_STATE, "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginVerifyPage;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$1$5$9", f = "StepByStepSmsLoginStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class StepByStepSmsLoginStateMachine$1$5$9 extends SuspendLambda implements Function3<IStepByStepLoginAction.LoginAction, State<StepByStepSmsLoginVerifyPage>, Continuation<? super ChangedState<? extends IStepByStepSmsLoginPageState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StepByStepSmsLoginStateMachine$1$5$9(Continuation<? super StepByStepSmsLoginStateMachine$1$5$9> continuation) {
        super(3, continuation);
    }

    public final Object invoke(IStepByStepLoginAction.LoginAction loginAction, State<StepByStepSmsLoginVerifyPage> state, Continuation<? super ChangedState<? extends IStepByStepSmsLoginPageState>> continuation) {
        StepByStepSmsLoginStateMachine$1$5$9 stepByStepSmsLoginStateMachine$1$5$9 = new StepByStepSmsLoginStateMachine$1$5$9(continuation);
        stepByStepSmsLoginStateMachine$1$5$9.L$0 = state;
        return stepByStepSmsLoginStateMachine$1$5$9.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                State state = (State) this.L$0;
                if (((StepByStepSmsLoginVerifyPage) state.getSnapshot()).getCaptchaStatus() == null || ((StepByStepSmsLoginVerifyPage) state.getSnapshot()).getSmsCode().length() != 6) {
                    return state.mutate(new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$1$5$9$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj2) {
                            StepByStepSmsLoginVerifyPage invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = StepByStepSmsLoginStateMachine$1$5$9.invokeSuspend$lambda$0((StepByStepSmsLoginVerifyPage) obj2);
                            return invokeSuspend$lambda$0;
                        }
                    });
                }
                return state.mutate(new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$1$5$9$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj2) {
                        StepByStepSmsLoginVerifyPage invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = StepByStepSmsLoginStateMachine$1$5$9.invokeSuspend$lambda$1((StepByStepSmsLoginVerifyPage) obj2);
                        return invokeSuspend$lambda$1;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StepByStepSmsLoginVerifyPage invokeSuspend$lambda$0(StepByStepSmsLoginVerifyPage $this$mutate) {
        StepByStepSmsLoginVerifyPage m1531copyvXyWBk$default = StepByStepSmsLoginVerifyPage.m1531copyvXyWBk$default($this$mutate, null, "", R.string.account_global_string_2, null, false, null, null, 0.0f, false, null, 0L, null, null, 8185, null);
        BLog.i(StepByStepSmsLoginPageStateKt.TAG_STEP_BY_STEP_SMS, "mutate state : StepByStepSmsLoginVerifyPage, action : LoginAction -> error = auth_code_error");
        return m1531copyvXyWBk$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StepByStepSmsLoginVerifyPage invokeSuspend$lambda$1(StepByStepSmsLoginVerifyPage $this$mutate) {
        StepByStepSmsLoginVerifyPage m1531copyvXyWBk$default = StepByStepSmsLoginVerifyPage.m1531copyvXyWBk$default($this$mutate, null, null, 0, null, false, null, null, 0.0f, true, null, 0L, null, null, 7935, null);
        BLog.i(StepByStepSmsLoginPageStateKt.TAG_STEP_BY_STEP_SMS, "override state : StepByStepSmsLoginVerifyPage to StepByStepSmsLoginSubmitPage, action : LoginAction -> startRequestingLogin");
        return m1531copyvXyWBk$default;
    }
}