package kntr.app.digital.preview.card;

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

/* compiled from: DigitalItemContainer.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$DigitalItemContainerKt {
    public static final ComposableSingletons$DigitalItemContainerKt INSTANCE = new ComposableSingletons$DigitalItemContainerKt();
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> lambda$592708160 = ComposableLambdaKt.composableLambdaInstance(592708160, false, new Function4() { // from class: kntr.app.digital.preview.card.ComposableSingletons$DigitalItemContainerKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda_592708160$lambda$0;
            lambda_592708160$lambda$0 = ComposableSingletons$DigitalItemContainerKt.lambda_592708160$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda_592708160$lambda$0;
        }
    });

    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> getLambda$592708160$preview_debug() {
        return lambda$592708160;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_592708160$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)54@1836L211:DigitalItemContainer.kt#v85lra");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(592708160, $changed, -1, "kntr.app.digital.preview.card.ComposableSingletons$DigitalItemContainerKt.lambda$592708160.<anonymous> (DigitalItemContainer.kt:54)");
        }
        BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Color.Companion.getBlack-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}