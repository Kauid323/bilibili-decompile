package tv.danmaku.bili.fullscreen.state;

import com.bilibili.lib.accounts.VerifyBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: NetCodeState.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/LoginVerifying;", "Ltv/danmaku/bili/fullscreen/state/NetCodeState;", "Ltv/danmaku/bili/fullscreen/state/NetCodeLoadingState;", "verifyBundle", "Lcom/bilibili/lib/accounts/VerifyBundle;", "<init>", "(Lcom/bilibili/lib/accounts/VerifyBundle;)V", "getVerifyBundle", "()Lcom/bilibili/lib/accounts/VerifyBundle;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginVerifying implements NetCodeState, NetCodeLoadingState {
    public static final int $stable = 8;
    private final VerifyBundle verifyBundle;

    public static /* synthetic */ LoginVerifying copy$default(LoginVerifying loginVerifying, VerifyBundle verifyBundle, int i, Object obj) {
        if ((i & 1) != 0) {
            verifyBundle = loginVerifying.verifyBundle;
        }
        return loginVerifying.copy(verifyBundle);
    }

    public final VerifyBundle component1() {
        return this.verifyBundle;
    }

    public final LoginVerifying copy(VerifyBundle verifyBundle) {
        Intrinsics.checkNotNullParameter(verifyBundle, "verifyBundle");
        return new LoginVerifying(verifyBundle);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LoginVerifying) && Intrinsics.areEqual(this.verifyBundle, ((LoginVerifying) obj).verifyBundle);
    }

    public int hashCode() {
        return this.verifyBundle.hashCode();
    }

    public String toString() {
        return "LoginVerifying(verifyBundle=" + this.verifyBundle + ")";
    }

    public LoginVerifying(VerifyBundle verifyBundle) {
        Intrinsics.checkNotNullParameter(verifyBundle, "verifyBundle");
        this.verifyBundle = verifyBundle;
    }

    public final VerifyBundle getVerifyBundle() {
        return this.verifyBundle;
    }
}