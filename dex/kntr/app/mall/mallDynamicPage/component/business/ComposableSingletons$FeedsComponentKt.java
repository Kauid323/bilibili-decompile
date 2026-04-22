package kntr.app.mall.mallDynamicPage.component.business;

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

/* compiled from: FeedsComponent.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$FeedsComponentKt {
    public static final ComposableSingletons$FeedsComponentKt INSTANCE = new ComposableSingletons$FeedsComponentKt();

    /* renamed from: lambda$-395742371  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f56lambda$395742371 = ComposableLambdaKt.composableLambdaInstance(-395742371, false, new Function2() { // from class: kntr.app.mall.mallDynamicPage.component.business.ComposableSingletons$FeedsComponentKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__395742371$lambda$0;
            lambda__395742371$lambda$0 = ComposableSingletons$FeedsComponentKt.lambda__395742371$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__395742371$lambda$0;
        }
    });
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> lambda$1679631955 = ComposableLambdaKt.composableLambdaInstance(1679631955, false, new Function4() { // from class: kntr.app.mall.mallDynamicPage.component.business.ComposableSingletons$FeedsComponentKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda_1679631955$lambda$0;
            lambda_1679631955$lambda$0 = ComposableSingletons$FeedsComponentKt.lambda_1679631955$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda_1679631955$lambda$0;
        }
    });

    /* renamed from: getLambda$-395742371$mallDynamicPage_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2059getLambda$395742371$mallDynamicPage_debug() {
        return f56lambda$395742371;
    }

    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> getLambda$1679631955$mallDynamicPage_debug() {
        return lambda$1679631955;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__395742371$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C186@7443L25:FeedsComponent.kt#9bld4r");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-395742371, $changed, -1, "kntr.app.mall.mallDynamicPage.component.business.ComposableSingletons$FeedsComponentKt.lambda$-395742371.<anonymous> (FeedsComponent.kt:186)");
            }
            FeedsComponentKt.DefaultImagePlaceHolder($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1679631955$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)187@7504L25:FeedsComponent.kt#9bld4r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1679631955, $changed, -1, "kntr.app.mall.mallDynamicPage.component.business.ComposableSingletons$FeedsComponentKt.lambda$1679631955.<anonymous> (FeedsComponent.kt:187)");
        }
        FeedsComponentKt.DefaultImagePlaceHolder($composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}