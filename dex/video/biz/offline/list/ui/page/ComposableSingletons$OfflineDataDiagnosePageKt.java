package video.biz.offline.list.ui.page;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LifecycleEffectKt;
import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.String2_commonMainKt;
import kntr.common.trio.systemui.SystemUIKt;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.utils.AppInfo_androidKt;
import video.biz.offline.list.logic.statemachine.OfflineDiagnosePageEvent;
import video.biz.offline.list.logic.statemachine.OfflineDiagnosePageStore;
import video.biz.offline.list.logic.statemachine.OfflineDiagnoseState;
import video.biz.offline.list.ui.widget.OfflinePageHeaderKt;

/* compiled from: OfflineDataDiagnosePage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ComposableSingletons$OfflineDataDiagnosePageKt {
    public static final ComposableSingletons$OfflineDataDiagnosePageKt INSTANCE = new ComposableSingletons$OfflineDataDiagnosePageKt();

    /* renamed from: lambda$-273186184  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f5lambda$273186184 = ComposableLambdaKt.composableLambdaInstance(-273186184, false, new Function2() { // from class: video.biz.offline.list.ui.page.ComposableSingletons$OfflineDataDiagnosePageKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__273186184$lambda$0;
            lambda__273186184$lambda$0 = ComposableSingletons$OfflineDataDiagnosePageKt.lambda__273186184$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__273186184$lambda$0;
        }
    });

    /* renamed from: lambda$-2077925654  reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f4lambda$2077925654 = ComposableLambdaKt.composableLambdaInstance(-2077925654, false, new Function3() { // from class: video.biz.offline.list.ui.page.ComposableSingletons$OfflineDataDiagnosePageKt$$ExternalSyntheticLambda2
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__2077925654$lambda$0;
            lambda__2077925654$lambda$0 = ComposableSingletons$OfflineDataDiagnosePageKt.lambda__2077925654$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__2077925654$lambda$0;
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$302151558 = ComposableLambdaKt.composableLambdaInstance(302151558, false, new Function2() { // from class: video.biz.offline.list.ui.page.ComposableSingletons$OfflineDataDiagnosePageKt$$ExternalSyntheticLambda3
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_302151558$lambda$0;
            lambda_302151558$lambda$0 = ComposableSingletons$OfflineDataDiagnosePageKt.lambda_302151558$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_302151558$lambda$0;
        }
    });

    /* renamed from: getLambda$-2077925654$ui_debug  reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m2837getLambda$2077925654$ui_debug() {
        return f4lambda$2077925654;
    }

    /* renamed from: getLambda$-273186184$ui_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2838getLambda$273186184$ui_debug() {
        return f5lambda$273186184;
    }

    public final Function2<Composer, Integer, Unit> getLambda$302151558$ui_debug() {
        return lambda$302151558;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__273186184$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C88@3960L28,89@4010L20,91@4062L34,93@4156L41,95@4254L89,95@4207L136,99@4373L23,104@4529L25,101@4406L159:OfflineDataDiagnosePage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-273186184, $changed, -1, "video.biz.offline.list.ui.page.ComposableSingletons$OfflineDataDiagnosePageKt.lambda$-273186184.<anonymous> (OfflineDataDiagnosePage.kt:88)");
            }
            SystemUiController uiController = SystemUI_androidKt.rememberSystemUiController($composer, 0);
            SystemUIKt.setStatusBarByGarb(uiController, $composer, 0);
            final OfflineDiagnosePageStore resultDataStore = OfflineDataDiagnosePageKt.rememberOfflineDiagnosePageStore($composer, 0);
            State uiState$delegate = SnapshotStateKt.collectAsState(resultDataStore.getStoreMachine().getState(), OfflineDiagnoseState.Idle.INSTANCE, (CoroutineContext) null, $composer, OfflineDiagnoseState.Idle.$stable << 3, 2);
            Lifecycle.Event event = Lifecycle.Event.ON_START;
            ComposerKt.sourceInformationMarkerStart($composer, -538907343, "CC(remember):OfflineDataDiagnosePage.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(resultDataStore);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.page.ComposableSingletons$OfflineDataDiagnosePageKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit lambda__273186184$lambda$0$1$0;
                        lambda__273186184$lambda$0$1$0 = ComposableSingletons$OfflineDataDiagnosePageKt.lambda__273186184$lambda$0$1$0(OfflineDiagnosePageStore.this);
                        return lambda__273186184$lambda$0$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            LifecycleEffectKt.LifecycleEventEffect(event, (LifecycleOwner) null, (Function0) it$iv, $composer, 6, 2);
            LazyListState lazyListState = LazyListStateKt.rememberLazyListState(0, 0, $composer, 0, 3);
            OfflineDiagnoseState lambda__273186184$lambda$0$0 = lambda__273186184$lambda$0$0(uiState$delegate);
            ComposerKt.sourceInformationMarkerStart($composer, -538898607, "CC(remember):OfflineDataDiagnosePage.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance(resultDataStore);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (KFunction) new ComposableSingletons$OfflineDataDiagnosePageKt$lambda$273186184$1$2$1(resultDataStore);
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            OfflineDataDiagnosePageKt.OfflineDataDiagnoseScreen(lambda__273186184$lambda$0$0, lazyListState, null, (KFunction) it$iv2, $composer, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final OfflineDiagnoseState lambda__273186184$lambda$0$0(State<? extends OfflineDiagnoseState> state) {
        Object thisObj$iv = state.getValue();
        return (OfflineDiagnoseState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__273186184$lambda$0$1$0(OfflineDiagnosePageStore $resultDataStore) {
        $resultDataStore.dispatch(OfflineDiagnosePageEvent.FetchAllVideos.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_302151558$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C119@4854L272:OfflineDataDiagnosePage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(302151558, $changed, -1, "video.biz.offline.list.ui.page.ComposableSingletons$OfflineDataDiagnosePageKt.lambda$302151558.<anonymous> (OfflineDataDiagnosePage.kt:119)");
            }
            OfflinePageHeaderKt.m2949OfflinePageHeaderGmEhDVc(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2177(PlayerbaseresRes.INSTANCE.getString())), SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), false, false, !AppInfo_androidKt.isHDApp(), DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, null, null, f4lambda$2077925654, $composer, 100663344, 236);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__2077925654$lambda$0(RowScope $this$OfflinePageHeader, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$OfflinePageHeader, "$this$OfflinePageHeader");
        ComposerKt.sourceInformation($composer, "C:OfflineDataDiagnosePage.kt#rawcr6");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2077925654, $changed, -1, "video.biz.offline.list.ui.page.ComposableSingletons$OfflineDataDiagnosePageKt.lambda$-2077925654.<anonymous> (OfflineDataDiagnosePage.kt:123)");
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