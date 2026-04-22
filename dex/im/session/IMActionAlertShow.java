package im.session;

import im.session.model.IMSessionAlert;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMAction.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lim/session/IMActionAlertShow;", "Lim/session/IMAction;", "alert", "Lim/session/model/IMSessionAlert;", "<init>", "(Lim/session/model/IMSessionAlert;)V", "getAlert", "()Lim/session/model/IMSessionAlert;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMActionAlertShow implements IMAction {
    private final IMSessionAlert alert;

    public static /* synthetic */ IMActionAlertShow copy$default(IMActionAlertShow iMActionAlertShow, IMSessionAlert iMSessionAlert, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            iMSessionAlert = iMActionAlertShow.alert;
        }
        return iMActionAlertShow.copy(iMSessionAlert);
    }

    public final IMSessionAlert component1() {
        return this.alert;
    }

    public final IMActionAlertShow copy(IMSessionAlert iMSessionAlert) {
        Intrinsics.checkNotNullParameter(iMSessionAlert, "alert");
        return new IMActionAlertShow(iMSessionAlert);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IMActionAlertShow) && Intrinsics.areEqual(this.alert, ((IMActionAlertShow) obj).alert);
    }

    public int hashCode() {
        return this.alert.hashCode();
    }

    public String toString() {
        return "IMActionAlertShow(alert=" + this.alert + ")";
    }

    public IMActionAlertShow(IMSessionAlert alert) {
        Intrinsics.checkNotNullParameter(alert, "alert");
        this.alert = alert;
    }

    public final IMSessionAlert getAlert() {
        return this.alert;
    }
}