package tv.danmaku.bili.ui.favorites.api;

import com.bilibili.okretro.BaseResponse;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.call.BiliCall;
import kotlin.Metadata;
import retrofit2.http.BaseUrl;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.model.FavoritesFolder;
import tv.danmaku.bili.ui.favorites.model.FavoritesTabList;
import tv.danmaku.bili.ui.favorites.model.FavoritesTabs;
import tv.danmaku.bili.ui.favorites.model.FollowResponse;

/* compiled from: FavoritesApiService.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u0003H'JF\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\u00032\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u00072\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\u000f\u001a\u00020\u00072\b\b\u0001\u0010\u0010\u001a\u00020\u0007H'J(\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\u00032\b\b\u0001\u0010\u0012\u001a\u00020\r2\b\b\u0001\u0010\u0013\u001a\u00020\u0007H'JF\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u00072\b\b\u0001\u0010\u000f\u001a\u00020\u00072\b\b\u0001\u0010\u0010\u001a\u00020\u0007H'J\u001e\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00040\u00032\b\b\u0001\u0010\u0018\u001a\u00020\u0007H'J\u001e\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'J/\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00040\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u001c2\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\rH'¢\u0006\u0002\u0010\u001dJ(\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00040\u00032\b\b\u0001\u0010\u0018\u001a\u00020\r2\b\b\u0001\u0010\u001f\u001a\u00020 H'J2\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\u001b\u001a\u00020\u001c2\b\b\u0001\u0010\"\u001a\u00020\u001cH'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006#À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/favorites/api/FavoritesApiService;", "", "getFavoritesTabs", "Lcom/bilibili/okretro/call/BiliCall;", "Lcom/bilibili/okretro/GeneralResponse;", "Ltv/danmaku/bili/ui/favorites/model/FavoritesTabs;", "tabId", "", "getFavoritesFolderList", "Ltv/danmaku/bili/ui/favorites/model/FavoritesFolder;", "getFavoritesList", "Ltv/danmaku/bili/ui/favorites/model/FavoritesTabList;", "startOid", "", "startOType", "startScore", "pageType", "getFolderFullInfo", "playlistId", "pageIndex", "getFollowList", "Ltv/danmaku/bili/ui/favorites/model/FollowResponse;", "cleanInvalid", "Lcom/bilibili/okretro/BaseResponse;", "fid", "cleanRedDot", "deleteFavorites", "resources", "", "(Ljava/lang/String;Ljava/lang/Long;)Lcom/bilibili/okretro/call/BiliCall;", "addTopFolder", "addTop", "", "lastWatched", "action", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@BaseUrl("https://api.bilibili.com")
public interface FavoritesApiService {
    @FormUrlEncoded
    @POST("/x/v3/fav/folder/add_top")
    BiliCall<GeneralResponse<BaseResponse>> addTopFolder(@Field("fid") long j, @Field("add_top") boolean z);

    @FormUrlEncoded
    @POST("/x/v3/fav/tab/clean_invalid")
    BiliCall<GeneralResponse<BaseResponse>> cleanInvalid(@Field("fid") int i);

    @FormUrlEncoded
    @POST("/x/v3/fav/tab/red_dot/clean")
    BiliCall<GeneralResponse<BaseResponse>> cleanRedDot(@Field("tab_id") int i);

    @FormUrlEncoded
    @POST("/x/v3/fav/tab/dels")
    BiliCall<GeneralResponse<BaseResponse>> deleteFavorites(@Field("resources") String str, @Field("media_id") Long l);

    @GET("/x/v3/fav/tab/my_fav")
    BiliCall<GeneralResponse<FavoritesFolder>> getFavoritesFolderList();

    @GET("/x/v3/fav/tab/fav")
    BiliCall<GeneralResponse<FavoritesTabList>> getFavoritesList(@Query("start_oid") long j, @Query("start_otype") int i, @Query("tab_id") int i2, @Query("start_score") int i3, @Query("page_type") int i4);

    @GET("/x/v3/fav/tab")
    BiliCall<GeneralResponse<FavoritesTabs>> getFavoritesTabs(@Query("tab_id") int i);

    @GET("/x/v3/fav/folder/resources")
    BiliCall<GeneralResponse<FavoritesTabList>> getFolderFullInfo(@Query("media_id") long j, @Query("pn") int i);

    @GET("/x/v3/fav/tab/fol")
    BiliCall<GeneralResponse<FollowResponse>> getFollowList(@Query("tab_id") int i, @Query("start_oid") long j, @Query("start_otype") int i2, @Query("start_score") int i3, @Query("page_type") int i4);

    @FormUrlEncoded
    @POST("/x/v3/fav/tab/report")
    BiliCall<GeneralResponse<BaseResponse>> lastWatched(@Field("tab_id") int i, @Field("resources") String str, @Field("action") String str2);
}