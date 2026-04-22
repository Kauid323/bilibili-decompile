package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: NetCodeState.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/LoginSuccess;", "Ltv/danmaku/bili/fullscreen/state/NetCodeState;", "loginType", "", "<init>", "(Ljava/lang/String;)V", "getLoginType", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginSuccess implements NetCodeState {
    public static final int $stable = 0;
    private final String loginType;

    public static /* synthetic */ LoginSuccess copy$default(LoginSuccess loginSuccess, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loginSuccess.loginType;
        }
        return loginSuccess.copy(str);
    }

    public final String component1() {
        return this.loginType;
    }

    public final LoginSuccess copy(String str) {
        Intrinsics.checkNotNullParameter(str, "loginType");
        return new LoginSuccess(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LoginSuccess) && Intrinsics.areEqual(this.loginType, ((LoginSuccess) obj).loginType);
    }

    public int hashCode() {
        return this.loginType.hashCode();
    }

    public String toString() {
        return "LoginSuccess(loginType=" + this.loginType + ")";
    }

    public LoginSuccess(String loginType) {
        Intrinsics.checkNotNullParameter(loginType, "loginType");
        this.loginType = loginType;
    }

    public final String getLoginType() {
        return this.loginType;
    }
}