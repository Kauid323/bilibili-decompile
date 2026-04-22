package kntr.app.tribee.consume.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TabKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.TextUnitKt;
import com.bapis.bilibili.app.dynamic.v2.KTribeeCategory;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import kntr.app.tribee.consume.viewmodel.track.TrackerKt;
import kntr.app.tribee.consume.widget.FlexibleScrollableTabRowKt;
import kntr.app.tribee.consume.widget.TabPosition;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeTabLayout.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001aC\u0010\u0010\u001a\u00020\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\t2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0003¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a²\u0006\n\u0010\u001b\u001a\u00020\u0007X\u008a\u0084\u0002²\u0006\n\u0010\u001c\u001a\u00020\u001dX\u008a\u0084\u0002"}, d2 = {"TribeeTabLayout", "", "tribeeId", "", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "selectedTabIndex", "", "tabs", "", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeCategory;", "modifier", "Landroidx/compose/ui/Modifier;", "onClick", "Lkotlin/Function1;", "(Ljava/lang/String;Landroidx/compose/foundation/pager/PagerState;ILjava/util/List;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "PagerTabIndicator", "tabPositions", "Lkntr/app/tribee/consume/widget/TabPosition;", "color", "Landroidx/compose/ui/graphics/Color;", "width", "Landroidx/compose/ui/unit/Dp;", "height", "PagerTabIndicator-qBIQl6Q", "(Ljava/util/List;Landroidx/compose/foundation/pager/PagerState;JFFLandroidx/compose/runtime/Composer;II)V", "consume_debug", "currentPage", "fraction", ""}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeTabLayoutKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PagerTabIndicator_qBIQl6Q$lambda$3(List list, PagerState pagerState, long j, float f, float f2, int i, int i2, Composer composer, int i3) {
        m742PagerTabIndicatorqBIQl6Q(list, pagerState, j, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeTabLayout$lambda$2(String str, PagerState pagerState, int i, List list, Modifier modifier, Function1 function1, int i2, int i3, Composer composer, int i4) {
        TribeeTabLayout(str, pagerState, i, list, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeTabLayout$lambda$0$0(int it) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v7 */
    public static final void TribeeTabLayout(final String tribeeId, final PagerState pagerState, final int selectedTabIndex, final List<KTribeeCategory> list, Modifier modifier, Function1<? super Integer, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function1 function12;
        Composer $composer2;
        Modifier modifier3;
        Function1 onClick;
        Modifier modifier4;
        final Function1 onClick2;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Intrinsics.checkNotNullParameter(list, "tabs");
        Composer $composer3 = $composer.startRestartGroup(2063469846);
        ComposerKt.sourceInformation($composer3, "C(TribeeTabLayout)N(tribeeId,pagerState,selectedTabIndex,tabs,modifier,onClick)38@1502L2,40@1514L1922:TribeeTabLayout.kt#iitu82");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(tribeeId) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(pagerState) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(selectedTabIndex) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(list) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty |= 196608;
            function12 = function1;
        } else if ((196608 & $changed) == 0) {
            function12 = function1;
            $dirty |= $composer3.changedInstance(function12) ? 131072 : 65536;
        } else {
            function12 = function1;
        }
        if (!$composer3.shouldExecute((74899 & $dirty) != 74898, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            onClick = function12;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                onClick2 = function12;
            } else {
                ComposerKt.sourceInformationMarkerStart($composer3, -1280362504, "CC(remember):TribeeTabLayout.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeTabLayoutKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            Unit TribeeTabLayout$lambda$0$0;
                            TribeeTabLayout$lambda$0$0 = TribeeTabLayoutKt.TribeeTabLayout$lambda$0$0(((Integer) obj).intValue());
                            return TribeeTabLayout$lambda$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onClick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2063469846, $dirty, -1, "kntr.app.tribee.consume.page.TribeeTabLayout (TribeeTabLayout.kt:39)");
            }
            Alignment contentAlignment$iv = Alignment.Companion.getCenterStart();
            int $changed$iv = (($dirty >> 12) & 14) | 48;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i5 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1223112591, "C49@1861L376,60@2249L1181,44@1614L1816:TribeeTabLayout.kt#iitu82");
            onClick = onClick2;
            FlexibleScrollableTabRowKt.m784FlexibleScrollableTabRowxam5sdo(selectedTabIndex, PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(2), 0.0f, 0.0f, 13, (Object) null), Color.Companion.getTransparent-0d7_KjU(), 0L, Dp.constructor-impl(0), 0.0f, ComposableLambdaKt.rememberComposableLambda(295425192, true, new Function3() { // from class: kntr.app.tribee.consume.page.TribeeTabLayoutKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit TribeeTabLayout$lambda$1$0;
                    TribeeTabLayout$lambda$1$0 = TribeeTabLayoutKt.TribeeTabLayout$lambda$1$0(pagerState, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return TribeeTabLayout$lambda$1$0;
                }
            }, $composer3, 54), null, ComposableLambdaKt.rememberComposableLambda(565216936, true, new Function2() { // from class: kntr.app.tribee.consume.page.TribeeTabLayoutKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeTabLayout$lambda$1$1;
                    TribeeTabLayout$lambda$1$1 = TribeeTabLayoutKt.TribeeTabLayout$lambda$1$1(list, selectedTabIndex, tribeeId, onClick2, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeTabLayout$lambda$1$1;
                }
            }, $composer3, 54), $composer3, (($dirty >> 6) & 14) | 102261168, 168);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            boolean propagateMinConstraints$iv = ComposerKt.isTraceInProgress();
            if (propagateMinConstraints$iv) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function1 function13 = onClick;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeTabLayoutKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeTabLayout$lambda$2;
                    TribeeTabLayout$lambda$2 = TribeeTabLayoutKt.TribeeTabLayout$lambda$2(tribeeId, pagerState, selectedTabIndex, list, modifier5, function13, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeTabLayout$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeTabLayout$lambda$1$0(PagerState $pagerState, List tabs, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(tabs, "tabs");
        ComposerKt.sourceInformation($composer, "CN(tabs):TribeeTabLayout.kt#iitu82");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(295425192, $changed, -1, "kntr.app.tribee.consume.page.TribeeTabLayout.<anonymous>.<anonymous> (TribeeTabLayout.kt:50)");
        }
        if (tabs.isEmpty()) {
            $composer.startReplaceGroup(622058266);
        } else {
            $composer.startReplaceGroup(623984265);
            ComposerKt.sourceInformation($composer, "56@2165L6,51@1932L273");
            m742PagerTabIndicatorqBIQl6Q(tabs, $pagerState, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), Dp.constructor-impl(14), Dp.constructor-impl(2), $composer, ($changed & 14) | 27648, 0);
        }
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeTabLayout$lambda$1$1(final List $tabs, final int $selectedTabIndex, final String $tribeeId, final Function1 $onClick, Composer $composer, int $changed) {
        Composer composer = $composer;
        ComposerKt.sourceInformation(composer, "C*64@2408L287,72@2750L6,73@2824L6,74@2856L550,62@2315L1091:TribeeTabLayout.kt#iitu82");
        if (!composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(565216936, $changed, -1, "kntr.app.tribee.consume.page.TribeeTabLayout.<anonymous>.<anonymous> (TribeeTabLayout.kt:61)");
            }
            List $this$forEachIndexed$iv = $tabs;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final KTribeeCategory tab = (KTribeeCategory) item$iv;
                final int index = index$iv;
                boolean z = $selectedTabIndex == index;
                ComposerKt.sourceInformationMarkerStart(composer, 960083790, "CC(remember):TribeeTabLayout.kt#9igjgp");
                boolean invalid$iv = composer.changed($tribeeId) | composer.changedInstance(tab) | composer.changed($onClick) | composer.changed(index);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeTabLayoutKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit TribeeTabLayout$lambda$1$1$0$0$0;
                            TribeeTabLayout$lambda$1$1$0$0$0 = TribeeTabLayoutKt.TribeeTabLayout$lambda$1$1$0$0$0($tribeeId, tab, $onClick, index);
                            return TribeeTabLayout$lambda$1$1$0$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                TabKt.Tab-bogVsAg(z, (Function0) it$iv, (Modifier) null, false, BiliTheme.INSTANCE.getColors(composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), BiliTheme.INSTANCE.getColors(composer, BiliTheme.$stable).getText2-0d7_KjU(), (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(1618912188, true, new Function3() { // from class: kntr.app.tribee.consume.page.TribeeTabLayoutKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit TribeeTabLayout$lambda$1$1$0$1;
                        TribeeTabLayout$lambda$1$1$0$1 = TribeeTabLayoutKt.TribeeTabLayout$lambda$1$1$0$1(tab, index, $tabs, $selectedTabIndex, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return TribeeTabLayout$lambda$1$1$0$1;
                    }
                }, composer, 54), $composer, 12582912, 76);
                composer = $composer;
                index$iv = index$iv2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeTabLayout$lambda$1$1$0$0$0(String $tribeeId, KTribeeCategory $tab, Function1 $onClick, int $index) {
        TrackerKt.categoryContentClick($tribeeId, $tab.getId(), $tab.getName());
        $onClick.invoke(Integer.valueOf($index));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeTabLayout$lambda$1$1$0$1(KTribeeCategory $tab, int $index, List $tabs, int $selectedTabIndex, ColumnScope $this$Tab, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Tab, "$this$Tab");
        ComposerKt.sourceInformation($composer, "C75@2878L510:TribeeTabLayout.kt#iitu82");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1618912188, $changed, -1, "kntr.app.tribee.consume.page.TribeeTabLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TribeeTabLayout.kt:75)");
            }
            TextKt.Text-Nvy7gAk($tab.getName(), PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(5), 7, (Object) null), $index == 0 ? Dp.constructor-impl(12) : Dp.constructor-impl(14), 0.0f, 0.0f, 0.0f, 14, (Object) null), 0.0f, 0.0f, $index == $tabs.size() - 1 ? Dp.constructor-impl(14) : Dp.constructor-impl(12), 0.0f, 11, (Object) null), 0L, (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, $index == $selectedTabIndex ? FontWeight.Companion.getBold() : null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 24576, 0, 262060);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x0166, code lost:
        if (r1 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L51;
     */
    /* renamed from: PagerTabIndicator-qBIQl6Q  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m742PagerTabIndicatorqBIQl6Q(final List<TabPosition> list, final PagerState pagerState, long j, float f, float f2, Composer $composer, final int $changed, final int i) {
        long j2;
        float f3;
        float f4;
        long j3;
        float f5;
        long j4;
        Composer $composer2 = $composer.startRestartGroup(-1781347892);
        ComposerKt.sourceInformation($composer2, "C(PagerTabIndicator)N(tabPositions,pagerState,color:c#ui.graphics.Color,width:c#ui.unit.Dp,height:c#ui.unit.Dp)99@3652L55,100@3728L69,106@4037L931,104@3969L1006:TribeeTabLayout.kt#iitu82");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(pagerState) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            j2 = j;
        } else if (($changed & 384) == 0) {
            j2 = j;
            $dirty |= $composer2.changed(j2) ? 256 : 128;
        } else {
            j2 = j;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            f3 = f;
        } else if (($changed & 3072) == 0) {
            f3 = f;
            $dirty |= $composer2.changed(f3) ? 2048 : 1024;
        } else {
            f3 = f;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            f4 = f2;
        } else if (($changed & 24576) == 0) {
            f4 = f2;
            $dirty |= $composer2.changed(f4) ? 16384 : 8192;
        } else {
            f4 = f2;
        }
        if ($composer2.shouldExecute(($dirty & 9363) != 9362, $dirty & 1)) {
            if (i2 != 0) {
                j4 = Color.Companion.getWhite-0d7_KjU();
            } else {
                j4 = j2;
            }
            if (i3 != 0) {
                f3 = Dp.constructor-impl(8);
            }
            if (i4 != 0) {
                f4 = Dp.constructor-impl(5);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1781347892, $dirty, -1, "kntr.app.tribee.consume.page.PagerTabIndicator (TribeeTabLayout.kt:98)");
            }
            State currentPage$delegate = SnapshotStateKt.rememberUpdatedState(Integer.valueOf(pagerState.getCurrentPage()), $composer2, 0);
            final State fraction$delegate = SnapshotStateKt.rememberUpdatedState(Float.valueOf(pagerState.getCurrentPageOffsetFraction()), $composer2, 0);
            final TabPosition currentTab = list.get(PagerTabIndicator_qBIQl6Q$lambda$0(currentPage$delegate));
            final TabPosition previousTab = (TabPosition) CollectionsKt.getOrNull(list, PagerTabIndicator_qBIQl6Q$lambda$0(currentPage$delegate) - 1);
            final TabPosition nextTab = (TabPosition) CollectionsKt.getOrNull(list, PagerTabIndicator_qBIQl6Q$lambda$0(currentPage$delegate) + 1);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1816646287, "CC(remember):TribeeTabLayout.kt#9igjgp");
            boolean invalid$iv = (($dirty & 7168) == 2048) | $composer2.changed(fraction$delegate) | $composer2.changed(nextTab) | $composer2.changed(currentTab) | $composer2.changed(previousTab) | (($dirty & 896) == 256) | ((57344 & $dirty) == 16384);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            final float f6 = f3;
            final long j5 = j4;
            final float f7 = f4;
            Object value$iv = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeTabLayoutKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj) {
                    Unit PagerTabIndicator_qBIQl6Q$lambda$2$0;
                    PagerTabIndicator_qBIQl6Q$lambda$2$0 = TribeeTabLayoutKt.PagerTabIndicator_qBIQl6Q$lambda$2$0(f6, nextTab, currentTab, previousTab, j5, f7, fraction$delegate, (DrawScope) obj);
                    return PagerTabIndicator_qBIQl6Q$lambda$2$0;
                }
            };
            $composer2.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(fillMaxSize$default, (Function1) it$iv, $composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j3 = j4;
            f5 = f3;
        } else {
            $composer2.skipToGroupEnd();
            j3 = j2;
            f5 = f3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final long j6 = j3;
            final float f8 = f5;
            final float f9 = f4;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeTabLayoutKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit PagerTabIndicator_qBIQl6Q$lambda$3;
                    PagerTabIndicator_qBIQl6Q$lambda$3 = TribeeTabLayoutKt.PagerTabIndicator_qBIQl6Q$lambda$3(list, pagerState, j6, f8, f9, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PagerTabIndicator_qBIQl6Q$lambda$3;
                }
            });
        }
    }

    private static final int PagerTabIndicator_qBIQl6Q$lambda$0(State<Integer> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).intValue();
    }

    private static final float PagerTabIndicator_qBIQl6Q$lambda$1(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PagerTabIndicator_qBIQl6Q$lambda$2$0(float f, TabPosition $nextTab, TabPosition $currentTab, TabPosition $previousTab, long j, float f2, State $fraction$delegate, DrawScope $this$Canvas) {
        float f3;
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        float indicatorWidth = $this$Canvas.toPx-0680j_4(f);
        if (PagerTabIndicator_qBIQl6Q$lambda$1($fraction$delegate) > 0.0f && $nextTab != null) {
            f3 = $this$Canvas.toPx-0680j_4(DpKt.lerp-Md-fbLM($currentTab.m786getLeftD9Ej5fM(), $nextTab.m786getLeftD9Ej5fM(), PagerTabIndicator_qBIQl6Q$lambda$1($fraction$delegate)));
        } else if (PagerTabIndicator_qBIQl6Q$lambda$1($fraction$delegate) < 0.0f && $previousTab != null) {
            f3 = $this$Canvas.toPx-0680j_4(DpKt.lerp-Md-fbLM($currentTab.m786getLeftD9Ej5fM(), $previousTab.m786getLeftD9Ej5fM(), -PagerTabIndicator_qBIQl6Q$lambda$1($fraction$delegate)));
        } else {
            f3 = $this$Canvas.toPx-0680j_4($currentTab.m786getLeftD9Ej5fM());
        }
        float indicatorOffset = f3;
        int bits$iv$iv$iv = (int) ($this$Canvas.getSize-NH-jbRc() & 4294967295L);
        float canvasHeight = Float.intBitsToFloat(bits$iv$iv$iv);
        float x$iv = indicatorOffset + (($this$Canvas.toPx-0680j_4($currentTab.m788getWidthD9Ej5fM()) - indicatorWidth) / 2);
        float y$iv = canvasHeight - $this$Canvas.toPx-0680j_4(f2);
        long v1$iv$iv = Float.floatToRawIntBits(x$iv);
        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
        long j2 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        float x$iv2 = PagerTabIndicator_qBIQl6Q$lambda$1($fraction$delegate);
        float width$iv = indicatorWidth + (Math.abs(x$iv2) * indicatorWidth);
        float height$iv = $this$Canvas.toPx-0680j_4(f2);
        long v1$iv$iv2 = Float.floatToRawIntBits(width$iv);
        long v2$iv$iv2 = Float.floatToRawIntBits(height$iv);
        long j3 = Size.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv2 & 4294967295L));
        long v1$iv$iv3 = Float.floatToRawIntBits(50.0f);
        long v2$iv$iv3 = Float.floatToRawIntBits(50.0f);
        DrawScope.-CC.drawRoundRect-u-Aw5IA$default($this$Canvas, j, j2, j3, CornerRadius.constructor-impl((v1$iv$iv3 << 32) | (v2$iv$iv3 & 4294967295L)), (DrawStyle) null, 0.0f, (ColorFilter) null, 0, 240, (Object) null);
        return Unit.INSTANCE;
    }
}