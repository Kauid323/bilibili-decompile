package tv.danmaku.bili.ui.offline.api;

import com.bilibili.okretro.anno.RequestInterceptor;
import com.bilibili.okretro.call.BiliCall;
import com.bilibili.okretro.interceptor.DefaultRequestInterceptor;
import retrofit2.http.BaseUrl;
import retrofit2.http.GET;
import retrofit2.http.Query;
import tv.danmaku.bili.update.internal.UpdaterKt;

@BaseUrl(UpdaterKt.HTTPS_APP_BILIBILI_COM)
public interface OfflineAppService {
    @GET("/x/playurl/download/num")
    @RequestInterceptor(DefaultRequestInterceptor.class)
    BiliCall<Void> reportTaskCountChange(@Query("access_key") String str, @Query("num") int i);
}