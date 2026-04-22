package kntr.app.pegasus.feedbackdialog;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeedbackDialog.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$FeedbackDialogKt {
    public static final ComposableSingletons$FeedbackDialogKt INSTANCE = new ComposableSingletons$FeedbackDialogKt();
    private static Function4<LazyItemScope, Integer, Composer, Integer, Unit> lambda$644208441 = ComposableLambdaKt.composableLambdaInstance(644208441, false, new Function4() { // from class: kntr.app.pegasus.feedbackdialog.ComposableSingletons$FeedbackDialogKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda_644208441$lambda$0;
            lambda_644208441$lambda$0 = ComposableSingletons$FeedbackDialogKt.lambda_644208441$lambda$0((LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            return lambda_644208441$lambda$0;
        }
    });

    public final Function4<LazyItemScope, Integer, Composer, Integer, Unit> getLambda$644208441$feedbackdialog_debug() {
        return lambda$644208441;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_644208441$lambda$0(LazyItemScope $this$stickyHeader, int it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$stickyHeader, "$this$stickyHeader");
        ComposerKt.sourceInformation($composer, "CN(it)84@2852L23:FeedbackDialog.kt#36vyx9");
        if (!$composer.shouldExecute(($changed & 129) != 128, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(644208441, $changed, -1, "kntr.app.pegasus.feedbackdialog.ComposableSingletons$FeedbackDialogKt.lambda$644208441.<anonymous> (FeedbackDialog.kt:84)");
            }
            FeedbackDialogKt.BottomSheetDragHandle($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}