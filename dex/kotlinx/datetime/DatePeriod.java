package kotlinx.datetime;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.serializers.DatePeriodIso8601Serializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: DateTimePeriod.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B%\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006B\u0017\b\u0000\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u0014\u0010\u0007\u001a\u00020\u0003X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\nR\u0014\u0010\u0014\u001a\u00020\u00158PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lkotlinx/datetime/DatePeriod;", "Lkotlinx/datetime/DateTimePeriod;", "years", "", "months", "days", "(III)V", "totalMonths", "(II)V", "getDays", "()I", "hours", "getHours", "minutes", "getMinutes", "nanoseconds", "getNanoseconds", "seconds", "getSeconds", "getTotalMonths$kotlinx_datetime", "totalNanoseconds", "", "getTotalNanoseconds$kotlinx_datetime", "()J", "Companion", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable(with = DatePeriodIso8601Serializer.class)
public final class DatePeriod extends DateTimePeriod {
    public static final Companion Companion = new Companion(null);
    private final int days;
    private final int totalMonths;

    @Override // kotlinx.datetime.DateTimePeriod
    public int getTotalMonths$kotlinx_datetime() {
        return this.totalMonths;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public int getDays() {
        return this.days;
    }

    public DatePeriod(int totalMonths, int days) {
        super(null);
        this.totalMonths = totalMonths;
        this.days = days;
    }

    public DatePeriod(int years, int months, int days) {
        this(DateTimePeriodKt.access$totalMonths(years, months), days);
    }

    public /* synthetic */ DatePeriod(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public int getHours() {
        return 0;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public int getMinutes() {
        return 0;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public int getSeconds() {
        return 0;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public int getNanoseconds() {
        return 0;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public long getTotalNanoseconds$kotlinx_datetime() {
        return 0L;
    }

    /* compiled from: DateTimePeriod.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bHÆ\u0001¨\u0006\t"}, d2 = {"Lkotlinx/datetime/DatePeriod$Companion;", "", "()V", "parse", "Lkotlinx/datetime/DatePeriod;", "text", "", "serializer", "Lkotlinx/serialization/KSerializer;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DatePeriod> serializer() {
            return DatePeriodIso8601Serializer.INSTANCE;
        }

        public final DatePeriod parse(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            DateTimePeriod period = DateTimePeriod.Companion.parse(text);
            if (period instanceof DatePeriod) {
                return (DatePeriod) period;
            }
            throw new DateTimeFormatException("Period " + period + " (parsed from string " + text + ") is not date-based");
        }
    }
}