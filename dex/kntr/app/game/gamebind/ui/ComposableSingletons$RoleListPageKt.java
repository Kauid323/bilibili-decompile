package kntr.app.game.gamebind.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: RoleListPage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$RoleListPageKt {
    public static final ComposableSingletons$RoleListPageKt INSTANCE = new ComposableSingletons$RoleListPageKt();
    private static Function2<Composer, Integer, Unit> lambda$2025103984 = ComposableLambdaKt.composableLambdaInstance(2025103984, false, new Function2() { // from class: kntr.app.game.gamebind.ui.ComposableSingletons$RoleListPageKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_2025103984$lambda$0;
            lambda_2025103984$lambda$0 = ComposableSingletons$RoleListPageKt.lambda_2025103984$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_2025103984$lambda$0;
        }
    });

    /* renamed from: lambda$-1349187559  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f25lambda$1349187559 = ComposableLambdaKt.composableLambdaInstance(-1349187559, false, new Function2() { // from class: kntr.app.game.gamebind.ui.ComposableSingletons$RoleListPageKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__1349187559$lambda$0;
            lambda__1349187559$lambda$0 = ComposableSingletons$RoleListPageKt.lambda__1349187559$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__1349187559$lambda$0;
        }
    });

    /* renamed from: getLambda$-1349187559$game_bind_ui_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1234getLambda$1349187559$game_bind_ui_debug() {
        return f25lambda$1349187559;
    }

    public final Function2<Composer, Integer, Unit> getLambda$2025103984$game_bind_ui_debug() {
        return lambda$2025103984;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_2025103984$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:RoleListPage.kt#ualdgv");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2025103984, $changed, -1, "kntr.app.game.gamebind.ui.ComposableSingletons$RoleListPageKt.lambda$2025103984.<anonymous> (RoleListPage.kt:292)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1349187559$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:RoleListPage.kt#ualdgv");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1349187559, $changed, -1, "kntr.app.game.gamebind.ui.ComposableSingletons$RoleListPageKt.lambda$-1349187559.<anonymous> (RoleListPage.kt:322)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}