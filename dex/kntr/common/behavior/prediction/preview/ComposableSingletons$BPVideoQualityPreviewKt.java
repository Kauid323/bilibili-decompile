package kntr.common.behavior.prediction.preview;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
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
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BPVideoQualityPreview.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$BPVideoQualityPreviewKt {
    public static final ComposableSingletons$BPVideoQualityPreviewKt INSTANCE = new ComposableSingletons$BPVideoQualityPreviewKt();

    /* renamed from: lambda$-254434393  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f49lambda$254434393 = ComposableLambdaKt.composableLambdaInstance(-254434393, false, new Function2() { // from class: kntr.common.behavior.prediction.preview.ComposableSingletons$BPVideoQualityPreviewKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__254434393$lambda$0;
            lambda__254434393$lambda$0 = ComposableSingletons$BPVideoQualityPreviewKt.lambda__254434393$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__254434393$lambda$0;
        }
    });

    /* renamed from: getLambda$-254434393$preview_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1821getLambda$254434393$preview_debug() {
        return f49lambda$254434393;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__254434393$lambda$0(Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        ComposerKt.sourceInformation($composer, "C33@1393L33,34@1455L31,35@1514L31,36@1581L45,37@1662L7,43@1809L6,39@1679L1362:BPVideoQualityPreview.kt#9vm0wh");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-254434393, $changed, -1, "kntr.common.behavior.prediction.preview.ComposableSingletons$BPVideoQualityPreviewKt.lambda$-254434393.<anonymous> (BPVideoQualityPreview.kt:33)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 301685224, "CC(remember):BPVideoQualityPreview.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotIntStateKt.mutableIntStateOf(0);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableIntState currentBtnTag$delegate = (MutableIntState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 301687206, "CC(remember):BPVideoQualityPreview.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final MutableState currentTitle$delegate = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 301689094, "CC(remember):BPVideoQualityPreview.kt#9igjgp");
            Object it$iv3 = $composer.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            final MutableState currentTips$delegate = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 301691252, "CC(remember):BPVideoQualityPreview.kt#9igjgp");
            Object it$iv4 = $composer.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            final MutableState currentPlaceholders$delegate = (MutableState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer);
            CompositionLocal this_$iv = ToasterKt.getLocalToaster();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            final Toaster toaster = (Toaster) consume;
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
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
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -666960558, "C46@1895L1136:BPVideoQualityPreview.kt#9vm0wh");
            Modifier modifier$iv2 = SizeKt.wrapContentSize$default(Modifier.Companion, (Alignment) null, false, 3, (Object) null);
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(32));
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            int $changed$iv$iv2 = (54 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1902249992, "C50@2098L262,50@2057L304,56@2419L271,56@2378L313,62@2748L268,62@2708L309:BPVideoQualityPreview.kt#9vm0wh");
            ComposerKt.sourceInformationMarkerStart($composer, -2139572271, "CC(remember):BPVideoQualityPreview.kt#9igjgp");
            Object value$iv5 = $composer.rememberedValue();
            if (value$iv5 == Composer.Companion.getEmpty()) {
                value$iv5 = new Function0() { // from class: kntr.common.behavior.prediction.preview.ComposableSingletons$BPVideoQualityPreviewKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit lambda__254434393$lambda$0$12$0$0$0;
                        lambda__254434393$lambda$0$12$0$0$0 = ComposableSingletons$BPVideoQualityPreviewKt.lambda__254434393$lambda$0$12$0$0$0(currentTitle$delegate, currentTips$delegate, currentPlaceholders$delegate, currentBtnTag$delegate);
                        return lambda__254434393$lambda$0$12$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv5);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            BPButtonKt.BPButton((Function0) value$iv5, null, "更新「用户标签」数据", $composer, 390, 2);
            ComposerKt.sourceInformationMarkerStart($composer, -2139561990, "CC(remember):BPVideoQualityPreview.kt#9igjgp");
            Object value$iv6 = $composer.rememberedValue();
            if (value$iv6 == Composer.Companion.getEmpty()) {
                value$iv6 = new Function0() { // from class: kntr.common.behavior.prediction.preview.ComposableSingletons$BPVideoQualityPreviewKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit lambda__254434393$lambda$0$12$0$1$0;
                        lambda__254434393$lambda$0$12$0$1$0 = ComposableSingletons$BPVideoQualityPreviewKt.lambda__254434393$lambda$0$12$0$1$0(currentTitle$delegate, currentTips$delegate, currentPlaceholders$delegate, currentBtnTag$delegate);
                        return lambda__254434393$lambda$0$12$0$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv6);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            BPButtonKt.BPButton((Function0) value$iv6, null, "更新「稿件标签」数据", $composer, 390, 2);
            ComposerKt.sourceInformationMarkerStart($composer, -2139551465, "CC(remember):BPVideoQualityPreview.kt#9igjgp");
            Object value$iv7 = $composer.rememberedValue();
            if (value$iv7 == Composer.Companion.getEmpty()) {
                value$iv7 = new Function0() { // from class: kntr.common.behavior.prediction.preview.ComposableSingletons$BPVideoQualityPreviewKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit lambda__254434393$lambda$0$12$0$2$0;
                        lambda__254434393$lambda$0$12$0$2$0 = ComposableSingletons$BPVideoQualityPreviewKt.lambda__254434393$lambda$0$12$0$2$0(currentTitle$delegate, currentTips$delegate, currentPlaceholders$delegate, currentBtnTag$delegate);
                        return lambda__254434393$lambda$0$12$0$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv7);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            BPButtonKt.BPButton((Function0) value$iv7, null, "预测稿件自动清晰度", $composer, 390, 2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (lambda__254434393$lambda$0$1(currentBtnTag$delegate) > 0) {
                $composer.startReplaceGroup(764001101);
                ComposerKt.sourceInformation($composer, "76@3255L21,77@3306L197,72@3088L430");
                String lambda__254434393$lambda$0$4 = lambda__254434393$lambda$0$4(currentTitle$delegate);
                String lambda__254434393$lambda$0$7 = lambda__254434393$lambda$0$7(currentTips$delegate);
                List<String> lambda__254434393$lambda$0$10 = lambda__254434393$lambda$0$10(currentPlaceholders$delegate);
                ComposerKt.sourceInformationMarkerStart($composer, 301744796, "CC(remember):BPVideoQualityPreview.kt#9igjgp");
                Object it$iv5 = $composer.rememberedValue();
                if (it$iv5 == Composer.Companion.getEmpty()) {
                    Object value$iv8 = new Function0() { // from class: kntr.common.behavior.prediction.preview.ComposableSingletons$BPVideoQualityPreviewKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit lambda__254434393$lambda$0$13$0;
                            lambda__254434393$lambda$0$13$0 = ComposableSingletons$BPVideoQualityPreviewKt.lambda__254434393$lambda$0$13$0(currentBtnTag$delegate);
                            return lambda__254434393$lambda$0$13$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv8);
                    it$iv5 = value$iv8;
                }
                Function0 function0 = (Function0) it$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 301746604, "CC(remember):BPVideoQualityPreview.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance(toaster);
                Object it$iv6 = $composer.rememberedValue();
                if (invalid$iv || it$iv6 == Composer.Companion.getEmpty()) {
                    Object value$iv9 = new Function1() { // from class: kntr.common.behavior.prediction.preview.ComposableSingletons$BPVideoQualityPreviewKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj) {
                            Unit lambda__254434393$lambda$0$14$0;
                            lambda__254434393$lambda$0$14$0 = ComposableSingletons$BPVideoQualityPreviewKt.lambda__254434393$lambda$0$14$0(Toaster.this, currentBtnTag$delegate, (List) obj);
                            return lambda__254434393$lambda$0$14$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv9);
                    it$iv6 = value$iv9;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                InputDialogKt.InputDialog(function0, (Function1) it$iv6, lambda__254434393$lambda$0$4, lambda__254434393$lambda$0$10, lambda__254434393$lambda$0$7, $composer, 6, 0);
            } else {
                $composer.startReplaceGroup(760923483);
            }
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final int lambda__254434393$lambda$0$1(MutableIntState $currentBtnTag$delegate) {
        IntState $this$getValue$iv = (IntState) $currentBtnTag$delegate;
        return $this$getValue$iv.getIntValue();
    }

    private static final String lambda__254434393$lambda$0$4(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    private static final String lambda__254434393$lambda$0$7(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    private static final List<String> lambda__254434393$lambda$0$10(MutableState<List<String>> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (List) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__254434393$lambda$0$12$0$0$0(MutableState $currentTitle$delegate, MutableState $currentTips$delegate, MutableState $currentPlaceholders$delegate, MutableIntState $currentBtnTag$delegate) {
        $currentTitle$delegate.setValue("请输入「用户标签」信息");
        $currentTips$delegate.setValue("如果需要覆盖已有的标签内容输入 1 即可，其他内容均视为向已有的内容添加数据");
        $currentPlaceholders$delegate.setValue(CollectionsKt.listOf(new String[]{"标签内容(JSON字符串)", "是否覆盖已有的标签内容"}));
        $currentBtnTag$delegate.setIntValue(1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__254434393$lambda$0$12$0$1$0(MutableState $currentTitle$delegate, MutableState $currentTips$delegate, MutableState $currentPlaceholders$delegate, MutableIntState $currentBtnTag$delegate) {
        $currentTitle$delegate.setValue("请输入「稿件标签」信息");
        $currentTips$delegate.setValue("优先读取第二项的内容（第二项输入 1 时才认为「是」）");
        $currentPlaceholders$delegate.setValue(CollectionsKt.listOf(new String[]{"稿件avid", "是否仅指定quality_tag为高清优先", "标签内容(JSON字符串)"}));
        $currentBtnTag$delegate.setIntValue(2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__254434393$lambda$0$12$0$2$0(MutableState $currentTitle$delegate, MutableState $currentTips$delegate, MutableState $currentPlaceholders$delegate, MutableIntState $currentBtnTag$delegate) {
        $currentTitle$delegate.setValue("请输入预测的上下文信息");
        $currentTips$delegate.setValue("第二项请输入正确的数字，第三、四项输入 1 时才认为「是」。");
        $currentPlaceholders$delegate.setValue(CollectionsKt.listOf(new String[]{"稿件avid", "默认的自动清晰度", "是否是高屏占比", "是否是Wifi环境"}));
        $currentBtnTag$delegate.setIntValue(3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__254434393$lambda$0$13$0(MutableIntState $currentBtnTag$delegate) {
        $currentBtnTag$delegate.setIntValue(0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__254434393$lambda$0$14$0(Toaster $toaster, MutableIntState $currentBtnTag$delegate, List inputs) {
        Intrinsics.checkNotNullParameter(inputs, "inputs");
        KLog_androidKt.getKLog().i("BPVideoQualityPreview", "inputs = " + inputs + ", currentBtnTag = " + lambda__254434393$lambda$0$1($currentBtnTag$delegate));
        BPVideoQualityPreviewKt.handleClick(lambda__254434393$lambda$0$1($currentBtnTag$delegate), inputs, $toaster);
        return Unit.INSTANCE;
    }
}