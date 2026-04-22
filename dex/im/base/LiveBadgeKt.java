package im.base;

import androidx.compose.foundation.ImageKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* compiled from: LiveBadge.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u001a-\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0017\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\f\u0010\r\"\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013\"\u000e\u0010\u0014\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"LiveIcon", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "startPlay", "", "LiveIcon-3IgeMak", "(Landroidx/compose/ui/Modifier;JZLandroidx/compose/runtime/Composer;II)V", "rememberLiveIconPainter", "Lim/base/LiveIconPainter;", "rememberLiveIconPainter-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)Lim/base/LiveIconPainter;", "FRAME_COUNT", "", "FRAME_PER_SECOND", "frameDuration", "Lkotlin/time/Duration;", "J", "MAX_HEIGHT_MULTIPLE", "", "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class LiveBadgeKt {
    private static final int FRAME_COUNT = 20;
    private static final int FRAME_PER_SECOND = 30;
    private static final float MAX_HEIGHT_MULTIPLE = 2.3333f;
    private static final long frameDuration;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LiveIcon_3IgeMak$lambda$1(Modifier modifier, long j, boolean z, int i2, int i3, Composer composer, int i4) {
        m3094LiveIcon3IgeMak(modifier, j, z, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* renamed from: LiveIcon-3IgeMak  reason: not valid java name */
    public static final void m3094LiveIcon3IgeMak(Modifier modifier, long j, boolean startPlay, Composer $composer, final int $changed, final int i2) {
        Modifier modifier2;
        long j2;
        boolean startPlay2;
        long j3;
        Modifier modifier3;
        Modifier modifier4;
        long j4;
        boolean startPlay3;
        Modifier modifier5;
        Composer $composer2 = $composer.startRestartGroup(-559140325);
        ComposerKt.sourceInformation($composer2, "C(LiveIcon)N(modifier,color:c#ui.graphics.Color,startPlay)28@986L30,29@1021L70,30@1128L73,30@1096L105:LiveBadge.kt#uu6lp7");
        int $dirty = $changed;
        int i3 = i2 & 1;
        if (i3 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            $dirty |= 48;
            j2 = j;
        } else if (($changed & 48) == 0) {
            j2 = j;
            $dirty |= $composer2.changed(j2) ? 32 : 16;
        } else {
            j2 = j;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            $dirty |= 384;
            startPlay2 = startPlay;
        } else if (($changed & 384) == 0) {
            startPlay2 = startPlay;
            $dirty |= $composer2.changed(startPlay2) ? 256 : 128;
        } else {
            startPlay2 = startPlay;
        }
        if (!$composer2.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            j3 = j2;
            modifier3 = modifier2;
        } else {
            if (i3 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i4 == 0) {
                j4 = j2;
            } else {
                j4 = Color.Companion.getWhite-0d7_KjU();
            }
            if (i5 == 0) {
                startPlay3 = startPlay2;
            } else {
                startPlay3 = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-559140325, $dirty, -1, "im.base.LiveIcon (LiveBadge.kt:27)");
            }
            LiveIconPainter painter = m3095rememberLiveIconPainterek8zF_U(j4, $composer2, ($dirty >> 3) & 14);
            ImageKt.Image(painter, "", modifier4, (Alignment) null, (ContentScale) null, (float) CropImageView.DEFAULT_ASPECT_RATIO, (ColorFilter) null, $composer2, (($dirty << 6) & 896) | 48, (int) TbsListener.ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR);
            Unit unit = Unit.INSTANCE;
            Boolean valueOf = Boolean.valueOf(startPlay3);
            ComposerKt.sourceInformationMarkerStart($composer2, -462931420, "CC(remember):LiveBadge.kt#9igjgp");
            boolean invalid$iv = (($dirty & 896) == 256) | $composer2.changed(painter);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                modifier5 = modifier4;
                j3 = j4;
                Object value$iv = (Function2) new LiveBadgeKt$LiveIcon$1$1(startPlay3, painter, null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            } else {
                modifier5 = modifier4;
                j3 = j4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, valueOf, (Function2) it$iv, $composer2, (($dirty >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
            startPlay2 = startPlay3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final long j5 = j3;
            final boolean z = startPlay2;
            endRestartGroup.updateScope(new Function2() { // from class: im.base.LiveBadgeKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit LiveIcon_3IgeMak$lambda$1;
                    LiveIcon_3IgeMak$lambda$1 = LiveBadgeKt.LiveIcon_3IgeMak$lambda$1(modifier6, j5, z, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return LiveIcon_3IgeMak$lambda$1;
                }
            });
        }
    }

    /* renamed from: rememberLiveIconPainter-ek8zF_U  reason: not valid java name */
    public static final LiveIconPainter m3095rememberLiveIconPainterek8zF_U(long j, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 43285584, "C(rememberLiveIconPainter)N(color:c#ui.graphics.Color)39@1282L54:LiveBadge.kt#uu6lp7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(43285584, $changed, -1, "im.base.rememberLiveIconPainter (LiveBadge.kt:39)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -1352224602, "CC(remember):LiveBadge.kt#9igjgp");
        boolean invalid$iv = ((($changed & 14) ^ 6) > 4 && $composer.changed(j)) || ($changed & 6) == 4;
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new LiveIconPainter(j, null);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        LiveIconPainter liveIconPainter = (LiveIconPainter) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return liveIconPainter;
    }

    static {
        Duration.Companion companion = Duration.Companion;
        frameDuration = Duration.div-UwyO8pc(DurationKt.toDuration(1, DurationUnit.SECONDS), 30);
    }
}