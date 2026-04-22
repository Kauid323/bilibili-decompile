package tv.danmaku.bili.inner;

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
import kotlinx.coroutines.JobKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.fullscreen.service.TechTrackService;
import tv.danmaku.bili.fullscreen.state.FullscreenLoginPhoneIdlePage;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginState;
import tv.danmaku.bili.quick.core.OnePassLoginPhaseType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InnerLoginStateMachine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginState;", "it", "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/fullscreen/state/FullscreenLoginPhoneIdlePage;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.inner.InnerLoginStateMachine$1$1$1", f = "InnerLoginStateMachine.kt", i = {0}, l = {BR.followButtonConfig}, m = "invokeSuspend", n = {"it"}, s = {"L$0"}, v = 1)
public final class InnerLoginStateMachine$1$1$1 extends SuspendLambda implements Function2<State<FullscreenLoginPhoneIdlePage>, Continuation<? super ChangedState<? extends IFullscreenLoginState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ InnerLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerLoginStateMachine$1$1$1(InnerLoginStateMachine innerLoginStateMachine, Continuation<? super InnerLoginStateMachine$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = innerLoginStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> innerLoginStateMachine$1$1$1 = new InnerLoginStateMachine$1$1$1(this.this$0, continuation);
        innerLoginStateMachine$1$1$1.L$0 = obj;
        return innerLoginStateMachine$1$1$1;
    }

    public final Object invoke(State<FullscreenLoginPhoneIdlePage> state, Continuation<? super ChangedState<? extends IFullscreenLoginState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State it;
        TechTrackService techTrackService;
        LoginReportService loginReportService;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                it = (State) this.L$0;
                JobKt.ensureActive(getContext());
                techTrackService = this.this$0.techTrackService;
                loginReportService = this.this$0.loginReportService;
                techTrackService.onPhase(loginReportService.getSpmid(), OnePassLoginPhaseType.Trigger.INSTANCE);
                this.L$0 = it;
                this.label = 1;
                Object loginState$default = InnerLoginStateMachine.getLoginState$default(this.this$0, false, false, (Continuation) this, 3, null);
                if (loginState$default != coroutine_suspended) {
                    $result = loginState$default;
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
        final IFullscreenLoginState loginState = (IFullscreenLoginState) $result;
        if (loginState == null) {
            return it.noChange();
        }
        return it.override(new Function1() { // from class: tv.danmaku.bili.inner.InnerLoginStateMachine$1$1$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                IFullscreenLoginState invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = InnerLoginStateMachine$1$1$1.invokeSuspend$lambda$0(IFullscreenLoginState.this, (FullscreenLoginPhoneIdlePage) obj);
                return invokeSuspend$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IFullscreenLoginState invokeSuspend$lambda$0(IFullscreenLoginState $loginState, FullscreenLoginPhoneIdlePage $this$override) {
        return $loginState;
    }
}