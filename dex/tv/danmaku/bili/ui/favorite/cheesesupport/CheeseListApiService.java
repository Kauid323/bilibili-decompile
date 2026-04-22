package tv.danmaku.bili.ui.favorite.cheesesupport;

import com.bilibili.okretro.call.rxjava.SplitGeneralResponse;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import retrofit2.http.BaseUrl;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import tv.danmaku.bili.BR;

/* compiled from: CheeseListApiService.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bg\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\bH'J\u001e\u0010\n\u001a\u00020\u000b2\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\f\u001a\u00020\rH'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/favorite/cheesesupport/CheeseListApiService;", "", "getFavCheeseList", "Lio/reactivex/rxjava3/core/Single;", "Ltv/danmaku/bili/ui/favorite/cheesesupport/CheeseList;", "accessKey", "", "pageNum", "", "pageSize", "cancelFavCheese", "Lio/reactivex/rxjava3/core/Completable;", "sessionId", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@BaseUrl("https://api.bilibili.com")
public interface CheeseListApiService {
    @POST("pugv/app/favorite/del")
    @SplitGeneralResponse
    Completable cancelFavCheese(@Query("access_key") String str, @Query("season_id") long j);

    @GET("pugv/app/favorite/page")
    @SplitGeneralResponse
    Single<CheeseList> getFavCheeseList(@Query("access_key") String str, @Query("pn") int i, @Query("ps") int i2);
}