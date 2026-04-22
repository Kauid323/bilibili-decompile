package kntr.app.tribee.repost.viewmodel;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.repost.action.TribeeRepostStateAction;
import kntr.app.tribee.repost.state.TribeeRepostState;
import kntr.app.tribee.repost.track.TribeeRepostTrackKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeRepostStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/repost/state/TribeeRepostState;", "action", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$SelectedTribeeOrPartitionChanged;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/repost/state/TribeeRepostState$TribeeRepostContentState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$1$3$4", f = "TribeeRepostStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeRepostStateMachine$1$3$4 extends SuspendLambda implements Function3<TribeeRepostStateAction.SelectedTribeeOrPartitionChanged, State<TribeeRepostState.TribeeRepostContentState>, Continuation<? super ChangedState<? extends TribeeRepostState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ TribeeRepostStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeRepostStateMachine$1$3$4(TribeeRepostStateMachine tribeeRepostStateMachine, Continuation<? super TribeeRepostStateMachine$1$3$4> continuation) {
        super(3, continuation);
        this.this$0 = tribeeRepostStateMachine;
    }

    public final Object invoke(TribeeRepostStateAction.SelectedTribeeOrPartitionChanged selectedTribeeOrPartitionChanged, State<TribeeRepostState.TribeeRepostContentState> state, Continuation<? super ChangedState<? extends TribeeRepostState>> continuation) {
        TribeeRepostStateMachine$1$3$4 tribeeRepostStateMachine$1$3$4 = new TribeeRepostStateMachine$1$3$4(this.this$0, continuation);
        tribeeRepostStateMachine$1$3$4.L$0 = selectedTribeeOrPartitionChanged;
        tribeeRepostStateMachine$1$3$4.L$1 = state;
        return tribeeRepostStateMachine$1$3$4.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        long j;
        final TribeeRepostStateAction.SelectedTribeeOrPartitionChanged action = (TribeeRepostStateAction.SelectedTribeeOrPartitionChanged) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (action.getByUserClick()) {
                    Long first = action.getTribee().getFirst();
                    long longValue = first != null ? first.longValue() : 0L;
                    String second = action.getTribee().getSecond();
                    String str = second == null ? "" : second;
                    Long first2 = action.getPartition().getFirst();
                    long longValue2 = first2 != null ? first2.longValue() : 0L;
                    String second2 = action.getPartition().getSecond();
                    String str2 = second2 == null ? "" : second2;
                    j = this.this$0.originDynamicId;
                    TribeeRepostTrackKt.selectTribeeBottomSheetItemClick(longValue, str, longValue2, str2, String.valueOf(j));
                }
                return state.mutate(new Function1() { // from class: kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$1$3$4$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        TribeeRepostState.TribeeRepostContentState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = TribeeRepostStateMachine$1$3$4.invokeSuspend$lambda$0(TribeeRepostStateAction.SelectedTribeeOrPartitionChanged.this, (TribeeRepostState.TribeeRepostContentState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeRepostState.TribeeRepostContentState invokeSuspend$lambda$0(TribeeRepostStateAction.SelectedTribeeOrPartitionChanged $action, TribeeRepostState.TribeeRepostContentState $this$mutate) {
        TribeeRepostState.TribeeRepostContentState copy;
        copy = $this$mutate.copy((r30 & 1) != 0 ? $this$mutate.uiAction : null, (r30 & 2) != 0 ? $this$mutate.data : null, (r30 & 4) != 0 ? $this$mutate.introBottomSheetState : null, (r30 & 8) != 0 ? $this$mutate.showSelectTribeeBottomSheet : false, (r30 & 16) != 0 ? $this$mutate.editRepostMainTextBottomSheetState : null, (r30 & 32) != 0 ? $this$mutate.editRepostTitleTextBottomSheetState : null, (r30 & 64) != 0 ? $this$mutate.enableRepostToFollowing : false, (r30 & 128) != 0 ? $this$mutate.enableRepostWithSource : false, (r30 & 256) != 0 ? $this$mutate.repostMainText : null, (r30 & 512) != 0 ? $this$mutate.repostTitleText : null, (r30 & 1024) != 0 ? $this$mutate.selectedTribee : $action.getTribee(), (r30 & 2048) != 0 ? $this$mutate.selectedPartition : $action.getPartition(), (r30 & 4096) != 0 ? $this$mutate.enableClickPageRepost : false, (r30 & 8192) != 0 ? $this$mutate.hasLoadedSelectTribeeBottomSheet : false);
        return copy;
    }
}