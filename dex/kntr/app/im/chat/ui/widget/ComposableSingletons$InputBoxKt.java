package kntr.app.im.chat.ui.widget;

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
import bili.resource.im.Res;
import bili.resource.im.String0_commonMainKt;
import com.bilibili.compose.theme.BiliTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: InputBox.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$InputBoxKt {
    public static final ComposableSingletons$InputBoxKt INSTANCE = new ComposableSingletons$InputBoxKt();
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1040893103 = ComposableLambdaKt.composableLambdaInstance(1040893103, false, new Function3() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$InputBoxKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_1040893103$lambda$0;
            lambda_1040893103$lambda$0 = ComposableSingletons$InputBoxKt.lambda_1040893103$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_1040893103$lambda$0;
        }
    });

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1040893103$ui_debug() {
        return lambda$1040893103;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1040893103$lambda$0(RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C260@10469L47,261@10560L9,259@10432L164:InputBox.kt#92mklk");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1040893103, $changed, -1, "kntr.app.im.chat.ui.widget.ComposableSingletons$InputBoxKt.lambda$1040893103.<anonymous> (InputBox.kt:259)");
            }
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getIm_global_string_219(Res.string.INSTANCE), $composer, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT13(), $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}