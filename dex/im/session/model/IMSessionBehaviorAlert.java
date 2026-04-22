package im.session.model;

import com.bapis.bilibili.app.im.v1.KBehaviorAlertToast;
import faceverify.q;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSessionAlert.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lim/session/model/IMSessionBehaviorAlert;", "Lim/session/model/IMSessionAlert;", q.KEY_RES_9_CONTENT, "Lcom/bapis/bilibili/app/im/v1/KBehaviorAlertToast;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KBehaviorAlertToast;)V", "getContent$annotations", "()V", "getContent", "()Lcom/bapis/bilibili/app/im/v1/KBehaviorAlertToast;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSessionBehaviorAlert implements IMSessionAlert {
    private final KBehaviorAlertToast content;

    public static /* synthetic */ IMSessionBehaviorAlert copy$default(IMSessionBehaviorAlert iMSessionBehaviorAlert, KBehaviorAlertToast kBehaviorAlertToast, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kBehaviorAlertToast = iMSessionBehaviorAlert.content;
        }
        return iMSessionBehaviorAlert.copy(kBehaviorAlertToast);
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public final KBehaviorAlertToast component1() {
        return this.content;
    }

    public final IMSessionBehaviorAlert copy(KBehaviorAlertToast kBehaviorAlertToast) {
        Intrinsics.checkNotNullParameter(kBehaviorAlertToast, q.KEY_RES_9_CONTENT);
        return new IMSessionBehaviorAlert(kBehaviorAlertToast);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IMSessionBehaviorAlert) && Intrinsics.areEqual(this.content, ((IMSessionBehaviorAlert) obj).content);
    }

    public int hashCode() {
        return this.content.hashCode();
    }

    public String toString() {
        return "IMSessionBehaviorAlert(content=" + this.content + ")";
    }

    public IMSessionBehaviorAlert(KBehaviorAlertToast content) {
        Intrinsics.checkNotNullParameter(content, q.KEY_RES_9_CONTENT);
        this.content = content;
    }

    public final KBehaviorAlertToast getContent() {
        return this.content;
    }
}