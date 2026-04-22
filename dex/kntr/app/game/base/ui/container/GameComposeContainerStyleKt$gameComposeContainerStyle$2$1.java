package kntr.app.game.base.ui.container;

import androidx.compose.foundation.OverscrollKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GameComposeContainerStyle.kt */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JA\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"kntr/app/game/base/ui/container/GameComposeContainerStyleKt$gameComposeContainerStyle$2$1", "Lkntr/app/game/base/ui/container/GameComposeContainerStyle;", "style", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier;", RoomRecommendViewModel.EMPTY_CURSOR, "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "original", "(Lkotlin/jvm/functions/Function3;)Lkotlin/jvm/functions/Function3;", "base-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameComposeContainerStyleKt$gameComposeContainerStyle$2$1 implements GameComposeContainerStyle {
    final /* synthetic */ GameComposeContainerStyle $containerStyle;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GameComposeContainerStyleKt$gameComposeContainerStyle$2$1(GameComposeContainerStyle $containerStyle) {
        this.$containerStyle = $containerStyle;
    }

    @Override // kntr.app.game.base.ui.container.GameComposeContainerStyle
    public Function3<Modifier, Composer, Integer, Unit> style(final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "original");
        final GameComposeContainerStyle gameComposeContainerStyle = this.$containerStyle;
        return ComposableLambdaKt.composableLambdaInstance(282910315, true, new Function3() { // from class: kntr.app.game.base.ui.container.GameComposeContainerStyleKt$gameComposeContainerStyle$2$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit style$lambda$0;
                style$lambda$0 = GameComposeContainerStyleKt$gameComposeContainerStyle$2$1.style$lambda$0(GameComposeContainerStyle.this, function3, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return style$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit style$lambda$0(GameComposeContainerStyle $containerStyle, Function3 $original, final Modifier modifier, Composer $composer, int $changed) {
        final Function3 orig;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(modifier)45@1664L61,43@1562L163:GameComposeContainerStyle.kt#whusci");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(modifier) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(282910315, $dirty, -1, "kntr.app.game.base.ui.container.gameComposeContainerStyle$delegate.<anonymous>.<no name provided>.style.<anonymous> (GameComposeContainerStyle.kt:42)");
            }
            if ($containerStyle == null || (orig = $containerStyle.style($original)) == null) {
                orig = $original;
            }
            CompositionLocalKt.CompositionLocalProvider(OverscrollKt.getLocalOverscrollFactory().provides((Object) null), ComposableLambdaKt.rememberComposableLambda(-555806293, true, new Function2() { // from class: kntr.app.game.base.ui.container.GameComposeContainerStyleKt$gameComposeContainerStyle$2$1$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit style$lambda$0$0;
                    style$lambda$0$0 = GameComposeContainerStyleKt$gameComposeContainerStyle$2$1.style$lambda$0$0(orig, modifier, (Composer) obj, ((Integer) obj2).intValue());
                    return style$lambda$0$0;
                }
            }, $composer, 54), $composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit style$lambda$0$0(Function3 $orig, Modifier $modifier, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C46@1691L16:GameComposeContainerStyle.kt#whusci");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-555806293, $changed, -1, "kntr.app.game.base.ui.container.gameComposeContainerStyle$delegate.<anonymous>.<no name provided>.style.<anonymous>.<anonymous> (GameComposeContainerStyle.kt:46)");
            }
            $orig.invoke($modifier, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}