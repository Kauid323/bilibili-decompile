package im.keywordBlocking;

import kotlin.Metadata;

/* compiled from: KBAction.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lim/keywordBlocking/KBActionAddCancel;", "Lim/keywordBlocking/KBAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KBActionAddCancel implements KBAction {
    public static final KBActionAddCancel INSTANCE = new KBActionAddCancel();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KBActionAddCancel) {
            KBActionAddCancel kBActionAddCancel = (KBActionAddCancel) obj;
            return true;
        }
        return false;
    }

    public int hashCode() {
        return -957018220;
    }

    public String toString() {
        return "KBActionAddCancel";
    }

    private KBActionAddCancel() {
    }
}