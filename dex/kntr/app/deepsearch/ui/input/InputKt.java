package kntr.app.deepsearch.ui.input;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextFieldStateKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.LongState;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.PageStyle;
import kntr.app.deepsearch.base.model.input.InputState;
import kntr.app.deepsearch.base.model.input.InputStringHolder;
import kntr.app.deepsearch.base.model.input.SenderStatus;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.compose.resources.ImageResourcesKt;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.app.deepsearch.compose.generated.resources.Drawable0_commonMainKt;
import srcs.app.deepsearch.compose.generated.resources.Res;
import srcs.app.deepsearch.compose.generated.resources.String0_commonMainKt;

/* compiled from: Input.kt */
@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aC\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\r\u001a)\u0010\u000e\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u0013\u001a5\u0010\u0014\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bH\u0003¢\u0006\u0002\u0010\u0016\u001a\u000e\u0010\u0017\u001a\u0004\u0018\u00010\u0018*\u00020\u0019H\u0002\u001a3\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00192\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00010\u000b2\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u001e\u001a?\u0010\u001f\u001a\u00020\t*\u00020\t2\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(¢\u0006\u0004\b)\u0010*¨\u0006+²\u0006\n\u0010,\u001a\u00020-X\u008a\u008e\u0002²\u0006\n\u0010.\u001a\u00020\u0003X\u008a\u0084\u0002²\u0006\n\u0010/\u001a\u00020(X\u008a\u0084\u0002²\u0006\f\u00100\u001a\u0004\u0018\u000101X\u008a\u008e\u0002²\u0006\n\u00102\u001a\u00020\u0019X\u008a\u008e\u0002²\u0006\n\u00103\u001a\u00020%X\u008a\u0084\u0002²\u0006\n\u00102\u001a\u00020\u0019X\u008a\u008e\u0002²\u0006\n\u00104\u001a\u00020#X\u008a\u0084\u0002²\u0006\n\u0010'\u001a\u00020(X\u008a\u0084\u0002²\u0006\n\u0010$\u001a\u00020%X\u008a\u0084\u0002²\u0006\n\u00105\u001a\u00020(X\u008a\u0084\u0002"}, d2 = {"Input", RoomRecommendViewModel.EMPTY_CURSOR, "isShowDialog", RoomRecommendViewModel.EMPTY_CURSOR, "inputState", "Lkntr/app/deepsearch/base/model/input/InputState;", "pageStyle", "Lkntr/app/deepsearch/base/model/biz/PageStyle;", "modifier", "Landroidx/compose/ui/Modifier;", "actionHandler", "Lkotlin/Function1;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$InputAction;", "(ZLkntr/app/deepsearch/base/model/input/InputState;Lkntr/app/deepsearch/base/model/biz/PageStyle;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "InputLengthText", "Landroidx/compose/foundation/layout/BoxScope;", "hasFocus", "input", RoomRecommendViewModel.EMPTY_CURSOR, "(Landroidx/compose/foundation/layout/BoxScope;ZLjava/lang/String;Lkntr/app/deepsearch/base/model/input/InputState;Landroidx/compose/runtime/Composer;I)V", "SenderBox", "showCursor", "(Landroidx/compose/foundation/layout/BoxScope;Lkntr/app/deepsearch/base/model/input/InputState;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "style", "Lkntr/app/deepsearch/ui/input/SenderStyle;", "Lkntr/app/deepsearch/ui/input/SenderStatusNullable;", "Sender", AdAlarmExtraKey.STATUS, "onClick", "Lkntr/app/deepsearch/base/model/input/SenderStatus;", "(Lkntr/app/deepsearch/ui/input/SenderStatusNullable;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "textFieldVerticalScrollbar", "scrollState", "Landroidx/compose/foundation/ScrollState;", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "width", "Landroidx/compose/ui/unit/Dp;", "offsetX", "alpha", RoomRecommendViewModel.EMPTY_CURSOR, "textFieldVerticalScrollbar-HgIXhM4", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;JFFF)Landroidx/compose/ui/Modifier;", "compose_debug", "inputVersion", RoomRecommendViewModel.EMPTY_CURSOR, "showScrollbar", "scrollbarAlpha", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "lastStatus", "padding", "color", "angle"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InputKt {

    /* compiled from: Input.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SenderStatus.values().length];
            try {
                iArr[SenderStatus.SESSION_LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SenderStatus.SEND_DISALLOW.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SenderStatus.SEND_ALLOW.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[SenderStatus.STOP_ACTION.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SenderStatusNullable.values().length];
            try {
                iArr2[SenderStatusNullable.SEND_ALLOW.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr2[SenderStatusNullable.SEND_DISALLOW.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr2[SenderStatusNullable.STOP_ACTION.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr2[SenderStatusNullable.SESSION_LOADING.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr2[SenderStatusNullable.GONE.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Input$lambda$16(boolean z, InputState inputState, PageStyle pageStyle, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        Input(z, inputState, pageStyle, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputLengthText$lambda$1(BoxScope boxScope, boolean z, String str, InputState inputState, int i, Composer composer, int i2) {
        InputLengthText(boxScope, z, str, inputState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Sender$lambda$11(SenderStatusNullable senderStatusNullable, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        Sender(senderStatusNullable, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Sender$lambda$4(SenderStatusNullable senderStatusNullable, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        Sender(senderStatusNullable, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SenderBox$lambda$6(BoxScope boxScope, InputState inputState, boolean z, Function1 function1, int i, Composer composer, int i2) {
        SenderBox(boxScope, inputState, z, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x03b2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x04e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Input(final boolean isShowDialog, final InputState inputState, final PageStyle pageStyle, Modifier modifier, final Function1<? super DeepSearchAction.InputAction, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int $dirty;
        Modifier modifier3;
        boolean z;
        long hintColor;
        boolean invalid$iv;
        Object it$iv;
        Object it$iv2;
        Object it$iv3;
        DefaultConstructorMarker defaultConstructorMarker;
        boolean isNotSessionLoading;
        long j2;
        long j3;
        Object it$iv4;
        Intrinsics.checkNotNullParameter(inputState, "inputState");
        Intrinsics.checkNotNullParameter(pageStyle, "pageStyle");
        Intrinsics.checkNotNullParameter(function1, "actionHandler");
        Composer $composer2 = $composer.startRestartGroup(-257522779);
        ComposerKt.sourceInformation($composer2, "C(Input)N(isShowDialog,inputState,pageStyle,modifier,actionHandler)86@4021L24,93@4219L47,97@4318L209,97@4272L255,116@4912L85,116@4882L115,121@5032L49,125@5113L102,125@5087L128,131@5243L21,133@5309L340,133@5270L379,143@5687L59,147@5773L98,153@5899L64,155@5989L64,172@6596L9,261@10495L50,162@6249L4303:Input.kt#t8834");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(isShowDialog) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(inputState) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(pageStyle) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty2 |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 16384 : 8192;
        }
        if (!$composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $dirty = $dirty2;
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-257522779, $dirty2, -1, "kntr.app.deepsearch.ui.input.Input (Input.kt:85)");
            }
            TextFieldState textState = TextFieldStateKt.rememberTextFieldState-Le-punE((String) null, 0L, $composer2, 0, 3);
            ComposerKt.sourceInformationMarkerStart($composer2, 1628725108, "CC(remember):Input.kt#9igjgp");
            Object it$iv5 = $composer2.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotLongStateKt.mutableLongStateOf(0L);
                $composer2.updateRememberedValue(value$iv);
                it$iv5 = value$iv;
            }
            MutableLongState inputVersion$delegate = (MutableLongState) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CharSequence text = textState.getText();
            ComposerKt.sourceInformationMarkerStart($composer2, 1628728438, "CC(remember):Input.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(textState) | ((57344 & $dirty2) == 16384);
            Object it$iv6 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv6 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new InputKt$Input$1$1(function1, textState, inputVersion$delegate, null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv6 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(text, function1, (Function2) it$iv6, $composer2, ($dirty2 >> 9) & 112);
            if (inputState.getInput().length() > 0) {
                $composer2.startReplaceGroup(-1048783842);
                $composer2.endReplaceGroup();
                z = true;
            } else {
                $composer2.startReplaceGroup(1628736775);
                ComposerKt.sourceInformation($composer2, "107@4584L12");
                z = ImeVisibleKt.imeVisible($composer2, 0) && !isShowDialog;
                $composer2.endReplaceGroup();
            }
            boolean showCursor = z;
            if (showCursor) {
                $composer2.startReplaceGroup(-1048687793);
                ComposerKt.sourceInformation($composer2, "110@4688L6");
                long j4 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText4-0d7_KjU();
                $composer2.endReplaceGroup();
                hintColor = j4;
            } else {
                $composer2.startReplaceGroup(-1048636209);
                ComposerKt.sourceInformation($composer2, "112@4740L6");
                long j5 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU();
                $composer2.endReplaceGroup();
                hintColor = j5;
            }
            float topPadding = showCursor ? Dp.constructor-impl(12) : Dp.constructor-impl(10);
            float bottomPadding = showCursor ? Dp.constructor-impl(58) : Dp.constructor-impl(10);
            Dp dp = Dp.box-impl(bottomPadding);
            ComposerKt.sourceInformationMarkerStart($composer2, 1628747322, "CC(remember):Input.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changed(bottomPadding) | $composer2.changed(showCursor);
            InputKt$Input$2$1 value$iv3 = $composer2.rememberedValue();
            if (invalid$iv3 || value$iv3 == Composer.Companion.getEmpty()) {
                value$iv3 = new InputKt$Input$2$1(bottomPadding, showCursor, null);
                $composer2.updateRememberedValue(value$iv3);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(dp, (Function2) value$iv3, $composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, 1628751126, "CC(remember):Input.kt#9igjgp");
            Object it$iv7 = $composer2.rememberedValue();
            if (it$iv7 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new FocusRequester();
                $composer2.updateRememberedValue(value$iv4);
                it$iv7 = value$iv4;
            }
            FocusRequester focusRequester = (FocusRequester) it$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1628753771, "CC(remember):Input.kt#9igjgp");
            boolean invalid$iv4 = $composer2.changedInstance(pageStyle);
            Object it$iv8 = $composer2.rememberedValue();
            if (!invalid$iv4 && it$iv8 != Composer.Companion.getEmpty()) {
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(pageStyle, (Function2) it$iv8, $composer2, ($dirty2 >> 6) & 14);
                final ScrollState scrollableState = ScrollKt.rememberScrollState(0, $composer2, 0, 1);
                InputStringHolder inputHolder = inputState.getInputHolder();
                ComposerKt.sourceInformationMarkerStart($composer2, 1628760281, "CC(remember):Input.kt#9igjgp");
                invalid$iv = $composer2.changedInstance(inputState) | $composer2.changed(textState);
                Object it$iv9 = $composer2.rememberedValue();
                if (invalid$iv) {
                    $dirty = $dirty2;
                    if (it$iv9 != Composer.Companion.getEmpty()) {
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        EffectsKt.LaunchedEffect(inputHolder, (Function2) it$iv9, $composer2, 0);
                        ComposerKt.sourceInformationMarkerStart($composer2, 1628772096, "CC(remember):Input.kt#9igjgp");
                        it$iv = $composer2.rememberedValue();
                        if (it$iv == Composer.Companion.getEmpty()) {
                            Object value$iv5 = InteractionSourceKt.MutableInteractionSource();
                            $composer2.updateRememberedValue(value$iv5);
                            it$iv = value$iv5;
                        }
                        MutableInteractionSource interactionSource = (MutableInteractionSource) it$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerStart($composer2, 1628774887, "CC(remember):Input.kt#9igjgp");
                        it$iv2 = $composer2.rememberedValue();
                        if (it$iv2 == Composer.Companion.getEmpty()) {
                            Object value$iv6 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.deepsearch.ui.input.InputKt$$ExternalSyntheticLambda0
                                public final Object invoke() {
                                    boolean isScrollInProgress;
                                    isScrollInProgress = scrollableState.isScrollInProgress();
                                    return Boolean.valueOf(isScrollInProgress);
                                }
                            });
                            $composer2.updateRememberedValue(value$iv6);
                            it$iv2 = value$iv6;
                        }
                        State showScrollbar$delegate = (State) it$iv2;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        State scrollbarAlpha$delegate = AnimateAsStateKt.animateFloatAsState(Input$lambda$10(showScrollbar$delegate) ? 1.0f : 0.0f, (AnimationSpec) null, 0.0f, (String) null, (Function1) null, $composer2, 0, 30);
                        ComposerKt.sourceInformationMarkerStart($composer2, 1628781765, "CC(remember):Input.kt#9igjgp");
                        it$iv3 = $composer2.rememberedValue();
                        if (it$iv3 == Composer.Companion.getEmpty()) {
                            defaultConstructorMarker = null;
                            Object value$iv7 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                            $composer2.updateRememberedValue(value$iv7);
                            it$iv3 = value$iv7;
                        } else {
                            defaultConstructorMarker = null;
                        }
                        final MutableState layoutResult$delegate = (MutableState) it$iv3;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        isNotSessionLoading = inputState.getSenderStatus() != SenderStatus.SESSION_LOADING;
                        boolean clearShow = !(textState.getText().length() > 0) && showCursor && isNotSessionLoading;
                        Modifier focusRequester2 = FocusRequesterModifierKt.focusRequester(modifier3, focusRequester);
                        TextStyle t14 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14();
                        if (isNotSessionLoading) {
                            $composer2.startReplaceGroup(-1046682217);
                            ComposerKt.sourceInformation($composer2, "175@6721L6");
                            long j6 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU();
                            $composer2.endReplaceGroup();
                            j2 = j6;
                        } else {
                            $composer2.startReplaceGroup(-1046606825);
                            ComposerKt.sourceInformation($composer2, "177@6797L6");
                            long j7 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU();
                            $composer2.endReplaceGroup();
                            j2 = j7;
                        }
                        TextStyle textStyle = TextStyle.copy-p1EtxEg$default(t14, j2, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null);
                        if (showCursor) {
                            $composer2.startReplaceGroup(1628813999);
                            ComposerKt.sourceInformation($composer2, "183@6991L6");
                            j3 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                            $composer2.endReplaceGroup();
                        } else {
                            $composer2.startReplaceGroup(1628814704);
                            $composer2.endReplaceGroup();
                            j3 = Color.Companion.getTransparent-0d7_KjU();
                        }
                        Brush solidColor = new SolidColor(j3, defaultConstructorMarker);
                        InputKt$Input$5 inputKt$Input$5 = new InputKt$Input$5(topPadding, bottomPadding, scrollableState, clearShow, showCursor, textState, inputState, function1, scrollbarAlpha$delegate, hintColor, focusRequester);
                        ComposerKt.sourceInformationMarkerStart($composer2, 1628925943, "CC(remember):Input.kt#9igjgp");
                        it$iv4 = $composer2.rememberedValue();
                        if (it$iv4 == Composer.Companion.getEmpty()) {
                            Object value$iv8 = new Function2() { // from class: kntr.app.deepsearch.ui.input.InputKt$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit Input$lambda$15$0;
                                    Input$lambda$15$0 = InputKt.Input$lambda$15$0(layoutResult$delegate, (Density) obj, (Function0) obj2);
                                    return Input$lambda$15$0;
                                }
                            };
                            $composer2.updateRememberedValue(value$iv8);
                            it$iv4 = value$iv8;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        BasicTextFieldKt.BasicTextField(textState, focusRequester2, isNotSessionLoading, false, (InputTransformation) null, textStyle, (KeyboardOptions) null, (KeyboardActionHandler) null, (TextFieldLineLimits) null, (Function2) it$iv4, interactionSource, solidColor, (OutputTransformation) null, inputKt$Input$5, scrollableState, $composer2, 805306368, 6, 4568);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                    }
                } else {
                    $dirty = $dirty2;
                }
                Object value$iv9 = (Function2) new InputKt$Input$4$1(inputState, textState, inputVersion$delegate, null);
                $composer2.updateRememberedValue(value$iv9);
                it$iv9 = value$iv9;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(inputHolder, (Function2) it$iv9, $composer2, 0);
                ComposerKt.sourceInformationMarkerStart($composer2, 1628772096, "CC(remember):Input.kt#9igjgp");
                it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                }
                MutableInteractionSource interactionSource2 = (MutableInteractionSource) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, 1628774887, "CC(remember):Input.kt#9igjgp");
                it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                }
                State showScrollbar$delegate2 = (State) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                State scrollbarAlpha$delegate2 = AnimateAsStateKt.animateFloatAsState(Input$lambda$10(showScrollbar$delegate2) ? 1.0f : 0.0f, (AnimationSpec) null, 0.0f, (String) null, (Function1) null, $composer2, 0, 30);
                ComposerKt.sourceInformationMarkerStart($composer2, 1628781765, "CC(remember):Input.kt#9igjgp");
                it$iv3 = $composer2.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                }
                final MutableState layoutResult$delegate2 = (MutableState) it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                isNotSessionLoading = inputState.getSenderStatus() != SenderStatus.SESSION_LOADING;
                if (textState.getText().length() > 0) {
                }
                Modifier focusRequester22 = FocusRequesterModifierKt.focusRequester(modifier3, focusRequester);
                TextStyle t142 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14();
                if (isNotSessionLoading) {
                }
                TextStyle textStyle2 = TextStyle.copy-p1EtxEg$default(t142, j2, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null);
                if (showCursor) {
                }
                Brush solidColor2 = new SolidColor(j3, defaultConstructorMarker);
                InputKt$Input$5 inputKt$Input$52 = new InputKt$Input$5(topPadding, bottomPadding, scrollableState, clearShow, showCursor, textState, inputState, function1, scrollbarAlpha$delegate2, hintColor, focusRequester);
                ComposerKt.sourceInformationMarkerStart($composer2, 1628925943, "CC(remember):Input.kt#9igjgp");
                it$iv4 = $composer2.rememberedValue();
                if (it$iv4 == Composer.Companion.getEmpty()) {
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                BasicTextFieldKt.BasicTextField(textState, focusRequester22, isNotSessionLoading, false, (InputTransformation) null, textStyle2, (KeyboardOptions) null, (KeyboardActionHandler) null, (TextFieldLineLimits) null, (Function2) it$iv4, interactionSource2, solidColor2, (OutputTransformation) null, inputKt$Input$52, scrollableState, $composer2, 805306368, 6, 4568);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = modifier3;
            }
            Object value$iv10 = (Function2) new InputKt$Input$3$1(pageStyle, focusRequester, null);
            $composer2.updateRememberedValue(value$iv10);
            it$iv8 = value$iv10;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(pageStyle, (Function2) it$iv8, $composer2, ($dirty2 >> 6) & 14);
            final ScrollState scrollableState2 = ScrollKt.rememberScrollState(0, $composer2, 0, 1);
            InputStringHolder inputHolder2 = inputState.getInputHolder();
            ComposerKt.sourceInformationMarkerStart($composer2, 1628760281, "CC(remember):Input.kt#9igjgp");
            invalid$iv = $composer2.changedInstance(inputState) | $composer2.changed(textState);
            Object it$iv92 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv92 = (Function2) new InputKt$Input$4$1(inputState, textState, inputVersion$delegate, null);
            $composer2.updateRememberedValue(value$iv92);
            it$iv92 = value$iv92;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(inputHolder2, (Function2) it$iv92, $composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, 1628772096, "CC(remember):Input.kt#9igjgp");
            it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
            }
            MutableInteractionSource interactionSource22 = (MutableInteractionSource) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1628774887, "CC(remember):Input.kt#9igjgp");
            it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
            }
            State showScrollbar$delegate22 = (State) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            State scrollbarAlpha$delegate22 = AnimateAsStateKt.animateFloatAsState(Input$lambda$10(showScrollbar$delegate22) ? 1.0f : 0.0f, (AnimationSpec) null, 0.0f, (String) null, (Function1) null, $composer2, 0, 30);
            ComposerKt.sourceInformationMarkerStart($composer2, 1628781765, "CC(remember):Input.kt#9igjgp");
            it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
            }
            final MutableState layoutResult$delegate22 = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            isNotSessionLoading = inputState.getSenderStatus() != SenderStatus.SESSION_LOADING;
            if (textState.getText().length() > 0) {
            }
            Modifier focusRequester222 = FocusRequesterModifierKt.focusRequester(modifier3, focusRequester);
            TextStyle t1422 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14();
            if (isNotSessionLoading) {
            }
            TextStyle textStyle22 = TextStyle.copy-p1EtxEg$default(t1422, j2, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null);
            if (showCursor) {
            }
            Brush solidColor22 = new SolidColor(j3, defaultConstructorMarker);
            InputKt$Input$5 inputKt$Input$522 = new InputKt$Input$5(topPadding, bottomPadding, scrollableState2, clearShow, showCursor, textState, inputState, function1, scrollbarAlpha$delegate22, hintColor, focusRequester);
            ComposerKt.sourceInformationMarkerStart($composer2, 1628925943, "CC(remember):Input.kt#9igjgp");
            it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            BasicTextFieldKt.BasicTextField(textState, focusRequester222, isNotSessionLoading, false, (InputTransformation) null, textStyle22, (KeyboardOptions) null, (KeyboardActionHandler) null, (TextFieldLineLimits) null, (Function2) it$iv4, interactionSource22, solidColor22, (OutputTransformation) null, inputKt$Input$522, scrollableState2, $composer2, 805306368, 6, 4568);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.input.InputKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Input$lambda$16;
                    Input$lambda$16 = InputKt.Input$lambda$16(isShowDialog, inputState, pageStyle, modifier4, function1, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Input$lambda$16;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long Input$lambda$1(MutableLongState $inputVersion$delegate) {
        LongState $this$getValue$iv = (LongState) $inputVersion$delegate;
        return $this$getValue$iv.getLongValue();
    }

    private static final boolean Input$lambda$10(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Input$lambda$11(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    private static final TextLayoutResult Input$lambda$13(MutableState<TextLayoutResult> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (TextLayoutResult) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Input$lambda$15$0(MutableState $layoutResult$delegate, Density $this$BasicTextField, Function0 it) {
        Intrinsics.checkNotNullParameter($this$BasicTextField, "$this$BasicTextField");
        Intrinsics.checkNotNullParameter(it, "it");
        $layoutResult$delegate.setValue((TextLayoutResult) it.invoke());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:67:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x026a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void InputLengthText(final BoxScope $this$InputLengthText, final boolean hasFocus, final String input, final InputState inputState, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        long j2;
        Composer $composer2 = $composer.startRestartGroup(-1912697410);
        ComposerKt.sourceInformation($composer2, "C(InputLengthText)N(hasFocus,input,inputState):Input.kt#t8834");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed($this$InputLengthText) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(hasFocus) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(input) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(inputState) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1912697410, $dirty2, -1, "kntr.app.deepsearch.ui.input.InputLengthText (Input.kt:272)");
            }
            float height = hasFocus ? Dp.constructor-impl(30) : Dp.constructor-impl(20);
            if (hasFocus) {
                $composer2.startReplaceGroup(162772504);
                ComposerKt.sourceInformation($composer2, "275@10756L924");
                Modifier modifier$iv = $this$InputLengthText.align(SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0(Modifier.Companion, Dp.constructor-impl(16), Dp.constructor-impl(10), Dp.constructor-impl(8), Dp.constructor-impl(8)), height), Alignment.Companion.getBottomStart());
                Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv2;
                    $composer2.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv2;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i2 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -1227898753, "C288@11186L129,294@11398L9,292@11329L341:Input.kt#t8834");
                int maxInputLength = inputState.getMaxInputLength();
                ComposerKt.sourceInformationMarkerStart($composer2, 1345864414, "CC(remember):Input.kt#9igjgp");
                boolean invalid$iv = (($dirty2 & 896) == 256) | $composer2.changed(maxInputLength);
                Object it$iv = $composer2.rememberedValue();
                if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                    String text = (String) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    TextStyle t12 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12();
                    if (input.length() > inputState.getMaxInputLength()) {
                        $composer2.startReplaceGroup(-1227562497);
                        ComposerKt.sourceInformation($composer2, "297@11540L6");
                        long j3 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU();
                        $composer2.endReplaceGroup();
                        j2 = j3;
                    } else {
                        $composer2.startReplaceGroup(-1227486950);
                        ComposerKt.sourceInformation($composer2, "299@11616L6");
                        long j4 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getStress_red-0d7_KjU();
                        $composer2.endReplaceGroup();
                        j2 = j4;
                    }
                    TextKt.Text-Nvy7gAk(text, (Modifier) null, j2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t12, $composer2, 0, 0, 131066);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                }
                Object value$iv = input.length() + "/" + inputState.getMaxInputLength();
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
                String text2 = (String) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                TextStyle t122 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12();
                if (input.length() > inputState.getMaxInputLength()) {
                }
                TextKt.Text-Nvy7gAk(text2, (Modifier) null, j2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t122, $composer2, 0, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                $composer2.startReplaceGroup(152082340);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.input.InputKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit InputLengthText$lambda$1;
                    InputLengthText$lambda$1 = InputKt.InputLengthText$lambda$1($this$InputLengthText, hasFocus, input, inputState, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return InputLengthText$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SenderBox(final BoxScope $this$SenderBox, final InputState inputState, final boolean showCursor, final Function1<? super DeepSearchAction.InputAction, Unit> function1, Composer $composer, final int $changed) {
        SenderStatusNullable target;
        SenderStatusNullable out;
        Composer $composer2 = $composer.startRestartGroup(-1319845285);
        ComposerKt.sourceInformation($composer2, "C(SenderBox)N(inputState,showCursor,actionHandler)312@11855L66,317@11948L1124,342@13092L48,344@13199L7,355@13501L195,346@13212L484:Input.kt#t8834");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed($this$SenderBox) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(inputState) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(showCursor) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1319845285, $dirty2, -1, "kntr.app.deepsearch.ui.input.SenderBox (Input.kt:311)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1355961859, "CC(remember):Input.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(SenderStatusNullable.GONE, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableState lastStatus$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SenderStatus senderStatus = inputState.getSenderStatus();
            String input = inputState.getInput();
            ComposerKt.sourceInformationMarkerStart($composer2, -1355957825, "CC(remember):Input.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(senderStatus.ordinal()) | (($dirty2 & 896) == 256) | $composer2.changed(input);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                if (!showCursor && inputState.getSenderStatus() != SenderStatus.STOP_ACTION) {
                    target = SenderStatusNullable.GONE;
                } else {
                    switch (WhenMappings.$EnumSwitchMapping$0[inputState.getSenderStatus().ordinal()]) {
                        case 1:
                            target = SenderStatusNullable.SESSION_LOADING;
                            break;
                        case 2:
                            target = SenderStatusNullable.SEND_DISALLOW;
                            break;
                        case 3:
                            target = SenderStatusNullable.SEND_ALLOW;
                            break;
                        case 4:
                            target = SenderStatusNullable.STOP_ACTION;
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                }
                if (SenderBox$lambda$1(lastStatus$delegate) == SenderStatusNullable.STOP_ACTION && target == SenderStatusNullable.SEND_DISALLOW) {
                    if (inputState.getInput().length() == 0) {
                        out = SenderStatusNullable.GONE;
                        SenderStatusNullable $this$SenderBox_u24lambda_u243_u240 = out;
                        lastStatus$delegate.setValue($this$SenderBox_u24lambda_u243_u240);
                        $composer2.updateRememberedValue(out);
                        it$iv2 = out;
                    }
                }
                out = target;
                SenderStatusNullable $this$SenderBox_u24lambda_u243_u2402 = out;
                lastStatus$delegate.setValue($this$SenderBox_u24lambda_u243_u2402);
                $composer2.updateRememberedValue(out);
                it$iv2 = out;
            }
            final SenderStatusNullable status = (SenderStatusNullable) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            State padding$delegate = AnimateAsStateKt.animateDpAsState-AjpBEmI(showCursor ? Dp.constructor-impl(8) : Dp.constructor-impl(5), (AnimationSpec) null, (String) null, (Function1) null, $composer2, 0, 14);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final SoftwareKeyboardController softController = (SoftwareKeyboardController) consume;
            AnimatedVisibilityKt.AnimatedVisibility(status != SenderStatusNullable.GONE, PaddingKt.padding-qDBjuR0$default($this$SenderBox.align(Modifier.Companion, Alignment.Companion.getBottomEnd()), 0.0f, 0.0f, SenderBox$lambda$4(padding$delegate), SenderBox$lambda$4(padding$delegate), 3, (Object) null), EnterExitTransitionKt.fadeIn$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null), EnterExitTransitionKt.fadeOut$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(1193952563, true, new Function3() { // from class: kntr.app.deepsearch.ui.input.InputKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SenderBox$lambda$5;
                    SenderBox$lambda$5 = InputKt.SenderBox$lambda$5(SenderStatusNullable.this, softController, function1, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SenderBox$lambda$5;
                }
            }, $composer2, 54), $composer2, 200064, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.input.InputKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit SenderBox$lambda$6;
                    SenderBox$lambda$6 = InputKt.SenderBox$lambda$6($this$SenderBox, inputState, showCursor, function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return SenderBox$lambda$6;
                }
            });
        }
    }

    private static final SenderStatusNullable SenderBox$lambda$1(MutableState<SenderStatusNullable> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (SenderStatusNullable) $this$getValue$iv.getValue();
    }

    private static final float SenderBox$lambda$4(State<Dp> state) {
        Object thisObj$iv = state.getValue();
        return ((Dp) thisObj$iv).unbox-impl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SenderBox$lambda$5(SenderStatusNullable $status, final SoftwareKeyboardController $softController, final Function1 $actionHandler, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C358@13570L109,356@13511L179:Input.kt#t8834");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1193952563, $changed, -1, "kntr.app.deepsearch.ui.input.SenderBox.<anonymous> (Input.kt:356)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 632147328, "CC(remember):Input.kt#9igjgp");
        boolean invalid$iv = $composer.changed($softController) | $composer.changed($actionHandler);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function1() { // from class: kntr.app.deepsearch.ui.input.InputKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj) {
                    Unit SenderBox$lambda$5$0$0;
                    SenderBox$lambda$5$0$0 = InputKt.SenderBox$lambda$5$0$0($softController, $actionHandler, (SenderStatus) obj);
                    return SenderBox$lambda$5$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Sender($status, (Function1) it$iv, null, $composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SenderBox$lambda$5$0$0(SoftwareKeyboardController $softController, Function1 $actionHandler, SenderStatus it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ($softController != null) {
            $softController.hide();
        }
        $actionHandler.invoke(DeepSearchAction.InputAction.SenderClick.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final SenderStyle style(SenderStatusNullable $this$style) {
        switch (WhenMappings.$EnumSwitchMapping$1[$this$style.ordinal()]) {
            case 1:
                return new SenderStyle(Dp.constructor-impl(66), new Function2<Composer, Integer, Color>() { // from class: kntr.app.deepsearch.ui.input.InputKt$style$1
                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                        return Color.box-impl(m746invokeWaAFU9c((Composer) p1, ((Number) p2).intValue()));
                    }

                    /* renamed from: invoke-WaAFU9c  reason: not valid java name */
                    public final long m746invokeWaAFU9c(Composer $composer, int $changed) {
                        $composer.startReplaceGroup(-699380172);
                        ComposerKt.sourceInformation($composer, "C396@14420L6:Input.kt#t8834");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-699380172, $changed, -1, "kntr.app.deepsearch.ui.input.style.<anonymous> (Input.kt:396)");
                        }
                        long j2 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        $composer.endReplaceGroup();
                        return j2;
                    }
                }, 0.0f, false, false, 28, null);
            case 2:
                return new SenderStyle(Dp.constructor-impl(66), new Function2<Composer, Integer, Color>() { // from class: kntr.app.deepsearch.ui.input.InputKt$style$2
                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                        return Color.box-impl(m747invokeWaAFU9c((Composer) p1, ((Number) p2).intValue()));
                    }

                    /* renamed from: invoke-WaAFU9c  reason: not valid java name */
                    public final long m747invokeWaAFU9c(Composer $composer, int $changed) {
                        $composer.startReplaceGroup(-657674965);
                        ComposerKt.sourceInformation($composer, "C402@14599L6:Input.kt#t8834");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-657674965, $changed, -1, "kntr.app.deepsearch.ui.input.style.<anonymous> (Input.kt:402)");
                        }
                        long j2 = Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        $composer.endReplaceGroup();
                        return j2;
                    }
                }, 0.4f, false, false, 24, null);
            case 3:
                return new SenderStyle(Dp.constructor-impl(30), new Function2<Composer, Integer, Color>() { // from class: kntr.app.deepsearch.ui.input.InputKt$style$3
                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                        return Color.box-impl(m748invokeWaAFU9c((Composer) p1, ((Number) p2).intValue()));
                    }

                    /* renamed from: invoke-WaAFU9c  reason: not valid java name */
                    public final long m748invokeWaAFU9c(Composer $composer, int $changed) {
                        $composer.startReplaceGroup(142860588);
                        ComposerKt.sourceInformation($composer, "C409@14825L6:Input.kt#t8834");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(142860588, $changed, -1, "kntr.app.deepsearch.ui.input.style.<anonymous> (Input.kt:409)");
                        }
                        long j2 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText4-0d7_KjU();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        $composer.endReplaceGroup();
                        return j2;
                    }
                }, 0.0f, true, false, 20, null);
            case 4:
                return new SenderStyle(Dp.constructor-impl(30), new Function2<Composer, Integer, Color>() { // from class: kntr.app.deepsearch.ui.input.InputKt$style$4
                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                        return Color.box-impl(m749invokeWaAFU9c((Composer) p1, ((Number) p2).intValue()));
                    }

                    /* renamed from: invoke-WaAFU9c  reason: not valid java name */
                    public final long m749invokeWaAFU9c(Composer $composer, int $changed) {
                        $composer.startReplaceGroup(943396141);
                        ComposerKt.sourceInformation($composer, "C416@15034L6:Input.kt#t8834");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(943396141, $changed, -1, "kntr.app.deepsearch.ui.input.style.<anonymous> (Input.kt:416)");
                        }
                        long j2 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText4-0d7_KjU();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        $composer.endReplaceGroup();
                        return j2;
                    }
                }, 0.0f, false, true, 12, null);
            case 5:
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final void Sender(final SenderStatusNullable status, final Function1<? super SenderStatus, Unit> function1, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(status, AdAlarmExtraKey.STATUS);
        Intrinsics.checkNotNullParameter(function1, "onClick");
        Composer $composer3 = $composer.startRestartGroup(650382315);
        ComposerKt.sourceInformation($composer3, "C(Sender)N(status,onClick,modifier)429@15306L66,435@15454L35,435@15432L57,441@15555L12,441@15529L39,442@15586L32,443@15636L29,445@15696L28,446@15768L258,467@16354L67,456@16032L1986:Input.kt#t8834");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(status.ordinal()) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
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
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(650382315, $dirty2, -1, "kntr.app.deepsearch.ui.input.Sender (Input.kt:428)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -2047815827, "CC(remember):Input.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(SenderStatusNullable.GONE, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableState lastStatus$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SenderStyle style = style(status);
            if (style == null) {
                style = style(Sender$lambda$1(lastStatus$delegate));
            }
            SenderStyle style2 = style;
            ComposerKt.sourceInformationMarkerStart($composer3, -2047811122, "CC(remember):Input.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 14) == 4;
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new InputKt$Sender$1$1(status, lastStatus$delegate, null);
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(style2, (Function2) it$iv2, $composer3, 0);
            if (style2 != null) {
                Modifier modifier5 = modifier4;
                State color$delegate = SingleValueAnimationKt.animateColorAsState-euL9pac(((Color) style2.getBackground().invoke($composer3, 0)).unbox-impl(), (AnimationSpec) null, (String) null, (Function1) null, $composer3, 0, 14);
                State alpha$delegate = AnimateAsStateKt.animateFloatAsState(style2.getAlpha(), (AnimationSpec) null, 0.0f, (String) null, (Function1) null, $composer3, 0, 30);
                State width$delegate = AnimateAsStateKt.animateDpAsState-AjpBEmI(style2.m753getWidthD9Ej5fM(), (AnimationSpec) null, (String) null, (Function1) null, $composer3, 0, 14);
                InfiniteTransition infiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition((String) null, $composer3, 0, 1);
                $composer2 = $composer3;
                final State angle$delegate = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 360.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(1500, 0, EasingKt.getLinearEasing(), 2, (Object) null), RepeatMode.Restart, 0L, 4, (Object) null), (String) null, $composer3, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                Modifier alpha = AlphaKt.alpha(BackgroundKt.background-bw27NRU(SizeKt.size-VpY3zN4(modifier5, Sender$lambda$7(width$delegate), Dp.constructor-impl(30)), Sender$lambda$5(color$delegate), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(15))), Sender$lambda$6(alpha$delegate));
                ComposerKt.sourceInformationMarkerStart($composer2, -2047782290, "CC(remember):Input.kt#9igjgp");
                boolean invalid$iv2 = (($dirty2 & 112) == 32) | (($dirty2 & 14) == 4);
                Object it$iv3 = $composer2.rememberedValue();
                if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function0() { // from class: kntr.app.deepsearch.ui.input.InputKt$$ExternalSyntheticLambda9
                        public final Object invoke() {
                            Unit Sender$lambda$9$0;
                            Sender$lambda$9$0 = InputKt.Sender$lambda$9$0(SenderStatusNullable.this, function1);
                            return Sender$lambda$9$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(alpha, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null);
                Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                modifier3 = modifier5;
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv2;
                    $composer2.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv2;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                int i4 = ((48 >> 6) & 112) | 6;
                BoxScope $this$Sender_u24lambda_u2410 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, 1676114182, "C487@16962L600,513@17775L237,507@17571L441:Input.kt#t8834");
                switch (WhenMappings.$EnumSwitchMapping$1[status.ordinal()]) {
                    case 1:
                    case 2:
                        $composer2.startReplaceGroup(1676215923);
                        ComposerKt.sourceInformation($composer2, "477@16659L38,478@16737L6,479@16795L9,476@16626L266");
                        TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getSender_text(Res.string.INSTANCE), $composer2, 0), $this$Sender_u24lambda_u2410.align(Modifier.Companion, Alignment.Companion.getCenter()), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), $composer2, 0, 0, 131064);
                        $composer2.endReplaceGroup();
                        break;
                    default:
                        $composer2.startReplaceGroup(1676507726);
                        $composer2.endReplaceGroup();
                        break;
                }
                AnimatedVisibilityKt.AnimatedVisibility(style2.getStopIcon(), PaddingKt.padding-qDBjuR0$default($this$Sender_u24lambda_u2410.align(Modifier.Companion, Alignment.Companion.getCenterEnd()), 0.0f, 0.0f, Dp.constructor-impl(9), 0.0f, 11, (Object) null), EnterExitTransitionKt.fadeIn$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null), EnterExitTransitionKt.fadeOut$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null), (String) null, ComposableSingletons$InputKt.INSTANCE.m738getLambda$958356275$compose_debug(), $composer2, 200064, 16);
                AnimatedVisibilityKt.AnimatedVisibility(style2.getLoadingIcon(), $this$Sender_u24lambda_u2410.align(Modifier.Companion, Alignment.Companion.getCenter()), EnterExitTransitionKt.fadeIn$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null), EnterExitTransitionKt.fadeOut$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(-1994781770, true, new Function3() { // from class: kntr.app.deepsearch.ui.input.InputKt$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit Sender$lambda$10$0;
                        Sender$lambda$10$0 = InputKt.Sender$lambda$10$0(angle$delegate, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return Sender$lambda$10$0;
                    }
                }, $composer2, 54), $composer2, 200064, 16);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier6 = modifier4;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.input.InputKt$$ExternalSyntheticLambda8
                        public final Object invoke(Object obj, Object obj2) {
                            Unit Sender$lambda$4;
                            Sender$lambda$4 = InputKt.Sender$lambda$4(SenderStatusNullable.this, function1, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return Sender$lambda$4;
                        }
                    });
                    return;
                }
                return;
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier7 = modifier3;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.input.InputKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit Sender$lambda$11;
                    Sender$lambda$11 = InputKt.Sender$lambda$11(SenderStatusNullable.this, function1, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Sender$lambda$11;
                }
            });
        }
    }

    private static final SenderStatusNullable Sender$lambda$1(MutableState<SenderStatusNullable> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (SenderStatusNullable) $this$getValue$iv.getValue();
    }

    private static final long Sender$lambda$5(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).unbox-impl();
    }

    private static final float Sender$lambda$6(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    private static final float Sender$lambda$7(State<Dp> state) {
        Object thisObj$iv = state.getValue();
        return ((Dp) thisObj$iv).unbox-impl();
    }

    private static final float Sender$lambda$8(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Sender$lambda$9$0(SenderStatusNullable $status, Function1 $onClick) {
        SenderStatus origin = $status.getOrigin();
        if (origin != null) {
            $onClick.invoke(origin);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Sender$lambda$10$0(State $angle$delegate, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C515@17822L47,514@17789L213:Input.kt#t8834");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1994781770, $changed, -1, "kntr.app.deepsearch.ui.input.Sender.<anonymous>.<anonymous> (Input.kt:514)");
        }
        ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_sender_loading(Res.drawable.INSTANCE), $composer, 0), "sender_loading", RotateKt.rotate(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), Sender$lambda$8($angle$delegate)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, Painter.$stable | 48, 120);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* renamed from: textFieldVerticalScrollbar-HgIXhM4  reason: not valid java name */
    public static final Modifier m743textFieldVerticalScrollbarHgIXhM4(Modifier $this$textFieldVerticalScrollbar_u2dHgIXhM4, final ScrollState scrollState, final long j2, final float f, final float f2, final float alpha) {
        Intrinsics.checkNotNullParameter($this$textFieldVerticalScrollbar_u2dHgIXhM4, "$this$textFieldVerticalScrollbar");
        Intrinsics.checkNotNullParameter(scrollState, "scrollState");
        return DrawModifierKt.drawWithContent($this$textFieldVerticalScrollbar_u2dHgIXhM4, new Function1() { // from class: kntr.app.deepsearch.ui.input.InputKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit textFieldVerticalScrollbar_HgIXhM4$lambda$0;
                textFieldVerticalScrollbar_HgIXhM4$lambda$0 = InputKt.textFieldVerticalScrollbar_HgIXhM4$lambda$0(scrollState, j2, alpha, f2, f, (ContentDrawScope) obj);
                return textFieldVerticalScrollbar_HgIXhM4$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit textFieldVerticalScrollbar_HgIXhM4$lambda$0(ScrollState $scrollState, long j2, float $alpha, float f, float f2, ContentDrawScope $this$drawWithContent) {
        Intrinsics.checkNotNullParameter($this$drawWithContent, "$this$drawWithContent");
        $this$drawWithContent.drawContent();
        if ($scrollState.getMaxValue() > 0) {
            int bits$iv$iv$iv = (int) ($this$drawWithContent.getSize-NH-jbRc() & 4294967295L);
            float intBitsToFloat = Float.intBitsToFloat(bits$iv$iv$iv);
            int bits$iv$iv$iv2 = (int) ($this$drawWithContent.getSize-NH-jbRc() & 4294967295L);
            int bits$iv$iv$iv3 = (int) ($this$drawWithContent.getSize-NH-jbRc() & 4294967295L);
            float thumbHeight = (intBitsToFloat * Float.intBitsToFloat(bits$iv$iv$iv2)) / RangesKt.coerceAtLeast($scrollState.getMaxValue() + Float.intBitsToFloat(bits$iv$iv$iv3), 20.0f);
            int bits$iv$iv$iv4 = (int) ($this$drawWithContent.getSize-NH-jbRc() & 4294967295L);
            float thumbOffset = ($scrollState.getValue() / $scrollState.getMaxValue()) * (Float.intBitsToFloat(bits$iv$iv$iv4) - thumbHeight);
            long j3 = Color.copy-wmQWz5c$default(j2, $alpha, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            int bits$iv$iv$iv5 = (int) ($this$drawWithContent.getSize-NH-jbRc() >> 32);
            long v1$iv$iv = Float.floatToRawIntBits(Float.intBitsToFloat(bits$iv$iv$iv5) - $this$drawWithContent.toPx-0680j_4(f));
            long v2$iv$iv = Float.floatToRawIntBits(thumbOffset);
            long j4 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
            float width$iv = $this$drawWithContent.toPx-0680j_4(f2);
            long v1$iv$iv2 = Float.floatToRawIntBits(width$iv);
            long v2$iv$iv2 = Float.floatToRawIntBits(thumbHeight);
            long v1$iv$iv3 = Size.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv2 & 4294967295L));
            float x$iv = $this$drawWithContent.toPx-0680j_4(f2) / 2.0f;
            long v1$iv$iv4 = Float.floatToRawIntBits(x$iv);
            long v2$iv$iv3 = Float.floatToRawIntBits(x$iv);
            DrawScope.-CC.drawRoundRect-u-Aw5IA$default((DrawScope) $this$drawWithContent, j3, j4, v1$iv$iv3, CornerRadius.constructor-impl((v1$iv$iv4 << 32) | (4294967295L & v2$iv$iv3)), (DrawStyle) null, 0.0f, (ColorFilter) null, 0, 240, (Object) null);
        }
        return Unit.INSTANCE;
    }
}