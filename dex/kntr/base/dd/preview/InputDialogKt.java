package kntr.base.dd.preview;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: InputDialog.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\u001aW\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"InputDialog", "", "onDismiss", "Lkotlin/Function0;", "onConfirm", "Lkotlin/Function1;", "", "", "title", "placeholders", "tips", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "preview_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class InputDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputDialog$lambda$5(Function0 function0, Function1 function1, String str, List list, String str2, int i, int i2, Composer composer, int i3) {
        InputDialog(function0, function1, str, list, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void InputDialog(final Function0<Unit> function0, final Function1<? super List<String>, Unit> function1, final String title, final List<String> list, String tips, Composer $composer, final int $changed, final int i) {
        String str;
        Composer $composer2;
        String tips2;
        final String tips3;
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Intrinsics.checkNotNullParameter(function1, "onConfirm");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(list, "placeholders");
        Composer $composer3 = $composer.startRestartGroup(906979875);
        ComposerKt.sourceInformation($composer3, "C(InputDialog)N(onDismiss,onConfirm,title,placeholders,tips)30@973L65,59@2067L180,67@2273L98,34@1111L15,35@1143L898,32@1044L1334:InputDialog.kt#veq8ty");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(title) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(list) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            str = tips;
        } else if (($changed & 24576) == 0) {
            str = tips;
            $dirty |= $composer3.changed(str) ? 16384 : 8192;
        } else {
            str = tips;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            tips2 = str;
        } else {
            if (i2 != 0) {
                tips3 = null;
            } else {
                tips3 = str;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(906979875, $dirty2, -1, "kntr.base.dd.preview.InputDialog (InputDialog.kt:29)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -270695196, "CC(remember):InputDialog.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                int size = list.size();
                String[] strArr = new String[size];
                for (int i3 = 0; i3 < size; i3++) {
                    strArr[i3] = "";
                }
                Object value$iv = SnapshotStateKt.mutableStateListOf(strArr);
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final SnapshotStateList inputStates = (SnapshotStateList) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            tips2 = tips3;
            $composer2 = $composer3;
            AndroidAlertDialog_androidKt.AlertDialog-Oix01E0(function0, ComposableLambdaKt.rememberComposableLambda(1971482219, true, new Function2() { // from class: kntr.base.dd.preview.InputDialogKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit InputDialog$lambda$1;
                    InputDialog$lambda$1 = InputDialogKt.InputDialog$lambda$1(function1, function0, inputStates, (Composer) obj, ((Integer) obj2).intValue());
                    return InputDialog$lambda$1;
                }
            }, $composer3, 54), (Modifier) null, ComposableLambdaKt.rememberComposableLambda(-1461651475, true, new Function2() { // from class: kntr.base.dd.preview.InputDialogKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit InputDialog$lambda$2;
                    InputDialog$lambda$2 = InputDialogKt.InputDialog$lambda$2(function0, (Composer) obj, ((Integer) obj2).intValue());
                    return InputDialog$lambda$2;
                }
            }, $composer3, 54), (Function2) null, ComposableLambdaKt.rememberComposableLambda(-599817873, true, new Function2() { // from class: kntr.base.dd.preview.InputDialogKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit InputDialog$lambda$3;
                    InputDialog$lambda$3 = InputDialogKt.InputDialog$lambda$3(title, (Composer) obj, ((Integer) obj2).intValue());
                    return InputDialog$lambda$3;
                }
            }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(-168901072, true, new Function2() { // from class: kntr.base.dd.preview.InputDialogKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit InputDialog$lambda$4;
                    InputDialog$lambda$4 = InputDialogKt.InputDialog$lambda$4(tips3, list, inputStates, (Composer) obj, ((Integer) obj2).intValue());
                    return InputDialog$lambda$4;
                }
            }, $composer3, 54), (Shape) null, 0L, 0L, 0L, 0L, 0.0f, (DialogProperties) null, $composer2, ($dirty2 & 14) | 1772592, 0, 16276);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final String str2 = tips2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.base.dd.preview.InputDialogKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit InputDialog$lambda$5;
                    InputDialog$lambda$5 = InputDialogKt.InputDialog$lambda$5(function0, function1, title, list, str2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return InputDialog$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputDialog$lambda$3(String $title, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C34@1113L11:InputDialog.kt#veq8ty");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-599817873, $changed, -1, "kntr.base.dd.preview.InputDialog.<anonymous> (InputDialog.kt:34)");
            }
            TextKt.Text-Nvy7gAk($title, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputDialog$lambda$4(String $tips, List $placeholders, final SnapshotStateList $inputStates, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C36@1157L874:InputDialog.kt#veq8ty");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-168901072, $changed, -1, "kntr.base.dd.preview.InputDialog.<anonymous> (InputDialog.kt:36)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
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
            int $changed$iv = ($changed$iv$iv$iv >> 6) & 14;
            boolean z = false;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 816256634, "C:InputDialog.kt#veq8ty");
            String str = $tips;
            if (!(str == null || StringsKt.isBlank(str))) {
                $composer.startReplaceGroup(816287385);
                ComposerKt.sourceInformation($composer, "40@1316L9,41@1381L6,38@1231L259");
                TextKt.Text-Nvy7gAk($tips, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(8), 7, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText_notice-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getDescription(), $composer, 48, 0, 131064);
            } else {
                $composer.startReplaceGroup(815057212);
            }
            $composer.endReplaceGroup();
            $composer.startReplaceGroup(2104551908);
            ComposerKt.sourceInformation($composer, "*49@1709L27,50@1776L21,47@1598L401");
            List $this$forEachIndexed$iv = $placeholders;
            boolean z2 = false;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                final String placeholder = (String) item$iv;
                final int index = index$iv;
                boolean z3 = z2;
                String str2 = (String) $inputStates.get(index);
                int $changed$iv2 = $changed$iv;
                int compositeKeyHash$iv$iv2 = compositeKeyHash$iv$iv;
                boolean z4 = z;
                Alignment.Horizontal horizontalAlignment$iv2 = horizontalAlignment$iv;
                MeasurePolicy measurePolicy$iv2 = measurePolicy$iv;
                Modifier modifier = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(4), 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 2020548743, "CC(remember):InputDialog.kt#9igjgp");
                boolean invalid$iv = $composer.changed(index);
                Object it$iv = $composer.rememberedValue();
                if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    OutlinedTextFieldKt.OutlinedTextField(str2, (Function1) it$iv, modifier, false, false, (TextStyle) null, (Function2) null, ComposableLambdaKt.rememberComposableLambda(501440773, true, new Function2() { // from class: kntr.base.dd.preview.InputDialogKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj, Object obj2) {
                            Unit InputDialog$lambda$4$0$0$1;
                            InputDialog$lambda$4$0$0$1 = InputDialogKt.InputDialog$lambda$4$0$0$1(placeholder, (Composer) obj, ((Integer) obj2).intValue());
                            return InputDialog$lambda$4$0$0$1;
                        }
                    }, $composer, 54), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 12583296, 0, 0, 8388472);
                    index$iv = index$iv2;
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    $changed$iv = $changed$iv2;
                    z2 = z3;
                    compositeKeyHash$iv$iv = compositeKeyHash$iv$iv2;
                    z = z4;
                    horizontalAlignment$iv = horizontalAlignment$iv2;
                    measurePolicy$iv = measurePolicy$iv2;
                }
                Object value$iv = new Function1() { // from class: kntr.base.dd.preview.InputDialogKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit InputDialog$lambda$4$0$0$0$0;
                        InputDialog$lambda$4$0$0$0$0 = InputDialogKt.InputDialog$lambda$4$0$0$0$0($inputStates, index, (String) obj);
                        return InputDialog$lambda$4$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                OutlinedTextFieldKt.OutlinedTextField(str2, (Function1) it$iv, modifier, false, false, (TextStyle) null, (Function2) null, ComposableLambdaKt.rememberComposableLambda(501440773, true, new Function2() { // from class: kntr.base.dd.preview.InputDialogKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2) {
                        Unit InputDialog$lambda$4$0$0$1;
                        InputDialog$lambda$4$0$0$1 = InputDialogKt.InputDialog$lambda$4$0$0$1(placeholder, (Composer) obj, ((Integer) obj2).intValue());
                        return InputDialog$lambda$4$0$0$1;
                    }
                }, $composer, 54), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 12583296, 0, 0, 8388472);
                index$iv = index$iv2;
                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                $changed$iv = $changed$iv2;
                z2 = z3;
                compositeKeyHash$iv$iv = compositeKeyHash$iv$iv2;
                z = z4;
                horizontalAlignment$iv = horizontalAlignment$iv2;
                measurePolicy$iv = measurePolicy$iv2;
            }
            $composer.endReplaceGroup();
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
    public static final Unit InputDialog$lambda$4$0$0$0$0(SnapshotStateList $inputStates, int $index, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $inputStates.set($index, it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputDialog$lambda$4$0$0$1(String $placeholder, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C50@1778L17:InputDialog.kt#veq8ty");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(501440773, $changed, -1, "kntr.base.dd.preview.InputDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (InputDialog.kt:50)");
            }
            TextKt.Text-Nvy7gAk($placeholder, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputDialog$lambda$1(final Function1 $onConfirm, final Function0 $onDismiss, final SnapshotStateList $inputStates, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C60@2102L91,60@2081L156:InputDialog.kt#veq8ty");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1971482219, $changed, -1, "kntr.base.dd.preview.InputDialog.<anonymous> (InputDialog.kt:60)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 513836134, "CC(remember):InputDialog.kt#9igjgp");
            boolean invalid$iv = $composer.changed($onConfirm) | $composer.changed($onDismiss);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.base.dd.preview.InputDialogKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit InputDialog$lambda$1$0$0;
                        InputDialog$lambda$1$0$0 = InputDialogKt.InputDialog$lambda$1$0$0($onConfirm, $inputStates, $onDismiss);
                        return InputDialog$lambda$1$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) it$iv, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$InputDialogKt.INSTANCE.m1376getLambda$1791372376$preview_debug(), $composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputDialog$lambda$1$0$0(Function1 $onConfirm, SnapshotStateList $inputStates, Function0 $onDismiss) {
        $onConfirm.invoke($inputStates.toList());
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputDialog$lambda$2(Function0 $onDismiss, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C68@2287L74:InputDialog.kt#veq8ty");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1461651475, $changed, -1, "kntr.base.dd.preview.InputDialog.<anonymous> (InputDialog.kt:68)");
            }
            ButtonKt.TextButton($onDismiss, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$InputDialogKt.INSTANCE.m1377getLambda$929538774$preview_debug(), $composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}