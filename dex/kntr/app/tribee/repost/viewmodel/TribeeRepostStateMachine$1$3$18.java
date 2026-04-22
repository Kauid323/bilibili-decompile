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
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/repost/state/TribeeRepostState;", "<unused var>", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$EditTitleTextBottomSheetConfirmClick;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/repost/state/TribeeRepostState$TribeeRepostContentState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$1$3$18", f = "TribeeRepostStateMachine.kt", i = {0, 1}, l = {325, 326}, m = "invokeSuspend", n = {"state", "state"}, s = {"L$0", "L$0"}, v = 1)
public final class TribeeRepostStateMachine$1$3$18 extends SuspendLambda implements Function3<TribeeRepostStateAction.EditTitleTextBottomSheetConfirmClick, State<TribeeRepostState.TribeeRepostContentState>, Continuation<? super ChangedState<? extends TribeeRepostState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TribeeRepostStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeRepostStateMachine$1$3$18(TribeeRepostStateMachine tribeeRepostStateMachine, Continuation<? super TribeeRepostStateMachine$1$3$18> continuation) {
        super(3, continuation);
        this.this$0 = tribeeRepostStateMachine;
    }

    public final Object invoke(TribeeRepostStateAction.EditTitleTextBottomSheetConfirmClick editTitleTextBottomSheetConfirmClick, State<TribeeRepostState.TribeeRepostContentState> state, Continuation<? super ChangedState<? extends TribeeRepostState>> continuation) {
        TribeeRepostStateMachine$1$3$18 tribeeRepostStateMachine$1$3$18 = new TribeeRepostStateMachine$1$3$18(this.this$0, continuation);
        tribeeRepostStateMachine$1$3$18.L$0 = state;
        return tribeeRepostStateMachine$1$3$18.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0085 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        long j;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Long first = ((TribeeRepostState.TribeeRepostContentState) state.getSnapshot()).getSelectedTribee().getFirst();
                long longValue = first != null ? first.longValue() : 0L;
                Long first2 = ((TribeeRepostState.TribeeRepostContentState) state.getSnapshot()).getSelectedPartition().getFirst();
                long longValue2 = first2 != null ? first2.longValue() : 0L;
                j = this.this$0.originDynamicId;
                TribeeRepostTrackKt.addTitleBottomSheetConfirmClick(longValue, longValue2, String.valueOf(j));
                this.L$0 = state;
                this.label = 1;
                if (this.this$0.dispatch(TribeeRepostStateAction.DismissEditTitleTextBottomSheet.INSTANCE, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.L$0 = state;
                this.label = 2;
                if (this.this$0.dispatch(new TribeeRepostStateAction.RequestRepost(2), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return state.mutate(new Function1() { // from class: kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$1$3$18$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        TribeeRepostState.TribeeRepostContentState copy$default;
                        copy$default = TribeeRepostState.TribeeRepostContentState.copy$default((TribeeRepostState.TribeeRepostContentState) obj, null, null, null, false, null, null, false, false, null, null, null, null, false, false, 12287, null);
                        return copy$default;
                    }
                });
            case 1:
                ResultKt.throwOnFailure($result);
                this.L$0 = state;
                this.label = 2;
                if (this.this$0.dispatch(new TribeeRepostStateAction.RequestRepost(2), (Continuation) this) == coroutine_suspended) {
                }
                return state.mutate(new Function1() { // from class: kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$1$3$18$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        TribeeRepostState.TribeeRepostContentState copy$default;
                        copy$default = TribeeRepostState.TribeeRepostContentState.copy$default((TribeeRepostState.TribeeRepostContentState) obj, null, null, null, false, null, null, false, false, null, null, null, null, false, false, 12287, null);
                        return copy$default;
                    }
                });
            case 2:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$1$3$18$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        TribeeRepostState.TribeeRepostContentState copy$default;
                        copy$default = TribeeRepostState.TribeeRepostContentState.copy$default((TribeeRepostState.TribeeRepostContentState) obj, null, null, null, false, null, null, false, false, null, null, null, null, false, false, 12287, null);
                        return copy$default;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}