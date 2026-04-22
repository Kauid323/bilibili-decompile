package tv.danmaku.bili.ui.favorite.cheesesupport;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: CheeseApiManager.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"PAGE_SIZE", "", "getMyFavCheeseList", "Lio/reactivex/rxjava3/core/Single;", "Ltv/danmaku/bili/ui/favorite/cheesesupport/CheeseList;", "accessKey", "", "pageNum", "cancelFavCheese", "Lio/reactivex/rxjava3/core/Completable;", "sessionId", "", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CheeseApiManagerKt {
    public static final int PAGE_SIZE = 20;

    public static final Single<CheeseList> getMyFavCheeseList(String accessKey, int pageNum) {
        Intrinsics.checkNotNullParameter(accessKey, "accessKey");
        return ((CheeseListApiService) SentinelApiGenerator.create(CheeseListApiService.class)).getFavCheeseList(accessKey, pageNum, 20);
    }

    public static final Completable cancelFavCheese(String accessKey, long sessionId) {
        Intrinsics.checkNotNullParameter(accessKey, "accessKey");
        return ((CheeseListApiService) SentinelApiGenerator.create(CheeseListApiService.class)).cancelFavCheese(accessKey, sessionId);
    }
}