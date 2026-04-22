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
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IFullscreenLoginPage.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginState;", "action", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$BackToLastPage;", AuthResultCbHelper.ARGS_STATE, "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenActionPage;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine$1$6$1", f = "IFullscreenLoginPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FullscreenLoginStateMachine$1$6$1 extends SuspendLambda implements Function3<IFullscreenLoginAction.BackToLastPage, State<IFullscreenActionPage>, Continuation<? super ChangedState<? extends IFullscreenLoginState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FullscreenLoginStateMachine$1$6$1(Continuation<? super FullscreenLoginStateMachine$1$6$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(IFullscreenLoginAction.BackToLastPage backToLastPage, State<IFullscreenActionPage> state, Continuation<? super ChangedState<? extends IFullscreenLoginState>> continuation) {
        FullscreenLoginStateMachine$1$6$1 fullscreenLoginStateMachine$1$6$1 = new FullscreenLoginStateMachine$1$6$1(continuation);
        fullscreenLoginStateMachine$1$6$1.L$0 = state;
        return fullscreenLoginStateMachine$1$6$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                State state = (State) this.L$0;
                IFullscreenActionPage iFullscreenActionPage = (IFullscreenActionPage) state.getSnapshot();
                if (!(iFullscreenActionPage instanceof FullscreenLoginIdlePage) && !(iFullscreenActionPage instanceof FullscreenLoginPhonePage) && !(iFullscreenActionPage instanceof FullscreenLoginDowngradeState) && !(iFullscreenActionPage instanceof FullscreenPhoneOrPasswordPage) && !Intrinsics.areEqual(iFullscreenActionPage, FullscreenLoginInvalidPage.INSTANCE) && !(iFullscreenActionPage instanceof FullscreenLoginFastPage)) {
                    if ((iFullscreenActionPage instanceof FullscreenLoginPasswordPage) || (iFullscreenActionPage instanceof FullscreenLoginSmsPage)) {
                        return state.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine$1$6$1$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj2) {
                                IFullscreenLoginState root;
                                root = ((IFullscreenActionPage) obj2).getRoot();
                                return root;
                            }
                        });
                    }
                    return state.noChange();
                }
                return state.noChange();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}