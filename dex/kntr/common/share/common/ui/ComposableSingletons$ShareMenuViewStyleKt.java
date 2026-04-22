package kntr.common.share.common.ui;

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
import kotlin.jvm.functions.Function2;

/* compiled from: ShareMenuViewStyle.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$ShareMenuViewStyleKt {
    public static final ComposableSingletons$ShareMenuViewStyleKt INSTANCE = new ComposableSingletons$ShareMenuViewStyleKt();

    /* renamed from: lambda$-1256405005  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f60lambda$1256405005 = ComposableLambdaKt.composableLambdaInstance(-1256405005, false, new Function2() { // from class: kntr.common.share.common.ui.ComposableSingletons$ShareMenuViewStyleKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__1256405005$lambda$0;
            lambda__1256405005$lambda$0 = ComposableSingletons$ShareMenuViewStyleKt.lambda__1256405005$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__1256405005$lambda$0;
        }
    });

    /* renamed from: getLambda$-1256405005$common_ui_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2364getLambda$1256405005$common_ui_debug() {
        return f60lambda$1256405005;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1256405005$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C42@1397L6,37@1209L222:ShareMenuViewStyle.kt#y4rqem");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1256405005, $changed, -1, "kntr.common.share.common.ui.ComposableSingletons$ShareMenuViewStyleKt.lambda$-1256405005.<anonymous> (ShareMenuViewStyle.kt:37)");
            }
            DividerKt.HorizontalDivider-9IZ8Weo(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(1)), 0.0f, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer, 6, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}