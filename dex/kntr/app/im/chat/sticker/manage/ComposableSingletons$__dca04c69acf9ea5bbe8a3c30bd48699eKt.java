package kntr.app.im.chat.sticker.manage;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: __dca04c69acf9ea5bbe8a3c30bd48699e.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$__dca04c69acf9ea5bbe8a3c30bd48699eKt {
    public static final ComposableSingletons$__dca04c69acf9ea5bbe8a3c30bd48699eKt INSTANCE = new ComposableSingletons$__dca04c69acf9ea5bbe8a3c30bd48699eKt();
    private static Function3<Modifier, Composer, Integer, Unit> lambda$937036902 = ComposableLambdaKt.composableLambdaInstance(937036902, false, new Function3() { // from class: kntr.app.im.chat.sticker.manage.ComposableSingletons$__dca04c69acf9ea5bbe8a3c30bd48699eKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_937036902$lambda$0;
            lambda_937036902$lambda$0 = ComposableSingletons$__dca04c69acf9ea5bbe8a3c30bd48699eKt.lambda_937036902$lambda$0((Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_937036902$lambda$0;
        }
    });

    public final Function3<Modifier, Composer, Integer, Unit> getLambda$937036902$sticker_debug() {
        return lambda$937036902;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_937036902$lambda$0(Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(modifier)11@441L52:__dca04c69acf9ea5bbe8a3c30bd48699e.kt#is795o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(modifier) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(937036902, $dirty, -1, "kntr.app.im.chat.sticker.manage.ComposableSingletons$__dca04c69acf9ea5bbe8a3c30bd48699eKt.lambda$937036902.<anonymous> (__dca04c69acf9ea5bbe8a3c30bd48699e.kt:11)");
            }
            StickerManagerPageKt.StickerManagerPage(modifier, $composer, $dirty & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}