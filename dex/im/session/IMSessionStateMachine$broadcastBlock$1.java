package im.session;

import com.bapis.bilibili.broadcast.message.im.KReqServerNotify;
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
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "notify", "Lcom/bapis/bilibili/broadcast/message/im/KReqServerNotify;", "state", "Lim/session/IMState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine$broadcastBlock$1", f = "IMSessionStateMachine.kt", i = {0, 0}, l = {799}, m = "invokeSuspend", n = {"notify", "state"}, s = {"L$0", "L$1"}, v = 1)
public final class IMSessionStateMachine$broadcastBlock$1 extends SuspendLambda implements Function3<KReqServerNotify, IMState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$broadcastBlock$1(IMSessionStateMachine iMSessionStateMachine, Continuation<? super IMSessionStateMachine$broadcastBlock$1> continuation) {
        super(3, continuation);
        this.this$0 = iMSessionStateMachine;
    }

    public final Object invoke(KReqServerNotify kReqServerNotify, IMState iMState, Continuation<? super Unit> continuation) {
        IMSessionStateMachine$broadcastBlock$1 iMSessionStateMachine$broadcastBlock$1 = new IMSessionStateMachine$broadcastBlock$1(this.this$0, continuation);
        iMSessionStateMachine$broadcastBlock$1.L$0 = kReqServerNotify;
        iMSessionStateMachine$broadcastBlock$1.L$1 = iMState;
        return iMSessionStateMachine$broadcastBlock$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object broadcastReceived;
        KReqServerNotify notify = (KReqServerNotify) this.L$0;
        IMState state = (IMState) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(notify);
                this.L$1 = SpillingKt.nullOutSpilledVariable(state);
                this.label = 1;
                broadcastReceived = this.this$0.broadcastReceived(notify, state, (Continuation) this);
                if (broadcastReceived == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}