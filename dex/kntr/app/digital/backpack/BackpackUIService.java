package kntr.app.digital.backpack;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Velocity;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kntr.app.digital.backpack.BackpackUIService;
import kntr.app.digital.backpack.di.BusinessScope;
import kntr.app.digital.backpack.lottery.LotteryCollectionService;
import kntr.app.digital.backpack.navigation.NavigationBarService;
import kntr.app.digital.backpack.pager.PagerService;
import kntr.app.digital.backpack.tab.TabsService;
import kntr.app.digital.backpack.topbackground.TopBackgroundService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.HostConfiguration;
import kntr.common.komponent.Komponent;
import kntr.common.komponent.KomponentHostScope;
import kntr.common.komponent.KomponentKt;
import kntr.common.komponent.KomponentScope;
import kntr.common.komponent.SetContentResult;
import kntr.common.komponent.UiComposableLike;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: BackpackUIService.kt */
@BusinessScope
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0011B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0014X\u008a\u0084\u0002"}, d2 = {"Lkntr/app/digital/backpack/BackpackUIService;", RoomRecommendViewModel.EMPTY_CURSOR, "navigationBarService", "Lkntr/app/digital/backpack/navigation/NavigationBarService;", "topBackgroundService", "Lkntr/app/digital/backpack/topbackground/TopBackgroundService;", "lotteryCollectionService", "Lkntr/app/digital/backpack/lottery/LotteryCollectionService;", "tabsService", "Lkntr/app/digital/backpack/tab/TabsService;", "pagerService", "Lkntr/app/digital/backpack/pager/PagerService;", "<init>", "(Lkntr/app/digital/backpack/navigation/NavigationBarService;Lkntr/app/digital/backpack/topbackground/TopBackgroundService;Lkntr/app/digital/backpack/lottery/LotteryCollectionService;Lkntr/app/digital/backpack/tab/TabsService;Lkntr/app/digital/backpack/pager/PagerService;)V", "komponent", "Lkntr/common/komponent/Komponent;", RoomRecommendViewModel.EMPTY_CURSOR, "NestedScrollConnectionImpl", "backpack_debug", "offset", RoomRecommendViewModel.EMPTY_CURSOR, "columnHeight", RoomRecommendViewModel.EMPTY_CURSOR, "appbarAlpha"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BackpackUIService {
    public static final int $stable = 8;
    private final LotteryCollectionService lotteryCollectionService;
    private final NavigationBarService navigationBarService;
    private final PagerService pagerService;
    private final TabsService tabsService;
    private final TopBackgroundService topBackgroundService;

    @Inject
    public BackpackUIService(NavigationBarService navigationBarService, TopBackgroundService topBackgroundService, LotteryCollectionService lotteryCollectionService, TabsService tabsService, PagerService pagerService) {
        Intrinsics.checkNotNullParameter(navigationBarService, "navigationBarService");
        Intrinsics.checkNotNullParameter(topBackgroundService, "topBackgroundService");
        Intrinsics.checkNotNullParameter(lotteryCollectionService, "lotteryCollectionService");
        Intrinsics.checkNotNullParameter(tabsService, "tabsService");
        Intrinsics.checkNotNullParameter(pagerService, "pagerService");
        this.navigationBarService = navigationBarService;
        this.topBackgroundService = topBackgroundService;
        this.lotteryCollectionService = lotteryCollectionService;
        this.tabsService = tabsService;
        this.pagerService = pagerService;
    }

    public final Komponent<Unit> komponent() {
        return KomponentKt.Komponent(new Function1() { // from class: kntr.app.digital.backpack.BackpackUIService$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                SetContentResult komponent$lambda$0;
                komponent$lambda$0 = BackpackUIService.komponent$lambda$0(BackpackUIService.this, (KomponentScope) obj);
                return komponent$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SetContentResult komponent$lambda$0(BackpackUIService this$0, final KomponentScope $this$Komponent) {
        Intrinsics.checkNotNullParameter($this$Komponent, "$this$Komponent");
        final UiComposableLike navigationBar = KomponentHostScope.-CC.embed$default((KomponentHostScope) $this$Komponent, this$0.navigationBarService.komponent(), (Function1) null, 2, (Object) null);
        final UiComposableLike topBackground = KomponentHostScope.-CC.embed$default((KomponentHostScope) $this$Komponent, this$0.topBackgroundService.komponent(), (Function1) null, 2, (Object) null);
        final UiComposableLike cardPools = KomponentHostScope.-CC.embed$default((KomponentHostScope) $this$Komponent, this$0.lotteryCollectionService.komponent(), (Function1) null, 2, (Object) null);
        final UiComposableLike tabs = KomponentHostScope.-CC.embed$default((KomponentHostScope) $this$Komponent, this$0.tabsService.komponent(), (Function1) null, 2, (Object) null);
        final UiComposableLike pager = KomponentHostScope.-CC.embed$default((KomponentHostScope) $this$Komponent, this$0.pagerService.komponent(), (Function1) null, 2, (Object) null);
        final Object state$iv$iv = Unit.INSTANCE;
        UiComposableLike content$iv$iv$iv = new UiComposableLike<S>(state$iv$iv, $this$Komponent, navigationBar, pager, topBackground, cardPools, tabs) { // from class: kntr.app.digital.backpack.BackpackUIService$komponent$lambda$0$$inlined$setContent$1
            final /* synthetic */ UiComposableLike $cardPools$inlined;
            final /* synthetic */ UiComposableLike $navigationBar$inlined;
            final /* synthetic */ UiComposableLike $pager$inlined;
            final /* synthetic */ UiComposableLike $tabs$inlined;
            final /* synthetic */ KomponentScope $this_setContent;
            final /* synthetic */ UiComposableLike $topBackground$inlined;
            private final S state;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$this_setContent = $this$Komponent;
                this.$navigationBar$inlined = navigationBar;
                this.$pager$inlined = pager;
                this.$topBackground$inlined = topBackground;
                this.$cardPools$inlined = cardPools;
                this.$tabs$inlined = tabs;
                this.state = state$iv$iv;
            }

            public void invoke(Modifier modifier, Composer $composer, int $changed) {
                Function0 factory$iv$iv$iv;
                Function0 factory$iv$iv;
                Function0 factory$iv$iv$iv2;
                float komponent$lambda$0$0$1;
                int komponent$lambda$0$0$4;
                float komponent$lambda$0$0$8;
                Intrinsics.checkNotNullParameter(modifier, "modifier");
                $composer.startReplaceGroup(1906618612);
                ComposerKt.sourceInformation($composer, "C(invoke)N(modifier)87@2987L17:Komponent.kt#vxw63z");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1906618612, $changed, -1, "kntr.common.komponent.setContent.<no name provided>.invoke (Komponent.kt:86)");
                }
                int $changed2 = $changed & 14;
                $composer.startReplaceGroup(-2046215881);
                ComposerKt.sourceInformation($composer, "CN(it)*64@2954L36,65@3031L33,67@3168L170,67@3144L194,73@3386L311,82@3718L3322:BackpackUIService.kt#nfb1io");
                ComposerKt.sourceInformationMarkerStart($composer, -66010580, "CC(remember):BackpackUIService.kt#9igjgp");
                Object it$iv = $composer.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                final MutableFloatState offset$delegate = (MutableFloatState) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -66008119, "CC(remember):BackpackUIService.kt#9igjgp");
                Object it$iv2 = $composer.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = SnapshotIntStateKt.mutableIntStateOf(0);
                    $composer.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                final MutableIntState columnHeight$delegate = (MutableIntState) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -66003598, "CC(remember):BackpackUIService.kt#9igjgp");
                Object it$iv3 = $composer.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = (Function1) new Function1<Float, Float>() { // from class: kntr.app.digital.backpack.BackpackUIService$komponent$1$1$scrollState$1$1
                        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                            return invoke(((Number) p1).floatValue());
                        }

                        public final Float invoke(float delta) {
                            float komponent$lambda$0$0$12;
                            float komponent$lambda$0$0$13;
                            MutableFloatState mutableFloatState = offset$delegate;
                            komponent$lambda$0$0$12 = BackpackUIService.komponent$lambda$0$0$1(offset$delegate);
                            mutableFloatState.setFloatValue(komponent$lambda$0$0$12 + delta);
                            komponent$lambda$0$0$13 = BackpackUIService.komponent$lambda$0$0$1(offset$delegate);
                            if (komponent$lambda$0$0$13 > 0.0f) {
                                offset$delegate.setFloatValue(0.0f);
                            }
                            return Float.valueOf(delta);
                        }
                    };
                    $composer.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                ScrollableState scrollState = ScrollableStateKt.rememberScrollableState((Function1) it$iv3, $composer, 6);
                ComposerKt.sourceInformationMarkerStart($composer, -65996481, "CC(remember):BackpackUIService.kt#9igjgp");
                Object it$iv4 = $composer.rememberedValue();
                if (it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: kntr.app.digital.backpack.BackpackUIService$komponent$1$1$appbarAlpha$2$1
                        /* renamed from: invoke */
                        public final Float m806invoke() {
                            float komponent$lambda$0$0$12;
                            float f;
                            float komponent$lambda$0$0$13;
                            komponent$lambda$0$0$12 = BackpackUIService.komponent$lambda$0$0$1(offset$delegate);
                            boolean z = false;
                            if (-500.0f <= komponent$lambda$0$0$12 && komponent$lambda$0$0$12 <= 0.0f) {
                                z = true;
                            }
                            if (z) {
                                komponent$lambda$0$0$13 = BackpackUIService.komponent$lambda$0$0$1(offset$delegate);
                                f = Math.abs(komponent$lambda$0$0$13 / 500.0f);
                            } else {
                                f = 1.0f;
                            }
                            return Float.valueOf(f);
                        }
                    });
                    $composer.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                }
                State appbarAlpha$delegate = (State) it$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer);
                int $changed$iv = $changed2 & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = ($changed$iv << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier);
                Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                int i2 = (($changed$iv >> 6) & 112) | 6;
                BoxScope $this$komponent_u24lambda_u240_u240_u249 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, -1394629014, "C108@5273L1199,83@3763L2709,139@6966L11,131@6497L521:BackpackUIService.kt#nfb1io");
                Modifier modifier$iv = ScrollableKt.scrollable$default(Modifier.Companion, scrollState, Orientation.Vertical, false, false, (FlingBehavior) null, (MutableInteractionSource) null, 60, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 1894720881, "CC(remember):BackpackUIService.kt#9igjgp");
                MeasurePolicy value$iv5 = $composer.rememberedValue();
                if (value$iv5 == Composer.Companion.getEmpty()) {
                    value$iv5 = new MeasurePolicy() { // from class: kntr.app.digital.backpack.BackpackUIService$komponent$1$1$1$2$1
                        public /* bridge */ int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> list, int width) {
                            return MeasurePolicy.-CC.$default$maxIntrinsicHeight(this, $this$maxIntrinsicHeight, list, width);
                        }

                        public /* bridge */ int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> list, int height) {
                            return MeasurePolicy.-CC.$default$maxIntrinsicWidth(this, $this$maxIntrinsicWidth, list, height);
                        }

                        public /* bridge */ int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> list, int width) {
                            return MeasurePolicy.-CC.$default$minIntrinsicHeight(this, $this$minIntrinsicHeight, list, width);
                        }

                        public /* bridge */ int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> list, int height) {
                            return MeasurePolicy.-CC.$default$minIntrinsicWidth(this, $this$minIntrinsicWidth, list, height);
                        }

                        /* renamed from: measure-3p2s80s  reason: not valid java name */
                        public final MeasureResult m805measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> list, long j2) {
                            float komponent$lambda$0$0$12;
                            Intrinsics.checkNotNullParameter($this$Layout, "$this$Layout");
                            Intrinsics.checkNotNullParameter(list, "measurables");
                            Measurable m1 = list.get(0);
                            Measurable m2 = list.get(1);
                            final Placeable p1 = m1.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(j2, Constraints.getMaxWidth-impl(j2), 0, 0, 0, 10, (Object) null));
                            final Placeable p2 = m2.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(j2, Constraints.getMaxWidth-impl(j2), 0, Constraints.getMaxHeight-impl(j2), 0, 10, (Object) null));
                            columnHeight$delegate.setIntValue(p1.getHeight());
                            MutableFloatState mutableFloatState = offset$delegate;
                            komponent$lambda$0$0$12 = BackpackUIService.komponent$lambda$0$0$1(offset$delegate);
                            mutableFloatState.setFloatValue(RangesKt.coerceAtLeast(komponent$lambda$0$0$12, -p1.getHeight()));
                            int i3 = Constraints.getMaxWidth-impl(j2);
                            int i4 = Constraints.getMaxHeight-impl(j2);
                            final MutableFloatState mutableFloatState2 = offset$delegate;
                            return MeasureScope.-CC.layout$default($this$Layout, i3, i4, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: kntr.app.digital.backpack.BackpackUIService$komponent$1$1$1$2$1.1
                                public /* bridge */ /* synthetic */ Object invoke(Object p12) {
                                    invoke((Placeable.PlacementScope) p12);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Placeable.PlacementScope $this$layout) {
                                    float komponent$lambda$0$0$13;
                                    float komponent$lambda$0$0$14;
                                    Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
                                    Placeable placeable = p1;
                                    komponent$lambda$0$0$13 = BackpackUIService.komponent$lambda$0$0$1(mutableFloatState2);
                                    Placeable.PlacementScope.place$default($this$layout, placeable, 0, MathKt.roundToInt(komponent$lambda$0$0$13), 0.0f, 4, (Object) null);
                                    Placeable placeable2 = p2;
                                    komponent$lambda$0$0$14 = BackpackUIService.komponent$lambda$0$0$1(mutableFloatState2);
                                    Placeable.PlacementScope.place$default($this$layout, placeable2, 0, MathKt.roundToInt(komponent$lambda$0$0$14) + p1.getHeight(), 0.0f, 4, (Object) null);
                                }
                            }, 4, (Object) null);
                        }
                    };
                    $composer.updateRememberedValue(value$iv5);
                }
                MeasurePolicy measurePolicy$iv2 = (MeasurePolicy) value$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                Function0 factory$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv2 = ((384 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv = factory$iv$iv2;
                    $composer.createNode(factory$iv$iv);
                } else {
                    factory$iv$iv = factory$iv$iv2;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv, Integer.valueOf(compositeKeyHash$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -1112497637, "C87@3968L153,85@3843L594,100@4807L23,95@4470L650:BackpackUIService.kt#nfb1io");
                Modifier modifier2 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart($composer, 656852516, "CC(remember):BackpackUIService.kt#9igjgp");
                Object value$iv6 = $composer.rememberedValue();
                if (value$iv6 == Composer.Companion.getEmpty()) {
                    value$iv6 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: kntr.app.digital.backpack.BackpackUIService$komponent$1$1$1$1$1$1
                        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                            invoke((LayoutCoordinates) p1);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(LayoutCoordinates layoutCoordinates) {
                            Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
                            columnHeight$delegate.setIntValue((int) (4294967295L & layoutCoordinates.getSize-YbymL2g()));
                        }
                    };
                    $composer.updateRememberedValue(value$iv6);
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifier$iv2 = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier2, (Function1) value$iv6);
                ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                int compositeKeyHash$iv2 = ((6 >> 3) & 14) | ((6 >> 3) & 112);
                MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, compositeKeyHash$iv2);
                int $changed$iv$iv3 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i5 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -2116826082, "C91@4195L49,92@4281L45,93@4363L40:BackpackUIService.kt#nfb1io");
                this.$topBackground$inlined.invoke(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer, 6);
                this.$cardPools$inlined.invoke(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer, 6);
                this.$tabs$inlined.invoke(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer, 6);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                UiComposableLike uiComposableLike = this.$pager$inlined;
                LazyListState rememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, $composer, 0, 3);
                komponent$lambda$0$0$1 = BackpackUIService.komponent$lambda$0$0$1(offset$delegate);
                komponent$lambda$0$0$4 = BackpackUIService.komponent$lambda$0$0$4(columnHeight$delegate);
                uiComposableLike.invoke(NestedScrollModifierKt.nestedScroll$default(Modifier.Companion, new BackpackUIService.NestedScrollConnectionImpl(scrollState, rememberLazyListState, komponent$lambda$0$0$1, komponent$lambda$0$0$4), (NestedScrollDispatcher) null, 2, (Object) null), $composer, 0);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                UiComposableLike uiComposableLike2 = this.$navigationBar$inlined;
                Modifier align = $this$komponent_u24lambda_u240_u240_u249.align(Modifier.Companion, Alignment.Companion.getTopCenter());
                long j2 = Color.Companion.getBlack-0d7_KjU();
                komponent$lambda$0$0$8 = BackpackUIService.komponent$lambda$0$0$8(appbarAlpha$delegate);
                uiComposableLike2.invoke(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(WindowInsetsPadding_androidKt.statusBarsPadding(BackgroundKt.background-bw27NRU$default(align, Color.copy-wmQWz5c$default(j2, komponent$lambda$0$0$8, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null)), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(8), 7, (Object) null), 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getAppBarStyle($composer, BiliTheme.$stable).getAppBarHeight-D9Ej5fM()), $composer, 0);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
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
    public static final float komponent$lambda$0$0$1(MutableFloatState $offset$delegate) {
        FloatState $this$getValue$iv = (FloatState) $offset$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int komponent$lambda$0$0$4(MutableIntState $columnHeight$delegate) {
        IntState $this$getValue$iv = (IntState) $columnHeight$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float komponent$lambda$0$0$8(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BackpackUIService.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lkntr/app/digital/backpack/BackpackUIService$NestedScrollConnectionImpl;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "parentScrollState", "Landroidx/compose/foundation/gestures/ScrollableState;", "childScrollState", "Landroidx/compose/foundation/lazy/LazyListState;", "offset", RoomRecommendViewModel.EMPTY_CURSOR, "columnHeight", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/lazy/LazyListState;FI)V", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class NestedScrollConnectionImpl implements NestedScrollConnection {
        private final LazyListState childScrollState;
        private final int columnHeight;
        private final float offset;
        private final ScrollableState parentScrollState;

        public NestedScrollConnectionImpl(ScrollableState parentScrollState, LazyListState childScrollState, float offset, int columnHeight) {
            Intrinsics.checkNotNullParameter(parentScrollState, "parentScrollState");
            Intrinsics.checkNotNullParameter(childScrollState, "childScrollState");
            this.parentScrollState = parentScrollState;
            this.childScrollState = childScrollState;
            this.offset = offset;
            this.columnHeight = columnHeight;
        }

        /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
        public /* bridge */ Object m801onPostFlingRZ2iAVY(long j2, long j3, Continuation<? super Velocity> continuation) {
            return NestedScrollConnection.-CC.$default$onPostFling-RZ2iAVY(this, j2, j3, continuation);
        }

        /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
        public /* bridge */ Object m803onPreFlingQWom1Mo(long j2, Continuation<? super Velocity> continuation) {
            return NestedScrollConnection.-CC.$default$onPreFling-QWom1Mo(this, j2, continuation);
        }

        /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
        public long m804onPreScrollOzD1aCk(long j2, int i) {
            int bits$iv$iv$iv = (int) (j2 & 4294967295L);
            float delta = Float.intBitsToFloat(bits$iv$iv$iv);
            if (delta < 0.0f) {
                float maxParentOffset = -this.columnHeight;
                if (this.offset > maxParentOffset) {
                    float remaining = maxParentOffset - this.offset;
                    float consume = Math.max(delta, remaining);
                    this.parentScrollState.dispatchRawDelta(consume);
                    long v1$iv$iv = Float.floatToRawIntBits(0.0f);
                    long v2$iv$iv = Float.floatToRawIntBits(consume);
                    return Offset.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv));
                }
            }
            return Offset.Companion.getZero-F1C5BW0();
        }

        /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
        public long m802onPostScrollDzOQY0M(long j2, long j3, int i) {
            int bits$iv$iv$iv = (int) (j3 & 4294967295L);
            float delta = Float.intBitsToFloat(bits$iv$iv$iv);
            if (delta > 0.0f) {
                boolean isChildAtTop = this.childScrollState.getFirstVisibleItemIndex() == 0 && this.childScrollState.getFirstVisibleItemScrollOffset() == 0;
                if (isChildAtTop) {
                    float remaining = 0.0f - this.offset;
                    if (remaining > 0.0f) {
                        float consume = Math.min(delta, remaining);
                        this.parentScrollState.dispatchRawDelta(consume);
                        long v1$iv$iv = Float.floatToRawIntBits(0.0f);
                        long v2$iv$iv = Float.floatToRawIntBits(consume);
                        return Offset.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv));
                    }
                }
            }
            return Offset.Companion.getZero-F1C5BW0();
        }
    }
}