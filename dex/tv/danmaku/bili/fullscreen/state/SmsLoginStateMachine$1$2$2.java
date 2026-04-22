package tv.danmaku.bili.fullscreen.state;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;
import tv.danmaku.bili.fullscreen.state.ISmsLoginAction;
import tv.danmaku.bili.report.misaka.MisakaHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmsLoginPageState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginPageState;", "action", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginAction$SmsCodeInputAction;", AuthResultCbHelper.ARGS_STATE, "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginValidState;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$1$2$2", f = "SmsLoginPageState.kt", i = {0, 0, 1, 1}, l = {BR.moreTextVisible, BR.needShowEndContainer}, m = "invokeSuspend", n = {AuthResultCbHelper.ARGS_STATE, "onlyDigit", AuthResultCbHelper.ARGS_STATE, "onlyDigit"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
public final class SmsLoginStateMachine$1$2$2 extends SuspendLambda implements Function3<ISmsLoginAction.SmsCodeInputAction, State<ISmsLoginValidState>, Continuation<? super ChangedState<? extends ISmsLoginPageState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ SmsLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmsLoginStateMachine$1$2$2(SmsLoginStateMachine smsLoginStateMachine, Continuation<? super SmsLoginStateMachine$1$2$2> continuation) {
        super(3, continuation);
        this.this$0 = smsLoginStateMachine;
    }

    public final Object invoke(ISmsLoginAction.SmsCodeInputAction smsCodeInputAction, State<ISmsLoginValidState> state, Continuation<? super ChangedState<? extends ISmsLoginPageState>> continuation) {
        SmsLoginStateMachine$1$2$2 smsLoginStateMachine$1$2$2 = new SmsLoginStateMachine$1$2$2(this.this$0, continuation);
        smsLoginStateMachine$1$2$2.L$0 = smsCodeInputAction;
        smsLoginStateMachine$1$2$2.L$1 = state;
        return smsLoginStateMachine$1$2$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state;
        final String onlyDigit;
        String onlyDigit2;
        State state2;
        String onlyDigit3;
        State state3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ISmsLoginAction.SmsCodeInputAction action = (ISmsLoginAction.SmsCodeInputAction) this.L$0;
                state = (State) this.L$1;
                CharSequence $this$filter$iv = action.getSmsCode();
                CharSequence $this$filterTo$iv$iv = $this$filter$iv;
                Appendable destination$iv$iv = new StringBuilder();
                int length = $this$filterTo$iv$iv.length();
                for (int index$iv$iv = 0; index$iv$iv < length; index$iv$iv++) {
                    char element$iv$iv = $this$filterTo$iv$iv.charAt(index$iv$iv);
                    char it = element$iv$iv;
                    if (Character.isDigit(it)) {
                        destination$iv$iv.append(element$iv$iv);
                    }
                }
                onlyDigit = ((StringBuilder) destination$iv$iv).toString();
                if (onlyDigit.length() == 6) {
                    if (((ISmsLoginValidState) state.getSnapshot()).getInput().getAgreementChecked()) {
                        this.L$0 = state;
                        this.L$1 = onlyDigit;
                        this.label = 1;
                        if (this.this$0.dispatch(new IFullscreenLoginAction.LoginAction(null, true, MapsKt.emptyMap(), 1, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        onlyDigit3 = onlyDigit;
                        state3 = state;
                        state = state3;
                        onlyDigit = onlyDigit3;
                        break;
                    } else {
                        this.L$0 = state;
                        this.L$1 = onlyDigit;
                        this.label = 2;
                        if (this.this$0.dispatch(new IFullscreenLoginAction.ShowEulaAction(null, 1, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        onlyDigit2 = onlyDigit;
                        state2 = state;
                        state = state2;
                        onlyDigit = onlyDigit2;
                        break;
                    }
                }
                break;
            case 1:
                onlyDigit3 = (String) this.L$1;
                state3 = (State) this.L$0;
                ResultKt.throwOnFailure($result);
                state = state3;
                onlyDigit = onlyDigit3;
                break;
            case 2:
                onlyDigit2 = (String) this.L$1;
                state2 = (State) this.L$0;
                ResultKt.throwOnFailure($result);
                state = state2;
                onlyDigit = onlyDigit2;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return state.mutate(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$1$2$2$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                ISmsLoginValidState invokeSuspend$lambda$1;
                invokeSuspend$lambda$1 = SmsLoginStateMachine$1$2$2.invokeSuspend$lambda$1(onlyDigit, (ISmsLoginValidState) obj);
                return invokeSuspend$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ISmsLoginValidState invokeSuspend$lambda$1(String $onlyDigit, ISmsLoginValidState $this$mutate) {
        SmsLoginInput copy;
        copy = r0.copy((r26 & 1) != 0 ? r0.phone : null, (r26 & 2) != 0 ? r0.smsCode : $onlyDigit, (r26 & 4) != 0 ? r0.agreementChecked : false, (r26 & 8) != 0 ? r0.availableCountryCode : null, (r26 & 16) != 0 ? r0.selectedCountry : null, (r26 & 32) != 0 ? r0.showCountryCodeSelect : false, (r26 & 64) != 0 ? r0.captchaStatus : null, (r26 & BR.cover) != 0 ? r0.redirected : null, (r26 & BR.hallEnterHotText) != 0 ? r0.toastInfo : null, (r26 & BR.roleType) != 0 ? r0.eulaDisplayInfo : null, (r26 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? r0.loginWay : null, (r26 & 2048) != 0 ? $this$mutate.getInput().netCodeState : null);
        return $this$mutate.copyState(copy);
    }
}