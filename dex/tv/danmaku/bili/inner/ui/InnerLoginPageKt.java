package tv.danmaku.bili.inner.ui;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import bili.resource.account.R;
import com.bilibili.compose.image.BiliImageKt;
import com.bilibili.compose.theme.BiliTheme;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import shark.AndroidResourceIdNames;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.log.cache.RingBuffer;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.eula.EulaLinkType;
import tv.danmaku.bili.fullscreen.data.PhoneCountryCode;
import tv.danmaku.bili.fullscreen.page.CommonKt;
import tv.danmaku.bili.fullscreen.page.SmsLoginPageKt;
import tv.danmaku.bili.fullscreen.route.ValidLoginType;
import tv.danmaku.bili.fullscreen.service.IspCode;
import tv.danmaku.bili.fullscreen.stat.Facebook;
import tv.danmaku.bili.fullscreen.stat.Google;
import tv.danmaku.bili.fullscreen.stat.LoginWay;
import tv.danmaku.bili.fullscreen.state.FastLoginFailed;
import tv.danmaku.bili.fullscreen.state.FastLoginLoadingPage;
import tv.danmaku.bili.fullscreen.state.FastLoginPage;
import tv.danmaku.bili.fullscreen.state.FastLoginRiskControl;
import tv.danmaku.bili.fullscreen.state.FullscreenLoginFastPage;
import tv.danmaku.bili.fullscreen.state.FullscreenLoginPhonePage;
import tv.danmaku.bili.fullscreen.state.FullscreenOverseaPage;
import tv.danmaku.bili.fullscreen.state.FullscreenPhoneOrPasswordPage;
import tv.danmaku.bili.fullscreen.state.IFastLoginPage;
import tv.danmaku.bili.fullscreen.state.IFullscreenAction;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginReportAction;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginState;
import tv.danmaku.bili.fullscreen.state.IOverseaLoginState;
import tv.danmaku.bili.fullscreen.state.IPhoneOnePassState;
import tv.danmaku.bili.fullscreen.state.IPhoneOrPasswordLoginPage;
import tv.danmaku.bili.fullscreen.state.ISmsLoginAction;
import tv.danmaku.bili.fullscreen.state.ISmsLoginCountingState;
import tv.danmaku.bili.fullscreen.state.ISmsLoginPageState;
import tv.danmaku.bili.fullscreen.state.NetCodeEnableState;
import tv.danmaku.bili.fullscreen.state.OverSeaLoadingState;
import tv.danmaku.bili.fullscreen.state.OverseaLoginState;
import tv.danmaku.bili.fullscreen.state.PhoneOnePassLoginLoadingState;
import tv.danmaku.bili.fullscreen.state.PhoneOnePassLoginState;
import tv.danmaku.bili.fullscreen.state.PhoneOrPasswordLoginIdlePage;
import tv.danmaku.bili.fullscreen.state.SmsLoginInput;
import tv.danmaku.bili.fullscreen.state.SmsLoginLoadingCountingState;
import tv.danmaku.bili.fullscreen.state.SmsLoginLoadingIdleState;
import tv.danmaku.bili.fullscreen.state.SmsLoginPageInitialState;
import tv.danmaku.bili.fullscreen.state.SmsLoginPageInputCountingState;
import tv.danmaku.bili.fullscreen.state.SmsLoginPageInputIdleState;
import tv.danmaku.bili.fullscreen.state.SmsLoginSelectCountryCodeState;
import tv.danmaku.bili.normal.ui.EulaTriggerType;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: InnerLoginPage.kt */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0089\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00052\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\n2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00052\u001a\b\u0002\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010\u0011\u001a/\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00132\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010\u0014\u001aé\u0001\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a2\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00052\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a2\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u00052\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00052\u001a\b\u0002\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\n2\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010 \u001a¥\u0001\u0010!\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\"2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a2#\b\u0002\u0010(\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010)\u001a¥\u0001\u0010*\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020+2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a2#\b\u0002\u0010(\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010,\u001a\r\u0010-\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010.¨\u0006/²\u0006\u0016\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u0005X\u008a\u0084\u0002"}, d2 = {"InnerLoginPage", "", LoginReporterV2.PAGE_FROM_KEY, "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginState;", "onAction", "Lkotlin/Function1;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenAction;", "routeTo", "", "routeToLogin", "Lkotlin/Function2;", "Ltv/danmaku/bili/fullscreen/route/ValidLoginType;", "", "onCountryCodeSwitchClick", "Ltv/danmaku/bili/fullscreen/state/SmsLoginInput;", "onOverseaLoginClick", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "(Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "InnerPhoneOrPasswordLoginPage", "Ltv/danmaku/bili/fullscreen/state/IPhoneOrPasswordLoginPage;", "(Ltv/danmaku/bili/fullscreen/state/IPhoneOrPasswordLoginPage;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "InnerOverseaLoginPage", "pageOversea", "Ltv/danmaku/bili/fullscreen/state/IOverseaLoginState;", "onLoginClick", "onSwitchClick", "Lkotlin/Function0;", "onPhoneInput", "onSmsCodeInput", "onSendCodeClick", "onLoginAgreementChecked", "onOverseaClick", "(Ltv/danmaku/bili/fullscreen/state/IOverseaLoginState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "InnerPhoneLoginPage", "Ltv/danmaku/bili/fullscreen/state/IPhoneOnePassState;", "loginButtonText", "switchLoginText", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "checked", "onAgreementCheckChanged", "(Ltv/danmaku/bili/fullscreen/state/IPhoneOnePassState;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "InnerFastLoginPage", "Ltv/danmaku/bili/fullscreen/state/IFastLoginPage;", "(Ltv/danmaku/bili/fullscreen/state/IFastLoginPage;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "TipToLogin", "(Landroidx/compose/runtime/Composer;I)V", "accountui_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class InnerLoginPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerFastLoginPage$lambda$3(IFastLoginPage iFastLoginPage, String str, String str2, Function1 function1, Function0 function0, Function1 function12, Function1 function13, Function1 function14, int i, int i2, Composer composer, int i3) {
        InnerFastLoginPage(iFastLoginPage, str, str2, function1, function0, function12, function13, function14, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerLoginPage$lambda$14(IFullscreenLoginState iFullscreenLoginState, Function1 function1, Function1 function12, Function2 function2, Function1 function13, Function2 function22, int i, int i2, Composer composer, int i3) {
        InnerLoginPage(iFullscreenLoginState, function1, function12, function2, function13, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerOverseaLoginPage$lambda$10(IOverseaLoginState iOverseaLoginState, Function1 function1, Function1 function12, Function0 function0, Function1 function13, Function1 function14, Function0 function02, Function1 function15, Function1 function16, Function2 function2, Function1 function17, int i, int i2, int i3, Composer composer, int i4) {
        InnerOverseaLoginPage(iOverseaLoginState, function1, function12, function0, function13, function14, function02, function15, function16, function2, function17, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerPhoneLoginPage$lambda$3(IPhoneOnePassState iPhoneOnePassState, String str, String str2, Function1 function1, Function0 function0, Function1 function12, Function1 function13, Function1 function14, int i, int i2, Composer composer, int i3) {
        InnerPhoneLoginPage(iPhoneOnePassState, str, str2, function1, function0, function12, function13, function14, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerPhoneOrPasswordLoginPage$lambda$2(IPhoneOrPasswordLoginPage iPhoneOrPasswordLoginPage, Function2 function2, int i, Composer composer, int i2) {
        InnerPhoneOrPasswordLoginPage(iPhoneOrPasswordLoginPage, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TipToLogin$lambda$0(int i, Composer composer, int i2) {
        TipToLogin(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerLoginPage$lambda$0$0(SmsLoginInput it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerLoginPage$lambda$1$0(boolean z, LoginWay loginWay) {
        Intrinsics.checkNotNullParameter(loginWay, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:124:0x0287, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x02c4, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x039a, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x03d5, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0410, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x044e, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x048e, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L171;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void InnerLoginPage(final IFullscreenLoginState page, final Function1<? super IFullscreenAction, Unit> function1, final Function1<? super String, Unit> function12, final Function2<? super ValidLoginType, ? super Boolean, Unit> function2, Function1<? super SmsLoginInput, Unit> function13, Function2<? super Boolean, ? super LoginWay, Unit> function22, Composer $composer, final int $changed, final int i) {
        Function1 onCountryCodeSwitchClick;
        Function2 onOverseaLoginClick;
        final Function1 onCountryCodeSwitchClick2;
        Function2 onOverseaLoginClick2;
        Intrinsics.checkNotNullParameter(page, LoginReporterV2.PAGE_FROM_KEY);
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Intrinsics.checkNotNullParameter(function12, "routeTo");
        Intrinsics.checkNotNullParameter(function2, "routeToLogin");
        Composer $composer2 = $composer.startRestartGroup(-1311985586);
        ComposerKt.sourceInformation($composer2, "C(InnerLoginPage)N(page,onAction,routeTo,routeToLogin,onCountryCodeSwitchClick,onOverseaLoginClick)81@4008L2,82@4067L11,84@4129L207,84@4108L228:InnerLoginPage.kt#1fav2j");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(page) : $composer2.changedInstance(page) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty |= $composer2.changedInstance(function12) ? BR.hallEnterHotText : BR.cover;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            onCountryCodeSwitchClick = function13;
        } else if (($changed & 24576) == 0) {
            onCountryCodeSwitchClick = function13;
            $dirty |= $composer2.changedInstance(onCountryCodeSwitchClick) ? RingBuffer.CONSUME_SIZE : 8192;
        } else {
            onCountryCodeSwitchClick = function13;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty |= 196608;
            onOverseaLoginClick = function22;
        } else if ((196608 & $changed) == 0) {
            onOverseaLoginClick = function22;
            $dirty |= $composer2.changedInstance(onOverseaLoginClick) ? 131072 : AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR;
        } else {
            onOverseaLoginClick = function22;
        }
        if ($composer2.shouldExecute((74899 & $dirty) != 74898, $dirty & 1)) {
            if (i2 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1902244432, "CC(remember):InnerLoginPage.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda18
                        public final Object invoke(Object obj) {
                            Unit InnerLoginPage$lambda$0$0;
                            InnerLoginPage$lambda$0$0 = InnerLoginPageKt.InnerLoginPage$lambda$0$0((SmsLoginInput) obj);
                            return InnerLoginPage$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onCountryCodeSwitchClick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onCountryCodeSwitchClick2 = onCountryCodeSwitchClick;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1902246329, "CC(remember):InnerLoginPage.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function2() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda24
                        public final Object invoke(Object obj, Object obj2) {
                            Unit InnerLoginPage$lambda$1$0;
                            InnerLoginPage$lambda$1$0 = InnerLoginPageKt.InnerLoginPage$lambda$1$0(((Boolean) obj).booleanValue(), (LoginWay) obj2);
                            return InnerLoginPage$lambda$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                onOverseaLoginClick2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onOverseaLoginClick2 = onOverseaLoginClick;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1311985586, $dirty, -1, "tv.danmaku.bili.inner.ui.InnerLoginPage (InnerLoginPage.kt:83)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1902248509, "CC(remember):InnerLoginPage.kt#9igjgp");
            boolean invalid$iv = ($dirty & BR.containerVisible) == 32;
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda25
                    public final Object invoke(Object obj) {
                        Unit InnerLoginPage$lambda$2$0;
                        InnerLoginPage$lambda$2$0 = InnerLoginPageKt.InnerLoginPage$lambda$2$0(function1, ((Boolean) obj).booleanValue());
                        return InnerLoginPage$lambda$2$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            State onLoginClick$delegate = SnapshotStateKt.rememberUpdatedState((Function1) it$iv3, $composer2, 0);
            if (page instanceof FullscreenLoginPhonePage) {
                $composer2.startReplaceGroup(-1159542933);
                ComposerKt.sourceInformation($composer2, "108@4945L77,109@5058L77,97@4548L83,100@4675L199,94@4409L777");
                IPhoneOnePassState currentPage = ((FullscreenLoginPhonePage) page).getCurrentPage();
                Function1<Boolean, Unit> InnerLoginPage$lambda$3 = InnerLoginPage$lambda$3(onLoginClick$delegate);
                String stringResource = StringResources_androidKt.stringResource(R.string.account_global_string_171, $composer2, 0);
                String stringResource2 = StringResources_androidKt.stringResource(R.string.account_global_string_160, $composer2, 0);
                ComposerKt.sourceInformationMarkerStart($composer2, 1902261793, "CC(remember):InnerLoginPage.kt#9igjgp");
                boolean invalid$iv2 = ($dirty & 7168) == 2048;
                Object it$iv4 = $composer2.rememberedValue();
                if (invalid$iv2 || it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda26
                        public final Object invoke() {
                            Unit InnerLoginPage$lambda$4$0;
                            InnerLoginPage$lambda$4$0 = InnerLoginPageKt.InnerLoginPage$lambda$4$0(function2);
                            return InnerLoginPage$lambda$4$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                }
                Function0 function0 = (Function0) it$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, 1902265973, "CC(remember):InnerLoginPage.kt#9igjgp");
                boolean invalid$iv3 = ($dirty & BR.containerVisible) == 32;
                Object it$iv5 = $composer2.rememberedValue();
                if (invalid$iv3 || it$iv5 == Composer.Companion.getEmpty()) {
                    Object value$iv5 = new Function1() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda27
                        public final Object invoke(Object obj) {
                            Unit InnerLoginPage$lambda$5$0;
                            InnerLoginPage$lambda$5$0 = InnerLoginPageKt.InnerLoginPage$lambda$5$0(function1, ((Boolean) obj).booleanValue());
                            return InnerLoginPage$lambda$5$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv5);
                    it$iv5 = value$iv5;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                InnerPhoneLoginPage(currentPage, stringResource, stringResource2, InnerLoginPage$lambda$3, function0, (Function1) it$iv5, function12, function1, $composer2, (($dirty << 12) & 3670016) | (($dirty << 18) & 29360128), 0);
                $composer2.endReplaceGroup();
            } else if (page instanceof FullscreenLoginFastPage) {
                $composer2.startReplaceGroup(-1158709684);
                ComposerKt.sourceInformation($composer2, "117@5345L75,118@5456L77,127@5855L53,119@5577L199,115@5250L744");
                IFastLoginPage currentPage2 = ((FullscreenLoginFastPage) page).getCurrentPage();
                String stringResource3 = StringResources_androidKt.stringResource(R.string.account_global_string_9, $composer2, 0);
                String stringResource4 = StringResources_androidKt.stringResource(R.string.account_global_string_183, $composer2, 0);
                Function1<Boolean, Unit> InnerLoginPage$lambda$32 = InnerLoginPage$lambda$3(onLoginClick$delegate);
                ComposerKt.sourceInformationMarkerStart($composer2, 1902303587, "CC(remember):InnerLoginPage.kt#9igjgp");
                boolean invalid$iv4 = ($dirty & BR.containerVisible) == 32;
                Object value$iv6 = $composer2.rememberedValue();
                if (invalid$iv4) {
                }
                value$iv6 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda28
                    public final Object invoke() {
                        Unit InnerLoginPage$lambda$6$0;
                        InnerLoginPage$lambda$6$0 = InnerLoginPageKt.InnerLoginPage$lambda$6$0(function1);
                        return InnerLoginPage$lambda$6$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv6);
                Function0 function02 = value$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, 1902294837, "CC(remember):InnerLoginPage.kt#9igjgp");
                boolean invalid$iv5 = ($dirty & BR.containerVisible) == 32;
                Object it$iv6 = $composer2.rememberedValue();
                if (invalid$iv5) {
                }
                Object value$iv7 = new Function1() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda29
                    public final Object invoke(Object obj) {
                        Unit InnerLoginPage$lambda$7$0;
                        InnerLoginPage$lambda$7$0 = InnerLoginPageKt.InnerLoginPage$lambda$7$0(function1, ((Boolean) obj).booleanValue());
                        return InnerLoginPage$lambda$7$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv7);
                it$iv6 = value$iv7;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                InnerFastLoginPage(currentPage2, stringResource3, stringResource4, InnerLoginPage$lambda$32, function02, (Function1) it$iv6, function12, function1, $composer2, (($dirty << 12) & 3670016) | (($dirty << 18) & 29360128), 0);
                $composer2.endReplaceGroup();
            } else if (page instanceof FullscreenPhoneOrPasswordPage) {
                $composer2.startReplaceGroup(-1157934405);
                ComposerKt.sourceInformation($composer2, "134@6064L129");
                InnerPhoneOrPasswordLoginPage(((FullscreenPhoneOrPasswordPage) page).getCurrentPage(), function2, $composer2, ($dirty >> 6) & BR.containerVisible);
                $composer2.endReplaceGroup();
            } else if (page instanceof FullscreenOverseaPage) {
                $composer2.startReplaceGroup(-1157718862);
                ComposerKt.sourceInformation($composer2, "146@6498L47,147@6578L50,148@6663L52,149@6751L50,150@6845L199,157@7089L32,142@6313L912");
                BLog.d("Oversea", "is FullscreenOverseaPage");
                IOverseaLoginState currentPage3 = ((FullscreenOverseaPage) page).getCurrentPage();
                Function1<Boolean, Unit> InnerLoginPage$lambda$33 = InnerLoginPage$lambda$3(onLoginClick$delegate);
                ComposerKt.sourceInformationMarkerStart($composer2, 1902324157, "CC(remember):InnerLoginPage.kt#9igjgp");
                boolean invalid$iv6 = ($dirty & 7168) == 2048;
                Object it$iv7 = $composer2.rememberedValue();
                if (invalid$iv6 || it$iv7 == Composer.Companion.getEmpty()) {
                    Object value$iv8 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda30
                        public final Object invoke() {
                            Unit InnerLoginPage$lambda$8$0;
                            InnerLoginPage$lambda$8$0 = InnerLoginPageKt.InnerLoginPage$lambda$8$0(function2);
                            return InnerLoginPage$lambda$8$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv8);
                    it$iv7 = value$iv8;
                }
                Function0 function03 = (Function0) it$iv7;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, 1902326720, "CC(remember):InnerLoginPage.kt#9igjgp");
                boolean invalid$iv7 = ($dirty & BR.containerVisible) == 32;
                Object it$iv8 = $composer2.rememberedValue();
                if (invalid$iv7) {
                }
                Object value$iv9 = new Function1() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda31
                    public final Object invoke(Object obj) {
                        Unit InnerLoginPage$lambda$9$0;
                        InnerLoginPage$lambda$9$0 = InnerLoginPageKt.InnerLoginPage$lambda$9$0(function1, (String) obj);
                        return InnerLoginPage$lambda$9$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv9);
                it$iv8 = value$iv9;
                Function1 function14 = (Function1) it$iv8;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, 1902329442, "CC(remember):InnerLoginPage.kt#9igjgp");
                boolean invalid$iv8 = ($dirty & BR.containerVisible) == 32;
                Object it$iv9 = $composer2.rememberedValue();
                if (invalid$iv8) {
                }
                Object value$iv10 = new Function1() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda33
                    public final Object invoke(Object obj) {
                        Unit InnerLoginPage$lambda$10$0;
                        InnerLoginPage$lambda$10$0 = InnerLoginPageKt.InnerLoginPage$lambda$10$0(function1, (String) obj);
                        return InnerLoginPage$lambda$10$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv10);
                it$iv9 = value$iv10;
                Function1 function15 = (Function1) it$iv9;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, 1902332256, "CC(remember):InnerLoginPage.kt#9igjgp");
                boolean invalid$iv9 = ($dirty & BR.containerVisible) == 32;
                Object it$iv10 = $composer2.rememberedValue();
                if (invalid$iv9) {
                }
                Object value$iv11 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda19
                    public final Object invoke() {
                        Unit InnerLoginPage$lambda$11$0;
                        InnerLoginPage$lambda$11$0 = InnerLoginPageKt.InnerLoginPage$lambda$11$0(function1);
                        return InnerLoginPage$lambda$11$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv11);
                it$iv10 = value$iv11;
                Function0 function04 = (Function0) it$iv10;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, 1902335413, "CC(remember):InnerLoginPage.kt#9igjgp");
                boolean invalid$iv10 = ($dirty & BR.containerVisible) == 32;
                Object it$iv11 = $composer2.rememberedValue();
                if (invalid$iv10) {
                }
                Object value$iv12 = new Function1() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda20
                    public final Object invoke(Object obj) {
                        Unit InnerLoginPage$lambda$12$0;
                        InnerLoginPage$lambda$12$0 = InnerLoginPageKt.InnerLoginPage$lambda$12$0(function1, ((Boolean) obj).booleanValue());
                        return InnerLoginPage$lambda$12$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv12);
                it$iv11 = value$iv12;
                Function1 function16 = (Function1) it$iv11;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, 1902343054, "CC(remember):InnerLoginPage.kt#9igjgp");
                boolean invalid$iv11 = (57344 & $dirty) == 16384;
                Object it$iv12 = $composer2.rememberedValue();
                if (invalid$iv11) {
                }
                Object value$iv13 = new Function1() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda22
                    public final Object invoke(Object obj) {
                        Unit InnerLoginPage$lambda$13$0;
                        InnerLoginPage$lambda$13$0 = InnerLoginPageKt.InnerLoginPage$lambda$13$0(onCountryCodeSwitchClick2, (SmsLoginInput) obj);
                        return InnerLoginPage$lambda$13$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv13);
                it$iv12 = value$iv13;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                InnerOverseaLoginPage(currentPage3, function1, InnerLoginPage$lambda$33, function03, function14, function15, function04, function16, (Function1) it$iv12, onOverseaLoginClick2, function12, $composer2, ($dirty & BR.containerVisible) | (1879048192 & ($dirty << 12)), ($dirty >> 6) & 14, 0);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-1156745710);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onOverseaLoginClick = onOverseaLoginClick2;
            onCountryCodeSwitchClick = onCountryCodeSwitchClick2;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Function1 function17 = onCountryCodeSwitchClick;
            final Function2 function23 = onOverseaLoginClick;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda23
                public final Object invoke(Object obj, Object obj2) {
                    Unit InnerLoginPage$lambda$14;
                    InnerLoginPage$lambda$14 = InnerLoginPageKt.InnerLoginPage$lambda$14(IFullscreenLoginState.this, function1, function12, function2, function17, function23, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return InnerLoginPage$lambda$14;
                }
            });
        }
    }

    private static final Function1<Boolean, Unit> InnerLoginPage$lambda$3(State<? extends Function1<? super Boolean, Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function1) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerLoginPage$lambda$2$0(Function1 $onAction, boolean login) {
        if (login) {
            $onAction.invoke(new IFullscreenLoginAction.LoginAction(null, true, null, 5, null));
        } else {
            $onAction.invoke(new IFullscreenLoginAction.ShowEulaAction(null, 1, null));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerLoginPage$lambda$4$0(Function2 $routeToLogin) {
        $routeToLogin.invoke(ValidLoginType.SmsLogin, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerLoginPage$lambda$5$0(Function1 $onAction, boolean it) {
        $onAction.invoke(new IFullscreenLoginAction.AgreementCheckedAction(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerLoginPage$lambda$7$0(Function1 $onAction, boolean it) {
        $onAction.invoke(new IFullscreenLoginAction.AgreementCheckedAction(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerLoginPage$lambda$6$0(Function1 $onAction) {
        $onAction.invoke(IFullscreenLoginAction.TryOtherLoginWay.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerLoginPage$lambda$8$0(Function2 $routeToLogin) {
        $routeToLogin.invoke(ValidLoginType.PwdLogin, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerLoginPage$lambda$9$0(Function1 $onAction, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $onAction.invoke(new ISmsLoginAction.PhoneInputAction(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerLoginPage$lambda$10$0(Function1 $onAction, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $onAction.invoke(new ISmsLoginAction.SmsCodeInputAction(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerLoginPage$lambda$11$0(Function1 $onAction) {
        $onAction.invoke(new ISmsLoginAction.ClickSendSmsAction(null, null, 3, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerLoginPage$lambda$12$0(Function1 $onAction, boolean it) {
        $onAction.invoke(new IFullscreenLoginAction.AgreementCheckedAction(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerLoginPage$lambda$13$0(Function1 $onCountryCodeSwitchClick, SmsLoginInput it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $onCountryCodeSwitchClick.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0241, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x028e, code lost:
        if (r9 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void InnerPhoneOrPasswordLoginPage(final IPhoneOrPasswordLoginPage page, final Function2<? super ValidLoginType, ? super Boolean, Unit> function2, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(page, LoginReporterV2.PAGE_FROM_KEY);
        Intrinsics.checkNotNullParameter(function2, "routeToLogin");
        Composer $composer2 = $composer.startRestartGroup(1706784246);
        ComposerKt.sourceInformation($composer2, "C(InnerPhoneOrPasswordLoginPage)N(page,routeToLogin)177@7562L711:InnerLoginPage.kt#1fav2j");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(page) : $composer2.changedInstance(page) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if (!$composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1706784246, $dirty, -1, "tv.danmaku.bili.inner.ui.InnerPhoneOrPasswordLoginPage (InnerLoginPage.kt:171)");
            }
            if (Intrinsics.areEqual(page, PhoneOrPasswordLoginIdlePage.INSTANCE)) {
                $composer2.startReplaceGroup(-1308167901);
                ComposerKt.sourceInformation($composer2, "173@7483L68,173@7462L89");
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, -457840006, "CC(remember):InnerLoginPage.kt#9igjgp");
                boolean invalid$iv = ($dirty & BR.containerVisible) == 32;
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = (Function2) new InnerLoginPageKt$InnerPhoneOrPasswordLoginPage$1$1(function2, null);
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer2, 6);
            } else {
                $composer2.startReplaceGroup(-1315564532);
            }
            $composer2.endReplaceGroup();
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(48), 0.0f, 2, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((BR.nickTextColor >> 3) & 14) | ((BR.nickTextColor >> 3) & BR.containerVisible));
            int $changed$iv$iv = (BR.nickTextColor << 3) & BR.containerVisible;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((BR.nickTextColor >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1355351960, "C178@7680L12,180@7734L77,184@7958L75,179@7701L342,189@8085L76,190@8191L75,188@8052L215:InnerLoginPage.kt#1fav2j");
            TipToLogin($composer2, 0);
            String stringResource = StringResources_androidKt.stringResource(R.string.account_global_string_186, $composer2, 0);
            Modifier modifier = SizeKt.width-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(64), 0.0f, Dp.constructor-impl(24), 5, (Object) null), Dp.constructor-impl((float) BR.headerTitle));
            ComposerKt.sourceInformationMarkerStart($composer2, 182276747, "CC(remember):InnerLoginPage.kt#9igjgp");
            boolean invalid$iv2 = ($dirty & BR.containerVisible) == 32;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda15
                public final Object invoke() {
                    Unit InnerPhoneOrPasswordLoginPage$lambda$1$0$0;
                    InnerPhoneOrPasswordLoginPage$lambda$1$0$0 = InnerLoginPageKt.InnerPhoneOrPasswordLoginPage$lambda$1$0$0(function2);
                    return InnerPhoneOrPasswordLoginPage$lambda$1$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CommonKt.LoginButton(stringResource, false, modifier, (Function0) it$iv2, $composer2, BR.negativeBtnVisible, 2);
            String stringResource2 = StringResources_androidKt.stringResource(R.string.account_global_string_72, $composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, 182284203, "CC(remember):InnerLoginPage.kt#9igjgp");
            boolean invalid$iv3 = ($dirty & BR.containerVisible) == 32;
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv3 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda16
                public final Object invoke() {
                    Unit InnerPhoneOrPasswordLoginPage$lambda$1$1$0;
                    InnerPhoneOrPasswordLoginPage$lambda$1$1$0 = InnerLoginPageKt.InnerPhoneOrPasswordLoginPage$lambda$1$1$0(function2);
                    return InnerPhoneOrPasswordLoginPage$lambda$1$1$0;
                }
            };
            $composer2.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CommonKt.SwitchLogin(stringResource2, null, (Function0) it$iv3, $composer2, 0, 2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda17
                public final Object invoke(Object obj, Object obj2) {
                    Unit InnerPhoneOrPasswordLoginPage$lambda$2;
                    InnerPhoneOrPasswordLoginPage$lambda$2 = InnerLoginPageKt.InnerPhoneOrPasswordLoginPage$lambda$2(IPhoneOrPasswordLoginPage.this, function2, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return InnerPhoneOrPasswordLoginPage$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerPhoneOrPasswordLoginPage$lambda$1$0$0(Function2 $routeToLogin) {
        $routeToLogin.invoke(ValidLoginType.SmsLogin, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerPhoneOrPasswordLoginPage$lambda$1$1$0(Function2 $routeToLogin) {
        $routeToLogin.invoke(ValidLoginType.PwdLogin, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerOverseaLoginPage$lambda$0$0(boolean it) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerOverseaLoginPage$lambda$2$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerOverseaLoginPage$lambda$3$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerOverseaLoginPage$lambda$5$0(boolean it) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerOverseaLoginPage$lambda$6$0(SmsLoginInput it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerOverseaLoginPage$lambda$7$0(boolean z, LoginWay loginWay) {
        Intrinsics.checkNotNullParameter(loginWay, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerOverseaLoginPage$lambda$8$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:297:0x0912, code lost:
        if (r13 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x0a83, code lost:
        if (r13 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L197;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:262:0x07f7  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x07f9  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x084c  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x084e  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0861  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0870 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:286:0x08cf  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x08f5  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x08f7  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x090a  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0916  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x095e  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0960  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x096b  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x097b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:316:0x09d9  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x09db  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x09e6  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x09f6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0a1e  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0a20  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0a32  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0a41 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:340:0x0a69  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0a6b  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0a7b  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x0a87  */
    /* JADX WARN: Type inference failed for: r10v47 */
    /* JADX WARN: Type inference failed for: r12v46 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void InnerOverseaLoginPage(final IOverseaLoginState pageOversea, final Function1<? super IFullscreenAction, Unit> function1, Function1<? super Boolean, Unit> function12, Function0<Unit> function0, Function1<? super String, Unit> function13, Function1<? super String, Unit> function14, Function0<Unit> function02, Function1<? super Boolean, Unit> function15, Function1<? super SmsLoginInput, Unit> function16, Function2<? super Boolean, ? super LoginWay, Unit> function2, Function1<? super String, Unit> function17, Composer $composer, final int $changed, final int $changed1, final int i) {
        int $dirty;
        int $dirty1;
        Composer $composer2;
        Function1 onLoginClick;
        Function0 onSwitchClick;
        Function1 onPhoneInput;
        Function1 onSmsCodeInput;
        Function0 onSendCodeClick;
        Function1 onLoginAgreementChecked;
        final Function1 onCountryCodeSwitchClick;
        Function2<? super Boolean, ? super LoginWay, Unit> function22;
        Function1 routeTo;
        Function1 onLoginClick2;
        Function0 onSwitchClick2;
        Function1 onPhoneInput2;
        Function1 onSmsCodeInput2;
        Function0 onSendCodeClick2;
        Function1 onLoginAgreementChecked2;
        Function1 onCountryCodeSwitchClick2;
        Function2<? super Boolean, ? super LoginWay, Unit> function23;
        Function1 routeTo2;
        OverseaLoginState oversea;
        final SmsLoginInput pageState;
        Function1 routeTo3;
        final Function2<? super Boolean, ? super LoginWay, Unit> function24;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        final Function0 onSendCodeClick3;
        Object value$iv;
        boolean invalid$iv;
        Object it$iv;
        Object value$iv2;
        boolean invalid$iv2;
        Object it$iv2;
        final Function1 onLoginClick3;
        Object value$iv3;
        boolean invalid$iv3;
        boolean invalid$iv4;
        boolean invalid$iv5;
        final Function0 onSwitchClick3;
        boolean invalid$iv6;
        Object it$iv3;
        Object value$iv4;
        boolean invalid$iv7;
        Intrinsics.checkNotNullParameter(pageOversea, "pageOversea");
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Composer $composer3 = $composer.startRestartGroup(-1073535769);
        ComposerKt.sourceInformation($composer3, "C(InnerOverseaLoginPage)N(pageOversea,onAction,onLoginClick,onSwitchClick,onPhoneInput,onSmsCodeInput,onSendCodeClick,onLoginAgreementChecked,onCountryCodeSwitchClick,onOverseaClick,routeTo)200@8434L2,201@8470L2,202@8511L2,203@8554L2,204@8592L2,205@8645L2,206@8705L2,207@8759L11,208@8804L2:InnerLoginPage.kt#1fav2j");
        int $dirty2 = $changed;
        int $dirty12 = $changed1;
        if (($changed & 6) == 0) {
            $dirty2 |= ($changed & 8) == 0 ? $composer3.changed(pageOversea) : $composer3.changedInstance(pageOversea) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= BR.negativeBtnVisible;
        } else if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty2 |= $composer3.changedInstance(function12) ? BR.hallEnterHotText : BR.cover;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changedInstance(function0) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty2 |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty2 |= $composer3.changedInstance(function13) ? RingBuffer.CONSUME_SIZE : 8192;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty2 |= $composer3.changedInstance(function14) ? 131072 : AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changedInstance(function02) ? 1048576 : 524288;
        }
        int i7 = i & BR.cover;
        if (i7 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changedInstance(function15) ? 8388608 : 4194304;
        }
        int i8 = i & BR.hallEnterHotText;
        if (i8 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer3.changedInstance(function16) ? 67108864 : 33554432;
        }
        int i9 = i & BR.roleType;
        if (i9 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 536870912 : 268435456;
        }
        int i10 = i & MisakaHelper.MAX_REPORT_SIZE;
        if (i10 != 0) {
            $dirty12 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty12 |= $composer3.changedInstance(function17) ? 4 : 2;
        }
        if ($composer3.shouldExecute((($dirty2 & 306783379) == 306783378 && ($dirty12 & 3) == 2) ? false : true, $dirty2 & 1)) {
            if (i2 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -875718327, "CC(remember):InnerLoginPage.kt#9igjgp");
                Object it$iv4 = $composer3.rememberedValue();
                if (it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv5 = new Function1() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda10
                        public final Object invoke(Object obj) {
                            Unit InnerOverseaLoginPage$lambda$0$0;
                            InnerOverseaLoginPage$lambda$0$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$0$0(((Boolean) obj).booleanValue());
                            return InnerOverseaLoginPage$lambda$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv5);
                    it$iv4 = value$iv5;
                }
                onLoginClick2 = it$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                onLoginClick2 = function12;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -875717175, "CC(remember):InnerLoginPage.kt#9igjgp");
                Object it$iv5 = $composer3.rememberedValue();
                if (it$iv5 == Composer.Companion.getEmpty()) {
                    Object value$iv6 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv6);
                    it$iv5 = value$iv6;
                }
                onSwitchClick2 = (Function0) it$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                onSwitchClick2 = function0;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -875715863, "CC(remember):InnerLoginPage.kt#9igjgp");
                Object it$iv6 = $composer3.rememberedValue();
                if (it$iv6 == Composer.Companion.getEmpty()) {
                    Object value$iv7 = new Function1() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            Unit InnerOverseaLoginPage$lambda$2$0;
                            InnerOverseaLoginPage$lambda$2$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$2$0((String) obj);
                            return InnerOverseaLoginPage$lambda$2$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv7);
                    it$iv6 = value$iv7;
                }
                onPhoneInput2 = (Function1) it$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                onPhoneInput2 = function13;
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -875714487, "CC(remember):InnerLoginPage.kt#9igjgp");
                Object it$iv7 = $composer3.rememberedValue();
                if (it$iv7 == Composer.Companion.getEmpty()) {
                    Object value$iv8 = new Function1() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            Unit InnerOverseaLoginPage$lambda$3$0;
                            InnerOverseaLoginPage$lambda$3$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$3$0((String) obj);
                            return InnerOverseaLoginPage$lambda$3$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv8);
                    it$iv7 = value$iv8;
                }
                onSmsCodeInput2 = (Function1) it$iv7;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                onSmsCodeInput2 = function14;
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -875713271, "CC(remember):InnerLoginPage.kt#9igjgp");
                Object it$iv8 = $composer3.rememberedValue();
                onSwitchClick = onSwitchClick2;
                if (it$iv8 == Composer.Companion.getEmpty()) {
                    Object value$iv9 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv9);
                    it$iv8 = value$iv9;
                }
                onSendCodeClick2 = it$iv8;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                onSwitchClick = onSwitchClick2;
                onSendCodeClick2 = function02;
            }
            if (i7 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -875711575, "CC(remember):InnerLoginPage.kt#9igjgp");
                Object it$iv9 = $composer3.rememberedValue();
                if (it$iv9 == Composer.Companion.getEmpty()) {
                    Object value$iv10 = new Function1() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj) {
                            Unit InnerOverseaLoginPage$lambda$5$0;
                            InnerOverseaLoginPage$lambda$5$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$5$0(((Boolean) obj).booleanValue());
                            return InnerOverseaLoginPage$lambda$5$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv10);
                    it$iv9 = value$iv10;
                }
                onLoginAgreementChecked2 = (Function1) it$iv9;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                onLoginAgreementChecked2 = function15;
            }
            if (i8 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -875709655, "CC(remember):InnerLoginPage.kt#9igjgp");
                Object it$iv10 = $composer3.rememberedValue();
                if (it$iv10 == Composer.Companion.getEmpty()) {
                    Object value$iv11 = new Function1() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda6
                        public final Object invoke(Object obj) {
                            Unit InnerOverseaLoginPage$lambda$6$0;
                            InnerOverseaLoginPage$lambda$6$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$6$0((SmsLoginInput) obj);
                            return InnerOverseaLoginPage$lambda$6$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv11);
                    it$iv10 = value$iv11;
                }
                onCountryCodeSwitchClick2 = (Function1) it$iv10;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                onCountryCodeSwitchClick2 = function16;
            }
            if (i9 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -875707918, "CC(remember):InnerLoginPage.kt#9igjgp");
                Object it$iv11 = $composer3.rememberedValue();
                if (it$iv11 == Composer.Companion.getEmpty()) {
                    Object value$iv12 = new Function2() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda7
                        public final Object invoke(Object obj, Object obj2) {
                            Unit InnerOverseaLoginPage$lambda$7$0;
                            InnerOverseaLoginPage$lambda$7$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$7$0(((Boolean) obj).booleanValue(), (LoginWay) obj2);
                            return InnerOverseaLoginPage$lambda$7$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv12);
                    it$iv11 = value$iv12;
                }
                function23 = (Function2) it$iv11;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                function23 = function2;
            }
            if (i10 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -875706487, "CC(remember):InnerLoginPage.kt#9igjgp");
                Object it$iv12 = $composer3.rememberedValue();
                if (it$iv12 == Composer.Companion.getEmpty()) {
                    Object value$iv13 = new Function1() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda8
                        public final Object invoke(Object obj) {
                            Unit InnerOverseaLoginPage$lambda$8$0;
                            InnerOverseaLoginPage$lambda$8$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$8$0((String) obj);
                            return InnerOverseaLoginPage$lambda$8$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv13);
                    it$iv12 = value$iv13;
                }
                routeTo2 = (Function1) it$iv12;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                routeTo2 = function17;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1073535769, $dirty2, $dirty12, "tv.danmaku.bili.inner.ui.InnerOverseaLoginPage (InnerLoginPage.kt:209)");
            }
            if (pageOversea instanceof OverseaLoginState) {
                oversea = (OverseaLoginState) pageOversea;
            } else if (!(pageOversea instanceof OverSeaLoadingState)) {
                throw new NoWhenBranchMatchedException();
            } else {
                oversea = ((OverSeaLoadingState) pageOversea).getOriginal();
            }
            ISmsLoginPageState page = oversea.getSmsLoginState();
            if (page instanceof SmsLoginLoadingCountingState) {
                pageState = ((SmsLoginLoadingCountingState) page).getOriginal().getInput();
            } else if (page instanceof SmsLoginPageInputCountingState) {
                pageState = ((SmsLoginPageInputCountingState) page).getInput();
            } else if (page instanceof SmsLoginPageInputIdleState) {
                pageState = ((SmsLoginPageInputIdleState) page).getInput();
            } else if (page instanceof SmsLoginLoadingIdleState) {
                pageState = ((SmsLoginLoadingIdleState) page).getInput();
            } else if (page instanceof SmsLoginSelectCountryCodeState) {
                pageState = ((SmsLoginSelectCountryCodeState) page).getCurrentInput();
            } else if (page instanceof SmsLoginPageInitialState) {
                pageState = null;
            } else if (!(page instanceof NetCodeEnableState)) {
                throw new NoWhenBranchMatchedException();
            } else {
                pageState = null;
            }
            int counting = page instanceof ISmsLoginCountingState ? ((ISmsLoginCountingState) page).getCountDown() : 0;
            if (pageState != null) {
                $composer3.startReplaceGroup(-1376231458);
                ComposerKt.sourceInformation($composer3, "234@9603L2669");
                Function2<? super Boolean, ? super LoginWay, Unit> function25 = function23;
                ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Modifier modifier$iv = Modifier.Companion;
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                routeTo3 = routeTo2;
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                onLoginAgreementChecked = onLoginAgreementChecked2;
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & BR.containerVisible));
                int $changed$iv$iv = (0 << 3) & BR.containerVisible;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                $dirty1 = $dirty12;
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                onSmsCodeInput = onSmsCodeInput2;
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
                onPhoneInput = onPhoneInput2;
                Function1 onLoginClick4 = onLoginClick2;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i11 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i12 = ((0 >> 6) & BR.containerVisible) | 6;
                ColumnScope $this$InnerOverseaLoginPage_u24lambda_u249 = columnScope;
                ComposerKt.sourceInformationMarkerStart($composer3, -892039427, "C235@9624L41,236@9678L207,242@9898L2364:InnerLoginPage.kt#1fav2j");
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), $composer3, 6);
                Modifier modifier$iv2 = $this$InnerOverseaLoginPage_u24lambda_u249.align(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getCenterHorizontally());
                Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (48 << 3) & BR.containerVisible;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                onCountryCodeSwitchClick = onCountryCodeSwitchClick2;
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
                Function0 onSendCodeClick4 = onSendCodeClick2;
                int $dirty3 = $dirty2;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i13 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i14 = ((48 >> 6) & BR.containerVisible) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -644429767, "C240@9859L12:InnerLoginPage.kt#1fav2j");
                TipToLogin($composer3, 0);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier$iv3 = WindowInsetsPadding_androidKt.navigationBarsPadding(PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(24), 0.0f, 2, (Object) null), 0.0f, Dp.constructor-impl(20), 0.0f, 0.0f, 13, (Object) null));
                Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((BR.negativeBtnVisible >> 3) & 14) | ((BR.negativeBtnVisible >> 3) & BR.containerVisible));
                int $changed$iv$iv3 = (BR.negativeBtnVisible << 3) & BR.containerVisible;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $i$f$Column = $changed$iv$iv3 << 6;
                int $changed$iv$iv$iv3 = ($i$f$Column & 896) | 6;
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
                int i15 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                int i16 = ((BR.negativeBtnVisible >> 6) & BR.containerVisible) | 6;
                ColumnScope $this$InnerOverseaLoginPage_u24lambda_u249_u241 = columnScope2;
                ComposerKt.sourceInformationMarkerStart($composer3, -415113565, "C257@10565L21,258@10629L39,259@10705L44,250@10214L553,264@10996L70,265@11103L44,261@10784L381,267@11182L41,273@11454L162,269@11241L394,278@11653L41,282@11808L63,285@11909L110,288@12059L114,280@11712L480,293@12210L38:InnerLoginPage.kt#1fav2j");
                String phone = pageState.getPhone();
                String smsCode = pageState.getSmsCode();
                PhoneCountryCode selectedCountry = pageState.getSelectedCountry();
                ComposerKt.sourceInformationMarkerStart($composer3, 263713123, "CC(remember):InnerLoginPage.kt#9igjgp");
                boolean invalid$iv8 = ($dirty3 & 3670016) == 1048576;
                Object it$iv13 = $composer3.rememberedValue();
                if (!invalid$iv8 && it$iv13 != Composer.Companion.getEmpty()) {
                    value$iv = it$iv13;
                    onSendCodeClick3 = onSendCodeClick4;
                    Function0 function03 = (Function0) value$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerStart($composer3, 263715189, "CC(remember):InnerLoginPage.kt#9igjgp");
                    $composer2 = $composer3;
                    invalid$iv = (($dirty3 & 234881024) != 67108864) | $composer2.changedInstance(pageState);
                    onSendCodeClick = onSendCodeClick3;
                    it$iv = $composer3.rememberedValue();
                    if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                        value$iv2 = it$iv;
                        Function0 function04 = (Function0) value$iv2;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerStart($composer3, 263717626, "CC(remember):InnerLoginPage.kt#9igjgp");
                        invalid$iv2 = (($dirty3 & 896) != 256) | $composer2.changedInstance(pageState);
                        it$iv2 = $composer3.rememberedValue();
                        if (!invalid$iv2 && it$iv2 != Composer.Companion.getEmpty()) {
                            value$iv3 = it$iv2;
                            onLoginClick3 = onLoginClick4;
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            SmsLoginPageKt.SmsInputGroup(phone, selectedCountry, smsCode, counting, onPhoneInput, onSmsCodeInput, function03, function04, (Function0) value$iv3, $composer3, (57344 & $dirty3) | (458752 & $dirty3));
                            Modifier modifier = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(32), 0.0f, Dp.constructor-impl(24), 5, (Object) null);
                            boolean z = StringsKt.isBlank(pageState.getPhone()) && !StringsKt.isBlank(pageState.getSmsCode());
                            String stringResource = StringResources_androidKt.stringResource(bili.resource.common.R.string.common_global_string_290, $composer3, 0);
                            ComposerKt.sourceInformationMarkerStart($composer3, 263730362, "CC(remember):InnerLoginPage.kt#9igjgp");
                            invalid$iv3 = (($dirty3 & 896) != 256) | $composer2.changedInstance(pageState);
                            Object it$iv14 = $composer3.rememberedValue();
                            if (invalid$iv3) {
                            }
                            Object value$iv14 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda41
                                public final Object invoke() {
                                    Unit InnerOverseaLoginPage$lambda$9$1$3$0;
                                    InnerOverseaLoginPage$lambda$9$1$3$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$3$0(onLoginClick3, pageState);
                                    return InnerOverseaLoginPage$lambda$9$1$3$0;
                                }
                            };
                            $composer3.updateRememberedValue(value$iv14);
                            it$iv14 = value$iv14;
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            CommonKt.LoginButton(stringResource, z, modifier, (Function0) it$iv14, $composer3, BR.negativeBtnVisible, 0);
                            onLoginClick = onLoginClick3;
                            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32)), $composer3, 6);
                            boolean agreementChecked = pageState.getAgreementChecked();
                            ComposerKt.sourceInformationMarkerStart($composer3, 263741712, "CC(remember):InnerLoginPage.kt#9igjgp");
                            invalid$iv4 = ($dirty3 & BR.containerVisible) != 32;
                            Object it$iv15 = $composer3.rememberedValue();
                            if (!invalid$iv4 && it$iv15 != Composer.Companion.getEmpty()) {
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                CommonKt.LoginAgreement(null, agreementChecked, null, onLoginAgreementChecked, routeTo3, (Function3) it$iv15, null, $composer3, (($dirty3 >> 12) & 7168) | (($dirty1 << 12) & 57344), 69);
                                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(60)), $composer3, 6);
                                Modifier modifier2 = Modifier.Companion;
                                ComposerKt.sourceInformationMarkerStart($composer3, 263752941, "CC(remember):InnerLoginPage.kt#9igjgp");
                                invalid$iv5 = ($dirty3 & 7168) != 2048;
                                Object it$iv16 = $composer3.rememberedValue();
                                if (!invalid$iv5 && it$iv16 != Composer.Companion.getEmpty()) {
                                    onSwitchClick3 = onSwitchClick;
                                    Function0 function05 = (Function0) it$iv16;
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    ComposerKt.sourceInformationMarkerStart($composer3, 263756220, "CC(remember):InnerLoginPage.kt#9igjgp");
                                    invalid$iv6 = ((1879048192 & $dirty3) != 536870912) | $composer2.changedInstance(pageState);
                                    onSwitchClick = onSwitchClick3;
                                    it$iv3 = $composer3.rememberedValue();
                                    if (!invalid$iv6 && it$iv3 != Composer.Companion.getEmpty()) {
                                        value$iv4 = it$iv3;
                                        function24 = function25;
                                        Function0 function06 = (Function0) value$iv4;
                                        ComposerKt.sourceInformationMarkerEnd($composer3);
                                        ComposerKt.sourceInformationMarkerStart($composer3, 263761024, "CC(remember):InnerLoginPage.kt#9igjgp");
                                        invalid$iv7 = ((1879048192 & $dirty3) != 536870912) | $composer2.changedInstance(pageState);
                                        Object it$iv17 = $composer3.rememberedValue();
                                        if (invalid$iv7) {
                                            $dirty = $dirty3;
                                        } else {
                                            $dirty = $dirty3;
                                        }
                                        Object value$iv15 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda45
                                            public final Object invoke() {
                                                Unit InnerOverseaLoginPage$lambda$9$1$7$0;
                                                InnerOverseaLoginPage$lambda$9$1$7$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$7$0(function24, pageState);
                                                return InnerOverseaLoginPage$lambda$9$1$7$0;
                                            }
                                        };
                                        $composer3.updateRememberedValue(value$iv15);
                                        it$iv17 = value$iv15;
                                        ComposerKt.sourceInformationMarkerEnd($composer3);
                                        CommonKt.ThirdPartyLogin(modifier2, false, false, function05, function06, (Function0) it$iv17, $composer3, 6, 6);
                                        SpacerKt.Spacer(ColumnScope.-CC.weight$default($this$InnerOverseaLoginPage_u24lambda_u249_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
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
                                        $composer2.endReplaceGroup();
                                    }
                                    function24 = function25;
                                    Object obj = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda44
                                        public final Object invoke() {
                                            Unit InnerOverseaLoginPage$lambda$9$1$6$0;
                                            InnerOverseaLoginPage$lambda$9$1$6$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$6$0(function24, pageState);
                                            return InnerOverseaLoginPage$lambda$9$1$6$0;
                                        }
                                    };
                                    $composer3.updateRememberedValue(obj);
                                    value$iv4 = obj;
                                    Function0 function062 = (Function0) value$iv4;
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    ComposerKt.sourceInformationMarkerStart($composer3, 263761024, "CC(remember):InnerLoginPage.kt#9igjgp");
                                    invalid$iv7 = ((1879048192 & $dirty3) != 536870912) | $composer2.changedInstance(pageState);
                                    Object it$iv172 = $composer3.rememberedValue();
                                    if (invalid$iv7) {
                                    }
                                    Object value$iv152 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda45
                                        public final Object invoke() {
                                            Unit InnerOverseaLoginPage$lambda$9$1$7$0;
                                            InnerOverseaLoginPage$lambda$9$1$7$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$7$0(function24, pageState);
                                            return InnerOverseaLoginPage$lambda$9$1$7$0;
                                        }
                                    };
                                    $composer3.updateRememberedValue(value$iv152);
                                    it$iv172 = value$iv152;
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    CommonKt.ThirdPartyLogin(modifier2, false, false, function05, function062, (Function0) it$iv172, $composer3, 6, 6);
                                    SpacerKt.Spacer(ColumnScope.-CC.weight$default($this$InnerOverseaLoginPage_u24lambda_u249_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
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
                                    $composer2.endReplaceGroup();
                                }
                                onSwitchClick3 = onSwitchClick;
                                Object value$iv16 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda43
                                    public final Object invoke() {
                                        Unit InnerOverseaLoginPage$lambda$9$1$5$0;
                                        InnerOverseaLoginPage$lambda$9$1$5$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$5$0(onSwitchClick3);
                                        return InnerOverseaLoginPage$lambda$9$1$5$0;
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv16);
                                it$iv16 = value$iv16;
                                Function0 function052 = (Function0) it$iv16;
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerStart($composer3, 263756220, "CC(remember):InnerLoginPage.kt#9igjgp");
                                invalid$iv6 = ((1879048192 & $dirty3) != 536870912) | $composer2.changedInstance(pageState);
                                onSwitchClick = onSwitchClick3;
                                it$iv3 = $composer3.rememberedValue();
                                if (!invalid$iv6) {
                                    value$iv4 = it$iv3;
                                    function24 = function25;
                                    Function0 function0622 = (Function0) value$iv4;
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    ComposerKt.sourceInformationMarkerStart($composer3, 263761024, "CC(remember):InnerLoginPage.kt#9igjgp");
                                    invalid$iv7 = ((1879048192 & $dirty3) != 536870912) | $composer2.changedInstance(pageState);
                                    Object it$iv1722 = $composer3.rememberedValue();
                                    if (invalid$iv7) {
                                    }
                                    Object value$iv1522 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda45
                                        public final Object invoke() {
                                            Unit InnerOverseaLoginPage$lambda$9$1$7$0;
                                            InnerOverseaLoginPage$lambda$9$1$7$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$7$0(function24, pageState);
                                            return InnerOverseaLoginPage$lambda$9$1$7$0;
                                        }
                                    };
                                    $composer3.updateRememberedValue(value$iv1522);
                                    it$iv1722 = value$iv1522;
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    CommonKt.ThirdPartyLogin(modifier2, false, false, function052, function0622, (Function0) it$iv1722, $composer3, 6, 6);
                                    SpacerKt.Spacer(ColumnScope.-CC.weight$default($this$InnerOverseaLoginPage_u24lambda_u249_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
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
                                    $composer2.endReplaceGroup();
                                }
                                function24 = function25;
                                Object obj2 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda44
                                    public final Object invoke() {
                                        Unit InnerOverseaLoginPage$lambda$9$1$6$0;
                                        InnerOverseaLoginPage$lambda$9$1$6$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$6$0(function24, pageState);
                                        return InnerOverseaLoginPage$lambda$9$1$6$0;
                                    }
                                };
                                $composer3.updateRememberedValue(obj2);
                                value$iv4 = obj2;
                                Function0 function06222 = (Function0) value$iv4;
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerStart($composer3, 263761024, "CC(remember):InnerLoginPage.kt#9igjgp");
                                invalid$iv7 = ((1879048192 & $dirty3) != 536870912) | $composer2.changedInstance(pageState);
                                Object it$iv17222 = $composer3.rememberedValue();
                                if (invalid$iv7) {
                                }
                                Object value$iv15222 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda45
                                    public final Object invoke() {
                                        Unit InnerOverseaLoginPage$lambda$9$1$7$0;
                                        InnerOverseaLoginPage$lambda$9$1$7$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$7$0(function24, pageState);
                                        return InnerOverseaLoginPage$lambda$9$1$7$0;
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv15222);
                                it$iv17222 = value$iv15222;
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                CommonKt.ThirdPartyLogin(modifier2, false, false, function052, function06222, (Function0) it$iv17222, $composer3, 6, 6);
                                SpacerKt.Spacer(ColumnScope.-CC.weight$default($this$InnerOverseaLoginPage_u24lambda_u249_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
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
                                $composer2.endReplaceGroup();
                            }
                            Object value$iv17 = new Function3() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda42
                                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                                    Unit InnerOverseaLoginPage$lambda$9$1$4$0;
                                    InnerOverseaLoginPage$lambda$9$1$4$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$4$0(function1, (EulaLinkType) obj3, ((Boolean) obj4).booleanValue(), (EulaTriggerType) obj5);
                                    return InnerOverseaLoginPage$lambda$9$1$4$0;
                                }
                            };
                            $composer3.updateRememberedValue(value$iv17);
                            it$iv15 = value$iv17;
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            CommonKt.LoginAgreement(null, agreementChecked, null, onLoginAgreementChecked, routeTo3, (Function3) it$iv15, null, $composer3, (($dirty3 >> 12) & 7168) | (($dirty1 << 12) & 57344), 69);
                            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(60)), $composer3, 6);
                            Modifier modifier22 = Modifier.Companion;
                            ComposerKt.sourceInformationMarkerStart($composer3, 263752941, "CC(remember):InnerLoginPage.kt#9igjgp");
                            if (($dirty3 & 7168) != 2048) {
                            }
                            Object it$iv162 = $composer3.rememberedValue();
                            if (!invalid$iv5) {
                                onSwitchClick3 = onSwitchClick;
                                Function0 function0522 = (Function0) it$iv162;
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerStart($composer3, 263756220, "CC(remember):InnerLoginPage.kt#9igjgp");
                                invalid$iv6 = ((1879048192 & $dirty3) != 536870912) | $composer2.changedInstance(pageState);
                                onSwitchClick = onSwitchClick3;
                                it$iv3 = $composer3.rememberedValue();
                                if (!invalid$iv6) {
                                }
                                function24 = function25;
                                Object obj22 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda44
                                    public final Object invoke() {
                                        Unit InnerOverseaLoginPage$lambda$9$1$6$0;
                                        InnerOverseaLoginPage$lambda$9$1$6$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$6$0(function24, pageState);
                                        return InnerOverseaLoginPage$lambda$9$1$6$0;
                                    }
                                };
                                $composer3.updateRememberedValue(obj22);
                                value$iv4 = obj22;
                                Function0 function062222 = (Function0) value$iv4;
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerStart($composer3, 263761024, "CC(remember):InnerLoginPage.kt#9igjgp");
                                invalid$iv7 = ((1879048192 & $dirty3) != 536870912) | $composer2.changedInstance(pageState);
                                Object it$iv172222 = $composer3.rememberedValue();
                                if (invalid$iv7) {
                                }
                                Object value$iv152222 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda45
                                    public final Object invoke() {
                                        Unit InnerOverseaLoginPage$lambda$9$1$7$0;
                                        InnerOverseaLoginPage$lambda$9$1$7$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$7$0(function24, pageState);
                                        return InnerOverseaLoginPage$lambda$9$1$7$0;
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv152222);
                                it$iv172222 = value$iv152222;
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                CommonKt.ThirdPartyLogin(modifier22, false, false, function0522, function062222, (Function0) it$iv172222, $composer3, 6, 6);
                                SpacerKt.Spacer(ColumnScope.-CC.weight$default($this$InnerOverseaLoginPage_u24lambda_u249_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
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
                                $composer2.endReplaceGroup();
                            }
                            onSwitchClick3 = onSwitchClick;
                            Object value$iv162 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda43
                                public final Object invoke() {
                                    Unit InnerOverseaLoginPage$lambda$9$1$5$0;
                                    InnerOverseaLoginPage$lambda$9$1$5$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$5$0(onSwitchClick3);
                                    return InnerOverseaLoginPage$lambda$9$1$5$0;
                                }
                            };
                            $composer3.updateRememberedValue(value$iv162);
                            it$iv162 = value$iv162;
                            Function0 function05222 = (Function0) it$iv162;
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerStart($composer3, 263756220, "CC(remember):InnerLoginPage.kt#9igjgp");
                            invalid$iv6 = ((1879048192 & $dirty3) != 536870912) | $composer2.changedInstance(pageState);
                            onSwitchClick = onSwitchClick3;
                            it$iv3 = $composer3.rememberedValue();
                            if (!invalid$iv6) {
                            }
                            function24 = function25;
                            Object obj222 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda44
                                public final Object invoke() {
                                    Unit InnerOverseaLoginPage$lambda$9$1$6$0;
                                    InnerOverseaLoginPage$lambda$9$1$6$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$6$0(function24, pageState);
                                    return InnerOverseaLoginPage$lambda$9$1$6$0;
                                }
                            };
                            $composer3.updateRememberedValue(obj222);
                            value$iv4 = obj222;
                            Function0 function0622222 = (Function0) value$iv4;
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerStart($composer3, 263761024, "CC(remember):InnerLoginPage.kt#9igjgp");
                            invalid$iv7 = ((1879048192 & $dirty3) != 536870912) | $composer2.changedInstance(pageState);
                            Object it$iv1722222 = $composer3.rememberedValue();
                            if (invalid$iv7) {
                            }
                            Object value$iv1522222 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda45
                                public final Object invoke() {
                                    Unit InnerOverseaLoginPage$lambda$9$1$7$0;
                                    InnerOverseaLoginPage$lambda$9$1$7$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$7$0(function24, pageState);
                                    return InnerOverseaLoginPage$lambda$9$1$7$0;
                                }
                            };
                            $composer3.updateRememberedValue(value$iv1522222);
                            it$iv1722222 = value$iv1522222;
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            CommonKt.ThirdPartyLogin(modifier22, false, false, function05222, function0622222, (Function0) it$iv1722222, $composer3, 6, 6);
                            SpacerKt.Spacer(ColumnScope.-CC.weight$default($this$InnerOverseaLoginPage_u24lambda_u249_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
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
                            $composer2.endReplaceGroup();
                        }
                        onLoginClick3 = onLoginClick4;
                        Object obj3 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda40
                            public final Object invoke() {
                                Unit InnerOverseaLoginPage$lambda$9$1$2$0;
                                InnerOverseaLoginPage$lambda$9$1$2$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$2$0(onLoginClick3, pageState);
                                return InnerOverseaLoginPage$lambda$9$1$2$0;
                            }
                        };
                        $composer3.updateRememberedValue(obj3);
                        value$iv3 = obj3;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        SmsLoginPageKt.SmsInputGroup(phone, selectedCountry, smsCode, counting, onPhoneInput, onSmsCodeInput, function03, function04, (Function0) value$iv3, $composer3, (57344 & $dirty3) | (458752 & $dirty3));
                        Modifier modifier3 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(32), 0.0f, Dp.constructor-impl(24), 5, (Object) null);
                        if (StringsKt.isBlank(pageState.getPhone())) {
                        }
                        String stringResource2 = StringResources_androidKt.stringResource(bili.resource.common.R.string.common_global_string_290, $composer3, 0);
                        ComposerKt.sourceInformationMarkerStart($composer3, 263730362, "CC(remember):InnerLoginPage.kt#9igjgp");
                        invalid$iv3 = (($dirty3 & 896) != 256) | $composer2.changedInstance(pageState);
                        Object it$iv142 = $composer3.rememberedValue();
                        if (invalid$iv3) {
                        }
                        Object value$iv142 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda41
                            public final Object invoke() {
                                Unit InnerOverseaLoginPage$lambda$9$1$3$0;
                                InnerOverseaLoginPage$lambda$9$1$3$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$3$0(onLoginClick3, pageState);
                                return InnerOverseaLoginPage$lambda$9$1$3$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv142);
                        it$iv142 = value$iv142;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        CommonKt.LoginButton(stringResource2, z, modifier3, (Function0) it$iv142, $composer3, BR.negativeBtnVisible, 0);
                        onLoginClick = onLoginClick3;
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32)), $composer3, 6);
                        boolean agreementChecked2 = pageState.getAgreementChecked();
                        ComposerKt.sourceInformationMarkerStart($composer3, 263741712, "CC(remember):InnerLoginPage.kt#9igjgp");
                        if (($dirty3 & BR.containerVisible) != 32) {
                        }
                        Object it$iv152 = $composer3.rememberedValue();
                        if (!invalid$iv4) {
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            CommonKt.LoginAgreement(null, agreementChecked2, null, onLoginAgreementChecked, routeTo3, (Function3) it$iv152, null, $composer3, (($dirty3 >> 12) & 7168) | (($dirty1 << 12) & 57344), 69);
                            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(60)), $composer3, 6);
                            Modifier modifier222 = Modifier.Companion;
                            ComposerKt.sourceInformationMarkerStart($composer3, 263752941, "CC(remember):InnerLoginPage.kt#9igjgp");
                            if (($dirty3 & 7168) != 2048) {
                            }
                            Object it$iv1622 = $composer3.rememberedValue();
                            if (!invalid$iv5) {
                            }
                            onSwitchClick3 = onSwitchClick;
                            Object value$iv1622 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda43
                                public final Object invoke() {
                                    Unit InnerOverseaLoginPage$lambda$9$1$5$0;
                                    InnerOverseaLoginPage$lambda$9$1$5$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$5$0(onSwitchClick3);
                                    return InnerOverseaLoginPage$lambda$9$1$5$0;
                                }
                            };
                            $composer3.updateRememberedValue(value$iv1622);
                            it$iv1622 = value$iv1622;
                            Function0 function052222 = (Function0) it$iv1622;
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerStart($composer3, 263756220, "CC(remember):InnerLoginPage.kt#9igjgp");
                            invalid$iv6 = ((1879048192 & $dirty3) != 536870912) | $composer2.changedInstance(pageState);
                            onSwitchClick = onSwitchClick3;
                            it$iv3 = $composer3.rememberedValue();
                            if (!invalid$iv6) {
                            }
                            function24 = function25;
                            Object obj2222 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda44
                                public final Object invoke() {
                                    Unit InnerOverseaLoginPage$lambda$9$1$6$0;
                                    InnerOverseaLoginPage$lambda$9$1$6$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$6$0(function24, pageState);
                                    return InnerOverseaLoginPage$lambda$9$1$6$0;
                                }
                            };
                            $composer3.updateRememberedValue(obj2222);
                            value$iv4 = obj2222;
                            Function0 function06222222 = (Function0) value$iv4;
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerStart($composer3, 263761024, "CC(remember):InnerLoginPage.kt#9igjgp");
                            invalid$iv7 = ((1879048192 & $dirty3) != 536870912) | $composer2.changedInstance(pageState);
                            Object it$iv17222222 = $composer3.rememberedValue();
                            if (invalid$iv7) {
                            }
                            Object value$iv15222222 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda45
                                public final Object invoke() {
                                    Unit InnerOverseaLoginPage$lambda$9$1$7$0;
                                    InnerOverseaLoginPage$lambda$9$1$7$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$7$0(function24, pageState);
                                    return InnerOverseaLoginPage$lambda$9$1$7$0;
                                }
                            };
                            $composer3.updateRememberedValue(value$iv15222222);
                            it$iv17222222 = value$iv15222222;
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            CommonKt.ThirdPartyLogin(modifier222, false, false, function052222, function06222222, (Function0) it$iv17222222, $composer3, 6, 6);
                            SpacerKt.Spacer(ColumnScope.-CC.weight$default($this$InnerOverseaLoginPage_u24lambda_u249_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
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
                            $composer2.endReplaceGroup();
                        }
                        Object value$iv172 = new Function3() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda42
                            public final Object invoke(Object obj32, Object obj4, Object obj5) {
                                Unit InnerOverseaLoginPage$lambda$9$1$4$0;
                                InnerOverseaLoginPage$lambda$9$1$4$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$4$0(function1, (EulaLinkType) obj32, ((Boolean) obj4).booleanValue(), (EulaTriggerType) obj5);
                                return InnerOverseaLoginPage$lambda$9$1$4$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv172);
                        it$iv152 = value$iv172;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        CommonKt.LoginAgreement(null, agreementChecked2, null, onLoginAgreementChecked, routeTo3, (Function3) it$iv152, null, $composer3, (($dirty3 >> 12) & 7168) | (($dirty1 << 12) & 57344), 69);
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(60)), $composer3, 6);
                        Modifier modifier2222 = Modifier.Companion;
                        ComposerKt.sourceInformationMarkerStart($composer3, 263752941, "CC(remember):InnerLoginPage.kt#9igjgp");
                        if (($dirty3 & 7168) != 2048) {
                        }
                        Object it$iv16222 = $composer3.rememberedValue();
                        if (!invalid$iv5) {
                        }
                        onSwitchClick3 = onSwitchClick;
                        Object value$iv16222 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda43
                            public final Object invoke() {
                                Unit InnerOverseaLoginPage$lambda$9$1$5$0;
                                InnerOverseaLoginPage$lambda$9$1$5$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$5$0(onSwitchClick3);
                                return InnerOverseaLoginPage$lambda$9$1$5$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv16222);
                        it$iv16222 = value$iv16222;
                        Function0 function0522222 = (Function0) it$iv16222;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerStart($composer3, 263756220, "CC(remember):InnerLoginPage.kt#9igjgp");
                        invalid$iv6 = ((1879048192 & $dirty3) != 536870912) | $composer2.changedInstance(pageState);
                        onSwitchClick = onSwitchClick3;
                        it$iv3 = $composer3.rememberedValue();
                        if (!invalid$iv6) {
                        }
                        function24 = function25;
                        Object obj22222 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda44
                            public final Object invoke() {
                                Unit InnerOverseaLoginPage$lambda$9$1$6$0;
                                InnerOverseaLoginPage$lambda$9$1$6$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$6$0(function24, pageState);
                                return InnerOverseaLoginPage$lambda$9$1$6$0;
                            }
                        };
                        $composer3.updateRememberedValue(obj22222);
                        value$iv4 = obj22222;
                        Function0 function062222222 = (Function0) value$iv4;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerStart($composer3, 263761024, "CC(remember):InnerLoginPage.kt#9igjgp");
                        invalid$iv7 = ((1879048192 & $dirty3) != 536870912) | $composer2.changedInstance(pageState);
                        Object it$iv172222222 = $composer3.rememberedValue();
                        if (invalid$iv7) {
                        }
                        Object value$iv152222222 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda45
                            public final Object invoke() {
                                Unit InnerOverseaLoginPage$lambda$9$1$7$0;
                                InnerOverseaLoginPage$lambda$9$1$7$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$7$0(function24, pageState);
                                return InnerOverseaLoginPage$lambda$9$1$7$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv152222222);
                        it$iv172222222 = value$iv152222222;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        CommonKt.ThirdPartyLogin(modifier2222, false, false, function0522222, function062222222, (Function0) it$iv172222222, $composer3, 6, 6);
                        SpacerKt.Spacer(ColumnScope.-CC.weight$default($this$InnerOverseaLoginPage_u24lambda_u249_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
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
                        $composer2.endReplaceGroup();
                    }
                    Object obj4 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda32
                        public final Object invoke() {
                            Unit InnerOverseaLoginPage$lambda$9$1$1$0;
                            InnerOverseaLoginPage$lambda$9$1$1$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$1$0(onCountryCodeSwitchClick, pageState);
                            return InnerOverseaLoginPage$lambda$9$1$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(obj4);
                    value$iv2 = obj4;
                    Function0 function042 = (Function0) value$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerStart($composer3, 263717626, "CC(remember):InnerLoginPage.kt#9igjgp");
                    invalid$iv2 = (($dirty3 & 896) != 256) | $composer2.changedInstance(pageState);
                    it$iv2 = $composer3.rememberedValue();
                    if (!invalid$iv2) {
                        value$iv3 = it$iv2;
                        onLoginClick3 = onLoginClick4;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        SmsLoginPageKt.SmsInputGroup(phone, selectedCountry, smsCode, counting, onPhoneInput, onSmsCodeInput, function03, function042, (Function0) value$iv3, $composer3, (57344 & $dirty3) | (458752 & $dirty3));
                        Modifier modifier32 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(32), 0.0f, Dp.constructor-impl(24), 5, (Object) null);
                        if (StringsKt.isBlank(pageState.getPhone())) {
                        }
                        String stringResource22 = StringResources_androidKt.stringResource(bili.resource.common.R.string.common_global_string_290, $composer3, 0);
                        ComposerKt.sourceInformationMarkerStart($composer3, 263730362, "CC(remember):InnerLoginPage.kt#9igjgp");
                        invalid$iv3 = (($dirty3 & 896) != 256) | $composer2.changedInstance(pageState);
                        Object it$iv1422 = $composer3.rememberedValue();
                        if (invalid$iv3) {
                        }
                        Object value$iv1422 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda41
                            public final Object invoke() {
                                Unit InnerOverseaLoginPage$lambda$9$1$3$0;
                                InnerOverseaLoginPage$lambda$9$1$3$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$3$0(onLoginClick3, pageState);
                                return InnerOverseaLoginPage$lambda$9$1$3$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv1422);
                        it$iv1422 = value$iv1422;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        CommonKt.LoginButton(stringResource22, z, modifier32, (Function0) it$iv1422, $composer3, BR.negativeBtnVisible, 0);
                        onLoginClick = onLoginClick3;
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32)), $composer3, 6);
                        boolean agreementChecked22 = pageState.getAgreementChecked();
                        ComposerKt.sourceInformationMarkerStart($composer3, 263741712, "CC(remember):InnerLoginPage.kt#9igjgp");
                        if (($dirty3 & BR.containerVisible) != 32) {
                        }
                        Object it$iv1522 = $composer3.rememberedValue();
                        if (!invalid$iv4) {
                        }
                        Object value$iv1722 = new Function3() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda42
                            public final Object invoke(Object obj32, Object obj42, Object obj5) {
                                Unit InnerOverseaLoginPage$lambda$9$1$4$0;
                                InnerOverseaLoginPage$lambda$9$1$4$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$4$0(function1, (EulaLinkType) obj32, ((Boolean) obj42).booleanValue(), (EulaTriggerType) obj5);
                                return InnerOverseaLoginPage$lambda$9$1$4$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv1722);
                        it$iv1522 = value$iv1722;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        CommonKt.LoginAgreement(null, agreementChecked22, null, onLoginAgreementChecked, routeTo3, (Function3) it$iv1522, null, $composer3, (($dirty3 >> 12) & 7168) | (($dirty1 << 12) & 57344), 69);
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(60)), $composer3, 6);
                        Modifier modifier22222 = Modifier.Companion;
                        ComposerKt.sourceInformationMarkerStart($composer3, 263752941, "CC(remember):InnerLoginPage.kt#9igjgp");
                        if (($dirty3 & 7168) != 2048) {
                        }
                        Object it$iv162222 = $composer3.rememberedValue();
                        if (!invalid$iv5) {
                        }
                        onSwitchClick3 = onSwitchClick;
                        Object value$iv162222 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda43
                            public final Object invoke() {
                                Unit InnerOverseaLoginPage$lambda$9$1$5$0;
                                InnerOverseaLoginPage$lambda$9$1$5$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$5$0(onSwitchClick3);
                                return InnerOverseaLoginPage$lambda$9$1$5$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv162222);
                        it$iv162222 = value$iv162222;
                        Function0 function05222222 = (Function0) it$iv162222;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerStart($composer3, 263756220, "CC(remember):InnerLoginPage.kt#9igjgp");
                        invalid$iv6 = ((1879048192 & $dirty3) != 536870912) | $composer2.changedInstance(pageState);
                        onSwitchClick = onSwitchClick3;
                        it$iv3 = $composer3.rememberedValue();
                        if (!invalid$iv6) {
                        }
                        function24 = function25;
                        Object obj222222 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda44
                            public final Object invoke() {
                                Unit InnerOverseaLoginPage$lambda$9$1$6$0;
                                InnerOverseaLoginPage$lambda$9$1$6$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$6$0(function24, pageState);
                                return InnerOverseaLoginPage$lambda$9$1$6$0;
                            }
                        };
                        $composer3.updateRememberedValue(obj222222);
                        value$iv4 = obj222222;
                        Function0 function0622222222 = (Function0) value$iv4;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerStart($composer3, 263761024, "CC(remember):InnerLoginPage.kt#9igjgp");
                        invalid$iv7 = ((1879048192 & $dirty3) != 536870912) | $composer2.changedInstance(pageState);
                        Object it$iv1722222222 = $composer3.rememberedValue();
                        if (invalid$iv7) {
                        }
                        Object value$iv1522222222 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda45
                            public final Object invoke() {
                                Unit InnerOverseaLoginPage$lambda$9$1$7$0;
                                InnerOverseaLoginPage$lambda$9$1$7$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$7$0(function24, pageState);
                                return InnerOverseaLoginPage$lambda$9$1$7$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv1522222222);
                        it$iv1722222222 = value$iv1522222222;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        CommonKt.ThirdPartyLogin(modifier22222, false, false, function05222222, function0622222222, (Function0) it$iv1722222222, $composer3, 6, 6);
                        SpacerKt.Spacer(ColumnScope.-CC.weight$default($this$InnerOverseaLoginPage_u24lambda_u249_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
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
                        $composer2.endReplaceGroup();
                    }
                    onLoginClick3 = onLoginClick4;
                    Object obj32 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda40
                        public final Object invoke() {
                            Unit InnerOverseaLoginPage$lambda$9$1$2$0;
                            InnerOverseaLoginPage$lambda$9$1$2$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$2$0(onLoginClick3, pageState);
                            return InnerOverseaLoginPage$lambda$9$1$2$0;
                        }
                    };
                    $composer3.updateRememberedValue(obj32);
                    value$iv3 = obj32;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    SmsLoginPageKt.SmsInputGroup(phone, selectedCountry, smsCode, counting, onPhoneInput, onSmsCodeInput, function03, function042, (Function0) value$iv3, $composer3, (57344 & $dirty3) | (458752 & $dirty3));
                    Modifier modifier322 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(32), 0.0f, Dp.constructor-impl(24), 5, (Object) null);
                    if (StringsKt.isBlank(pageState.getPhone())) {
                    }
                    String stringResource222 = StringResources_androidKt.stringResource(bili.resource.common.R.string.common_global_string_290, $composer3, 0);
                    ComposerKt.sourceInformationMarkerStart($composer3, 263730362, "CC(remember):InnerLoginPage.kt#9igjgp");
                    invalid$iv3 = (($dirty3 & 896) != 256) | $composer2.changedInstance(pageState);
                    Object it$iv14222 = $composer3.rememberedValue();
                    if (invalid$iv3) {
                    }
                    Object value$iv14222 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda41
                        public final Object invoke() {
                            Unit InnerOverseaLoginPage$lambda$9$1$3$0;
                            InnerOverseaLoginPage$lambda$9$1$3$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$3$0(onLoginClick3, pageState);
                            return InnerOverseaLoginPage$lambda$9$1$3$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv14222);
                    it$iv14222 = value$iv14222;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    CommonKt.LoginButton(stringResource222, z, modifier322, (Function0) it$iv14222, $composer3, BR.negativeBtnVisible, 0);
                    onLoginClick = onLoginClick3;
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32)), $composer3, 6);
                    boolean agreementChecked222 = pageState.getAgreementChecked();
                    ComposerKt.sourceInformationMarkerStart($composer3, 263741712, "CC(remember):InnerLoginPage.kt#9igjgp");
                    if (($dirty3 & BR.containerVisible) != 32) {
                    }
                    Object it$iv15222 = $composer3.rememberedValue();
                    if (!invalid$iv4) {
                    }
                    Object value$iv17222 = new Function3() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda42
                        public final Object invoke(Object obj322, Object obj42, Object obj5) {
                            Unit InnerOverseaLoginPage$lambda$9$1$4$0;
                            InnerOverseaLoginPage$lambda$9$1$4$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$4$0(function1, (EulaLinkType) obj322, ((Boolean) obj42).booleanValue(), (EulaTriggerType) obj5);
                            return InnerOverseaLoginPage$lambda$9$1$4$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv17222);
                    it$iv15222 = value$iv17222;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    CommonKt.LoginAgreement(null, agreementChecked222, null, onLoginAgreementChecked, routeTo3, (Function3) it$iv15222, null, $composer3, (($dirty3 >> 12) & 7168) | (($dirty1 << 12) & 57344), 69);
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(60)), $composer3, 6);
                    Modifier modifier222222 = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart($composer3, 263752941, "CC(remember):InnerLoginPage.kt#9igjgp");
                    if (($dirty3 & 7168) != 2048) {
                    }
                    Object it$iv1622222 = $composer3.rememberedValue();
                    if (!invalid$iv5) {
                    }
                    onSwitchClick3 = onSwitchClick;
                    Object value$iv1622222 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda43
                        public final Object invoke() {
                            Unit InnerOverseaLoginPage$lambda$9$1$5$0;
                            InnerOverseaLoginPage$lambda$9$1$5$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$5$0(onSwitchClick3);
                            return InnerOverseaLoginPage$lambda$9$1$5$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv1622222);
                    it$iv1622222 = value$iv1622222;
                    Function0 function052222222 = (Function0) it$iv1622222;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerStart($composer3, 263756220, "CC(remember):InnerLoginPage.kt#9igjgp");
                    invalid$iv6 = ((1879048192 & $dirty3) != 536870912) | $composer2.changedInstance(pageState);
                    onSwitchClick = onSwitchClick3;
                    it$iv3 = $composer3.rememberedValue();
                    if (!invalid$iv6) {
                    }
                    function24 = function25;
                    Object obj2222222 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda44
                        public final Object invoke() {
                            Unit InnerOverseaLoginPage$lambda$9$1$6$0;
                            InnerOverseaLoginPage$lambda$9$1$6$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$6$0(function24, pageState);
                            return InnerOverseaLoginPage$lambda$9$1$6$0;
                        }
                    };
                    $composer3.updateRememberedValue(obj2222222);
                    value$iv4 = obj2222222;
                    Function0 function06222222222 = (Function0) value$iv4;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerStart($composer3, 263761024, "CC(remember):InnerLoginPage.kt#9igjgp");
                    invalid$iv7 = ((1879048192 & $dirty3) != 536870912) | $composer2.changedInstance(pageState);
                    Object it$iv17222222222 = $composer3.rememberedValue();
                    if (invalid$iv7) {
                    }
                    Object value$iv15222222222 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda45
                        public final Object invoke() {
                            Unit InnerOverseaLoginPage$lambda$9$1$7$0;
                            InnerOverseaLoginPage$lambda$9$1$7$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$7$0(function24, pageState);
                            return InnerOverseaLoginPage$lambda$9$1$7$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv15222222222);
                    it$iv17222222222 = value$iv15222222222;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    CommonKt.ThirdPartyLogin(modifier222222, false, false, function052222222, function06222222222, (Function0) it$iv17222222222, $composer3, 6, 6);
                    SpacerKt.Spacer(ColumnScope.-CC.weight$default($this$InnerOverseaLoginPage_u24lambda_u249_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
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
                    $composer2.endReplaceGroup();
                }
                onSendCodeClick3 = onSendCodeClick4;
                Object obj5 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda21
                    public final Object invoke() {
                        Unit InnerOverseaLoginPage$lambda$9$1$0$0;
                        InnerOverseaLoginPage$lambda$9$1$0$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$0$0(onSendCodeClick3);
                        return InnerOverseaLoginPage$lambda$9$1$0$0;
                    }
                };
                $composer3.updateRememberedValue(obj5);
                value$iv = obj5;
                Function0 function032 = (Function0) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, 263715189, "CC(remember):InnerLoginPage.kt#9igjgp");
                $composer2 = $composer3;
                invalid$iv = (($dirty3 & 234881024) != 67108864) | $composer2.changedInstance(pageState);
                onSendCodeClick = onSendCodeClick3;
                it$iv = $composer3.rememberedValue();
                if (!invalid$iv) {
                    value$iv2 = it$iv;
                    Function0 function0422 = (Function0) value$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerStart($composer3, 263717626, "CC(remember):InnerLoginPage.kt#9igjgp");
                    invalid$iv2 = (($dirty3 & 896) != 256) | $composer2.changedInstance(pageState);
                    it$iv2 = $composer3.rememberedValue();
                    if (!invalid$iv2) {
                    }
                    onLoginClick3 = onLoginClick4;
                    Object obj322 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda40
                        public final Object invoke() {
                            Unit InnerOverseaLoginPage$lambda$9$1$2$0;
                            InnerOverseaLoginPage$lambda$9$1$2$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$2$0(onLoginClick3, pageState);
                            return InnerOverseaLoginPage$lambda$9$1$2$0;
                        }
                    };
                    $composer3.updateRememberedValue(obj322);
                    value$iv3 = obj322;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    SmsLoginPageKt.SmsInputGroup(phone, selectedCountry, smsCode, counting, onPhoneInput, onSmsCodeInput, function032, function0422, (Function0) value$iv3, $composer3, (57344 & $dirty3) | (458752 & $dirty3));
                    Modifier modifier3222 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(32), 0.0f, Dp.constructor-impl(24), 5, (Object) null);
                    if (StringsKt.isBlank(pageState.getPhone())) {
                    }
                    String stringResource2222 = StringResources_androidKt.stringResource(bili.resource.common.R.string.common_global_string_290, $composer3, 0);
                    ComposerKt.sourceInformationMarkerStart($composer3, 263730362, "CC(remember):InnerLoginPage.kt#9igjgp");
                    invalid$iv3 = (($dirty3 & 896) != 256) | $composer2.changedInstance(pageState);
                    Object it$iv142222 = $composer3.rememberedValue();
                    if (invalid$iv3) {
                    }
                    Object value$iv142222 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda41
                        public final Object invoke() {
                            Unit InnerOverseaLoginPage$lambda$9$1$3$0;
                            InnerOverseaLoginPage$lambda$9$1$3$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$3$0(onLoginClick3, pageState);
                            return InnerOverseaLoginPage$lambda$9$1$3$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv142222);
                    it$iv142222 = value$iv142222;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    CommonKt.LoginButton(stringResource2222, z, modifier3222, (Function0) it$iv142222, $composer3, BR.negativeBtnVisible, 0);
                    onLoginClick = onLoginClick3;
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32)), $composer3, 6);
                    boolean agreementChecked2222 = pageState.getAgreementChecked();
                    ComposerKt.sourceInformationMarkerStart($composer3, 263741712, "CC(remember):InnerLoginPage.kt#9igjgp");
                    if (($dirty3 & BR.containerVisible) != 32) {
                    }
                    Object it$iv152222 = $composer3.rememberedValue();
                    if (!invalid$iv4) {
                    }
                    Object value$iv172222 = new Function3() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda42
                        public final Object invoke(Object obj3222, Object obj42, Object obj52) {
                            Unit InnerOverseaLoginPage$lambda$9$1$4$0;
                            InnerOverseaLoginPage$lambda$9$1$4$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$4$0(function1, (EulaLinkType) obj3222, ((Boolean) obj42).booleanValue(), (EulaTriggerType) obj52);
                            return InnerOverseaLoginPage$lambda$9$1$4$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv172222);
                    it$iv152222 = value$iv172222;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    CommonKt.LoginAgreement(null, agreementChecked2222, null, onLoginAgreementChecked, routeTo3, (Function3) it$iv152222, null, $composer3, (($dirty3 >> 12) & 7168) | (($dirty1 << 12) & 57344), 69);
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(60)), $composer3, 6);
                    Modifier modifier2222222 = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart($composer3, 263752941, "CC(remember):InnerLoginPage.kt#9igjgp");
                    if (($dirty3 & 7168) != 2048) {
                    }
                    Object it$iv16222222 = $composer3.rememberedValue();
                    if (!invalid$iv5) {
                    }
                    onSwitchClick3 = onSwitchClick;
                    Object value$iv16222222 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda43
                        public final Object invoke() {
                            Unit InnerOverseaLoginPage$lambda$9$1$5$0;
                            InnerOverseaLoginPage$lambda$9$1$5$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$5$0(onSwitchClick3);
                            return InnerOverseaLoginPage$lambda$9$1$5$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv16222222);
                    it$iv16222222 = value$iv16222222;
                    Function0 function0522222222 = (Function0) it$iv16222222;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerStart($composer3, 263756220, "CC(remember):InnerLoginPage.kt#9igjgp");
                    invalid$iv6 = ((1879048192 & $dirty3) != 536870912) | $composer2.changedInstance(pageState);
                    onSwitchClick = onSwitchClick3;
                    it$iv3 = $composer3.rememberedValue();
                    if (!invalid$iv6) {
                    }
                    function24 = function25;
                    Object obj22222222 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda44
                        public final Object invoke() {
                            Unit InnerOverseaLoginPage$lambda$9$1$6$0;
                            InnerOverseaLoginPage$lambda$9$1$6$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$6$0(function24, pageState);
                            return InnerOverseaLoginPage$lambda$9$1$6$0;
                        }
                    };
                    $composer3.updateRememberedValue(obj22222222);
                    value$iv4 = obj22222222;
                    Function0 function062222222222 = (Function0) value$iv4;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerStart($composer3, 263761024, "CC(remember):InnerLoginPage.kt#9igjgp");
                    invalid$iv7 = ((1879048192 & $dirty3) != 536870912) | $composer2.changedInstance(pageState);
                    Object it$iv172222222222 = $composer3.rememberedValue();
                    if (invalid$iv7) {
                    }
                    Object value$iv152222222222 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda45
                        public final Object invoke() {
                            Unit InnerOverseaLoginPage$lambda$9$1$7$0;
                            InnerOverseaLoginPage$lambda$9$1$7$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$7$0(function24, pageState);
                            return InnerOverseaLoginPage$lambda$9$1$7$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv152222222222);
                    it$iv172222222222 = value$iv152222222222;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    CommonKt.ThirdPartyLogin(modifier2222222, false, false, function0522222222, function062222222222, (Function0) it$iv172222222222, $composer3, 6, 6);
                    SpacerKt.Spacer(ColumnScope.-CC.weight$default($this$InnerOverseaLoginPage_u24lambda_u249_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
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
                    $composer2.endReplaceGroup();
                }
                Object obj42 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda32
                    public final Object invoke() {
                        Unit InnerOverseaLoginPage$lambda$9$1$1$0;
                        InnerOverseaLoginPage$lambda$9$1$1$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$1$0(onCountryCodeSwitchClick, pageState);
                        return InnerOverseaLoginPage$lambda$9$1$1$0;
                    }
                };
                $composer3.updateRememberedValue(obj42);
                value$iv2 = obj42;
                Function0 function04222 = (Function0) value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, 263717626, "CC(remember):InnerLoginPage.kt#9igjgp");
                invalid$iv2 = (($dirty3 & 896) != 256) | $composer2.changedInstance(pageState);
                it$iv2 = $composer3.rememberedValue();
                if (!invalid$iv2) {
                }
                onLoginClick3 = onLoginClick4;
                Object obj3222 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda40
                    public final Object invoke() {
                        Unit InnerOverseaLoginPage$lambda$9$1$2$0;
                        InnerOverseaLoginPage$lambda$9$1$2$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$2$0(onLoginClick3, pageState);
                        return InnerOverseaLoginPage$lambda$9$1$2$0;
                    }
                };
                $composer3.updateRememberedValue(obj3222);
                value$iv3 = obj3222;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                SmsLoginPageKt.SmsInputGroup(phone, selectedCountry, smsCode, counting, onPhoneInput, onSmsCodeInput, function032, function04222, (Function0) value$iv3, $composer3, (57344 & $dirty3) | (458752 & $dirty3));
                Modifier modifier32222 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(32), 0.0f, Dp.constructor-impl(24), 5, (Object) null);
                if (StringsKt.isBlank(pageState.getPhone())) {
                }
                String stringResource22222 = StringResources_androidKt.stringResource(bili.resource.common.R.string.common_global_string_290, $composer3, 0);
                ComposerKt.sourceInformationMarkerStart($composer3, 263730362, "CC(remember):InnerLoginPage.kt#9igjgp");
                invalid$iv3 = (($dirty3 & 896) != 256) | $composer2.changedInstance(pageState);
                Object it$iv1422222 = $composer3.rememberedValue();
                if (invalid$iv3) {
                }
                Object value$iv1422222 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda41
                    public final Object invoke() {
                        Unit InnerOverseaLoginPage$lambda$9$1$3$0;
                        InnerOverseaLoginPage$lambda$9$1$3$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$3$0(onLoginClick3, pageState);
                        return InnerOverseaLoginPage$lambda$9$1$3$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv1422222);
                it$iv1422222 = value$iv1422222;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                CommonKt.LoginButton(stringResource22222, z, modifier32222, (Function0) it$iv1422222, $composer3, BR.negativeBtnVisible, 0);
                onLoginClick = onLoginClick3;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32)), $composer3, 6);
                boolean agreementChecked22222 = pageState.getAgreementChecked();
                ComposerKt.sourceInformationMarkerStart($composer3, 263741712, "CC(remember):InnerLoginPage.kt#9igjgp");
                if (($dirty3 & BR.containerVisible) != 32) {
                }
                Object it$iv1522222 = $composer3.rememberedValue();
                if (!invalid$iv4) {
                }
                Object value$iv1722222 = new Function3() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda42
                    public final Object invoke(Object obj32222, Object obj422, Object obj52) {
                        Unit InnerOverseaLoginPage$lambda$9$1$4$0;
                        InnerOverseaLoginPage$lambda$9$1$4$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$4$0(function1, (EulaLinkType) obj32222, ((Boolean) obj422).booleanValue(), (EulaTriggerType) obj52);
                        return InnerOverseaLoginPage$lambda$9$1$4$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv1722222);
                it$iv1522222 = value$iv1722222;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                CommonKt.LoginAgreement(null, agreementChecked22222, null, onLoginAgreementChecked, routeTo3, (Function3) it$iv1522222, null, $composer3, (($dirty3 >> 12) & 7168) | (($dirty1 << 12) & 57344), 69);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(60)), $composer3, 6);
                Modifier modifier22222222 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart($composer3, 263752941, "CC(remember):InnerLoginPage.kt#9igjgp");
                if (($dirty3 & 7168) != 2048) {
                }
                Object it$iv162222222 = $composer3.rememberedValue();
                if (!invalid$iv5) {
                }
                onSwitchClick3 = onSwitchClick;
                Object value$iv162222222 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda43
                    public final Object invoke() {
                        Unit InnerOverseaLoginPage$lambda$9$1$5$0;
                        InnerOverseaLoginPage$lambda$9$1$5$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$5$0(onSwitchClick3);
                        return InnerOverseaLoginPage$lambda$9$1$5$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv162222222);
                it$iv162222222 = value$iv162222222;
                Function0 function05222222222 = (Function0) it$iv162222222;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, 263756220, "CC(remember):InnerLoginPage.kt#9igjgp");
                invalid$iv6 = ((1879048192 & $dirty3) != 536870912) | $composer2.changedInstance(pageState);
                onSwitchClick = onSwitchClick3;
                it$iv3 = $composer3.rememberedValue();
                if (!invalid$iv6) {
                }
                function24 = function25;
                Object obj222222222 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda44
                    public final Object invoke() {
                        Unit InnerOverseaLoginPage$lambda$9$1$6$0;
                        InnerOverseaLoginPage$lambda$9$1$6$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$6$0(function24, pageState);
                        return InnerOverseaLoginPage$lambda$9$1$6$0;
                    }
                };
                $composer3.updateRememberedValue(obj222222222);
                value$iv4 = obj222222222;
                Function0 function0622222222222 = (Function0) value$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, 263761024, "CC(remember):InnerLoginPage.kt#9igjgp");
                invalid$iv7 = ((1879048192 & $dirty3) != 536870912) | $composer2.changedInstance(pageState);
                Object it$iv1722222222222 = $composer3.rememberedValue();
                if (invalid$iv7) {
                }
                Object value$iv1522222222222 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda45
                    public final Object invoke() {
                        Unit InnerOverseaLoginPage$lambda$9$1$7$0;
                        InnerOverseaLoginPage$lambda$9$1$7$0 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$9$1$7$0(function24, pageState);
                        return InnerOverseaLoginPage$lambda$9$1$7$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv1522222222222);
                it$iv1722222222222 = value$iv1522222222222;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                CommonKt.ThirdPartyLogin(modifier22222222, false, false, function05222222222, function0622222222222, (Function0) it$iv1722222222222, $composer3, 6, 6);
                SpacerKt.Spacer(ColumnScope.-CC.weight$default($this$InnerOverseaLoginPage_u24lambda_u249_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
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
                $composer2.endReplaceGroup();
            } else {
                onLoginAgreementChecked = onLoginAgreementChecked2;
                $dirty = $dirty2;
                $dirty1 = $dirty12;
                onLoginClick = onLoginClick2;
                onCountryCodeSwitchClick = onCountryCodeSwitchClick2;
                routeTo3 = routeTo2;
                onSendCodeClick = onSendCodeClick2;
                onPhoneInput = onPhoneInput2;
                onSmsCodeInput = onSmsCodeInput2;
                $composer2 = $composer3;
                function24 = function23;
                $composer2.startReplaceGroup(-1373643547);
                ComposerKt.sourceInformation($composer2, "297@12294L38");
                BoxKt.Box(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer2, 6);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            routeTo = routeTo3;
            function22 = function24;
        } else {
            $dirty = $dirty2;
            $dirty1 = $dirty12;
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            onLoginClick = function12;
            onSwitchClick = function0;
            onPhoneInput = function13;
            onSmsCodeInput = function14;
            onSendCodeClick = function02;
            onLoginAgreementChecked = function15;
            onCountryCodeSwitchClick = function16;
            function22 = function2;
            routeTo = function17;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Function1 function18 = onLoginClick;
            final Function0 function07 = onSwitchClick;
            final Function1 function19 = onPhoneInput;
            final Function1 function110 = onSmsCodeInput;
            final Function0 function08 = onSendCodeClick;
            final Function1 function111 = onLoginAgreementChecked;
            final Function1 function112 = onCountryCodeSwitchClick;
            final Function2<? super Boolean, ? super LoginWay, Unit> function26 = function22;
            final Function1 function113 = routeTo;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj6, Object obj7) {
                    Unit InnerOverseaLoginPage$lambda$10;
                    InnerOverseaLoginPage$lambda$10 = InnerLoginPageKt.InnerOverseaLoginPage$lambda$10(IOverseaLoginState.this, function1, function18, function07, function19, function110, function08, function111, function112, function26, function113, $changed, $changed1, i, (Composer) obj6, ((Integer) obj7).intValue());
                    return InnerOverseaLoginPage$lambda$10;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerOverseaLoginPage$lambda$9$1$0$0(Function0 $onSendCodeClick) {
        $onSendCodeClick.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerOverseaLoginPage$lambda$9$1$1$0(Function1 $onCountryCodeSwitchClick, SmsLoginInput $pageState) {
        $onCountryCodeSwitchClick.invoke($pageState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerOverseaLoginPage$lambda$9$1$2$0(Function1 $onLoginClick, SmsLoginInput $pageState) {
        $onLoginClick.invoke(Boolean.valueOf($pageState.getAgreementChecked()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerOverseaLoginPage$lambda$9$1$3$0(Function1 $onLoginClick, SmsLoginInput $pageState) {
        $onLoginClick.invoke(Boolean.valueOf($pageState.getAgreementChecked()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerOverseaLoginPage$lambda$9$1$4$0(Function1 $onAction, EulaLinkType type, boolean inDialog, EulaTriggerType triggerType) {
        Intrinsics.checkNotNullParameter(type, "type");
        $onAction.invoke(new IFullscreenLoginReportAction.EulaLinkClicked(type, inDialog, triggerType));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerOverseaLoginPage$lambda$9$1$5$0(Function0 $onSwitchClick) {
        $onSwitchClick.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerOverseaLoginPage$lambda$9$1$6$0(Function2 $onOverseaClick, SmsLoginInput $pageState) {
        $onOverseaClick.invoke(Boolean.valueOf($pageState.getAgreementChecked()), Google.GoogleLogin.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerOverseaLoginPage$lambda$9$1$7$0(Function2 $onOverseaClick, SmsLoginInput $pageState) {
        $onOverseaClick.invoke(Boolean.valueOf($pageState.getAgreementChecked()), Facebook.FacebookLogin.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerPhoneLoginPage$lambda$1$0(boolean it) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x033a, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L88;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v23 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void InnerPhoneLoginPage(final IPhoneOnePassState page, final String loginButtonText, final String switchLoginText, final Function1<? super Boolean, Unit> function1, Function0<Unit> function0, Function1<? super Boolean, Unit> function12, final Function1<? super String, Unit> function13, final Function1<? super IFullscreenAction, Unit> function14, Composer $composer, final int $changed, final int i) {
        Function0 function02;
        Function1 function15;
        Composer $composer2;
        Function0 onSwitchClick;
        Function1 onAgreementCheckChanged;
        PhoneOnePassLoginState phoneOnePassLoginState;
        Intrinsics.checkNotNullParameter(page, LoginReporterV2.PAGE_FROM_KEY);
        Intrinsics.checkNotNullParameter(loginButtonText, "loginButtonText");
        Intrinsics.checkNotNullParameter(switchLoginText, "switchLoginText");
        Intrinsics.checkNotNullParameter(function1, "onLoginClick");
        Intrinsics.checkNotNullParameter(function13, "routeTo");
        Intrinsics.checkNotNullParameter(function14, "onAction");
        Composer $composer3 = $composer.startRestartGroup(230441456);
        ComposerKt.sourceInformation($composer3, "C(InnerPhoneLoginPage)N(page,loginButtonText,switchLoginText,onLoginClick,onSwitchClick,onAgreementCheckChanged,routeTo,onAction)307@12545L2,308@12607L2,316@12831L1097:InnerLoginPage.kt#1fav2j");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer3.changed(page) : $composer3.changedInstance(page) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(loginButtonText) ? 32 : 16;
        }
        if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty |= $composer3.changed(switchLoginText) ? BR.hallEnterHotText : BR.cover;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            function02 = function0;
        } else if (($changed & 24576) == 0) {
            function02 = function0;
            $dirty |= $composer3.changedInstance(function02) ? RingBuffer.CONSUME_SIZE : 8192;
        } else {
            function02 = function0;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty |= 196608;
            function15 = function12;
        } else if ((196608 & $changed) == 0) {
            function15 = function12;
            $dirty |= $composer3.changedInstance(function15) ? 131072 : AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR;
        } else {
            function15 = function12;
        }
        if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changedInstance(function13) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changedInstance(function14) ? 8388608 : 4194304;
        }
        if ($composer3.shouldExecute(($dirty & 4793491) != 4793490, $dirty & 1)) {
            if (i2 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -1884054062, "CC(remember):InnerLoginPage.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda9
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onSwitchClick2 = (Function0) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onSwitchClick = onSwitchClick2;
            } else {
                onSwitchClick = function02;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -1884052078, "CC(remember):InnerLoginPage.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda11
                        public final Object invoke(Object obj) {
                            Unit InnerPhoneLoginPage$lambda$1$0;
                            InnerPhoneLoginPage$lambda$1$0 = InnerLoginPageKt.InnerPhoneLoginPage$lambda$1$0(((Boolean) obj).booleanValue());
                            return InnerPhoneLoginPage$lambda$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function1 onAgreementCheckChanged2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onAgreementCheckChanged = onAgreementCheckChanged2;
            } else {
                onAgreementCheckChanged = function15;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(230441456, $dirty, -1, "tv.danmaku.bili.inner.ui.InnerPhoneLoginPage (InnerLoginPage.kt:311)");
            }
            if (page instanceof PhoneOnePassLoginLoadingState) {
                phoneOnePassLoginState = ((PhoneOnePassLoginLoadingState) page).getOrigin();
            } else if (!(page instanceof PhoneOnePassLoginState)) {
                throw new NoWhenBranchMatchedException();
            } else {
                phoneOnePassLoginState = (PhoneOnePassLoginState) page;
            }
            final PhoneOnePassLoginState pageState = phoneOnePassLoginState;
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(48), 0.0f, 2, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((BR.nickTextColor >> 3) & 14) | ((BR.nickTextColor >> 3) & BR.containerVisible));
            int $changed$iv$iv = (BR.nickTextColor << 3) & BR.containerVisible;
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
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i5 = ((BR.nickTextColor >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1405449488, "C317@12949L12,321@13113L6,318@12970L196,327@13299L44,324@13175L178,329@13362L41,330@13412L67,331@13488L41,337@13766L146,332@13538L384:InnerLoginPage.kt#1fav2j");
            TipToLogin($composer3, 0);
            TextKt.Text--4IGK_g(pageState.getPhone().getSecurePhone(), PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(40), 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), TextUnitKt.getSp(24), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 3120, 0, 131056);
            Modifier modifier = SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl((float) BR.headerTitle));
            ComposerKt.sourceInformationMarkerStart($composer3, -738063470, "CC(remember):InnerLoginPage.kt#9igjgp");
            boolean invalid$iv = (($dirty & 7168) == 2048) | $composer3.changedInstance(pageState);
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv3 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda12
                public final Object invoke() {
                    Unit InnerPhoneLoginPage$lambda$2$0$0;
                    InnerPhoneLoginPage$lambda$2$0$0 = InnerLoginPageKt.InnerPhoneLoginPage$lambda$2$0$0(function1, pageState);
                    return InnerPhoneLoginPage$lambda$2$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            int $dirty2 = $dirty;
            CommonKt.LoginButton(loginButtonText, false, modifier, (Function0) it$iv3, $composer3, (($dirty >> 3) & 14) | BR.negativeBtnVisible, 2);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), $composer3, 6);
            CommonKt.SwitchLogin(switchLoginText, null, onSwitchClick, $composer3, (($dirty2 >> 6) & 14) | (($dirty2 >> 6) & 896), 2);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(48)), $composer3, 6);
            boolean agreementChecked = pageState.getAgreementChecked();
            IspCode ispCode = pageState.getPhone().getIspCode();
            ComposerKt.sourceInformationMarkerStart($composer3, -738048424, "CC(remember):InnerLoginPage.kt#9igjgp");
            boolean invalid$iv2 = ($dirty2 & 29360128) == 8388608;
            Object it$iv4 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function3() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda13
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit InnerPhoneLoginPage$lambda$2$1$0;
                        InnerPhoneLoginPage$lambda$2$1$0 = InnerLoginPageKt.InnerPhoneLoginPage$lambda$2$1$0(function14, (EulaLinkType) obj, ((Boolean) obj2).booleanValue(), (EulaTriggerType) obj3);
                        return InnerPhoneLoginPage$lambda$2$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            CommonKt.LoginAgreement(null, agreementChecked, ispCode, onAgreementCheckChanged, function13, (Function3) it$iv4, null, $composer3, (($dirty2 >> 6) & 7168) | (($dirty2 >> 6) & 57344), 65);
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
            onSwitchClick = function02;
            onAgreementCheckChanged = function15;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Function0 function03 = onSwitchClick;
            final Function1 function16 = onAgreementCheckChanged;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj, Object obj2) {
                    Unit InnerPhoneLoginPage$lambda$3;
                    InnerPhoneLoginPage$lambda$3 = InnerLoginPageKt.InnerPhoneLoginPage$lambda$3(IPhoneOnePassState.this, loginButtonText, switchLoginText, function1, function03, function16, function13, function14, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return InnerPhoneLoginPage$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerPhoneLoginPage$lambda$2$0$0(Function1 $onLoginClick, PhoneOnePassLoginState $pageState) {
        $onLoginClick.invoke(Boolean.valueOf($pageState.getAgreementChecked()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerPhoneLoginPage$lambda$2$1$0(Function1 $onAction, EulaLinkType type, boolean inDialog, EulaTriggerType triggerType) {
        Intrinsics.checkNotNullParameter(type, "type");
        $onAction.invoke(new IFullscreenLoginReportAction.EulaLinkClicked(type, inDialog, triggerType));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerFastLoginPage$lambda$1$0(boolean it) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:122:0x03fc, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L100;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void InnerFastLoginPage(final IFastLoginPage page, final String loginButtonText, final String switchLoginText, final Function1<? super Boolean, Unit> function1, Function0<Unit> function0, Function1<? super Boolean, Unit> function12, final Function1<? super String, Unit> function13, final Function1<? super IFullscreenAction, Unit> function14, Composer $composer, final int $changed, final int i) {
        Function1 function15;
        Composer $composer2;
        Function0 onSwitchClick;
        Function1 onAgreementCheckChanged;
        FastLoginPage fastLoginPage;
        Intrinsics.checkNotNullParameter(page, LoginReporterV2.PAGE_FROM_KEY);
        Intrinsics.checkNotNullParameter(loginButtonText, "loginButtonText");
        Intrinsics.checkNotNullParameter(switchLoginText, "switchLoginText");
        Intrinsics.checkNotNullParameter(function1, "onLoginClick");
        Intrinsics.checkNotNullParameter(function13, "routeTo");
        Intrinsics.checkNotNullParameter(function14, "onAction");
        Composer $composer3 = $composer.startRestartGroup(1931734494);
        ComposerKt.sourceInformation($composer3, "C(InnerFastLoginPage)N(page,loginButtonText,switchLoginText,onLoginClick,onSwitchClick,onAgreementCheckChanged,routeTo,onAction)350@14130L2,351@14192L2:InnerLoginPage.kt#1fav2j");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer3.changed(page) : $composer3.changedInstance(page) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(loginButtonText) ? 32 : 16;
        }
        if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty |= $composer3.changed(switchLoginText) ? BR.hallEnterHotText : BR.cover;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? RingBuffer.CONSUME_SIZE : 8192;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty |= 196608;
            function15 = function12;
        } else if (($changed & 196608) == 0) {
            function15 = function12;
            $dirty |= $composer3.changedInstance(function15) ? 131072 : AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR;
        } else {
            function15 = function12;
        }
        if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changedInstance(function13) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changedInstance(function14) ? 8388608 : 4194304;
        }
        if ($composer3.shouldExecute(($dirty & 4793491) != 4793490, $dirty & 1)) {
            if (i2 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 970982816, "CC(remember):InnerLoginPage.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda35
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onSwitchClick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onSwitchClick = onSwitchClick2;
            } else {
                onSwitchClick = function0;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 970984800, "CC(remember):InnerLoginPage.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda36
                        public final Object invoke(Object obj) {
                            Unit InnerFastLoginPage$lambda$1$0;
                            InnerFastLoginPage$lambda$1$0 = InnerLoginPageKt.InnerFastLoginPage$lambda$1$0(((Boolean) obj).booleanValue());
                            return InnerFastLoginPage$lambda$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function1 onAgreementCheckChanged2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onAgreementCheckChanged = onAgreementCheckChanged2;
            } else {
                onAgreementCheckChanged = function15;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1931734494, $dirty, -1, "tv.danmaku.bili.inner.ui.InnerFastLoginPage (InnerLoginPage.kt:354)");
            }
            if (page instanceof FastLoginFailed) {
                fastLoginPage = null;
            } else if (page instanceof FastLoginRiskControl) {
                fastLoginPage = null;
            } else if (page instanceof FastLoginLoadingPage) {
                fastLoginPage = ((FastLoginLoadingPage) page).getOriginal();
            } else if (!(page instanceof FastLoginPage)) {
                throw new NoWhenBranchMatchedException();
            } else {
                fastLoginPage = (FastLoginPage) page;
            }
            final FastLoginPage pageState = fastLoginPage;
            if (pageState == null) {
                $composer3.startReplaceGroup(36062894);
                ComposerKt.sourceInformation($composer3, "362@14508L38");
                BoxKt.Box(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer3, 6);
                $composer3.endReplaceGroup();
                $composer2 = $composer3;
            } else {
                $composer3.startReplaceGroup(36167271);
                ComposerKt.sourceInformation($composer3, "364@14568L1485");
                Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(48), 0.0f, 2, (Object) null);
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((BR.nickTextColor >> 3) & 14) | ((BR.nickTextColor >> 3) & BR.containerVisible));
                int $changed$iv$iv = (BR.nickTextColor << 3) & BR.containerVisible;
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
                ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i5 = ((BR.nickTextColor >> 6) & BR.containerVisible) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1019579498, "C365@14690L12,366@14715L232,377@15139L6,373@14960L285,386@15473L44,381@15258L273,388@15544L67,389@15624L41,394@15875L154,390@15678L365:InnerLoginPage.kt#1fav2j");
                TipToLogin($composer3, 0);
                BiliImageKt.BiliImage(pageState.getAccount().getFace(), ClipKt.clip(SizeKt.size-VpY3zN4(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(32), 0.0f, 0.0f, 13, (Object) null), Dp.constructor-impl(80), Dp.constructor-impl(80)), RoundedCornerShapeKt.getCircleShape()), (String) null, false, 0, (String) null, false, (Function3) null, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer3, 0, 0, 4092);
                TextKt.Text--4IGK_g(pageState.getAccount().getName(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(16), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), TextUnitKt.getSp(16), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer3, 3120, 3120, 120816);
                Modifier modifier = SizeKt.width-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(32), 0.0f, Dp.constructor-impl(24), 5, (Object) null), Dp.constructor-impl((float) BR.headerTitle));
                ComposerKt.sourceInformationMarkerStart($composer3, -1833981232, "CC(remember):InnerLoginPage.kt#9igjgp");
                boolean invalid$iv = (($dirty & 7168) == 2048) | $composer3.changedInstance(pageState);
                Object it$iv3 = $composer3.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv3 = new Function0() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda37
                    public final Object invoke() {
                        Unit InnerFastLoginPage$lambda$2$0$0;
                        InnerFastLoginPage$lambda$2$0$0 = InnerLoginPageKt.InnerFastLoginPage$lambda$2$0$0(function1, pageState);
                        return InnerFastLoginPage$lambda$2$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                int $dirty2 = $dirty;
                CommonKt.LoginButton(loginButtonText, false, modifier, (Function0) it$iv3, $composer3, (($dirty >> 3) & 14) | BR.negativeBtnVisible, 2);
                CommonKt.SwitchLogin(switchLoginText, null, onSwitchClick, $composer3, (($dirty2 >> 6) & 14) | (($dirty2 >> 6) & 896), 2);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(48)), $composer3, 6);
                boolean agreementChecked = pageState.getAgreementChecked();
                ComposerKt.sourceInformationMarkerStart($composer3, -1833968258, "CC(remember):InnerLoginPage.kt#9igjgp");
                boolean invalid$iv2 = ($dirty2 & 29360128) == 8388608;
                Object it$iv4 = $composer3.rememberedValue();
                if (invalid$iv2 || it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = new Function3() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda38
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            Unit InnerFastLoginPage$lambda$2$1$0;
                            InnerFastLoginPage$lambda$2$1$0 = InnerLoginPageKt.InnerFastLoginPage$lambda$2$1$0(function14, (EulaLinkType) obj, ((Boolean) obj2).booleanValue(), (EulaTriggerType) obj3);
                            return InnerFastLoginPage$lambda$2$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer2 = $composer3;
                CommonKt.LoginAgreement(null, agreementChecked, null, onAgreementCheckChanged, function13, (Function3) it$iv4, null, $composer3, (($dirty2 >> 6) & 7168) | (($dirty2 >> 6) & 57344), 69);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            onSwitchClick = function0;
            onAgreementCheckChanged = function15;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Function0 function02 = onSwitchClick;
            final Function1 function16 = onAgreementCheckChanged;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda39
                public final Object invoke(Object obj, Object obj2) {
                    Unit InnerFastLoginPage$lambda$3;
                    InnerFastLoginPage$lambda$3 = InnerLoginPageKt.InnerFastLoginPage$lambda$3(IFastLoginPage.this, loginButtonText, switchLoginText, function1, function02, function16, function13, function14, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return InnerFastLoginPage$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerFastLoginPage$lambda$2$0$0(Function1 $onLoginClick, FastLoginPage $pageState) {
        $onLoginClick.invoke(Boolean.valueOf($pageState.getAgreementChecked()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerFastLoginPage$lambda$2$1$0(Function1 $onAction, EulaLinkType type, boolean inDialog, EulaTriggerType triggerType) {
        Intrinsics.checkNotNullParameter(type, "type");
        $onAction.invoke(new IFullscreenLoginReportAction.EulaLinkClicked(type, inDialog, triggerType));
        return Unit.INSTANCE;
    }

    public static final void TipToLogin(Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-928687586);
        ComposerKt.sourceInformation($composer3, "C(TipToLogin)405@16119L76,406@16223L9,407@16265L6,404@16098L342:InnerLoginPage.kt#1fav2j");
        if (!$composer3.shouldExecute($changed != 0, $changed & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-928687586, $changed, -1, "tv.danmaku.bili.inner.ui.TipToLogin (InnerLoginPage.kt:403)");
            }
            String stringResource = StringResources_androidKt.stringResource(R.string.account_global_string_53, $composer3, 0);
            TextStyle t22b = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT22b();
            long j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa9-0d7_KjU();
            int i = TextOverflow.Companion.getEllipsis-gIe3tQ8();
            int i2 = TextAlign.Companion.getCenter-e0LSkKk();
            Modifier modifier = PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 2, (Object) null);
            TextAlign textAlign = TextAlign.box-impl(i2);
            $composer2 = $composer3;
            TextKt.Text--4IGK_g(stringResource, modifier, j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, textAlign, 0L, i, false, 2, 0, (Function1) null, t22b, $composer2, 48, 3120, 54776);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.inner.ui.InnerLoginPageKt$$ExternalSyntheticLambda34
                public final Object invoke(Object obj, Object obj2) {
                    Unit TipToLogin$lambda$0;
                    TipToLogin$lambda$0 = InnerLoginPageKt.TipToLogin$lambda$0($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return TipToLogin$lambda$0;
                }
            });
        }
    }
}