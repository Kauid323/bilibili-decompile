package im.base;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentStatus.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lim/base/ErrorContent;", "Lim/base/ContentStatus;", "error", "", "<init>", "(Ljava/lang/String;)V", "getError$annotations", "()V", "getError", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ErrorContent implements ContentStatus {
    private final String error;

    public static /* synthetic */ ErrorContent copy$default(ErrorContent errorContent, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = errorContent.error;
        }
        return errorContent.copy(str);
    }

    public static /* synthetic */ void getError$annotations() {
    }

    public final String component1() {
        return this.error;
    }

    public final ErrorContent copy(String str) {
        return new ErrorContent(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ErrorContent) && Intrinsics.areEqual(this.error, ((ErrorContent) obj).error);
    }

    public int hashCode() {
        if (this.error == null) {
            return 0;
        }
        return this.error.hashCode();
    }

    public String toString() {
        return "ErrorContent(error=" + this.error + ")";
    }

    public ErrorContent(String error) {
        this.error = error;
    }

    public final String getError() {
        return this.error;
    }
}