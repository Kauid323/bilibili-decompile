package tv.danmaku.bili.ui.favorites.viewmodel;

import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.favorites.model.FollowItem;
import tv.danmaku.bili.ui.favorites.state.FavPageState;
import tv.danmaku.bili.ui.favorites.state.FavTabState;
import tv.danmaku.bili.ui.favorites.state.FollowAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FollowListViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FollowListViewModel$onAction$1", f = "FollowListViewModel.kt", i = {}, l = {BR.danmakuNumIcon, 152, BR.disable}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FollowListViewModel$onAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FollowAction $action;
    int label;
    final /* synthetic */ FollowListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FollowListViewModel$onAction$1(FollowAction followAction, FollowListViewModel followListViewModel, Continuation<? super FollowListViewModel$onAction$1> continuation) {
        super(2, continuation);
        this.$action = followAction;
        this.this$0 = followListViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FollowListViewModel$onAction$1(this.$action, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object followList;
        Object followList2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                FollowAction followAction = this.$action;
                if (followAction instanceof FollowAction.Load) {
                    this.label = 1;
                    followList2 = this.this$0.getFollowList(((FollowAction.Load) this.$action).getFirstLoad(), false, (Continuation) this);
                    if (followList2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (followAction instanceof FollowAction.Delete) {
                    FollowItem it = (FollowItem) CollectionsKt.getOrNull(((FavTabState) this.this$0.getUiStateFlow().getValue()).getItemList(), ((FollowAction.Delete) this.$action).getPos());
                    if (it != null) {
                        FollowListViewModel followListViewModel = this.this$0;
                        String str = it.getOid() + ":" + it.getOtype();
                        this.label = 2;
                        if (BaseFavoritesViewModel.deleteItems$default(followListViewModel, str, null, this, 2, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    FollowListViewModel followListViewModel2 = this.this$0;
                    final FollowAction followAction2 = this.$action;
                    followListViewModel2.updateState(new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FollowListViewModel$onAction$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            FavTabState invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = FollowListViewModel$onAction$1.invokeSuspend$lambda$1(FollowAction.this, (FavTabState) obj);
                            return invokeSuspend$lambda$1;
                        }
                    });
                    break;
                } else if (Intrinsics.areEqual(followAction, FollowAction.Refresh.INSTANCE)) {
                    this.label = 3;
                    followList = this.this$0.getFollowList(false, true, (Continuation) this);
                    if (followList == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (followAction instanceof FollowAction.ClickItem) {
                    FollowListViewModel followListViewModel3 = this.this$0;
                    final FollowAction followAction3 = this.$action;
                    followListViewModel3.updateState(new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FollowListViewModel$onAction$1$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            FavTabState invokeSuspend$lambda$2;
                            invokeSuspend$lambda$2 = FollowListViewModel$onAction$1.invokeSuspend$lambda$2(FollowAction.this, (FavTabState) obj);
                            return invokeSuspend$lambda$2;
                        }
                    });
                    break;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                FollowListViewModel followListViewModel22 = this.this$0;
                final FollowAction followAction22 = this.$action;
                followListViewModel22.updateState(new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FollowListViewModel$onAction$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        FavTabState invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = FollowListViewModel$onAction$1.invokeSuspend$lambda$1(FollowAction.this, (FavTabState) obj);
                        return invokeSuspend$lambda$1;
                    }
                });
                break;
            case 3:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FavTabState invokeSuspend$lambda$1(FollowAction $action, FavTabState $this$updateState) {
        FavTabState copy;
        List newList = CollectionsKt.toMutableList($this$updateState.getItemList());
        newList.remove(((FollowAction.Delete) $action).getPos());
        copy = $this$updateState.copy((r18 & 1) != 0 ? $this$updateState.pageState : newList.isEmpty() ? FavPageState.Empty.INSTANCE : $this$updateState.getPageState(), (r18 & 2) != 0 ? $this$updateState.footerState : null, (r18 & 4) != 0 ? $this$updateState.itemList : newList, (r18 & 8) != 0 ? $this$updateState.isRefreshing : false, (r18 & 16) != 0 ? $this$updateState.isCheckMode : false, (r18 & 32) != 0 ? $this$updateState.pageNum : 0, (r18 & 64) != 0 ? $this$updateState.hasMore : false, (r18 & BR.cover) != 0 ? $this$updateState.hasInvalid : false);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FavTabState invokeSuspend$lambda$2(FollowAction $action, FavTabState $this$updateState) {
        FollowItem copy;
        FavTabState copy2;
        List $this$invokeSuspend_u24lambda_u242_u240 = CollectionsKt.toMutableList($this$updateState.getItemList());
        int pos = ((FollowAction.ClickItem) $action).getPos();
        copy = r5.copy((r32 & 1) != 0 ? r5.oid : 0L, (r32 & 2) != 0 ? r5.otype : 0, (r32 & 4) != 0 ? r5.tagName : null, (r32 & 8) != 0 ? r5.tagType : 0, (r32 & 16) != 0 ? r5.title : null, (r32 & 32) != 0 ? r5.cover : null, (r32 & 64) != 0 ? r5.progressDesc : null, (r32 & BR.cover) != 0 ? r5.historyDesc : null, (r32 & BR.hallEnterHotText) != 0 ? r5.jumpLink : null, (r32 & BR.roleType) != 0 ? r5.lastView : false, (r32 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? r5.redDot : false, (r32 & 2048) != 0 ? r5.share : null, (r32 & 4096) != 0 ? r5.userState : 0, (r32 & 8192) != 0 ? ((FollowItem) $this$updateState.getItemList().get(((FollowAction.ClickItem) $action).getPos())).isFinish : 0);
        $this$invokeSuspend_u24lambda_u242_u240.set(pos, copy);
        Unit unit = Unit.INSTANCE;
        copy2 = $this$updateState.copy((r18 & 1) != 0 ? $this$updateState.pageState : null, (r18 & 2) != 0 ? $this$updateState.footerState : null, (r18 & 4) != 0 ? $this$updateState.itemList : $this$invokeSuspend_u24lambda_u242_u240, (r18 & 8) != 0 ? $this$updateState.isRefreshing : false, (r18 & 16) != 0 ? $this$updateState.isCheckMode : false, (r18 & 32) != 0 ? $this$updateState.pageNum : 0, (r18 & 64) != 0 ? $this$updateState.hasMore : false, (r18 & BR.cover) != 0 ? $this$updateState.hasInvalid : false);
        return copy2;
    }
}