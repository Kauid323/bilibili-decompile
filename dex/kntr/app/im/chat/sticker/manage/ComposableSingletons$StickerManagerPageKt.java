package kntr.app.im.chat.sticker.manage;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StickerManagerPage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$StickerManagerPageKt {
    public static final ComposableSingletons$StickerManagerPageKt INSTANCE = new ComposableSingletons$StickerManagerPageKt();

    /* renamed from: lambda$-1912151288  reason: not valid java name */
    private static Function3<AnimatedVisibilityScope, Composer, Integer, Unit> f35lambda$1912151288 = ComposableLambdaKt.composableLambdaInstance(-1912151288, false, new Function3() { // from class: kntr.app.im.chat.sticker.manage.ComposableSingletons$StickerManagerPageKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1912151288$lambda$0;
            lambda__1912151288$lambda$0 = ComposableSingletons$StickerManagerPageKt.lambda__1912151288$lambda$0((AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1912151288$lambda$0;
        }
    });

    /* renamed from: getLambda$-1912151288$sticker_debug  reason: not valid java name */
    public final Function3<AnimatedVisibilityScope, Composer, Integer, Unit> m1660getLambda$1912151288$sticker_debug() {
        return f35lambda$1912151288;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1912151288$lambda$0(AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C559@20544L182:StickerManagerPage.kt#is795o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1912151288, $changed, -1, "kntr.app.im.chat.sticker.manage.ComposableSingletons$StickerManagerPageKt.lambda$-1912151288.<anonymous> (StickerManagerPage.kt:559)");
        }
        BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}