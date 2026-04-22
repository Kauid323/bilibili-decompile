package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.LocalTime;
import kotlinx.datetime.format.TimeFieldContainer;
import kotlinx.datetime.internal.DecimalFraction;
import kotlinx.datetime.internal.format.parser.Copyable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.io.FilenameUtils;

/* compiled from: LocalTimeFormat.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002BM\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000bJ\b\u0010\u001d\u001a\u00020\u0000H\u0016J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0002J\b\u0010\"\u001a\u00020\u0004H\u0016J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020&J\b\u0010(\u001a\u00020)H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013¨\u0006*"}, d2 = {"Lkotlinx/datetime/format/IncompleteLocalTime;", "Lkotlinx/datetime/format/TimeFieldContainer;", "Lkotlinx/datetime/internal/format/parser/Copyable;", "hour", "", "hourOfAmPm", "amPm", "Lkotlinx/datetime/format/AmPmMarker;", "minute", "second", "nanosecond", "(Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/datetime/format/AmPmMarker;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAmPm", "()Lkotlinx/datetime/format/AmPmMarker;", "setAmPm", "(Lkotlinx/datetime/format/AmPmMarker;)V", "getHour", "()Ljava/lang/Integer;", "setHour", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getHourOfAmPm", "setHourOfAmPm", "getMinute", "setMinute", "getNanosecond", "setNanosecond", "getSecond", "setSecond", "copy", "equals", "", "other", "", "hashCode", "populateFrom", "", "localTime", "Lkotlinx/datetime/LocalTime;", "toLocalTime", "toString", "", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class IncompleteLocalTime implements TimeFieldContainer, Copyable<IncompleteLocalTime> {
    private AmPmMarker amPm;
    private Integer hour;
    private Integer hourOfAmPm;
    private Integer minute;
    private Integer nanosecond;
    private Integer second;

    public IncompleteLocalTime() {
        this(null, null, null, null, null, null, 63, null);
    }

    public IncompleteLocalTime(Integer hour, Integer hourOfAmPm, AmPmMarker amPm, Integer minute, Integer second, Integer nanosecond) {
        this.hour = hour;
        this.hourOfAmPm = hourOfAmPm;
        this.amPm = amPm;
        this.minute = minute;
        this.second = second;
        this.nanosecond = nanosecond;
    }

    public /* synthetic */ IncompleteLocalTime(Integer num, Integer num2, AmPmMarker amPmMarker, Integer num3, Integer num4, Integer num5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : amPmMarker, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : num4, (i & 32) != 0 ? null : num5);
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public DecimalFraction getFractionOfSecond() {
        return TimeFieldContainer.DefaultImpls.getFractionOfSecond(this);
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public void setFractionOfSecond(DecimalFraction value) {
        TimeFieldContainer.DefaultImpls.setFractionOfSecond(this, value);
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public Integer getHour() {
        return this.hour;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public void setHour(Integer num) {
        this.hour = num;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public Integer getHourOfAmPm() {
        return this.hourOfAmPm;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public void setHourOfAmPm(Integer num) {
        this.hourOfAmPm = num;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public AmPmMarker getAmPm() {
        return this.amPm;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public void setAmPm(AmPmMarker amPmMarker) {
        this.amPm = amPmMarker;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public Integer getMinute() {
        return this.minute;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public void setMinute(Integer num) {
        this.minute = num;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public Integer getSecond() {
        return this.second;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public void setSecond(Integer num) {
        this.second = num;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public Integer getNanosecond() {
        return this.nanosecond;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public void setNanosecond(Integer num) {
        this.nanosecond = num;
    }

    public final LocalTime toLocalTime() {
        int hour;
        Integer hour2 = getHour();
        if (hour2 != null) {
            hour = hour2.intValue();
            Integer hourOfAmPm = getHourOfAmPm();
            if (hourOfAmPm != null) {
                int it = hourOfAmPm.intValue();
                if (!(((hour + 11) % 12) + 1 == it)) {
                    throw new IllegalArgumentException(("Inconsistent hour and hour-of-am-pm: hour is " + hour + ", but hour-of-am-pm is " + it).toString());
                }
            }
            AmPmMarker amPm = getAmPm();
            if (amPm != null) {
                if (!((amPm == AmPmMarker.PM) == (hour >= 12))) {
                    throw new IllegalArgumentException(("Inconsistent hour and the AM/PM marker: hour is " + hour + ", but the AM/PM marker is " + amPm).toString());
                }
            }
        } else {
            Integer hourOfAmPm2 = getHourOfAmPm();
            Integer num = null;
            if (hourOfAmPm2 != null) {
                int hourOfAmPm3 = hourOfAmPm2.intValue();
                AmPmMarker amPm2 = getAmPm();
                if (amPm2 != null) {
                    int it2 = hourOfAmPm3;
                    if (it2 == 12) {
                        it2 = 0;
                    }
                    num = Integer.valueOf(it2 + (amPm2 != AmPmMarker.PM ? 0 : 12));
                }
            }
            if (num == null) {
                throw new DateTimeFormatException("Incomplete time: missing hour");
            }
            hour = num.intValue();
        }
        int intValue = ((Number) LocalDateFormatKt.requireParsedField(getMinute(), "minute")).intValue();
        Integer second = getSecond();
        int intValue2 = second != null ? second.intValue() : 0;
        Integer nanosecond = getNanosecond();
        return new LocalTime(hour, intValue, intValue2, nanosecond != null ? nanosecond.intValue() : 0);
    }

    public final void populateFrom(LocalTime localTime) {
        Intrinsics.checkNotNullParameter(localTime, "localTime");
        setHour(Integer.valueOf(localTime.getHour()));
        setHourOfAmPm(Integer.valueOf(((localTime.getHour() + 11) % 12) + 1));
        setAmPm(localTime.getHour() >= 12 ? AmPmMarker.PM : AmPmMarker.AM);
        setMinute(Integer.valueOf(localTime.getMinute()));
        setSecond(Integer.valueOf(localTime.getSecond()));
        setNanosecond(Integer.valueOf(localTime.getNanosecond()));
    }

    @Override // kotlinx.datetime.internal.format.parser.Copyable
    public IncompleteLocalTime copy() {
        return new IncompleteLocalTime(getHour(), getHourOfAmPm(), getAmPm(), getMinute(), getSecond(), getNanosecond());
    }

    public boolean equals(Object other) {
        return (other instanceof IncompleteLocalTime) && Intrinsics.areEqual(getHour(), ((IncompleteLocalTime) other).getHour()) && Intrinsics.areEqual(getHourOfAmPm(), ((IncompleteLocalTime) other).getHourOfAmPm()) && getAmPm() == ((IncompleteLocalTime) other).getAmPm() && Intrinsics.areEqual(getMinute(), ((IncompleteLocalTime) other).getMinute()) && Intrinsics.areEqual(getSecond(), ((IncompleteLocalTime) other).getSecond()) && Intrinsics.areEqual(getNanosecond(), ((IncompleteLocalTime) other).getNanosecond());
    }

    public int hashCode() {
        Integer hour = getHour();
        int intValue = (hour != null ? hour.intValue() : 0) * 31;
        Integer hourOfAmPm = getHourOfAmPm();
        int intValue2 = intValue + ((hourOfAmPm != null ? hourOfAmPm.intValue() : 0) * 31);
        AmPmMarker amPm = getAmPm();
        int hashCode = intValue2 + ((amPm != null ? amPm.hashCode() : 0) * 31);
        Integer minute = getMinute();
        int intValue3 = hashCode + ((minute != null ? minute.intValue() : 0) * 31);
        Integer second = getSecond();
        int intValue4 = intValue3 + ((second != null ? second.intValue() : 0) * 31);
        Integer nanosecond = getNanosecond();
        return intValue4 + (nanosecond != null ? nanosecond.intValue() : 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
        if (r3 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        String it;
        StringBuilder sb = new StringBuilder();
        Integer hour = getHour();
        if (hour == null) {
            hour = "??";
        }
        StringBuilder append = sb.append(hour).append(AbstractJsonLexerKt.COLON);
        Integer minute = getMinute();
        if (minute == null) {
            minute = "??";
        }
        StringBuilder append2 = append.append(minute).append(AbstractJsonLexerKt.COLON);
        Integer second = getSecond();
        StringBuilder append3 = append2.append(second != null ? second : "??").append(FilenameUtils.EXTENSION_SEPARATOR);
        Integer nanosecond = getNanosecond();
        if (nanosecond != null) {
            int nanos = nanosecond.intValue();
            String it2 = String.valueOf(nanos);
            it = StringsKt.padStart(it2, 9 - it2.length(), '0');
        }
        it = "???";
        return append3.append(it).toString();
    }
}