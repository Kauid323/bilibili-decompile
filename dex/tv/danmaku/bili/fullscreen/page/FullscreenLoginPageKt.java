package tv.danmaku.bili.fullscreen.page;

import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.data.PhoneCountryCode;
import tv.danmaku.bili.fullscreen.state.FullscreenLoginDowngradeState;
import tv.danmaku.bili.fullscreen.state.FullscreenLoginFastPage;
import tv.danmaku.bili.fullscreen.state.FullscreenLoginIdlePage;
import tv.danmaku.bili.fullscreen.state.FullscreenLoginInvalidPage;
import tv.danmaku.bili.fullscreen.state.FullscreenLoginPasswordPage;
import tv.danmaku.bili.fullscreen.state.FullscreenLoginPhoneIdlePage;
import tv.danmaku.bili.fullscreen.state.FullscreenLoginPhonePage;
import tv.danmaku.bili.fullscreen.state.FullscreenLoginSmsPage;
import tv.danmaku.bili.fullscreen.state.FullscreenPhoneOrPasswordPage;
import tv.danmaku.bili.fullscreen.state.IFullscreenAction;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginState;
import tv.danmaku.bili.fullscreen.state.IPasswordLoginAction;
import tv.danmaku.bili.fullscreen.state.IPasswordLoginPage;
import tv.danmaku.bili.fullscreen.state.IPhoneOnePassState;
import tv.danmaku.bili.fullscreen.state.ISmsLoginAction;
import tv.danmaku.bili.fullscreen.state.ISmsLoginPageState;
import tv.danmaku.bili.fullscreen.state.SmsLoginInput;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: FullscreenLoginPage.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\u001aK\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f²\u0006\u0016\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u0005X\u008a\u0084\u0002"}, d2 = {"FullscreenLoginPage", "", LoginReporterV2.PAGE_FROM_KEY, "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginState;", "onAction", "Lkotlin/Function1;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenAction;", "routeTo", "", "onForgetPwdClick", "Lkotlin/Function0;", "(Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "accountui_apinkDebug", "onLoginClick", ""}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FullscreenLoginPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenLoginPage$lambda$20(IFullscreenLoginState iFullscreenLoginState, Function1 function1, Function1 function12, Function0 function0, int i, Composer composer, int i2) {
        FullscreenLoginPage(iFullscreenLoginState, function1, function12, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:153:0x0320, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0432, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x046c, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x04a6, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x04e0, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x051c, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L209;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x0558, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L217;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x0597, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01d3, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L97;
     */
    /* JADX WARN: Removed duplicated region for block: B:283:0x061e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FullscreenLoginPage(final IFullscreenLoginState page, final Function1<? super IFullscreenAction, Unit> function1, final Function1<? super String, Unit> function12, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(page, LoginReporterV2.PAGE_FROM_KEY);
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Intrinsics.checkNotNullParameter(function12, "routeTo");
        Intrinsics.checkNotNullParameter(function0, "onForgetPwdClick");
        Composer $composer2 = $composer.startRestartGroup(1522639491);
        ComposerKt.sourceInformation($composer2, "C(FullscreenLoginPage)N(page,onAction,routeTo,onForgetPwdClick)35@1586L7,36@1643L56,39@1745L207,39@1724L228:FullscreenLoginPage.kt#gqoihp");
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
            $dirty |= $composer2.changedInstance(function0) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1522639491, $dirty2, -1, "tv.danmaku.bili.fullscreen.page.FullscreenLoginPage (FullscreenLoginPage.kt:34)");
            }
            OnBackPressedDispatcherOwner current = LocalOnBackPressedDispatcherOwner.INSTANCE.getCurrent($composer2, LocalOnBackPressedDispatcherOwner.$stable);
            final OnBackPressedDispatcher onBackPressedDispatcher = current != null ? current.getOnBackPressedDispatcher() : null;
            ComposerKt.sourceInformationMarkerStart($composer2, -1327287589, "CC(remember):FullscreenLoginPage.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(onBackPressedDispatcher);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.FullscreenLoginPageKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit FullscreenLoginPage$lambda$0$0;
                        FullscreenLoginPage$lambda$0$0 = FullscreenLoginPageKt.FullscreenLoginPage$lambda$0$0(onBackPressedDispatcher);
                        return FullscreenLoginPage$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final Function0 onBackPressed = (Function0) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1327284174, "CC(remember):FullscreenLoginPage.kt#9igjgp");
            boolean invalid$iv2 = ($dirty2 & BR.containerVisible) == 32;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.FullscreenLoginPageKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit FullscreenLoginPage$lambda$1$0;
                        FullscreenLoginPage$lambda$1$0 = FullscreenLoginPageKt.FullscreenLoginPage$lambda$1$0(function1, ((Boolean) obj).booleanValue());
                        return FullscreenLoginPage$lambda$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            State onLoginClick$delegate = SnapshotStateKt.rememberUpdatedState((Function1) it$iv2, $composer2, 0);
            if (!(page instanceof FullscreenLoginFastPage) && !(page instanceof FullscreenLoginDowngradeState) && !(page instanceof FullscreenPhoneOrPasswordPage) && !Intrinsics.areEqual(page, FullscreenLoginInvalidPage.INSTANCE) && !Intrinsics.areEqual(page, FullscreenLoginPhoneIdlePage.INSTANCE)) {
                if (page instanceof FullscreenLoginIdlePage) {
                    $composer2.startReplaceGroup(1804389266);
                    ComposerKt.sourceInformation($composer2, "58@2293L53");
                    FullscreenLoginIdlePageKt.FullscreenLoginIdle((FullscreenLoginIdlePage) page, function1, $composer2, ($dirty2 & 14) | ($dirty2 & BR.containerVisible));
                    $composer2.endReplaceGroup();
                } else if (page instanceof FullscreenLoginPhonePage) {
                    $composer2.startReplaceGroup(1804520613);
                    ComposerKt.sourceInformation($composer2, "66@2582L50,67@2676L199,62@2411L514");
                    IPhoneOnePassState currentPage = ((FullscreenLoginPhonePage) page).getCurrentPage();
                    Function1<Boolean, Unit> FullscreenLoginPage$lambda$2 = FullscreenLoginPage$lambda$2(onLoginClick$delegate);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1327257547, "CC(remember):FullscreenLoginPage.kt#9igjgp");
                    boolean invalid$iv3 = ($dirty2 & BR.containerVisible) == 32;
                    Object it$iv3 = $composer2.rememberedValue();
                    if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                        Object value$iv3 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.FullscreenLoginPageKt$$ExternalSyntheticLambda3
                            public final Object invoke() {
                                Unit FullscreenLoginPage$lambda$3$0;
                                FullscreenLoginPage$lambda$3$0 = FullscreenLoginPageKt.FullscreenLoginPage$lambda$3$0(function1);
                                return FullscreenLoginPage$lambda$3$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv3);
                        it$iv3 = value$iv3;
                    }
                    Function0 function02 = (Function0) it$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1327254390, "CC(remember):FullscreenLoginPage.kt#9igjgp");
                    boolean invalid$iv4 = ($dirty2 & BR.containerVisible) == 32;
                    Object it$iv4 = $composer2.rememberedValue();
                    if (invalid$iv4) {
                    }
                    Object value$iv4 = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.FullscreenLoginPageKt$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj) {
                            Unit FullscreenLoginPage$lambda$4$0;
                            FullscreenLoginPage$lambda$4$0 = FullscreenLoginPageKt.FullscreenLoginPage$lambda$4$0(function1, ((Boolean) obj).booleanValue());
                            return FullscreenLoginPage$lambda$4$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    PhoneLoginPageKt.PhoneLoginPage(currentPage, function1, FullscreenLoginPage$lambda$2, function02, (Function1) it$iv4, function12, $composer2, ($dirty2 & BR.containerVisible) | (($dirty2 << 9) & 458752), 0);
                    $composer2.endReplaceGroup();
                } else if (page instanceof FullscreenLoginPasswordPage) {
                    $composer2.startReplaceGroup(1805102545);
                    ComposerKt.sourceInformation($composer2, "82@3123L57,83@3216L58,84@3308L19,86@3406L50,87@3493L63,79@2993L662");
                    IPasswordLoginPage currentPage2 = ((FullscreenLoginPasswordPage) page).getCurrentPage();
                    ComposerKt.sourceInformationMarkerStart($composer2, -1327240228, "CC(remember):FullscreenLoginPage.kt#9igjgp");
                    boolean invalid$iv5 = ($dirty2 & BR.containerVisible) == 32;
                    Object it$iv5 = $composer2.rememberedValue();
                    if (invalid$iv5 || it$iv5 == Composer.Companion.getEmpty()) {
                        Object value$iv5 = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.FullscreenLoginPageKt$$ExternalSyntheticLambda5
                            public final Object invoke(Object obj) {
                                Unit FullscreenLoginPage$lambda$5$0;
                                FullscreenLoginPage$lambda$5$0 = FullscreenLoginPageKt.FullscreenLoginPage$lambda$5$0(function1, (String) obj);
                                return FullscreenLoginPage$lambda$5$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv5);
                        it$iv5 = value$iv5;
                    }
                    Function1 function13 = (Function1) it$iv5;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1327237251, "CC(remember):FullscreenLoginPage.kt#9igjgp");
                    boolean invalid$iv6 = ($dirty2 & BR.containerVisible) == 32;
                    Object it$iv6 = $composer2.rememberedValue();
                    if (invalid$iv6 || it$iv6 == Composer.Companion.getEmpty()) {
                        Object value$iv6 = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.FullscreenLoginPageKt$$ExternalSyntheticLambda6
                            public final Object invoke(Object obj) {
                                Unit FullscreenLoginPage$lambda$6$0;
                                FullscreenLoginPage$lambda$6$0 = FullscreenLoginPageKt.FullscreenLoginPage$lambda$6$0(function1, (String) obj);
                                return FullscreenLoginPage$lambda$6$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv6);
                        it$iv6 = value$iv6;
                    }
                    Function1 function14 = (Function1) it$iv6;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1327234346, "CC(remember):FullscreenLoginPage.kt#9igjgp");
                    boolean invalid$iv7 = $composer2.changed(onBackPressed);
                    Object it$iv7 = $composer2.rememberedValue();
                    if (invalid$iv7 || it$iv7 == Composer.Companion.getEmpty()) {
                        Object value$iv7 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.FullscreenLoginPageKt$$ExternalSyntheticLambda7
                            public final Object invoke() {
                                Unit FullscreenLoginPage$lambda$7$0;
                                FullscreenLoginPage$lambda$7$0 = FullscreenLoginPageKt.FullscreenLoginPage$lambda$7$0(onBackPressed);
                                return FullscreenLoginPage$lambda$7$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv7);
                        it$iv7 = value$iv7;
                    }
                    Function0 function03 = (Function0) it$iv7;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Function1<Boolean, Unit> FullscreenLoginPage$lambda$22 = FullscreenLoginPage$lambda$2(onLoginClick$delegate);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1327231179, "CC(remember):FullscreenLoginPage.kt#9igjgp");
                    boolean invalid$iv8 = ($dirty2 & BR.containerVisible) == 32;
                    Object it$iv8 = $composer2.rememberedValue();
                    if (invalid$iv8 || it$iv8 == Composer.Companion.getEmpty()) {
                        Object value$iv8 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.FullscreenLoginPageKt$$ExternalSyntheticLambda8
                            public final Object invoke() {
                                Unit FullscreenLoginPage$lambda$8$0;
                                FullscreenLoginPage$lambda$8$0 = FullscreenLoginPageKt.FullscreenLoginPage$lambda$8$0(function1);
                                return FullscreenLoginPage$lambda$8$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv8);
                        it$iv8 = value$iv8;
                    }
                    Function0 function04 = (Function0) it$iv8;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1327228382, "CC(remember):FullscreenLoginPage.kt#9igjgp");
                    boolean invalid$iv9 = ($dirty2 & BR.containerVisible) == 32;
                    Object it$iv9 = $composer2.rememberedValue();
                    if (invalid$iv9) {
                    }
                    Object value$iv9 = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.FullscreenLoginPageKt$$ExternalSyntheticLambda9
                        public final Object invoke(Object obj) {
                            Unit FullscreenLoginPage$lambda$9$0;
                            FullscreenLoginPage$lambda$9$0 = FullscreenLoginPageKt.FullscreenLoginPage$lambda$9$0(function1, ((Boolean) obj).booleanValue());
                            return FullscreenLoginPage$lambda$9$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv9);
                    it$iv9 = value$iv9;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    PasswordLoginPageKt.PasswordLoginPage(currentPage2, function1, function13, function14, function03, FullscreenLoginPage$lambda$22, function04, (Function1) it$iv9, function12, function0, $composer2, ($dirty2 & BR.containerVisible) | (($dirty2 << 18) & 234881024) | (1879048192 & ($dirty2 << 18)), 0);
                    $composer2.endReplaceGroup();
                } else if (page instanceof FullscreenLoginSmsPage) {
                    $composer2.startReplaceGroup(1805845057);
                    ComposerKt.sourceInformation($composer2, "97@3842L19,99@3941L54,100@4029L53,101@4115L50,102@4200L52,103@4288L50,104@4382L199,111@4626L47,112@4715L272,120@5027L55,94@3718L1414");
                    ISmsLoginPageState currentPage3 = ((FullscreenLoginSmsPage) page).getCurrentPage();
                    ComposerKt.sourceInformationMarkerStart($composer2, -1327217258, "CC(remember):FullscreenLoginPage.kt#9igjgp");
                    boolean invalid$iv10 = $composer2.changed(onBackPressed);
                    Object it$iv10 = $composer2.rememberedValue();
                    if (invalid$iv10 || it$iv10 == Composer.Companion.getEmpty()) {
                        Object value$iv10 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.FullscreenLoginPageKt$$ExternalSyntheticLambda10
                            public final Object invoke() {
                                Unit FullscreenLoginPage$lambda$10$0;
                                FullscreenLoginPage$lambda$10$0 = FullscreenLoginPageKt.FullscreenLoginPage$lambda$10$0(onBackPressed);
                                return FullscreenLoginPage$lambda$10$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv10);
                        it$iv10 = value$iv10;
                    }
                    Function0 function05 = (Function0) it$iv10;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Function1<Boolean, Unit> FullscreenLoginPage$lambda$23 = FullscreenLoginPage$lambda$2(onLoginClick$delegate);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1327214055, "CC(remember):FullscreenLoginPage.kt#9igjgp");
                    boolean invalid$iv11 = ($dirty2 & BR.containerVisible) == 32;
                    Object it$iv11 = $composer2.rememberedValue();
                    if (invalid$iv11 || it$iv11 == Composer.Companion.getEmpty()) {
                        Object value$iv11 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.FullscreenLoginPageKt$$ExternalSyntheticLambda11
                            public final Object invoke() {
                                Unit FullscreenLoginPage$lambda$11$0;
                                FullscreenLoginPage$lambda$11$0 = FullscreenLoginPageKt.FullscreenLoginPage$lambda$11$0(function1);
                                return FullscreenLoginPage$lambda$11$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv11);
                        it$iv11 = value$iv11;
                    }
                    Function0 function06 = (Function0) it$iv11;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1327211240, "CC(remember):FullscreenLoginPage.kt#9igjgp");
                    boolean invalid$iv12 = ($dirty2 & BR.containerVisible) == 32;
                    Object it$iv12 = $composer2.rememberedValue();
                    if (invalid$iv12 || it$iv12 == Composer.Companion.getEmpty()) {
                        Object value$iv12 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.FullscreenLoginPageKt$$ExternalSyntheticLambda12
                            public final Object invoke() {
                                Unit FullscreenLoginPage$lambda$12$0;
                                FullscreenLoginPage$lambda$12$0 = FullscreenLoginPageKt.FullscreenLoginPage$lambda$12$0(function1);
                                return FullscreenLoginPage$lambda$12$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv12);
                        it$iv12 = value$iv12;
                    }
                    Function0 function07 = (Function0) it$iv12;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1327208491, "CC(remember):FullscreenLoginPage.kt#9igjgp");
                    boolean invalid$iv13 = ($dirty2 & BR.containerVisible) == 32;
                    Object it$iv13 = $composer2.rememberedValue();
                    if (invalid$iv13) {
                    }
                    Object value$iv13 = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.FullscreenLoginPageKt$$ExternalSyntheticLambda13
                        public final Object invoke(Object obj) {
                            Unit FullscreenLoginPage$lambda$13$0;
                            FullscreenLoginPage$lambda$13$0 = FullscreenLoginPageKt.FullscreenLoginPage$lambda$13$0(function1, (String) obj);
                            return FullscreenLoginPage$lambda$13$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv13);
                    it$iv13 = value$iv13;
                    Function1 function15 = (Function1) it$iv13;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1327205769, "CC(remember):FullscreenLoginPage.kt#9igjgp");
                    boolean invalid$iv14 = ($dirty2 & BR.containerVisible) == 32;
                    Object it$iv14 = $composer2.rememberedValue();
                    if (invalid$iv14) {
                    }
                    Object value$iv14 = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.FullscreenLoginPageKt$$ExternalSyntheticLambda14
                        public final Object invoke(Object obj) {
                            Unit FullscreenLoginPage$lambda$14$0;
                            FullscreenLoginPage$lambda$14$0 = FullscreenLoginPageKt.FullscreenLoginPage$lambda$14$0(function1, (String) obj);
                            return FullscreenLoginPage$lambda$14$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv14);
                    it$iv14 = value$iv14;
                    Function1 function16 = (Function1) it$iv14;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1327202955, "CC(remember):FullscreenLoginPage.kt#9igjgp");
                    boolean invalid$iv15 = ($dirty2 & BR.containerVisible) == 32;
                    Object it$iv15 = $composer2.rememberedValue();
                    if (invalid$iv15) {
                    }
                    Object value$iv15 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.FullscreenLoginPageKt$$ExternalSyntheticLambda15
                        public final Object invoke() {
                            Unit FullscreenLoginPage$lambda$15$0;
                            FullscreenLoginPage$lambda$15$0 = FullscreenLoginPageKt.FullscreenLoginPage$lambda$15$0(function1);
                            return FullscreenLoginPage$lambda$15$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv15);
                    it$iv15 = value$iv15;
                    Function0 function08 = (Function0) it$iv15;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1327199798, "CC(remember):FullscreenLoginPage.kt#9igjgp");
                    boolean invalid$iv16 = ($dirty2 & BR.containerVisible) == 32;
                    Object it$iv16 = $composer2.rememberedValue();
                    if (invalid$iv16) {
                    }
                    Object value$iv16 = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.FullscreenLoginPageKt$$ExternalSyntheticLambda16
                        public final Object invoke(Object obj) {
                            Unit FullscreenLoginPage$lambda$16$0;
                            FullscreenLoginPage$lambda$16$0 = FullscreenLoginPageKt.FullscreenLoginPage$lambda$16$0(function1, ((Boolean) obj).booleanValue());
                            return FullscreenLoginPage$lambda$16$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv16);
                    it$iv16 = value$iv16;
                    Function1 function17 = (Function1) it$iv16;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1327192142, "CC(remember):FullscreenLoginPage.kt#9igjgp");
                    boolean invalid$iv17 = ($dirty2 & BR.containerVisible) == 32;
                    Object it$iv17 = $composer2.rememberedValue();
                    if (invalid$iv17) {
                    }
                    Object value$iv17 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.FullscreenLoginPageKt$$ExternalSyntheticLambda17
                        public final Object invoke() {
                            Unit FullscreenLoginPage$lambda$17$0;
                            FullscreenLoginPage$lambda$17$0 = FullscreenLoginPageKt.FullscreenLoginPage$lambda$17$0(function1);
                            return FullscreenLoginPage$lambda$17$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv17);
                    it$iv17 = value$iv17;
                    Function0 function09 = (Function0) it$iv17;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1327189069, "CC(remember):FullscreenLoginPage.kt#9igjgp");
                    boolean invalid$iv18 = ($dirty2 & BR.containerVisible) == 32;
                    Object it$iv18 = $composer2.rememberedValue();
                    if (invalid$iv18) {
                    }
                    Object value$iv18 = new Function2() { // from class: tv.danmaku.bili.fullscreen.page.FullscreenLoginPageKt$$ExternalSyntheticLambda18
                        public final Object invoke(Object obj, Object obj2) {
                            Unit FullscreenLoginPage$lambda$18$0;
                            FullscreenLoginPage$lambda$18$0 = FullscreenLoginPageKt.FullscreenLoginPage$lambda$18$0(function1, (SmsLoginInput) obj, (PhoneCountryCode) obj2);
                            return FullscreenLoginPage$lambda$18$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv18);
                    it$iv18 = value$iv18;
                    Function2 function2 = (Function2) it$iv18;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1327179302, "CC(remember):FullscreenLoginPage.kt#9igjgp");
                    boolean invalid$iv19 = ($dirty2 & BR.containerVisible) == 32;
                    Object it$iv19 = $composer2.rememberedValue();
                    if (invalid$iv19) {
                    }
                    Object value$iv19 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.FullscreenLoginPageKt$$ExternalSyntheticLambda19
                        public final Object invoke() {
                            Unit FullscreenLoginPage$lambda$19$0;
                            FullscreenLoginPage$lambda$19$0 = FullscreenLoginPageKt.FullscreenLoginPage$lambda$19$0(function1);
                            return FullscreenLoginPage$lambda$19$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv19);
                    it$iv19 = value$iv19;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    SmsLoginPageKt.SmsLoginPage(currentPage3, function1, function05, FullscreenLoginPage$lambda$23, function06, function07, function15, function16, function08, function17, function09, function2, (Function0) it$iv19, function12, $composer2, $dirty2 & BR.containerVisible, ($dirty2 << 3) & 7168, 0);
                    $composer2.endReplaceGroup();
                } else {
                    $composer2.startReplaceGroup(1807245761);
                    ComposerKt.sourceInformation($composer2, "125@5173L38");
                    BoxKt.Box(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer2, 6);
                    $composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            $composer2.startReplaceGroup(1804287617);
            ComposerKt.sourceInformation($composer2, "54@2191L38");
            BoxKt.Box(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer2, 6);
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fullscreen.page.FullscreenLoginPageKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit FullscreenLoginPage$lambda$20;
                    FullscreenLoginPage$lambda$20 = FullscreenLoginPageKt.FullscreenLoginPage$lambda$20(IFullscreenLoginState.this, function1, function12, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return FullscreenLoginPage$lambda$20;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenLoginPage$lambda$0$0(OnBackPressedDispatcher $onBackPressedDispatcher) {
        if ($onBackPressedDispatcher != null) {
            $onBackPressedDispatcher.onBackPressed();
            return Unit.INSTANCE;
        }
        return null;
    }

    private static final Function1<Boolean, Unit> FullscreenLoginPage$lambda$2(State<? extends Function1<? super Boolean, Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function1) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenLoginPage$lambda$1$0(Function1 $onAction, boolean login) {
        if (login) {
            $onAction.invoke(new IFullscreenLoginAction.LoginAction(null, true, null, 5, null));
        } else {
            $onAction.invoke(new IFullscreenLoginAction.ShowEulaAction(null, 1, null));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenLoginPage$lambda$3$0(Function1 $onAction) {
        $onAction.invoke(new IFullscreenLoginAction.SwitchToSms(false, 1, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenLoginPage$lambda$4$0(Function1 $onAction, boolean it) {
        $onAction.invoke(new IFullscreenLoginAction.AgreementCheckedAction(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenLoginPage$lambda$5$0(Function1 $onAction, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $onAction.invoke(new IPasswordLoginAction.AccountInputAction(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenLoginPage$lambda$6$0(Function1 $onAction, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $onAction.invoke(new IPasswordLoginAction.PasswordInputAction(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenLoginPage$lambda$7$0(Function0 $onBackPressed) {
        $onBackPressed.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenLoginPage$lambda$8$0(Function1 $onAction) {
        $onAction.invoke(new IFullscreenLoginAction.SwitchToSms(false, 1, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenLoginPage$lambda$9$0(Function1 $onAction, boolean it) {
        $onAction.invoke(new IFullscreenLoginAction.AgreementCheckedAction(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenLoginPage$lambda$10$0(Function0 $onBackPressed) {
        $onBackPressed.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenLoginPage$lambda$11$0(Function1 $onAction) {
        $onAction.invoke(new IFullscreenLoginAction.NetCodeAuth(true));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenLoginPage$lambda$12$0(Function1 $onAction) {
        $onAction.invoke(IFullscreenLoginAction.SwitchToPassword.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenLoginPage$lambda$13$0(Function1 $onAction, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $onAction.invoke(new ISmsLoginAction.PhoneInputAction(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenLoginPage$lambda$14$0(Function1 $onAction, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $onAction.invoke(new ISmsLoginAction.SmsCodeInputAction(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenLoginPage$lambda$15$0(Function1 $onAction) {
        $onAction.invoke(new ISmsLoginAction.ClickSendSmsAction(null, null, 3, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenLoginPage$lambda$16$0(Function1 $onAction, boolean it) {
        $onAction.invoke(new IFullscreenLoginAction.AgreementCheckedAction(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenLoginPage$lambda$17$0(Function1 $onAction) {
        $onAction.invoke(ISmsLoginAction.SelectCountryCode.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenLoginPage$lambda$18$0(Function1 $onAction, SmsLoginInput input, PhoneCountryCode code) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(code, LoginReporterV2.Show.SIGNUP_KEY_CODE);
        $onAction.invoke(new ISmsLoginAction.OnCountryCodeSelected(input, code));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenLoginPage$lambda$19$0(Function1 $onAction) {
        $onAction.invoke(ISmsLoginAction.OnCountryCodeSelectCancel.INSTANCE);
        return Unit.INSTANCE;
    }
}