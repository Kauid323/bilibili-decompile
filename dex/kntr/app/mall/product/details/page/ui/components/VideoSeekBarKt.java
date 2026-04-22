package kntr.app.mall.product.details.page.ui.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.SliderDefaults;
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.SliderState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.utils.HelperKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: VideoSeekBar.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0081\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"VideoSeekBar", "", "progress", "", "onChange", "Lkotlin/Function1;", "onSeekFinish", "Lkotlin/Function0;", "thumbImg", "", "scale", "trackHeight", "Landroidx/compose/ui/unit/Dp;", "thumbSize", "modifier", "Landroidx/compose/ui/Modifier;", "activeColor", "Landroidx/compose/ui/graphics/Color;", "inactiveColor", "enabled", "", "VideoSeekBar-BE8BMqc", "(FLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Ljava/lang/String;FFFLandroidx/compose/ui/Modifier;JJZLandroidx/compose/runtime/Composer;III)V", "product-details-page_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class VideoSeekBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoSeekBar_BE8BMqc$lambda$2(float f, Function1 function1, Function0 function0, String str, float f2, float f3, float f4, Modifier modifier, long j, long j2, boolean z, int i, int i2, int i3, Composer composer, int i4) {
        m543VideoSeekBarBE8BMqc(f, function1, function0, str, f2, f3, f4, modifier, j, j2, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* renamed from: VideoSeekBar-BE8BMqc  reason: not valid java name */
    public static final void m543VideoSeekBarBE8BMqc(final float progress, final Function1<? super Float, Unit> function1, final Function0<Unit> function0, final String thumbImg, final float scale, final float f, final float f2, Modifier modifier, long j, long j2, boolean enabled, Composer $composer, final int $changed, final int $changed1, final int i) {
        Composer $composer2;
        Modifier modifier2;
        long j3;
        long j4;
        boolean enabled2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(function1, "onChange");
        Intrinsics.checkNotNullParameter(function0, "onSeekFinish");
        Intrinsics.checkNotNullParameter(thumbImg, "thumbImg");
        Composer $composer3 = $composer.startRestartGroup(-1599189989);
        ComposerKt.sourceInformation($composer3, "C(VideoSeekBar)N(progress,onChange,onSeekFinish,thumbImg,scale,trackHeight:c#ui.unit.Dp,thumbSize:c#ui.unit.Dp,modifier,activeColor:c#ui.graphics.Color,inactiveColor:c#ui.graphics.Color,enabled)49@1784L216,56@2047L347,68@2437L691,37@1376L1786:VideoSeekBar.kt#o90vz8");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(progress) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(thumbImg) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changed(scale) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changed(f) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer3.changed(f2) ? 1048576 : 524288;
        }
        int i2 = i & 128;
        if (i2 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changed(modifier) ? 8388608 : 4194304;
        }
        int i3 = i & 256;
        if (i3 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer3.changed(j) ? 67108864 : 33554432;
        }
        int i4 = i & 512;
        if (i4 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer3.changed(j2) ? 536870912 : 268435456;
        }
        int i5 = i & 1024;
        if (i5 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer3.changed(enabled) ? 4 : 2;
        }
        if ($composer3.shouldExecute((($dirty & 306783379) == 306783378 && ($dirty1 & 3) == 2) ? false : true, $dirty & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier;
            }
            if (i3 == 0) {
                j3 = j;
            } else {
                j3 = ColorKt.Color(4294924943L);
            }
            if (i4 == 0) {
                j4 = j2;
            } else {
                j4 = ColorKt.Color(4294967295L);
            }
            if (i5 == 0) {
                enabled2 = enabled;
            } else {
                enabled2 = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1599189989, $dirty, $dirty1, "kntr.app.mall.product.details.page.ui.components.VideoSeekBar (VideoSeekBar.kt:36)");
            }
            Modifier modifier4 = modifier3;
            final long j5 = j3;
            final long j6 = j4;
            $composer2 = $composer3;
            SliderKt.Slider(RangesKt.coerceIn(progress, 0.0f, 1.0f), function1, SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), Dp.constructor-impl(Math.max(f, f2))), enabled2, function0, SliderDefaults.INSTANCE.colors-q0g_0yA(Color.Companion.getTransparent-0d7_KjU(), j3, 0L, j4, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, (($dirty >> 21) & 112) | 6 | (($dirty >> 18) & 7168), 6, 1012), (MutableInteractionSource) null, 0, ComposableLambdaKt.rememberComposableLambda(1650499415, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.components.VideoSeekBarKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit VideoSeekBar_BE8BMqc$lambda$0;
                    VideoSeekBar_BE8BMqc$lambda$0 = VideoSeekBarKt.VideoSeekBar_BE8BMqc$lambda$0(scale, thumbImg, f2, (SliderState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return VideoSeekBar_BE8BMqc$lambda$0;
                }
            }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(-2065701736, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.components.VideoSeekBarKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit VideoSeekBar_BE8BMqc$lambda$1;
                    VideoSeekBar_BE8BMqc$lambda$1 = VideoSeekBarKt.VideoSeekBar_BE8BMqc$lambda$1(f, scale, j5, j6, (SliderState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return VideoSeekBar_BE8BMqc$lambda$1;
                }
            }, $composer3, 54), RangesKt.rangeTo(0.0f, 1.0f), $composer2, ($dirty & 112) | 905969664 | (($dirty1 << 9) & 7168) | (($dirty << 6) & 57344), 0, 192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            j3 = j;
            j4 = j2;
            enabled2 = enabled;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            final long j7 = j3;
            final long j8 = j4;
            final boolean z = enabled2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.VideoSeekBarKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit VideoSeekBar_BE8BMqc$lambda$2;
                    VideoSeekBar_BE8BMqc$lambda$2 = VideoSeekBarKt.VideoSeekBar_BE8BMqc$lambda$2(progress, function1, function0, thumbImg, scale, f, f2, modifier5, j7, j8, z, $changed, $changed1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return VideoSeekBar_BE8BMqc$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoSeekBar_BE8BMqc$lambda$0(float $scale, String $thumbImg, float f, SliderState it, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)57@2061L323:VideoSeekBar.kt#o90vz8");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1650499415, $changed, -1, "kntr.app.mall.product.details.page.ui.components.VideoSeekBar.<anonymous> (VideoSeekBar.kt:57)");
            }
            Modifier modifier$iv = SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(20, $scale));
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
            ComposerKt.sourceInformationMarkerStart($composer, -97343851, "C61@2213L157:VideoSeekBar.kt#o90vz8");
            String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl($thumbImg);
            BiliImageKt.BiliImage(new ImageRequest($this$asRequest_u24default$iv).build(), SizeKt.size-3ABfNKs(Modifier.Companion, f), null, null, null, null, null, null, null, $composer, 0, 508);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoSeekBar_BE8BMqc$lambda$1(float f, float $scale, long j, long j2, SliderState sliderState, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(sliderState, "sliderState");
        ComposerKt.sourceInformation($composer, "CN(sliderState)77@2802L145,69@2481L637:VideoSeekBar.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer.changed(sliderState) : $composer.changedInstance(sliderState) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2065701736, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.VideoSeekBar.<anonymous> (VideoSeekBar.kt:69)");
            }
            SliderDefaults.INSTANCE.Track-4EFweAY(sliderState, ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), f), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(1, $scale))), false, SliderDefaults.INSTANCE.colors-q0g_0yA(0L, j, 0L, j2, 0L, 0L, 0L, 0L, 0L, 0L, $composer, 0, 6, 1013), (Function2) null, (Function3) null, ProvideUiScaleKt.dpScaled(0, $scale), ProvideUiScaleKt.dpScaled(0, $scale), $composer, 100687872 | SliderState.$stable | ($dirty2 & 14), 36);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}