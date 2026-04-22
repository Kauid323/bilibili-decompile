package kotlinx.datetime;

import j$.time.DateTimeException;
import j$.time.ZoneOffset;
import j$.time.format.DateTimeFormatter;
import j$.time.format.DateTimeFormatterBuilder;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UtcOffsetJvm.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\b\u0011\u001a1\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\f\"#\u0010\u0012\u001a\n \r*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"#\u0010\u0015\u001a\n \r*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011\"#\u0010\u0018\u001a\n \r*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011¨\u0006\u0019"}, d2 = {"", "hours", "minutes", "seconds", "Lkotlinx/datetime/UtcOffset;", "UtcOffset", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lkotlinx/datetime/UtcOffset;", "", "input", "j$/time/format/DateTimeFormatter", "format", "parseWithFormat", "(Ljava/lang/CharSequence;Lj$/time/format/DateTimeFormatter;)Lkotlinx/datetime/UtcOffset;", "kotlin.jvm.PlatformType", "isoFormat$delegate", "Lkotlin/Lazy;", "getIsoFormat", "()Lj$/time/format/DateTimeFormatter;", "isoFormat", "isoBasicFormat$delegate", "getIsoBasicFormat", "isoBasicFormat", "fourDigitsFormat$delegate", "getFourDigitsFormat", "fourDigitsFormat", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UtcOffsetJvmKt {
    private static final Lazy isoFormat$delegate = LazyKt.lazy(new Function0<DateTimeFormatter>() { // from class: kotlinx.datetime.UtcOffsetJvmKt$isoFormat$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DateTimeFormatter invoke() {
            return new DateTimeFormatterBuilder().parseCaseInsensitive().appendOffsetId().toFormatter();
        }
    });
    private static final Lazy isoBasicFormat$delegate = LazyKt.lazy(new Function0<DateTimeFormatter>() { // from class: kotlinx.datetime.UtcOffsetJvmKt$isoBasicFormat$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DateTimeFormatter invoke() {
            return new DateTimeFormatterBuilder().parseCaseInsensitive().appendOffset("+HHmmss", "Z").toFormatter();
        }
    });
    private static final Lazy fourDigitsFormat$delegate = LazyKt.lazy(new Function0<DateTimeFormatter>() { // from class: kotlinx.datetime.UtcOffsetJvmKt$fourDigitsFormat$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DateTimeFormatter invoke() {
            return new DateTimeFormatterBuilder().parseCaseInsensitive().appendOffset("+HHMM", "+0000").toFormatter();
        }
    });

    public static final /* synthetic */ DateTimeFormatter access$getFourDigitsFormat() {
        return getFourDigitsFormat();
    }

    public static final /* synthetic */ DateTimeFormatter access$getIsoBasicFormat() {
        return getIsoBasicFormat();
    }

    public static final /* synthetic */ DateTimeFormatter access$getIsoFormat() {
        return getIsoFormat();
    }

    public static final /* synthetic */ UtcOffset access$parseWithFormat(CharSequence input, DateTimeFormatter format) {
        return parseWithFormat(input, format);
    }

    public static /* synthetic */ UtcOffset UtcOffset$default(Integer num, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            num3 = null;
        }
        return UtcOffset(num, num2, num3);
    }

    public static final UtcOffset UtcOffset(Integer hours, Integer minutes, Integer seconds) {
        UtcOffset utcOffset;
        try {
            if (hours != null) {
                ZoneOffset ofHoursMinutesSeconds = ZoneOffset.ofHoursMinutesSeconds(hours.intValue(), minutes != null ? minutes.intValue() : 0, seconds != null ? seconds.intValue() : 0);
                Intrinsics.checkNotNullExpressionValue(ofHoursMinutesSeconds, "ofHoursMinutesSeconds(...)");
                utcOffset = new UtcOffset(ofHoursMinutesSeconds);
            } else if (minutes != null) {
                ZoneOffset ofHoursMinutesSeconds2 = ZoneOffset.ofHoursMinutesSeconds(minutes.intValue() / 60, minutes.intValue() % 60, seconds != null ? seconds.intValue() : 0);
                Intrinsics.checkNotNullExpressionValue(ofHoursMinutesSeconds2, "ofHoursMinutesSeconds(...)");
                utcOffset = new UtcOffset(ofHoursMinutesSeconds2);
            } else {
                ZoneOffset ofTotalSeconds = ZoneOffset.ofTotalSeconds(seconds != null ? seconds.intValue() : 0);
                Intrinsics.checkNotNullExpressionValue(ofTotalSeconds, "ofTotalSeconds(...)");
                utcOffset = new UtcOffset(ofTotalSeconds);
            }
            return utcOffset;
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static final DateTimeFormatter getIsoFormat() {
        return (DateTimeFormatter) isoFormat$delegate.getValue();
    }

    public static final DateTimeFormatter getIsoBasicFormat() {
        return (DateTimeFormatter) isoBasicFormat$delegate.getValue();
    }

    public static final DateTimeFormatter getFourDigitsFormat() {
        return (DateTimeFormatter) fourDigitsFormat$delegate.getValue();
    }

    public static final UtcOffset parseWithFormat(CharSequence input, DateTimeFormatter format) {
        try {
            ZoneOffset p0 = (ZoneOffset) format.parse(input, new TemporalQuery() { // from class: kotlinx.datetime.UtcOffsetJvmKt$$ExternalSyntheticLambda0
                public final Object queryFrom(TemporalAccessor temporalAccessor) {
                    return ZoneOffset.from(temporalAccessor);
                }
            });
            return new UtcOffset(p0);
        } catch (DateTimeException e) {
            throw new DateTimeFormatException(e);
        }
    }
}