package kntr.app.mall.product.details.page.ui.screen;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullScreenPreview.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$FullScreenPreviewKt {
    public static final ComposableSingletons$FullScreenPreviewKt INSTANCE = new ComposableSingletons$FullScreenPreviewKt();
    private static Function2<Composer, Integer, Unit> lambda$1594471539 = ComposableLambdaKt.composableLambdaInstance(1594471539, false, new Function2() { // from class: kntr.app.mall.product.details.page.ui.screen.ComposableSingletons$FullScreenPreviewKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_1594471539$lambda$0;
            lambda_1594471539$lambda$0 = ComposableSingletons$FullScreenPreviewKt.lambda_1594471539$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_1594471539$lambda$0;
        }
    });
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> lambda$1208910525 = ComposableLambdaKt.composableLambdaInstance(1208910525, false, new Function4() { // from class: kntr.app.mall.product.details.page.ui.screen.ComposableSingletons$FullScreenPreviewKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda_1208910525$lambda$0;
            lambda_1208910525$lambda$0 = ComposableSingletons$FullScreenPreviewKt.lambda_1208910525$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda_1208910525$lambda$0;
        }
    });

    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> getLambda$1208910525$product_details_page_debug() {
        return lambda$1208910525;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1594471539$product_details_page_debug() {
        return lambda$1594471539;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1594471539$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C78@3263L18:FullScreenPreview.kt#dsyj5e");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1594471539, $changed, -1, "kntr.app.mall.product.details.page.ui.screen.ComposableSingletons$FullScreenPreviewKt.lambda$1594471539.<anonymous> (FullScreenPreview.kt:78)");
            }
            FullScreenPreviewKt.BlackPlaceHolder(null, $composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1208910525$lambda$0(ImageFailScope $this$ImageWithDynamicRatio, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$ImageWithDynamicRatio, "$this$ImageWithDynamicRatio");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)79@3331L18:FullScreenPreview.kt#dsyj5e");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1208910525, $changed, -1, "kntr.app.mall.product.details.page.ui.screen.ComposableSingletons$FullScreenPreviewKt.lambda$1208910525.<anonymous> (FullScreenPreview.kt:79)");
        }
        FullScreenPreviewKt.BlackPlaceHolder(null, $composer, 0, 1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}