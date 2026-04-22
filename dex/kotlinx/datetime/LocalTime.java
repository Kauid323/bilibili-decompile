package kotlinx.datetime;

import j$.time.DateTimeException;
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
import kotlinx.datetime.format.LocalTimeFormat;
import kotlinx.datetime.format.LocalTimeFormatKt;
import kotlinx.datetime.serializers.LocalTimeIso8601Serializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: LocalTime.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002$%B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B-\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\u000bJ\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\rJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\rJ\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b \u0010\rR\u0011\u0010\b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b!\u0010\rR\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\"\u0010\rR\u0011\u0010\n\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b#\u0010\r¨\u0006&"}, d2 = {"Lkotlinx/datetime/LocalTime;", "", "j$/time/LocalTime", "value", "<init>", "(Lj$/time/LocalTime;)V", "", "hour", "minute", "second", "nanosecond", "(IIII)V", "toSecondOfDay", "()I", "toMillisecondOfDay", "", "toNanosecondOfDay", "()J", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "compareTo", "(Lkotlinx/datetime/LocalTime;)I", "Lj$/time/LocalTime;", "getValue$kotlinx_datetime", "()Lj$/time/LocalTime;", "getHour", "getMinute", "getSecond", "getNanosecond", "Companion", "Formats", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable(with = LocalTimeIso8601Serializer.class)
public final class LocalTime implements Comparable<LocalTime> {
    public static final Companion Companion = new Companion(null);
    private static final LocalTime MAX;
    private static final LocalTime MIN;
    private final j$.time.LocalTime value;

    public LocalTime(j$.time.LocalTime value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    public final j$.time.LocalTime getValue$kotlinx_datetime() {
        return this.value;
    }

    public /* synthetic */ LocalTime(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LocalTime(int hour, int minute, int second, int nanosecond) {
        this(r0);
        try {
            j$.time.LocalTime of = j$.time.LocalTime.of(hour, minute, second, nanosecond);
            Intrinsics.checkNotNull(of);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(e);
        }
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

    public final int toSecondOfDay() {
        return this.value.toSecondOfDay();
    }

    public final int toMillisecondOfDay() {
        return (int) (this.value.toNanoOfDay() / 1000000);
    }

    public final long toNanosecondOfDay() {
        return this.value.toNanoOfDay();
    }

    public boolean equals(Object other) {
        return this == other || ((other instanceof LocalTime) && Intrinsics.areEqual(this.value, ((LocalTime) other).value));
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        String localTime = this.value.toString();
        Intrinsics.checkNotNullExpressionValue(localTime, "toString(...)");
        return localTime;
    }

    @Override // java.lang.Comparable
    public int compareTo(LocalTime other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.value.compareTo(other.value);
    }

    /* compiled from: LocalTime.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0012J\u001e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\nJ\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001fHÆ\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006 "}, d2 = {"Lkotlinx/datetime/LocalTime$Companion;", "", "()V", "MAX", "Lkotlinx/datetime/LocalTime;", "getMAX$kotlinx_datetime", "()Lkotlinx/datetime/LocalTime;", "MIN", "getMIN$kotlinx_datetime", "Format", "Lkotlinx/datetime/format/DateTimeFormat;", "builder", "Lkotlin/Function1;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithTime;", "", "Lkotlin/ExtensionFunctionType;", "fromMillisecondOfDay", "millisecondOfDay", "", "fromNanosecondOfDay", "nanosecondOfDay", "", "fromSecondOfDay", "secondOfDay", "parse", "input", "", "format", "isoString", "", "serializer", "Lkotlinx/serialization/KSerializer;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LocalTime> serializer() {
            return LocalTimeIso8601Serializer.INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LocalTime parse$default(Companion companion, CharSequence charSequence, DateTimeFormat dateTimeFormat, int i, Object obj) {
            if ((i & 2) != 0) {
                dateTimeFormat = LocalTimeKt.getIsoTimeFormat();
            }
            return companion.parse(charSequence, dateTimeFormat);
        }

        public final LocalTime parse(CharSequence input, DateTimeFormat<LocalTime> format) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(format, "format");
            if (format == Formats.INSTANCE.getISO()) {
                try {
                    j$.time.LocalTime p0 = j$.time.LocalTime.parse(input);
                    return new LocalTime(p0);
                } catch (DateTimeParseException e) {
                    throw new DateTimeFormatException(e);
                }
            }
            return format.parse(input);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This overload is only kept for binary compatibility")
        public final /* synthetic */ LocalTime parse(String isoString) {
            Intrinsics.checkNotNullParameter(isoString, "isoString");
            return parse$default(this, isoString, null, 2, null);
        }

        public final LocalTime fromSecondOfDay(int secondOfDay) {
            try {
                j$.time.LocalTime p0 = j$.time.LocalTime.ofSecondOfDay(secondOfDay);
                return new LocalTime(p0);
            } catch (DateTimeException e) {
                throw new IllegalArgumentException(e);
            }
        }

        public final LocalTime fromMillisecondOfDay(int millisecondOfDay) {
            try {
                j$.time.LocalTime p0 = j$.time.LocalTime.ofNanoOfDay(millisecondOfDay * 1000000);
                return new LocalTime(p0);
            } catch (Throwable e) {
                throw new IllegalArgumentException(e);
            }
        }

        public final LocalTime fromNanosecondOfDay(long nanosecondOfDay) {
            try {
                j$.time.LocalTime p0 = j$.time.LocalTime.ofNanoOfDay(nanosecondOfDay);
                return new LocalTime(p0);
            } catch (DateTimeException e) {
                throw new IllegalArgumentException(e);
            }
        }

        public final LocalTime getMIN$kotlinx_datetime() {
            return LocalTime.MIN;
        }

        public final LocalTime getMAX$kotlinx_datetime() {
            return LocalTime.MAX;
        }

        public final DateTimeFormat<LocalTime> Format(Function1<? super DateTimeFormatBuilder.WithTime, Unit> builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            return LocalTimeFormat.Companion.build(builder);
        }
    }

    static {
        j$.time.LocalTime MIN2 = j$.time.LocalTime.MIN;
        Intrinsics.checkNotNullExpressionValue(MIN2, "MIN");
        MIN = new LocalTime(MIN2);
        j$.time.LocalTime MAX2 = j$.time.LocalTime.MAX;
        Intrinsics.checkNotNullExpressionValue(MAX2, "MAX");
        MAX = new LocalTime(MAX2);
    }

    /* compiled from: LocalTime.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/datetime/LocalTime$Formats;", "", "()V", "ISO", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalTime;", "getISO", "()Lkotlinx/datetime/format/DateTimeFormat;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Formats {
        public static final Formats INSTANCE = new Formats();

        private Formats() {
        }

        public final DateTimeFormat<LocalTime> getISO() {
            return LocalTimeFormatKt.getISO_TIME();
        }
    }
}