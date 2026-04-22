package video.biz.offline.list.ui.page;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.String2_commonMainKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.ui.widget.OfflinePageHeaderKt;

/* compiled from: OfflineSettingsPage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ComposableSingletons$OfflineSettingsPageKt {
    public static final ComposableSingletons$OfflineSettingsPageKt INSTANCE = new ComposableSingletons$OfflineSettingsPageKt();

    /* renamed from: lambda$-1953785919  reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f9lambda$1953785919 = ComposableLambdaKt.composableLambdaInstance(-1953785919, false, new Function3() { // from class: video.biz.offline.list.ui.page.ComposableSingletons$OfflineSettingsPageKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1953785919$lambda$0;
            lambda__1953785919$lambda$0 = ComposableSingletons$OfflineSettingsPageKt.lambda__1953785919$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1953785919$lambda$0;
        }
    });

    /* renamed from: lambda$-251073371  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f10lambda$251073371 = ComposableLambdaKt.composableLambdaInstance(-251073371, false, new Function2() { // from class: video.biz.offline.list.ui.page.ComposableSingletons$OfflineSettingsPageKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__251073371$lambda$0;
            lambda__251073371$lambda$0 = ComposableSingletons$OfflineSettingsPageKt.lambda__251073371$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__251073371$lambda$0;
        }
    });

    /* renamed from: getLambda$-1953785919$ui_debug  reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m2845getLambda$1953785919$ui_debug() {
        return f9lambda$1953785919;
    }

    /* renamed from: getLambda$-251073371$ui_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2846getLambda$251073371$ui_debug() {
        return f10lambda$251073371;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__251073371$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C48@2176L243:OfflineSettingsPage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-251073371, $changed, -1, "video.biz.offline.list.ui.page.ComposableSingletons$OfflineSettingsPageKt.lambda$-251073371.<anonymous> (OfflineSettingsPage.kt:48)");
            }
            OfflinePageHeaderKt.m2949OfflinePageHeaderGmEhDVc(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2272(PlayerbaseresRes.INSTANCE.getString())), SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), false, false, false, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, null, null, f9lambda$1953785919, $composer, 100663344, 252);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1953785919$lambda$0(RowScope $this$OfflinePageHeader, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$OfflinePageHeader, "$this$OfflinePageHeader");
        ComposerKt.sourceInformation($composer, "C:OfflineSettingsPage.kt#rawcr6");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1953785919, $changed, -1, "video.biz.offline.list.ui.page.ComposableSingletons$OfflineSettingsPageKt.lambda$-1953785919.<anonymous> (OfflineSettingsPage.kt:51)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}