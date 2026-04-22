package tv.danmaku.bili.auth;

import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.auth.ScopeInfoResponse;

/* compiled from: AuthLoginModel.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/auth/AuthHeaderModel;", "Ltv/danmaku/bili/auth/AuthLoginModel;", "<init>", "()V", "appInfo", "Ltv/danmaku/bili/auth/ScopeInfoResponse$AppInfo;", "getAppInfo", "()Ltv/danmaku/bili/auth/ScopeInfoResponse$AppInfo;", "setAppInfo", "(Ltv/danmaku/bili/auth/ScopeInfoResponse$AppInfo;)V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AuthHeaderModel implements AuthLoginModel {
    public static final int $stable = 8;
    private ScopeInfoResponse.AppInfo appInfo;

    public final ScopeInfoResponse.AppInfo getAppInfo() {
        return this.appInfo;
    }

    public final void setAppInfo(ScopeInfoResponse.AppInfo appInfo) {
        this.appInfo = appInfo;
    }
}