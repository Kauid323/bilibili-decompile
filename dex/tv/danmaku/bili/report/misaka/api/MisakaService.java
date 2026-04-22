package tv.danmaku.bili.report.misaka.api;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.anno.RequestInterceptor;
import com.bilibili.okretro.call.BiliCall;
import com.bilibili.okretro.interceptor.HeaderRequestInterceptor;
import java.util.List;
import retrofit2.http.BaseUrl;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

@BaseUrl("http://misaka-sw.mincdn.com")
public interface MisakaService {
    @GET("/filterlists")
    @RequestInterceptor(HeaderRequestInterceptor.class)
    BiliCall<GeneralResponse<List<MisakaRule>>> fetchMisakaRules();

    @FormUrlEncoded
    @POST("/")
    @RequestInterceptor(HeaderRequestInterceptor.class)
    BiliCall<Void> reportBadRequest(@Header("vid") String str, @Field("body") String str2);
}