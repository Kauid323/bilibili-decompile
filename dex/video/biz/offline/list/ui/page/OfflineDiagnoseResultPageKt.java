package video.biz.offline.list.ui.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import kntr.common.trio.systemui.SystemUIKt;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.LogKt;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.list.logic.statemachine.OfflineResolveDataStore;
import video.biz.offline.list.logic.statemachine.OfflineResolvePageEvent;
import video.biz.offline.list.logic.statemachine.OfflineResolveState;
import video.biz.offline.list.ui.widget.DiagnoseResultReportButton_androidKt;

/* compiled from: OfflineDiagnoseResultPage.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0005\u001a)\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\nH\u0001¢\u0006\u0002\u0010\f\u001a\u001f\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0001¢\u0006\u0002\u0010\u0012\u001a\u0015\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0015\u001a\u0015\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0015\u001a\u0015\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0015\u001a\u0015\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0015\u001a\u001d\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0005¨\u0006\u001d²\u0006\n\u0010\u001e\u001a\u00020\bX\u008a\u0084\u0002²\u0006\n\u0010\u001f\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010 \u001a\u00020!X\u008a\u0084\u0002²\u0006\n\u0010\u001b\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\"\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\"\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\"\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\"\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\"\u001a\u00020\u0003X\u008a\u008e\u0002"}, d2 = {"OfflineDiagnoseResultPage", "", "videoId", "", "cid", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "OfflineDiagnoseResultScreen", "uiState", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolveState;", "onEvent", "Lkotlin/Function1;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolvePageEvent;", "(Lvideo/biz/offline/list/logic/statemachine/OfflineResolveState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "OfflineDiagnoseResultContent", "video", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "OfflineStorage", "videoEntity", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;Landroidx/compose/runtime/Composer;I)V", "OfflineFileTree", "OfflineTips", "OfflineResult", "OfflineDesc", "OfflineBasic", RankRouter.BundleKey.ACTION_PARAM_TITLE, "desc", "ui_debug", "state", "buttonText", "buttonVisible", "", "content"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineDiagnoseResultPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineBasic$lambda$1(String str, String str2, int i, Composer composer, int i2) {
        OfflineBasic(str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDesc$lambda$7(OfflineVideoEntity offlineVideoEntity, int i, Composer composer, int i2) {
        OfflineDesc(offlineVideoEntity, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDiagnoseResultContent$lambda$1(OfflineVideoEntity offlineVideoEntity, Modifier modifier, int i, int i2, Composer composer, int i3) {
        OfflineDiagnoseResultContent(offlineVideoEntity, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDiagnoseResultPage$lambda$4(String str, String str2, int i, Composer composer, int i2) {
        OfflineDiagnoseResultPage(str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDiagnoseResultScreen$lambda$1(OfflineResolveState offlineResolveState, Function1 function1, int i, Composer composer, int i2) {
        OfflineDiagnoseResultScreen(offlineResolveState, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineFileTree$lambda$7(OfflineVideoEntity offlineVideoEntity, int i, Composer composer, int i2) {
        OfflineFileTree(offlineVideoEntity, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineResult$lambda$7(OfflineVideoEntity offlineVideoEntity, int i, Composer composer, int i2) {
        OfflineResult(offlineVideoEntity, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineStorage$lambda$7(OfflineVideoEntity offlineVideoEntity, int i, Composer composer, int i2) {
        OfflineStorage(offlineVideoEntity, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineTips$lambda$7(OfflineVideoEntity offlineVideoEntity, int i, Composer composer, int i2) {
        OfflineTips(offlineVideoEntity, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void OfflineDiagnoseResultPage(final String videoId, final String cid, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        Intrinsics.checkNotNullParameter(cid, "cid");
        Composer $composer2 = $composer.startRestartGroup(344769252);
        ComposerKt.sourceInformation($composer2, "C(OfflineDiagnoseResultPage)N(videoId,cid)63@2976L7,64@3000L24,67@3060L164,75@3273L40,77@3340L261,77@3319L282,87@3617L227,87@3607L237:OfflineDiagnoseResultPage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(videoId) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(cid) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(344769252, $dirty2, -1, "video.biz.offline.list.ui.page.OfflineDiagnoseResultPage (OfflineDiagnoseResultPage.kt:62)");
            }
            CompositionLocal this_$iv = ToasterKt.getLocalToaster();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Toaster toaster = (Toaster) consume;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 610775560, "CC(remember):OfflineDiagnoseResultPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new OfflineResolveDataStore(scope, videoId, cid);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final OfflineResolveDataStore resultDataStore = (OfflineResolveDataStore) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final State state$delegate = SnapshotStateKt.collectAsState(resultDataStore.getMachine().getState(), OfflineResolveState.Idle.INSTANCE, (CoroutineContext) null, $composer2, OfflineResolveState.Idle.$stable << 3, 2);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 610784617, "CC(remember):OfflineDiagnoseResultPage.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(resultDataStore) | $composer2.changedInstance(toaster);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new OfflineDiagnoseResultPageKt$OfflineDiagnoseResultPage$1$1(resultDataStore, toaster, null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv2, $composer2, 6);
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(914439324, true, new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDiagnoseResultPageKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineDiagnoseResultPage$lambda$3;
                    OfflineDiagnoseResultPage$lambda$3 = OfflineDiagnoseResultPageKt.OfflineDiagnoseResultPage$lambda$3(OfflineResolveDataStore.this, state$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineDiagnoseResultPage$lambda$3;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDiagnoseResultPageKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineDiagnoseResultPage$lambda$4;
                    OfflineDiagnoseResultPage$lambda$4 = OfflineDiagnoseResultPageKt.OfflineDiagnoseResultPage$lambda$4(videoId, cid, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineDiagnoseResultPage$lambda$4;
                }
            });
        }
    }

    private static final OfflineResolveState OfflineDiagnoseResultPage$lambda$1(State<? extends OfflineResolveState> state) {
        Object thisObj$iv = state.getValue();
        return (OfflineResolveState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDiagnoseResultPage$lambda$3(OfflineResolveDataStore $resultDataStore, State $state$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C88@3644L28,89@3692L20,93@3802L25,91@3722L116:OfflineDiagnoseResultPage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(914439324, $changed, -1, "video.biz.offline.list.ui.page.OfflineDiagnoseResultPage.<anonymous> (OfflineDiagnoseResultPage.kt:88)");
            }
            SystemUiController controller = SystemUI_androidKt.rememberSystemUiController($composer, 0);
            SystemUIKt.setStatusBarByGarb(controller, $composer, 0);
            OfflineResolveState OfflineDiagnoseResultPage$lambda$1 = OfflineDiagnoseResultPage$lambda$1($state$delegate);
            ComposerKt.sourceInformationMarkerStart($composer, -1692099371, "CC(remember):OfflineDiagnoseResultPage.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($resultDataStore);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (KFunction) new OfflineDiagnoseResultPageKt$OfflineDiagnoseResultPage$2$1$1($resultDataStore);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            OfflineDiagnoseResultScreen(OfflineDiagnoseResultPage$lambda$1, (KFunction) it$iv, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void OfflineDiagnoseResultScreen(final OfflineResolveState uiState, final Function1<? super OfflineResolvePageEvent, Unit> function1, Composer $composer, final int $changed) {
        Composer $composer2;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(function1, "onEvent");
        Composer $composer3 = $composer.startRestartGroup(1750981226);
        ComposerKt.sourceInformation($composer3, "C(OfflineDiagnoseResultScreen)N(uiState,onEvent)104@4059L6,114@4413L3816,103@3992L4237:OfflineDiagnoseResultPage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(uiState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1750981226, $dirty2, -1, "video.biz.offline.list.ui.page.OfflineDiagnoseResultScreen (OfflineDiagnoseResultPage.kt:102)");
            }
            $composer2 = $composer3;
            ScaffoldKt.Scaffold-TvnljyQ(BackgroundKt.background-bw27NRU$default(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa0-0d7_KjU(), (Shape) null, 2, (Object) null), ComposableSingletons$OfflineDiagnoseResultPageKt.INSTANCE.m2843getLambda$339833810$ui_debug(), (Function2) null, (Function2) null, (Function2) null, 0, 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(2059134649, true, new Function3() { // from class: video.biz.offline.list.ui.page.OfflineDiagnoseResultPageKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit OfflineDiagnoseResultScreen$lambda$0;
                    OfflineDiagnoseResultScreen$lambda$0 = OfflineDiagnoseResultPageKt.OfflineDiagnoseResultScreen$lambda$0(OfflineResolveState.this, function1, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return OfflineDiagnoseResultScreen$lambda$0;
                }
            }, $composer3, 54), $composer2, 805306416, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDiagnoseResultPageKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineDiagnoseResultScreen$lambda$1;
                    OfflineDiagnoseResultScreen$lambda$1 = OfflineDiagnoseResultPageKt.OfflineDiagnoseResultScreen$lambda$1(OfflineResolveState.this, function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineDiagnoseResultScreen$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDiagnoseResultScreen$lambda$0(OfflineResolveState $uiState, final Function1 $onEvent, PaddingValues innerPadding, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
        ComposerKt.sourceInformation($composer, "CN(innerPadding):OfflineDiagnoseResultPage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(innerPadding) ? 4 : 2;
        }
        if ($composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2059134649, $dirty, -1, "video.biz.offline.list.ui.page.OfflineDiagnoseResultScreen.<anonymous> (OfflineDiagnoseResultPage.kt:115)");
            }
            if ($uiState instanceof OfflineResolveState.Error) {
                $composer.startReplaceGroup(-1337461734);
                $composer.endReplaceGroup();
            } else if (!($uiState instanceof OfflineResolveState.OfflineResolvePageUiState)) {
                if (!Intrinsics.areEqual($uiState, OfflineResolveState.Idle.INSTANCE)) {
                    if (!Intrinsics.areEqual($uiState, OfflineResolveState.Loading.INSTANCE)) {
                        $composer.startReplaceGroup(-1151521151);
                        $composer.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    $composer.startReplaceGroup(-1333862882);
                    $composer.endReplaceGroup();
                    LogKt.getVBLog().debug("OfflineResolveState Loading.");
                } else {
                    $composer.startReplaceGroup(-1333979039);
                    $composer.endReplaceGroup();
                    LogKt.getVBLog().debug("OfflineResolveState Idle.");
                }
            } else {
                $composer.startReplaceGroup(-1337276881);
                ComposerKt.sourceInformation($composer, "");
                if (((OfflineResolveState.OfflineResolvePageUiState) $uiState).getEntity() != null) {
                    $composer.startReplaceGroup(-1337236767);
                    ComposerKt.sourceInformation($composer, "121@4677L31,122@4750L55,124@4848L122,124@4827L143,128@4992L2899");
                    ComposerKt.sourceInformationMarkerStart($composer, -1151517288, "CC(remember):OfflineDiagnoseResultPage.kt#9igjgp");
                    Object it$iv = $composer.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                        $composer.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    final MutableState buttonText$delegate = (MutableState) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, -1151514928, "CC(remember):OfflineDiagnoseResultPage.kt#9igjgp");
                    Object it$iv2 = $composer.rememberedValue();
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: video.biz.offline.list.ui.page.OfflineDiagnoseResultPageKt$$ExternalSyntheticLambda13
                            public final Object invoke() {
                                boolean OfflineDiagnoseResultScreen$lambda$0$3$0;
                                OfflineDiagnoseResultScreen$lambda$0$3$0 = OfflineDiagnoseResultPageKt.OfflineDiagnoseResultScreen$lambda$0$3$0(buttonText$delegate);
                                return Boolean.valueOf(OfflineDiagnoseResultScreen$lambda$0$3$0);
                            }
                        });
                        $composer.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                    }
                    State buttonVisible$delegate = (State) it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Unit unit = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer, -1151511725, "CC(remember):OfflineDiagnoseResultPage.kt#9igjgp");
                    boolean invalid$iv = $composer.changedInstance($uiState);
                    Object it$iv3 = $composer.rememberedValue();
                    if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
                        Object value$iv3 = (Function2) new OfflineDiagnoseResultPageKt$OfflineDiagnoseResultScreen$1$1$1($uiState, buttonText$delegate, null);
                        $composer.updateRememberedValue(value$iv3);
                        it$iv3 = value$iv3;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    EffectsKt.LaunchedEffect(unit, (Function2) it$iv3, $composer, 6);
                    Modifier modifier$iv = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), innerPadding);
                    ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                    CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                    Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer.startReusableNode();
                    if ($composer.getInserting()) {
                        factory$iv$iv$iv = factory$iv$iv$iv2;
                        $composer.createNode(factory$iv$iv$iv);
                    } else {
                        factory$iv$iv$iv = factory$iv$iv$iv2;
                        $composer.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                    int i = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    int i2 = ((0 >> 6) & 112) | 6;
                    BoxScope $this$OfflineDiagnoseResultScreen_u24lambda_u240_u246 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer, -132492621, "C138@5448L6,134@5220L320:OfflineDiagnoseResultPage.kt#rawcr6");
                    OfflineVideoEntity entity = ((OfflineResolveState.OfflineResolvePageUiState) $uiState).getEntity();
                    Intrinsics.checkNotNull(entity);
                    OfflineDiagnoseResultContent(entity, PaddingKt.padding-qDBjuR0$default(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(15), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 13, (Object) null), $composer, OfflineVideoEntity.$stable, 0);
                    if (((OfflineResolveState.OfflineResolvePageUiState) $uiState).getUploading()) {
                        $composer.startReplaceGroup(-132160457);
                        ComposerKt.sourceInformation($composer, "143@5643L2,143@5617L1564");
                        ComposerKt.sourceInformationMarkerStart($composer, -419905063, "CC(remember):OfflineDiagnoseResultPage.kt#9igjgp");
                        Object it$iv4 = $composer.rememberedValue();
                        if (it$iv4 == Composer.Companion.getEmpty()) {
                            Object value$iv4 = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineDiagnoseResultPageKt$$ExternalSyntheticLambda14
                                public final Object invoke() {
                                    Unit unit2;
                                    unit2 = Unit.INSTANCE;
                                    return unit2;
                                }
                            };
                            $composer.updateRememberedValue(value$iv4);
                            it$iv4 = value$iv4;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        AndroidDialog_androidKt.Dialog((Function0) it$iv4, (DialogProperties) null, ComposableSingletons$OfflineDiagnoseResultPageKt.INSTANCE.m2842getLambda$1307085819$ui_debug(), $composer, 390, 2);
                    } else {
                        $composer.startReplaceGroup(-137753973);
                    }
                    $composer.endReplaceGroup();
                    if (OfflineDiagnoseResultScreen$lambda$0$4(buttonVisible$delegate)) {
                        $composer.startReplaceGroup(-130511846);
                        ComposerKt.sourceInformation($composer, "181@7701L111,174@7282L561");
                        Modifier align = $this$OfflineDiagnoseResultScreen_u24lambda_u240_u246.align(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(15), Dp.constructor-impl(60), 3, (Object) null), Alignment.Companion.getBottomEnd());
                        boolean buttonEnabled = ((OfflineResolveState.OfflineResolvePageUiState) $uiState).getButtonEnabled();
                        String OfflineDiagnoseResultScreen$lambda$0$1 = OfflineDiagnoseResultScreen$lambda$0$1(buttonText$delegate);
                        ComposerKt.sourceInformationMarkerStart($composer, -419839098, "CC(remember):OfflineDiagnoseResultPage.kt#9igjgp");
                        boolean invalid$iv2 = $composer.changed($onEvent);
                        Object it$iv5 = $composer.rememberedValue();
                        if (invalid$iv2 || it$iv5 == Composer.Companion.getEmpty()) {
                            Object value$iv5 = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineDiagnoseResultPageKt$$ExternalSyntheticLambda15
                                public final Object invoke() {
                                    Unit OfflineDiagnoseResultScreen$lambda$0$6$1$0;
                                    OfflineDiagnoseResultScreen$lambda$0$6$1$0 = OfflineDiagnoseResultPageKt.OfflineDiagnoseResultScreen$lambda$0$6$1$0($onEvent);
                                    return OfflineDiagnoseResultScreen$lambda$0$6$1$0;
                                }
                            };
                            $composer.updateRememberedValue(value$iv5);
                            it$iv5 = value$iv5;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        DiagnoseResultReportButton_androidKt.DiagnoseResultReportButton(buttonEnabled, OfflineDiagnoseResultScreen$lambda$0$1, (Function0) it$iv5, align, $composer, 0, 0);
                    } else {
                        $composer.startReplaceGroup(-137753973);
                    }
                    $composer.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endReplaceGroup();
                } else {
                    $composer.startReplaceGroup(-1334084873);
                    ComposerKt.sourceInformation($composer, "188@7937L10");
                    OfflineDataDiagnosePageKt.EmptyTip(null, $composer, 0, 1);
                    $composer.endReplaceGroup();
                }
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final String OfflineDiagnoseResultScreen$lambda$0$1(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean OfflineDiagnoseResultScreen$lambda$0$3$0(MutableState $buttonText$delegate) {
        return OfflineDiagnoseResultScreen$lambda$0$1($buttonText$delegate).length() > 0;
    }

    private static final boolean OfflineDiagnoseResultScreen$lambda$0$4(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDiagnoseResultScreen$lambda$0$6$1$0(Function1 $onEvent) {
        $onEvent.invoke(OfflineResolvePageEvent.Upload.INSTANCE);
        return Unit.INSTANCE;
    }

    public static final void OfflineDiagnoseResultContent(final OfflineVideoEntity video2, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(video2, "video");
        Composer $composer3 = $composer.startRestartGroup(861940778);
        ComposerKt.sourceInformation($composer3, "C(OfflineDiagnoseResultContent)N(video,modifier)211@8467L296,208@8362L401:OfflineDiagnoseResultPage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer3.changed(video2) : $composer3.changedInstance(video2) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        boolean z = false;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(861940778, $dirty2, -1, "video.biz.offline.list.ui.page.OfflineDiagnoseResultContent (OfflineDiagnoseResultPage.kt:207)");
            }
            Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(7));
            ComposerKt.sourceInformationMarkerStart($composer3, -603593358, "CC(remember):OfflineDiagnoseResultPage.kt#9igjgp");
            if (($dirty2 & 14) == 4 || (($dirty2 & 8) != 0 && $composer3.changedInstance(video2))) {
                z = true;
            }
            boolean invalid$iv = z;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineDiagnoseResultPageKt$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj) {
                        Unit OfflineDiagnoseResultContent$lambda$0$0;
                        OfflineDiagnoseResultContent$lambda$0$0 = OfflineDiagnoseResultPageKt.OfflineDiagnoseResultContent$lambda$0$0(OfflineVideoEntity.this, (LazyListScope) obj);
                        return OfflineDiagnoseResultContent$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            LazyDslKt.LazyColumn(modifier3, (LazyListState) null, (PaddingValues) null, false, vertical, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv, $composer3, (($dirty2 >> 3) & 14) | 24576, 494);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDiagnoseResultPageKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineDiagnoseResultContent$lambda$1;
                    OfflineDiagnoseResultContent$lambda$1 = OfflineDiagnoseResultPageKt.OfflineDiagnoseResultContent$lambda$1(OfflineVideoEntity.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineDiagnoseResultContent$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDiagnoseResultContent$lambda$0$0(final OfflineVideoEntity $video, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1410456843, true, new Function3() { // from class: video.biz.offline.list.ui.page.OfflineDiagnoseResultPageKt$$ExternalSyntheticLambda18
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit OfflineDiagnoseResultContent$lambda$0$0$0;
                OfflineDiagnoseResultContent$lambda$0$0$0 = OfflineDiagnoseResultPageKt.OfflineDiagnoseResultContent$lambda$0$0$0(OfflineVideoEntity.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return OfflineDiagnoseResultContent$lambda$0$0$0;
            }
        }), 3, (Object) null);
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(550213278, true, new Function3() { // from class: video.biz.offline.list.ui.page.OfflineDiagnoseResultPageKt$$ExternalSyntheticLambda19
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit OfflineDiagnoseResultContent$lambda$0$0$1;
                OfflineDiagnoseResultContent$lambda$0$0$1 = OfflineDiagnoseResultPageKt.OfflineDiagnoseResultContent$lambda$0$0$1(OfflineVideoEntity.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return OfflineDiagnoseResultContent$lambda$0$0$1;
            }
        }), 3, (Object) null);
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1634062659, true, new Function3() { // from class: video.biz.offline.list.ui.page.OfflineDiagnoseResultPageKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit OfflineDiagnoseResultContent$lambda$0$0$2;
                OfflineDiagnoseResultContent$lambda$0$0$2 = OfflineDiagnoseResultPageKt.OfflineDiagnoseResultContent$lambda$0$0$2(OfflineVideoEntity.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return OfflineDiagnoseResultContent$lambda$0$0$2;
            }
        }), 3, (Object) null);
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(476628700, true, new Function3() { // from class: video.biz.offline.list.ui.page.OfflineDiagnoseResultPageKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit OfflineDiagnoseResultContent$lambda$0$0$3;
                OfflineDiagnoseResultContent$lambda$0$0$3 = OfflineDiagnoseResultPageKt.OfflineDiagnoseResultContent$lambda$0$0$3(OfflineVideoEntity.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return OfflineDiagnoseResultContent$lambda$0$0$3;
            }
        }), 3, (Object) null);
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1707647237, true, new Function3() { // from class: video.biz.offline.list.ui.page.OfflineDiagnoseResultPageKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit OfflineDiagnoseResultContent$lambda$0$0$4;
                OfflineDiagnoseResultContent$lambda$0$0$4 = OfflineDiagnoseResultPageKt.OfflineDiagnoseResultContent$lambda$0$0$4(OfflineVideoEntity.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return OfflineDiagnoseResultContent$lambda$0$0$4;
            }
        }), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDiagnoseResultContent$lambda$0$0$0(OfflineVideoEntity $video, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C213@8496L21:OfflineDiagnoseResultPage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1410456843, $changed, -1, "video.biz.offline.list.ui.page.OfflineDiagnoseResultContent.<anonymous>.<anonymous>.<anonymous> (OfflineDiagnoseResultPage.kt:213)");
            }
            OfflineStorage($video, $composer, OfflineVideoEntity.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDiagnoseResultContent$lambda$0$0$1(OfflineVideoEntity $video, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C216@8555L18:OfflineDiagnoseResultPage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(550213278, $changed, -1, "video.biz.offline.list.ui.page.OfflineDiagnoseResultContent.<anonymous>.<anonymous>.<anonymous> (OfflineDiagnoseResultPage.kt:216)");
            }
            OfflineDesc($video, $composer, OfflineVideoEntity.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDiagnoseResultContent$lambda$0$0$2(OfflineVideoEntity $video, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C219@8611L20:OfflineDiagnoseResultPage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1634062659, $changed, -1, "video.biz.offline.list.ui.page.OfflineDiagnoseResultContent.<anonymous>.<anonymous>.<anonymous> (OfflineDiagnoseResultPage.kt:219)");
            }
            OfflineResult($video, $composer, OfflineVideoEntity.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDiagnoseResultContent$lambda$0$0$3(OfflineVideoEntity $video, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C222@8669L18:OfflineDiagnoseResultPage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(476628700, $changed, -1, "video.biz.offline.list.ui.page.OfflineDiagnoseResultContent.<anonymous>.<anonymous>.<anonymous> (OfflineDiagnoseResultPage.kt:222)");
            }
            OfflineTips($video, $composer, OfflineVideoEntity.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDiagnoseResultContent$lambda$0$0$4(OfflineVideoEntity $video, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C225@8725L22:OfflineDiagnoseResultPage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1707647237, $changed, -1, "video.biz.offline.list.ui.page.OfflineDiagnoseResultContent.<anonymous>.<anonymous>.<anonymous> (OfflineDiagnoseResultPage.kt:225)");
            }
            OfflineFileTree($video, $composer, OfflineVideoEntity.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void OfflineStorage(final OfflineVideoEntity videoEntity, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(videoEntity, "videoEntity");
        Composer $composer2 = $composer.startRestartGroup(-2023661986);
        ComposerKt.sourceInformation($composer2, "C(OfflineStorage)N(videoEntity)232@8850L31,233@8901L31,235@8966L131,235@8938L159:OfflineDiagnoseResultPage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(videoEntity) : $composer2.changedInstance(videoEntity) ? 4 : 2;
        }
        if (!$composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2023661986, $dirty, -1, "video.biz.offline.list.ui.page.OfflineStorage (OfflineDiagnoseResultPage.kt:231)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 881018845, "CC(remember):OfflineDiagnoseResultPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableState title$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 881020477, "CC(remember):OfflineDiagnoseResultPage.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            MutableState content$delegate = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 881022657, "CC(remember):OfflineDiagnoseResultPage.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4 || (($dirty & 8) != 0 && $composer2.changedInstance(videoEntity));
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (Function2) new OfflineDiagnoseResultPageKt$OfflineStorage$1$1(videoEntity, title$delegate, content$delegate, null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(videoEntity, (Function2) it$iv3, $composer2, OfflineVideoEntity.$stable | ($dirty & 14));
            if (OfflineStorage$lambda$4(content$delegate).length() > 0) {
                $composer2.startReplaceGroup(1542058677);
                ComposerKt.sourceInformation($composer2, "241@9139L63");
                OfflineBasic(OfflineStorage$lambda$1(title$delegate), OfflineStorage$lambda$4(content$delegate), $composer2, 0);
            } else {
                $composer2.startReplaceGroup(1532999268);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDiagnoseResultPageKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineStorage$lambda$7;
                    OfflineStorage$lambda$7 = OfflineDiagnoseResultPageKt.OfflineStorage$lambda$7(OfflineVideoEntity.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineStorage$lambda$7;
                }
            });
        }
    }

    private static final String OfflineStorage$lambda$1(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    private static final String OfflineStorage$lambda$4(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    public static final void OfflineFileTree(final OfflineVideoEntity videoEntity, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(videoEntity, "videoEntity");
        Composer $composer2 = $composer.startRestartGroup(-2111680907);
        ComposerKt.sourceInformation($composer2, "C(OfflineFileTree)N(videoEntity)250@9296L31,251@9347L31,253@9412L125,253@9384L153:OfflineDiagnoseResultPage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(videoEntity) : $composer2.changedInstance(videoEntity) ? 4 : 2;
        }
        if (!$composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2111680907, $dirty, -1, "video.biz.offline.list.ui.page.OfflineFileTree (OfflineDiagnoseResultPage.kt:249)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -2100785580, "CC(remember):OfflineDiagnoseResultPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableState title$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -2100783948, "CC(remember):OfflineDiagnoseResultPage.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            MutableState content$delegate = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -2100781774, "CC(remember):OfflineDiagnoseResultPage.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4 || (($dirty & 8) != 0 && $composer2.changedInstance(videoEntity));
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (Function2) new OfflineDiagnoseResultPageKt$OfflineFileTree$1$1(videoEntity, title$delegate, content$delegate, null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(videoEntity, (Function2) it$iv3, $composer2, OfflineVideoEntity.$stable | ($dirty & 14));
            if (OfflineFileTree$lambda$4(content$delegate).length() > 0) {
                $composer2.startReplaceGroup(-699571234);
                ComposerKt.sourceInformation($composer2, "259@9579L63");
                OfflineBasic(OfflineFileTree$lambda$1(title$delegate), OfflineFileTree$lambda$4(content$delegate), $composer2, 0);
            } else {
                $composer2.startReplaceGroup(-709067123);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDiagnoseResultPageKt$$ExternalSyntheticLambda17
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineFileTree$lambda$7;
                    OfflineFileTree$lambda$7 = OfflineDiagnoseResultPageKt.OfflineFileTree$lambda$7(OfflineVideoEntity.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineFileTree$lambda$7;
                }
            });
        }
    }

    private static final String OfflineFileTree$lambda$1(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    private static final String OfflineFileTree$lambda$4(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    public static final void OfflineTips(final OfflineVideoEntity videoEntity, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(videoEntity, "videoEntity");
        Composer $composer2 = $composer.startRestartGroup(1026248887);
        ComposerKt.sourceInformation($composer2, "C(OfflineTips)N(videoEntity)268@9732L31,269@9783L31,271@9848L123,271@9820L151:OfflineDiagnoseResultPage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(videoEntity) : $composer2.changedInstance(videoEntity) ? 4 : 2;
        }
        if (!$composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1026248887, $dirty, -1, "video.biz.offline.list.ui.page.OfflineTips (OfflineDiagnoseResultPage.kt:267)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1617295466, "CC(remember):OfflineDiagnoseResultPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableState title$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1617293834, "CC(remember):OfflineDiagnoseResultPage.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            MutableState content$delegate = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1617291662, "CC(remember):OfflineDiagnoseResultPage.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4 || (($dirty & 8) != 0 && $composer2.changedInstance(videoEntity));
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (Function2) new OfflineDiagnoseResultPageKt$OfflineTips$1$1(videoEntity, title$delegate, content$delegate, null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(videoEntity, (Function2) it$iv3, $composer2, OfflineVideoEntity.$stable | ($dirty & 14));
            if (OfflineTips$lambda$4(content$delegate).length() > 0) {
                $composer2.startReplaceGroup(1403718428);
                ComposerKt.sourceInformation($composer2, "277@10013L63");
                OfflineBasic(OfflineTips$lambda$1(title$delegate), OfflineTips$lambda$4(content$delegate), $composer2, 0);
            } else {
                $composer2.startReplaceGroup(1393792011);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDiagnoseResultPageKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineTips$lambda$7;
                    OfflineTips$lambda$7 = OfflineDiagnoseResultPageKt.OfflineTips$lambda$7(OfflineVideoEntity.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineTips$lambda$7;
                }
            });
        }
    }

    private static final String OfflineTips$lambda$1(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    private static final String OfflineTips$lambda$4(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    public static final void OfflineResult(final OfflineVideoEntity videoEntity, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(videoEntity, "videoEntity");
        Composer $composer2 = $composer.startRestartGroup(76673842);
        ComposerKt.sourceInformation($composer2, "C(OfflineResult)N(videoEntity)286@10168L31,287@10219L31,289@10284L129,289@10256L157:OfflineDiagnoseResultPage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(videoEntity) : $composer2.changedInstance(videoEntity) ? 4 : 2;
        }
        if (!$composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(76673842, $dirty, -1, "video.biz.offline.list.ui.page.OfflineResult (OfflineDiagnoseResultPage.kt:285)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 669120401, "CC(remember):OfflineDiagnoseResultPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableState title$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 669122033, "CC(remember):OfflineDiagnoseResultPage.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            MutableState content$delegate = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 669124211, "CC(remember):OfflineDiagnoseResultPage.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4 || (($dirty & 8) != 0 && $composer2.changedInstance(videoEntity));
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (Function2) new OfflineDiagnoseResultPageKt$OfflineResult$1$1(videoEntity, title$delegate, content$delegate, null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(videoEntity, (Function2) it$iv3, $composer2, OfflineVideoEntity.$stable | ($dirty & 14));
            if (OfflineResult$lambda$4(content$delegate).length() > 0) {
                $composer2.startReplaceGroup(-731827775);
                ComposerKt.sourceInformation($composer2, "295@10455L63");
                OfflineBasic(OfflineResult$lambda$1(title$delegate), OfflineResult$lambda$4(content$delegate), $composer2, 0);
            } else {
                $composer2.startReplaceGroup(-742192656);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDiagnoseResultPageKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineResult$lambda$7;
                    OfflineResult$lambda$7 = OfflineDiagnoseResultPageKt.OfflineResult$lambda$7(OfflineVideoEntity.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineResult$lambda$7;
                }
            });
        }
    }

    private static final String OfflineResult$lambda$1(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    private static final String OfflineResult$lambda$4(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    public static final void OfflineDesc(final OfflineVideoEntity videoEntity, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(videoEntity, "videoEntity");
        Composer $composer2 = $composer.startRestartGroup(1015052286);
        ComposerKt.sourceInformation($composer2, "C(OfflineDesc)N(videoEntity)304@10608L31,305@10659L31,307@10724L125,307@10696L153:OfflineDiagnoseResultPage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(videoEntity) : $composer2.changedInstance(videoEntity) ? 4 : 2;
        }
        if (!$composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1015052286, $dirty, -1, "video.biz.offline.list.ui.page.OfflineDesc (OfflineDiagnoseResultPage.kt:303)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 507672861, "CC(remember):OfflineDiagnoseResultPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableState title$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 507674493, "CC(remember):OfflineDiagnoseResultPage.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            MutableState content$delegate = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 507676667, "CC(remember):OfflineDiagnoseResultPage.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4 || (($dirty & 8) != 0 && $composer2.changedInstance(videoEntity));
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (Function2) new OfflineDiagnoseResultPageKt$OfflineDesc$1$1(videoEntity, title$delegate, content$delegate, null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(videoEntity, (Function2) it$iv3, $composer2, OfflineVideoEntity.$stable | ($dirty & 14));
            if (OfflineDesc$lambda$4(content$delegate).length() > 0) {
                $composer2.startReplaceGroup(-1441738187);
                ComposerKt.sourceInformation($composer2, "313@10891L63");
                OfflineBasic(OfflineDesc$lambda$1(title$delegate), OfflineDesc$lambda$4(content$delegate), $composer2, 0);
            } else {
                $composer2.startReplaceGroup(-1452535580);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDiagnoseResultPageKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineDesc$lambda$7;
                    OfflineDesc$lambda$7 = OfflineDiagnoseResultPageKt.OfflineDesc$lambda$7(OfflineVideoEntity.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineDesc$lambda$7;
                }
            });
        }
    }

    private static final String OfflineDesc$lambda$1(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    private static final String OfflineDesc$lambda$4(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    public static final void OfflineBasic(final String title, final String desc, Composer $composer, final int $changed) {
        Composer $composer2;
        Intrinsics.checkNotNullParameter(title, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        Intrinsics.checkNotNullParameter(desc, "desc");
        Composer $composer3 = $composer.startRestartGroup(158373278);
        ComposerKt.sourceInformation($composer3, "C(OfflineBasic)N(title,desc)325@11048L621:OfflineDiagnoseResultPage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(title) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(desc) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(158373278, $dirty2, -1, "video.biz.offline.list.ui.page.OfflineBasic (OfflineDiagnoseResultPage.kt:324)");
            }
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Dp.constructor-impl(12), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(12), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 10, (Object) null);
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            int $changed$iv$iv = (54 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -988164700, "C334@11311L6,335@11355L9,332@11256L165,340@11484L6,341@11528L9,338@11430L233:OfflineDiagnoseResultPage.kt#rawcr6");
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(title, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT18(), $composer3, ($dirty2 & 14) | 1572864, 0, 131002);
            TextKt.Text-Nvy7gAk(desc, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer3, (($dirty2 >> 3) & 14) | 48, 0, 131064);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDiagnoseResultPageKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineBasic$lambda$1;
                    OfflineBasic$lambda$1 = OfflineDiagnoseResultPageKt.OfflineBasic$lambda$1(title, desc, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineBasic$lambda$1;
                }
            });
        }
    }
}