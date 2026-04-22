package im.keywordBlocking;

import com.tencent.tauth.AuthActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KBPageData.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lim/keywordBlocking/KBDropListItemDelete;", "Lim/keywordBlocking/KBDropListItem;", AuthActivity.ACTION_KEY, "Lim/keywordBlocking/KBAction;", "<init>", "(Lim/keywordBlocking/KBAction;)V", "getAction", "()Lim/keywordBlocking/KBAction;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KBDropListItemDelete implements KBDropListItem {
    private final KBAction action;

    public static /* synthetic */ KBDropListItemDelete copy$default(KBDropListItemDelete kBDropListItemDelete, KBAction kBAction, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kBAction = kBDropListItemDelete.action;
        }
        return kBDropListItemDelete.copy(kBAction);
    }

    public final KBAction component1() {
        return this.action;
    }

    public final KBDropListItemDelete copy(KBAction kBAction) {
        return new KBDropListItemDelete(kBAction);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof KBDropListItemDelete) && Intrinsics.areEqual(this.action, ((KBDropListItemDelete) obj).action);
    }

    public int hashCode() {
        if (this.action == null) {
            return 0;
        }
        return this.action.hashCode();
    }

    public String toString() {
        return "KBDropListItemDelete(action=" + this.action + ")";
    }

    public KBDropListItemDelete(KBAction action) {
        this.action = action;
    }

    @Override // im.keywordBlocking.KBDropListItem
    public KBAction getAction() {
        return this.action;
    }
}