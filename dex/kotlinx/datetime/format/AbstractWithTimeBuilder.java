package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalTime;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.internal.format.BasicFormatStructure;
import kotlinx.datetime.internal.format.FormatStructure;

/* compiled from: LocalTimeFormat.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0016\u0010\u0015\u001a\u00020\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016¨\u0006\u0019"}, d2 = {"Lkotlinx/datetime/format/AbstractWithTimeBuilder;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithTime;", "addFormatStructureForTime", "", "structure", "Lkotlinx/datetime/internal/format/FormatStructure;", "Lkotlinx/datetime/format/TimeFieldContainer;", "amPmHour", "padding", "Lkotlinx/datetime/format/Padding;", "amPmMarker", "am", "", "pm", "hour", "minute", "second", "secondFraction", "minLength", "", "maxLength", "time", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalTime;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface AbstractWithTimeBuilder extends DateTimeFormatBuilder.WithTime {
    void addFormatStructureForTime(FormatStructure<? super TimeFieldContainer> formatStructure);

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
    void amPmHour(Padding padding);

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
    void amPmMarker(String str, String str2);

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
    void hour(Padding padding);

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
    void minute(Padding padding);

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
    void second(Padding padding);

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
    void secondFraction(int i, int i2);

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
    void time(DateTimeFormat<LocalTime> dateTimeFormat);

    /* compiled from: LocalTimeFormat.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class DefaultImpls {
        public static void secondFraction(AbstractWithTimeBuilder $this, int fixedLength) {
            DateTimeFormatBuilder.WithTime.DefaultImpls.secondFraction($this, fixedLength);
        }

        public static void hour(AbstractWithTimeBuilder $this, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            $this.addFormatStructureForTime(new BasicFormatStructure(new HourDirective(padding)));
        }

        public static void amPmHour(AbstractWithTimeBuilder $this, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            $this.addFormatStructureForTime(new BasicFormatStructure(new AmPmHourDirective(padding)));
        }

        public static void amPmMarker(AbstractWithTimeBuilder $this, String am, String pm) {
            Intrinsics.checkNotNullParameter(am, "am");
            Intrinsics.checkNotNullParameter(pm, "pm");
            $this.addFormatStructureForTime(new BasicFormatStructure(new AmPmMarkerDirective(am, pm)));
        }

        public static void minute(AbstractWithTimeBuilder $this, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            $this.addFormatStructureForTime(new BasicFormatStructure(new MinuteDirective(padding)));
        }

        public static void second(AbstractWithTimeBuilder $this, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            $this.addFormatStructureForTime(new BasicFormatStructure(new SecondDirective(padding)));
        }

        public static void secondFraction(AbstractWithTimeBuilder $this, int minLength, int maxLength) {
            $this.addFormatStructureForTime(new BasicFormatStructure(new FractionalSecondDirective(minLength, maxLength, null, 4, null)));
        }

        public static void time(AbstractWithTimeBuilder $this, DateTimeFormat<LocalTime> format) {
            Intrinsics.checkNotNullParameter(format, "format");
            if (format instanceof LocalTimeFormat) {
                $this.addFormatStructureForTime(((LocalTimeFormat) format).getActualFormat());
            }
        }
    }
}