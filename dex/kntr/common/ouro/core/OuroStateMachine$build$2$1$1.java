package kntr.common.ouro.core;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.action.OuroAction;
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
/* compiled from: OuroStateMachine.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lkntr/common/ouro/core/action/OuroAction;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.core.OuroStateMachine$build$2$1$1", f = "OuroStateMachine.kt", i = {0}, l = {46}, m = "invokeSuspend", n = {"it"}, s = {"L$0"}, v = 1)
public final class OuroStateMachine$build$2$1$1 extends SuspendLambda implements Function2<OuroAction, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OuroStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OuroStateMachine$build$2$1$1(OuroStateMachine ouroStateMachine, Continuation<? super OuroStateMachine$build$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = ouroStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> ouroStateMachine$build$2$1$1 = new OuroStateMachine$build$2$1$1(this.this$0, continuation);
        ouroStateMachine$build$2$1$1.L$0 = obj;
        return ouroStateMachine$build$2$1$1;
    }

    public final Object invoke(OuroAction ouroAction, Continuation<? super Unit> continuation) {
        return create(ouroAction, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        OuroAction it = (OuroAction) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                this.label = 1;
                if (this.this$0.dispatch(it, (Continuation) this) == coroutine_suspended) {
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