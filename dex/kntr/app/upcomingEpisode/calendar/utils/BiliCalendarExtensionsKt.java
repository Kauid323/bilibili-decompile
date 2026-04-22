package kntr.app.upcomingEpisode.calendar.utils;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import bili.resource.watching.Res;
import bili.resource.watching.String0_commonMainKt;
import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarPointType;
import j$.time.DayOfWeek;
import j$.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.calendar.model.Day;
import kntr.app.upcomingEpisode.calendar.model.DayPosition;
import kntr.app.upcomingEpisode.calendar.model.YearMonth;
import kntr.app.upcomingEpisode.calendar.model.YearMonthKt;
import kntr.app.upcomingEpisode.list.model.CalendarCard;
import kntr.app.upcomingEpisode.list.model.CardUiType;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;
import kotlinx.datetime.ClockKt;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.DayOfWeekKt;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.LocalDateJvmKt;
import kotlinx.datetime.MonthKt;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: BiliCalendarExtensions.kt */
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\r\u001a\u0014\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u0014\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u0014\u0010\u0015\u001a\u00020\r*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u0017\u001a\u00020\r*\u00060\u0018j\u0002`\u00192\n\u0010\u0016\u001a\u00060\u0018j\u0002`\u0019H\u0000\u001a\u001c\u0010\u000b\u001a\u00060\u0018j\u0002`\u0019*\u00060\u0018j\u0002`\u00192\u0006\u0010\u001a\u001a\u00020\rH\u0000\u001a\u0011\u0010\u001f\u001a\u00020 *\u00020\bH\u0001¢\u0006\u0002\u0010!\u001a\u0015\u0010\u001f\u001a\u00020 *\u00060\"j\u0002`#H\u0001¢\u0006\u0002\u0010$\u001a\u0015\u0010\u001f\u001a\u00020 *\u00060\u0018j\u0002`\u0019H\u0001¢\u0006\u0002\u0010%\u001a\u001d\u0010&\u001a\u0002H'\"\u0004\b\u0000\u0010'*\b\u0012\u0004\u0012\u0002H'0(H\u0000¢\u0006\u0002\u0010)\u001a\f\u0010*\u001a\u00020+*\u00020\u0001H\u0000\u001a\n\u0010,\u001a\u00020-*\u00020\u0001\u001a\n\u0010.\u001a\u00020-*\u00020\u0001\u001a\u0014\u0010/\u001a\u00020\u0001*\u00020-2\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u001e\u00100\u001a\b\u0012\u0004\u0012\u00020\u00010(*\u00020\u00012\f\b\u0002\u00101\u001a\u00060\u0018j\u0002`\u0019\u001a\n\u00102\u001a\u00020+*\u000203\u001a\n\u00104\u001a\u00020+*\u000203\u001a\n\u00105\u001a\u00020+*\u000203\u001a\n\u00106\u001a\u00020+*\u000207\u001a\n\u00108\u001a\u00020+*\u000207\"\u0015\u0010\u0007\u001a\u00020\b*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0018\u0010\u001b\u001a\u00020\b*\u00020\u001c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u00069"}, d2 = {"now", "Lkotlinx/datetime/LocalDate;", "Lkotlinx/datetime/LocalDate$Companion;", "clock", "Lkotlinx/datetime/Clock;", "timeZone", "Lkotlinx/datetime/TimeZone;", "yearMonth", "Lkntr/app/upcomingEpisode/calendar/model/YearMonth;", "getYearMonth", "(Lkotlinx/datetime/LocalDate;)Lkntr/app/upcomingEpisode/calendar/model/YearMonth;", "plusDays", "value", "", "minusDays", "plusMonths", "minusMonths", "plusYears", "minusYears", "plusWeeks", "minusWeeks", "weeksUntil", "other", "daysUntil", "Ljava/time/DayOfWeek;", "Lkotlinx/datetime/DayOfWeek;", "days", "positionYearMonth", "Lkntr/app/upcomingEpisode/calendar/model/Day;", "getPositionYearMonth", "(Lkntr/app/upcomingEpisode/calendar/model/Day;)Lkntr/app/upcomingEpisode/calendar/model/YearMonth;", "displayText", "", "(Lkntr/app/upcomingEpisode/calendar/model/YearMonth;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "Ljava/time/Month;", "Lkotlinx/datetime/Month;", "(Ljava/time/Month;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "(Ljava/time/DayOfWeek;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "mid", "T", "", "(Ljava/util/List;)Ljava/lang/Object;", "isNow", "", "toTimestampSeconds", "", "toEndOfDayTimestampSeconds", "toLocalDate", "datesOfWeek", "firstDayOfWeek", "isDefault", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarPointType;", "isRed", "isGray", "isHighlighted", "Lkntr/app/upcomingEpisode/list/model/CalendarCard;", "isVisible", "main_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BiliCalendarExtensionsKt {

    /* compiled from: BiliCalendarExtensions.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<DayOfWeek> entries$0 = EnumEntriesKt.enumEntries(DayOfWeek.values());
    }

    /* compiled from: BiliCalendarExtensions.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DayPosition.values().length];
            try {
                iArr[DayPosition.InDate.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DayPosition.MonthDate.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[DayPosition.OutDate.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ LocalDate now$default(LocalDate.Companion companion, Clock clock, TimeZone timeZone, int i, Object obj) {
        if ((i & 1) != 0) {
            clock = (Clock) Clock.System.INSTANCE;
        }
        if ((i & 2) != 0) {
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return now(companion, clock, timeZone);
    }

    public static final LocalDate now(LocalDate.Companion $this$now, Clock clock, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter($this$now, "<this>");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return ClockKt.todayIn(clock, timeZone);
    }

    public static final YearMonth getYearMonth(LocalDate $this$yearMonth) {
        Intrinsics.checkNotNullParameter($this$yearMonth, "<this>");
        return new YearMonth($this$yearMonth.getYear(), $this$yearMonth.getMonth());
    }

    public static final LocalDate plusDays(LocalDate $this$plusDays, int value) {
        Intrinsics.checkNotNullParameter($this$plusDays, "<this>");
        return LocalDateJvmKt.plus($this$plusDays, value, DateTimeUnit.Companion.getDAY());
    }

    public static final LocalDate minusDays(LocalDate $this$minusDays, int value) {
        Intrinsics.checkNotNullParameter($this$minusDays, "<this>");
        return LocalDateJvmKt.minus($this$minusDays, value, DateTimeUnit.Companion.getDAY());
    }

    public static final LocalDate plusMonths(LocalDate $this$plusMonths, int value) {
        Intrinsics.checkNotNullParameter($this$plusMonths, "<this>");
        return LocalDateJvmKt.plus($this$plusMonths, value, DateTimeUnit.Companion.getMONTH());
    }

    public static final LocalDate minusMonths(LocalDate $this$minusMonths, int value) {
        Intrinsics.checkNotNullParameter($this$minusMonths, "<this>");
        return LocalDateJvmKt.minus($this$minusMonths, value, DateTimeUnit.Companion.getMONTH());
    }

    public static final LocalDate plusYears(LocalDate $this$plusYears, int value) {
        Intrinsics.checkNotNullParameter($this$plusYears, "<this>");
        return LocalDateJvmKt.plus($this$plusYears, value, DateTimeUnit.Companion.getYEAR());
    }

    public static final LocalDate minusYears(LocalDate $this$minusYears, int value) {
        Intrinsics.checkNotNullParameter($this$minusYears, "<this>");
        return LocalDateJvmKt.minus($this$minusYears, value, DateTimeUnit.Companion.getYEAR());
    }

    public static final LocalDate plusWeeks(LocalDate $this$plusWeeks, int value) {
        Intrinsics.checkNotNullParameter($this$plusWeeks, "<this>");
        return LocalDateJvmKt.plus($this$plusWeeks, value, DateTimeUnit.Companion.getWEEK());
    }

    public static final LocalDate minusWeeks(LocalDate $this$minusWeeks, int value) {
        Intrinsics.checkNotNullParameter($this$minusWeeks, "<this>");
        return LocalDateJvmKt.minus($this$minusWeeks, value, DateTimeUnit.Companion.getWEEK());
    }

    public static final int weeksUntil(LocalDate $this$weeksUntil, LocalDate other) {
        Intrinsics.checkNotNullParameter($this$weeksUntil, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return LocalDateJvmKt.until($this$weeksUntil, other, DateTimeUnit.Companion.getWEEK());
    }

    public static final int daysUntil(DayOfWeek $this$daysUntil, DayOfWeek other) {
        Intrinsics.checkNotNullParameter($this$daysUntil, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return ((other.ordinal() - $this$daysUntil.ordinal()) + 7) % 7;
    }

    public static final DayOfWeek plusDays(DayOfWeek $this$plusDays, int days) {
        Intrinsics.checkNotNullParameter($this$plusDays, "<this>");
        int amount = days % 7;
        return (DayOfWeek) EntriesMappings.entries$0.get(($this$plusDays.ordinal() + (amount + 7)) % 7);
    }

    public static final YearMonth getPositionYearMonth(Day $this$positionYearMonth) {
        Intrinsics.checkNotNullParameter($this$positionYearMonth, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$positionYearMonth.getPosition().ordinal()]) {
            case 1:
                return YearMonthKt.plusMonths(getYearMonth($this$positionYearMonth.getDate()), 1);
            case 2:
                return getYearMonth($this$positionYearMonth.getDate());
            case 3:
                return YearMonthKt.minusMonths(getYearMonth($this$positionYearMonth.getDate()), 1);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final String displayText(YearMonth $this$displayText, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$displayText, "<this>");
        ComposerKt.sourceInformationMarkerStart($composer, -1099725827, "C(displayText)145@5104L13:BiliCalendarExtensions.kt#4u6as6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1099725827, $changed, -1, "kntr.app.upcomingEpisode.calendar.utils.displayText (BiliCalendarExtensions.kt:145)");
        }
        String str = $this$displayText.getYear() + "年" + displayText($this$displayText.getMonth(), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return str;
    }

    public static final String displayText(Month $this$displayText, Composer $composer, int $changed) {
        String stringResource;
        Intrinsics.checkNotNullParameter($this$displayText, "<this>");
        ComposerKt.sourceInformationMarkerStart($composer, -1295675104, "C(displayText):BiliCalendarExtensions.kt#4u6as6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1295675104, $changed, -1, "kntr.app.upcomingEpisode.calendar.utils.displayText (BiliCalendarExtensions.kt:149)");
        }
        switch (MonthKt.getNumber($this$displayText)) {
            case 1:
                $composer.startReplaceGroup(396743260);
                ComposerKt.sourceInformation($composer, "150@5214L60");
                stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_11(Res.string.INSTANCE), $composer, 0);
                $composer.endReplaceGroup();
                break;
            case 2:
                $composer.startReplaceGroup(396745628);
                ComposerKt.sourceInformation($composer, "151@5288L60");
                stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_12(Res.string.INSTANCE), $composer, 0);
                $composer.endReplaceGroup();
                break;
            case 3:
                $composer.startReplaceGroup(396747996);
                ComposerKt.sourceInformation($composer, "152@5362L60");
                stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_13(Res.string.INSTANCE), $composer, 0);
                $composer.endReplaceGroup();
                break;
            case 4:
                $composer.startReplaceGroup(396750364);
                ComposerKt.sourceInformation($composer, "153@5436L60");
                stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_14(Res.string.INSTANCE), $composer, 0);
                $composer.endReplaceGroup();
                break;
            case 5:
                $composer.startReplaceGroup(396752732);
                ComposerKt.sourceInformation($composer, "154@5510L60");
                stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_15(Res.string.INSTANCE), $composer, 0);
                $composer.endReplaceGroup();
                break;
            case 6:
                $composer.startReplaceGroup(396755100);
                ComposerKt.sourceInformation($composer, "155@5584L60");
                stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_16(Res.string.INSTANCE), $composer, 0);
                $composer.endReplaceGroup();
                break;
            case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                $composer.startReplaceGroup(396757468);
                ComposerKt.sourceInformation($composer, "156@5658L60");
                stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_17(Res.string.INSTANCE), $composer, 0);
                $composer.endReplaceGroup();
                break;
            case 8:
                $composer.startReplaceGroup(396759836);
                ComposerKt.sourceInformation($composer, "157@5732L60");
                stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_18(Res.string.INSTANCE), $composer, 0);
                $composer.endReplaceGroup();
                break;
            case ConstantsKt.SPACER_9 /* 9 */:
                $composer.startReplaceGroup(396762204);
                ComposerKt.sourceInformation($composer, "158@5806L60");
                stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_19(Res.string.INSTANCE), $composer, 0);
                $composer.endReplaceGroup();
                break;
            case 10:
                $composer.startReplaceGroup(396764604);
                ComposerKt.sourceInformation($composer, "159@5881L60");
                stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_20(Res.string.INSTANCE), $composer, 0);
                $composer.endReplaceGroup();
                break;
            case MediaAttrUtils.TYPE_MENU /* 11 */:
                $composer.startReplaceGroup(396767004);
                ComposerKt.sourceInformation($composer, "160@5956L60");
                stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_21(Res.string.INSTANCE), $composer, 0);
                $composer.endReplaceGroup();
                break;
            default:
                $composer.startReplaceGroup(396769468);
                ComposerKt.sourceInformation($composer, "161@6033L60");
                stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_22(Res.string.INSTANCE), $composer, 0);
                $composer.endReplaceGroup();
                break;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return stringResource;
    }

    public static final String displayText(DayOfWeek $this$displayText, Composer $composer, int $changed) {
        String stringResource;
        Intrinsics.checkNotNullParameter($this$displayText, "<this>");
        ComposerKt.sourceInformationMarkerStart($composer, -519166311, "C(displayText):BiliCalendarExtensions.kt#4u6as6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-519166311, $changed, -1, "kntr.app.upcomingEpisode.calendar.utils.displayText (BiliCalendarExtensions.kt:166)");
        }
        switch (DayOfWeekKt.getIsoDayNumber($this$displayText)) {
            case 1:
                $composer.startReplaceGroup(-702615851);
                ComposerKt.sourceInformation($composer, "167@6204L60");
                stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_23(Res.string.INSTANCE), $composer, 0);
                $composer.endReplaceGroup();
                break;
            case 2:
                $composer.startReplaceGroup(-702613483);
                ComposerKt.sourceInformation($composer, "168@6278L60");
                stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_24(Res.string.INSTANCE), $composer, 0);
                $composer.endReplaceGroup();
                break;
            case 3:
                $composer.startReplaceGroup(-702611115);
                ComposerKt.sourceInformation($composer, "169@6352L60");
                stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_25(Res.string.INSTANCE), $composer, 0);
                $composer.endReplaceGroup();
                break;
            case 4:
                $composer.startReplaceGroup(-702608747);
                ComposerKt.sourceInformation($composer, "170@6426L60");
                stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_26(Res.string.INSTANCE), $composer, 0);
                $composer.endReplaceGroup();
                break;
            case 5:
                $composer.startReplaceGroup(-702606379);
                ComposerKt.sourceInformation($composer, "171@6500L60");
                stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_27(Res.string.INSTANCE), $composer, 0);
                $composer.endReplaceGroup();
                break;
            case 6:
                $composer.startReplaceGroup(-702604011);
                ComposerKt.sourceInformation($composer, "172@6574L60");
                stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_28(Res.string.INSTANCE), $composer, 0);
                $composer.endReplaceGroup();
                break;
            default:
                $composer.startReplaceGroup(-702601547);
                ComposerKt.sourceInformation($composer, "173@6651L60");
                stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_29(Res.string.INSTANCE), $composer, 0);
                $composer.endReplaceGroup();
                break;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return stringResource;
    }

    public static final <T> T mid(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(list.size() / 2);
    }

    public static final boolean isNow(LocalDate $this$isNow) {
        Intrinsics.checkNotNullParameter($this$isNow, "<this>");
        return Intrinsics.areEqual($this$isNow, now$default(LocalDate.Companion, null, null, 3, null));
    }

    public static final long toTimestampSeconds(LocalDate $this$toTimestampSeconds) {
        Intrinsics.checkNotNullParameter($this$toTimestampSeconds, "<this>");
        return TimeZoneKt.atStartOfDayIn($this$toTimestampSeconds, TimeZone.Companion.currentSystemDefault()).getEpochSeconds();
    }

    public static final long toEndOfDayTimestampSeconds(LocalDate $this$toEndOfDayTimestampSeconds) {
        Intrinsics.checkNotNullParameter($this$toEndOfDayTimestampSeconds, "<this>");
        return toTimestampSeconds(plusDays($this$toEndOfDayTimestampSeconds, 1)) - 1;
    }

    public static /* synthetic */ LocalDate toLocalDate$default(long j, TimeZone timeZone, int i, Object obj) {
        if ((i & 1) != 0) {
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return toLocalDate(j, timeZone);
    }

    public static final LocalDate toLocalDate(long $this$toLocalDate, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return TimeZoneKt.toLocalDateTime(Instant.Companion.fromEpochSeconds$default(Instant.Companion, $this$toLocalDate, 0L, 2, (Object) null), timeZone).getDate();
    }

    public static /* synthetic */ List datesOfWeek$default(LocalDate localDate, DayOfWeek dayOfWeek, int i, Object obj) {
        if ((i & 1) != 0) {
            dayOfWeek = BiliCalendarUtilsKt.firstDayOfWeekFromLocale$default(null, 1, null);
        }
        return datesOfWeek(localDate, dayOfWeek);
    }

    public static final List<LocalDate> datesOfWeek(LocalDate $this$datesOfWeek, DayOfWeek firstDayOfWeek) {
        Intrinsics.checkNotNullParameter($this$datesOfWeek, "<this>");
        Intrinsics.checkNotNullParameter(firstDayOfWeek, "firstDayOfWeek");
        int daysOffset = (($this$datesOfWeek.getDayOfWeek().ordinal() - firstDayOfWeek.ordinal()) + 7) % 7;
        LocalDate firstDate = minusDays($this$datesOfWeek, daysOffset);
        ArrayList arrayList = new ArrayList(7);
        for (int i = 0; i < 7; i++) {
            int index = i;
            arrayList.add(plusDays(firstDate, index));
        }
        return arrayList;
    }

    public static final boolean isDefault(KCalendarPointType $this$isDefault) {
        Intrinsics.checkNotNullParameter($this$isDefault, "<this>");
        return Intrinsics.areEqual($this$isDefault, KCalendarPointType.CALENDAR_POINT_TYPE_DEFAULT.INSTANCE);
    }

    public static final boolean isRed(KCalendarPointType $this$isRed) {
        Intrinsics.checkNotNullParameter($this$isRed, "<this>");
        return Intrinsics.areEqual($this$isRed, KCalendarPointType.CALENDAR_POINT_TYPE_RED.INSTANCE);
    }

    public static final boolean isGray(KCalendarPointType $this$isGray) {
        Intrinsics.checkNotNullParameter($this$isGray, "<this>");
        return Intrinsics.areEqual($this$isGray, KCalendarPointType.CALENDAR_POINT_TYPE_GRAY.INSTANCE);
    }

    public static final boolean isHighlighted(CalendarCard $this$isHighlighted) {
        Intrinsics.checkNotNullParameter($this$isHighlighted, "<this>");
        return $this$isHighlighted.getCardUiType().getValue() == CardUiType.TYPE_HIGHLIGHT;
    }

    public static final boolean isVisible(CalendarCard $this$isVisible) {
        Intrinsics.checkNotNullParameter($this$isVisible, "<this>");
        return ((Boolean) $this$isVisible.getShouldCardShow().getValue()).booleanValue();
    }
}