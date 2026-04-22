package kntr.app.tribee.consume.page;

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

/* compiled from: TribeePostCompose.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$TribeePostComposeKt {
    public static final ComposableSingletons$TribeePostComposeKt INSTANCE = new ComposableSingletons$TribeePostComposeKt();

    /* renamed from: lambda$-773400562  reason: not valid java name */
    private static Function3<String, Composer, Integer, Unit> f16lambda$773400562 = ComposableLambdaKt.composableLambdaInstance(-773400562, false, new Function3() { // from class: kntr.app.tribee.consume.page.ComposableSingletons$TribeePostComposeKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__773400562$lambda$0;
            lambda__773400562$lambda$0 = ComposableSingletons$TribeePostComposeKt.lambda__773400562$lambda$0((String) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__773400562$lambda$0;
        }
    });

    /* renamed from: getLambda$-773400562$consume_debug  reason: not valid java name */
    public final Function3<String, Composer, Integer, Unit> m679getLambda$773400562$consume_debug() {
        return f16lambda$773400562;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__773400562$lambda$0(String it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)206@8748L6,201@8453L345:TribeePostCompose.kt#iitu82");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-773400562, $changed, -1, "kntr.app.tribee.consume.page.ComposableSingletons$TribeePostComposeKt.lambda$-773400562.<anonymous> (TribeePostCompose.kt:201)");
            }
            DividerKt.VerticalDivider-9IZ8Weo(SizeKt.size-VpY3zN4(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(4), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl(1), Dp.constructor-impl(14)), 0.0f, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer, 6, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}