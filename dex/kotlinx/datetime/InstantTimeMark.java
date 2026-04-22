package kotlinx.datetime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.ComparableTimeMark;
import kotlin.time.Duration;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Clock.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001e\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0001H\u0096\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\bH\u0096\u0002ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\bH\u0096\u0002ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0016J%\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\f\u0010 \u001a\u00020\f*\u00020\u0003H\u0002J\u001e\u0010!\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0014\u001a\u00020\bH\u0002ø\u0001\u0001¢\u0006\u0004\b\"\u0010#R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Lkotlinx/datetime/InstantTimeMark;", "Lkotlin/time/ComparableTimeMark;", "instant", "Lkotlinx/datetime/Instant;", "clock", "Lkotlinx/datetime/Clock;", "(Lkotlinx/datetime/Instant;Lkotlinx/datetime/Clock;)V", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "()J", "equals", "", "other", "", "hashCode", "", "minus", "minus-5sfh64U", "(Lkotlin/time/ComparableTimeMark;)J", "duration", "minus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "plus", "plus-LRDsOJo", "saturatingDiff", "instant1", "instant2", "saturatingDiff-3nIYWDw", "(Lkotlinx/datetime/Instant;Lkotlinx/datetime/Instant;)J", "toString", "", "isSaturated", "saturatingAdd", "saturatingAdd-HG0u8IE", "(Lkotlinx/datetime/Instant;J)Lkotlinx/datetime/Instant;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class InstantTimeMark implements ComparableTimeMark {
    private final Clock clock;
    private final Instant instant;

    public InstantTimeMark(Instant instant, Clock clock) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.instant = instant;
        this.clock = clock;
    }

    @Override // java.lang.Comparable
    public int compareTo(ComparableTimeMark other) {
        return ComparableTimeMark.DefaultImpls.compareTo(this, other);
    }

    @Override // kotlin.time.TimeMark
    public boolean hasNotPassedNow() {
        return ComparableTimeMark.DefaultImpls.hasNotPassedNow(this);
    }

    @Override // kotlin.time.TimeMark
    public boolean hasPassedNow() {
        return ComparableTimeMark.DefaultImpls.hasPassedNow(this);
    }

    @Override // kotlin.time.TimeMark
    /* renamed from: elapsedNow-UwyO8pc */
    public long mo1235elapsedNowUwyO8pc() {
        return m1482saturatingDiff3nIYWDw(this.clock.now(), this.instant);
    }

    @Override // kotlin.time.TimeMark
    /* renamed from: plus-LRDsOJo */
    public ComparableTimeMark mo1238plusLRDsOJo(long duration) {
        return new InstantTimeMark(m1481saturatingAddHG0u8IE(this.instant, duration), this.clock);
    }

    @Override // kotlin.time.TimeMark
    /* renamed from: minus-LRDsOJo */
    public ComparableTimeMark mo1236minusLRDsOJo(long duration) {
        return new InstantTimeMark(m1481saturatingAddHG0u8IE(this.instant, Duration.m1289unaryMinusUwyO8pc(duration)), this.clock);
    }

    @Override // kotlin.time.ComparableTimeMark
    /* renamed from: minus-5sfh64U  reason: not valid java name */
    public long mo1237minusUwyO8pc(ComparableTimeMark other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (!(other instanceof InstantTimeMark) || !Intrinsics.areEqual(((InstantTimeMark) other).clock, this.clock)) {
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + other);
        }
        return m1482saturatingDiff3nIYWDw(this.instant, ((InstantTimeMark) other).instant);
    }

    @Override // kotlin.time.ComparableTimeMark
    public boolean equals(Object other) {
        return (other instanceof InstantTimeMark) && Intrinsics.areEqual(this.clock, ((InstantTimeMark) other).clock) && Intrinsics.areEqual(this.instant, ((InstantTimeMark) other).instant);
    }

    @Override // kotlin.time.ComparableTimeMark
    public int hashCode() {
        return this.instant.hashCode();
    }

    public String toString() {
        return "InstantTimeMark(" + this.instant + ", " + this.clock + ')';
    }

    private final boolean isSaturated(Instant $this$isSaturated) {
        return Intrinsics.areEqual($this$isSaturated, Instant.Companion.getMAX$kotlinx_datetime()) || Intrinsics.areEqual($this$isSaturated, Instant.Companion.getMIN$kotlinx_datetime());
    }

    /* renamed from: saturatingAdd-HG0u8IE  reason: not valid java name */
    private final Instant m1481saturatingAddHG0u8IE(Instant $this$saturatingAdd_u2dHG0u8IE, long duration) {
        if (isSaturated($this$saturatingAdd_u2dHG0u8IE)) {
            if (Duration.m1270isInfiniteimpl(duration) && Duration.m1272isPositiveimpl(duration) != InstantKt.isDistantFuture($this$saturatingAdd_u2dHG0u8IE)) {
                throw new IllegalArgumentException("Summing infinities of different signs");
            }
            return $this$saturatingAdd_u2dHG0u8IE;
        }
        return $this$saturatingAdd_u2dHG0u8IE.m1480plusLRDsOJo(duration);
    }

    /* renamed from: saturatingDiff-3nIYWDw  reason: not valid java name */
    private final long m1482saturatingDiff3nIYWDw(Instant instant1, Instant instant2) {
        if (Intrinsics.areEqual(instant1, instant2)) {
            return Duration.Companion.m1336getZEROUwyO8pc();
        }
        if (isSaturated(instant1) || isSaturated(instant2)) {
            return Duration.m1275timesUwyO8pc(instant1.m1478minus5sfh64U(instant2), Double.POSITIVE_INFINITY);
        }
        return instant1.m1478minus5sfh64U(instant2);
    }
}