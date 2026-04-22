package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.LocalTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.UtcOffset;
import kotlinx.datetime.format.AbstractDateTimeFormatBuilder;
import kotlinx.datetime.format.AbstractWithDateTimeBuilder;
import kotlinx.datetime.format.AbstractWithOffsetBuilder;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.internal.format.AppendableFormatStructure;
import kotlinx.datetime.internal.format.BasicFormatStructure;
import kotlinx.datetime.internal.format.CachedFormatStructure;
import kotlinx.datetime.internal.format.FormatStructure;

/* compiled from: DateTimeComponents.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lkotlinx/datetime/format/DateTimeComponentsFormat;", "Lkotlinx/datetime/format/AbstractDateTimeFormat;", "Lkotlinx/datetime/format/DateTimeComponents;", "Lkotlinx/datetime/format/DateTimeComponentsContents;", "actualFormat", "Lkotlinx/datetime/internal/format/CachedFormatStructure;", "(Lkotlinx/datetime/internal/format/CachedFormatStructure;)V", "getActualFormat", "()Lkotlinx/datetime/internal/format/CachedFormatStructure;", "emptyIntermediate", "getEmptyIntermediate", "()Lkotlinx/datetime/format/DateTimeComponentsContents;", "intermediateFromValue", "value", "valueFromIntermediate", "intermediate", "Builder", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DateTimeComponentsFormat extends AbstractDateTimeFormat<DateTimeComponents, DateTimeComponentsContents> {
    private final CachedFormatStructure<DateTimeComponentsContents> actualFormat;

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public CachedFormatStructure<DateTimeComponentsContents> getActualFormat() {
        return this.actualFormat;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DateTimeComponentsFormat(CachedFormatStructure<? super DateTimeComponentsContents> actualFormat) {
        super(null);
        Intrinsics.checkNotNullParameter(actualFormat, "actualFormat");
        this.actualFormat = actualFormat;
    }

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public DateTimeComponentsContents intermediateFromValue(DateTimeComponents value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return value.getContents$kotlinx_datetime();
    }

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public DateTimeComponents valueFromIntermediate(DateTimeComponentsContents intermediate) {
        Intrinsics.checkNotNullParameter(intermediate, "intermediate");
        return new DateTimeComponents(intermediate);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public DateTimeComponentsContents getEmptyIntermediate() {
        DateTimeComponentsContents dateTimeComponentsContents;
        dateTimeComponentsContents = DateTimeComponentsKt.emptyDateTimeComponentsContents;
        return dateTimeComponentsContents;
    }

    /* compiled from: DateTimeComponents.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00032\u00020\u00042\u00020\u0005B\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0016\u0010\u0010\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0000H\u0016J\u0016\u0010\u0013\u001a\u00020\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lkotlinx/datetime/format/DateTimeComponentsFormat$Builder;", "Lkotlinx/datetime/format/AbstractDateTimeFormatBuilder;", "Lkotlinx/datetime/format/DateTimeComponentsContents;", "Lkotlinx/datetime/format/AbstractWithDateTimeBuilder;", "Lkotlinx/datetime/format/AbstractWithOffsetBuilder;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTimeComponents;", "actualBuilder", "Lkotlinx/datetime/internal/format/AppendableFormatStructure;", "(Lkotlinx/datetime/internal/format/AppendableFormatStructure;)V", "getActualBuilder", "()Lkotlinx/datetime/internal/format/AppendableFormatStructure;", "addFormatStructureForDateTime", "", "structure", "Lkotlinx/datetime/internal/format/FormatStructure;", "Lkotlinx/datetime/format/DateTimeFieldContainer;", "addFormatStructureForOffset", "Lkotlinx/datetime/format/UtcOffsetFieldContainer;", "createEmpty", "dateTimeComponents", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/format/DateTimeComponents;", "timeZoneId", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Builder implements AbstractDateTimeFormatBuilder<DateTimeComponentsContents, Builder>, AbstractWithDateTimeBuilder, AbstractWithOffsetBuilder, DateTimeFormatBuilder.WithDateTimeComponents {
        private final AppendableFormatStructure<DateTimeComponentsContents> actualBuilder;

        public Builder(AppendableFormatStructure<DateTimeComponentsContents> actualBuilder) {
            Intrinsics.checkNotNullParameter(actualBuilder, "actualBuilder");
            this.actualBuilder = actualBuilder;
        }

        @Override // kotlinx.datetime.format.AbstractWithDateTimeBuilder, kotlinx.datetime.format.AbstractWithDateBuilder
        public void addFormatStructureForDate(FormatStructure<? super DateFieldContainer> formatStructure) {
            AbstractWithDateTimeBuilder.DefaultImpls.addFormatStructureForDate(this, formatStructure);
        }

        @Override // kotlinx.datetime.format.AbstractWithDateTimeBuilder, kotlinx.datetime.format.AbstractWithTimeBuilder
        public void addFormatStructureForTime(FormatStructure<? super TimeFieldContainer> formatStructure) {
            AbstractWithDateTimeBuilder.DefaultImpls.addFormatStructureForTime(this, formatStructure);
        }

        @Override // kotlinx.datetime.format.AbstractWithTimeBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
        public void amPmHour(Padding padding) {
            AbstractWithDateTimeBuilder.DefaultImpls.amPmHour(this, padding);
        }

        @Override // kotlinx.datetime.format.AbstractWithTimeBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
        public void amPmMarker(String am, String pm) {
            AbstractWithDateTimeBuilder.DefaultImpls.amPmMarker(this, am, pm);
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public void appendAlternativeParsingImpl(Function1<? super Builder, Unit>[] function1Arr, Function1<? super Builder, Unit> function1) {
            AbstractDateTimeFormatBuilder.DefaultImpls.appendAlternativeParsingImpl(this, function1Arr, function1);
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public void appendOptionalImpl(String onZero, Function1<? super Builder, Unit> function1) {
            AbstractDateTimeFormatBuilder.DefaultImpls.appendOptionalImpl(this, onZero, function1);
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public CachedFormatStructure<DateTimeComponentsContents> build() {
            return AbstractDateTimeFormatBuilder.DefaultImpls.build(this);
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder, kotlinx.datetime.format.DateTimeFormatBuilder
        public void chars(String value) {
            AbstractDateTimeFormatBuilder.DefaultImpls.chars(this, value);
        }

        @Override // kotlinx.datetime.format.AbstractWithDateBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
        public void date(DateTimeFormat<LocalDate> dateTimeFormat) {
            AbstractWithDateTimeBuilder.DefaultImpls.date(this, dateTimeFormat);
        }

        @Override // kotlinx.datetime.format.AbstractWithDateTimeBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithDateTime
        public void dateTime(DateTimeFormat<LocalDateTime> dateTimeFormat) {
            AbstractWithDateTimeBuilder.DefaultImpls.dateTime(this, dateTimeFormat);
        }

        @Override // kotlinx.datetime.format.AbstractWithDateBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
        public void dayOfMonth(Padding padding) {
            AbstractWithDateTimeBuilder.DefaultImpls.dayOfMonth(this, padding);
        }

        @Override // kotlinx.datetime.format.AbstractWithDateBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
        public void dayOfWeek(DayOfWeekNames names) {
            AbstractWithDateTimeBuilder.DefaultImpls.dayOfWeek(this, names);
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public AppendableFormatStructure<DateTimeComponentsContents> getActualBuilder() {
            return this.actualBuilder;
        }

        @Override // kotlinx.datetime.format.AbstractWithTimeBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
        public void hour(Padding padding) {
            AbstractWithDateTimeBuilder.DefaultImpls.hour(this, padding);
        }

        @Override // kotlinx.datetime.format.AbstractWithTimeBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
        public void minute(Padding padding) {
            AbstractWithDateTimeBuilder.DefaultImpls.minute(this, padding);
        }

        @Override // kotlinx.datetime.format.AbstractWithDateBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
        public void monthName(MonthNames names) {
            AbstractWithDateTimeBuilder.DefaultImpls.monthName(this, names);
        }

        @Override // kotlinx.datetime.format.AbstractWithDateBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
        public void monthNumber(Padding padding) {
            AbstractWithDateTimeBuilder.DefaultImpls.monthNumber(this, padding);
        }

        @Override // kotlinx.datetime.format.AbstractWithOffsetBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithUtcOffset
        public void offset(DateTimeFormat<UtcOffset> dateTimeFormat) {
            AbstractWithOffsetBuilder.DefaultImpls.offset(this, dateTimeFormat);
        }

        @Override // kotlinx.datetime.format.AbstractWithOffsetBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithUtcOffset
        public void offsetHours(Padding padding) {
            AbstractWithOffsetBuilder.DefaultImpls.offsetHours(this, padding);
        }

        @Override // kotlinx.datetime.format.AbstractWithOffsetBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithUtcOffset
        public void offsetMinutesOfHour(Padding padding) {
            AbstractWithOffsetBuilder.DefaultImpls.offsetMinutesOfHour(this, padding);
        }

        @Override // kotlinx.datetime.format.AbstractWithOffsetBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithUtcOffset
        public void offsetSecondsOfMinute(Padding padding) {
            AbstractWithOffsetBuilder.DefaultImpls.offsetSecondsOfMinute(this, padding);
        }

        @Override // kotlinx.datetime.format.AbstractWithTimeBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
        public void second(Padding padding) {
            AbstractWithDateTimeBuilder.DefaultImpls.second(this, padding);
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
        public void secondFraction(int fixedLength) {
            AbstractWithDateTimeBuilder.DefaultImpls.secondFraction(this, fixedLength);
        }

        @Override // kotlinx.datetime.format.AbstractWithTimeBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
        public void secondFraction(int minLength, int maxLength) {
            AbstractWithDateTimeBuilder.DefaultImpls.secondFraction(this, minLength, maxLength);
        }

        @Override // kotlinx.datetime.format.AbstractWithTimeBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
        public void time(DateTimeFormat<LocalTime> dateTimeFormat) {
            AbstractWithDateTimeBuilder.DefaultImpls.time(this, dateTimeFormat);
        }

        @Override // kotlinx.datetime.format.AbstractWithDateBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
        public void year(Padding padding) {
            AbstractWithDateTimeBuilder.DefaultImpls.year(this, padding);
        }

        @Override // kotlinx.datetime.format.AbstractWithDateBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
        public void yearTwoDigits(int baseYear) {
            AbstractWithDateTimeBuilder.DefaultImpls.yearTwoDigits(this, baseYear);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.datetime.format.AbstractWithDateTimeBuilder
        public void addFormatStructureForDateTime(FormatStructure<? super DateTimeFieldContainer> structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            getActualBuilder().add(structure);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.datetime.format.AbstractWithOffsetBuilder
        public void addFormatStructureForOffset(FormatStructure<? super UtcOffsetFieldContainer> structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            getActualBuilder().add(structure);
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDateTimeComponents
        public void timeZoneId() {
            getActualBuilder().add(new BasicFormatStructure(new TimeZoneIdDirective(TimeZone.Companion.getAvailableZoneIds())));
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDateTimeComponents
        public void dateTimeComponents(DateTimeFormat<DateTimeComponents> format) {
            Intrinsics.checkNotNullParameter(format, "format");
            if (format instanceof DateTimeComponentsFormat) {
                getActualBuilder().add(((DateTimeComponentsFormat) format).getActualFormat());
            }
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public Builder createEmpty() {
            return new Builder(new AppendableFormatStructure());
        }
    }
}