package tv.danmaku.bili.ui.main2.mine.widgets;

import android.net.Uri;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.ColorPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.res.PainterResources_androidKt;
import com.bilibili.app.comm.list.widget.image.ImageResource;
import com.bilibili.app.comm.list.widget.image.ImageResourceKt;
import com.bilibili.compose.image.BiliImageKt;
import com.bilibili.compose.image.BiliImageState;
import com.google.accompanist.drawablepainter.DrawablePainterKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefineKt;

/* compiled from: ImageBox.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0007\u001a\u00020\b*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a!\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010\u000f\u001a\u0016\u0010\u0010\u001a\u00020\u0005*\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002\u001a\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0003¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"ImageBox", "", "image", "Lcom/bilibili/app/comm/list/widget/image/ImageResource;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/bilibili/app/comm/list/widget/image/ImageResource;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "applyAlpha", "Landroidx/compose/ui/graphics/Color;", "alpha", "", "applyAlpha-DxMtmZc", "(JF)J", "getPainter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Lcom/bilibili/app/comm/list/widget/image/ImageResource;FLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "addModifier", "getColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Lcom/bilibili/app/comm/list/widget/image/ImageResource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/ColorFilter;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ImageBoxKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageBox$lambda$6(ImageResource imageResource, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ImageBox(imageResource, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ImageBox(final ImageResource image, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Uri uri;
        Intrinsics.checkNotNullParameter(image, "image");
        Composer $composer3 = $composer.startRestartGroup(-1290932216);
        ComposerKt.sourceInformation($composer3, "C(ImageBox)N(image,modifier)41@1501L57,44@1605L45,48@1670L106,72@2325L1640,67@2085L1880:ImageBox.kt#wiutlo");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(image) ? 4 : 2;
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
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1290932216, $dirty2, -1, "tv.danmaku.bili.ui.main2.mine.widgets.ImageBox (ImageBox.kt:30)");
            }
            ImageResource actual = ImageResourceKt.flatten(image);
            if (actual instanceof ImageResource.TransparentImage) {
                actual = ((ImageResource.TransparentImage) actual).getImage();
            }
            final ImageResource flatten = actual;
            final float alpha = ImageResourceKt.getAlpha(flatten);
            ComposerKt.sourceInformationMarkerStart($composer3, 659699585, "CC(remember):ImageBox.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(TuplesKt.to(flatten, Float.valueOf(alpha)), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState last = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 659702901, "CC(remember):ImageBox.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                MutableState mutableStateOf$default = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(mutableStateOf$default);
                it$iv2 = mutableStateOf$default;
            }
            final MutableState lastPainter = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 659705042, "CC(remember):ImageBox.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(image);
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
                boolean invalid$iv2 = flatten instanceof ImageResource.NetImage;
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(invalid$iv2 && !Intrinsics.areEqual(last.getValue(), flatten)), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv2);
                it$iv3 = value$iv2;
            }
            final MutableState toDelay = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (((Boolean) toDelay.getValue()).booleanValue()) {
                $composer3.startReplaceGroup(-1023848705);
                ComposerKt.sourceInformation($composer3, "53@1840L110,53@1811L139");
                ComposerKt.sourceInformationMarkerStart($composer3, 659710486, "CC(remember):ImageBox.kt#9igjgp");
                boolean invalid$iv3 = $composer3.changed(toDelay) | $composer3.changedInstance(flatten) | $composer3.changed(alpha);
                Object it$iv4 = $composer3.rememberedValue();
                if (invalid$iv3 || it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = (Function2) new ImageBoxKt$ImageBox$1$1(toDelay, last, flatten, alpha, null);
                    $composer3.updateRememberedValue(value$iv3);
                    it$iv4 = value$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(image, (Function2) it$iv4, $composer3, $dirty2 & 14);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(-1023691318);
                ComposerKt.sourceInformation($composer3, "59@1983L53,59@1972L64");
                ComposerKt.sourceInformationMarkerStart($composer3, 659715005, "CC(remember):ImageBox.kt#9igjgp");
                boolean invalid$iv4 = $composer3.changedInstance(flatten) | $composer3.changed(alpha);
                Object it$iv5 = $composer3.rememberedValue();
                if (invalid$iv4 || it$iv5 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = new Function0() { // from class: tv.danmaku.bili.ui.main2.mine.widgets.ImageBoxKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit ImageBox$lambda$4$0;
                            ImageBox$lambda$4$0 = ImageBoxKt.ImageBox$lambda$4$0(last, flatten, alpha);
                            return ImageBox$lambda$4$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv4);
                    it$iv5 = value$iv4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.SideEffect((Function0) it$iv5, $composer3, 0);
                $composer3.endReplaceGroup();
            }
            ImageResource.NetImage netImage = flatten instanceof ImageResource.NetImage ? (ImageResource.NetImage) flatten : null;
            String uri2 = (netImage == null || (uri = netImage.getUri()) == null) ? null : uri.toString();
            String str = uri2 == null ? "" : uri2;
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null);
            ImageResource.NetImage netImage2 = flatten instanceof ImageResource.NetImage ? (ImageResource.NetImage) flatten : null;
            final Modifier modifier4 = modifier3;
            Modifier modifier5 = modifier3;
            $composer2 = $composer3;
            BiliImageKt.BiliImage(str, fillMaxSize$default, false, 0, netImage2 != null ? netImage2.getStyle() : null, false, ComposableLambdaKt.rememberComposableLambda(2005467720, true, new Function3() { // from class: tv.danmaku.bili.ui.main2.mine.widgets.ImageBoxKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ImageBox$lambda$5;
                    ImageBox$lambda$5 = ImageBoxKt.ImageBox$lambda$5(alpha, toDelay, flatten, modifier4, image, lastPainter, last, (BiliImageState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ImageBox$lambda$5;
                }
            }, $composer3, 54), $composer2, 1573248, 40);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier5;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.main2.mine.widgets.ImageBoxKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ImageBox$lambda$6;
                    ImageBox$lambda$6 = ImageBoxKt.ImageBox$lambda$6(image, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ImageBox$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageBox$lambda$4$0(MutableState $last, ImageResource $flatten, float $alpha) {
        $last.setValue(TuplesKt.to($flatten, Float.valueOf($alpha)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageBox$lambda$5(float $alpha, MutableState $toDelay, ImageResource $flatten, Modifier $modifier, ImageResource $image, final MutableState $lastPainter, MutableState $last, BiliImageState it, Composer $composer, int $changed) {
        final Painter painter;
        String str;
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it):ImageBox.kt#wiutlo");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer.changed(it) : $composer.changedInstance(it) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2005467720, $dirty2, -1, "tv.danmaku.bili.ui.main2.mine.widgets.ImageBox.<anonymous> (ImageBox.kt:73)");
            }
            if (it.getSucceed()) {
                $composer.startReplaceGroup(1893797943);
                ComposerKt.sourceInformation($composer, "74@2379L47,75@2439L238,82@2701L59,82@2690L70");
                final Painter painter2 = DrawablePainterKt.rememberDrawablePainter(it.getDrawable(), $composer, 0);
                ImageKt.Image(painter2, BusinessSplashDefineKt.SPLASH_OPEN_EVENT_BACKGROUND, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment) null, ContentScale.Companion.getCrop(), $alpha, (ColorFilter) null, $composer, Painter.$stable | 25008, 72);
                ComposerKt.sourceInformationMarkerStart($composer, -1185824893, "CC(remember):ImageBox.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance(painter2);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: tv.danmaku.bili.ui.main2.mine.widgets.ImageBoxKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            Unit ImageBox$lambda$5$0$0;
                            ImageBox$lambda$5$0$0 = ImageBoxKt.ImageBox$lambda$5$0$0($lastPainter, painter2);
                            return ImageBox$lambda$5$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                EffectsKt.SideEffect((Function0) it$iv, $composer, 0);
                $composer.endReplaceGroup();
            } else if (it.getError() || !((Boolean) $toDelay.getValue()).booleanValue()) {
                $composer.startReplaceGroup(1894260711);
                ComposerKt.sourceInformation($composer, "86@2841L42,97@3307L59,97@3296L70");
                Painter painter3 = getPainter($flatten, $alpha, $composer, 0);
                if (painter3 != null) {
                    $composer.startReplaceGroup(1894357772);
                    ComposerKt.sourceInformation($composer, "94@3221L29,88@2935L334");
                    painter = painter3;
                    str = "CC(remember):ImageBox.kt#9igjgp";
                    ImageKt.Image(painter3, BusinessSplashDefineKt.SPLASH_OPEN_EVENT_BACKGROUND, addModifier($modifier, $flatten), (Alignment) null, ContentScale.Companion.getCrop(), $alpha, getColorFilter($image, $composer, 0), $composer, Painter.$stable | 24624, 8);
                } else {
                    painter = painter3;
                    str = "CC(remember):ImageBox.kt#9igjgp";
                    $composer.startReplaceGroup(1891451770);
                }
                $composer.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart($composer, -1185805501, str);
                boolean invalid$iv2 = $composer.changedInstance(painter);
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: tv.danmaku.bili.ui.main2.mine.widgets.ImageBoxKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit ImageBox$lambda$5$1$0;
                            ImageBox$lambda$5$1$0 = ImageBoxKt.ImageBox$lambda$5$1$0($lastPainter, painter);
                            return ImageBox$lambda$5$1$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                EffectsKt.SideEffect((Function0) it$iv2, $composer, 0);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(1894825593);
                ComposerKt.sourceInformation($composer, "");
                Painter painter4 = (Painter) $lastPainter.getValue();
                if (painter4 == null) {
                    $composer.startReplaceGroup(-1185800409);
                    ComposerKt.sourceInformation($composer, "102@3466L63");
                    painter4 = getPainter((ImageResource) ((Pair) $last.getValue()).getFirst(), ((Number) ((Pair) $last.getValue()).getSecond()).floatValue(), $composer, 0);
                } else {
                    $composer.startReplaceGroup(-1185801060);
                }
                $composer.endReplaceGroup();
                Painter painter5 = painter4;
                if (painter5 != null) {
                    $composer.startReplaceGroup(1894999224);
                    ComposerKt.sourceInformation($composer, "110@3876L40,104@3581L354");
                    ImageKt.Image(painter5, BusinessSplashDefineKt.SPLASH_OPEN_EVENT_BACKGROUND, addModifier($modifier, (ImageResource) ((Pair) $last.getValue()).getFirst()), (Alignment) null, ContentScale.Companion.getCrop(), $alpha, getColorFilter((ImageResource) ((Pair) $last.getValue()).getFirst(), $composer, 0), $composer, Painter.$stable | 24624, 8);
                } else {
                    $composer.startReplaceGroup(1891451770);
                }
                $composer.endReplaceGroup();
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageBox$lambda$5$0$0(MutableState $lastPainter, Painter $painter) {
        $lastPainter.setValue($painter);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageBox$lambda$5$1$0(MutableState $lastPainter, Painter $painter) {
        $lastPainter.setValue($painter);
        return Unit.INSTANCE;
    }

    /* renamed from: applyAlpha-DxMtmZc  reason: not valid java name */
    private static final long m2119applyAlphaDxMtmZc(long j, float alpha) {
        return ((float) 1) - alpha < 1.0E-4f ? j : Color.copy-wmQWz5c$default(j, Color.getAlpha-impl(j) * alpha, 0.0f, 0.0f, 0.0f, 14, (Object) null);
    }

    private static final Painter getPainter(ImageResource image, float alpha, Composer $composer, int $changed) {
        Painter painter;
        ComposerKt.sourceInformationMarkerStart($composer, 1252246395, "C(getPainter)N(image,alpha):ImageBox.kt#wiutlo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1252246395, $changed, -1, "tv.danmaku.bili.ui.main2.mine.widgets.getPainter (ImageBox.kt:120)");
        }
        if (image instanceof ImageResource.LocalResource) {
            $composer.startReplaceGroup(817946973);
            ComposerKt.sourceInformation($composer, "122@4237L34");
            painter = PainterResources_androidKt.painterResource(((ImageResource.LocalResource) image).unbox-impl(), $composer, 0);
            $composer.endReplaceGroup();
        } else if (image instanceof ImageResource.PureColor) {
            $composer.startReplaceGroup(817949325);
            $composer.endReplaceGroup();
            painter = (Painter) new ColorPainter(m2119applyAlphaDxMtmZc(ColorKt.Color(((ImageResource.PureColor) image).getColor()), alpha), (DefaultConstructorMarker) null);
        } else if (image instanceof ImageResource.ShapeColor) {
            $composer.startReplaceGroup(817952188);
            ComposerKt.sourceInformation($composer, "124@4400L33");
            painter = PainterResources_androidKt.painterResource(((ImageResource.ShapeColor) image).getShape(), $composer, 0);
            $composer.endReplaceGroup();
        } else if (image instanceof ImageResource.NetImage) {
            $composer.startReplaceGroup(817955415);
            ComposerKt.sourceInformation($composer, "126@4500L60");
            painter = getPainter(((ImageResource.NetImage) image).getPlaceholderResource(), alpha, $composer, $changed & BR.containerVisible);
            $composer.endReplaceGroup();
        } else if (!(image instanceof ImageResource.TransparentImage) && image != null) {
            $composer.startReplaceGroup(817945565);
            $composer.endReplaceGroup();
            throw new NoWhenBranchMatchedException();
        } else {
            $composer.startReplaceGroup(-413068606);
            $composer.endReplaceGroup();
            painter = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return painter;
    }

    private static final Modifier addModifier(Modifier $this$addModifier, ImageResource image) {
        if ((image instanceof ImageResource.ShapeColor) || (image instanceof ImageResource.LocalResource)) {
            return SizeKt.fillMaxSize$default($this$addModifier, 0.0f, 1, (Object) null);
        }
        if (image instanceof ImageResource.PureColor) {
            return SizeKt.fillMaxSize$default(ClipKt.clip($this$addModifier, RoundedCornerShapeKt.RoundedCornerShape(((ImageResource.PureColor) image).getCorner())), 0.0f, 1, (Object) null);
        }
        if (!(image instanceof ImageResource.TransparentImage) && !(image instanceof ImageResource.NetImage) && image != null) {
            throw new NoWhenBranchMatchedException();
        }
        return $this$addModifier;
    }

    private static final ColorFilter getColorFilter(ImageResource image, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -191136981, "C(getColorFilter)N(image):ImageBox.kt#wiutlo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-191136981, $changed, -1, "tv.danmaku.bili.ui.main2.mine.widgets.getColorFilter (ImageBox.kt:145)");
        }
        ColorFilter colorFilter = image instanceof ImageResource.ShapeColor ? ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, ColorKt.Color(((ImageResource.ShapeColor) image).getColor()), 0, 2, (Object) null) : null;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return colorFilter;
    }
}