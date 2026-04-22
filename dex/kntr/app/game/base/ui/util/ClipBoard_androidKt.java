package kntr.app.game.base.ui.util;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;

/* compiled from: ClipBoard.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000f\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"rememberAndroidClipboardManager", "Lkntr/app/game/base/ui/util/GameClipboardManager;", "(Landroidx/compose/runtime/Composer;I)Lkntr/app/game/base/ui/util/GameClipboardManager;", "rememberPlatformClipboardManager", "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ClipBoard_androidKt {
    public static final GameClipboardManager rememberAndroidClipboardManager(Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformationMarkerStart($composer, 1098809406, "C(rememberAndroidClipboardManager)32@999L7,33@1018L148:ClipBoard.android.kt#m4f0gv");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1098809406, $changed, -1, "kntr.app.game.base.ui.util.rememberAndroidClipboardManager (ClipBoard.android.kt:30)");
        }
        CompositionLocal this_$iv = CompositionLocalsKt.getLocalClipboardManager();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ClipboardManager context = (ClipboardManager) consume;
        ComposerKt.sourceInformationMarkerStart($composer, -606110670, "CC(remember):ClipBoard.android.kt#9igjgp");
        boolean invalid$iv = $composer.changed(context);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            try {
                obj = new AndroidClipboardManagerImpl(context);
            } catch (Exception e) {
                obj = null;
            }
            Object value$iv = obj;
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        AndroidClipboardManagerImpl androidClipboardManagerImpl = (AndroidClipboardManagerImpl) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return androidClipboardManagerImpl;
    }

    public static final GameClipboardManager rememberPlatformClipboardManager(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1457358628, "C(rememberPlatformClipboardManager)46@1301L33:ClipBoard.android.kt#m4f0gv");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1457358628, $changed, -1, "kntr.app.game.base.ui.util.rememberPlatformClipboardManager (ClipBoard.android.kt:46)");
        }
        GameClipboardManager rememberAndroidClipboardManager = rememberAndroidClipboardManager($composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return rememberAndroidClipboardManager;
    }
}