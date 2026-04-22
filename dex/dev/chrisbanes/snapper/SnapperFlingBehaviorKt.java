package dev.chrisbanes.snapper;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import io.ktor.http.ContentDisposition;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnapperFlingBehavior.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0087\b¢\u0006\u0002\u0010\t\u001aK\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u000bH\u0007¢\u0006\u0002\u0010\f\u001as\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2<\u0010\r\u001a8\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"rememberSnapperFlingBehavior", "Ldev/chrisbanes/snapper/SnapperFlingBehavior;", "layoutInfo", "Ldev/chrisbanes/snapper/SnapperLayoutInfo;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "springAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Ldev/chrisbanes/snapper/SnapperLayoutInfo;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Ldev/chrisbanes/snapper/SnapperFlingBehavior;", "maximumFlingDistance", "Lkotlin/Function1;", "(Ldev/chrisbanes/snapper/SnapperLayoutInfo;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Ldev/chrisbanes/snapper/SnapperFlingBehavior;", "snapIndex", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", ContentDisposition.Parameters.Name, "startIndex", "targetIndex", "(Ldev/chrisbanes/snapper/SnapperLayoutInfo;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Ldev/chrisbanes/snapper/SnapperFlingBehavior;", "lib_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SnapperFlingBehaviorKt {
    public static final SnapperFlingBehavior rememberSnapperFlingBehavior(SnapperLayoutInfo layoutInfo, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec, Function3<? super SnapperLayoutInfo, ? super Integer, ? super Integer, Integer> function3, Composer $composer, int $changed, int i2) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(layoutInfo, "layoutInfo");
        Intrinsics.checkNotNullParameter(function3, "snapIndex");
        $composer.startReplaceableGroup(-632874525);
        ComposerKt.sourceInformation($composer, "C(rememberSnapperFlingBehavior)P(1!1,3)");
        int i3 = 0;
        if ((i2 & 2) != 0) {
            decayAnimationSpec = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay($composer, 0);
        }
        if ((i2 & 4) != 0) {
            animationSpec = SnapperFlingBehaviorDefaults.INSTANCE.getSpringAnimationSpec();
        }
        Object[] keys$iv = {layoutInfo, decayAnimationSpec, animationSpec, function3};
        $composer.startReplaceableGroup(-3685570);
        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        int length = keys$iv.length;
        while (i3 < length) {
            Object key$iv = keys$iv[i3];
            i3++;
            invalid$iv |= $composer.changed(key$iv);
        }
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = new SnapperFlingBehavior(layoutInfo, decayAnimationSpec, animationSpec, function3);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        SnapperFlingBehavior snapperFlingBehavior = (SnapperFlingBehavior) value$iv$iv;
        $composer.endReplaceableGroup();
        return snapperFlingBehavior;
    }

    public static final SnapperFlingBehavior rememberSnapperFlingBehavior(SnapperLayoutInfo layoutInfo, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec, Composer $composer, int $changed, int i2) {
        Intrinsics.checkNotNullParameter(layoutInfo, "layoutInfo");
        $composer.startReplaceableGroup(-632873455);
        ComposerKt.sourceInformation($composer, "C(rememberSnapperFlingBehavior)P(1)");
        if ((i2 & 2) != 0) {
            decayAnimationSpec = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay($composer, 0);
        }
        if ((i2 & 4) != 0) {
            animationSpec = SnapperFlingBehaviorDefaults.INSTANCE.getSpringAnimationSpec();
        }
        SnapperFlingBehavior rememberSnapperFlingBehavior = rememberSnapperFlingBehavior(layoutInfo, decayAnimationSpec, animationSpec, SnapperFlingBehaviorDefaults.INSTANCE.getSnapIndex(), $composer, ($changed & 14) | 576, 0);
        $composer.endReplaceableGroup();
        return rememberSnapperFlingBehavior;
    }

    @Deprecated(message = "The maximumFlingDistance parameter has been replaced with snapIndex")
    public static final SnapperFlingBehavior rememberSnapperFlingBehavior(SnapperLayoutInfo layoutInfo, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec, Function1<? super SnapperLayoutInfo, Float> function1, Composer $composer, int $changed, int i2) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(layoutInfo, "layoutInfo");
        $composer.startReplaceableGroup(-632871981);
        ComposerKt.sourceInformation($composer, "C(rememberSnapperFlingBehavior)P(1!1,3)");
        int i3 = 0;
        if ((i2 & 2) != 0) {
            decayAnimationSpec = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay($composer, 0);
        }
        if ((i2 & 4) != 0) {
            animationSpec = SnapperFlingBehaviorDefaults.INSTANCE.getSpringAnimationSpec();
        }
        if ((i2 & 8) != 0) {
            function1 = SnapperFlingBehaviorDefaults.INSTANCE.getMaximumFlingDistance();
        }
        Object[] keys$iv = {layoutInfo, decayAnimationSpec, animationSpec, function1};
        $composer.startReplaceableGroup(-3685570);
        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        int length = keys$iv.length;
        while (i3 < length) {
            Object key$iv = keys$iv[i3];
            i3++;
            invalid$iv |= $composer.changed(key$iv);
        }
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = new SnapperFlingBehavior(layoutInfo, decayAnimationSpec, animationSpec, function1);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        SnapperFlingBehavior snapperFlingBehavior = (SnapperFlingBehavior) value$iv$iv;
        $composer.endReplaceableGroup();
        return snapperFlingBehavior;
    }
}