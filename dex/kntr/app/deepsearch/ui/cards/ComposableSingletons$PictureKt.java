package kntr.app.deepsearch.ui.cards;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Picture.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$PictureKt {
    public static final ComposableSingletons$PictureKt INSTANCE = new ComposableSingletons$PictureKt();
    private static Function2<Composer, Integer, Unit> lambda$985054492 = ComposableLambdaKt.composableLambdaInstance(985054492, false, new Function2() { // from class: kntr.app.deepsearch.ui.cards.ComposableSingletons$PictureKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_985054492$lambda$0;
            lambda_985054492$lambda$0 = ComposableSingletons$PictureKt.lambda_985054492$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_985054492$lambda$0;
        }
    });
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> lambda$848059538 = ComposableLambdaKt.composableLambdaInstance(848059538, false, new Function4() { // from class: kntr.app.deepsearch.ui.cards.ComposableSingletons$PictureKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda_848059538$lambda$0;
            lambda_848059538$lambda$0 = ComposableSingletons$PictureKt.lambda_848059538$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda_848059538$lambda$0;
        }
    });

    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> getLambda$848059538$compose_debug() {
        return lambda$848059538;
    }

    public final Function2<Composer, Integer, Unit> getLambda$985054492$compose_debug() {
        return lambda$985054492;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_985054492$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C386@15172L13:Picture.kt#pp6rt");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(985054492, $changed, -1, "kntr.app.deepsearch.ui.cards.ComposableSingletons$PictureKt.lambda$985054492.<anonymous> (Picture.kt:386)");
            }
            PictureKt.Placeholder(null, $composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_848059538$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)387@15225L13:Picture.kt#pp6rt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(848059538, $changed, -1, "kntr.app.deepsearch.ui.cards.ComposableSingletons$PictureKt.lambda$848059538.<anonymous> (Picture.kt:387)");
        }
        PictureKt.Placeholder(null, $composer, 0, 1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}