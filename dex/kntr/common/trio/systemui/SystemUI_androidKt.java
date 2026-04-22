package kntr.common.trio.systemui;

import android.view.Window;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import com.google.accompanist.systemuicontroller.SystemUiController;
import com.google.accompanist.systemuicontroller.SystemUiControllerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: SystemUI.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"rememberSystemUiController", "Lkntr/common/trio/systemui/SystemUiController;", "(Landroidx/compose/runtime/Composer;I)Lkntr/common/trio/systemui/SystemUiController;", "trio_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SystemUI_androidKt {
    public static final SystemUiController rememberSystemUiController(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 2032350064, "C(rememberSystemUiController)9@341L28,10@381L321:SystemUI.android.kt#kklx1l");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2032350064, $changed, -1, "kntr.common.trio.systemui.rememberSystemUiController (SystemUI.android.kt:8)");
        }
        final com.google.accompanist.systemuicontroller.SystemUiController systemUiController = SystemUiControllerKt.rememberSystemUiController((Window) null, $composer, 0, 1);
        ComposerKt.sourceInformationMarkerStart($composer, -1121703887, "CC(remember):SystemUI.android.kt#9igjgp");
        boolean invalid$iv = $composer.changed(systemUiController);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new SystemUiController() { // from class: kntr.common.trio.systemui.SystemUI_androidKt$rememberSystemUiController$1$1
                @Override // kntr.common.trio.systemui.SystemUiController
                public void setStatusBar(boolean darkIcons) {
                    SystemUiController.-CC.setSystemBarsColor-Iv8Zu3U$default(systemUiController, Color.Companion.getTransparent-0d7_KjU(), darkIcons, false, (Function1) null, 12, (Object) null);
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        SystemUI_androidKt$rememberSystemUiController$1$1 systemUI_androidKt$rememberSystemUiController$1$1 = (SystemUI_androidKt$rememberSystemUiController$1$1) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return systemUI_androidKt$rememberSystemUiController$1$1;
    }
}