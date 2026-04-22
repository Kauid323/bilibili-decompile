package tv.danmaku.bili.ui.main.usergrow;

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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UserGrowHelper.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bc\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007H'J\"\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00040\u00032\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0007H'J\"\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00040\u00032\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0007H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/main/usergrow/UserGrowApi;", "", "fetchStatusForLogin", "Lcom/bilibili/okretro/call/BiliCall;", "Lcom/bilibili/okretro/GeneralResponse;", "Ltv/danmaku/bili/ui/main/usergrow/UserGrowStatus;", "accessKey", "", "checkClipboard", "Ltv/danmaku/bili/ui/main/usergrow/WatchWordResult;", "word", "checkShareWordClipboard", "Ltv/danmaku/bili/ui/main/usergrow/ShareWordResult;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@BaseUrl("https://app.bilibili.com")
public interface UserGrowApi {
    @FormUrlEncoded
    @POST("https://api.bilibili.com/x/fission/check/watchword")
    BiliCall<GeneralResponse<WatchWordResult>> checkClipboard(@Field("clipboard") String str);

    @GET("https://api.bilibili.com/x/share/clipboard")
    BiliCall<GeneralResponse<ShareWordResult>> checkShareWordClipboard(@Query("word") String str);

    @GET("x/resource/fission/check/new")
    BiliCall<GeneralResponse<UserGrowStatus>> fetchStatusForLogin(@Query("access_key") String str);
}