package usercenter;

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
import bili.resource.profile.ProfileRes;
import bili.resource.profile.String0_commonMainKt;
import com.bilibili.compose.theme.BiliTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: RecommendHandleDialog.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ComposableSingletons$RecommendHandleDialogKt {
    public static final ComposableSingletons$RecommendHandleDialogKt INSTANCE = new ComposableSingletons$RecommendHandleDialogKt();
    private static Function3<RowScope, Composer, Integer, Unit> lambda$35851535 = ComposableLambdaKt.composableLambdaInstance(35851535, false, new Function3() { // from class: usercenter.ComposableSingletons$RecommendHandleDialogKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_35851535$lambda$0;
            lambda_35851535$lambda$0 = ComposableSingletons$RecommendHandleDialogKt.lambda_35851535$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_35851535$lambda$0;
        }
    });

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$35851535$usercenter_debug() {
        return lambda$35851535;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_35851535$lambda$0(RowScope $this$TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C116@4584L9,117@4645L6,114@4432L252:RecommendHandleDialog.kt#xobjkw");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(35851535, $changed, -1, "usercenter.ComposableSingletons$RecommendHandleDialogKt.lambda$35851535.<anonymous> (RecommendHandleDialog.kt:114)");
            }
            TextKt.Text-Nvy7gAk(ProfileRes.INSTANCE.getString(String0_commonMainKt.getProfile_global_string_2(ProfileRes.INSTANCE.getString())), (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16(), $composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}