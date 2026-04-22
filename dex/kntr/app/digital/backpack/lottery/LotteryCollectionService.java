package kntr.app.digital.backpack.lottery;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.AnimationModifierKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
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
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextMeasurerHelperKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import javax.inject.Inject;
import kntr.app.digital.backpack.di.BusinessScope;
import kntr.app.digital.backpack.lottery.LotteryCollectionModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.HostConfiguration;
import kntr.common.komponent.Komponent;
import kntr.common.komponent.KomponentKt;
import kntr.common.komponent.KomponentScope;
import kntr.common.komponent.SetContentResult;
import kntr.common.komponent.UiComposableLike;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.digital.backpack.generated.resources.Drawable0_commonMainKt;
import srcs.app.digital.backpack.generated.resources.Res;

/* compiled from: LotteryCollectionService.kt */
@BusinessScope
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0017\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000eJ'\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u0084\u0002²\u0006\n\u0010\u0019\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u0084\u0002"}, d2 = {"Lkntr/app/digital/backpack/lottery/LotteryCollectionService;", RoomRecommendViewModel.EMPTY_CURSOR, "lotteryCollectionModel", "Lkntr/app/digital/backpack/lottery/LotteryCollectionModel;", "lotterySelectedService", "Lkntr/app/digital/backpack/lottery/LotterySelectedService;", "<init>", "(Lkntr/app/digital/backpack/lottery/LotteryCollectionModel;Lkntr/app/digital/backpack/lottery/LotterySelectedService;)V", "komponent", "Lkntr/common/komponent/Komponent;", RoomRecommendViewModel.EMPTY_CURSOR, "Content", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "CardPoolItem", "isSelected", RoomRecommendViewModel.EMPTY_CURSOR, "text", RoomRecommendViewModel.EMPTY_CURSOR, "(ZLjava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "CardPoolCollectionWithExpandable", "backpack_debug", "currentLotteryId", RoomRecommendViewModel.EMPTY_CURSOR, "expand"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LotteryCollectionService {
    public static final int $stable = 8;
    private final LotteryCollectionModel lotteryCollectionModel;
    private final LotterySelectedService lotterySelectedService;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CardPoolCollectionWithExpandable$lambda$4(LotteryCollectionService lotteryCollectionService, Modifier modifier, int i, int i2, Composer composer, int i3) {
        lotteryCollectionService.CardPoolCollectionWithExpandable(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CardPoolItem$lambda$1(LotteryCollectionService lotteryCollectionService, boolean z, String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        lotteryCollectionService.CardPoolItem(z, str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$1(LotteryCollectionService lotteryCollectionService, Modifier modifier, int i, int i2, Composer composer, int i3) {
        lotteryCollectionService.Content(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    @Inject
    public LotteryCollectionService(LotteryCollectionModel lotteryCollectionModel, LotterySelectedService lotterySelectedService) {
        Intrinsics.checkNotNullParameter(lotteryCollectionModel, "lotteryCollectionModel");
        Intrinsics.checkNotNullParameter(lotterySelectedService, "lotterySelectedService");
        this.lotteryCollectionModel = lotteryCollectionModel;
        this.lotterySelectedService = lotterySelectedService;
    }

    public final Komponent<Unit> komponent() {
        return KomponentKt.Komponent(new Function1() { // from class: kntr.app.digital.backpack.lottery.LotteryCollectionService$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                SetContentResult komponent$lambda$0;
                komponent$lambda$0 = LotteryCollectionService.komponent$lambda$0(LotteryCollectionService.this, (KomponentScope) obj);
                return komponent$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SetContentResult komponent$lambda$0(final LotteryCollectionService this$0, final KomponentScope $this$Komponent) {
        Intrinsics.checkNotNullParameter($this$Komponent, "$this$Komponent");
        final Object state$iv$iv = Unit.INSTANCE;
        UiComposableLike content$iv$iv$iv = new UiComposableLike<S>(state$iv$iv, $this$Komponent, this$0) { // from class: kntr.app.digital.backpack.lottery.LotteryCollectionService$komponent$lambda$0$$inlined$setContent$1
            final /* synthetic */ KomponentScope $this_setContent;
            private final S state;
            final /* synthetic */ LotteryCollectionService this$0;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$this_setContent = $this$Komponent;
                this.this$0 = this$0;
                this.state = state$iv$iv;
            }

            public void invoke(Modifier modifier, Composer $composer, int $changed) {
                LotteryCollectionModel lotteryCollectionModel;
                Intrinsics.checkNotNullParameter(modifier, "modifier");
                $composer.startReplaceGroup(1906618612);
                ComposerKt.sourceInformation($composer, "C(invoke)N(modifier)87@2987L17:Komponent.kt#vxw63z");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1906618612, $changed, -1, "kntr.common.komponent.setContent.<no name provided>.invoke (Komponent.kt:86)");
                }
                int $changed2 = $changed & 14;
                $composer.startReplaceGroup(2096806221);
                ComposerKt.sourceInformation($composer, "CN(it):LotteryCollectionService.kt#5jskp7");
                lotteryCollectionModel = this.this$0.lotteryCollectionModel;
                if (lotteryCollectionModel.getList().isEmpty()) {
                    $composer.startReplaceGroup(2094384469);
                } else {
                    $composer.startReplaceGroup(2096850426);
                    ComposerKt.sourceInformation($composer, "58@2509L11");
                    this.this$0.Content(modifier, $composer, $changed2 & 14, 0);
                }
                $composer.endReplaceGroup();
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

    /* JADX WARN: Code restructure failed: missing block: B:44:0x01f2, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Content(Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-1684573069);
        ComposerKt.sourceInformation($composer2, "C(Content)N(modifier)65@2661L2181:LotteryCollectionService.kt#5jskp7");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(this) ? 32 : 16;
        }
        if (!$composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1684573069, $dirty, -1, "kntr.app.digital.backpack.lottery.LotteryCollectionService.Content (LotteryCollectionService.kt:64)");
            }
            int $changed$iv = $dirty & 14;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier4 = modifier3;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1748980591, "C99@4571L257:LotteryCollectionService.kt#5jskp7");
            if (this.lotteryCollectionModel.getList().size() < 5) {
                $composer2.startReplaceGroup(-1748952258);
                ComposerKt.sourceInformation($composer2, "67@2845L16,72@3144L1278,68@2882L1540");
                final State currentLotteryId$delegate = SnapshotStateKt.collectAsState(this.lotterySelectedService.getCurrentLotteryIdFlow(), (CoroutineContext) null, $composer2, 0, 1);
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(12));
                PaddingValues paddingValues = PaddingKt.PaddingValues-YgX7TsA(Dp.constructor-impl(12), Dp.constructor-impl(15));
                Arrangement.Horizontal horizontal2 = horizontal;
                ComposerKt.sourceInformationMarkerStart($composer2, -1303331577, "CC(remember):LotteryCollectionService.kt#9igjgp");
                boolean invalid$iv = $composer2.changedInstance(this) | $composer2.changed(currentLotteryId$delegate);
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv = new Function1() { // from class: kntr.app.digital.backpack.lottery.LotteryCollectionService$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit Content$lambda$0$1$0;
                        Content$lambda$0$1$0 = LotteryCollectionService.Content$lambda$0$1$0(LotteryCollectionService.this, currentLotteryId$delegate, (LazyListScope) obj);
                        return Content$lambda$0$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                LazyDslKt.LazyRow(fillMaxWidth$default, (LazyListState) null, paddingValues, false, horizontal2, (Alignment.Vertical) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv, $composer2, 24966, 490);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-1747317907);
                ComposerKt.sourceInformation($composer2, "97@4468L68");
                CardPoolCollectionWithExpandable(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer2, ($dirty & 112) | 6, 0);
                $composer2.endReplaceGroup();
            }
            SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 2, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl((float) 0.5d)), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.25f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), $composer2, 6);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.backpack.lottery.LotteryCollectionService$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$1;
                    Content$lambda$1 = LotteryCollectionService.Content$lambda$1(LotteryCollectionService.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long Content$lambda$0$0(State<Long> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$0$1$0(final LotteryCollectionService this$0, final State $currentLotteryId$delegate, LazyListScope $this$LazyRow) {
        Intrinsics.checkNotNullParameter($this$LazyRow, "$this$LazyRow");
        final List items$iv = this$0.lotteryCollectionModel.getList();
        final Function1 contentType$iv = new Function1() { // from class: kntr.app.digital.backpack.lottery.LotteryCollectionService$Content$lambda$0$1$0$$inlined$items$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return m839invoke((LotteryCollectionModel.CardPool) p1);
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final Void m839invoke(LotteryCollectionModel.CardPool cardPool) {
                return null;
            }
        };
        $this$LazyRow.items(items$iv.size(), (Function1) null, new Function1<Integer, Object>() { // from class: kntr.app.digital.backpack.lottery.LotteryCollectionService$Content$lambda$0$1$0$$inlined$items$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return contentType$iv.invoke(items$iv.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.app.digital.backpack.lottery.LotteryCollectionService$Content$lambda$0$1$0$$inlined$items$default$4
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                long Content$lambda$0$0;
                long j2;
                ComposerKt.sourceInformation($composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if (!$composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                int $changed2 = $dirty & 14;
                final LotteryCollectionModel.CardPool it2 = (LotteryCollectionModel.CardPool) items$iv.get(it);
                $composer.startReplaceGroup(-529548947);
                ComposerKt.sourceInformation($composer, "CN(it)*90@4212L131,75@3313L1061:LotteryCollectionService.kt#5jskp7");
                long lotteryId = it2.getLotteryId();
                Content$lambda$0$0 = LotteryCollectionService.Content$lambda$0$0($currentLotteryId$delegate);
                boolean isSelected = lotteryId == Content$lambda$0$0;
                LotteryCollectionService lotteryCollectionService = this$0;
                String lotteryName = it2.getLotteryName();
                Modifier modifier = Modifier.Companion;
                if (isSelected) {
                    j2 = Color.copy-wmQWz5c$default(ColorKt.Color(4294964669L), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                } else {
                    j2 = Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                }
                Modifier modifier2 = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU(modifier, j2, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(17))), Dp.constructor-impl(16), Dp.constructor-impl(7));
                ComposerKt.sourceInformationMarkerStart($composer, -1956714618, "CC(remember):LotteryCollectionService.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance(this$0) | (((($changed2 & 112) ^ 48) > 32 && $composer.changed(it2)) || ($changed2 & 48) == 32);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    final LotteryCollectionService lotteryCollectionService2 = this$0;
                    Object value$iv = (Function0) new Function0<Unit>() { // from class: kntr.app.digital.backpack.lottery.LotteryCollectionService$Content$1$1$1$1$1$1
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m840invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: collision with other method in class */
                        public final void m840invoke() {
                            LotterySelectedService lotterySelectedService;
                            lotterySelectedService = LotteryCollectionService.this.lotterySelectedService;
                            lotterySelectedService.select(it2.getLotteryId());
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                lotteryCollectionService.CardPoolItem(isSelected, lotteryName, ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), $composer, 0, 0);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    public final void CardPoolItem(final boolean isSelected, final String text, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer2 = $composer.startRestartGroup(-842387948);
        ComposerKt.sourceInformation($composer2, "C(CardPoolItem)N(isSelected,text,modifier)115@5026L325:LotteryCollectionService.kt#5jskp7");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(isSelected) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(text) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if (!$composer2.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-842387948, $dirty, -1, "kntr.app.digital.backpack.lottery.LotteryCollectionService.CardPoolItem (LotteryCollectionService.kt:114)");
            }
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            int $changed$iv = (($dirty >> 6) & 14) | 48;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1531038690, "C118@5183L9,116@5106L231:LotteryCollectionService.kt#5jskp7");
            TextStyle t14b = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14b();
            TextKt.Text-Nvy7gAk(text, Modifier.Companion, isSelected ? ColorKt.Color(4294964669L) : Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t14b, $composer2, (($dirty >> 3) & 14) | 48, 0, 131064);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.backpack.lottery.LotteryCollectionService$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit CardPoolItem$lambda$1;
                    CardPoolItem$lambda$1 = LotteryCollectionService.CardPoolItem$lambda$1(LotteryCollectionService.this, isSelected, text, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CardPoolItem$lambda$1;
                }
            });
        }
    }

    public final void CardPoolCollectionWithExpandable(Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3 = $composer.startRestartGroup(856103322);
        ComposerKt.sourceInformation($composer3, "C(CardPoolCollectionWithExpandable)N(modifier)128@5532L34,129@5597L7,*130@5624L4856:LotteryCollectionService.kt#5jskp7");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(this) ? 32 : 16;
        }
        if (!$composer3.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(856103322, $dirty, -1, "kntr.app.digital.backpack.lottery.LotteryCollectionService.CardPoolCollectionWithExpandable (LotteryCollectionService.kt:127)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -1918425284, "CC(remember):LotteryCollectionService.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState expand$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Density $this$CardPoolCollectionWithExpandable_u24lambda_u243 = (Density) consume;
            int $changed$iv = $dirty & 14;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            Modifier modifier4 = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = (($changed$iv >> 6) & 112) | 6;
            RowScope $this$CardPoolCollectionWithExpandable_u24lambda_u243_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1597756533, "C138@5923L3128,133@5710L3341,193@9073L1389:LotteryCollectionService.kt#5jskp7");
            BoxWithConstraintsKt.BoxWithConstraints(AnimationModifierKt.animateContentSize$default(RowScope.-CC.weight$default($this$CardPoolCollectionWithExpandable_u24lambda_u243_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), (FiniteAnimationSpec) null, (Function2) null, 3, (Object) null), (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(731235090, true, new Function3() { // from class: kntr.app.digital.backpack.lottery.LotteryCollectionService$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit CardPoolCollectionWithExpandable$lambda$3$0$0;
                    CardPoolCollectionWithExpandable$lambda$3$0$0 = LotteryCollectionService.CardPoolCollectionWithExpandable$lambda$3$0$0(LotteryCollectionService.this, $this$CardPoolCollectionWithExpandable_u24lambda_u243, expand$delegate, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return CardPoolCollectionWithExpandable$lambda$3$0$0;
                }
            }, $composer3, 54), $composer3, 3072, 6);
            Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl(16), Dp.constructor-impl(26));
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i6 = ((0 >> 6) & 112) | 6;
            BoxScope $this$CardPoolCollectionWithExpandable_u24lambda_u243_u240_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1122932439, "C:LotteryCollectionService.kt#5jskp7");
            if (!CardPoolCollectionWithExpandable$lambda$1(expand$delegate)) {
                $composer3.startReplaceGroup(1122925649);
                ComposerKt.sourceInformation($composer3, "200@9370L48,206@9741L20,199@9321L471");
                Painter painterResource = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIcon_arrow_down_12(Res.drawable.INSTANCE), $composer3, 0);
                Modifier modifier5 = SizeKt.size-3ABfNKs($this$CardPoolCollectionWithExpandable_u24lambda_u243_u240_u241.align(Modifier.Companion, Alignment.Companion.getTopEnd()), Dp.constructor-impl(12));
                ComposerKt.sourceInformationMarkerStart($composer3, 1144615958, "CC(remember):LotteryCollectionService.kt#9igjgp");
                Object value$iv2 = $composer3.rememberedValue();
                if (value$iv2 == Composer.Companion.getEmpty()) {
                    value$iv2 = new Function0() { // from class: kntr.app.digital.backpack.lottery.LotteryCollectionService$$ExternalSyntheticLambda8
                        public final Object invoke() {
                            Unit CardPoolCollectionWithExpandable$lambda$3$0$1$0$0;
                            CardPoolCollectionWithExpandable$lambda$3$0$1$0$0 = LotteryCollectionService.CardPoolCollectionWithExpandable$lambda$3$0$1$0$0(expand$delegate);
                            return CardPoolCollectionWithExpandable$lambda$3$0$1$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ImageKt.Image(painterResource, "expand1", ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv2, 15, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer3, Painter.$stable | 48, 120);
            } else {
                $composer3.startReplaceGroup(1113691648);
            }
            $composer3.endReplaceGroup();
            if (CardPoolCollectionWithExpandable$lambda$1(expand$delegate)) {
                $composer3.startReplaceGroup(1123487896);
                ComposerKt.sourceInformation($composer3, "212@9935L48,219@10363L20,211@9886L528");
                Painter painterResource2 = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIcon_arrow_down_12(Res.drawable.INSTANCE), $composer3, 0);
                Modifier modifier6 = SizeKt.size-3ABfNKs($this$CardPoolCollectionWithExpandable_u24lambda_u243_u240_u241.align(RotateKt.rotate(Modifier.Companion, 180.0f), Alignment.Companion.getBottomEnd()), Dp.constructor-impl(12));
                ComposerKt.sourceInformationMarkerStart($composer3, 1144635862, "CC(remember):LotteryCollectionService.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function0() { // from class: kntr.app.digital.backpack.lottery.LotteryCollectionService$$ExternalSyntheticLambda9
                        public final Object invoke() {
                            Unit CardPoolCollectionWithExpandable$lambda$3$0$1$1$0;
                            CardPoolCollectionWithExpandable$lambda$3$0$1$1$0 = LotteryCollectionService.CardPoolCollectionWithExpandable$lambda$3$0$1$1$0(expand$delegate);
                            return CardPoolCollectionWithExpandable$lambda$3$0$1$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv3);
                    it$iv2 = value$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ImageKt.Image(painterResource2, "expand2", ClickableKt.clickable-oSLSa3U$default(modifier6, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer3, Painter.$stable | 48, 120);
            } else {
                $composer3.startReplaceGroup(1113691648);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Unit unit = Unit.INSTANCE;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.backpack.lottery.LotteryCollectionService$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit CardPoolCollectionWithExpandable$lambda$4;
                    CardPoolCollectionWithExpandable$lambda$4 = LotteryCollectionService.CardPoolCollectionWithExpandable$lambda$4(LotteryCollectionService.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CardPoolCollectionWithExpandable$lambda$4;
                }
            });
        }
    }

    private static final boolean CardPoolCollectionWithExpandable$lambda$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void CardPoolCollectionWithExpandable$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CardPoolCollectionWithExpandable$lambda$3$0$0(final LotteryCollectionService this$0, final Density $this_with, final MutableState $expand$delegate, BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C146@6320L2709,140@5993L3036:LotteryCollectionService.kt#5jskp7");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$BoxWithConstraints) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(731235090, $dirty2, -1, "kntr.app.digital.backpack.lottery.LotteryCollectionService.CardPoolCollectionWithExpandable.<anonymous>.<anonymous>.<anonymous> (LotteryCollectionService.kt:139)");
            }
            final float maxW = $this$BoxWithConstraints.getMaxWidth-D9Ej5fM();
            FlowLayoutKt.FlowRow(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), Dp.constructor-impl(16), 0.0f, 0.0f, 12, (Object) null), Arrangement.INSTANCE.getStart(), Arrangement.INSTANCE.getTop(), (Alignment.Vertical) null, 0, 0, ComposableLambdaKt.rememberComposableLambda(-1669607027, true, new Function3() { // from class: kntr.app.digital.backpack.lottery.LotteryCollectionService$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit CardPoolCollectionWithExpandable$lambda$3$0$0$0;
                    CardPoolCollectionWithExpandable$lambda$3$0$0$0 = LotteryCollectionService.CardPoolCollectionWithExpandable$lambda$3$0$0$0(LotteryCollectionService.this, $this_with, maxW, $expand$delegate, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return CardPoolCollectionWithExpandable$lambda$3$0$0$0;
                }
            }, $composer, 54), $composer, 1573296, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x01cf, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L31;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [int] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit CardPoolCollectionWithExpandable$lambda$3$0$0$0(final LotteryCollectionService this$0, Density $this_with, float $maxW, MutableState $expand$delegate, FlowRowScope $this$FlowRow, Composer $composer, int $changed) {
        float totalWidth;
        boolean firstRowComplete;
        long j2;
        Intrinsics.checkNotNullParameter($this$FlowRow, "$this$FlowRow");
        ComposerKt.sourceInformation($composer, "C149@6529L16,*152@6763L22,185@8793L145,169@7746L1227:LotteryCollectionService.kt#5jskp7");
        ?? r12 = 1;
        ?? r13 = 0;
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1669607027, $changed, -1, "kntr.app.digital.backpack.lottery.LotteryCollectionService.CardPoolCollectionWithExpandable.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LotteryCollectionService.kt:147)");
            }
            float totalWidth2 = 0.0f;
            boolean firstRowComplete2 = false;
            State currentLotteryId$delegate = SnapshotStateKt.collectAsState(this$0.lotterySelectedService.getCurrentLotteryIdFlow(), (CoroutineContext) null, $composer, 0, 1);
            Iterable $this$forEach$iv = this$0.lotteryCollectionModel.getList();
            for (Object element$iv : $this$forEach$iv) {
                final LotteryCollectionModel.CardPool cardPool = (LotteryCollectionModel.CardPool) element$iv;
                boolean isSelected = CardPoolCollectionWithExpandable$lambda$3$0$0$0$0(currentLotteryId$delegate) == cardPool.getLotteryId() ? r12 : r13;
                TextMeasurer textMeasurer = TextMeasurerHelperKt.rememberTextMeasurer((int) r13, $composer, (int) r13, (int) r12);
                int $i$f$unpackInt1 = (int) (TextMeasurer.measure-wNUYSr0$default(textMeasurer, cardPool.getLotteryName(), new TextStyle(0L, TextUnitKt.getSp(14), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777213, (DefaultConstructorMarker) null), 0, false, 0, 0L, (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 1020, (Object) null).getSize-YbymL2g() >> 32);
                float textWidth = $i$f$unpackInt1 + $this_with.toPx-0680j_4(Dp.constructor-impl(32));
                if (CardPoolCollectionWithExpandable$lambda$1($expand$delegate)) {
                    totalWidth = totalWidth2;
                    firstRowComplete = firstRowComplete2;
                } else {
                    if (!firstRowComplete2) {
                        totalWidth2 += $this_with.toPx-0680j_4(Dp.constructor-impl(12)) + textWidth;
                        if (totalWidth2 > $this_with.toPx-0680j_4($maxW) - $this_with.toPx-0680j_4(Dp.constructor-impl(12))) {
                            firstRowComplete2 = true;
                        }
                    }
                    if (firstRowComplete2) {
                        r12 = 1;
                        r13 = 0;
                    } else {
                        totalWidth = totalWidth2;
                        firstRowComplete = firstRowComplete2;
                    }
                }
                String lotteryName = cardPool.getLotteryName();
                Modifier modifier = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(12), Dp.constructor-impl(16), 3, (Object) null);
                if (isSelected) {
                    j2 = Color.copy-wmQWz5c$default(ColorKt.Color(4294964669L), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                } else {
                    j2 = Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                }
                Modifier modifier2 = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU(modifier, j2, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(17))), Dp.constructor-impl(16), Dp.constructor-impl(7));
                ComposerKt.sourceInformationMarkerStart($composer, -464850349, "CC(remember):LotteryCollectionService.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance(this$0) | $composer.changed(cardPool);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv = new Function0() { // from class: kntr.app.digital.backpack.lottery.LotteryCollectionService$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        Unit CardPoolCollectionWithExpandable$lambda$3$0$0$0$1$0$0;
                        CardPoolCollectionWithExpandable$lambda$3$0$0$0$1$0$0 = LotteryCollectionService.CardPoolCollectionWithExpandable$lambda$3$0$0$0$1$0$0(LotteryCollectionService.this, cardPool);
                        return CardPoolCollectionWithExpandable$lambda$3$0$0$0$1$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                this$0.CardPoolItem(isSelected, lotteryName, ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), $composer, 0, 0);
                totalWidth2 = totalWidth;
                firstRowComplete2 = firstRowComplete;
                r12 = 1;
                r13 = 0;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final long CardPoolCollectionWithExpandable$lambda$3$0$0$0$0(State<Long> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CardPoolCollectionWithExpandable$lambda$3$0$0$0$1$0$0(LotteryCollectionService this$0, LotteryCollectionModel.CardPool $cardPool) {
        this$0.lotterySelectedService.select($cardPool.getLotteryId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CardPoolCollectionWithExpandable$lambda$3$0$1$0$0(MutableState $expand$delegate) {
        CardPoolCollectionWithExpandable$lambda$2($expand$delegate, !CardPoolCollectionWithExpandable$lambda$1($expand$delegate));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CardPoolCollectionWithExpandable$lambda$3$0$1$1$0(MutableState $expand$delegate) {
        CardPoolCollectionWithExpandable$lambda$2($expand$delegate, !CardPoolCollectionWithExpandable$lambda$1($expand$delegate));
        return Unit.INSTANCE;
    }
}