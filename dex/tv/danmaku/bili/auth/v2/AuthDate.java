package tv.danmaku.bili.auth.v2;

import kotlin.Metadata;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;

/* compiled from: AuthV2ViewModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\f\u001a\u00020\r*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\rH\u0016J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/auth/v2/AuthDate;", "", "year", "", "month", "day", "<init>", "(III)V", "getYear", "()I", "getMonth", "getDay", "padStart", "", "length", "toString", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AuthDate {
    private final int day;
    private final int month;
    private final int year;

    public static /* synthetic */ AuthDate copy$default(AuthDate authDate, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = authDate.year;
        }
        if ((i4 & 2) != 0) {
            i2 = authDate.month;
        }
        if ((i4 & 4) != 0) {
            i3 = authDate.day;
        }
        return authDate.copy(i, i2, i3);
    }

    public final int component1() {
        return this.year;
    }

    public final int component2() {
        return this.month;
    }

    public final int component3() {
        return this.day;
    }

    public final AuthDate copy(int i, int i2, int i3) {
        return new AuthDate(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AuthDate) {
            AuthDate authDate = (AuthDate) obj;
            return this.year == authDate.year && this.month == authDate.month && this.day == authDate.day;
        }
        return false;
    }

    public int hashCode() {
        return (((this.year * 31) + this.month) * 31) + this.day;
    }

    public AuthDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public final int getYear() {
        return this.year;
    }

    public final int getMonth() {
        return this.month;
    }

    public final int getDay() {
        return this.day;
    }

    private final String padStart(int $this$padStart, int length) {
        return StringsKt.padStart(String.valueOf($this$padStart), length, '0');
    }

    public String toString() {
        String padStart = padStart(this.year, 4);
        String padStart2 = padStart(this.month, 2);
        return padStart + "-" + padStart2 + "-" + padStart(this.day, 2);
    }
}