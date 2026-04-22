package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.DecimalFraction;
import kotlinx.datetime.internal.format.parser.Copyable;

/* compiled from: DateTimeComponents.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\b\u0012\u0004\u0012\u00020\u00000\u0005B1\b\u0000\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\b\u0010R\u001a\u00020\u0000H\u0016J\u0013\u0010S\u001a\u00020+2\b\u0010T\u001a\u0004\u0018\u00010UH\u0096\u0002J\b\u0010V\u001a\u00020\u0018H\u0016R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR(\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e8V@VX\u0096\u000f¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u0004\u0018\u00010\u0018X\u0096\u000f¢\u0006\f\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR\u001a\u0010'\u001a\u0004\u0018\u00010\u0018X\u0096\u000f¢\u0006\f\u001a\u0004\b(\u0010\u001a\"\u0004\b)\u0010\u001cR\u001a\u0010*\u001a\u0004\u0018\u00010+X\u0096\u000f¢\u0006\f\u001a\u0004\b*\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u0004\u0018\u00010\u0018X\u0096\u000f¢\u0006\f\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u0010\u001cR\u001a\u00102\u001a\u0004\u0018\u00010\u0018X\u0096\u000f¢\u0006\f\u001a\u0004\b3\u0010\u001a\"\u0004\b4\u0010\u001cR\u001a\u00105\u001a\u0004\u0018\u00010\u0018X\u0096\u000f¢\u0006\f\u001a\u0004\b6\u0010\u001a\"\u0004\b7\u0010\u001cR\u001a\u00108\u001a\u0004\u0018\u00010\u0018X\u0096\u000f¢\u0006\f\u001a\u0004\b9\u0010\u001a\"\u0004\b:\u0010\u001cR\u001a\u0010;\u001a\u0004\u0018\u00010\u0018X\u0096\u000f¢\u0006\f\u001a\u0004\b<\u0010\u001a\"\u0004\b=\u0010\u001cR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u001a\u0010@\u001a\u0004\u0018\u00010\u0018X\u0096\u000f¢\u0006\f\u001a\u0004\bA\u0010\u001a\"\u0004\bB\u0010\u001cR\u001a\u0010C\u001a\u0004\u0018\u00010\u0018X\u0096\u000f¢\u0006\f\u001a\u0004\bD\u0010\u001a\"\u0004\bE\u0010\u001cR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010L\u001a\u0004\u0018\u00010\u0018X\u0096\u000f¢\u0006\f\u001a\u0004\bM\u0010\u001a\"\u0004\bN\u0010\u001cR\u001a\u0010O\u001a\u0004\u0018\u00010\u0018X\u0096\u000f¢\u0006\f\u001a\u0004\bP\u0010\u001a\"\u0004\bQ\u0010\u001c¨\u0006W"}, d2 = {"Lkotlinx/datetime/format/DateTimeComponentsContents;", "Lkotlinx/datetime/format/DateFieldContainer;", "Lkotlinx/datetime/format/TimeFieldContainer;", "Lkotlinx/datetime/format/UtcOffsetFieldContainer;", "Lkotlinx/datetime/format/DateTimeFieldContainer;", "Lkotlinx/datetime/internal/format/parser/Copyable;", "date", "Lkotlinx/datetime/format/IncompleteLocalDate;", "time", "Lkotlinx/datetime/format/IncompleteLocalTime;", "offset", "Lkotlinx/datetime/format/IncompleteUtcOffset;", "timeZoneId", "", "(Lkotlinx/datetime/format/IncompleteLocalDate;Lkotlinx/datetime/format/IncompleteLocalTime;Lkotlinx/datetime/format/IncompleteUtcOffset;Ljava/lang/String;)V", "amPm", "Lkotlinx/datetime/format/AmPmMarker;", "getAmPm", "()Lkotlinx/datetime/format/AmPmMarker;", "setAmPm", "(Lkotlinx/datetime/format/AmPmMarker;)V", "getDate", "()Lkotlinx/datetime/format/IncompleteLocalDate;", "dayOfMonth", "", "getDayOfMonth", "()Ljava/lang/Integer;", "setDayOfMonth", "(Ljava/lang/Integer;)V", "value", "Lkotlinx/datetime/internal/DecimalFraction;", "fractionOfSecond", "getFractionOfSecond", "()Lkotlinx/datetime/internal/DecimalFraction;", "setFractionOfSecond", "(Lkotlinx/datetime/internal/DecimalFraction;)V", "hour", "getHour", "setHour", "hourOfAmPm", "getHourOfAmPm", "setHourOfAmPm", "isNegative", "", "()Ljava/lang/Boolean;", "setNegative", "(Ljava/lang/Boolean;)V", "isoDayOfWeek", "getIsoDayOfWeek", "setIsoDayOfWeek", "minute", "getMinute", "setMinute", "minutesOfHour", "getMinutesOfHour", "setMinutesOfHour", "monthNumber", "getMonthNumber", "setMonthNumber", "nanosecond", "getNanosecond", "setNanosecond", "getOffset", "()Lkotlinx/datetime/format/IncompleteUtcOffset;", "second", "getSecond", "setSecond", "secondsOfMinute", "getSecondsOfMinute", "setSecondsOfMinute", "getTime", "()Lkotlinx/datetime/format/IncompleteLocalTime;", "getTimeZoneId", "()Ljava/lang/String;", "setTimeZoneId", "(Ljava/lang/String;)V", "totalHoursAbs", "getTotalHoursAbs", "setTotalHoursAbs", "year", "getYear", "setYear", "copy", "equals", "other", "", "hashCode", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DateTimeComponentsContents implements DateFieldContainer, TimeFieldContainer, UtcOffsetFieldContainer, DateTimeFieldContainer, Copyable<DateTimeComponentsContents> {
    private final IncompleteLocalDate date;
    private final IncompleteUtcOffset offset;
    private final IncompleteLocalTime time;
    private String timeZoneId;

    public DateTimeComponentsContents() {
        this(null, null, null, null, 15, null);
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public AmPmMarker getAmPm() {
        return this.time.getAmPm();
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public Integer getDayOfMonth() {
        return this.date.getDayOfMonth();
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public DecimalFraction getFractionOfSecond() {
        return this.time.getFractionOfSecond();
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public Integer getHour() {
        return this.time.getHour();
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public Integer getHourOfAmPm() {
        return this.time.getHourOfAmPm();
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public Integer getIsoDayOfWeek() {
        return this.date.getIsoDayOfWeek();
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public Integer getMinute() {
        return this.time.getMinute();
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public Integer getMinutesOfHour() {
        return this.offset.getMinutesOfHour();
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public Integer getMonthNumber() {
        return this.date.getMonthNumber();
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public Integer getNanosecond() {
        return this.time.getNanosecond();
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public Integer getSecond() {
        return this.time.getSecond();
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public Integer getSecondsOfMinute() {
        return this.offset.getSecondsOfMinute();
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public Integer getTotalHoursAbs() {
        return this.offset.getTotalHoursAbs();
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public Integer getYear() {
        return this.date.getYear();
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public Boolean isNegative() {
        return this.offset.isNegative();
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public void setAmPm(AmPmMarker amPmMarker) {
        this.time.setAmPm(amPmMarker);
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public void setDayOfMonth(Integer num) {
        this.date.setDayOfMonth(num);
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public void setFractionOfSecond(DecimalFraction decimalFraction) {
        this.time.setFractionOfSecond(decimalFraction);
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public void setHour(Integer num) {
        this.time.setHour(num);
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public void setHourOfAmPm(Integer num) {
        this.time.setHourOfAmPm(num);
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public void setIsoDayOfWeek(Integer num) {
        this.date.setIsoDayOfWeek(num);
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public void setMinute(Integer num) {
        this.time.setMinute(num);
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public void setMinutesOfHour(Integer num) {
        this.offset.setMinutesOfHour(num);
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public void setMonthNumber(Integer num) {
        this.date.setMonthNumber(num);
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public void setNanosecond(Integer num) {
        this.time.setNanosecond(num);
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public void setNegative(Boolean bool) {
        this.offset.setNegative(bool);
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public void setSecond(Integer num) {
        this.time.setSecond(num);
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public void setSecondsOfMinute(Integer num) {
        this.offset.setSecondsOfMinute(num);
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public void setTotalHoursAbs(Integer num) {
        this.offset.setTotalHoursAbs(num);
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public void setYear(Integer num) {
        this.date.setYear(num);
    }

    public DateTimeComponentsContents(IncompleteLocalDate date, IncompleteLocalTime time, IncompleteUtcOffset offset, String timeZoneId) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(offset, "offset");
        this.date = date;
        this.time = time;
        this.offset = offset;
        this.timeZoneId = timeZoneId;
    }

    public /* synthetic */ DateTimeComponentsContents(IncompleteLocalDate incompleteLocalDate, IncompleteLocalTime incompleteLocalTime, IncompleteUtcOffset incompleteUtcOffset, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new IncompleteLocalDate(null, null, null, null, 15, null) : incompleteLocalDate, (i & 2) != 0 ? new IncompleteLocalTime(null, null, null, null, null, null, 63, null) : incompleteLocalTime, (i & 4) != 0 ? new IncompleteUtcOffset(null, null, null, null, 15, null) : incompleteUtcOffset, (i & 8) != 0 ? null : str);
    }

    public final IncompleteLocalDate getDate() {
        return this.date;
    }

    public final IncompleteLocalTime getTime() {
        return this.time;
    }

    public final IncompleteUtcOffset getOffset() {
        return this.offset;
    }

    public final String getTimeZoneId() {
        return this.timeZoneId;
    }

    public final void setTimeZoneId(String str) {
        this.timeZoneId = str;
    }

    @Override // kotlinx.datetime.internal.format.parser.Copyable
    public DateTimeComponentsContents copy() {
        return new DateTimeComponentsContents(this.date.copy(), this.time.copy(), this.offset.copy(), this.timeZoneId);
    }

    public boolean equals(Object other) {
        return (other instanceof DateTimeComponentsContents) && Intrinsics.areEqual(((DateTimeComponentsContents) other).date, this.date) && Intrinsics.areEqual(((DateTimeComponentsContents) other).time, this.time) && Intrinsics.areEqual(((DateTimeComponentsContents) other).offset, this.offset) && Intrinsics.areEqual(((DateTimeComponentsContents) other).timeZoneId, this.timeZoneId);
    }

    public int hashCode() {
        int hashCode = (this.date.hashCode() ^ this.time.hashCode()) ^ this.offset.hashCode();
        String str = this.timeZoneId;
        return hashCode ^ (str != null ? str.hashCode() : 0);
    }
}