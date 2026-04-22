package im.direct.notification.interactive;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: INAction.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lim/direct/notification/interactive/INActionThankFail;", "Lim/direct/notification/interactive/INAction;", "error", "", "<init>", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "interactive_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class INActionThankFail implements INAction {
    private final Throwable error;

    public static /* synthetic */ INActionThankFail copy$default(INActionThankFail iNActionThankFail, Throwable th, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            th = iNActionThankFail.error;
        }
        return iNActionThankFail.copy(th);
    }

    public final Throwable component1() {
        return this.error;
    }

    public final INActionThankFail copy(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        return new INActionThankFail(th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof INActionThankFail) && Intrinsics.areEqual(this.error, ((INActionThankFail) obj).error);
    }

    public int hashCode() {
        return this.error.hashCode();
    }

    public String toString() {
        return "INActionThankFail(error=" + this.error + ")";
    }

    public INActionThankFail(Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.error = error;
    }

    public final Throwable getError() {
        return this.error;
    }
}