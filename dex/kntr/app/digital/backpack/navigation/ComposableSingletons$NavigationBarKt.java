package kntr.app.digital.backpack.navigation;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigationBar.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$NavigationBarKt {
    public static final ComposableSingletons$NavigationBarKt INSTANCE = new ComposableSingletons$NavigationBarKt();
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> lambda$2047842988 = ComposableLambdaKt.composableLambdaInstance(2047842988, false, new Function4() { // from class: kntr.app.digital.backpack.navigation.ComposableSingletons$NavigationBarKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda_2047842988$lambda$0;
            lambda_2047842988$lambda$0 = ComposableSingletons$NavigationBarKt.lambda_2047842988$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda_2047842988$lambda$0;
        }
    });

    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> getLambda$2047842988$backpack_debug() {
        return lambda$2047842988;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_2047842988$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)51@1823L211:NavigationBar.kt#bw9ta");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2047842988, $changed, -1, "kntr.app.digital.backpack.navigation.ComposableSingletons$NavigationBarKt.lambda$2047842988.<anonymous> (NavigationBar.kt:51)");
        }
        BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Color.Companion.getBlack-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}