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
import kotlinx.datetime.format.LocalDateFormat;
import kotlinx.datetime.format.LocalDateFormatKt;
import kotlinx.datetime.internal.MathKt;
import kotlinx.datetime.serializers.LocalDateIso8601Serializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: LocalDate.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002+,B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B!\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\nB%\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\u0010\r\u001a\u00060\u000bj\u0002`\f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b \u0010\u0015R\u0015\u0010\r\u001a\u00060\u000bj\u0002`\f8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b#\u0010\u0015R\u0015\u0010(\u001a\u00060$j\u0002`%8F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0011\u0010*\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b)\u0010\u0015¨\u0006-"}, d2 = {"Lkotlinx/datetime/LocalDate;", "", "j$/time/LocalDate", "value", "<init>", "(Lj$/time/LocalDate;)V", "", "year", "monthNumber", "dayOfMonth", "(III)V", "j$/time/Month", "Lkotlinx/datetime/Month;", "month", "(ILj$/time/Month;I)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "compareTo", "(Lkotlinx/datetime/LocalDate;)I", "toEpochDays", "Lj$/time/LocalDate;", "getValue$kotlinx_datetime", "()Lj$/time/LocalDate;", "getYear", "getMonthNumber", "getMonth", "()Lj$/time/Month;", "getDayOfMonth", "j$/time/DayOfWeek", "Lkotlinx/datetime/DayOfWeek;", "getDayOfWeek", "()Lj$/time/DayOfWeek;", "dayOfWeek", "getDayOfYear", "dayOfYear", "Companion", "Formats", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable(with = LocalDateIso8601Serializer.class)
public final class LocalDate implements Comparable<LocalDate> {
    public static final Companion Companion = new Companion(null);
    private static final LocalDate MAX;
    private static final LocalDate MIN;
    private final j$.time.LocalDate value;

    public LocalDate(j$.time.LocalDate value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    /* compiled from: LocalDate.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012J\u001e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\nJ\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u001aHÆ\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u001b"}, d2 = {"Lkotlinx/datetime/LocalDate$Companion;", "", "()V", "MAX", "Lkotlinx/datetime/LocalDate;", "getMAX$kotlinx_datetime", "()Lkotlinx/datetime/LocalDate;", "MIN", "getMIN$kotlinx_datetime", "Format", "Lkotlinx/datetime/format/DateTimeFormat;", "block", "Lkotlin/Function1;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "", "Lkotlin/ExtensionFunctionType;", "fromEpochDays", "epochDays", "", "parse", "input", "", "format", "isoString", "", "serializer", "Lkotlinx/serialization/KSerializer;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LocalDate> serializer() {
            return LocalDateIso8601Serializer.INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LocalDate parse$default(Companion companion, CharSequence charSequence, DateTimeFormat dateTimeFormat, int i, Object obj) {
            if ((i & 2) != 0) {
                dateTimeFormat = LocalDateKt.getIsoDateFormat();
            }
            return companion.parse(charSequence, dateTimeFormat);
        }

        public final LocalDate parse(CharSequence input, DateTimeFormat<LocalDate> format) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(format, "format");
            if (format == Formats.INSTANCE.getISO()) {
                try {
                    j$.time.LocalDate p0 = j$.time.LocalDate.parse(input);
                    return new LocalDate(p0);
                } catch (DateTimeParseException e) {
                    throw new DateTimeFormatException(e);
                }
            }
            return format.parse(input);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This overload is only kept for binary compatibility")
        public final /* synthetic */ LocalDate parse(String isoString) {
            Intrinsics.checkNotNullParameter(isoString, "isoString");
            return parse$default(this, isoString, null, 2, null);
        }

        public final LocalDate getMIN$kotlinx_datetime() {
            return LocalDate.MIN;
        }

        public final LocalDate getMAX$kotlinx_datetime() {
            return LocalDate.MAX;
        }

        public final LocalDate fromEpochDays(int epochDays) {
            j$.time.LocalDate ofEpochDay = j$.time.LocalDate.ofEpochDay(epochDays);
            Intrinsics.checkNotNullExpressionValue(ofEpochDay, "ofEpochDay(...)");
            return new LocalDate(ofEpochDay);
        }

        public final DateTimeFormat<LocalDate> Format(Function1<? super DateTimeFormatBuilder.WithDate, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            return LocalDateFormat.Companion.build(block);
        }
    }

    public final j$.time.LocalDate getValue$kotlinx_datetime() {
        return this.value;
    }

    static {
        j$.time.LocalDate MIN2 = j$.time.LocalDate.MIN;
        Intrinsics.checkNotNullExpressionValue(MIN2, "MIN");
        MIN = new LocalDate(MIN2);
        j$.time.LocalDate MAX2 = j$.time.LocalDate.MAX;
        Intrinsics.checkNotNullExpressionValue(MAX2, "MAX");
        MAX = new LocalDate(MAX2);
    }

    /* compiled from: LocalDate.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlinx/datetime/LocalDate$Formats;", "", "()V", "ISO", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalDate;", "getISO", "()Lkotlinx/datetime/format/DateTimeFormat;", "ISO_BASIC", "getISO_BASIC", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Formats {
        public static final Formats INSTANCE = new Formats();
        private static final DateTimeFormat<LocalDate> ISO_BASIC = LocalDateFormatKt.getISO_DATE_BASIC();

        private Formats() {
        }

        public final DateTimeFormat<LocalDate> getISO() {
            return LocalDateFormatKt.getISO_DATE();
        }

        public final DateTimeFormat<LocalDate> getISO_BASIC() {
            return ISO_BASIC;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LocalDate(int year, int monthNumber, int dayOfMonth) {
        this(r0);
        try {
            j$.time.LocalDate of = j$.time.LocalDate.of(year, monthNumber, dayOfMonth);
            Intrinsics.checkNotNull(of);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalDate(int year, Month month, int dayOfMonth) {
        this(year, MonthKt.getNumber(month), dayOfMonth);
        Intrinsics.checkNotNullParameter(month, "month");
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

    public boolean equals(Object other) {
        return this == other || ((other instanceof LocalDate) && Intrinsics.areEqual(this.value, ((LocalDate) other).value));
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        String localDate = this.value.toString();
        Intrinsics.checkNotNullExpressionValue(localDate, "toString(...)");
        return localDate;
    }

    @Override // java.lang.Comparable
    public int compareTo(LocalDate other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.value.compareTo(other.value);
    }

    public final int toEpochDays() {
        return MathKt.clampToInt(this.value.toEpochDay());
    }
}