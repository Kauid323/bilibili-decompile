package tv.danmaku.bili.auth.api;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.call.BiliCall;
import kotlin.Metadata;
import retrofit2.http.BaseUrl;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.auth.ScopeInfoResponse;

/* compiled from: AuthLoginApiService.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H'JF\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\u000b\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u00072\b\b\u0001\u0010\r\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/auth/api/AuthLoginApiService;", "", "getScopeInfo", "Lcom/bilibili/okretro/call/BiliCall;", "Lcom/bilibili/okretro/GeneralResponse;", "Ltv/danmaku/bili/auth/ScopeInfoResponse;", "clientId", "", "sessionId", "authLogin", "Ltv/danmaku/bili/auth/api/AuthLoginResponse;", "scopes", "packageName", "signature", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@BaseUrl("https://api.bilibili.com")
public interface AuthLoginApiService {
    @POST("/x/account-oauth2/v1/authorize")
    BiliCall<GeneralResponse<AuthLoginResponse>> authLogin(@Query("client_id") String str, @Query("scopes") String str2, @Query("package") String str3, @Query("signature") String str4, @Query("session_id") String str5);

    @GET("/x/account-oauth2/v1/scope")
    BiliCall<GeneralResponse<ScopeInfoResponse>> getScopeInfo(@Query("client_id") String str, @Query("session_id") String str2);
}