package kntr.app.mall.product.details.page.ui.floatingLayer;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.mall.product.details.page.ui.container.TopContainerKt;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.utils.HelperKt;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.mall.product.details.page.vm.PageViewModelWrapper;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.device.DeviceType;
import kntr.base.device.KDevice;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LikedCollectionFloatingLayer.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\n\u0010\b\u001a\u00020\tX\u008a\u0084\u0002"}, d2 = {"LikedCollectionFloatingLayer", "", "pageViewModelWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LikedCollectionFloatingLayerKt {

    /* compiled from: LikedCollectionFloatingLayer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeviceType.values().length];
            try {
                iArr[DeviceType.iOS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DeviceType.Android.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LikedCollectionFloatingLayer$lambda$2(PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        LikedCollectionFloatingLayer(pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void LikedCollectionFloatingLayer(final PageViewModelWrapper pageViewModelWrapper, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(pageViewModelWrapper, "pageViewModelWrapper");
        Composer $composer2 = $composer.startRestartGroup(-364514914);
        ComposerKt.sourceInformation($composer2, "C(LikedCollectionFloatingLayer)N(pageViewModelWrapper,modifier)40@1786L16,41@1860L16,47@2107L2971,42@1881L3197:LikedCollectionFloatingLayer.kt#j7uxph");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(pageViewModelWrapper) ? 4 : 2;
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
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-364514914, $dirty2, -1, "kntr.app.mall.product.details.page.ui.floatingLayer.LikedCollectionFloatingLayer (LikedCollectionFloatingLayer.kt:38)");
            }
            final PageViewModel pageViewModel = pageViewModelWrapper.getViewModel();
            final State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer2, 0, 1);
            State visible = SnapshotStateKt.collectAsState(pageViewModel.getShowLikedCollectionLayer(), (CoroutineContext) null, $composer2, 0, 1);
            AnimatedVisibilityKt.AnimatedVisibility(((Boolean) visible.getValue()).booleanValue(), modifier3, EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(500, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(500, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(2145006022, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.LikedCollectionFloatingLayerKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit LikedCollectionFloatingLayer$lambda$1;
                    LikedCollectionFloatingLayer$lambda$1 = LikedCollectionFloatingLayerKt.LikedCollectionFloatingLayer$lambda$1(PageViewModel.this, scaleModel$delegate, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return LikedCollectionFloatingLayer$lambda$1;
                }
            }, $composer2, 54), $composer2, ($dirty2 & 112) | 200064, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.LikedCollectionFloatingLayerKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit LikedCollectionFloatingLayer$lambda$2;
                    LikedCollectionFloatingLayer$lambda$2 = LikedCollectionFloatingLayerKt.LikedCollectionFloatingLayer$lambda$2(PageViewModelWrapper.this, modifier3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return LikedCollectionFloatingLayer$lambda$2;
                }
            });
        }
    }

    private static final UiScaleModel LikedCollectionFloatingLayer$lambda$0(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LikedCollectionFloatingLayer$lambda$1(final PageViewModel $pageViewModel, State $scaleModel$delegate, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C56@2514L447,48@2117L2955:LikedCollectionFloatingLayer.kt#j7uxph");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2145006022, $changed, -1, "kntr.app.mall.product.details.page.ui.floatingLayer.LikedCollectionFloatingLayer.<anonymous> (LikedCollectionFloatingLayer.kt:48)");
        }
        Modifier modifier = PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(68, LikedCollectionFloatingLayer$lambda$0($scaleModel$delegate).getScale()), 7, (Object) null), TopContainerKt.m587withOverlayAlphaDxMtmZc(Color.Companion.getBlack-0d7_KjU(), 0.8f), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(4, LikedCollectionFloatingLayer$lambda$0($scaleModel$delegate).getScale()))), ProvideUiScaleKt.dpScaled(12, LikedCollectionFloatingLayer$lambda$0($scaleModel$delegate).getScale()));
        ComposerKt.sourceInformationMarkerStart($composer, -233501467, "CC(remember):LikedCollectionFloatingLayer.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance($pageViewModel);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.LikedCollectionFloatingLayerKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit LikedCollectionFloatingLayer$lambda$1$0$0;
                    LikedCollectionFloatingLayer$lambda$1$0$0 = LikedCollectionFloatingLayerKt.LikedCollectionFloatingLayer$lambda$1$0$0(PageViewModel.this);
                    return LikedCollectionFloatingLayer$lambda$1$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
        int $changed$iv$iv = (0 << 3) & 112;
        ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
        CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
        Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            factory$iv$iv$iv = factory$iv$iv$iv5;
            $composer.createNode(factory$iv$iv$iv);
        } else {
            factory$iv$iv$iv = factory$iv$iv$iv5;
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
        ComposerKt.sourceInformationMarkerStart($composer, -99264888, "C66@2987L2075:LikedCollectionFloatingLayer.kt#j7uxph");
        Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
        Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
        ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
        MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((438 >> 3) & 14) | ((438 >> 3) & 112));
        int $changed$iv$iv2 = (438 << 3) & 112;
        ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
        CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
        Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            factory$iv$iv$iv2 = factory$iv$iv$iv6;
            $composer.createNode(factory$iv$iv$iv2);
        } else {
            factory$iv$iv$iv2 = factory$iv$iv$iv6;
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
        int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
        RowScope rowScope = RowScopeInstance.INSTANCE;
        int i4 = ((438 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, 2080186421, "C71@3206L903,92@4127L921:LikedCollectionFloatingLayer.kt#j7uxph");
        Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
        ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
        Modifier modifier$iv3 = Modifier.Companion;
        Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
        MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
        int $changed$iv$iv3 = (384 << 3) & 112;
        ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
        CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
        Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            factory$iv$iv$iv3 = factory$iv$iv$iv7;
            $composer.createNode(factory$iv$iv$iv3);
        } else {
            factory$iv$iv$iv3 = factory$iv$iv$iv7;
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
        int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
        RowScope rowScope2 = RowScopeInstance.INSTANCE;
        int i6 = ((384 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -1051396729, "C74@3319L565,88@4030L9,85@3905L186:LikedCollectionFloatingLayer.kt#j7uxph");
        String $this$asRequest$iv = HelperKt.customizedImageUrl("https://i0.hdslb.com/bfs/kfptfe/floor/32d8eeb7fdd36cfc8abc274783301838116bc8c6.png");
        ImageRequest $this$LikedCollectionFloatingLayer_u24lambda_u241_u241_u240_u240_u240 = new ImageRequest($this$asRequest$iv);
        $this$LikedCollectionFloatingLayer_u24lambda_u241_u241_u240_u240_u240.contentScale(ContentScale.Companion.getFit());
        BiliImageKt.BiliImage($this$LikedCollectionFloatingLayer_u24lambda_u241_u241_u240_u240_u240.build(), SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(4, LikedCollectionFloatingLayer$lambda$0($scaleModel$delegate).getScale()), 0.0f, 11, (Object) null), ProvideUiScaleKt.dpScaled(18, LikedCollectionFloatingLayer$lambda$0($scaleModel$delegate).getScale())), null, null, null, null, null, null, null, $composer, 0, 508);
        TextKt.Text-Nvy7gAk("收藏成功", (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), LikedCollectionFloatingLayer$lambda$0($scaleModel$delegate).getScale()), $composer, 390, 0, 131066);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getCenterVertically();
        ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
        Modifier modifier$iv4 = Modifier.Companion;
        Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
        MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
        int $changed$iv$iv4 = (384 << 3) & 112;
        ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
        CompositionLocalMap localMap$iv$iv4 = $composer.getCurrentCompositionLocalMap();
        Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer, modifier$iv4);
        Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
        int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            factory$iv$iv$iv4 = factory$iv$iv$iv8;
            $composer.createNode(factory$iv$iv$iv4);
        } else {
            factory$iv$iv$iv4 = factory$iv$iv$iv8;
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer);
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
        int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
        RowScope rowScope3 = RowScopeInstance.INSTANCE;
        int i8 = ((384 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -1591092308, "C98@4381L9,95@4240L202,100@4463L567:LikedCollectionFloatingLayer.kt#j7uxph");
        TextKt.Text-Nvy7gAk("查看我的收藏", (Modifier) null, ColorKt.Color((int) KotlinVersion.MAX_COMPONENT_VALUE, 102, 153, (int) KotlinVersion.MAX_COMPONENT_VALUE), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), LikedCollectionFloatingLayer$lambda$0($scaleModel$delegate).getScale()), $composer, 390, 0, 131066);
        String $this$asRequest$iv2 = HelperKt.customizedImageUrl("https://i0.hdslb.com/bfs/kfptfe/floor/9ea7c122709de62ca2d8cb2a73f58014400edaed.png");
        ImageRequest $this$LikedCollectionFloatingLayer_u24lambda_u241_u241_u240_u241_u240 = new ImageRequest($this$asRequest$iv2);
        $this$LikedCollectionFloatingLayer_u24lambda_u241_u241_u240_u241_u240.contentScale(ContentScale.Companion.getFit());
        BiliImageKt.BiliImage($this$LikedCollectionFloatingLayer_u24lambda_u241_u241_u240_u241_u240.build(), SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(4, LikedCollectionFloatingLayer$lambda$0($scaleModel$delegate).getScale()), 0.0f, 0.0f, 0.0f, 14, (Object) null), ProvideUiScaleKt.dpScaled(12, LikedCollectionFloatingLayer$lambda$0($scaleModel$delegate).getScale())), null, null, null, null, null, null, null, $composer, 0, 508);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LikedCollectionFloatingLayer$lambda$1$0$0(PageViewModel $pageViewModel) {
        String targetUrl;
        switch (WhenMappings.$EnumSwitchMapping$0[KDevice.INSTANCE.getDeviceType().ordinal()]) {
            case 1:
                targetUrl = "bilibili://user_center/favourite?tab=product";
                break;
            case 2:
                targetUrl = "bilibili://main/favorite?tab=product";
                break;
            default:
                targetUrl = null;
                break;
        }
        $pageViewModel.handleJumpUrl$product_details_page_debug(targetUrl);
        return Unit.INSTANCE;
    }
}