package im.session;

import com.bapis.bilibili.broadcast.message.im.KUpdateQuickLinkCommand;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.base.IMLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/session/IMState;", "<unused var>", "Lcom/bapis/bilibili/broadcast/message/im/KUpdateQuickLinkCommand;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine$updateBlock$5", f = "IMSessionStateMachine.kt", i = {0}, l = {583}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class IMSessionStateMachine$updateBlock$5 extends SuspendLambda implements Function3<KUpdateQuickLinkCommand, State<IMState>, Continuation<? super ChangedState<? extends IMState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$updateBlock$5(IMSessionStateMachine iMSessionStateMachine, Continuation<? super IMSessionStateMachine$updateBlock$5> continuation) {
        super(3, continuation);
        this.this$0 = iMSessionStateMachine;
    }

    public final Object invoke(KUpdateQuickLinkCommand kUpdateQuickLinkCommand, State<IMState> state, Continuation<? super ChangedState<IMState>> continuation) {
        IMSessionStateMachine$updateBlock$5 iMSessionStateMachine$updateBlock$5 = new IMSessionStateMachine$updateBlock$5(this.this$0, continuation);
        iMSessionStateMachine$updateBlock$5.L$0 = state;
        return iMSessionStateMachine$updateBlock$5.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String str;
        Object updateQuickLink;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion companion = IMLog.Companion;
                str = this.this$0.sessionLogTag;
                companion.i(str, "刷新金刚位未读数");
                this.L$0 = SpillingKt.nullOutSpilledVariable(state);
                this.label = 1;
                updateQuickLink = this.this$0.updateQuickLink(state, (Continuation) this);
                if (updateQuickLink == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return updateQuickLink;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}