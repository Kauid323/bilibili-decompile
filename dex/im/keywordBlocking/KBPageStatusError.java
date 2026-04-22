package im.keywordBlocking;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KBPageStatus.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lim/keywordBlocking/KBPageStatusError;", "Lim/keywordBlocking/KBPageStatus;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage$annotations", "()V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KBPageStatusError implements KBPageStatus {
    private final String message;

    public static /* synthetic */ KBPageStatusError copy$default(KBPageStatusError kBPageStatusError, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = kBPageStatusError.message;
        }
        return kBPageStatusError.copy(str);
    }

    public static /* synthetic */ void getMessage$annotations() {
    }

    public final String component1() {
        return this.message;
    }

    public final KBPageStatusError copy(String str) {
        return new KBPageStatusError(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof KBPageStatusError) && Intrinsics.areEqual(this.message, ((KBPageStatusError) obj).message);
    }

    public int hashCode() {
        if (this.message == null) {
            return 0;
        }
        return this.message.hashCode();
    }

    public String toString() {
        return "KBPageStatusError(message=" + this.message + ")";
    }

    public KBPageStatusError(String message) {
        this.message = message;
    }

    public final String getMessage() {
        return this.message;
    }
}