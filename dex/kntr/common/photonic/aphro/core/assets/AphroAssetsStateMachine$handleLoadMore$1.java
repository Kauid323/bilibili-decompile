package kntr.common.photonic.aphro.core.assets;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kntr.common.photonic.aphro.core.assets.AphroAssetsAction;
import kntr.common.photonic.aphro.core.assets.AphroAssetsState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AphroAssetsStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsState;", "action", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsAction$LoadMore;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsState$AphroContent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.core.assets.AphroAssetsStateMachine$handleLoadMore$1", f = "AphroAssetsStateMachine.kt", i = {0}, l = {98}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class AphroAssetsStateMachine$handleLoadMore$1 extends SuspendLambda implements Function3<AphroAssetsAction.LoadMore, State<AphroAssetsState.AphroContent>, Continuation<? super ChangedState<? extends AphroAssetsState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AphroAssetsStateMachine$handleLoadMore$1(Continuation<? super AphroAssetsStateMachine$handleLoadMore$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(AphroAssetsAction.LoadMore loadMore, State<AphroAssetsState.AphroContent> state, Continuation<? super ChangedState<? extends AphroAssetsState>> continuation) {
        AphroAssetsStateMachine$handleLoadMore$1 aphroAssetsStateMachine$handleLoadMore$1 = new AphroAssetsStateMachine$handleLoadMore$1(continuation);
        aphroAssetsStateMachine$handleLoadMore$1.L$0 = state;
        return aphroAssetsStateMachine$handleLoadMore$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final List nextPage;
        Object obj;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ReceiveChannel<List<Asset>> reader$core_debug = ((AphroAssetsState.AphroContent) state.getSnapshot()).getReader$core_debug();
                if (reader$core_debug == null) {
                    nextPage = null;
                    break;
                } else {
                    this.L$0 = state;
                    this.label = 1;
                    Object obj2 = reader$core_debug.receiveCatching-JP2dKIU((Continuation) this);
                    if (obj2 != coroutine_suspended) {
                        obj = obj2;
                        nextPage = (List) ChannelResult.getOrNull-impl(obj);
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                }
            case 1:
                ResultKt.throwOnFailure($result);
                obj = ((ChannelResult) $result).unbox-impl();
                nextPage = (List) ChannelResult.getOrNull-impl(obj);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return (nextPage == null || nextPage.isEmpty()) ? state.noChange() : state.mutate(new Function1() { // from class: kntr.common.photonic.aphro.core.assets.AphroAssetsStateMachine$handleLoadMore$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj3) {
                AphroAssetsState.AphroContent invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = AphroAssetsStateMachine$handleLoadMore$1.invokeSuspend$lambda$0(nextPage, (AphroAssetsState.AphroContent) obj3);
                return invokeSuspend$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AphroAssetsState.AphroContent invokeSuspend$lambda$0(List $nextPage, AphroAssetsState.AphroContent $this$mutate) {
        return AphroAssetsState.AphroContent.copy$default($this$mutate, null, null, CollectionsKt.plus($this$mutate.getAssetList(), $nextPage), 3, null);
    }
}