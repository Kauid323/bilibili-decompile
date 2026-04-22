package kntr.app.mall.product.details.page.ui.screen;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.unit.Dp;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.mall.product.details.page.generated.resources.Drawable0_commonMainKt;
import srcs.app.mall.product.details.page.generated.resources.Res;

/* compiled from: EmptyScreen.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$EmptyScreenKt {
    public static final ComposableSingletons$EmptyScreenKt INSTANCE = new ComposableSingletons$EmptyScreenKt();

    /* renamed from: lambda$-1400136371  reason: not valid java name */
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> f8lambda$1400136371 = ComposableLambdaKt.composableLambdaInstance(-1400136371, false, new Function4() { // from class: kntr.app.mall.product.details.page.ui.screen.ComposableSingletons$EmptyScreenKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda__1400136371$lambda$0;
            lambda__1400136371$lambda$0 = ComposableSingletons$EmptyScreenKt.lambda__1400136371$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda__1400136371$lambda$0;
        }
    });

    /* renamed from: getLambda$-1400136371$product_details_page_debug  reason: not valid java name */
    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> m613getLambda$1400136371$product_details_page_debug() {
        return f8lambda$1400136371;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1400136371$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)43@1712L35,42@1675L217:EmptyScreen.kt#dsyj5e");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1400136371, $changed, -1, "kntr.app.mall.product.details.page.ui.screen.ComposableSingletons$EmptyScreenKt.lambda$-1400136371.<anonymous> (EmptyScreen.kt:42)");
        }
        ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getEmpty(Res.drawable.INSTANCE), $composer, 0), (String) null, SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(280), Dp.constructor-impl(144)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, Painter.$stable | 432, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}