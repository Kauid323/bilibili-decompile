package tv.danmaku.bili.ui.garb.model;

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

/* compiled from: GarbApiService.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\b\u001a\u00020\tH'J,\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0007H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/garb/model/GarbApiService;", "", "fetchGarb", "Lcom/bilibili/okretro/call/BiliCall;", "Lcom/bilibili/okretro/GeneralResponse;", "Ltv/danmaku/bili/ui/garb/model/GarbData;", "key", "", "isFreeTheme", "", "unloadGarb", "Ljava/lang/Void;", "skin", "theme_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@BaseUrl("https://app.bilibili.com")
public interface GarbApiService {
    @GET("x/resource/show/skin")
    BiliCall<GeneralResponse<GarbData>> fetchGarb(@Query("access_key") String str, @Query("is_free_theme") int i);

    @FormUrlEncoded
    @POST("https://api.bilibili.com/x/garb/v1/user/equip/unload")
    BiliCall<GeneralResponse<Void>> unloadGarb(@Field("access_key") String str, @Field("part") String str2);
}