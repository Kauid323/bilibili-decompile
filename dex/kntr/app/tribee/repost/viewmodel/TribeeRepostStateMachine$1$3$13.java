package kntr.app.tribee.repost.viewmodel;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.repost.action.TribeeRepostStateAction;
import kntr.app.tribee.repost.state.TribeeRepostState;
import kntr.app.tribee.repost.track.RepostToFollowingBottomSheetTrackType;
import kntr.app.tribee.repost.track.TribeeRepostTrackKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeRepostStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/repost/state/TribeeRepostState;", "<unused var>", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$EditMainTextBottomSheetConfirmClick;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/repost/state/TribeeRepostState$TribeeRepostContentState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$1$3$13", f = "TribeeRepostStateMachine.kt", i = {0}, l = {269}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class TribeeRepostStateMachine$1$3$13 extends SuspendLambda implements Function3<TribeeRepostStateAction.EditMainTextBottomSheetConfirmClick, State<TribeeRepostState.TribeeRepostContentState>, Continuation<? super ChangedState<? extends TribeeRepostState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TribeeRepostStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeRepostStateMachine$1$3$13(TribeeRepostStateMachine tribeeRepostStateMachine, Continuation<? super TribeeRepostStateMachine$1$3$13> continuation) {
        super(3, continuation);
        this.this$0 = tribeeRepostStateMachine;
    }

    public final Object invoke(TribeeRepostStateAction.EditMainTextBottomSheetConfirmClick editMainTextBottomSheetConfirmClick, State<TribeeRepostState.TribeeRepostContentState> state, Continuation<? super ChangedState<? extends TribeeRepostState>> continuation) {
        TribeeRepostStateMachine$1$3$13 tribeeRepostStateMachine$1$3$13 = new TribeeRepostStateMachine$1$3$13(this.this$0, continuation);
        tribeeRepostStateMachine$1$3$13.L$0 = state;
        return tribeeRepostStateMachine$1$3$13.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        long j;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                RepostToFollowingBottomSheetTrackType repostToFollowingBottomSheetTrackType = RepostToFollowingBottomSheetTrackType.Edit;
                j = this.this$0.originDynamicId;
                TribeeRepostTrackKt.repostToFollowingBottomSheetConfirmClick(repostToFollowingBottomSheetTrackType, String.valueOf(j));
                this.L$0 = state;
                this.label = 1;
                if (this.this$0.dispatch(TribeeRepostStateAction.DismissEditMainTextBottomSheet.INSTANCE, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return state.noChange();
    }
}