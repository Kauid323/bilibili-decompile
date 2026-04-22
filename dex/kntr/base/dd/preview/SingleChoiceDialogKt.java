package kntr.base.dd.preview;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.RadioButtonColors;
import androidx.compose.material3.RadioButtonKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
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
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SingleChoiceDialog.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ag\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00040\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\tH\u0001¢\u0006\u0002\u0010\r¨\u0006\u000e²\u0006\u0010\u0010\u000f\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002X\u008a\u008e\u0002"}, d2 = {"SingleChoiceDialog", "", "T", "title", "", "items", "", "selectedItem", "onItemLabel", "Lkotlin/Function1;", "onDismiss", "Lkotlin/Function0;", "onConfirm", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "preview_debug", "currentSelection"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SingleChoiceDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SingleChoiceDialog$lambda$7(String str, List list, Object obj, Function1 function1, Function0 function0, Function1 function12, int i, Composer composer, int i2) {
        SingleChoiceDialog(str, list, obj, function1, function0, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final <T> void SingleChoiceDialog(final String title, final List<? extends T> list, final T t, final Function1<? super T, String> function1, final Function0<Unit> function0, final Function1<? super T, Unit> function12, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(function1, "onItemLabel");
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Intrinsics.checkNotNullParameter(function12, "onConfirm");
        Composer $composer2 = $composer.startRestartGroup(-2035567335);
        ComposerKt.sourceInformation($composer2, "C(SingleChoiceDialog)N(title,items,selectedItem,onItemLabel,onDismiss,onConfirm)31@1103L41,57@2189L176,65@2391L98,35@1217L52,36@1286L877,33@1150L1346:SingleChoiceDialog.kt#veq8ty");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(title) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= ($changed & 512) == 0 ? $composer2.changed(t) : $composer2.changedInstance(t) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function12) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2035567335, $dirty2, -1, "kntr.base.dd.preview.SingleChoiceDialog (SingleChoiceDialog.kt:30)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1970082590, "CC(remember):SingleChoiceDialog.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(t, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState currentSelection$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            AndroidAlertDialog_androidKt.AlertDialog-Oix01E0(function0, ComposableLambdaKt.rememberComposableLambda(-516523055, true, new Function2() { // from class: kntr.base.dd.preview.SingleChoiceDialogKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit SingleChoiceDialog$lambda$3;
                    SingleChoiceDialog$lambda$3 = SingleChoiceDialogKt.SingleChoiceDialog$lambda$3(function12, function0, currentSelection$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return SingleChoiceDialog$lambda$3;
                }
            }, $composer2, 54), (Modifier) null, ComposableLambdaKt.rememberComposableLambda(-1056952561, true, new Function2() { // from class: kntr.base.dd.preview.SingleChoiceDialogKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit SingleChoiceDialog$lambda$4;
                    SingleChoiceDialog$lambda$4 = SingleChoiceDialogKt.SingleChoiceDialog$lambda$4(function0, (Composer) obj, ((Integer) obj2).intValue());
                    return SingleChoiceDialog$lambda$4;
                }
            }, $composer2, 54), (Function2) null, ComposableLambdaKt.rememberComposableLambda(-1597382067, true, new Function2() { // from class: kntr.base.dd.preview.SingleChoiceDialogKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SingleChoiceDialog$lambda$5;
                    SingleChoiceDialog$lambda$5 = SingleChoiceDialogKt.SingleChoiceDialog$lambda$5(title, (Composer) obj, ((Integer) obj2).intValue());
                    return SingleChoiceDialog$lambda$5;
                }
            }, $composer2, 54), ComposableLambdaKt.rememberComposableLambda(279886828, true, new Function2() { // from class: kntr.base.dd.preview.SingleChoiceDialogKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit SingleChoiceDialog$lambda$6;
                    SingleChoiceDialog$lambda$6 = SingleChoiceDialogKt.SingleChoiceDialog$lambda$6(list, currentSelection$delegate, function1, (Composer) obj, ((Integer) obj2).intValue());
                    return SingleChoiceDialog$lambda$6;
                }
            }, $composer2, 54), (Shape) null, 0L, 0L, 0L, 0L, 0.0f, (DialogProperties) null, $composer2, (($dirty2 >> 12) & 14) | 1772592, 0, 16276);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.base.dd.preview.SingleChoiceDialogKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit SingleChoiceDialog$lambda$7;
                    SingleChoiceDialog$lambda$7 = SingleChoiceDialogKt.SingleChoiceDialog$lambda$7(title, list, t, function1, function0, function12, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return SingleChoiceDialog$lambda$7;
                }
            });
        }
    }

    private static final <T> T SingleChoiceDialog$lambda$1(MutableState<T> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (T) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SingleChoiceDialog$lambda$5(String $title, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C35@1219L48:SingleChoiceDialog.kt#veq8ty");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1597382067, $changed, -1, "kntr.base.dd.preview.SingleChoiceDialog.<anonymous> (SingleChoiceDialog.kt:35)");
            }
            TextKt.Text-Nvy7gAk($title, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 1572864, 0, 262078);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0199, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit SingleChoiceDialog$lambda$6(List $items, MutableState $currentSelection$delegate, Function1 $onItemLabel, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        final MutableState mutableState = $currentSelection$delegate;
        ComposerKt.sourceInformation($composer, "C37@1300L853:SingleChoiceDialog.kt#veq8ty");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(279886828, $changed, -1, "kntr.base.dd.preview.SingleChoiceDialog.<anonymous> (SingleChoiceDialog.kt:37)");
            }
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(4));
            int $changed$iv = '0';
            Composer $composer$iv = $composer;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer$iv, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv = (48 << 3) & 112;
            Composer $composer$iv$iv = $composer$iv;
            Modifier modifier$iv$iv = modifier$iv;
            MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv;
            String str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv, 0));
            CompositionLocalMap localMap$iv$iv = $composer$iv$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer$iv$iv, modifier$iv$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            String str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv$iv.startReusableNode();
            if ($composer$iv$iv.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer$iv$iv.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer$iv$iv.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer$iv$iv);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            boolean z = false;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, 910882513, "C:SingleChoiceDialog.kt#veq8ty");
            $composer$iv$iv.startReplaceGroup(-801900500);
            ComposerKt.sourceInformation($composer$iv$iv, "*44@1649L27,40@1481L640");
            List $this$forEach$iv = $items;
            boolean z2 = false;
            for (final Object element$iv : $this$forEach$iv) {
                Iterable $this$forEach$iv2 = $this$forEach$iv;
                boolean z3 = z2;
                boolean isSelected = Intrinsics.areEqual(element$iv, SingleChoiceDialog$lambda$1($currentSelection$delegate));
                int $changed$iv2 = $changed$iv;
                int compositeKeyHash$iv$iv2 = compositeKeyHash$iv$iv;
                boolean z4 = z;
                int $changed$iv$iv2 = $changed$iv$iv;
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv, 930257748, "CC(remember):SingleChoiceDialog.kt#9igjgp");
                boolean invalid$iv = $composer$iv$iv.changedInstance(element$iv);
                Object it$iv = $composer$iv$iv.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv = new Function0() { // from class: kntr.base.dd.preview.SingleChoiceDialogKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        Unit SingleChoiceDialog$lambda$6$0$0$0$0;
                        SingleChoiceDialog$lambda$6$0$0$0$0 = SingleChoiceDialogKt.SingleChoiceDialog$lambda$6$0$0$0$0(element$iv, mutableState);
                        return SingleChoiceDialog$lambda$6$0$0$0$0;
                    }
                };
                $composer$iv$iv.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                Modifier modifier$iv2 = PaddingKt.padding-3ABfNKs(ClickableKt.clickable-oSLSa3U$default(fillMaxWidth$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), Dp.constructor-impl(8));
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                Modifier modifier$iv$iv2 = modifier$iv$iv;
                MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer$iv$iv, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -1159599143, str);
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer$iv$iv.getCurrentCompositionLocalMap();
                String str3 = str;
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer$iv$iv, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = ((((384 << 3) & 112) << 6) & 896) | 6;
                Composer $composer$iv2 = $composer$iv;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -553112988, str2);
                if (!($composer$iv$iv.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv$iv.startReusableNode();
                if ($composer$iv$iv.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer$iv$iv.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer$iv$iv.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv$iv);
                String str4 = str2;
                Composer $composer$iv$iv2 = $composer$iv$iv;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i4 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -1671606192, "C50@1947L27,48@1845L156,52@2026L73:SingleChoiceDialog.kt#veq8ty");
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -608109072, "CC(remember):SingleChoiceDialog.kt#9igjgp");
                boolean invalid$iv2 = $composer$iv$iv.changedInstance(element$iv);
                Object it$iv2 = $composer$iv$iv.rememberedValue();
                if (!invalid$iv2 && it$iv2 != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    RadioButtonKt.RadioButton(isSelected, (Function0) it$iv2, (Modifier) null, false, (RadioButtonColors) null, (MutableInteractionSource) null, $composer$iv$iv, 0, 60);
                    TextKt.Text-Nvy7gAk((String) $onItemLabel.invoke(element$iv), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(8), 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer$iv$iv, 48, 0, 262140);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    $composer$iv$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    mutableState = $currentSelection$delegate;
                    $composer$iv = $composer$iv2;
                    compositeKeyHash$iv$iv = compositeKeyHash$iv$iv2;
                    $this$forEach$iv = $this$forEach$iv2;
                    z2 = z3;
                    $changed$iv = $changed$iv2;
                    z = z4;
                    $changed$iv$iv = $changed$iv$iv2;
                    modifier$iv$iv = modifier$iv$iv2;
                    measurePolicy$iv$iv = measurePolicy$iv$iv2;
                    str = str3;
                    str2 = str4;
                    $composer$iv$iv = $composer$iv$iv2;
                }
                Object value$iv2 = new Function0() { // from class: kntr.base.dd.preview.SingleChoiceDialogKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        Unit SingleChoiceDialog$lambda$6$0$0$1$0$0;
                        SingleChoiceDialog$lambda$6$0$0$1$0$0 = SingleChoiceDialogKt.SingleChoiceDialog$lambda$6$0$0$1$0$0(element$iv, mutableState);
                        return SingleChoiceDialog$lambda$6$0$0$1$0$0;
                    }
                };
                $composer$iv$iv.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                RadioButtonKt.RadioButton(isSelected, (Function0) it$iv2, (Modifier) null, false, (RadioButtonColors) null, (MutableInteractionSource) null, $composer$iv$iv, 0, 60);
                TextKt.Text-Nvy7gAk((String) $onItemLabel.invoke(element$iv), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(8), 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer$iv$iv, 48, 0, 262140);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                $composer$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                mutableState = $currentSelection$delegate;
                $composer$iv = $composer$iv2;
                compositeKeyHash$iv$iv = compositeKeyHash$iv$iv2;
                $this$forEach$iv = $this$forEach$iv2;
                z2 = z3;
                $changed$iv = $changed$iv2;
                z = z4;
                $changed$iv$iv = $changed$iv$iv2;
                modifier$iv$iv = modifier$iv$iv2;
                measurePolicy$iv$iv = measurePolicy$iv$iv2;
                str = str3;
                str2 = str4;
                $composer$iv$iv = $composer$iv$iv2;
            }
            $composer$iv$iv.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            $composer$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SingleChoiceDialog$lambda$6$0$0$0$0(Object $item, MutableState $currentSelection$delegate) {
        $currentSelection$delegate.setValue($item);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SingleChoiceDialog$lambda$6$0$0$1$0$0(Object $item, MutableState $currentSelection$delegate) {
        $currentSelection$delegate.setValue($item);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SingleChoiceDialog$lambda$3(final Function1 $onConfirm, final Function0 $onDismiss, final MutableState $currentSelection$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C58@2224L87,58@2203L152:SingleChoiceDialog.kt#veq8ty");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-516523055, $changed, -1, "kntr.base.dd.preview.SingleChoiceDialog.<anonymous> (SingleChoiceDialog.kt:58)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 1837551688, "CC(remember):SingleChoiceDialog.kt#9igjgp");
            boolean invalid$iv = $composer.changed($onConfirm) | $composer.changed($onDismiss);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.base.dd.preview.SingleChoiceDialogKt$$ExternalSyntheticLambda7
                    public final Object invoke() {
                        Unit SingleChoiceDialog$lambda$3$0$0;
                        SingleChoiceDialog$lambda$3$0$0 = SingleChoiceDialogKt.SingleChoiceDialog$lambda$3$0$0($onConfirm, $onDismiss, $currentSelection$delegate);
                        return SingleChoiceDialog$lambda$3$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) it$iv, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SingleChoiceDialogKt.INSTANCE.m1379getLambda$1421669516$preview_debug(), $composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SingleChoiceDialog$lambda$3$0$0(Function1 $onConfirm, Function0 $onDismiss, MutableState $currentSelection$delegate) {
        $onConfirm.invoke(SingleChoiceDialog$lambda$1($currentSelection$delegate));
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SingleChoiceDialog$lambda$4(Function0 $onDismiss, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C66@2405L74:SingleChoiceDialog.kt#veq8ty");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1056952561, $changed, -1, "kntr.base.dd.preview.SingleChoiceDialog.<anonymous> (SingleChoiceDialog.kt:66)");
            }
            ButtonKt.TextButton($onDismiss, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SingleChoiceDialogKt.INSTANCE.m1380getLambda$1962099022$preview_debug(), $composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}