package tv.danmaku.bili.videopage.common.watchlater.api;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.call.BiliCall;
import retrofit2.http.BaseUrl;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

@BaseUrl("https://api.bilibili.com")
public interface WatchLaterService {
    @FormUrlEncoded
    @POST("/x/v2/history/toview/add")
    BiliCall<GeneralResponse<Void>> add(@Field("access_key") String str, @Field("aid") String str2, @Field("from") String str3);

    @FormUrlEncoded
    @POST("/x/v2/history/toview/clear")
    BiliCall<Void> clearAll(@Field("access_key") String str);

    @FormUrlEncoded
    @POST("/x/v2/history/toview/del")
    BiliCall<GeneralResponse<Void>> deleteItem(@Field("access_key") String str, @Field("aid") String str2, @Field("viewed") boolean z);

    @GET("/x/v2/history/toview")
    BiliCall<GeneralResponse<WatchLaterList>> getWatchLaterList(@Query("access_key") String str);
}