package kntr.common.share.common.ui;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.activity.ComponentActivity;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.util.Iterator;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ShareLocalContext;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* compiled from: SharePannel.android.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002\u001a\r\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"findActivity", "Landroidx/activity/ComponentActivity;", "Landroid/content/Context;", "provideLocalContext", "Lkntr/common/share/common/ShareLocalContext;", "(Landroidx/compose/runtime/Composer;I)Lkntr/common/share/common/ShareLocalContext;", "common-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SharePannel_androidKt {
    private static final ComponentActivity findActivity(Context $this$findActivity) {
        ComponentActivity componentActivity;
        Iterator it = SequencesKt.generateSequence($this$findActivity, new Function1() { // from class: kntr.common.share.common.ui.SharePannel_androidKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Context findActivity$lambda$0;
                findActivity$lambda$0 = SharePannel_androidKt.findActivity$lambda$0((Context) obj);
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

    public static final ShareLocalContext provideLocalContext(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -962776146, "C(provideLocalContext)29@930L7:SharePannel.android.kt#y4rqem");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-962776146, $changed, -1, "kntr.common.share.common.ui.provideLocalContext (SharePannel.android.kt:29)");
        }
        CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ShareLocalContextAndroid shareLocalContextAndroid = new ShareLocalContextAndroid(findActivity((Context) consume));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return shareLocalContextAndroid;
    }
}