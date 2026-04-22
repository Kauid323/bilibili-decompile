package tv.danmaku.bili.stepbystep.sms;

import ComposableSingletons$CustomBottomSheetKt$;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.DividerKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import bili.resource.account.R;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.AnimateLottieCompositionAsStateKt;
import com.airbnb.lottie.compose.LottieAnimationKt;
import com.airbnb.lottie.compose.LottieAnimationState;
import com.airbnb.lottie.compose.LottieCancellationBehavior;
import com.airbnb.lottie.compose.LottieClipSpec;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.airbnb.lottie.compose.LottieCompositionSpec;
import com.airbnb.lottie.compose.LottieDynamicProperties;
import com.airbnb.lottie.compose.RememberLottieCompositionKt;
import com.bilibili.app.comm.list.widget.statement.LittleTVLoadingStateKt;
import com.bilibili.app.comm.list.widget.statement.TVPageState;
import com.bilibili.compose.text.SimpleTextFieldKt;
import com.bilibili.compose.text.TextFieldColors;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.utils.ModifierUtilsKt;
import com.bilibili.compose.widget.BiliCheckBoxShape;
import com.bilibili.droid.ScreenUtil;
import com.bilibili.iconfont.KtxKt;
import com.google.accompanist.drawablepainter.DrawablePainterKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import shark.AndroidResourceIdNames;
import tv.danmaku.android.log.cache.RingBuffer;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.eula.EulaLinkType;
import tv.danmaku.bili.flowcontrol.internal.config.FlowControlConfig;
import tv.danmaku.bili.fullscreen.data.PhoneCountryCode;
import tv.danmaku.bili.fullscreen.page.CommonKt;
import tv.danmaku.bili.normal.SelectCountryCodeFragmentKt;
import tv.danmaku.bili.normal.ui.EulaTriggerType;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.stepbystep.IStepByStepLoginAction;
import tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction;

/* compiled from: StepByStepSmsLoginCompose.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u001aU\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001aa\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00132\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001aC\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u0018\u001a'\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\u001d\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010\u001e\u001ae\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010(H\u0007¢\u0006\u0002\u0010*\u001a\u0015\u0010+\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010,\u001a7\u0010-\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\t2\b\b\u0002\u0010/\u001a\u00020\u00152\u000e\b\u0002\u00100\u001a\b\u0012\u0004\u0012\u00020\u00010(H\u0007¢\u0006\u0002\u00101\u001a-\u00102\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\t2\u000e\b\u0002\u00104\u001a\b\u0012\u0004\u0012\u00020\u00010(H\u0001¢\u0006\u0002\u00105\u001aA\u00106\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u0002072\u0006\u00108\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u00109\u001a/\u0010:\u001a\u00020\u001b*\u00020\u001b2!\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0004\u0012\u00020\u00010\u0005H\u0000¨\u0006?²\u0006\f\u0010@\u001a\u0004\u0018\u00010AX\u008a\u0084\u0002²\u0006\n\u0010B\u001a\u00020CX\u008a\u0084\u0002"}, d2 = {"StepByStepSmsLogin", "", "verticalPaddings", "Ltv/danmaku/bili/stepbystep/sms/StepByStepComposePaddingMap;", "onAction", "Lkotlin/Function1;", "Ltv/danmaku/bili/stepbystep/IStepByStepLoginAction;", "onRouteTo", "Lkotlin/Function2;", "", "Landroid/os/Bundle;", "pageState", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "counting", "", "(Ltv/danmaku/bili/stepbystep/sms/StepByStepComposePaddingMap;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;ILandroidx/compose/runtime/Composer;I)V", "LoginSmsPhonePage", "titleStyle", "Landroidx/compose/ui/text/TextStyle;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginPhonePage;", "enableSwitchToPassword", "", "(Ltv/danmaku/bili/stepbystep/sms/StepByStepComposePaddingMap;Landroidx/compose/ui/text/TextStyle;Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginPhonePage;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/runtime/Composer;II)V", "LoginSmsVerifyPage", "(Ltv/danmaku/bili/stepbystep/sms/StepByStepComposePaddingMap;Landroidx/compose/ui/text/TextStyle;Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;Lkotlin/jvm/functions/Function1;ILandroidx/compose/runtime/Composer;II)V", "LoginPageTitle", "modifier", "Landroidx/compose/ui/Modifier;", "text", "style", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;II)V", "LoginInputPhone", "focusChangeModifier", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "phone", "countryCode", "Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;", "onPhoneInput", "onCountryCodeClick", "Lkotlin/Function0;", "onClearOutPhone", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/focus/FocusRequester;Ljava/lang/String;Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "LoginSubmitButton", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "LoginConfirmButton", "buttonText", "enable", "onClick", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "SwitchLogin", ReportUtilKt.POS_TITLE, "onSwitchClick", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "LoginSmsCodeInput", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginVerifyPage;", "codeButtonMessage", "(Landroidx/compose/ui/Modifier;Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginVerifyPage;Ljava/lang/String;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "observeIme", "onVisibleChanged", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "isShowing", "accountui_apinkDebug", "composition", "Lcom/airbnb/lottie/LottieComposition;", "progress", ""}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class StepByStepSmsLoginComposeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginConfirmButton$lambda$2(Modifier modifier, String str, boolean z, Function0 function0, int i, int i2, Composer composer, int i3) {
        LoginConfirmButton(modifier, str, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginInputPhone$lambda$1(Modifier modifier, Modifier modifier2, FocusRequester focusRequester, String str, PhoneCountryCode phoneCountryCode, Function1 function1, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        LoginInputPhone(modifier, modifier2, focusRequester, str, phoneCountryCode, function1, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginPageTitle$lambda$0(Modifier modifier, String str, TextStyle textStyle, int i, int i2, Composer composer, int i3) {
        LoginPageTitle(modifier, str, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginSmsCodeInput$lambda$3(Modifier modifier, StepByStepSmsLoginVerifyPage stepByStepSmsLoginVerifyPage, String str, int i, Function1 function1, int i2, Composer composer, int i3) {
        LoginSmsCodeInput(modifier, stepByStepSmsLoginVerifyPage, str, i, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginSmsPhonePage$lambda$11(StepByStepComposePaddingMap stepByStepComposePaddingMap, TextStyle textStyle, StepByStepSmsLoginPhonePage stepByStepSmsLoginPhonePage, Function1 function1, Function2 function2, boolean z, int i, int i2, Composer composer, int i3) {
        LoginSmsPhonePage(stepByStepComposePaddingMap, textStyle, stepByStepSmsLoginPhonePage, function1, function2, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginSmsVerifyPage$lambda$2(StepByStepComposePaddingMap stepByStepComposePaddingMap, TextStyle textStyle, IStepByStepSmsLoginPageState iStepByStepSmsLoginPageState, Function1 function1, int i, int i2, int i3, Composer composer, int i4) {
        LoginSmsVerifyPage(stepByStepComposePaddingMap, textStyle, iStepByStepSmsLoginPageState, function1, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginSubmitButton$lambda$1(Modifier modifier, int i, Composer composer, int i2) {
        LoginSubmitButton(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StepByStepSmsLogin$lambda$1(StepByStepComposePaddingMap stepByStepComposePaddingMap, Function1 function1, Function2 function2, IStepByStepSmsLoginPageState iStepByStepSmsLoginPageState, int i, int i2, Composer composer, int i3) {
        StepByStepSmsLogin(stepByStepComposePaddingMap, function1, function2, iStepByStepSmsLoginPageState, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwitchLogin$lambda$2(Modifier modifier, String str, Function0 function0, int i, int i2, Composer composer, int i3) {
        SwitchLogin(modifier, str, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void StepByStepSmsLogin(final StepByStepComposePaddingMap verticalPaddings, final Function1<? super IStepByStepLoginAction, Unit> function1, final Function2<? super String, ? super Bundle, Unit> function2, final IStepByStepSmsLoginPageState pageState, final int counting, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv2;
        Composer $composer$iv$iv;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(verticalPaddings, "verticalPaddings");
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Intrinsics.checkNotNullParameter(function2, "onRouteTo");
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        Composer $composer3 = $composer.startRestartGroup(200493405);
        ComposerKt.sourceInformation($composer3, "C(StepByStepSmsLogin)N(verticalPaddings,onAction,onRouteTo,pageState,counting)79@3576L1859:StepByStepSmsLoginCompose.kt#fna1tl");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer3.changed(verticalPaddings) : $composer3.changedInstance(verticalPaddings) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? BR.hallEnterHotText : BR.cover;
        }
        if (($changed & 3072) == 0) {
            $dirty |= ($changed & 4096) == 0 ? $composer3.changed(pageState) : $composer3.changedInstance(pageState) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changed(counting) ? RingBuffer.CONSUME_SIZE : 8192;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(200493405, $dirty2, -1, "tv.danmaku.bili.stepbystep.sms.StepByStepSmsLogin (StepByStepSmsLoginCompose.kt:78)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(36), 0.0f, 2, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((BR.nickTextColor >> 3) & 14) | ((BR.nickTextColor >> 3) & BR.containerVisible));
            int $changed$iv$iv = (BR.nickTextColor << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((BR.nickTextColor >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1610990712, "C:StepByStepSmsLoginCompose.kt#fna1tl");
            if (pageState instanceof StepByStepSmsLoginPhonePage) {
                $composer3.startReplaceGroup(-1610953420);
                ComposerKt.sourceInformation($composer3, "87@3840L219");
                $composer$iv$iv$iv = $composer3;
                $composer$iv = $composer3;
                $composer$iv$iv = $composer3;
                $composer$iv2 = $composer3;
                LoginSmsPhonePage(verticalPaddings, null, (StepByStepSmsLoginPhonePage) pageState, function1, function2, false, $composer3, ($dirty2 & 14) | (($dirty2 >> 3) & 896) | (($dirty2 << 6) & 7168) | (($dirty2 << 6) & 57344), 34);
                $composer3.endReplaceGroup();
                $composer2 = $composer3;
            } else {
                $composer$iv$iv$iv = $composer3;
                $composer$iv = $composer3;
                $composer$iv2 = $composer3;
                $composer$iv$iv = $composer3;
                if (pageState instanceof StepByStepSmsLoginVerifyPage) {
                    $composer2 = $composer3;
                    $composer2.startReplaceGroup(-1610655851);
                    ComposerKt.sourceInformation($composer2, "96@4140L218");
                    LoginSmsVerifyPage(verticalPaddings, null, (StepByStepSmsLoginVerifyPage) pageState, function1, counting, $composer2, ($dirty2 & 14) | (($dirty2 >> 3) & 896) | (($dirty2 << 6) & 7168) | ($dirty2 & 57344), 2);
                    $composer2.endReplaceGroup();
                } else {
                    $composer2 = $composer3;
                    if (pageState instanceof StepByStepSmsLoginIdlePage) {
                        $composer2.startReplaceGroup(-1610383330);
                        ComposerKt.sourceInformation($composer2, "105@4437L49");
                        LittleTVLoadingStateKt.LittleTVLoadStatus(new TVPageState.Loading(0, 1, (DefaultConstructorMarker) null), (Modifier) null, $composer2, TVPageState.Loading.$stable, 2);
                        $composer2.endReplaceGroup();
                    } else if (!(pageState instanceof StepByStepSmsLoginPageTransitionState)) {
                        $composer2.startReplaceGroup(1472053211);
                        $composer2.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    } else {
                        $composer2.startReplaceGroup(-1610204398);
                        ComposerKt.sourceInformation($composer2, "");
                        IStepByStepSmsLoginPageState currentPage = ((StepByStepSmsLoginPageTransitionState) pageState).getCurrentPage();
                        if (currentPage instanceof StepByStepSmsLoginPhonePage) {
                            $composer2.startReplaceGroup(-1610111584);
                            ComposerKt.sourceInformation($composer2, "111@4687L271");
                            LoginSmsPhonePage(verticalPaddings, null, (StepByStepSmsLoginPhonePage) ((StepByStepSmsLoginPageTransitionState) pageState).getCurrentPage(), function1, function2, false, $composer2, ($dirty2 & 14) | (($dirty2 << 6) & 7168) | (($dirty2 << 6) & 57344), 34);
                            $composer2.endReplaceGroup();
                            $composer2 = $composer2;
                        } else if (currentPage instanceof StepByStepSmsLoginVerifyPage) {
                            $composer2 = $composer2;
                            $composer2.startReplaceGroup(-1609738623);
                            ComposerKt.sourceInformation($composer2, "120@5063L270");
                            LoginSmsVerifyPage(verticalPaddings, null, (StepByStepSmsLoginVerifyPage) ((StepByStepSmsLoginPageTransitionState) pageState).getCurrentPage(), function1, counting, $composer2, ($dirty2 & 14) | (($dirty2 << 6) & 7168) | ($dirty2 & 57344), 2);
                            $composer2.endReplaceGroup();
                        } else {
                            $composer2 = $composer2;
                            $composer2.startReplaceGroup(-1609427507);
                            $composer2.endReplaceGroup();
                        }
                        $composer2.endReplaceGroup();
                    }
                }
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit StepByStepSmsLogin$lambda$1;
                    StepByStepSmsLogin$lambda$1 = StepByStepSmsLoginComposeKt.StepByStepSmsLogin$lambda$1(StepByStepComposePaddingMap.this, function1, function2, pageState, counting, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return StepByStepSmsLogin$lambda$1;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x0252, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02a2, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x02df, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0202, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L75;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LoginSmsPhonePage(final StepByStepComposePaddingMap verticalPaddings, TextStyle titleStyle, final StepByStepSmsLoginPhonePage pageState, final Function1<? super IStepByStepLoginAction, Unit> function1, final Function2<? super String, ? super Bundle, Unit> function2, boolean enableSwitchToPassword, Composer $composer, final int $changed, final int i) {
        TextStyle titleStyle2;
        boolean z;
        TextStyle titleStyle3;
        boolean enableSwitchToPassword2;
        int $dirty;
        String str;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(verticalPaddings, "verticalPaddings");
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Intrinsics.checkNotNullParameter(function2, "onRouteTo");
        Composer $composer2 = $composer.startRestartGroup(1158710056);
        ComposerKt.sourceInformation($composer2, "C(LoginSmsPhonePage)N(verticalPaddings,titleStyle,pageState,onAction,onRouteTo,enableSwitchToPassword)144@5821L7,145@5854L41,148@5921L169,148@5900L190,157@6199L76,155@6095L214,162@6463L55,166@6698L91,169@6820L402,181@7250L52,160@6314L989,184@7435L76,186@7579L250,182@7308L527,216@8755L99,206@8377L43,209@8448L280,202@8174L686:StepByStepSmsLoginCompose.kt#fna1tl");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= ($changed & 8) == 0 ? $composer2.changed(verticalPaddings) : $composer2.changedInstance(verticalPaddings) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                titleStyle2 = titleStyle;
                if ($composer2.changed(titleStyle2)) {
                    i3 = 32;
                    $dirty2 |= i3;
                }
            } else {
                titleStyle2 = titleStyle;
            }
            i3 = 16;
            $dirty2 |= i3;
        } else {
            titleStyle2 = titleStyle;
        }
        if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty2 |= $composer2.changedInstance(pageState) ? BR.hallEnterHotText : BR.cover;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? RingBuffer.CONSUME_SIZE : 8192;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty2 |= 196608;
            z = enableSwitchToPassword;
        } else if ((196608 & $changed) == 0) {
            z = enableSwitchToPassword;
            $dirty2 |= $composer2.changed(z) ? 131072 : AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR;
        } else {
            z = enableSwitchToPassword;
        }
        if ($composer2.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "138@5563L9");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty2 &= -113;
                }
                $dirty = $dirty2;
                titleStyle3 = titleStyle2;
                enableSwitchToPassword2 = z;
            } else {
                if ((i & 2) != 0) {
                    titleStyle2 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT18b();
                    $dirty2 &= -113;
                }
                if (i4 == 0) {
                    $dirty = $dirty2;
                    titleStyle3 = titleStyle2;
                    enableSwitchToPassword2 = z;
                } else {
                    $dirty = $dirty2;
                    titleStyle3 = titleStyle2;
                    enableSwitchToPassword2 = true;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1158710056, $dirty, -1, "tv.danmaku.bili.stepbystep.sms.LoginSmsPhonePage (StepByStepSmsLoginCompose.kt:143)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SoftwareKeyboardController keyboardController = (SoftwareKeyboardController) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 1123847089, "CC(remember):StepByStepSmsLoginCompose.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new FocusRequester();
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            FocusRequester focusRequester = (FocusRequester) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1123849361, "CC(remember):StepByStepSmsLoginCompose.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(pageState) | $composer2.changed(keyboardController);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new StepByStepSmsLoginComposeKt$LoginSmsPhonePage$1$1(pageState, focusRequester, keyboardController, null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv2, $composer2, 6);
            int $dirty3 = $dirty;
            LoginPageTitle(PaddingKt.padding(Modifier.Companion, verticalPaddings.getTitlePadding()), StringResources_androidKt.stringResource(R.string.account_global_string_93, $composer2, 0), titleStyle3, $composer2, ($dirty << 3) & 896, 0);
            Modifier padding = PaddingKt.padding(Modifier.Companion, verticalPaddings.getPhoneInputPadding());
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer2, 1123866591, "CC(remember):StepByStepSmsLoginCompose.kt#9igjgp");
            boolean invalid$iv2 = ($dirty3 & 7168) == 2048;
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv3 = new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda26
                public final Object invoke(Object obj) {
                    Unit LoginSmsPhonePage$lambda$2$0;
                    LoginSmsPhonePage$lambda$2$0 = StepByStepSmsLoginComposeKt.LoginSmsPhonePage$lambda$2$0(function1, (FocusState) obj);
                    return LoginSmsPhonePage$lambda$2$0;
                }
            };
            $composer2.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier onFocusChanged = FocusChangedModifierKt.onFocusChanged(modifier, (Function1) it$iv3);
            String phone = pageState.getPhoneInputState().getPhone();
            PhoneCountryCode selectedCountry = pageState.getPhoneInputState().getSelectedCountry();
            ComposerKt.sourceInformationMarkerStart($composer2, 1123874147, "CC(remember):StepByStepSmsLoginCompose.kt#9igjgp");
            boolean invalid$iv3 = ($dirty3 & 7168) == 2048;
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv4 = new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda27
                public final Object invoke(Object obj) {
                    Unit LoginSmsPhonePage$lambda$3$0;
                    LoginSmsPhonePage$lambda$3$0 = StepByStepSmsLoginComposeKt.LoginSmsPhonePage$lambda$3$0(function1, (String) obj);
                    return LoginSmsPhonePage$lambda$3$0;
                }
            };
            $composer2.updateRememberedValue(value$iv4);
            it$iv4 = value$iv4;
            Function1 function12 = (Function1) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1123878362, "CC(remember):StepByStepSmsLoginCompose.kt#9igjgp");
            boolean invalid$iv4 = (($dirty3 & 7168) == 2048) | (($dirty3 & 57344) == 16384) | $composer2.changedInstance(pageState);
            Object it$iv5 = $composer2.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv5 = new Function0() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit LoginSmsPhonePage$lambda$4$0;
                    LoginSmsPhonePage$lambda$4$0 = StepByStepSmsLoginComposeKt.LoginSmsPhonePage$lambda$4$0(function1, function2, pageState);
                    return LoginSmsPhonePage$lambda$4$0;
                }
            };
            $composer2.updateRememberedValue(value$iv5);
            it$iv5 = value$iv5;
            Function0 function0 = (Function0) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1123891772, "CC(remember):StepByStepSmsLoginCompose.kt#9igjgp");
            boolean invalid$iv5 = ($dirty3 & 7168) == 2048;
            Object it$iv6 = $composer2.rememberedValue();
            if (invalid$iv5) {
            }
            Object value$iv6 = new Function0() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit LoginSmsPhonePage$lambda$5$0;
                    LoginSmsPhonePage$lambda$5$0 = StepByStepSmsLoginComposeKt.LoginSmsPhonePage$lambda$5$0(function1);
                    return LoginSmsPhonePage$lambda$5$0;
                }
            };
            $composer2.updateRememberedValue(value$iv6);
            it$iv6 = value$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LoginInputPhone(padding, onFocusChanged, focusRequester, phone, selectedCountry, function12, function0, (Function0) it$iv6, $composer2, BR.negativeBtnVisible);
            Modifier padding2 = PaddingKt.padding(Modifier.Companion, verticalPaddings.getPhoneConfirmButtonPadding());
            String stringResource = StringResources_androidKt.stringResource(R.string.account_global_string_34, $composer2, 0);
            boolean confirmButtonEnable = pageState.getConfirmButtonEnable();
            ComposerKt.sourceInformationMarkerStart($composer2, 1123902498, "CC(remember):StepByStepSmsLoginCompose.kt#9igjgp");
            boolean invalid$iv6 = $composer2.changedInstance(pageState) | (($dirty3 & 7168) == 2048);
            Object it$iv7 = $composer2.rememberedValue();
            if (invalid$iv6 || it$iv7 == Composer.Companion.getEmpty()) {
                Object value$iv7 = new Function0() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit LoginSmsPhonePage$lambda$6$0;
                        LoginSmsPhonePage$lambda$6$0 = StepByStepSmsLoginComposeKt.LoginSmsPhonePage$lambda$6$0(StepByStepSmsLoginPhonePage.this, function1);
                        return LoginSmsPhonePage$lambda$6$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv7);
                it$iv7 = value$iv7;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LoginConfirmButton(padding2, stringResource, confirmButtonEnable, (Function0) it$iv7, $composer2, 0, 0);
            if (enableSwitchToPassword2) {
                $composer2.startReplaceGroup(481527341);
                ComposerKt.sourceInformation($composer2, "198@7994L76,199@8100L53,196@7878L285");
                Modifier padding3 = PaddingKt.padding(Modifier.Companion, verticalPaddings.getSwitchLoginPadding());
                String stringResource2 = StringResources_androidKt.stringResource(R.string.account_global_string_17, $composer2, 0);
                str = "CC(remember):StepByStepSmsLoginCompose.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($composer2, 1123918973, str);
                boolean invalid$iv7 = ($dirty3 & 7168) == 2048;
                Object it$iv8 = $composer2.rememberedValue();
                if (invalid$iv7 || it$iv8 == Composer.Companion.getEmpty()) {
                    Object value$iv8 = new Function0() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            Unit LoginSmsPhonePage$lambda$7$0;
                            LoginSmsPhonePage$lambda$7$0 = StepByStepSmsLoginComposeKt.LoginSmsPhonePage$lambda$7$0(function1);
                            return LoginSmsPhonePage$lambda$7$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv8);
                    it$iv8 = value$iv8;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                i2 = 2048;
                SwitchLogin(padding3, stringResource2, (Function0) it$iv8, $composer2, 0, 0);
            } else {
                str = "CC(remember):StepByStepSmsLoginCompose.kt#9igjgp";
                i2 = 2048;
                $composer2.startReplaceGroup(473711962);
            }
            $composer2.endReplaceGroup();
            Modifier padding4 = PaddingKt.padding(Modifier.Companion, verticalPaddings.getAgreementLinePadding());
            boolean agreementChecked = pageState.getAgreementChecked();
            BiliCheckBoxShape biliCheckBoxShape = BiliCheckBoxShape.CIRCLE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1123939979, str);
            boolean invalid$iv8 = ($dirty3 & 7168) == i2;
            Object it$iv9 = $composer2.rememberedValue();
            if (invalid$iv8 || it$iv9 == Composer.Companion.getEmpty()) {
                Object value$iv9 = new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        Unit LoginSmsPhonePage$lambda$8$0;
                        LoginSmsPhonePage$lambda$8$0 = StepByStepSmsLoginComposeKt.LoginSmsPhonePage$lambda$8$0(function1, ((Boolean) obj).booleanValue());
                        return LoginSmsPhonePage$lambda$8$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv9);
                it$iv9 = value$iv9;
            }
            Function1 function13 = (Function1) it$iv9;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1123927827, str);
            boolean invalid$iv9 = ($dirty3 & 57344) == 16384;
            Object it$iv10 = $composer2.rememberedValue();
            if (invalid$iv9 || it$iv10 == Composer.Companion.getEmpty()) {
                Object value$iv10 = new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        Unit LoginSmsPhonePage$lambda$9$0;
                        LoginSmsPhonePage$lambda$9$0 = StepByStepSmsLoginComposeKt.LoginSmsPhonePage$lambda$9$0(function2, (String) obj);
                        return LoginSmsPhonePage$lambda$9$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv10);
                it$iv10 = value$iv10;
            }
            Function1 function14 = (Function1) it$iv10;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1123930336, str);
            boolean invalid$iv10 = ($dirty3 & 7168) == 2048;
            Object it$iv11 = $composer2.rememberedValue();
            if (invalid$iv10 || it$iv11 == Composer.Companion.getEmpty()) {
                Object value$iv11 = new Function3() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit LoginSmsPhonePage$lambda$10$0;
                        LoginSmsPhonePage$lambda$10$0 = StepByStepSmsLoginComposeKt.LoginSmsPhonePage$lambda$10$0(function1, (EulaLinkType) obj, ((Boolean) obj2).booleanValue(), (EulaTriggerType) obj3);
                        return LoginSmsPhonePage$lambda$10$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv11);
                it$iv11 = value$iv11;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CommonKt.LoginAgreement(padding4, agreementChecked, null, function13, function14, (Function3) it$iv11, biliCheckBoxShape, $composer2, 1572864, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            titleStyle3 = titleStyle2;
            enableSwitchToPassword2 = z;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final TextStyle textStyle = titleStyle3;
            final boolean z2 = enableSwitchToPassword2;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit LoginSmsPhonePage$lambda$11;
                    LoginSmsPhonePage$lambda$11 = StepByStepSmsLoginComposeKt.LoginSmsPhonePage$lambda$11(StepByStepComposePaddingMap.this, textStyle, pageState, function1, function2, z2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return LoginSmsPhonePage$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginSmsPhonePage$lambda$2$0(Function1 $onAction, FocusState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $onAction.invoke(new IStepByStepLoginAction.OnFocusChanged(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginSmsPhonePage$lambda$3$0(Function1 $onAction, String phone) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        $onAction.invoke(new StepByStepSmsLoginAction.InputPhoneAction(phone));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginSmsPhonePage$lambda$4$0(Function1 $onAction, Function2 $onRouteTo, StepByStepSmsLoginPhonePage $pageState) {
        $onAction.invoke(StepByStepSmsLoginAction.ReportAction.ClickCountryCode.INSTANCE);
        Bundle $this$LoginSmsPhonePage_u24lambda_u244_u240_u240 = new Bundle();
        $this$LoginSmsPhonePage_u24lambda_u244_u240_u240.putParcelable(SelectCountryCodeFragmentKt.KEY_AVAILABLE_COUNTRY_CODE, $pageState.getPhoneInputState().getAvailableCountryCode());
        Unit unit = Unit.INSTANCE;
        $onRouteTo.invoke(SelectCountryCodeFragmentKt.URL_SELECT_COUNTRY_CODE_PAGE, $this$LoginSmsPhonePage_u24lambda_u244_u240_u240);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginSmsPhonePage$lambda$5$0(Function1 $onAction) {
        $onAction.invoke(StepByStepSmsLoginAction.ClearOutPhone.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginSmsPhonePage$lambda$6$0(StepByStepSmsLoginPhonePage $pageState, Function1 $onAction) {
        IStepByStepLoginAction action;
        if ($pageState.getAgreementChecked()) {
            action = StepByStepSmsLoginAction.PageTransitionAction.INSTANCE;
        } else {
            action = IStepByStepLoginAction.ShowEulaAction.INSTANCE;
        }
        $onAction.invoke(action);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginSmsPhonePage$lambda$7$0(Function1 $onAction) {
        $onAction.invoke(IStepByStepLoginAction.SwitchToPassword.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginSmsPhonePage$lambda$9$0(Function2 $onRouteTo, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $onRouteTo.invoke(it, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginSmsPhonePage$lambda$10$0(Function1 $onAction, EulaLinkType type, boolean inDialog, EulaTriggerType eulaTriggerType) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (inDialog) {
            $onAction.invoke(new StepByStepSmsLoginAction.ReportAction.ClickProvisionPopupTerms(type));
        } else {
            $onAction.invoke(new StepByStepSmsLoginAction.ReportAction.ClickProvisionTerms(type));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginSmsPhonePage$lambda$8$0(Function1 $onAction, boolean checked) {
        $onAction.invoke(new IStepByStepLoginAction.AgreementCheckedAction(checked, false, 2, null));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LoginSmsVerifyPage(final StepByStepComposePaddingMap verticalPaddings, TextStyle titleStyle, final IStepByStepSmsLoginPageState pageState, final Function1<? super IStepByStepLoginAction, Unit> function1, final int counting, Composer $composer, final int $changed, final int i) {
        TextStyle textStyle;
        Composer $composer2;
        TextStyle titleStyle2;
        int $dirty;
        Object $this$asTo$iv;
        StepByStepSmsLoginVerifyPage verifyPage;
        String stringResource;
        String str;
        int i2;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(verticalPaddings, "verticalPaddings");
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Composer $composer3 = $composer.startRestartGroup(-1665798796);
        ComposerKt.sourceInformation($composer3, "C(LoginSmsVerifyPage)N(verticalPaddings,titleStyle,pageState,onAction,counting):StepByStepSmsLoginCompose.kt#fna1tl");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= ($changed & 8) == 0 ? $composer3.changed(verticalPaddings) : $composer3.changedInstance(verticalPaddings) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                textStyle = titleStyle;
                if ($composer3.changed(textStyle)) {
                    i5 = 32;
                    $dirty2 |= i5;
                }
            } else {
                textStyle = titleStyle;
            }
            i5 = 16;
            $dirty2 |= i5;
        } else {
            textStyle = titleStyle;
        }
        if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty2 |= ($changed & BR.roleType) == 0 ? $composer3.changed(pageState) : $composer3.changedInstance(pageState) ? BR.hallEnterHotText : BR.cover;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changedInstance(function1) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer3.changed(counting) ? RingBuffer.CONSUME_SIZE : 8192;
        }
        if ($composer3.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer3.startDefaults();
            ComposerKt.sourceInformation($composer3, "225@8989L9");
            if (($changed & 1) != 0 && !$composer3.getDefaultsInvalid()) {
                $composer3.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty2 &= -113;
                }
            } else if ((i & 2) != 0) {
                $dirty = $dirty2 & (-113);
                titleStyle2 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT18b();
                $composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1665798796, $dirty, -1, "tv.danmaku.bili.stepbystep.sms.LoginSmsVerifyPage (StepByStepSmsLoginCompose.kt:229)");
                }
                $this$asTo$iv = pageState;
                if (!($this$asTo$iv instanceof StepByStepSmsLoginVerifyPage)) {
                    $this$asTo$iv = null;
                }
                verifyPage = (StepByStepSmsLoginVerifyPage) $this$asTo$iv;
                if (verifyPage == null) {
                    $composer3.startReplaceGroup(-1759392944);
                    ComposerKt.sourceInformation($composer3, "234@9338L76,232@9226L230,237@9465L544");
                    int $dirty3 = $dirty;
                    LoginPageTitle(PaddingKt.padding(Modifier.Companion, verticalPaddings.getTitlePadding()), StringResources_androidKt.stringResource(R.string.account_global_string_86, $composer3, 0), titleStyle2, $composer3, ($dirty << 3) & 896, 0);
                    Modifier padding = PaddingKt.padding(Modifier.Companion, verticalPaddings.getVerifyInputPadding());
                    if (verifyPage.getCaptchaStatus() == null) {
                        $composer3.startReplaceGroup(-1758934206);
                        ComposerKt.sourceInformation($composer3, "243@9757L76");
                        stringResource = StringResources_androidKt.stringResource(R.string.account_global_string_21, $composer3, 0);
                        $composer3.endReplaceGroup();
                    } else {
                        $composer3.startReplaceGroup(-1758819940);
                        ComposerKt.sourceInformation($composer3, "245@9871L114");
                        stringResource = StringResources_androidKt.stringResource(R.string.account_global_string_30, $composer3, 0);
                        $composer3.endReplaceGroup();
                    }
                    LoginSmsCodeInput(padding, verifyPage, stringResource, counting, function1, $composer3, (($dirty3 >> 3) & 7168) | (57344 & ($dirty3 << 3)));
                    if (!StringsKt.isBlank(verifyPage.getExceptionMessage())) {
                        $composer3.startReplaceGroup(-1758598693);
                        $composer3.endReplaceGroup();
                        str = verifyPage.getExceptionMessage();
                    } else if (verifyPage.getExceptionMessageResourceId() > 0) {
                        $composer3.startReplaceGroup(-1758494564);
                        ComposerKt.sourceInformation($composer3, "253@10197L58");
                        str = StringResources_androidKt.stringResource(verifyPage.getExceptionMessageResourceId(), $composer3, 0);
                        $composer3.endReplaceGroup();
                    } else {
                        $composer3.startReplaceGroup(-1758408942);
                        $composer3.endReplaceGroup();
                        str = null;
                    }
                    String errorMsg = str;
                    if (errorMsg == null) {
                        $composer3.startReplaceGroup(-1758352957);
                        $composer3.endReplaceGroup();
                        i2 = 0;
                        i3 = 1;
                        i4 = 2048;
                    } else {
                        $composer3.startReplaceGroup(-1758352956);
                        ComposerKt.sourceInformation($composer3, "*260@10403L6,261@10456L9,258@10336L302");
                        i2 = 0;
                        i3 = 1;
                        i4 = 2048;
                        TextKt.Text--4IGK_g(errorMsg, PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), verticalPaddings.getVerifyExceptionMessagePadding()), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getStress_red-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13(), $composer3, 0, 0, 65528);
                        $composer3.endReplaceGroup();
                    }
                    if (verifyPage.getVerifying()) {
                        $composer3.startReplaceGroup(-1757996425);
                        ComposerKt.sourceInformation($composer3, "268@10697L127");
                        LoginSubmitButton(PaddingKt.padding(Modifier.Companion, verticalPaddings.getVerifyConfirmButtonPadding()), $composer3, i2);
                        $composer3.endReplaceGroup();
                        $composer2 = $composer3;
                    } else {
                        $composer3.startReplaceGroup(-1757832466);
                        ComposerKt.sourceInformation($composer3, "274@10998L76,276@11159L86,272@10854L392");
                        Modifier padding2 = PaddingKt.padding(Modifier.Companion, verticalPaddings.getVerifyConfirmButtonPadding());
                        String stringResource2 = StringResources_androidKt.stringResource(R.string.account_global_string_34, $composer3, i2);
                        boolean confirmButtonEnable = verifyPage.getConfirmButtonEnable();
                        ComposerKt.sourceInformationMarkerStart($composer3, 1190231594, "CC(remember):StepByStepSmsLoginCompose.kt#9igjgp");
                        int i6 = ($dirty3 & 7168) == i4 ? i3 : i2;
                        Object it$iv = $composer3.rememberedValue();
                        if (i6 != 0 || it$iv == Composer.Companion.getEmpty()) {
                            Object value$iv = new Function0() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda11
                                public final Object invoke() {
                                    Unit LoginSmsVerifyPage$lambda$1$0;
                                    LoginSmsVerifyPage$lambda$1$0 = StepByStepSmsLoginComposeKt.LoginSmsVerifyPage$lambda$1$0(function1);
                                    return LoginSmsVerifyPage$lambda$1$0;
                                }
                            };
                            $composer3.updateRememberedValue(value$iv);
                            it$iv = value$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer2 = $composer3;
                        LoginConfirmButton(padding2, stringResource2, confirmButtonEnable, (Function0) it$iv, $composer3, 0, 0);
                        $composer2.endReplaceGroup();
                    }
                } else {
                    $composer2 = $composer3;
                    $composer2.startReplaceGroup(-1768599634);
                }
                $composer2.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            $dirty = $dirty2;
            titleStyle2 = textStyle;
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            $this$asTo$iv = pageState;
            if (!($this$asTo$iv instanceof StepByStepSmsLoginVerifyPage)) {
            }
            verifyPage = (StepByStepSmsLoginVerifyPage) $this$asTo$iv;
            if (verifyPage == null) {
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            titleStyle2 = textStyle;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final TextStyle textStyle2 = titleStyle2;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit LoginSmsVerifyPage$lambda$2;
                    LoginSmsVerifyPage$lambda$2 = StepByStepSmsLoginComposeKt.LoginSmsVerifyPage$lambda$2(StepByStepComposePaddingMap.this, textStyle2, pageState, function1, counting, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return LoginSmsVerifyPage$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginSmsVerifyPage$lambda$1$0(Function1 $onAction) {
        $onAction.invoke(new IStepByStepLoginAction.LoginAction(null, false, 3, null));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LoginPageTitle(final Modifier modifier, final String text, TextStyle style, Composer $composer, final int $changed, final int i) {
        TextStyle textStyle;
        Composer $composer2;
        TextStyle style2;
        int $dirty;
        int i2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer3 = $composer.startRestartGroup(702643270);
        ComposerKt.sourceInformation($composer3, "C(LoginPageTitle)N(modifier,text,style)287@11435L6,285@11382L123:StepByStepSmsLoginCompose.kt#fna1tl");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(text) ? 32 : 16;
        }
        if (($changed & BR.negativeBtnVisible) == 0) {
            if ((i & 4) == 0) {
                textStyle = style;
                if ($composer3.changed(textStyle)) {
                    i2 = BR.hallEnterHotText;
                    $dirty2 |= i2;
                }
            } else {
                textStyle = style;
            }
            i2 = BR.cover;
            $dirty2 |= i2;
        } else {
            textStyle = style;
        }
        if ($composer3.shouldExecute(($dirty2 & BR.danmakuNumIcon) != 146, $dirty2 & 1)) {
            $composer3.startDefaults();
            ComposerKt.sourceInformation($composer3, "284@11360L9");
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if ((i & 4) != 0) {
                    $dirty = $dirty2 & (-897);
                    style2 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT18b();
                    $composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(702643270, $dirty, -1, "tv.danmaku.bili.stepbystep.sms.LoginPageTitle (StepByStepSmsLoginCompose.kt:284)");
                    }
                    $composer2 = $composer3;
                    TextKt.Text--4IGK_g(text, modifier, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, style2, $composer2, (($dirty >> 3) & 14) | (($dirty << 3) & BR.containerVisible), ($dirty << 12) & 3670016, 65528);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                $dirty = $dirty2;
                style2 = textStyle;
                $composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                $composer2 = $composer3;
                TextKt.Text--4IGK_g(text, modifier, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, style2, $composer2, (($dirty >> 3) & 14) | (($dirty << 3) & BR.containerVisible), ($dirty << 12) & 3670016, 65528);
                if (ComposerKt.isTraceInProgress()) {
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty = $dirty2 & (-897);
                    style2 = textStyle;
                    $composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    $composer2 = $composer3;
                    TextKt.Text--4IGK_g(text, modifier, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, style2, $composer2, (($dirty >> 3) & 14) | (($dirty << 3) & BR.containerVisible), ($dirty << 12) & 3670016, 65528);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
                $dirty = $dirty2;
                style2 = textStyle;
                $composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                $composer2 = $composer3;
                TextKt.Text--4IGK_g(text, modifier, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, style2, $composer2, (($dirty >> 3) & 14) | (($dirty << 3) & BR.containerVisible), ($dirty << 12) & 3670016, 65528);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            style2 = textStyle;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final TextStyle textStyle2 = style2;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit LoginPageTitle$lambda$0;
                    LoginPageTitle$lambda$0 = StepByStepSmsLoginComposeKt.LoginPageTitle$lambda$0(modifier, text, textStyle2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return LoginPageTitle$lambda$0;
                }
            });
        }
    }

    public static final void LoginInputPhone(final Modifier modifier, final Modifier focusChangeModifier, final FocusRequester focusRequester, final String phone, final PhoneCountryCode countryCode, final Function1<? super String, Unit> function1, final Function0<Unit> function0, final Function0<Unit> function02, Composer $composer, final int $changed) {
        int $dirty;
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        VisualTransformation none;
        Composer $composer$iv$iv$iv;
        Function0 factory$iv$iv$iv3;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(focusChangeModifier, "focusChangeModifier");
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        Intrinsics.checkNotNullParameter(function1, "onPhoneInput");
        Intrinsics.checkNotNullParameter(function0, "onCountryCodeClick");
        Intrinsics.checkNotNullParameter(function02, "onClearOutPhone");
        Composer $composer3 = $composer.startRestartGroup(-1793515048);
        ComposerKt.sourceInformation($composer3, "C(LoginInputPhone)N(modifier,focusChangeModifier,focusRequester,phone,countryCode,onPhoneInput,onCountryCodeClick,onClearOutPhone)308@11933L6,304@11803L4191:StepByStepSmsLoginCompose.kt#fna1tl");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(focusChangeModifier) ? 32 : 16;
        }
        if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty2 |= $composer3.changed(focusRequester) ? BR.hallEnterHotText : BR.cover;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changed(phone) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= (32768 & $changed) == 0 ? $composer3.changed(countryCode) : $composer3.changedInstance(countryCode) ? RingBuffer.CONSUME_SIZE : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= $composer3.changedInstance(function1) ? 131072 : AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR;
        }
        if ((1572864 & $changed) == 0) {
            $dirty2 |= $composer3.changedInstance(function0) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty2 |= $composer3.changedInstance(function02) ? 8388608 : 4194304;
        }
        int $dirty3 = $dirty2;
        if (!$composer3.shouldExecute((4793491 & $dirty3) != 4793490, $dirty3 & 1)) {
            $dirty = $dirty3;
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1793515048, $dirty3, -1, "tv.danmaku.bili.stepbystep.sms.LoginInputPhone (StepByStepSmsLoginCompose.kt:303)");
            }
            Modifier modifier$iv = BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, (Object) null), Dp.constructor-impl(48)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg2-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(48)));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((BR.negativeBtnVisible >> 3) & 14) | ((BR.negativeBtnVisible >> 3) & BR.containerVisible));
            int $changed$iv$iv = (BR.negativeBtnVisible << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $composer2 = $composer3;
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
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i2 = ((BR.negativeBtnVisible >> 6) & BR.containerVisible) | 6;
            RowScope $this$LoginInputPhone_u24lambda_u240 = rowScope;
            ComposerKt.sourceInformationMarkerStart($composer3, 2063111151, "C311@12052L1203,350@13492L71,352@13641L9,358@13864L24,344@13264L2158:StepByStepSmsLoginCompose.kt#fna1tl");
            Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(ModifierUtilsKt.clickableNoInteraction$default(Modifier.Companion, false, function0, 1, (Object) null), Dp.constructor-impl(16), 0.0f, 0.0f, 0.0f, 14, (Object) null);
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((BR.negativeBtnVisible >> 3) & 14) | ((BR.negativeBtnVisible >> 3) & BR.containerVisible));
            int $changed$iv$iv2 = (BR.negativeBtnVisible << 3) & BR.containerVisible;
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
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            int i4 = ((BR.negativeBtnVisible >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 573148562, "C319@12378L6,320@12426L9,317@12284L170,325@12613L7,323@12499L252,334@12987L6,322@12467L546,337@13069L6,336@13026L219:StepByStepSmsLoginCompose.kt#fna1tl");
            TextKt.Text--4IGK_g("+" + countryCode.getCountryCode(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16(), $composer3, 0, 0, 65530);
            CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            IconKt.Icon-ww6aTOc(DrawablePainterKt.rememberDrawablePainter(AppCompatResources.getDrawable((Context) consume, com.bilibili.iconfont.R.drawable.ref_arrow_forward_right_line_500), $composer3, 0), (String) null, RotateKt.rotate(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(4), 0.0f, Dp.constructor-impl(7), 0.0f, 10, (Object) null), Dp.constructor-impl(16)), 90.0f), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), $composer3, Painter.$stable | BR.pendentVisible, 0);
            DividerKt.Divider-oMI9zvI(SizeKt.width-3ABfNKs(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), Dp.constructor-impl((float) 0.5d)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getLine_regular-0d7_KjU(), Dp.constructor-impl((float) 0.5d), 0.0f, $composer3, (int) BR.nickTextColor, 8);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier focusRequester2 = FocusRequesterModifierKt.focusRequester(RowScope.-CC.weight$default($this$LoginInputPhone_u24lambda_u240, PaddingKt.padding-VpY3zN4$default(focusChangeModifier, Dp.constructor-impl(12), 0.0f, 2, (Object) null), 1.0f, false, 2, (Object) null), focusRequester);
            String stringResource = StringResources_androidKt.stringResource(R.string.account_global_string_45, $composer3, 0);
            TextStyle t16 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16();
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, KeyboardType.Companion.getPhone-PjHm6EE(), ImeAction.Companion.getNext-eUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, (int) BR.contentBackground, (DefaultConstructorMarker) null);
            TextFieldColors textFieldColors = SimpleTextFieldKt.defaultTextFieldColors-69fazGs(0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, (int) BR.countdownTrackEnabled);
            if (countryCode.getId() == PhoneCountryCode.Companion.getDefaultCountryCode().getId()) {
                $composer3.startReplaceGroup(2064950876);
                ComposerKt.sourceInformation($composer3, "361@14046L1289");
                ComposerKt.sourceInformationMarkerStart($composer3, -487576195, "CC(remember):StepByStepSmsLoginCompose.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new VisualTransformation() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda18
                        public final TransformedText filter(AnnotatedString annotatedString) {
                            TransformedText LoginInputPhone$lambda$0$1$0;
                            LoginInputPhone$lambda$0$1$0 = StepByStepSmsLoginComposeKt.LoginInputPhone$lambda$0$1$0(annotatedString);
                            return LoginInputPhone$lambda$0$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                none = (VisualTransformation) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(2066267477);
                $composer3.endReplaceGroup();
                none = VisualTransformation.Companion.getNone();
            }
            SimpleTextFieldKt.SimpleTextField(phone, stringResource, function1, focusRequester2, t16, (TextStyle) null, false, true, 0, keyboardOptions, (KeyboardActions) null, none, (Function1) null, textFieldColors, $composer3, (($dirty3 >> 9) & 14) | 817889280 | (($dirty3 >> 9) & 896), 0, 5472);
            if (phone.length() > 0) {
                $composer3.startReplaceGroup(2066381433);
                ComposerKt.sourceInformation($composer3, "394@15469L509");
                $composer$iv$iv$iv = $composer3;
                Modifier modifier$iv3 = ModifierUtilsKt.clickableNoInteraction$default(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(48)), false, function02, 1, (Object) null);
                Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv3 = (48 << 3) & BR.containerVisible;
                $dirty = $dirty3;
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
                int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i6 = ((48 >> 6) & BR.containerVisible) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -288689849, "C401@15783L7,401@15735L109,403@15928L6,400@15699L265:StepByStepSmsLoginCompose.kt#fna1tl");
                CompositionLocal this_$iv2 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume2 = $composer3.consume(this_$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                IconKt.Icon-ww6aTOc(DrawablePainterKt.rememberDrawablePainter(KtxKt.getAppCompatDrawable((Context) consume2, com.bilibili.app.accountui.R.drawable.ic_account_et_clear), $composer3, 0), "", (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGraph_weak-0d7_KjU(), $composer3, Painter.$stable | 48, 4);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                $dirty = $dirty3;
                $composer$iv$iv$iv = $composer3;
                $composer3.startReplaceGroup(2051032558);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda19
                public final Object invoke(Object obj, Object obj2) {
                    Unit LoginInputPhone$lambda$1;
                    LoginInputPhone$lambda$1 = StepByStepSmsLoginComposeKt.LoginInputPhone$lambda$1(modifier, focusChangeModifier, focusRequester, phone, countryCode, function1, function0, function02, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return LoginInputPhone$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TransformedText LoginInputPhone$lambda$0$1$0(AnnotatedString text) {
        Intrinsics.checkNotNullParameter(text, "text");
        int i = 0;
        AnnotatedString.Builder $this$LoginInputPhone_u24lambda_u240_u241_u240_u240 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
        CharSequence $this$forEachIndexed$iv = (CharSequence) text;
        int index$iv = 0;
        while (i < $this$forEachIndexed$iv.length()) {
            char item$iv = $this$forEachIndexed$iv.charAt(i);
            int index$iv2 = index$iv + 1;
            $this$LoginInputPhone_u24lambda_u240_u241_u240_u240.append(item$iv);
            switch (index$iv) {
                case 2:
                case 6:
                    $this$LoginInputPhone_u24lambda_u240_u241_u240_u240.append(" ");
                    break;
            }
            i++;
            index$iv = index$iv2;
        }
        return new TransformedText($this$LoginInputPhone_u24lambda_u240_u241_u240_u240.toAnnotatedString(), new OffsetMapping() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$LoginInputPhone$1$2$1$2
            public int originalToTransformed(int offset) {
                if (offset < 3) {
                    return offset;
                }
                boolean z = false;
                if (3 <= offset && offset < 7) {
                    z = true;
                }
                return z ? offset + 1 : offset + 2;
            }

            public int transformedToOriginal(int offset) {
                if (offset < 3) {
                    return offset;
                }
                boolean z = false;
                if (3 <= offset && offset < 8) {
                    z = true;
                }
                return z ? offset - 1 : offset - 2;
            }
        });
    }

    public static final void LoginSubmitButton(final Modifier modifier, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer $composer2 = $composer.startRestartGroup(-1638791396);
        ComposerKt.sourceInformation($composer2, "C(LoginSubmitButton)N(modifier)417@16205L6,412@16058L1033:StepByStepSmsLoginCompose.kt#fna1tl");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if ($composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1638791396, $dirty, -1, "tv.danmaku.bili.stepbystep.sms.LoginSubmitButton (StepByStepSmsLoginCompose.kt:411)");
            }
            Modifier modifier$iv = BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, (Object) null), Dp.constructor-impl(44)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(44)));
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((BR.pendentVisible >> 3) & 14) | ((BR.pendentVisible >> 3) & BR.containerVisible));
            int $changed$iv$iv = (BR.pendentVisible << 3) & BR.containerVisible;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i2 = ((BR.pendentVisible >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1306524422, "C422@16415L86,423@16526L138,427@16673L142,434@16904L77,435@17013L9,436@17058L6,432@16824L261:StepByStepSmsLoginCompose.kt#fna1tl");
            LottieCompositionResult composition$delegate = RememberLottieCompositionKt.rememberLottieComposition(LottieCompositionSpec.Asset.box-impl(LottieCompositionSpec.Asset.constructor-impl("player_loading_tv_white.json")), (String) null, (String) null, (String) null, (String) null, (Function3) null, $composer2, 6, 62);
            LottieAnimationState progress$delegate = AnimateLottieCompositionAsStateKt.animateLottieCompositionAsState(LoginSubmitButton$lambda$0$0(composition$delegate), false, false, (LottieClipSpec) null, 0.0f, (int) FlowControlConfig.RETRY_MAX_TIMES, (LottieCancellationBehavior) null, $composer2, 196608, 94);
            LottieAnimationKt.LottieAnimation(LoginSubmitButton$lambda$0$0(composition$delegate), LoginSubmitButton$lambda$0$1(progress$delegate), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), false, false, false, (LottieDynamicProperties) null, (Alignment) null, (ContentScale) null, $composer2, (int) BR.negativeBtnVisible, (int) BR.rightText);
            TextKt.Text--4IGK_g(StringResources_androidKt.stringResource(R.string.account_global_string_131, $composer2, 0), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(4), 0.0f, 0.0f, 0.0f, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT15(), $composer2, 48, 0, 65528);
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
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj, Object obj2) {
                    Unit LoginSubmitButton$lambda$1;
                    LoginSubmitButton$lambda$1 = StepByStepSmsLoginComposeKt.LoginSubmitButton$lambda$1(modifier, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return LoginSubmitButton$lambda$1;
                }
            });
        }
    }

    private static final LottieComposition LoginSubmitButton$lambda$0$0(LottieCompositionResult $composition$delegate) {
        State $this$getValue$iv = (State) $composition$delegate;
        return (LottieComposition) $this$getValue$iv.getValue();
    }

    private static final float LoginSubmitButton$lambda$0$1(LottieAnimationState $progress$delegate) {
        State $this$getValue$iv = (State) $progress$delegate;
        return ((Number) $this$getValue$iv.getValue()).floatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v7 */
    public static final void LoginConfirmButton(final Modifier modifier, final String buttonText, boolean enable, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        boolean z;
        Function0 onClick;
        boolean enable2;
        Function0 onClick2;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        Composer $composer2 = $composer.startRestartGroup(907522943);
        ComposerKt.sourceInformation($composer2, "C(LoginConfirmButton)N(modifier,buttonText,enable,onClick)442@17217L2,449@17419L6,443@17227L601:StepByStepSmsLoginCompose.kt#fna1tl");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(buttonText) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= BR.negativeBtnVisible;
            z = enable;
        } else if (($changed & BR.negativeBtnVisible) == 0) {
            z = enable;
            $dirty |= $composer2.changed(z) ? BR.hallEnterHotText : BR.cover;
        } else {
            z = enable;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            onClick = function0;
        } else if (($changed & 3072) == 0) {
            onClick = function0;
            $dirty |= $composer2.changedInstance(onClick) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        } else {
            onClick = function0;
        }
        if (!$composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            enable2 = z;
        } else {
            boolean enable3 = i2 != 0 ? false : z;
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 251190657, "CC(remember):StepByStepSmsLoginCompose.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda10
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onClick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onClick2 = onClick;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(907522943, $dirty, -1, "tv.danmaku.bili.stepbystep.sms.LoginConfirmButton (StepByStepSmsLoginCompose.kt:442)");
            }
            Modifier modifier$iv = ModifierUtilsKt.clickableNoInteraction(BackgroundKt.background-bw27NRU(AlphaKt.alpha(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, (Object) null), Dp.constructor-impl(44)), enable3 ? 1.0f : 0.4f), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(44))), enable3, onClick2);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((BR.pendentVisible >> 3) & 14) | ((BR.pendentVisible >> 3) & BR.containerVisible));
            int $changed$iv$iv = (BR.pendentVisible << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            enable2 = enable3;
            Function0 onClick3 = onClick2;
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
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i5 = ((BR.pendentVisible >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1654955491, "C457@17750L9,458@17795L6,455@17683L139:StepByStepSmsLoginCompose.kt#fna1tl");
            TextKt.Text--4IGK_g(buttonText, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT15(), $composer2, ($dirty >> 3) & 14, 0, 65530);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onClick = onClick3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final boolean z2 = enable2;
            final Function0 function02 = onClick;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda20
                public final Object invoke(Object obj, Object obj2) {
                    Unit LoginConfirmButton$lambda$2;
                    LoginConfirmButton$lambda$2 = StepByStepSmsLoginComposeKt.LoginConfirmButton$lambda$2(modifier, buttonText, z2, function02, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return LoginConfirmButton$lambda$2;
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v9 */
    public static final void SwitchLogin(final Modifier modifier, final String title, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Function0 onSwitchClick;
        Function0 onSwitchClick2;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(title, ReportUtilKt.POS_TITLE);
        Composer $composer2 = $composer.startRestartGroup(907530483);
        ComposerKt.sourceInformation($composer2, "C(SwitchLogin)N(modifier,title,onSwitchClick)464@17932L2,465@17942L766:StepByStepSmsLoginCompose.kt#fna1tl");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(title) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= BR.negativeBtnVisible;
            onSwitchClick = function0;
        } else if (($changed & BR.negativeBtnVisible) == 0) {
            onSwitchClick = function0;
            $dirty |= $composer2.changedInstance(onSwitchClick) ? BR.hallEnterHotText : BR.cover;
        } else {
            onSwitchClick = function0;
        }
        if ($composer2.shouldExecute(($dirty & BR.danmakuNumIcon) != 146, $dirty & 1)) {
            if (i2 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 258435605, "CC(remember):StepByStepSmsLoginCompose.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda13
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onSwitchClick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onSwitchClick2 = onSwitchClick;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(907530483, $dirty, -1, "tv.danmaku.bili.stepbystep.sms.SwitchLogin (StepByStepSmsLoginCompose.kt:464)");
            }
            Modifier modifier$iv = SizeKt.height-3ABfNKs(ModifierUtilsKt.clickableNoInteraction$default(modifier, false, onSwitchClick2, 1, (Object) null), Dp.constructor-impl(36));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((BR.negativeBtnVisible >> 3) & 14) | ((BR.negativeBtnVisible >> 3) & BR.containerVisible));
            int $changed$iv$iv = (BR.negativeBtnVisible << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Function0 onSwitchClick3 = onSwitchClick2;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((BR.negativeBtnVisible >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1120201803, "C473@18197L9,474@18242L6,471@18135L130,478@18367L7,477@18302L175,484@18675L6,476@18274L428:StepByStepSmsLoginCompose.kt#fna1tl");
            TextKt.Text--4IGK_g(title, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText2-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13(), $composer2, ($dirty >> 3) & 14, 0, 65530);
            CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            IconKt.Icon-ww6aTOc(DrawablePainterKt.rememberDrawablePainter(KtxKt.getAppCompatDrawable((Context) consume, com.bilibili.app.comm.baseres.R.drawable.ic_light_gray_arrow_right), $composer2, 0), (String) null, PaddingKt.padding-qDBjuR0$default(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(13)), Dp.constructor-impl(6), Dp.constructor-impl(2), 0.0f, Dp.constructor-impl(1), 4, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_bold-0d7_KjU(), $composer2, Painter.$stable | BR.pendentVisible, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onSwitchClick = onSwitchClick3;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Function0 function02 = onSwitchClick;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj, Object obj2) {
                    Unit SwitchLogin$lambda$2;
                    SwitchLogin$lambda$2 = StepByStepSmsLoginComposeKt.SwitchLogin$lambda$2(modifier, title, function02, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SwitchLogin$lambda$2;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x02ff, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0364, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L73;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LoginSmsCodeInput(final Modifier modifier, final StepByStepSmsLoginVerifyPage pageState, final String codeButtonMessage, final int counting, final Function1<? super IStepByStepLoginAction, Unit> function1, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        FocusRequester focusRequester;
        Composer $composer$iv;
        Composer $composer$iv$iv;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv2;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        Intrinsics.checkNotNullParameter(codeButtonMessage, "codeButtonMessage");
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Composer $composer3 = $composer.startRestartGroup(-914445828);
        ComposerKt.sourceInformation($composer3, "C(LoginSmsCodeInput)N(modifier,pageState,codeButtonMessage,counting,onAction)497@18979L7,498@19012L41,501@19079L169,501@19058L190,512@19383L6,508@19253L2412:StepByStepSmsLoginCompose.kt#fna1tl");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(pageState) ? 32 : 16;
        }
        if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty |= $composer3.changed(codeButtonMessage) ? BR.hallEnterHotText : BR.cover;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(counting) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? RingBuffer.CONSUME_SIZE : 8192;
        }
        if (!$composer3.shouldExecute(($dirty & 9363) != 9362, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-914445828, $dirty, -1, "tv.danmaku.bili.stepbystep.sms.LoginSmsCodeInput (StepByStepSmsLoginCompose.kt:496)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SoftwareKeyboardController keyboardController = (SoftwareKeyboardController) consume;
            ComposerKt.sourceInformationMarkerStart($composer3, 1685864229, "CC(remember):StepByStepSmsLoginCompose.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new FocusRequester();
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            FocusRequester focusRequester2 = (FocusRequester) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1685866501, "CC(remember):StepByStepSmsLoginCompose.kt#9igjgp");
            boolean invalid$iv = $composer3.changedInstance(pageState) | $composer3.changed(keyboardController);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new StepByStepSmsLoginComposeKt$LoginSmsCodeInput$1$1(pageState, focusRequester2, keyboardController, null);
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv2, $composer3, 6);
            Modifier modifier$iv = BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, (Object) null), Dp.constructor-impl(48)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg2-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(48)));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((BR.negativeBtnVisible >> 3) & 14) | ((BR.negativeBtnVisible >> 3) & BR.containerVisible));
            int $changed$iv$iv = (BR.negativeBtnVisible << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i2 = ((BR.negativeBtnVisible >> 6) & BR.containerVisible) | 6;
            RowScope $this$LoginSmsCodeInput_u24lambda_u242 = rowScope;
            ComposerKt.sourceInformationMarkerStart($composer3, 1840940766, "C517@19577L76,518@19689L9,519@19742L9,531@20218L55,532@20341L6,532@20296L58,520@19785L89,515@19502L862:StepByStepSmsLoginCompose.kt#fna1tl");
            String smsCode = pageState.getSmsCode();
            String stringResource = StringResources_androidKt.stringResource(R.string.account_global_string_86, $composer3, 0);
            TextStyle t15 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT15();
            TextStyle t152 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT15();
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, KeyboardType.Companion.getNumber-PjHm6EE(), ImeAction.Companion.getNext-eUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, (int) BR.contentBackground, (DefaultConstructorMarker) null);
            $composer2 = $composer3;
            Modifier focusRequester3 = FocusRequesterModifierKt.focusRequester(PaddingKt.padding-VpY3zN4$default(RowScope.-CC.weight$default($this$LoginSmsCodeInput_u24lambda_u242, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(16), 0.0f, 2, (Object) null), focusRequester2);
            ComposerKt.sourceInformationMarkerStart($composer3, -910425329, "CC(remember):StepByStepSmsLoginCompose.kt#9igjgp");
            boolean invalid$iv2 = ($dirty & 57344) == 16384;
            Object value$iv3 = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            value$iv3 = new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda21
                public final Object invoke(Object obj) {
                    Unit LoginSmsCodeInput$lambda$2$0$0;
                    LoginSmsCodeInput$lambda$2$0$0 = StepByStepSmsLoginComposeKt.LoginSmsCodeInput$lambda$2$0$0(function1, (FocusState) obj);
                    return LoginSmsCodeInput$lambda$2$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier onFocusChanged = FocusChangedModifierKt.onFocusChanged(focusRequester3, (Function1) value$iv3);
            TextFieldColors textFieldColors = SimpleTextFieldKt.defaultTextFieldColors-69fazGs(0L, 0L, 0L, 0L, 0L, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), 0L, $composer3, 0, 95);
            ComposerKt.sourceInformationMarkerStart($composer3, -910439151, "CC(remember):StepByStepSmsLoginCompose.kt#9igjgp");
            boolean invalid$iv3 = ($dirty & 57344) == 16384;
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv4 = new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda22
                public final Object invoke(Object obj) {
                    Unit LoginSmsCodeInput$lambda$2$1$0;
                    LoginSmsCodeInput$lambda$2$1$0 = StepByStepSmsLoginComposeKt.LoginSmsCodeInput$lambda$2$1$0(function1, (String) obj);
                    return LoginSmsCodeInput$lambda$2$1$0;
                }
            };
            $composer3.updateRememberedValue(value$iv4);
            it$iv3 = value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SimpleTextFieldKt.SimpleTextField(smsCode, stringResource, (Function1) it$iv3, onFocusChanged, t15, t152, false, false, 0, keyboardOptions, (KeyboardActions) null, (VisualTransformation) null, (Function1) null, textFieldColors, $composer3, 805306368, 0, 7616);
            if (pageState.getSmsCode().length() > 0) {
                $composer3.startReplaceGroup(1841792459);
                ComposerKt.sourceInformation($composer3, "539@20552L57,536@20424L551");
                Modifier modifier2 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(48));
                ComposerKt.sourceInformationMarkerStart($composer3, -910414639, "CC(remember):StepByStepSmsLoginCompose.kt#9igjgp");
                boolean invalid$iv4 = ($dirty & 57344) == 16384;
                Object it$iv4 = $composer3.rememberedValue();
                if (invalid$iv4 || it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv5 = new Function0() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda23
                        public final Object invoke() {
                            Unit LoginSmsCodeInput$lambda$2$2$0;
                            LoginSmsCodeInput$lambda$2$2$0 = StepByStepSmsLoginComposeKt.LoginSmsCodeInput$lambda$2$2$0(function1);
                            return LoginSmsCodeInput$lambda$2$2$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv5);
                    it$iv4 = value$iv5;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier$iv$iv = ModifierUtilsKt.clickableNoInteraction$default(modifier2, false, (Function0) it$iv4, 1, (Object) null);
                Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (48 << 3) & BR.containerVisible;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv$iv);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                focusRequester = focusRequester2;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer3.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i4 = ((48 >> 6) & BR.containerVisible) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 1149047523, "C543@20780L7,543@20732L109,545@20925L6,542@20696L265:StepByStepSmsLoginCompose.kt#fna1tl");
                CompositionLocal this_$iv2 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume2 = $composer3.consume(this_$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                IconKt.Icon-ww6aTOc(DrawablePainterKt.rememberDrawablePainter(KtxKt.getAppCompatDrawable((Context) consume2, com.bilibili.app.accountui.R.drawable.ic_account_et_clear), $composer3, 0), "", (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGraph_weak-0d7_KjU(), $composer3, Painter.$stable | 48, 4);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                focusRequester = focusRequester2;
                $composer3.startReplaceGroup(1821526922);
            }
            $composer3.endReplaceGroup();
            if (counting > 0) {
                $composer3.startReplaceGroup(1842393177);
                ComposerKt.sourceInformation($composer3, "553@21103L6,554@21151L9,551@21027L209");
                TextKt.Text--4IGK_g(String.valueOf(counting), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(16), 0.0f, 11, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT15(), $composer3, 48, 0, 65528);
                $composer3.endReplaceGroup();
                $composer$iv = $composer3;
                $composer$iv$iv = $composer3;
                $composer$iv$iv$iv = $composer3;
                $composer$iv2 = $composer3;
            } else {
                $composer3.startReplaceGroup(1842635659);
                ComposerKt.sourceInformation($composer3, "560@21348L6,561@21401L9,564@21538L97,558@21266L383");
                long j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                TextStyle t153 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT15();
                Modifier modifier3 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(16), 0.0f, 11, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, -910383047, "CC(remember):StepByStepSmsLoginCompose.kt#9igjgp");
                boolean invalid$iv5 = (57344 & $dirty) == 16384;
                Object it$iv5 = $composer3.rememberedValue();
                if (invalid$iv5 || it$iv5 == Composer.Companion.getEmpty()) {
                    Object value$iv6 = new Function0() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda24
                        public final Object invoke() {
                            Unit LoginSmsCodeInput$lambda$2$4$0;
                            LoginSmsCodeInput$lambda$2$4$0 = StepByStepSmsLoginComposeKt.LoginSmsCodeInput$lambda$2$4$0(function1);
                            return LoginSmsCodeInput$lambda$2$4$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv6);
                    it$iv5 = value$iv6;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer$iv = $composer3;
                $composer$iv$iv = $composer3;
                $composer$iv$iv$iv = $composer3;
                $composer$iv2 = $composer3;
                TextKt.Text--4IGK_g(codeButtonMessage, ModifierUtilsKt.clickableNoInteraction$default(modifier3, false, (Function0) it$iv5, 1, (Object) null), j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t153, $composer3, ($dirty >> 6) & 14, 0, 65528);
                $composer3.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda25
                public final Object invoke(Object obj, Object obj2) {
                    Unit LoginSmsCodeInput$lambda$3;
                    LoginSmsCodeInput$lambda$3 = StepByStepSmsLoginComposeKt.LoginSmsCodeInput$lambda$3(modifier, pageState, codeButtonMessage, counting, function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return LoginSmsCodeInput$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginSmsCodeInput$lambda$2$1$0(Function1 $onAction, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $onAction.invoke(new StepByStepSmsLoginAction.InputSmsCodeAction(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginSmsCodeInput$lambda$2$0$0(Function1 $onAction, FocusState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $onAction.invoke(new IStepByStepLoginAction.OnFocusChanged(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginSmsCodeInput$lambda$2$2$0(Function1 $onAction) {
        $onAction.invoke(StepByStepSmsLoginAction.ClearOutVerifyCode.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginSmsCodeInput$lambda$2$4$0(Function1 $onAction) {
        $onAction.invoke(new StepByStepSmsLoginAction.GetSmsAction(null, null, 3, null));
        return Unit.INSTANCE;
    }

    public static final Modifier observeIme(Modifier $this$observeIme, final Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$observeIme, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onVisibleChanged");
        return ComposedModifierKt.composed$default($this$observeIme, (Function1) null, new Function3() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda15
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Modifier observeIme$lambda$0;
                observeIme$lambda$0 = StepByStepSmsLoginComposeKt.observeIme$lambda$0(function1, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return observeIme$lambda$0;
            }
        }, 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier observeIme$lambda$0(final Function1 $onVisibleChanged, Modifier $this$composed, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$composed, "$this$composed");
        $composer.startReplaceGroup(-2000165626);
        ComposerKt.sourceInformation($composer, "C627@24568L7,628@24606L140:StepByStepSmsLoginCompose.kt#fna1tl");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2000165626, $changed, -1, "tv.danmaku.bili.stepbystep.sms.observeIme.<anonymous> (StepByStepSmsLoginCompose.kt:627)");
        }
        CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final Context context = (Context) consume;
        ComposerKt.sourceInformationMarkerStart($composer, 1986184434, "CC(remember):StepByStepSmsLoginCompose.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance(context) | $composer.changed($onVisibleChanged);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$$ExternalSyntheticLambda17
                public final Object invoke(Object obj) {
                    Unit observeIme$lambda$0$0$0;
                    observeIme$lambda$0$0$0 = StepByStepSmsLoginComposeKt.observeIme$lambda$0$0$0(context, $onVisibleChanged, (LayoutCoordinates) obj);
                    return observeIme$lambda$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned($this$composed, (Function1) it$iv);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return onGloballyPositioned;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeIme$lambda$0$0$0(Context $context, Function1 $onVisibleChanged, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        int height = ScreenUtil.getScreenHeight($context);
        $onVisibleChanged.invoke(Boolean.valueOf(((float) height) - LayoutCoordinatesKt.boundsInWindow$default(it, false, 1, (Object) null).getBottom() > ((float) height) / 4.0f));
        return Unit.INSTANCE;
    }
}