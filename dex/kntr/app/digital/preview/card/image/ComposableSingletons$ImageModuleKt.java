package kntr.app.digital.preview.card.image;

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

/* compiled from: ImageModule.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$ImageModuleKt {
    public static final ComposableSingletons$ImageModuleKt INSTANCE = new ComposableSingletons$ImageModuleKt();

    /* renamed from: lambda$-1210502821  reason: not valid java name */
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> f22lambda$1210502821 = ComposableLambdaKt.composableLambdaInstance(-1210502821, false, new Function4() { // from class: kntr.app.digital.preview.card.image.ComposableSingletons$ImageModuleKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda__1210502821$lambda$0;
            lambda__1210502821$lambda$0 = ComposableSingletons$ImageModuleKt.lambda__1210502821$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda__1210502821$lambda$0;
        }
    });

    /* renamed from: getLambda$-1210502821$preview_debug  reason: not valid java name */
    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> m934getLambda$1210502821$preview_debug() {
        return f22lambda$1210502821;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1210502821$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)31@995L171:ImageModule.kt#9sutw3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1210502821, $changed, -1, "kntr.app.digital.preview.card.image.ComposableSingletons$ImageModuleKt.lambda$-1210502821.<anonymous> (ImageModule.kt:31)");
        }
        BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Color.Companion.getBlack-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}