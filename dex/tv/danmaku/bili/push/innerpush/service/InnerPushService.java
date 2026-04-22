package tv.danmaku.bili.push.innerpush.service;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.call.BiliCall;
import kotlin.Metadata;
import retrofit2.http.BaseUrl;
import retrofit2.http.GET;
import retrofit2.http.Query;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.model.InnerPushConfig;
import tv.danmaku.bili.push.innerpush.model.InnerPushReplayBody;

/* compiled from: InnerPushService.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H'J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u0003H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/push/innerpush/service/InnerPushService;", "", "requestInnerPushDisplay", "Lcom/bilibili/okretro/call/BiliCall;", "Lcom/bilibili/okretro/GeneralResponse;", "Ltv/danmaku/bili/push/innerpush/model/InnerPushReplayBody;", "scene", "", "msgs", "requestInnerPushConfig", "Ltv/danmaku/bili/push/innerpush/model/InnerPushConfig;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@BaseUrl("https://api.bilibili.com")
public interface InnerPushService {
    @GET("/x/push/broadcast/config")
    BiliCall<GeneralResponse<InnerPushConfig>> requestInnerPushConfig();

    @GET("/x/push/broadcast/display")
    BiliCall<GeneralResponse<InnerPushReplayBody>> requestInnerPushDisplay(@Query("scene") String str, @Query("msgs") String str2);
}