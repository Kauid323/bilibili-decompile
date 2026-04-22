package kotlinx.datetime;

import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DateTimePeriod.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkotlinx/datetime/DateTimePeriodImpl;", "Lkotlinx/datetime/DateTimePeriod;", "totalMonths", "", "days", "totalNanoseconds", "", "(IIJ)V", "getDays", "()I", "getTotalMonths$kotlinx_datetime", "getTotalNanoseconds$kotlinx_datetime", "()J", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DateTimePeriodImpl extends DateTimePeriod {
    private final int days;
    private final int totalMonths;
    private final long totalNanoseconds;

    @Override // kotlinx.datetime.DateTimePeriod
    public int getTotalMonths$kotlinx_datetime() {
        return this.totalMonths;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public int getDays() {
        return this.days;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public long getTotalNanoseconds$kotlinx_datetime() {
        return this.totalNanoseconds;
    }

    public DateTimePeriodImpl(int totalMonths, int days, long totalNanoseconds) {
        super(null);
        this.totalMonths = totalMonths;
        this.days = days;
        this.totalNanoseconds = totalNanoseconds;
    }
}