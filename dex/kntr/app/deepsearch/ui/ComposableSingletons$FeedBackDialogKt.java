package kntr.app.deepsearch.ui;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import com.bilibili.compose.theme.BiliTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.app.deepsearch.compose.generated.resources.Res;
import srcs.app.deepsearch.compose.generated.resources.String0_commonMainKt;

/* compiled from: FeedBackDialog.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$FeedBackDialogKt {
    public static final ComposableSingletons$FeedBackDialogKt INSTANCE = new ComposableSingletons$FeedBackDialogKt();

    /* renamed from: lambda$-1113932747  reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f14lambda$1113932747 = ComposableLambdaKt.composableLambdaInstance(-1113932747, false, new Function3() { // from class: kntr.app.deepsearch.ui.ComposableSingletons$FeedBackDialogKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1113932747$lambda$0;
            lambda__1113932747$lambda$0 = ComposableSingletons$FeedBackDialogKt.lambda__1113932747$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1113932747$lambda$0;
        }
    });

    /* renamed from: getLambda$-1113932747$compose_debug  reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m672getLambda$1113932747$compose_debug() {
        return f14lambda$1113932747;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1113932747$lambda$0(RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C257@10655L33,258@10724L6,259@10778L9,256@10626L181:FeedBackDialog.kt#7uvpm4");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1113932747, $changed, -1, "kntr.app.deepsearch.ui.ComposableSingletons$FeedBackDialogKt.lambda$-1113932747.<anonymous> (FeedBackDialog.kt:256)");
            }
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getSubmit(Res.string.INSTANCE), $composer, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16b(), $composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}