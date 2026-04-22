package tv.danmaku.bili.auth.api;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: AuthLoginResponse.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/auth/api/AuthLoginResponse;", "", "<init>", "()V", "redirectUrl", "", "getRedirectUrl", "()Ljava/lang/String;", "setRedirectUrl", "(Ljava/lang/String;)V", "returnScheme", "getReturnScheme", "setReturnScheme", LoginReporterV2.Show.SIGNUP_KEY_CODE, "getCode", "setCode", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AuthLoginResponse {
    public static final int $stable = 8;
    private String code;
    @JSONField(name = "redirect_url")
    private String redirectUrl;
    @JSONField(name = "return_scheme")
    private String returnScheme;

    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    public final void setRedirectUrl(String str) {
        this.redirectUrl = str;
    }

    public final String getReturnScheme() {
        return this.returnScheme;
    }

    public final void setReturnScheme(String str) {
        this.returnScheme = str;
    }

    public final String getCode() {
        return this.code;
    }

    public final void setCode(String str) {
        this.code = str;
    }
}