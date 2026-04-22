package tv.danmaku.bili.fullscreen.state;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.fullscreen.stat.LoginWay;
import tv.danmaku.bili.fullscreen.stat.Unspecified;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;
import tv.danmaku.bili.report.misaka.MisakaHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmsLoginPageState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginPageState;", "action", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$LoginAction;", AuthResultCbHelper.ARGS_STATE, "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginValidState;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$1$2$5", f = "SmsLoginPageState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SmsLoginStateMachine$1$2$5 extends SuspendLambda implements Function3<IFullscreenLoginAction.LoginAction, State<ISmsLoginValidState>, Continuation<? super ChangedState<? extends ISmsLoginPageState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SmsLoginStateMachine$1$2$5(Continuation<? super SmsLoginStateMachine$1$2$5> continuation) {
        super(3, continuation);
    }

    public final Object invoke(IFullscreenLoginAction.LoginAction loginAction, State<ISmsLoginValidState> state, Continuation<? super ChangedState<? extends ISmsLoginPageState>> continuation) {
        SmsLoginStateMachine$1$2$5 smsLoginStateMachine$1$2$5 = new SmsLoginStateMachine$1$2$5(continuation);
        smsLoginStateMachine$1$2$5.L$0 = loginAction;
        smsLoginStateMachine$1$2$5.L$1 = state;
        return smsLoginStateMachine$1$2$5.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        final LoginWay loginWay;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                IFullscreenLoginAction.LoginAction action = (IFullscreenLoginAction.LoginAction) this.L$0;
                State state = (State) this.L$1;
                BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "on sms login, agreement checked " + ((ISmsLoginValidState) state.getSnapshot()).getInput().getAgreementChecked());
                if (Intrinsics.areEqual(action.getLoginWay(), Unspecified.INSTANCE)) {
                    loginWay = ((ISmsLoginValidState) state.getSnapshot()).getInput().getLoginWay();
                } else {
                    loginWay = action.getLoginWay();
                }
                return state.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$1$2$5$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        ISmsLoginLoadingState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = SmsLoginStateMachine$1$2$5.invokeSuspend$lambda$0(LoginWay.this, (ISmsLoginValidState) obj2);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ISmsLoginLoadingState invokeSuspend$lambda$0(LoginWay $loginWay, ISmsLoginValidState $this$override) {
        SmsLoginInput copy;
        SmsLoginInput copy2;
        if ($this$override instanceof SmsLoginPageInputCountingState) {
            copy2 = r4.copy((r26 & 1) != 0 ? r4.phone : null, (r26 & 2) != 0 ? r4.smsCode : null, (r26 & 4) != 0 ? r4.agreementChecked : false, (r26 & 8) != 0 ? r4.availableCountryCode : null, (r26 & 16) != 0 ? r4.selectedCountry : null, (r26 & 32) != 0 ? r4.showCountryCodeSelect : false, (r26 & 64) != 0 ? r4.captchaStatus : null, (r26 & BR.cover) != 0 ? r4.redirected : null, (r26 & BR.hallEnterHotText) != 0 ? r4.toastInfo : null, (r26 & BR.roleType) != 0 ? r4.eulaDisplayInfo : null, (r26 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? r4.loginWay : $loginWay, (r26 & 2048) != 0 ? ((SmsLoginPageInputCountingState) $this$override).getInput().netCodeState : null);
            return new SmsLoginLoadingCountingState(new SmsLoginPageInputCountingState(copy2, ((SmsLoginPageInputCountingState) $this$override).getCountDown(), ((SmsLoginPageInputCountingState) $this$override).getLoggedIn()));
        } else if (!($this$override instanceof SmsLoginPageInputIdleState)) {
            throw new NoWhenBranchMatchedException();
        } else {
            copy = r4.copy((r26 & 1) != 0 ? r4.phone : null, (r26 & 2) != 0 ? r4.smsCode : null, (r26 & 4) != 0 ? r4.agreementChecked : false, (r26 & 8) != 0 ? r4.availableCountryCode : null, (r26 & 16) != 0 ? r4.selectedCountry : null, (r26 & 32) != 0 ? r4.showCountryCodeSelect : false, (r26 & 64) != 0 ? r4.captchaStatus : null, (r26 & BR.cover) != 0 ? r4.redirected : null, (r26 & BR.hallEnterHotText) != 0 ? r4.toastInfo : null, (r26 & BR.roleType) != 0 ? r4.eulaDisplayInfo : null, (r26 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? r4.loginWay : $loginWay, (r26 & 2048) != 0 ? ((SmsLoginPageInputIdleState) $this$override).getInput().netCodeState : null);
            return new SmsLoginLoadingIdleState(new SmsLoginPageInputIdleState(copy, ((SmsLoginPageInputIdleState) $this$override).getLoggedIn()));
        }
    }
}