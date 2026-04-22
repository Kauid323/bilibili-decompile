package kntr.app.mall.product.details.page.ui.components;

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

/* compiled from: DetailDescComponent.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$DetailDescComponentKt {
    public static final ComposableSingletons$DetailDescComponentKt INSTANCE = new ComposableSingletons$DetailDescComponentKt();

    /* renamed from: lambda$-2126148540  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f1lambda$2126148540 = ComposableLambdaKt.composableLambdaInstance(-2126148540, false, new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ComposableSingletons$DetailDescComponentKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__2126148540$lambda$0;
            lambda__2126148540$lambda$0 = ComposableSingletons$DetailDescComponentKt.lambda__2126148540$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__2126148540$lambda$0;
        }
    });

    /* renamed from: lambda$-570053922  reason: not valid java name */
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> f2lambda$570053922 = ComposableLambdaKt.composableLambdaInstance(-570053922, false, new Function4() { // from class: kntr.app.mall.product.details.page.ui.components.ComposableSingletons$DetailDescComponentKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda__570053922$lambda$0;
            lambda__570053922$lambda$0 = ComposableSingletons$DetailDescComponentKt.lambda__570053922$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda__570053922$lambda$0;
        }
    });

    /* renamed from: getLambda$-2126148540$product_details_page_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m434getLambda$2126148540$product_details_page_debug() {
        return f1lambda$2126148540;
    }

    /* renamed from: getLambda$-570053922$product_details_page_debug  reason: not valid java name */
    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> m435getLambda$570053922$product_details_page_debug() {
        return f2lambda$570053922;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__2126148540$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C392@15689L25:DetailDescComponent.kt#o90vz8");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2126148540, $changed, -1, "kntr.app.mall.product.details.page.ui.components.ComposableSingletons$DetailDescComponentKt.lambda$-2126148540.<anonymous> (DetailDescComponent.kt:392)");
            }
            DetailDescComponentKt.DefaultImagePlaceHolder($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__570053922$lambda$0(ImageFailScope imageFailScope, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(imageFailScope, "<this>");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)396@15807L25:DetailDescComponent.kt#o90vz8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-570053922, $changed, -1, "kntr.app.mall.product.details.page.ui.components.ComposableSingletons$DetailDescComponentKt.lambda$-570053922.<anonymous> (DetailDescComponent.kt:396)");
        }
        DetailDescComponentKt.DefaultImagePlaceHolder($composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}