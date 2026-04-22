package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ranges.OpenEndRange;
import kotlin.time.Duration;

/* compiled from: DateTimeFormat.kt */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0016\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u0002X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"kntr/base/localization/DateTimeFormatKt$until$1", "Lkotlin/ranges/OpenEndRange;", "Lkotlin/time/Duration;", "start", "getStart-UwyO8pc", "()J", "J", "endExclusive", "getEndExclusive-UwyO8pc", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DateTimeFormatKt$until$1 implements OpenEndRange<Duration> {
    private final long endExclusive;
    private final long start;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DateTimeFormatKt$until$1(long $receiver, long j) {
        this.start = $receiver;
        this.endExclusive = j;
    }

    public /* bridge */ /* synthetic */ boolean contains(Comparable value) {
        return m1597containsLRDsOJo(((Duration) value).unbox-impl());
    }

    /* renamed from: contains-LRDsOJo  reason: not valid java name */
    public /* bridge */ boolean m1597containsLRDsOJo(long j) {
        return OpenEndRange.DefaultImpls.contains(this, Duration.box-impl(j));
    }

    public /* bridge */ /* synthetic */ Comparable getEndExclusive() {
        return Duration.box-impl(m1598getEndExclusiveUwyO8pc());
    }

    public /* bridge */ /* synthetic */ Comparable getStart() {
        return Duration.box-impl(m1599getStartUwyO8pc());
    }

    public /* bridge */ boolean isEmpty() {
        return OpenEndRange.DefaultImpls.isEmpty(this);
    }

    /* renamed from: getStart-UwyO8pc  reason: not valid java name */
    public long m1599getStartUwyO8pc() {
        return this.start;
    }

    /* renamed from: getEndExclusive-UwyO8pc  reason: not valid java name */
    public long m1598getEndExclusiveUwyO8pc() {
        return this.endExclusive;
    }
}