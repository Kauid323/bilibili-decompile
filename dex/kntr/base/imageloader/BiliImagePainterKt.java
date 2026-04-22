package kntr.base.imageloader;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.AnimationState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BiliImagePainter.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a!\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rH\u0007¢\u0006\u0002\u0010\u0010¨\u0006\u0011²\u0006\f\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u008a\u008e\u0002"}, d2 = {"rememberBiliImagePainter", "Landroidx/compose/ui/graphics/painter/Painter;", "request", "Lkntr/base/imageloader/ImmutableImageRequest;", "(Lkntr/base/imageloader/ImmutableImageRequest;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "imageSource", "Lkntr/base/imageloader/ImageSource;", "options", "Lkntr/base/imageloader/BiliImageOptions;", "(Lkntr/base/imageloader/ImageSource;Lkntr/base/imageloader/BiliImageOptions;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "image", "Lkntr/base/imageloader/Image;", "onAnimation", "Lkotlin/Function1;", "Lkntr/base/imageloader/AnimationState;", "", "(Lkntr/base/imageloader/Image;Lkntr/base/imageloader/BiliImageOptions;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/painter/Painter;", "imageloader_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BiliImagePainterKt {
    public static final Painter rememberBiliImagePainter(ImmutableImageRequest request, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(request, "request");
        ComposerKt.sourceInformationMarkerStart($composer, 1382184500, "C(rememberBiliImagePainter)N(request)27@945L24,28@993L59,31@1081L211,31@1057L235,41@1304L59:BiliImagePainter.kt#2bx67y");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1382184500, $changed, -1, "kntr.base.imageloader.rememberBiliImagePainter (BiliImagePainter.kt:26)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart($composer, 683736516, "CC(remember):Effects.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer);
            $composer.updateRememberedValue(value$iv$iv);
            it$iv$iv = value$iv$iv;
        }
        CoroutineScope scope = (CoroutineScope) it$iv$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 1134414479, "CC(remember):BiliImagePainter.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        MutableState imageSource$delegate = (MutableState) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 1134417447, "CC(remember):BiliImagePainter.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance(scope) | (((($changed & 14) ^ 6) > 4 && $composer.changed(request)) || ($changed & 6) == 4);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = (Function2) new BiliImagePainterKt$rememberBiliImagePainter$1$1(scope, request, imageSource$delegate, null);
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(request, (Function2) it$iv2, $composer, $changed & 14);
        Painter rememberBiliImagePainter = rememberBiliImagePainter(rememberBiliImagePainter$lambda$1(imageSource$delegate), request.getOptions$imageloader_debug(), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return rememberBiliImagePainter;
    }

    private static final ImageSource rememberBiliImagePainter$lambda$1(MutableState<ImageSource> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (ImageSource) $this$getValue$iv.getValue();
    }

    public static final Painter rememberBiliImagePainter(ImageSource imageSource, BiliImageOptions options, Composer $composer, int $changed) {
        Image image;
        Intrinsics.checkNotNullParameter(options, "options");
        $composer.startReplaceGroup(1567378491);
        ComposerKt.sourceInformation($composer, "C(rememberBiliImagePainter)N(imageSource,options)50@1547L46:BiliImagePainter.kt#2bx67y");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1567378491, $changed, -1, "kntr.base.imageloader.rememberBiliImagePainter (BiliImagePainter.kt:48)");
        }
        if (imageSource == null || (image = imageSource.getSource()) == null) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return null;
        }
        Painter rememberBiliImagePainter = rememberBiliImagePainter(image, options, null, $composer, ($changed & 112) | 384, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return rememberBiliImagePainter;
    }

    public static final Painter rememberBiliImagePainter(final Image image, BiliImageOptions options, Function1<? super AnimationState, Unit> function1, Composer $composer, int $changed, int i) {
        Function1 onAnimation;
        boolean z;
        Painter painter;
        AnimatablePainter animatablePainter;
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(options, "options");
        ComposerKt.sourceInformationMarkerStart($composer, 83113619, "C(rememberBiliImagePainter)N(image,options,onAnimation):BiliImagePainter.kt#2bx67y");
        if ((i & 4) != 0) {
            onAnimation = null;
        } else {
            onAnimation = function1;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(83113619, $changed, -1, "kntr.base.imageloader.rememberBiliImagePainter (BiliImagePainter.kt:59)");
        }
        if (image instanceof StaticImage) {
            $composer.startReplaceGroup(2136852839);
            ComposerKt.sourceInformation($composer, "61@1813L80");
            ComposerKt.sourceInformationMarkerStart($composer, -1732184157, "CC(remember):BiliImagePainter.kt#9igjgp");
            boolean invalid$iv = ((($changed & 14) ^ 6) > 4 && $composer.changed(image)) || ($changed & 6) == 4;
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new BitmapPainter(((StaticImage) image).getBitmap(), 0L, 0L, 6, (DefaultConstructorMarker) null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endReplaceGroup();
            painter = (Painter) ((BitmapPainter) it$iv);
        } else if (!(image instanceof AnimateImage)) {
            $composer.startReplaceGroup(-1732183383);
            $composer.endReplaceGroup();
            throw new NoWhenBranchMatchedException();
        } else {
            $composer.startReplaceGroup(2137057005);
            ComposerKt.sourceInformation($composer, "");
            Painter painter2 = ((AnimateImage) image).getPainter();
            if (BiliImage_androidKt.canUseAnimationPainter()) {
                z = false;
            } else if (painter2 != null) {
                z = false;
            } else {
                $composer.startReplaceGroup(2138165689);
                ComposerKt.sourceInformation($composer, "");
                if (options.getAutoPlay()) {
                    $composer.startReplaceGroup(2138225240);
                    ComposerKt.sourceInformation($composer, "98@3213L96,101@3363L791,101@3330L824");
                    ComposerKt.sourceInformationMarkerStart($composer, -1732139341, "CC(remember):BiliImagePainter.kt#9igjgp");
                    boolean invalid$iv2 = ((($changed & 14) ^ 6) > 4 && $composer.changed(image)) || ($changed & 6) == 4;
                    Object it$iv2 = $composer.rememberedValue();
                    if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv2 = new AnimatablePainter((AnimateImage) image);
                        $composer.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                    }
                    AnimatablePainter painter3 = (AnimatablePainter) it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, -1732133846, "CC(remember):BiliImagePainter.kt#9igjgp");
                    boolean invalid$iv3 = (((($changed & 14) ^ 6) > 4 && $composer.changedInstance(image)) || ($changed & 6) == 4) | (((($changed & 112) ^ 48) > 32 && $composer.changed(options)) || ($changed & 48) == 32) | $composer.changed(painter3);
                    Object it$iv3 = $composer.rememberedValue();
                    if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                        Object value$iv3 = (Function2) new BiliImagePainterKt$rememberBiliImagePainter$4$1(image, options, painter3, null);
                        $composer.updateRememberedValue(value$iv3);
                        it$iv3 = value$iv3;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    EffectsKt.LaunchedEffect(painter3, options, (Function2) it$iv3, $composer, $changed & 112);
                    $composer.endReplaceGroup();
                    animatablePainter = painter3;
                } else {
                    $composer.startReplaceGroup(2139241575);
                    ComposerKt.sourceInformation($composer, "119@4228L96");
                    ComposerKt.sourceInformationMarkerStart($composer, -1732106861, "CC(remember):BiliImagePainter.kt#9igjgp");
                    boolean invalid$iv4 = ((($changed & 14) ^ 6) > 4 && $composer.changed(image)) || ($changed & 6) == 4;
                    Object it$iv4 = $composer.rememberedValue();
                    if (invalid$iv4 || it$iv4 == Composer.Companion.getEmpty()) {
                        Object value$iv4 = new BitmapPainter(((AnimateImage) image).getFrame(0), 0L, 0L, 6, (DefaultConstructorMarker) null);
                        $composer.updateRememberedValue(value$iv4);
                        it$iv4 = value$iv4;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endReplaceGroup();
                    animatablePainter = (Painter) ((BitmapPainter) it$iv4);
                }
                $composer.endReplaceGroup();
                painter = animatablePainter;
                $composer.endReplaceGroup();
            }
            $composer.startReplaceGroup(2137120927);
            ComposerKt.sourceInformation($composer, "69@2058L1008");
            ComposerKt.sourceInformationMarkerStart($composer, -1732175389, "CC(remember):BiliImagePainter.kt#9igjgp");
            boolean invalid$iv5 = (((($changed & 14) ^ 6) <= 4 || !$composer.changed(image)) && ($changed & 6) != 4) ? z : true;
            Object it$iv5 = $composer.rememberedValue();
            if (invalid$iv5 || it$iv5 == Composer.Companion.getEmpty()) {
                if (onAnimation != null) {
                    final Function1 it = onAnimation;
                    ((AnimateImage) image).setAnimationListener(new AnimationListener() { // from class: kntr.base.imageloader.BiliImagePainterKt$rememberBiliImagePainter$3$1$1
                        @Override // kntr.base.imageloader.AnimationListener
                        public void onReady(AnimateController controller) {
                            Intrinsics.checkNotNullParameter(controller, "controller");
                            it.invoke(new AnimationState.Ready(((AnimateImage) image).getImageInfo(), controller));
                        }

                        @Override // kntr.base.imageloader.AnimationListener
                        public void onStart() {
                            it.invoke(AnimationState.Start.INSTANCE);
                        }

                        @Override // kntr.base.imageloader.AnimationListener
                        public void onStop() {
                            it.invoke(AnimationState.Stop.INSTANCE);
                        }

                        @Override // kntr.base.imageloader.AnimationListener
                        public void onLastFrame() {
                            it.invoke(AnimationState.LastFrame.INSTANCE);
                        }
                    });
                }
                Intrinsics.checkNotNull(painter2);
                $composer.updateRememberedValue(painter2);
                it$iv5 = painter2;
            }
            painter = (Painter) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endReplaceGroup();
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return painter;
    }
}