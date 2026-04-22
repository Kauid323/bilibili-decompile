package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PaddingCard.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$PaddingCardKt {
    public static final ComposableSingletons$PaddingCardKt INSTANCE = new ComposableSingletons$PaddingCardKt();
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$1767857282 = ComposableLambdaKt.composableLambdaInstance(1767857282, false, new Function3() { // from class: kntr.app.mall.product.details.page.ui.components.ComposableSingletons$PaddingCardKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_1767857282$lambda$0;
            lambda_1767857282$lambda$0 = ComposableSingletons$PaddingCardKt.lambda_1767857282$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_1767857282$lambda$0;
        }
    });

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$1767857282$product_details_page_debug() {
        return lambda$1767857282;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1767857282$lambda$0(BoxScope boxScope, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(boxScope, "<this>");
        ComposerKt.sourceInformation($composer, "C:PaddingCard.kt#o90vz8");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1767857282, $changed, -1, "kntr.app.mall.product.details.page.ui.components.ComposableSingletons$PaddingCardKt.lambda$1767857282.<anonymous> (PaddingCard.kt:31)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}