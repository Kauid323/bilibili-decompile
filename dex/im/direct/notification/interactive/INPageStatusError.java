package im.direct.notification.interactive;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: INState.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lim/direct/notification/interactive/INPageStatusError;", "Lim/direct/notification/interactive/INPageStatus;", "error", "", "<init>", "(Ljava/lang/Throwable;)V", "getError$annotations", "()V", "getError", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "interactive_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class INPageStatusError implements INPageStatus {
    private final Throwable error;

    public static /* synthetic */ INPageStatusError copy$default(INPageStatusError iNPageStatusError, Throwable th, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            th = iNPageStatusError.error;
        }
        return iNPageStatusError.copy(th);
    }

    public static /* synthetic */ void getError$annotations() {
    }

    public final Throwable component1() {
        return this.error;
    }

    public final INPageStatusError copy(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        return new INPageStatusError(th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof INPageStatusError) && Intrinsics.areEqual(this.error, ((INPageStatusError) obj).error);
    }

    public int hashCode() {
        return this.error.hashCode();
    }

    public String toString() {
        return "INPageStatusError(error=" + this.error + ")";
    }

    public INPageStatusError(Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.error = error;
    }

    public final Throwable getError() {
        return this.error;
    }
}