package kntr.app.ad.domain.adextra;

import kntr.app.ad.common.utils.Logger_androidKt;
import kntr.app.ad.domain.adextra.handler.DefaultHandler;
import kntr.app.ad.domain.adextra.handler.FollowingCommentHandler;
import kntr.app.ad.domain.adextra.handler.FollowingDetailHandler;
import kntr.app.ad.domain.adextra.handler.IAdExtraQueryHandler;
import kntr.app.ad.domain.adextra.handler.RewardComponentHandler;
import kntr.app.ad.domain.adextra.handler.RewardSearchHandler;
import kntr.app.ad.domain.adextra.handler.StoryCommentHandler;
import kntr.app.ad.domain.adextra.handler.StoryFeedHandler;
import kntr.app.ad.domain.adextra.handler.StoryFlyCartHandler;
import kntr.app.ad.domain.adextra.handler.StoryGoodsHandler;
import kntr.app.ad.domain.adextra.handler.StoryNatureCartHandler;
import kntr.app.ad.domain.adextra.handler.UgcCommentHandler;
import kntr.app.ad.domain.adextra.handler.UgcDanmakuHandler;
import kntr.app.ad.domain.adextra.handler.UgcDetailHandler;
import kntr.app.ad.domain.adextra.handler.UgcEndPageHandler;
import kntr.app.ad.domain.adextra.handler.UgcMerchandiseHandler;
import kntr.app.ad.protocol.adextra.AdExtraDefaultQuery;
import kntr.app.ad.protocol.adextra.AdExtraFollowingCommentQuery;
import kntr.app.ad.protocol.adextra.AdExtraFollowingDetailQuery;
import kntr.app.ad.protocol.adextra.AdExtraRewardComponentQuery;
import kntr.app.ad.protocol.adextra.AdExtraRewardSearchQuery;
import kntr.app.ad.protocol.adextra.AdExtraStoryCommentQuery;
import kntr.app.ad.protocol.adextra.AdExtraStoryFeedQuery;
import kntr.app.ad.protocol.adextra.AdExtraStoryFlyCartQuery;
import kntr.app.ad.protocol.adextra.AdExtraStoryGoodsQuery;
import kntr.app.ad.protocol.adextra.AdExtraStoryNatureCartQuery;
import kntr.app.ad.protocol.adextra.AdExtraUgcCommentQuery;
import kntr.app.ad.protocol.adextra.AdExtraUgcDanmakuQuery;
import kntr.app.ad.protocol.adextra.AdExtraUgcDetailQuery;
import kntr.app.ad.protocol.adextra.AdExtraUgcEndPageQuery;
import kntr.app.ad.protocol.adextra.AdExtraUgcMerchandiseQuery;
import kntr.app.ad.protocol.adextra.IAdExtraFetcher;
import kntr.app.ad.protocol.adextra.IAdExtraQuery;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.neuron.KNeuron;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;

/* compiled from: AdExtraFetcher.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\u0018\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\n"}, d2 = {"Lkntr/app/ad/domain/adextra/AdExtraFetcher;", "Lkntr/app/ad/protocol/adextra/IAdExtraFetcher;", "<init>", "()V", "get", RoomRecommendViewModel.EMPTY_CURSOR, "query", "Lkntr/app/ad/protocol/adextra/IAdExtraQuery;", "pickHandler", "Lkntr/app/ad/domain/adextra/handler/IAdExtraQueryHandler;", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdExtraFetcher implements IAdExtraFetcher {
    public static final AdExtraFetcher INSTANCE = new AdExtraFetcher();

    private AdExtraFetcher() {
    }

    @Override // kntr.app.ad.protocol.adextra.IAdExtraFetcher
    public String get(IAdExtraQuery query) {
        Object obj;
        Intrinsics.checkNotNullParameter(query, "query");
        TimeSource.Monotonic $this$measureTimedValue$iv$iv = TimeSource.Monotonic.INSTANCE;
        long mark$iv$iv = $this$measureTimedValue$iv$iv.markNow-z9LOYto();
        AdExtraFetcher $this$get_u24lambda_u240_u240 = INSTANCE;
        try {
            Result.Companion companion = Result.Companion;
            IAdExtraQueryHandler handler = $this$get_u24lambda_u240_u240.pickHandler(query);
            Intrinsics.checkNotNull(handler, "null cannot be cast to non-null type kntr.app.ad.domain.adextra.handler.IAdExtraQueryHandler<kntr.app.ad.protocol.adextra.IAdExtraQuery>");
            obj = Result.constructor-impl(AdExtraUtil_androidKt.adAES(handler.handle(query)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable it = Result.exceptionOrNull-impl(obj);
        if (it != null) {
            Logger_androidKt.getAdLog().e("AdExtra", "failed to fetch ad extra", it);
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Object obj2 = (String) obj;
        if (obj2 == null) {
            obj2 = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        Object result$iv$iv = obj2;
        TimedValue timedValue = new TimedValue(result$iv$iv, TimeSource.Monotonic.ValueTimeMark.elapsedNow-UwyO8pc(mark$iv$iv), (DefaultConstructorMarker) null);
        String result = (String) timedValue.component1();
        long duration = timedValue.component2-UwyO8pc();
        KNeuron.INSTANCE.simpleTrackT("ad.ops.adextra", MapsKt.mapOf(TuplesKt.to("time", String.valueOf(Duration.getInWholeMilliseconds-impl(duration)))));
        Logger_androidKt.getAdLog().d("AdExtra", "kntr cost: " + Duration.toString-impl(duration) + ", " + result);
        return result;
    }

    private final IAdExtraQueryHandler<? extends IAdExtraQuery> pickHandler(IAdExtraQuery query) {
        if (query instanceof AdExtraDefaultQuery) {
            return new DefaultHandler();
        }
        if (query instanceof AdExtraStoryCommentQuery) {
            return new StoryCommentHandler();
        }
        if (query instanceof AdExtraStoryFeedQuery) {
            return new StoryFeedHandler();
        }
        if (query instanceof AdExtraStoryFlyCartQuery) {
            return new StoryFlyCartHandler();
        }
        if (query instanceof AdExtraStoryNatureCartQuery) {
            return new StoryNatureCartHandler();
        }
        if (query instanceof AdExtraStoryGoodsQuery) {
            return new StoryGoodsHandler();
        }
        if (query instanceof AdExtraUgcCommentQuery) {
            return new UgcCommentHandler();
        }
        if (query instanceof AdExtraUgcDanmakuQuery) {
            return new UgcDanmakuHandler();
        }
        if (query instanceof AdExtraUgcDetailQuery) {
            return new UgcDetailHandler();
        }
        if (query instanceof AdExtraUgcEndPageQuery) {
            return new UgcEndPageHandler();
        }
        if (query instanceof AdExtraUgcMerchandiseQuery) {
            return new UgcMerchandiseHandler();
        }
        if (query instanceof AdExtraFollowingCommentQuery) {
            return new FollowingCommentHandler();
        }
        if (query instanceof AdExtraFollowingDetailQuery) {
            return new FollowingDetailHandler();
        }
        if (query instanceof AdExtraRewardSearchQuery) {
            return new RewardSearchHandler();
        }
        if (query instanceof AdExtraRewardComponentQuery) {
            return new RewardComponentHandler();
        }
        throw new NoWhenBranchMatchedException();
    }
}