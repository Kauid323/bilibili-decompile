package kntr.app.deepsearch.ui;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchThinkPopContent;
import kntr.app.deepsearch.ui.bottomSheet.BottomSheetDialogKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThinkingDialog.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u008e\u0002"}, d2 = {"ThinkingDialog", RoomRecommendViewModel.EMPTY_CURSOR, "showBottomSheetDialog", RoomRecommendViewModel.EMPTY_CURSOR, "dispatcher", "Lkotlin/Function1;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "data", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "modifier", "Landroidx/compose/ui/Modifier;", "(ZLkotlin/jvm/functions/Function1;Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "compose_debug", "lineCount", RoomRecommendViewModel.EMPTY_CURSOR}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ThinkingDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ThinkingDialog$lambda$3(boolean z, Function1 function1, DeepSearchPageData deepSearchPageData, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ThinkingDialog(z, function1, deepSearchPageData, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ThinkingDialog(final boolean showBottomSheetDialog, final Function1<? super DeepSearchAction, Unit> function1, final DeepSearchPageData data, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(function1, "dispatcher");
        Intrinsics.checkNotNullParameter(data, "data");
        Composer $composer2 = $composer.startRestartGroup(244278921);
        ComposerKt.sourceInformation($composer2, "C(ThinkingDialog)N(showBottomSheetDialog,dispatcher,data,modifier)29@1119L90,32@1227L205,39@1440L742,26@1001L1181:ThinkingDialog.kt#7uvpm4");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(showBottomSheetDialog) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(data) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        if (!$composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(244278921, $dirty, -1, "kntr.app.deepsearch.ui.ThinkingDialog (ThinkingDialog.kt:25)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1471148797, "CC(remember):ThinkingDialog.kt#9igjgp");
            boolean invalid$iv = ($dirty & 112) == 32;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.deepsearch.ui.ThinkingDialogKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit ThinkingDialog$lambda$0$0;
                        ThinkingDialog$lambda$0$0 = ThinkingDialogKt.ThinkingDialog$lambda$0$0(function1);
                        return ThinkingDialog$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            BottomSheetDialogKt.DSBottomSheetDialog(showBottomSheetDialog, (Function0) it$iv, ComposableLambdaKt.rememberComposableLambda(-1174090935, true, new Function2() { // from class: kntr.app.deepsearch.ui.ThinkingDialogKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ThinkingDialog$lambda$1;
                    ThinkingDialog$lambda$1 = ThinkingDialogKt.ThinkingDialog$lambda$1(DeepSearchPageData.this, (Composer) obj, ((Integer) obj2).intValue());
                    return ThinkingDialog$lambda$1;
                }
            }, $composer2, 54), modifier4, ComposableLambdaKt.rememberComposableLambda(1797697415, true, new Function2() { // from class: kntr.app.deepsearch.ui.ThinkingDialogKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit ThinkingDialog$lambda$2;
                    ThinkingDialog$lambda$2 = ThinkingDialogKt.ThinkingDialog$lambda$2(DeepSearchPageData.this, (Composer) obj, ((Integer) obj2).intValue());
                    return ThinkingDialog$lambda$2;
                }
            }, $composer2, 54), $composer2, ($dirty & 14) | 24960 | ($dirty & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.ThinkingDialogKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit ThinkingDialog$lambda$3;
                    ThinkingDialog$lambda$3 = ThinkingDialogKt.ThinkingDialog$lambda$3(showBottomSheetDialog, function1, data, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ThinkingDialog$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ThinkingDialog$lambda$0$0(Function1 $dispatcher) {
        $dispatcher.invoke(DeepSearchAction.ThinkPopViewAction.ThinkPopViewHidden.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ThinkingDialog$lambda$1(DeepSearchPageData $data, Composer $composer, int $changed) {
        String str;
        ComposerKt.sourceInformation($composer, "C35@1345L9,36@1395L6,33@1241L181:ThinkingDialog.kt#7uvpm4");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1174090935, $changed, -1, "kntr.app.deepsearch.ui.ThinkingDialog.<anonymous> (ThinkingDialog.kt:33)");
            }
            DeepSearchThinkPopContent thinkPopContent = $data.getThinkPopContent();
            if (thinkPopContent == null || (str = thinkPopContent.getWindowTitle()) == null) {
                str = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            TextKt.Text-Nvy7gAk(str, (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT15b(), $composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ThinkingDialog$lambda$2(DeepSearchPageData $data, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        String str;
        ComposerKt.sourceInformation($composer, "C40@1468L21,41@1515L33,42@1557L410,54@2002L174,54@1976L200:ThinkingDialog.kt#7uvpm4");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1797697415, $changed, -1, "kntr.app.deepsearch.ui.ThinkingDialog.<anonymous> (ThinkingDialog.kt:40)");
            }
            ScrollState scrollState = ScrollKt.rememberScrollState(0, $composer, 0, 1);
            ComposerKt.sourceInformationMarkerStart($composer, 1010365256, "CC(remember):ThinkingDialog.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotIntStateKt.mutableIntStateOf(0);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableIntState lineCount$delegate = (MutableIntState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv$iv = ScrollKt.verticalScroll$default(Modifier.Companion, scrollState, false, (FlingBehavior) null, false, 14, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv$iv);
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
            ComposerKt.sourceInformationMarkerStart($composer, 1150248831, "C47@1750L9,48@1799L6,49@1844L98,45@1650L307:ThinkingDialog.kt#7uvpm4");
            DeepSearchThinkPopContent thinkPopContent = $data.getThinkPopContent();
            if (thinkPopContent == null || (str = thinkPopContent.getContent()) == null) {
                str = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            String str2 = str;
            TextStyle t13 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT13();
            long j2 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU();
            ComposerKt.sourceInformationMarkerStart($composer, -932720525, "CC(remember):ThinkingDialog.kt#9igjgp");
            Object value$iv2 = $composer.rememberedValue();
            if (value$iv2 == Composer.Companion.getEmpty()) {
                value$iv2 = new Function1() { // from class: kntr.app.deepsearch.ui.ThinkingDialogKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit ThinkingDialog$lambda$2$3$0$0;
                        ThinkingDialog$lambda$2$3$0$0 = ThinkingDialogKt.ThinkingDialog$lambda$2$3$0$0(lineCount$delegate, (TextLayoutResult) obj);
                        return ThinkingDialog$lambda$2$3$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            TextKt.Text-Nvy7gAk(str2, (Modifier) null, j2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) value$iv2, t13, $composer, 0, 1572864, 65530);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Integer valueOf = Integer.valueOf(ThinkingDialog$lambda$2$1(lineCount$delegate));
            ComposerKt.sourceInformationMarkerStart($composer, 1010380981, "CC(remember):ThinkingDialog.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($data) | $composer.changed(scrollState);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (Function2) new ThinkingDialogKt$ThinkingDialog$3$2$1($data, scrollState, null);
                $composer.updateRememberedValue(value$iv3);
                it$iv2 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv2, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final int ThinkingDialog$lambda$2$1(MutableIntState $lineCount$delegate) {
        IntState $this$getValue$iv = (IntState) $lineCount$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ThinkingDialog$lambda$2$3$0$0(MutableIntState $lineCount$delegate, TextLayoutResult textLayoutResult) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        $lineCount$delegate.setIntValue(textLayoutResult.getLineCount());
        return Unit.INSTANCE;
    }
}