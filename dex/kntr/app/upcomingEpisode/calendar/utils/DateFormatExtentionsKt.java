package kntr.app.upcomingEpisode.calendar.utils;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.calendar.model.Year;
import kntr.app.upcomingEpisode.calendar.model.YearKt;
import kntr.app.upcomingEpisode.calendar.model.YearMonth;
import kntr.app.upcomingEpisode.calendar.model.YearMonthKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.format.DateTimeFormat;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.format.DateTimeFormatBuilderKt;
import kotlinx.datetime.format.Padding;

/* compiled from: DateFormatExtentions.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\r\u001a\u00020\u000e*\u00020\u0002H\u0000\u001a\f\u0010\r\u001a\u00020\u000e*\u00020\u000fH\u0000\u001a\f\u0010\r\u001a\u00020\u000e*\u00020\u0010H\u0000\u001a\f\u0010\u0011\u001a\u00020\u0002*\u00020\u000eH\u0000\u001a\f\u0010\u0012\u001a\u00020\u000f*\u00020\u000eH\u0000\u001a\f\u0010\u0013\u001a\u00020\u0010*\u00020\u000eH\u0000\"!\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004\"!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004\"!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004¨\u0006\u0014"}, d2 = {"ISO_YEAR_MONTH", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalDate;", "getISO_YEAR_MONTH", "()Lkotlinx/datetime/format/DateTimeFormat;", "ISO_YEAR_MONTH$delegate", "Lkotlin/Lazy;", "ISO_YEAR", "getISO_YEAR", "ISO_YEAR$delegate", "ISO_LOCAL_DATE", "getISO_LOCAL_DATE", "ISO_LOCAL_DATE$delegate", "toIso8601String", "", "Lkntr/app/upcomingEpisode/calendar/model/YearMonth;", "Lkntr/app/upcomingEpisode/calendar/model/Year;", "fromIso8601LocalDate", "fromIso8601YearMonth", "fromIso8601Year", "main_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DateFormatExtentionsKt {
    private static final Lazy ISO_YEAR_MONTH$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.upcomingEpisode.calendar.utils.DateFormatExtentionsKt$$ExternalSyntheticLambda2
        public final Object invoke() {
            DateTimeFormat ISO_YEAR_MONTH_delegate$lambda$0;
            ISO_YEAR_MONTH_delegate$lambda$0 = DateFormatExtentionsKt.ISO_YEAR_MONTH_delegate$lambda$0();
            return ISO_YEAR_MONTH_delegate$lambda$0;
        }
    });
    private static final Lazy ISO_YEAR$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.upcomingEpisode.calendar.utils.DateFormatExtentionsKt$$ExternalSyntheticLambda3
        public final Object invoke() {
            DateTimeFormat ISO_YEAR_delegate$lambda$0;
            ISO_YEAR_delegate$lambda$0 = DateFormatExtentionsKt.ISO_YEAR_delegate$lambda$0();
            return ISO_YEAR_delegate$lambda$0;
        }
    });
    private static final Lazy ISO_LOCAL_DATE$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.upcomingEpisode.calendar.utils.DateFormatExtentionsKt$$ExternalSyntheticLambda4
        public final Object invoke() {
            DateTimeFormat ISO_LOCAL_DATE_delegate$lambda$0;
            ISO_LOCAL_DATE_delegate$lambda$0 = DateFormatExtentionsKt.ISO_LOCAL_DATE_delegate$lambda$0();
            return ISO_LOCAL_DATE_delegate$lambda$0;
        }
    });

    private static final DateTimeFormat<LocalDate> getISO_YEAR_MONTH() {
        return (DateTimeFormat) ISO_YEAR_MONTH$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DateTimeFormat ISO_YEAR_MONTH_delegate$lambda$0() {
        return LocalDate.Companion.Format(new Function1() { // from class: kntr.app.upcomingEpisode.calendar.utils.DateFormatExtentionsKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit ISO_YEAR_MONTH_delegate$lambda$0$0;
                ISO_YEAR_MONTH_delegate$lambda$0$0 = DateFormatExtentionsKt.ISO_YEAR_MONTH_delegate$lambda$0$0((DateTimeFormatBuilder.WithDate) obj);
                return ISO_YEAR_MONTH_delegate$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ISO_YEAR_MONTH_delegate$lambda$0$0(DateTimeFormatBuilder.WithDate $this$Format) {
        Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
        DateTimeFormatBuilder.WithDate.DefaultImpls.year$default($this$Format, (Padding) null, 1, (Object) null);
        DateTimeFormatBuilderKt.char((DateTimeFormatBuilder) $this$Format, '-');
        DateTimeFormatBuilder.WithDate.DefaultImpls.monthNumber$default($this$Format, (Padding) null, 1, (Object) null);
        return Unit.INSTANCE;
    }

    private static final DateTimeFormat<LocalDate> getISO_YEAR() {
        return (DateTimeFormat) ISO_YEAR$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DateTimeFormat ISO_YEAR_delegate$lambda$0() {
        return LocalDate.Companion.Format(new Function1() { // from class: kntr.app.upcomingEpisode.calendar.utils.DateFormatExtentionsKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit ISO_YEAR_delegate$lambda$0$0;
                ISO_YEAR_delegate$lambda$0$0 = DateFormatExtentionsKt.ISO_YEAR_delegate$lambda$0$0((DateTimeFormatBuilder.WithDate) obj);
                return ISO_YEAR_delegate$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ISO_YEAR_delegate$lambda$0$0(DateTimeFormatBuilder.WithDate $this$Format) {
        Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
        DateTimeFormatBuilder.WithDate.DefaultImpls.year$default($this$Format, (Padding) null, 1, (Object) null);
        return Unit.INSTANCE;
    }

    private static final DateTimeFormat<LocalDate> getISO_LOCAL_DATE() {
        return (DateTimeFormat) ISO_LOCAL_DATE$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DateTimeFormat ISO_LOCAL_DATE_delegate$lambda$0() {
        return LocalDate.Formats.INSTANCE.getISO();
    }

    public static final String toIso8601String(LocalDate $this$toIso8601String) {
        Intrinsics.checkNotNullParameter($this$toIso8601String, "<this>");
        return getISO_LOCAL_DATE().format($this$toIso8601String);
    }

    public static final String toIso8601String(YearMonth $this$toIso8601String) {
        Intrinsics.checkNotNullParameter($this$toIso8601String, "<this>");
        return getISO_YEAR_MONTH().format(YearMonthKt.atStartOfMonth($this$toIso8601String));
    }

    public static final String toIso8601String(Year $this$toIso8601String) {
        Intrinsics.checkNotNullParameter($this$toIso8601String, "<this>");
        return getISO_YEAR().format(YearMonthKt.atStartOfMonth(YearKt.atMonth($this$toIso8601String, 1)));
    }

    public static final LocalDate fromIso8601LocalDate(String $this$fromIso8601LocalDate) {
        Intrinsics.checkNotNullParameter($this$fromIso8601LocalDate, "<this>");
        return LocalDate.Companion.parse($this$fromIso8601LocalDate, getISO_LOCAL_DATE());
    }

    public static final YearMonth fromIso8601YearMonth(String $this$fromIso8601YearMonth) {
        Intrinsics.checkNotNullParameter($this$fromIso8601YearMonth, "<this>");
        return BiliCalendarExtensionsKt.getYearMonth(LocalDate.Companion.parse($this$fromIso8601YearMonth + "-01", getISO_LOCAL_DATE()));
    }

    public static final Year fromIso8601Year(String $this$fromIso8601Year) {
        Intrinsics.checkNotNullParameter($this$fromIso8601Year, "<this>");
        return new Year(LocalDate.Companion.parse($this$fromIso8601Year + "-01-01", getISO_LOCAL_DATE()).getYear());
    }
}