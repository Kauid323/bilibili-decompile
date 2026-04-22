package kntr.base.localization;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import j$.time.DayOfWeek;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.LocalTime;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DateTimeFormat.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\nHÖ\u0001R)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR/\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR/\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR/\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\u001c"}, d2 = {"Lkntr/base/localization/DefaultIMDateTimeFormat;", "Lkntr/base/localization/IMDateTimeFormat;", "<init>", "()V", "hourMinute", "Lkotlin/Function1;", "Lkotlinx/datetime/LocalTime;", "Lkotlin/ParameterName;", "name", "time", "", "today", "getToday", "()Lkotlin/jvm/functions/Function1;", "yesterday", "getYesterday", "thisWeek", "Lkotlinx/datetime/LocalDateTime;", "getThisWeek", "past", "getPast", "equals", "", "other", "", "hashCode", "", "toString", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DefaultIMDateTimeFormat implements IMDateTimeFormat {
    public static final DefaultIMDateTimeFormat INSTANCE = new DefaultIMDateTimeFormat();
    private static final Function1<LocalTime, String> hourMinute = new Function1() { // from class: kntr.base.localization.DefaultIMDateTimeFormat$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            String hourMinute$lambda$0;
            hourMinute$lambda$0 = DefaultIMDateTimeFormat.hourMinute$lambda$0((LocalTime) obj);
            return hourMinute$lambda$0;
        }
    };
    private static final Function1<LocalTime, String> today = hourMinute;
    private static final Function1<LocalTime, String> yesterday = new Function1() { // from class: kntr.base.localization.DefaultIMDateTimeFormat$$ExternalSyntheticLambda1
        public final Object invoke(Object obj) {
            String yesterday$lambda$0;
            yesterday$lambda$0 = DefaultIMDateTimeFormat.yesterday$lambda$0((LocalTime) obj);
            return yesterday$lambda$0;
        }
    };
    private static final Function1<LocalDateTime, String> thisWeek = new Function1() { // from class: kntr.base.localization.DefaultIMDateTimeFormat$$ExternalSyntheticLambda2
        public final Object invoke(Object obj) {
            String thisWeek$lambda$0;
            thisWeek$lambda$0 = DefaultIMDateTimeFormat.thisWeek$lambda$0((LocalDateTime) obj);
            return thisWeek$lambda$0;
        }
    };
    private static final Function1<LocalDateTime, String> past = new Function1() { // from class: kntr.base.localization.DefaultIMDateTimeFormat$$ExternalSyntheticLambda3
        public final Object invoke(Object obj) {
            String past$lambda$0;
            past$lambda$0 = DefaultIMDateTimeFormat.past$lambda$0((LocalDateTime) obj);
            return past$lambda$0;
        }
    };

    /* compiled from: DateTimeFormat.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DayOfWeek.values().length];
            try {
                iArr[DayOfWeek.MONDAY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DayOfWeek.TUESDAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[DayOfWeek.WEDNESDAY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[DayOfWeek.THURSDAY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[DayOfWeek.FRIDAY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[DayOfWeek.SATURDAY.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[DayOfWeek.SUNDAY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultIMDateTimeFormat) {
            DefaultIMDateTimeFormat defaultIMDateTimeFormat = (DefaultIMDateTimeFormat) obj;
            return true;
        }
        return false;
    }

    public int hashCode() {
        return -876726286;
    }

    public String toString() {
        return "DefaultIMDateTimeFormat";
    }

    private DefaultIMDateTimeFormat() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String hourMinute$lambda$0(LocalTime it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return DateTimeResource_androidKt.getDateTimeResource().getString(DateTimeStringID.HourMinute, StringsKt.padStart(String.valueOf(it.getHour()), 2, '0'), StringsKt.padStart(String.valueOf(it.getMinute()), 2, '0'));
    }

    @Override // kntr.base.localization.IMDateTimeFormat
    public Function1<LocalTime, String> getToday() {
        return today;
    }

    @Override // kntr.base.localization.IMDateTimeFormat
    public Function1<LocalTime, String> getYesterday() {
        return yesterday;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String yesterday$lambda$0(LocalTime it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return DateTimeResource_androidKt.getDateTimeResource().getString(DateTimeStringID.Yesterday, hourMinute.invoke(it));
    }

    @Override // kntr.base.localization.IMDateTimeFormat
    public Function1<LocalDateTime, String> getThisWeek() {
        return thisWeek;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String thisWeek$lambda$0(LocalDateTime it) {
        DateTimeStringID dayOfWeekResource;
        Intrinsics.checkNotNullParameter(it, "it");
        switch (WhenMappings.$EnumSwitchMapping$0[it.getDayOfWeek().ordinal()]) {
            case 1:
                dayOfWeekResource = DateTimeStringID.Monday;
                break;
            case 2:
                dayOfWeekResource = DateTimeStringID.Tuesday;
                break;
            case 3:
                dayOfWeekResource = DateTimeStringID.Wednesday;
                break;
            case 4:
                dayOfWeekResource = DateTimeStringID.Thursday;
                break;
            case 5:
                dayOfWeekResource = DateTimeStringID.Friday;
                break;
            case 6:
                dayOfWeekResource = DateTimeStringID.Saturday;
                break;
            case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                dayOfWeekResource = DateTimeStringID.Sunday;
                break;
            default:
                dayOfWeekResource = DateTimeStringID.Monday;
                break;
        }
        return DateTimeResource_androidKt.getDateTimeResource().getString(dayOfWeekResource, hourMinute.invoke(it.getTime()));
    }

    @Override // kntr.base.localization.IMDateTimeFormat
    public Function1<LocalDateTime, String> getPast() {
        return past;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String past$lambda$0(LocalDateTime it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return DateTimeResource_androidKt.getDateTimeResource().getString(DateTimeStringID.YearMonthDayTime, Integer.valueOf(it.getYear()), Integer.valueOf(it.getMonthNumber()), Integer.valueOf(it.getDayOfMonth()), StringsKt.padStart(String.valueOf(it.getHour()), 2, '0'), StringsKt.padStart(String.valueOf(it.getMinute()), 2, '0'));
    }
}