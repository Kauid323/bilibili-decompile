package tv.danmaku.bili.fullscreen.service;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: LoginResultService.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/AccountFailed;", "Ltv/danmaku/bili/fullscreen/service/IAccountResult;", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(Ljava/lang/Exception;)V", "getError", "()Ljava/lang/Exception;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AccountFailed implements IAccountResult {
    public static final int $stable = 8;
    private final Exception error;

    public AccountFailed() {
        this(null, 1, null);
    }

    public static /* synthetic */ AccountFailed copy$default(AccountFailed accountFailed, Exception exc, int i, Object obj) {
        if ((i & 1) != 0) {
            exc = accountFailed.error;
        }
        return accountFailed.copy(exc);
    }

    public final Exception component1() {
        return this.error;
    }

    public final AccountFailed copy(Exception exc) {
        return new AccountFailed(exc);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AccountFailed) && Intrinsics.areEqual(this.error, ((AccountFailed) obj).error);
    }

    public int hashCode() {
        if (this.error == null) {
            return 0;
        }
        return this.error.hashCode();
    }

    public String toString() {
        return "AccountFailed(error=" + this.error + ")";
    }

    public AccountFailed(Exception error) {
        this.error = error;
    }

    public /* synthetic */ AccountFailed(Exception exc, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : exc);
    }

    public final Exception getError() {
        return this.error;
    }
}