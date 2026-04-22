package kntr.app.ad.ad.biz.liveroom.ui;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
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
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.bilibili.compose.color.ThemeColorsKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.GarbInfo;
import kntr.app.ad.ad.biz.liveroom.AdLiveBrandCardButtonState;
import kntr.app.ad.ad.biz.liveroom.AdLiveBrandCardCoverState;
import kntr.app.ad.ad.biz.liveroom.AdLiveBrandCardTagViewState;
import kntr.app.ad.ad.biz.liveroom.AdLiveBrandCardTitleState;
import kntr.app.ad.ad.biz.liveroom.AdLiveRoomBrandCardUIState;
import kntr.app.ad.ad.biz.liveroom.vm.AdLiveRoomBrandCardViewModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kntr.base.imageloader.ImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.ad.ui.uikit.generated.resources.Drawable0_commonMainKt;
import srcs.app.ad.ui.uikit.generated.resources.Res;

/* compiled from: AdLiveRoomBrandCard.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a-\u0010\t\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a!\u0010\u0010\u001a\u00020\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0013¨\u0006\u0014²\u0006\f\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u008a\u0084\u0002"}, d2 = {"AdLiveRoomBrandCard", RoomRecommendViewModel.EMPTY_CURSOR, "vm", "Lkntr/app/ad/ad/biz/liveroom/vm/AdLiveRoomBrandCardViewModel;", "modifier", "Landroidx/compose/ui/Modifier;", "onCloseViewClick", "Lkotlin/Function0;", "(Lkntr/app/ad/ad/biz/liveroom/vm/AdLiveRoomBrandCardViewModel;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "AdLiveRoomBigCardCover", "url", RoomRecommendViewModel.EMPTY_CURSOR, "failPlaceholderIconSize", "Landroidx/compose/ui/unit/Dp;", "AdLiveRoomBigCardCover-6a0pyJM", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;FLandroidx/compose/runtime/Composer;II)V", "CenteredTextButton", "state", "Lkntr/app/ad/ad/biz/liveroom/AdLiveBrandCardButtonState;", "(Lkntr/app/ad/ad/biz/liveroom/AdLiveBrandCardButtonState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "liveroom_debug", "uiState", "Lkntr/app/ad/ad/biz/liveroom/AdLiveRoomBrandCardUIState;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AdLiveRoomBrandCardKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdLiveRoomBigCardCover_6a0pyJM$lambda$1(String str, Modifier modifier, float f, int i, int i2, Composer composer, int i3) {
        m103AdLiveRoomBigCardCover6a0pyJM(str, modifier, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdLiveRoomBrandCard$lambda$3(AdLiveRoomBrandCardViewModel adLiveRoomBrandCardViewModel, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        AdLiveRoomBrandCard(adLiveRoomBrandCardViewModel, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CenteredTextButton$lambda$1(AdLiveBrandCardButtonState adLiveBrandCardButtonState, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CenteredTextButton(adLiveBrandCardButtonState, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v8 */
    public static final void AdLiveRoomBrandCard(final AdLiveRoomBrandCardViewModel vm, Modifier modifier, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 function02;
        Function0 onCloseViewClick;
        Modifier modifier3;
        Modifier modifier4;
        final Function0 onCloseViewClick2;
        Intrinsics.checkNotNullParameter(vm, "vm");
        Composer $composer2 = $composer.startRestartGroup(954053668);
        ComposerKt.sourceInformation($composer2, "C(AdLiveRoomBrandCard)N(vm,modifier,onCloseViewClick)48@2129L2,50@2167L16:AdLiveRoomBrandCard.kt#wjc8hy");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(vm) ? 4 : 2;
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
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            function02 = function0;
        } else if (($changed & 384) == 0) {
            function02 = function0;
            $dirty |= $composer2.changedInstance(function02) ? 256 : 128;
        } else {
            function02 = function0;
        }
        if (!$composer2.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            onCloseViewClick = function02;
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 2017545158, "CC(remember):AdLiveRoomBrandCard.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.ad.ad.biz.liveroom.ui.AdLiveRoomBrandCardKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onCloseViewClick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onCloseViewClick2 = function02;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(954053668, $dirty, -1, "kntr.app.ad.ad.biz.liveroom.ui.AdLiveRoomBrandCard (AdLiveRoomBrandCard.kt:49)");
            }
            State uiState$delegate = SnapshotStateKt.collectAsState(vm.getUiState(), (CoroutineContext) null, $composer2, 0, 1);
            final AdLiveRoomBrandCardUIState state = AdLiveRoomBrandCard$lambda$1(uiState$delegate);
            if (state == null) {
                $composer2.startReplaceGroup(-1880414737);
            } else {
                $composer2.startReplaceGroup(-1880414736);
                ComposerKt.sourceInformation($composer2, "*60@2519L62,63@2593L3677,53@2221L4049");
                Modifier clip = ClipKt.clip(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(modifier4, Dp.constructor-impl(114)), Dp.constructor-impl(180)), Color.Companion.getWhite-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(6))), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(6)));
                ComposerKt.sourceInformationMarkerStart($composer2, -1523200125, "CC(remember):AdLiveRoomBrandCard.kt#9igjgp");
                boolean invalid$iv = $composer2.changedInstance(vm);
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.app.ad.ad.biz.liveroom.ui.AdLiveRoomBrandCardKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit AdLiveRoomBrandCard$lambda$2$0$0;
                            AdLiveRoomBrandCard$lambda$2$0$0 = AdLiveRoomBrandCardKt.AdLiveRoomBrandCard$lambda$2$0$0(AdLiveRoomBrandCardViewModel.this);
                            return AdLiveRoomBrandCard$lambda$2$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                SurfaceKt.Surface-T9BRK9s(ClickableKt.clickable-oSLSa3U$default(clip, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), (Shape) null, 0L, 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-2074104086, true, new Function2() { // from class: kntr.app.ad.ad.biz.liveroom.ui.AdLiveRoomBrandCardKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj, Object obj2) {
                        Unit AdLiveRoomBrandCard$lambda$2$1;
                        AdLiveRoomBrandCard$lambda$2$1 = AdLiveRoomBrandCardKt.AdLiveRoomBrandCard$lambda$2$1(AdLiveRoomBrandCardUIState.this, onCloseViewClick2, vm, (Composer) obj, ((Integer) obj2).intValue());
                        return AdLiveRoomBrandCard$lambda$2$1;
                    }
                }, $composer2, 54), $composer2, 12582912, 126);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            onCloseViewClick = onCloseViewClick2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function0 function03 = onCloseViewClick;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ad.biz.liveroom.ui.AdLiveRoomBrandCardKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit AdLiveRoomBrandCard$lambda$3;
                    AdLiveRoomBrandCard$lambda$3 = AdLiveRoomBrandCardKt.AdLiveRoomBrandCard$lambda$3(AdLiveRoomBrandCardViewModel.this, modifier5, function03, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AdLiveRoomBrandCard$lambda$3;
                }
            });
        }
    }

    private static final AdLiveRoomBrandCardUIState AdLiveRoomBrandCard$lambda$1(State<AdLiveRoomBrandCardUIState> state) {
        Object thisObj$iv = state.getValue();
        return (AdLiveRoomBrandCardUIState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdLiveRoomBrandCard$lambda$2$0$0(AdLiveRoomBrandCardViewModel $vm) {
        $vm.clickCard();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x031a, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit AdLiveRoomBrandCard$lambda$2$1(AdLiveRoomBrandCardUIState $state, final Function0 $onCloseViewClick, final AdLiveRoomBrandCardViewModel $vm, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        ComposerKt.sourceInformation($composer, "C64@2607L3653:AdLiveRoomBrandCard.kt#wjc8hy");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2074104086, $changed, -1, "kntr.app.ad.ad.biz.liveroom.ui.AdLiveRoomBrandCard.<anonymous>.<anonymous> (AdLiveRoomBrandCard.kt:64)");
            }
            Modifier modifier$iv = PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Color.Companion.getWhite-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(6))), Dp.constructor-impl(2));
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1120308438, "C71@2873L2673,133@5564L40,136@5644L489,150@6151L40,152@6209L37:AdLiveRoomBrandCard.kt#wjc8hy");
            Modifier modifier$iv2 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(120));
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i4 = ((6 >> 6) & 112) | 6;
            BoxScope $this$AdLiveRoomBrandCard_u24lambda_u242_u241_u240_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 316911166, "C83@3347L6,78@3097L405,93@3746L150,88@3524L1016:AdLiveRoomBrandCard.kt#wjc8hy");
            AdLiveBrandCardCoverState coverState = $state.getCoverState();
            m103AdLiveRoomBigCardCover6a0pyJM(coverState != null ? coverState.getUrl() : null, ClipKt.clip(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getWh0-0d7_KjU(), (Shape) null, 2, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), Dp.constructor-impl(50), $composer, 384, 0);
            Modifier modifier = SizeKt.size-3ABfNKs($this$AdLiveRoomBrandCard_u24lambda_u242_u241_u240_u240.align(Modifier.Companion, Alignment.Companion.getTopEnd()), Dp.constructor-impl(24));
            ComposerKt.sourceInformationMarkerStart($composer, 287336092, "CC(remember):AdLiveRoomBrandCard.kt#9igjgp");
            boolean invalid$iv = $composer.changed($onCloseViewClick) | $composer.changedInstance($vm);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.app.ad.ad.biz.liveroom.ui.AdLiveRoomBrandCardKt$$ExternalSyntheticLambda7
                public final Object invoke() {
                    Unit AdLiveRoomBrandCard$lambda$2$1$0$0$0$0;
                    AdLiveRoomBrandCard$lambda$2$1$0$0$0$0 = AdLiveRoomBrandCardKt.AdLiveRoomBrandCard$lambda$2$1$0$0$0$0($onCloseViewClick, $vm);
                    return AdLiveRoomBrandCard$lambda$2$1$0$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv$iv = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv3 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i6 = ((48 >> 6) & 112) | 6;
            BoxScope $this$AdLiveRoomBrandCard_u24lambda_u242_u241_u240_u240_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -1601277352, "C102@4116L126,100@4039L479:AdLiveRoomBrandCard.kt#wjc8hy");
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getAd_live_ad_big_card_close(Res.drawable.INSTANCE), $composer, 0), "Close", $this$AdLiveRoomBrandCard_u24lambda_u242_u241_u240_u240_u241.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), Alignment.Companion.getTopEnd()), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, Painter.$stable | 48, 120);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            AdLiveBrandCardTagViewState adTagState = $state.getAdTagState();
            String text = adTagState != null ? adTagState.getText() : null;
            if (!(text == null || text.length() == 0)) {
                $composer.startReplaceGroup(318385618);
                ComposerKt.sourceInformation($composer, "113@4632L874");
                AdLiveBrandCardTagViewState adTagState2 = $state.getAdTagState();
                String text2 = adTagState2 != null ? adTagState2.getText() : null;
                String str = text2 == null ? RoomRecommendViewModel.EMPTY_CURSOR : text2;
                long sp = TextUnitKt.getSp(7);
                TextKt.Text-Nvy7gAk(str, PaddingKt.padding-VpY3zN4$default(SizeKt.height-3ABfNKs(BackgroundKt.background-bw27NRU($this$AdLiveRoomBrandCard_u24lambda_u242_u241_u240_u240.align(Modifier.Companion, Alignment.Companion.getBottomEnd()), ColorKt.Color(855638016), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(4), 0.0f, Dp.constructor-impl(4), 0.0f, 10, (Object) null)), Dp.constructor-impl(10)), Dp.constructor-impl(1), 0.0f, 2, (Object) null), ColorKt.Color(4294967295L), (TextAutoSize) null, sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(10), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 1, (Function1) null, (TextStyle) null, $composer, 24960, 221616, 206824);
            } else {
                $composer.startReplaceGroup(313762588);
            }
            $composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer, 6);
            AdLiveBrandCardTitleState titleState = $state.getTitleState();
            String text3 = titleState != null ? titleState.getText() : null;
            String str2 = text3 == null ? RoomRecommendViewModel.EMPTY_CURSOR : text3;
            long sp2 = TextUnitKt.getSp(11);
            FontWeight bold = FontWeight.Companion.getBold();
            TextKt.Text-Nvy7gAk(str2, SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(28)), ColorKt.Color(4279769372L), (TextAutoSize) null, sp2, (FontStyle) null, bold, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(11), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 2, (Function1) null, (TextStyle) null, $composer, 1597872, 221616, 206760);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer, 6);
            CenteredTextButton($state.getButtonState(), null, $composer, 0, 2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdLiveRoomBrandCard$lambda$2$1$0$0$0$0(Function0 $onCloseViewClick, AdLiveRoomBrandCardViewModel $vm) {
        $onCloseViewClick.invoke();
        $vm.reportClose();
        return Unit.INSTANCE;
    }

    /* renamed from: AdLiveRoomBigCardCover-6a0pyJM  reason: not valid java name */
    public static final void m103AdLiveRoomBigCardCover6a0pyJM(final String url, Modifier modifier, float f, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float f2;
        float f3;
        Modifier modifier3;
        Modifier modifier4;
        final float f4;
        Composer $composer2 = $composer.startRestartGroup(-508522396);
        ComposerKt.sourceInformation($composer2, "C(AdLiveRoomBigCardCover)N(url,modifier,failPlaceholderIconSize:c#ui.unit.Dp)170@6636L972,164@6431L1184:AdLiveRoomBrandCard.kt#wjc8hy");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(url) ? 4 : 2;
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
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            f2 = f;
        } else if (($changed & 384) == 0) {
            f2 = f;
            $dirty |= $composer2.changed(f2) ? 256 : 128;
        } else {
            f2 = f;
        }
        if (!$composer2.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            f3 = f2;
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                f4 = f2;
            } else {
                f4 = Dp.constructor-impl(50);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-508522396, $dirty, -1, "kntr.app.ad.ad.biz.liveroom.ui.AdLiveRoomBigCardCover (AdLiveRoomBrandCard.kt:163)");
            }
            BiliImageKt.BiliImage(new ImageRequest(url == null ? RoomRecommendViewModel.EMPTY_CURSOR : url).contentScale(ContentScale.Companion.getFillBounds()).build(), modifier4, (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, ComposableLambdaKt.rememberComposableLambda(-1912312173, true, new Function4() { // from class: kntr.app.ad.ad.biz.liveroom.ui.AdLiveRoomBrandCardKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit AdLiveRoomBigCardCover_6a0pyJM$lambda$0;
                    AdLiveRoomBigCardCover_6a0pyJM$lambda$0 = AdLiveRoomBrandCardKt.AdLiveRoomBigCardCover_6a0pyJM$lambda$0(f4, (ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return AdLiveRoomBigCardCover_6a0pyJM$lambda$0;
                }
            }, $composer2, 54), $composer2, ($dirty & 112) | 100663296, 252);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            f3 = f4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final float f5 = f3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ad.biz.liveroom.ui.AdLiveRoomBrandCardKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit AdLiveRoomBigCardCover_6a0pyJM$lambda$1;
                    AdLiveRoomBigCardCover_6a0pyJM$lambda$1 = AdLiveRoomBrandCardKt.AdLiveRoomBigCardCover_6a0pyJM$lambda$1(url, modifier5, f5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AdLiveRoomBigCardCover_6a0pyJM$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdLiveRoomBigCardCover_6a0pyJM$lambda$0(float f, ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        long Color;
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)175@6796L6,171@6650L948:AdLiveRoomBrandCard.kt#wjc8hy");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1912312173, $changed, -1, "kntr.app.ad.ad.biz.liveroom.ui.AdLiveRoomBigCardCover.<anonymous> (AdLiveRoomBrandCard.kt:171)");
        }
        Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGa2-0d7_KjU(), (Shape) null, 2, (Object) null);
        Alignment contentAlignment$iv = Alignment.Companion.getCenter();
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
        int $changed$iv$iv = (48 << 3) & 112;
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
        int i2 = ((48 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, 1407001368, "C179@6931L47,184@7217L7,178@6894L690:AdLiveRoomBrandCard.kt#wjc8hy");
        Painter painterResource = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_tv_placeholder(Res.drawable.INSTANCE), $composer, 0);
        Modifier modifier = SizeKt.size-3ABfNKs(Modifier.Companion, f);
        ColorFilter.Companion companion = ColorFilter.Companion;
        CompositionLocal this_$iv = BiliThemeKt.getLocalTheme();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ThemeColorsKt.isNightTheme((GarbInfo) consume)) {
            Color = ColorKt.Color(4282137660L);
        } else {
            Color = ColorKt.Color(4292138196L);
        }
        ImageKt.Image(painterResource, (String) null, modifier, (Alignment) null, ContentScale.Companion.getFillBounds(), 0.0f, ColorFilter.Companion.tint-xETnrds$default(companion, Color, 0, 2, (Object) null), $composer, Painter.$stable | 24624, 40);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final void CenteredTextButton(final AdLiveBrandCardButtonState state, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(112120794);
        ComposerKt.sourceInformation($composer2, "C(CenteredTextButton)N(state,modifier)204@7738L550:AdLiveRoomBrandCard.kt#wjc8hy");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
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
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(112120794, $dirty, -1, "kntr.app.ad.ad.biz.liveroom.ui.CenteredTextButton (AdLiveRoomBrandCard.kt:203)");
            }
            Modifier modifier$iv = BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), Dp.constructor-impl(24)), ColorKt.Color(4294928025L), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4)));
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier$iv$iv = modifier3;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -805429241, "C215@8114L168:AdLiveRoomBrandCard.kt#wjc8hy");
            String text = state != null ? state.getText() : null;
            TextKt.Text-Nvy7gAk(text == null ? RoomRecommendViewModel.EMPTY_CURSOR : text, (Modifier) null, ColorKt.Color(4294964214L), (TextAutoSize) null, TextUnitKt.getSp(13), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer2, 24960, 0, 261098);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier$iv$iv;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ad.biz.liveroom.ui.AdLiveRoomBrandCardKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CenteredTextButton$lambda$1;
                    CenteredTextButton$lambda$1 = AdLiveRoomBrandCardKt.CenteredTextButton$lambda$1(AdLiveBrandCardButtonState.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CenteredTextButton$lambda$1;
                }
            });
        }
    }
}