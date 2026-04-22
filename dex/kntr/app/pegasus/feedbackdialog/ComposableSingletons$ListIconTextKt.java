package kntr.app.pegasus.feedbackdialog;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kntr.app.pegasus.feedbackdialog.widget.ImagePlaceholderKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ListIconText.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$ListIconTextKt {
    public static final ComposableSingletons$ListIconTextKt INSTANCE = new ComposableSingletons$ListIconTextKt();

    /* renamed from: lambda$-2032547712  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f12lambda$2032547712 = ComposableLambdaKt.composableLambdaInstance(-2032547712, false, new Function2() { // from class: kntr.app.pegasus.feedbackdialog.ComposableSingletons$ListIconTextKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__2032547712$lambda$0;
            lambda__2032547712$lambda$0 = ComposableSingletons$ListIconTextKt.lambda__2032547712$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__2032547712$lambda$0;
        }
    });

    /* renamed from: lambda$-876498102  reason: not valid java name */
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> f13lambda$876498102 = ComposableLambdaKt.composableLambdaInstance(-876498102, false, new Function4() { // from class: kntr.app.pegasus.feedbackdialog.ComposableSingletons$ListIconTextKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda__876498102$lambda$0;
            lambda__876498102$lambda$0 = ComposableSingletons$ListIconTextKt.lambda__876498102$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda__876498102$lambda$0;
        }
    });

    /* renamed from: getLambda$-2032547712$feedbackdialog_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m664getLambda$2032547712$feedbackdialog_debug() {
        return f12lambda$2032547712;
    }

    /* renamed from: getLambda$-876498102$feedbackdialog_debug  reason: not valid java name */
    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> m665getLambda$876498102$feedbackdialog_debug() {
        return f13lambda$876498102;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__2032547712$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C109@3983L18:ListIconText.kt#36vyx9");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2032547712, $changed, -1, "kntr.app.pegasus.feedbackdialog.ComposableSingletons$ListIconTextKt.lambda$-2032547712.<anonymous> (ListIconText.kt:109)");
            }
            ImagePlaceholderKt.m673ImagePlaceholderIv8Zu3U(0L, $composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__876498102$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)112@4089L18:ListIconText.kt#36vyx9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-876498102, $changed, -1, "kntr.app.pegasus.feedbackdialog.ComposableSingletons$ListIconTextKt.lambda$-876498102.<anonymous> (ListIconText.kt:112)");
        }
        ImagePlaceholderKt.m673ImagePlaceholderIv8Zu3U(0L, $composer, 0, 1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}