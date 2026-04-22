package kntr.app.upcomingEpisode.calendar.ui;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarPointType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.calendar.model.Day;
import kntr.app.upcomingEpisode.calendar.model.Month;
import kntr.app.upcomingEpisode.calendar.utils.BiliMonthCalendarState;
import kntr.app.upcomingEpisode.calendar.utils.BiliMonthCalendarStateKt;
import kntr.app.upcomingEpisode.calendar.utils.DateFormatExtentionsKt;
import kntr.app.upcomingEpisode.calendar.utils.FlingBehaviorKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDate;

/* compiled from: BiliMonthCalendar.kt */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0083\u0001\u0010\u0000\u001a\u00020\u00012\"\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0013\b\u0002\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u00062\u0013\b\u0002\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\u0013\u001at\u0010\u0014\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d0\u00192\"\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u0007H\u0000¢\u0006\u0002\u0010\u001e¨\u0006\u001f"}, d2 = {"BiliMonthCalendar", "", "dayContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/layout/BoxScope;", "Lkntr/app/upcomingEpisode/calendar/model/Day;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "dateToPointType", "", "Lkotlinx/datetime/LocalDate;", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarPointType;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Lkntr/app/upcomingEpisode/calendar/utils/BiliMonthCalendarState;", "mainHeader", "Lkotlin/Function0;", "subHeader", "(Lkotlin/jvm/functions/Function4;Ljava/util/Map;Landroidx/compose/ui/Modifier;Lkntr/app/upcomingEpisode/calendar/utils/BiliMonthCalendarState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "calendarMonths", "Landroidx/compose/foundation/lazy/LazyListScope;", "monthCount", "", "monthData", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "offset", "Lkntr/app/upcomingEpisode/calendar/model/Month;", "(Landroidx/compose/foundation/lazy/LazyListScope;ILjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "main_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BiliMonthCalendarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BiliMonthCalendar$lambda$1(Function4 function4, Map map, Modifier modifier, BiliMonthCalendarState biliMonthCalendarState, Function2 function2, Function2 function22, int i, int i2, Composer composer, int i3) {
        BiliMonthCalendar(function4, map, modifier, biliMonthCalendarState, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x02b0, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BiliMonthCalendar(final Function4<? super BoxScope, ? super Day, ? super Composer, ? super Integer, Unit> function4, final Map<LocalDate, ? extends KCalendarPointType> map, Modifier modifier, BiliMonthCalendarState state, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final BiliMonthCalendarState state2;
        Function2 mainHeader;
        Function2 subHeader;
        Function2 mainHeader2;
        Modifier modifier3;
        Function2 function23;
        Function0 factory$iv$iv$iv;
        int i2;
        Intrinsics.checkNotNullParameter(function4, "dayContent");
        Intrinsics.checkNotNullParameter(map, "dateToPointType");
        Composer $composer2 = $composer.startRestartGroup(939657756);
        ComposerKt.sourceInformation($composer2, "C(BiliMonthCalendar)N(dayContent,dateToPointType,modifier,state,mainHeader,subHeader)41@1764L472:BiliMonthCalendar.kt#4t4v7p");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(map) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                state2 = state;
                if ($composer2.changed(state2)) {
                    i2 = 2048;
                    $dirty |= i2;
                }
            } else {
                state2 = state;
            }
            i2 = 1024;
            $dirty |= i2;
        } else {
            state2 = state;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            mainHeader = function2;
        } else if (($changed & 24576) == 0) {
            mainHeader = function2;
            $dirty |= $composer2.changedInstance(mainHeader) ? 16384 : 8192;
        } else {
            mainHeader = function2;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty |= 196608;
            subHeader = function22;
        } else if ((196608 & $changed) == 0) {
            subHeader = function22;
            $dirty |= $composer2.changedInstance(subHeader) ? 131072 : 65536;
        } else {
            subHeader = function22;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "37@1633L32");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                modifier3 = modifier2;
            } else {
                if (i3 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                    state2 = BiliMonthCalendarStateKt.rememberBiliMonthCalendarState(null, null, null, null, $composer2, 0, 15);
                }
                Function2 mainHeader3 = i4 != 0 ? ComposableSingletons$BiliMonthCalendarKt.INSTANCE.m1215getLambda$1005698352$main_debug() : function2;
                if (i5 != 0) {
                    mainHeader = mainHeader3;
                    subHeader = ComposableSingletons$BiliMonthCalendarKt.INSTANCE.m1216getLambda$740732547$main_debug();
                } else {
                    subHeader = function22;
                    mainHeader = mainHeader3;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(939657756, $dirty2, -1, "kntr.app.upcomingEpisode.calendar.ui.BiliMonthCalendar (BiliMonthCalendar.kt:40)");
            }
            int $changed$iv = ($dirty2 >> 6) & 14;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i7 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 187356916, "C44@1817L12,45@1838L11,48@1932L35,49@1979L251,46@1858L372:BiliMonthCalendar.kt#4t4v7p");
            mainHeader.invoke($composer2, Integer.valueOf(($dirty2 >> 12) & 14));
            subHeader.invoke($composer2, Integer.valueOf(($dirty2 >> 15) & 14));
            LazyListState listState$main_debug = state2.getListState$main_debug();
            FlingBehavior pagedFlingBehavior = FlingBehaviorKt.pagedFlingBehavior(state2.getListState$main_debug(), $composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, -409593203, "CC(remember):BiliMonthCalendar.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(map) | (((($dirty2 & 7168) ^ 3072) > 2048 && $composer2.changed(state2)) || ($dirty2 & 3072) == 2048) | (($dirty2 & 14) == 4);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function1() { // from class: kntr.app.upcomingEpisode.calendar.ui.BiliMonthCalendarKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit BiliMonthCalendar$lambda$0$0$0;
                    BiliMonthCalendar$lambda$0$0$0 = BiliMonthCalendarKt.BiliMonthCalendar$lambda$0$0$0(BiliMonthCalendarState.this, map, function4, (LazyListScope) obj);
                    return BiliMonthCalendar$lambda$0$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyDslKt.LazyRow((Modifier) null, listState$main_debug, (PaddingValues) null, false, (Arrangement.Horizontal) null, (Alignment.Vertical) null, pagedFlingBehavior, false, (OverscrollEffect) null, (Function1) it$iv, $composer2, 0, 445);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function23 = subHeader;
            mainHeader2 = mainHeader;
        } else {
            $composer2.skipToGroupEnd();
            mainHeader2 = function2;
            modifier3 = modifier2;
            function23 = function22;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final BiliMonthCalendarState biliMonthCalendarState = state2;
            final Function2 function24 = mainHeader2;
            final Function2 function25 = function23;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.upcomingEpisode.calendar.ui.BiliMonthCalendarKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit BiliMonthCalendar$lambda$1;
                    BiliMonthCalendar$lambda$1 = BiliMonthCalendarKt.BiliMonthCalendar$lambda$1(function4, map, modifier4, biliMonthCalendarState, function24, function25, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BiliMonthCalendar$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BiliMonthCalendar$lambda$0$0$0(BiliMonthCalendarState $state, Map $dateToPointType, Function4 $dayContent, LazyListScope $this$LazyRow) {
        Intrinsics.checkNotNullParameter($this$LazyRow, "$this$LazyRow");
        calendarMonths($this$LazyRow, $state.getCalendarInfo$main_debug().getIndexCount(), $dateToPointType, new BiliMonthCalendarKt$BiliMonthCalendar$1$1$1$1($state.getStore$main_debug()), $dayContent);
        return Unit.INSTANCE;
    }

    public static final void calendarMonths(LazyListScope $this$calendarMonths, int monthCount, final Map<LocalDate, ? extends KCalendarPointType> map, final Function1<? super Integer, Month> function1, final Function4<? super BoxScope, ? super Day, ? super Composer, ? super Integer, Unit> function4) {
        Intrinsics.checkNotNullParameter($this$calendarMonths, "<this>");
        Intrinsics.checkNotNullParameter(map, "dateToPointType");
        Intrinsics.checkNotNullParameter(function1, "monthData");
        Intrinsics.checkNotNullParameter(function4, "dayContent");
        LazyListScope.-CC.items$default($this$calendarMonths, monthCount, new Function1() { // from class: kntr.app.upcomingEpisode.calendar.ui.BiliMonthCalendarKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Object calendarMonths$lambda$0;
                calendarMonths$lambda$0 = BiliMonthCalendarKt.calendarMonths$lambda$0(function1, ((Integer) obj).intValue());
                return calendarMonths$lambda$0;
            }
        }, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-1524707773, true, new Function4() { // from class: kntr.app.upcomingEpisode.calendar.ui.BiliMonthCalendarKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit calendarMonths$lambda$1;
                calendarMonths$lambda$1 = BiliMonthCalendarKt.calendarMonths$lambda$1(function1, map, function4, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                return calendarMonths$lambda$1;
            }
        }), 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object calendarMonths$lambda$0(Function1 $monthData, int offset) {
        return DateFormatExtentionsKt.toIso8601String(((Month) $monthData.invoke(Integer.valueOf(offset))).getYearMonth());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit calendarMonths$lambda$1(Function1 $monthData, Map $dateToPointType, Function4 $dayContent, LazyItemScope $this$items, int offset, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Day newDay;
        Function0 factory$iv$iv$iv5;
        Map map = $dateToPointType;
        Intrinsics.checkNotNullParameter($this$items, "$this$items");
        ComposerKt.sourceInformation($composer, "CN(offset)71@2634L2271:BiliMonthCalendar.kt#4t4v7p");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$items) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(offset) ? 32 : 16;
        }
        if ($composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1524707773, $dirty, -1, "kntr.app.upcomingEpisode.calendar.ui.calendarMonths.<anonymous> (BiliMonthCalendar.kt:70)");
            }
            Month month = (Month) $monthData.invoke(Integer.valueOf(offset));
            String str = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            String str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            String str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            String str4 = "C72@3469L9:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -52095549, "C72@2652L2243:BiliMonthCalendar.kt#4t4v7p");
            Modifier modifier$iv2 = SizeKt.wrapContentHeight$default(LazyItemScope.-CC.fillParentMaxWidth$default($this$items, Modifier.Companion, 0.0f, 1, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1604568003, "C78@2840L2041:BiliMonthCalendar.kt#4t4v7p");
            Modifier modifier$iv3 = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null);
            boolean z = true;
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv3 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            Composer $composer$iv$iv$iv = $composer;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv$iv$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv$iv$iv.startReusableNode();
            if ($composer$iv$iv$iv.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                $composer$iv$iv$iv.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                $composer$iv$iv$iv.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer$iv$iv$iv);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            Composer $composer$iv = $composer$iv$iv$iv;
            boolean z2 = false;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i6 = ((6 >> 6) & 112) | 6;
            String str5 = "C:BiliMonthCalendar.kt#4t4v7p";
            Composer $composer2 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer2, -268828647, "C:BiliMonthCalendar.kt#4t4v7p");
            $composer2.startReplaceGroup(2069538090);
            ComposerKt.sourceInformation($composer2, "*86@3151L1690");
            Iterator it = month.getWeekDays().iterator();
            int i7 = 0;
            while (it.hasNext()) {
                int row = i7;
                CompositionLocalMap localMap$iv$iv4 = localMap$iv$iv3;
                i7++;
                List week = (List) it.next();
                Iterator it2 = it;
                boolean z3 = z2;
                int $changed$iv$iv$iv4 = $changed$iv$iv$iv3;
                Modifier materialized$iv$iv4 = materialized$iv$iv3;
                Month month2 = month;
                Modifier modifier$iv4 = PaddingKt.padding-qDBjuR0(SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(4), Dp.constructor-impl(12), row == CollectionsKt.getLastIndex(month.getWeekDays()) ? Dp.constructor-impl(12) : Dp.constructor-impl(0));
                Composer $composer$iv2 = $composer2;
                boolean z4 = false;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                int $i$f$Row = ((0 >> 3) & 14) | ((0 >> 3) & 112);
                MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer$iv2, $i$f$Row);
                int $changed$iv$iv4 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -1159599143, str2);
                int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv2, 0));
                CompositionLocalMap localMap$iv$iv5 = $composer$iv2.getCurrentCompositionLocalMap();
                boolean z5 = z;
                Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer$iv2, modifier$iv4);
                Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv5 = (($changed$iv$iv4 << 6) & 896) | 6;
                Composer $composer$iv$iv$iv2 = $composer$iv$iv$iv;
                Composer $composer$iv$iv$iv3 = $composer$iv;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -553112988, str3);
                if (!($composer$iv2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv2.startReusableNode();
                if ($composer$iv2.getInserting()) {
                    factory$iv$iv$iv4 = factory$iv$iv$iv9;
                    $composer$iv2.createNode(factory$iv$iv$iv4);
                } else {
                    factory$iv$iv$iv4 = factory$iv$iv$iv9;
                    $composer$iv2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer$iv2);
                Composer $composer3 = $composer2;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                int i8 = ($changed$iv$iv$iv5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i9 = ((0 >> 6) & 112) | 6;
                RowScope $this$calendarMonths_u24lambda_u241_u240_u240_u240_u240 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -1677641000, str5);
                $composer$iv2.startReplaceGroup(-1439590773);
                ComposerKt.sourceInformation($composer$iv2, "*107@4269L342");
                Iterator it3 = week.iterator();
                int i10 = 0;
                while (it3.hasNext()) {
                    int column = i10;
                    int i11 = i10 + 1;
                    String str6 = str5;
                    Day day = (Day) it3.next();
                    Iterator it4 = it3;
                    if (map.get(day.getDate()) != null) {
                        Object obj = map.get(day.getDate());
                        Intrinsics.checkNotNull(obj);
                        newDay = day.copyWithPointType((KCalendarPointType) obj);
                    } else {
                        newDay = day;
                    }
                    Modifier modifier$iv5 = ClipKt.clipToBounds(RowScope.-CC.weight$default($this$calendarMonths_u24lambda_u241_u240_u240_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null));
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, 1042775818, str);
                    Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                    int compositeKeyHash$iv$iv5 = compositeKeyHash$iv$iv4;
                    MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                    int $changed$iv$iv5 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -1159599143, str2);
                    int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv2, 0));
                    CompositionLocalMap localMap$iv$iv6 = $composer$iv2.getCurrentCompositionLocalMap();
                    String str7 = str2;
                    boolean z6 = z4;
                    Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer$iv2, modifier$iv5);
                    Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv6 = (($changed$iv$iv5 << 6) & 896) | 6;
                    CompositionLocalMap localMap$iv$iv7 = localMap$iv$iv5;
                    String str8 = str;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -553112988, str3);
                    if (!($composer$iv2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer$iv2.startReusableNode();
                    if ($composer$iv2.getInserting()) {
                        factory$iv$iv$iv5 = factory$iv$iv$iv10;
                        $composer$iv2.createNode(factory$iv$iv$iv5);
                    } else {
                        factory$iv$iv$iv5 = factory$iv$iv$iv10;
                        $composer$iv2.useNode();
                    }
                    String str9 = str3;
                    Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer$iv2);
                    int $changed$iv$iv$iv7 = $changed$iv$iv$iv5;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                    int i12 = ($changed$iv$iv$iv6 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, 1833054614, str4);
                    BoxScope $this$calendarMonths_u24lambda_u241_u240_u240_u240_u240_u240 = BoxScopeInstance.INSTANCE;
                    String str10 = str4;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -972981056, "C113@4559L18:BiliMonthCalendar.kt#4t4v7p");
                    $dayContent.invoke($this$calendarMonths_u24lambda_u241_u240_u240_u240_u240_u240, newDay, $composer$iv2, Integer.valueOf((((0 >> 6) & 112) | 6) & 14));
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    $composer$iv2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    if (column != CollectionsKt.getLastIndex(week)) {
                        $composer$iv2.startReplaceGroup(-1676753006);
                        ComposerKt.sourceInformation($composer$iv2, "116@4712L39");
                        SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer$iv2, 6);
                        $composer$iv2.endReplaceGroup();
                    } else {
                        $composer$iv2.startReplaceGroup(-1681394047);
                        $composer$iv2.endReplaceGroup();
                    }
                    map = $dateToPointType;
                    str = str8;
                    compositeKeyHash$iv$iv4 = compositeKeyHash$iv$iv5;
                    i10 = i11;
                    str5 = str6;
                    it3 = it4;
                    z4 = z6;
                    str2 = str7;
                    str3 = str9;
                    localMap$iv$iv5 = localMap$iv$iv7;
                    $changed$iv$iv$iv5 = $changed$iv$iv$iv7;
                    str4 = str10;
                }
                $composer$iv2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer$iv2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                map = $dateToPointType;
                $changed$iv$iv$iv3 = $changed$iv$iv$iv4;
                month = month2;
                localMap$iv$iv3 = localMap$iv$iv4;
                it = it2;
                z2 = z3;
                materialized$iv$iv3 = materialized$iv$iv4;
                z = z5;
                $composer$iv = $composer$iv$iv$iv3;
                $composer$iv$iv$iv = $composer$iv$iv$iv2;
                $composer2 = $composer3;
                str2 = str2;
                str4 = str4;
            }
            Composer $composer4 = $composer2;
            Composer $composer$iv$iv$iv4 = $composer$iv$iv$iv;
            $composer4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}