package kntr.app.tribee.repost.viewmodel;

import androidx.compose.ui.unit.Dp;
import bili.resource.tribee.String0_commonMainKt;
import bili.resource.tribee.TribeeRes;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.repost.action.TribeeRepostStateAction;
import kntr.app.tribee.repost.page.editTextBottomSheet.EditTextBottomSheetState;
import kntr.app.tribee.repost.state.TribeeRepostState;
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
import org.jetbrains.compose.resources.StringResourcesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeRepostStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/repost/state/TribeeRepostState;", "<unused var>", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$ShowEditTitleTextBottomSheet;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/repost/state/TribeeRepostState$TribeeRepostContentState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$1$3$15", f = "TribeeRepostStateMachine.kt", i = {0, 1, 1, 2, 2, 2, 3, 3, 3, 3}, l = {286, 287, 288, 289}, m = "invokeSuspend", n = {"state", "state", "title", "state", "title", "subtitle", "state", "title", "subtitle", "placeholder"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"}, v = 1)
public final class TribeeRepostStateMachine$1$3$15 extends SuspendLambda implements Function3<TribeeRepostStateAction.ShowEditTitleTextBottomSheet, State<TribeeRepostState.TribeeRepostContentState>, Continuation<? super ChangedState<? extends TribeeRepostState>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TribeeRepostStateMachine$1$3$15(Continuation<? super TribeeRepostStateMachine$1$3$15> continuation) {
        super(3, continuation);
    }

    public final Object invoke(TribeeRepostStateAction.ShowEditTitleTextBottomSheet showEditTitleTextBottomSheet, State<TribeeRepostState.TribeeRepostContentState> state, Continuation<? super ChangedState<? extends TribeeRepostState>> continuation) {
        TribeeRepostStateMachine$1$3$15 tribeeRepostStateMachine$1$3$15 = new TribeeRepostStateMachine$1$3$15(continuation);
        tribeeRepostStateMachine$1$3$15.L$0 = state;
        return tribeeRepostStateMachine$1$3$15.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object string;
        String title;
        Object string2;
        Object string3;
        String subtitle;
        String title2;
        Object string4;
        String subtitle2;
        String title3;
        String placeholder;
        final State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = state;
                this.label = 1;
                string = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_65(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string == coroutine_suspended) {
                    return coroutine_suspended;
                }
                title = (String) string;
                this.L$0 = state;
                this.L$1 = title;
                this.label = 2;
                string2 = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_66(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                String subtitle3 = (String) string2;
                this.L$0 = state;
                this.L$1 = title;
                this.L$2 = subtitle3;
                this.label = 3;
                string3 = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_67(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                subtitle = title;
                title2 = subtitle3;
                String placeholder2 = (String) string3;
                this.L$0 = state;
                this.L$1 = subtitle;
                this.L$2 = title2;
                this.L$3 = placeholder2;
                this.label = 4;
                string4 = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_68(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string4 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                subtitle2 = title2;
                title3 = subtitle;
                placeholder = placeholder2;
                final String buttonText = (String) string4;
                final String str = title3;
                final String str2 = subtitle2;
                final String str3 = placeholder;
                return state.mutate(new Function1() { // from class: kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$1$3$15$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        TribeeRepostState.TribeeRepostContentState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = TribeeRepostStateMachine$1$3$15.invokeSuspend$lambda$0(state, str, str2, str3, buttonText, (TribeeRepostState.TribeeRepostContentState) obj);
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
                string2 = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_66(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string2 == coroutine_suspended) {
                }
                String subtitle32 = (String) string2;
                this.L$0 = state;
                this.L$1 = title;
                this.L$2 = subtitle32;
                this.label = 3;
                string3 = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_67(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string3 == coroutine_suspended) {
                }
                break;
            case 2:
                title = (String) this.L$1;
                ResultKt.throwOnFailure($result);
                string2 = $result;
                String subtitle322 = (String) string2;
                this.L$0 = state;
                this.L$1 = title;
                this.L$2 = subtitle322;
                this.label = 3;
                string3 = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_67(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string3 == coroutine_suspended) {
                }
                break;
            case 3:
                title2 = (String) this.L$2;
                subtitle = (String) this.L$1;
                ResultKt.throwOnFailure($result);
                string3 = $result;
                String placeholder22 = (String) string3;
                this.L$0 = state;
                this.L$1 = subtitle;
                this.L$2 = title2;
                this.L$3 = placeholder22;
                this.label = 4;
                string4 = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_68(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string4 != coroutine_suspended) {
                }
                break;
            case 4:
                ResultKt.throwOnFailure($result);
                string4 = $result;
                placeholder = (String) this.L$3;
                subtitle2 = (String) this.L$2;
                title3 = (String) this.L$1;
                final String buttonText2 = (String) string4;
                final String str4 = title3;
                final String str22 = subtitle2;
                final String str32 = placeholder;
                return state.mutate(new Function1() { // from class: kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$1$3$15$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        TribeeRepostState.TribeeRepostContentState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = TribeeRepostStateMachine$1$3$15.invokeSuspend$lambda$0(state, str4, str22, str32, buttonText2, (TribeeRepostState.TribeeRepostContentState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeRepostState.TribeeRepostContentState invokeSuspend$lambda$0(State $state, String $title, String $subtitle, String $placeholder, String $buttonText, TribeeRepostState.TribeeRepostContentState $this$mutate) {
        TribeeRepostState.TribeeRepostContentState copy;
        copy = $this$mutate.copy((r30 & 1) != 0 ? $this$mutate.uiAction : null, (r30 & 2) != 0 ? $this$mutate.data : null, (r30 & 4) != 0 ? $this$mutate.introBottomSheetState : null, (r30 & 8) != 0 ? $this$mutate.showSelectTribeeBottomSheet : false, (r30 & 16) != 0 ? $this$mutate.editRepostMainTextBottomSheetState : null, (r30 & 32) != 0 ? $this$mutate.editRepostTitleTextBottomSheetState : new EditTextBottomSheetState($title, $subtitle, ((TribeeRepostState.TribeeRepostContentState) $state.getSnapshot()).getRepostTitleText(), $placeholder, 60, $buttonText, Dp.constructor-impl(96), null), (r30 & 64) != 0 ? $this$mutate.enableRepostToFollowing : false, (r30 & 128) != 0 ? $this$mutate.enableRepostWithSource : false, (r30 & 256) != 0 ? $this$mutate.repostMainText : null, (r30 & 512) != 0 ? $this$mutate.repostTitleText : null, (r30 & 1024) != 0 ? $this$mutate.selectedTribee : null, (r30 & 2048) != 0 ? $this$mutate.selectedPartition : null, (r30 & 4096) != 0 ? $this$mutate.enableClickPageRepost : false, (r30 & 8192) != 0 ? $this$mutate.hasLoadedSelectTribeeBottomSheet : false);
        return copy;
    }
}