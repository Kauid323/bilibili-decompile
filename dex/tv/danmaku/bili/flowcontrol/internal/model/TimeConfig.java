package tv.danmaku.bili.flowcontrol.internal.model;

import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;

/* compiled from: TimePolicies.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/flowcontrol/internal/model/TimeConfig;", "", "s", "", "e", "<init>", "(JJ)V", "getS", "()J", "setS", "(J)V", "getE", "setE", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TimeConfig {
    private long e;
    private long s;

    public TimeConfig() {
        this(0L, 0L, 3, null);
    }

    public static /* synthetic */ TimeConfig copy$default(TimeConfig timeConfig, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = timeConfig.s;
        }
        if ((i & 2) != 0) {
            j2 = timeConfig.e;
        }
        return timeConfig.copy(j, j2);
    }

    public final long component1() {
        return this.s;
    }

    public final long component2() {
        return this.e;
    }

    public final TimeConfig copy(long j, long j2) {
        return new TimeConfig(j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TimeConfig) {
            TimeConfig timeConfig = (TimeConfig) obj;
            return this.s == timeConfig.s && this.e == timeConfig.e;
        }
        return false;
    }

    public int hashCode() {
        return (ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.s) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.e);
    }

    public String toString() {
        long j = this.s;
        return "TimeConfig(s=" + j + ", e=" + this.e + ")";
    }

    public TimeConfig(long s, long e) {
        this.s = s;
        this.e = e;
    }

    public /* synthetic */ TimeConfig(long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2);
    }

    public final long getS() {
        return this.s;
    }

    public final void setS(long j) {
        this.s = j;
    }

    public final long getE() {
        return this.e;
    }

    public final void setE(long j) {
        this.e = j;
    }
}