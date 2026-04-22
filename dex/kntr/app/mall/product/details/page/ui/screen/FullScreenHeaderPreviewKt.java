package kntr.app.mall.product.details.page.ui.screen;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.BasicInfoFloor;
import kntr.app.mall.product.details.page.api.model.FooterFloor;
import kntr.app.mall.product.details.page.api.model.GlobalSkinConfigDTO;
import kntr.app.mall.product.details.page.api.model.ProductDetailsResponse;
import kntr.app.mall.product.details.page.ui.container.BottomContainerKt;
import kntr.app.mall.product.details.page.ui.container.TopContainerKt;
import kntr.app.mall.product.details.page.ui.container.TopTabItem;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.vm.BottomContainerState;
import kntr.app.mall.product.details.page.vm.ContentModule;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.mall.product.details.page.vm.PageViewModelWrapper;
import kntr.app.mall.product.details.page.vm.VideoPlayerViewModelWrapper;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
import kntr.common.trio.pagecontroller.OnBackPressedCallback_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullScreenHeaderPreview.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\u001a:\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\u0010\u000b\u001a\u001f\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010\u000f\u001a\u001f\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010\u0011\u001a\u001f\u0010\u0012\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010\u000f\u001a\u001f\u0010\u0013\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010\u000f¨\u0006\u0014²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u0084\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u0084\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u0084\u0002²\u0006\f\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u008a\u0084\u0002²\u0006\f\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u008a\u0084\u0002²\u0006\n\u0010\u001b\u001a\u00020\u001cX\u008a\u0084\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u0084\u0002²\u0006\f\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u008a\u0084\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u0084\u0002"}, d2 = {"FullScreenHeaderPreview", "", "pageViewModelWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "videoViewModelWrapper", "Lkntr/app/mall/product/details/page/vm/VideoPlayerViewModelWrapper;", "headerBannerSection", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Lkntr/app/mall/product/details/page/vm/VideoPlayerViewModelWrapper;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TopIndicator", "pageViewModel", "Lkntr/app/mall/product/details/page/vm/PageViewModel;", "(Lkntr/app/mall/product/details/page/vm/PageViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "PreviewTabContainer", "(Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "BottomIndicator", "BottomContainer", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;", "showFullScreen", "", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "selectedIndex", "", "bottomContainerState", "Lkntr/app/mall/product/details/page/vm/BottomContainerState;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FullScreenHeaderPreviewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomContainer$lambda$2(PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        BottomContainer(pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomContainer$lambda$3(PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        BottomContainer(pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomContainer$lambda$6(PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        BottomContainer(pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomIndicator$lambda$4(PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        BottomIndicator(pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullScreenHeaderPreview$lambda$4(PageViewModelWrapper pageViewModelWrapper, VideoPlayerViewModelWrapper videoPlayerViewModelWrapper, Function2 function2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        FullScreenHeaderPreview(pageViewModelWrapper, videoPlayerViewModelWrapper, function2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewTabContainer$lambda$2(PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        PreviewTabContainer(pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewTabContainer$lambda$3(PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        PreviewTabContainer(pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewTabContainer$lambda$5(PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        PreviewTabContainer(pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopIndicator$lambda$2(PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TopIndicator(pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void FullScreenHeaderPreview(final PageViewModelWrapper pageViewModelWrapper, final VideoPlayerViewModelWrapper videoViewModelWrapper, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(pageViewModelWrapper, "pageViewModelWrapper");
        Intrinsics.checkNotNullParameter(videoViewModelWrapper, "videoViewModelWrapper");
        Intrinsics.checkNotNullParameter(function2, "headerBannerSection");
        Composer $composer2 = $composer.startRestartGroup(-266780289);
        ComposerKt.sourceInformation($composer2, "C(FullScreenHeaderPreview)N(pageViewModelWrapper,videoViewModelWrapper,headerBannerSection,modifier)60@2886L16,61@2971L16,63@3040L7,65@3075L143,83@3626L2020,78@3399L2247:FullScreenHeaderPreview.kt#dsyj5e");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(pageViewModelWrapper) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(videoViewModelWrapper) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-266780289, $dirty2, -1, "kntr.app.mall.product.details.page.ui.screen.FullScreenHeaderPreview (FullScreenHeaderPreview.kt:57)");
            }
            final PageViewModel pageViewModel = pageViewModelWrapper.getViewModel();
            videoViewModelWrapper.getViewModel();
            final State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer2, 0, 1);
            State showFullScreen$delegate = SnapshotStateKt.collectAsState(pageViewModel.getShowHeaderFullScreenPreview(), (CoroutineContext) null, $composer2, 0, 1);
            OnBackPressedDispatcher backHandler = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer2, LocalOnBackPressedDispatcher.$stable);
            ComposerKt.sourceInformationMarkerStart($composer2, 1322198638, "CC(remember):FullScreenHeaderPreview.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = OnBackPressedCallback_androidKt.OnBackPressedCallback(true, new Function1() { // from class: kntr.app.mall.product.details.page.ui.screen.FullScreenHeaderPreviewKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        Unit FullScreenHeaderPreview$lambda$2$0;
                        FullScreenHeaderPreview$lambda$2$0 = FullScreenHeaderPreviewKt.FullScreenHeaderPreview$lambda$2$0(PageViewModel.this, (OnBackPressedCallback) obj);
                        return FullScreenHeaderPreview$lambda$2$0;
                    }
                });
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            OnBackPressedCallback callback = (OnBackPressedCallback) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (FullScreenHeaderPreview$lambda$1(showFullScreen$delegate)) {
                backHandler.addCallback(callback);
            } else {
                callback.remove();
            }
            int $this$dp$iv = Integer.parseInt(pageViewModel.getStatusBarHeight());
            final float topInsets = Dp.constructor-impl($this$dp$iv);
            AnimatedVisibilityKt.AnimatedVisibility(FullScreenHeaderPreview$lambda$1(showFullScreen$delegate), modifier4, EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(-7930793, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.screen.FullScreenHeaderPreviewKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit FullScreenHeaderPreview$lambda$3;
                    FullScreenHeaderPreview$lambda$3 = FullScreenHeaderPreviewKt.FullScreenHeaderPreview$lambda$3(topInsets, pageViewModel, function2, scaleModel$delegate, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return FullScreenHeaderPreview$lambda$3;
                }
            }, $composer2, 54), $composer2, (($dirty2 >> 6) & 112) | 200064, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.screen.FullScreenHeaderPreviewKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit FullScreenHeaderPreview$lambda$4;
                    FullScreenHeaderPreview$lambda$4 = FullScreenHeaderPreviewKt.FullScreenHeaderPreview$lambda$4(PageViewModelWrapper.this, videoViewModelWrapper, function2, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return FullScreenHeaderPreview$lambda$4;
                }
            });
        }
    }

    private static final UiScaleModel FullScreenHeaderPreview$lambda$0(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    private static final boolean FullScreenHeaderPreview$lambda$1(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullScreenHeaderPreview$lambda$2$0(PageViewModel $pageViewModel, OnBackPressedCallback $this$OnBackPressedCallback) {
        Intrinsics.checkNotNullParameter($this$OnBackPressedCallback, "$this$OnBackPressedCallback");
        $pageViewModel.toggleHeaderFullScreenPreview$product_details_page_debug(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x01d9, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit FullScreenHeaderPreview$lambda$3(float $topInsets, final PageViewModel $pageViewModel, Function2 $headerBannerSection, State $scaleModel$delegate, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C88@3766L6,92@3928L99,96@4094L63,84@3636L2004:FullScreenHeaderPreview.kt#dsyj5e");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-7930793, $changed, -1, "kntr.app.mall.product.details.page.ui.screen.FullScreenHeaderPreview.<anonymous> (FullScreenHeaderPreview.kt:84)");
        }
        Modifier modifier = PaddingKt.padding-qDBjuR0$default(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), 0.0f, $topInsets, 0.0f, 0.0f, 13, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, 968452282, "CC(remember):FullScreenHeaderPreview.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = InteractionSourceKt.MutableInteractionSource();
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 968457558, "CC(remember):FullScreenHeaderPreview.kt#9igjgp");
        Object it$iv2 = $composer.rememberedValue();
        if (it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.screen.FullScreenHeaderPreviewKt$$ExternalSyntheticLambda7
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Modifier modifier$iv = ClickableKt.clickable-O2vRcR0$default(modifier, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv2, 28, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
        int $changed$iv$iv = (0 << 3) & 112;
        ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
        CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
        Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScope boxScope = BoxScopeInstance.INSTANCE;
        int i2 = ((0 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -1469779841, "C104@4318L106,100@4183L1447:FullScreenHeaderPreview.kt#dsyj5e");
        Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, 1060969383, "CC(remember):FullScreenHeaderPreview.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance($pageViewModel);
        Object it$iv3 = $composer.rememberedValue();
        if (invalid$iv) {
        }
        Object value$iv3 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.screen.FullScreenHeaderPreviewKt$$ExternalSyntheticLambda8
            public final Object invoke() {
                Unit FullScreenHeaderPreview$lambda$3$2$0$0;
                FullScreenHeaderPreview$lambda$3$2$0$0 = FullScreenHeaderPreviewKt.FullScreenHeaderPreview$lambda$3$2$0$0(PageViewModel.this);
                return FullScreenHeaderPreview$lambda$3$2$0$0;
            }
        };
        $composer.updateRememberedValue(value$iv3);
        it$iv3 = value$iv3;
        ComposerKt.sourceInformationMarkerEnd($composer);
        Modifier modifier$iv2 = ClickableKt.clickable-oSLSa3U$default(fillMaxSize$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
        MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
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
        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        int i4 = ((0 >> 6) & 112) | 6;
        BoxScope $this$FullScreenHeaderPreview_u24lambda_u243_u242_u241 = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, -327933382, "C108@4458L255,118@4794L420,128@5232L384:FullScreenHeaderPreview.kt#dsyj5e");
        Modifier modifier$iv3 = $this$FullScreenHeaderPreview_u24lambda_u243_u242_u241.align(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getTopCenter());
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        Alignment contentAlignment$iv3 = Alignment.Companion.getTopStart();
        MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
        int $changed$iv$iv3 = (0 << 3) & 112;
        ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
        CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
        Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            factory$iv$iv$iv3 = factory$iv$iv$iv8;
            $composer.createNode(factory$iv$iv$iv3);
        } else {
            factory$iv$iv$iv3 = factory$iv$iv$iv8;
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
        BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
        int i6 = ((0 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -130099073, "C114@4668L27:FullScreenHeaderPreview.kt#dsyj5e");
        TopIndicator($pageViewModel, null, $composer, 0, 2);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Modifier modifier$iv4 = $this$FullScreenHeaderPreview_u24lambda_u243_u242_u241.align(Modifier.Companion, Alignment.Companion.getCenter());
        Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
        ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
        MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
        int $changed$iv$iv4 = (384 << 3) & 112;
        ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
        CompositionLocalMap localMap$iv$iv4 = $composer.getCurrentCompositionLocalMap();
        Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer, modifier$iv4);
        Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
        int $i$f$Column = $changed$iv$iv4 << 6;
        int $changed$iv$iv$iv4 = ($i$f$Column & 896) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            factory$iv$iv$iv4 = factory$iv$iv$iv9;
            $composer.createNode(factory$iv$iv$iv4);
        } else {
            factory$iv$iv$iv4 = factory$iv$iv$iv9;
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer);
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
        int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
        int i8 = ((384 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, 44765316, "C123@5030L21,124@5072L73,125@5166L30:FullScreenHeaderPreview.kt#dsyj5e");
        $headerBannerSection.invoke($composer, 0);
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(18, FullScreenHeaderPreview$lambda$0($scaleModel$delegate).getScale())), $composer, 0);
        BottomIndicator($pageViewModel, null, $composer, 0, 2);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Modifier modifier$iv5 = $this$FullScreenHeaderPreview_u24lambda_u243_u242_u241.align(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getBottomCenter());
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        Alignment contentAlignment$iv4 = Alignment.Companion.getTopStart();
        MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv4, false);
        int $changed$iv$iv5 = (0 << 3) & 112;
        ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
        CompositionLocalMap localMap$iv$iv5 = $composer.getCurrentCompositionLocalMap();
        Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer, modifier$iv5);
        Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
        int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            factory$iv$iv$iv5 = factory$iv$iv$iv10;
            $composer.createNode(factory$iv$iv$iv5);
        } else {
            factory$iv$iv$iv5 = factory$iv$iv$iv10;
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer);
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
        int i9 = ($changed$iv$iv$iv5 >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
        int i10 = ((0 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -1244605078, "C134@5445L153:FullScreenHeaderPreview.kt#dsyj5e");
        BottomContainer($pageViewModel, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer, 48, 0);
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
    public static final Unit FullScreenHeaderPreview$lambda$3$2$0$0(PageViewModel $pageViewModel) {
        $pageViewModel.toggleHeaderFullScreenPreview$product_details_page_debug(false);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x02e7, code lost:
        if (r9 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void TopIndicator(final PageViewModel pageViewModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer2 = $composer.startRestartGroup(-1929222916);
        ComposerKt.sourceInformation($composer2, "C(TopIndicator)N(pageViewModel,modifier)149@5814L16,150@5835L735:FullScreenHeaderPreview.kt#dsyj5e");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(pageViewModel) ? 4 : 2;
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
                ComposerKt.traceEventStart(-1929222916, $dirty, -1, "kntr.app.mall.product.details.page.ui.screen.TopIndicator (FullScreenHeaderPreview.kt:148)");
            }
            State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer2, 0, 1);
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            Modifier modifier4 = modifier3;
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
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
            int i4 = ((0 >> 6) & 112) | 6;
            BoxScope $this$TopIndicator_u24lambda_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1926800742, "C155@5929L584,169@6522L42:FullScreenHeaderPreview.kt#dsyj5e");
            Modifier modifier$iv2 = $this$TopIndicator_u24lambda_u241.align(Modifier.Companion, Alignment.Companion.getCenterStart());
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1232480255, "C157@6042L24,158@6101L6,164@6382L106,156@5997L506:FullScreenHeaderPreview.kt#dsyj5e");
            Painter arrow_back_left_line_500 = BiliIconfont.INSTANCE.getArrow_back_left_line_500($composer2, 6);
            long j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU();
            Modifier modifier5 = SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, TopIndicator$lambda$0(scaleModel$delegate).getScale()), 0.0f, 0.0f, 0.0f, 14, (Object) null), ProvideUiScaleKt.dpScaled(24, TopIndicator$lambda$0(scaleModel$delegate).getScale()));
            ComposerKt.sourceInformationMarkerStart($composer2, 1761369810, "CC(remember):FullScreenHeaderPreview.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(pageViewModel);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.screen.FullScreenHeaderPreviewKt$$ExternalSyntheticLambda9
                public final Object invoke() {
                    Unit TopIndicator$lambda$1$0$0$0;
                    TopIndicator$lambda$1$0$0$0 = FullScreenHeaderPreviewKt.TopIndicator$lambda$1$0$0$0(PageViewModel.this);
                    return TopIndicator$lambda$1$0$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            IconKt.Icon-ww6aTOc(arrow_back_left_line_500, "返回", ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), j, $composer2, Painter.$stable | 48, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            PreviewTabContainer(pageViewModel.getWrapper$product_details_page_debug(), null, $composer2, 0, 2);
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
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.screen.FullScreenHeaderPreviewKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit TopIndicator$lambda$2;
                    TopIndicator$lambda$2 = FullScreenHeaderPreviewKt.TopIndicator$lambda$2(PageViewModel.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TopIndicator$lambda$2;
                }
            });
        }
    }

    private static final UiScaleModel TopIndicator$lambda$0(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopIndicator$lambda$1$0$0$0(PageViewModel $pageViewModel) {
        $pageViewModel.toggleHeaderFullScreenPreview$product_details_page_debug(false);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x0347, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L89;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void PreviewTabContainer(final PageViewModelWrapper pageViewModelWrapper, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        long j;
        Function0 factory$iv$iv$iv;
        boolean isItemSelected;
        Object value$iv;
        Function0 factory$iv$iv$iv2;
        TextStyle textStyle;
        long j2;
        long selectedColor;
        ProductDetailsResponse.ProductDetailsData data;
        GlobalSkinConfigDTO globalSkin;
        Composer $composer3 = $composer.startRestartGroup(-586670159);
        ComposerKt.sourceInformation($composer3, "C(PreviewTabContainer)N(pageViewModelWrapper,modifier)179@6814L16,180@6884L16,191@7211L16,205@7557L2349:FullScreenHeaderPreview.kt#dsyj5e");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(pageViewModelWrapper) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ($composer3.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            final Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-586670159, $dirty, -1, "kntr.app.mall.product.details.page.ui.screen.PreviewTabContainer (FullScreenHeaderPreview.kt:177)");
            }
            PageViewModel pageViewModel = pageViewModelWrapper.getViewModel();
            State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer3, 0, 1);
            State pagerState$delegate = SnapshotStateKt.collectAsState(pageViewModel.getBannerPagerState(), (CoroutineContext) null, $composer3, 0, 1);
            if (PreviewTabContainer$lambda$1(pagerState$delegate) == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.screen.FullScreenHeaderPreviewKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2) {
                            Unit PreviewTabContainer$lambda$2;
                            PreviewTabContainer$lambda$2 = FullScreenHeaderPreviewKt.PreviewTabContainer$lambda$2(PageViewModelWrapper.this, modifier3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return PreviewTabContainer$lambda$2;
                        }
                    });
                    return;
                }
                return;
            }
            PagerState PreviewTabContainer$lambda$1 = PreviewTabContainer$lambda$1(pagerState$delegate);
            int currentPage = PreviewTabContainer$lambda$1 != null ? PreviewTabContainer$lambda$1.getCurrentPage() : 0;
            List tabItems = pageViewModel.getFullscreenTopTabItems$product_details_page_debug();
            if (tabItems.size() <= 1) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup2 = $composer3.endRestartGroup();
                if (endRestartGroup2 != null) {
                    endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.screen.FullScreenHeaderPreviewKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj, Object obj2) {
                            Unit PreviewTabContainer$lambda$3;
                            PreviewTabContainer$lambda$3 = FullScreenHeaderPreviewKt.PreviewTabContainer$lambda$3(PageViewModelWrapper.this, modifier3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return PreviewTabContainer$lambda$3;
                        }
                    });
                    return;
                }
                return;
            }
            ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) SnapshotStateKt.collectAsState(pageViewModel.getProductDetailsResponse(), (CoroutineContext) null, $composer3, 0, 1).getValue();
            String globalSkinFontColor = (productDetailsResponse == null || (data = productDetailsResponse.getData()) == null || (globalSkin = data.getGlobalSkin()) == null) ? null : globalSkin.getFontColor();
            String str = globalSkinFontColor;
            if (str == null || str.length() == 0) {
                $composer3.startReplaceGroup(-1267879010);
                ComposerKt.sourceInformation($composer3, "202@7524L6");
                j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(-1267940359);
                $composer3.endReplaceGroup();
                j = ComposeColorParserKt.parseColor(globalSkinFontColor);
            }
            long selectedColor2 = j;
            Modifier modifier$iv = SizeKt.height-3ABfNKs(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(64, PreviewTabContainer$lambda$0(scaleModel$delegate).getScale()), 0.0f, 2, (Object) null), ProvideUiScaleKt.dpScaled(44, PreviewTabContainer$lambda$0(scaleModel$delegate).getScale()));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Composer $composer$iv = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer$iv, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            Modifier modifier4 = modifier3;
            String str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            Composer $composer$iv$iv = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv, 0));
            CompositionLocalMap localMap$iv$iv = $composer$iv$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer$iv$iv, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            String str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv$iv.startReusableNode();
            if ($composer$iv$iv.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer$iv$iv.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer$iv$iv.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer$iv$iv);
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            boolean z = false;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((384 >> 6) & 112) | 6;
            RowScope $this$PreviewTabContainer_u24lambda_u244 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, 670664217, "C:FullScreenHeaderPreview.kt#dsyj5e");
            $composer$iv$iv.startReplaceGroup(575823937);
            ComposerKt.sourceInformation($composer$iv$iv, "*227@8460L39,225@8342L21,220@8171L1719");
            List $this$forEachIndexed$iv = tabItems;
            boolean z2 = false;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                final TopTabItem tabItm = (TopTabItem) item$iv;
                boolean z3 = z2;
                int $i$f$forEachIndexed = tabItm.getItemKey();
                Integer bannerFirstItemCount = pageViewModel.getBannerFirstItemCount();
                int $changed$iv$iv$iv2 = $changed$iv$iv$iv;
                if ($i$f$forEachIndexed == (bannerFirstItemCount != null ? bannerFirstItemCount.intValue() : 0) - 1) {
                    Integer bannerFirstItemCount2 = pageViewModel.getBannerFirstItemCount();
                    isItemSelected = currentPage < (bannerFirstItemCount2 != null ? bannerFirstItemCount2.intValue() : 0);
                } else {
                    isItemSelected = currentPage == tabItm.getItemKey();
                }
                Modifier weight$default = RowScope.-CC.weight$default($this$PreviewTabContainer_u24lambda_u244, Modifier.Companion, 1.0f, false, 2, (Object) null);
                PageViewModel pageViewModel2 = pageViewModel;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -1287655648, "CC(remember):FullScreenHeaderPreview.kt#9igjgp");
                Object it$iv = $composer$iv$iv.rememberedValue();
                Modifier materialized$iv$iv2 = materialized$iv$iv;
                if (it$iv == Composer.Companion.getEmpty()) {
                    value$iv = InteractionSourceKt.MutableInteractionSource();
                    $composer$iv$iv.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -1287659442, "CC(remember):FullScreenHeaderPreview.kt#9igjgp");
                boolean invalid$iv = $composer$iv$iv.changedInstance(tabItm);
                Object it$iv2 = $composer$iv$iv.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.screen.FullScreenHeaderPreviewKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit PreviewTabContainer$lambda$4$0$1$0;
                        PreviewTabContainer$lambda$4$0$1$0 = FullScreenHeaderPreviewKt.PreviewTabContainer$lambda$4$0$1$0(TopTabItem.this);
                        return PreviewTabContainer$lambda$4$0$1$0;
                    }
                };
                $composer$iv$iv.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                Modifier modifier$iv2 = ClickableKt.clickable-O2vRcR0$default(weight$default, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv2, 28, (Object) null);
                Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                int currentPage2 = currentPage;
                List tabItems2 = tabItems;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -1159599143, str2);
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv, 0));
                String str4 = str2;
                CompositionLocalMap localMap$iv$iv2 = $composer$iv$iv.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer$iv$iv, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv2 << 6) & 896) | 6;
                Composer $composer$iv2 = $composer$iv;
                boolean z4 = z;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -553112988, str3);
                if (!($composer$iv$iv.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv$iv.startReusableNode();
                if ($composer$iv$iv.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer$iv$iv.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer$iv$iv.useNode();
                }
                String str5 = str3;
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv$iv);
                Composer $composer$iv$iv2 = $composer$iv$iv;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                int i6 = ((48 >> 6) & 112) | 6;
                BoxScope $this$PreviewTabContainer_u24lambda_u244_u240_u242 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -643579339, "C231@8613L584:FullScreenHeaderPreview.kt#dsyj5e");
                String titleText = tabItm.getTitleText();
                if (isItemSelected) {
                    $composer$iv$iv.startReplaceGroup(-643493222);
                    ComposerKt.sourceInformation($composer$iv$iv, "235@8776L9");
                    TextStyle scaled = ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer$iv$iv, BiliTheme.$stable).getT16b(), PreviewTabContainer$lambda$0(scaleModel$delegate).getScale());
                    $composer$iv$iv.endReplaceGroup();
                    textStyle = scaled;
                } else {
                    $composer$iv$iv.startReplaceGroup(-643383141);
                    ComposerKt.sourceInformation($composer$iv$iv, "237@8887L9");
                    TextStyle scaled2 = ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer$iv$iv, BiliTheme.$stable).getT15(), PreviewTabContainer$lambda$0(scaleModel$delegate).getScale());
                    $composer$iv$iv.endReplaceGroup();
                    textStyle = scaled2;
                }
                if (isItemSelected) {
                    $composer$iv$iv.startReplaceGroup(-643207650);
                    $composer$iv$iv.endReplaceGroup();
                    j2 = selectedColor2;
                } else {
                    $composer$iv$iv.startReplaceGroup(-643132971);
                    ComposerKt.sourceInformation($composer$iv$iv, "243@9140L6");
                    long j3 = BiliTheme.INSTANCE.getColors($composer$iv$iv, BiliTheme.$stable).getText2-0d7_KjU();
                    $composer$iv$iv.endReplaceGroup();
                    j2 = j3;
                }
                TextKt.Text-Nvy7gAk(titleText, (Modifier) null, j2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, textStyle, $composer$iv$iv, 0, 0, 131066);
                if (isItemSelected) {
                    $composer$iv$iv.startReplaceGroup(-642982559);
                    ComposerKt.sourceInformation($composer$iv$iv, "247@9256L602");
                    selectedColor = selectedColor2;
                    BoxKt.Box(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(OffsetKt.offset-VpY3zN4$default($this$PreviewTabContainer_u24lambda_u244_u240_u242.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), 0.0f, ProvideUiScaleKt.dpScaled(3, PreviewTabContainer$lambda$0(scaleModel$delegate).getScale()), 1, (Object) null), ProvideUiScaleKt.dpScaled(20, PreviewTabContainer$lambda$0(scaleModel$delegate).getScale())), ProvideUiScaleKt.dpScaled(3, PreviewTabContainer$lambda$0(scaleModel$delegate).getScale())), selectedColor, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(1.5d, PreviewTabContainer$lambda$0(scaleModel$delegate).getScale()))), $composer$iv$iv, 0);
                } else {
                    selectedColor = selectedColor2;
                    $composer$iv$iv.startReplaceGroup(-652163581);
                }
                $composer$iv$iv.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                $composer$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                selectedColor2 = selectedColor;
                $composer$iv = $composer$iv2;
                pageViewModel = pageViewModel2;
                currentPage = currentPage2;
                tabItems = tabItems2;
                index$iv = index$iv2;
                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                z2 = z3;
                $changed$iv$iv$iv = $changed$iv$iv$iv2;
                str2 = str4;
                materialized$iv$iv = materialized$iv$iv2;
                str3 = str5;
                z = z4;
                $composer$iv$iv = $composer$iv$iv2;
            }
            $composer$iv$iv.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            $composer$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup3 = $composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.screen.FullScreenHeaderPreviewKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit PreviewTabContainer$lambda$5;
                    PreviewTabContainer$lambda$5 = FullScreenHeaderPreviewKt.PreviewTabContainer$lambda$5(PageViewModelWrapper.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PreviewTabContainer$lambda$5;
                }
            });
        }
    }

    private static final UiScaleModel PreviewTabContainer$lambda$0(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    private static final PagerState PreviewTabContainer$lambda$1(State<? extends PagerState> state) {
        Object thisObj$iv = state.getValue();
        return (PagerState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewTabContainer$lambda$4$0$1$0(TopTabItem $tabItm) {
        $tabItm.getOnSelect().invoke();
        return Unit.INSTANCE;
    }

    private static final void BottomIndicator(final PageViewModel pageViewModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv$iv$iv;
        String str;
        Composer $composer$iv$iv;
        Composer $composer$iv;
        State selectedIndex$delegate;
        String str2;
        final PageViewModel pageViewModel2;
        String str3;
        Composer $composer3;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        Composer $composer4 = $composer.startRestartGroup(735960558);
        ComposerKt.sourceInformation($composer4, "C(BottomIndicator)N(pageViewModel,modifier)270@10084L16,271@10163L16,272@10233L16,274@10300L3776:FullScreenHeaderPreview.kt#dsyj5e");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changedInstance(pageViewModel) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (!$composer4.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(735960558, $dirty, -1, "kntr.app.mall.product.details.page.ui.screen.BottomIndicator (FullScreenHeaderPreview.kt:269)");
            }
            State pagerState$delegate = SnapshotStateKt.collectAsState(pageViewModel.getBannerPreviewPagerState(), (CoroutineContext) null, $composer4, 0, 1);
            State selectedIndex$delegate2 = SnapshotStateKt.collectAsState(pageViewModel.getHeaderSkuSelectedIndex(), (CoroutineContext) null, $composer4, 0, 1);
            State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer4, 0, 1);
            PagerState BottomIndicator$lambda$0 = BottomIndicator$lambda$0(pagerState$delegate);
            Integer currentPage = BottomIndicator$lambda$0 != null ? Integer.valueOf(BottomIndicator$lambda$0.getCurrentPage()) : null;
            Modifier modifier$iv = SizeKt.height-3ABfNKs(modifier3, ProvideUiScaleKt.dpScaled(24, BottomIndicator$lambda$2(scaleModel$delegate).getScale()));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            Modifier modifier4 = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 398874892, "C:FullScreenHeaderPreview.kt#dsyj5e");
            int currentPageIndex = (currentPage != null ? currentPage.intValue() : 0) + 1;
            Integer bannerFirstItemCount = pageViewModel.getBannerFirstItemCount();
            int firstItemCount = bannerFirstItemCount != null ? bannerFirstItemCount.intValue() : 0;
            boolean isActive = currentPageIndex <= firstItemCount;
            if (isActive) {
                $composer4.startReplaceGroup(398976912);
                ComposerKt.sourceInformation($composer4, "285@10741L565");
                String text = currentPageIndex + "/" + firstItemCount;
                $composer$iv$iv = $composer4;
                Modifier modifier$iv2 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.width-3ABfNKs(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(44, BottomIndicator$lambda$2(scaleModel$delegate).getScale())), RoundedCornerShapeKt.RoundedCornerShape(50)), TopContainerKt.m587withOverlayAlphaDxMtmZc(Color.Companion.getBlack-0d7_KjU(), 0.3f), (Shape) null, 2, (Object) null);
                Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                $composer$iv$iv$iv = $composer4;
                ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                $composer$iv = $composer4;
                $composer2 = $composer4;
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                selectedIndex$delegate = selectedIndex$delegate2;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv5 = factory$iv$iv$iv7;
                    $composer4.createNode(factory$iv$iv$iv5);
                } else {
                    factory$iv$iv$iv5 = factory$iv$iv$iv7;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i6 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -313126133, "C297@11235L9,294@11117L175:FullScreenHeaderPreview.kt#dsyj5e");
                TextKt.Text-Nvy7gAk(text, (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT12(), BottomIndicator$lambda$2(scaleModel$delegate).getScale()), $composer4, 384, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
            } else {
                $composer$iv$iv$iv = $composer4;
                $composer2 = $composer4;
                str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                $composer$iv$iv = $composer4;
                $composer$iv = $composer4;
                selectedIndex$delegate = selectedIndex$delegate2;
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $composer4.startReplaceGroup(388373176);
            }
            $composer4.endReplaceGroup();
            if (Intrinsics.areEqual(currentPage, pageViewModel.getBannerSkuIndex())) {
                $composer4.startReplaceGroup(399680829);
                ComposerKt.sourceInformation($composer4, "302@11388L739");
                Modifier modifier$iv3 = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.fillMaxHeight$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, BottomIndicator$lambda$2(scaleModel$delegate).getScale()), 0.0f, 2, (Object) null), 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape(50)), TopContainerKt.m587withOverlayAlphaDxMtmZc(Color.Companion.getBlack-0d7_KjU(), 0.3f), (Shape) null, 2, (Object) null), ProvideUiScaleKt.dpScaled(13, BottomIndicator$lambda$2(scaleModel$delegate).getScale()), 0.0f, 2, (Object) null);
                Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv3 = (48 << 3) & 112;
                str3 = str;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, str3);
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                String str4 = str2;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, str4);
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv4 = factory$iv$iv$iv8;
                    $composer4.createNode(factory$iv$iv$iv4);
                } else {
                    factory$iv$iv$iv4 = factory$iv$iv$iv8;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
                str2 = str4;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                int i8 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -11555728, "C316@12056L9,312@11856L257:FullScreenHeaderPreview.kt#dsyj5e");
                pageViewModel2 = pageViewModel;
                String currentSkuName$product_details_page_debug = pageViewModel2.getCurrentSkuName$product_details_page_debug(BottomIndicator$lambda$1(selectedIndex$delegate));
                if (currentSkuName$product_details_page_debug == null) {
                    currentSkuName$product_details_page_debug = "";
                }
                TextKt.Text-Nvy7gAk(currentSkuName$product_details_page_debug, (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT12(), BottomIndicator$lambda$2(scaleModel$delegate).getScale()), $composer4, 384, 24576, 114682);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
            } else {
                pageViewModel2 = pageViewModel;
                str3 = str;
                $composer4.startReplaceGroup(388373176);
            }
            $composer4.endReplaceGroup();
            if (Intrinsics.areEqual(currentPage, pageViewModel.getBannerCommentOrUpSayIndex()) && pageViewModel.getUseUpSay()) {
                $composer4.startReplaceGroup(400566251);
                ComposerKt.sourceInformation($composer4, "329@12587L495,322@12247L1813");
                Modifier modifier5 = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape(50)), TopContainerKt.m587withOverlayAlphaDxMtmZc(Color.Companion.getBlack-0d7_KjU(), 0.3f), (Shape) null, 2, (Object) null), ProvideUiScaleKt.dpScaled(12, BottomIndicator$lambda$2(scaleModel$delegate).getScale()), 0.0f, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer4, -956899847, "CC(remember):FullScreenHeaderPreview.kt#9igjgp");
                Composer $composer5 = $composer2;
                boolean invalid$iv = $composer5.changedInstance(pageViewModel2);
                Object it$iv = $composer4.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.screen.FullScreenHeaderPreviewKt$$ExternalSyntheticLambda11
                        public final Object invoke() {
                            Unit BottomIndicator$lambda$3$2$0;
                            BottomIndicator$lambda$3$2$0 = FullScreenHeaderPreviewKt.BottomIndicator$lambda$3$2$0(PageViewModel.this);
                            return BottomIndicator$lambda$3$2$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer4);
                Modifier modifier$iv4 = ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
                Alignment contentAlignment$iv3 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                int $changed$iv$iv4 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, str3);
                int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv4 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer4, modifier$iv4);
                Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                String str5 = str2;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, str5);
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv9;
                    $composer4.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv9;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                int i9 = ($changed$iv$iv$iv4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                int i10 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -419560123, "C342@13169L877:FullScreenHeaderPreview.kt#dsyj5e");
                Modifier modifier$iv5 = SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer4, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                int $changed$iv$iv5 = (390 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, str3);
                int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv5 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer4, modifier$iv5);
                Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                $composer2 = $composer5;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, str5);
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv10;
                    $composer4.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv10;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                int i11 = ($changed$iv$iv$iv5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope2 = RowScopeInstance.INSTANCE;
                int i12 = ((390 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, 1234826597, "C348@13432L9,346@13339L232,353@13645L28,352@13592L436:FullScreenHeaderPreview.kt#dsyj5e");
                TextKt.Text-Nvy7gAk("看完整视频", (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT12(), BottomIndicator$lambda$2(scaleModel$delegate).getScale()), $composer4, 390, 24576, 114682);
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_500($composer4, 6), (String) null, PaddingKt.padding-qDBjuR0$default(SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, BottomIndicator$lambda$2(scaleModel$delegate).getScale())), ProvideUiScaleKt.dpScaled(2, BottomIndicator$lambda$2(scaleModel$delegate).getScale()), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.Companion.getWhite-0d7_KjU(), $composer4, Painter.$stable | 3120, 0);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endReplaceGroup();
                $composer3 = $composer4;
            } else {
                $composer3 = $composer4;
                $composer3.startReplaceGroup(388373176);
                $composer3.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.screen.FullScreenHeaderPreviewKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit BottomIndicator$lambda$4;
                    BottomIndicator$lambda$4 = FullScreenHeaderPreviewKt.BottomIndicator$lambda$4(PageViewModel.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BottomIndicator$lambda$4;
                }
            });
        }
    }

    private static final PagerState BottomIndicator$lambda$0(State<? extends PagerState> state) {
        Object thisObj$iv = state.getValue();
        return (PagerState) thisObj$iv;
    }

    private static final int BottomIndicator$lambda$1(State<Integer> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).intValue();
    }

    private static final UiScaleModel BottomIndicator$lambda$2(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomIndicator$lambda$3$2$0(PageViewModel $pageViewModel) {
        BasicInfoFloor.NewUpSayModel upSayModel;
        ProductDetailsResponse.ProductDetailsData data;
        BasicInfoFloor basicInfoFloorVO;
        ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) $pageViewModel.getProductDetailsResponse().getValue();
        if (productDetailsResponse == null || (data = productDetailsResponse.getData()) == null || (basicInfoFloorVO = data.getBasicInfoFloorVO()) == null) {
            upSayModel = null;
        } else {
            upSayModel = basicInfoFloorVO.getNewUpSayVO();
        }
        String jumpUrl = upSayModel != null ? upSayModel.getJumpUrl() : null;
        $pageViewModel.handleJumpUrl$product_details_page_debug(jumpUrl);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0137, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0171, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void BottomContainer(final PageViewModel pageViewModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Composer $composer3;
        Composer $composer4 = $composer.startRestartGroup(307933372);
        ComposerKt.sourceInformation($composer4, "C(BottomContainer)N(pageViewModel,modifier)372@14261L16,373@14331L16,381@14591L12,383@14661L17,392@15026L69,395@15124L74,385@14684L575:FullScreenHeaderPreview.kt#dsyj5e");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changedInstance(pageViewModel) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer4.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            final Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(307933372, $dirty2, -1, "kntr.app.mall.product.details.page.ui.screen.BottomContainer (FullScreenHeaderPreview.kt:371)");
            }
            State bottomContainerState$delegate = SnapshotStateKt.collectAsState(pageViewModel.getBottomContainerState$product_details_page_debug(), (CoroutineContext) null, $composer4, 0, 1);
            State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer4, 0, 1);
            BottomContainerState BottomContainer$lambda$0 = BottomContainer$lambda$0(bottomContainerState$delegate);
            if (BottomContainer$lambda$0 != null) {
                ContentModule.FooterModule footerModule = BottomContainer$lambda$0.getData();
                if (footerModule == null) {
                    modifier3 = modifier4;
                    $composer3 = $composer4;
                } else {
                    FooterFloor footerFloor = footerModule.getData();
                    final FooterFloor.PurchaseButton purchaseButton = footerFloor.getPurchaseButton();
                    if (purchaseButton == null) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ScopeUpdateScope endRestartGroup = $composer4.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.screen.FullScreenHeaderPreviewKt$$ExternalSyntheticLambda14
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit BottomContainer$lambda$3;
                                    BottomContainer$lambda$3 = FullScreenHeaderPreviewKt.BottomContainer$lambda$3(PageViewModel.this, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                                    return BottomContainer$lambda$3;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    PaddingValues bottomInsets = WindowInsetsKt.asPaddingValues(WindowInsetsKt.only-bOOhFvg(WindowInsets_androidKt.getSafeGestures(WindowInsets.Companion, $composer4, 6), WindowInsetsSides.Companion.getBottom-JoeWqyM()), $composer4, 0);
                    Modifier modifier5 = PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(modifier4, ProvideUiScaleKt.dpScaled(12, BottomContainer$lambda$1(scaleModel$delegate).getScale()), 0.0f, 2, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(bottomInsets.calculateBottomPadding-D9Ej5fM() + ProvideUiScaleKt.dpScaled(12, BottomContainer$lambda$1(scaleModel$delegate).getScale())), 7, (Object) null);
                    FooterFloor.AddCartButton addCartButton = footerFloor.getAddCartButton();
                    PageViewModelWrapper wrapper$product_details_page_debug = pageViewModel.getWrapper$product_details_page_debug();
                    ComposerKt.sourceInformationMarkerStart($composer4, -428743231, "CC(remember):FullScreenHeaderPreview.kt#9igjgp");
                    boolean invalid$iv = $composer4.changedInstance(pageViewModel) | $composer4.changedInstance(purchaseButton);
                    Object it$iv = $composer4.rememberedValue();
                    if (invalid$iv) {
                    }
                    Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.screen.FullScreenHeaderPreviewKt$$ExternalSyntheticLambda15
                        public final Object invoke() {
                            Unit BottomContainer$lambda$4$0;
                            BottomContainer$lambda$4$0 = FullScreenHeaderPreviewKt.BottomContainer$lambda$4$0(PageViewModel.this, purchaseButton);
                            return BottomContainer$lambda$4$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                    Function0 function0 = (Function0) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerStart($composer4, -428740090, "CC(remember):FullScreenHeaderPreview.kt#9igjgp");
                    boolean invalid$iv2 = $composer4.changedInstance(pageViewModel) | $composer4.changedInstance(purchaseButton);
                    Object it$iv2 = $composer4.rememberedValue();
                    if (invalid$iv2) {
                    }
                    Object value$iv2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.screen.FullScreenHeaderPreviewKt$$ExternalSyntheticLambda16
                        public final Object invoke() {
                            Unit BottomContainer$lambda$5$0;
                            BottomContainer$lambda$5$0 = FullScreenHeaderPreviewKt.BottomContainer$lambda$5$0(PageViewModel.this, purchaseButton);
                            return BottomContainer$lambda$5$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    Modifier modifier6 = modifier4;
                    $composer2 = $composer4;
                    BottomContainerKt.PurchaseButtonComponent(wrapper$product_details_page_debug, modifier5, purchaseButton, addCartButton, function0, (Function0) it$iv2, false, null, false, $composer4, 0, 448);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier6;
                }
            } else {
                modifier3 = modifier4;
                $composer3 = $composer4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup2 = $composer3.endRestartGroup();
            if (endRestartGroup2 != null) {
                final Modifier modifier7 = modifier3;
                endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.screen.FullScreenHeaderPreviewKt$$ExternalSyntheticLambda13
                    public final Object invoke(Object obj, Object obj2) {
                        Unit BottomContainer$lambda$2;
                        BottomContainer$lambda$2 = FullScreenHeaderPreviewKt.BottomContainer$lambda$2(PageViewModel.this, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                        return BottomContainer$lambda$2;
                    }
                });
                return;
            }
            return;
        }
        $composer2 = $composer4;
        $composer2.skipToGroupEnd();
        ScopeUpdateScope endRestartGroup3 = $composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.screen.FullScreenHeaderPreviewKt$$ExternalSyntheticLambda17
                public final Object invoke(Object obj, Object obj2) {
                    Unit BottomContainer$lambda$6;
                    BottomContainer$lambda$6 = FullScreenHeaderPreviewKt.BottomContainer$lambda$6(PageViewModel.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BottomContainer$lambda$6;
                }
            });
        }
    }

    private static final BottomContainerState BottomContainer$lambda$0(State<BottomContainerState> state) {
        Object thisObj$iv = state.getValue();
        return (BottomContainerState) thisObj$iv;
    }

    private static final UiScaleModel BottomContainer$lambda$1(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomContainer$lambda$4$0(PageViewModel $pageViewModel, FooterFloor.PurchaseButton $purchaseButton) {
        $pageViewModel.handleAddButton$product_details_page_debug($purchaseButton);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomContainer$lambda$5$0(PageViewModel $pageViewModel, FooterFloor.PurchaseButton $purchaseButton) {
        $pageViewModel.handlePurchaseButton$product_details_page_debug($purchaseButton);
        return Unit.INSTANCE;
    }
}