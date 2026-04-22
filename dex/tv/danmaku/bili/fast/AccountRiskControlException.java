package tv.danmaku.bili.fast;

import com.bilibili.lib.accountsui.AccountStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: FastReLoginActivity.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/fast/AccountRiskControlException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "status", "Lcom/bilibili/lib/accountsui/AccountStatus;", "message", "", "<init>", "(Lcom/bilibili/lib/accountsui/AccountStatus;Ljava/lang/String;)V", "getStatus", "()Lcom/bilibili/lib/accountsui/AccountStatus;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AccountRiskControlException extends Exception {
    public static final int $stable = 8;
    private final AccountStatus status;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountRiskControlException(AccountStatus status, String message) {
        super(message);
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(message, "message");
        this.status = status;
    }

    public final AccountStatus getStatus() {
        return this.status;
    }
}