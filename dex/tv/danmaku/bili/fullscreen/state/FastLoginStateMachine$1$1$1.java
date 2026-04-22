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
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FastLoginPage.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/fullscreen/state/IFastLoginPage;", "action", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$AgreementCheckedAction;", AuthResultCbHelper.ARGS_STATE, "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/fullscreen/state/FastLoginPage;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.FastLoginStateMachine$1$1$1", f = "FastLoginPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FastLoginStateMachine$1$1$1 extends SuspendLambda implements Function3<IFullscreenLoginAction.AgreementCheckedAction, State<FastLoginPage>, Continuation<? super ChangedState<? extends IFastLoginPage>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FastLoginStateMachine$1$1$1(Continuation<? super FastLoginStateMachine$1$1$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(IFullscreenLoginAction.AgreementCheckedAction agreementCheckedAction, State<FastLoginPage> state, Continuation<? super ChangedState<? extends IFastLoginPage>> continuation) {
        FastLoginStateMachine$1$1$1 fastLoginStateMachine$1$1$1 = new FastLoginStateMachine$1$1$1(continuation);
        fastLoginStateMachine$1$1$1.L$0 = agreementCheckedAction;
        fastLoginStateMachine$1$1$1.L$1 = state;
        return fastLoginStateMachine$1$1$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                final IFullscreenLoginAction.AgreementCheckedAction action = (IFullscreenLoginAction.AgreementCheckedAction) this.L$0;
                State state = (State) this.L$1;
                BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "on agreement checked " + action.getChecked());
                return state.mutate(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FastLoginStateMachine$1$1$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        FastLoginPage invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = FastLoginStateMachine$1$1$1.invokeSuspend$lambda$0(IFullscreenLoginAction.AgreementCheckedAction.this, (FastLoginPage) obj2);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FastLoginPage invokeSuspend$lambda$0(IFullscreenLoginAction.AgreementCheckedAction $action, FastLoginPage $this$mutate) {
        FastLoginPage copy;
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.account : null, (r20 & 2) != 0 ? $this$mutate.agreementChecked : $action.getChecked(), (r20 & 4) != 0 ? $this$mutate.eulaDisplay : null, (r20 & 8) != 0 ? $this$mutate.loggedIn : false, (r20 & 16) != 0 ? $this$mutate.showLoading : false, (r20 & 32) != 0 ? $this$mutate.loginType : null, (r20 & 64) != 0 ? $this$mutate.redirect : null, (r20 & BR.cover) != 0 ? $this$mutate.captchaDisplay : null, (r20 & BR.hallEnterHotText) != 0 ? $this$mutate.toastInfo : null);
        return copy;
    }
}