package tv.danmaku.bili.ui.offline.api;

import com.bilibili.okretro.anno.RequestInterceptor;
import com.bilibili.okretro.call.BiliCall;
import com.bilibili.okretro.interceptor.SignOnUrlRequestInterceptor;
import okhttp3.RequestBody;
import retrofit2.http.BaseUrl;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

@BaseUrl("https://api.bilibili.com")
public interface OfflineApiService {
    @POST("/pgc/player/api/v2/cache/play")
    @RequestInterceptor(SignOnUrlRequestInterceptor.class)
    BiliCall<OgvApiResponseV2> queryEpPlayableV2(@Query("access_key") String str, @Body RequestBody requestBody);
}