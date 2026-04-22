package tv.danmaku.bili.push.pushsetting.service;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.call.BiliCall;
import com.google.protobuf.Any;
import kotlin.Metadata;
import retrofit2.http.BaseUrl;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.httpdns.api.ConstsKt;
import tv.danmaku.bili.push.pushsetting.model.PushCallBackInfo;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: PushSettingService.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001JD\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\n\u001a\u00020\u000bH'J8\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\n\u001a\u00020\u000bH'J \u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00040\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u000bH'J,\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00040\u00032\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\u0012\u001a\u00020\u000bH'J:\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00040\u00032\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0007H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0017À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/push/pushsetting/service/PushSettingService;", "", "requestPushDialog", "Lcom/bilibili/okretro/call/BiliCall;", "Lcom/bilibili/okretro/GeneralResponse;", "Ltv/danmaku/bili/push/pushsetting/model/PushCallBackInfo;", "entrance", "", ConstsKt.SP_SYSTEM, FavoritesConstsKt.SPMID, "systemPopup", "", "reportDialogExpose", "Lcom/google/protobuf/Any;", "reportAppFirstStart", "eventType", "updatePushSetting", "types", "value", "setSinglePushSetting", "Ljava/lang/Void;", "accessKey", "type", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@BaseUrl("https://api.bilibili.com")
public interface PushSettingService {
    @POST("/x/push/event/report")
    BiliCall<GeneralResponse<Any>> reportAppFirstStart(@Query("event") int i);

    @POST("/x/push/popup/report")
    BiliCall<GeneralResponse<Any>> reportDialogExpose(@Query("entrance") String str, @Query("system") String str2, @Query("system_popup") int i);

    @GET("/x/push/popup/setting")
    BiliCall<GeneralResponse<PushCallBackInfo>> requestPushDialog(@Query("entrance") String str, @Query("system") String str2, @Query("spmid") String str3, @Query("system_popup") int i);

    @POST("/x/push/setting/set")
    BiliCall<GeneralResponse<Void>> setSinglePushSetting(@Query("access_key") String str, @Query("type") String str2, @Query("value") String str3);

    @POST("/x/push/settings/set")
    BiliCall<GeneralResponse<Any>> updatePushSetting(@Query("replace_types") String str, @Query("value") int i);
}