package kotlinx.datetime;

import j$.time.DateTimeException;
import j$.time.DayOfWeek;
import j$.time.Month;
import j$.time.format.DateTimeParseException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.DateTimeFormat;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.format.LocalDateTimeFormat;
import kotlinx.datetime.format.LocalDateTimeFormatKt;
import kotlinx.datetime.serializers.LocalDateTimeIso8601Serializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: LocalDateTime.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 ;2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002;<B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005BE\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\u000eBI\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\u0012B\u0019\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0004\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0096\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u0018\u0010\"\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\"\u0010#R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010&R\u0011\u0010\u0007\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b'\u0010\u001eR\u0011\u0010\b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b(\u0010\u001eR\u0015\u0010\u0011\u001a\u00060\u000fj\u0002`\u00108F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b+\u0010\u001eR\u0015\u00100\u001a\u00060,j\u0002`-8F¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0011\u00102\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b1\u0010\u001eR\u0011\u0010\n\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b3\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b4\u0010\u001eR\u0011\u0010\f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b5\u0010\u001eR\u0011\u0010\r\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b6\u0010\u001eR\u0011\u0010\u0014\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b7\u00108R\u0011\u0010\u0016\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006="}, d2 = {"Lkotlinx/datetime/LocalDateTime;", "", "j$/time/LocalDateTime", "value", "<init>", "(Lj$/time/LocalDateTime;)V", "", "year", "monthNumber", "dayOfMonth", "hour", "minute", "second", "nanosecond", "(IIIIIII)V", "j$/time/Month", "Lkotlinx/datetime/Month;", "month", "(ILj$/time/Month;IIIII)V", "Lkotlinx/datetime/LocalDate;", "date", "Lkotlinx/datetime/LocalTime;", "time", "(Lkotlinx/datetime/LocalDate;Lkotlinx/datetime/LocalTime;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "compareTo", "(Lkotlinx/datetime/LocalDateTime;)I", "Lj$/time/LocalDateTime;", "getValue$kotlinx_datetime", "()Lj$/time/LocalDateTime;", "getYear", "getMonthNumber", "getMonth", "()Lj$/time/Month;", "getDayOfMonth", "j$/time/DayOfWeek", "Lkotlinx/datetime/DayOfWeek;", "getDayOfWeek", "()Lj$/time/DayOfWeek;", "dayOfWeek", "getDayOfYear", "dayOfYear", "getHour", "getMinute", "getSecond", "getNanosecond", "getDate", "()Lkotlinx/datetime/LocalDate;", "getTime", "()Lkotlinx/datetime/LocalTime;", "Companion", "Formats", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable(with = LocalDateTimeIso8601Serializer.class)
public final class LocalDateTime implements Comparable<LocalDateTime> {
    public static final Companion Companion = new Companion(null);
    private static final LocalDateTime MAX;
    private static final LocalDateTime MIN;
    private final j$.time.LocalDateTime value;

    public LocalDateTime(j$.time.LocalDateTime value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    public final j$.time.LocalDateTime getValue$kotlinx_datetime() {
        return this.value;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ LocalDateTime(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4, i5, r8, r9);
        int i9;
        int i10;
        if ((i8 & 32) == 0) {
            i9 = i6;
        } else {
            i9 = 0;
        }
        if ((i8 & 64) == 0) {
            i10 = i7;
        } else {
            i10 = 0;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LocalDateTime(int year, int monthNumber, int dayOfMonth, int hour, int minute, int second, int nanosecond) {
        this(r0);
        try {
            j$.time.LocalDateTime of = j$.time.LocalDateTime.of(year, monthNumber, dayOfMonth, hour, minute, second, nanosecond);
            Intrinsics.checkNotNull(of);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ LocalDateTime(int i, Month month, int i2, int i3, int i4, int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, month, i2, i3, i4, r8, r9);
        int i8;
        int i9;
        if ((i7 & 32) == 0) {
            i8 = i5;
        } else {
            i8 = 0;
        }
        if ((i7 & 64) == 0) {
            i9 = i6;
        } else {
            i9 = 0;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalDateTime(int year, Month month, int dayOfMonth, int hour, int minute, int second, int nanosecond) {
        this(year, MonthKt.getNumber(month), dayOfMonth, hour, minute, second, nanosecond);
        Intrinsics.checkNotNullParameter(month, "month");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LocalDateTime(LocalDate date, LocalTime time) {
        this(r0);
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(time, "time");
        j$.time.LocalDateTime of = j$.time.LocalDateTime.of(date.getValue$kotlinx_datetime(), time.getValue$kotlinx_datetime());
        Intrinsics.checkNotNullExpressionValue(of, "of(...)");
    }

    public final int getYear() {
        return this.value.getYear();
    }

    public final int getMonthNumber() {
        return this.value.getMonthValue();
    }

    public final Month getMonth() {
        Month month = this.value.getMonth();
        Intrinsics.checkNotNullExpressionValue(month, "getMonth(...)");
        return month;
    }

    public final int getDayOfMonth() {
        return this.value.getDayOfMonth();
    }

    public final DayOfWeek getDayOfWeek() {
        DayOfWeek dayOfWeek = this.value.getDayOfWeek();
        Intrinsics.checkNotNullExpressionValue(dayOfWeek, "getDayOfWeek(...)");
        return dayOfWeek;
    }

    public final int getDayOfYear() {
        return this.value.getDayOfYear();
    }

    public final int getHour() {
        return this.value.getHour();
    }

    public final int getMinute() {
        return this.value.getMinute();
    }

    public final int getSecond() {
        return this.value.getSecond();
    }

    public final int getNanosecond() {
        return this.value.getNano();
    }

    public final LocalDate getDate() {
        j$.time.LocalDate localDate = this.value.toLocalDate();
        Intrinsics.checkNotNullExpressionValue(localDate, "toLocalDate(...)");
        return new LocalDate(localDate);
    }

    public final LocalTime getTime() {
        j$.time.LocalTime localTime = this.value.toLocalTime();
        Intrinsics.checkNotNullExpressionValue(localTime, "toLocalTime(...)");
        return new LocalTime(localTime);
    }

    public boolean equals(Object other) {
        return this == other || ((other instanceof LocalDateTime) && Intrinsics.areEqual(this.value, ((LocalDateTime) other).value));
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        String localDateTime = this.value.toString();
        Intrinsics.checkNotNullExpressionValue(localDateTime, "toString(...)");
        return localDateTime;
    }

    @Override // java.lang.Comparable
    public int compareTo(LocalDateTime other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.value.compareTo(other.value);
    }

    /* compiled from: LocalDateTime.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fJ\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\nJ\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017HÆ\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0018"}, d2 = {"Lkotlinx/datetime/LocalDateTime$Companion;", "", "()V", "MAX", "Lkotlinx/datetime/LocalDateTime;", "getMAX$kotlinx_datetime", "()Lkotlinx/datetime/LocalDateTime;", "MIN", "getMIN$kotlinx_datetime", "Format", "Lkotlinx/datetime/format/DateTimeFormat;", "builder", "Lkotlin/Function1;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTime;", "", "Lkotlin/ExtensionFunctionType;", "parse", "input", "", "format", "isoString", "", "serializer", "Lkotlinx/serialization/KSerializer;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LocalDateTime> serializer() {
            return LocalDateTimeIso8601Serializer.INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LocalDateTime parse$default(Companion companion, CharSequence charSequence, DateTimeFormat dateTimeFormat, int i, Object obj) {
            if ((i & 2) != 0) {
                dateTimeFormat = LocalDateTimeKt.getIsoDateTimeFormat();
            }
            return companion.parse(charSequence, dateTimeFormat);
        }

        public final LocalDateTime parse(CharSequence input, DateTimeFormat<LocalDateTime> format) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(format, "format");
            if (format == Formats.INSTANCE.getISO()) {
                try {
                    j$.time.LocalDateTime p0 = j$.time.LocalDateTime.parse(input);
                    return new LocalDateTime(p0);
                } catch (DateTimeParseException e) {
                    throw new DateTimeFormatException(e);
                }
            }
            return format.parse(input);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This overload is only kept for binary compatibility")
        public final /* synthetic */ LocalDateTime parse(String isoString) {
            Intrinsics.checkNotNullParameter(isoString, "isoString");
            return parse$default(this, isoString, null, 2, null);
        }

        public final LocalDateTime getMIN$kotlinx_datetime() {
            return LocalDateTime.MIN;
        }

        public final LocalDateTime getMAX$kotlinx_datetime() {
            return LocalDateTime.MAX;
        }

        public final DateTimeFormat<LocalDateTime> Format(Function1<? super DateTimeFormatBuilder.WithDateTime, Unit> builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            return LocalDateTimeFormat.Companion.build(builder);
        }
    }

    static {
        j$.time.LocalDateTime MIN2 = j$.time.LocalDateTime.MIN;
        Intrinsics.checkNotNullExpressionValue(MIN2, "MIN");
        MIN = new LocalDateTime(MIN2);
        j$.time.LocalDateTime MAX2 = j$.time.LocalDateTime.MAX;
        Intrinsics.checkNotNullExpressionValue(MAX2, "MAX");
        MAX = new LocalDateTime(MAX2);
    }

    /* compiled from: LocalDateTime.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/datetime/LocalDateTime$Formats;", "", "()V", "ISO", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalDateTime;", "getISO", "()Lkotlinx/datetime/format/DateTimeFormat;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Formats {
        public static final Formats INSTANCE = new Formats();
        private static final DateTimeFormat<LocalDateTime> ISO = LocalDateTimeFormatKt.getISO_DATETIME();

        private Formats() {
        }

        public final DateTimeFormat<LocalDateTime> getISO() {
            return ISO;
        }
    }
}