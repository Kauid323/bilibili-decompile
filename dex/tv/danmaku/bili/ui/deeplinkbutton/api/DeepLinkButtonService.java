package tv.danmaku.bili.ui.deeplinkbutton.api;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.call.BiliCall;
import kotlin.Metadata;
import retrofit2.http.BaseUrl;
import retrofit2.http.GET;
import retrofit2.http.Query;
import tv.danmaku.bili.BR;

/* compiled from: DeepLinkButtonService.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\ba\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/deeplinkbutton/api/DeepLinkButtonService;", "", "getDeepLinkButtonInfo", "Lcom/bilibili/okretro/call/BiliCall;", "Lcom/bilibili/okretro/GeneralResponse;", "Ltv/danmaku/bili/ui/deeplinkbutton/api/DeepLinkButtonInfo;", "schema", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@BaseUrl("https://app.bilibili.com")
public interface DeepLinkButtonService {
    @GET("/x/resource/deeplink/button")
    BiliCall<GeneralResponse<DeepLinkButtonInfo>> getDeepLinkButtonInfo(@Query("schema") String str);
}