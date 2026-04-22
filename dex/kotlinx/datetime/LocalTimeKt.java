package kotlinx.datetime;

import j$.time.Month;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalTime;
import kotlinx.datetime.format.DateTimeFormat;

/* compiled from: LocalTime.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0002\u001a\u00020\u0003*\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0001¢\u0006\u0004\b\u0002\u0010\u0004\u001a\u0013\u0010\u0005\u001a\u00020\u0000*\u00020\u0003H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a+\u0010\f\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\r\u001a/\u0010\f\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u0011\u001a\u0019\u0010\f\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\f\u0010\u0014\u001a\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00000\u0001H\u0000¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lkotlinx/datetime/LocalTime;", "Lkotlinx/datetime/format/DateTimeFormat;", "format", "", "(Lkotlinx/datetime/LocalTime;Lkotlinx/datetime/format/DateTimeFormat;)Ljava/lang/String;", "toLocalTime", "(Ljava/lang/String;)Lkotlinx/datetime/LocalTime;", "", "year", "monthNumber", "dayOfMonth", "Lkotlinx/datetime/LocalDateTime;", "atDate", "(Lkotlinx/datetime/LocalTime;III)Lkotlinx/datetime/LocalDateTime;", "j$/time/Month", "Lkotlinx/datetime/Month;", "month", "(Lkotlinx/datetime/LocalTime;ILj$/time/Month;I)Lkotlinx/datetime/LocalDateTime;", "Lkotlinx/datetime/LocalDate;", "date", "(Lkotlinx/datetime/LocalTime;Lkotlinx/datetime/LocalDate;)Lkotlinx/datetime/LocalDateTime;", "getIsoTimeFormat", "()Lkotlinx/datetime/format/DateTimeFormat;", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class LocalTimeKt {
    public static final String format(LocalTime $this$format, DateTimeFormat<LocalTime> format) {
        Intrinsics.checkNotNullParameter($this$format, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return format.format($this$format);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Removed to support more idiomatic code. See https://github.com/Kotlin/kotlinx-datetime/issues/339", replaceWith = @ReplaceWith(expression = "LocalTime.parse(this)", imports = {}))
    public static final LocalTime toLocalTime(String $this$toLocalTime) {
        Intrinsics.checkNotNullParameter($this$toLocalTime, "<this>");
        return LocalTime.Companion.parse$default(LocalTime.Companion, $this$toLocalTime, null, 2, null);
    }

    public static /* synthetic */ LocalDateTime atDate$default(LocalTime localTime, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        return atDate(localTime, i, i2, i3);
    }

    public static final LocalDateTime atDate(LocalTime $this$atDate, int year, int monthNumber, int dayOfMonth) {
        Intrinsics.checkNotNullParameter($this$atDate, "<this>");
        return new LocalDateTime(year, monthNumber, dayOfMonth, $this$atDate.getHour(), $this$atDate.getMinute(), $this$atDate.getSecond(), $this$atDate.getNanosecond());
    }

    public static /* synthetic */ LocalDateTime atDate$default(LocalTime localTime, int i, Month month, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return atDate(localTime, i, month, i2);
    }

    public static final LocalDateTime atDate(LocalTime $this$atDate, int year, Month month, int dayOfMonth) {
        Intrinsics.checkNotNullParameter($this$atDate, "<this>");
        Intrinsics.checkNotNullParameter(month, "month");
        return new LocalDateTime(year, month, dayOfMonth, $this$atDate.getHour(), $this$atDate.getMinute(), $this$atDate.getSecond(), $this$atDate.getNanosecond());
    }

    public static final LocalDateTime atDate(LocalTime $this$atDate, LocalDate date) {
        Intrinsics.checkNotNullParameter($this$atDate, "<this>");
        Intrinsics.checkNotNullParameter(date, "date");
        return new LocalDateTime(date, $this$atDate);
    }

    public static final DateTimeFormat<LocalTime> getIsoTimeFormat() {
        return LocalTime.Formats.INSTANCE.getISO();
    }
}