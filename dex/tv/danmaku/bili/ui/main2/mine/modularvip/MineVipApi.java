package tv.danmaku.bili.ui.main2.mine.modularvip;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.call.BiliCall;
import kotlin.Metadata;
import okhttp3.RequestBody;
import retrofit2.http.BaseUrl;
import retrofit2.http.Body;
import retrofit2.http.POST;
import tv.danmaku.bili.BR;

/* compiled from: MineVipApi.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipApi;", "", "reportExposure", "Lcom/bilibili/okretro/call/BiliCall;", "Lcom/bilibili/okretro/GeneralResponse;", "Ljava/lang/Void;", "body", "Lokhttp3/RequestBody;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@BaseUrl("https://api.bilibili.com")
public interface MineVipApi {
    @POST("/x/vip/ads/material/report")
    BiliCall<GeneralResponse<Void>> reportExposure(@Body RequestBody requestBody);
}