package tv.danmaku.bili.ui.favorite.api;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.call.BiliCall;
import retrofit2.http.BaseUrl;
import retrofit2.http.GET;
import retrofit2.http.Query;

@BaseUrl("https://app.bilibili.com")
public interface FavoriteService {
    @GET("/x/v2/favorite/topic")
    BiliCall<GeneralResponse<FavTopicData>> getFavTopic(@Query("access_key") String str, @Query("pn") int i, @Query("ps") int i2);

    @GET("/x/v2/favorite/second/tab")
    BiliCall<GeneralResponse<FavSecondTabData>> getSecondTab(@Query("access_key") String str, @Query("tab") String str2);
}