package kntr.app.game.gamebind.ui.item;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RoleItemView.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$RoleItemViewKt {
    public static final ComposableSingletons$RoleItemViewKt INSTANCE = new ComposableSingletons$RoleItemViewKt();

    /* renamed from: lambda$-313045440  reason: not valid java name */
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> f26lambda$313045440 = ComposableLambdaKt.composableLambdaInstance(-313045440, false, new Function4() { // from class: kntr.app.game.gamebind.ui.item.ComposableSingletons$RoleItemViewKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda__313045440$lambda$0;
            lambda__313045440$lambda$0 = ComposableSingletons$RoleItemViewKt.lambda__313045440$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda__313045440$lambda$0;
        }
    });

    /* renamed from: getLambda$-313045440$game_bind_ui_debug  reason: not valid java name */
    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> m1247getLambda$313045440$game_bind_ui_debug() {
        return f26lambda$313045440;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__313045440$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it):RoleItemView.kt#2zw2i8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-313045440, $changed, -1, "kntr.app.game.gamebind.ui.item.ComposableSingletons$RoleItemViewKt.lambda$-313045440.<anonymous> (RoleItemView.kt:122)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}