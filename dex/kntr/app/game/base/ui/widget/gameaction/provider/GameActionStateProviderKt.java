package kntr.app.game.base.ui.widget.gameaction.provider;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: GameActionStateProvider.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"LocalGameStateProvider", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lkntr/app/game/base/ui/widget/gameaction/provider/GameActionStateProvider;", "getLocalGameStateProvider", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GameActionStateProviderKt {
    private static final ProvidableCompositionLocal<GameActionStateProvider> LocalGameStateProvider = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: kntr.app.game.base.ui.widget.gameaction.provider.GameActionStateProviderKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            GameActionStateProvider LocalGameStateProvider$lambda$0;
            LocalGameStateProvider$lambda$0 = GameActionStateProviderKt.LocalGameStateProvider$lambda$0();
            return LocalGameStateProvider$lambda$0;
        }
    });

    public static final ProvidableCompositionLocal<GameActionStateProvider> getLocalGameStateProvider() {
        return LocalGameStateProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GameActionStateProvider LocalGameStateProvider$lambda$0() {
        return GameActionStateProvider.Companion.getMDefaultInstant$base_ui_debug();
    }
}