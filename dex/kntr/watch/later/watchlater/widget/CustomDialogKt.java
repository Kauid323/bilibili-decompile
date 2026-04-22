package kntr.watch.later.watchlater.widget;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BorderStroke;
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
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
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
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CustomDialog.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001az\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"CustomDialog", "", "onDismissRequest", "Lkotlin/Function0;", "title", "", "message", "confirmText", "cancelText", "onConfirm", "onCancel", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "watch_later_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CustomDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomDialog$lambda$3(Function0 function0, String str, String str2, String str3, String str4, Function0 function02, Function0 function03, Function2 function2, int i, int i2, Composer composer, int i3) {
        CustomDialog(function0, str, str2, str3, str4, function02, function03, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static final void CustomDialog(final Function0<Unit> function0, String title, String message, String confirmText, String cancelText, Function0<Unit> function02, Function0<Unit> function03, Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        String str;
        Function0 onConfirm;
        String title2;
        String message2;
        String cancelText2;
        Function0 onCancel;
        Function2 content;
        String confirmText2;
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Composer $composer2 = $composer.startRestartGroup(-99021724);
        ComposerKt.sourceInformation($composer2, "C(CustomDialog)N(onDismissRequest,title,message,confirmText,cancelText,onConfirm,onCancel,content)37@1506L2,38@1537L2,48@1810L4065,41@1596L4279:CustomDialog.kt#yiq3mh");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(title) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(message) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            str = confirmText;
        } else if (($changed & 3072) == 0) {
            str = confirmText;
            $dirty |= $composer2.changed(str) ? 2048 : 1024;
        } else {
            str = confirmText;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty |= $composer2.changed(cancelText) ? 16384 : 8192;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= 196608;
            onConfirm = function02;
        } else if ((196608 & $changed) == 0) {
            onConfirm = function02;
            $dirty |= $composer2.changedInstance(onConfirm) ? 131072 : 65536;
        } else {
            onConfirm = function02;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changedInstance(function03) ? 1048576 : 524288;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ($composer2.shouldExecute(($dirty & 4793491) != 4793490, $dirty & 1)) {
            title2 = i2 != 0 ? "" : title;
            message2 = i3 != 0 ? "" : message;
            confirmText2 = i4 != 0 ? "" : str;
            cancelText2 = i5 != 0 ? "" : cancelText;
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -670590202, "CC(remember):CustomDialog.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.watch.later.watchlater.widget.CustomDialogKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onConfirm2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onConfirm = onConfirm2;
            }
            if (i7 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -670589210, "CC(remember):CustomDialog.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.watch.later.watchlater.widget.CustomDialogKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function0 onCancel2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onCancel = onCancel2;
            } else {
                onCancel = function03;
            }
            content = i8 != 0 ? null : function2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-99021724, $dirty, -1, "kntr.watch.later.watchlater.widget.CustomDialog (CustomDialog.kt:40)");
            }
            int $dirty2 = $dirty;
            final String str2 = title2;
            final Function2 function22 = content;
            final String str3 = message2;
            final String str4 = cancelText2;
            final Function0 function04 = onCancel;
            final Function0 function05 = onConfirm;
            final String str5 = confirmText2;
            AndroidDialog_androidKt.Dialog(function0, new DialogProperties(true, true, false, 4, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(-1728037573, true, new Function2() { // from class: kntr.watch.later.watchlater.widget.CustomDialogKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit CustomDialog$lambda$2;
                    CustomDialog$lambda$2 = CustomDialogKt.CustomDialog$lambda$2(str2, function22, str3, str4, function04, function0, function05, str5, (Composer) obj, ((Integer) obj2).intValue());
                    return CustomDialog$lambda$2;
                }
            }, $composer2, 54), $composer2, ($dirty2 & 14) | 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            title2 = title;
            message2 = message;
            cancelText2 = cancelText;
            onCancel = function03;
            content = function2;
            confirmText2 = str;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final String str6 = title2;
            final String str7 = message2;
            final String str8 = confirmText2;
            final String str9 = cancelText2;
            final Function0 function06 = onConfirm;
            final Function0 function07 = onCancel;
            final Function2 function23 = content;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.watch.later.watchlater.widget.CustomDialogKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit CustomDialog$lambda$3;
                    CustomDialog$lambda$3 = CustomDialogKt.CustomDialog$lambda$3(function0, str6, str7, str8, str9, function06, function07, function23, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CustomDialog$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomDialog$lambda$2(final String $title, final Function2 $content, final String $message, final String $cancelText, final Function0 $onCancel, final Function0 $onDismissRequest, final Function0 $onConfirm, final String $confirmText, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C56@2077L6,55@2018L88,59@2161L77,62@2250L3619,49@1820L4049:CustomDialog.kt#yiq3mh");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1728037573, $changed, -1, "kntr.watch.later.watchlater.widget.CustomDialog.<anonymous> (CustomDialog.kt:49)");
            }
            Modifier modifier = SizeKt.sizeIn-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(280), 0.0f, 11, (Object) null);
            Shape shape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8));
            CardColors cardColors = CardDefaults.INSTANCE.cardColors-ro_MJ88(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getWh0-0d7_KjU(), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14);
            CardDefaults cardDefaults = CardDefaults.INSTANCE;
            float f = Dp.constructor-impl(8);
            int $i$f$getDp = CardDefaults.$stable;
            CardKt.Card(modifier, shape, cardColors, cardDefaults.cardElevation-aqJV_2Y(f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer, ($i$f$getDp << 18) | 6, 62), (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(375900461, true, new Function3() { // from class: kntr.watch.later.watchlater.widget.CustomDialogKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit CustomDialog$lambda$2$0;
                    CustomDialog$lambda$2$0 = CustomDialogKt.CustomDialog$lambda$2$0($title, $content, $message, $cancelText, $onCancel, $onDismissRequest, $onConfirm, $confirmText, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return CustomDialog$lambda$2$0;
                }
            }, $composer, 54), $composer, 196614, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomDialog$lambda$2$0(String $title, Function2 $content, String $message, String $cancelText, final Function0 $onCancel, final Function0 $onDismissRequest, final Function0 $onConfirm, String $confirmText, ColumnScope $this$Card, Composer $composer, int $changed) {
        Modifier materialized$iv$iv;
        Composer $composer$iv$iv$iv;
        Alignment.Horizontal horizontalAlignment$iv;
        Function0 factory$iv$iv$iv;
        String str;
        Composer $composer$iv;
        Composer $composer$iv$iv;
        String str2;
        Composer $composer2;
        String str3;
        String str4;
        String str5;
        Composer $composer$iv$iv2;
        Composer $composer$iv$iv$iv2;
        int i;
        Composer $composer$iv2;
        Composer $composer$iv3;
        Composer $composer$iv$iv$iv3;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter($this$Card, "$this$Card");
        ComposerKt.sourceInformation($composer, "C63@2264L3595:CustomDialog.kt#yiq3mh");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(375900461, $changed, -1, "kntr.watch.later.watchlater.widget.CustomDialog.<anonymous>.<anonymous> (CustomDialog.kt:63)");
            }
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(18), 0.0f, 0.0f, 13, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv2, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                $composer.createNode(factory$iv$iv$iv3);
            } else {
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i3 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 830040596, "C99@3701L41,103@3912L6,100@3759L191,105@3967L1878:CustomDialog.kt#yiq3mh");
            String str6 = $title;
            if (str6 == null || StringsKt.isBlank(str6)) {
                materialized$iv$iv = materialized$iv$iv2;
                $composer$iv$iv$iv = $composer;
                horizontalAlignment$iv = horizontalAlignment$iv2;
                $composer.startReplaceGroup(827420351);
            } else {
                $composer.startReplaceGroup(830006650);
                ComposerKt.sourceInformation($composer, "80@2956L6,72@2592L453");
                materialized$iv$iv = materialized$iv$iv2;
                $composer$iv$iv$iv = $composer;
                horizontalAlignment$iv = horizontalAlignment$iv2;
                TextKt.Text-Nvy7gAk($title, PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(20), 0.0f, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(16), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 1597488, 0, 261032);
            }
            $composer.endReplaceGroup();
            if ($content != null) {
                $composer.startReplaceGroup(830499054);
                ComposerKt.sourceInformation($composer, "85@3123L9");
                $content.invoke($composer, 0);
                $composer.endReplaceGroup();
            } else {
                if ($message.length() > 0) {
                    $composer.startReplaceGroup(830593449);
                    ComposerKt.sourceInformation($composer, "87@3204L40,95@3577L6,88@3265L401");
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), $composer, 6);
                    TextKt.Text-Nvy7gAk($message, PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(20), 0.0f, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(13), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 24624, 0, 261096);
                } else {
                    $composer.startReplaceGroup(827420351);
                }
                $composer.endReplaceGroup();
            }
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), $composer, 6);
            DividerKt.HorizontalDivider-9IZ8Weo(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer, 54, 0);
            Modifier modifier$iv2 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(44));
            Arrangement.Horizontal horizontalArrangement$iv = (Arrangement.Horizontal) (!StringsKt.isBlank($cancelText) ? Arrangement.INSTANCE.getSpaceEvenly() : Arrangement.INSTANCE.getCenter());
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv2 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i5 = ((6 >> 6) & 112) | 6;
            RowScope $this$CustomDialog_u24lambda_u242_u240_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 1151106917, "C134@5315L138,129@5102L725:CustomDialog.kt#yiq3mh");
            if (StringsKt.isBlank($cancelText)) {
                str = "C72@3469L9:Box.kt#2w3rfo";
                $composer$iv = $composer;
                $composer$iv$iv = $composer;
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $composer2 = $composer;
                str3 = "CC(remember):CustomDialog.kt#9igjgp";
                str4 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                str5 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                $composer$iv$iv2 = $composer;
                $composer$iv$iv$iv2 = $composer;
                i = 16;
                $composer$iv2 = $composer;
                $composer$iv3 = $composer;
                $composer$iv$iv$iv3 = $composer$iv$iv$iv;
                $composer.startReplaceGroup(1146885243);
            } else {
                $composer.startReplaceGroup(1151111659);
                ComposerKt.sourceInformation($composer, "115@4492L149,110@4259L800");
                Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(RowScope.-CC.weight$default($this$CustomDialog_u24lambda_u242_u240_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 1006971548, "CC(remember):CustomDialog.kt#9igjgp");
                boolean invalid$iv = $composer.changed($onCancel) | $composer.changed($onDismissRequest);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.watch.later.watchlater.widget.CustomDialogKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit CustomDialog$lambda$2$0$0$0$0$0;
                            CustomDialog$lambda$2$0$0$0$0$0 = CustomDialogKt.CustomDialog$lambda$2$0$0$0$0$0($onCancel, $onDismissRequest);
                            return CustomDialog$lambda$2$0$0$0$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifier$iv3 = ClickableKt.clickable-oSLSa3U$default(fillMaxHeight$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
                Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv3 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
                Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    $composer.createNode(factory$iv$iv$iv5);
                } else {
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i7 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 1719474862, "C124@4921L6,121@4764L200,126@4993L40:CustomDialog.kt#yiq3mh");
                $composer$iv = $composer;
                $composer$iv$iv = $composer;
                $composer$iv$iv2 = $composer;
                $composer$iv2 = $composer;
                $composer$iv$iv$iv3 = $composer$iv$iv$iv;
                $composer$iv$iv$iv2 = $composer;
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                i = 16;
                $composer2 = $composer;
                str3 = "CC(remember):CustomDialog.kt#9igjgp";
                str4 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                $composer$iv3 = $composer;
                str5 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                str = "C72@3469L9:Box.kt#2w3rfo";
                TextKt.Text-Nvy7gAk($cancelText, (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(16), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 24576, 0, 262122);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer, 6);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
            }
            $composer.endReplaceGroup();
            Modifier fillMaxHeight$default2 = SizeKt.fillMaxHeight$default(RowScope.-CC.weight$default($this$CustomDialog_u24lambda_u242_u240_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1006997873, str3);
            boolean invalid$iv2 = $composer.changed($onConfirm) | $composer.changed($onDismissRequest);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.watch.later.watchlater.widget.CustomDialogKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit CustomDialog$lambda$2$0$0$0$2$0;
                        CustomDialog$lambda$2$0$0$0$2$0 = CustomDialogKt.CustomDialog$lambda$2$0$0$0$2$0($onConfirm, $onDismissRequest);
                        return CustomDialog$lambda$2$0$0$0$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv4 = ClickableKt.clickable-oSLSa3U$default(fillMaxHeight$default2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
            Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, str4);
            MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv4 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, str5);
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer, modifier$iv4);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, str2);
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, str);
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i9 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 2109038149, "C143@5710L6,140@5564L241:CustomDialog.kt#yiq3mh");
            TextKt.Text-Nvy7gAk($confirmText, (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getPi5-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(i), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 24576, 0, 261098);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv$iv$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer$iv$iv$iv3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomDialog$lambda$2$0$0$0$0$0(Function0 $onCancel, Function0 $onDismissRequest) {
        $onCancel.invoke();
        $onDismissRequest.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomDialog$lambda$2$0$0$0$2$0(Function0 $onConfirm, Function0 $onDismissRequest) {
        $onConfirm.invoke();
        $onDismissRequest.invoke();
        return Unit.INSTANCE;
    }
}