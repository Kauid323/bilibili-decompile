package kntr.app.deepsearch.ui.paragraph;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
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
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import com.bapis.bilibili.app.dynamic.v2.KModuleParagraph;
import com.bapis.bilibili.app.dynamic.v2.KParagraph;
import com.bapis.bilibili.app.dynamic.v2.KTextNode;
import com.bilibili.common.paragraph.ParagraphState;
import com.bilibili.common.paragraph.ParagraphStateKt;
import com.bilibili.common.paragraph.action.ParagraphClickListener;
import com.bilibili.common.paragraph.action.ParagraphStateBuilderScope;
import com.bilibili.common.paragraph.builder.ParagraphBuilderKt;
import com.bilibili.common.paragraph.builder.ParagraphBuilderProvider;
import com.bilibili.common.paragraph.builder.ParagraphContent;
import com.bilibili.common.paragraph.impl.constant.SortedListDrawParams;
import com.bilibili.common.paragraph.impl.text.TextNodeClickInfo;
import com.bilibili.common.paragraph.impl.text.TextNodeClickListener;
import com.bilibili.common.paragraph.impl.text.TextNodeClickListenerKt;
import com.bilibili.common.paragraph.impl.text.TextParagraphBuilderScope;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeDayNight;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import java.util.Iterator;
import java.util.List;
import kntr.app.deepsearch.ui.paragraph.DeepSearchParagraphComponent;
import kntr.app.deepsearch.ui.paragraph.constants.ParagraphTextDrawParams;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: DeepSearchParagraphPreview.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a%\u0010\u0005\u001a\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f²\u0006\u0010\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u008a\u008e\u0002"}, d2 = {"DeepSearchOpusPreview", RoomRecommendViewModel.EMPTY_CURSOR, "opus_id", RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "DeepSearchParagraphPreviewData", "data", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bapis/bilibili/app/dynamic/v2/KModuleParagraph;", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "compose_debug", "paragraph"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchParagraphPreviewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeepSearchOpusPreview$lambda$4(String str, int i, Composer composer, int i2) {
        DeepSearchOpusPreview(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeepSearchParagraphPreviewData$lambda$1(List list, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DeepSearchParagraphPreviewData(list, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void DeepSearchOpusPreview(final String opus_id, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(opus_id, "opus_id");
        Composer $composer2 = $composer.startRestartGroup(-2126304130);
        ComposerKt.sourceInformation($composer2, "C(DeepSearchOpusPreview)N(opus_id)43@2074L110,47@2214L503,47@2190L527,65@2723L41:DeepSearchParagraphPreview.kt#a32fmc");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(opus_id) ? 4 : 2;
        }
        if (!$composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2126304130, $dirty, -1, "kntr.app.deepsearch.ui.paragraph.DeepSearchOpusPreview (DeepSearchParagraphPreview.kt:42)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1026166188, "CC(remember):DeepSearchParagraphPreview.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableState paragraph$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1026171061, "CC(remember):DeepSearchParagraphPreview.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new DeepSearchParagraphPreviewKt$DeepSearchOpusPreview$1$1(opus_id, paragraph$delegate, null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(opus_id, (Function2) it$iv2, $composer2, $dirty & 14);
            DeepSearchParagraphPreviewData(DeepSearchOpusPreview$lambda$1(paragraph$delegate), null, $composer2, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.paragraph.DeepSearchParagraphPreviewKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeepSearchOpusPreview$lambda$4;
                    DeepSearchOpusPreview$lambda$4 = DeepSearchParagraphPreviewKt.DeepSearchOpusPreview$lambda$4(opus_id, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return DeepSearchOpusPreview$lambda$4;
                }
            });
        }
    }

    private static final List<KModuleParagraph> DeepSearchOpusPreview$lambda$1(MutableState<List<KModuleParagraph>> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (List) $this$getValue$iv.getValue();
    }

    public static final void DeepSearchParagraphPreviewData(final List<KModuleParagraph> list, final Modifier modifier, Composer $composer, final int $changed, final int i) {
        Intrinsics.checkNotNullParameter(list, "data");
        Composer $composer2 = $composer.startRestartGroup(1274235021);
        ComposerKt.sourceInformation($composer2, "C(DeepSearchParagraphPreviewData)N(data,modifier)73@2937L2196,73@2927L2206:DeepSearchParagraphPreview.kt#a32fmc");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1274235021, $dirty2, -1, "kntr.app.deepsearch.ui.paragraph.DeepSearchParagraphPreviewData (DeepSearchParagraphPreview.kt:72)");
            }
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(596544069, true, new Function2() { // from class: kntr.app.deepsearch.ui.paragraph.DeepSearchParagraphPreviewKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeepSearchParagraphPreviewData$lambda$0;
                    DeepSearchParagraphPreviewData$lambda$0 = DeepSearchParagraphPreviewKt.DeepSearchParagraphPreviewData$lambda$0(modifier, list, (Composer) obj, ((Integer) obj2).intValue());
                    return DeepSearchParagraphPreviewData$lambda$0;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.paragraph.DeepSearchParagraphPreviewKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeepSearchParagraphPreviewData$lambda$1;
                    DeepSearchParagraphPreviewData$lambda$1 = DeepSearchParagraphPreviewKt.DeepSearchParagraphPreviewData$lambda$1(list, modifier, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DeepSearchParagraphPreviewData$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeepSearchParagraphPreviewData$lambda$0(Modifier $modifier, List $data, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        ComposerKt.sourceInformation($composer, "C75@2973L63,82@3175L6,84@3265L21,78@3045L2082:DeepSearchParagraphPreview.kt#a32fmc");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(596544069, $changed, -1, "kntr.app.deepsearch.ui.paragraph.DeepSearchParagraphPreviewData.<anonymous> (DeepSearchParagraphPreview.kt:74)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 2048201156, "CC(remember):DeepSearchParagraphPreview.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateListOf(new String[]{RoomRecommendViewModel.EMPTY_CURSOR});
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final Iterable iterable = (SnapshotStateList) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv = ScrollKt.verticalScroll$default(WindowInsetsPadding_androidKt.safeContentPadding(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default($modifier, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null)), ScrollKt.rememberScrollState(0, $composer, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
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
            ComposerKt.sourceInformationMarkerStart($composer, 1973810665, "C87@3393L7,95@3774L7,96@3844L7,102@4198L611,89@3441L1368,117@4822L295:DeepSearchParagraphPreview.kt#a32fmc");
            CompositionLocal this_$iv = TextKt.getLocalTextStyle();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            TextStyle textStyle = (TextStyle) consume;
            Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
            DeepSearchParagraphComponent.Builder deepSearchParagraphComponentFactory = ((DeepSearchParagraphEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(DeepSearchParagraphEntryPoint.class))).getDeepSearchParagraphComponentFactory();
            CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            DeepSearchParagraphComponent.Builder bindDensity = deepSearchParagraphComponentFactory.bindDensity((Density) consume2);
            CompositionLocal this_$iv3 = BiliThemeKt.getLocalDayNightTheme();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume3 = $composer.consume(this_$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ParagraphBuilderProvider deepSearchParagraphBuilderProvider = bindDensity.bindDayNight((ThemeDayNight) consume3).bindSortedListDrawParams(new SortedListDrawParams(0.0f, 0.0f, 0.0f, 0.0f, 0L, 31, (DefaultConstructorMarker) null)).bindParagraphTextDrawParams(new ParagraphTextDrawParams(null, null, null, 7, null)).bindDefaultTextStyle(textStyle).build().deepSearchParagraphBuilderProvider();
            ComposerKt.sourceInformationMarkerStart($composer, -1737418398, "CC(remember):DeepSearchParagraphPreview.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.app.deepsearch.ui.paragraph.DeepSearchParagraphPreviewKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        Unit DeepSearchParagraphPreviewData$lambda$0$1$0$0;
                        DeepSearchParagraphPreviewData$lambda$0$1$0$0 = DeepSearchParagraphPreviewKt.DeepSearchParagraphPreviewData$lambda$0$1$0$0(iterable, (ParagraphStateBuilderScope) obj);
                        return DeepSearchParagraphPreviewData$lambda$0$1$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ParagraphState state = ParagraphStateKt.rememberParagraphState($data, (TextStyle) null, deepSearchParagraphBuilderProvider, (Function1) it$iv2, $composer, 3072, 2);
            Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            int $i$f$Column = ((6 >> 3) & 14) | ((6 >> 3) & 112);
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, $i$f$Column);
            int $changed$iv$iv2 = (6 << 3) & 112;
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
            int i4 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 352679197, "C118@4882L75:DeepSearchParagraphPreview.kt#a32fmc");
            TextKt.Text-Nvy7gAk(CollectionsKt.joinToString$default(iterable, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 48, 0, 262140);
            $composer.startReplaceGroup(1951042715);
            ComposerKt.sourceInformation($composer, "*120@5050L19,120@5022L63");
            Iterable $this$forEach$iv = state.getContents();
            boolean z = false;
            for (Iterator it = $this$forEach$iv.iterator(); it.hasNext(); it = it) {
                Object element$iv = it.next();
                ParagraphState state2 = state;
                ParagraphContent it2 = (ParagraphContent) element$iv;
                it2.Content(SizeKt.fillMaxWidth$default(ParagraphBuilderKt.padding(Modifier.Companion, it2.getSpacing(), $composer, 6), 0.0f, 1, (Object) null), $composer, 0);
                state = state2;
                z = z;
                $this$forEach$iv = $this$forEach$iv;
            }
            $composer.endReplaceGroup();
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
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeepSearchParagraphPreviewData$lambda$0$1$0$0(final SnapshotStateList $clicked, ParagraphStateBuilderScope $this$rememberParagraphState) {
        Intrinsics.checkNotNullParameter($this$rememberParagraphState, "$this$rememberParagraphState");
        $this$rememberParagraphState.register(Reflection.getOrCreateKotlinClass(KParagraph.KLine.class), new ParagraphClickListener() { // from class: kntr.app.deepsearch.ui.paragraph.DeepSearchParagraphPreviewKt$$ExternalSyntheticLambda0
            public final boolean invoke(KParagraph.IContent iContent) {
                boolean DeepSearchParagraphPreviewData$lambda$0$1$0$0$0;
                DeepSearchParagraphPreviewData$lambda$0$1$0$0$0 = DeepSearchParagraphPreviewKt.DeepSearchParagraphPreviewData$lambda$0$1$0$0$0($clicked, (KParagraph.KLine) iContent);
                return DeepSearchParagraphPreviewData$lambda$0$1$0$0$0;
            }
        });
        TextNodeClickListenerKt.registerTextParagraphClickListener($this$rememberParagraphState, new Function1() { // from class: kntr.app.deepsearch.ui.paragraph.DeepSearchParagraphPreviewKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit DeepSearchParagraphPreviewData$lambda$0$1$0$0$1;
                DeepSearchParagraphPreviewData$lambda$0$1$0$0$1 = DeepSearchParagraphPreviewKt.DeepSearchParagraphPreviewData$lambda$0$1$0$0$1($clicked, (TextParagraphBuilderScope) obj);
                return DeepSearchParagraphPreviewData$lambda$0$1$0$0$1;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DeepSearchParagraphPreviewData$lambda$0$1$0$0$0(SnapshotStateList $clicked, KParagraph.KLine it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return $clicked.add("Click at KLine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeepSearchParagraphPreviewData$lambda$0$1$0$0$1(final SnapshotStateList $clicked, TextParagraphBuilderScope $this$registerTextParagraphClickListener) {
        Intrinsics.checkNotNullParameter($this$registerTextParagraphClickListener, "$this$registerTextParagraphClickListener");
        $this$registerTextParagraphClickListener.registerNode(Reflection.getOrCreateKotlinClass(KTextNode.KLink.class), new TextNodeClickListener() { // from class: kntr.app.deepsearch.ui.paragraph.DeepSearchParagraphPreviewKt$$ExternalSyntheticLambda6
            public final boolean invoke(KTextNode.IText iText, TextNodeClickInfo textNodeClickInfo) {
                boolean DeepSearchParagraphPreviewData$lambda$0$1$0$0$1$0;
                DeepSearchParagraphPreviewData$lambda$0$1$0$0$1$0 = DeepSearchParagraphPreviewKt.DeepSearchParagraphPreviewData$lambda$0$1$0$0$1$0($clicked, (KTextNode.KLink) iText, textNodeClickInfo);
                return DeepSearchParagraphPreviewData$lambda$0$1$0$0$1$0;
            }
        });
        $this$registerTextParagraphClickListener.registerNode(Reflection.getOrCreateKotlinClass(KTextNode.KWord.class), new TextNodeClickListener() { // from class: kntr.app.deepsearch.ui.paragraph.DeepSearchParagraphPreviewKt$$ExternalSyntheticLambda7
            public final boolean invoke(KTextNode.IText iText, TextNodeClickInfo textNodeClickInfo) {
                boolean DeepSearchParagraphPreviewData$lambda$0$1$0$0$1$1;
                DeepSearchParagraphPreviewData$lambda$0$1$0$0$1$1 = DeepSearchParagraphPreviewKt.DeepSearchParagraphPreviewData$lambda$0$1$0$0$1$1($clicked, (KTextNode.KWord) iText, textNodeClickInfo);
                return DeepSearchParagraphPreviewData$lambda$0$1$0$0$1$1;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DeepSearchParagraphPreviewData$lambda$0$1$0$0$1$0(SnapshotStateList $clicked, KTextNode.KLink node, TextNodeClickInfo info) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(info, "info");
        return $clicked.add("Click at KLink " + node.getValue().getLink() + " at " + info);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DeepSearchParagraphPreviewData$lambda$0$1$0$0$1$1(SnapshotStateList $clicked, KTextNode.KWord node, TextNodeClickInfo info) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(info, "info");
        return $clicked.add("Click at KWord " + node.getValue().getWords() + " at " + info);
    }
}