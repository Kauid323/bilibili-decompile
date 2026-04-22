package kntr.common.photonic.aphro.ui.preview;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
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
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.util.MathHelpersKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageOptions;
import kntr.base.imageloader.BiliImagePainterKt;
import kntr.base.imageloader.ImageSource;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.common.photonic.AssetEntry;
import kntr.common.photonic.aphro.ui.preview.model.PreviewableAsset;
import kntr.common.photonic.aphro.ui.preview.state.ImagePreviewState;
import kntr.common.photonic.shower.AssetShower;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: ImagePreviewLauncher.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a&\u0010\u0007\u001a\u00020\b*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\rH\u0000\u001a&\u0010\u000e\u001a\u00020\b*\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0000¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\f\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u008a\u008e\u0002²\u0006\f\u0010\u0017\u001a\u0004\u0018\u00010\nX\u008a\u008e\u0002²\u0006\f\u0010\u0018\u001a\u0004\u0018\u00010\nX\u008a\u008e\u0002²\u0006\n\u0010\u0019\u001a\u00020\u001aX\u008a\u0084\u0002"}, d2 = {"ImagePreviewTransition", "", "state", "Lkntr/common/photonic/aphro/ui/preview/TransitionState;", "previewState", "Lkntr/common/photonic/aphro/ui/preview/state/ImagePreviewState;", "(Lkntr/common/photonic/aphro/ui/preview/TransitionState;Lkntr/common/photonic/aphro/ui/preview/state/ImagePreviewState;Landroidx/compose/runtime/Composer;I)V", "exitAnimation", "Landroidx/compose/ui/Modifier;", "sourceRect", "Landroidx/compose/ui/unit/IntRect;", "targetRect", "animationProgress", "", "animation", "ui_debug", "parentSize", "Landroidx/compose/ui/unit/IntSize;", "pictureSize", "pictureOffset", "Landroidx/compose/ui/unit/IntOffset;", "boxCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "sourcePictureFrame", "exitSourcePictureFrame", "animationPhase", "Lkntr/common/photonic/aphro/ui/preview/AnimationPhase;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImagePreviewLauncherKt {

    /* compiled from: ImagePreviewLauncher.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnimationPhase.values().length];
            try {
                iArr[AnimationPhase.Init.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[AnimationPhase.Entering.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[AnimationPhase.Exiting.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[AnimationPhase.Exited.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImagePreviewTransition$lambda$21(TransitionState transitionState, ImagePreviewState imagePreviewState, int i, Composer composer, int i2) {
        ImagePreviewTransition(transitionState, imagePreviewState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ImagePreviewTransition(final TransitionState state, final ImagePreviewState previewState, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(previewState, "previewState");
        Composer $composer2 = $composer.startRestartGroup(1229260479);
        ComposerKt.sourceInformation($composer2, "C(ImagePreviewTransition)N(state,previewState)104@3654L7,105@3684L41,106@3749L41,107@3816L43,109@3887L53,110@3971L43,111@4049L43,113@4141L16,115@4194L526,115@4163L557,129@4778L5036,129@4726L5088:ImagePreviewLauncher.kt#n54g3c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(previewState) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1229260479, $dirty2, -1, "kntr.common.photonic.aphro.ui.preview.ImagePreviewTransition (ImagePreviewLauncher.kt:103)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 203319016, "CC(remember):ImagePreviewLauncher.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.Companion.getZero-YbymL2g()), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState parentSize$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 203321096, "CC(remember):ImagePreviewLauncher.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.Companion.getZero-YbymL2g()), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final MutableState pictureSize$delegate = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 203323242, "CC(remember):ImagePreviewLauncher.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = SnapshotStateKt.mutableStateOf$default(IntOffset.box-impl(IntOffset.Companion.getZero-nOcc-ac()), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            final MutableState pictureOffset$delegate = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 203325524, "CC(remember):ImagePreviewLauncher.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            final MutableState boxCoordinates$delegate = (MutableState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 203328202, "CC(remember):ImagePreviewLauncher.kt#9igjgp");
            Object it$iv5 = $composer2.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv5 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            }
            final MutableState sourcePictureFrame$delegate = (MutableState) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 203330698, "CC(remember):ImagePreviewLauncher.kt#9igjgp");
            Object it$iv6 = $composer2.rememberedValue();
            if (it$iv6 == Composer.Companion.getEmpty()) {
                Object value$iv6 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv6);
                it$iv6 = value$iv6;
            }
            final MutableState exitSourcePictureFrame$delegate = (MutableState) it$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            State animationPhase$delegate = SnapshotStateKt.collectAsState(state.getAnimationPhase(), (CoroutineContext) null, $composer2, 0, 1);
            AnimationPhase ImagePreviewTransition$lambda$18 = ImagePreviewTransition$lambda$18(animationPhase$delegate);
            ComposerKt.sourceInformationMarkerStart($composer2, 203335821, "CC(remember):ImagePreviewLauncher.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(state) | (($dirty2 & 112) == 32);
            Object value$iv7 = $composer2.rememberedValue();
            if (invalid$iv || value$iv7 == Composer.Companion.getEmpty()) {
                value$iv7 = new ImagePreviewLauncherKt$ImagePreviewTransition$1$1(state, previewState, boxCoordinates$delegate, exitSourcePictureFrame$delegate, null);
                $composer2.updateRememberedValue(value$iv7);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(ImagePreviewTransition$lambda$18, (Function2) value$iv7, $composer2, 0);
            BiliThemeKt.BiliTheme(ThemeStrategy.ForceNight, false, ComposableLambdaKt.rememberComposableLambda(-713686521, true, new Function2() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePreviewLauncherKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit ImagePreviewTransition$lambda$20;
                    ImagePreviewTransition$lambda$20 = ImagePreviewLauncherKt.ImagePreviewTransition$lambda$20(TransitionState.this, boxCoordinates$delegate, parentSize$delegate, sourcePictureFrame$delegate, density, previewState, pictureSize$delegate, pictureOffset$delegate, exitSourcePictureFrame$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return ImagePreviewTransition$lambda$20;
                }
            }, $composer2, 54), $composer2, 390, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePreviewLauncherKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit ImagePreviewTransition$lambda$21;
                    ImagePreviewTransition$lambda$21 = ImagePreviewLauncherKt.ImagePreviewTransition$lambda$21(TransitionState.this, previewState, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return ImagePreviewTransition$lambda$21;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long ImagePreviewTransition$lambda$1(MutableState<IntSize> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((IntSize) $this$getValue$iv.getValue()).unbox-impl();
    }

    private static final void ImagePreviewTransition$lambda$2(MutableState<IntSize> mutableState, long j) {
        Object value$iv = IntSize.box-impl(j);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long ImagePreviewTransition$lambda$4(MutableState<IntSize> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((IntSize) $this$getValue$iv.getValue()).unbox-impl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ImagePreviewTransition$lambda$5(MutableState<IntSize> mutableState, long j) {
        Object value$iv = IntSize.box-impl(j);
        mutableState.setValue(value$iv);
    }

    private static final long ImagePreviewTransition$lambda$7(MutableState<IntOffset> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((IntOffset) $this$getValue$iv.getValue()).unbox-impl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ImagePreviewTransition$lambda$8(MutableState<IntOffset> mutableState, long j) {
        Object value$iv = IntOffset.box-impl(j);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutCoordinates ImagePreviewTransition$lambda$10(MutableState<LayoutCoordinates> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (LayoutCoordinates) $this$getValue$iv.getValue();
    }

    private static final IntRect ImagePreviewTransition$lambda$13(MutableState<IntRect> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (IntRect) $this$getValue$iv.getValue();
    }

    private static final IntRect ImagePreviewTransition$lambda$16(MutableState<IntRect> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (IntRect) $this$getValue$iv.getValue();
    }

    private static final AnimationPhase ImagePreviewTransition$lambda$18(State<? extends AnimationPhase> state) {
        Object thisObj$iv = state.getValue();
        return (AnimationPhase) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x028a, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit ImagePreviewTransition$lambda$20(final TransitionState $state, final MutableState $boxCoordinates$delegate, final MutableState $parentSize$delegate, final MutableState $sourcePictureFrame$delegate, Density $density, ImagePreviewState $previewState, MutableState $pictureSize$delegate, final MutableState $pictureOffset$delegate, MutableState $exitSourcePictureFrame$delegate, Composer $composer, int $changed) {
        Composer $composer$iv$iv$iv;
        Composer $composer2;
        AssetShower shower;
        Modifier materialized$iv$iv;
        PreviewableAsset previewableAsset;
        IntSize intSize;
        PreviewableAsset previewableAsset2;
        ComposerKt.sourceInformation($composer, "C133@4883L663,145@5611L6,130@4788L5020:ImagePreviewLauncher.kt#n54g3c");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-713686521, $changed, -1, "kntr.common.photonic.aphro.ui.preview.ImagePreviewTransition.<anonymous> (ImagePreviewLauncher.kt:130)");
            }
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer, 1342024702, "CC(remember):ImagePreviewLauncher.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($state);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePreviewLauncherKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit ImagePreviewTransition$lambda$20$0$0;
                        ImagePreviewTransition$lambda$20$0$0 = ImagePreviewLauncherKt.ImagePreviewTransition$lambda$20$0$0(TransitionState.this, $boxCoordinates$delegate, $parentSize$delegate, $sourcePictureFrame$delegate, (LayoutCoordinates) obj);
                        return ImagePreviewTransition$lambda$20$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(OnGloballyPositionedModifierKt.onGloballyPositioned(modifier, (Function1) it$iv), 0.0f, 1, (Object) null), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg2-0d7_KjU(), MathHelpersKt.lerp(0.0f, 1.0f, ((Number) $state.getAnimationProgress().getValue()).floatValue()), 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                $composer.createNode(factory$iv$iv$iv);
            } else {
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            Composer $composer3 = $composer;
            ComposerKt.sourceInformationMarkerStart($composer3, -909120742, "C:ImagePreviewLauncher.kt#n54g3c");
            if (!IntSize.equals-impl0(ImagePreviewTransition$lambda$1($parentSize$delegate), IntSize.Companion.getZero-YbymL2g())) {
                $composer3.startReplaceGroup(-909073127);
                ComposerKt.sourceInformation($composer3, "");
                switch (WhenMappings.$EnumSwitchMapping$0[((AnimationPhase) $state.getAnimationPhase().getValue()).ordinal()]) {
                    case 1:
                    case 2:
                        $composer$iv$iv$iv = $composer;
                        $composer3.startReplaceGroup(-909017823);
                        ComposerKt.sourceInformation($composer3, "151@5927L137,155@6135L107,158@6295L222,158@6267L250,162@6556L63,163@6684L617,163@6644L657");
                        ComposerKt.sourceInformationMarkerStart($composer3, 663413302, "CC(remember):ImagePreviewLauncher.kt#9igjgp");
                        Object it$iv2 = $composer3.rememberedValue();
                        if (it$iv2 == Composer.Companion.getEmpty()) {
                            Object value$iv2 = AssetEntry.INSTANCE.getShower().getShowerForAssetType(Reflection.getOrCreateKotlinClass(PreviewableAsset.class));
                            $composer3.updateRememberedValue(value$iv2);
                            it$iv2 = value$iv2;
                        }
                        AssetShower shower2 = (AssetShower) it$iv2;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerStart($composer3, 663419928, "CC(remember):ImagePreviewLauncher.kt#9igjgp");
                        Object it$iv3 = $composer3.rememberedValue();
                        if (it$iv3 == Composer.Companion.getEmpty()) {
                            Object value$iv3 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                            $composer3.updateRememberedValue(value$iv3);
                            it$iv3 = value$iv3;
                        }
                        MutableState sourceState = (MutableState) it$iv3;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        PreviewableAsset asset = $state.getAsset();
                        ComposerKt.sourceInformationMarkerStart($composer3, 663425163, "CC(remember):ImagePreviewLauncher.kt#9igjgp");
                        boolean invalid$iv2 = $composer3.changedInstance(shower2) | $composer3.changedInstance($state);
                        Object value$iv4 = $composer3.rememberedValue();
                        if (invalid$iv2 || value$iv4 == Composer.Companion.getEmpty()) {
                            $composer2 = $composer3;
                            shower = shower2;
                            materialized$iv$iv = materialized$iv$iv2;
                            previewableAsset = asset;
                            value$iv4 = new ImagePreviewLauncherKt$ImagePreviewTransition$2$2$1$1(sourceState, shower2, $state, $parentSize$delegate, null);
                            $composer3.updateRememberedValue(value$iv4);
                        } else {
                            $composer2 = $composer3;
                            shower = shower2;
                            materialized$iv$iv = materialized$iv$iv2;
                            previewableAsset = asset;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer3 = $composer2;
                        EffectsKt.LaunchedEffect(previewableAsset, (Function2) value$iv4, $composer3, 0);
                        Painter painter = BiliImagePainterKt.rememberBiliImagePainter((ImageSource) sourceState.getValue(), new BiliImageOptions(false, 0, false, false, false, null, null, 0.0f, null, null, null, null, null, 8191, null), $composer3, 0);
                        PreviewableAsset asset2 = $state.getAsset();
                        IntSize intSize2 = IntSize.box-impl(ImagePreviewTransition$lambda$1($parentSize$delegate));
                        ComposerKt.sourceInformationMarkerStart($composer3, 663438006, "CC(remember):ImagePreviewLauncher.kt#9igjgp");
                        boolean invalid$iv3 = $composer3.changedInstance($state);
                        Object value$iv5 = $composer3.rememberedValue();
                        if (invalid$iv3 || value$iv5 == Composer.Companion.getEmpty()) {
                            intSize = intSize2;
                            previewableAsset2 = asset2;
                            value$iv5 = new ImagePreviewLauncherKt$ImagePreviewTransition$2$2$2$1($state, $parentSize$delegate, $pictureSize$delegate, $pictureOffset$delegate, null);
                            $composer3.updateRememberedValue(value$iv5);
                        } else {
                            intSize = intSize2;
                            previewableAsset2 = asset2;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        EffectsKt.LaunchedEffect(previewableAsset2, intSize, (Function2) value$iv5, $composer3, 0);
                        if (painter != null) {
                            $composer3.startReplaceGroup(-907589498);
                            ComposerKt.sourceInformation($composer3, "184@7872L17,176@7377L919");
                            Modifier modifier2 = SizeKt.size-VpY3zN4(Modifier.Companion, $density.toDp-u2uoSUM((int) (ImagePreviewTransition$lambda$4($pictureSize$delegate) >> 32)), $density.toDp-u2uoSUM((int) (ImagePreviewTransition$lambda$4($pictureSize$delegate) & 4294967295L)));
                            ComposerKt.sourceInformationMarkerStart($composer3, 663475422, "CC(remember):ImagePreviewLauncher.kt#9igjgp");
                            Object it$iv4 = $composer3.rememberedValue();
                            if (it$iv4 == Composer.Companion.getEmpty()) {
                                Object value$iv6 = new Function1() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePreviewLauncherKt$$ExternalSyntheticLambda3
                                    public final Object invoke(Object obj) {
                                        IntOffset ImagePreviewTransition$lambda$20$1$6$0;
                                        ImagePreviewTransition$lambda$20$1$6$0 = ImagePreviewLauncherKt.ImagePreviewTransition$lambda$20$1$6$0($pictureOffset$delegate, (Density) obj);
                                        return ImagePreviewTransition$lambda$20$1$6$0;
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv6);
                                it$iv4 = value$iv6;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ImageKt.Image(painter, (String) null, animation(OffsetKt.offset(modifier2, (Function1) it$iv4), ImagePreviewTransition$lambda$13($sourcePictureFrame$delegate), IntRectKt.IntRect-VbeCjmY(ImagePreviewTransition$lambda$7($pictureOffset$delegate), ImagePreviewTransition$lambda$4($pictureSize$delegate)), ((Number) $state.getAnimationProgress().getValue()).floatValue()), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer3, Painter.$stable | 48, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
                        } else {
                            $composer3.startReplaceGroup(-914908939);
                        }
                        $composer3.endReplaceGroup();
                        $composer3.endReplaceGroup();
                        Unit unit = Unit.INSTANCE;
                        break;
                    case 3:
                    case 4:
                        $composer3.startReplaceGroup(-906520308);
                        ComposerKt.sourceInformation($composer3, "194@8454L83");
                        Painter painter2 = BiliImagePainterKt.rememberBiliImagePainter((ImageSource) $previewState.getCurrentImageSource().getValue(), new BiliImageOptions(false, 0, false, false, false, null, null, 0.0f, null, null, null, null, null, 8191, null), $composer3, 0);
                        final IntRect sourceRect = ImagePreviewTransition$lambda$16($exitSourcePictureFrame$delegate);
                        if (painter2 == null || sourceRect == null) {
                            $composer$iv$iv$iv = $composer;
                            $composer3.startReplaceGroup(-914908939);
                        } else {
                            $composer3.startReplaceGroup(-906246950);
                            ComposerKt.sourceInformation($composer3, "207@9259L54,198@8700L987");
                            ContentScale crop = ContentScale.Companion.getCrop();
                            $composer$iv$iv$iv = $composer;
                            Modifier modifier3 = SizeKt.size-VpY3zN4(Modifier.Companion, Dp.box-impl($density.toDp-u2uoSUM(sourceRect.getWidth())).unbox-impl(), $density.toDp-u2uoSUM(sourceRect.getHeight()));
                            ComposerKt.sourceInformationMarkerStart($composer3, 663519843, "CC(remember):ImagePreviewLauncher.kt#9igjgp");
                            boolean invalid$iv4 = $composer3.changed(sourceRect);
                            Object it$iv5 = $composer3.rememberedValue();
                            if (!invalid$iv4) {
                                break;
                            }
                            Object value$iv7 = new Function1() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePreviewLauncherKt$$ExternalSyntheticLambda4
                                public final Object invoke(Object obj) {
                                    IntOffset ImagePreviewTransition$lambda$20$1$9$0;
                                    ImagePreviewTransition$lambda$20$1$9$0 = ImagePreviewLauncherKt.ImagePreviewTransition$lambda$20$1$9$0(sourceRect, (Density) obj);
                                    return ImagePreviewTransition$lambda$20$1$9$0;
                                }
                            };
                            $composer3.updateRememberedValue(value$iv7);
                            it$iv5 = value$iv7;
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ImageKt.Image(painter2, (String) null, exitAnimation(OffsetKt.offset(modifier3, (Function1) it$iv5), sourceRect, ImagePreviewTransition$lambda$13($sourcePictureFrame$delegate), 1 - ((Number) $state.getAnimationProgress().getValue()).floatValue()), (Alignment) null, crop, 0.0f, (ColorFilter) null, $composer3, Painter.$stable | 24624, 104);
                        }
                        $composer3.endReplaceGroup();
                        $composer3.endReplaceGroup();
                        Unit unit2 = Unit.INSTANCE;
                        break;
                    default:
                        $composer$iv$iv$iv = $composer;
                        $composer3.startReplaceGroup(-905221997);
                        $composer3.endReplaceGroup();
                        Unit unit3 = Unit.INSTANCE;
                        break;
                }
            } else {
                $composer$iv$iv$iv = $composer;
                $composer3.startReplaceGroup(-914908939);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImagePreviewTransition$lambda$20$0$0(TransitionState $state, MutableState $boxCoordinates$delegate, MutableState $parentSize$delegate, MutableState $sourcePictureFrame$delegate, LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        $boxCoordinates$delegate.setValue(coordinates);
        ImagePreviewTransition$lambda$2($parentSize$delegate, coordinates.getSize-YbymL2g());
        IntRect it = $state.getAsset().getThumbnailRect();
        if (it != null) {
            float x$iv = it.getLeft();
            float y$iv = it.getTop();
            long v1$iv$iv = Float.floatToRawIntBits(x$iv);
            long v2$iv$iv = Float.floatToRawIntBits(y$iv);
            long sourcePictureOffset = coordinates.windowToLocal-MK-Hz9U(Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L)));
            int bits$iv$iv$iv = (int) (sourcePictureOffset >> 32);
            int x$iv2 = (int) Float.intBitsToFloat(bits$iv$iv$iv);
            int bits$iv$iv$iv2 = (int) (sourcePictureOffset & 4294967295L);
            int y$iv2 = (int) Float.intBitsToFloat(bits$iv$iv$iv2);
            $sourcePictureFrame$delegate.setValue(IntRectKt.IntRect-VbeCjmY(IntOffset.constructor-impl((x$iv2 << 32) | (y$iv2 & 4294967295L)), it.getSize-YbymL2g()));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset ImagePreviewTransition$lambda$20$1$6$0(MutableState $pictureOffset$delegate, Density $this$offset) {
        Intrinsics.checkNotNullParameter($this$offset, "$this$offset");
        return IntOffset.box-impl(ImagePreviewTransition$lambda$7($pictureOffset$delegate));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset ImagePreviewTransition$lambda$20$1$9$0(IntRect $sourceRect, Density $this$offset) {
        Intrinsics.checkNotNullParameter($this$offset, "$this$offset");
        int x$iv = $sourceRect.getLeft();
        int y$iv = $sourceRect.getTop();
        return IntOffset.box-impl(IntOffset.constructor-impl((x$iv << 32) | (y$iv & 4294967295L)));
    }

    public static final Modifier exitAnimation(Modifier $this$exitAnimation, IntRect sourceRect, IntRect targetRect, float animationProgress) {
        Intrinsics.checkNotNullParameter($this$exitAnimation, "<this>");
        Intrinsics.checkNotNullParameter(sourceRect, "sourceRect");
        if (targetRect == null) {
            return AlphaKt.alpha($this$exitAnimation, MathHelpersKt.lerp(1.0f, 0.0f, animationProgress));
        }
        float scaleX = MathHelpersKt.lerp(1.0f, targetRect.getWidth() / sourceRect.getWidth(), animationProgress);
        float scaleY = MathHelpersKt.lerp(1.0f, targetRect.getHeight() / sourceRect.getHeight(), animationProgress);
        float sourceCenterX = sourceRect.getLeft() + (sourceRect.getWidth() / 2.0f);
        float sourceCenterY = sourceRect.getTop() + (sourceRect.getHeight() / 2.0f);
        float targetCenterX = targetRect.getLeft() + (targetRect.getWidth() / 2.0f);
        float targetCenterY = targetRect.getTop() + (targetRect.getHeight() / 2.0f);
        final float offsetX = MathHelpersKt.lerp(0.0f, targetCenterX - sourceCenterX, animationProgress);
        final float offsetY = MathHelpersKt.lerp(0.0f, targetCenterY - sourceCenterY, animationProgress);
        return GraphicsLayerModifierKt.graphicsLayer-_6ThJ44$default(OffsetKt.offset($this$exitAnimation, new Function1() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePreviewLauncherKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                IntOffset exitAnimation$lambda$0;
                exitAnimation$lambda$0 = ImagePreviewLauncherKt.exitAnimation$lambda$0(offsetX, offsetY, (Density) obj);
                return exitAnimation$lambda$0;
            }
        }), scaleX, scaleY, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, TransformOrigin.Companion.getCenter-SzJe1aQ(), (Shape) null, false, (RenderEffect) null, 0L, 0L, 0, 0, (ColorFilter) null, 523260, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset exitAnimation$lambda$0(float $offsetX, float $offsetY, Density $this$offset) {
        Intrinsics.checkNotNullParameter($this$offset, "$this$offset");
        int x$iv = (int) $offsetX;
        int y$iv = (int) $offsetY;
        return IntOffset.box-impl(IntOffset.constructor-impl((x$iv << 32) | (y$iv & 4294967295L)));
    }

    public static final Modifier animation(Modifier $this$animation, IntRect sourceRect, IntRect targetRect, float animationProgress) {
        Intrinsics.checkNotNullParameter($this$animation, "<this>");
        Intrinsics.checkNotNullParameter(targetRect, "targetRect");
        if (sourceRect != null) {
            float scaleX = MathHelpersKt.lerp(sourceRect.getWidth() / targetRect.getWidth(), 1.0f, animationProgress);
            float scaleY = MathHelpersKt.lerp(sourceRect.getHeight() / targetRect.getHeight(), 1.0f, animationProgress);
            float sourceCenterX = sourceRect.getLeft() + (sourceRect.getWidth() / 2.0f);
            float sourceCenterY = sourceRect.getTop() + (sourceRect.getHeight() / 2.0f);
            float targetCenterX = targetRect.getLeft() + (targetRect.getWidth() / 2.0f);
            float targetCenterY = targetRect.getTop() + (targetRect.getHeight() / 2.0f);
            final float offsetX = MathHelpersKt.lerp(sourceCenterX - targetCenterX, 0.0f, animationProgress);
            final float offsetY = MathHelpersKt.lerp(sourceCenterY - targetCenterY, 0.0f, animationProgress);
            return GraphicsLayerModifierKt.graphicsLayer-_6ThJ44$default(OffsetKt.offset($this$animation, new Function1() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePreviewLauncherKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    IntOffset animation$lambda$0;
                    animation$lambda$0 = ImagePreviewLauncherKt.animation$lambda$0(offsetX, offsetY, (Density) obj);
                    return animation$lambda$0;
                }
            }), scaleX, scaleY, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, TransformOrigin.Companion.getCenter-SzJe1aQ(), (Shape) null, false, (RenderEffect) null, 0L, 0L, 0, 0, (ColorFilter) null, 523260, (Object) null);
        }
        float alpha = MathHelpersKt.lerp(0.0f, 1.0f, animationProgress);
        return AlphaKt.alpha($this$animation, alpha);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset animation$lambda$0(float $offsetX, float $offsetY, Density $this$offset) {
        Intrinsics.checkNotNullParameter($this$offset, "$this$offset");
        int x$iv = (int) $offsetX;
        int y$iv = (int) $offsetY;
        return IntOffset.box-impl(IntOffset.constructor-impl((x$iv << 32) | (y$iv & 4294967295L)));
    }
}