package settings.language;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: __b9588d8c9dbe72a971a0fffed75f4985.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$__b9588d8c9dbe72a971a0fffed75f4985Kt {
    public static final ComposableSingletons$__b9588d8c9dbe72a971a0fffed75f4985Kt INSTANCE = new ComposableSingletons$__b9588d8c9dbe72a971a0fffed75f4985Kt();
    private static Function2<Composer, Integer, Unit> lambda$165938510 = ComposableLambdaKt.composableLambdaInstance(165938510, false, new Function2() { // from class: settings.language.ComposableSingletons$__b9588d8c9dbe72a971a0fffed75f4985Kt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_165938510$lambda$0;
            lambda_165938510$lambda$0 = ComposableSingletons$__b9588d8c9dbe72a971a0fffed75f4985Kt.lambda_165938510$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_165938510$lambda$0;
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$165938510$language_debug() {
        return lambda$165938510;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_165938510$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C10@369L27:__b9588d8c9dbe72a971a0fffed75f4985.kt#nusb0j");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(165938510, $changed, -1, "settings.language.ComposableSingletons$__b9588d8c9dbe72a971a0fffed75f4985Kt.lambda$165938510.<anonymous> (__b9588d8c9dbe72a971a0fffed75f4985.kt:10)");
            }
            LanguageSettingsPageKt.LanguageSettingsPage($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}