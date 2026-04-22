package tv.danmaku.bili.change;

import com.bilibili.lib.accounts.model.SimpleAccountItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: Actions.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/change/RemoveAccountAction;", "Ltv/danmaku/bili/change/IIntentAction;", "account", "Lcom/bilibili/lib/accounts/model/SimpleAccountItem;", "<init>", "(Lcom/bilibili/lib/accounts/model/SimpleAccountItem;)V", "getAccount", "()Lcom/bilibili/lib/accounts/model/SimpleAccountItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RemoveAccountAction implements IIntentAction {
    public static final int $stable = 8;
    private final SimpleAccountItem account;

    public static /* synthetic */ RemoveAccountAction copy$default(RemoveAccountAction removeAccountAction, SimpleAccountItem simpleAccountItem, int i, Object obj) {
        if ((i & 1) != 0) {
            simpleAccountItem = removeAccountAction.account;
        }
        return removeAccountAction.copy(simpleAccountItem);
    }

    public final SimpleAccountItem component1() {
        return this.account;
    }

    public final RemoveAccountAction copy(SimpleAccountItem simpleAccountItem) {
        Intrinsics.checkNotNullParameter(simpleAccountItem, "account");
        return new RemoveAccountAction(simpleAccountItem);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RemoveAccountAction) && Intrinsics.areEqual(this.account, ((RemoveAccountAction) obj).account);
    }

    public int hashCode() {
        return this.account.hashCode();
    }

    public String toString() {
        return "RemoveAccountAction(account=" + this.account + ")";
    }

    public RemoveAccountAction(SimpleAccountItem account) {
        Intrinsics.checkNotNullParameter(account, "account");
        this.account = account;
    }

    public final SimpleAccountItem getAccount() {
        return this.account;
    }
}