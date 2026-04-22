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

/* compiled from: GridIconText.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$GridIconTextKt {
    public static final ComposableSingletons$GridIconTextKt INSTANCE = new ComposableSingletons$GridIconTextKt();
    private static Function2<Composer, Integer, Unit> lambda$614336680 = ComposableLambdaKt.composableLambdaInstance(614336680, false, new Function2() { // from class: kntr.app.pegasus.feedbackdialog.ComposableSingletons$GridIconTextKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_614336680$lambda$0;
            lambda_614336680$lambda$0 = ComposableSingletons$GridIconTextKt.lambda_614336680$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_614336680$lambda$0;
        }
    });

    /* renamed from: lambda$-1476310754  reason: not valid java name */
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> f9lambda$1476310754 = ComposableLambdaKt.composableLambdaInstance(-1476310754, false, new Function4() { // from class: kntr.app.pegasus.feedbackdialog.ComposableSingletons$GridIconTextKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda__1476310754$lambda$0;
            lambda__1476310754$lambda$0 = ComposableSingletons$GridIconTextKt.lambda__1476310754$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda__1476310754$lambda$0;
        }
    });

    /* renamed from: getLambda$-1476310754$feedbackdialog_debug  reason: not valid java name */
    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> m659getLambda$1476310754$feedbackdialog_debug() {
        return f9lambda$1476310754;
    }

    public final Function2<Composer, Integer, Unit> getLambda$614336680$feedbackdialog_debug() {
        return lambda$614336680;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_614336680$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C157@6125L18:GridIconText.kt#36vyx9");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(614336680, $changed, -1, "kntr.app.pegasus.feedbackdialog.ComposableSingletons$GridIconTextKt.lambda$614336680.<anonymous> (GridIconText.kt:157)");
            }
            ImagePlaceholderKt.m673ImagePlaceholderIv8Zu3U(0L, $composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1476310754$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)160@6243L18:GridIconText.kt#36vyx9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1476310754, $changed, -1, "kntr.app.pegasus.feedbackdialog.ComposableSingletons$GridIconTextKt.lambda$-1476310754.<anonymous> (GridIconText.kt:160)");
        }
        ImagePlaceholderKt.m673ImagePlaceholderIv8Zu3U(0L, $composer, 0, 1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}