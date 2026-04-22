package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.LocalTime;
import kotlinx.datetime.format.AbstractWithDateBuilder;
import kotlinx.datetime.format.AbstractWithTimeBuilder;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.internal.format.FormatStructure;

/* compiled from: LocalDateTimeFormat.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H&J\u0016\u0010\u000b\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0016J\u0016\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¨\u0006\u0011"}, d2 = {"Lkotlinx/datetime/format/AbstractWithDateTimeBuilder;", "Lkotlinx/datetime/format/AbstractWithDateBuilder;", "Lkotlinx/datetime/format/AbstractWithTimeBuilder;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTime;", "addFormatStructureForDate", "", "structure", "Lkotlinx/datetime/internal/format/FormatStructure;", "Lkotlinx/datetime/format/DateFieldContainer;", "addFormatStructureForDateTime", "Lkotlinx/datetime/format/DateTimeFieldContainer;", "addFormatStructureForTime", "Lkotlinx/datetime/format/TimeFieldContainer;", "dateTime", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalDateTime;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface AbstractWithDateTimeBuilder extends AbstractWithDateBuilder, AbstractWithTimeBuilder, DateTimeFormatBuilder.WithDateTime {
    @Override // kotlinx.datetime.format.AbstractWithDateBuilder
    void addFormatStructureForDate(FormatStructure<? super DateFieldContainer> formatStructure);

    void addFormatStructureForDateTime(FormatStructure<? super DateTimeFieldContainer> formatStructure);

    @Override // kotlinx.datetime.format.AbstractWithTimeBuilder
    void addFormatStructureForTime(FormatStructure<? super TimeFieldContainer> formatStructure);

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDateTime
    void dateTime(DateTimeFormat<LocalDateTime> dateTimeFormat);

    /* compiled from: LocalDateTimeFormat.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class DefaultImpls {
        public static void amPmHour(AbstractWithDateTimeBuilder $this, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithTimeBuilder.DefaultImpls.amPmHour($this, padding);
        }

        public static void amPmMarker(AbstractWithDateTimeBuilder $this, String am, String pm) {
            Intrinsics.checkNotNullParameter(am, "am");
            Intrinsics.checkNotNullParameter(pm, "pm");
            AbstractWithTimeBuilder.DefaultImpls.amPmMarker($this, am, pm);
        }

        public static void date(AbstractWithDateTimeBuilder $this, DateTimeFormat<LocalDate> format) {
            Intrinsics.checkNotNullParameter(format, "format");
            AbstractWithDateBuilder.DefaultImpls.date($this, format);
        }

        public static void dayOfMonth(AbstractWithDateTimeBuilder $this, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithDateBuilder.DefaultImpls.dayOfMonth($this, padding);
        }

        public static void dayOfWeek(AbstractWithDateTimeBuilder $this, DayOfWeekNames names) {
            Intrinsics.checkNotNullParameter(names, "names");
            AbstractWithDateBuilder.DefaultImpls.dayOfWeek($this, names);
        }

        public static void hour(AbstractWithDateTimeBuilder $this, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithTimeBuilder.DefaultImpls.hour($this, padding);
        }

        public static void minute(AbstractWithDateTimeBuilder $this, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithTimeBuilder.DefaultImpls.minute($this, padding);
        }

        public static void monthName(AbstractWithDateTimeBuilder $this, MonthNames names) {
            Intrinsics.checkNotNullParameter(names, "names");
            AbstractWithDateBuilder.DefaultImpls.monthName($this, names);
        }

        public static void monthNumber(AbstractWithDateTimeBuilder $this, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithDateBuilder.DefaultImpls.monthNumber($this, padding);
        }

        public static void second(AbstractWithDateTimeBuilder $this, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithTimeBuilder.DefaultImpls.second($this, padding);
        }

        public static void secondFraction(AbstractWithDateTimeBuilder $this, int fixedLength) {
            AbstractWithTimeBuilder.DefaultImpls.secondFraction($this, fixedLength);
        }

        public static void secondFraction(AbstractWithDateTimeBuilder $this, int minLength, int maxLength) {
            AbstractWithTimeBuilder.DefaultImpls.secondFraction($this, minLength, maxLength);
        }

        public static void time(AbstractWithDateTimeBuilder $this, DateTimeFormat<LocalTime> format) {
            Intrinsics.checkNotNullParameter(format, "format");
            AbstractWithTimeBuilder.DefaultImpls.time($this, format);
        }

        public static void year(AbstractWithDateTimeBuilder $this, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithDateBuilder.DefaultImpls.year($this, padding);
        }

        public static void yearTwoDigits(AbstractWithDateTimeBuilder $this, int baseYear) {
            AbstractWithDateBuilder.DefaultImpls.yearTwoDigits($this, baseYear);
        }

        public static void addFormatStructureForDate(AbstractWithDateTimeBuilder $this, FormatStructure<? super DateFieldContainer> structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            $this.addFormatStructureForDateTime(structure);
        }

        public static void addFormatStructureForTime(AbstractWithDateTimeBuilder $this, FormatStructure<? super TimeFieldContainer> structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            $this.addFormatStructureForDateTime(structure);
        }

        public static void dateTime(AbstractWithDateTimeBuilder $this, DateTimeFormat<LocalDateTime> format) {
            Intrinsics.checkNotNullParameter(format, "format");
            if (format instanceof LocalDateTimeFormat) {
                $this.addFormatStructureForDateTime(((LocalDateTimeFormat) format).getActualFormat());
            }
        }
    }
}