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
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/photonic/aphro/core/AphroState;", "action", "Lkntr/common/photonic/aphro/core/AphroAction$CheckUseOriginImage;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/common/photonic/aphro/core/AphroState$AphroContent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.core.AphroStateMachine$handleOriginImage$1", f = "AphroStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class AphroStateMachine$handleOriginImage$1 extends SuspendLambda implements Function3<AphroAction.CheckUseOriginImage, State<AphroState.AphroContent>, Continuation<? super ChangedState<? extends AphroState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AphroStateMachine$handleOriginImage$1(Continuation<? super AphroStateMachine$handleOriginImage$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(AphroAction.CheckUseOriginImage checkUseOriginImage, State<AphroState.AphroContent> state, Continuation<? super ChangedState<? extends AphroState>> continuation) {
        AphroStateMachine$handleOriginImage$1 aphroStateMachine$handleOriginImage$1 = new AphroStateMachine$handleOriginImage$1(continuation);
        aphroStateMachine$handleOriginImage$1.L$0 = checkUseOriginImage;
        aphroStateMachine$handleOriginImage$1.L$1 = state;
        return aphroStateMachine$handleOriginImage$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final AphroAction.CheckUseOriginImage action = (AphroAction.CheckUseOriginImage) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.common.photonic.aphro.core.AphroStateMachine$handleOriginImage$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        AphroState.AphroContent invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = AphroStateMachine$handleOriginImage$1.invokeSuspend$lambda$0(AphroAction.CheckUseOriginImage.this, (AphroState.AphroContent) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AphroState.AphroContent invokeSuspend$lambda$0(AphroAction.CheckUseOriginImage $action, AphroState.AphroContent $this$mutate) {
        AphroState.AphroContent copy;
        copy = $this$mutate.copy((r24 & 1) != 0 ? $this$mutate.status : null, (r24 & 2) != 0 ? $this$mutate.selectedAlbum : null, (r24 & 4) != 0 ? $this$mutate.albumList : null, (r24 & 8) != 0 ? $this$mutate.assetsState : null, (r24 & 16) != 0 ? $this$mutate.option : null, (r24 & 32) != 0 ? $this$mutate.useOriginImage : $action.getUseOriginImage(), (r24 & 64) != 0 ? $this$mutate.confirmed : false, (r24 & 128) != 0 ? $this$mutate.selected : null, (r24 & 256) != 0 ? $this$mutate.albumRefresh : 0, (r24 & 512) != 0 ? $this$mutate.requiredAssetCount : 0, (r24 & 1024) != 0 ? $this$mutate.toast : null);
        return copy;
    }
}