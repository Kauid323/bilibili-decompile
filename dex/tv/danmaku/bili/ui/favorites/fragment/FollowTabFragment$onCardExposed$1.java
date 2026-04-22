package tv.danmaku.bili.ui.favorites.fragment;

import com.bilibili.pvtracker.PageViewTracker;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.api.FavoritesApiManagerKt;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.favorites.model.FollowItem;
import tv.danmaku.bili.ui.favorites.state.FavTabState;
import tv.danmaku.bili.ui.favorites.util.FavReportHelperKt;
import tv.danmaku.bili.ui.favorites.util.FavoritesUtilsKt;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: FollowTabFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.fragment.FollowTabFragment$onCardExposed$1", f = "FollowTabFragment.kt", i = {}, l = {234}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class FollowTabFragment$onCardExposed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ FollowTabFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FollowTabFragment$onCardExposed$1(int i, FollowTabFragment followTabFragment, Continuation<? super FollowTabFragment$onCardExposed$1> continuation) {
        super(2, continuation);
        this.$position = i;
        this.this$0 = followTabFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FollowTabFragment$onCardExposed$1(this.$position, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        String str = FollowTabFragment.TAG;
        try {
            switch (i) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    BLog.i(FollowTabFragment.TAG, "card exposed position:" + this.$position);
                    if (this.$position < 0 || this.$position >= ((FavTabState) this.this$0.getViewModel().getUiStateFlow().getValue()).getItemList().size()) {
                        return Unit.INSTANCE;
                    }
                    FollowItem item = (FollowItem) ((FavTabState) this.this$0.getViewModel().getUiStateFlow().getValue()).getItemList().get(this.$position);
                    if (item.isExposed()) {
                        return Unit.INSTANCE;
                    }
                    item.setExposed(true);
                    Pair[] pairArr = new Pair[12];
                    pairArr[0] = TuplesKt.to("oid", String.valueOf(item.getOid()));
                    pairArr[1] = TuplesKt.to(FavoritesConstsKt.FAV_TYPE, String.valueOf(item.getOtype()));
                    pairArr[2] = TuplesKt.to("tab_name", this.this$0.getFirstTabName());
                    pairArr[3] = TuplesKt.to("second_tab_name", this.this$0.getSecondTabName());
                    pairArr[4] = TuplesKt.to(FavoritesConstsKt.IS_LAST_SEEN, item.isLastSeen());
                    pairArr[5] = TuplesKt.to(FavoritesConstsKt.IS_ACQUIESCE, FavoritesUtilsKt.toIsAcquiesce(this.this$0.getTabId(), this.this$0.getActivityVM().getDefaultTabId()));
                    pairArr[6] = TuplesKt.to(FavoritesConstsKt.POS, String.valueOf(this.$position + 1));
                    pairArr[7] = TuplesKt.to("from_spmid", this.this$0.getActivityVM().getFromSpmid());
                    pairArr[8] = TuplesKt.to(FavoritesConstsKt.IS_RENEWAL, item.isRenewal());
                    pairArr[9] = TuplesKt.to(FavoritesConstsKt.IS_END, item.isEnd());
                    pairArr[10] = TuplesKt.to(FavoritesConstsKt.USER_STATE, item.getUserStateStr());
                    String currentPolarisActionId = PageViewTracker.getInstance().currentPolarisActionId();
                    if (currentPolarisActionId == null) {
                        currentPolarisActionId = "";
                    }
                    pairArr[11] = TuplesKt.to(FavoritesConstsKt.ACTION_ID, currentPolarisActionId);
                    FavReportHelperKt.reportFavShow(FavoritesConstsKt.FAV_CONTENT_CARD_SHOW, MapsKt.mapOf(pairArr));
                    this.label = 1;
                    Object reportLastWatchedEvent = FavoritesApiManagerKt.reportLastWatchedEvent(this.this$0.getTabId(), item.getResources(), ReportEvent.EVENT_TYPE_SHOW, (Continuation) this);
                    str = reportLastWatchedEvent;
                    if (reportLastWatchedEvent == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    str = str;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable e) {
            BLog.e(str, "reportLastWatchedEvent error", e);
        }
        return Unit.INSTANCE;
    }
}