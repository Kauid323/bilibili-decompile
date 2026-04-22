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
import tv.danmaku.bili.ui.favorites.util.FavReportHelperKt;
import tv.danmaku.bili.ui.favorites.util.FavoritesUtilsKt;

/* compiled from: FollowTabFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.fragment.FollowTabFragment$adapter$1$onItemClick$1", f = "FollowTabFragment.kt", i = {}, l = {BR.buttonVisible}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class FollowTabFragment$adapter$1$onItemClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FollowItem $item;
    final /* synthetic */ int $pos;
    int label;
    final /* synthetic */ FollowTabFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FollowTabFragment$adapter$1$onItemClick$1(FollowTabFragment followTabFragment, FollowItem followItem, int i, Continuation<? super FollowTabFragment$adapter$1$onItemClick$1> continuation) {
        super(2, continuation);
        this.this$0 = followTabFragment;
        this.$item = followItem;
        this.$pos = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FollowTabFragment$adapter$1$onItemClick$1(this.this$0, this.$item, this.$pos, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (FavoritesApiManagerKt.reportLastWatchedEvent(this.this$0.getTabId(), this.$item.getResources(), "click", (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable e) {
            BLog.e(FollowTabFragment.TAG, "reportLastWatchedEvent error", e);
        }
        Pair[] pairArr = new Pair[12];
        pairArr[0] = TuplesKt.to("oid", String.valueOf(this.$item.getOid()));
        pairArr[1] = TuplesKt.to(FavoritesConstsKt.FAV_TYPE, String.valueOf(this.$item.getOtype()));
        pairArr[2] = TuplesKt.to("tab_name", this.this$0.getFirstTabName());
        pairArr[3] = TuplesKt.to("second_tab_name", this.this$0.getSecondTabName());
        pairArr[4] = TuplesKt.to(FavoritesConstsKt.IS_LAST_SEEN, this.$item.isLastSeen());
        pairArr[5] = TuplesKt.to(FavoritesConstsKt.IS_ACQUIESCE, FavoritesUtilsKt.toIsAcquiesce(this.this$0.getTabId(), this.this$0.getActivityVM().getDefaultTabId()));
        pairArr[6] = TuplesKt.to(FavoritesConstsKt.POS, String.valueOf(this.$pos + 1));
        pairArr[7] = TuplesKt.to("from_spmid", this.this$0.getActivityVM().getFromSpmid());
        pairArr[8] = TuplesKt.to(FavoritesConstsKt.IS_RENEWAL, this.$item.isRenewal());
        pairArr[9] = TuplesKt.to(FavoritesConstsKt.IS_END, this.$item.isEnd());
        pairArr[10] = TuplesKt.to(FavoritesConstsKt.USER_STATE, this.$item.getUserStateStr());
        String currentPolarisActionId = PageViewTracker.getInstance().currentPolarisActionId();
        if (currentPolarisActionId == null) {
            currentPolarisActionId = "";
        }
        pairArr[11] = TuplesKt.to(FavoritesConstsKt.ACTION_ID, currentPolarisActionId);
        FavReportHelperKt.reportFavCardClick(MapsKt.mapOf(pairArr));
        return Unit.INSTANCE;
    }
}