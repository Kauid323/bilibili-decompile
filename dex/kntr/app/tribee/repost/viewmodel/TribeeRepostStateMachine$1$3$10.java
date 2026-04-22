package kntr.app.tribee.repost.viewmodel;

import androidx.compose.ui.unit.Dp;
import bili.resource.tribee.String0_commonMainKt;
import bili.resource.tribee.TribeeRes;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.repost.action.TribeeRepostStateAction;
import kntr.app.tribee.repost.page.editTextBottomSheet.EditTextBottomSheetState;
import kntr.app.tribee.repost.state.TribeeRepostState;
import kntr.app.tribee.repost.track.SwitchTrackPosition;
import kntr.app.tribee.repost.track.TribeeRepostTrackKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.jetbrains.compose.resources.StringResourcesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeRepostStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/repost/state/TribeeRepostState;", "<unused var>", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$ShowEditMainTextBottomSheet;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/repost/state/TribeeRepostState$TribeeRepostContentState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$1$3$10", f = "TribeeRepostStateMachine.kt", i = {0, 1, 1, 2, 2, 2}, l = {230, 231, 232}, m = "invokeSuspend", n = {"state", "state", "title", "state", "title", "placeholder"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2"}, v = 1)
public final class TribeeRepostStateMachine$1$3$10 extends SuspendLambda implements Function3<TribeeRepostStateAction.ShowEditMainTextBottomSheet, State<TribeeRepostState.TribeeRepostContentState>, Continuation<? super ChangedState<? extends TribeeRepostState>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ TribeeRepostStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeRepostStateMachine$1$3$10(TribeeRepostStateMachine tribeeRepostStateMachine, Continuation<? super TribeeRepostStateMachine$1$3$10> continuation) {
        super(3, continuation);
        this.this$0 = tribeeRepostStateMachine;
    }

    public final Object invoke(TribeeRepostStateAction.ShowEditMainTextBottomSheet showEditMainTextBottomSheet, State<TribeeRepostState.TribeeRepostContentState> state, Continuation<? super ChangedState<? extends TribeeRepostState>> continuation) {
        TribeeRepostStateMachine$1$3$10 tribeeRepostStateMachine$1$3$10 = new TribeeRepostStateMachine$1$3$10(this.this$0, continuation);
        tribeeRepostStateMachine$1$3$10.L$0 = state;
        return tribeeRepostStateMachine$1$3$10.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0099 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        long j;
        Object string;
        final String title;
        Object string2;
        Object string3;
        final String placeholder;
        final State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                SwitchTrackPosition switchTrackPosition = SwitchTrackPosition.EditText;
                j = this.this$0.originDynamicId;
                TribeeRepostTrackKt.switchClick$default(switchTrackPosition, null, String.valueOf(j), 2, null);
                this.L$0 = state;
                this.label = 1;
                string = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_52(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string == coroutine_suspended) {
                    return coroutine_suspended;
                }
                title = (String) string;
                this.L$0 = state;
                this.L$1 = title;
                this.label = 2;
                string2 = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_63(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                String placeholder2 = (String) string2;
                this.L$0 = state;
                this.L$1 = title;
                this.L$2 = placeholder2;
                this.label = 3;
                string3 = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_64(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                placeholder = placeholder2;
                final String buttonText = (String) string3;
                return state.mutate(new Function1() { // from class: kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$1$3$10$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        TribeeRepostState.TribeeRepostContentState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = TribeeRepostStateMachine$1$3$10.invokeSuspend$lambda$0(state, title, placeholder, buttonText, (TribeeRepostState.TribeeRepostContentState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            case 1:
                ResultKt.throwOnFailure($result);
                string = $result;
                title = (String) string;
                this.L$0 = state;
                this.L$1 = title;
                this.label = 2;
                string2 = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_63(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string2 == coroutine_suspended) {
                }
                String placeholder22 = (String) string2;
                this.L$0 = state;
                this.L$1 = title;
                this.L$2 = placeholder22;
                this.label = 3;
                string3 = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_64(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string3 == coroutine_suspended) {
                }
                break;
            case 2:
                title = (String) this.L$1;
                ResultKt.throwOnFailure($result);
                string2 = $result;
                String placeholder222 = (String) string2;
                this.L$0 = state;
                this.L$1 = title;
                this.L$2 = placeholder222;
                this.label = 3;
                string3 = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_64(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string3 == coroutine_suspended) {
                }
                break;
            case 3:
                placeholder = (String) this.L$2;
                title = (String) this.L$1;
                ResultKt.throwOnFailure($result);
                string3 = $result;
                final String buttonText2 = (String) string3;
                return state.mutate(new Function1() { // from class: kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$1$3$10$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        TribeeRepostState.TribeeRepostContentState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = TribeeRepostStateMachine$1$3$10.invokeSuspend$lambda$0(state, title, placeholder, buttonText2, (TribeeRepostState.TribeeRepostContentState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeRepostState.TribeeRepostContentState invokeSuspend$lambda$0(State $state, String $title, String $placeholder, String $buttonText, TribeeRepostState.TribeeRepostContentState $this$mutate) {
        TribeeRepostState.TribeeRepostContentState copy;
        copy = $this$mutate.copy((r30 & 1) != 0 ? $this$mutate.uiAction : null, (r30 & 2) != 0 ? $this$mutate.data : null, (r30 & 4) != 0 ? $this$mutate.introBottomSheetState : null, (r30 & 8) != 0 ? $this$mutate.showSelectTribeeBottomSheet : false, (r30 & 16) != 0 ? $this$mutate.editRepostMainTextBottomSheetState : new EditTextBottomSheetState($title, null, ((TribeeRepostState.TribeeRepostContentState) $state.getSnapshot()).getRepostMainText(), $placeholder, MediaAttrUtils.TYPE_PAY_SEASON, $buttonText, Dp.constructor-impl(160), 2, null), (r30 & 32) != 0 ? $this$mutate.editRepostTitleTextBottomSheetState : null, (r30 & 64) != 0 ? $this$mutate.enableRepostToFollowing : false, (r30 & 128) != 0 ? $this$mutate.enableRepostWithSource : false, (r30 & 256) != 0 ? $this$mutate.repostMainText : null, (r30 & 512) != 0 ? $this$mutate.repostTitleText : null, (r30 & 1024) != 0 ? $this$mutate.selectedTribee : null, (r30 & 2048) != 0 ? $this$mutate.selectedPartition : null, (r30 & 4096) != 0 ? $this$mutate.enableClickPageRepost : false, (r30 & 8192) != 0 ? $this$mutate.hasLoadedSelectTribeeBottomSheet : false);
        return copy;
    }
}