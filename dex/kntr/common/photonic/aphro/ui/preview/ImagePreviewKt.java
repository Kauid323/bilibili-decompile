package kntr.common.photonic.aphro.ui.preview;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.PageSize;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.compose.list.OverscrollKt;
import kntr.common.photonic.aphro.ui.preview.state.ImagePreviewItemState;
import kntr.common.photonic.aphro.ui.preview.state.ImagePreviewState;
import kntr.common.trio.pagecontroller.BackHandlerKt;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: ImagePreview.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00010\u00052&\u0010\u0007\u001a\"\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\f2&\u0010\r\u001a\"\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\f2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0001¢\u0006\u0002\u0010\u000e\u001a=\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"ImagePreview", "", "state", "Lkntr/common/photonic/aphro/ui/preview/state/ImagePreviewState;", "onDismissRequest", "Lkotlin/Function1;", "Lkntr/common/photonic/aphro/ui/preview/ExitTransitionState;", "previewHeader", "Landroidx/compose/ui/Modifier;", "Lkotlin/ParameterName;", "name", "modifier", "Landroidx/compose/runtime/Composable;", "previewFooter", "(Lkntr/common/photonic/aphro/ui/preview/state/ImagePreviewState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "PreviewPager", "isAnimating", "", "(Lkntr/common/photonic/aphro/ui/preview/state/ImagePreviewState;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImagePreviewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImagePreview$lambda$4(ImagePreviewState imagePreviewState, Function1 function1, Function3 function3, Function3 function32, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ImagePreview(imagePreviewState, function1, function3, function32, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewPager$lambda$2(ImagePreviewState imagePreviewState, boolean z, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        PreviewPager(imagePreviewState, z, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ImagePreview(final ImagePreviewState state, final Function1<? super ExitTransitionState, Unit> function1, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function32, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(function1, "onDismissRequest");
        Intrinsics.checkNotNullParameter(function3, "previewHeader");
        Intrinsics.checkNotNullParameter(function32, "previewFooter");
        Composer $composer2 = $composer.startRestartGroup(-380802174);
        ComposerKt.sourceInformation($composer2, "C(ImagePreview)N(state,onDismissRequest,previewHeader,previewFooter,modifier)48@2120L24,50@2199L870,79@3087L127,79@3075L139,85@3243L300,85@3220L323,96@3601L4856,96@3549L4908:ImagePreview.kt#n54g3c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function32) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-380802174, $dirty2, -1, "kntr.common.photonic.aphro.ui.preview.ImagePreview (ImagePreview.kt:47)");
            }
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
            ComposerKt.sourceInformationMarkerStart($composer2, -878656728, "CC(remember):ImagePreview.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(scope) | (($dirty2 & 14) == 4);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePreviewKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit ImagePreview$lambda$0$0;
                        ImagePreview$lambda$0$0 = ImagePreviewKt.ImagePreview$lambda$0$0(scope, state);
                        return ImagePreview$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final Function0 resetGestureState = (Function0) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -878629055, "CC(remember):ImagePreview.kt#9igjgp");
            boolean invalid$iv2 = (($dirty2 & 14) == 4) | (($dirty2 & 112) == 32);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePreviewKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit ImagePreview$lambda$1$0;
                        ImagePreview$lambda$1$0 = ImagePreviewKt.ImagePreview$lambda$1$0(ImagePreviewState.this, function1);
                        return ImagePreview$lambda$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            BackHandlerKt.BackHandler(false, (Function0) it$iv2, $composer2, 0, 1);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -878623890, "CC(remember):ImagePreview.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changedInstance(scope) | (($dirty2 & 14) == 4);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePreviewKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        DisposableEffectResult ImagePreview$lambda$2$0;
                        ImagePreview$lambda$2$0 = ImagePreviewKt.ImagePreview$lambda$2$0(scope, state, (DisposableEffectScope) obj);
                        return ImagePreview$lambda$2$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.DisposableEffect(unit, (Function1) it$iv3, $composer2, 6);
            final Modifier modifier4 = modifier3;
            BiliThemeKt.BiliTheme(ThemeStrategy.ForceNight, false, ComposableLambdaKt.rememberComposableLambda(213659962, true, new Function2() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePreviewKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit ImagePreview$lambda$3;
                    ImagePreview$lambda$3 = ImagePreviewKt.ImagePreview$lambda$3(modifier4, state, function1, resetGestureState, scope, function3, function32, (Composer) obj, ((Integer) obj2).intValue());
                    return ImagePreview$lambda$3;
                }
            }, $composer2, 54), $composer2, 390, 2);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePreviewKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit ImagePreview$lambda$4;
                    ImagePreview$lambda$4 = ImagePreviewKt.ImagePreview$lambda$4(ImagePreviewState.this, function1, function3, function32, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ImagePreview$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImagePreview$lambda$0$0(CoroutineScope $scope, ImagePreviewState $state) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ImagePreviewKt$ImagePreview$resetGestureState$1$1$1($state, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImagePreview$lambda$1$0(ImagePreviewState $state, Function1 $onDismissRequest) {
        if (!$state.isAnimating$ui_debug() && !$state.isExiting$ui_debug()) {
            $onDismissRequest.invoke($state.getExitTransitionState$ui_debug());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ImagePreview$lambda$2$0(final CoroutineScope $scope, final ImagePreviewState $state, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePreviewKt$ImagePreview$lambda$2$0$$inlined$onDispose$1
            public void dispose() {
                BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ImagePreviewKt$ImagePreview$2$1$1$1($state, null), 3, (Object) null);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset ImagePreview$lambda$3$1$0$0(ImagePreviewState $state, Density $this$offset) {
        Intrinsics.checkNotNullParameter($this$offset, "$this$offset");
        int x$iv = (int) ((Number) $state.getAnimation().getGestureOffsetX().getValue()).floatValue();
        int y$iv = (int) ((Number) $state.getAnimation().getGestureOffsetY().getValue()).floatValue();
        return IntOffset.box-impl(IntOffset.constructor-impl((x$iv << 32) | (y$iv & 4294967295L)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x01c0, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit ImagePreview$lambda$3(Modifier $modifier, final ImagePreviewState $state, Function1 $onDismissRequest, Function0 $resetGestureState, CoroutineScope $scope, Function3 $previewHeader, Function3 $previewFooter, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C101@3741L6,102@3793L3519,97@3611L4840:ImagePreview.kt#n54g3c");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(213659962, $changed, -1, "kntr.common.photonic.aphro.ui.preview.ImagePreview.<anonymous> (ImagePreview.kt:97)");
            }
            Modifier modifier = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default($modifier, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg2-0d7_KjU(), (Shape) null, 2, (Object) null);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -831197063, "CC(remember):ImagePreview.kt#9igjgp");
            boolean invalid$iv = $composer.changed($state) | $composer.changed($onDismissRequest) | $composer.changed($resetGestureState) | $composer.changedInstance($scope);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (PointerInputEventHandler) new ImagePreviewKt$ImagePreview$3$1$1($state, $onDismissRequest, $resetGestureState, $scope);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv = SuspendingPointerInputFilterKt.pointerInput(modifier, unit, (PointerInputEventHandler) it$iv);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
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
            int i2 = ((0 >> 6) & 112) | 6;
            BoxScope $this$ImagePreview_u24lambda_u243_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 1408685280, "C167@7479L414,163@7338L976,185@8327L49,186@8389L52:ImagePreview.kt#n54g3c");
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -1617122702, "CC(remember):ImagePreview.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed($state);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function1() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePreviewKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    IntOffset ImagePreview$lambda$3$1$0$0;
                    ImagePreview$lambda$3$1$0$0 = ImagePreviewKt.ImagePreview$lambda$3$1$0$0(ImagePreviewState.this, (Density) obj);
                    return ImagePreview$lambda$3$1$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            PreviewPager($state, ((Boolean) $state.getAnimation().isAnimating().getValue()).booleanValue(), $onDismissRequest, GraphicsLayerModifierKt.graphicsLayer-_6ThJ44$default(OffsetKt.offset(fillMaxSize$default, (Function1) it$iv2), ((Number) $state.getAnimation().getGestureScale().getValue()).floatValue(), ((Number) $state.getAnimation().getGestureScale().getValue()).floatValue(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, TransformOrigin.Companion.getCenter-SzJe1aQ(), (Shape) null, false, (RenderEffect) null, 0L, 0L, 0, 0, (ColorFilter) null, 523260, (Object) null), $composer, 0, 0);
            $previewHeader.invoke($this$ImagePreview_u24lambda_u243_u241.align(Modifier.Companion, Alignment.Companion.getTopStart()), $composer, 0);
            $previewFooter.invoke($this$ImagePreview_u24lambda_u243_u241.align(Modifier.Companion, Alignment.Companion.getBottomStart()), $composer, 0);
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

    private static final void PreviewPager(final ImagePreviewState state, final boolean isAnimating, final Function1<? super ExitTransitionState, Unit> function1, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Composer $composer2 = $composer.startRestartGroup(-515635848);
        ComposerKt.sourceInformation($composer2, "C(PreviewPager)N(state,isAnimating,onDismissRequest,modifier)198@8692L163,198@8652L203,209@9012L281,205@8861L432:ImagePreview.kt#n54g3c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(isAnimating) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
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
                ComposerKt.traceEventStart(-515635848, $dirty2, -1, "kntr.common.photonic.aphro.ui.preview.PreviewPager (ImagePreview.kt:197)");
            }
            Integer valueOf = Integer.valueOf(state.getInitialAssetIndex());
            ComposerKt.sourceInformationMarkerStart($composer2, -1604803973, "CC(remember):ImagePreview.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 14) == 4;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new ImagePreviewKt$PreviewPager$1$1(state, null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv, $composer2, 0);
            PagerKt.HorizontalPager--8jOkeI(state.getPagerState(), OverscrollKt.overScrollHorizontal$default(modifier4, false, null, 0.0f, 0.0f, 0.0f, null, 63, null), (PaddingValues) null, (PageSize) null, 0, 0.0f, (Alignment.Vertical) null, (TargetedFlingBehavior) null, !isAnimating, false, (Function1) null, (NestedScrollConnection) null, (SnapPosition) null, (OverscrollEffect) null, ComposableLambdaKt.rememberComposableLambda(-1023014151, true, new Function4() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePreviewKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit PreviewPager$lambda$1;
                    PreviewPager$lambda$1 = ImagePreviewKt.PreviewPager$lambda$1(ImagePreviewState.this, function1, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    return PreviewPager$lambda$1;
                }
            }, $composer2, 54), $composer2, 0, 24576, 16124);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePreviewKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit PreviewPager$lambda$2;
                    PreviewPager$lambda$2 = ImagePreviewKt.PreviewPager$lambda$2(ImagePreviewState.this, isAnimating, function1, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PreviewPager$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewPager$lambda$1(ImagePreviewState $state, Function1 $onDismissRequest, PagerScope $this$HorizontalPager, int it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$HorizontalPager, "$this$HorizontalPager");
        ComposerKt.sourceInformation($composer, "CN(it):ImagePreview.kt#n54g3c");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1023014151, $changed, -1, "kntr.common.photonic.aphro.ui.preview.PreviewPager.<anonymous> (ImagePreview.kt:210)");
        }
        ImagePreviewItemState item = (ImagePreviewItemState) CollectionsKt.getOrNull($state.getDataSource(), it);
        if (item != null) {
            $composer.startReplaceGroup(473443460);
            ComposerKt.sourceInformation($composer, "212@9104L173");
            ImagePageItemKt.ImagePageItem(item, $state, it, $onDismissRequest, null, $composer, ($changed << 3) & 896, 16);
        } else {
            $composer.startReplaceGroup(464419081);
        }
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}