package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlinx.datetime.internal.DecimalFraction;

/* compiled from: LocalTimeFormat.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0011\b`\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R(\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u0010X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u0010X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u0010X¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u0010X¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u0010X¦\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014¨\u0006!"}, d2 = {"Lkotlinx/datetime/format/TimeFieldContainer;", "", "amPm", "Lkotlinx/datetime/format/AmPmMarker;", "getAmPm", "()Lkotlinx/datetime/format/AmPmMarker;", "setAmPm", "(Lkotlinx/datetime/format/AmPmMarker;)V", "value", "Lkotlinx/datetime/internal/DecimalFraction;", "fractionOfSecond", "getFractionOfSecond", "()Lkotlinx/datetime/internal/DecimalFraction;", "setFractionOfSecond", "(Lkotlinx/datetime/internal/DecimalFraction;)V", "hour", "", "getHour", "()Ljava/lang/Integer;", "setHour", "(Ljava/lang/Integer;)V", "hourOfAmPm", "getHourOfAmPm", "setHourOfAmPm", "minute", "getMinute", "setMinute", "nanosecond", "getNanosecond", "setNanosecond", "second", "getSecond", "setSecond", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface TimeFieldContainer {
    AmPmMarker getAmPm();

    DecimalFraction getFractionOfSecond();

    Integer getHour();

    Integer getHourOfAmPm();

    Integer getMinute();

    Integer getNanosecond();

    Integer getSecond();

    void setAmPm(AmPmMarker amPmMarker);

    void setFractionOfSecond(DecimalFraction decimalFraction);

    void setHour(Integer num);

    void setHourOfAmPm(Integer num);

    void setMinute(Integer num);

    void setNanosecond(Integer num);

    void setSecond(Integer num);

    /* compiled from: LocalTimeFormat.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class DefaultImpls {
        public static DecimalFraction getFractionOfSecond(TimeFieldContainer $this) {
            Integer nanosecond = $this.getNanosecond();
            if (nanosecond != null) {
                int it = nanosecond.intValue();
                return new DecimalFraction(it, 9);
            }
            return null;
        }

        public static void setFractionOfSecond(TimeFieldContainer $this, DecimalFraction value) {
            $this.setNanosecond(value != null ? Integer.valueOf(value.fractionalPartWithNDigits(9)) : null);
        }
    }
}