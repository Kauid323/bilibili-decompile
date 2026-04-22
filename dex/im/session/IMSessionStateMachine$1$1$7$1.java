package im.session;

import com.bapis.bilibili.app.im.v1.KSessionPageType;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.session.service.IMSessionDataSourceServiceLike;
import kotlin.Metadata;
import kotlin.Result;
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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/session/IMState;", "it", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine$1$1$7$1", f = "IMSessionStateMachine.kt", i = {0, 1}, l = {147, 146}, m = "invokeSuspend", n = {"it", "it"}, s = {"L$0", "L$0"}, v = 1)
public final class IMSessionStateMachine$1$1$7$1 extends SuspendLambda implements Function2<State<IMState>, Continuation<? super ChangedState<? extends IMState>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$1$1$7$1(IMSessionStateMachine iMSessionStateMachine, Continuation<? super IMSessionStateMachine$1$1$7$1> continuation) {
        super(2, continuation);
        this.this$0 = iMSessionStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> iMSessionStateMachine$1$1$7$1 = new IMSessionStateMachine$1$1$7$1(this.this$0, continuation);
        iMSessionStateMachine$1$1$7$1.L$0 = obj;
        return iMSessionStateMachine$1$1$7$1;
    }

    public final Object invoke(State<IMState> state, Continuation<? super ChangedState<IMState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IMSessionDataSourceServiceLike iMSessionDataSourceServiceLike;
        KSessionPageType kSessionPageType;
        State state;
        IMSessionStateMachine iMSessionStateMachine;
        Object obj;
        State it = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMSessionStateMachine iMSessionStateMachine2 = this.this$0;
                iMSessionDataSourceServiceLike = this.this$0.dataSourceService;
                kSessionPageType = this.this$0.pageType;
                this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                this.L$1 = iMSessionStateMachine2;
                this.L$2 = it;
                this.label = 1;
                Object mo3356loadNext0E7RQCE = iMSessionDataSourceServiceLike.mo3356loadNext0E7RQCE(kSessionPageType, (IMState) it.getSnapshot(), (Continuation) this);
                if (mo3356loadNext0E7RQCE == coroutine_suspended) {
                    return coroutine_suspended;
                }
                state = it;
                iMSessionStateMachine = iMSessionStateMachine2;
                obj = mo3356loadNext0E7RQCE;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                state = (State) this.L$2;
                iMSessionStateMachine = (IMSessionStateMachine) this.L$1;
                obj = ((Result) $result).unbox-impl();
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.L$0 = SpillingKt.nullOutSpilledVariable(it);
        this.L$1 = null;
        this.L$2 = null;
        this.label = 2;
        Object receive$default = IMSessionStateMachine.receive$default(iMSessionStateMachine, state, obj, true, false, (Continuation) this, 4, null);
        if (receive$default == coroutine_suspended) {
            return coroutine_suspended;
        }
        return receive$default;
    }
}