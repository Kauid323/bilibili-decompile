package kntr.base.dd.preview;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
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
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: TipsDialog.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0001¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"TipsDialog", "", "title", "", "message", "onDismiss", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "preview_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TipsDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TipsDialog$lambda$4(String str, String str2, Function0 function0, int i, int i2, Composer composer, int i3) {
        TipsDialog(str, str2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v11 */
    public static final void TipsDialog(String title, String message, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        String str;
        String str2;
        Function0 onDismiss;
        String message2;
        String title2;
        final String title3;
        final String message3;
        final Function0 onDismiss2;
        Composer $composer2 = $composer.startRestartGroup(1504220906);
        ComposerKt.sourceInformation($composer2, "C(TipsDialog)N(title,message,onDismiss)18@642L2,35@1101L105,22@721L72,25@810L265,20@654L559:TipsDialog.kt#veq8ty");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            str = title;
        } else if (($changed & 6) == 0) {
            str = title;
            $dirty |= $composer2.changed(str) ? 4 : 2;
        } else {
            str = title;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            str2 = message;
        } else if (($changed & 48) == 0) {
            str2 = message;
            $dirty |= $composer2.changed(str2) ? 32 : 16;
        } else {
            str2 = message;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            onDismiss = function0;
        } else if (($changed & 384) == 0) {
            onDismiss = function0;
            $dirty |= $composer2.changedInstance(onDismiss) ? 256 : 128;
        } else {
            onDismiss = function0;
        }
        if (!$composer2.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            message2 = str2;
            title2 = str;
        } else {
            if (i2 != 0) {
                title3 = "提示";
            } else {
                title3 = str;
            }
            if (i3 == 0) {
                message3 = str2;
            } else {
                message3 = "";
            }
            if (i4 == 0) {
                onDismiss2 = onDismiss;
            } else {
                ComposerKt.sourceInformationMarkerStart($composer2, -1847685012, "CC(remember):TipsDialog.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.base.dd.preview.TipsDialogKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onDismiss2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1504220906, $dirty, -1, "kntr.base.dd.preview.TipsDialog (TipsDialog.kt:19)");
            }
            AndroidAlertDialog_androidKt.AlertDialog-Oix01E0(onDismiss2, ComposableLambdaKt.rememberComposableLambda(-87271006, true, new Function2() { // from class: kntr.base.dd.preview.TipsDialogKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit TipsDialog$lambda$1;
                    TipsDialog$lambda$1 = TipsDialogKt.TipsDialog$lambda$1(onDismiss2, (Composer) obj, ((Integer) obj2).intValue());
                    return TipsDialog$lambda$1;
                }
            }, $composer2, 54), (Modifier) null, (Function2) null, (Function2) null, ComposableLambdaKt.rememberComposableLambda(-1333834210, true, new Function2() { // from class: kntr.base.dd.preview.TipsDialogKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TipsDialog$lambda$2;
                    TipsDialog$lambda$2 = TipsDialogKt.TipsDialog$lambda$2(title3, (Composer) obj, ((Integer) obj2).intValue());
                    return TipsDialog$lambda$2;
                }
            }, $composer2, 54), ComposableLambdaKt.rememberComposableLambda(502008637, true, new Function2() { // from class: kntr.base.dd.preview.TipsDialogKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit TipsDialog$lambda$3;
                    TipsDialog$lambda$3 = TipsDialogKt.TipsDialog$lambda$3(message3, (Composer) obj, ((Integer) obj2).intValue());
                    return TipsDialog$lambda$3;
                }
            }, $composer2, 54), (Shape) null, 0L, 0L, 0L, 0L, 0.0f, (DialogProperties) null, $composer2, (($dirty >> 6) & 14) | 1769520, 0, 16284);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            title2 = title3;
            message2 = message3;
            onDismiss = onDismiss2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final String str3 = title2;
            final String str4 = message2;
            final Function0 function02 = onDismiss;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.base.dd.preview.TipsDialogKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit TipsDialog$lambda$4;
                    TipsDialog$lambda$4 = TipsDialogKt.TipsDialog$lambda$4(str3, str4, function02, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TipsDialog$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TipsDialog$lambda$2(String $title, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C23@735L48:TipsDialog.kt#veq8ty");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1333834210, $changed, -1, "kntr.base.dd.preview.TipsDialog.<anonymous> (TipsDialog.kt:23)");
            }
            TextKt.Text-Nvy7gAk($title, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 1572864, 0, 262078);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TipsDialog$lambda$3(String $message, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C30@982L21,26@824L241:TipsDialog.kt#veq8ty");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(502008637, $changed, -1, "kntr.base.dd.preview.TipsDialog.<anonymous> (TipsDialog.kt:26)");
            }
            Modifier modifier$iv = ScrollKt.verticalScroll$default(SizeKt.heightIn-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(320), 1, (Object) null), ScrollKt.rememberScrollState(0, $composer, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
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
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -753354369, "C32@1038L13:TipsDialog.kt#veq8ty");
            TextKt.Text-Nvy7gAk($message, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 0, 0, 262142);
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
    public static final Unit TipsDialog$lambda$1(Function0 $onDismiss, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C36@1115L81:TipsDialog.kt#veq8ty");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-87271006, $changed, -1, "kntr.base.dd.preview.TipsDialog.<anonymous> (TipsDialog.kt:36)");
            }
            ButtonKt.TextButton($onDismiss, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$TipsDialogKt.INSTANCE.m1381getLambda$472547643$preview_debug(), $composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}