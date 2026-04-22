package kntr.app.tribee.repost.page.editTextBottomSheet;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
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
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.bilitheme.compose.bottomsheet.BottomSheetScope;
import kntr.common.bilitheme.compose.bottomsheet.ComposeBottomsheetKt;
import kntr.common.screen.adjust.KScreenAdjustUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: EditTextBottomSheet.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001aq\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\u00112\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\u00112\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\u0011H\u0007¢\u0006\u0002\u0010\u0014\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0015²\u0006\n\u0010\u0016\u001a\u00020\u0006X\u008a\u008e\u0002²\u0006\u0010\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u000fX\u008a\u0084\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0002X\u008a\u008e\u0002"}, d2 = {"textWithoutComposition", "", "Landroidx/compose/ui/text/input/TextFieldValue;", "getTextWithoutComposition", "(Landroidx/compose/ui/text/input/TextFieldValue;)Ljava/lang/String;", "rememberKeyboardOpen", "", "(Landroidx/compose/runtime/Composer;I)Z", "EditTextBottomSheet", "", "state", "Lkntr/app/tribee/repost/page/editTextBottomSheet/EditTextBottomSheetState;", "modifier", "Landroidx/compose/ui/Modifier;", "onExpose", "Lkotlin/Function0;", "onTextChange", "Lkotlin/Function1;", "onConfirm", "onDismiss", "(Lkntr/app/tribee/repost/page/editTextBottomSheet/EditTextBottomSheetState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "repost_debug", "isKeyboardOpen", "currentOnExpose", "textFieldValue"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class EditTextBottomSheetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditTextBottomSheet$lambda$11(EditTextBottomSheetState editTextBottomSheetState, Modifier modifier, Function0 function0, Function1 function1, Function1 function12, Function1 function13, int i, int i2, Composer composer, int i3) {
        EditTextBottomSheet(editTextBottomSheetState, modifier, function0, function1, function12, function13, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final String getTextWithoutComposition(TextFieldValue $this$textWithoutComposition) {
        Intrinsics.checkNotNullParameter($this$textWithoutComposition, "<this>");
        TextRange textRange = $this$textWithoutComposition.getComposition-MzsxiRA();
        if (textRange == null) {
            return $this$textWithoutComposition.getText();
        }
        long composition = textRange.unbox-impl();
        if (TextRange.getCollapsed-impl(composition)) {
            return $this$textWithoutComposition.getText();
        }
        try {
            int start = RangesKt.coerceIn(TextRange.getStart-impl(composition), 0, $this$textWithoutComposition.getText().length());
            int end = RangesKt.coerceAtLeast(RangesKt.coerceIn(TextRange.getEnd-impl(composition), 0, $this$textWithoutComposition.getText().length()), start);
            return start >= end ? $this$textWithoutComposition.getText() : StringsKt.removeRange($this$textWithoutComposition.getText(), start, end).toString();
        } catch (Exception e) {
            return $this$textWithoutComposition.getText();
        }
    }

    public static final boolean rememberKeyboardOpen(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -933214973, "C(rememberKeyboardOpen)68@2965L34,69@3033L3,69@3060L7,71@3100L132,71@3074L158:EditTextBottomSheet.kt#rpfy70");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-933214973, $changed, -1, "kntr.app.tribee.repost.page.editTextBottomSheet.rememberKeyboardOpen (EditTextBottomSheet.kt:67)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 828577893, "CC(remember):EditTextBottomSheet.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        MutableState isKeyboardOpen$delegate = (MutableState) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        WindowInsets ime = WindowInsets_androidKt.getIme(WindowInsets.Companion, $composer, 6);
        CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        int imeHeight = ime.getBottom((Density) consume);
        Integer valueOf = Integer.valueOf(imeHeight);
        ComposerKt.sourceInformationMarkerStart($composer, 828582311, "CC(remember):EditTextBottomSheet.kt#9igjgp");
        boolean invalid$iv = $composer.changed(imeHeight);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = (Function2) new EditTextBottomSheetKt$rememberKeyboardOpen$1$1(imeHeight, isKeyboardOpen$delegate, null);
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv2, $composer, 0);
        boolean rememberKeyboardOpen$lambda$1 = rememberKeyboardOpen$lambda$1(isKeyboardOpen$delegate);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return rememberKeyboardOpen$lambda$1;
    }

    private static final boolean rememberKeyboardOpen$lambda$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rememberKeyboardOpen$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditTextBottomSheet$lambda$1$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditTextBottomSheet$lambda$2$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditTextBottomSheet$lambda$3$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v19 */
    public static final void EditTextBottomSheet(final EditTextBottomSheetState state, Modifier modifier, Function0<Unit> function0, Function1<? super String, Unit> function1, Function1<? super String, Unit> function12, Function1<? super String, Unit> function13, Composer $composer, final int $changed, final int i) {
        Function0 onExpose;
        Function1 function14;
        Function1 function15;
        Function1 onDismiss;
        Modifier modifier2;
        Function0 onExpose2;
        Function1 onTextChange;
        Function1 onConfirm;
        Function0 onExpose3;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer $composer2 = $composer.startRestartGroup(1094348);
        ComposerKt.sourceInformation($composer2, "C(EditTextBottomSheet)N(state,modifier,onExpose,onTextChange,onConfirm,onDismiss)85@3398L2,86@3439L2,87@3477L2,88@3515L2,90@3550L30,91@3606L33,91@3585L54,95@3667L186,104@3896L7,105@3965L7,106@3998L29,107@4053L22,110@4158L7,111@4198L7588,109@4081L7705:EditTextBottomSheet.kt#rpfy70");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            onExpose = function0;
        } else if (($changed & 384) == 0) {
            onExpose = function0;
            $dirty |= $composer2.changedInstance(onExpose) ? 256 : 128;
        } else {
            onExpose = function0;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            function14 = function1;
        } else if (($changed & 3072) == 0) {
            function14 = function1;
            $dirty |= $composer2.changedInstance(function14) ? 2048 : 1024;
        } else {
            function14 = function1;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            function15 = function12;
        } else if (($changed & 24576) == 0) {
            function15 = function12;
            $dirty |= $composer2.changedInstance(function15) ? 16384 : 8192;
        } else {
            function15 = function12;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty |= 196608;
            onDismiss = function13;
        } else if ((196608 & $changed) == 0) {
            onDismiss = function13;
            $dirty |= $composer2.changedInstance(onDismiss) ? 131072 : 65536;
        } else {
            onDismiss = function13;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute((74883 & $dirty2) != 74882, $dirty2 & 1)) {
            modifier2 = (i & 2) != 0 ? (Modifier) Modifier.Companion : modifier;
            if (i2 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1051672398, "CC(remember):EditTextBottomSheet.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.repost.page.editTextBottomSheet.EditTextBottomSheetKt$$ExternalSyntheticLambda13
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onExpose4 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onExpose = onExpose4;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1051673710, "CC(remember):EditTextBottomSheet.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: kntr.app.tribee.repost.page.editTextBottomSheet.EditTextBottomSheetKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            Unit EditTextBottomSheet$lambda$1$0;
                            EditTextBottomSheet$lambda$1$0 = EditTextBottomSheetKt.EditTextBottomSheet$lambda$1$0((String) obj);
                            return EditTextBottomSheet$lambda$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function1 onTextChange2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onTextChange = onTextChange2;
            } else {
                onTextChange = function14;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1051674926, "CC(remember):EditTextBottomSheet.kt#9igjgp");
                Object it$iv3 = $composer2.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function1() { // from class: kntr.app.tribee.repost.page.editTextBottomSheet.EditTextBottomSheetKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            Unit EditTextBottomSheet$lambda$2$0;
                            EditTextBottomSheet$lambda$2$0 = EditTextBottomSheetKt.EditTextBottomSheet$lambda$2$0((String) obj);
                            return EditTextBottomSheet$lambda$2$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                Function1 onConfirm2 = it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onConfirm = onConfirm2;
            } else {
                onConfirm = function15;
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1051676142, "CC(remember):EditTextBottomSheet.kt#9igjgp");
                Object it$iv4 = $composer2.rememberedValue();
                if (it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = new Function1() { // from class: kntr.app.tribee.repost.page.editTextBottomSheet.EditTextBottomSheetKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            Unit EditTextBottomSheet$lambda$3$0;
                            EditTextBottomSheet$lambda$3$0 = EditTextBottomSheetKt.EditTextBottomSheet$lambda$3$0((String) obj);
                            return EditTextBottomSheet$lambda$3$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                }
                Function1 onDismiss2 = it$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onDismiss = onDismiss2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1094348, $dirty2, -1, "kntr.app.tribee.repost.page.editTextBottomSheet.EditTextBottomSheet (EditTextBottomSheet.kt:89)");
            }
            State currentOnExpose$delegate = SnapshotStateKt.rememberUpdatedState(onExpose, $composer2, ($dirty2 >> 6) & 14);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1051679085, "CC(remember):EditTextBottomSheet.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(currentOnExpose$delegate);
            Object it$iv5 = $composer2.rememberedValue();
            if (invalid$iv || it$iv5 == Composer.Companion.getEmpty()) {
                onExpose3 = onExpose;
                Object value$iv5 = (Function2) new EditTextBottomSheetKt$EditTextBottomSheet$5$1(currentOnExpose$delegate, null);
                $composer2.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            } else {
                onExpose3 = onExpose;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv5, $composer2, 6);
            ComposerKt.sourceInformationMarkerStart($composer2, 1051681190, "CC(remember):EditTextBottomSheet.kt#9igjgp");
            Object it$iv6 = $composer2.rememberedValue();
            if (it$iv6 == Composer.Companion.getEmpty()) {
                Object value$iv6 = SnapshotStateKt.mutableStateOf$default(new TextFieldValue(state.getText(), TextRangeKt.TextRange(state.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv6);
                it$iv6 = value$iv6;
            }
            final MutableState textFieldValue$delegate = (MutableState) it$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final FocusManager focusManager = (FocusManager) consume;
            CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final SoftwareKeyboardController keyboardController = (SoftwareKeyboardController) consume2;
            ComposerKt.sourceInformationMarkerStart($composer2, 1051691625, "CC(remember):EditTextBottomSheet.kt#9igjgp");
            Object it$iv7 = $composer2.rememberedValue();
            if (it$iv7 == Composer.Companion.getEmpty()) {
                Object value$iv7 = new FocusRequester();
                $composer2.updateRememberedValue(value$iv7);
                it$iv7 = value$iv7;
            }
            final FocusRequester focusRequester = (FocusRequester) it$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final boolean isKeyboardOpen = rememberKeyboardOpen($composer2, 0);
            ProvidableCompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
            CompositionLocal this_$iv3 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(this_$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            onExpose2 = onExpose3;
            final Function1 function16 = onDismiss;
            final Function1 function17 = onConfirm;
            final Function1 function18 = onTextChange;
            CompositionLocalKt.CompositionLocalProvider(localDensity.provides(DensityKt.Density(((Density) consume3).getDensity(), 1.0f)), ComposableLambdaKt.rememberComposableLambda(-1575487988, true, new Function2() { // from class: kntr.app.tribee.repost.page.editTextBottomSheet.EditTextBottomSheetKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit EditTextBottomSheet$lambda$10;
                    EditTextBottomSheet$lambda$10 = EditTextBottomSheetKt.EditTextBottomSheet$lambda$10(isKeyboardOpen, focusManager, keyboardController, function16, focusRequester, textFieldValue$delegate, state, function17, function18, (Composer) obj, ((Integer) obj2).intValue());
                    return EditTextBottomSheet$lambda$10;
                }
            }, $composer2, 54), $composer2, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            onExpose2 = onExpose;
            onTextChange = function14;
            onConfirm = function15;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final Function0 function02 = onExpose2;
            final Function1 function19 = onTextChange;
            final Function1 function110 = onConfirm;
            final Function1 function111 = onDismiss;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.repost.page.editTextBottomSheet.EditTextBottomSheetKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit EditTextBottomSheet$lambda$11;
                    EditTextBottomSheet$lambda$11 = EditTextBottomSheetKt.EditTextBottomSheet$lambda$11(EditTextBottomSheetState.this, modifier3, function02, function19, function110, function111, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return EditTextBottomSheet$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> EditTextBottomSheet$lambda$4(State<? extends Function0<Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function0) thisObj$iv;
    }

    private static final TextFieldValue EditTextBottomSheet$lambda$7(MutableState<TextFieldValue> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (TextFieldValue) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditTextBottomSheet$lambda$10$1$0(FocusRequester $focusRequester, SoftwareKeyboardController $keyboardController) {
        FocusRequester.requestFocus-3ESFkO8$default($focusRequester, 0, 1, (Object) null);
        if ($keyboardController != null) {
            $keyboardController.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditTextBottomSheet$lambda$10(boolean $isKeyboardOpen, final FocusManager $focusManager, final SoftwareKeyboardController $keyboardController, final Function1 $onDismiss, final FocusRequester $focusRequester, final MutableState $textFieldValue$delegate, final EditTextBottomSheetState $state, final Function1 $onConfirm, final Function1 $onTextChange, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C128@4910L6,122@4661L208,113@4253L148,129@4938L6842,112@4208L7572:EditTextBottomSheet.kt#rpfy70");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1575487988, $changed, -1, "kntr.app.tribee.repost.page.editTextBottomSheet.EditTextBottomSheet.<anonymous> (EditTextBottomSheet.kt:112)");
            }
            boolean z = !$isKeyboardOpen;
            PaddingValues paddingValues = PaddingKt.PaddingValues-a9UjIt4(Dp.constructor-impl(12), Dp.constructor-impl(12), Dp.constructor-impl(12), Dp.constructor-impl(20));
            long j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1_float-0d7_KjU();
            ComposerKt.sourceInformationMarkerStart($composer, 2079514044, "CC(remember):EditTextBottomSheet.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($focusManager) | $composer.changed($keyboardController) | $composer.changed($onDismiss);
            Object value$iv = $composer.rememberedValue();
            if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                value$iv = new Function0() { // from class: kntr.app.tribee.repost.page.editTextBottomSheet.EditTextBottomSheetKt$$ExternalSyntheticLambda10
                    public final Object invoke() {
                        Unit EditTextBottomSheet$lambda$10$0$0;
                        EditTextBottomSheet$lambda$10$0$0 = EditTextBottomSheetKt.EditTextBottomSheet$lambda$10$0$0($focusRequester, $focusManager, $keyboardController, $onDismiss, $textFieldValue$delegate);
                        return EditTextBottomSheet$lambda$10$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
            }
            Function0 function0 = (Function0) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 2079500928, "CC(remember):EditTextBottomSheet.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed($keyboardController);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv2 || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.tribee.repost.page.editTextBottomSheet.EditTextBottomSheetKt$$ExternalSyntheticLambda11
                    public final Object invoke() {
                        Unit EditTextBottomSheet$lambda$10$1$0;
                        EditTextBottomSheet$lambda$10$1$0 = EditTextBottomSheetKt.EditTextBottomSheet$lambda$10$1$0($focusRequester, $keyboardController);
                        return EditTextBottomSheet$lambda$10$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposeBottomsheetKt.m1831BottomSheetContainerlVb_Clg(function0, (Function0) it$iv, j, true, z, false, paddingValues, ComposableLambdaKt.rememberComposableLambda(210104285, true, new Function3() { // from class: kntr.app.tribee.repost.page.editTextBottomSheet.EditTextBottomSheetKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit EditTextBottomSheet$lambda$10$2;
                    EditTextBottomSheet$lambda$10$2 = EditTextBottomSheetKt.EditTextBottomSheet$lambda$10$2(EditTextBottomSheetState.this, $onConfirm, $onDismiss, $textFieldValue$delegate, $focusRequester, $onTextChange, (BottomSheetScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return EditTextBottomSheet$lambda$10$2;
                }
            }, $composer, 54), $composer, 12782592, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditTextBottomSheet$lambda$10$0$0(FocusRequester $focusRequester, FocusManager $focusManager, SoftwareKeyboardController $keyboardController, Function1 $onDismiss, MutableState $textFieldValue$delegate) {
        $focusRequester.freeFocus();
        FocusManager.-CC.clearFocus$default($focusManager, false, 1, (Object) null);
        if ($keyboardController != null) {
            $keyboardController.hide();
        }
        $onDismiss.invoke(getTextWithoutComposition(EditTextBottomSheet$lambda$7($textFieldValue$delegate)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0350, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L26;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0846  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0852  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0858  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x08de  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x08e0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x08e3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x090f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0941  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0959  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0af3  */
    /* JADX WARN: Type inference failed for: r4v12 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit EditTextBottomSheet$lambda$10$2(final EditTextBottomSheetState $state, final Function1 $onConfirm, final Function1 $onDismiss, final MutableState $textFieldValue$delegate, FocusRequester $focusRequester, final Function1 $onTextChange, BottomSheetScope $this$BottomSheetContainer, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        String str;
        String str2;
        Function0 factory$iv$iv$iv3;
        final MutableState mutableState;
        Function0 factory$iv$iv$iv4;
        boolean isOverLimit;
        String displayText;
        long j;
        boolean invalid$iv;
        Object it$iv;
        Function0 factory$iv$iv$iv5;
        Intrinsics.checkNotNullParameter($this$BottomSheetContainer, "$this$BottomSheetContainer");
        ComposerKt.sourceInformation($composer, "C134@5102L6,130@4952L6818:EditTextBottomSheet.kt#rpfy70");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(210104285, $changed, -1, "kntr.app.tribee.repost.page.editTextBottomSheet.EditTextBottomSheet.<anonymous>.<anonymous> (EditTextBottomSheet.kt:130)");
            }
            Modifier modifier$iv$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1_float-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv6;
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
            ComposerKt.sourceInformationMarkerStart($composer, -2046453339, "C136@5153L1270,183@7096L41,185@7155L2282,234@9455L40,236@9513L888,257@10419L41,268@10915L6,269@10987L6,270@11064L6,271@11163L6,267@10846L361,260@10516L52,277@11483L273,259@10478L1278:EditTextBottomSheet.kt#rpfy70");
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv2 = (438 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((438 >> 6) & 112) | 6;
            RowScope $this$EditTextBottomSheet_u24lambda_u2410_u242_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 1929337836, "C147@5633L6,143@5445L323,153@5893L20,154@5956L6,158@6141L6,160@6262L120,151@5789L616:EditTextBottomSheet.kt#rpfy70");
            TextKt.Text-Nvy7gAk($state.getTitle(), RowScope.-CC.weight$default($this$EditTextBottomSheet_u24lambda_u2410_u242_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(16), (FontStyle) null, FontWeight.Companion.getW600(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(22), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 1597440, 48, 260008);
            Painter xmark_close_line_500 = BiliIconfont.INSTANCE.getXmark_close_line_500($composer, 6);
            long j2 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU();
            Modifier modifier = PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg2_float-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.constructor-impl(2));
            ComposerKt.sourceInformationMarkerStart($composer, -1323211313, "CC(remember):EditTextBottomSheet.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed($onDismiss);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv = new Function0() { // from class: kntr.app.tribee.repost.page.editTextBottomSheet.EditTextBottomSheetKt$$ExternalSyntheticLambda5
                public final Object invoke() {
                    Unit EditTextBottomSheet$lambda$10$2$0$0$0$0;
                    EditTextBottomSheet$lambda$10$2$0$0$0$0 = EditTextBottomSheetKt.EditTextBottomSheet$lambda$10$2$0$0$0$0($onDismiss, $textFieldValue$delegate);
                    return EditTextBottomSheet$lambda$10$2$0$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv2 = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            IconKt.Icon-ww6aTOc(xmark_close_line_500, (String) null, ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), j2, $composer, Painter.$stable | 48, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            String subtitle = $state.getSubtitle();
            if (!(subtitle == null || subtitle.length() == 0)) {
                $composer.startReplaceGroup(-2045325033);
                ComposerKt.sourceInformation($composer, "167@6500L40,168@6561L499");
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer, 6);
                Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                int $changed$iv$iv3 = (54 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, str2);
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv5 = factory$iv$iv$iv8;
                    $composer.createNode(factory$iv$iv$iv5);
                } else {
                    factory$iv$iv$iv5 = factory$iv$iv$iv8;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
                str = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i6 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 1637597381, "C176@6905L6,174@6802L236:EditTextBottomSheet.kt#rpfy70");
                TextKt.Text-Nvy7gAk($state.getSubtitle(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(17), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 24576, 48, 260074);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
            } else {
                str = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $composer.startReplaceGroup(-2051770801);
            }
            $composer.endReplaceGroup();
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer, 6);
            Modifier modifier$iv3 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $state.m1013getTextFieldHeightD9Ej5fM());
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv4 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, str2);
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv9;
                $composer.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv9;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i8 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1423721639, "C200@7840L6,203@7996L6,209@8293L6,193@7472L191,213@8527L869,191@7368L2051:EditTextBottomSheet.kt#rpfy70");
            TextFieldValue EditTextBottomSheet$lambda$7 = EditTextBottomSheet$lambda$7($textFieldValue$delegate);
            TextStyle textStyle = new TextStyle(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), TextUnitKt.getSp(14), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(24), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646140, (DefaultConstructorMarker) null);
            Brush solidColor = new SolidColor(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (DefaultConstructorMarker) null);
            KeyboardOptions keyboardOptions = KeyboardOptions.Companion.getDefault();
            Modifier focusRequester = FocusRequesterModifierKt.focusRequester(PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg2_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), Dp.constructor-impl(12)), $focusRequester);
            ComposerKt.sourceInformationMarkerStart($composer, -369714024, "CC(remember):EditTextBottomSheet.kt#9igjgp");
            boolean invalid$iv3 = $composer.changed($onTextChange);
            Object value$iv2 = $composer.rememberedValue();
            if (!invalid$iv3 && value$iv2 != Composer.Companion.getEmpty()) {
                mutableState = $textFieldValue$delegate;
                ComposerKt.sourceInformationMarkerEnd($composer);
                BasicTextFieldKt.BasicTextField(EditTextBottomSheet$lambda$7, (Function1) value$iv2, focusRequester, false, false, textStyle, keyboardOptions, (KeyboardActions) null, false, 0, 0, (VisualTransformation) null, (Function1) null, (MutableInteractionSource) null, solidColor, ComposableLambdaKt.rememberComposableLambda(-818141226, true, new Function3() { // from class: kntr.app.tribee.repost.page.editTextBottomSheet.EditTextBottomSheetKt$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit EditTextBottomSheet$lambda$10$2$0$2$1;
                        EditTextBottomSheet$lambda$10$2$0$2$1 = EditTextBottomSheetKt.EditTextBottomSheet$lambda$10$2$0$2$1(EditTextBottomSheetState.this, mutableState, (Function2) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return EditTextBottomSheet$lambda$10$2$0$2$1;
                    }
                }, $composer, 54), $composer, 1572864, 196608, 16280);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer, 6);
                Modifier modifier$iv4 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getEnd();
                ComposerKt.sourceInformationMarkerStart($composer, 844473419, str);
                Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                int $changed$iv$iv5 = (54 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv5 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer, modifier$iv4);
                Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, str2);
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if (!$composer.getInserting()) {
                    factory$iv$iv$iv4 = factory$iv$iv$iv10;
                    $composer.createNode(factory$iv$iv$iv4);
                } else {
                    factory$iv$iv$iv4 = factory$iv$iv$iv10;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                int i9 = ($changed$iv$iv$iv5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope2 = RowScopeInstance.INSTANCE;
                int i10 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 447141798, "C250@10164L219:EditTextBottomSheet.kt#rpfy70");
                isOverLimit = getTextWithoutComposition(EditTextBottomSheet$lambda$7($textFieldValue$delegate)).length() <= $state.getMaxLength();
                if (isOverLimit) {
                    displayText = getTextWithoutComposition(EditTextBottomSheet$lambda$7($textFieldValue$delegate)).length() + "/" + $state.getMaxLength();
                } else {
                    displayText = "-" + (getTextWithoutComposition(EditTextBottomSheet$lambda$7($textFieldValue$delegate)).length() - $state.getMaxLength());
                }
                if (!isOverLimit) {
                    $composer.startReplaceGroup(152988280);
                    ComposerKt.sourceInformation($composer, "252@10273L6");
                    j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getStress_red-0d7_KjU();
                } else {
                    $composer.startReplaceGroup(152989331);
                    ComposerKt.sourceInformation($composer, "252@10306L6");
                    j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU();
                }
                $composer.endReplaceGroup();
                TextKt.Text-Nvy7gAk(displayText, (Modifier) null, j, (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 24576, 0, 262122);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), $composer, 6);
                Modifier modifier2 = SizeKt.height-3ABfNKs(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(0), 0.0f, 2, (Object) null), Dp.constructor-impl(44));
                ButtonColors buttonColors = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText_white-0d7_KjU(), $composer, ButtonDefaults.$stable << 12, 0);
                Shape shape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(22));
                boolean z = StringsKt.isBlank(getTextWithoutComposition(EditTextBottomSheet$lambda$7($textFieldValue$delegate))) && getTextWithoutComposition(EditTextBottomSheet$lambda$7($textFieldValue$delegate)).length() <= $state.getMaxLength();
                ComposerKt.sourceInformationMarkerStart($composer, 2012360423, "CC(remember):EditTextBottomSheet.kt#9igjgp");
                invalid$iv = $composer.changed($onConfirm);
                it$iv = $composer.rememberedValue();
                if (!invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function0() { // from class: kntr.app.tribee.repost.page.editTextBottomSheet.EditTextBottomSheetKt$$ExternalSyntheticLambda8
                        public final Object invoke() {
                            Unit EditTextBottomSheet$lambda$10$2$0$4$0;
                            EditTextBottomSheet$lambda$10$2$0$4$0 = EditTextBottomSheetKt.EditTextBottomSheet$lambda$10$2$0$4$0($onConfirm, mutableState);
                            return EditTextBottomSheet$lambda$10$2$0$4$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv3);
                    it$iv = value$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                ButtonKt.Button((Function0) it$iv, modifier2, z, shape, buttonColors, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-423075133, true, new Function3() { // from class: kntr.app.tribee.repost.page.editTextBottomSheet.EditTextBottomSheetKt$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit EditTextBottomSheet$lambda$10$2$0$5;
                        EditTextBottomSheet$lambda$10$2$0$5 = EditTextBottomSheetKt.EditTextBottomSheet$lambda$10$2$0$5(EditTextBottomSheetState.this, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return EditTextBottomSheet$lambda$10$2$0$5;
                    }
                }, $composer, 54), $composer, 805306416, (int) KScreenAdjustUtilsKt.CONTAINER_FUNCTION_MAX_WIDTH);
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
            mutableState = $textFieldValue$delegate;
            value$iv2 = new Function1() { // from class: kntr.app.tribee.repost.page.editTextBottomSheet.EditTextBottomSheetKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj) {
                    Unit EditTextBottomSheet$lambda$10$2$0$2$0$0;
                    EditTextBottomSheet$lambda$10$2$0$2$0$0 = EditTextBottomSheetKt.EditTextBottomSheet$lambda$10$2$0$2$0$0($onTextChange, mutableState, (TextFieldValue) obj);
                    return EditTextBottomSheet$lambda$10$2$0$2$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            BasicTextFieldKt.BasicTextField(EditTextBottomSheet$lambda$7, (Function1) value$iv2, focusRequester, false, false, textStyle, keyboardOptions, (KeyboardActions) null, false, 0, 0, (VisualTransformation) null, (Function1) null, (MutableInteractionSource) null, solidColor, ComposableLambdaKt.rememberComposableLambda(-818141226, true, new Function3() { // from class: kntr.app.tribee.repost.page.editTextBottomSheet.EditTextBottomSheetKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit EditTextBottomSheet$lambda$10$2$0$2$1;
                    EditTextBottomSheet$lambda$10$2$0$2$1 = EditTextBottomSheetKt.EditTextBottomSheet$lambda$10$2$0$2$1(EditTextBottomSheetState.this, mutableState, (Function2) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return EditTextBottomSheet$lambda$10$2$0$2$1;
                }
            }, $composer, 54), $composer, 1572864, 196608, 16280);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer, 6);
            Modifier modifier$iv42 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv32 = Arrangement.INSTANCE.getEnd();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, str);
            Alignment.Vertical verticalAlignment$iv32 = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv52 = RowKt.rowMeasurePolicy(horizontalArrangement$iv32, verticalAlignment$iv32, $composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            int $changed$iv$iv52 = (54 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv52 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv52 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv52 = ComposedModifierKt.materializeModifier($composer, modifier$iv42);
            Function0 factory$iv$iv$iv102 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv52 = (($changed$iv$iv52 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, str2);
            if (!($composer.getApplier() instanceof Applier)) {
            }
            $composer.startReusableNode();
            if (!$composer.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv52 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, measurePolicy$iv52, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, localMap$iv$iv52, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv52, Integer.valueOf(compositeKeyHash$iv$iv52), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv52, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, materialized$iv$iv52, ComposeUiNode.Companion.getSetModifier());
            int i92 = ($changed$iv$iv$iv52 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope22 = RowScopeInstance.INSTANCE;
            int i102 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 447141798, "C250@10164L219:EditTextBottomSheet.kt#rpfy70");
            if (getTextWithoutComposition(EditTextBottomSheet$lambda$7($textFieldValue$delegate)).length() <= $state.getMaxLength()) {
            }
            if (isOverLimit) {
            }
            if (!isOverLimit) {
            }
            $composer.endReplaceGroup();
            TextKt.Text-Nvy7gAk(displayText, (Modifier) null, j, (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 24576, 0, 262122);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), $composer, 6);
            Modifier modifier22 = SizeKt.height-3ABfNKs(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(0), 0.0f, 2, (Object) null), Dp.constructor-impl(44));
            ButtonColors buttonColors2 = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText_white-0d7_KjU(), $composer, ButtonDefaults.$stable << 12, 0);
            Shape shape2 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(22));
            if (StringsKt.isBlank(getTextWithoutComposition(EditTextBottomSheet$lambda$7($textFieldValue$delegate)))) {
            }
            ComposerKt.sourceInformationMarkerStart($composer, 2012360423, "CC(remember):EditTextBottomSheet.kt#9igjgp");
            invalid$iv = $composer.changed($onConfirm);
            it$iv = $composer.rememberedValue();
            if (!invalid$iv) {
            }
            Object value$iv32 = new Function0() { // from class: kntr.app.tribee.repost.page.editTextBottomSheet.EditTextBottomSheetKt$$ExternalSyntheticLambda8
                public final Object invoke() {
                    Unit EditTextBottomSheet$lambda$10$2$0$4$0;
                    EditTextBottomSheet$lambda$10$2$0$4$0 = EditTextBottomSheetKt.EditTextBottomSheet$lambda$10$2$0$4$0($onConfirm, mutableState);
                    return EditTextBottomSheet$lambda$10$2$0$4$0;
                }
            };
            $composer.updateRememberedValue(value$iv32);
            it$iv = value$iv32;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) it$iv, modifier22, z, shape2, buttonColors2, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-423075133, true, new Function3() { // from class: kntr.app.tribee.repost.page.editTextBottomSheet.EditTextBottomSheetKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit EditTextBottomSheet$lambda$10$2$0$5;
                    EditTextBottomSheet$lambda$10$2$0$5 = EditTextBottomSheetKt.EditTextBottomSheet$lambda$10$2$0$5(EditTextBottomSheetState.this, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return EditTextBottomSheet$lambda$10$2$0$5;
                }
            }, $composer, 54), $composer, 805306416, (int) KScreenAdjustUtilsKt.CONTAINER_FUNCTION_MAX_WIDTH);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditTextBottomSheet$lambda$10$2$0$0$0$0(Function1 $onDismiss, MutableState $textFieldValue$delegate) {
        $onDismiss.invoke(getTextWithoutComposition(EditTextBottomSheet$lambda$7($textFieldValue$delegate)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditTextBottomSheet$lambda$10$2$0$2$0$0(Function1 $onTextChange, MutableState $textFieldValue$delegate, TextFieldValue newTextFieldValue) {
        Intrinsics.checkNotNullParameter(newTextFieldValue, "newTextFieldValue");
        $textFieldValue$delegate.setValue(newTextFieldValue);
        $onTextChange.invoke(getTextWithoutComposition(EditTextBottomSheet$lambda$7($textFieldValue$delegate)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditTextBottomSheet$lambda$10$2$0$2$1(EditTextBottomSheetState $state, MutableState $textFieldValue$delegate, Function2 innerTextField, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
        ComposerKt.sourceInformation($composer, "CN(innerTextField)214@8575L795:EditTextBottomSheet.kt#rpfy70");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changedInstance(innerTextField) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-818141226, $dirty, -1, "kntr.app.tribee.repost.page.editTextBottomSheet.EditTextBottomSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (EditTextBottomSheet.kt:214)");
            }
            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (6 << 3) & 112;
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
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 3776658, "C228@9324L16:EditTextBottomSheet.kt#rpfy70");
            if (EditTextBottomSheet$lambda$7($textFieldValue$delegate).getText().length() == 0) {
                $composer.startReplaceGroup(3808773);
                ComposerKt.sourceInformation($composer, "224@9159L6,218@8784L473");
                TextKt.Text-Nvy7gAk($state.getPlaceholder(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, new TextStyle(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), TextUnitKt.getSp(14), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(24), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646140, (DefaultConstructorMarker) null), $composer, 0, 0, 131070);
            } else {
                $composer.startReplaceGroup(-4885146);
            }
            $composer.endReplaceGroup();
            innerTextField.invoke($composer, Integer.valueOf($dirty & 14));
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
    public static final Unit EditTextBottomSheet$lambda$10$2$0$4$0(Function1 $onConfirm, MutableState $textFieldValue$delegate) {
        $onConfirm.invoke(getTextWithoutComposition(EditTextBottomSheet$lambda$7($textFieldValue$delegate)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditTextBottomSheet$lambda$10$2$0$5(EditTextBottomSheetState $state, RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C282@11698L6,278@11505L233:EditTextBottomSheet.kt#rpfy70");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-423075133, $changed, -1, "kntr.app.tribee.repost.page.editTextBottomSheet.EditTextBottomSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous> (EditTextBottomSheet.kt:278)");
            }
            TextKt.Text-Nvy7gAk($state.getButtonText(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(16), (FontStyle) null, FontWeight.Companion.getW400(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 1597440, 0, 262058);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}