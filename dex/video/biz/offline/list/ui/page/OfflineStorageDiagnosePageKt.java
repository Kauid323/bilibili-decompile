package video.biz.offline.list.ui.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.String2_commonMainKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.model.StorageInfoModel;
import video.biz.offline.list.logic.statemachine.OfflineSDDiagnoseProcedure;
import video.biz.offline.list.logic.statemachine.OfflineSDDiagnoseResult;
import video.biz.offline.list.logic.tree.VideoFile;

/* compiled from: OfflineStorageDiagnosePage.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\u0015\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u0006\u001a\u0015\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\n\u001a\u0015\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0003¢\u0006\u0002\u0010\u000e\u001a\u0015\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010\u0012\u001a\u0015\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010\u0012¨\u0006\u0014"}, d2 = {"OfflineStorageDiagnosePage", "", "(Landroidx/compose/runtime/Composer;I)V", "StorageInfo", "info", "Lvideo/biz/offline/base/model/model/StorageInfoModel;", "(Lvideo/biz/offline/base/model/model/StorageInfoModel;Landroidx/compose/runtime/Composer;I)V", "ProcedureInfo", "procedure", "Lvideo/biz/offline/list/logic/statemachine/OfflineSDDiagnoseProcedure;", "(Lvideo/biz/offline/list/logic/statemachine/OfflineSDDiagnoseProcedure;Landroidx/compose/runtime/Composer;I)V", "DiagnoseResult", "result", "Lvideo/biz/offline/list/logic/statemachine/OfflineSDDiagnoseResult;", "(Lvideo/biz/offline/list/logic/statemachine/OfflineSDDiagnoseResult;Landroidx/compose/runtime/Composer;I)V", "TitleText", "content", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "NormalText", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineStorageDiagnosePageKt {

    /* compiled from: OfflineStorageDiagnosePage.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OfflineSDDiagnoseResult.values().length];
            try {
                iArr[OfflineSDDiagnoseResult.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[OfflineSDDiagnoseResult.WRITE_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[OfflineSDDiagnoseResult.READ_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DiagnoseResult$lambda$1(OfflineSDDiagnoseResult offlineSDDiagnoseResult, int i, Composer composer, int i2) {
        DiagnoseResult(offlineSDDiagnoseResult, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NormalText$lambda$0(String str, int i, Composer composer, int i2) {
        NormalText(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NormalText$lambda$1(String str, int i, Composer composer, int i2) {
        NormalText(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineStorageDiagnosePage$lambda$0(int i, Composer composer, int i2) {
        OfflineStorageDiagnosePage(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProcedureInfo$lambda$1(OfflineSDDiagnoseProcedure offlineSDDiagnoseProcedure, int i, Composer composer, int i2) {
        ProcedureInfo(offlineSDDiagnoseProcedure, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StorageInfo$lambda$0(StorageInfoModel storageInfoModel, int i, Composer composer, int i2) {
        StorageInfo(storageInfoModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TitleText$lambda$0(String str, int i, Composer composer, int i2) {
        TitleText(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TitleText$lambda$1(String str, int i, Composer composer, int i2) {
        TitleText(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void OfflineStorageDiagnosePage(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1579638886);
        ComposerKt.sourceInformation($composer2, "C(OfflineStorageDiagnosePage)53@2818L1898:OfflineStorageDiagnosePage.kt#rawcr6");
        if (!$composer2.shouldExecute($changed != 0, $changed & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1579638886, $changed, -1, "video.biz.offline.list.ui.page.OfflineStorageDiagnosePage (OfflineStorageDiagnosePage.kt:52)");
            }
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableSingletons$OfflineStorageDiagnosePageKt.INSTANCE.m2849getLambda$1724003922$ui_debug(), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineStorageDiagnosePageKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineStorageDiagnosePage$lambda$0;
                    OfflineStorageDiagnosePage$lambda$0 = OfflineStorageDiagnosePageKt.OfflineStorageDiagnosePage$lambda$0($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineStorageDiagnosePage$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StorageInfo(final StorageInfoModel info, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1784082414);
        ComposerKt.sourceInformation($composer2, "C(StorageInfo)N(info)117@5213L35:OfflineStorageDiagnosePage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(info) : $composer2.changedInstance(info) ? 4 : 2;
        }
        if (!$composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1784082414, $dirty, -1, "video.biz.offline.list.ui.page.StorageInfo (OfflineStorageDiagnosePage.kt:108)");
            }
            StringBuilder spaceBuilder = new StringBuilder();
            if (info.getTotalSpace() > 0) {
                spaceBuilder.append(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2231(PlayerbaseresRes.INSTANCE.getString())) + info.getTotalSpaceDesc());
            }
            if (info.getAvailableSpace() > 0) {
                spaceBuilder.append(VideoFile.TREE_END);
                spaceBuilder.append(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2181(PlayerbaseresRes.INSTANCE.getString())) + info.getAvailableSpaceDesc());
            }
            String sb = spaceBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
            NormalText(sb, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineStorageDiagnosePageKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit StorageInfo$lambda$0;
                    StorageInfo$lambda$0 = OfflineStorageDiagnosePageKt.StorageInfo$lambda$0(StorageInfoModel.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return StorageInfo$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProcedureInfo(final OfflineSDDiagnoseProcedure procedure, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(2073486501);
        ComposerKt.sourceInformation($composer2, "C(ProcedureInfo)N(procedure)122@5335L867:OfflineStorageDiagnosePage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(procedure.ordinal()) ? 4 : 2;
        }
        if ($composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2073486501, $dirty, -1, "video.biz.offline.list.ui.page.ProcedureInfo (OfflineStorageDiagnosePage.kt:121)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1944463228, "C134@6108L39,135@6156L40:OfflineStorageDiagnosePage.kt#rawcr6");
            if (procedure.compareTo(OfflineSDDiagnoseProcedure.Info) > 0) {
                $composer2.startReplaceGroup(1944489360);
                ComposerKt.sourceInformation($composer2, "124@5415L95");
                TitleText(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2267(PlayerbaseresRes.INSTANCE.getString())), $composer2, 0);
            } else {
                $composer2.startReplaceGroup(1939126887);
            }
            $composer2.endReplaceGroup();
            StringBuilder procedureBuilder = new StringBuilder();
            procedureBuilder.append(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2238(PlayerbaseresRes.INSTANCE.getString())) + VideoFile.TREE_END);
            if (procedure.compareTo(OfflineSDDiagnoseProcedure.WriteTest) >= 0) {
                procedureBuilder.append(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2166(PlayerbaseresRes.INSTANCE.getString())) + VideoFile.TREE_END);
            }
            if (procedure.compareTo(OfflineSDDiagnoseProcedure.ReadTest) >= 0) {
                procedureBuilder.append(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2168(PlayerbaseresRes.INSTANCE.getString())) + VideoFile.TREE_END);
            }
            String sb = procedureBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
            NormalText(sb, $composer2, 0);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), $composer2, 6);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineStorageDiagnosePageKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProcedureInfo$lambda$1;
                    ProcedureInfo$lambda$1 = OfflineStorageDiagnosePageKt.ProcedureInfo$lambda$1(OfflineSDDiagnoseProcedure.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return ProcedureInfo$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DiagnoseResult(final OfflineSDDiagnoseResult result, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        String string;
        String string2;
        Composer $composer2 = $composer.startRestartGroup(-789002037);
        ComposerKt.sourceInformation($composer2, "C(DiagnoseResult)N(result)141@6284L1220:OfflineStorageDiagnosePage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(result.ordinal()) ? 4 : 2;
        }
        if ($composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-789002037, $dirty, -1, "video.biz.offline.list.ui.page.DiagnoseResult (OfflineStorageDiagnosePage.kt:140)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            $composer2.startReplaceGroup(-80871723);
            ComposerKt.sourceInformation($composer2, "C142@6301L95,143@6405L506,155@7024L95,156@7128L370:OfflineStorageDiagnosePage.kt#rawcr6");
            TitleText(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2248(PlayerbaseresRes.INSTANCE.getString())), $composer2, 0);
            switch (WhenMappings.$EnumSwitchMapping$0[result.ordinal()]) {
                case 1:
                    string = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2226(PlayerbaseresRes.INSTANCE.getString()));
                    break;
                case 2:
                    string = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2270(PlayerbaseresRes.INSTANCE.getString()));
                    break;
                case 3:
                    string = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2161(PlayerbaseresRes.INSTANCE.getString()));
                    break;
                default:
                    string = "";
                    break;
            }
            NormalText(string, $composer2, 0);
            if (result == OfflineSDDiagnoseResult.NONE) {
                $composer2.endReplaceGroup();
            } else {
                TitleText(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2239(PlayerbaseresRes.INSTANCE.getString())), $composer2, 0);
                switch (WhenMappings.$EnumSwitchMapping$0[result.ordinal()]) {
                    case 2:
                    case 3:
                        string2 = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2194(PlayerbaseresRes.INSTANCE.getString()));
                        break;
                    default:
                        string2 = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2232(PlayerbaseresRes.INSTANCE.getString()));
                        break;
                }
                NormalText(string2, $composer2, 0);
                $composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineStorageDiagnosePageKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit DiagnoseResult$lambda$1;
                    DiagnoseResult$lambda$1 = OfflineStorageDiagnosePageKt.DiagnoseResult$lambda$1(OfflineSDDiagnoseResult.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return DiagnoseResult$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TitleText(final String content, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-1882010311);
        ComposerKt.sourceInformation($composer3, "C(TitleText)N(content)174@7671L9,175@7713L6,172@7615L116:OfflineStorageDiagnosePage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(content) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1882010311, $dirty2, -1, "video.biz.offline.list.ui.page.TitleText (OfflineStorageDiagnosePage.kt:168)");
            }
            if (!(content.length() == 0)) {
                $composer2 = $composer3;
                TextKt.Text-Nvy7gAk(content, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa10-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT18b(), $composer2, $dirty2 & 14, 0, 131066);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineStorageDiagnosePageKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit TitleText$lambda$0;
                            TitleText$lambda$0 = OfflineStorageDiagnosePageKt.TitleText$lambda$0(content, $changed, (Composer) obj, ((Integer) obj2).intValue());
                            return TitleText$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineStorageDiagnosePageKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit TitleText$lambda$1;
                    TitleText$lambda$1 = OfflineStorageDiagnosePageKt.TitleText$lambda$1(content, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return TitleText$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NormalText(final String content, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-1889533020);
        ComposerKt.sourceInformation($composer3, "C(NormalText)N(content)187@7973L9,188@8014L6,184@7843L189:OfflineStorageDiagnosePage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(content) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1889533020, $dirty2, -1, "video.biz.offline.list.ui.page.NormalText (OfflineStorageDiagnosePage.kt:180)");
            }
            if (!(content.length() == 0)) {
                $composer2 = $composer3;
                TextKt.Text-Nvy7gAk(content, PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl(20), Dp.constructor-impl(6)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa10-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer2, $dirty2 & 14, 0, 131064);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineStorageDiagnosePageKt$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj, Object obj2) {
                            Unit NormalText$lambda$0;
                            NormalText$lambda$0 = OfflineStorageDiagnosePageKt.NormalText$lambda$0(content, $changed, (Composer) obj, ((Integer) obj2).intValue());
                            return NormalText$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineStorageDiagnosePageKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit NormalText$lambda$1;
                    NormalText$lambda$1 = OfflineStorageDiagnosePageKt.NormalText$lambda$1(content, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return NormalText$lambda$1;
                }
            });
        }
    }
}