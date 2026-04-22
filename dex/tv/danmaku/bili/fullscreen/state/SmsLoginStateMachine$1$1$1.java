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
import kotlin.jvm.functions.Function2;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.data.AvailableCountryCode;
import tv.danmaku.bili.fullscreen.service.ISmsLoginService;
import tv.danmaku.bili.fullscreen.stat.Sms;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmsLoginPageState.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginPageState;", "it", "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/fullscreen/state/SmsLoginPageInitialState;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$1$1$1", f = "SmsLoginPageState.kt", i = {0}, l = {BR.leftBadgeVisible}, m = "invokeSuspend", n = {"it"}, s = {"L$0"}, v = 1)
public final class SmsLoginStateMachine$1$1$1 extends SuspendLambda implements Function2<State<SmsLoginPageInitialState>, Continuation<? super ChangedState<? extends ISmsLoginPageState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SmsLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmsLoginStateMachine$1$1$1(SmsLoginStateMachine smsLoginStateMachine, Continuation<? super SmsLoginStateMachine$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = smsLoginStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> smsLoginStateMachine$1$1$1 = new SmsLoginStateMachine$1$1$1(this.this$0, continuation);
        smsLoginStateMachine$1$1$1.L$0 = obj;
        return smsLoginStateMachine$1$1$1;
    }

    public final Object invoke(State<SmsLoginPageInitialState> state, Continuation<? super ChangedState<? extends ISmsLoginPageState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State it;
        ISmsLoginService iSmsLoginService;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                it = (State) this.L$0;
                iSmsLoginService = this.this$0.smsLoginService;
                this.L$0 = it;
                this.label = 1;
                Object allCountryCode = iSmsLoginService.getAllCountryCode((Continuation) this);
                if (allCountryCode != coroutine_suspended) {
                    $result = allCountryCode;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                it = (State) this.L$0;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final AvailableCountryCode code = (AvailableCountryCode) $result;
        return it.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$1$1$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                SmsLoginPageInputIdleState invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = SmsLoginStateMachine$1$1$1.invokeSuspend$lambda$0(AvailableCountryCode.this, (SmsLoginPageInitialState) obj);
                return invokeSuspend$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SmsLoginPageInputIdleState invokeSuspend$lambda$0(AvailableCountryCode $code, SmsLoginPageInitialState $this$override) {
        Sms.SmsLogin smsLogin;
        NetCodeState initNetCodeState = $this$override.getInitNetCodeState();
        if ($this$override.getInitNetCodeState() instanceof BindingPage) {
            smsLogin = Sms.SmsWithNetCode.INSTANCE;
        } else {
            smsLogin = Sms.SmsLogin.INSTANCE;
        }
        return new SmsLoginPageInputIdleState(new SmsLoginInput(null, null, false, $code, null, false, null, null, null, null, smsLogin, initNetCodeState, 1015, null), false, 2, null);
    }
}