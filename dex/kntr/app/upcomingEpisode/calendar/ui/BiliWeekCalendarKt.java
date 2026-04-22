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
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarPointType;
import java.util.Iterator;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.calendar.model.Week;
import kntr.app.upcomingEpisode.calendar.model.WeekDay;
import kntr.app.upcomingEpisode.calendar.utils.BiliWeekCalendarState;
import kntr.app.upcomingEpisode.calendar.utils.BiliWeekCalendarStateKt;
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

/* compiled from: BiliWeekCalendar.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0083\u0001\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\n¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0013\b\u0002\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\n2\u0013\b\u0002\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"BiliWeekCalendar", "", "dateToPointTypeMap", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "Lkotlinx/datetime/LocalDate;", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarPointType;", "dayContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/layout/BoxScope;", "Lkntr/app/upcomingEpisode/calendar/model/WeekDay;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Lkntr/app/upcomingEpisode/calendar/utils/BiliWeekCalendarState;", "mainHeader", "Lkotlin/Function0;", "subHeader", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;Lkotlin/jvm/functions/Function4;Landroidx/compose/ui/Modifier;Lkntr/app/upcomingEpisode/calendar/utils/BiliWeekCalendarState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "main_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BiliWeekCalendarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BiliWeekCalendar$lambda$1(SnapshotStateMap snapshotStateMap, Function4 function4, Modifier modifier, BiliWeekCalendarState biliWeekCalendarState, Function2 function2, Function2 function22, int i, int i2, Composer composer, int i3) {
        BiliWeekCalendar(snapshotStateMap, function4, modifier, biliWeekCalendarState, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x02b9, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L69;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BiliWeekCalendar(final SnapshotStateMap<LocalDate, KCalendarPointType> snapshotStateMap, final Function4<? super BoxScope, ? super WeekDay, ? super Composer, ? super Integer, Unit> function4, Modifier modifier, BiliWeekCalendarState state, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final BiliWeekCalendarState state2;
        Function2 mainHeader;
        Function2 subHeader;
        Function2 mainHeader2;
        Function2 subHeader2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        int i2;
        Intrinsics.checkNotNullParameter(snapshotStateMap, "dateToPointTypeMap");
        Intrinsics.checkNotNullParameter(function4, "dayContent");
        Composer $composer2 = $composer.startRestartGroup(2076870341);
        ComposerKt.sourceInformation($composer2, "C(BiliWeekCalendar)N(dateToPointTypeMap,dayContent,modifier,state,mainHeader,subHeader)44@1807L1893:BiliWeekCalendar.kt#4t4v7p");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(snapshotStateMap) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 32 : 16;
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
            ComposerKt.sourceInformation($composer2, "40@1677L31");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
            } else {
                if (i3 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                    state2 = BiliWeekCalendarStateKt.rememberBiliWeekCalendarState(null, null, null, null, $composer2, 0, 15);
                }
                Function2 mainHeader3 = i4 != 0 ? ComposableSingletons$BiliWeekCalendarKt.INSTANCE.getLambda$549351033$main_debug() : function2;
                if (i5 != 0) {
                    mainHeader = mainHeader3;
                    subHeader = ComposableSingletons$BiliWeekCalendarKt.INSTANCE.getLambda$1327286502$main_debug();
                    modifier2 = modifier4;
                } else {
                    subHeader = function22;
                    mainHeader = mainHeader3;
                    modifier2 = modifier4;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2076870341, $dirty2, -1, "kntr.app.upcomingEpisode.calendar.ui.BiliWeekCalendar (BiliWeekCalendar.kt:43)");
            }
            int $changed$iv = ($dirty2 >> 6) & 14;
            Modifier modifier$iv = modifier2;
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            modifier3 = modifier2;
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
            ComposerKt.sourceInformationMarkerStart($composer2, -342416066, "C47@1860L12,48@1881L11,51@1975L35,52@2022L1672,49@1901L1793:BiliWeekCalendar.kt#4t4v7p");
            mainHeader.invoke($composer2, Integer.valueOf(($dirty2 >> 12) & 14));
            subHeader.invoke($composer2, Integer.valueOf(($dirty2 >> 15) & 14));
            LazyListState listState$main_debug = state2.getListState$main_debug();
            FlingBehavior pagedFlingBehavior = FlingBehaviorKt.pagedFlingBehavior(state2.getListState$main_debug(), $composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, 681696003, "CC(remember):BiliWeekCalendar.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 14) == 4) | (((($dirty2 & 7168) ^ 3072) > 2048 && $composer2.changed(state2)) || ($dirty2 & 3072) == 2048) | (($dirty2 & 112) == 32);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function1() { // from class: kntr.app.upcomingEpisode.calendar.ui.BiliWeekCalendarKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit BiliWeekCalendar$lambda$0$0$0;
                    BiliWeekCalendar$lambda$0$0$0 = BiliWeekCalendarKt.BiliWeekCalendar$lambda$0$0$0(BiliWeekCalendarState.this, snapshotStateMap, function4, (LazyListScope) obj);
                    return BiliWeekCalendar$lambda$0$0$0;
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
            subHeader2 = subHeader;
            mainHeader2 = mainHeader;
        } else {
            $composer2.skipToGroupEnd();
            mainHeader2 = function2;
            subHeader2 = function22;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final BiliWeekCalendarState biliWeekCalendarState = state2;
            final Function2 function23 = mainHeader2;
            final Function2 function24 = subHeader2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.upcomingEpisode.calendar.ui.BiliWeekCalendarKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit BiliWeekCalendar$lambda$1;
                    BiliWeekCalendar$lambda$1 = BiliWeekCalendarKt.BiliWeekCalendar$lambda$1(snapshotStateMap, function4, modifier5, biliWeekCalendarState, function23, function24, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BiliWeekCalendar$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BiliWeekCalendar$lambda$0$0$0(final BiliWeekCalendarState $state, final SnapshotStateMap $dateToPointTypeMap, final Function4 $dayContent, LazyListScope $this$LazyRow) {
        Intrinsics.checkNotNullParameter($this$LazyRow, "$this$LazyRow");
        LazyListScope.-CC.items$default($this$LazyRow, $state.getTotalWeekCounts$main_debug(), new Function1() { // from class: kntr.app.upcomingEpisode.calendar.ui.BiliWeekCalendarKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Object BiliWeekCalendar$lambda$0$0$0$0;
                BiliWeekCalendar$lambda$0$0$0$0 = BiliWeekCalendarKt.BiliWeekCalendar$lambda$0$0$0$0(BiliWeekCalendarState.this, ((Integer) obj).intValue());
                return BiliWeekCalendar$lambda$0$0$0$0;
            }
        }, (Function1) null, ComposableLambdaKt.composableLambdaInstance(1318251919, true, new Function4() { // from class: kntr.app.upcomingEpisode.calendar.ui.BiliWeekCalendarKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit BiliWeekCalendar$lambda$0$0$0$1;
                BiliWeekCalendar$lambda$0$0$0$1 = BiliWeekCalendarKt.BiliWeekCalendar$lambda$0$0$0$1(BiliWeekCalendarState.this, $dateToPointTypeMap, $dayContent, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                return BiliWeekCalendar$lambda$0$0$0$1;
            }
        }), 4, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object BiliWeekCalendar$lambda$0$0$0$0(BiliWeekCalendarState $state, int offset) {
        return DateFormatExtentionsKt.toIso8601String(((WeekDay) CollectionsKt.first($state.getStore$main_debug().get(Integer.valueOf(offset)).getDays())).getDate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BiliWeekCalendar$lambda$0$0$0$1(BiliWeekCalendarState $state, SnapshotStateMap $dateToPointTypeMap, Function4 $dayContent, LazyItemScope $this$items, int offset, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        WeekDay newDay;
        Function0 factory$iv$iv$iv2;
        SnapshotStateMap snapshotStateMap = $dateToPointTypeMap;
        Intrinsics.checkNotNullParameter($this$items, "$this$items");
        ComposerKt.sourceInformation($composer, "CN(offset)64@2408L1262:BiliWeekCalendar.kt#4t4v7p");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$items) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(offset) ? 32 : 16;
        }
        if ($composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1318251919, $dirty, -1, "kntr.app.upcomingEpisode.calendar.ui.BiliWeekCalendar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BiliWeekCalendar.kt:63)");
            }
            Week week = $state.getStore$main_debug().get(Integer.valueOf(offset));
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0(LazyItemScope.-CC.fillParentMaxWidth$default($this$items, Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(4), Dp.constructor-impl(12), Dp.constructor-impl(12));
            boolean z = false;
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            String str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            String str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            boolean z2 = false;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i2 = ((0 >> 6) & 112) | 6;
            RowScope $this$BiliWeekCalendar_u24lambda_u240_u240_u240_u241_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -178447240, "C:BiliWeekCalendar.kt#4t4v7p");
            $composer.startReplaceGroup(1795358955);
            ComposerKt.sourceInformation($composer, "*82@3189L286");
            Iterator it = week.getDays().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                int column = i3;
                int i4 = i3 + 1;
                Iterator it2 = it;
                WeekDay day = (WeekDay) it.next();
                if (snapshotStateMap.get(day.getDate()) != null) {
                    Object obj = snapshotStateMap.get(day.getDate());
                    Intrinsics.checkNotNull(obj);
                    newDay = day.copyWithPointType((KCalendarPointType) obj);
                } else {
                    newDay = day;
                }
                Modifier modifier$iv2 = ClipKt.clipToBounds(RowScope.-CC.weight$default($this$BiliWeekCalendar_u24lambda_u240_u240_u240_u241_u240, Modifier.Companion, 1.0f, false, 2, (Object) null));
                int compositeKeyHash$iv$iv2 = compositeKeyHash$iv$iv;
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, str);
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                String str3 = str;
                boolean z3 = z;
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = ((((0 << 3) & 112) << 6) & 896) | 6;
                boolean z4 = z2;
                MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, str2);
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer.useNode();
                }
                String str4 = str2;
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
                int $changed$iv$iv2 = $changed$iv$iv;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope $this$BiliWeekCalendar_u24lambda_u240_u240_u240_u241_u240_u240 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, 390300443, "C88@3431L18:BiliWeekCalendar.kt#4t4v7p");
                $dayContent.invoke($this$BiliWeekCalendar_u24lambda_u240_u240_u240_u241_u240_u240, newDay, $composer, Integer.valueOf((((0 >> 6) & 112) | 6) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if (column != CollectionsKt.getLastIndex(week.getDays())) {
                    $composer.startReplaceGroup(-177760808);
                    ComposerKt.sourceInformation($composer, "91@3565L39");
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer, 6);
                    $composer.endReplaceGroup();
                } else {
                    $composer.startReplaceGroup(-181271465);
                    $composer.endReplaceGroup();
                }
                snapshotStateMap = $dateToPointTypeMap;
                measurePolicy$iv$iv = measurePolicy$iv$iv2;
                it = it2;
                i3 = i4;
                compositeKeyHash$iv$iv = compositeKeyHash$iv$iv2;
                z = z3;
                str = str3;
                str2 = str4;
                z2 = z4;
                $changed$iv$iv = $changed$iv$iv2;
            }
            $composer.endReplaceGroup();
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