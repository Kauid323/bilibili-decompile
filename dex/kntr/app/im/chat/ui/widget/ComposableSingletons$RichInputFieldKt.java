package kntr.app.im.chat.ui.widget;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RichInputField.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$RichInputFieldKt {
    public static final ComposableSingletons$RichInputFieldKt INSTANCE = new ComposableSingletons$RichInputFieldKt();
    private static Function2<Composer, Integer, Unit> lambda$401147669 = ComposableLambdaKt.composableLambdaInstance(401147669, false, new Function2() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$RichInputFieldKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_401147669$lambda$0;
            lambda_401147669$lambda$0 = ComposableSingletons$RichInputFieldKt.lambda_401147669$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_401147669$lambda$0;
        }
    });
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> lambda$1064029791 = ComposableLambdaKt.composableLambdaInstance(1064029791, false, new Function4() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$RichInputFieldKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda_1064029791$lambda$0;
            lambda_1064029791$lambda$0 = ComposableSingletons$RichInputFieldKt.lambda_1064029791$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda_1064029791$lambda$0;
        }
    });

    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> getLambda$1064029791$ui_debug() {
        return lambda$1064029791;
    }

    public final Function2<Composer, Integer, Unit> getLambda$401147669$ui_debug() {
        return lambda$401147669;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_401147669$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C508@18343L40:RichInputField.kt#92mklk");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(401147669, $changed, -1, "kntr.app.im.chat.ui.widget.ComposableSingletons$RichInputFieldKt.lambda$401147669.<anonymous> (RichInputField.kt:508)");
            }
            RichInputFieldKt.EmotePlaceholder(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1064029791$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)511@18567L40:RichInputField.kt#92mklk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1064029791, $changed, -1, "kntr.app.im.chat.ui.widget.ComposableSingletons$RichInputFieldKt.lambda$1064029791.<anonymous> (RichInputField.kt:511)");
        }
        RichInputFieldKt.EmotePlaceholder(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer, 6, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}