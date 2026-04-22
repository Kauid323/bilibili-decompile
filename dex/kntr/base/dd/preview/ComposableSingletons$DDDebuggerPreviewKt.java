package kntr.base.dd.preview;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
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
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import com.bilibili.compose.theme.BiliTheme;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecision;
import kntr.base.dd.KDeviceDecision;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* compiled from: DDDebuggerPreview.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$DDDebuggerPreviewKt {
    public static final ComposableSingletons$DDDebuggerPreviewKt INSTANCE = new ComposableSingletons$DDDebuggerPreviewKt();

    /* renamed from: lambda$-18439082  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f38lambda$18439082 = ComposableLambdaKt.composableLambdaInstance(-18439082, false, new Function2() { // from class: kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__18439082$lambda$0;
            lambda__18439082$lambda$0 = ComposableSingletons$DDDebuggerPreviewKt.lambda__18439082$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__18439082$lambda$0;
        }
    });

    /* compiled from: DDDebuggerPreview.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ClickEvent.values().length];
            try {
                iArr[ClickEvent.UpdateVersion.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ClickEvent.ClearAllMockValue.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ClickEvent.ChangeEnv.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ClickEvent.FallbackVersion.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[ClickEvent.ObserveKeyUpdate.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[ClickEvent.QueryDecideValue.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[ClickEvent.QueryPropertyValue.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[ClickEvent.MockDecideValue.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[ClickEvent.MockPropertyValue.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: getLambda$-18439082$preview_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1374getLambda$18439082$preview_debug() {
        return f38lambda$18439082;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0427, code lost:
        if (r1 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L72;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit lambda__18439082$lambda$0(Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        MutableState currentVersion$delegate;
        String str;
        final CoroutineScope coroutineScope;
        final MutableState tipsMsg$delegate;
        final MutableState tipsMsg$delegate2;
        ComposerKt.sourceInformation($composer, "C75@2816L7,76@2853L24,77@2901L56,78@2988L57,79@3079L46,80@3157L68,82@3235L3189,148@6468L48,318@14297L355,318@14276L376:DDDebuggerPreview.kt#veq8ty");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-18439082, $changed, -1, "kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt.lambda$-18439082.<anonymous> (DDDebuggerPreview.kt:75)");
            }
            CompositionLocal this_$iv = ToasterKt.getLocalToaster();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            final Toaster toaster = (Toaster) consume;
            ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer);
                $composer.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope coroutineScope2 = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -540084658, "CC(remember):DDDebuggerPreview.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState tipsMsg$delegate3 = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -540081873, "CC(remember):DDDebuggerPreview.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default(KDeviceDecision.INSTANCE.getDd().version(), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final MutableState currentVersion$delegate2 = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -540078972, "CC(remember):DDDebuggerPreview.kt#9igjgp");
            Object it$iv3 = $composer.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            final MutableState currentClickEvent$delegate = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -540076454, "CC(remember):DDDebuggerPreview.kt#9igjgp");
            Object it$iv4 = $composer.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = SnapshotStateKt.mutableStateOf$default(new LinkedHashMap(), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            final MutableState observeKeysJobs$delegate = (MutableState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(20));
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            int $changed$iv$iv = (54 << 3) & 112;
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
            int i2 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1370396609, "C88@3414L41,93@3640L9,89@3468L205,95@3686L41,99@3875L2524,97@3802L2612:DDDebuggerPreview.kt#veq8ty");
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(48)), $composer, 6);
            TextKt.Text-Nvy7gAk("DD 调试工具", SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getHugTitle(), $composer, 54, 0, 130044);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer, 6);
            List events = ClickEvent.getEntries();
            DDDebuggerPreviewKt.TableView(events, null, ComposableLambdaKt.rememberComposableLambda(-1290529727, true, new Function4() { // from class: kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit lambda__18439082$lambda$0$11$0;
                    lambda__18439082$lambda$0$11$0 = ComposableSingletons$DDDebuggerPreviewKt.lambda__18439082$lambda$0$11$0(coroutineScope2, toaster, tipsMsg$delegate3, currentClickEvent$delegate, currentVersion$delegate2, ((Integer) obj).intValue(), (ClickEvent) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return lambda__18439082$lambda$0$11$0;
                }
            }, $composer, 54), $composer, 384, 2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -539970522, "CC(remember):DDDebuggerPreview.kt#9igjgp");
            Object it$iv5 = $composer.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv5 = new Function0() { // from class: kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit lambda__18439082$lambda$0$12$0;
                        lambda__18439082$lambda$0$12$0 = ComposableSingletons$DDDebuggerPreviewKt.lambda__18439082$lambda$0$12$0(currentClickEvent$delegate);
                        return lambda__18439082$lambda$0$12$0;
                    }
                };
                $composer.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            }
            Function0 onDialogDismiss = (Function0) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ClickEvent lambda__18439082$lambda$0$7 = lambda__18439082$lambda$0$7(currentClickEvent$delegate);
            switch (lambda__18439082$lambda$0$7 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[lambda__18439082$lambda$0$7.ordinal()]) {
                case 3:
                    currentVersion$delegate = currentVersion$delegate2;
                    str = "CC(remember):DDDebuggerPreview.kt#9igjgp";
                    coroutineScope = coroutineScope2;
                    tipsMsg$delegate = tipsMsg$delegate3;
                    $composer.startReplaceGroup(440949815);
                    ComposerKt.sourceInformation($composer, "159@6817L12,160@6863L161,155@6623L469");
                    List entries = IDeviceDecision.Version.Env.getEntries();
                    IDeviceDecision.Version.Env env = lambda__18439082$lambda$0$4(currentVersion$delegate).getEnv();
                    List list = entries;
                    ComposerKt.sourceInformationMarkerStart($composer, -539959390, str);
                    Object it$iv6 = $composer.rememberedValue();
                    if (it$iv6 == Composer.Companion.getEmpty()) {
                        Object value$iv6 = new Function1() { // from class: kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$$ExternalSyntheticLambda4
                            public final Object invoke(Object obj) {
                                String lambda__18439082$lambda$0$13$0;
                                lambda__18439082$lambda$0$13$0 = ComposableSingletons$DDDebuggerPreviewKt.lambda__18439082$lambda$0$13$0((IDeviceDecision.Version.Env) obj);
                                return lambda__18439082$lambda$0$13$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv6);
                        it$iv6 = value$iv6;
                    }
                    Function1 function1 = (Function1) it$iv6;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, -539957769, str);
                    boolean invalid$iv = $composer.changedInstance(toaster);
                    Object it$iv7 = $composer.rememberedValue();
                    if (invalid$iv || it$iv7 == Composer.Companion.getEmpty()) {
                        Object value$iv7 = new Function1() { // from class: kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$$ExternalSyntheticLambda5
                            public final Object invoke(Object obj) {
                                Unit lambda__18439082$lambda$0$14$0;
                                lambda__18439082$lambda$0$14$0 = ComposableSingletons$DDDebuggerPreviewKt.lambda__18439082$lambda$0$14$0(Toaster.this, (IDeviceDecision.Version.Env) obj);
                                return lambda__18439082$lambda$0$14$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv7);
                        it$iv7 = value$iv7;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    SingleChoiceDialogKt.SingleChoiceDialog("环境切换", list, env, function1, onDialogDismiss, (Function1) it$iv7, $composer, 27654);
                    $composer.endReplaceGroup();
                    Unit unit = Unit.INSTANCE;
                    break;
                case 4:
                    currentVersion$delegate = currentVersion$delegate2;
                    str = "CC(remember):DDDebuggerPreview.kt#9igjgp";
                    coroutineScope = coroutineScope2;
                    tipsMsg$delegate = tipsMsg$delegate3;
                    $composer.startReplaceGroup(441504467);
                    ComposerKt.sourceInformation($composer, "174@7424L646,169@7168L921");
                    String desc = ClickEvent.FallbackVersion.getDesc();
                    List listOf = CollectionsKt.listOf("版本号");
                    ComposerKt.sourceInformationMarkerStart($composer, -539939332, str);
                    boolean invalid$iv2 = $composer.changedInstance(coroutineScope) | $composer.changedInstance(toaster);
                    Object it$iv8 = $composer.rememberedValue();
                    if (invalid$iv2 || it$iv8 == Composer.Companion.getEmpty()) {
                        Object value$iv8 = new Function1() { // from class: kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$$ExternalSyntheticLambda6
                            public final Object invoke(Object obj) {
                                Unit lambda__18439082$lambda$0$15$0;
                                lambda__18439082$lambda$0$15$0 = ComposableSingletons$DDDebuggerPreviewKt.lambda__18439082$lambda$0$15$0(Toaster.this, coroutineScope, tipsMsg$delegate, (List) obj);
                                return lambda__18439082$lambda$0$15$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv8);
                        it$iv8 = value$iv8;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    InputDialogKt.InputDialog(onDialogDismiss, (Function1) it$iv8, desc, listOf, "请输入一个当前环境有效的版本号进行回滚。", $composer, 28038, 0);
                    $composer.endReplaceGroup();
                    Unit unit2 = Unit.INSTANCE;
                    break;
                case 5:
                    currentVersion$delegate = currentVersion$delegate2;
                    str = "CC(remember):DDDebuggerPreview.kt#9igjgp";
                    coroutineScope = coroutineScope2;
                    tipsMsg$delegate = tipsMsg$delegate3;
                    $composer.startReplaceGroup(444189625);
                    ComposerKt.sourceInformation($composer, "234@10305L2047,224@9824L2547");
                    String desc2 = ClickEvent.ObserveKeyUpdate.getDesc();
                    List listOf2 = CollectionsKt.listOf(new String[]{"key", "是否是FF类型的key值", "输入 1 表示移除对该key的监听"});
                    ComposerKt.sourceInformationMarkerStart($composer, -539845739, str);
                    boolean invalid$iv3 = $composer.changedInstance(coroutineScope) | $composer.changedInstance(toaster);
                    Object it$iv9 = $composer.rememberedValue();
                    if (invalid$iv3 || it$iv9 == Composer.Companion.getEmpty()) {
                        Object value$iv9 = new Function1() { // from class: kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$$ExternalSyntheticLambda8
                            public final Object invoke(Object obj) {
                                Unit lambda__18439082$lambda$0$17$0;
                                lambda__18439082$lambda$0$17$0 = ComposableSingletons$DDDebuggerPreviewKt.lambda__18439082$lambda$0$17$0(Toaster.this, coroutineScope, observeKeysJobs$delegate, (List) obj);
                                return lambda__18439082$lambda$0$17$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv9);
                        it$iv9 = value$iv9;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    InputDialogKt.InputDialog(onDialogDismiss, (Function1) it$iv9, desc2, listOf2, "请输入需要进行观察的key，当key对应的决策值有变化之后，会有toast进行通知。\n在第二项输入 1 则表示当前key之前是FF类型的配置。", $composer, 28038, 0);
                    $composer.endReplaceGroup();
                    Unit unit3 = Unit.INSTANCE;
                    break;
                case 6:
                case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                    currentVersion$delegate = currentVersion$delegate2;
                    str = "CC(remember):DDDebuggerPreview.kt#9igjgp";
                    coroutineScope = coroutineScope2;
                    $composer.startReplaceGroup(442527870);
                    ComposerKt.sourceInformation($composer, "198@8612L1116,193@8338L1409");
                    final boolean isProp = ClickEvent.QueryPropertyValue == lambda__18439082$lambda$0$7(currentClickEvent$delegate);
                    String valueType = isProp ? "指标值" : "决策值";
                    ClickEvent lambda__18439082$lambda$0$72 = lambda__18439082$lambda$0$7(currentClickEvent$delegate);
                    Intrinsics.checkNotNull(lambda__18439082$lambda$0$72);
                    String desc3 = lambda__18439082$lambda$0$72.getDesc();
                    String str2 = "查询key值对应的" + valueType + "，若为空则查询当前所有的" + valueType + ".";
                    List listOf3 = CollectionsKt.listOf("key 值.");
                    ComposerKt.sourceInformationMarkerStart($composer, -539900846, str);
                    boolean invalid$iv4 = $composer.changedInstance(coroutineScope) | $composer.changed(isProp);
                    Object it$iv10 = $composer.rememberedValue();
                    if (invalid$iv4 || it$iv10 == Composer.Companion.getEmpty()) {
                        tipsMsg$delegate2 = tipsMsg$delegate3;
                        Object value$iv10 = new Function1() { // from class: kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$$ExternalSyntheticLambda7
                            public final Object invoke(Object obj) {
                                Unit lambda__18439082$lambda$0$16$0;
                                lambda__18439082$lambda$0$16$0 = ComposableSingletons$DDDebuggerPreviewKt.lambda__18439082$lambda$0$16$0(coroutineScope, isProp, tipsMsg$delegate2, (List) obj);
                                return lambda__18439082$lambda$0$16$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv10);
                        it$iv10 = value$iv10;
                    } else {
                        tipsMsg$delegate2 = tipsMsg$delegate3;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    tipsMsg$delegate = tipsMsg$delegate2;
                    InputDialogKt.InputDialog(onDialogDismiss, (Function1) it$iv10, desc3, listOf3, str2, $composer, 3078, 0);
                    $composer.endReplaceGroup();
                    Unit unit4 = Unit.INSTANCE;
                    break;
                case 8:
                case ConstantsKt.SPACER_9 /* 9 */:
                    $composer.startReplaceGroup(446774994);
                    ComposerKt.sourceInformation($composer, "286@13193L859,276@12677L1394");
                    final boolean isProp2 = ClickEvent.MockPropertyValue == lambda__18439082$lambda$0$7(currentClickEvent$delegate);
                    String keyType = isProp2 ? "name" : "key";
                    String valueType2 = isProp2 ? "指标值" : "决策值";
                    ClickEvent lambda__18439082$lambda$0$73 = lambda__18439082$lambda$0$7(currentClickEvent$delegate);
                    Intrinsics.checkNotNull(lambda__18439082$lambda$0$73);
                    String desc4 = lambda__18439082$lambda$0$73.getDesc();
                    String str3 = "1、选择直接覆盖" + keyType + "对应的" + valueType2 + "，当MOCK值为空时会删除其之前的MOCK值；\n2、不输入" + keyType + "直接输入JSON字符串进行批量MOCK。";
                    List listOf4 = CollectionsKt.listOf(new String[]{keyType, "MOCK 值", "JSON字符串，格式: [{\"n\": \"a\", \"v\": \"true\"},...]"});
                    ComposerKt.sourceInformationMarkerStart($composer, -539754511, "CC(remember):DDDebuggerPreview.kt#9igjgp");
                    boolean invalid$iv5 = $composer.changed(isProp2) | $composer.changedInstance(toaster);
                    Object it$iv11 = $composer.rememberedValue();
                    if (!invalid$iv5) {
                        break;
                    }
                    Object value$iv11 = new Function1() { // from class: kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$$ExternalSyntheticLambda9
                        public final Object invoke(Object obj) {
                            Unit lambda__18439082$lambda$0$18$0;
                            lambda__18439082$lambda$0$18$0 = ComposableSingletons$DDDebuggerPreviewKt.lambda__18439082$lambda$0$18$0(isProp2, toaster, (List) obj);
                            return lambda__18439082$lambda$0$18$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv11);
                    it$iv11 = value$iv11;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    currentVersion$delegate = currentVersion$delegate2;
                    str = "CC(remember):DDDebuggerPreview.kt#9igjgp";
                    coroutineScope = coroutineScope2;
                    InputDialogKt.InputDialog(onDialogDismiss, (Function1) it$iv11, desc4, listOf4, str3, $composer, 6, 0);
                    $composer.endReplaceGroup();
                    Unit unit5 = Unit.INSTANCE;
                    tipsMsg$delegate = tipsMsg$delegate3;
                    break;
                default:
                    currentVersion$delegate = currentVersion$delegate2;
                    str = "CC(remember):DDDebuggerPreview.kt#9igjgp";
                    coroutineScope = coroutineScope2;
                    tipsMsg$delegate = tipsMsg$delegate3;
                    $composer.startReplaceGroup(448359466);
                    $composer.endReplaceGroup();
                    Unit unit6 = Unit.INSTANCE;
                    break;
            }
            if (lambda__18439082$lambda$0$1(tipsMsg$delegate) != null) {
                $composer.startReplaceGroup(448405656);
                ComposerKt.sourceInformation($composer, "313@14210L46,313@14164L92");
                Pair<String, String> lambda__18439082$lambda$0$1 = lambda__18439082$lambda$0$1(tipsMsg$delegate);
                Intrinsics.checkNotNull(lambda__18439082$lambda$0$1);
                String first = lambda__18439082$lambda$0$1.getFirst();
                Pair<String, String> lambda__18439082$lambda$0$12 = lambda__18439082$lambda$0$1(tipsMsg$delegate);
                Intrinsics.checkNotNull(lambda__18439082$lambda$0$12);
                String second = lambda__18439082$lambda$0$12.getSecond();
                ComposerKt.sourceInformationMarkerStart($composer, -539722780, str);
                Object it$iv12 = $composer.rememberedValue();
                if (it$iv12 == Composer.Companion.getEmpty()) {
                    Object value$iv12 = new Function0() { // from class: kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$$ExternalSyntheticLambda10
                        public final Object invoke() {
                            Unit lambda__18439082$lambda$0$19$0;
                            lambda__18439082$lambda$0$19$0 = ComposableSingletons$DDDebuggerPreviewKt.lambda__18439082$lambda$0$19$0(tipsMsg$delegate);
                            return lambda__18439082$lambda$0$19$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv12);
                    it$iv12 = value$iv12;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                TipsDialogKt.TipsDialog(first, second, (Function0) it$iv12, $composer, 384, 0);
            } else {
                $composer.startReplaceGroup(434364268);
            }
            $composer.endReplaceGroup();
            Unit unit7 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -539719687, str);
            boolean invalid$iv6 = $composer.changedInstance(coroutineScope);
            Object it$iv13 = $composer.rememberedValue();
            if (invalid$iv6 || it$iv13 == Composer.Companion.getEmpty()) {
                Object value$iv13 = (Function2) new ComposableSingletons$DDDebuggerPreviewKt$lambda$18439082$1$9$1(coroutineScope, currentVersion$delegate, null);
                $composer.updateRememberedValue(value$iv13);
                it$iv13 = value$iv13;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(unit7, (Function2) it$iv13, $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final Pair<String, String> lambda__18439082$lambda$0$1(MutableState<Pair<String, String>> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (Pair) $this$getValue$iv.getValue();
    }

    private static final IDeviceDecision.Version lambda__18439082$lambda$0$4(MutableState<IDeviceDecision.Version> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (IDeviceDecision.Version) $this$getValue$iv.getValue();
    }

    private static final ClickEvent lambda__18439082$lambda$0$7(MutableState<ClickEvent> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (ClickEvent) $this$getValue$iv.getValue();
    }

    private static final Map<String, Job> lambda__18439082$lambda$0$10(MutableState<Map<String, Job>> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (Map) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__18439082$lambda$0$11$0(final CoroutineScope $coroutineScope, final Toaster $toaster, final MutableState $tipsMsg$delegate, final MutableState $currentClickEvent$delegate, MutableState $currentVersion$delegate, int i, final ClickEvent event, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        String version;
        Intrinsics.checkNotNullParameter(event, "event");
        ComposerKt.sourceInformation($composer, "CN(event)105@4135L6,106@4190L1223,100@3909L2472:DDDebuggerPreview.kt#veq8ty");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(event.ordinal()) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 145) != 144, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1290529727, $dirty2, -1, "kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt.lambda$-18439082.<anonymous>.<anonymous>.<anonymous> (DDDebuggerPreview.kt:100)");
            }
            Modifier modifier = BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(36)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1046492200, "CC(remember):DDDebuggerPreview.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($coroutineScope) | (($dirty2 & 112) == 32) | $composer.changedInstance($toaster);
            Object value$iv = $composer.rememberedValue();
            if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                value$iv = new Function0() { // from class: kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit lambda__18439082$lambda$0$11$0$0$0;
                        lambda__18439082$lambda$0$11$0$0$0 = ComposableSingletons$DDDebuggerPreviewKt.lambda__18439082$lambda$0$11$0$0$0(ClickEvent.this, $coroutineScope, $toaster, $tipsMsg$delegate, $currentClickEvent$delegate);
                        return lambda__18439082$lambda$0$11$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv, 15, (Object) null), Dp.constructor-impl(16), 0.0f, 2, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenterStart();
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $i$f$Box = $changed$iv$iv << 6;
            int $changed$iv$iv$iv = ($i$f$Box & 896) | 6;
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
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i3 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 600510214, "C130@5557L802:DDDebuggerPreview.kt#veq8ty");
            String desc = event.getDesc();
            switch (WhenMappings.$EnumSwitchMapping$0[event.ordinal()]) {
                case 1:
                    version = lambda__18439082$lambda$0$4($currentVersion$delegate).getVersion();
                    break;
                case 2:
                    version = "清理";
                    break;
                case 3:
                    version = lambda__18439082$lambda$0$4($currentVersion$delegate).getEnv().getValue();
                    break;
                case 4:
                    version = "回滚";
                    break;
                case 5:
                    version = "订阅";
                    break;
                case 6:
                case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                    version = "查询";
                    break;
                case 8:
                case ConstantsKt.SPACER_9 /* 9 */:
                    version = "MOCK";
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            DDDebuggerPreviewKt.TitleRow(desc, version, null, $composer, 0, 4);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__18439082$lambda$0$11$0$0$0(ClickEvent $event, CoroutineScope $coroutineScope, Toaster $toaster, MutableState $tipsMsg$delegate, MutableState $currentClickEvent$delegate) {
        switch (WhenMappings.$EnumSwitchMapping$0[$event.ordinal()]) {
            case 1:
                BuildersKt.launch$default($coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ComposableSingletons$DDDebuggerPreviewKt$lambda$18439082$1$1$1$1$1$1($toaster, $tipsMsg$delegate, null), 3, (Object) null);
                break;
            case 2:
                DDDebuggerPreviewKt.getDebugger().clearAllMock();
                Toaster.CC.showToast$default($toaster, "清理成功.", null, 2, null);
                break;
            default:
                $currentClickEvent$delegate.setValue($event);
                break;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__18439082$lambda$0$12$0(MutableState $currentClickEvent$delegate) {
        $currentClickEvent$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String lambda__18439082$lambda$0$13$0(IDeviceDecision.Version.Env it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__18439082$lambda$0$14$0(Toaster $toaster, IDeviceDecision.Version.Env it) {
        Intrinsics.checkNotNullParameter(it, "it");
        KDeviceDecision.INSTANCE.getUtils().changeEnv("debugger", it);
        Toaster.CC.showToast$default($toaster, "已切换到 " + it.getValue() + " 环境.", null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__18439082$lambda$0$15$0(Toaster $toaster, CoroutineScope $coroutineScope, MutableState $tipsMsg$delegate, List list) {
        Intrinsics.checkNotNullParameter(list, "list");
        Long longOrNull = StringsKt.toLongOrNull((String) list.get(0));
        if (longOrNull != null) {
            long it = longOrNull.longValue();
            if (BuildersKt.launch$default($coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ComposableSingletons$DDDebuggerPreviewKt$lambda$18439082$1$4$1$1$1($toaster, it, $tipsMsg$delegate, null), 3, (Object) null) != null) {
                return Unit.INSTANCE;
            }
        }
        Toaster.CC.showToast$default($toaster, "请输入一个有效的版本号！", null, 2, null);
        Unit unit = Unit.INSTANCE;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__18439082$lambda$0$16$0(CoroutineScope $coroutineScope, boolean $isProp, MutableState $tipsMsg$delegate, List list) {
        Intrinsics.checkNotNullParameter(list, "list");
        BuildersKt.launch$default($coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ComposableSingletons$DDDebuggerPreviewKt$lambda$18439082$1$5$1$1(list, $isProp, $tipsMsg$delegate, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__18439082$lambda$0$17$0(Toaster $toaster, CoroutineScope $coroutineScope, MutableState $observeKeysJobs$delegate, List list) {
        Job job;
        Intrinsics.checkNotNullParameter(list, "list");
        boolean isFF = Intrinsics.areEqual(list.get(1), "1");
        Object obj = list.get(0);
        String it = (String) obj;
        if (StringsKt.isBlank(it)) {
            obj = null;
        }
        String key = (String) obj;
        if (key != null) {
            if (Intrinsics.areEqual(list.get(2), "1")) {
                CoroutineContext coroutineContext = (Job) lambda__18439082$lambda$0$10($observeKeysJobs$delegate).get(key);
                if (coroutineContext != null && (job = JobKt.getJob(coroutineContext)) != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                lambda__18439082$lambda$0$10($observeKeysJobs$delegate).remove(key);
                BuildersKt.launch$default($coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ComposableSingletons$DDDebuggerPreviewKt$lambda$18439082$1$6$1$2$1($toaster, key, null), 3, (Object) null);
            } else if (!lambda__18439082$lambda$0$10($observeKeysJobs$delegate).containsKey(key)) {
                lambda__18439082$lambda$0$10($observeKeysJobs$delegate).put(key, BuildersKt.launch$default($coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ComposableSingletons$DDDebuggerPreviewKt$lambda$18439082$1$6$1$2$2(isFF, key, $toaster, null), 3, (Object) null));
            }
        } else {
            Toaster.CC.showToast$default($toaster, "请输入一个有效的key！", null, 2, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__18439082$lambda$0$18$0(boolean $isProp, Toaster $toaster, List list) {
        Intrinsics.checkNotNullParameter(list, "list");
        String k = (String) list.get(0);
        String v = (String) list.get(1);
        String jsonString = (String) list.get(2);
        if (!StringsKt.isBlank(k)) {
            if ($isProp) {
                DDDebuggerPreviewKt.getDebugger().mockDDProp(k, v);
            } else {
                DDDebuggerPreviewKt.getDebugger().mockDDValue(k, v);
            }
        } else if (StringsKt.isBlank(jsonString)) {
            Toaster.CC.showToast$default($toaster, "第一项和第三项至少有一个不为空。", null, 2, null);
        } else if ($isProp) {
            DDDebuggerPreviewKt.getDebugger().mockDDProps(jsonString);
        } else {
            DDDebuggerPreviewKt.getDebugger().mockDDValues(jsonString);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__18439082$lambda$0$19$0(MutableState $tipsMsg$delegate) {
        $tipsMsg$delegate.setValue(null);
        return Unit.INSTANCE;
    }
}