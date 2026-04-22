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
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.fullscreen.state.ISmsLoginAction;
import tv.danmaku.bili.report.misaka.MisakaHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmsLoginPageState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginPageState;", "action", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginAction$PhoneInputAction;", AuthResultCbHelper.ARGS_STATE, "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginValidState;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$1$2$1", f = "SmsLoginPageState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SmsLoginStateMachine$1$2$1 extends SuspendLambda implements Function3<ISmsLoginAction.PhoneInputAction, State<ISmsLoginValidState>, Continuation<? super ChangedState<? extends ISmsLoginPageState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SmsLoginStateMachine$1$2$1(Continuation<? super SmsLoginStateMachine$1$2$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(ISmsLoginAction.PhoneInputAction phoneInputAction, State<ISmsLoginValidState> state, Continuation<? super ChangedState<? extends ISmsLoginPageState>> continuation) {
        SmsLoginStateMachine$1$2$1 smsLoginStateMachine$1$2$1 = new SmsLoginStateMachine$1$2$1(continuation);
        smsLoginStateMachine$1$2$1.L$0 = phoneInputAction;
        smsLoginStateMachine$1$2$1.L$1 = state;
        return smsLoginStateMachine$1$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                final ISmsLoginAction.PhoneInputAction action = (ISmsLoginAction.PhoneInputAction) this.L$0;
                State state = (State) this.L$1;
                return state.mutate(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$1$2$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        ISmsLoginValidState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = SmsLoginStateMachine$1$2$1.invokeSuspend$lambda$0(ISmsLoginAction.PhoneInputAction.this, (ISmsLoginValidState) obj2);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ISmsLoginValidState invokeSuspend$lambda$0(ISmsLoginAction.PhoneInputAction $action, ISmsLoginValidState $this$mutate) {
        String limitLengthInput;
        SmsLoginInput copy;
        CharSequence $this$filterTo$iv$iv = $action.getPhone();
        Appendable destination$iv$iv = new StringBuilder();
        int length = $this$filterTo$iv$iv.length();
        for (int index$iv$iv = 0; index$iv$iv < length; index$iv$iv++) {
            char element$iv$iv = $this$filterTo$iv$iv.charAt(index$iv$iv);
            if (Character.isDigit(element$iv$iv)) {
                destination$iv$iv.append(element$iv$iv);
            }
        }
        String $this$filter$iv = ((StringBuilder) destination$iv$iv).toString();
        if ($this$filter$iv.length() > 16) {
            String substring = $this$filter$iv.substring(0, 16);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            limitLengthInput = substring;
        } else {
            limitLengthInput = $this$filter$iv;
        }
        copy = r3.copy((r26 & 1) != 0 ? r3.phone : limitLengthInput, (r26 & 2) != 0 ? r3.smsCode : null, (r26 & 4) != 0 ? r3.agreementChecked : false, (r26 & 8) != 0 ? r3.availableCountryCode : null, (r26 & 16) != 0 ? r3.selectedCountry : null, (r26 & 32) != 0 ? r3.showCountryCodeSelect : false, (r26 & 64) != 0 ? r3.captchaStatus : null, (r26 & BR.cover) != 0 ? r3.redirected : null, (r26 & BR.hallEnterHotText) != 0 ? r3.toastInfo : null, (r26 & BR.roleType) != 0 ? r3.eulaDisplayInfo : null, (r26 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? r3.loginWay : null, (r26 & 2048) != 0 ? $this$mutate.getInput().netCodeState : null);
        return $this$mutate.copyState(copy);
    }
}