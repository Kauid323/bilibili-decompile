package kntr.common.photonic.aphro.core;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.core.AphroAction;
import kntr.common.photonic.aphro.core.AphroState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: AphroStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/photonic/aphro/core/AphroState;", "<unused var>", "Lkntr/common/photonic/aphro/core/AphroAction$ConsumeConfirm;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/common/photonic/aphro/core/AphroState$AphroContent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.core.AphroStateMachine$handleConfirm$2", f = "AphroStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class AphroStateMachine$handleConfirm$2 extends SuspendLambda implements Function3<AphroAction.ConsumeConfirm, State<AphroState.AphroContent>, Continuation<? super ChangedState<? extends AphroState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AphroStateMachine$handleConfirm$2(Continuation<? super AphroStateMachine$handleConfirm$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(AphroAction.ConsumeConfirm consumeConfirm, State<AphroState.AphroContent> state, Continuation<? super ChangedState<? extends AphroState>> continuation) {
        AphroStateMachine$handleConfirm$2 aphroStateMachine$handleConfirm$2 = new AphroStateMachine$handleConfirm$2(continuation);
        aphroStateMachine$handleConfirm$2.L$0 = state;
        return aphroStateMachine$handleConfirm$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.common.photonic.aphro.core.AphroStateMachine$handleConfirm$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        AphroState.AphroContent copy$default;
                        copy$default = AphroState.AphroContent.copy$default((AphroState.AphroContent) obj, null, null, null, null, null, false, false, null, 0, 0, null, 1983, null);
                        return copy$default;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}