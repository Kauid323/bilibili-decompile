package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.datetime.LocalDateTime;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DateTimeFormat.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0007HÖ\u0001R \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lkntr/base/localization/DefaultAbsoluteDateTimeFormat;", "Lkntr/base/localization/AbsoluteDateTimeFormat;", "<init>", "()V", "yearMonthDayHourMinute", "Lkotlin/Function1;", "Lkotlinx/datetime/LocalDateTime;", "", "getYearMonthDayHourMinute", "()Lkotlin/jvm/functions/Function1;", "equals", "", "other", "", "hashCode", "", "toString", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DefaultAbsoluteDateTimeFormat implements AbsoluteDateTimeFormat {
    public static final DefaultAbsoluteDateTimeFormat INSTANCE = new DefaultAbsoluteDateTimeFormat();
    private static final Function1<LocalDateTime, String> yearMonthDayHourMinute = new Function1() { // from class: kntr.base.localization.DefaultAbsoluteDateTimeFormat$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            String yearMonthDayHourMinute$lambda$0;
            yearMonthDayHourMinute$lambda$0 = DefaultAbsoluteDateTimeFormat.yearMonthDayHourMinute$lambda$0((LocalDateTime) obj);
            return yearMonthDayHourMinute$lambda$0;
        }
    };

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultAbsoluteDateTimeFormat) {
            DefaultAbsoluteDateTimeFormat defaultAbsoluteDateTimeFormat = (DefaultAbsoluteDateTimeFormat) obj;
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 1148436005;
    }

    public String toString() {
        return "DefaultAbsoluteDateTimeFormat";
    }

    private DefaultAbsoluteDateTimeFormat() {
    }

    @Override // kntr.base.localization.AbsoluteDateTimeFormat
    public Function1<LocalDateTime, String> getYearMonthDayHourMinute() {
        return yearMonthDayHourMinute;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String yearMonthDayHourMinute$lambda$0(LocalDateTime it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return DateTimeResource_androidKt.getDateTimeResource().getString(DateTimeStringID.YearMonthDayTime, Integer.valueOf(it.getYear()), Integer.valueOf(it.getMonthNumber()), Integer.valueOf(it.getDayOfMonth()), StringsKt.padStart(String.valueOf(it.getHour()), 2, '0'), StringsKt.padStart(String.valueOf(it.getMinute()), 2, '0'));
    }
}