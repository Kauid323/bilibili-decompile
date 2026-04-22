package kntr.base.net;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Gnet.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lkntr/base/net/HttpStatus;", "", "value", "", "description", "", "<init>", "(ILjava/lang/String;)V", "getValue", "()I", "getDescription", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class HttpStatus {
    private final String description;
    private final int value;

    public static /* synthetic */ HttpStatus copy$default(HttpStatus httpStatus, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = httpStatus.value;
        }
        if ((i2 & 2) != 0) {
            str = httpStatus.description;
        }
        return httpStatus.copy(i, str);
    }

    public final int component1() {
        return this.value;
    }

    public final String component2() {
        return this.description;
    }

    public final HttpStatus copy(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "description");
        return new HttpStatus(i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HttpStatus) {
            HttpStatus httpStatus = (HttpStatus) obj;
            return this.value == httpStatus.value && Intrinsics.areEqual(this.description, httpStatus.description);
        }
        return false;
    }

    public int hashCode() {
        return (this.value * 31) + this.description.hashCode();
    }

    public String toString() {
        int i = this.value;
        return "HttpStatus(value=" + i + ", description=" + this.description + ")";
    }

    public HttpStatus(int value, String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        this.value = value;
        this.description = description;
    }

    public final int getValue() {
        return this.value;
    }

    public final String getDescription() {
        return this.description;
    }
}