package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.LocalTime;
import kotlinx.datetime.format.AbstractDateTimeFormatBuilder;
import kotlinx.datetime.format.AbstractWithDateTimeBuilder;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.internal.format.AppendableFormatStructure;
import kotlinx.datetime.internal.format.CachedFormatStructure;
import kotlinx.datetime.internal.format.FormatStructure;

/* compiled from: LocalDateTimeFormat.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0003H\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lkotlinx/datetime/format/LocalDateTimeFormat;", "Lkotlinx/datetime/format/AbstractDateTimeFormat;", "Lkotlinx/datetime/LocalDateTime;", "Lkotlinx/datetime/format/IncompleteLocalDateTime;", "actualFormat", "Lkotlinx/datetime/internal/format/CachedFormatStructure;", "Lkotlinx/datetime/format/DateTimeFieldContainer;", "(Lkotlinx/datetime/internal/format/CachedFormatStructure;)V", "getActualFormat", "()Lkotlinx/datetime/internal/format/CachedFormatStructure;", "emptyIntermediate", "getEmptyIntermediate", "()Lkotlinx/datetime/format/IncompleteLocalDateTime;", "intermediateFromValue", "value", "valueFromIntermediate", "intermediate", "Builder", "Companion", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LocalDateTimeFormat extends AbstractDateTimeFormat<LocalDateTime, IncompleteLocalDateTime> {
    public static final Companion Companion = new Companion(null);
    private final CachedFormatStructure<DateTimeFieldContainer> actualFormat;

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public CachedFormatStructure<IncompleteLocalDateTime> getActualFormat() {
        return this.actualFormat;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LocalDateTimeFormat(CachedFormatStructure<? super DateTimeFieldContainer> actualFormat) {
        super(null);
        Intrinsics.checkNotNullParameter(actualFormat, "actualFormat");
        this.actualFormat = actualFormat;
    }

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public IncompleteLocalDateTime intermediateFromValue(LocalDateTime value) {
        Intrinsics.checkNotNullParameter(value, "value");
        IncompleteLocalDateTime $this$intermediateFromValue_u24lambda_u240 = new IncompleteLocalDateTime(null, null, 3, null);
        $this$intermediateFromValue_u24lambda_u240.populateFrom(value);
        return $this$intermediateFromValue_u24lambda_u240;
    }

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public LocalDateTime valueFromIntermediate(IncompleteLocalDateTime intermediate) {
        Intrinsics.checkNotNullParameter(intermediate, "intermediate");
        return intermediate.toLocalDateTime();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public IncompleteLocalDateTime getEmptyIntermediate() {
        return LocalDateTimeFormatKt.access$getEmptyIncompleteLocalDateTime$p();
    }

    /* compiled from: LocalDateTimeFormat.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"Lkotlinx/datetime/format/LocalDateTimeFormat$Companion;", "", "()V", "build", "Lkotlinx/datetime/format/LocalDateTimeFormat;", "block", "Lkotlin/Function1;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTime;", "", "Lkotlin/ExtensionFunctionType;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LocalDateTimeFormat build(Function1<? super DateTimeFormatBuilder.WithDateTime, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder(new AppendableFormatStructure());
            block.invoke(builder);
            return new LocalDateTimeFormat(builder.build());
        }
    }

    /* compiled from: LocalDateTimeFormat.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0000H\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lkotlinx/datetime/format/LocalDateTimeFormat$Builder;", "Lkotlinx/datetime/format/AbstractDateTimeFormatBuilder;", "Lkotlinx/datetime/format/DateTimeFieldContainer;", "Lkotlinx/datetime/format/AbstractWithDateTimeBuilder;", "actualBuilder", "Lkotlinx/datetime/internal/format/AppendableFormatStructure;", "(Lkotlinx/datetime/internal/format/AppendableFormatStructure;)V", "getActualBuilder", "()Lkotlinx/datetime/internal/format/AppendableFormatStructure;", "addFormatStructureForDateTime", "", "structure", "Lkotlinx/datetime/internal/format/FormatStructure;", "createEmpty", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Builder implements AbstractDateTimeFormatBuilder<DateTimeFieldContainer, Builder>, AbstractWithDateTimeBuilder {
        private final AppendableFormatStructure<DateTimeFieldContainer> actualBuilder;

        public Builder(AppendableFormatStructure<DateTimeFieldContainer> actualBuilder) {
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
        public CachedFormatStructure<DateTimeFieldContainer> build() {
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
        public AppendableFormatStructure<DateTimeFieldContainer> getActualBuilder() {
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

        @Override // kotlinx.datetime.format.AbstractWithDateTimeBuilder
        public void addFormatStructureForDateTime(FormatStructure<? super DateTimeFieldContainer> structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            getActualBuilder().add(structure);
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public Builder createEmpty() {
            return new Builder(new AppendableFormatStructure());
        }
    }
}