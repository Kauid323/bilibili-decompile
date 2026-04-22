package kntr.app.game.biz;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: GameTest.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"HelloGameTheme", RoomRecommendViewModel.EMPTY_CURSOR, "(Landroidx/compose/runtime/Composer;I)V", "gamebiz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GameTestKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HelloGameTheme$lambda$0(int i, Composer composer, int i2) {
        HelloGameTheme(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void HelloGameTheme(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1080116584);
        ComposerKt.sourceInformation($composer2, "C(HelloGameTheme)23@900L1094:GameTest.kt#351edr");
        if (!$composer2.shouldExecute($changed != 0, $changed & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1080116584, $changed, -1, "kntr.app.game.biz.HelloGameTheme (GameTest.kt:22)");
            }
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableSingletons$GameTestKt.INSTANCE.getLambda$283782736$gamebiz_debug(), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.biz.GameTestKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit HelloGameTheme$lambda$0;
                    HelloGameTheme$lambda$0 = GameTestKt.HelloGameTheme$lambda$0($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return HelloGameTheme$lambda$0;
                }
            });
        }
    }
}