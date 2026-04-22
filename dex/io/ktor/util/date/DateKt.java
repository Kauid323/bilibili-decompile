package io.ktor.util.date;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

/* compiled from: Date.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001c\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\u0002¢\u0006\u0004\b\u0005\u0010\u0004\u001a\u001c\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\u0002¢\u0006\u0004\b\b\u0010\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\u0002¢\u0006\u0004\b\t\u0010\u0004\u001a\u0011\u0010\n\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/util/date/GMTDate;", "", "milliseconds", "plus", "(Lio/ktor/util/date/GMTDate;J)Lio/ktor/util/date/GMTDate;", "minus", "Lkotlin/time/Duration;", "duration", "plus-HG0u8IE", "minus-HG0u8IE", "truncateToSeconds", "(Lio/ktor/util/date/GMTDate;)Lio/ktor/util/date/GMTDate;", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DateKt {
    public static final GMTDate plus(GMTDate $this$plus, long milliseconds) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        return DateJvmKt.GMTDate(Long.valueOf($this$plus.getTimestamp() + milliseconds));
    }

    public static final GMTDate minus(GMTDate $this$minus, long milliseconds) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        return DateJvmKt.GMTDate(Long.valueOf($this$minus.getTimestamp() - milliseconds));
    }

    /* renamed from: plus-HG0u8IE  reason: not valid java name */
    public static final GMTDate m1802plusHG0u8IE(GMTDate $this$plus_u2dHG0u8IE, long duration) {
        Intrinsics.checkNotNullParameter($this$plus_u2dHG0u8IE, "$this$plus");
        return DateJvmKt.GMTDate(Long.valueOf($this$plus_u2dHG0u8IE.getTimestamp() + Duration.getInWholeMilliseconds-impl(duration)));
    }

    /* renamed from: minus-HG0u8IE  reason: not valid java name */
    public static final GMTDate m1801minusHG0u8IE(GMTDate $this$minus_u2dHG0u8IE, long duration) {
        Intrinsics.checkNotNullParameter($this$minus_u2dHG0u8IE, "$this$minus");
        return DateJvmKt.GMTDate(Long.valueOf($this$minus_u2dHG0u8IE.getTimestamp() - Duration.getInWholeMilliseconds-impl(duration)));
    }

    public static final GMTDate truncateToSeconds(GMTDate $this$truncateToSeconds) {
        Intrinsics.checkNotNullParameter($this$truncateToSeconds, "<this>");
        return DateJvmKt.GMTDate($this$truncateToSeconds.getSeconds(), $this$truncateToSeconds.getMinutes(), $this$truncateToSeconds.getHours(), $this$truncateToSeconds.getDayOfMonth(), $this$truncateToSeconds.getMonth(), $this$truncateToSeconds.getYear());
    }
}