package kntr.common.photonic.aphro.ui.component;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MediaItem.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$MediaItemKt {
    public static final ComposableSingletons$MediaItemKt INSTANCE = new ComposableSingletons$MediaItemKt();

    /* renamed from: lambda$-1411610164  reason: not valid java name */
    private static Function3<AnimatedVisibilityScope, Composer, Integer, Unit> f55lambda$1411610164 = ComposableLambdaKt.composableLambdaInstance(-1411610164, false, new Function3() { // from class: kntr.common.photonic.aphro.ui.component.ComposableSingletons$MediaItemKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1411610164$lambda$0;
            lambda__1411610164$lambda$0 = ComposableSingletons$MediaItemKt.lambda__1411610164$lambda$0((AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1411610164$lambda$0;
        }
    });

    /* renamed from: lambda$-1962986678  reason: not valid java name */
    private static Function3<AnimatedVisibilityScope, Composer, Integer, Unit> f56lambda$1962986678 = ComposableLambdaKt.composableLambdaInstance(-1962986678, false, new Function3() { // from class: kntr.common.photonic.aphro.ui.component.ComposableSingletons$MediaItemKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1962986678$lambda$0;
            lambda__1962986678$lambda$0 = ComposableSingletons$MediaItemKt.lambda__1962986678$lambda$0((AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1962986678$lambda$0;
        }
    });

    /* renamed from: getLambda$-1411610164$ui_debug  reason: not valid java name */
    public final Function3<AnimatedVisibilityScope, Composer, Integer, Unit> m2253getLambda$1411610164$ui_debug() {
        return f55lambda$1411610164;
    }

    /* renamed from: getLambda$-1962986678$ui_debug  reason: not valid java name */
    public final Function3<AnimatedVisibilityScope, Composer, Integer, Unit> m2254getLambda$1962986678$ui_debug() {
        return f56lambda$1962986678;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1411610164$lambda$0(AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C139@5386L218:MediaItem.kt#gh748z");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1411610164, $changed, -1, "kntr.common.photonic.aphro.ui.component.ComposableSingletons$MediaItemKt.lambda$-1411610164.<anonymous> (MediaItem.kt:139)");
        }
        BoxKt.Box(ZIndexModifierKt.zIndex(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), 1.0f), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1962986678$lambda$0(AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C189@6671L502:MediaItem.kt#gh748z");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1962986678, $changed, -1, "kntr.common.photonic.aphro.ui.component.ComposableSingletons$MediaItemKt.lambda$-1962986678.<anonymous> (MediaItem.kt:189)");
        }
        BoxKt.Box(BackgroundKt.background$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), Color.box-impl(Color.Companion.getTransparent-0d7_KjU())), TuplesKt.to(Float.valueOf(0.5f), Color.box-impl(Color.Companion.getTransparent-0d7_KjU())), TuplesKt.to(Float.valueOf(1.0f), Color.box-impl(Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null)))}, 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}