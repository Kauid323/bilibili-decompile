package kotlinx.datetime.format;

import kotlin.Metadata;

/* compiled from: UtcOffsetFormat.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\b`\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u0004\u0018\u00010\bX¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\bX¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lkotlinx/datetime/format/UtcOffsetFieldContainer;", "", "isNegative", "", "()Ljava/lang/Boolean;", "setNegative", "(Ljava/lang/Boolean;)V", "minutesOfHour", "", "getMinutesOfHour", "()Ljava/lang/Integer;", "setMinutesOfHour", "(Ljava/lang/Integer;)V", "secondsOfMinute", "getSecondsOfMinute", "setSecondsOfMinute", "totalHoursAbs", "getTotalHoursAbs", "setTotalHoursAbs", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface UtcOffsetFieldContainer {
    Integer getMinutesOfHour();

    Integer getSecondsOfMinute();

    Integer getTotalHoursAbs();

    Boolean isNegative();

    void setMinutesOfHour(Integer num);

    void setNegative(Boolean bool);

    void setSecondsOfMinute(Integer num);

    void setTotalHoursAbs(Integer num);
}