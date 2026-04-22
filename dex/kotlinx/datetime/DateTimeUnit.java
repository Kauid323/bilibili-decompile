package kotlinx.datetime;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.datetime.internal.DateCalculationsKt;
import kotlinx.datetime.internal.MathJvmKt;
import kotlinx.datetime.serializers.DateBasedDateTimeUnitSerializer;
import kotlinx.datetime.serializers.DateTimeUnitSerializer;
import kotlinx.datetime.serializers.DayBasedDateTimeUnitSerializer;
import kotlinx.datetime.serializers.MonthBasedDateTimeUnitSerializer;
import kotlinx.datetime.serializers.TimeBasedDateTimeUnitSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: DateTimeUnit.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u000b2\u00020\u0001:\u0005\u000b\f\r\u000e\u000fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0004J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0004J\u0011\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0006H¦\u0002\u0082\u0001\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lkotlinx/datetime/DateTimeUnit;", "", "()V", "formatToString", "", "value", "", "unit", "", "times", "scalar", "Companion", "DateBased", "DayBased", "MonthBased", "TimeBased", "Lkotlinx/datetime/DateTimeUnit$DateBased;", "Lkotlinx/datetime/DateTimeUnit$TimeBased;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable(with = DateTimeUnitSerializer.class)
public abstract class DateTimeUnit {
    public static final Companion Companion = new Companion(null);
    private static final TimeBased NANOSECOND = new TimeBased(1);
    private static final TimeBased MICROSECOND = NANOSECOND.times(1000);
    private static final TimeBased MILLISECOND = MICROSECOND.times(1000);
    private static final TimeBased SECOND = MILLISECOND.times(1000);
    private static final TimeBased MINUTE = SECOND.times(60);
    private static final TimeBased HOUR = MINUTE.times(60);
    private static final DayBased DAY = new DayBased(1);
    private static final DayBased WEEK = DAY.times(7);
    private static final MonthBased MONTH = new MonthBased(1);
    private static final MonthBased QUARTER = MONTH.times(3);
    private static final MonthBased YEAR = MONTH.times(12);
    private static final MonthBased CENTURY = YEAR.times(100);

    public /* synthetic */ DateTimeUnit(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract DateTimeUnit times(int i);

    private DateTimeUnit() {
    }

    /* compiled from: DateTimeUnit.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0011\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0012H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0016R\u0017\u0010\u0005\u001a\u00020\u00068Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Lkotlinx/datetime/DateTimeUnit$TimeBased;", "Lkotlinx/datetime/DateTimeUnit;", "nanoseconds", "", "(J)V", "duration", "Lkotlin/time/Duration;", "getDuration-UwyO8pc", "()J", "getNanoseconds", "unitName", "", "unitScale", "equals", "", "other", "", "hashCode", "", "times", "scalar", "toString", "Companion", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable(with = TimeBasedDateTimeUnitSerializer.class)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class TimeBased extends DateTimeUnit {
        public static final Companion Companion = new Companion(null);
        private final long nanoseconds;
        private final String unitName;
        private final long unitScale;

        /* compiled from: DateTimeUnit.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lkotlinx/datetime/DateTimeUnit$TimeBased$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/datetime/DateTimeUnit$TimeBased;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<TimeBased> serializer() {
                return TimeBasedDateTimeUnitSerializer.INSTANCE;
            }
        }

        public final long getNanoseconds() {
            return this.nanoseconds;
        }

        public TimeBased(long nanoseconds) {
            super(null);
            this.nanoseconds = nanoseconds;
            if (!(this.nanoseconds > 0)) {
                throw new IllegalArgumentException(("Unit duration must be positive, but was " + this.nanoseconds + " ns.").toString());
            }
            if (this.nanoseconds % DateCalculationsKt.NANOS_PER_HOUR == 0) {
                this.unitName = "HOUR";
                this.unitScale = this.nanoseconds / DateCalculationsKt.NANOS_PER_HOUR;
            } else if (this.nanoseconds % DateCalculationsKt.NANOS_PER_MINUTE == 0) {
                this.unitName = "MINUTE";
                this.unitScale = this.nanoseconds / DateCalculationsKt.NANOS_PER_MINUTE;
            } else {
                long j = 1000000000;
                if (this.nanoseconds % j == 0) {
                    this.unitName = "SECOND";
                    this.unitScale = this.nanoseconds / j;
                    return;
                }
                long j2 = 1000000;
                if (this.nanoseconds % j2 == 0) {
                    this.unitName = "MILLISECOND";
                    this.unitScale = this.nanoseconds / j2;
                    return;
                }
                long j3 = 1000;
                if (this.nanoseconds % j3 == 0) {
                    this.unitName = "MICROSECOND";
                    this.unitScale = this.nanoseconds / j3;
                    return;
                }
                this.unitName = "NANOSECOND";
                this.unitScale = this.nanoseconds;
            }
        }

        @Override // kotlinx.datetime.DateTimeUnit
        public TimeBased times(int scalar) {
            return new TimeBased(MathJvmKt.safeMultiply(this.nanoseconds, scalar));
        }

        /* renamed from: getDuration-UwyO8pc  reason: not valid java name */
        public final long m1477getDurationUwyO8pc() {
            Duration.Companion companion = Duration.Companion;
            return DurationKt.toDuration(this.nanoseconds, DurationUnit.NANOSECONDS);
        }

        public boolean equals(Object other) {
            return this == other || ((other instanceof TimeBased) && this.nanoseconds == ((TimeBased) other).nanoseconds);
        }

        public int hashCode() {
            return ((int) this.nanoseconds) ^ ((int) (this.nanoseconds >> 32));
        }

        public String toString() {
            return formatToString(this.unitScale, this.unitName);
        }
    }

    /* compiled from: DateTimeUnit.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b7\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002Z>\b\u0007\u0010\u0004\"\u00020\u00052\u00020\u0005B0\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\"\b\t\u0012\u001e\b\u000bB\u001a\b\n\u0012\f\b\u000b\u0012\b\b\fJ\u0004\b\b(\f\u0012\b\b\r\u0012\u0004\b\b(\u000eZ>\b\u0007\u0010\u000f\"\u00020\u00102\u00020\u0010B0\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0011\u0012\"\b\t\u0012\u001e\b\u000bB\u001a\b\n\u0012\f\b\u000b\u0012\b\b\fJ\u0004\b\b(\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0082\u0001\u0002\u0005\u0010¨\u0006\u0013"}, d2 = {"Lkotlinx/datetime/DateTimeUnit$DateBased;", "Lkotlinx/datetime/DateTimeUnit;", "()V", "Companion", "DayBased", "Lkotlinx/datetime/DateTimeUnit$DayBased;", "Lkotlin/Deprecated;", "message", "Use DateTimeUnit.DayBased", "replaceWith", "Lkotlin/ReplaceWith;", "imports", "kotlinx.datetime.DateTimeUnit", "expression", "DateTimeUnit.DayBased", "MonthBased", "Lkotlinx/datetime/DateTimeUnit$MonthBased;", "Use DateTimeUnit.MonthBased", "DateTimeUnit.MonthBased", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable(with = DateBasedDateTimeUnitSerializer.class)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static abstract class DateBased extends DateTimeUnit {
        public static final Companion Companion = new Companion(null);

        public /* synthetic */ DateBased(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(message = "Use DateTimeUnit.DayBased", replaceWith = @ReplaceWith(expression = "DateTimeUnit.DayBased", imports = {"kotlinx.datetime.DateTimeUnit"}))
        public static /* synthetic */ void DayBased$annotations() {
        }

        @Deprecated(message = "Use DateTimeUnit.MonthBased", replaceWith = @ReplaceWith(expression = "DateTimeUnit.MonthBased", imports = {"kotlinx.datetime.DateTimeUnit"}))
        public static /* synthetic */ void MonthBased$annotations() {
        }

        /* compiled from: DateTimeUnit.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lkotlinx/datetime/DateTimeUnit$DateBased$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/datetime/DateTimeUnit$DateBased;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<DateBased> serializer() {
                return DateBasedDateTimeUnitSerializer.INSTANCE;
            }
        }

        private DateBased() {
            super(null);
        }
    }

    /* compiled from: DateTimeUnit.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u0011\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0003H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lkotlinx/datetime/DateTimeUnit$DayBased;", "Lkotlinx/datetime/DateTimeUnit$DateBased;", "days", "", "(I)V", "getDays", "()I", "equals", "", "other", "", "hashCode", "times", "scalar", "toString", "", "Companion", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable(with = DayBasedDateTimeUnitSerializer.class)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class DayBased extends DateBased {
        public static final Companion Companion = new Companion(null);
        private final int days;

        /* compiled from: DateTimeUnit.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lkotlinx/datetime/DateTimeUnit$DayBased$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/datetime/DateTimeUnit$DayBased;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<DayBased> serializer() {
                return DayBasedDateTimeUnitSerializer.INSTANCE;
            }
        }

        public final int getDays() {
            return this.days;
        }

        public DayBased(int days) {
            super(null);
            this.days = days;
            if (this.days > 0) {
                return;
            }
            throw new IllegalArgumentException(("Unit duration must be positive, but was " + this.days + " days.").toString());
        }

        @Override // kotlinx.datetime.DateTimeUnit
        public DayBased times(int scalar) {
            return new DayBased(MathJvmKt.safeMultiply(this.days, scalar));
        }

        public boolean equals(Object other) {
            return this == other || ((other instanceof DayBased) && this.days == ((DayBased) other).days);
        }

        public int hashCode() {
            return this.days ^ 65536;
        }

        public String toString() {
            if (this.days % 7 == 0) {
                return formatToString(this.days / 7, "WEEK");
            }
            return formatToString(this.days, "DAY");
        }
    }

    /* compiled from: DateTimeUnit.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u0011\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0003H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lkotlinx/datetime/DateTimeUnit$MonthBased;", "Lkotlinx/datetime/DateTimeUnit$DateBased;", "months", "", "(I)V", "getMonths", "()I", "equals", "", "other", "", "hashCode", "times", "scalar", "toString", "", "Companion", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable(with = MonthBasedDateTimeUnitSerializer.class)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class MonthBased extends DateBased {
        public static final Companion Companion = new Companion(null);
        private final int months;

        /* compiled from: DateTimeUnit.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lkotlinx/datetime/DateTimeUnit$MonthBased$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/datetime/DateTimeUnit$MonthBased;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<MonthBased> serializer() {
                return MonthBasedDateTimeUnitSerializer.INSTANCE;
            }
        }

        public final int getMonths() {
            return this.months;
        }

        public MonthBased(int months) {
            super(null);
            this.months = months;
            if (this.months > 0) {
                return;
            }
            throw new IllegalArgumentException(("Unit duration must be positive, but was " + this.months + " months.").toString());
        }

        @Override // kotlinx.datetime.DateTimeUnit
        public MonthBased times(int scalar) {
            return new MonthBased(MathJvmKt.safeMultiply(this.months, scalar));
        }

        public boolean equals(Object other) {
            return this == other || ((other instanceof MonthBased) && this.months == ((MonthBased) other).months);
        }

        public int hashCode() {
            return this.months ^ 131072;
        }

        public String toString() {
            return this.months % 1200 == 0 ? formatToString(this.months / 1200, "CENTURY") : this.months % 12 == 0 ? formatToString(this.months / 12, "YEAR") : this.months % 3 == 0 ? formatToString(this.months / 3, "QUARTER") : formatToString(this.months, "MONTH");
        }
    }

    protected final String formatToString(int value, String unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return value == 1 ? unit : value + '-' + unit;
    }

    protected final String formatToString(long value, String unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return value == 1 ? unit : value + '-' + unit;
    }

    /* compiled from: DateTimeUnit.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"HÆ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0013\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0011\u0010\u001b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000eR\u0011\u0010\u001d\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\nR\u0011\u0010\u001f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006¨\u0006$"}, d2 = {"Lkotlinx/datetime/DateTimeUnit$Companion;", "", "()V", "CENTURY", "Lkotlinx/datetime/DateTimeUnit$MonthBased;", "getCENTURY", "()Lkotlinx/datetime/DateTimeUnit$MonthBased;", "DAY", "Lkotlinx/datetime/DateTimeUnit$DayBased;", "getDAY", "()Lkotlinx/datetime/DateTimeUnit$DayBased;", "HOUR", "Lkotlinx/datetime/DateTimeUnit$TimeBased;", "getHOUR", "()Lkotlinx/datetime/DateTimeUnit$TimeBased;", "MICROSECOND", "getMICROSECOND", "MILLISECOND", "getMILLISECOND", "MINUTE", "getMINUTE", "MONTH", "getMONTH", "NANOSECOND", "getNANOSECOND", "QUARTER", "getQUARTER", "SECOND", "getSECOND", "WEEK", "getWEEK", "YEAR", "getYEAR", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/datetime/DateTimeUnit;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DateTimeUnit> serializer() {
            return DateTimeUnitSerializer.INSTANCE;
        }

        public final TimeBased getNANOSECOND() {
            return DateTimeUnit.NANOSECOND;
        }

        public final TimeBased getMICROSECOND() {
            return DateTimeUnit.MICROSECOND;
        }

        public final TimeBased getMILLISECOND() {
            return DateTimeUnit.MILLISECOND;
        }

        public final TimeBased getSECOND() {
            return DateTimeUnit.SECOND;
        }

        public final TimeBased getMINUTE() {
            return DateTimeUnit.MINUTE;
        }

        public final TimeBased getHOUR() {
            return DateTimeUnit.HOUR;
        }

        public final DayBased getDAY() {
            return DateTimeUnit.DAY;
        }

        public final DayBased getWEEK() {
            return DateTimeUnit.WEEK;
        }

        public final MonthBased getMONTH() {
            return DateTimeUnit.MONTH;
        }

        public final MonthBased getQUARTER() {
            return DateTimeUnit.QUARTER;
        }

        public final MonthBased getYEAR() {
            return DateTimeUnit.YEAR;
        }

        public final MonthBased getCENTURY() {
            return DateTimeUnit.CENTURY;
        }
    }
}