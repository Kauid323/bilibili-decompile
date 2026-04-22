package tv.danmaku.bili.change;

import com.bilibili.lib.accounts.model.SimpleAccountItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: Actions.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/change/RemoveFinishedAction;", "Ltv/danmaku/bili/change/IIntentAction;", "account", "Lcom/bilibili/lib/accounts/model/SimpleAccountItem;", "error", "", "<init>", "(Lcom/bilibili/lib/accounts/model/SimpleAccountItem;Ljava/lang/Throwable;)V", "getAccount", "()Lcom/bilibili/lib/accounts/model/SimpleAccountItem;", "getError", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RemoveFinishedAction implements IIntentAction {
    public static final int $stable = 8;
    private final SimpleAccountItem account;
    private final Throwable error;

    public static /* synthetic */ RemoveFinishedAction copy$default(RemoveFinishedAction removeFinishedAction, SimpleAccountItem simpleAccountItem, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            simpleAccountItem = removeFinishedAction.account;
        }
        if ((i & 2) != 0) {
            th = removeFinishedAction.error;
        }
        return removeFinishedAction.copy(simpleAccountItem, th);
    }

    public final SimpleAccountItem component1() {
        return this.account;
    }

    public final Throwable component2() {
        return this.error;
    }

    public final RemoveFinishedAction copy(SimpleAccountItem simpleAccountItem, Throwable th) {
        Intrinsics.checkNotNullParameter(simpleAccountItem, "account");
        return new RemoveFinishedAction(simpleAccountItem, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RemoveFinishedAction) {
            RemoveFinishedAction removeFinishedAction = (RemoveFinishedAction) obj;
            return Intrinsics.areEqual(this.account, removeFinishedAction.account) && Intrinsics.areEqual(this.error, removeFinishedAction.error);
        }
        return false;
    }

    public int hashCode() {
        return (this.account.hashCode() * 31) + (this.error == null ? 0 : this.error.hashCode());
    }

    public String toString() {
        SimpleAccountItem simpleAccountItem = this.account;
        return "RemoveFinishedAction(account=" + simpleAccountItem + ", error=" + this.error + ")";
    }

    public RemoveFinishedAction(SimpleAccountItem account, Throwable error) {
        Intrinsics.checkNotNullParameter(account, "account");
        this.account = account;
        this.error = error;
    }

    public /* synthetic */ RemoveFinishedAction(SimpleAccountItem simpleAccountItem, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(simpleAccountItem, (i & 2) != 0 ? null : th);
    }

    public final SimpleAccountItem getAccount() {
        return this.account;
    }

    public final Throwable getError() {
        return this.error;
    }
}