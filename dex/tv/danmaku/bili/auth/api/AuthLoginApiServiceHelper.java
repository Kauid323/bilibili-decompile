package tv.danmaku.bili.auth.api;

import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Callback;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.auth.ScopeInfoResponse;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: AuthLoginApiServiceHelper.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ<\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00120\f¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/auth/api/AuthLoginApiServiceHelper;", "", "<init>", "()V", "createAuthLoginApiService", "Ltv/danmaku/bili/auth/api/AuthLoginApiService;", "getScopeInfo", "", "clientId", "", "sessionId", AuthResultCbHelper.ARGS_CALLBACK, "Lcom/bilibili/okretro/BiliApiDataCallback;", "Ltv/danmaku/bili/auth/ScopeInfoResponse;", "authLogin", "scopes", "packageName", "signature", "Ltv/danmaku/bili/auth/api/AuthLoginResponse;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AuthLoginApiServiceHelper {
    public static final int $stable = 0;
    public static final AuthLoginApiServiceHelper INSTANCE = new AuthLoginApiServiceHelper();

    private AuthLoginApiServiceHelper() {
    }

    private final AuthLoginApiService createAuthLoginApiService() {
        Object createService = ServiceGenerator.createService(AuthLoginApiService.class);
        Intrinsics.checkNotNullExpressionValue(createService, "createService(...)");
        return (AuthLoginApiService) createService;
    }

    public final void getScopeInfo(String clientId, String sessionId, BiliApiDataCallback<ScopeInfoResponse> biliApiDataCallback) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(biliApiDataCallback, AuthResultCbHelper.ARGS_CALLBACK);
        createAuthLoginApiService().getScopeInfo(clientId, sessionId).enqueue((Callback) biliApiDataCallback);
    }

    public final void authLogin(String clientId, String scopes, String packageName, String signature, String sessionId, BiliApiDataCallback<AuthLoginResponse> biliApiDataCallback) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(biliApiDataCallback, AuthResultCbHelper.ARGS_CALLBACK);
        createAuthLoginApiService().authLogin(clientId, scopes, packageName, signature, sessionId).enqueue((Callback) biliApiDataCallback);
    }
}