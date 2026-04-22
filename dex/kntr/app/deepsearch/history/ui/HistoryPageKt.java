package kntr.app.deepsearch.history.ui;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeDayNight;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.deepsearch.base.model.history.DSHistoryData;
import kntr.app.deepsearch.history.DSHistoryViewModel;
import kntr.app.deepsearch.history.di.DSHistoryEntryPoint;
import kntr.app.deepsearch.stub.PageStub_androidKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HistoryPage.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u00012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"HistoryPage", RoomRecommendViewModel.EMPTY_CURSOR, "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "history-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class HistoryPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HistoryPage$lambda$3(String str, int i, int i2, Composer composer, int i3) {
        HistoryPage(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void HistoryPage(String sessionId, Composer $composer, final int $changed, final int i) {
        final String sessionId2;
        Composer $composer2 = $composer.startRestartGroup(505244331);
        ComposerKt.sourceInformation($composer2, "C(HistoryPage)N(sessionId)33@1378L24,35@1451L232,42@1714L16,45@1788L52,49@1846L21,51@1883L563,51@1873L573:HistoryPage.kt#a2kngy");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            sessionId2 = sessionId;
        } else if (($changed & 6) == 0) {
            sessionId2 = sessionId;
            $dirty |= $composer2.changed(sessionId2) ? 4 : 2;
        } else {
            sessionId2 = sessionId;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            String sessionId3 = i2 != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : sessionId2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(505244331, $dirty2, -1, "kntr.app.deepsearch.history.ui.HistoryPage (HistoryPage.kt:32)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 208503123, "CC(remember):HistoryPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
                Object value$iv = ((DSHistoryEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(DSHistoryEntryPoint.class))).getDSHistoryComponentFactory().build(scope, sessionId3 == null ? RoomRecommendViewModel.EMPTY_CURSOR : sessionId3).viewModel();
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            DSHistoryViewModel viewModel = (DSHistoryViewModel) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final State data = SnapshotStateKt.collectAsState(viewModel.getData(), (CoroutineContext) null, $composer2, 0, 1);
            ComposerKt.sourceInformationMarkerStart($composer2, 208513727, "CC(remember):HistoryPage.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (KFunction) new HistoryPageKt$HistoryPage$dispatcher$1$1(viewModel);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Function1 dispatcher = (KFunction) it$iv2;
            PageStub_androidKt.PushHistoryPageStub($composer2, 0);
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(714157043, true, new Function2() { // from class: kntr.app.deepsearch.history.ui.HistoryPageKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit HistoryPage$lambda$2;
                    HistoryPage$lambda$2 = HistoryPageKt.HistoryPage$lambda$2(data, dispatcher, (Composer) obj, ((Integer) obj2).intValue());
                    return HistoryPage$lambda$2;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            sessionId2 = sessionId3;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.history.ui.HistoryPageKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit HistoryPage$lambda$3;
                    HistoryPage$lambda$3 = HistoryPageKt.HistoryPage$lambda$3(sessionId2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return HistoryPage$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HistoryPage$lambda$2(State $data, Function1 $dispatcher, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C52@1910L28,53@1971L13,54@2040L62,54@2016L86,63@2279L6,64@2346L10,58@2112L328:HistoryPage.kt#a2kngy");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(714157043, $changed, -1, "kntr.app.deepsearch.history.ui.HistoryPage.<anonymous> (HistoryPage.kt:52)");
            }
            SystemUiController controller = SystemUI_androidKt.rememberSystemUiController($composer, 0);
            boolean isNight = BiliTheme.INSTANCE.getDayNightTheme($composer, BiliTheme.$stable) == ThemeDayNight.Night;
            Boolean valueOf = Boolean.valueOf(isNight);
            ComposerKt.sourceInformationMarkerStart($composer, -889843951, "CC(remember):HistoryPage.kt#9igjgp");
            boolean invalid$iv = $composer.changed(controller) | $composer.changed(isNight);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new HistoryPageKt$HistoryPage$1$1$1(controller, isNight, null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv, $composer, 0);
            HistoryKt.HistoryList((DSHistoryData) $data.getValue(), SizeKt.fillMaxSize$default(WindowInsetsPaddingKt.windowInsetsPadding(BackgroundKt.background-bw27NRU$default(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg2-0d7_KjU(), (Shape) null, 2, (Object) null), WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, $composer, 6)), 0.0f, 1, (Object) null), $dispatcher, $composer, 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}