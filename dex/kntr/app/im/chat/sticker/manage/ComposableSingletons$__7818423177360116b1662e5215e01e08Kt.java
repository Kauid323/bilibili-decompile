package kntr.app.im.chat.sticker.manage;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: __7818423177360116b1662e5215e01e08.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$__7818423177360116b1662e5215e01e08Kt {
    public static final ComposableSingletons$__7818423177360116b1662e5215e01e08Kt INSTANCE = new ComposableSingletons$__7818423177360116b1662e5215e01e08Kt();
    private static Function3<Modifier, Composer, Integer, Unit> lambda$602928528 = ComposableLambdaKt.composableLambdaInstance(602928528, false, new Function3() { // from class: kntr.app.im.chat.sticker.manage.ComposableSingletons$__7818423177360116b1662e5215e01e08Kt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_602928528$lambda$0;
            lambda_602928528$lambda$0 = ComposableSingletons$__7818423177360116b1662e5215e01e08Kt.lambda_602928528$lambda$0((Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_602928528$lambda$0;
        }
    });

    public final Function3<Modifier, Composer, Integer, Unit> getLambda$602928528$sticker_debug() {
        return lambda$602928528;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_602928528$lambda$0(Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(modifier)11@441L57:__7818423177360116b1662e5215e01e08.kt#is795o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(modifier) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(602928528, $dirty, -1, "kntr.app.im.chat.sticker.manage.ComposableSingletons$__7818423177360116b1662e5215e01e08Kt.lambda$602928528.<anonymous> (__7818423177360116b1662e5215e01e08.kt:11)");
            }
            StickerAphroAlbumsPageKt.StickerAlbumsSelectPage(modifier, $composer, $dirty & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}