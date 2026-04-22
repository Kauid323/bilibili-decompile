package kntr.common.photonic.aphro.core.assets;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.core.assets.AphroAssetsState;
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
/* compiled from: AphroAssetsStateMachine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsState;", "it", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsState$Init;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.core.assets.AphroAssetsStateMachine$initLoad$1$1", f = "AphroAssetsStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AphroAssetsStateMachine$initLoad$1$1 extends SuspendLambda implements Function2<State<AphroAssetsState.Init>, Continuation<? super ChangedState<? extends AphroAssetsState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AphroAssetsStateMachine$initLoad$1$1(Continuation<? super AphroAssetsStateMachine$initLoad$1$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> aphroAssetsStateMachine$initLoad$1$1 = new AphroAssetsStateMachine$initLoad$1$1(continuation);
        aphroAssetsStateMachine$initLoad$1$1.L$0 = obj;
        return aphroAssetsStateMachine$initLoad$1$1;
    }

    public final Object invoke(State<AphroAssetsState.Init> state, Continuation<? super ChangedState<? extends AphroAssetsState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State it = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return it.override(new Function1() { // from class: kntr.common.photonic.aphro.core.assets.AphroAssetsStateMachine$initLoad$1$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        AphroAssetsState.LoadingAssets invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = AphroAssetsStateMachine$initLoad$1$1.invokeSuspend$lambda$0((AphroAssetsState.Init) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AphroAssetsState.LoadingAssets invokeSuspend$lambda$0(AphroAssetsState.Init $this$override) {
        return new AphroAssetsState.LoadingAssets($this$override.getAlbumInfo(), $this$override.getRequiredAssetCount());
    }
}