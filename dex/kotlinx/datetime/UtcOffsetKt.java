package kotlinx.datetime;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.UtcOffset;
import kotlinx.datetime.format.DateTimeFormat;

/* compiled from: UtcOffset.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0000\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0001\u001a\u0018\u0010\u0006\u001a\u00020\u0007*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¨\u0006\b"}, d2 = {"UtcOffset", "Lkotlinx/datetime/UtcOffset;", "getIsoUtcOffsetFormat", "Lkotlinx/datetime/format/DateTimeFormat;", "asTimeZone", "Lkotlinx/datetime/FixedOffsetTimeZone;", "format", "", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UtcOffsetKt {
    public static final String format(UtcOffset $this$format, DateTimeFormat<UtcOffset> format) {
        Intrinsics.checkNotNullParameter($this$format, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return format.format($this$format);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use UtcOffset.ZERO instead", replaceWith = @ReplaceWith(expression = "UtcOffset.ZERO", imports = {}))
    public static final UtcOffset UtcOffset() {
        return UtcOffset.Companion.getZERO();
    }

    public static final FixedOffsetTimeZone asTimeZone(UtcOffset $this$asTimeZone) {
        Intrinsics.checkNotNullParameter($this$asTimeZone, "<this>");
        return new FixedOffsetTimeZone($this$asTimeZone);
    }

    public static final DateTimeFormat<UtcOffset> getIsoUtcOffsetFormat() {
        return UtcOffset.Formats.INSTANCE.getISO();
    }
}