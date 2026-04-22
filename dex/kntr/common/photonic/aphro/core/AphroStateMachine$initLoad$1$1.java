package kntr.common.photonic.aphro.core;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.core.AphroState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AphroStateMachine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/photonic/aphro/core/AphroState;", "it", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/common/photonic/aphro/core/AphroState$Init;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.core.AphroStateMachine$initLoad$1$1", f = "AphroStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AphroStateMachine$initLoad$1$1 extends SuspendLambda implements Function2<State<AphroState.Init>, Continuation<? super ChangedState<? extends AphroState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AphroStateMachine$initLoad$1$1(Continuation<? super AphroStateMachine$initLoad$1$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> aphroStateMachine$initLoad$1$1 = new AphroStateMachine$initLoad$1$1(continuation);
        aphroStateMachine$initLoad$1$1.L$0 = obj;
        return aphroStateMachine$initLoad$1$1;
    }

    public final Object invoke(State<AphroState.Init> state, Continuation<? super ChangedState<? extends AphroState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State it = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return it.override(new Function1() { // from class: kntr.common.photonic.aphro.core.AphroStateMachine$initLoad$1$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        AphroState.LoadingAlbum invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = AphroStateMachine$initLoad$1$1.invokeSuspend$lambda$0((AphroState.Init) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AphroState.LoadingAlbum invokeSuspend$lambda$0(AphroState.Init $this$override) {
        return new AphroState.LoadingAlbum($this$override.getPreSelected(), $this$override.getOption(), $this$override.getRequiredAssetCount(), $this$override.getInitialAlbumId());
    }
}