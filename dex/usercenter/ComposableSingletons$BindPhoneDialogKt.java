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
import bili.resource.profile.ProfileRes;
import com.bilibili.compose.theme.BiliTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BindPhoneDialog.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ComposableSingletons$BindPhoneDialogKt {
    public static final ComposableSingletons$BindPhoneDialogKt INSTANCE = new ComposableSingletons$BindPhoneDialogKt();

    /* renamed from: lambda$-473162336  reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f1lambda$473162336 = ComposableLambdaKt.composableLambdaInstance(-473162336, false, new Function3() { // from class: usercenter.ComposableSingletons$BindPhoneDialogKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__473162336$lambda$0;
            lambda__473162336$lambda$0 = ComposableSingletons$BindPhoneDialogKt.lambda__473162336$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__473162336$lambda$0;
        }
    });

    /* renamed from: lambda$-56482295  reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f2lambda$56482295 = ComposableLambdaKt.composableLambdaInstance(-56482295, false, new Function3() { // from class: usercenter.ComposableSingletons$BindPhoneDialogKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__56482295$lambda$0;
            lambda__56482295$lambda$0 = ComposableSingletons$BindPhoneDialogKt.lambda__56482295$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__56482295$lambda$0;
        }
    });

    /* renamed from: getLambda$-473162336$usercenter_debug  reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m2710getLambda$473162336$usercenter_debug() {
        return f1lambda$473162336;
    }

    /* renamed from: getLambda$-56482295$usercenter_debug  reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m2711getLambda$56482295$usercenter_debug() {
        return f2lambda$56482295;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__473162336$lambda$0(RowScope $this$TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C109@4305L9,110@4366L6,107@4154L251:BindPhoneDialog.kt#xobjkw");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-473162336, $changed, -1, "usercenter.ComposableSingletons$BindPhoneDialogKt.lambda$-473162336.<anonymous> (BindPhoneDialog.kt:107)");
            }
            TextKt.Text-Nvy7gAk(CommonRes.INSTANCE.getString(String0_commonMainKt.getCommon_global_string_238(CommonRes.INSTANCE.getString())), (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16(), $composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__56482295$lambda$0(RowScope $this$TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C121@4797L9,122@4858L6,119@4644L258:BindPhoneDialog.kt#xobjkw");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-56482295, $changed, -1, "usercenter.ComposableSingletons$BindPhoneDialogKt.lambda$-56482295.<anonymous> (BindPhoneDialog.kt:119)");
            }
            TextKt.Text-Nvy7gAk(ProfileRes.INSTANCE.getString(bili.resource.profile.String0_commonMainKt.getProfile_global_string_47(ProfileRes.INSTANCE.getString())), (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16(), $composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}