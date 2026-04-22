package tv.danmaku.bili.moss.test.cases.bandwidth;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.anno.RequestInterceptor;
import com.bilibili.okretro.call.BiliCall;
import com.bilibili.okretro.interceptor.HeaderRequestInterceptor;
import kotlin.Metadata;
import okhttp3.RequestBody;
import retrofit2.http.BaseUrl;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import tv.danmaku.bili.BR;

/* compiled from: HeartbeatTestApi.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\t\u001a\u00020\nH'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/moss/test/cases/bandwidth/HeartbeatApi;", "", "reportV2", "Lcom/bilibili/okretro/call/BiliCall;", "Lcom/bilibili/okretro/GeneralResponse;", "", "heartbeatParams", "Ltv/danmaku/bili/moss/test/cases/bandwidth/HeartbeatParams;", "reportClick", "body", "Lokhttp3/RequestBody;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@BaseUrl("https://api.bilibili.com")
public interface HeartbeatApi {
    @POST("/x/report/click/android2")
    @RequestInterceptor(HeaderRequestInterceptor.class)
    BiliCall<String> reportClick(@Body RequestBody requestBody);

    @FormUrlEncoded
    @POST("/x/report/heartbeat/mobile")
    BiliCall<GeneralResponse<String>> reportV2(@FieldMap HeartbeatParams heartbeatParams);
}