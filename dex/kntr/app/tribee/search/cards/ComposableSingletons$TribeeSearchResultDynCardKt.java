package kntr.app.tribee.search.cards;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeSearchResultDynCard.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$TribeeSearchResultDynCardKt {
    public static final ComposableSingletons$TribeeSearchResultDynCardKt INSTANCE = new ComposableSingletons$TribeeSearchResultDynCardKt();
    private static Function3<String, Composer, Integer, Unit> lambda$394584424 = ComposableLambdaKt.composableLambdaInstance(394584424, false, new Function3() { // from class: kntr.app.tribee.search.cards.ComposableSingletons$TribeeSearchResultDynCardKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_394584424$lambda$0;
            lambda_394584424$lambda$0 = ComposableSingletons$TribeeSearchResultDynCardKt.lambda_394584424$lambda$0((String) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_394584424$lambda$0;
        }
    });

    public final Function3<String, Composer, Integer, Unit> getLambda$394584424$search_debug() {
        return lambda$394584424;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_394584424$lambda$0(String it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)175@8191L6,170@7876L369:TribeeSearchResultDynCard.kt#jdzap2");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(394584424, $changed, -1, "kntr.app.tribee.search.cards.ComposableSingletons$TribeeSearchResultDynCardKt.lambda$394584424.<anonymous> (TribeeSearchResultDynCard.kt:170)");
            }
            DividerKt.VerticalDivider-9IZ8Weo(SizeKt.size-VpY3zN4(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(4), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl(1), Dp.constructor-impl(14)), 0.0f, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer, 6, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}