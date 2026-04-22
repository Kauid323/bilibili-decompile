package tv.danmaku.biliplayerv2.service.interact.helper;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.time.Duration;
import tv.danmaku.bili.videopage.common.callback.ShareIconObserverKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ThumbnailConfig.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0011\u0010\bJ\u0010\u0010\u0012\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0013\u0010\bJ$\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u001e"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/helper/ClosedRange;", "Ltv/danmaku/biliplayerv2/service/interact/helper/DurationConstraint;", "start", "Lkotlin/time/Duration;", ShareIconObserverKt.SHARE_FROM_END, "<init>", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStart-UwyO8pc", "()J", "J", "getEnd-UwyO8pc", "contains", "", "duration", "contains-LRDsOJo", "(J)Z", "component1", "component1-UwyO8pc", "component2", "component2-UwyO8pc", "copy", "copy-QTBD994", "(JJ)Ltv/danmaku/biliplayerv2/service/interact/helper/ClosedRange;", "equals", "other", "", "hashCode", "", "toString", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ClosedRange implements DurationConstraint {
    private final long end;
    private final long start;

    public /* synthetic */ ClosedRange(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    /* renamed from: copy-QTBD994$default  reason: not valid java name */
    public static /* synthetic */ ClosedRange m2266copyQTBD994$default(ClosedRange closedRange, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = closedRange.start;
        }
        if ((i & 2) != 0) {
            j2 = closedRange.end;
        }
        return closedRange.m2269copyQTBD994(j, j2);
    }

    /* renamed from: component1-UwyO8pc  reason: not valid java name */
    public final long m2267component1UwyO8pc() {
        return this.start;
    }

    /* renamed from: component2-UwyO8pc  reason: not valid java name */
    public final long m2268component2UwyO8pc() {
        return this.end;
    }

    /* renamed from: copy-QTBD994  reason: not valid java name */
    public final ClosedRange m2269copyQTBD994(long j, long j2) {
        return new ClosedRange(j, j2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ClosedRange) {
            ClosedRange closedRange = (ClosedRange) obj;
            return Duration.equals-impl0(this.start, closedRange.start) && Duration.equals-impl0(this.end, closedRange.end);
        }
        return false;
    }

    public int hashCode() {
        return (Duration.hashCode-impl(this.start) * 31) + Duration.hashCode-impl(this.end);
    }

    public String toString() {
        String str = Duration.toString-impl(this.start);
        return "ClosedRange(start=" + str + ", end=" + Duration.toString-impl(this.end) + ")";
    }

    private ClosedRange(long start, long end) {
        this.start = start;
        this.end = end;
    }

    /* renamed from: getEnd-UwyO8pc  reason: not valid java name */
    public final long m2270getEndUwyO8pc() {
        return this.end;
    }

    /* renamed from: getStart-UwyO8pc  reason: not valid java name */
    public final long m2271getStartUwyO8pc() {
        return this.start;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.helper.DurationConstraint
    /* renamed from: contains-LRDsOJo */
    public boolean mo2265containsLRDsOJo(long j) {
        return Duration.box-impl(j).compareTo(Duration.box-impl(this.end)) <= 0 && Duration.box-impl(j).compareTo(Duration.box-impl(this.start)) >= 0;
    }
}