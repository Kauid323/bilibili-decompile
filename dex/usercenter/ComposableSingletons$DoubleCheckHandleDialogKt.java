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
import bili.resource.common.CommonRes;
import bili.resource.common.String0_commonMainKt;
import com.bilibili.compose.theme.BiliTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DoubleCheckHandleDialog.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ComposableSingletons$DoubleCheckHandleDialogKt {
    public static final ComposableSingletons$DoubleCheckHandleDialogKt INSTANCE = new ComposableSingletons$DoubleCheckHandleDialogKt();
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1193782949 = ComposableLambdaKt.composableLambdaInstance(1193782949, false, new Function3() { // from class: usercenter.ComposableSingletons$DoubleCheckHandleDialogKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_1193782949$lambda$0;
            lambda_1193782949$lambda$0 = ComposableSingletons$DoubleCheckHandleDialogKt.lambda_1193782949$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_1193782949$lambda$0;
        }
    });

    /* renamed from: lambda$-1623598770  reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f3lambda$1623598770 = ComposableLambdaKt.composableLambdaInstance(-1623598770, false, new Function3() { // from class: usercenter.ComposableSingletons$DoubleCheckHandleDialogKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1623598770$lambda$0;
            lambda__1623598770$lambda$0 = ComposableSingletons$DoubleCheckHandleDialogKt.lambda__1623598770$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1623598770$lambda$0;
        }
    });

    /* renamed from: getLambda$-1623598770$usercenter_debug  reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m2712getLambda$1623598770$usercenter_debug() {
        return f3lambda$1623598770;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1193782949$usercenter_debug() {
        return lambda$1193782949;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1193782949$lambda$0(RowScope $this$TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C111@4199L9,112@4260L6,109@4048L251:DoubleCheckHandleDialog.kt#xobjkw");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1193782949, $changed, -1, "usercenter.ComposableSingletons$DoubleCheckHandleDialogKt.lambda$1193782949.<anonymous> (DoubleCheckHandleDialog.kt:109)");
            }
            TextKt.Text-Nvy7gAk(CommonRes.INSTANCE.getString(String0_commonMainKt.getCommon_global_string_238(CommonRes.INSTANCE.getString())), (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16(), $composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1623598770$lambda$0(RowScope $this$TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C123@4695L9,124@4756L6,121@4544L256:DoubleCheckHandleDialog.kt#xobjkw");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1623598770, $changed, -1, "usercenter.ComposableSingletons$DoubleCheckHandleDialogKt.lambda$-1623598770.<anonymous> (DoubleCheckHandleDialog.kt:121)");
            }
            TextKt.Text-Nvy7gAk(CommonRes.INSTANCE.getString(String0_commonMainKt.getCommon_global_string_202(CommonRes.INSTANCE.getString())), (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16(), $composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}