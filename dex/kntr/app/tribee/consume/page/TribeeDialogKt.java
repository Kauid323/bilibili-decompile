package kntr.app.tribee.consume.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
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
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import bili.resource.tribee.String0_commonMainKt;
import bili.resource.tribee.TribeeRes;
import com.bapis.bilibili.app.dynamic.v2.KToastDialog;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.iconfont.BiliIconfontKt;
import com.bilibili.compose.text.SimpleTextFieldKt;
import com.bilibili.compose.text.TextFieldColors;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.tribee.consume.viewmodel.track.TrackerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.base.net.comm.imp.InitGMultiDomainKt;
import kntr.common.trio.toast.ToastDuration;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: TribeeDialog.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u001af\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052+\b\u0002\u0010\u0007\u001a%\u0012\u0004\u0012\u00020\u0006\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001ay\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u001c\u001ac\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u001e\u001a/\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\"\u001a/\u0010#\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\"\u001aG\u0010$\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010%\u001aQ\u0010&\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010'\u001aK\u0010(\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0003¢\u0006\u0002\u0010)¨\u0006*²\u0006\n\u0010+\u001a\u00020\tX\u008a\u008e\u0002"}, d2 = {"TribeeDialog", "", "dialog", "Lcom/bapis/bilibili/app/dynamic/v2/KToastDialog;", "cancelClickCallback", "Lkotlin/Function1;", "Lcom/bapis/bilibili/app/dynamic/v2/KToastDialog$KToastDialogType;", "confirmClickCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "params", "onDismiss", "Lkotlin/Function0;", "(Lcom/bapis/bilibili/app/dynamic/v2/KToastDialog;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "DialogContent", "title", "cancelText", "confirmText", "modifier", "Landroidx/compose/ui/Modifier;", "topImage", "subtitle", "isEmphasisCancel", "", "topEndCloseIcon", "Landroidx/compose/ui/graphics/painter/Painter;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "GameStatsCheckDialog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "DialogSingleConfirmButton", "text", "clickCallback", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "DialogSingleButton", "GameStatsDialogOptionalButton", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "DialogOptionalButton", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "TribeeInviteCheckDialog", "(Lcom/bapis/bilibili/app/dynamic/v2/KToastDialog;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "consume_debug", "input"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DialogContent$lambda$3(String str, String str2, String str3, Modifier modifier, String str4, String str5, boolean z, Painter painter, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        DialogContent(str, str2, str3, modifier, str4, str5, z, painter, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DialogOptionalButton$lambda$3(String str, String str2, Modifier modifier, boolean z, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        DialogOptionalButton(str, str2, modifier, z, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DialogSingleButton$lambda$3(String str, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        DialogSingleButton(str, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DialogSingleConfirmButton$lambda$3(String str, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        DialogSingleConfirmButton(str, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GameStatsCheckDialog$lambda$3(String str, String str2, String str3, Modifier modifier, String str4, String str5, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        GameStatsCheckDialog(str, str2, str3, modifier, str4, str5, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GameStatsDialogOptionalButton$lambda$3(String str, String str2, Modifier modifier, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        GameStatsDialogOptionalButton(str, str2, modifier, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeDialog$lambda$4(KToastDialog kToastDialog, Function1 function1, Function2 function2, Function0 function0, int i, int i2, Composer composer, int i3) {
        TribeeDialog(kToastDialog, function1, function2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInviteCheckDialog$lambda$5(KToastDialog kToastDialog, Function0 function0, Function1 function1, Function0 function02, int i, int i2, Composer composer, int i3) {
        TribeeInviteCheckDialog(kToastDialog, function0, function1, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeDialog$lambda$0$0(KToastDialog.KToastDialogType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeDialog$lambda$1$0(KToastDialog.KToastDialogType kToastDialogType, String str) {
        Intrinsics.checkNotNullParameter(kToastDialogType, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r15v9 */
    public static final void TribeeDialog(final KToastDialog dialog, Function1<? super KToastDialog.KToastDialogType, Unit> function1, Function2<? super KToastDialog.KToastDialogType, ? super String, Unit> function2, final Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Function1 function12;
        Function2 function22;
        Function1 cancelClickCallback;
        final Function2 confirmClickCallback;
        final Function1 cancelClickCallback2;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Composer $composer2 = $composer.startRestartGroup(1181365295);
        ComposerKt.sourceInformation($composer2, "C(TribeeDialog)N(dialog,cancelClickCallback,confirmClickCallback,onDismiss)72@3368L2,73@3457L11,76@3533L1144,76@3505L1172,117@4805L2779,114@4683L2901:TribeeDialog.kt#iitu82");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(dialog) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            function12 = function1;
        } else if (($changed & 48) == 0) {
            function12 = function1;
            $dirty |= $composer2.changedInstance(function12) ? 32 : 16;
        } else {
            function12 = function1;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            function22 = function2;
        } else if (($changed & 384) == 0) {
            function22 = function2;
            $dirty |= $composer2.changedInstance(function22) ? 256 : 128;
        } else {
            function22 = function2;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            if (i2 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1420685905, "CC(remember):TribeeDialog.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda13
                        public final Object invoke(Object obj) {
                            Unit TribeeDialog$lambda$0$0;
                            TribeeDialog$lambda$0$0 = TribeeDialogKt.TribeeDialog$lambda$0$0((KToastDialog.KToastDialogType) obj);
                            return TribeeDialog$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function1 cancelClickCallback3 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                cancelClickCallback2 = cancelClickCallback3;
            } else {
                cancelClickCallback2 = function12;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1420688762, "CC(remember):TribeeDialog.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function2() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda14
                        public final Object invoke(Object obj, Object obj2) {
                            Unit TribeeDialog$lambda$1$0;
                            TribeeDialog$lambda$1$0 = TribeeDialogKt.TribeeDialog$lambda$1$0((KToastDialog.KToastDialogType) obj, (String) obj2);
                            return TribeeDialog$lambda$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function2 confirmClickCallback2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                confirmClickCallback = confirmClickCallback2;
            } else {
                confirmClickCallback = function22;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1181365295, $dirty2, -1, "kntr.app.tribee.consume.page.TribeeDialog (TribeeDialog.kt:75)");
            }
            KToastDialog.KToastDialogType type = dialog.getType();
            ComposerKt.sourceInformationMarkerStart($composer2, 1420692327, "CC(remember):TribeeDialog.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(dialog);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (Function2) new TribeeDialogKt$TribeeDialog$3$1(dialog, null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(type, (Function2) it$iv3, $composer2, 0);
            AndroidDialog_androidKt.Dialog(function0, new DialogProperties(false, false, false, 5, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(659212664, true, new Function2() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeDialog$lambda$3;
                    TribeeDialog$lambda$3 = TribeeDialogKt.TribeeDialog$lambda$3(dialog, cancelClickCallback2, function0, confirmClickCallback, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeDialog$lambda$3;
                }
            }, $composer2, 54), $composer2, (($dirty2 >> 9) & 14) | 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            cancelClickCallback = cancelClickCallback2;
        } else {
            $composer2.skipToGroupEnd();
            cancelClickCallback = function12;
            confirmClickCallback = function22;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Function1 function13 = cancelClickCallback;
            final Function2 function23 = confirmClickCallback;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeDialog$lambda$4;
                    TribeeDialog$lambda$4 = TribeeDialogKt.TribeeDialog$lambda$4(dialog, function13, function23, function0, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeDialog$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x01a6, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x01e2, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x03b1, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x03f2, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit TribeeDialog$lambda$3(final KToastDialog $dialog, final Function1 $cancelClickCallback, final Function0 $onDismiss, final Function2 $confirmClickCallback, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Painter painter;
        Function0 factory$iv$iv$iv2;
        ComposerKt.sourceInformation($composer, "C:TribeeDialog.kt#iitu82");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(659212664, $changed, -1, "kntr.app.tribee.consume.page.TribeeDialog.<anonymous> (TribeeDialog.kt:118)");
            }
            if (Intrinsics.areEqual($dialog.getType(), KToastDialog.KToastDialogType.ACTIVATE_NO_CANDIDATE.INSTANCE) || Intrinsics.areEqual($dialog.getType(), KToastDialog.KToastDialogType.ACTIVATE_CANDIDATE.INSTANCE)) {
                $composer.startReplaceGroup(2014177202);
                ComposerKt.sourceInformation($composer, "123@5085L104,127@5230L89,121@4989L384");
                ComposerKt.sourceInformationMarkerStart($composer, 2143186656, "CC(remember):TribeeDialog.kt#9igjgp");
                boolean invalid$iv = $composer.changed($cancelClickCallback) | $composer.changedInstance($dialog) | $composer.changed($onDismiss);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit TribeeDialog$lambda$3$0$0;
                            TribeeDialog$lambda$3$0$0 = TribeeDialogKt.TribeeDialog$lambda$3$0$0($cancelClickCallback, $dialog, $onDismiss);
                            return TribeeDialog$lambda$3$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 function0 = (Function0) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 2143191281, "CC(remember):TribeeDialog.kt#9igjgp");
                boolean invalid$iv2 = $composer.changed($confirmClickCallback) | $composer.changedInstance($dialog);
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            Unit TribeeDialog$lambda$3$1$0;
                            TribeeDialog$lambda$3$1$0 = TribeeDialogKt.TribeeDialog$lambda$3$1$0($confirmClickCallback, $dialog, (String) obj);
                            return TribeeDialog$lambda$3$1$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                TribeeInviteCheckDialog($dialog, function0, (Function1) it$iv2, $onDismiss, $composer, 0, 0);
                $composer.endReplaceGroup();
            } else if (Intrinsics.areEqual($dialog.getType(), KToastDialog.KToastDialogType.GAME_STATS_NO_TRIBEE.INSTANCE)) {
                $composer.startReplaceGroup(2014667405);
                ComposerKt.sourceInformation($composer, "133@5474L677");
                Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (54 << 3) & 112;
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
                    factory$iv$iv$iv2 = factory$iv$iv$iv3;
                    $composer.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv3;
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
                int i2 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -1277493316, "C140@5870L116,144@6031L87,134@5568L569:TribeeDialog.kt#iitu82");
                String title = $dialog.getTitle();
                String cancelText = $dialog.getCancelText();
                String confirmText = $dialog.getConfirmText();
                String picUrl = $dialog.getPicUrl();
                String desc = $dialog.getDesc();
                ComposerKt.sourceInformationMarkerStart($composer, 928631074, "CC(remember):TribeeDialog.kt#9igjgp");
                boolean invalid$iv3 = $composer.changed($cancelClickCallback) | $composer.changedInstance($dialog) | $composer.changed($onDismiss);
                Object it$iv3 = $composer.rememberedValue();
                if (invalid$iv3) {
                }
                Object value$iv3 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit TribeeDialog$lambda$3$2$0$0;
                        TribeeDialog$lambda$3$2$0$0 = TribeeDialogKt.TribeeDialog$lambda$3$2$0$0($cancelClickCallback, $dialog, $onDismiss);
                        return TribeeDialog$lambda$3$2$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
                Function0 function02 = (Function0) it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 928636197, "CC(remember):TribeeDialog.kt#9igjgp");
                boolean invalid$iv4 = $composer.changed($confirmClickCallback) | $composer.changedInstance($dialog);
                Object it$iv4 = $composer.rememberedValue();
                if (invalid$iv4) {
                }
                Object value$iv4 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit TribeeDialog$lambda$3$2$1$0;
                        TribeeDialog$lambda$3$2$1$0 = TribeeDialogKt.TribeeDialog$lambda$3$2$1$0($confirmClickCallback, $dialog);
                        return TribeeDialog$lambda$3$2$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer);
                GameStatsCheckDialog(title, cancelText, confirmText, null, picUrl, desc, function02, (Function0) it$iv4, $composer, 0, 8);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(2015390759);
                ComposerKt.sourceInformation($composer, "150@6181L1387");
                Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
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
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                int i4 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -713354282, "C166@7012L116,170@7173L123,151@6275L1040:TribeeDialog.kt#iitu82");
                String picUrl2 = $dialog.getPicUrl();
                String title2 = $dialog.getTitle();
                String desc2 = $dialog.getDesc();
                if (Intrinsics.areEqual($dialog.getType(), KToastDialog.KToastDialogType.PUBLISH_JOIN.INSTANCE)) {
                    $composer.startReplaceGroup(-713068773);
                    ComposerKt.sourceInformation($composer, "159@6643L20");
                    Painter xmark_close_line_500 = BiliIconfont.INSTANCE.getXmark_close_line_500($composer, 6);
                    $composer.endReplaceGroup();
                    painter = xmark_close_line_500;
                } else {
                    $composer.startReplaceGroup(-712975432);
                    $composer.endReplaceGroup();
                    painter = null;
                }
                String cancelText2 = $dialog.getCancelText();
                String confirmText2 = $dialog.getConfirmText();
                boolean z = !Intrinsics.areEqual($dialog.getType(), KToastDialog.KToastDialogType.STEAM_ACCOUNT_RELEASE.INSTANCE);
                ComposerKt.sourceInformationMarkerStart($composer, 1639578978, "CC(remember):TribeeDialog.kt#9igjgp");
                boolean invalid$iv5 = $composer.changed($cancelClickCallback) | $composer.changedInstance($dialog) | $composer.changed($onDismiss);
                Object it$iv5 = $composer.rememberedValue();
                if (invalid$iv5) {
                }
                Object value$iv5 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        Unit TribeeDialog$lambda$3$3$0$0;
                        TribeeDialog$lambda$3$3$0$0 = TribeeDialogKt.TribeeDialog$lambda$3$3$0$0($cancelClickCallback, $dialog, $onDismiss);
                        return TribeeDialog$lambda$3$3$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
                Function0 function03 = (Function0) it$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 1639584137, "CC(remember):TribeeDialog.kt#9igjgp");
                boolean invalid$iv6 = $composer.changed($confirmClickCallback) | $composer.changedInstance($dialog) | $composer.changed($onDismiss);
                Object it$iv6 = $composer.rememberedValue();
                if (invalid$iv6) {
                }
                Object value$iv6 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        Unit TribeeDialog$lambda$3$3$1$0;
                        TribeeDialog$lambda$3$3$1$0 = TribeeDialogKt.TribeeDialog$lambda$3$3$1$0($confirmClickCallback, $dialog, $onDismiss);
                        return TribeeDialog$lambda$3$3$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv6);
                it$iv6 = value$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer);
                DialogContent(title2, cancelText2, confirmText2, null, picUrl2, desc2, z, painter, function03, (Function0) it$iv6, $composer, Painter.$stable << 21, 8);
                if (Intrinsics.areEqual($dialog.getType(), KToastDialog.KToastDialogType.INVITE_CODE_SUCCESS.INSTANCE)) {
                    $composer.startReplaceGroup(-712270275);
                    ComposerKt.sourceInformation($composer, "177@7425L111");
                    TribeeJoinedSuccessfulBgImage_androidKt.TribeeJoinedSuccessfulBgImage(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer, 6, 0);
                } else {
                    $composer.startReplaceGroup(-719619724);
                }
                $composer.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeDialog$lambda$3$0$0(Function1 $cancelClickCallback, KToastDialog $dialog, Function0 $onDismiss) {
        $cancelClickCallback.invoke($dialog.getType());
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeDialog$lambda$3$1$0(Function2 $confirmClickCallback, KToastDialog $dialog, String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        $confirmClickCallback.invoke($dialog.getType(), input);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeDialog$lambda$3$2$0$0(Function1 $cancelClickCallback, KToastDialog $dialog, Function0 $onDismiss) {
        $cancelClickCallback.invoke($dialog.getType());
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeDialog$lambda$3$2$1$0(Function2 $confirmClickCallback, KToastDialog $dialog) {
        $confirmClickCallback.invoke($dialog.getType(), (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeDialog$lambda$3$3$0$0(Function1 $cancelClickCallback, KToastDialog $dialog, Function0 $onDismiss) {
        $cancelClickCallback.invoke($dialog.getType());
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeDialog$lambda$3$3$1$0(Function2 $confirmClickCallback, KToastDialog $dialog, Function0 $onDismiss) {
        $confirmClickCallback.invoke($dialog.getType(), (Object) null);
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:160:0x03b7, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L91;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x080c  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0827  */
    /* JADX WARN: Removed duplicated region for block: B:202:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0128  */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DialogContent(final String title, final String cancelText, final String confirmText, Modifier modifier, String topImage, String subtitle, boolean isEmphasisCancel, Painter topEndCloseIcon, Function0<Unit> function0, Function0<Unit> function02, Composer $composer, final int $changed, final int i) {
        boolean z;
        int i2;
        int i3;
        Composer $composer2;
        Modifier modifier2;
        String topImage2;
        String subtitle2;
        Painter topEndCloseIcon2;
        Function0 cancelClickCallback;
        Function0<Unit> function03;
        boolean isEmphasisCancel2;
        ScopeUpdateScope endRestartGroup;
        final Function0 cancelClickCallback2;
        Function0 factory$iv$iv$iv;
        BoxScope $this$DialogContent_u24lambda_u242;
        Modifier modifier$iv$iv;
        Function0 factory$iv$iv$iv2;
        int $dirty;
        Composer $composer3;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(cancelText, "cancelText");
        Intrinsics.checkNotNullParameter(confirmText, "confirmText");
        Composer $composer4 = $composer.startRestartGroup(382078421);
        ComposerKt.sourceInformation($composer4, "C(DialogContent)N(title,cancelText,confirmText,modifier,topImage,subtitle,isEmphasisCancel,topEndCloseIcon,cancelClickCallback,confirmClickCallback)196@7890L2,197@7933L2,204@8148L6,199@7945L3280:TribeeDialog.kt#iitu82");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer4.changed(title) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer4.changed(cancelText) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer4.changed(confirmText) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer4.changed(modifier) ? 2048 : 1024;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty2 |= $composer4.changed(topImage) ? 16384 : 8192;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty2 |= $composer4.changed(subtitle) ? 131072 : 65536;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
            z = isEmphasisCancel;
        } else if (($changed & 1572864) == 0) {
            z = isEmphasisCancel;
            $dirty2 |= $composer4.changed(z) ? 1048576 : 524288;
        } else {
            z = isEmphasisCancel;
        }
        int i8 = i & 128;
        int i9 = 12582912;
        if (i8 == 0) {
            if (($changed & 12582912) == 0) {
                i9 = ($changed & 16777216) == 0 ? $composer4.changed(topEndCloseIcon) : $composer4.changedInstance(topEndCloseIcon) ? 8388608 : 4194304;
            }
            i2 = i & 256;
            if (i2 == 0) {
                $dirty2 |= 100663296;
            } else if (($changed & 100663296) == 0) {
                $dirty2 |= $composer4.changedInstance(function0) ? 67108864 : 33554432;
            }
            i3 = i & 512;
            if (i3 == 0) {
                $dirty2 |= 805306368;
            } else if (($changed & 805306368) == 0) {
                $dirty2 |= $composer4.changedInstance(function02) ? 536870912 : 268435456;
            }
            if ($composer4.shouldExecute(($dirty2 & 306783379) == 306783378, $dirty2 & 1)) {
                $composer2 = $composer4;
                $composer2.skipToGroupEnd();
                modifier2 = modifier;
                topImage2 = topImage;
                subtitle2 = subtitle;
                topEndCloseIcon2 = topEndCloseIcon;
                cancelClickCallback = function0;
                function03 = function02;
                isEmphasisCancel2 = z;
            } else {
                Modifier modifier3 = i4 != 0 ? (Modifier) Modifier.Companion : modifier;
                topImage2 = i5 != 0 ? "" : topImage;
                subtitle2 = i6 != 0 ? "" : subtitle;
                isEmphasisCancel2 = i7 != 0 ? true : z;
                topEndCloseIcon2 = i8 != 0 ? null : topEndCloseIcon;
                if (i2 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer4, 2105151703, "CC(remember):TribeeDialog.kt#9igjgp");
                    Object it$iv = $composer4.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda27
                            public final Object invoke() {
                                Unit unit;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        $composer4.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    cancelClickCallback2 = it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                } else {
                    cancelClickCallback2 = function0;
                }
                if (i3 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer4, 2105153079, "CC(remember):TribeeDialog.kt#9igjgp");
                    Object it$iv2 = $composer4.rememberedValue();
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv2 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda28
                            public final Object invoke() {
                                Unit unit;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        $composer4.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    function03 = it$iv2;
                } else {
                    function03 = function02;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(382078421, $dirty2, -1, "kntr.app.tribee.consume.page.DialogContent (TribeeDialog.kt:198)");
                }
                Modifier modifier$iv = BackgroundKt.background-bw27NRU(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), Dp.constructor-impl(28), 0.0f, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBg1_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)));
                ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv3;
                    $composer4.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv3;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Modifier modifier4 = modifier3;
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i10 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                int i11 = ((0 >> 6) & 112) | 6;
                BoxScope $this$DialogContent_u24lambda_u2422 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer4, -13619976, "C226@8921L2298:TribeeDialog.kt#iitu82");
                if (topEndCloseIcon2 != null) {
                    $composer4.startReplaceGroup(-13650512);
                    ComposerKt.sourceInformation($composer4, "216@8597L39,218@8711L77,222@8874L6,207@8226L675");
                    modifier$iv$iv = modifier$iv;
                    Modifier align = $this$DialogContent_u24lambda_u2422.align(PaddingKt.padding-3ABfNKs(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(2), Dp.constructor-impl(2), 0.0f, 9, (Object) null), Dp.constructor-impl(36)), Dp.constructor-impl(8)), Alignment.Companion.getTopEnd());
                    ComposerKt.sourceInformationMarkerStart($composer4, 1246496886, "CC(remember):TribeeDialog.kt#9igjgp");
                    $this$DialogContent_u24lambda_u242 = $this$DialogContent_u24lambda_u2422;
                    Object it$iv3 = $composer4.rememberedValue();
                    if (it$iv3 == Composer.Companion.getEmpty()) {
                        Object value$iv3 = InteractionSourceKt.MutableInteractionSource();
                        $composer4.updateRememberedValue(value$iv3);
                        it$iv3 = value$iv3;
                    }
                    MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerStart($composer4, 1246500572, "CC(remember):TribeeDialog.kt#9igjgp");
                    boolean invalid$iv = (234881024 & $dirty2) == 67108864;
                    Object it$iv4 = $composer4.rememberedValue();
                    if (invalid$iv) {
                    }
                    Object value$iv4 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda29
                        public final Object invoke() {
                            Unit DialogContent$lambda$2$1$0;
                            DialogContent$lambda$2$1$0 = TribeeDialogKt.DialogContent$lambda$2$1$0(cancelClickCallback2);
                            return DialogContent$lambda$2$1$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    IconKt.Icon-ww6aTOc(topEndCloseIcon2, "close icon", ClickableKt.clickable-O2vRcR0$default(align, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv4, 28, (Object) null), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText2-0d7_KjU(), $composer4, Painter.$stable | 48 | (($dirty2 >> 21) & 14), 0);
                } else {
                    $this$DialogContent_u24lambda_u242 = $this$DialogContent_u24lambda_u2422;
                    modifier$iv$iv = modifier$iv;
                    $composer4.startReplaceGroup(-21832621);
                }
                $composer4.endReplaceGroup();
                Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(12), 0.0f, 0.0f, 13, (Object) null);
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                int $changed$iv$iv2 = (390 << 3) & 112;
                Function0 cancelClickCallback3 = cancelClickCallback2;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer4.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i12 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i13 = ((390 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, 1041889375, "C247@9658L6,243@9508L419:TribeeDialog.kt#iitu82");
                if (StringsKt.isBlank(topImage2)) {
                    $dirty = $dirty2;
                    $composer4.startReplaceGroup(1032809257);
                } else {
                    $composer4.startReplaceGroup(1041862156);
                    ComposerKt.sourceInformation($composer4, "231@9131L349");
                    String $this$asRequest$iv = topImage2;
                    ImageRequest $this$DialogContent_u24lambda_u242_u242_u240 = new ImageRequest($this$asRequest$iv);
                    $dirty = $dirty2;
                    $this$DialogContent_u24lambda_u242_u242_u240.contentScale(ContentScale.Companion.getInside());
                    BiliImageKt.BiliImage($this$DialogContent_u24lambda_u242_u242_u240.build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl((float) BackoffConfigKt.MAX_DELAY_SECONDS)), "image", null, null, null, null, null, null, $composer4, 432, InitGMultiDomainKt.HTTP_CODE_GATEWAY_TIMEOUT);
                }
                $composer4.endReplaceGroup();
                int $dirty3 = $dirty;
                modifier2 = modifier4;
                $composer2 = $composer4;
                cancelClickCallback = cancelClickCallback3;
                TextKt.Text-Nvy7gAk(title, PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(20), 0.0f, 2, (Object) null), 0.0f, Dp.constructor-impl(12), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(16), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer4, ($dirty3 & 14) | 1597488, 0, 261032);
                String it = !StringsKt.isBlank(subtitle2) ? subtitle2 : null;
                if (it == null) {
                    $composer3 = $composer4;
                    $composer3.startReplaceGroup(1042722219);
                    $composer3.endReplaceGroup();
                } else {
                    $composer3 = $composer4;
                    $composer3.startReplaceGroup(1042722220);
                    ComposerKt.sourceInformation($composer3, "*260@10113L6,257@10000L409");
                    TextKt.Text-Nvy7gAk(it, PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(20), 0.0f, 2, (Object) null), 0.0f, Dp.constructor-impl(6), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(13), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 24624, 0, 261096);
                    Unit unit = Unit.INSTANCE;
                    $composer3.endReplaceGroup();
                    Unit unit2 = Unit.INSTANCE;
                }
                if (!StringsKt.isBlank(cancelText) && !StringsKt.isBlank(confirmText)) {
                    $composer3.startReplaceGroup(1557674573);
                    ComposerKt.sourceInformation($composer3, "272@10535L340");
                    DialogOptionalButton(cancelText, confirmText, null, isEmphasisCancel2, cancelClickCallback, function03, $composer3, (($dirty3 >> 3) & 14) | (($dirty3 >> 3) & 112) | (($dirty3 >> 9) & 7168) | (($dirty3 >> 12) & 57344) | (($dirty3 >> 12) & 458752), 4);
                    $composer3.endReplaceGroup();
                } else if (StringsKt.isBlank(confirmText)) {
                    $composer3.startReplaceGroup(1557693059);
                    ComposerKt.sourceInformation($composer3, "286@11121L74");
                    DialogSingleButton(cancelText, null, cancelClickCallback, $composer3, (($dirty3 >> 3) & 14) | (($dirty3 >> 18) & 896), 2);
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(1557687379);
                    ComposerKt.sourceInformation($composer3, "281@10941L154");
                    DialogSingleConfirmButton(confirmText, null, function03, $composer3, (($dirty3 >> 6) & 14) | (($dirty3 >> 21) & 896), 2);
                    $composer3.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier5 = modifier2;
                final String str = topImage2;
                final String str2 = subtitle2;
                final boolean z2 = isEmphasisCancel2;
                final Painter painter = topEndCloseIcon2;
                final Function0 function04 = cancelClickCallback;
                final Function0<Unit> function05 = function03;
                endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda30
                    public final Object invoke(Object obj, Object obj2) {
                        Unit DialogContent$lambda$3;
                        DialogContent$lambda$3 = TribeeDialogKt.DialogContent$lambda$3(title, cancelText, confirmText, modifier5, str, str2, z2, painter, function04, function05, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                        return DialogContent$lambda$3;
                    }
                });
                return;
            }
            return;
        }
        $dirty2 |= i9;
        i2 = i & 256;
        if (i2 == 0) {
        }
        i3 = i & 512;
        if (i3 == 0) {
        }
        if ($composer4.shouldExecute(($dirty2 & 306783379) == 306783378, $dirty2 & 1)) {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DialogContent$lambda$2$1$0(Function0 $cancelClickCallback) {
        $cancelClickCallback.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r7v23 */
    public static final void GameStatsCheckDialog(final String title, final String cancelText, final String confirmText, Modifier modifier, String topImage, String subtitle, Function0<Unit> function0, Function0<Unit> function02, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String str;
        String str2;
        Composer $composer2;
        Function0<Unit> function03;
        Function0<Unit> function04;
        Modifier modifier3;
        String topImage2;
        String subtitle2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer$iv$iv$iv;
        Composer $composer3;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(cancelText, "cancelText");
        Intrinsics.checkNotNullParameter(confirmText, "confirmText");
        Composer $composer4 = $composer.startRestartGroup(1538230946);
        ComposerKt.sourceInformation($composer4, "C(GameStatsCheckDialog)N(title,cancelText,confirmText,modifier,topImage,subtitle,cancelClickCallback,confirmClickCallback)300@11462L2,301@11505L2,308@11720L6,303@11517L2490:TribeeDialog.kt#iitu82");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(title) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changed(cancelText) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changed(confirmText) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= 24576;
            str = topImage;
        } else if (($changed & 24576) == 0) {
            str = topImage;
            $dirty |= $composer4.changed(str) ? 16384 : 8192;
        } else {
            str = topImage;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty |= 196608;
            str2 = subtitle;
        } else if ((196608 & $changed) == 0) {
            str2 = subtitle;
            $dirty |= $composer4.changed(str2) ? 131072 : 65536;
        } else {
            str2 = subtitle;
        }
        int i5 = i & 64;
        if (i5 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer4.changedInstance(function0) ? 1048576 : 524288;
        }
        int i6 = i & 128;
        if (i6 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer4.changedInstance(function02) ? 8388608 : 4194304;
        }
        if ($composer4.shouldExecute(($dirty & 4793491) != 4793490, $dirty & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            topImage2 = i3 != 0 ? "" : str;
            subtitle2 = i4 != 0 ? "" : str2;
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer4, 771196356, "CC(remember):TribeeDialog.kt#9igjgp");
                Object it$iv = $composer4.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda34
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer4);
                function03 = it$iv;
            } else {
                function03 = function0;
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer4, 771197732, "CC(remember):TribeeDialog.kt#9igjgp");
                Object it$iv2 = $composer4.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda35
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer4);
                function04 = it$iv2;
            } else {
                function04 = function02;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1538230946, $dirty, -1, "kntr.app.tribee.consume.page.GameStatsCheckDialog (TribeeDialog.kt:302)");
            }
            Modifier modifier$iv = BackgroundKt.background-bw27NRU(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), Dp.constructor-impl(28), 0.0f, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBg1_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)));
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Modifier modifier5 = modifier4;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i8 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -246394475, "C310@11755L2246:TribeeDialog.kt#iitu82");
            int $dirty2 = $dirty;
            Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(12), 0.0f, 0.0f, 13, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv2 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer4.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i10 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -9149266, "C331@12492L6,327@12342L419:TribeeDialog.kt#iitu82");
            if (StringsKt.isBlank(topImage2)) {
                $composer$iv$iv$iv = $composer4;
                $composer4.startReplaceGroup(-21039100);
            } else {
                $composer4.startReplaceGroup(-9174873);
                ComposerKt.sourceInformation($composer4, "315@11965L349");
                String $this$asRequest$iv = topImage2;
                $composer$iv$iv$iv = $composer4;
                ImageRequest $this$GameStatsCheckDialog_u24lambda_u242_u240_u240 = new ImageRequest($this$asRequest$iv);
                $this$GameStatsCheckDialog_u24lambda_u242_u240_u240.contentScale(ContentScale.Companion.getInside());
                BiliImageKt.BiliImage($this$GameStatsCheckDialog_u24lambda_u242_u240_u240.build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl((float) BackoffConfigKt.MAX_DELAY_SECONDS)), "image", null, null, null, null, null, null, $composer4, 432, InitGMultiDomainKt.HTTP_CODE_GATEWAY_TIMEOUT);
            }
            $composer4.endReplaceGroup();
            Composer $composer$iv$iv$iv2 = $composer$iv$iv$iv;
            $composer2 = $composer4;
            modifier3 = modifier5;
            TextKt.Text-Nvy7gAk(title, PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(20), 0.0f, 2, (Object) null), 0.0f, Dp.constructor-impl(12), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(16), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer4, ($dirty2 & 14) | 1597488, 0, 261032);
            String it = !StringsKt.isBlank(subtitle2) ? subtitle2 : null;
            if (it == null) {
                $composer3 = $composer4;
                $composer3.startReplaceGroup(-8314810);
                $composer3.endReplaceGroup();
            } else {
                $composer3 = $composer4;
                $composer3.startReplaceGroup(-8314809);
                ComposerKt.sourceInformation($composer3, "*344@12947L6,341@12834L409");
                TextKt.Text-Nvy7gAk(it, PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(20), 0.0f, 2, (Object) null), 0.0f, Dp.constructor-impl(6), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(13), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 24624, 0, 261096);
                Unit unit = Unit.INSTANCE;
                $composer3.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            if (!StringsKt.isBlank(cancelText) && !StringsKt.isBlank(confirmText)) {
                $composer3.startReplaceGroup(-1385723874);
                ComposerKt.sourceInformation($composer3, "356@13369L288");
                GameStatsDialogOptionalButton(cancelText, confirmText, null, function03, function04, $composer3, (($dirty2 >> 3) & 14) | (($dirty2 >> 3) & 112) | (($dirty2 >> 9) & 7168) | (($dirty2 >> 9) & 57344), 4);
                $composer3.endReplaceGroup();
            } else if (StringsKt.isBlank(confirmText)) {
                $composer3.startReplaceGroup(-1385707000);
                ComposerKt.sourceInformation($composer3, "369@13903L74");
                DialogSingleButton(cancelText, null, function03, $composer3, (($dirty2 >> 3) & 14) | (($dirty2 >> 12) & 896), 2);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(-1385712680);
                ComposerKt.sourceInformation($composer3, "364@13723L154");
                DialogSingleConfirmButton(confirmText, null, function04, $composer3, (($dirty2 >> 6) & 14) | (($dirty2 >> 15) & 896), 2);
                $composer3.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer$iv$iv$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            function03 = function0;
            function04 = function02;
            modifier3 = modifier2;
            topImage2 = str;
            subtitle2 = str2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final String str3 = topImage2;
            final String str4 = subtitle2;
            final Function0<Unit> function05 = function03;
            final Function0<Unit> function06 = function04;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda36
                public final Object invoke(Object obj, Object obj2) {
                    Unit GameStatsCheckDialog$lambda$3;
                    GameStatsCheckDialog$lambda$3 = TribeeDialogKt.GameStatsCheckDialog$lambda$3(title, cancelText, confirmText, modifier6, str3, str4, function05, function06, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return GameStatsCheckDialog$lambda$3;
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v10 */
    public static final void DialogSingleConfirmButton(final String text, Modifier modifier, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 function02;
        Composer $composer2;
        Modifier modifier3;
        Function0 clickCallback;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer3 = $composer.startRestartGroup(699952459);
        ComposerKt.sourceInformation($composer3, "C(DialogSingleConfirmButton)N(text,modifier,clickCallback)379@14139L2,388@14402L6,390@14524L39,381@14151L703:TribeeDialog.kt#iitu82");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(text) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            function02 = function0;
        } else if (($changed & 384) == 0) {
            function02 = function0;
            $dirty |= $composer3.changedInstance(function02) ? 256 : 128;
        } else {
            function02 = function0;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -1655548659, "CC(remember):TribeeDialog.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda32
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 clickCallback2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                clickCallback = clickCallback2;
            } else {
                clickCallback = function02;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(699952459, $dirty2, -1, "kntr.app.tribee.consume.page.DialogSingleConfirmButton (TribeeDialog.kt:380)");
            }
            Modifier modifier5 = BackgroundKt.background-bw27NRU(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), Dp.constructor-impl(16), 0.0f, 2, (Object) null), 0.0f, Dp.constructor-impl(24), 0.0f, Dp.constructor-impl(16), 5, (Object) null), Dp.constructor-impl(34)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(17)));
            ComposerKt.sourceInformationMarkerStart($composer3, -1655536302, "CC(remember):TribeeDialog.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = ClickableKt.clickable-O2vRcR0$default(modifier5, (MutableInteractionSource) it$iv2, (Indication) null, false, (String) null, (Role) null, clickCallback, 28, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i5 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1060694009, "C399@14820L6,396@14729L119:TribeeDialog.kt#iitu82");
            modifier3 = modifier4;
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(text, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, ($dirty2 & 14) | 24576, 0, 262122);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            clickCallback = function02;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final Function0 function03 = clickCallback;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda33
                public final Object invoke(Object obj, Object obj2) {
                    Unit DialogSingleConfirmButton$lambda$3;
                    DialogSingleConfirmButton$lambda$3 = TribeeDialogKt.DialogSingleConfirmButton$lambda$3(text, modifier6, function03, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DialogSingleConfirmButton$lambda$3;
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v13 */
    public static final void DialogSingleButton(final String text, Modifier modifier, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 function02;
        Composer $composer2;
        Modifier modifier3;
        Function0 clickCallback;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer3 = $composer.startRestartGroup(-147387921);
        ComposerKt.sourceInformation($composer3, "C(DialogSingleButton)N(text,modifier,clickCallback)408@14979L2,417@15205L39,410@14991L834:TribeeDialog.kt#iitu82");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(text) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            function02 = function0;
        } else if (($changed & 384) == 0) {
            function02 = function0;
            $dirty |= $composer3.changedInstance(function02) ? 256 : 128;
        } else {
            function02 = function0;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 94132177, "CC(remember):TribeeDialog.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda37
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 clickCallback2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                clickCallback = clickCallback2;
            } else {
                clickCallback = function02;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-147387921, $dirty2, -1, "kntr.app.tribee.consume.page.DialogSingleButton (TribeeDialog.kt:409)");
            }
            Modifier modifier5 = PaddingKt.padding-qDBjuR0$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), Dp.constructor-impl(68)), 0.0f, Dp.constructor-impl(24), 0.0f, 0.0f, 13, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 94139446, "CC(remember):TribeeDialog.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = ClickableKt.clickable-O2vRcR0$default(modifier5, (MutableInteractionSource) it$iv2, (Indication) null, false, (String) null, (Role) null, clickCallback, 28, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i5 = ((0 >> 6) & 112) | 6;
            BoxScope $this$DialogSingleButton_u24lambda_u242 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 361847848, "C424@15462L6,422@15365L159,430@15624L6,427@15533L286:TribeeDialog.kt#iitu82");
            DividerKt.HorizontalDivider-9IZ8Weo(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer3, 54, 0);
            modifier3 = modifier4;
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(text, $this$DialogSingleButton_u24lambda_u242.align(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getCenter()), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(16), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, ($dirty2 & 14) | 24576, 0, 261096);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            clickCallback = function02;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final Function0 function03 = clickCallback;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit DialogSingleButton$lambda$3;
                    DialogSingleButton$lambda$3 = TribeeDialogKt.DialogSingleButton$lambda$3(text, modifier6, function03, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DialogSingleButton$lambda$3;
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r6v25 */
    public static final void GameStatsDialogOptionalButton(final String cancelText, final String confirmText, Modifier modifier, Function0<Unit> function0, Function0<Unit> function02, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 function03;
        Function0 confirmClickCallback;
        Composer $composer2;
        Modifier modifier3;
        Function0 cancelClickCallback;
        Function0 confirmClickCallback2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Intrinsics.checkNotNullParameter(cancelText, "cancelText");
        Intrinsics.checkNotNullParameter(confirmText, "confirmText");
        Composer $composer3 = $composer.startRestartGroup(159760375);
        ComposerKt.sourceInformation($composer3, "C(GameStatsDialogOptionalButton)N(cancelText,confirmText,modifier,cancelClickCallback,confirmClickCallback)445@15998L2,446@16041L2,448@16053L2307:TribeeDialog.kt#iitu82");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(cancelText) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(confirmText) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            function03 = function0;
        } else if (($changed & 3072) == 0) {
            function03 = function0;
            $dirty |= $composer3.changedInstance(function03) ? 2048 : 1024;
        } else {
            function03 = function0;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            confirmClickCallback = function02;
        } else if (($changed & 24576) == 0) {
            confirmClickCallback = function02;
            $dirty |= $composer3.changedInstance(confirmClickCallback) ? 16384 : 8192;
        } else {
            confirmClickCallback = function02;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -1089097255, "CC(remember):TribeeDialog.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda24
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 cancelClickCallback2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                cancelClickCallback = cancelClickCallback2;
            } else {
                cancelClickCallback = function03;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -1089095879, "CC(remember):TribeeDialog.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda25
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function0 confirmClickCallback3 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                confirmClickCallback2 = confirmClickCallback3;
            } else {
                confirmClickCallback2 = confirmClickCallback;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(159760375, $dirty2, -1, "kntr.app.tribee.consume.page.GameStatsDialogOptionalButton (TribeeDialog.kt:447)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(PaddingKt.padding-qDBjuR0$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), Dp.constructor-impl(74)), 0.0f, Dp.constructor-impl(24), 0.0f, 0.0f, 13, (Object) null), Dp.constructor-impl(16), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Modifier modifier5 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i6 = ((0 >> 6) & 112) | 6;
            BoxScope $this$GameStatsDialogOptionalButton_u24lambda_u242 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 286807193, "C456@16261L2093:TribeeDialog.kt#iitu82");
            Modifier modifier$iv2 = $this$GameStatsDialogOptionalButton_u24lambda_u242.align(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(34)), Alignment.Companion.getTopCenter());
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i8 = ((0 >> 6) & 112) | 6;
            RowScope $this$GameStatsDialogOptionalButton_u24lambda_u242_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1217440220, "C468@16648L6,471@16822L6,474@16991L39,463@16458L1008,488@17480L40,495@17724L6,497@17862L39,490@17534L810:TribeeDialog.kt#iitu82");
            Modifier modifier6 = BorderKt.border-xT4_qwU(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$GameStatsDialogOptionalButton_u24lambda_u242_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(34)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(17))), Dp.constructor-impl(1), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getLine_regular-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(17)));
            ComposerKt.sourceInformationMarkerStart($composer3, 237837608, "CC(remember):TribeeDialog.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv3 = ClickableKt.clickable-O2vRcR0$default(modifier6, (MutableInteractionSource) it$iv3, (Indication) null, false, (String) null, (Role) null, cancelClickCallback, 28, (Object) null);
            Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv3 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer3.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i10 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1802524274, "C483@17371L6,480@17250L202:TribeeDialog.kt#iitu82");
            modifier3 = modifier5;
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(cancelText, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, ($dirty2 & 14) | 24576, 0, 261098);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer3, 6);
            Modifier modifier7 = BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$GameStatsDialogOptionalButton_u24lambda_u242_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(34)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(17)));
            ComposerKt.sourceInformationMarkerStart($composer3, 237865480, "CC(remember):TribeeDialog.kt#9igjgp");
            Object it$iv4 = $composer3.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv4 = ClickableKt.clickable-O2vRcR0$default(modifier7, (MutableInteractionSource) it$iv4, (Indication) null, false, (String) null, (Role) null, confirmClickCallback2, 28, (Object) null);
            Alignment contentAlignment$iv3 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
            int $changed$iv$iv4 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv7);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i11 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i12 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1519316651, "C506@18244L6,503@18122L208:TribeeDialog.kt#iitu82");
            TextKt.Text-Nvy7gAk(confirmText, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, (($dirty2 >> 3) & 14) | 24576, 0, 261098);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            confirmClickCallback = confirmClickCallback2;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            cancelClickCallback = function03;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier8 = modifier3;
            final Function0 function04 = cancelClickCallback;
            final Function0 function05 = confirmClickCallback;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda26
                public final Object invoke(Object obj, Object obj2) {
                    Unit GameStatsDialogOptionalButton$lambda$3;
                    GameStatsDialogOptionalButton$lambda$3 = TribeeDialogKt.GameStatsDialogOptionalButton$lambda$3(cancelText, confirmText, modifier8, function04, function05, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return GameStatsDialogOptionalButton$lambda$3;
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r14v17 */
    public static final void DialogOptionalButton(final String cancelText, final String confirmText, Modifier modifier, boolean isEmphasisCancel, Function0<Unit> function0, Function0<Unit> function02, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean isEmphasisCancel2;
        Function0 cancelClickCallback;
        Function0 confirmClickCallback;
        Composer $composer2;
        Modifier modifier3;
        Function0 cancelClickCallback2;
        Function0 confirmClickCallback2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3;
        Composer $composer$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv$iv2;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv2;
        Composer $composer$iv3;
        Composer $composer$iv$iv$iv2;
        Composer $composer$iv4;
        Composer $composer4;
        Intrinsics.checkNotNullParameter(cancelText, "cancelText");
        Intrinsics.checkNotNullParameter(confirmText, "confirmText");
        Composer $composer5 = $composer.startRestartGroup(-1161306614);
        ComposerKt.sourceInformation($composer5, "C(DialogOptionalButton)N(cancelText,confirmText,modifier,isEmphasisCancel,cancelClickCallback,confirmClickCallback)520@18562L2,521@18605L2,523@18617L2982:TribeeDialog.kt#iitu82");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer5.changed(cancelText) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer5.changed(confirmText) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer5.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            isEmphasisCancel2 = isEmphasisCancel;
        } else if (($changed & 3072) == 0) {
            isEmphasisCancel2 = isEmphasisCancel;
            $dirty |= $composer5.changed(isEmphasisCancel2) ? 2048 : 1024;
        } else {
            isEmphasisCancel2 = isEmphasisCancel;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            cancelClickCallback = function0;
        } else if (($changed & 24576) == 0) {
            cancelClickCallback = function0;
            $dirty |= $composer5.changedInstance(cancelClickCallback) ? 16384 : 8192;
        } else {
            cancelClickCallback = function0;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty |= 196608;
            confirmClickCallback = function02;
        } else if ((196608 & $changed) == 0) {
            confirmClickCallback = function02;
            $dirty |= $composer5.changedInstance(confirmClickCallback) ? 131072 : 65536;
        } else {
            confirmClickCallback = function02;
        }
        if ($composer5.shouldExecute((74899 & $dirty) != 74898, $dirty & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            boolean isEmphasisCancel3 = i3 != 0 ? true : isEmphasisCancel2;
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer5, 675846860, "CC(remember):TribeeDialog.kt#9igjgp");
                Object it$iv = $composer5.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda10
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer5.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 cancelClickCallback3 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer5);
                cancelClickCallback2 = cancelClickCallback3;
            } else {
                cancelClickCallback2 = cancelClickCallback;
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer5, 675848236, "CC(remember):TribeeDialog.kt#9igjgp");
                Object it$iv2 = $composer5.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda21
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer5.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function0 confirmClickCallback3 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer5);
                confirmClickCallback2 = confirmClickCallback3;
            } else {
                confirmClickCallback2 = confirmClickCallback;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1161306614, $dirty, -1, "kntr.app.tribee.consume.page.DialogOptionalButton (TribeeDialog.kt:522)");
            }
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), Dp.constructor-impl(68)), 0.0f, Dp.constructor-impl(24), 0.0f, 0.0f, 13, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer5, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
            CompositionLocalMap localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
            $composer2 = $composer5;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer5.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer5.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer5);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Modifier modifier5 = modifier4;
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i7 = ((0 >> 6) & 112) | 6;
            BoxScope $this$DialogOptionalButton_u24lambda_u242 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer5, 1821606434, "C532@18877L6,530@18780L159,535@18948L2645:TribeeDialog.kt#iitu82");
            DividerKt.HorizontalDivider-9IZ8Weo(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer5, 54, 0);
            Modifier modifier$iv2 = $this$DialogOptionalButton_u24lambda_u242.align(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getCenter());
            ComposerKt.sourceInformationMarkerStart($composer5, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer5, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer5.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer5, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer5.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer5.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer5);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i9 = ((0 >> 6) & 112) | 6;
            RowScope $this$DialogOptionalButton_u24lambda_u242_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer5, 803244599, "C:TribeeDialog.kt#iitu82");
            if (isEmphasisCancel3) {
                $composer5.startReplaceGroup(803227610);
                ComposerKt.sourceInformation($composer5, "545@19269L6,550@19479L39,542@19147L586,559@19871L6,564@20086L39,556@19750L589");
                long sp = TextUnitKt.getSp(16);
                long j = BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getText1-0d7_KjU();
                Modifier weight$default = RowScope.-CC.weight$default($this$DialogOptionalButton_u24lambda_u242_u240, Modifier.Companion, 1.0f, false, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer5, 25920583, "CC(remember):TribeeDialog.kt#9igjgp");
                Object it$iv3 = $composer5.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = InteractionSourceKt.MutableInteractionSource();
                    $composer5.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer5);
                $composer$iv$iv = $composer5;
                $composer$iv$iv2 = $composer5;
                $composer$iv$iv$iv = $composer5;
                $composer3 = $composer5;
                modifier3 = modifier5;
                $composer$iv = $composer5;
                TextKt.Text-Nvy7gAk(confirmText, ClickableKt.clickable-O2vRcR0$default(weight$default, (MutableInteractionSource) it$iv3, (Indication) null, false, (String) null, (Role) null, confirmClickCallback2, 28, (Object) null), j, (TextAutoSize) null, sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer5, (($dirty >> 3) & 14) | 24576, 0, 261096);
                long sp2 = TextUnitKt.getSp(16);
                long j2 = BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                Modifier weight$default2 = RowScope.-CC.weight$default($this$DialogOptionalButton_u24lambda_u242_u240, Modifier.Companion, 1.0f, false, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer5, 25940007, "CC(remember):TribeeDialog.kt#9igjgp");
                Object it$iv4 = $composer5.rememberedValue();
                if (it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = InteractionSourceKt.MutableInteractionSource();
                    $composer5.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer5);
                $composer$iv$iv$iv2 = $composer5;
                $composer$iv2 = $composer5;
                $composer$iv3 = $composer5;
                $composer$iv4 = $composer5;
                TextKt.Text-Nvy7gAk(cancelText, ClickableKt.clickable-O2vRcR0$default(weight$default2, (MutableInteractionSource) it$iv4, (Indication) null, false, (String) null, (Role) null, cancelClickCallback2, 28, (Object) null), j2, (TextAutoSize) null, sp2, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer5, ($dirty & 14) | 24576, 0, 261096);
                $composer5.endReplaceGroup();
                $composer4 = $composer5;
            } else {
                int $dirty2 = $dirty;
                $composer3 = $composer5;
                $composer$iv$iv = $composer5;
                $composer$iv = $composer5;
                $composer$iv$iv2 = $composer5;
                $composer$iv$iv$iv = $composer5;
                modifier3 = modifier5;
                $composer$iv2 = $composer5;
                $composer$iv3 = $composer5;
                $composer$iv$iv$iv2 = $composer5;
                $composer$iv4 = $composer5;
                $composer5.startReplaceGroup(804447770);
                ComposerKt.sourceInformation($composer5, "574@20498L6,579@20708L39,571@20377L584,588@21100L6,593@21315L39,585@20978L591");
                long sp3 = TextUnitKt.getSp(16);
                long j3 = BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getText1-0d7_KjU();
                Modifier weight$default3 = RowScope.-CC.weight$default($this$DialogOptionalButton_u24lambda_u242_u240, Modifier.Companion, 1.0f, false, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer5, 25959911, "CC(remember):TribeeDialog.kt#9igjgp");
                Object it$iv5 = $composer5.rememberedValue();
                if (it$iv5 == Composer.Companion.getEmpty()) {
                    Object value$iv5 = InteractionSourceKt.MutableInteractionSource();
                    $composer5.updateRememberedValue(value$iv5);
                    it$iv5 = value$iv5;
                }
                ComposerKt.sourceInformationMarkerEnd($composer5);
                TextKt.Text-Nvy7gAk(cancelText, ClickableKt.clickable-O2vRcR0$default(weight$default3, (MutableInteractionSource) it$iv5, (Indication) null, false, (String) null, (Role) null, cancelClickCallback2, 28, (Object) null), j3, (TextAutoSize) null, sp3, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer5, ($dirty2 & 14) | 24576, 0, 261096);
                long sp4 = TextUnitKt.getSp(16);
                long j4 = BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                Modifier weight$default4 = RowScope.-CC.weight$default($this$DialogOptionalButton_u24lambda_u242_u240, Modifier.Companion, 1.0f, false, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer5, 25979335, "CC(remember):TribeeDialog.kt#9igjgp");
                Object it$iv6 = $composer5.rememberedValue();
                if (it$iv6 == Composer.Companion.getEmpty()) {
                    Object value$iv6 = InteractionSourceKt.MutableInteractionSource();
                    $composer5.updateRememberedValue(value$iv6);
                    it$iv6 = value$iv6;
                }
                ComposerKt.sourceInformationMarkerEnd($composer5);
                $composer4 = $composer5;
                TextKt.Text-Nvy7gAk(confirmText, ClickableKt.clickable-O2vRcR0$default(weight$default4, (MutableInteractionSource) it$iv6, (Indication) null, false, (String) null, (Role) null, confirmClickCallback2, 28, (Object) null), j4, (TextAutoSize) null, sp4, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer4, (($dirty2 >> 3) & 14) | 24576, 0, 261096);
                $composer4.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            $composer$iv$iv$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            isEmphasisCancel2 = isEmphasisCancel3;
            cancelClickCallback = cancelClickCallback2;
            confirmClickCallback = confirmClickCallback2;
        } else {
            $composer2 = $composer5;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final boolean z = isEmphasisCancel2;
            final Function0 function03 = cancelClickCallback;
            final Function0 function04 = confirmClickCallback;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda31
                public final Object invoke(Object obj, Object obj2) {
                    Unit DialogOptionalButton$lambda$3;
                    DialogOptionalButton$lambda$3 = TribeeDialogKt.DialogOptionalButton$lambda$3(cancelText, confirmText, modifier6, z, function03, function04, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DialogOptionalButton$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInviteCheckDialog$lambda$1$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    private static final void TribeeInviteCheckDialog(final KToastDialog dialog, Function0<Unit> function0, Function1<? super String, Unit> function1, Function0<Unit> function02, Composer $composer, final int $changed, final int i) {
        Function0 function03;
        Function1 function12;
        Function0 function04;
        Function1 confirmClickCallback;
        Function0 onDismiss;
        Function0 cancelClickCallback;
        Function0 cancelClickCallback2;
        Function1 confirmClickCallback2;
        Function0 onDismiss2;
        Composer $composer2 = $composer.startRestartGroup(1363662374);
        ComposerKt.sourceInformation($composer2, "C(TribeeInviteCheckDialog)N(dialog,cancelClickCallback,confirmClickCallback,onDismiss)607@21716L2,608@21765L2,609@21797L2,611@21830L47,611@21809L68,614@21909L7,617@21999L7,618@22039L8636,616@21922L8753:TribeeDialog.kt#iitu82");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(dialog) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            function03 = function0;
        } else if (($changed & 48) == 0) {
            function03 = function0;
            $dirty |= $composer2.changedInstance(function03) ? 32 : 16;
        } else {
            function03 = function0;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            function12 = function1;
        } else if (($changed & 384) == 0) {
            function12 = function1;
            $dirty |= $composer2.changedInstance(function12) ? 256 : 128;
        } else {
            function12 = function1;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            function04 = function02;
        } else if (($changed & 3072) == 0) {
            function04 = function02;
            $dirty |= $composer2.changedInstance(function04) ? 2048 : 1024;
        } else {
            function04 = function02;
        }
        if ($composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            if (i2 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 514519112, "CC(remember):TribeeDialog.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda7
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                cancelClickCallback2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                cancelClickCallback2 = function03;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 514520680, "CC(remember):TribeeDialog.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda8
                        public final Object invoke(Object obj) {
                            Unit TribeeInviteCheckDialog$lambda$1$0;
                            TribeeInviteCheckDialog$lambda$1$0 = TribeeDialogKt.TribeeInviteCheckDialog$lambda$1$0((String) obj);
                            return TribeeInviteCheckDialog$lambda$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                confirmClickCallback2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                confirmClickCallback2 = function12;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 514521704, "CC(remember):TribeeDialog.kt#9igjgp");
                Object it$iv3 = $composer2.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda9
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                onDismiss2 = it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onDismiss2 = function04;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1363662374, $dirty, -1, "kntr.app.tribee.consume.page.TribeeInviteCheckDialog (TribeeDialog.kt:610)");
            }
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 514522805, "CC(remember):TribeeDialog.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = (Function2) new TribeeDialogKt$TribeeInviteCheckDialog$4$1(null);
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv4, $composer2, 6);
            CompositionLocal this_$iv = ToasterKt.getLocalToaster();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Toaster toaster = (Toaster) consume;
            ProvidableCompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
            CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Function0 function05 = onDismiss2;
            final Function1 function13 = confirmClickCallback2;
            final Function0 function06 = cancelClickCallback2;
            CompositionLocalKt.CompositionLocalProvider(localDensity.provides(DensityKt.Density(((Density) consume2).getDensity(), 1.0f)), ComposableLambdaKt.rememberComposableLambda(-1416099098, true, new Function2() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeInviteCheckDialog$lambda$4;
                    TribeeInviteCheckDialog$lambda$4 = TribeeDialogKt.TribeeInviteCheckDialog$lambda$4(function05, dialog, function13, toaster, function06, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeInviteCheckDialog$lambda$4;
                }
            }, $composer2, 54), $composer2, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            cancelClickCallback = cancelClickCallback2;
            confirmClickCallback = confirmClickCallback2;
            onDismiss = onDismiss2;
        } else {
            $composer2.skipToGroupEnd();
            confirmClickCallback = function12;
            onDismiss = function04;
            cancelClickCallback = function03;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Function0 function07 = cancelClickCallback;
            final Function1 function14 = confirmClickCallback;
            final Function0 function08 = onDismiss;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeInviteCheckDialog$lambda$5;
                    TribeeInviteCheckDialog$lambda$5 = TribeeDialogKt.TribeeInviteCheckDialog$lambda$5(dialog, function07, function14, function08, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeInviteCheckDialog$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0aa2, code lost:
        if (r0 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0292, code lost:
        if (r9 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0501, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0756, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0809, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L61;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v41 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit TribeeInviteCheckDialog$lambda$4(final Function0 $onDismiss, final KToastDialog $dialog, final Function1 $confirmClickCallback, final Toaster $toaster, final Function0 $cancelClickCallback, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Composer $composer$iv$iv$iv;
        long textColor;
        long borderColor;
        ComposerKt.sourceInformation($composer, "C619@22070L29,620@22165L7,622@22203L115,622@22182L136,633@22550L6,628@22328L8341:TribeeDialog.kt#iitu82");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1416099098, $changed, -1, "kntr.app.tribee.consume.page.TribeeInviteCheckDialog.<anonymous> (TribeeDialog.kt:619)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 633400675, "CC(remember):TribeeDialog.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new FocusRequester();
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            FocusRequester focusRequester = (FocusRequester) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            SoftwareKeyboardController keyboardController = (SoftwareKeyboardController) consume;
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 633405017, "CC(remember):TribeeDialog.kt#9igjgp");
            boolean invalid$iv = $composer.changed(keyboardController);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new TribeeDialogKt$TribeeInviteCheckDialog$5$1$1(focusRequester, keyboardController, null);
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv2, $composer, 6);
            Modifier modifier$iv = BackgroundKt.background-bw27NRU(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(8), 0.0f, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)));
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i2 = ((0 >> 6) & 112) | 6;
            BoxScope $this$TribeeInviteCheckDialog_u24lambda_u244_u242 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 483969487, "C636@22633L20,644@22977L39,646@23091L67,650@23244L6,635@22587L684,653@23285L7374:TribeeDialog.kt#iitu82");
            Painter xmark_close_line_500 = BiliIconfont.INSTANCE.getXmark_close_line_500($composer, 6);
            Modifier align = $this$TribeeInviteCheckDialog_u24lambda_u244_u242.align(PaddingKt.padding-3ABfNKs(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(2), Dp.constructor-impl(2), 0.0f, 9, (Object) null), Dp.constructor-impl(36)), Dp.constructor-impl(8)), Alignment.Companion.getTopEnd());
            ComposerKt.sourceInformationMarkerStart($composer, 1262542355, "CC(remember):TribeeDialog.kt#9igjgp");
            Object it$iv3 = $composer.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = InteractionSourceKt.MutableInteractionSource();
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1262546031, "CC(remember):TribeeDialog.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed($onDismiss);
            Object it$iv4 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv4 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda17
                public final Object invoke() {
                    Unit TribeeInviteCheckDialog$lambda$4$2$1$0;
                    TribeeInviteCheckDialog$lambda$4$2$1$0 = TribeeDialogKt.TribeeInviteCheckDialog$lambda$4$2$1$0($onDismiss);
                    return TribeeInviteCheckDialog$lambda$4$2$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv4);
            it$iv4 = value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer);
            BiliIconfontKt.BiliIcon-ww6aTOc(xmark_close_line_500, ClickableKt.clickable-O2vRcR0$default(align, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv4, 28, (Object) null), "close icon", BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU(), $composer, Painter.$stable | 384, 0);
            Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(12), 0.0f, 0.0f, 13, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv2 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
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
            int i4 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 828795772, "C660@23536L301,673@24028L6,669@23855L470,682@24373L42,682@24356L59,683@24432L2443,736@26921L56,746@27384L6,752@27733L572,764@28426L6,737@26994L1468:TribeeDialog.kt#iitu82");
            String $this$asRequest$iv = $dialog.getPicUrl();
            ImageRequest $this$TribeeInviteCheckDialog_u24lambda_u244_u242_u242_u240 = new ImageRequest($this$asRequest$iv);
            $this$TribeeInviteCheckDialog_u24lambda_u244_u242_u242_u240.contentScale(ContentScale.Companion.getInside());
            BiliImageKt.BiliImage($this$TribeeInviteCheckDialog_u24lambda_u244_u242_u242_u240.build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl((float) BackoffConfigKt.MAX_DELAY_SECONDS)), "image", null, null, null, null, null, null, $composer, 432, InitGMultiDomainKt.HTTP_CODE_GATEWAY_TIMEOUT);
            TextKt.Text-Nvy7gAk($dialog.getTitle(), PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(20), 0.0f, 2, (Object) null), 0.0f, Dp.constructor-impl(12), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(16), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 1597488, 0, 261032);
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart($composer, -388886932, "CC(remember):TribeeDialog.kt#9igjgp");
            boolean invalid$iv3 = $composer.changedInstance($dialog);
            Object it$iv5 = $composer.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv5 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda18
                public final Object invoke() {
                    MutableState TribeeInviteCheckDialog$lambda$4$2$2$1$0;
                    TribeeInviteCheckDialog$lambda$4$2$2$1$0 = TribeeDialogKt.TribeeInviteCheckDialog$lambda$4$2$2$1$0($dialog);
                    return TribeeInviteCheckDialog$lambda$4$2$2$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv5);
            it$iv5 = value$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer);
            final MutableState input$delegate = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) it$iv5, $composer, 0);
            Modifier modifier$iv3 = PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(20), Dp.constructor-impl(16));
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv3 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i6 = ((6 >> 6) & 112) | 6;
            BoxScope $this$TribeeInviteCheckDialog_u24lambda_u244_u242_u242_u244 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 1486467637, "C698@25174L6,704@25522L6,710@25798L6,689@24731L111,686@24579L1468:TribeeDialog.kt#iitu82");
            String TribeeInviteCheckDialog$lambda$4$2$2$2 = TribeeInviteCheckDialog$lambda$4$2$2$2(input$delegate);
            String inputDefaultText = $dialog.getInputDefaultText();
            Modifier modifier = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(BackgroundKt.background-bw27NRU(FocusRequesterModifierKt.focusRequester(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(34)), focusRequester), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_bg_regular_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape(50)), (Alignment.Vertical) null, false, 3, (Object) null), Dp.constructor-impl(12), 0.0f, Dp.constructor-impl(32), 0.0f, 10, (Object) null);
            TextStyle textStyle = new TextStyle(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), TextUnitKt.getSp(14), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646140, (DefaultConstructorMarker) null);
            TextStyle textStyle2 = new TextStyle(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), TextUnitKt.getSp(14), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646140, (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1294879255, "CC(remember):TribeeDialog.kt#9igjgp");
            boolean invalid$iv4 = $composer.changed(input$delegate);
            Object it$iv6 = $composer.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv6 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda19
                public final Object invoke(Object obj) {
                    Unit TribeeInviteCheckDialog$lambda$4$2$2$4$0$0;
                    TribeeInviteCheckDialog$lambda$4$2$2$4$0$0 = TribeeDialogKt.TribeeInviteCheckDialog$lambda$4$2$2$4$0$0(input$delegate, (String) obj);
                    return TribeeInviteCheckDialog$lambda$4$2$2$4$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv6);
            it$iv6 = value$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer);
            SimpleTextFieldKt.SimpleTextField(TribeeInviteCheckDialog$lambda$4$2$2$2, inputDefaultText, (Function1) it$iv6, modifier, textStyle, textStyle2, false, true, 1, (KeyboardOptions) null, (KeyboardActions) null, (VisualTransformation) null, (Function1) null, (TextFieldColors) null, $composer, 113246208, 0, 15936);
            if (TribeeInviteCheckDialog$lambda$4$2$2$2(input$delegate).length() > 0) {
                $composer.startReplaceGroup(1487946894);
                ComposerKt.sourceInformation($composer, "720@26177L27,721@26251L6,730@26755L14,719@26119L716");
                Painter xmark_close_circle_fill_500 = BiliIconfont.INSTANCE.getXmark_close_circle_fill_500($composer, 6);
                long j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText4-0d7_KjU();
                Modifier align2 = $this$TribeeInviteCheckDialog_u24lambda_u244_u242_u242_u244.align(PaddingKt.padding-3ABfNKs(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(33)), Dp.constructor-impl(10)), Alignment.Companion.getCenterEnd());
                MutableInteractionSource MutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
                ComposerKt.sourceInformationMarkerStart($composer, 1294943926, "CC(remember):TribeeDialog.kt#9igjgp");
                boolean invalid$iv5 = $composer.changed(input$delegate);
                Object it$iv7 = $composer.rememberedValue();
                if (invalid$iv5) {
                }
                Object value$iv7 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda20
                    public final Object invoke() {
                        Unit TribeeInviteCheckDialog$lambda$4$2$2$4$1$0;
                        TribeeInviteCheckDialog$lambda$4$2$2$4$1$0 = TribeeDialogKt.TribeeInviteCheckDialog$lambda$4$2$2$4$1$0(input$delegate);
                        return TribeeInviteCheckDialog$lambda$4$2$2$4$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv7);
                it$iv7 = value$iv7;
                ComposerKt.sourceInformationMarkerEnd($composer);
                BiliIconfontKt.BiliIcon-ww6aTOc(xmark_close_circle_fill_500, ClickableKt.clickable-O2vRcR0$default(align2, MutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv7, 28, (Object) null), (String) null, j, $composer, Painter.$stable, 4);
            } else {
                $composer.startReplaceGroup(1462013658);
            }
            $composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            final String activateCodeErrorTips = StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_10(TribeeRes.INSTANCE.getString()), $composer, 0);
            String confirmText = $dialog.getConfirmText();
            long sp = TextUnitKt.getSp(14);
            Modifier wrapContentHeight$default = SizeKt.wrapContentHeight$default(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(16), 0.0f, 2, (Object) null), Dp.constructor-impl(34)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(17))), (Alignment.Vertical) null, false, 3, (Object) null);
            MutableInteractionSource MutableInteractionSource2 = InteractionSourceKt.MutableInteractionSource();
            ComposerKt.sourceInformationMarkerStart($composer, -388778882, "CC(remember):TribeeDialog.kt#9igjgp");
            boolean invalid$iv6 = $composer.changed(input$delegate) | $composer.changed($confirmClickCallback) | $composer.changedInstance($toaster) | $composer.changed(activateCodeErrorTips);
            Object it$iv8 = $composer.rememberedValue();
            if (invalid$iv6 || it$iv8 == Composer.Companion.getEmpty()) {
                Object value$iv8 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda22
                    public final Object invoke() {
                        Unit TribeeInviteCheckDialog$lambda$4$2$2$5$0;
                        TribeeInviteCheckDialog$lambda$4$2$2$5$0 = TribeeDialogKt.TribeeInviteCheckDialog$lambda$4$2$2$5$0($confirmClickCallback, $toaster, activateCodeErrorTips, input$delegate);
                        return TribeeInviteCheckDialog$lambda$4$2$2$5$0;
                    }
                };
                $composer.updateRememberedValue(value$iv8);
                it$iv8 = value$iv8;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            TextKt.Text-Nvy7gAk(confirmText, ClickableKt.clickable-O2vRcR0$default(wrapContentHeight$default, MutableInteractionSource2, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv8, 28, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 24576, 0, 261096);
            if (StringsKt.isBlank($dialog.getCancelText())) {
                $composer$iv$iv$iv = $composer;
                $composer.startReplaceGroup(835549679);
                ComposerKt.sourceInformation($composer, "807@30586L41");
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), $composer, 6);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(833578854);
                ComposerKt.sourceInformation($composer, "796@29993L392,780@29176L1364");
                if (Intrinsics.areEqual($dialog.getType(), KToastDialog.KToastDialogType.ACTIVATE_NO_CANDIDATE.INSTANCE)) {
                    $composer.startReplaceGroup(833650898);
                    ComposerKt.sourceInformation($composer, "770@28690L6");
                    long j2 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU();
                    $composer.endReplaceGroup();
                    textColor = j2;
                } else {
                    $composer.startReplaceGroup(833734815);
                    ComposerKt.sourceInformation($composer, "772@28774L6");
                    long j3 = Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    $composer.endReplaceGroup();
                    textColor = j3;
                }
                if (Intrinsics.areEqual($dialog.getType(), KToastDialog.KToastDialogType.ACTIVATE_NO_CANDIDATE.INSTANCE)) {
                    $composer.startReplaceGroup(833964494);
                    ComposerKt.sourceInformation($composer, "776@29006L6");
                    borderColor = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_bold-0d7_KjU();
                    $composer.endReplaceGroup();
                } else {
                    $composer.startReplaceGroup(834052379);
                    ComposerKt.sourceInformation($composer, "778@29094L6");
                    borderColor = Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_bold-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    $composer.endReplaceGroup();
                }
                String cancelText = $dialog.getCancelText();
                long sp2 = TextUnitKt.getSp(14);
                Modifier wrapContentHeight$default2 = SizeKt.wrapContentHeight$default(BorderKt.border-xT4_qwU(SizeKt.height-3ABfNKs(PaddingKt.padding-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(16)), Dp.constructor-impl(34)), Dp.constructor-impl((float) 0.5d), borderColor, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(17))), (Alignment.Vertical) null, false, 3, (Object) null);
                MutableInteractionSource MutableInteractionSource3 = InteractionSourceKt.MutableInteractionSource();
                ComposerKt.sourceInformationMarkerStart($composer, -388706742, "CC(remember):TribeeDialog.kt#9igjgp");
                $composer$iv$iv$iv = $composer;
                boolean invalid$iv7 = $composer.changedInstance($dialog) | $composer.changed($cancelClickCallback);
                Object value$iv9 = $composer.rememberedValue();
                if (invalid$iv7) {
                }
                value$iv9 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDialogKt$$ExternalSyntheticLambda23
                    public final Object invoke() {
                        Unit TribeeInviteCheckDialog$lambda$4$2$2$6$0;
                        TribeeInviteCheckDialog$lambda$4$2$2$6$0 = TribeeDialogKt.TribeeInviteCheckDialog$lambda$4$2$2$6$0($dialog, $cancelClickCallback);
                        return TribeeInviteCheckDialog$lambda$4$2$2$6$0;
                    }
                };
                $composer.updateRememberedValue(value$iv9);
                ComposerKt.sourceInformationMarkerEnd($composer);
                TextKt.Text-Nvy7gAk(cancelText, ClickableKt.clickable-O2vRcR0$default(wrapContentHeight$default2, MutableInteractionSource3, (Indication) null, false, (String) null, (Role) null, (Function0) value$iv9, 28, (Object) null), textColor, (TextAutoSize) null, sp2, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 24576, 0, 261096);
                $composer.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
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
    public static final Unit TribeeInviteCheckDialog$lambda$4$2$1$0(Function0 $onDismiss) {
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState TribeeInviteCheckDialog$lambda$4$2$2$1$0(KToastDialog $dialog) {
        return SnapshotStateKt.mutableStateOf$default($dialog.getInputInviteCode(), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    private static final String TribeeInviteCheckDialog$lambda$4$2$2$2(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInviteCheckDialog$lambda$4$2$2$4$0$0(MutableState $input$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $input$delegate.setValue(StringsKt.substring(it, RangesKt.until(0, RangesKt.coerceAtMost(it.length(), 6))));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInviteCheckDialog$lambda$4$2$2$4$1$0(MutableState $input$delegate) {
        $input$delegate.setValue("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInviteCheckDialog$lambda$4$2$2$5$0(Function1 $confirmClickCallback, Toaster $toaster, String $activateCodeErrorTips, MutableState $input$delegate) {
        if (!StringsKt.isBlank(TribeeInviteCheckDialog$lambda$4$2$2$2($input$delegate))) {
            $confirmClickCallback.invoke(TribeeInviteCheckDialog$lambda$4$2$2$2($input$delegate));
            TrackerKt.inviteCodeInputDialogClick("activate", "");
        } else {
            if (TribeeInviteCheckDialog$lambda$4$2$2$2($input$delegate).length() > 0) {
                $toaster.showToast($activateCodeErrorTips, ToastDuration.Short);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInviteCheckDialog$lambda$4$2$2$6$0(KToastDialog $dialog, Function0 $cancelClickCallback) {
        if (Intrinsics.areEqual($dialog.getType(), KToastDialog.KToastDialogType.ACTIVATE_NO_CANDIDATE.INSTANCE)) {
            $cancelClickCallback.invoke();
            TrackerKt.inviteCodeInputDialogClick($dialog.getCancelText(), $dialog.getCancelJumpUri());
        }
        return Unit.INSTANCE;
    }
}