package tv.danmaku.bili.fullscreen.state;

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
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.fullscreen.service.SmsCaptchaStatus;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;
import tv.danmaku.bili.report.misaka.MisakaHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmsLoginPageState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginPageState;", "action", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$DismissCaptchaAction;", AuthResultCbHelper.ARGS_STATE, "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginValidState;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$1$2$7", f = "SmsLoginPageState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SmsLoginStateMachine$1$2$7 extends SuspendLambda implements Function3<IFullscreenLoginAction.DismissCaptchaAction, State<ISmsLoginValidState>, Continuation<? super ChangedState<? extends ISmsLoginPageState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SmsLoginStateMachine$1$2$7(Continuation<? super SmsLoginStateMachine$1$2$7> continuation) {
        super(3, continuation);
    }

    public final Object invoke(IFullscreenLoginAction.DismissCaptchaAction dismissCaptchaAction, State<ISmsLoginValidState> state, Continuation<? super ChangedState<? extends ISmsLoginPageState>> continuation) {
        SmsLoginStateMachine$1$2$7 smsLoginStateMachine$1$2$7 = new SmsLoginStateMachine$1$2$7(continuation);
        smsLoginStateMachine$1$2$7.L$0 = state;
        return smsLoginStateMachine$1$2$7.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                State state = (State) this.L$0;
                return state.mutate(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$1$2$7$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        ISmsLoginValidState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = SmsLoginStateMachine$1$2$7.invokeSuspend$lambda$0((ISmsLoginValidState) obj2);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ISmsLoginValidState invokeSuspend$lambda$0(ISmsLoginValidState $this$mutate) {
        SmsLoginInput copy;
        SmsLoginInput input = $this$mutate.getInput();
        SmsCaptchaStatus captchaStatus = $this$mutate.getInput().getCaptchaStatus();
        copy = input.copy((r26 & 1) != 0 ? input.phone : null, (r26 & 2) != 0 ? input.smsCode : null, (r26 & 4) != 0 ? input.agreementChecked : false, (r26 & 8) != 0 ? input.availableCountryCode : null, (r26 & 16) != 0 ? input.selectedCountry : null, (r26 & 32) != 0 ? input.showCountryCodeSelect : false, (r26 & 64) != 0 ? input.captchaStatus : captchaStatus != null ? SmsCaptchaStatus.copy$default(captchaStatus, null, null, false, null, "", null, 47, null) : null, (r26 & BR.cover) != 0 ? input.redirected : null, (r26 & BR.hallEnterHotText) != 0 ? input.toastInfo : null, (r26 & BR.roleType) != 0 ? input.eulaDisplayInfo : null, (r26 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? input.loginWay : null, (r26 & 2048) != 0 ? input.netCodeState : null);
        return $this$mutate.copyState(copy);
    }
}