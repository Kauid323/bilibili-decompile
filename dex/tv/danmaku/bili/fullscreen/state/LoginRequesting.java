package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: NetCodeState.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/LoginRequesting;", "Ltv/danmaku/bili/fullscreen/state/NetCodeState;", "Ltv/danmaku/bili/fullscreen/state/NetCodeLoadingState;", "bizSeq", "", "codeSecret", "extendCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBizSeq", "()Ljava/lang/String;", "getCodeSecret", "getExtendCode", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginRequesting implements NetCodeState, NetCodeLoadingState {
    public static final int $stable = 0;
    private final String bizSeq;
    private final String codeSecret;
    private final String extendCode;

    public static /* synthetic */ LoginRequesting copy$default(LoginRequesting loginRequesting, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loginRequesting.bizSeq;
        }
        if ((i & 2) != 0) {
            str2 = loginRequesting.codeSecret;
        }
        if ((i & 4) != 0) {
            str3 = loginRequesting.extendCode;
        }
        return loginRequesting.copy(str, str2, str3);
    }

    public final String component1() {
        return this.bizSeq;
    }

    public final String component2() {
        return this.codeSecret;
    }

    public final String component3() {
        return this.extendCode;
    }

    public final LoginRequesting copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "bizSeq");
        Intrinsics.checkNotNullParameter(str2, "codeSecret");
        Intrinsics.checkNotNullParameter(str3, "extendCode");
        return new LoginRequesting(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LoginRequesting) {
            LoginRequesting loginRequesting = (LoginRequesting) obj;
            return Intrinsics.areEqual(this.bizSeq, loginRequesting.bizSeq) && Intrinsics.areEqual(this.codeSecret, loginRequesting.codeSecret) && Intrinsics.areEqual(this.extendCode, loginRequesting.extendCode);
        }
        return false;
    }

    public int hashCode() {
        return (((this.bizSeq.hashCode() * 31) + this.codeSecret.hashCode()) * 31) + this.extendCode.hashCode();
    }

    public String toString() {
        String str = this.bizSeq;
        String str2 = this.codeSecret;
        return "LoginRequesting(bizSeq=" + str + ", codeSecret=" + str2 + ", extendCode=" + this.extendCode + ")";
    }

    public LoginRequesting(String bizSeq, String codeSecret, String extendCode) {
        Intrinsics.checkNotNullParameter(bizSeq, "bizSeq");
        Intrinsics.checkNotNullParameter(codeSecret, "codeSecret");
        Intrinsics.checkNotNullParameter(extendCode, "extendCode");
        this.bizSeq = bizSeq;
        this.codeSecret = codeSecret;
        this.extendCode = extendCode;
    }

    public final String getBizSeq() {
        return this.bizSeq;
    }

    public final String getCodeSecret() {
        return this.codeSecret;
    }

    public final String getExtendCode() {
        return this.extendCode;
    }
}