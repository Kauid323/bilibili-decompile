package kntr.common.ouro.ui.inlineContent;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageContent.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$ImageContentKt {
    public static final ComposableSingletons$ImageContentKt INSTANCE = new ComposableSingletons$ImageContentKt();
    private static Function2<Composer, Integer, Unit> lambda$449999126 = ComposableLambdaKt.composableLambdaInstance(449999126, false, new Function2() { // from class: kntr.common.ouro.ui.inlineContent.ComposableSingletons$ImageContentKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_449999126$lambda$0;
            lambda_449999126$lambda$0 = ComposableSingletons$ImageContentKt.lambda_449999126$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_449999126$lambda$0;
        }
    });
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> lambda$1821109900 = ComposableLambdaKt.composableLambdaInstance(1821109900, false, new Function4() { // from class: kntr.common.ouro.ui.inlineContent.ComposableSingletons$ImageContentKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda_1821109900$lambda$0;
            lambda_1821109900$lambda$0 = ComposableSingletons$ImageContentKt.lambda_1821109900$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda_1821109900$lambda$0;
        }
    });

    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> getLambda$1821109900$ui_debug() {
        return lambda$1821109900;
    }

    public final Function2<Composer, Integer, Unit> getLambda$449999126$ui_debug() {
        return lambda$449999126;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_449999126$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C49@2081L162:ImageContent.kt#ldidgb");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(449999126, $changed, -1, "kntr.common.ouro.ui.inlineContent.ComposableSingletons$ImageContentKt.lambda$449999126.<anonymous> (ImageContent.kt:49)");
            }
            BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Color.Companion.getGray-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1821109900$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)57@2295L162:ImageContent.kt#ldidgb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1821109900, $changed, -1, "kntr.common.ouro.ui.inlineContent.ComposableSingletons$ImageContentKt.lambda$1821109900.<anonymous> (ImageContent.kt:57)");
        }
        BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Color.Companion.getGray-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}