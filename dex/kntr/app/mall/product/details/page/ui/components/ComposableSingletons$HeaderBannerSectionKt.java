package kntr.app.mall.product.details.page.ui.components;

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
import kntr.app.mall.product.details.page.utils.ThemesKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.DrawableResource;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.mall.product.details.page.generated.resources.Drawable0_commonMainKt;
import srcs.app.mall.product.details.page.generated.resources.Res;

/* compiled from: HeaderBannerSection.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$HeaderBannerSectionKt {
    public static final ComposableSingletons$HeaderBannerSectionKt INSTANCE = new ComposableSingletons$HeaderBannerSectionKt();

    /* renamed from: lambda$-271627637  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f3lambda$271627637 = ComposableLambdaKt.composableLambdaInstance(-271627637, false, new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ComposableSingletons$HeaderBannerSectionKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__271627637$lambda$0;
            lambda__271627637$lambda$0 = ComposableSingletons$HeaderBannerSectionKt.lambda__271627637$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__271627637$lambda$0;
        }
    });
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> lambda$1598673109 = ComposableLambdaKt.composableLambdaInstance(1598673109, false, new Function4() { // from class: kntr.app.mall.product.details.page.ui.components.ComposableSingletons$HeaderBannerSectionKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda_1598673109$lambda$0;
            lambda_1598673109$lambda$0 = ComposableSingletons$HeaderBannerSectionKt.lambda_1598673109$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda_1598673109$lambda$0;
        }
    });

    /* renamed from: getLambda$-271627637$product_details_page_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m437getLambda$271627637$product_details_page_debug() {
        return f3lambda$271627637;
    }

    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> getLambda$1598673109$product_details_page_debug() {
        return lambda$1598673109;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__271627637$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C580@27071L37,579@27002L323:HeaderBannerSection.kt#o90vz8");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-271627637, $changed, -1, "kntr.app.mall.product.details.page.ui.components.ComposableSingletons$HeaderBannerSectionKt.lambda$-271627637.<anonymous> (HeaderBannerSection.kt:579)");
            }
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getLoading(Res.drawable.INSTANCE), $composer, 0), (String) null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, Painter.$stable | 432, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1598673109$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        DrawableResource headerPlaceNight;
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)586@27499L21,594@28050L25,593@27981L311:HeaderBannerSection.kt#o90vz8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1598673109, $changed, -1, "kntr.app.mall.product.details.page.ui.components.ComposableSingletons$HeaderBannerSectionKt.lambda$1598673109.<anonymous> (HeaderBannerSection.kt:586)");
        }
        boolean isLight = ThemesKt.isCurrentThemeLight($composer, 0);
        if (isLight) {
            headerPlaceNight = Drawable0_commonMainKt.getHeaderPlace(Res.drawable.INSTANCE);
        } else {
            headerPlaceNight = Drawable0_commonMainKt.getHeaderPlaceNight(Res.drawable.INSTANCE);
        }
        DrawableResource resource = headerPlaceNight;
        ImageKt.Image(ImageResourcesKt.painterResource(resource, $composer, 0), (String) null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, Painter.$stable | 432, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}