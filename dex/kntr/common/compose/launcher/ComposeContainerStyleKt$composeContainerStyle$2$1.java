package kntr.common.compose.launcher;

import androidx.compose.foundation.OverscrollKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ComposeContainerStyle.kt */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JA\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"kntr/common/compose/launcher/ComposeContainerStyleKt$composeContainerStyle$2$1", "Lkntr/common/compose/launcher/ComposeContainerStyle;", "style", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier;", "", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "original", "(Lkotlin/jvm/functions/Function3;)Lkotlin/jvm/functions/Function3;", "compose-launcher_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposeContainerStyleKt$composeContainerStyle$2$1 implements ComposeContainerStyle {
    final /* synthetic */ ComposeContainerStyle $containerStyle;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ComposeContainerStyleKt$composeContainerStyle$2$1(ComposeContainerStyle $containerStyle) {
        this.$containerStyle = $containerStyle;
    }

    @Override // kntr.common.compose.launcher.ComposeContainerStyle
    public Function3<Modifier, Composer, Integer, Unit> style(final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "original");
        final ComposeContainerStyle composeContainerStyle = this.$containerStyle;
        return ComposableLambdaKt.composableLambdaInstance(-1568860457, true, new Function3() { // from class: kntr.common.compose.launcher.ComposeContainerStyleKt$composeContainerStyle$2$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit style$lambda$0;
                style$lambda$0 = ComposeContainerStyleKt$composeContainerStyle$2$1.style$lambda$0(ComposeContainerStyle.this, function3, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return style$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit style$lambda$0(ComposeContainerStyle $containerStyle, Function3 $original, final Modifier modifier, Composer $composer, int $changed) {
        final Function3 orig;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(modifier)45@1629L61,43@1527L163:ComposeContainerStyle.kt#2jy5aq");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(modifier) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1568860457, $dirty, -1, "kntr.common.compose.launcher.composeContainerStyle$delegate.<anonymous>.<no name provided>.style.<anonymous> (ComposeContainerStyle.kt:42)");
            }
            if ($containerStyle == null || (orig = $containerStyle.style($original)) == null) {
                orig = $original;
            }
            CompositionLocalKt.CompositionLocalProvider(OverscrollKt.getLocalOverscrollFactory().provides((Object) null), ComposableLambdaKt.rememberComposableLambda(-673551465, true, new Function2() { // from class: kntr.common.compose.launcher.ComposeContainerStyleKt$composeContainerStyle$2$1$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit style$lambda$0$0;
                    style$lambda$0$0 = ComposeContainerStyleKt$composeContainerStyle$2$1.style$lambda$0$0(orig, modifier, (Composer) obj, ((Integer) obj2).intValue());
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
        ComposerKt.sourceInformation($composer, "C46@1656L16:ComposeContainerStyle.kt#2jy5aq");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-673551465, $changed, -1, "kntr.common.compose.launcher.composeContainerStyle$delegate.<anonymous>.<no name provided>.style.<anonymous>.<anonymous> (ComposeContainerStyle.kt:46)");
            }
            $orig.invoke($modifier, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}