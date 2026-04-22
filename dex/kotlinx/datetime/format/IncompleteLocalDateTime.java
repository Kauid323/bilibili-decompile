package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.internal.DecimalFraction;
import kotlinx.datetime.internal.format.parser.Copyable;

/* compiled from: LocalDateTimeFormat.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00000\u0004B\u0019\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u00109\u001a\u00020\u0000H\u0016J\u000e\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=J\u0006\u0010>\u001a\u00020=R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u000f¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u00198V@VX\u0096\u000f¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u0013X\u0096\u000f¢\u0006\f\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\u001a\u0010\"\u001a\u0004\u0018\u00010\u0013X\u0096\u000f¢\u0006\f\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R\u001a\u0010%\u001a\u0004\u0018\u00010\u0013X\u0096\u000f¢\u0006\f\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R\u001a\u0010(\u001a\u0004\u0018\u00010\u0013X\u0096\u000f¢\u0006\f\u001a\u0004\b)\u0010\u0015\"\u0004\b*\u0010\u0017R\u001a\u0010+\u001a\u0004\u0018\u00010\u0013X\u0096\u000f¢\u0006\f\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017R\u001a\u0010.\u001a\u0004\u0018\u00010\u0013X\u0096\u000f¢\u0006\f\u001a\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0017R\u001a\u00101\u001a\u0004\u0018\u00010\u0013X\u0096\u000f¢\u0006\f\u001a\u0004\b2\u0010\u0015\"\u0004\b3\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u001a\u00106\u001a\u0004\u0018\u00010\u0013X\u0096\u000f¢\u0006\f\u001a\u0004\b7\u0010\u0015\"\u0004\b8\u0010\u0017¨\u0006?"}, d2 = {"Lkotlinx/datetime/format/IncompleteLocalDateTime;", "Lkotlinx/datetime/format/DateTimeFieldContainer;", "Lkotlinx/datetime/format/DateFieldContainer;", "Lkotlinx/datetime/format/TimeFieldContainer;", "Lkotlinx/datetime/internal/format/parser/Copyable;", "date", "Lkotlinx/datetime/format/IncompleteLocalDate;", "time", "Lkotlinx/datetime/format/IncompleteLocalTime;", "(Lkotlinx/datetime/format/IncompleteLocalDate;Lkotlinx/datetime/format/IncompleteLocalTime;)V", "amPm", "Lkotlinx/datetime/format/AmPmMarker;", "getAmPm", "()Lkotlinx/datetime/format/AmPmMarker;", "setAmPm", "(Lkotlinx/datetime/format/AmPmMarker;)V", "getDate", "()Lkotlinx/datetime/format/IncompleteLocalDate;", "dayOfMonth", "", "getDayOfMonth", "()Ljava/lang/Integer;", "setDayOfMonth", "(Ljava/lang/Integer;)V", "value", "Lkotlinx/datetime/internal/DecimalFraction;", "fractionOfSecond", "getFractionOfSecond", "()Lkotlinx/datetime/internal/DecimalFraction;", "setFractionOfSecond", "(Lkotlinx/datetime/internal/DecimalFraction;)V", "hour", "getHour", "setHour", "hourOfAmPm", "getHourOfAmPm", "setHourOfAmPm", "isoDayOfWeek", "getIsoDayOfWeek", "setIsoDayOfWeek", "minute", "getMinute", "setMinute", "monthNumber", "getMonthNumber", "setMonthNumber", "nanosecond", "getNanosecond", "setNanosecond", "second", "getSecond", "setSecond", "getTime", "()Lkotlinx/datetime/format/IncompleteLocalTime;", "year", "getYear", "setYear", "copy", "populateFrom", "", "dateTime", "Lkotlinx/datetime/LocalDateTime;", "toLocalDateTime", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class IncompleteLocalDateTime implements DateTimeFieldContainer, DateFieldContainer, TimeFieldContainer, Copyable<IncompleteLocalDateTime> {
    private final IncompleteLocalDate date;
    private final IncompleteLocalTime time;

    public IncompleteLocalDateTime() {
        this(null, null, 3, null);
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

    @Override // kotlinx.datetime.format.DateFieldContainer
    public Integer getYear() {
        return this.date.getYear();
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

    @Override // kotlinx.datetime.format.DateFieldContainer
    public void setMonthNumber(Integer num) {
        this.date.setMonthNumber(num);
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public void setNanosecond(Integer num) {
        this.time.setNanosecond(num);
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public void setSecond(Integer num) {
        this.time.setSecond(num);
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public void setYear(Integer num) {
        this.date.setYear(num);
    }

    public IncompleteLocalDateTime(IncompleteLocalDate date, IncompleteLocalTime time) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(time, "time");
        this.date = date;
        this.time = time;
    }

    public /* synthetic */ IncompleteLocalDateTime(IncompleteLocalDate incompleteLocalDate, IncompleteLocalTime incompleteLocalTime, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new IncompleteLocalDate(null, null, null, null, 15, null) : incompleteLocalDate, (i & 2) != 0 ? new IncompleteLocalTime(null, null, null, null, null, null, 63, null) : incompleteLocalTime);
    }

    public final IncompleteLocalDate getDate() {
        return this.date;
    }

    public final IncompleteLocalTime getTime() {
        return this.time;
    }

    public final LocalDateTime toLocalDateTime() {
        return new LocalDateTime(this.date.toLocalDate(), this.time.toLocalTime());
    }

    public final void populateFrom(LocalDateTime dateTime) {
        Intrinsics.checkNotNullParameter(dateTime, "dateTime");
        this.date.populateFrom(dateTime.getDate());
        this.time.populateFrom(dateTime.getTime());
    }

    @Override // kotlinx.datetime.internal.format.parser.Copyable
    public IncompleteLocalDateTime copy() {
        return new IncompleteLocalDateTime(this.date.copy(), this.time.copy());
    }
}