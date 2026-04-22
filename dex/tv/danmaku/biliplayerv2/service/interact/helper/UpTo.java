package tv.danmaku.biliplayerv2.service.interact.helper;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.time.Duration;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ThumbnailConfig.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u001a\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/helper/UpTo;", "Ltv/danmaku/biliplayerv2/service/interact/helper/DurationConstraint;", "max", "Lkotlin/time/Duration;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMax-UwyO8pc", "()J", "J", "contains", "", "duration", "contains-LRDsOJo", "(J)Z", "component1", "component1-UwyO8pc", "copy", "copy-LRDsOJo", "(J)Ltv/danmaku/biliplayerv2/service/interact/helper/UpTo;", "equals", "other", "", "hashCode", "", "toString", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class UpTo implements DurationConstraint {
    private final long max;

    public /* synthetic */ UpTo(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    /* renamed from: copy-LRDsOJo$default  reason: not valid java name */
    public static /* synthetic */ UpTo m2278copyLRDsOJo$default(UpTo upTo, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = upTo.max;
        }
        return upTo.m2280copyLRDsOJo(j);
    }

    /* renamed from: component1-UwyO8pc  reason: not valid java name */
    public final long m2279component1UwyO8pc() {
        return this.max;
    }

    /* renamed from: copy-LRDsOJo  reason: not valid java name */
    public final UpTo m2280copyLRDsOJo(long j) {
        return new UpTo(j, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UpTo) && Duration.equals-impl0(this.max, ((UpTo) obj).max);
    }

    public int hashCode() {
        return Duration.hashCode-impl(this.max);
    }

    public String toString() {
        return "UpTo(max=" + Duration.toString-impl(this.max) + ")";
    }

    private UpTo(long max) {
        this.max = max;
    }

    /* renamed from: getMax-UwyO8pc  reason: not valid java name */
    public final long m2281getMaxUwyO8pc() {
        return this.max;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.helper.DurationConstraint
    /* renamed from: contains-LRDsOJo */
    public boolean mo2265containsLRDsOJo(long j) {
        return Duration.compareTo-LRDsOJo(j, this.max) <= 0;
    }
}