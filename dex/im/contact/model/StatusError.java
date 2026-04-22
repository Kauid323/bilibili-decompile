package im.contact.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMContactPageStatus.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lim/contact/model/StatusError;", "Lim/contact/model/IMContactPageStatus;", "message", "", "<init>", "(Ljava/lang/String;)V", "throwable", "", "(Ljava/lang/Throwable;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StatusError implements IMContactPageStatus {
    private final String message;

    public static /* synthetic */ StatusError copy$default(StatusError statusError, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = statusError.message;
        }
        return statusError.copy(str);
    }

    public final String component1() {
        return this.message;
    }

    public final StatusError copy(String str) {
        return new StatusError(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StatusError) && Intrinsics.areEqual(this.message, ((StatusError) obj).message);
    }

    public int hashCode() {
        if (this.message == null) {
            return 0;
        }
        return this.message.hashCode();
    }

    public String toString() {
        return "StatusError(message=" + this.message + ")";
    }

    public StatusError(String message) {
        this.message = message;
    }

    public final String getMessage() {
        return this.message;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StatusError(Throwable throwable) {
        this(throwable.getMessage());
        Intrinsics.checkNotNullParameter(throwable, "throwable");
    }
}