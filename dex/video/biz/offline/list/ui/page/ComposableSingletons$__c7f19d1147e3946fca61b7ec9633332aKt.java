package video.biz.offline.list.ui.page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: __c7f19d1147e3946fca61b7ec9633332a.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ComposableSingletons$__c7f19d1147e3946fca61b7ec9633332aKt {
    public static final ComposableSingletons$__c7f19d1147e3946fca61b7ec9633332aKt INSTANCE = new ComposableSingletons$__c7f19d1147e3946fca61b7ec9633332aKt();

    /* renamed from: lambda$-1601042457  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f15lambda$1601042457 = ComposableLambdaKt.composableLambdaInstance(-1601042457, false, new Function2() { // from class: video.biz.offline.list.ui.page.ComposableSingletons$__c7f19d1147e3946fca61b7ec9633332aKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__1601042457$lambda$0;
            lambda__1601042457$lambda$0 = ComposableSingletons$__c7f19d1147e3946fca61b7ec9633332aKt.lambda__1601042457$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__1601042457$lambda$0;
        }
    });

    /* renamed from: getLambda$-1601042457$ui_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2857getLambda$1601042457$ui_debug() {
        return f15lambda$1601042457;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1601042457$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C10@382L27:__c7f19d1147e3946fca61b7ec9633332a.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1601042457, $changed, -1, "video.biz.offline.list.ui.page.ComposableSingletons$__c7f19d1147e3946fca61b7ec9633332aKt.lambda$-1601042457.<anonymous> (__c7f19d1147e3946fca61b7ec9633332a.kt:10)");
            }
            OfflineSettingsPageKt.OfflineCacheSettings($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}