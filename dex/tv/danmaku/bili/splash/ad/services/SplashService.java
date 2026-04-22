package tv.danmaku.bili.splash.ad.services;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.anno.RequestInterceptor;
import com.bilibili.okretro.call.BiliCall;
import kotlin.Metadata;
import retrofit2.http.BaseUrl;
import retrofit2.http.GET;
import retrofit2.http.Query;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.SplashListResponse;
import tv.danmaku.bili.splash.ad.model.SplashShowResponse;

/* compiled from: SplashServices.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\ba\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0007H'J^\u0010\n\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0007H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/splash/ad/services/SplashService;", "", "getSplashList", "Lcom/bilibili/okretro/call/BiliCall;", "Lcom/bilibili/okretro/GeneralResponse;", "Ltv/danmaku/bili/splash/ad/model/SplashListResponse;", "loadedResSplashList", "", "keepIds", "openEvent", "getSplashShowList", "Ltv/danmaku/bili/splash/ad/model/SplashShowResponse;", "accessKey", "width", "", "height", "adExtra", "network", "topviewIds", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@BaseUrl("https://app.bilibili.com")
public interface SplashService {
    @GET("/x/v2/splash/list")
    @RequestInterceptor(SplashListInterceptor.class)
    BiliCall<GeneralResponse<SplashListResponse>> getSplashList(@Query("loaded_creative_list") String str, @Query("client_keep_ids") String str2, @Query("open_event") String str3);

    @GET("/x/v2/splash/show")
    @RequestInterceptor(SplashShowInterceptor.class)
    BiliCall<GeneralResponse<SplashShowResponse>> getSplashShowList(@Query("access_key") String str, @Query("width") int i, @Query("height") int i2, @Query("ad_extra") String str2, @Query("network") String str3, @Query("topview_ids") String str4);
}