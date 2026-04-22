package im.keywordBlocking;

import com.tencent.tauth.AuthActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KBPageData.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0018"}, d2 = {"Lim/keywordBlocking/KBAlertDeleteConfirm;", "Lim/keywordBlocking/KBAlert;", "confirmAction", "Lim/keywordBlocking/KBAction;", "cancelAction", "<init>", "(Lim/keywordBlocking/KBAction;Lim/keywordBlocking/KBAction;)V", AuthActivity.ACTION_KEY, "Lim/keywordBlocking/KBActionDeleteItem;", "(Lim/keywordBlocking/KBActionDeleteItem;)V", "getConfirmAction", "()Lim/keywordBlocking/KBAction;", "getCancelAction", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KBAlertDeleteConfirm implements KBAlert {
    private final KBAction cancelAction;
    private final KBAction confirmAction;

    public static /* synthetic */ KBAlertDeleteConfirm copy$default(KBAlertDeleteConfirm kBAlertDeleteConfirm, KBAction kBAction, KBAction kBAction2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kBAction = kBAlertDeleteConfirm.confirmAction;
        }
        if ((i2 & 2) != 0) {
            kBAction2 = kBAlertDeleteConfirm.cancelAction;
        }
        return kBAlertDeleteConfirm.copy(kBAction, kBAction2);
    }

    public final KBAction component1() {
        return this.confirmAction;
    }

    public final KBAction component2() {
        return this.cancelAction;
    }

    public final KBAlertDeleteConfirm copy(KBAction kBAction, KBAction kBAction2) {
        Intrinsics.checkNotNullParameter(kBAction, "confirmAction");
        Intrinsics.checkNotNullParameter(kBAction2, "cancelAction");
        return new KBAlertDeleteConfirm(kBAction, kBAction2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KBAlertDeleteConfirm) {
            KBAlertDeleteConfirm kBAlertDeleteConfirm = (KBAlertDeleteConfirm) obj;
            return Intrinsics.areEqual(this.confirmAction, kBAlertDeleteConfirm.confirmAction) && Intrinsics.areEqual(this.cancelAction, kBAlertDeleteConfirm.cancelAction);
        }
        return false;
    }

    public int hashCode() {
        return (this.confirmAction.hashCode() * 31) + this.cancelAction.hashCode();
    }

    public String toString() {
        KBAction kBAction = this.confirmAction;
        return "KBAlertDeleteConfirm(confirmAction=" + kBAction + ", cancelAction=" + this.cancelAction + ")";
    }

    public KBAlertDeleteConfirm(KBAction confirmAction, KBAction cancelAction) {
        Intrinsics.checkNotNullParameter(confirmAction, "confirmAction");
        Intrinsics.checkNotNullParameter(cancelAction, "cancelAction");
        this.confirmAction = confirmAction;
        this.cancelAction = cancelAction;
    }

    @Override // im.keywordBlocking.KBAlert
    public KBAction getConfirmAction() {
        return this.confirmAction;
    }

    @Override // im.keywordBlocking.KBAlert
    public KBAction getCancelAction() {
        return this.cancelAction;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KBAlertDeleteConfirm(KBActionDeleteItem action) {
        this(new KBActionDeleteConfirm(action.getItem()), KBActionDeleteCancel.INSTANCE);
        Intrinsics.checkNotNullParameter(action, AuthActivity.ACTION_KEY);
    }
}