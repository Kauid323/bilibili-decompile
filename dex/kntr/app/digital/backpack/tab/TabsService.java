package kntr.app.digital.backpack.tab;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TabKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
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
import androidx.compose.ui.graphics.ColorKt;
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
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.ogv.bdesign.tab.TabPosition;
import com.bilibili.ogv.bdesign.tab.XXScrollableTabRowKt;
import java.util.List;
import javax.inject.Inject;
import kntr.app.digital.backpack.di.BusinessScope;
import kntr.app.digital.backpack.lottery.LotterySelectedService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.HostConfiguration;
import kntr.common.komponent.Komponent;
import kntr.common.komponent.KomponentKt;
import kntr.common.komponent.KomponentScope;
import kntr.common.komponent.SetContentResult;
import kntr.common.komponent.UiComposableLike;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: TabsService.kt */
@BusinessScope
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\b\u0001\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0013JC\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001bH\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001f²\u0006\n\u0010 \u001a\u00020\u0003X\u008a\u0084\u0002²\u0006\n\u0010!\u001a\u00020\"X\u008a\u0084\u0002²\u0006\n\u0010#\u001a\u00020$X\u008a\u0084\u0002"}, d2 = {"Lkntr/app/digital/backpack/tab/TabsService;", RoomRecommendViewModel.EMPTY_CURSOR, "tabsModelInitializer", "Lkntr/app/digital/backpack/tab/TabsModel;", "lotterySelectedService", "Lkntr/app/digital/backpack/lottery/LotterySelectedService;", "<init>", "(Lkntr/app/digital/backpack/tab/TabsModel;Lkntr/app/digital/backpack/lottery/LotterySelectedService;)V", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "getPagerState", "()Landroidx/compose/foundation/pager/PagerState;", "komponent", "Lkntr/common/komponent/Komponent;", RoomRecommendViewModel.EMPTY_CURSOR, "Tab", "tabsModel", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/digital/backpack/tab/TabsModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "PagerTabIndicator", "tabPositions", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bilibili/ogv/bdesign/tab/TabPosition;", "color", "Landroidx/compose/ui/graphics/Color;", "width", "Landroidx/compose/ui/unit/Dp;", "height", "PagerTabIndicator-qBIQl6Q", "(Ljava/util/List;Landroidx/compose/foundation/pager/PagerState;JFFLandroidx/compose/runtime/Composer;II)V", "backpack_debug", "tabs", "currentPage", RoomRecommendViewModel.EMPTY_CURSOR, "fraction", RoomRecommendViewModel.EMPTY_CURSOR}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TabsService {
    public static final int $stable = 8;
    private final LotterySelectedService lotterySelectedService;
    private final PagerState pagerState;
    private final TabsModel tabsModelInitializer;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PagerTabIndicator_qBIQl6Q$lambda$3(TabsService tabsService, List list, PagerState pagerState, long j2, float f, float f2, int i, int i2, Composer composer, int i3) {
        tabsService.m850PagerTabIndicatorqBIQl6Q(list, pagerState, j2, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tab$lambda$1(TabsService tabsService, TabsModel tabsModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        tabsService.Tab(tabsModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    @Inject
    public TabsService(TabsModel tabsModelInitializer, LotterySelectedService lotterySelectedService) {
        Intrinsics.checkNotNullParameter(tabsModelInitializer, "tabsModelInitializer");
        Intrinsics.checkNotNullParameter(lotterySelectedService, "lotterySelectedService");
        this.tabsModelInitializer = tabsModelInitializer;
        this.lotterySelectedService = lotterySelectedService;
        this.pagerState = PagerStateKt.PagerState$default(0, 0.0f, new Function0() { // from class: kntr.app.digital.backpack.tab.TabsService$$ExternalSyntheticLambda0
            public final Object invoke() {
                int pagerState$lambda$0;
                pagerState$lambda$0 = TabsService.pagerState$lambda$0(TabsService.this);
                return Integer.valueOf(pagerState$lambda$0);
            }
        }, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int pagerState$lambda$0(TabsService this$0) {
        return this$0.tabsModelInitializer.getTabs().size();
    }

    public final PagerState getPagerState() {
        return this.pagerState;
    }

    public final Komponent<Unit> komponent() {
        return KomponentKt.Komponent(new Function1() { // from class: kntr.app.digital.backpack.tab.TabsService$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                SetContentResult komponent$lambda$0;
                komponent$lambda$0 = TabsService.komponent$lambda$0(TabsService.this, (KomponentScope) obj);
                return komponent$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SetContentResult komponent$lambda$0(final TabsService this$0, final KomponentScope $this$Komponent) {
        Intrinsics.checkNotNullParameter($this$Komponent, "$this$Komponent");
        final Object state$iv$iv = Unit.INSTANCE;
        UiComposableLike content$iv$iv$iv = new UiComposableLike<S>(state$iv$iv, $this$Komponent, this$0) { // from class: kntr.app.digital.backpack.tab.TabsService$komponent$lambda$0$$inlined$setContent$1
            final /* synthetic */ KomponentScope $this_setContent;
            private final S state;
            final /* synthetic */ TabsService this$0;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$this_setContent = $this$Komponent;
                this.this$0 = this$0;
                this.state = state$iv$iv;
            }

            public void invoke(Modifier modifier, Composer $composer, int $changed) {
                LotterySelectedService lotterySelectedService;
                TabsModel komponent$lambda$0$0$0;
                Intrinsics.checkNotNullParameter(modifier, "modifier");
                $composer.startReplaceGroup(1906618612);
                ComposerKt.sourceInformation($composer, "C(invoke)N(modifier)87@2987L17:Komponent.kt#vxw63z");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1906618612, $changed, -1, "kntr.common.komponent.setContent.<no name provided>.invoke (Komponent.kt:86)");
                }
                $composer.startReplaceGroup(985254584);
                ComposerKt.sourceInformation($composer, "CN(it)*47@1864L16,48@1901L24:TabsService.kt#i31ka1");
                lotterySelectedService = this.this$0.lotterySelectedService;
                State tabs$delegate = SnapshotStateKt.collectAsState(lotterySelectedService.getCurrentTabsModel(), (CoroutineContext) null, $composer, 0, 1);
                TabsService tabsService = this.this$0;
                komponent$lambda$0$0$0 = TabsService.komponent$lambda$0$0$0(tabs$delegate);
                tabsService.Tab(komponent$lambda$0$0$0, modifier, $composer, (($changed & 14) << 3) & 112, 0);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
            }

            public Object getContentType() {
                return Reflection.getOrCreateKotlinClass(getClass());
            }

            public Object getKey() {
                return this.$this_setContent.getKey();
            }

            public S getState() {
                return this.state;
            }

            public HostConfiguration getPreferredHostConfiguration() {
                return this.$this_setContent.getPreferredHostConfiguration();
            }
        };
        return $this$Komponent.__setContent(content$iv$iv$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TabsModel komponent$lambda$0$0$0(State<TabsModel> state) {
        Object thisObj$iv = state.getValue();
        return (TabsModel) thisObj$iv;
    }

    public final void Tab(final TabsModel tabsModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(tabsModel, "tabsModel");
        Composer $composer2 = $composer.startRestartGroup(-802499536);
        ComposerKt.sourceInformation($composer2, "C(Tab)N(tabsModel,modifier)58@2147L24,59@2184L2118:TabsService.kt#i31ka1");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(tabsModel) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(this) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-802499536, $dirty2, -1, "kntr.app.digital.backpack.tab.TabsService.Tab (TabsService.kt:56)");
            }
            final List tabs = tabsModel.getTabs();
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            int $changed$iv = (($dirty2 >> 3) & 14) | 384;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            modifier3 = modifier4;
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
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = (($changed$iv >> 6) & 112) | 6;
            RowScope $this$Tab_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -536937023, "C68@2563L469,79@3052L1004,63@2322L1734,102@4074L214:TabsService.kt#i31ka1");
            XXScrollableTabRowKt.XXScrollableTabRow-sKfQg0A(this.pagerState.getCurrentPage(), RowScope.-CC.weight$default($this$Tab_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), 0L, 0L, Dp.constructor-impl(4), ComposableLambdaKt.rememberComposableLambda(413329588, true, new Function3() { // from class: kntr.app.digital.backpack.tab.TabsService$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit Tab$lambda$0$0;
                    Tab$lambda$0$0 = TabsService.Tab$lambda$0$0(TabsService.this, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return Tab$lambda$0$0;
                }
            }, $composer2, 54), ComposableSingletons$TabsServiceKt.INSTANCE.getLambda$856032371$backpack_debug(), ComposableLambdaKt.rememberComposableLambda(865802932, true, new Function2() { // from class: kntr.app.digital.backpack.tab.TabsService$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit Tab$lambda$0$1;
                    Tab$lambda$0$1 = TabsService.Tab$lambda$0$1(tabs, this, scope, (Composer) obj, ((Integer) obj2).intValue());
                    return Tab$lambda$0$1;
                }
            }, $composer2, 54), $composer2, 14376960, 12);
            TextKt.Text-Nvy7gAk(tabsModel.getCollectionProgress(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(16), 0.0f, 11, (Object) null), Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer2, 25008, 0, 262120);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.backpack.tab.TabsService$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit Tab$lambda$1;
                    Tab$lambda$1 = TabsService.Tab$lambda$1(TabsService.this, tabsModel, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Tab$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tab$lambda$0$0(TabsService this$0, List tabPositions, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(tabPositions, "tabPositions");
        ComposerKt.sourceInformation($composer, "CN(tabPositions):TabsService.kt#i31ka1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(413329588, $changed, -1, "kntr.app.digital.backpack.tab.TabsService.Tab.<anonymous>.<anonymous> (TabsService.kt:69)");
        }
        if (tabPositions.isEmpty()) {
            $composer.startReplaceGroup(-172025010);
        } else {
            $composer.startReplaceGroup(-169369488);
            ComposerKt.sourceInformation($composer, "70@2666L318");
            this$0.m850PagerTabIndicatorqBIQl6Q(tabPositions, this$0.pagerState, ColorKt.Color(4294964669L), Dp.constructor-impl(8), Dp.constructor-impl(2), $composer, ($changed & 14) | 28032, 0);
        }
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tab$lambda$0$1(List $tabs, TabsService this$0, final CoroutineScope $scope, Composer $composer, int $changed) {
        final TabsService tabsService = this$0;
        ComposerKt.sourceInformation($composer, "C*87@3496L186,92@3710L306,82@3208L808:TabsService.kt#i31ka1");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(865802932, $changed, -1, "kntr.app.digital.backpack.tab.TabsService.Tab.<anonymous>.<anonymous> (TabsService.kt:80)");
            }
            List $this$forEachIndexed$iv = $tabs;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final TabModel tabs = (TabModel) item$iv;
                final int index = index$iv;
                boolean selected = tabsService.pagerState.getCurrentPage() == index;
                Modifier modifier = Modifier.Companion;
                long Color = ColorKt.Color(4294964669L);
                long j2 = Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 1613682225, "CC(remember):TabsService.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance($scope) | $composer.changedInstance(tabsService) | $composer.changed(index);
                Object it$iv = $composer.rememberedValue();
                if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    TabKt.Tab-bogVsAg(selected, (Function0) it$iv, modifier, false, Color, j2, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(1435204458, true, new Function3() { // from class: kntr.app.digital.backpack.tab.TabsService$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            Unit Tab$lambda$0$1$0$1;
                            Tab$lambda$0$1$0$1 = TabsService.Tab$lambda$0$1$0$1(TabModel.this, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            return Tab$lambda$0$1$0$1;
                        }
                    }, $composer, 54), $composer, 12804480, 72);
                    tabsService = this$0;
                    index$iv = index$iv2;
                }
                Object value$iv = new Function0() { // from class: kntr.app.digital.backpack.tab.TabsService$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit Tab$lambda$0$1$0$0$0;
                        Tab$lambda$0$1$0$0$0 = TabsService.Tab$lambda$0$1$0$0$0($scope, tabsService, index);
                        return Tab$lambda$0$1$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                TabKt.Tab-bogVsAg(selected, (Function0) it$iv, modifier, false, Color, j2, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(1435204458, true, new Function3() { // from class: kntr.app.digital.backpack.tab.TabsService$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit Tab$lambda$0$1$0$1;
                        Tab$lambda$0$1$0$1 = TabsService.Tab$lambda$0$1$0$1(TabModel.this, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return Tab$lambda$0$1$0$1;
                    }
                }, $composer, 54), $composer, 12804480, 72);
                tabsService = this$0;
                index$iv = index$iv2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tab$lambda$0$1$0$0$0(CoroutineScope $scope, TabsService this$0, int $index) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TabsService$Tab$1$2$1$1$1$1(this$0, $index, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tab$lambda$0$1$0$1(TabModel $tabs, ColumnScope $this$Tab, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Tab, "$this$Tab");
        ComposerKt.sourceInformation($composer, "C95@3847L9,93@3740L250:TabsService.kt#i31ka1");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1435204458, $changed, -1, "kntr.app.digital.backpack.tab.TabsService.Tab.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabsService.kt:93)");
            }
            TextKt.Text-Nvy7gAk($tabs.getTitle(), PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl(12), Dp.constructor-impl(8)), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12b(), $composer, 48, 0, 131068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x0165, code lost:
        if (r1 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L51;
     */
    /* renamed from: PagerTabIndicator-qBIQl6Q  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void m850PagerTabIndicatorqBIQl6Q(final List<TabPosition> list, final PagerState pagerState, long j2, float f, float f2, Composer $composer, final int $changed, final int i) {
        long j3;
        float f3;
        float f4;
        float f5;
        float f6;
        long j4;
        long j5;
        Composer $composer2 = $composer.startRestartGroup(1225571407);
        ComposerKt.sourceInformation($composer2, "C(PagerTabIndicator)N(tabPositions,pagerState,color:c#ui.graphics.Color,width:c#ui.unit.Dp,height:c#ui.unit.Dp)119@4598L55,120@4682L69,126@5039L1099,124@4955L1198:TabsService.kt#i31ka1");
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
            j3 = j2;
        } else if (($changed & 384) == 0) {
            j3 = j2;
            $dirty |= $composer2.changed(j3) ? 256 : 128;
        } else {
            j3 = j2;
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
                j5 = Color.Companion.getWhite-0d7_KjU();
            } else {
                j5 = j3;
            }
            if (i3 != 0) {
                f3 = Dp.constructor-impl(8);
            }
            if (i4 != 0) {
                f4 = Dp.constructor-impl(5);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1225571407, $dirty, -1, "kntr.app.digital.backpack.tab.TabsService.PagerTabIndicator (TabsService.kt:118)");
            }
            State currentPage$delegate = SnapshotStateKt.rememberUpdatedState(Integer.valueOf(pagerState.getCurrentPage()), $composer2, 0);
            final State fraction$delegate = SnapshotStateKt.rememberUpdatedState(Float.valueOf(pagerState.getCurrentPageOffsetFraction()), $composer2, 0);
            final TabPosition currentTab = list.get(PagerTabIndicator_qBIQl6Q$lambda$0(currentPage$delegate));
            final TabPosition previousTab = (TabPosition) CollectionsKt.getOrNull(list, PagerTabIndicator_qBIQl6Q$lambda$0(currentPage$delegate) - 1);
            final TabPosition nextTab = (TabPosition) CollectionsKt.getOrNull(list, PagerTabIndicator_qBIQl6Q$lambda$0(currentPage$delegate) + 1);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 953106170, "CC(remember):TabsService.kt#9igjgp");
            boolean invalid$iv = (($dirty & 7168) == 2048) | $composer2.changed(fraction$delegate) | $composer2.changed(nextTab) | $composer2.changed(currentTab) | $composer2.changed(previousTab) | (($dirty & 896) == 256) | ((57344 & $dirty) == 16384);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            final float f7 = f3;
            final long j6 = j5;
            final float f8 = f4;
            Object value$iv = new Function1() { // from class: kntr.app.digital.backpack.tab.TabsService$$ExternalSyntheticLambda7
                public final Object invoke(Object obj) {
                    Unit PagerTabIndicator_qBIQl6Q$lambda$2$0;
                    PagerTabIndicator_qBIQl6Q$lambda$2$0 = TabsService.PagerTabIndicator_qBIQl6Q$lambda$2$0(f7, nextTab, currentTab, previousTab, j6, f8, fraction$delegate, (DrawScope) obj);
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
            f5 = f3;
            f6 = f4;
            j4 = j5;
        } else {
            $composer2.skipToGroupEnd();
            f5 = f3;
            f6 = f4;
            j4 = j3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final long j7 = j4;
            final float f9 = f5;
            final float f10 = f6;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.backpack.tab.TabsService$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit PagerTabIndicator_qBIQl6Q$lambda$3;
                    PagerTabIndicator_qBIQl6Q$lambda$3 = TabsService.PagerTabIndicator_qBIQl6Q$lambda$3(TabsService.this, list, pagerState, j7, f9, f10, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
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
    public static final Unit PagerTabIndicator_qBIQl6Q$lambda$2$0(float f, TabPosition $nextTab, TabPosition $currentTab, TabPosition $previousTab, long j2, float f2, State $fraction$delegate, DrawScope $this$Canvas) {
        float f3;
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        float indicatorWidth = $this$Canvas.toPx-0680j_4(f);
        if (PagerTabIndicator_qBIQl6Q$lambda$1($fraction$delegate) > 0.0f && $nextTab != null) {
            f3 = $this$Canvas.toPx-0680j_4(DpKt.lerp-Md-fbLM($currentTab.getLeft-D9Ej5fM(), $nextTab.getLeft-D9Ej5fM(), PagerTabIndicator_qBIQl6Q$lambda$1($fraction$delegate)));
        } else if (PagerTabIndicator_qBIQl6Q$lambda$1($fraction$delegate) < 0.0f && $previousTab != null) {
            f3 = $this$Canvas.toPx-0680j_4(DpKt.lerp-Md-fbLM($currentTab.getLeft-D9Ej5fM(), $previousTab.getLeft-D9Ej5fM(), -PagerTabIndicator_qBIQl6Q$lambda$1($fraction$delegate)));
        } else {
            f3 = $this$Canvas.toPx-0680j_4($currentTab.getLeft-D9Ej5fM());
        }
        float indicatorOffset = f3;
        int bits$iv$iv$iv = (int) ($this$Canvas.getSize-NH-jbRc() & 4294967295L);
        float canvasHeight = Float.intBitsToFloat(bits$iv$iv$iv);
        float x$iv = indicatorOffset + (($this$Canvas.toPx-0680j_4($currentTab.getWidth-D9Ej5fM()) - indicatorWidth) / 2);
        float y$iv = canvasHeight - $this$Canvas.toPx-0680j_4(f2);
        long v1$iv$iv = Float.floatToRawIntBits(x$iv);
        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
        long j3 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        float x$iv2 = PagerTabIndicator_qBIQl6Q$lambda$1($fraction$delegate);
        float width$iv = indicatorWidth + (Math.abs(x$iv2) * indicatorWidth);
        float height$iv = $this$Canvas.toPx-0680j_4(f2);
        long v1$iv$iv2 = Float.floatToRawIntBits(width$iv);
        long v2$iv$iv2 = Float.floatToRawIntBits(height$iv);
        long j4 = Size.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv2 & 4294967295L));
        long v1$iv$iv3 = Float.floatToRawIntBits(50.0f);
        long v2$iv$iv3 = Float.floatToRawIntBits(50.0f);
        DrawScope.-CC.drawRoundRect-u-Aw5IA$default($this$Canvas, j2, j3, j4, CornerRadius.constructor-impl((v1$iv$iv3 << 32) | (v2$iv$iv3 & 4294967295L)), (DrawStyle) null, 0.0f, (ColorFilter) null, 0, 240, (Object) null);
        return Unit.INSTANCE;
    }
}