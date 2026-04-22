package kntr.app.game.base.ui.localproviders;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: GameLocalProviders.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u001d\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u000e\n\u0000\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"DEFAULT_SOURCE_FROM", RoomRecommendViewModel.EMPTY_CURSOR, "LocalSourceFrom", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalSourceFrom$annotations", "()V", "getLocalSourceFrom", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GameLocalProvidersKt {
    public static final String DEFAULT_SOURCE_FROM = "9800000014";
    private static final ProvidableCompositionLocal<String> LocalSourceFrom = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: kntr.app.game.base.ui.localproviders.GameLocalProvidersKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            String str;
            str = GameLocalProvidersKt.DEFAULT_SOURCE_FROM;
            return str;
        }
    });

    public static /* synthetic */ void getLocalSourceFrom$annotations() {
    }

    public static final ProvidableCompositionLocal<String> getLocalSourceFrom() {
        return LocalSourceFrom;
    }
}