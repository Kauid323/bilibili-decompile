package kntr.app.digital.preview.share;

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

/* compiled from: ShareDialogService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$ShareDialogServiceKt {
    public static final ComposableSingletons$ShareDialogServiceKt INSTANCE = new ComposableSingletons$ShareDialogServiceKt();

    /* renamed from: lambda$-1600729266  reason: not valid java name */
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> f23lambda$1600729266 = ComposableLambdaKt.composableLambdaInstance(-1600729266, false, new Function4() { // from class: kntr.app.digital.preview.share.ComposableSingletons$ShareDialogServiceKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda__1600729266$lambda$0;
            lambda__1600729266$lambda$0 = ComposableSingletons$ShareDialogServiceKt.lambda__1600729266$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda__1600729266$lambda$0;
        }
    });

    /* renamed from: getLambda$-1600729266$preview_debug  reason: not valid java name */
    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> m988getLambda$1600729266$preview_debug() {
        return f23lambda$1600729266;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1600729266$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)238@10459L291:ShareDialogService.kt#q5u6yf");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1600729266, $changed, -1, "kntr.app.digital.preview.share.ComposableSingletons$ShareDialogServiceKt.lambda$-1600729266.<anonymous> (ShareDialogService.kt:238)");
        }
        BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Color.Companion.getBlack-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}