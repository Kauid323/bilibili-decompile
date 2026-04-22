package kntr.app.ad.ui.uikit.components;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.DrawableResource;
import org.jetbrains.compose.resources.ImageResourcesKt;

/* compiled from: AdFrameAnimation.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\u001a;\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u008e\u0002"}, d2 = {"AdFrameAnimation", RoomRecommendViewModel.EMPTY_CURSOR, "frameImages", RoomRecommendViewModel.EMPTY_CURSOR, "Lorg/jetbrains/compose/resources/DrawableResource;", "modifier", "Landroidx/compose/ui/Modifier;", "frameDuration", RoomRecommendViewModel.EMPTY_CURSOR, "size", "Landroidx/compose/ui/unit/Dp;", "AdFrameAnimation--jt2gSs", "(Ljava/util/List;Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "uikit_debug", "currentFrame", RoomRecommendViewModel.EMPTY_CURSOR}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AdFrameAnimationKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdFrameAnimation__jt2gSs$lambda$4(List list, Modifier modifier, long j2, float f, int i, int i2, Composer composer, int i3) {
        m481AdFrameAnimationjt2gSs(list, modifier, j2, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* renamed from: AdFrameAnimation--jt2gSs  reason: not valid java name */
    public static final void m481AdFrameAnimationjt2gSs(final List<DrawableResource> list, Modifier modifier, long frameDuration, float f, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j2;
        float f2;
        long frameDuration2;
        Modifier modifier3;
        Modifier modifier4;
        float f3;
        Intrinsics.checkNotNullParameter(list, "frameImages");
        Composer $composer2 = $composer.startRestartGroup(1251126632);
        ComposerKt.sourceInformation($composer2, "C(AdFrameAnimation)N(frameImages,modifier,frameDuration,size:c#ui.unit.Dp)24@835L33,27@908L138,27@887L159,34@1076L53,33@1051L160:AdFrameAnimation.kt#oqm2gb");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
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
            j2 = frameDuration;
        } else if (($changed & 384) == 0) {
            j2 = frameDuration;
            $dirty |= $composer2.changed(j2) ? 256 : 128;
        } else {
            j2 = frameDuration;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            f2 = f;
        } else if (($changed & 3072) == 0) {
            f2 = f;
            $dirty |= $composer2.changed(f2) ? 2048 : 1024;
        } else {
            f2 = f;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                frameDuration2 = j2;
            } else {
                frameDuration2 = 125;
            }
            if (i4 == 0) {
                f3 = f2;
            } else {
                f3 = Dp.constructor-impl(100);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1251126632, $dirty2, -1, "kntr.app.ad.ui.uikit.components.AdFrameAnimation (AdFrameAnimation.kt:23)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -258143703, "CC(remember):AdFrameAnimation.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotIntStateKt.mutableIntStateOf(0);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableIntState currentFrame$delegate = (MutableIntState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -258141262, "CC(remember):AdFrameAnimation.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 896) == 256) | $composer2.changedInstance(list);
            Object value$iv2 = $composer2.rememberedValue();
            if (invalid$iv || value$iv2 == Composer.Companion.getEmpty()) {
                value$iv2 = new AdFrameAnimationKt$AdFrameAnimation$1$1(frameDuration2, list, currentFrame$delegate, null);
                $composer2.updateRememberedValue(value$iv2);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) value$iv2, $composer2, 6);
            Modifier modifier5 = modifier4;
            ImageKt.Image(ImageResourcesKt.painterResource(list.get(AdFrameAnimation__jt2gSs$lambda$1(currentFrame$delegate)), $composer2, 0), (String) null, SizeKt.size-3ABfNKs(modifier4, f3), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer2, Painter.$stable | 48, 120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
            f2 = f3;
        } else {
            $composer2.skipToGroupEnd();
            frameDuration2 = j2;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final long j3 = frameDuration2;
            final float f4 = f2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.uikit.components.AdFrameAnimationKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit AdFrameAnimation__jt2gSs$lambda$4;
                    AdFrameAnimation__jt2gSs$lambda$4 = AdFrameAnimationKt.AdFrameAnimation__jt2gSs$lambda$4(list, modifier6, j3, f4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AdFrameAnimation__jt2gSs$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int AdFrameAnimation__jt2gSs$lambda$1(MutableIntState $currentFrame$delegate) {
        IntState $this$getValue$iv = (IntState) $currentFrame$delegate;
        return $this$getValue$iv.getIntValue();
    }
}