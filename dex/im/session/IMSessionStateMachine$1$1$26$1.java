package im.session;

import com.bapis.bilibili.app.im.v1.KAutoReplyToast;
import com.bapis.bilibili.app.im.v1.KBehaviorAlertToast;
import com.bapis.bilibili.app.im.v1.KSessionListExtraInfo;
import com.bilibili.blens.BSetter;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.session.model.IMSessionPageDataLensKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/session/IMState;", "<unused var>", "Lim/session/IMActionDismissBehaviorAlert;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine$1$1$26$1", f = "IMSessionStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMSessionStateMachine$1$1$26$1 extends SuspendLambda implements Function3<IMActionDismissBehaviorAlert, State<IMState>, Continuation<? super ChangedState<? extends IMState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMSessionStateMachine$1$1$26$1(Continuation<? super IMSessionStateMachine$1$1$26$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(IMActionDismissBehaviorAlert iMActionDismissBehaviorAlert, State<IMState> state, Continuation<? super ChangedState<IMState>> continuation) {
        IMSessionStateMachine$1$1$26$1 iMSessionStateMachine$1$1$26$1 = new IMSessionStateMachine$1$1$26$1(continuation);
        iMSessionStateMachine$1$1$26$1.L$0 = state;
        return iMSessionStateMachine$1$1$26$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$1$1$26$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        IMState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = IMSessionStateMachine$1$1$26$1.invokeSuspend$lambda$0((IMState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMState invokeSuspend$lambda$0(IMState $this$mutate) {
        final BSimpleLens lens = IMSessionPageDataLensKt.getExtraInfo(IMStateLensKt.getData(IMState.Companion));
        return (IMState) CopyScopeKt.copy($this$mutate, new Function1() { // from class: im.session.IMSessionStateMachine$1$1$26$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = IMSessionStateMachine$1$1$26$1.invokeSuspend$lambda$0$0(lens, (CopyScope) obj);
                return invokeSuspend$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(BSimpleLens $lens, CopyScope $this$copy) {
        KSessionListExtraInfo currentExtra = (KSessionListExtraInfo) $lens.get($this$copy.getCurrent());
        $this$copy.set((BSetter) $lens, currentExtra != null ? KSessionListExtraInfo.copy$default(currentExtra, (KAutoReplyToast) null, false, (String) null, (KBehaviorAlertToast) null, 5, (Object) null) : null);
        return Unit.INSTANCE;
    }
}