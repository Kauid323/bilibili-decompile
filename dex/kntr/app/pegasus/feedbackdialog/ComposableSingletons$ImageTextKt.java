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

/* compiled from: ImageText.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$ImageTextKt {
    public static final ComposableSingletons$ImageTextKt INSTANCE = new ComposableSingletons$ImageTextKt();

    /* renamed from: lambda$-465646213  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f11lambda$465646213 = ComposableLambdaKt.composableLambdaInstance(-465646213, false, new Function2() { // from class: kntr.app.pegasus.feedbackdialog.ComposableSingletons$ImageTextKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__465646213$lambda$0;
            lambda__465646213$lambda$0 = ComposableSingletons$ImageTextKt.lambda__465646213$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__465646213$lambda$0;
        }
    });

    /* renamed from: lambda$-451341455  reason: not valid java name */
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> f10lambda$451341455 = ComposableLambdaKt.composableLambdaInstance(-451341455, false, new Function4() { // from class: kntr.app.pegasus.feedbackdialog.ComposableSingletons$ImageTextKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda__451341455$lambda$0;
            lambda__451341455$lambda$0 = ComposableSingletons$ImageTextKt.lambda__451341455$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda__451341455$lambda$0;
        }
    });

    /* renamed from: getLambda$-451341455$feedbackdialog_debug  reason: not valid java name */
    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> m661getLambda$451341455$feedbackdialog_debug() {
        return f10lambda$451341455;
    }

    /* renamed from: getLambda$-465646213$feedbackdialog_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m662getLambda$465646213$feedbackdialog_debug() {
        return f11lambda$465646213;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__465646213$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C50@1970L18:ImageText.kt#36vyx9");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-465646213, $changed, -1, "kntr.app.pegasus.feedbackdialog.ComposableSingletons$ImageTextKt.lambda$-465646213.<anonymous> (ImageText.kt:50)");
            }
            ImagePlaceholderKt.m673ImagePlaceholderIv8Zu3U(0L, $composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__451341455$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)53@2064L18:ImageText.kt#36vyx9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-451341455, $changed, -1, "kntr.app.pegasus.feedbackdialog.ComposableSingletons$ImageTextKt.lambda$-451341455.<anonymous> (ImageText.kt:53)");
        }
        ImagePlaceholderKt.m673ImagePlaceholderIv8Zu3U(0L, $composer, 0, 1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}