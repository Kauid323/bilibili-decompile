package kntr.common.photonic.aphro.ui.preview;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import bili.resource.common.CommonRes;
import bili.resource.common.String0_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageOptions;
import kntr.base.imageloader.BiliImagePainterKt;
import kntr.base.imageloader.ImageSource;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.common.photonic.AssetEntry;
import kntr.common.photonic.aphro.ui.preview.model.PreviewableAsset;
import kntr.common.photonic.aphro.ui.preview.state.ImagePreviewItemState;
import kntr.common.photonic.aphro.ui.preview.state.ImagePreviewState;
import kntr.common.photonic.aphro.ui.preview.utils.IntSizeExtKt;
import kntr.common.photonic.aphro.ui.preview.utils.ResolutionExtKt;
import kntr.common.photonic.shower.AssetShower;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: ImagePageItem.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u001aE\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\u0010\r¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\u0012\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u008a\u008e\u0002"}, d2 = {"ImagePageItem", "", "item", "Lkntr/common/photonic/aphro/ui/preview/state/ImagePreviewItemState;", "state", "Lkntr/common/photonic/aphro/ui/preview/state/ImagePreviewState;", "pageIndex", "", "onDismissRequest", "Lkotlin/Function1;", "Lkntr/common/photonic/aphro/ui/preview/ExitTransitionState;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/common/photonic/aphro/ui/preview/state/ImagePreviewItemState;Lkntr/common/photonic/aphro/ui/preview/state/ImagePreviewState;ILkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ui_debug", "parentSize", "Landroidx/compose/ui/unit/IntSize;", "pictureSize", "imageSource", "Lkotlin/Result;", "Lkntr/base/imageloader/ImageSource;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImagePageItemKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImagePageItem$lambda$17(ImagePreviewItemState imagePreviewItemState, ImagePreviewState imagePreviewState, int i, Function1 function1, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        ImagePageItem(imagePreviewItemState, imagePreviewState, i, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:208:0x08a2, code lost:
        if (r9 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0280, code lost:
        if (r3 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0568  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0574  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x057a  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x05fa  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x06b9  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x06bc  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x06c5  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x06c8  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0783  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x07b9  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x07bc  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x07c7  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x07fc  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x08d7  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x08ec  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0967  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x096a  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0975  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0a4e  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0a5a  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0a60  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0b98  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0372  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ImagePageItem(final ImagePreviewItemState item, final ImagePreviewState state, final int pageIndex, final Function1<? super ExitTransitionState, Unit> function1, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        final Animatable offsetX;
        boolean invalid$iv;
        Object value$iv;
        PreviewableAsset asset;
        Object ImagePageItem$lambda$10;
        Painter painter;
        Object it$iv;
        Modifier onSizeChanged;
        boolean invalid$iv2;
        Object value$iv2;
        String str;
        Modifier modifier4;
        Object obj;
        int i2;
        Animatable offsetX2;
        PreviewableAsset asset2;
        int i3;
        MutableState pictureSize$delegate;
        Modifier modifier5;
        int $dirty;
        boolean invalid$iv3;
        Object it$iv2;
        int changedInstance;
        Object value$iv3;
        MutableState pictureSize$delegate2;
        Composer $composer3;
        Composer $composer$iv;
        Function0 factory$iv$iv$iv;
        MutableState pictureSize$delegate3;
        int $dirty2;
        MutableState parentSize$delegate;
        BoxScope $this$ImagePageItem_u24lambda_u2416;
        Composer $composer$iv2;
        int $changed$iv;
        int i4;
        Object it$iv3;
        final ImagePreviewState imagePreviewState;
        MutableState imageSource$delegate;
        final MutableState pictureSize$delegate4;
        int i5;
        Object it$iv4;
        Composer $composer$iv3;
        Function0 factory$iv$iv$iv2;
        final MutableState parentSize$delegate2;
        PreviewableAsset asset3;
        Composer $composer4;
        int changedInstance2;
        Object value$iv4;
        Composer $composer5;
        PreviewableAsset previewableAsset;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(function1, "onDismissRequest");
        Composer $composer6 = $composer.startRestartGroup(-410624866);
        ComposerKt.sourceInformation($composer6, "C(ImagePageItem)N(item,state,pageIndex,onDismissRequest,modifier)76@3304L59,77@3387L59,79@3464L24,80@3505L55,81@3579L55,82@3653L55,84@3733L71,87@3832L128,91@3992L7,97@4112L55,99@4182L633,114@4857L2604,164@7481L1755,93@4005L9581:ImagePageItem.kt#n54g3c");
        int $dirty3 = $changed;
        if (($changed & 6) == 0) {
            $dirty3 |= $composer6.changed(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty3 |= $composer6.changed(state) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty3 |= $composer6.changed(pageIndex) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty3 |= $composer6.changedInstance(function1) ? 2048 : 1024;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty3 |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer6.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int $dirty4 = $dirty3;
        if ($composer6.shouldExecute(($dirty4 & 9363) != 9362, $dirty4 & 1)) {
            Modifier modifier6 = i6 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-410624866, $dirty4, -1, "kntr.common.photonic.aphro.ui.preview.ImagePageItem (ImagePageItem.kt:74)");
            }
            PreviewableAsset asset4 = item.getAsset();
            ComposerKt.sourceInformationMarkerStart($composer6, 526502873, "CC(remember):ImagePageItem.kt#9igjgp");
            Object it$iv5 = $composer6.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv5 = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.constructor-impl((0 & 4294967295L) | (0 << 32))), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer6.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            }
            final MutableState parentSize$delegate3 = (MutableState) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerStart($composer6, 526505529, "CC(remember):ImagePageItem.kt#9igjgp");
            Object it$iv6 = $composer6.rememberedValue();
            if (it$iv6 == Composer.Companion.getEmpty()) {
                Object value$iv6 = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.constructor-impl((0 << 32) | (0 & 4294967295L))), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer6.updateRememberedValue(value$iv6);
                it$iv6 = value$iv6;
            }
            MutableState pictureSize$delegate5 = (MutableState) it$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerStart($composer6, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer6, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer6.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer6);
                $composer6.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope scope = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            boolean booleanValue = ((Boolean) item.getLoadOriginImage().getValue()).booleanValue();
            ComposerKt.sourceInformationMarkerStart($composer6, 526509301, "CC(remember):ImagePageItem.kt#9igjgp");
            boolean invalid$iv4 = $composer6.changed(booleanValue);
            Object it$iv7 = $composer6.rememberedValue();
            if (invalid$iv4 || it$iv7 == Composer.Companion.getEmpty()) {
                Object value$iv7 = AnimatableKt.Animatable$default(1.0f, 0.0f, 2, (Object) null);
                $composer6.updateRememberedValue(value$iv7);
                it$iv7 = value$iv7;
            }
            final Animatable scale = (Animatable) it$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer6);
            boolean booleanValue2 = ((Boolean) item.getLoadOriginImage().getValue()).booleanValue();
            ComposerKt.sourceInformationMarkerStart($composer6, 526511669, "CC(remember):ImagePageItem.kt#9igjgp");
            boolean invalid$iv5 = $composer6.changed(booleanValue2);
            Object it$iv8 = $composer6.rememberedValue();
            if (!invalid$iv5 && it$iv8 != Composer.Companion.getEmpty()) {
                offsetX = (Animatable) it$iv8;
                ComposerKt.sourceInformationMarkerEnd($composer6);
                boolean booleanValue3 = ((Boolean) item.getLoadOriginImage().getValue()).booleanValue();
                ComposerKt.sourceInformationMarkerStart($composer6, 526514037, "CC(remember):ImagePageItem.kt#9igjgp");
                invalid$iv = $composer6.changed(booleanValue3);
                Object it$iv9 = $composer6.rememberedValue();
                if (invalid$iv) {
                }
                Animatable Animatable$default = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
                $composer6.updateRememberedValue(Animatable$default);
                it$iv9 = Animatable$default;
                final Animatable offsetY = (Animatable) it$iv9;
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerStart($composer6, 526516613, "CC(remember):ImagePageItem.kt#9igjgp");
                value$iv = $composer6.rememberedValue();
                if (value$iv != Composer.Companion.getEmpty()) {
                    Result.Companion companion = Result.Companion;
                    asset = asset4;
                    value$iv = SnapshotStateKt.mutableStateOf$default(Result.m2635boximpl(Result.m2636constructorimpl(asset4.getThumbnailImageSource())), (SnapshotMutationPolicy) null, 2, (Object) null);
                    $composer6.updateRememberedValue(value$iv);
                } else {
                    asset = asset4;
                }
                MutableState imageSource$delegate2 = (MutableState) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ImagePageItem$lambda$10 = ImagePageItem$lambda$10(imageSource$delegate2);
                if (Result.m2642isFailureimpl(ImagePageItem$lambda$10)) {
                    ImagePageItem$lambda$10 = null;
                }
                painter = BiliImagePainterKt.rememberBiliImagePainter((ImageSource) ImagePageItem$lambda$10, new BiliImageOptions(false, 0, false, false, false, null, null, 0.0f, null, null, null, null, null, 8191, null), $composer6, 0);
                CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer6, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = $composer6.consume(this_$iv);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                Density density = (Density) consume;
                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(modifier6, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer6, 526528725, "CC(remember):ImagePageItem.kt#9igjgp");
                it$iv = $composer6.rememberedValue();
                if (it$iv != Composer.Companion.getEmpty()) {
                    Object value$iv8 = new Function1() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePageItemKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj2) {
                            Unit ImagePageItem$lambda$12$0;
                            ImagePageItem$lambda$12$0 = ImagePageItemKt.ImagePageItem$lambda$12$0(parentSize$delegate3, (IntSize) obj2);
                            return ImagePageItem$lambda$12$0;
                        }
                    };
                    $composer6.updateRememberedValue(value$iv8);
                    it$iv = value$iv8;
                }
                ComposerKt.sourceInformationMarkerEnd($composer6);
                onSizeChanged = OnRemeasuredModifierKt.onSizeChanged(fillMaxSize$default, (Function1) it$iv);
                ComposerKt.sourceInformationMarkerStart($composer6, 526531543, "CC(remember):ImagePageItem.kt#9igjgp");
                invalid$iv2 = $composer6.changedInstance(scale) | $composer6.changedInstance(offsetX) | $composer6.changedInstance(offsetY) | (($dirty4 & 112) != 32) | (($dirty4 & 896) != 256) | $composer6.changedInstance(scope);
                value$iv2 = $composer6.rememberedValue();
                if (!invalid$iv2 || value$iv2 == Composer.Companion.getEmpty()) {
                    str = "CC(remember):ImagePageItem.kt#9igjgp";
                    modifier4 = modifier6;
                    obj = null;
                    i2 = 0;
                    offsetX2 = offsetX;
                    asset2 = asset;
                    i3 = 1;
                    pictureSize$delegate = pictureSize$delegate5;
                    modifier5 = onSizeChanged;
                    $dirty = $dirty4;
                    value$iv2 = new Function1() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePageItemKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj2) {
                            Unit ImagePageItem$lambda$13$0;
                            ImagePageItem$lambda$13$0 = ImagePageItemKt.ImagePageItem$lambda$13$0(scale, offsetX, offsetY, state, pageIndex, scope, (GraphicsLayerScope) obj2);
                            return ImagePageItem$lambda$13$0;
                        }
                    };
                    $composer6.updateRememberedValue(value$iv2);
                } else {
                    str = "CC(remember):ImagePageItem.kt#9igjgp";
                    offsetX2 = offsetX;
                    $dirty = $dirty4;
                    modifier4 = modifier6;
                    asset2 = asset;
                    obj = null;
                    i2 = 0;
                    i3 = 1;
                    pictureSize$delegate = pictureSize$delegate5;
                    modifier5 = onSizeChanged;
                }
                ComposerKt.sourceInformationMarkerEnd($composer6);
                Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifier5, (Function1) value$iv2);
                Object value = item.getLoadOriginImage().getValue();
                ComposerKt.sourceInformationMarkerStart($composer6, 526555114, str);
                invalid$iv3 = $composer6.changedInstance(scale) | $composer6.changedInstance(offsetX2) | $composer6.changedInstance(offsetY) | $composer6.changedInstance(scope);
                it$iv2 = $composer6.rememberedValue();
                if (!invalid$iv3 || it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv9 = (PointerInputEventHandler) new ImagePageItemKt$ImagePageItem$3$1(scale, offsetX2, offsetY, scope, parentSize$delegate3, pictureSize$delegate);
                    $composer6.updateRememberedValue(value$iv9);
                    it$iv2 = value$iv9;
                }
                ComposerKt.sourceInformationMarkerEnd($composer6);
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(graphicsLayer, value, (PointerInputEventHandler) it$iv2);
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer6, 526638233, str);
                int $dirty5 = $dirty;
                changedInstance = $composer6.changedInstance(offsetX2) | $composer6.changedInstance(offsetY) | $composer6.changedInstance(scale) | $composer6.changedInstance(scope) | (($dirty5 & 112) != 32 ? i3 : i2) | (($dirty5 & 7168) != 2048 ? i3 : i2);
                value$iv3 = $composer6.rememberedValue();
                if (changedInstance == 0 || value$iv3 == Composer.Companion.getEmpty()) {
                    pictureSize$delegate2 = pictureSize$delegate;
                    modifier3 = modifier4;
                    $composer3 = $composer6;
                    value$iv3 = new ImagePageItemKt$ImagePageItem$4$1(offsetX2, offsetY, scale, scope, parentSize$delegate3, pictureSize$delegate2, state, function1);
                    $composer6.updateRememberedValue(value$iv3);
                } else {
                    $composer3 = $composer6;
                    modifier3 = modifier4;
                    pictureSize$delegate2 = pictureSize$delegate;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier$iv = SuspendingPointerInputFilterKt.pointerInput(pointerInput, unit, (PointerInputEventHandler) value$iv3);
                int $changed$iv2 = i2;
                $composer$iv = $composer3;
                ComposerKt.sourceInformationMarkerStart($composer$iv, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = ($changed$iv2 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv, i2));
                CompositionLocalMap localMap$iv$iv = $composer$iv.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv);
                Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv.startReusableNode();
                if ($composer$iv.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv3;
                    $composer$iv.useNode();
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv3;
                    $composer$iv.createNode(factory$iv$iv$iv);
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer$iv);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                int i8 = (($changed$iv2 >> 6) & 112) | 6;
                BoxScope $this$ImagePageItem_u24lambda_u24162 = BoxScopeInstance.INSTANCE;
                Composer $composer7 = $composer$iv;
                ComposerKt.sourceInformationMarkerStart($composer7, 2078417785, "C242@11229L80,242@11201L108:ImagePageItem.kt#n54g3c");
                if (((int) (ImagePageItem$lambda$1(parentSize$delegate3) >> 32)) <= 0) {
                    MutableState pictureSize$delegate6 = pictureSize$delegate2;
                    int $i$f$unpackInt2 = (int) (ImagePageItem$lambda$1(parentSize$delegate3) & 4294967295L);
                    if ($i$f$unpackInt2 > 0) {
                        $composer7.startReplaceGroup(2078392767);
                        ComposerKt.sourceInformation($composer7, "206@9600L142,210@9783L1399,210@9756L1426");
                        ImagePageItem$lambda$5(pictureSize$delegate6, IntSizeExtKt.m2327scaleInTemP2vQ(ResolutionExtKt.toIntSize(asset2.getRotatedResolution()), ImagePageItem$lambda$1(parentSize$delegate3)));
                        if (((int) (ImagePageItem$lambda$4(pictureSize$delegate6) >> 32)) == 0 || ((int) (ImagePageItem$lambda$4(pictureSize$delegate6) & 4294967295L)) == 0) {
                            ImagePageItem$lambda$5(pictureSize$delegate6, ImagePageItem$lambda$1(parentSize$delegate3));
                        }
                        PreviewableAsset asset5 = item.getAsset();
                        ComposerKt.sourceInformationMarkerStart($composer7, -902778702, str);
                        boolean invalid$iv6 = $composer7.changed(asset5);
                        Object it$iv10 = $composer7.rememberedValue();
                        if (!invalid$iv6 && it$iv10 != Composer.Companion.getEmpty()) {
                            AssetShower shower = (AssetShower) it$iv10;
                            ComposerKt.sourceInformationMarkerEnd($composer7);
                            asset3 = item.getAsset();
                            ComposerKt.sourceInformationMarkerStart($composer7, -902771589, str);
                            $composer4 = $composer3;
                            PreviewableAsset asset6 = asset2;
                            changedInstance2 = (($dirty5 & 14) != 4 ? i3 : 0) | (($dirty5 & 112) != 32 ? i3 : 0) | $composer4.changedInstance(shower) | $composer4.changedInstance(asset6);
                            value$iv4 = $composer7.rememberedValue();
                            if (changedInstance2 == 0 || value$iv4 == Composer.Companion.getEmpty()) {
                                $composer5 = $composer7;
                                $composer2 = $composer4;
                                $composer$iv2 = $composer$iv;
                                previewableAsset = asset3;
                                pictureSize$delegate3 = pictureSize$delegate6;
                                $changed$iv = 0;
                                $this$ImagePageItem_u24lambda_u2416 = $this$ImagePageItem_u24lambda_u24162;
                                $dirty2 = $dirty5;
                                parentSize$delegate = parentSize$delegate3;
                                value$iv4 = new ImagePageItemKt$ImagePageItem$5$1$1(item, pictureSize$delegate6, state, shower, asset6, imageSource$delegate2, null);
                                $composer7.updateRememberedValue(value$iv4);
                            } else {
                                parentSize$delegate = parentSize$delegate3;
                                $composer5 = $composer7;
                                $composer2 = $composer4;
                                pictureSize$delegate3 = pictureSize$delegate6;
                                $this$ImagePageItem_u24lambda_u2416 = $this$ImagePageItem_u24lambda_u24162;
                                $composer$iv2 = $composer$iv;
                                $dirty2 = $dirty5;
                                $changed$iv = 0;
                                previewableAsset = asset3;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            $composer7 = $composer5;
                            EffectsKt.LaunchedEffect(previewableAsset, (Function2) value$iv4, $composer7, $changed$iv);
                            $composer7.endReplaceGroup();
                            Result m2635boximpl = Result.m2635boximpl(ImagePageItem$lambda$10(imageSource$delegate2));
                            ComposerKt.sourceInformationMarkerStart($composer7, -902726636, str);
                            i4 = ($dirty2 & 112) != 32 ? i3 : $changed$iv;
                            Composer $this$cache$iv = $composer7;
                            it$iv3 = $this$cache$iv.rememberedValue();
                            if (i4 == 0 || it$iv3 == Composer.Companion.getEmpty()) {
                                imagePreviewState = state;
                                imageSource$delegate = imageSource$delegate2;
                                Object value$iv10 = (Function2) new ImagePageItemKt$ImagePageItem$5$2$1(imagePreviewState, imageSource$delegate, null);
                                $this$cache$iv.updateRememberedValue(value$iv10);
                                it$iv3 = value$iv10;
                            } else {
                                imagePreviewState = state;
                                imageSource$delegate = imageSource$delegate2;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer7);
                            EffectsKt.LaunchedEffect(m2635boximpl, (Function2) it$iv3, $composer7, 0);
                            if (painter == null) {
                                $composer7.startReplaceGroup(2080385199);
                                ComposerKt.sourceInformation($composer7, "261@11834L366,267@12222L132,254@11595L774");
                                long size = DpKt.DpSize-YgX7TsA(density.toDp-u2uoSUM((int) (ImagePageItem$lambda$4(pictureSize$delegate3) >> 32)), density.toDp-u2uoSUM((int) (ImagePageItem$lambda$4(pictureSize$delegate3) & 4294967295L)));
                                Modifier modifier7 = SizeKt.size-6HolHcs(Modifier.Companion, size);
                                ComposerKt.sourceInformationMarkerStart($composer7, -902706990, str);
                                Composer $this$cache$iv2 = $composer7;
                                Object it$iv11 = $this$cache$iv2.rememberedValue();
                                if (it$iv11 == Composer.Companion.getEmpty()) {
                                    pictureSize$delegate4 = pictureSize$delegate3;
                                    parentSize$delegate2 = parentSize$delegate;
                                    Object value$iv11 = new Function1() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePageItemKt$$ExternalSyntheticLambda2
                                        public final Object invoke(Object obj2) {
                                            IntOffset ImagePageItem$lambda$16$4$0;
                                            ImagePageItem$lambda$16$4$0 = ImagePageItemKt.ImagePageItem$lambda$16$4$0(parentSize$delegate2, pictureSize$delegate4, (Density) obj2);
                                            return ImagePageItem$lambda$16$4$0;
                                        }
                                    };
                                    $this$cache$iv2.updateRememberedValue(value$iv11);
                                    it$iv11 = value$iv11;
                                } else {
                                    pictureSize$delegate4 = pictureSize$delegate3;
                                    parentSize$delegate2 = parentSize$delegate;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer7);
                                Modifier offset = OffsetKt.offset(modifier7, (Function1) it$iv11);
                                ComposerKt.sourceInformationMarkerStart($composer7, -902694808, str);
                                int i9 = ($dirty2 & 112) == 32 ? i3 : 0;
                                Composer $this$cache$iv3 = $composer7;
                                Object it$iv12 = $this$cache$iv3.rememberedValue();
                                if (i9 != 0) {
                                }
                                Object value$iv12 = new Function1() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePageItemKt$$ExternalSyntheticLambda3
                                    public final Object invoke(Object obj2) {
                                        Unit ImagePageItem$lambda$16$5$0;
                                        ImagePageItem$lambda$16$5$0 = ImagePageItemKt.ImagePageItem$lambda$16$5$0(ImagePreviewState.this, (LayoutCoordinates) obj2);
                                        return ImagePageItem$lambda$16$5$0;
                                    }
                                };
                                $this$cache$iv3.updateRememberedValue(value$iv12);
                                it$iv12 = value$iv12;
                                ComposerKt.sourceInformationMarkerEnd($composer7);
                                ImageKt.Image(painter, (String) null, OnGloballyPositionedModifierKt.onGloballyPositioned(offset, (Function1) it$iv12), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer7, Painter.$stable | 48, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
                            } else {
                                pictureSize$delegate4 = pictureSize$delegate3;
                                $composer7.startReplaceGroup(2069102718);
                            }
                            $composer7.endReplaceGroup();
                            if (!Result.m2642isFailureimpl(ImagePageItem$lambda$10(imageSource$delegate))) {
                                Object ImagePageItem$lambda$102 = ImagePageItem$lambda$10(imageSource$delegate);
                                if (Result.m2642isFailureimpl(ImagePageItem$lambda$102)) {
                                    ImagePageItem$lambda$102 = null;
                                }
                                ImageSource imageSource = (ImageSource) ImagePageItem$lambda$102;
                                if ((imageSource != null ? imageSource.getError() : null) == null) {
                                    $composer7.startReplaceGroup(2069102718);
                                    $composer7.endReplaceGroup();
                                    ComposerKt.sourceInformationMarkerEnd($composer7);
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                                    $composer$iv.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }
                            $composer7.startReplaceGroup(2081495867);
                            ComposerKt.sourceInformation($composer7, "280@12787L82,273@12471L1099");
                            Modifier modifier8 = BackgroundKt.background-bw27NRU($this$ImagePageItem_u24lambda_u2416.align(Modifier.Companion, Alignment.Companion.getCenter()), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
                            ComposerKt.sourceInformationMarkerStart($composer7, -902676778, str);
                            i5 = ($dirty2 & 14) != 4 ? i3 : 0;
                            Composer $this$cache$iv4 = $composer7;
                            it$iv4 = $this$cache$iv4.rememberedValue();
                            if (i5 == 0 || it$iv4 == Composer.Companion.getEmpty()) {
                                Object value$iv13 = new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePageItemKt$$ExternalSyntheticLambda4
                                    public final Object invoke() {
                                        Unit ImagePageItem$lambda$16$6$0;
                                        ImagePageItem$lambda$16$6$0 = ImagePageItemKt.ImagePageItem$lambda$16$6$0(ImagePreviewItemState.this);
                                        return ImagePageItem$lambda$16$6$0;
                                    }
                                };
                                $this$cache$iv4.updateRememberedValue(value$iv13);
                                it$iv4 = value$iv13;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer7);
                            Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(modifier8, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv4, 15, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(8));
                            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(4));
                            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
                            $composer$iv3 = $composer7;
                            ComposerKt.sourceInformationMarkerStart($composer$iv3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer$iv3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                            int $changed$iv$iv2 = (432 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                            CompositionLocalMap localMap$iv$iv2 = $composer$iv3.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv2);
                            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer$iv3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer$iv3.startReusableNode();
                            if ($composer$iv3.getInserting()) {
                                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                                $composer$iv3.useNode();
                            } else {
                                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                                $composer$iv3.createNode(factory$iv$iv$iv2);
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv3);
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                            int i10 = ($changed$iv$iv$iv2 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer$iv3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                            int i11 = ((432 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer$iv3, -111020900, "C287@13131L21,289@13238L6,286@13082L245,293@13377L57,294@13474L6,295@13524L9,292@13344L212:ImagePageItem.kt#n54g3c");
                            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_replay_line_500($composer$iv3, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getText_white-0d7_KjU(), $composer$iv3, Painter.$stable | 432, 0);
                            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_204(CommonRes.INSTANCE.getString()), $composer$iv3, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getGa7-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv3, BiliTheme.$stable).getT14(), $composer$iv3, 0, 0, 131066);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                            $composer$iv3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                            $composer7.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd($composer7);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                            $composer$iv.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer$iv);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                        }
                        Object value$iv14 = AssetEntry.INSTANCE.getShower().getShowerForAssetType(Reflection.getOrCreateKotlinClass(item.getAsset().getClass()));
                        if (!(value$iv14 instanceof AssetShower)) {
                            value$iv14 = null;
                        }
                        $composer7.updateRememberedValue(value$iv14);
                        it$iv10 = value$iv14;
                        AssetShower shower2 = (AssetShower) it$iv10;
                        ComposerKt.sourceInformationMarkerEnd($composer7);
                        asset3 = item.getAsset();
                        ComposerKt.sourceInformationMarkerStart($composer7, -902771589, str);
                        $composer4 = $composer3;
                        PreviewableAsset asset62 = asset2;
                        changedInstance2 = (($dirty5 & 14) != 4 ? i3 : 0) | (($dirty5 & 112) != 32 ? i3 : 0) | $composer4.changedInstance(shower2) | $composer4.changedInstance(asset62);
                        value$iv4 = $composer7.rememberedValue();
                        if (changedInstance2 == 0) {
                        }
                        $composer5 = $composer7;
                        $composer2 = $composer4;
                        $composer$iv2 = $composer$iv;
                        previewableAsset = asset3;
                        pictureSize$delegate3 = pictureSize$delegate6;
                        $changed$iv = 0;
                        $this$ImagePageItem_u24lambda_u2416 = $this$ImagePageItem_u24lambda_u24162;
                        $dirty2 = $dirty5;
                        parentSize$delegate = parentSize$delegate3;
                        value$iv4 = new ImagePageItemKt$ImagePageItem$5$1$1(item, pictureSize$delegate6, state, shower2, asset62, imageSource$delegate2, null);
                        $composer7.updateRememberedValue(value$iv4);
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        $composer7 = $composer5;
                        EffectsKt.LaunchedEffect(previewableAsset, (Function2) value$iv4, $composer7, $changed$iv);
                        $composer7.endReplaceGroup();
                        Result m2635boximpl2 = Result.m2635boximpl(ImagePageItem$lambda$10(imageSource$delegate2));
                        ComposerKt.sourceInformationMarkerStart($composer7, -902726636, str);
                        i4 = ($dirty2 & 112) != 32 ? i3 : $changed$iv;
                        Composer $this$cache$iv5 = $composer7;
                        it$iv3 = $this$cache$iv5.rememberedValue();
                        if (i4 == 0) {
                        }
                        imagePreviewState = state;
                        imageSource$delegate = imageSource$delegate2;
                        Object value$iv102 = (Function2) new ImagePageItemKt$ImagePageItem$5$2$1(imagePreviewState, imageSource$delegate, null);
                        $this$cache$iv5.updateRememberedValue(value$iv102);
                        it$iv3 = value$iv102;
                        ComposerKt.sourceInformationMarkerEnd($composer7);
                        EffectsKt.LaunchedEffect(m2635boximpl2, (Function2) it$iv3, $composer7, 0);
                        if (painter == null) {
                        }
                        $composer7.endReplaceGroup();
                        if (!Result.m2642isFailureimpl(ImagePageItem$lambda$10(imageSource$delegate))) {
                        }
                        $composer7.startReplaceGroup(2081495867);
                        ComposerKt.sourceInformation($composer7, "280@12787L82,273@12471L1099");
                        Modifier modifier82 = BackgroundKt.background-bw27NRU($this$ImagePageItem_u24lambda_u2416.align(Modifier.Companion, Alignment.Companion.getCenter()), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
                        ComposerKt.sourceInformationMarkerStart($composer7, -902676778, str);
                        i5 = ($dirty2 & 14) != 4 ? i3 : 0;
                        Composer $this$cache$iv42 = $composer7;
                        it$iv4 = $this$cache$iv42.rememberedValue();
                        if (i5 == 0) {
                        }
                        Object value$iv132 = new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePageItemKt$$ExternalSyntheticLambda4
                            public final Object invoke() {
                                Unit ImagePageItem$lambda$16$6$0;
                                ImagePageItem$lambda$16$6$0 = ImagePageItemKt.ImagePageItem$lambda$16$6$0(ImagePreviewItemState.this);
                                return ImagePageItem$lambda$16$6$0;
                            }
                        };
                        $this$cache$iv42.updateRememberedValue(value$iv132);
                        it$iv4 = value$iv132;
                        ComposerKt.sourceInformationMarkerEnd($composer7);
                        Modifier modifier$iv22 = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(modifier82, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv4, 15, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(8));
                        Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(4));
                        Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getCenterHorizontally();
                        $composer$iv3 = $composer7;
                        ComposerKt.sourceInformationMarkerStart($composer$iv3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv22 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer$iv3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                        int $changed$iv$iv22 = (432 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                        CompositionLocalMap localMap$iv$iv22 = $composer$iv3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv22 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv22);
                        Function0 factory$iv$iv$iv42 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer$iv3.getApplier() instanceof Applier)) {
                        }
                        $composer$iv3.startReusableNode();
                        if ($composer$iv3.getInserting()) {
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer$iv3);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv22, ComposeUiNode.Companion.getSetModifier());
                        int i102 = ($changed$iv$iv$iv22 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer$iv3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                        int i112 = ((432 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer$iv3, -111020900, "C287@13131L21,289@13238L6,286@13082L245,293@13377L57,294@13474L6,295@13524L9,292@13344L212:ImagePageItem.kt#n54g3c");
                        IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_replay_line_500($composer$iv3, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getText_white-0d7_KjU(), $composer$iv3, Painter.$stable | 432, 0);
                        TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_204(CommonRes.INSTANCE.getString()), $composer$iv3, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getGa7-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv3, BiliTheme.$stable).getT14(), $composer$iv3, 0, 0, 131066);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        $composer$iv3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        $composer7.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer7);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                        $composer$iv.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    } else {
                        $composer2 = $composer3;
                        $dirty2 = $dirty5;
                        parentSize$delegate = parentSize$delegate3;
                        $this$ImagePageItem_u24lambda_u2416 = $this$ImagePageItem_u24lambda_u24162;
                        $composer$iv2 = $composer$iv;
                        pictureSize$delegate3 = pictureSize$delegate6;
                        $changed$iv = 0;
                    }
                } else {
                    $composer2 = $composer3;
                    pictureSize$delegate3 = pictureSize$delegate2;
                    $dirty2 = $dirty5;
                    parentSize$delegate = parentSize$delegate3;
                    $this$ImagePageItem_u24lambda_u2416 = $this$ImagePageItem_u24lambda_u24162;
                    $composer$iv2 = $composer$iv;
                    $changed$iv = 0;
                }
                $composer7.startReplaceGroup(2069102718);
                $composer7.endReplaceGroup();
                Result m2635boximpl22 = Result.m2635boximpl(ImagePageItem$lambda$10(imageSource$delegate2));
                ComposerKt.sourceInformationMarkerStart($composer7, -902726636, str);
                i4 = ($dirty2 & 112) != 32 ? i3 : $changed$iv;
                Composer $this$cache$iv52 = $composer7;
                it$iv3 = $this$cache$iv52.rememberedValue();
                if (i4 == 0) {
                }
                imagePreviewState = state;
                imageSource$delegate = imageSource$delegate2;
                Object value$iv1022 = (Function2) new ImagePageItemKt$ImagePageItem$5$2$1(imagePreviewState, imageSource$delegate, null);
                $this$cache$iv52.updateRememberedValue(value$iv1022);
                it$iv3 = value$iv1022;
                ComposerKt.sourceInformationMarkerEnd($composer7);
                EffectsKt.LaunchedEffect(m2635boximpl22, (Function2) it$iv3, $composer7, 0);
                if (painter == null) {
                }
                $composer7.endReplaceGroup();
                if (!Result.m2642isFailureimpl(ImagePageItem$lambda$10(imageSource$delegate))) {
                }
                $composer7.startReplaceGroup(2081495867);
                ComposerKt.sourceInformation($composer7, "280@12787L82,273@12471L1099");
                Modifier modifier822 = BackgroundKt.background-bw27NRU($this$ImagePageItem_u24lambda_u2416.align(Modifier.Companion, Alignment.Companion.getCenter()), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
                ComposerKt.sourceInformationMarkerStart($composer7, -902676778, str);
                i5 = ($dirty2 & 14) != 4 ? i3 : 0;
                Composer $this$cache$iv422 = $composer7;
                it$iv4 = $this$cache$iv422.rememberedValue();
                if (i5 == 0) {
                }
                Object value$iv1322 = new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePageItemKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit ImagePageItem$lambda$16$6$0;
                        ImagePageItem$lambda$16$6$0 = ImagePageItemKt.ImagePageItem$lambda$16$6$0(ImagePreviewItemState.this);
                        return ImagePageItem$lambda$16$6$0;
                    }
                };
                $this$cache$iv422.updateRememberedValue(value$iv1322);
                it$iv4 = value$iv1322;
                ComposerKt.sourceInformationMarkerEnd($composer7);
                Modifier modifier$iv222 = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(modifier822, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv4, 15, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(8));
                Arrangement.Vertical verticalArrangement$iv22 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(4));
                Alignment.Horizontal horizontalAlignment$iv22 = Alignment.Companion.getCenterHorizontally();
                $composer$iv3 = $composer7;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv222 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv22, horizontalAlignment$iv22, $composer$iv3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                int $changed$iv$iv222 = (432 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                CompositionLocalMap localMap$iv$iv222 = $composer$iv3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv222 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv222);
                Function0 factory$iv$iv$iv422 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv222 = (($changed$iv$iv222 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv3.getApplier() instanceof Applier)) {
                }
                $composer$iv3.startReusableNode();
                if ($composer$iv3.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv222 = Updater.constructor-impl($composer$iv3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv222, measurePolicy$iv222, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv222, localMap$iv$iv222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv222, Integer.valueOf(compositeKeyHash$iv$iv222), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv222, materialized$iv$iv222, ComposeUiNode.Companion.getSetModifier());
                int i1022 = ($changed$iv$iv$iv222 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope22 = ColumnScopeInstance.INSTANCE;
                int i1122 = ((432 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -111020900, "C287@13131L21,289@13238L6,286@13082L245,293@13377L57,294@13474L6,295@13524L9,292@13344L212:ImagePageItem.kt#n54g3c");
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_replay_line_500($composer$iv3, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getText_white-0d7_KjU(), $composer$iv3, Painter.$stable | 432, 0);
                TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_204(CommonRes.INSTANCE.getString()), $composer$iv3, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getGa7-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv3, BiliTheme.$stable).getT14(), $composer$iv3, 0, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer$iv3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer7.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer7);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            Animatable Animatable$default2 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
            $composer6.updateRememberedValue(Animatable$default2);
            it$iv8 = Animatable$default2;
            offsetX = (Animatable) it$iv8;
            ComposerKt.sourceInformationMarkerEnd($composer6);
            boolean booleanValue32 = ((Boolean) item.getLoadOriginImage().getValue()).booleanValue();
            ComposerKt.sourceInformationMarkerStart($composer6, 526514037, "CC(remember):ImagePageItem.kt#9igjgp");
            invalid$iv = $composer6.changed(booleanValue32);
            Object it$iv92 = $composer6.rememberedValue();
            if (invalid$iv) {
            }
            Animatable Animatable$default3 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
            $composer6.updateRememberedValue(Animatable$default3);
            it$iv92 = Animatable$default3;
            final Animatable offsetY2 = (Animatable) it$iv92;
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerStart($composer6, 526516613, "CC(remember):ImagePageItem.kt#9igjgp");
            value$iv = $composer6.rememberedValue();
            if (value$iv != Composer.Companion.getEmpty()) {
            }
            MutableState imageSource$delegate22 = (MutableState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ImagePageItem$lambda$10 = ImagePageItem$lambda$10(imageSource$delegate22);
            if (Result.m2642isFailureimpl(ImagePageItem$lambda$10)) {
            }
            painter = BiliImagePainterKt.rememberBiliImagePainter((ImageSource) ImagePageItem$lambda$10, new BiliImageOptions(false, 0, false, false, false, null, null, 0.0f, null, null, null, null, null, 8191, null), $composer6, 0);
            CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer6, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer6.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            Density density2 = (Density) consume2;
            Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(modifier6, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer6, 526528725, "CC(remember):ImagePageItem.kt#9igjgp");
            it$iv = $composer6.rememberedValue();
            if (it$iv != Composer.Companion.getEmpty()) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer6);
            onSizeChanged = OnRemeasuredModifierKt.onSizeChanged(fillMaxSize$default2, (Function1) it$iv);
            ComposerKt.sourceInformationMarkerStart($composer6, 526531543, "CC(remember):ImagePageItem.kt#9igjgp");
            invalid$iv2 = $composer6.changedInstance(scale) | $composer6.changedInstance(offsetX) | $composer6.changedInstance(offsetY2) | (($dirty4 & 112) != 32) | (($dirty4 & 896) != 256) | $composer6.changedInstance(scope);
            value$iv2 = $composer6.rememberedValue();
            if (invalid$iv2) {
            }
            str = "CC(remember):ImagePageItem.kt#9igjgp";
            modifier4 = modifier6;
            obj = null;
            i2 = 0;
            offsetX2 = offsetX;
            asset2 = asset;
            i3 = 1;
            pictureSize$delegate = pictureSize$delegate5;
            modifier5 = onSizeChanged;
            $dirty = $dirty4;
            value$iv2 = new Function1() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePageItemKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj2) {
                    Unit ImagePageItem$lambda$13$0;
                    ImagePageItem$lambda$13$0 = ImagePageItemKt.ImagePageItem$lambda$13$0(scale, offsetX, offsetY2, state, pageIndex, scope, (GraphicsLayerScope) obj2);
                    return ImagePageItem$lambda$13$0;
                }
            };
            $composer6.updateRememberedValue(value$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            Modifier graphicsLayer2 = GraphicsLayerModifierKt.graphicsLayer(modifier5, (Function1) value$iv2);
            Object value2 = item.getLoadOriginImage().getValue();
            ComposerKt.sourceInformationMarkerStart($composer6, 526555114, str);
            invalid$iv3 = $composer6.changedInstance(scale) | $composer6.changedInstance(offsetX2) | $composer6.changedInstance(offsetY2) | $composer6.changedInstance(scope);
            it$iv2 = $composer6.rememberedValue();
            if (!invalid$iv3) {
            }
            Object value$iv92 = (PointerInputEventHandler) new ImagePageItemKt$ImagePageItem$3$1(scale, offsetX2, offsetY2, scope, parentSize$delegate3, pictureSize$delegate);
            $composer6.updateRememberedValue(value$iv92);
            it$iv2 = value$iv92;
            ComposerKt.sourceInformationMarkerEnd($composer6);
            Modifier pointerInput2 = SuspendingPointerInputFilterKt.pointerInput(graphicsLayer2, value2, (PointerInputEventHandler) it$iv2);
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer6, 526638233, str);
            int $dirty52 = $dirty;
            changedInstance = $composer6.changedInstance(offsetX2) | $composer6.changedInstance(offsetY2) | $composer6.changedInstance(scale) | $composer6.changedInstance(scope) | (($dirty52 & 112) != 32 ? i3 : i2) | (($dirty52 & 7168) != 2048 ? i3 : i2);
            value$iv3 = $composer6.rememberedValue();
            if (changedInstance == 0) {
            }
            pictureSize$delegate2 = pictureSize$delegate;
            modifier3 = modifier4;
            $composer3 = $composer6;
            value$iv3 = new ImagePageItemKt$ImagePageItem$4$1(offsetX2, offsetY2, scale, scope, parentSize$delegate3, pictureSize$delegate2, state, function1);
            $composer6.updateRememberedValue(value$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv3 = SuspendingPointerInputFilterKt.pointerInput(pointerInput2, unit2, (PointerInputEventHandler) value$iv3);
            int $changed$iv22 = i2;
            $composer$iv = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv3 = ($changed$iv22 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv, i2));
            CompositionLocalMap localMap$iv$iv3 = $composer$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv3);
            Function0 factory$iv$iv$iv32 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv.getApplier() instanceof Applier)) {
            }
            $composer$iv.startReusableNode();
            if ($composer$iv.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer$iv);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i72 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i82 = (($changed$iv22 >> 6) & 112) | 6;
            BoxScope $this$ImagePageItem_u24lambda_u241622 = BoxScopeInstance.INSTANCE;
            Composer $composer72 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer72, 2078417785, "C242@11229L80,242@11201L108:ImagePageItem.kt#n54g3c");
            if (((int) (ImagePageItem$lambda$1(parentSize$delegate3) >> 32)) <= 0) {
            }
            $composer72.startReplaceGroup(2069102718);
            $composer72.endReplaceGroup();
            Result m2635boximpl222 = Result.m2635boximpl(ImagePageItem$lambda$10(imageSource$delegate22));
            ComposerKt.sourceInformationMarkerStart($composer72, -902726636, str);
            i4 = ($dirty2 & 112) != 32 ? i3 : $changed$iv;
            Composer $this$cache$iv522 = $composer72;
            it$iv3 = $this$cache$iv522.rememberedValue();
            if (i4 == 0) {
            }
            imagePreviewState = state;
            imageSource$delegate = imageSource$delegate22;
            Object value$iv10222 = (Function2) new ImagePageItemKt$ImagePageItem$5$2$1(imagePreviewState, imageSource$delegate, null);
            $this$cache$iv522.updateRememberedValue(value$iv10222);
            it$iv3 = value$iv10222;
            ComposerKt.sourceInformationMarkerEnd($composer72);
            EffectsKt.LaunchedEffect(m2635boximpl222, (Function2) it$iv3, $composer72, 0);
            if (painter == null) {
            }
            $composer72.endReplaceGroup();
            if (!Result.m2642isFailureimpl(ImagePageItem$lambda$10(imageSource$delegate))) {
            }
            $composer72.startReplaceGroup(2081495867);
            ComposerKt.sourceInformation($composer72, "280@12787L82,273@12471L1099");
            Modifier modifier8222 = BackgroundKt.background-bw27NRU($this$ImagePageItem_u24lambda_u2416.align(Modifier.Companion, Alignment.Companion.getCenter()), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
            ComposerKt.sourceInformationMarkerStart($composer72, -902676778, str);
            i5 = ($dirty2 & 14) != 4 ? i3 : 0;
            Composer $this$cache$iv4222 = $composer72;
            it$iv4 = $this$cache$iv4222.rememberedValue();
            if (i5 == 0) {
            }
            Object value$iv13222 = new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePageItemKt$$ExternalSyntheticLambda4
                public final Object invoke() {
                    Unit ImagePageItem$lambda$16$6$0;
                    ImagePageItem$lambda$16$6$0 = ImagePageItemKt.ImagePageItem$lambda$16$6$0(ImagePreviewItemState.this);
                    return ImagePageItem$lambda$16$6$0;
                }
            };
            $this$cache$iv4222.updateRememberedValue(value$iv13222);
            it$iv4 = value$iv13222;
            ComposerKt.sourceInformationMarkerEnd($composer72);
            Modifier modifier$iv2222 = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(modifier8222, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv4, 15, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(8));
            Arrangement.Vertical verticalArrangement$iv222 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(4));
            Alignment.Horizontal horizontalAlignment$iv222 = Alignment.Companion.getCenterHorizontally();
            $composer$iv3 = $composer72;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2222 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv222, horizontalAlignment$iv222, $composer$iv3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv2222 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
            CompositionLocalMap localMap$iv$iv2222 = $composer$iv3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2222 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv2222);
            Function0 factory$iv$iv$iv4222 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2222 = (($changed$iv$iv2222 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv3.getApplier() instanceof Applier)) {
            }
            $composer$iv3.startReusableNode();
            if ($composer$iv3.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2222 = Updater.constructor-impl($composer$iv3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2222, measurePolicy$iv2222, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2222, localMap$iv$iv2222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2222, Integer.valueOf(compositeKeyHash$iv$iv2222), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2222, materialized$iv$iv2222, ComposeUiNode.Companion.getSetModifier());
            int i10222 = ($changed$iv$iv$iv2222 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope222 = ColumnScopeInstance.INSTANCE;
            int i11222 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -111020900, "C287@13131L21,289@13238L6,286@13082L245,293@13377L57,294@13474L6,295@13524L9,292@13344L212:ImagePageItem.kt#n54g3c");
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_replay_line_500($composer$iv3, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getText_white-0d7_KjU(), $composer$iv3, Painter.$stable | 432, 0);
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_204(CommonRes.INSTANCE.getString()), $composer$iv3, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getGa7-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv3, BiliTheme.$stable).getT14(), $composer$iv3, 0, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer$iv3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer72.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer72);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2 = $composer6;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier9 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePageItemKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj2, Object obj3) {
                    Unit ImagePageItem$lambda$17;
                    ImagePageItem$lambda$17 = ImagePageItemKt.ImagePageItem$lambda$17(ImagePreviewItemState.this, state, pageIndex, function1, modifier9, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return ImagePageItem$lambda$17;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long ImagePageItem$lambda$1(MutableState<IntSize> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((IntSize) $this$getValue$iv.getValue()).unbox-impl();
    }

    private static final void ImagePageItem$lambda$2(MutableState<IntSize> mutableState, long j) {
        Object value$iv = IntSize.box-impl(j);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long ImagePageItem$lambda$4(MutableState<IntSize> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((IntSize) $this$getValue$iv.getValue()).unbox-impl();
    }

    private static final void ImagePageItem$lambda$5(MutableState<IntSize> mutableState, long j) {
        Object value$iv = IntSize.box-impl(j);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ImagePageItem$lambda$10(MutableState<Result<ImageSource>> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Result) $this$getValue$iv.getValue()).m2645unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ImagePageItem$lambda$11(MutableState<Result<ImageSource>> mutableState, Object obj) {
        Object value$iv = Result.m2635boximpl(obj);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImagePageItem$lambda$12$0(MutableState $parentSize$delegate, IntSize it) {
        ImagePageItem$lambda$2($parentSize$delegate, it.unbox-impl());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImagePageItem$lambda$13$0(Animatable $scale, Animatable $offsetX, Animatable $offsetY, ImagePreviewState $state, int $pageIndex, CoroutineScope $scope, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setScaleX(((Number) $scale.getValue()).floatValue());
        $this$graphicsLayer.setScaleY(((Number) $scale.getValue()).floatValue());
        $this$graphicsLayer.setTranslationX(((Number) $offsetX.getValue()).floatValue());
        $this$graphicsLayer.setTranslationY(((Number) $offsetY.getValue()).floatValue());
        float pageOffset = Math.abs(($state.getPagerState().getCurrentPage() + $state.getPagerState().getCurrentPageOffsetFraction()) - $pageIndex);
        if (pageOffset == 1.0f) {
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ImagePageItemKt$ImagePageItem$2$1$1($scale, $offsetX, null), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset ImagePageItem$lambda$16$4$0(MutableState $parentSize$delegate, MutableState $pictureSize$delegate, Density $this$offset) {
        Intrinsics.checkNotNullParameter($this$offset, "$this$offset");
        float baseX = (((int) (ImagePageItem$lambda$1($parentSize$delegate) >> 32)) - ((int) (ImagePageItem$lambda$4($pictureSize$delegate) >> 32))) / 2.0f;
        int $i$f$unpackInt2 = (int) (ImagePageItem$lambda$1($parentSize$delegate) & 4294967295L);
        float baseY = RangesKt.coerceAtLeast(($i$f$unpackInt2 - ((int) (ImagePageItem$lambda$4($pictureSize$delegate) & 4294967295L))) / 2.0f, 0.0f);
        int x$iv = (int) baseX;
        int y$iv = (int) baseY;
        return IntOffset.box-impl(IntOffset.constructor-impl((x$iv << 32) | (4294967295L & y$iv)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImagePageItem$lambda$16$5$0(ImagePreviewState $state, LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        $state.getCurrentPictureRect().setValue(LayoutCoordinatesKt.boundsInWindow$default(coordinates, false, 1, (Object) null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImagePageItem$lambda$16$6$0(ImagePreviewItemState $item) {
        MutableIntState retryCount = $item.getRetryCount();
        retryCount.setValue(retryCount.getValue().intValue() + 1);
        return Unit.INSTANCE;
    }
}