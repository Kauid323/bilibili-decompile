package tv.danmaku.bili.ui.theme.api;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.anno.RequestInterceptor;
import com.bilibili.okretro.call.BiliCall;
import retrofit2.http.BaseUrl;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

@BaseUrl("https://club.bilibili.com")
public interface BiliThemeApiService {
    @FormUrlEncoded
    @POST("/api/add.skin.order.do")
    @RequestInterceptor(ClubHostRequestInterceptor.class)
    BiliCall<GeneralResponse<OrderResult>> addOrder(@Query("access_key") String str, @Field("id") int i);

    @FormUrlEncoded
    @POST("/api/cancel.skin.order.do")
    @RequestInterceptor(ClubHostRequestInterceptor.class)
    BiliCall<GeneralResponse<OrderResult>> cancelOrder(@Query("access_key") String str, @Field("id") int i);

    @GET("/api/query.skin.list.do")
    @RequestInterceptor(ClubHostRequestInterceptor.class)
    BiliCall<BiliSkinList> getThemeList(@Query("access_key") String str);
}