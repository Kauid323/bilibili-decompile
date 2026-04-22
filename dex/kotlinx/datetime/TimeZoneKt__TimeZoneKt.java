package kotlinx.datetime;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimeZone.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004*8\b\u0007\u0010\u0005\"\u00020\u00062\u00020\u0006B*\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u001c\b\n\u0012\u0018\b\u000bB\u0014\b\u000b\u0012\u0006\b\f\u0012\u0002\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¨\u0006\u000f"}, d2 = {"offsetIn", "Lkotlinx/datetime/UtcOffset;", "Lkotlinx/datetime/Instant;", "timeZone", "Lkotlinx/datetime/TimeZone;", "ZoneOffset", "Lkotlinx/datetime/FixedOffsetTimeZone;", "Lkotlin/Deprecated;", "message", "Use FixedOffsetTimeZone or UtcOffset instead", "replaceWith", "Lkotlin/ReplaceWith;", "imports", "expression", "FixedOffsetTimeZone", "kotlinx-datetime"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "kotlinx/datetime/TimeZoneKt")
final /* synthetic */ class TimeZoneKt__TimeZoneKt {
    @Deprecated(message = "Use FixedOffsetTimeZone or UtcOffset instead", replaceWith = @ReplaceWith(expression = "FixedOffsetTimeZone", imports = {}))
    public static /* synthetic */ void ZoneOffset$annotations() {
    }

    public static final UtcOffset offsetIn(Instant $this$offsetIn, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter($this$offsetIn, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return TimeZoneKt.offsetAt(timeZone, $this$offsetIn);
    }
}