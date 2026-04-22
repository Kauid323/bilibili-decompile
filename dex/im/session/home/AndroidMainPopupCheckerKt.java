package im.session.home;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

/* compiled from: AndroidMainPopupChecker.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"rememberMainPopupChecker", "Lim/session/home/MainPopupChecker;", "(Landroidx/compose/runtime/Composer;I)Lim/session/home/MainPopupChecker;", "session-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AndroidMainPopupCheckerKt {
    public static final MainPopupChecker rememberMainPopupChecker(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 885218553, "C(rememberMainPopupChecker)20@618L7,21@648L92,22@752L87:AndroidMainPopupChecker.kt#kfobb3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(885218553, $changed, -1, "im.session.home.rememberMainPopupChecker (AndroidMainPopupChecker.kt:19)");
        }
        CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Context context = (Context) consume;
        ComposerKt.sourceInformationMarkerStart($composer, 291508501, "CC(remember):AndroidMainPopupChecker.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
            Object value$iv = ((MainPopupCheckerModule) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(MainPopupCheckerModule.class))).getMainPopupChecker();
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        AndroidMainPopupChecker androidImpl = (AndroidMainPopupChecker) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 291511824, "CC(remember):AndroidMainPopupChecker.kt#9igjgp");
        boolean invalid$iv = $composer.changed(context);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = new AndroidMainPopupCheckerDelegate(context, androidImpl);
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        AndroidMainPopupCheckerDelegate androidMainPopupCheckerDelegate = (AndroidMainPopupCheckerDelegate) it$iv2;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return androidMainPopupCheckerDelegate;
    }
}