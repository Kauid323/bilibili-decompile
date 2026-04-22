package im.session;

import com.tencent.smtt.sdk.TbsListener;
import im.session.model.IMSessionAlert;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionStateMachine.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lim/session/IMState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine$1$1$28$1", f = "IMSessionStateMachine.kt", i = {0, 0, 0}, l = {TbsListener.ErrorCode.INFO_INITX5_FALSE_DEFAULT}, m = "invokeSuspend", n = {"it", "it", "$i$a$-let-IMSessionStateMachine$1$1$28$1$1"}, s = {"L$0", "L$1", "I$0"}, v = 1)
public final class IMSessionStateMachine$1$1$28$1 extends SuspendLambda implements Function2<IMState, Continuation<? super Unit>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$1$1$28$1(IMSessionStateMachine iMSessionStateMachine, Continuation<? super IMSessionStateMachine$1$1$28$1> continuation) {
        super(2, continuation);
        this.this$0 = iMSessionStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> iMSessionStateMachine$1$1$28$1 = new IMSessionStateMachine$1$1$28$1(this.this$0, continuation);
        iMSessionStateMachine$1$1$28$1.L$0 = obj;
        return iMSessionStateMachine$1$1$28$1;
    }

    public final Object invoke(IMState iMState, Continuation<? super Unit> continuation) {
        return create(iMState, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IMState it = (IMState) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMSessionAlert it2 = it.getData().getAlert$session_debug();
                if (it2 != null) {
                    IMSessionStateMachine iMSessionStateMachine = this.this$0;
                    IMActionAlertShow iMActionAlertShow = new IMActionAlertShow(it2);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(it2);
                    this.I$0 = 0;
                    this.label = 1;
                    if (iMSessionStateMachine.dispatch(iMActionAlertShow, this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                int i2 = this.I$0;
                IMSessionAlert iMSessionAlert = (IMSessionAlert) this.L$1;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}