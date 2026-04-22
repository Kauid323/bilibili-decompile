package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.UtcOffset;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.internal.format.BasicFormatStructure;
import kotlinx.datetime.internal.format.FormatStructure;
import kotlinx.datetime.internal.format.SignedFormatStructure;

/* compiled from: UtcOffsetFormat.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u0010"}, d2 = {"Lkotlinx/datetime/format/AbstractWithOffsetBuilder;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithUtcOffset;", "addFormatStructureForOffset", "", "structure", "Lkotlinx/datetime/internal/format/FormatStructure;", "Lkotlinx/datetime/format/UtcOffsetFieldContainer;", "offset", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/UtcOffset;", "offsetHours", "padding", "Lkotlinx/datetime/format/Padding;", "offsetMinutesOfHour", "offsetSecondsOfMinute", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface AbstractWithOffsetBuilder extends DateTimeFormatBuilder.WithUtcOffset {
    void addFormatStructureForOffset(FormatStructure<? super UtcOffsetFieldContainer> formatStructure);

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithUtcOffset
    void offset(DateTimeFormat<UtcOffset> dateTimeFormat);

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithUtcOffset
    void offsetHours(Padding padding);

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithUtcOffset
    void offsetMinutesOfHour(Padding padding);

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithUtcOffset
    void offsetSecondsOfMinute(Padding padding);

    /* compiled from: UtcOffsetFormat.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class DefaultImpls {
        public static void offsetHours(AbstractWithOffsetBuilder $this, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            $this.addFormatStructureForOffset(new SignedFormatStructure(new BasicFormatStructure(new UtcOffsetWholeHoursDirective(padding)), true));
        }

        public static void offsetMinutesOfHour(AbstractWithOffsetBuilder $this, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            $this.addFormatStructureForOffset(new BasicFormatStructure(new UtcOffsetMinuteOfHourDirective(padding)));
        }

        public static void offsetSecondsOfMinute(AbstractWithOffsetBuilder $this, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            $this.addFormatStructureForOffset(new BasicFormatStructure(new UtcOffsetSecondOfMinuteDirective(padding)));
        }

        public static void offset(AbstractWithOffsetBuilder $this, DateTimeFormat<UtcOffset> format) {
            Intrinsics.checkNotNullParameter(format, "format");
            if (format instanceof UtcOffsetFormat) {
                $this.addFormatStructureForOffset(((UtcOffsetFormat) format).getActualFormat());
            }
        }
    }
}