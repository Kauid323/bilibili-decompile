package video.biz.offline.list.ui.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
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
import androidx.compose.ui.unit.Dp;
import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.String2_commonMainKt;
import com.bilibili.compose.theme.BiliTheme;
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
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.utils.AppInfo_androidKt;
import video.biz.offline.base.model.model.StorageInfoModel;
import video.biz.offline.list.logic.statemachine.OfflineSDDiagnosePageState;
import video.biz.offline.list.logic.statemachine.OfflineSDDiagnosePageStore;
import video.biz.offline.list.logic.statemachine.OfflineSDDiagnoseProcedure;
import video.biz.offline.list.ui.widget.OfflinePageHeaderKt;

/* compiled from: OfflineStorageDiagnosePage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ComposableSingletons$OfflineStorageDiagnosePageKt {
    public static final ComposableSingletons$OfflineStorageDiagnosePageKt INSTANCE = new ComposableSingletons$OfflineStorageDiagnosePageKt();
    private static Function3<RowScope, Composer, Integer, Unit> lambda$398415574 = ComposableLambdaKt.composableLambdaInstance(398415574, false, new Function3() { // from class: video.biz.offline.list.ui.page.ComposableSingletons$OfflineStorageDiagnosePageKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_398415574$lambda$0;
            lambda_398415574$lambda$0 = ComposableSingletons$OfflineStorageDiagnosePageKt.lambda_398415574$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_398415574$lambda$0;
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$890377330 = ComposableLambdaKt.composableLambdaInstance(890377330, false, new Function2() { // from class: video.biz.offline.list.ui.page.ComposableSingletons$OfflineStorageDiagnosePageKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_890377330$lambda$0;
            lambda_890377330$lambda$0 = ComposableSingletons$OfflineStorageDiagnosePageKt.lambda_890377330$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_890377330$lambda$0;
        }
    });

    /* renamed from: lambda$-1724003922  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f11lambda$1724003922 = ComposableLambdaKt.composableLambdaInstance(-1724003922, false, new Function2() { // from class: video.biz.offline.list.ui.page.ComposableSingletons$OfflineStorageDiagnosePageKt$$ExternalSyntheticLambda2
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__1724003922$lambda$0;
            lambda__1724003922$lambda$0 = ComposableSingletons$OfflineStorageDiagnosePageKt.lambda__1724003922$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__1724003922$lambda$0;
        }
    });

    /* renamed from: getLambda$-1724003922$ui_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2849getLambda$1724003922$ui_debug() {
        return f11lambda$1724003922;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$398415574$ui_debug() {
        return lambda$398415574;
    }

    public final Function2<Composer, Integer, Unit> getLambda$890377330$ui_debug() {
        return lambda$890377330;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1724003922$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C54@2855L28,55@2903L20,57@2945L41,58@3028L44,60@3103L181,60@3082L202,75@3660L1050,66@3293L1417:OfflineStorageDiagnosePage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1724003922, $changed, -1, "video.biz.offline.list.ui.page.ComposableSingletons$OfflineStorageDiagnosePageKt.lambda$-1724003922.<anonymous> (OfflineStorageDiagnosePage.kt:54)");
            }
            SystemUiController controller = SystemUI_androidKt.rememberSystemUiController($composer, 0);
            SystemUIKt.setStatusBarByGarb(controller, $composer, 0);
            ComposerKt.sourceInformationMarkerStart($composer, 1089610999, "CC(remember):OfflineStorageDiagnosePage.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new OfflineSDDiagnosePageStore();
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            OfflineSDDiagnosePageStore store = (OfflineSDDiagnosePageStore) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            final State state$delegate = SnapshotStateKt.collectAsState(store.getMachine().getState(), new OfflineSDDiagnosePageState(null, null, null, 7, null), (CoroutineContext) null, $composer, OfflineSDDiagnosePageState.$stable << 3, 2);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 1089616195, "CC(remember):OfflineStorageDiagnosePage.kt#9igjgp");
            boolean invalid$iv = $composer.changed(state$delegate) | $composer.changedInstance(store);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new ComposableSingletons$OfflineStorageDiagnosePageKt$lambda$1724003922$1$1$1(store, state$delegate, null);
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv2, $composer, 6);
            ScaffoldKt.Scaffold-TvnljyQ((Modifier) null, lambda$890377330, (Function2) null, (Function2) null, (Function2) null, 0, 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(852271037, true, new Function3() { // from class: video.biz.offline.list.ui.page.ComposableSingletons$OfflineStorageDiagnosePageKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit lambda__1724003922$lambda$0$3;
                    lambda__1724003922$lambda$0$3 = ComposableSingletons$OfflineStorageDiagnosePageKt.lambda__1724003922$lambda$0$3(state$delegate, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return lambda__1724003922$lambda$0$3;
                }
            }, $composer, 54), $composer, 805306416, 509);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflineSDDiagnosePageState lambda__1724003922$lambda$0$1(State<OfflineSDDiagnosePageState> state) {
        Object thisObj$iv = state.getValue();
        return (OfflineSDDiagnosePageState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_890377330$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C68@3342L292:OfflineStorageDiagnosePage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(890377330, $changed, -1, "video.biz.offline.list.ui.page.ComposableSingletons$OfflineStorageDiagnosePageKt.lambda$890377330.<anonymous> (OfflineStorageDiagnosePage.kt:68)");
            }
            OfflinePageHeaderKt.m2949OfflinePageHeaderGmEhDVc(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2236(PlayerbaseresRes.INSTANCE.getString())), SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), false, false, !AppInfo_androidKt.isHDApp(), DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, null, null, lambda$398415574, $composer, 100663344, 236);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_398415574$lambda$0(RowScope $this$OfflinePageHeader, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$OfflinePageHeader, "$this$OfflinePageHeader");
        ComposerKt.sourceInformation($composer, "C:OfflineStorageDiagnosePage.kt#rawcr6");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(398415574, $changed, -1, "video.biz.offline.list.ui.page.ComposableSingletons$OfflineStorageDiagnosePageKt.lambda$398415574.<anonymous> (OfflineStorageDiagnosePage.kt:72)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1724003922$lambda$0$3(State $state$delegate, PaddingValues innerPadding, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
        ComposerKt.sourceInformation($composer, "CN(innerPadding)81@3894L6,76@3690L1010:OfflineStorageDiagnosePage.kt#rawcr6");
        int currentMarker = $composer.getCurrentMarker();
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(innerPadding) ? 4 : 2;
        }
        if ($composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(852271037, $dirty, -1, "video.biz.offline.list.ui.page.ComposableSingletons$OfflineStorageDiagnosePageKt.lambda$-1724003922.<anonymous>.<anonymous> (OfflineStorageDiagnosePage.kt:76)");
            }
            Modifier modifier$iv = PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(PaddingKt.padding(Modifier.Companion, innerPadding), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(12));
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            $composer.startReplaceGroup(-1084537455);
            ComposerKt.sourceInformation($composer, "C85@4003L95,92@4397L17,95@4456L30,101@4658L28:OfflineStorageDiagnosePage.kt#rawcr6");
            OfflineStorageDiagnosePageKt.TitleText(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2222(PlayerbaseresRes.INSTANCE.getString())), $composer, 0);
            StorageInfoModel info = lambda__1724003922$lambda$0$1($state$delegate).getBasicInfo();
            if (info == null) {
                $composer.startReplaceGroup(-1084380689);
                ComposerKt.sourceInformation($composer, "89@4230L96");
                OfflineStorageDiagnosePageKt.NormalText(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2163(PlayerbaseresRes.INSTANCE.getString())), $composer, 0);
                $composer.endToMarker(currentMarker);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
            $composer.startReplaceGroup(-1088530597);
            $composer.endReplaceGroup();
            OfflineStorageDiagnosePageKt.StorageInfo(info, $composer, StorageInfoModel.$stable);
            OfflineStorageDiagnosePageKt.ProcedureInfo(lambda__1724003922$lambda$0$1($state$delegate).getProcedure(), $composer, 0);
            if (lambda__1724003922$lambda$0$1($state$delegate).getProcedure() == OfflineSDDiagnoseProcedure.Finish) {
                OfflineStorageDiagnosePageKt.DiagnoseResult(lambda__1724003922$lambda$0$1($state$delegate).getResult(), $composer, 0);
                $composer.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer.endToMarker(currentMarker);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}