package kntr.common.trio.pagecontroller;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.ViewTreeOnBackPressedDispatcherOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* compiled from: LocalOnBackPressedDispatcher.android.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\r\u0010\u0003\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"requireActivity", "Landroidx/activity/ComponentActivity;", "Landroid/content/Context;", "findViewTreeOnBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "(Landroidx/compose/runtime/Composer;I)Landroidx/activity/OnBackPressedDispatcher;", "trio_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LocalOnBackPressedDispatcher_androidKt {
    private static final ComponentActivity requireActivity(final Context $this$requireActivity) {
        ComponentActivity componentActivity;
        Iterator it = SequencesKt.generateSequence($this$requireActivity, new Function1() { // from class: kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher_androidKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Context requireActivity$lambda$0;
                requireActivity$lambda$0 = LocalOnBackPressedDispatcher_androidKt.requireActivity$lambda$0($this$requireActivity, (Context) obj);
                return requireActivity$lambda$0;
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
        if (componentActivity != null) {
            return componentActivity;
        }
        throw new NoSuchElementException("No element of the sequence was transformed to a non-null value.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Context requireActivity$lambda$0(Context $this_requireActivity, Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ContextWrapper contextWrapper = $this_requireActivity instanceof ContextWrapper ? (ContextWrapper) $this_requireActivity : null;
        if (contextWrapper != null) {
            return contextWrapper.getBaseContext();
        }
        return null;
    }

    public static final OnBackPressedDispatcher findViewTreeOnBackPressedDispatcher(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 2102619428, "C(findViewTreeOnBackPressedDispatcher)18@721L7:LocalOnBackPressedDispatcher.android.kt#yqq3oh");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2102619428, $changed, -1, "kntr.common.trio.pagecontroller.findViewTreeOnBackPressedDispatcher (LocalOnBackPressedDispatcher.android.kt:16)");
        }
        CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalView();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        OnBackPressedDispatcherOwner owner = ViewTreeOnBackPressedDispatcherOwner.get((View) consume);
        if (owner != null) {
            $composer.startReplaceGroup(1982644278);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(1982647285);
            ComposerKt.sourceInformation($composer, "19@800L7");
            CompositionLocal this_$iv2 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComponentActivity requireActivity = requireActivity((Context) consume2);
            $composer.endReplaceGroup();
            owner = (OnBackPressedDispatcherOwner) requireActivity;
        }
        OnBackPressedDispatcher onBackPressedDispatcher = owner.getOnBackPressedDispatcher();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return onBackPressedDispatcher;
    }
}