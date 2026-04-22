package tv.danmaku.bili.fullscreen.page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bili.resource.account.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import tv.danmaku.bili.BR;

/* compiled from: PasswordLoginPage.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ComposableSingletons$PasswordLoginPageKt {
    public static final ComposableSingletons$PasswordLoginPageKt INSTANCE = new ComposableSingletons$PasswordLoginPageKt();

    /* renamed from: lambda$-1076236361  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f8lambda$1076236361 = ComposableLambdaKt.composableLambdaInstance(-1076236361, false, new Function2() { // from class: tv.danmaku.bili.fullscreen.page.ComposableSingletons$PasswordLoginPageKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__1076236361$lambda$0;
            lambda__1076236361$lambda$0 = ComposableSingletons$PasswordLoginPageKt.lambda__1076236361$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__1076236361$lambda$0;
        }
    });

    /* renamed from: lambda$-1644208584  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f9lambda$1644208584 = ComposableLambdaKt.composableLambdaInstance(-1644208584, false, new Function2() { // from class: tv.danmaku.bili.fullscreen.page.ComposableSingletons$PasswordLoginPageKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__1644208584$lambda$0;
            lambda__1644208584$lambda$0 = ComposableSingletons$PasswordLoginPageKt.lambda__1644208584$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__1644208584$lambda$0;
        }
    });

    /* renamed from: getLambda$-1076236361$accountui_apinkDebug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1054getLambda$1076236361$accountui_apinkDebug() {
        return f8lambda$1076236361;
    }

    /* renamed from: getLambda$-1644208584$accountui_apinkDebug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1055getLambda$1644208584$accountui_apinkDebug() {
        return f9lambda$1644208584;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1076236361$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C132@5046L80:PasswordLoginPage.kt#gqoihp");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1076236361, $changed, -1, "tv.danmaku.bili.fullscreen.page.ComposableSingletons$PasswordLoginPageKt.lambda$-1076236361.<anonymous> (PasswordLoginPage.kt:132)");
            }
            PasswordLoginPageKt.LabelText(R.string.account_global_string_97, null, $composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1644208584$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C133@5140L81:PasswordLoginPage.kt#gqoihp");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1644208584, $changed, -1, "tv.danmaku.bili.fullscreen.page.ComposableSingletons$PasswordLoginPageKt.lambda$-1644208584.<anonymous> (PasswordLoginPage.kt:133)");
            }
            PasswordLoginPageKt.LabelText(R.string.account_global_string_161, null, $composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}