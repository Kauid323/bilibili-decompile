package kntr.app.upcomingEpisode.calendar.utils;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.runtime.snapshots.SnapshotStateSet;
import androidx.compose.ui.text.intl.Locale;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import bili.resource.watching.Res;
import bili.resource.watching.String0_commonMainKt;
import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarPointType;
import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarTimeRange;
import j$.time.DayOfWeek;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.base.handler.CalendarType;
import kntr.app.upcomingEpisode.calendar.model.Day;
import kntr.app.upcomingEpisode.calendar.model.Month;
import kntr.app.upcomingEpisode.calendar.model.Week;
import kntr.app.upcomingEpisode.calendar.model.Year;
import kntr.app.upcomingEpisode.calendar.model.YearMonth;
import kntr.app.upcomingEpisode.calendar.model.YearMonthKt;
import kntr.app.upcomingEpisode.list.model.CalendarCard;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.DayOfWeekKt;
import kotlinx.datetime.LocalDate;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: BiliCalendarUtils.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a-\u0010\u0002\u001a\u00020\u0003\"\u000e\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u0002H\u00042\u0006\u0010\u0007\u001a\u0002H\u0004H\u0000¢\u0006\u0002\u0010\b\u001a\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r\u001a\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a-\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001aP\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u001d2#\b\u0002\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00030\u001fH\u0007¢\u0006\u0002\u0010$\u001aC\u0010%\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020(0'2\u0018\u0010)\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*0'H\u0007¢\u0006\u0002\u0010,\u001a<\u0010-\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020(0'2\u0018\u0010)\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*0'\u001a\u0015\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u000fH\u0007¢\u0006\u0002\u00100\u001a\u0015\u00101\u001a\u00020\u00012\u0006\u00102\u001a\u00020\nH\u0007¢\u0006\u0002\u00103\u001a\u001e\u00104\u001a\f\u0012\b\u0012\u000606j\u0002`7052\f\b\u0002\u00108\u001a\u000606j\u0002`7\u001a\u0014\u00109\u001a\u000606j\u0002`72\b\b\u0002\u0010:\u001a\u00020;\u001a*\u0010<\u001a\n\u0012\u0004\u0012\u00020=\u0018\u0001052\u0012\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=05052\u0006\u0010\u0014\u001a\u00020\u0015\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0015\u0010?\u001a\u00020@*\u00020@8F¢\u0006\u0006\u001a\u0004\bA\u0010B\"\u0015\u0010C\u001a\u00020@*\u00020@8F¢\u0006\u0006\u001a\u0004\bD\u0010B¨\u0006E²\u0006%\u0010F\u001a\u001d\u0012\u0013\u0012\u00110 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00030\u001fX\u008a\u0084\u0002"}, d2 = {"TAG", "", "checkRange", "", "T", "", "start", "end", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)V", "rememberFirstVisibleMonthAfterScroll", "Lkntr/app/upcomingEpisode/calendar/model/Month;", "monthState", "Lkntr/app/upcomingEpisode/calendar/utils/BiliMonthCalendarState;", "(Lkntr/app/upcomingEpisode/calendar/utils/BiliMonthCalendarState;Landroidx/compose/runtime/Composer;I)Lkntr/app/upcomingEpisode/calendar/model/Month;", "rememberFirstVisibleWeekAfterScroll", "Lkntr/app/upcomingEpisode/calendar/model/Week;", "weekState", "Lkntr/app/upcomingEpisode/calendar/utils/BiliWeekCalendarState;", "(Lkntr/app/upcomingEpisode/calendar/utils/BiliWeekCalendarState;Landroidx/compose/runtime/Composer;I)Lkntr/app/upcomingEpisode/calendar/model/Week;", "SyncWeekAndMonthState", "selection", "Lkotlinx/datetime/LocalDate;", "calendarType", "Lkntr/app/upcomingEpisode/base/handler/CalendarType;", "(Lkntr/app/upcomingEpisode/calendar/utils/BiliWeekCalendarState;Lkntr/app/upcomingEpisode/calendar/utils/BiliMonthCalendarState;Lkotlinx/datetime/LocalDate;Lkntr/app/upcomingEpisode/base/handler/CalendarType;Landroidx/compose/runtime/Composer;I)V", "RequestWatchCalendarAfterMonthScroll", "hasRequestWatchCalendar", "", "pageSet", "Landroidx/compose/runtime/snapshots/SnapshotStateSet;", "onMonthScroll", "Lkotlin/Function1;", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarTimeRange;", "Lkotlin/ParameterName;", "name", "timeRange", "(Lkntr/app/upcomingEpisode/calendar/utils/BiliMonthCalendarState;ZLandroidx/compose/runtime/snapshots/SnapshotStateSet;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "CheckPointTypeWhenResume", "pointTypeMap", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarPointType;", "cardListMap", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkntr/app/upcomingEpisode/list/model/CalendarCard;", "(Lkotlinx/datetime/LocalDate;Landroidx/compose/runtime/snapshots/SnapshotStateMap;Landroidx/compose/runtime/snapshots/SnapshotStateMap;Landroidx/compose/runtime/Composer;I)V", "checkPointType", "getWeekHeaderTitle", "week", "(Lkntr/app/upcomingEpisode/calendar/model/Week;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "getMonthHeaderTitle", "month", "(Lkntr/app/upcomingEpisode/calendar/model/Month;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "daysOfWeek", "", "Ljava/time/DayOfWeek;", "Lkotlinx/datetime/DayOfWeek;", "firstDayOfWeek", "firstDayOfWeekFromLocale", "locale", "Landroidx/compose/ui/text/intl/Locale;", "weekOfSelection", "Lkntr/app/upcomingEpisode/calendar/model/Day;", "weeks", "next", "Lkntr/app/upcomingEpisode/calendar/model/YearMonth;", "getNext", "(Lkntr/app/upcomingEpisode/calendar/model/YearMonth;)Lkntr/app/upcomingEpisode/calendar/model/YearMonth;", "previous", "getPrevious", "main_debug", "latestOnMonthScroll"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BiliCalendarUtilsKt {
    private static final String TAG = "BiliCalendarUtils";

    /* compiled from: BiliCalendarUtils.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<DayOfWeek> entries$0 = EnumEntriesKt.enumEntries(DayOfWeek.values());
    }

    public static final Unit CheckPointTypeWhenResume$lambda$1(LocalDate localDate, SnapshotStateMap snapshotStateMap, SnapshotStateMap snapshotStateMap2, int i, Composer composer, int i2) {
        CheckPointTypeWhenResume(localDate, snapshotStateMap, snapshotStateMap2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit RequestWatchCalendarAfterMonthScroll$lambda$4(BiliMonthCalendarState biliMonthCalendarState, boolean z, SnapshotStateSet snapshotStateSet, Function1 function1, int i, int i2, Composer composer, int i3) {
        RequestWatchCalendarAfterMonthScroll(biliMonthCalendarState, z, snapshotStateSet, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit SyncWeekAndMonthState$lambda$2(BiliWeekCalendarState biliWeekCalendarState, BiliMonthCalendarState biliMonthCalendarState, LocalDate localDate, CalendarType calendarType, int i, Composer composer, int i2) {
        SyncWeekAndMonthState(biliWeekCalendarState, biliMonthCalendarState, localDate, calendarType, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final <T extends Comparable<? super T>> void checkRange(T t, T t2) {
        Intrinsics.checkNotNullParameter(t, "start");
        Intrinsics.checkNotNullParameter(t2, "end");
        if (!(t2.compareTo(t) >= 0)) {
            throw new IllegalStateException(("start: " + t + " is greater than end: " + t2).toString());
        }
    }

    public static final Month rememberFirstVisibleMonthAfterScroll(BiliMonthCalendarState monthState, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(monthState, "monthState");
        ComposerKt.sourceInformationMarkerStart($composer, -1099366892, "C(rememberFirstVisibleMonthAfterScroll)N(monthState)59@2307L69,60@2408L330,60@2381L357:BiliCalendarUtils.kt#4u6as6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1099366892, $changed, -1, "kntr.app.upcomingEpisode.calendar.utils.rememberFirstVisibleMonthAfterScroll (BiliCalendarUtils.kt:58)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 70375161, "CC(remember):BiliCalendarUtils.kt#9igjgp");
        boolean invalid$iv = ((($changed & 14) ^ 6) > 4 && $composer.changed(monthState)) || ($changed & 6) == 4;
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = SnapshotStateKt.mutableStateOf$default(monthState.getFirstVisibleMonth(), (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        MutableState visibleMonth = (MutableState) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 70378654, "CC(remember):BiliCalendarUtils.kt#9igjgp");
        boolean invalid$iv2 = $composer.changed(visibleMonth) | (((($changed & 14) ^ 6) > 4 && $composer.changed(monthState)) || ($changed & 6) == 4);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = (Function2) new BiliCalendarUtilsKt$rememberFirstVisibleMonthAfterScroll$1$1(monthState, visibleMonth, null);
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(monthState, (Function2) it$iv2, $composer, $changed & 14);
        Month month = (Month) visibleMonth.getValue();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return month;
    }

    public static final Week rememberFirstVisibleWeekAfterScroll(BiliWeekCalendarState weekState, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(weekState, "weekState");
        ComposerKt.sourceInformationMarkerStart($composer, -1839552202, "C(rememberFirstVisibleWeekAfterScroll)N(weekState)77@2996L66,78@3093L323,78@3067L349:BiliCalendarUtils.kt#4u6as6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1839552202, $changed, -1, "kntr.app.upcomingEpisode.calendar.utils.rememberFirstVisibleWeekAfterScroll (BiliCalendarUtils.kt:76)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1716863224, "CC(remember):BiliCalendarUtils.kt#9igjgp");
        boolean invalid$iv = ((($changed & 14) ^ 6) > 4 && $composer.changed(weekState)) || ($changed & 6) == 4;
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = SnapshotStateKt.mutableStateOf$default(weekState.getFirstVisibleWeek(), (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        MutableState visibleWeek = (MutableState) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 1716866585, "CC(remember):BiliCalendarUtils.kt#9igjgp");
        boolean invalid$iv2 = $composer.changed(visibleWeek) | (((($changed & 14) ^ 6) > 4 && $composer.changed(weekState)) || ($changed & 6) == 4);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = (Function2) new BiliCalendarUtilsKt$rememberFirstVisibleWeekAfterScroll$1$1(weekState, visibleWeek, null);
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(weekState, (Function2) it$iv2, $composer, $changed & 14);
        Week week = (Week) visibleWeek.getValue();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return week;
    }

    public static final void SyncWeekAndMonthState(final BiliWeekCalendarState weekState, final BiliMonthCalendarState monthState, final LocalDate selection, final CalendarType calendarType, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(weekState, "weekState");
        Intrinsics.checkNotNullParameter(monthState, "monthState");
        Intrinsics.checkNotNullParameter(selection, "selection");
        Intrinsics.checkNotNullParameter(calendarType, "calendarType");
        Composer $composer2 = $composer.startRestartGroup(-360073473);
        ComposerKt.sourceInformation($composer2, "C(SyncWeekAndMonthState)N(weekState,monthState,selection,calendarType)97@3669L34,98@3734L785,98@3708L811,117@4551L883,117@4524L910:BiliCalendarUtils.kt#4u6as6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(weekState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(monthState) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(selection) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(calendarType.ordinal()) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-360073473, $dirty2, -1, "kntr.app.upcomingEpisode.calendar.utils.SyncWeekAndMonthState (BiliCalendarUtils.kt:96)");
            }
            State latestIsWeekMode = SnapshotStateKt.rememberUpdatedState(calendarType, $composer2, ($dirty2 >> 9) & 14);
            ComposerKt.sourceInformationMarkerStart($composer2, 1861752496, "CC(remember):BiliCalendarUtils.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 14) == 4) | $composer2.changed(latestIsWeekMode) | (($dirty2 & 112) == 32);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new BiliCalendarUtilsKt$SyncWeekAndMonthState$1$1(weekState, latestIsWeekMode, monthState, null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(weekState, (Function2) it$iv, $composer2, $dirty2 & 14);
            ComposerKt.sourceInformationMarkerStart($composer2, 1861778738, "CC(remember):BiliCalendarUtils.kt#9igjgp");
            boolean invalid$iv2 = (($dirty2 & 112) == 32) | $composer2.changed(latestIsWeekMode) | $composer2.changedInstance(selection) | (($dirty2 & 14) == 4);
            Object value$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || value$iv2 == Composer.Companion.getEmpty()) {
                value$iv2 = new BiliCalendarUtilsKt$SyncWeekAndMonthState$2$1(monthState, latestIsWeekMode, selection, weekState, null);
                $composer2.updateRememberedValue(value$iv2);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(monthState, (Function2) value$iv2, $composer2, ($dirty2 >> 3) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.upcomingEpisode.calendar.utils.BiliCalendarUtilsKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit SyncWeekAndMonthState$lambda$2;
                    SyncWeekAndMonthState$lambda$2 = BiliCalendarUtilsKt.SyncWeekAndMonthState$lambda$2(BiliWeekCalendarState.this, monthState, selection, calendarType, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return SyncWeekAndMonthState$lambda$2;
                }
            });
        }
    }

    public static final Unit RequestWatchCalendarAfterMonthScroll$lambda$0$0(KCalendarTimeRange it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v5 */
    public static final void RequestWatchCalendarAfterMonthScroll(final BiliMonthCalendarState monthState, final boolean hasRequestWatchCalendar, final SnapshotStateSet<LocalDate> snapshotStateSet, Function1<? super KCalendarTimeRange, Unit> function1, Composer $composer, final int $changed, final int i) {
        Function1 function12;
        Function1 onMonthScroll;
        Intrinsics.checkNotNullParameter(monthState, "monthState");
        Intrinsics.checkNotNullParameter(snapshotStateSet, "pageSet");
        Composer $composer2 = $composer.startRestartGroup(-287659711);
        ComposerKt.sourceInformation($composer2, "C(RequestWatchCalendarAfterMonthScroll)N(monthState,hasRequestWatchCalendar,pageSet,onMonthScroll)145@5690L2,147@5721L69,149@5942L45,150@6012L29,151@6073L35,152@6140L1471,152@6113L1498:BiliCalendarUtils.kt#4u6as6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(monthState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(hasRequestWatchCalendar) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(snapshotStateSet) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            function12 = function1;
        } else if (($changed & 3072) == 0) {
            function12 = function1;
            $dirty |= $composer2.changedInstance(function12) ? 2048 : 1024;
        } else {
            function12 = function1;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            onMonthScroll = function12;
        } else {
            if (i2 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -1563068189, "CC(remember):BiliCalendarUtils.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.upcomingEpisode.calendar.utils.BiliCalendarUtilsKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            Unit RequestWatchCalendarAfterMonthScroll$lambda$0$0;
                            RequestWatchCalendarAfterMonthScroll$lambda$0$0 = BiliCalendarUtilsKt.RequestWatchCalendarAfterMonthScroll$lambda$0$0((KCalendarTimeRange) obj);
                            return RequestWatchCalendarAfterMonthScroll$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function1 onMonthScroll2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onMonthScroll = onMonthScroll2;
            } else {
                onMonthScroll = function12;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-287659711, $dirty2, -1, "kntr.app.upcomingEpisode.calendar.utils.RequestWatchCalendarAfterMonthScroll (BiliCalendarUtils.kt:146)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1563067130, "CC(remember):BiliCalendarUtils.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 14) == 4;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default(monthState.getFirstVisibleMonth(), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            MutableState visibleMonth = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            State latestHasRequestWatchCalendar = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(hasRequestWatchCalendar), $composer2, ($dirty2 >> 3) & 14);
            State latestPageSet = SnapshotStateKt.rememberUpdatedState(snapshotStateSet, $composer2, ($dirty2 >> 6) & 14);
            State latestOnMonthScroll$delegate = SnapshotStateKt.rememberUpdatedState(onMonthScroll, $composer2, ($dirty2 >> 9) & 14);
            ComposerKt.sourceInformationMarkerStart($composer2, -1563052320, "CC(remember):BiliCalendarUtils.kt#9igjgp");
            boolean invalid$iv2 = (($dirty2 & 14) == 4) | $composer2.changed(visibleMonth) | $composer2.changed(latestHasRequestWatchCalendar) | $composer2.changed(latestPageSet) | $composer2.changed(latestOnMonthScroll$delegate);
            Object value$iv3 = $composer2.rememberedValue();
            if (invalid$iv2 || value$iv3 == Composer.Companion.getEmpty()) {
                value$iv3 = new BiliCalendarUtilsKt$RequestWatchCalendarAfterMonthScroll$2$1(monthState, visibleMonth, latestHasRequestWatchCalendar, latestPageSet, latestOnMonthScroll$delegate, null);
                $composer2.updateRememberedValue(value$iv3);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(monthState, (Function2) value$iv3, $composer2, $dirty2 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Function1 function13 = onMonthScroll;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.upcomingEpisode.calendar.utils.BiliCalendarUtilsKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit RequestWatchCalendarAfterMonthScroll$lambda$4;
                    RequestWatchCalendarAfterMonthScroll$lambda$4 = BiliCalendarUtilsKt.RequestWatchCalendarAfterMonthScroll$lambda$4(BiliMonthCalendarState.this, hasRequestWatchCalendar, snapshotStateSet, function13, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RequestWatchCalendarAfterMonthScroll$lambda$4;
                }
            });
        }
    }

    public static final Function1<KCalendarTimeRange, Unit> RequestWatchCalendarAfterMonthScroll$lambda$2(State<? extends Function1<? super KCalendarTimeRange, Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function1) thisObj$iv;
    }

    public static final void CheckPointTypeWhenResume(final LocalDate selection, final SnapshotStateMap<LocalDate, KCalendarPointType> snapshotStateMap, final SnapshotStateMap<LocalDate, SnapshotStateList<CalendarCard>> snapshotStateMap2, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(selection, "selection");
        Intrinsics.checkNotNullParameter(snapshotStateMap, "pointTypeMap");
        Intrinsics.checkNotNullParameter(snapshotStateMap2, "cardListMap");
        Composer $composer2 = $composer.startRestartGroup(116823305);
        ComposerKt.sourceInformation($composer2, "C(CheckPointTypeWhenResume)N(selection,pointTypeMap,cardListMap)193@7873L7,194@7938L249,194@7885L302:BiliCalendarUtils.kt#4u6as6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(selection) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(snapshotStateMap) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(snapshotStateMap2) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(116823305, $dirty2, -1, "kntr.app.upcomingEpisode.calendar.utils.CheckPointTypeWhenResume (BiliCalendarUtils.kt:192)");
            }
            CompositionLocal this_$iv = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LifecycleOwner lifecycle = (LifecycleOwner) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 598056610, "CC(remember):BiliCalendarUtils.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(lifecycle) | $composer2.changedInstance(selection) | (($dirty2 & 112) == 32) | (($dirty2 & 896) == 256);
            Object value$iv = $composer2.rememberedValue();
            if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                value$iv = new BiliCalendarUtilsKt$CheckPointTypeWhenResume$1$1(lifecycle, selection, snapshotStateMap, snapshotStateMap2, null);
                $composer2.updateRememberedValue(value$iv);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(selection, snapshotStateMap, snapshotStateMap2, (Function2) value$iv, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.upcomingEpisode.calendar.utils.BiliCalendarUtilsKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit CheckPointTypeWhenResume$lambda$1;
                    CheckPointTypeWhenResume$lambda$1 = BiliCalendarUtilsKt.CheckPointTypeWhenResume$lambda$1(selection, snapshotStateMap, snapshotStateMap2, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return CheckPointTypeWhenResume$lambda$1;
                }
            });
        }
    }

    public static final void checkPointType(LocalDate selection, SnapshotStateMap<LocalDate, KCalendarPointType> snapshotStateMap, SnapshotStateMap<LocalDate, SnapshotStateList<CalendarCard>> snapshotStateMap2) {
        Boolean hasVisibleCards;
        CalendarCard card;
        boolean z;
        Intrinsics.checkNotNullParameter(selection, "selection");
        Intrinsics.checkNotNullParameter(snapshotStateMap, "pointTypeMap");
        Intrinsics.checkNotNullParameter(snapshotStateMap2, "cardListMap");
        KCalendarPointType currentPointType = (KCalendarPointType) snapshotStateMap.get(selection);
        Iterable iterable = (SnapshotStateList) snapshotStateMap2.get(selection);
        Boolean hasUnreadCards = null;
        boolean z2 = true;
        if (iterable == null) {
            hasVisibleCards = null;
        } else {
            Iterable $this$any$iv = iterable;
            if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                Iterator it = $this$any$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object element$iv = it.next();
                        if (BiliCalendarExtensionsKt.isVisible((CalendarCard) element$iv)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
            } else {
                z = false;
            }
            hasVisibleCards = Boolean.valueOf(z);
        }
        if (Intrinsics.areEqual(hasVisibleCards, false)) {
            ((Map) snapshotStateMap).put(selection, KCalendarPointType.CALENDAR_POINT_TYPE_DEFAULT.INSTANCE);
            KLog_androidKt.getKLog().i(TAG, "checkPointType. currentCardList isEmpty，change point type to default");
            return;
        }
        if (currentPointType != null && BiliCalendarExtensionsKt.isRed(currentPointType)) {
            if (iterable != null) {
                Iterable $this$any$iv2 = iterable;
                if (!($this$any$iv2 instanceof Collection) || !((Collection) $this$any$iv2).isEmpty()) {
                    Iterator it2 = $this$any$iv2.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            Object element$iv2 = it2.next();
                            CalendarCard card2 = (CalendarCard) element$iv2;
                            if (BiliCalendarExtensionsKt.isHighlighted(card2) && BiliCalendarExtensionsKt.isVisible(card2)) {
                                card = 1;
                                continue;
                            } else {
                                card = null;
                                continue;
                            }
                            if (card != null) {
                                break;
                            }
                        } else {
                            z2 = false;
                            break;
                        }
                    }
                } else {
                    z2 = false;
                }
                hasUnreadCards = Boolean.valueOf(z2);
            }
            if (Intrinsics.areEqual(hasUnreadCards, false)) {
                ((Map) snapshotStateMap).put(selection, KCalendarPointType.CALENDAR_POINT_TYPE_GRAY.INSTANCE);
                KLog_androidKt.getKLog().i(TAG, "checkPointType. Every card is read, change point type to gray");
            }
        }
    }

    public static final String getWeekHeaderTitle(Week week, Composer $composer, int $changed) {
        String str;
        Intrinsics.checkNotNullParameter(week, "week");
        ComposerKt.sourceInformationMarkerStart($composer, 339223633, "C(getWeekHeaderTitle)N(week):BiliCalendarUtils.kt#4u6as6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(339223633, $changed, -1, "kntr.app.upcomingEpisode.calendar.utils.getWeekHeaderTitle (BiliCalendarUtils.kt:236)");
        }
        LocalDate midDate = week.getDays().get(3).getDate();
        int currentYear = Year.Companion.now$default(Year.Companion, null, null, 3, null).getYear$main_debug();
        int midDateYear = midDate.getYear();
        if (currentYear == midDateYear) {
            $composer.startReplaceGroup(-246559168);
            ComposerKt.sourceInformation($composer, "242@9553L59,242@9637L13");
            str = StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_1(Res.string.INSTANCE), $composer, 0) + " · " + BiliCalendarExtensionsKt.displayText(midDate.getMonth(), $composer, 0);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(-246440996);
            ComposerKt.sourceInformation($composer, "244@9672L59,244@9760L13");
            str = StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_1(Res.string.INSTANCE), $composer, 0) + " · " + BiliCalendarExtensionsKt.displayText(BiliCalendarExtensionsKt.getYearMonth(midDate), $composer, 0);
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return str;
    }

    public static final String getMonthHeaderTitle(Month month, Composer $composer, int $changed) {
        String str;
        Intrinsics.checkNotNullParameter(month, "month");
        ComposerKt.sourceInformationMarkerStart($composer, -968371629, "C(getMonthHeaderTitle)N(month):BiliCalendarUtils.kt#4u6as6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-968371629, $changed, -1, "kntr.app.upcomingEpisode.calendar.utils.getMonthHeaderTitle (BiliCalendarUtils.kt:249)");
        }
        int currentYear = Year.Companion.now$default(Year.Companion, null, null, 3, null).getYear$main_debug();
        if (currentYear == month.getYearMonth().getYear()) {
            $composer.startReplaceGroup(536305046);
            ComposerKt.sourceInformation($composer, "253@9980L59,253@10072L13");
            str = StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_1(Res.string.INSTANCE), $composer, 0) + " · " + BiliCalendarExtensionsKt.displayText(month.getYearMonth().getMonth(), $composer, 0);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(536430844);
            ComposerKt.sourceInformation($composer, "255@10107L59,255@10193L13");
            str = StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_1(Res.string.INSTANCE), $composer, 0) + " · " + BiliCalendarExtensionsKt.displayText(month.getYearMonth(), $composer, 0);
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return str;
    }

    public static /* synthetic */ List daysOfWeek$default(DayOfWeek dayOfWeek, int i, Object obj) {
        if ((i & 1) != 0) {
            dayOfWeek = firstDayOfWeekFromLocale$default(null, 1, null);
        }
        return daysOfWeek(dayOfWeek);
    }

    public static final List<DayOfWeek> daysOfWeek(DayOfWeek firstDayOfWeek) {
        Intrinsics.checkNotNullParameter(firstDayOfWeek, "firstDayOfWeek");
        int pivot = 7 - firstDayOfWeek.ordinal();
        List list = EntriesMappings.entries$0;
        return CollectionsKt.plus(CollectionsKt.takeLast(list, pivot), CollectionsKt.dropLast(list, pivot));
    }

    public static /* synthetic */ DayOfWeek firstDayOfWeekFromLocale$default(Locale locale, int i, Object obj) {
        if ((i & 1) != 0) {
            locale = Locale.Companion.getCurrent();
        }
        return firstDayOfWeekFromLocale(locale);
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x00a0, code lost:
        if (r0.equals("AF") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x00aa, code lost:
        if (r0.equals("AE") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:?, code lost:
        return kotlinx.datetime.DayOfWeekKt.DayOfWeek(7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:?, code lost:
        return kotlinx.datetime.DayOfWeekKt.DayOfWeek(6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0025, code lost:
        if (r0.equals("ZA") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x002e, code lost:
        if (r0.equals("US") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0037, code lost:
        if (r0.equals("TW") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0040, code lost:
        if (r0.equals("SA") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0049, code lost:
        if (r0.equals("PH") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0052, code lost:
        if (r0.equals("MX") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x005b, code lost:
        if (r0.equals("JP") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0064, code lost:
        if (r0.equals("IR") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x006d, code lost:
        if (r0.equals("IN") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0076, code lost:
        if (r0.equals("EG") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x007f, code lost:
        if (r0.equals("DZ") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0088, code lost:
        if (r0.equals("CA") != false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0091, code lost:
        if (r0.equals("BR") == false) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final DayOfWeek firstDayOfWeekFromLocale(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String countryCode = locale.getRegion().toUpperCase(java.util.Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(countryCode, "toUpperCase(...)");
        switch (countryCode.hashCode()) {
            case 2084:
                break;
            case 2085:
                break;
            case 2128:
                break;
            case 2142:
                break;
            case 2198:
                break;
            case 2210:
                break;
            case 2341:
                break;
            case 2345:
                break;
            case 2374:
                break;
            case 2475:
                break;
            case 2552:
                break;
            case 2638:
                break;
            case 2691:
                break;
            case 2718:
                break;
            case 2855:
                break;
            default:
                return DayOfWeekKt.DayOfWeek(1);
        }
    }

    public static final List<Day> weekOfSelection(List<? extends List<Day>> list, LocalDate selection) {
        Object obj;
        boolean z;
        LocalDate date;
        Intrinsics.checkNotNullParameter(list, "weeks");
        Intrinsics.checkNotNullParameter(selection, "selection");
        List<? extends List<Day>> $this$firstOrNull$iv = list;
        Iterator<T> it = $this$firstOrNull$iv.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object element$iv = it.next();
            List it2 = (List) element$iv;
            Day day = (Day) CollectionsKt.firstOrNull(it2);
            if (day != null && (date = day.getDate()) != null) {
                obj = date.getDayOfWeek();
            }
            if (obj == selection.getDayOfWeek()) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                obj = element$iv;
                break;
            }
        }
        return (List) obj;
    }

    public static final YearMonth getNext(YearMonth $this$next) {
        Intrinsics.checkNotNullParameter($this$next, "<this>");
        return YearMonthKt.plus($this$next, 1, DateTimeUnit.Companion.getMONTH());
    }

    public static final YearMonth getPrevious(YearMonth $this$previous) {
        Intrinsics.checkNotNullParameter($this$previous, "<this>");
        return YearMonthKt.minus($this$previous, 1, DateTimeUnit.Companion.getMONTH());
    }
}