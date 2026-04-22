package kotlinx.datetime;

import j$.time.DateTimeException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.datetime.format.DateTimeComponents;
import kotlinx.datetime.format.DateTimeFormat;
import kotlinx.datetime.serializers.InstantIso8601Serializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: Instant.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001&B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\fJ\u001e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u0016H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010!R\u0011\u0010#\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\"\u0010\bR\u0011\u0010%\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b$\u0010\u001b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, d2 = {"Lkotlinx/datetime/Instant;", "", "j$/time/Instant", "value", "<init>", "(Lj$/time/Instant;)V", "", "toEpochMilliseconds", "()J", "Lkotlin/time/Duration;", "duration", "plus-LRDsOJo", "(J)Lkotlinx/datetime/Instant;", "plus", "minus-LRDsOJo", "minus", "other", "minus-5sfh64U", "(Lkotlinx/datetime/Instant;)J", "", "compareTo", "(Lkotlinx/datetime/Instant;)I", "", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lj$/time/Instant;", "getValue$kotlinx_datetime", "()Lj$/time/Instant;", "getEpochSeconds", "epochSeconds", "getNanosecondsOfSecond", "nanosecondsOfSecond", "Companion", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable(with = InstantIso8601Serializer.class)
public final class Instant implements Comparable<Instant> {
    public static final Companion Companion = new Companion(null);
    private static final Instant DISTANT_FUTURE;
    private static final Instant DISTANT_PAST;
    private static final Instant MAX;
    private static final Instant MIN;
    private final j$.time.Instant value;

    public Instant(j$.time.Instant value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    public final j$.time.Instant getValue$kotlinx_datetime() {
        return this.value;
    }

    public final long getEpochSeconds() {
        return this.value.getEpochSecond();
    }

    public final int getNanosecondsOfSecond() {
        return this.value.getNano();
    }

    public final long toEpochMilliseconds() {
        try {
            return this.value.toEpochMilli();
        } catch (ArithmeticException e) {
            return this.value.isAfter(j$.time.Instant.EPOCH) ? LongCompanionObject.MAX_VALUE : Long.MIN_VALUE;
        }
    }

    /* renamed from: plus-LRDsOJo  reason: not valid java name */
    public final Instant m1480plusLRDsOJo(long duration) {
        long seconds = Duration.m1259getInWholeSecondsimpl(duration);
        int nanoseconds = Duration.m1261getNanosecondsComponentimpl(duration);
        try {
            j$.time.Instant plusNanos = this.value.plusSeconds(seconds).plusNanos(nanoseconds);
            Intrinsics.checkNotNullExpressionValue(plusNanos, "plusNanos(...)");
            return new Instant(plusNanos);
        } catch (Exception e) {
            if ((e instanceof ArithmeticException) || (e instanceof DateTimeException)) {
                return Duration.m1272isPositiveimpl(duration) ? MAX : MIN;
            }
            throw e;
        }
    }

    /* renamed from: minus-LRDsOJo  reason: not valid java name */
    public final Instant m1479minusLRDsOJo(long duration) {
        return m1480plusLRDsOJo(Duration.m1289unaryMinusUwyO8pc(duration));
    }

    /* renamed from: minus-5sfh64U  reason: not valid java name */
    public final long m1478minus5sfh64U(Instant other) {
        Intrinsics.checkNotNullParameter(other, "other");
        Duration.Companion companion = Duration.Companion;
        long duration = DurationKt.toDuration(this.value.getEpochSecond() - other.value.getEpochSecond(), DurationUnit.SECONDS);
        Duration.Companion companion2 = Duration.Companion;
        return Duration.m1274plusLRDsOJo(duration, DurationKt.toDuration(this.value.getNano() - other.value.getNano(), DurationUnit.NANOSECONDS));
    }

    @Override // java.lang.Comparable
    public int compareTo(Instant other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.value.compareTo(other.value);
    }

    public boolean equals(Object other) {
        return this == other || ((other instanceof Instant) && Intrinsics.areEqual(this.value, ((Instant) other).value));
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        String instant = this.value.toString();
        Intrinsics.checkNotNullExpressionValue(instant, "toString(...)");
        return instant;
    }

    /* compiled from: Instant.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000fJ\b\u0010\u0014\u001a\u00020\u0004H\u0007J\u001e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001eHÆ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\u001f"}, d2 = {"Lkotlinx/datetime/Instant$Companion;", "", "()V", "DISTANT_FUTURE", "Lkotlinx/datetime/Instant;", "getDISTANT_FUTURE", "()Lkotlinx/datetime/Instant;", "DISTANT_PAST", "getDISTANT_PAST", "MAX", "getMAX$kotlinx_datetime", "MIN", "getMIN$kotlinx_datetime", "fromEpochMilliseconds", "epochMilliseconds", "", "fromEpochSeconds", "epochSeconds", "nanosecondAdjustment", "", "now", "parse", "input", "", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/format/DateTimeComponents;", "isoString", "", "serializer", "Lkotlinx/serialization/KSerializer;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Instant> serializer() {
            return InstantIso8601Serializer.INSTANCE;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use Clock.System.now() instead", replaceWith = @ReplaceWith(expression = "Clock.System.now()", imports = {"kotlinx.datetime.Clock"}))
        public final Instant now() {
            j$.time.Instant instant = j$.time.Clock.systemUTC().instant();
            Intrinsics.checkNotNullExpressionValue(instant, "instant(...)");
            return new Instant(instant);
        }

        public final Instant fromEpochMilliseconds(long epochMilliseconds) {
            j$.time.Instant ofEpochMilli = j$.time.Instant.ofEpochMilli(epochMilliseconds);
            Intrinsics.checkNotNullExpressionValue(ofEpochMilli, "ofEpochMilli(...)");
            return new Instant(ofEpochMilli);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Instant parse$default(Companion companion, CharSequence charSequence, DateTimeFormat dateTimeFormat, int i, Object obj) {
            DateTimeFormat<DateTimeComponents> dateTimeFormat2 = dateTimeFormat;
            if ((i & 2) != 0) {
                dateTimeFormat2 = DateTimeComponents.Formats.INSTANCE.getISO_DATE_TIME_OFFSET();
            }
            return companion.parse(charSequence, dateTimeFormat2);
        }

        public final Instant parse(CharSequence input, DateTimeFormat<DateTimeComponents> format) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(format, "format");
            try {
                return format.parse(input).toInstantUsingOffset();
            } catch (IllegalArgumentException e) {
                throw new DateTimeFormatException("Failed to parse an instant from '" + ((Object) input) + '\'', e);
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This overload is only kept for binary compatibility")
        public final /* synthetic */ Instant parse(String isoString) {
            Intrinsics.checkNotNullParameter(isoString, "isoString");
            return parse$default(this, isoString, null, 2, null);
        }

        public static /* synthetic */ Instant fromEpochSeconds$default(Companion companion, long j, long j2, int i, Object obj) {
            if ((i & 2) != 0) {
                j2 = 0;
            }
            return companion.fromEpochSeconds(j, j2);
        }

        public final Instant fromEpochSeconds(long epochSeconds, long nanosecondAdjustment) {
            try {
                j$.time.Instant ofEpochSecond = j$.time.Instant.ofEpochSecond(epochSeconds, nanosecondAdjustment);
                Intrinsics.checkNotNullExpressionValue(ofEpochSecond, "ofEpochSecond(...)");
                return new Instant(ofEpochSecond);
            } catch (Exception e) {
                if ((e instanceof ArithmeticException) || (e instanceof DateTimeException)) {
                    return epochSeconds > 0 ? getMAX$kotlinx_datetime() : getMIN$kotlinx_datetime();
                }
                throw e;
            }
        }

        public final Instant fromEpochSeconds(long epochSeconds, int nanosecondAdjustment) {
            return fromEpochSeconds(epochSeconds, nanosecondAdjustment);
        }

        public final Instant getDISTANT_PAST() {
            return Instant.DISTANT_PAST;
        }

        public final Instant getDISTANT_FUTURE() {
            return Instant.DISTANT_FUTURE;
        }

        public final Instant getMIN$kotlinx_datetime() {
            return Instant.MIN;
        }

        public final Instant getMAX$kotlinx_datetime() {
            return Instant.MAX;
        }
    }

    static {
        j$.time.Instant ofEpochSecond = j$.time.Instant.ofEpochSecond((long) InstantKt.DISTANT_PAST_SECONDS, 999999999L);
        Intrinsics.checkNotNullExpressionValue(ofEpochSecond, "ofEpochSecond(...)");
        DISTANT_PAST = new Instant(ofEpochSecond);
        j$.time.Instant ofEpochSecond2 = j$.time.Instant.ofEpochSecond((long) InstantKt.DISTANT_FUTURE_SECONDS, 0L);
        Intrinsics.checkNotNullExpressionValue(ofEpochSecond2, "ofEpochSecond(...)");
        DISTANT_FUTURE = new Instant(ofEpochSecond2);
        j$.time.Instant MIN2 = j$.time.Instant.MIN;
        Intrinsics.checkNotNullExpressionValue(MIN2, "MIN");
        MIN = new Instant(MIN2);
        j$.time.Instant MAX2 = j$.time.Instant.MAX;
        Intrinsics.checkNotNullExpressionValue(MAX2, "MAX");
        MAX = new Instant(MAX2);
    }
}