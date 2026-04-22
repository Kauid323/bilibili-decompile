package tv.danmaku.biliplayerv2.service.interact.helper;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.time.Duration;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ThumbnailConfig.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u001a\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/helper/From;", "Ltv/danmaku/biliplayerv2/service/interact/helper/DurationConstraint;", "min", "Lkotlin/time/Duration;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMin-UwyO8pc", "()J", "J", "contains", "", "duration", "contains-LRDsOJo", "(J)Z", "component1", "component1-UwyO8pc", "copy", "copy-LRDsOJo", "(J)Ltv/danmaku/biliplayerv2/service/interact/helper/From;", "equals", "other", "", "hashCode", "", "toString", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class From implements DurationConstraint {
    private final long min;

    public /* synthetic */ From(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    /* renamed from: copy-LRDsOJo$default  reason: not valid java name */
    public static /* synthetic */ From m2272copyLRDsOJo$default(From from, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = from.min;
        }
        return from.m2274copyLRDsOJo(j);
    }

    /* renamed from: component1-UwyO8pc  reason: not valid java name */
    public final long m2273component1UwyO8pc() {
        return this.min;
    }

    /* renamed from: copy-LRDsOJo  reason: not valid java name */
    public final From m2274copyLRDsOJo(long j) {
        return new From(j, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof From) && Duration.equals-impl0(this.min, ((From) obj).min);
    }

    public int hashCode() {
        return Duration.hashCode-impl(this.min);
    }

    public String toString() {
        return "From(min=" + Duration.toString-impl(this.min) + ")";
    }

    private From(long min) {
        this.min = min;
    }

    /* renamed from: getMin-UwyO8pc  reason: not valid java name */
    public final long m2275getMinUwyO8pc() {
        return this.min;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.helper.DurationConstraint
    /* renamed from: contains-LRDsOJo */
    public boolean mo2265containsLRDsOJo(long j) {
        return Duration.compareTo-LRDsOJo(j, this.min) >= 0;
    }
}