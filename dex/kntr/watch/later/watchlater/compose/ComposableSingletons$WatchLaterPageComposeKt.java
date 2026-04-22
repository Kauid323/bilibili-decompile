package kntr.watch.later.watchlater.compose;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchLaterPageCompose.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$WatchLaterPageComposeKt {
    public static final ComposableSingletons$WatchLaterPageComposeKt INSTANCE = new ComposableSingletons$WatchLaterPageComposeKt();

    /* renamed from: lambda$-803165361  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f62lambda$803165361 = ComposableLambdaKt.composableLambdaInstance(-803165361, false, new Function2() { // from class: kntr.watch.later.watchlater.compose.ComposableSingletons$WatchLaterPageComposeKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__803165361$lambda$0;
            lambda__803165361$lambda$0 = ComposableSingletons$WatchLaterPageComposeKt.lambda__803165361$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__803165361$lambda$0;
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$1580674010 = ComposableLambdaKt.composableLambdaInstance(1580674010, false, new Function3() { // from class: kntr.watch.later.watchlater.compose.ComposableSingletons$WatchLaterPageComposeKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_1580674010$lambda$0;
            lambda_1580674010$lambda$0 = ComposableSingletons$WatchLaterPageComposeKt.lambda_1580674010$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_1580674010$lambda$0;
        }
    });

    /* renamed from: getLambda$-803165361$watch_later_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2580getLambda$803165361$watch_later_debug() {
        return f62lambda$803165361;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$1580674010$watch_later_debug() {
        return lambda$1580674010;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__803165361$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C187@7810L24,193@8078L11,186@7761L358:WatchLaterPageCompose.kt#b3vx81");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-803165361, $changed, -1, "kntr.watch.later.watchlater.compose.ComposableSingletons$WatchLaterPageComposeKt.lambda$-803165361.<anonymous> (WatchLaterPageCompose.kt:186)");
            }
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_back_left_line_500($composer, 6), (String) null, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl(24)), BiliTheme.INSTANCE.getThemeColors($composer, BiliTheme.$stable).getActionIcon-0d7_KjU(), $composer, Painter.$stable | 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1580674010$lambda$0(LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C507@19868L41:WatchLaterPageCompose.kt#b3vx81");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1580674010, $changed, -1, "kntr.watch.later.watchlater.compose.ComposableSingletons$WatchLaterPageComposeKt.lambda$1580674010.<anonymous> (WatchLaterPageCompose.kt:507)");
            }
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(48)), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}