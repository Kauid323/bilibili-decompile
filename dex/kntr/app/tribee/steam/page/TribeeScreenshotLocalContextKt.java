package kntr.app.tribee.steam.page;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.activity.ComponentActivity;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.util.Iterator;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.screenshot.ScreenshotLocalContext;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* compiled from: TribeeScreenshotLocalContext.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002\u001a\r\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"findActivity", "Landroidx/activity/ComponentActivity;", "Landroid/content/Context;", "provideScreenLocalContext", "Lkntr/common/screenshot/ScreenshotLocalContext;", "(Landroidx/compose/runtime/Composer;I)Lkntr/common/screenshot/ScreenshotLocalContext;", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeScreenshotLocalContextKt {
    private static final ComponentActivity findActivity(Context $this$findActivity) {
        ComponentActivity componentActivity;
        Iterator it = SequencesKt.generateSequence($this$findActivity, new Function1() { // from class: kntr.app.tribee.steam.page.TribeeScreenshotLocalContextKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Context findActivity$lambda$0;
                findActivity$lambda$0 = TribeeScreenshotLocalContextKt.findActivity$lambda$0((Context) obj);
                return findActivity$lambda$0;
            }
        }).iterator();
        do {
            componentActivity = null;
            if (!it.hasNext()) {
                break;
            }
            Context it2 = (Context) it.next();
            if (it2 instanceof ComponentActivity) {
                componentActivity = (ComponentActivity) it2;
                continue;
            }
        } while (componentActivity == null);
        return componentActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Context findActivity$lambda$0(Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ContextWrapper contextWrapper = it instanceof ContextWrapper ? (ContextWrapper) it : null;
        if (contextWrapper != null) {
            return contextWrapper.getBaseContext();
        }
        return null;
    }

    public static final ScreenshotLocalContext provideScreenLocalContext(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1087456968, "C(provideScreenLocalContext)29@949L7:TribeeScreenshotLocalContext.kt#k3l5ii");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1087456968, $changed, -1, "kntr.app.tribee.steam.page.provideScreenLocalContext (TribeeScreenshotLocalContext.kt:29)");
        }
        CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        TribeeScreenshotLocalContext tribeeScreenshotLocalContext = new TribeeScreenshotLocalContext(findActivity((Context) consume));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return tribeeScreenshotLocalContext;
    }
}