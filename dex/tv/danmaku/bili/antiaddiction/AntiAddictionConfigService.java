package tv.danmaku.bili.antiaddiction;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.call.BiliCall;
import kotlin.Metadata;
import retrofit2.http.BaseUrl;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.antiaddiction.data.AddictionConfigData;
import tv.danmaku.bili.antiaddiction.data.AntiAddictionStatusData;

/* compiled from: AntiAddictionConfigService.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u0003H'J2\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\fH'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/antiaddiction/AntiAddictionConfigService;", "", "getConfigData", "Lcom/bilibili/okretro/call/BiliCall;", "Lcom/bilibili/okretro/GeneralResponse;", "Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData;", "getAntiAddictionStatus", "Ltv/danmaku/bili/antiaddiction/data/AntiAddictionStatusData;", "setSleepRemindConfig", "switch", "", "startTime", "", "endTime", "antiaddiction_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@BaseUrl("https://app.bilibili.com")
public interface AntiAddictionConfigService {
    @GET("/x/v2/anti_addiction/aggregation/status")
    BiliCall<GeneralResponse<AntiAddictionStatusData>> getAntiAddictionStatus();

    @GET("/x/v2/anti_addiction/rule")
    BiliCall<GeneralResponse<AddictionConfigData>> getConfigData();

    @POST("/x/v2/anti_addiction/sleep_remind/set")
    BiliCall<GeneralResponse<Object>> setSleepRemindConfig(@Query("switch") boolean z, @Query("stime") String str, @Query("etime") String str2);
}