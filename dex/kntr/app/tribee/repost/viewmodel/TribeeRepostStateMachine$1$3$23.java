package kntr.app.tribee.repost.viewmodel;

import bili.resource.tribee.String0_commonMainKt;
import bili.resource.tribee.TribeeRes;
import com.bapis.bilibili.app.dynamic.v2.KRepostOpus2TribeeOptionsResp;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDyn;
import com.bapis.bilibili.dynamic.common.KCreateResp;
import com.bilibili.lib.brouter.uri.Builder;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.base.TribeeResultChannel;
import kntr.app.tribee.base.TribeeResultContent;
import kntr.app.tribee.consume.TribeePreference;
import kntr.app.tribee.consume.viewmodel.state.TribeeToast;
import kntr.app.tribee.repost.action.TribeeRepostStateAction;
import kntr.app.tribee.repost.action.TribeeRepostUIAction;
import kntr.app.tribee.repost.service.TribeeRepostDataService;
import kntr.app.tribee.repost.state.TribeeRepostState;
import kntr.app.tribee.repost.track.TribeeRepostTrackKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.common.router.UrisKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.datetime.Clock;
import org.jetbrains.compose.resources.StringResourcesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeRepostStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/repost/state/TribeeRepostState;", "action", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$RequestRepost;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/repost/state/TribeeRepostState$TribeeRepostContentState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$1$3$23", f = "TribeeRepostStateMachine.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {392, 395}, m = "invokeSuspend", n = {"action", "state", "currentState", "tribeeId", "action", "state", "currentState", "repostSuccessToast", "tribeeId"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0"}, v = 1)
public final class TribeeRepostStateMachine$1$3$23 extends SuspendLambda implements Function3<TribeeRepostStateAction.RequestRepost, State<TribeeRepostState.TribeeRepostContentState>, Continuation<? super ChangedState<? extends TribeeRepostState>>, Object> {
    final /* synthetic */ InStateBuilderBlock<TribeeRepostState.TribeeRepostContentState, TribeeRepostState, TribeeRepostStateAction> $this_inState;
    long J$0;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ TribeeRepostStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeRepostStateMachine$1$3$23(TribeeRepostStateMachine tribeeRepostStateMachine, InStateBuilderBlock<TribeeRepostState.TribeeRepostContentState, TribeeRepostState, TribeeRepostStateAction> inStateBuilderBlock, Continuation<? super TribeeRepostStateMachine$1$3$23> continuation) {
        super(3, continuation);
        this.this$0 = tribeeRepostStateMachine;
        this.$this_inState = inStateBuilderBlock;
    }

    public final Object invoke(TribeeRepostStateAction.RequestRepost requestRepost, State<TribeeRepostState.TribeeRepostContentState> state, Continuation<? super ChangedState<? extends TribeeRepostState>> continuation) {
        TribeeRepostStateMachine$1$3$23 tribeeRepostStateMachine$1$3$23 = new TribeeRepostStateMachine$1$3$23(this.this$0, this.$this_inState, continuation);
        tribeeRepostStateMachine$1$3$23.L$0 = requestRepost;
        tribeeRepostStateMachine$1$3$23.L$1 = state;
        return tribeeRepostStateMachine$1$3$23.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0091 A[Catch: Exception -> 0x01b3, TryCatch #0 {Exception -> 0x01b3, blocks: (B:20:0x007e, B:22:0x0091, B:24:0x0098), top: B:61:0x007e }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cf A[Catch: Exception -> 0x0033, TryCatch #1 {Exception -> 0x0033, blocks: (B:7:0x002c, B:28:0x00c6, B:30:0x00cf, B:32:0x00db, B:34:0x00e2, B:39:0x00f3, B:41:0x00ff, B:43:0x0106, B:47:0x0117, B:49:0x0129, B:50:0x012d, B:51:0x013c, B:53:0x0142, B:55:0x01a4), top: B:63:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0142 A[Catch: Exception -> 0x0033, TryCatch #1 {Exception -> 0x0033, blocks: (B:7:0x002c, B:28:0x00c6, B:30:0x00cf, B:32:0x00db, B:34:0x00e2, B:39:0x00f3, B:41:0x00ff, B:43:0x0106, B:47:0x0117, B:49:0x0129, B:50:0x012d, B:51:0x013c, B:53:0x0142, B:55:0x01a4), top: B:63:0x002c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        TribeeRepostState.TribeeRepostContentState currentState;
        long tribeeId;
        Object string;
        String repostSuccessToast;
        TribeeRepostDataService tribeeRepostDataService;
        Object repost;
        TribeeRepostState.TribeeRepostContentState currentState2;
        String repostSuccessToast2;
        KTribeeDyn fakeCard;
        long j;
        TribeeRepostStateAction.RequestRepost action = (TribeeRepostStateAction.RequestRepost) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                currentState = (TribeeRepostState.TribeeRepostContentState) state.getSnapshot();
                Long first = currentState.getSelectedTribee().getFirst();
                tribeeId = first != null ? first.longValue() : 0L;
                this.L$0 = action;
                this.L$1 = state;
                this.L$2 = currentState;
                this.J$0 = tribeeId;
                this.label = 1;
                string = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_69(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string == coroutine_suspended) {
                    return coroutine_suspended;
                }
                repostSuccessToast = (String) string;
                try {
                    tribeeRepostDataService = this.this$0.dataService;
                    Long first2 = currentState.getSelectedPartition().getFirst();
                    long longValue = first2 == null ? first2.longValue() : 0L;
                    this.L$0 = action;
                    this.L$1 = state;
                    this.L$2 = currentState;
                    this.L$3 = repostSuccessToast;
                    this.J$0 = tribeeId;
                    this.label = 2;
                    repost = tribeeRepostDataService.repost(tribeeId, longValue, currentState.getRepostMainText(), currentState.getRepostTitleText(), currentState.getEnableRepostToFollowing(), currentState.getEnableRepostWithSource(), (Continuation) this);
                    if (repost != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    currentState2 = currentState;
                    repostSuccessToast2 = repostSuccessToast;
                    KCreateResp repostRespond = (KCreateResp) repost;
                    if (action.getFromType() == 1) {
                        Long first3 = currentState2.getSelectedTribee().getFirst();
                        long longValue2 = first3 != null ? first3.longValue() : 0L;
                        String second = currentState2.getSelectedTribee().getSecond();
                        String str = second == null ? "" : second;
                        Long first4 = currentState2.getSelectedPartition().getFirst();
                        long longValue3 = first4 != null ? first4.longValue() : 0L;
                        String second2 = currentState2.getSelectedPartition().getSecond();
                        String str2 = second2 == null ? "" : second2;
                        boolean enableRepostToFollowing = currentState2.getEnableRepostToFollowing();
                        boolean enableRepostWithSource = currentState2.getEnableRepostWithSource();
                        KRepostOpus2TribeeOptionsResp.KRenderParams params = currentState2.getData().getParams();
                        long remainCnt = params != null ? params.getRemainCnt() : 0L;
                        j = this.this$0.originDynamicId;
                        TribeeRepostTrackKt.pageConfirmClick(longValue2, str, longValue3, str2, enableRepostToFollowing, enableRepostWithSource, remainCnt, String.valueOf(j));
                    }
                    fakeCard = repostRespond.getTribeeFakeCard();
                    if (fakeCard != null) {
                        TribeePreference.INSTANCE.setDefaultRepostTribeeId(tribeeId);
                        String fakeCardResultKey = String.valueOf(Clock.System.INSTANCE.now().toEpochMilliseconds());
                        TribeeResultChannel.INSTANCE.prepareChannel(fakeCardResultKey);
                        TribeeResultChannel.INSTANCE.setResult(fakeCardResultKey, new TribeeResultContent(repostRespond.getTribeeCategoryId(), fakeCard));
                        final Builder url = UrisKt.toUri("bilibili://tribee/home/" + tribeeId).buildUpon();
                        url.appendQueryParameter("fake_card_result_key", fakeCardResultKey);
                        url.appendQueryParameter("insert_fake_card_toast", repostSuccessToast2);
                        url.appendQueryParameter("from_spmid", TribeeRepostTrackKt.TRIBEE_REPOST_PAGE_SPMID);
                        ChangedState mutate = state.mutate(new Function1() { // from class: kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$1$3$23$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                TribeeRepostState.TribeeRepostContentState invokeSuspend$lambda$0$0;
                                invokeSuspend$lambda$0$0 = TribeeRepostStateMachine$1$3$23.invokeSuspend$lambda$0$0(url, (TribeeRepostState.TribeeRepostContentState) obj);
                                return invokeSuspend$lambda$0$0;
                            }
                        });
                        if (mutate != null) {
                            return mutate;
                        }
                    }
                    InStateBuilderBlock<TribeeRepostState.TribeeRepostContentState, TribeeRepostState, TribeeRepostStateAction> inStateBuilderBlock = this.$this_inState;
                    return state.mutate(new Function1() { // from class: kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$1$3$23$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            TribeeRepostState.TribeeRepostContentState copy$default;
                            copy$default = TribeeRepostState.TribeeRepostContentState.copy$default((TribeeRepostState.TribeeRepostContentState) obj, null, null, null, false, null, null, false, false, null, null, null, null, true, false, 12287, null);
                            return copy$default;
                        }
                    });
                } catch (Exception e) {
                    e = e;
                    KLog_androidKt.getKLog().e("TribeeRepostStateMachine", "repost error! (" + e.getMessage() + ")");
                    return state.mutate(new Function1() { // from class: kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$1$3$23$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            TribeeRepostState.TribeeRepostContentState invokeSuspend$lambda$2;
                            invokeSuspend$lambda$2 = TribeeRepostStateMachine$1$3$23.invokeSuspend$lambda$2(e, (TribeeRepostState.TribeeRepostContentState) obj);
                            return invokeSuspend$lambda$2;
                        }
                    });
                }
            case 1:
                tribeeId = this.J$0;
                currentState = (TribeeRepostState.TribeeRepostContentState) this.L$2;
                ResultKt.throwOnFailure($result);
                string = $result;
                repostSuccessToast = (String) string;
                tribeeRepostDataService = this.this$0.dataService;
                Long first22 = currentState.getSelectedPartition().getFirst();
                if (first22 == null) {
                }
                this.L$0 = action;
                this.L$1 = state;
                this.L$2 = currentState;
                this.L$3 = repostSuccessToast;
                this.J$0 = tribeeId;
                this.label = 2;
                repost = tribeeRepostDataService.repost(tribeeId, longValue, currentState.getRepostMainText(), currentState.getRepostTitleText(), currentState.getEnableRepostToFollowing(), currentState.getEnableRepostWithSource(), (Continuation) this);
                if (repost != coroutine_suspended) {
                }
                break;
            case 2:
                tribeeId = this.J$0;
                repostSuccessToast2 = (String) this.L$3;
                currentState2 = (TribeeRepostState.TribeeRepostContentState) this.L$2;
                try {
                    ResultKt.throwOnFailure($result);
                    repost = $result;
                    KCreateResp repostRespond2 = (KCreateResp) repost;
                    if (action.getFromType() == 1) {
                    }
                    fakeCard = repostRespond2.getTribeeFakeCard();
                    if (fakeCard != null) {
                    }
                    InStateBuilderBlock<TribeeRepostState.TribeeRepostContentState, TribeeRepostState, TribeeRepostStateAction> inStateBuilderBlock2 = this.$this_inState;
                    return state.mutate(new Function1() { // from class: kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$1$3$23$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            TribeeRepostState.TribeeRepostContentState copy$default;
                            copy$default = TribeeRepostState.TribeeRepostContentState.copy$default((TribeeRepostState.TribeeRepostContentState) obj, null, null, null, false, null, null, false, false, null, null, null, null, true, false, 12287, null);
                            return copy$default;
                        }
                    });
                } catch (Exception e2) {
                    e = e2;
                    KLog_androidKt.getKLog().e("TribeeRepostStateMachine", "repost error! (" + e.getMessage() + ")");
                    return state.mutate(new Function1() { // from class: kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$1$3$23$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            TribeeRepostState.TribeeRepostContentState invokeSuspend$lambda$2;
                            invokeSuspend$lambda$2 = TribeeRepostStateMachine$1$3$23.invokeSuspend$lambda$2(e, (TribeeRepostState.TribeeRepostContentState) obj);
                            return invokeSuspend$lambda$2;
                        }
                    });
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeRepostState.TribeeRepostContentState invokeSuspend$lambda$0$0(Builder $url, TribeeRepostState.TribeeRepostContentState $this$mutate) {
        TribeeRepostState.TribeeRepostContentState copy;
        copy = $this$mutate.copy((r30 & 1) != 0 ? $this$mutate.uiAction : new TribeeRepostUIAction.CloseAndRouterTo($url.toString()), (r30 & 2) != 0 ? $this$mutate.data : null, (r30 & 4) != 0 ? $this$mutate.introBottomSheetState : null, (r30 & 8) != 0 ? $this$mutate.showSelectTribeeBottomSheet : false, (r30 & 16) != 0 ? $this$mutate.editRepostMainTextBottomSheetState : null, (r30 & 32) != 0 ? $this$mutate.editRepostTitleTextBottomSheetState : null, (r30 & 64) != 0 ? $this$mutate.enableRepostToFollowing : false, (r30 & 128) != 0 ? $this$mutate.enableRepostWithSource : false, (r30 & 256) != 0 ? $this$mutate.repostMainText : null, (r30 & 512) != 0 ? $this$mutate.repostTitleText : null, (r30 & 1024) != 0 ? $this$mutate.selectedTribee : null, (r30 & 2048) != 0 ? $this$mutate.selectedPartition : null, (r30 & 4096) != 0 ? $this$mutate.enableClickPageRepost : true, (r30 & 8192) != 0 ? $this$mutate.hasLoadedSelectTribeeBottomSheet : false);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeRepostState.TribeeRepostContentState invokeSuspend$lambda$2(Exception $e, TribeeRepostState.TribeeRepostContentState $this$mutate) {
        TribeeRepostState.TribeeRepostContentState copy;
        copy = $this$mutate.copy((r30 & 1) != 0 ? $this$mutate.uiAction : new TribeeRepostUIAction.ToastTips(TribeeToast.Companion.create$default(TribeeToast.Companion, $e, null, 2, null)), (r30 & 2) != 0 ? $this$mutate.data : null, (r30 & 4) != 0 ? $this$mutate.introBottomSheetState : null, (r30 & 8) != 0 ? $this$mutate.showSelectTribeeBottomSheet : false, (r30 & 16) != 0 ? $this$mutate.editRepostMainTextBottomSheetState : null, (r30 & 32) != 0 ? $this$mutate.editRepostTitleTextBottomSheetState : null, (r30 & 64) != 0 ? $this$mutate.enableRepostToFollowing : false, (r30 & 128) != 0 ? $this$mutate.enableRepostWithSource : false, (r30 & 256) != 0 ? $this$mutate.repostMainText : null, (r30 & 512) != 0 ? $this$mutate.repostTitleText : null, (r30 & 1024) != 0 ? $this$mutate.selectedTribee : null, (r30 & 2048) != 0 ? $this$mutate.selectedPartition : null, (r30 & 4096) != 0 ? $this$mutate.enableClickPageRepost : true, (r30 & 8192) != 0 ? $this$mutate.hasLoadedSelectTribeeBottomSheet : false);
        return copy;
    }
}