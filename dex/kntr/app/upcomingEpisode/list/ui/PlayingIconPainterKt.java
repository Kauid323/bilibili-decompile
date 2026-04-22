package kntr.app.upcomingEpisode.list.ui;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: PlayingIconPainter.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a#\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0003¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"rememberPlayingIcon", "Lkntr/app/upcomingEpisode/list/ui/PlayingIconPainter;", "size", "Landroidx/compose/ui/unit/DpSize;", "key", "", "color", "Landroidx/compose/ui/graphics/Color;", "isLive", "", "rememberPlayingIcon-m3LR9pM", "(JLjava/lang/Object;JZLandroidx/compose/runtime/Composer;II)Lkntr/app/upcomingEpisode/list/ui/PlayingIconPainter;", "animePhase", "Landroidx/compose/runtime/State;", "", "start", "count", "(IILandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "main_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PlayingIconPainterKt {
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007b, code lost:
        if (r34.changed(r28) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0082, code lost:
        if ((r35 & 6) == 4) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0084, code lost:
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0085, code lost:
        r15 = (r6 | r34.changed(r3)) | r34.changed(r2);
        r11 = r34.rememberedValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009a, code lost:
        if (r15 != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a2, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ab, code lost:
        r8 = r2.toPx-0680j_4(androidx.compose.ui.unit.DpSize.getWidth-D9Ej5fM(r28));
        r0 = r2.toPx-0680j_4(androidx.compose.ui.unit.DpSize.getHeight-D9Ej5fM(r28));
        r0 = java.lang.Float.floatToRawIntBits(r8);
        r2 = java.lang.Float.floatToRawIntBits(r0);
        r11 = new kntr.app.upcomingEpisode.list.ui.PlayingIconPainter(androidx.compose.ui.geometry.Size.constructor-impl((r0 << 32) | (r2 & 4294967295L)), r9, r4, r14, null);
        r34.updateRememberedValue(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0101, code lost:
        r11 = (kntr.app.upcomingEpisode.list.ui.PlayingIconPainter) r11;
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r34);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x010b, code lost:
        if (androidx.compose.runtime.ComposerKt.isTraceInProgress() == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x010d, code lost:
        androidx.compose.runtime.ComposerKt.traceEventEnd();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0110, code lost:
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r34);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0113, code lost:
        return r11;
     */
    /* renamed from: rememberPlayingIcon-m3LR9pM  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final PlayingIconPainter m1239rememberPlayingIconm3LR9pM(long j, Object key, long j2, boolean isLive, Composer $composer, int $changed, int i) {
        Object key2;
        long j3;
        boolean isLive2;
        ComposerKt.sourceInformationMarkerStart($composer, -895927625, "C(rememberPlayingIcon)N(size:c#ui.unit.DpSize,key,color:c#ui.graphics.Color,isLive)37@1718L6,40@1821L7,42@1861L90,46@1963L316:PlayingIconPainter.kt#kr57tx");
        if ((i & 2) != 0) {
            key2 = Unit.INSTANCE;
        } else {
            key2 = key;
        }
        if ((i & 4) == 0) {
            j3 = j2;
        } else {
            j3 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU();
        }
        if ((i & 8) == 0) {
            isLive2 = isLive;
        } else {
            isLive2 = false;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-895927625, $changed, -1, "kntr.app.upcomingEpisode.list.ui.rememberPlayingIcon (PlayingIconPainter.kt:39)");
        }
        CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density = (Density) consume;
        boolean z = false;
        State phaseProvider = animePhase(0, 20, $composer, 54);
        ComposerKt.sourceInformationMarkerStart($composer, -1992977293, "CC(remember):PlayingIconPainter.kt#9igjgp");
        if ((($changed & 14) ^ 6) <= 4) {
        }
    }

    private static final State<Integer> animePhase(int start, final int count, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1357082989, "C(animePhase)N(start,count)64@2388L27,65@2449L509,65@2420L538,80@2970L112:PlayingIconPainter.kt#kr57tx");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1357082989, $changed, -1, "kntr.app.upcomingEpisode.list.ui.animePhase (PlayingIconPainter.kt:63)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -1513302808, "CC(remember):PlayingIconPainter.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        final Animatable animatable = (Animatable) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        Integer valueOf = Integer.valueOf(start);
        Integer valueOf2 = Integer.valueOf(count);
        ComposerKt.sourceInformationMarkerStart($composer, -1513300374, "CC(remember):PlayingIconPainter.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance(animatable) | (((($changed & 14) ^ 6) > 4 && $composer.changed(start)) || ($changed & 6) == 4) | (((($changed & 112) ^ 48) > 32 && $composer.changed(count)) || ($changed & 48) == 32);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = (Function2) new PlayingIconPainterKt$animePhase$1$1(animatable, start, count, null);
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(valueOf, valueOf2, (Function2) it$iv2, $composer, ($changed & 14) | ($changed & 112));
        ComposerKt.sourceInformationMarkerStart($composer, -1513284099, "CC(remember):PlayingIconPainter.kt#9igjgp");
        boolean invalid$iv2 = (((($changed & 14) ^ 6) > 4 && $composer.changed(start)) || ($changed & 6) == 4) | (((($changed & 112) ^ 48) > 32 && $composer.changed(count)) || ($changed & 48) == 32);
        Object it$iv3 = $composer.rememberedValue();
        if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
            Object value$iv3 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.upcomingEpisode.list.ui.PlayingIconPainterKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    int animePhase$lambda$2$0;
                    animePhase$lambda$2$0 = PlayingIconPainterKt.animePhase$lambda$2$0(animatable, count);
                    return Integer.valueOf(animePhase$lambda$2$0);
                }
            });
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
        }
        State<Integer> state = (State) it$iv3;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int animePhase$lambda$2$0(Animatable $animatable, int $count) {
        return (int) (((Number) $animatable.getValue()).floatValue() * $count);
    }
}