package im.session;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import com.tencent.tauth.AuthActivity;
import im.base.IMLog;
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
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/session/IMState;", AuthActivity.ACTION_KEY, "Lim/session/IMActionClickQuickLinkItem;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine$1$1$15$6", f = "IMSessionStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMSessionStateMachine$1$1$15$6 extends SuspendLambda implements Function3<IMActionClickQuickLinkItem, State<IMState>, Continuation<? super ChangedState<? extends IMState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$1$1$15$6(IMSessionStateMachine iMSessionStateMachine, Continuation<? super IMSessionStateMachine$1$1$15$6> continuation) {
        super(3, continuation);
        this.this$0 = iMSessionStateMachine;
    }

    public final Object invoke(IMActionClickQuickLinkItem iMActionClickQuickLinkItem, State<IMState> state, Continuation<? super ChangedState<IMState>> continuation) {
        IMSessionStateMachine$1$1$15$6 iMSessionStateMachine$1$1$15$6 = new IMSessionStateMachine$1$1$15$6(this.this$0, continuation);
        iMSessionStateMachine$1$1$15$6.L$0 = iMActionClickQuickLinkItem;
        iMSessionStateMachine$1$1$15$6.L$1 = state;
        return iMSessionStateMachine$1$1$15$6.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String str;
        final IMActionClickQuickLinkItem action = (IMActionClickQuickLinkItem) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion companion = IMLog.Companion;
                str = this.this$0.sessionLogTag;
                companion.i(str, "点击金刚位 " + action.getItem().getType());
                return state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$1$1$15$6$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        IMState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = IMSessionStateMachine$1$1$15$6.invokeSuspend$lambda$0(IMActionClickQuickLinkItem.this, (IMState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMState invokeSuspend$lambda$0(IMActionClickQuickLinkItem $action, IMState $this$mutate) {
        IMState copy;
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.pageType : null, (r18 & 2) != 0 ? $this$mutate.data : $this$mutate.getData().clearQuickLinkUnread$session_debug($action.getItem()), (r18 & 4) != 0 ? $this$mutate.toast : null, (r18 & 8) != 0 ? $this$mutate.isLoggedIn : false, (r18 & 16) != 0 ? $this$mutate.type : null, (r18 & 32) != 0 ? $this$mutate.clickedSession : null, (r18 & 64) != 0 ? $this$mutate.firstLoad : false, (r18 & 128) != 0 ? $this$mutate.techTrack : null);
        return copy;
    }
}