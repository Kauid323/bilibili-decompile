package tv.danmaku.bili.ui.splash.brand.service;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.call.BiliCall;
import kotlin.Metadata;
import retrofit2.http.BaseUrl;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplashData;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingData;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingMoreData;
import tv.danmaku.bili.update.internal.UpdaterKt;
import tv.danmaku.bili.videopage.common.performance.PerformanceConstants;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: BrandSplashService.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001Jd\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\t\u001a\u00020\n2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\r\u001a\u00020\n2\b\b\u0001\u0010\u000e\u001a\u00020\nH'J\u0096\u0001\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\t\u001a\u00020\n2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\r\u001a\u00020\n2\b\b\u0001\u0010\u000e\u001a\u00020\n2\b\b\u0001\u0010\u0011\u001a\u00020\u00072\b\b\u0001\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u00072\b\b\u0001\u0010\u0015\u001a\u00020\n2\b\b\u0003\u0010\u0016\u001a\u00020\u0007H'Jr\u0010\u0017\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\t\u001a\u00020\n2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\r\u001a\u00020\n2\b\b\u0001\u0010\u000e\u001a\u00020\n2\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0007H'JP\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\u001c\u001a\u00020\u00072\b\b\u0001\u0010\u001d\u001a\u00020\u00072\b\b\u0001\u0010\u001e\u001a\u00020\u00072\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0007H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001fÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/service/BrandSplashService;", "", "fetchSettingInfo", "Lcom/bilibili/okretro/call/BiliCall;", "Lcom/bilibili/okretro/GeneralResponse;", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingData;", "accessKey", "", "mobiApp", "buildVersion", "", "device", PerformanceConstants.EXTRA_KEY_NETWORK, "width", "height", "fetchNextPage", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingMoreData;", "source", "lastSplashBizId", "", "groupNo", "splashType", ChronosDanmakuSender.KEY_MARK_DANMAKU, "fetchBrandSplashList", "Ltv/danmaku/bili/ui/splash/brand/model/BrandSplashData;", "selected", "reportBrandSelect", "Ljava/lang/Void;", "ids", "collectionIds", "dlcSplashIds", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@BaseUrl(UpdaterKt.HTTPS_APP_BILIBILI_COM)
public interface BrandSplashService {
    @GET("/x/v2/splash/brand/list")
    BiliCall<GeneralResponse<BrandSplashData>> fetchBrandSplashList(@Query("access_key") String str, @Query("mobi_app") String str2, @Query("build") int i, @Query("device") String str3, @Query("network") String str4, @Query("screen_width") int i2, @Query("screen_height") int i3, @Query("selected") String str5);

    @GET("/x/v2/splash/brand/config/page")
    BiliCall<GeneralResponse<BrandSplashSettingMoreData>> fetchNextPage(@Query("access_key") String str, @Query("mobi_app") String str2, @Query("build") int i, @Query("device") String str3, @Query("network") String str4, @Query("screen_width") int i2, @Query("screen_height") int i3, @Query("source") String str5, @Query("last_splash_biz_id") long j, @Query("group_no") String str6, @Query("splash_type") int i4, @Query("keyword") String str7);

    @GET("/x/v2/splash/brand/config")
    BiliCall<GeneralResponse<BrandSplashSettingData>> fetchSettingInfo(@Query("access_key") String str, @Query("mobi_app") String str2, @Query("build") int i, @Query("device") String str3, @Query("network") String str4, @Query("screen_width") int i2, @Query("screen_height") int i3);

    @FormUrlEncoded
    @POST("/x/v2/splash/brand/save")
    BiliCall<Void> reportBrandSelect(@Field("access_key") String str, @Field("network") String str2, @Field("id") String str3, @Field("vip_splash_id") String str4, @Field("dlc_splash_id") String str5, @Field("device") String str6);

    /* compiled from: BrandSplashService.kt */
    /* renamed from: tv.danmaku.bili.ui.splash.brand.service.BrandSplashService$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ BiliCall fetchNextPage$default(BrandSplashService brandSplashService, String str, String str2, int i, String str3, String str4, int i2, int i3, String str5, long j, String str6, int i4, String str7, int i5, Object obj) {
            String str8;
            if (obj == null) {
                if ((i5 & IjkMediaMeta.FF_PROFILE_H264_INTRA) == 0) {
                    str8 = str7;
                } else {
                    str8 = "";
                }
                return brandSplashService.fetchNextPage(str, str2, i, str3, str4, i2, i3, str5, j, str6, i4, str8);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchNextPage");
        }
    }
}