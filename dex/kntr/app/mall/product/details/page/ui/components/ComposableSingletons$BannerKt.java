package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: Banner.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$BannerKt {
    public static final ComposableSingletons$BannerKt INSTANCE = new ComposableSingletons$BannerKt();

    /* renamed from: lambda$-2110955408  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f0lambda$2110955408 = ComposableLambdaKt.composableLambdaInstance(-2110955408, false, new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ComposableSingletons$BannerKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__2110955408$lambda$0;
            lambda__2110955408$lambda$0 = ComposableSingletons$BannerKt.lambda__2110955408$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__2110955408$lambda$0;
        }
    });

    /* renamed from: getLambda$-2110955408$product_details_page_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m433getLambda$2110955408$product_details_page_debug() {
        return f0lambda$2110955408;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__2110955408$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:Banner.kt#o90vz8");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2110955408, $changed, -1, "kntr.app.mall.product.details.page.ui.components.ComposableSingletons$BannerKt.lambda$-2110955408.<anonymous> (Banner.kt:75)");
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