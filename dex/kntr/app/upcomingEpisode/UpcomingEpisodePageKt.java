package kntr.app.upcomingEpisode;

import ComposableSingletons$CustomBottomSheetKt$;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.runtime.snapshots.SnapshotStateSet;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarPointType;
import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarTimeRange;
import com.bapis.bilibili.community.interfacess.watch.v1.KRecommend;
import com.bapis.bilibili.community.interfacess.watch.v1.KReserveRecommend;
import com.bapis.bilibili.community.interfacess.watch.v1.KUpInfo;
import com.bapis.bilibili.community.interfacess.watch.v1.KWatchBizType;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeDayNight;
import com.bilibili.compose.theme.ThemeStrategy;
import j$.time.DayOfWeek;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.base.UpcomingEpisodeViewModel;
import kntr.app.upcomingEpisode.base.handler.CalendarCardClickArea;
import kntr.app.upcomingEpisode.base.handler.CalendarType;
import kntr.app.upcomingEpisode.base.handler.UpcomingEpisodeTrackerHandlerKt;
import kntr.app.upcomingEpisode.base.stateMachine.RequestFrom;
import kntr.app.upcomingEpisode.base.stateMachine.RequestStatus;
import kntr.app.upcomingEpisode.base.stateMachine.TrackerAction;
import kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeAction;
import kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeData;
import kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeStateMachine;
import kntr.app.upcomingEpisode.base.util.UpcomingEpisodePageUtils_androidKt$ConfigWindow$1$1;
import kntr.app.upcomingEpisode.calendar.model.Day;
import kntr.app.upcomingEpisode.calendar.model.DayPosition;
import kntr.app.upcomingEpisode.calendar.model.Month;
import kntr.app.upcomingEpisode.calendar.model.Week;
import kntr.app.upcomingEpisode.calendar.model.WeekDay;
import kntr.app.upcomingEpisode.calendar.model.YearMonth;
import kntr.app.upcomingEpisode.calendar.model.YearMonthKt;
import kntr.app.upcomingEpisode.calendar.ui.BiliCalendarDayContentKt;
import kntr.app.upcomingEpisode.calendar.ui.BiliCalendarHeaderKt;
import kntr.app.upcomingEpisode.calendar.ui.BiliMonthCalendarKt;
import kntr.app.upcomingEpisode.calendar.ui.BiliWeekCalendarKt;
import kntr.app.upcomingEpisode.calendar.utils.BiliCalendarExtensionsKt;
import kntr.app.upcomingEpisode.calendar.utils.BiliCalendarUtilsKt;
import kntr.app.upcomingEpisode.calendar.utils.BiliMonthCalendarState;
import kntr.app.upcomingEpisode.calendar.utils.BiliMonthCalendarStateKt;
import kntr.app.upcomingEpisode.calendar.utils.BiliWeekCalendarState;
import kntr.app.upcomingEpisode.calendar.utils.BiliWeekCalendarStateKt;
import kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListDialogKt;
import kntr.app.upcomingEpisode.list.utils.UpcomingEpisodeExtensionsKt;
import kntr.app.upcomingEpisode.list.utils.UpcomingEpisodeUtilsKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.router.Router;
import kntr.common.pv.compose.PvTriggerEntranceKt;
import kntr.common.router.RouterKt;
import kntr.common.router.UrisKt;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.LocalDate;

/* compiled from: UpcomingEpisodePage.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a;\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\t\u001a\u0015\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0003¢\u0006\u0002\u0010\r\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0014X\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\u0014X\u008a\u0084\u0002"}, d2 = {"TAG", "", UpcomingEpisodePageKt.TAG, "", "modifier", "Landroidx/compose/ui/Modifier;", "landingAnchorTime", "landingAnchorBizId", "landingAnchorBizType", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "WindowConfig", "isNight", "", "(ZLandroidx/compose/runtime/Composer;I)V", "main_debug", "selection", "Lkotlinx/datetime/LocalDate;", "calendarType", "Lkntr/app/upcomingEpisode/base/handler/CalendarType;", "animationProgress", "", "monthCalendarAlpha", "weekCalendarAlpha"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UpcomingEpisodePageKt {
    private static final String TAG = "UpcomingEpisodePage";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodePage$lambda$29(Modifier modifier, String str, String str2, String str3, int i, int i2, Composer composer, int i3) {
        UpcomingEpisodePage(modifier, str, str2, str3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WindowConfig$lambda$1(boolean z, int i, Composer composer, int i2) {
        WindowConfig(z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void UpcomingEpisodePage(Modifier modifier, String landingAnchorTime, String landingAnchorBizId, String landingAnchorBizType, Composer $composer, final int $changed, final int i) {
        String landingAnchorTime2;
        String str;
        String landingAnchorBizType2;
        Composer $composer2;
        Modifier modifier2;
        String landingAnchorTime3;
        String landingAnchorBizId2;
        int $dirty;
        boolean z;
        Object value$iv;
        String landingAnchorTime4;
        Object obj;
        Composer $composer3 = $composer.startRestartGroup(-1342807247);
        ComposerKt.sourceInformation($composer3, "C(UpcomingEpisodePage)N(modifier,landingAnchorTime,landingAnchorBizId,landingAnchorBizType)89@4716L54,90@4787L24,92@4840L165,98@5040L16,99@5079L28,101@5144L103,104@5277L59,115@5670L144,119@5844L144,124@6055L83,126@6166L83,127@6271L25,129@6326L212,136@6567L135,142@6721L58,144@6808L160,149@6990L46,150@7061L52,151@7143L36,152@7210L43,153@7283L49,154@7370L14,154@7385L17,157@7552L7,160@7692L142,167@7871L140,174@8040L210,180@8280L7,181@8313L103,181@8292L124,184@8439L46,185@8509L48,188@8670L23,189@8698L160,195@8863L134,202@9097L121,200@9002L329,208@9346L11175,208@9336L11185:UpcomingEpisodePage.kt#jbu1nf");
        int $dirty2 = $changed;
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            landingAnchorTime2 = landingAnchorTime;
        } else if (($changed & 48) == 0) {
            landingAnchorTime2 = landingAnchorTime;
            $dirty2 |= $composer3.changed(landingAnchorTime2) ? 32 : 16;
        } else {
            landingAnchorTime2 = landingAnchorTime;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            str = landingAnchorBizId;
        } else if (($changed & 384) == 0) {
            str = landingAnchorBizId;
            $dirty2 |= $composer3.changed(str) ? 256 : 128;
        } else {
            str = landingAnchorBizId;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            landingAnchorBizType2 = landingAnchorBizType;
        } else if (($changed & 3072) == 0) {
            landingAnchorBizType2 = landingAnchorBizType;
            $dirty2 |= $composer3.changed(landingAnchorBizType2) ? 2048 : 1024;
        } else {
            landingAnchorBizType2 = landingAnchorBizType;
        }
        if ($composer3.shouldExecute(($dirty2 & 1169) != 1168, $dirty2 & 1)) {
            modifier2 = (i & 1) != 0 ? (Modifier) Modifier.Companion : modifier;
            if (i2 != 0) {
                landingAnchorTime2 = null;
            }
            landingAnchorBizId2 = i3 != 0 ? null : str;
            String landingAnchorBizType3 = i4 != 0 ? null : landingAnchorBizType2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1342807247, $dirty2, -1, "kntr.app.upcomingEpisode.UpcomingEpisodePage (UpcomingEpisodePage.kt:88)");
            }
            PvTriggerEntranceKt.rememberPvEventTrigger(UpcomingEpisodeTrackerHandlerKt.EXIT_UPCOMING_EP_PAGE_EVENT_ID, $composer3, 6);
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3);
                $composer3.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1947561802, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv2 = new UpcomingEpisodeViewModel(new UpcomingEpisodeStateMachine(), scope);
                $composer3.updateRememberedValue(value$iv2);
                it$iv = value$iv2;
            }
            final UpcomingEpisodeViewModel viewModel = (UpcomingEpisodeViewModel) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final State data = SnapshotStateKt.collectAsState(viewModel.getDataFlow(), (CoroutineContext) null, $composer3, 0, 1);
            ComposerKt.sourceInformationMarkerStart($composer3, -1947554291, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv3 = BiliCalendarExtensionsKt.now$default(LocalDate.Companion, null, null, 3, null);
                $composer3.updateRememberedValue(value$iv3);
                it$iv2 = value$iv3;
            }
            final LocalDate currentDate = (LocalDate) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1947552136, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                if (landingAnchorTime2 != null && (value$iv = BiliCalendarExtensionsKt.toLocalDate$default(UpcomingEpisodeExtensionsKt.safeParseToLong$default(landingAnchorTime2, 0L, 1, null), null, 1, null)) != null) {
                    $composer3.updateRememberedValue(value$iv);
                    it$iv3 = value$iv;
                }
                Object value$iv4 = BiliCalendarExtensionsKt.now$default(LocalDate.Companion, null, null, 3, null);
                $composer3.updateRememberedValue(value$iv4);
                it$iv3 = value$iv4;
            }
            LocalDate landingAnchorDate = (LocalDate) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1947547924, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(landingAnchorDate);
            Object it$iv4 = $composer3.rememberedValue();
            if (invalid$iv || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv5 = BiliCalendarExtensionsKt.getYearMonth(landingAnchorDate);
                $composer3.updateRememberedValue(value$iv5);
                it$iv4 = value$iv5;
            }
            YearMonth landingAnchorMonth = (YearMonth) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1947535263, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            Object it$iv5 = $composer3.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv6 = BiliCalendarExtensionsKt.getYearMonth(currentDate).compareTo(BiliCalendarExtensionsKt.getYearMonth(landingAnchorDate)) < 0 ? BiliCalendarExtensionsKt.getYearMonth(currentDate) : BiliCalendarExtensionsKt.getYearMonth(landingAnchorDate);
                $composer3.updateRememberedValue(value$iv6);
                it$iv5 = value$iv6;
            }
            YearMonth minorMonth = (YearMonth) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1947529695, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            Object it$iv6 = $composer3.rememberedValue();
            if (it$iv6 == Composer.Companion.getEmpty()) {
                $dirty = $dirty2;
                Object value$iv7 = BiliCalendarExtensionsKt.getYearMonth(currentDate).compareTo(BiliCalendarExtensionsKt.getYearMonth(landingAnchorDate)) > 0 ? BiliCalendarExtensionsKt.getYearMonth(currentDate) : BiliCalendarExtensionsKt.getYearMonth(landingAnchorDate);
                $composer3.updateRememberedValue(value$iv7);
                it$iv6 = value$iv7;
            } else {
                $dirty = $dirty2;
            }
            YearMonth majorMonth = (YearMonth) it$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1947523004, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            boolean invalid$iv2 = $composer3.changed(currentDate);
            Object it$iv7 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv7 == Composer.Companion.getEmpty()) {
                Object value$iv8 = YearMonthKt.minusMonths(minorMonth, 12);
                $composer3.updateRememberedValue(value$iv8);
                it$iv7 = value$iv8;
            }
            YearMonth startMonth = (YearMonth) it$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1947519452, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            boolean invalid$iv3 = $composer3.changed(currentDate);
            Object it$iv8 = $composer3.rememberedValue();
            if (invalid$iv3 || it$iv8 == Composer.Companion.getEmpty()) {
                Object value$iv9 = YearMonthKt.plusMonths(majorMonth, 2);
                $composer3.updateRememberedValue(value$iv9);
                it$iv8 = value$iv9;
            }
            YearMonth endMonth = (YearMonth) it$iv8;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1947516150, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            Object it$iv9 = $composer3.rememberedValue();
            if (it$iv9 == Composer.Companion.getEmpty()) {
                z = true;
                value$iv = BiliCalendarUtilsKt.daysOfWeek$default(null, 1, null);
                $composer3.updateRememberedValue(value$iv);
            } else {
                z = true;
                value$iv = it$iv9;
            }
            List daysOfWeek = (List) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final BiliMonthCalendarState monthState = BiliMonthCalendarStateKt.rememberBiliMonthCalendarState(startMonth, endMonth, landingAnchorMonth, (DayOfWeek) CollectionsKt.first(daysOfWeek), $composer3, 0, 0);
            ComposerKt.sourceInformationMarkerStart($composer3, -1947506568, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            Object it$iv10 = $composer3.rememberedValue();
            if (it$iv10 == Composer.Companion.getEmpty()) {
                Object value$iv10 = ((Day) CollectionsKt.first((List) CollectionsKt.first(monthState.getFirstMonth().getWeekDays()))).getDate();
                $composer3.updateRememberedValue(value$iv10);
                it$iv10 = value$iv10;
            }
            LocalDate startDate = (LocalDate) it$iv10;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1947501717, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            Object it$iv11 = $composer3.rememberedValue();
            if (it$iv11 == Composer.Companion.getEmpty()) {
                Object value$iv11 = YearMonthKt.atEndOfMonth(monthState.getLastMonth().getYearMonth());
                $composer3.updateRememberedValue(value$iv11);
                it$iv11 = value$iv11;
            }
            LocalDate endDate = (LocalDate) it$iv11;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final BiliWeekCalendarState weekState = BiliWeekCalendarStateKt.rememberBiliWeekCalendarState(startDate, endDate, landingAnchorDate, null, $composer3, 0, 8);
            ComposerKt.sourceInformationMarkerStart($composer3, -1947493121, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            Object it$iv12 = $composer3.rememberedValue();
            if (it$iv12 == Composer.Companion.getEmpty()) {
                MutableState mutableStateOf$default = SnapshotStateKt.mutableStateOf$default(landingAnchorDate, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(mutableStateOf$default);
                it$iv12 = mutableStateOf$default;
            }
            final MutableState selection$delegate = (MutableState) it$iv12;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1947490843, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            Object it$iv13 = $composer3.rememberedValue();
            if (it$iv13 == Composer.Companion.getEmpty()) {
                landingAnchorTime4 = landingAnchorTime2;
                obj = null;
                Object value$iv12 = SnapshotStateKt.mutableStateOf$default(((UpcomingEpisodeData) data.getValue()).getCalendarType(), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv12);
                it$iv13 = value$iv12;
            } else {
                landingAnchorTime4 = landingAnchorTime2;
                obj = null;
            }
            final MutableState calendarType$delegate = (MutableState) it$iv13;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1947488235, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            Object it$iv14 = $composer3.rememberedValue();
            if (it$iv14 == Composer.Companion.getEmpty()) {
                Object value$iv13 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                $composer3.updateRememberedValue(value$iv13);
                it$iv14 = value$iv13;
            }
            final MutableFloatState animationProgress$delegate = (MutableFloatState) it$iv14;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final State monthCalendarAlpha$delegate = AnimateAsStateKt.animateFloatAsState(UpcomingEpisodePage$lambda$18(animationProgress$delegate) * 1.0f, (AnimationSpec) null, 0.0f, (String) null, (Function1) null, $composer3, 0, 30);
            final State weekCalendarAlpha$delegate = AnimateAsStateKt.animateFloatAsState((1 - UpcomingEpisodePage$lambda$18(animationProgress$delegate)) * 1.0f, (AnimationSpec) null, 0.0f, (String) null, (Function1) null, $composer3, 0, 30);
            final float paddingBottom = WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getNavigationBars(WindowInsets.Companion, $composer3, 6), $composer3, 0).calculateBottomPadding-D9Ej5fM();
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Density density = (Density) consume;
            int $this$dp$iv = ConstantsKt.MONTH_CALENDAR_CONTENT_HEIGHT - 128;
            final float heightDiffPx = density.toPx-0680j_4(Dp.constructor-impl($this$dp$iv));
            ComposerKt.sourceInformationMarkerStart($composer3, -1947470561, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            Object it$iv15 = $composer3.rememberedValue();
            if (it$iv15 == Composer.Companion.getEmpty()) {
                Object value$iv14 = ((Day) CollectionsKt.first((List) CollectionsKt.first(monthState.getFirstVisibleMonth().getWeekDays()))).getDate();
                $composer3.updateRememberedValue(value$iv14);
                it$iv15 = value$iv14;
            }
            LocalDate firstMonthBeginDate = (LocalDate) it$iv15;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1947464835, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            Object it$iv16 = $composer3.rememberedValue();
            if (it$iv16 == Composer.Companion.getEmpty()) {
                Object value$iv15 = ((Day) CollectionsKt.last((List) CollectionsKt.last(monthState.getFirstVisibleMonth().getWeekDays()))).getDate();
                $composer3.updateRememberedValue(value$iv15);
                it$iv16 = value$iv15;
            }
            LocalDate firstMonthEndDate = (LocalDate) it$iv16;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1947459357, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            Object it$iv17 = $composer3.rememberedValue();
            if (it$iv17 == Composer.Companion.getEmpty()) {
                Object value$iv16 = new KCalendarTimeRange(BiliCalendarExtensionsKt.toTimestampSeconds(firstMonthBeginDate), BiliCalendarExtensionsKt.toEndOfDayTimestampSeconds(firstMonthEndDate));
                $composer3.updateRememberedValue(value$iv16);
                it$iv17 = value$iv16;
            }
            KCalendarTimeRange timeRange = (KCalendarTimeRange) it$iv17;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            CompositionLocal this_$iv2 = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Router router = (Router) consume2;
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1947450728, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            boolean invalid$iv4 = $composer3.changedInstance(viewModel) | $composer3.changedInstance(timeRange);
            Object it$iv18 = $composer3.rememberedValue();
            if (invalid$iv4 || it$iv18 == Composer.Companion.getEmpty()) {
                Object value$iv17 = (Function2) new UpcomingEpisodePageKt$UpcomingEpisodePage$1$1(viewModel, timeRange, null);
                $composer3.updateRememberedValue(value$iv17);
                it$iv18 = value$iv17;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv18, $composer3, 6);
            final Week visibleWeek = BiliCalendarUtilsKt.rememberFirstVisibleWeekAfterScroll(weekState, $composer3, 0);
            final Month visibleMonth = BiliCalendarUtilsKt.rememberFirstVisibleMonthAfterScroll(monthState, $composer3, 0);
            final SnapshotStateMap cardListMap = ((UpcomingEpisodeData) data.getValue()).getCardListMap();
            final SnapshotStateMap pointTypeMap = ((UpcomingEpisodeData) data.getValue()).getPointTypeMap();
            final LazyListState listState = LazyListStateKt.rememberLazyListState(0, 0, $composer3, 0, 3);
            landingAnchorTime3 = landingAnchorTime4;
            $composer2 = $composer3;
            BiliCalendarUtilsKt.SyncWeekAndMonthState(weekState, monthState, UpcomingEpisodePage$lambda$12(selection$delegate), UpcomingEpisodePage$lambda$15(calendarType$delegate), $composer3, 0);
            BiliCalendarUtilsKt.CheckPointTypeWhenResume(UpcomingEpisodePage$lambda$12(selection$delegate), pointTypeMap, cardListMap, $composer2, 0);
            boolean hasRequestCalendarApi = ((UpcomingEpisodeData) data.getValue()).getHasRequestCalendarApi();
            SnapshotStateSet<LocalDate> pageSet = ((UpcomingEpisodeData) data.getValue()).getPageSet();
            ComposerKt.sourceInformationMarkerStart($composer2, -1947425622, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            boolean invalid$iv5 = $composer2.changedInstance(viewModel);
            Object it$iv19 = $composer2.rememberedValue();
            if (invalid$iv5 || it$iv19 == Composer.Companion.getEmpty()) {
                Object value$iv18 = new Function1() { // from class: kntr.app.upcomingEpisode.UpcomingEpisodePageKt$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj2) {
                        Unit UpcomingEpisodePage$lambda$27$0;
                        UpcomingEpisodePage$lambda$27$0 = UpcomingEpisodePageKt.UpcomingEpisodePage$lambda$27$0(UpcomingEpisodeViewModel.this, (KCalendarTimeRange) obj2);
                        return UpcomingEpisodePage$lambda$27$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv18);
                it$iv19 = value$iv18;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            BiliCalendarUtilsKt.RequestWatchCalendarAfterMonthScroll(monthState, hasRequestCalendarApi, pageSet, (Function1) it$iv19, $composer2, 0, 0);
            final String str2 = landingAnchorBizType3;
            final String str3 = landingAnchorBizId2;
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(1638787817, true, new Function2() { // from class: kntr.app.upcomingEpisode.UpcomingEpisodePageKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj2, Object obj3) {
                    Unit UpcomingEpisodePage$lambda$28;
                    UpcomingEpisodePage$lambda$28 = UpcomingEpisodePageKt.UpcomingEpisodePage$lambda$28(r3, r4, density, cardListMap, data, currentDate, listState, paddingBottom, str2, str3, viewModel, router, monthState, pointTypeMap, heightDiffPx, weekState, monthCalendarAlpha$delegate, scope, selection$delegate, calendarType$delegate, visibleMonth, weekCalendarAlpha$delegate, visibleWeek, animationProgress$delegate, (Composer) obj2, ((Integer) obj3).intValue());
                    return UpcomingEpisodePage$lambda$28;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            landingAnchorBizType2 = landingAnchorBizType3;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            landingAnchorTime3 = landingAnchorTime2;
            landingAnchorBizId2 = str;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final String str4 = landingAnchorTime3;
            final String str5 = landingAnchorBizId2;
            final String str6 = landingAnchorBizType2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.upcomingEpisode.UpcomingEpisodePageKt$$ExternalSyntheticLambda17
                public final Object invoke(Object obj2, Object obj3) {
                    Unit UpcomingEpisodePage$lambda$29;
                    UpcomingEpisodePage$lambda$29 = UpcomingEpisodePageKt.UpcomingEpisodePage$lambda$29(modifier3, str4, str5, str6, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return UpcomingEpisodePage$lambda$29;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocalDate UpcomingEpisodePage$lambda$12(MutableState<LocalDate> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (LocalDate) $this$getValue$iv.getValue();
    }

    private static final CalendarType UpcomingEpisodePage$lambda$15(MutableState<CalendarType> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (CalendarType) $this$getValue$iv.getValue();
    }

    private static final float UpcomingEpisodePage$lambda$18(MutableFloatState $animationProgress$delegate) {
        FloatState $this$getValue$iv = (FloatState) $animationProgress$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    private static final float UpcomingEpisodePage$lambda$20(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    private static final float UpcomingEpisodePage$lambda$21(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodePage$lambda$27$0(UpcomingEpisodeViewModel $viewModel, KCalendarTimeRange timeRange) {
        Intrinsics.checkNotNullParameter(timeRange, "timeRange");
        $viewModel.dispatch(new UpcomingEpisodeAction.WatchCalendar(timeRange, RequestFrom.Auto.INSTANCE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodePage$lambda$28(final int $monthCalendarHeight, final int $weekCalendarHeight, final Density $density, final SnapshotStateMap $cardListMap, final State $data, final LocalDate $currentDate, final LazyListState $listState, final float $paddingBottom, final String $landingAnchorBizType, final String $landingAnchorBizId, final UpcomingEpisodeViewModel $viewModel, final Router $router, final BiliMonthCalendarState $monthState, final SnapshotStateMap $pointTypeMap, final float $heightDiffPx, final BiliWeekCalendarState $weekState, final State $monthCalendarAlpha$delegate, final CoroutineScope $scope, final MutableState $selection$delegate, final MutableState $calendarType$delegate, final Month $visibleMonth, final State $weekCalendarAlpha$delegate, final Week $visibleWeek, final MutableFloatState $animationProgress$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C213@9509L6,215@9573L10942,209@9356L11159:UpcomingEpisodePage.kt#jbu1nf");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1638787817, $changed, -1, "kntr.app.upcomingEpisode.UpcomingEpisodePage.<anonymous> (UpcomingEpisodePage.kt:209)");
            }
            BoxWithConstraintsKt.BoxWithConstraints(WindowInsetsPadding_androidKt.statusBarsPadding(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg2-0d7_KjU(), (Shape) null, 2, (Object) null)), (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(1707438419, true, new Function3() { // from class: kntr.app.upcomingEpisode.UpcomingEpisodePageKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit UpcomingEpisodePage$lambda$28$0;
                    UpcomingEpisodePage$lambda$28$0 = UpcomingEpisodePageKt.UpcomingEpisodePage$lambda$28$0($monthCalendarHeight, $weekCalendarHeight, $density, $cardListMap, $data, $currentDate, $listState, $paddingBottom, $landingAnchorBizType, $landingAnchorBizId, $viewModel, $router, $monthState, $pointTypeMap, $heightDiffPx, $weekState, $monthCalendarAlpha$delegate, $scope, $selection$delegate, $calendarType$delegate, $visibleMonth, $weekCalendarAlpha$delegate, $visibleWeek, $animationProgress$delegate, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return UpcomingEpisodePage$lambda$28$0;
                }
            }, $composer, 54), $composer, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0330, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0367, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x039e, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit UpcomingEpisodePage$lambda$28$0(int $monthCalendarHeight, int $weekCalendarHeight, Density $density, final SnapshotStateMap $cardListMap, State $data, LocalDate $currentDate, final LazyListState $listState, float $paddingBottom, String $landingAnchorBizType, String $landingAnchorBizId, final UpcomingEpisodeViewModel $viewModel, final Router $router, final BiliMonthCalendarState $monthState, final SnapshotStateMap $pointTypeMap, final float $heightDiffPx, final BiliWeekCalendarState $weekState, State $monthCalendarAlpha$delegate, final CoroutineScope $scope, final MutableState $selection$delegate, final MutableState $calendarType$delegate, final Month $visibleMonth, State $weekCalendarAlpha$delegate, final Week $visibleWeek, final MutableFloatState $animationProgress$delegate, BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C220@9896L13,221@9945L21,222@9979L4362,316@14389L129,331@15183L362,340@15584L300,348@15929L324,356@16301L584,370@16939L359,379@17352L608,393@18011L233,400@18283L109,403@18424L132,406@18589L968,429@19598L254,437@20067L228,444@20328L162,320@14531L5974:UpcomingEpisodePage.kt#jbu1nf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$BoxWithConstraints) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1707438419, $dirty2, -1, "kntr.app.upcomingEpisode.UpcomingEpisodePage.<anonymous>.<anonymous> (UpcomingEpisodePage.kt:216)");
            }
            int screenHeightDp = (int) $this$BoxWithConstraints.getMaxHeight-D9Ej5fM();
            int dialogPeekHeightDp = screenHeightDp - $monthCalendarHeight;
            int dialogMaxHeightDp = screenHeightDp - $weekCalendarHeight;
            final float dialogMaxHeightPx = $density.toPx-0680j_4(Dp.constructor-impl(dialogMaxHeightDp));
            boolean isNight = BiliTheme.INSTANCE.getDayNightTheme($composer, BiliTheme.$stable) == ThemeDayNight.Night;
            WindowConfig(isNight, $composer, 0);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 185489776, "C240@10732L1803,230@10329L211,223@10001L2553,292@13288L1020,283@12939L209,275@12571L1756:UpcomingEpisodePage.kt#jbu1nf");
            BiliMonthCalendarKt.BiliMonthCalendar(ComposableLambdaKt.rememberComposableLambda(-607915775, true, new Function4() { // from class: kntr.app.upcomingEpisode.UpcomingEpisodePageKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit UpcomingEpisodePage$lambda$28$0$1$0;
                    UpcomingEpisodePage$lambda$28$0$1$0 = UpcomingEpisodePageKt.UpcomingEpisodePage$lambda$28$0$1$0(BiliMonthCalendarState.this, $scope, $weekState, $listState, $viewModel, $selection$delegate, $calendarType$delegate, (BoxScope) obj, (Day) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return UpcomingEpisodePage$lambda$28$0$1$0;
                }
            }, $composer, 54), (Map) $pointTypeMap, ZIndexModifierKt.zIndex(AlphaKt.alpha(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl($monthCalendarHeight)), UpcomingEpisodePage$lambda$20($monthCalendarAlpha$delegate)), UpcomingEpisodePage$lambda$20($monthCalendarAlpha$delegate)), $monthState, ComposableLambdaKt.rememberComposableLambda(1639949282, true, new Function2() { // from class: kntr.app.upcomingEpisode.UpcomingEpisodePageKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit UpcomingEpisodePage$lambda$28$0$1$1;
                    UpcomingEpisodePage$lambda$28$0$1$1 = UpcomingEpisodePageKt.UpcomingEpisodePage$lambda$28$0$1$1(Month.this, (Composer) obj, ((Integer) obj2).intValue());
                    return UpcomingEpisodePage$lambda$28$0$1$1;
                }
            }, $composer, 54), ComposableSingletons$UpcomingEpisodePageKt.INSTANCE.m1185getLambda$494461469$main_debug(), $composer, 221190, 0);
            BiliWeekCalendarKt.BiliWeekCalendar($pointTypeMap, ComposableLambdaKt.rememberComposableLambda(-809308110, true, new Function4() { // from class: kntr.app.upcomingEpisode.UpcomingEpisodePageKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit UpcomingEpisodePage$lambda$28$0$1$2;
                    UpcomingEpisodePage$lambda$28$0$1$2 = UpcomingEpisodePageKt.UpcomingEpisodePage$lambda$28$0$1$2(UpcomingEpisodeViewModel.this, $scope, $listState, $selection$delegate, $calendarType$delegate, (BoxScope) obj, (WeekDay) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return UpcomingEpisodePage$lambda$28$0$1$2;
                }
            }, $composer, 54), ZIndexModifierKt.zIndex(AlphaKt.alpha(SizeKt.wrapContentHeight$default(Modifier.Companion, (Alignment.Vertical) null, false, 3, (Object) null), UpcomingEpisodePage$lambda$21($weekCalendarAlpha$delegate)), UpcomingEpisodePage$lambda$21($weekCalendarAlpha$delegate)), $weekState, ComposableLambdaKt.rememberComposableLambda(996295910, true, new Function2() { // from class: kntr.app.upcomingEpisode.UpcomingEpisodePageKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit UpcomingEpisodePage$lambda$28$0$1$3;
                    UpcomingEpisodePage$lambda$28$0$1$3 = UpcomingEpisodePageKt.UpcomingEpisodePage$lambda$28$0$1$3(Week.this, (Composer) obj, ((Integer) obj2).intValue());
                    return UpcomingEpisodePage$lambda$28$0$1$3;
                }
            }, $composer, 54), ComposableSingletons$UpcomingEpisodePageKt.INSTANCE.m1184getLambda$458029371$main_debug(), $composer, 221232, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            SnapshotStateList visibleCards = UpcomingEpisodeUtilsKt.rememberVisibleCards(UpcomingEpisodePage$lambda$12($selection$delegate), $cardListMap, $composer, 0);
            float f = Dp.constructor-impl(dialogPeekHeightDp);
            float f2 = Dp.constructor-impl(dialogMaxHeightDp);
            RequestStatus state = ((UpcomingEpisodeData) $data.getValue()).getRequestModel().getWatchCalendarReqState().getState();
            RequestFrom from = ((UpcomingEpisodeData) $data.getValue()).getRequestModel().getWatchCalendarReqState().getFrom();
            CalendarType calendarType = ((UpcomingEpisodeData) $data.getValue()).getCalendarType();
            List<KRecommend> recommendData = ((UpcomingEpisodeData) $data.getValue()).getRecommendData();
            boolean areEqual = Intrinsics.areEqual(UpcomingEpisodePage$lambda$12($selection$delegate), $currentDate);
            ComposerKt.sourceInformationMarkerStart($composer, 170993469, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($viewModel);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function3() { // from class: kntr.app.upcomingEpisode.UpcomingEpisodePageKt$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit UpcomingEpisodePage$lambda$28$0$2$0;
                        UpcomingEpisodePage$lambda$28$0$2$0 = UpcomingEpisodePageKt.UpcomingEpisodePage$lambda$28$0$2$0(UpcomingEpisodeViewModel.this, (KWatchBizType) obj, (String) obj2, (Function0) obj3);
                        return UpcomingEpisodePage$lambda$28$0$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Function3 function3 = (Function3) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 171006239, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($viewModel);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function2() { // from class: kntr.app.upcomingEpisode.UpcomingEpisodePageKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit UpcomingEpisodePage$lambda$28$0$3$0;
                    UpcomingEpisodePage$lambda$28$0$3$0 = UpcomingEpisodePageKt.UpcomingEpisodePage$lambda$28$0$3$0(UpcomingEpisodeViewModel.this, (String) obj, (Function0) obj2);
                    return UpcomingEpisodePage$lambda$28$0$3$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            Function2 function2 = (Function2) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 171017303, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            boolean invalid$iv3 = $composer.changedInstance($viewModel);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv3 = new Function2() { // from class: kntr.app.upcomingEpisode.UpcomingEpisodePageKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit UpcomingEpisodePage$lambda$28$0$4$0;
                    UpcomingEpisodePage$lambda$28$0$4$0 = UpcomingEpisodePageKt.UpcomingEpisodePage$lambda$28$0$4$0(UpcomingEpisodeViewModel.this, (String) obj, (Function0) obj2);
                    return UpcomingEpisodePage$lambda$28$0$4$0;
                }
            };
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            Function2 function22 = (Function2) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 171029467, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            boolean invalid$iv4 = $composer.changedInstance($viewModel);
            Object it$iv4 = $composer.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv4 = new Function2() { // from class: kntr.app.upcomingEpisode.UpcomingEpisodePageKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit UpcomingEpisodePage$lambda$28$0$5$0;
                    UpcomingEpisodePage$lambda$28$0$5$0 = UpcomingEpisodePageKt.UpcomingEpisodePage$lambda$28$0$5$0(UpcomingEpisodeViewModel.this, (KReserveRecommend) obj, (Function0) obj2);
                    return UpcomingEpisodePage$lambda$28$0$5$0;
                }
            };
            $composer.updateRememberedValue(value$iv4);
            it$iv4 = value$iv4;
            Function2 function23 = (Function2) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 171049658, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            boolean invalid$iv5 = $composer.changedInstance($router) | $composer.changedInstance($viewModel);
            Object it$iv5 = $composer.rememberedValue();
            if (invalid$iv5 || it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv5 = new Function2() { // from class: kntr.app.upcomingEpisode.UpcomingEpisodePageKt$$ExternalSyntheticLambda12
                    public final Object invoke(Object obj, Object obj2) {
                        Unit UpcomingEpisodePage$lambda$28$0$6$0;
                        UpcomingEpisodePage$lambda$28$0$6$0 = UpcomingEpisodePageKt.UpcomingEpisodePage$lambda$28$0$6$0(Router.this, $viewModel, (KUpInfo) obj, (KReserveRecommend) obj2);
                        return UpcomingEpisodePage$lambda$28$0$6$0;
                    }
                };
                $composer.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            }
            Function2 function24 = (Function2) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 171063123, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            boolean invalid$iv6 = $composer.changedInstance($viewModel);
            Object it$iv6 = $composer.rememberedValue();
            if (invalid$iv6 || it$iv6 == Composer.Companion.getEmpty()) {
                Object value$iv6 = new Function2() { // from class: kntr.app.upcomingEpisode.UpcomingEpisodePageKt$$ExternalSyntheticLambda19
                    public final Object invoke(Object obj, Object obj2) {
                        Unit UpcomingEpisodePage$lambda$28$0$7$0;
                        UpcomingEpisodePage$lambda$28$0$7$0 = UpcomingEpisodePageKt.UpcomingEpisodePage$lambda$28$0$7$0(UpcomingEpisodeViewModel.this, (KReserveRecommend) obj, (Function0) obj2);
                        return UpcomingEpisodePage$lambda$28$0$7$0;
                    }
                };
                $composer.updateRememberedValue(value$iv6);
                it$iv6 = value$iv6;
            }
            Function2 function25 = (Function2) it$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 171083836, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            boolean invalid$iv7 = $composer.changedInstance($viewModel);
            Object it$iv7 = $composer.rememberedValue();
            if (invalid$iv7 || it$iv7 == Composer.Companion.getEmpty()) {
                Object value$iv7 = new Function1() { // from class: kntr.app.upcomingEpisode.UpcomingEpisodePageKt$$ExternalSyntheticLambda20
                    public final Object invoke(Object obj) {
                        Unit UpcomingEpisodePage$lambda$28$0$8$0;
                        UpcomingEpisodePage$lambda$28$0$8$0 = UpcomingEpisodePageKt.UpcomingEpisodePage$lambda$28$0$8$0(UpcomingEpisodeViewModel.this, (KReserveRecommend) obj);
                        return UpcomingEpisodePage$lambda$28$0$8$0;
                    }
                };
                $composer.updateRememberedValue(value$iv7);
                it$iv7 = value$iv7;
            }
            Function1 function1 = (Function1) it$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 171092416, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            boolean invalid$iv8 = $composer.changedInstance($viewModel);
            Object it$iv8 = $composer.rememberedValue();
            if (invalid$iv8 || it$iv8 == Composer.Companion.getEmpty()) {
                Object value$iv8 = new Function1() { // from class: kntr.app.upcomingEpisode.UpcomingEpisodePageKt$$ExternalSyntheticLambda21
                    public final Object invoke(Object obj) {
                        Unit UpcomingEpisodePage$lambda$28$0$9$0;
                        UpcomingEpisodePage$lambda$28$0$9$0 = UpcomingEpisodePageKt.UpcomingEpisodePage$lambda$28$0$9$0(UpcomingEpisodeViewModel.this, (Map) obj);
                        return UpcomingEpisodePage$lambda$28$0$9$0;
                    }
                };
                $composer.updateRememberedValue(value$iv8);
                it$iv8 = value$iv8;
            }
            Function1 function12 = (Function1) it$iv8;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 171096951, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            boolean invalid$iv9 = $composer.changedInstance($viewModel);
            Object it$iv9 = $composer.rememberedValue();
            if (invalid$iv9 || it$iv9 == Composer.Companion.getEmpty()) {
                Object value$iv9 = new Function2() { // from class: kntr.app.upcomingEpisode.UpcomingEpisodePageKt$$ExternalSyntheticLambda22
                    public final Object invoke(Object obj, Object obj2) {
                        Unit UpcomingEpisodePage$lambda$28$0$10$0;
                        UpcomingEpisodePage$lambda$28$0$10$0 = UpcomingEpisodePageKt.UpcomingEpisodePage$lambda$28$0$10$0(UpcomingEpisodeViewModel.this, (CalendarCardClickArea) obj, (Map) obj2);
                        return UpcomingEpisodePage$lambda$28$0$10$0;
                    }
                };
                $composer.updateRememberedValue(value$iv9);
                it$iv9 = value$iv9;
            }
            Function2 function26 = (Function2) it$iv9;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 171103067, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            boolean invalid$iv10 = $composer.changed($monthState) | $composer.changedInstance($viewModel);
            Object it$iv10 = $composer.rememberedValue();
            if (invalid$iv10 || it$iv10 == Composer.Companion.getEmpty()) {
                Object value$iv10 = new Function0() { // from class: kntr.app.upcomingEpisode.UpcomingEpisodePageKt$$ExternalSyntheticLambda23
                    public final Object invoke() {
                        Unit UpcomingEpisodePage$lambda$28$0$11$0;
                        UpcomingEpisodePage$lambda$28$0$11$0 = UpcomingEpisodePageKt.UpcomingEpisodePage$lambda$28$0$11$0(BiliMonthCalendarState.this, $viewModel);
                        return UpcomingEpisodePage$lambda$28$0$11$0;
                    }
                };
                $composer.updateRememberedValue(value$iv10);
                it$iv10 = value$iv10;
            }
            Function0 function0 = (Function0) it$iv10;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 171134641, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            boolean invalid$iv11 = $composer.changedInstance($viewModel);
            Object it$iv11 = $composer.rememberedValue();
            if (invalid$iv11 || it$iv11 == Composer.Companion.getEmpty()) {
                Object value$iv11 = new Function1() { // from class: kntr.app.upcomingEpisode.UpcomingEpisodePageKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit UpcomingEpisodePage$lambda$28$0$12$0;
                        UpcomingEpisodePage$lambda$28$0$12$0 = UpcomingEpisodePageKt.UpcomingEpisodePage$lambda$28$0$12$0(UpcomingEpisodeViewModel.this, $calendarType$delegate, (CalendarType) obj);
                        return UpcomingEpisodePage$lambda$28$0$12$0;
                    }
                };
                $composer.updateRememberedValue(value$iv11);
                it$iv11 = value$iv11;
            }
            Function1 function13 = (Function1) it$iv11;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 171149623, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            boolean invalid$iv12 = $composer.changed($pointTypeMap) | $composer.changed($cardListMap);
            Object it$iv12 = $composer.rememberedValue();
            if (invalid$iv12 || it$iv12 == Composer.Companion.getEmpty()) {
                Object value$iv12 = new Function0() { // from class: kntr.app.upcomingEpisode.UpcomingEpisodePageKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit UpcomingEpisodePage$lambda$28$0$13$0;
                        UpcomingEpisodePage$lambda$28$0$13$0 = UpcomingEpisodePageKt.UpcomingEpisodePage$lambda$28$0$13$0($pointTypeMap, $cardListMap, $selection$delegate);
                        return UpcomingEpisodePage$lambda$28$0$13$0;
                    }
                };
                $composer.updateRememberedValue(value$iv12);
                it$iv12 = value$iv12;
            }
            Function0 function02 = (Function0) it$iv12;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 171157909, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            boolean invalid$iv13 = $composer.changed(dialogMaxHeightPx) | $composer.changed($heightDiffPx);
            Object it$iv13 = $composer.rememberedValue();
            if (invalid$iv13 || it$iv13 == Composer.Companion.getEmpty()) {
                Object value$iv13 = new Function1() { // from class: kntr.app.upcomingEpisode.UpcomingEpisodePageKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit UpcomingEpisodePage$lambda$28$0$14$0;
                        UpcomingEpisodePage$lambda$28$0$14$0 = UpcomingEpisodePageKt.UpcomingEpisodePage$lambda$28$0$14$0(dialogMaxHeightPx, $heightDiffPx, $animationProgress$delegate, ((Integer) obj).intValue());
                        return UpcomingEpisodePage$lambda$28$0$14$0;
                    }
                };
                $composer.updateRememberedValue(value$iv13);
                it$iv13 = value$iv13;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            UpcomingEpisodeListDialogKt.m1257UpcomingEpisodeListDialogyivurRs(null, $listState, 0.0f, f, f2, $paddingBottom, visibleCards, state, from, calendarType, recommendData, areEqual, $landingAnchorBizType, $landingAnchorBizId, function3, function2, function22, function23, function24, function25, function1, function12, function26, function0, function13, function02, (Function1) it$iv13, $composer, 0, 0, 0, 5);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodePage$lambda$28$0$1$1(Month $visibleMonth, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C233@10458L33,231@10355L163:UpcomingEpisodePage.kt#jbu1nf");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1639949282, $changed, -1, "kntr.app.upcomingEpisode.UpcomingEpisodePage.<anonymous>.<anonymous>.<anonymous>.<anonymous> (UpcomingEpisodePage.kt:231)");
            }
            BiliCalendarHeaderKt.m1210BiliCalendarHeaderAjpBEmI(Dp.constructor-impl(0), BiliCalendarUtilsKt.getMonthHeaderTitle($visibleMonth, $composer, 0), null, null, $composer, 6, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodePage$lambda$28$0$1$0(final BiliMonthCalendarState $monthState, final CoroutineScope $scope, final BiliWeekCalendarState $weekState, final LazyListState $listState, final UpcomingEpisodeViewModel $viewModel, final MutableState $selection$delegate, final MutableState $calendarType$delegate, BoxScope $this$BiliMonthCalendar, final Day day, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliMonthCalendar, "$this$BiliMonthCalendar");
        Intrinsics.checkNotNullParameter(day, "day");
        ComposerKt.sourceInformation($composer, "CN(day)247@11132L1291,242@10847L1666:UpcomingEpisodePage.kt#jbu1nf");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(day) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (!$composer.shouldExecute(($dirty2 & 145) != 144, $dirty2 & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-607915775, $dirty2, -1, "kntr.app.upcomingEpisode.UpcomingEpisodePage.<anonymous>.<anonymous>.<anonymous>.<anonymous> (UpcomingEpisodePage.kt:241)");
            }
            final boolean hasBackground = day.getPosition() == DayPosition.MonthDate;
            LocalDate date = day.getDate();
            boolean areEqual = Intrinsics.areEqual(UpcomingEpisodePage$lambda$12($selection$delegate), day.getDate());
            KCalendarPointType pointType = day.getPointType();
            boolean z = !hasBackground;
            ComposerKt.sourceInformationMarkerStart($composer, -91493428, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            boolean invalid$iv = $composer.changed($monthState) | (($dirty2 & 112) == 32) | $composer.changedInstance($scope) | $composer.changed($weekState) | $composer.changed(hasBackground) | $composer.changed($listState) | $composer.changedInstance($viewModel);
            Object value$iv = $composer.rememberedValue();
            if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                value$iv = new Function1() { // from class: kntr.app.upcomingEpisode.UpcomingEpisodePageKt$$ExternalSyntheticLambda18
                    public final Object invoke(Object obj) {
                        Unit UpcomingEpisodePage$lambda$28$0$1$0$0$0;
                        UpcomingEpisodePage$lambda$28$0$1$0$0$0 = UpcomingEpisodePageKt.UpcomingEpisodePage$lambda$28$0$1$0$0$0(Day.this, $monthState, $scope, $viewModel, $selection$delegate, $weekState, hasBackground, $listState, $calendarType$delegate, (LocalDate) obj);
                        return UpcomingEpisodePage$lambda$28$0$1$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            BiliCalendarDayContentKt.BiliCalendarDayContent(date, areEqual, null, pointType, z, (Function1) value$iv, CalendarType.MONTH, $composer, 1572864, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodePage$lambda$28$0$1$0$0$0(Day $day, BiliMonthCalendarState $monthState, CoroutineScope $scope, UpcomingEpisodeViewModel $viewModel, MutableState $selection$delegate, BiliWeekCalendarState $weekState, boolean $hasBackground, LazyListState $listState, MutableState $calendarType$delegate, LocalDate clicked) {
        Intrinsics.checkNotNullParameter(clicked, "clicked");
        if (!Intrinsics.areEqual(UpcomingEpisodePage$lambda$12($selection$delegate), clicked) && !Intrinsics.areEqual(BiliCalendarExtensionsKt.getYearMonth($day.getDate()), YearMonthKt.plus($monthState.getEndMonth(), 1, DateTimeUnit.Companion.getMONTH()))) {
            $selection$delegate.setValue(clicked);
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new UpcomingEpisodePageKt$UpcomingEpisodePage$3$1$1$1$1$1$1($weekState, $hasBackground, $monthState, $listState, $selection$delegate, null), 3, (Object) null);
            $viewModel.dispatch(new TrackerAction.UpcomingEpisodeCalendarClick(UpcomingEpisodePage$lambda$15($calendarType$delegate), $day.getPointType()));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodePage$lambda$28$0$1$3(Week $visibleWeek, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C286@13068L31,284@12965L161:UpcomingEpisodePage.kt#jbu1nf");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(996295910, $changed, -1, "kntr.app.upcomingEpisode.UpcomingEpisodePage.<anonymous>.<anonymous>.<anonymous>.<anonymous> (UpcomingEpisodePage.kt:284)");
            }
            BiliCalendarHeaderKt.m1210BiliCalendarHeaderAjpBEmI(Dp.constructor-impl(0), BiliCalendarUtilsKt.getWeekHeaderTitle($visibleWeek, $composer, 0), null, null, $composer, 6, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodePage$lambda$28$0$1$2(final UpcomingEpisodeViewModel $viewModel, final CoroutineScope $scope, final LazyListState $listState, final MutableState $selection$delegate, final MutableState $calendarType$delegate, BoxScope $this$BiliWeekCalendar, final WeekDay day, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliWeekCalendar, "$this$BiliWeekCalendar");
        Intrinsics.checkNotNullParameter(day, "day");
        ComposerKt.sourceInformation($composer, "CN(day)297@13547L712,293@13321L965:UpcomingEpisodePage.kt#jbu1nf");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(day) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 145) != 144, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-809308110, $dirty2, -1, "kntr.app.upcomingEpisode.UpcomingEpisodePage.<anonymous>.<anonymous>.<anonymous>.<anonymous> (UpcomingEpisodePage.kt:293)");
            }
            LocalDate date = day.getDate();
            boolean areEqual = Intrinsics.areEqual(UpcomingEpisodePage$lambda$12($selection$delegate), day.getDate());
            KCalendarPointType pointType = day.getPointType();
            ComposerKt.sourceInformationMarkerStart($composer, -356004134, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($viewModel) | (($dirty2 & 112) == 32) | $composer.changedInstance($scope) | $composer.changed($listState);
            Object value$iv = $composer.rememberedValue();
            if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                value$iv = new Function1() { // from class: kntr.app.upcomingEpisode.UpcomingEpisodePageKt$$ExternalSyntheticLambda15
                    public final Object invoke(Object obj) {
                        Unit UpcomingEpisodePage$lambda$28$0$1$2$0$0;
                        UpcomingEpisodePage$lambda$28$0$1$2$0$0 = UpcomingEpisodePageKt.UpcomingEpisodePage$lambda$28$0$1$2$0$0(UpcomingEpisodeViewModel.this, day, $scope, $selection$delegate, $calendarType$delegate, $listState, (LocalDate) obj);
                        return UpcomingEpisodePage$lambda$28$0$1$2$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            BiliCalendarDayContentKt.BiliCalendarDayContent(date, areEqual, null, pointType, false, (Function1) value$iv, null, $composer, 0, 84);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodePage$lambda$28$0$1$2$0$0(UpcomingEpisodeViewModel $viewModel, WeekDay $day, CoroutineScope $scope, MutableState $selection$delegate, MutableState $calendarType$delegate, LazyListState $listState, LocalDate clicked) {
        Intrinsics.checkNotNullParameter(clicked, "clicked");
        if (!Intrinsics.areEqual(UpcomingEpisodePage$lambda$12($selection$delegate), clicked)) {
            $selection$delegate.setValue(clicked);
            $viewModel.dispatch(new TrackerAction.UpcomingEpisodeCalendarClick(UpcomingEpisodePage$lambda$15($calendarType$delegate), $day.getPointType()));
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new UpcomingEpisodePageKt$UpcomingEpisodePage$3$1$1$3$1$1$1($listState, null), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodePage$lambda$28$0$2$0(UpcomingEpisodeViewModel $viewModel, KWatchBizType bizType, String bizId, Function0 onDeleteSuccess) {
        Intrinsics.checkNotNullParameter(bizType, "bizType");
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Intrinsics.checkNotNullParameter(onDeleteSuccess, "onDeleteSuccess");
        $viewModel.dispatch(new UpcomingEpisodeAction.DeleteCalendarCard(bizType, bizId, onDeleteSuccess));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodePage$lambda$28$0$3$0(UpcomingEpisodeViewModel $viewModel, String bizId, Function0 onReserveSuccess) {
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Intrinsics.checkNotNullParameter(onReserveSuccess, "onReserveSuccess");
        $viewModel.dispatch(new UpcomingEpisodeAction.ReserveCard(bizId, onReserveSuccess));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodePage$lambda$28$0$4$0(UpcomingEpisodeViewModel $viewModel, String bizId, Function0 onCancelReserveSuccess) {
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Intrinsics.checkNotNullParameter(onCancelReserveSuccess, "onCancelReserveSuccess");
        $viewModel.dispatch(new UpcomingEpisodeAction.CancelReserveCard(bizId, onCancelReserveSuccess));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodePage$lambda$28$0$5$0(UpcomingEpisodeViewModel $viewModel, KReserveRecommend data, Function0 onReserveSuccess) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(onReserveSuccess, "onReserveSuccess");
        $viewModel.dispatch(new UpcomingEpisodeAction.ReserveCard(String.valueOf(data.getReserveId()), onReserveSuccess));
        $viewModel.dispatch(new TrackerAction.UpComingEpisodeRecommendReservationCardClick(data, CalendarCardClickArea.BUTTON));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodePage$lambda$28$0$6$0(Router $router, UpcomingEpisodeViewModel $viewModel, KUpInfo upInfo, KReserveRecommend data) {
        Intrinsics.checkNotNullParameter(upInfo, "upInfo");
        Intrinsics.checkNotNullParameter(data, "data");
        $router.launch(UrisKt.toUri(upInfo.getJumpUrl()));
        $viewModel.dispatch(new TrackerAction.UpComingEpisodeRecommendReservationCardClick(data, CalendarCardClickArea.UP_INFO));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodePage$lambda$28$0$7$0(UpcomingEpisodeViewModel $viewModel, KReserveRecommend data, Function0 onCancelReserveSuccess) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(onCancelReserveSuccess, "onCancelReserveSuccess");
        $viewModel.dispatch(new UpcomingEpisodeAction.CancelReserveCard(String.valueOf(data.getReserveId()), onCancelReserveSuccess));
        $viewModel.dispatch(new TrackerAction.UpComingEpisodeRecommendReservationCardClick(data, CalendarCardClickArea.BUTTON));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodePage$lambda$28$0$8$0(UpcomingEpisodeViewModel $viewModel, KReserveRecommend data) {
        Intrinsics.checkNotNullParameter(data, "data");
        $viewModel.dispatch(new TrackerAction.UpComingEpisodeRecommendReservationCardShow(data));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodePage$lambda$28$0$9$0(UpcomingEpisodeViewModel $viewModel, Map map) {
        Intrinsics.checkNotNullParameter(map, "map");
        $viewModel.dispatch(new TrackerAction.UpcomingEpisodeCardShow(map));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodePage$lambda$28$0$10$0(UpcomingEpisodeViewModel $viewModel, CalendarCardClickArea clickArea, Map map) {
        Intrinsics.checkNotNullParameter(clickArea, "clickArea");
        Intrinsics.checkNotNullParameter(map, "map");
        $viewModel.dispatch(new TrackerAction.UpcomingEpisodeCardClick(clickArea, map));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodePage$lambda$28$0$11$0(BiliMonthCalendarState $monthState, UpcomingEpisodeViewModel $viewModel) {
        LocalDate retryMonthBeginDate = ((Day) CollectionsKt.first((List) CollectionsKt.first($monthState.getFirstVisibleMonth().getWeekDays()))).getDate();
        LocalDate retryMonthEndDate = ((Day) CollectionsKt.last((List) CollectionsKt.last($monthState.getFirstVisibleMonth().getWeekDays()))).getDate();
        KCalendarTimeRange retryTimeRange = new KCalendarTimeRange(BiliCalendarExtensionsKt.toTimestampSeconds(retryMonthBeginDate), BiliCalendarExtensionsKt.toEndOfDayTimestampSeconds(retryMonthEndDate));
        $viewModel.dispatch(new UpcomingEpisodeAction.WatchCalendar(retryTimeRange, RequestFrom.Manual.INSTANCE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodePage$lambda$28$0$12$0(UpcomingEpisodeViewModel $viewModel, MutableState $calendarType$delegate, CalendarType newType) {
        Intrinsics.checkNotNullParameter(newType, "newType");
        $calendarType$delegate.setValue(newType);
        $viewModel.dispatch(new TrackerAction.UpcomingEpisodeCalendarShow(newType));
        KLog_androidKt.getKLog().i(TAG, "onCalendarTypeChange. Calendar type change to " + newType);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodePage$lambda$28$0$13$0(SnapshotStateMap $pointTypeMap, SnapshotStateMap $cardListMap, MutableState $selection$delegate) {
        BiliCalendarUtilsKt.checkPointType(UpcomingEpisodePage$lambda$12($selection$delegate), $pointTypeMap, $cardListMap);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodePage$lambda$28$0$14$0(float $dialogMaxHeightPx, float $heightDiffPx, MutableFloatState $animationProgress$delegate, int newHeight) {
        $animationProgress$delegate.setFloatValue(RangesKt.coerceIn(($dialogMaxHeightPx - newHeight) / $heightDiffPx, 0.0f, 1.0f));
        return Unit.INSTANCE;
    }

    private static final void WindowConfig(final boolean isNight, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(35325011);
        ComposerKt.sourceInformation($composer2, "C(WindowConfig)N(isNight)455@20586L169:UpcomingEpisodePage.kt#jbu1nf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(isNight) ? 4 : 2;
        }
        if (!$composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(35325011, $dirty, -1, "kntr.app.upcomingEpisode.WindowConfig (UpcomingEpisodePage.kt:454)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 2136225621, "CC(ConfigWindow)N(block)20@732L7:UpcomingEpisodePageUtils.android.kt#59pppy");
            CompositionLocal this_$iv$iv = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Activity activity$iv = ContextUtilKt.findActivityOrNull((Context) consume);
            if (Build.VERSION.SDK_INT >= 30 || activity$iv == null) {
                $composer2.startReplaceGroup(1767584790);
                ComposerKt.sourceInformation($composer2, "29@1198L7");
                boolean z = false & true;
                ComposerKt.sourceInformationMarkerStart($composer2, -115110621, "C456@20626L28,457@20687L62,457@20663L86:UpcomingEpisodePage.kt#jbu1nf");
                SystemUiController controller = SystemUI_androidKt.rememberSystemUiController($composer2, 0);
                Boolean valueOf = Boolean.valueOf(isNight);
                ComposerKt.sourceInformationMarkerStart($composer2, 2074499154, "CC(remember):UpcomingEpisodePage.kt#9igjgp");
                boolean invalid$iv = $composer2.changed(controller) | (($dirty & 14) == 4);
                Object it$iv = $composer2.rememberedValue();
                if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv, $composer2, $dirty & 14);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endReplaceGroup();
                }
                Object value$iv = (Function2) new UpcomingEpisodePageKt$WindowConfig$1$1$1(controller, isNight, null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv, $composer2, $dirty & 14);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(1767232165);
                ComposerKt.sourceInformation($composer2, "22@856L13,23@925L251,23@901L275");
                boolean isNight$iv = BiliTheme.INSTANCE.getDayNightTheme($composer2, BiliTheme.$stable) == ThemeDayNight.Night;
                Boolean valueOf2 = Boolean.valueOf(isNight$iv);
                ComposerKt.sourceInformationMarkerStart($composer2, -81536656, "CC(remember):UpcomingEpisodePageUtils.android.kt#9igjgp");
                boolean invalid$iv$iv = $composer2.changedInstance(activity$iv) | $composer2.changed(isNight$iv);
                Object it$iv$iv = $composer2.rememberedValue();
                if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                    Object value$iv$iv = (Function2) new UpcomingEpisodePageUtils_androidKt$ConfigWindow$1$1(activity$iv, isNight$iv, null);
                    $composer2.updateRememberedValue(value$iv$iv);
                    it$iv$iv = value$iv$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(valueOf2, (Function2) it$iv$iv, $composer2, 0);
                $composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.upcomingEpisode.UpcomingEpisodePageKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj, Object obj2) {
                    Unit WindowConfig$lambda$1;
                    WindowConfig$lambda$1 = UpcomingEpisodePageKt.WindowConfig$lambda$1(isNight, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return WindowConfig$lambda$1;
                }
            });
        }
    }
}