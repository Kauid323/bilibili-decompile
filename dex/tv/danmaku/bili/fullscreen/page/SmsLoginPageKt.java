package tv.danmaku.bili.fullscreen.page;

import ComposableSingletons$CustomBottomSheetKt$;
import android.content.Context;
import androidx.activity.compose.BackHandlerKt;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
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
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.text.KeyboardActionScope;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import bili.resource.account.R;
import com.bilibili.compose.text.SimpleTextFieldKt;
import com.bilibili.compose.text.TextFieldColors;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.utils.ModifierUtilsKt;
import com.google.accompanist.drawablepainter.DrawablePainterKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import shark.AndroidResourceIdNames;
import tv.danmaku.android.log.cache.RingBuffer;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.eula.EulaLinkType;
import tv.danmaku.bili.fullscreen.data.PhoneCountryCode;
import tv.danmaku.bili.fullscreen.state.IFullscreenAction;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginReportAction;
import tv.danmaku.bili.fullscreen.state.ISmsLoginCountingState;
import tv.danmaku.bili.fullscreen.state.ISmsLoginPageState;
import tv.danmaku.bili.fullscreen.state.NetCodeIdle;
import tv.danmaku.bili.fullscreen.state.NetCodeState;
import tv.danmaku.bili.fullscreen.state.SmsLoginInput;
import tv.danmaku.bili.fullscreen.state.SmsLoginLoadingCountingState;
import tv.danmaku.bili.fullscreen.state.SmsLoginLoadingIdleState;
import tv.danmaku.bili.fullscreen.state.SmsLoginPageInitialState;
import tv.danmaku.bili.fullscreen.state.SmsLoginPageInputCountingState;
import tv.danmaku.bili.fullscreen.state.SmsLoginPageInputIdleState;
import tv.danmaku.bili.fullscreen.state.SmsLoginSelectCountryCodeState;
import tv.danmaku.bili.normal.ui.EulaTriggerType;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: SmsLoginPage.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\u001a\u0093\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00052\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u001a\b\u0002\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u00142\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0019\u001a=\u0010\u001a\u001a\u00020\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\u001e\u001a\u007f\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007¢\u0006\u0002\u0010&\u001a?\u0010'\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00162\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0003¢\u0006\u0002\u0010(\u001aU\u0010)\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0003¢\u0006\u0002\u0010+\u001a)\u0010,\u001a\u00020\u00012\u0006\u0010-\u001a\u00020\u00162\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010/¨\u00060"}, d2 = {"SmsLoginPage", "", LoginReporterV2.PAGE_FROM_KEY, "Ltv/danmaku/bili/fullscreen/state/ISmsLoginPageState;", "onAction", "Lkotlin/Function1;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenAction;", "onBackPressed", "Lkotlin/Function0;", "onLoginClick", "", "onNetCodeClick", "onSwitchClick", "onPhoneInput", "", "onSmsCodeInput", "onSendCodeClick", "onLoginAgreementChecked", "onCountryCodeSwitchClick", "onCountryCodeSelected", "Lkotlin/Function2;", "Ltv/danmaku/bili/fullscreen/state/SmsLoginInput;", "Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;", "onCountryCodeCancel", "routeTo", "(Ltv/danmaku/bili/fullscreen/state/ISmsLoginPageState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "SelectCountryCodePage", "list", "", "onSelected", "(Lkotlin/jvm/functions/Function0;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "SmsInputGroup", "phone", "countryCode", "smsCode", "counting", "", "onCountryCodeClick", "(Ljava/lang/String;Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;Ljava/lang/String;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "PhoneRow", "(Ljava/lang/String;Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SmsRow", "onSendClick", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "CountryCodeItem", LoginReporterV2.Show.SIGNUP_KEY_CODE, "onItemClick", "(Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "accountui_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SmsLoginPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CountryCodeItem$lambda$2(PhoneCountryCode phoneCountryCode, Function1 function1, int i, Composer composer, int i2) {
        CountryCodeItem(phoneCountryCode, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PhoneRow$lambda$1(String str, PhoneCountryCode phoneCountryCode, Function1 function1, Function0 function0, int i, Composer composer, int i2) {
        PhoneRow(str, phoneCountryCode, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectCountryCodePage$lambda$2(Function0 function0, List list, Function1 function1, int i, Composer composer, int i2) {
        SelectCountryCodePage(function0, list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmsInputGroup$lambda$1(String str, PhoneCountryCode phoneCountryCode, String str2, int i, Function1 function1, Function1 function12, Function0 function0, Function0 function02, Function0 function03, int i2, Composer composer, int i3) {
        SmsInputGroup(str, phoneCountryCode, str2, i, function1, function12, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmsLoginPage$lambda$15(ISmsLoginPageState iSmsLoginPageState, Function1 function1, Function0 function0, Function1 function12, Function0 function02, Function0 function03, Function1 function13, Function1 function14, Function0 function04, Function1 function15, Function0 function05, Function2 function2, Function0 function06, Function1 function16, int i, int i2, int i3, Composer composer, int i4) {
        SmsLoginPage(iSmsLoginPageState, function1, function0, function12, function02, function03, function13, function14, function04, function15, function05, function2, function06, function16, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmsRow$lambda$1(String str, String str2, int i, Function1 function1, Function0 function0, Function0 function02, int i2, Composer composer, int i3) {
        SmsRow(str, str2, i, function1, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmsLoginPage$lambda$1$0(boolean it) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmsLoginPage$lambda$4$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmsLoginPage$lambda$5$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmsLoginPage$lambda$7$0(boolean it) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmsLoginPage$lambda$9$0(SmsLoginInput smsLoginInput, PhoneCountryCode phoneCountryCode) {
        Intrinsics.checkNotNullParameter(smsLoginInput, "<unused var>");
        Intrinsics.checkNotNullParameter(phoneCountryCode, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmsLoginPage$lambda$11$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:303:0x07ce, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x08d2, code lost:
        if (r15 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L179;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:278:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x08b5  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x08b7  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x08ca  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x08d6  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0967  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x098f  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x09c0  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x09c2  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x09cc  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x09db  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0a3b  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0a3d  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0a47  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0ae5  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0ae7  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0af2  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0b21  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0b57  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x0bc5  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x0bda  */
    /* JADX WARN: Type inference failed for: r13v38 */
    /* JADX WARN: Type inference failed for: r13v43 */
    /* JADX WARN: Type inference failed for: r13v48 */
    /* JADX WARN: Type inference failed for: r13v52 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SmsLoginPage(final ISmsLoginPageState page, final Function1<? super IFullscreenAction, Unit> function1, Function0<Unit> function0, Function1<? super Boolean, Unit> function12, Function0<Unit> function02, Function0<Unit> function03, Function1<? super String, Unit> function13, Function1<? super String, Unit> function14, Function0<Unit> function04, Function1<? super Boolean, Unit> function15, Function0<Unit> function05, Function2<? super SmsLoginInput, ? super PhoneCountryCode, Unit> function2, Function0<Unit> function06, Function1<? super String, Unit> function16, Composer $composer, final int $changed, final int $changed1, final int i) {
        int $dirty;
        Function0 onBackPressed;
        Function1 onLoginClick;
        Function0 onNetCodeClick;
        Function0 onSwitchClick;
        Function1 onPhoneInput;
        Function1 onSmsCodeInput;
        Function0 onSendCodeClick;
        Function1 onLoginAgreementChecked;
        Function0 onCountryCodeSwitchClick;
        Function2 onCountryCodeSelected;
        Function0 onCountryCodeCancel;
        Function1 routeTo;
        Function0 onBackPressed2;
        Function1 onLoginClick2;
        Function1 onLoginClick3;
        Function0 onNetCodeClick2;
        Function0 onSwitchClick2;
        Function1 onPhoneInput2;
        Function1 onSmsCodeInput2;
        final Function0 onSendCodeClick2;
        Function1 onLoginAgreementChecked2;
        Function0 onCountryCodeSwitchClick2;
        Function2 onCountryCodeSelected2;
        Function0 onCountryCodeCancel2;
        Function1 routeTo2;
        Function0 onCountryCodeCancel3;
        boolean isNetCodeBinding;
        Function2 onCountryCodeSelected3;
        boolean z;
        boolean z2;
        Function0 onCountryCodeCancel4;
        final Function2 onCountryCodeSelected4;
        Function0 factory$iv$iv$iv;
        int i2;
        String stringResource;
        Function0 factory$iv$iv$iv2;
        final Function1 onLoginClick4;
        boolean invalid$iv;
        boolean invalid$iv2;
        final Function1<? super IFullscreenAction, Unit> function17;
        Object value$iv;
        boolean invalid$iv3;
        Object it$iv;
        boolean invalid$iv4;
        Object it$iv2;
        Intrinsics.checkNotNullParameter(page, LoginReporterV2.PAGE_FROM_KEY);
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Composer $composer2 = $composer.startRestartGroup(462637278);
        ComposerKt.sourceInformation($composer2, "C(SmsLoginPage)N(page,onAction,onBackPressed,onLoginClick,onNetCodeClick,onSwitchClick,onPhoneInput,onSmsCodeInput,onSendCodeClick,onLoginAgreementChecked,onCountryCodeSwitchClick,onCountryCodeSelected,onCountryCodeCancel,routeTo)76@3553L2,77@3595L2,78@3632L2,79@3668L2,80@3709L2,81@3752L2,82@3790L2,83@3843L2,84@3890L2,85@3965L11,86@4016L2,87@4052L2:SmsLoginPage.kt#gqoihp");
        int $dirty2 = $changed;
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty2 |= ($changed & 8) == 0 ? $composer2.changed(page) : $composer2.changedInstance(page) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= BR.negativeBtnVisible;
        } else if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? BR.hallEnterHotText : BR.cover;
        }
        int i4 = i & 8;
        int i5 = MisakaHelper.MAX_REPORT_SIZE;
        if (i4 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changedInstance(function12) ? 2048 : 1024;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty2 |= $composer2.changedInstance(function02) ? RingBuffer.CONSUME_SIZE : 8192;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty2 |= $composer2.changedInstance(function03) ? 131072 : AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer2.changedInstance(function13) ? 1048576 : 524288;
        }
        int i9 = i & BR.cover;
        if (i9 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer2.changedInstance(function14) ? 8388608 : 4194304;
        }
        int i10 = i & BR.hallEnterHotText;
        if (i10 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer2.changedInstance(function04) ? 67108864 : 33554432;
        }
        int i11 = i & BR.roleType;
        if (i11 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer2.changedInstance(function15) ? 536870912 : 268435456;
        }
        int i12 = i & MisakaHelper.MAX_REPORT_SIZE;
        if (i12 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer2.changedInstance(function05) ? 4 : 2;
        }
        int i13 = i & 2048;
        if (i13 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty1 |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        int i14 = i & 4096;
        if (i14 != 0) {
            $dirty1 |= BR.negativeBtnVisible;
        } else if (($changed1 & BR.negativeBtnVisible) == 0) {
            $dirty1 |= $composer2.changedInstance(function06) ? BR.hallEnterHotText : BR.cover;
        }
        int i15 = i & 8192;
        if (i15 != 0) {
            $dirty1 |= 3072;
        } else if (($changed1 & 3072) == 0) {
            if ($composer2.changedInstance(function16)) {
                i5 = 2048;
            }
            $dirty1 |= i5;
        }
        if ($composer2.shouldExecute((($dirty2 & 306783379) == 306783378 && ($dirty1 & 1171) == 1170) ? false : true, $dirty2 & 1)) {
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -2082170688, "CC(remember):SmsLoginPage.kt#9igjgp");
                Object it$iv3 = $composer2.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda10
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv3 = value$iv2;
                }
                onBackPressed2 = it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onBackPressed2 = function0;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -2082169344, "CC(remember):SmsLoginPage.kt#9igjgp");
                Object it$iv4 = $composer2.rememberedValue();
                if (it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            Unit SmsLoginPage$lambda$1$0;
                            SmsLoginPage$lambda$1$0 = SmsLoginPageKt.SmsLoginPage$lambda$1$0(((Boolean) obj).booleanValue());
                            return SmsLoginPage$lambda$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                    it$iv4 = value$iv3;
                }
                onLoginClick2 = (Function1) it$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onLoginClick2 = function12;
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -2082168160, "CC(remember):SmsLoginPage.kt#9igjgp");
                Object it$iv5 = $composer2.rememberedValue();
                onLoginClick3 = onLoginClick2;
                if (it$iv5 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv4);
                    it$iv5 = value$iv4;
                }
                onNetCodeClick2 = it$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onLoginClick3 = onLoginClick2;
                onNetCodeClick2 = function02;
            }
            if (i7 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -2082167008, "CC(remember):SmsLoginPage.kt#9igjgp");
                Object it$iv6 = $composer2.rememberedValue();
                onNetCodeClick = onNetCodeClick2;
                if (it$iv6 == Composer.Companion.getEmpty()) {
                    Object value$iv5 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv5);
                    it$iv6 = value$iv5;
                }
                onSwitchClick2 = it$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onNetCodeClick = onNetCodeClick2;
                onSwitchClick2 = function03;
            }
            if (i8 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -2082165696, "CC(remember):SmsLoginPage.kt#9igjgp");
                Object it$iv7 = $composer2.rememberedValue();
                onSwitchClick = onSwitchClick2;
                if (it$iv7 == Composer.Companion.getEmpty()) {
                    Object value$iv6 = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj) {
                            Unit SmsLoginPage$lambda$4$0;
                            SmsLoginPage$lambda$4$0 = SmsLoginPageKt.SmsLoginPage$lambda$4$0((String) obj);
                            return SmsLoginPage$lambda$4$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv6);
                    it$iv7 = value$iv6;
                }
                onPhoneInput2 = it$iv7;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onSwitchClick = onSwitchClick2;
                onPhoneInput2 = function13;
            }
            if (i9 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -2082164320, "CC(remember):SmsLoginPage.kt#9igjgp");
                Object it$iv8 = $composer2.rememberedValue();
                if (it$iv8 == Composer.Companion.getEmpty()) {
                    Object value$iv7 = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj) {
                            Unit SmsLoginPage$lambda$5$0;
                            SmsLoginPage$lambda$5$0 = SmsLoginPageKt.SmsLoginPage$lambda$5$0((String) obj);
                            return SmsLoginPage$lambda$5$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv7);
                    it$iv8 = value$iv7;
                }
                onSmsCodeInput2 = (Function1) it$iv8;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onSmsCodeInput2 = function14;
            }
            if (i10 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -2082163104, "CC(remember):SmsLoginPage.kt#9igjgp");
                Object it$iv9 = $composer2.rememberedValue();
                if (it$iv9 == Composer.Companion.getEmpty()) {
                    Object value$iv8 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda6
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv8);
                    it$iv9 = value$iv8;
                }
                onSendCodeClick2 = (Function0) it$iv9;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onSendCodeClick2 = function04;
            }
            if (i11 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -2082161408, "CC(remember):SmsLoginPage.kt#9igjgp");
                Object it$iv10 = $composer2.rememberedValue();
                if (it$iv10 == Composer.Companion.getEmpty()) {
                    Object value$iv9 = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda7
                        public final Object invoke(Object obj) {
                            Unit SmsLoginPage$lambda$7$0;
                            SmsLoginPage$lambda$7$0 = SmsLoginPageKt.SmsLoginPage$lambda$7$0(((Boolean) obj).booleanValue());
                            return SmsLoginPage$lambda$7$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv9);
                    it$iv10 = value$iv9;
                }
                onLoginAgreementChecked2 = (Function1) it$iv10;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onLoginAgreementChecked2 = function15;
            }
            if (i12 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -2082159904, "CC(remember):SmsLoginPage.kt#9igjgp");
                Object it$iv11 = $composer2.rememberedValue();
                if (it$iv11 == Composer.Companion.getEmpty()) {
                    Object value$iv10 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda8
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv10);
                    it$iv11 = value$iv10;
                }
                onCountryCodeSwitchClick2 = (Function0) it$iv11;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onCountryCodeSwitchClick2 = function05;
            }
            if (i13 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -2082157495, "CC(remember):SmsLoginPage.kt#9igjgp");
                Object it$iv12 = $composer2.rememberedValue();
                if (it$iv12 == Composer.Companion.getEmpty()) {
                    Object value$iv11 = new Function2() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda9
                        public final Object invoke(Object obj, Object obj2) {
                            Unit SmsLoginPage$lambda$9$0;
                            SmsLoginPage$lambda$9$0 = SmsLoginPageKt.SmsLoginPage$lambda$9$0((SmsLoginInput) obj, (PhoneCountryCode) obj2);
                            return SmsLoginPage$lambda$9$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv11);
                    it$iv12 = value$iv11;
                }
                onCountryCodeSelected2 = (Function2) it$iv12;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onCountryCodeSelected2 = function2;
            }
            if (i14 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -2082155872, "CC(remember):SmsLoginPage.kt#9igjgp");
                Object it$iv13 = $composer2.rememberedValue();
                if (it$iv13 == Composer.Companion.getEmpty()) {
                    Object value$iv12 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda21
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv12);
                    it$iv13 = value$iv12;
                }
                onCountryCodeCancel2 = (Function0) it$iv13;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onCountryCodeCancel2 = function06;
            }
            if (i15 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -2082154720, "CC(remember):SmsLoginPage.kt#9igjgp");
                Object it$iv14 = $composer2.rememberedValue();
                if (it$iv14 == Composer.Companion.getEmpty()) {
                    Object value$iv13 = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda23
                        public final Object invoke(Object obj) {
                            Unit SmsLoginPage$lambda$11$0;
                            SmsLoginPage$lambda$11$0 = SmsLoginPageKt.SmsLoginPage$lambda$11$0((String) obj);
                            return SmsLoginPage$lambda$11$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv13);
                    it$iv14 = value$iv13;
                }
                routeTo2 = (Function1) it$iv14;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                routeTo2 = function16;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(462637278, $dirty2, $dirty1, "tv.danmaku.bili.fullscreen.page.SmsLoginPage (SmsLoginPage.kt:88)");
            }
            final SmsLoginInput pageState = page instanceof SmsLoginLoadingCountingState ? ((SmsLoginLoadingCountingState) page).getOriginal().getInput() : page instanceof SmsLoginPageInputCountingState ? ((SmsLoginPageInputCountingState) page).getInput() : page instanceof SmsLoginPageInputIdleState ? ((SmsLoginPageInputIdleState) page).getInput() : page instanceof SmsLoginLoadingIdleState ? ((SmsLoginLoadingIdleState) page).getInput() : page instanceof SmsLoginPageInitialState ? null : page instanceof SmsLoginSelectCountryCodeState ? null : null;
            int counting = page instanceof ISmsLoginCountingState ? ((ISmsLoginCountingState) page).getCountDown() : 0;
            if (pageState != null) {
                onCountryCodeCancel3 = onCountryCodeCancel2;
                if (pageState.isPhoneBindingForNetCodeLogin()) {
                    isNetCodeBinding = true;
                    if (pageState == null) {
                        $composer2.startReplaceGroup(-121472818);
                        ComposerKt.sourceInformation($composer2, "108@4723L3324,185@8084L7,186@8139L1677,186@8100L1716");
                        onCountryCodeSelected3 = onCountryCodeSelected2;
                        ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.Companion;
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Function1 routeTo3 = routeTo2;
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                        onLoginAgreementChecked = onLoginAgreementChecked2;
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & BR.containerVisible));
                        int $changed$iv$iv = (0 << 3) & BR.containerVisible;
                        ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                        CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                        Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        onCountryCodeSwitchClick = onCountryCodeSwitchClick2;
                        onSmsCodeInput = onSmsCodeInput2;
                        ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer2.startReusableNode();
                        if ($composer2.getInserting()) {
                            factory$iv$iv$iv = factory$iv$iv$iv3;
                            $composer2.createNode(factory$iv$iv$iv);
                        } else {
                            factory$iv$iv$iv = factory$iv$iv$iv3;
                            $composer2.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
                        onPhoneInput = onPhoneInput2;
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                        int i16 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                        int i17 = ((0 >> 6) & BR.containerVisible) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, -194855369, "C109@4744L345,117@5102L2935:SmsLoginPage.kt#gqoihp");
                        if (isNetCodeBinding) {
                            $composer2.startReplaceGroup(-194899421);
                            ComposerKt.sourceInformation($composer2, "111@4821L72");
                            i2 = 0;
                            stringResource = StringResources_androidKt.stringResource(R.string.account_global_string_422, $composer2, 0);
                            $composer2.endReplaceGroup();
                        } else {
                            i2 = 0;
                            $composer2.startReplaceGroup(-194782365);
                            ComposerKt.sourceInformation($composer2, "113@4939L72");
                            stringResource = StringResources_androidKt.stringResource(R.string.account_global_string_186, $composer2, 0);
                            $composer2.endReplaceGroup();
                        }
                        CommonKt.PageHead(stringResource, onBackPressed2, $composer2, ($dirty2 >> 3) & BR.containerVisible, i2);
                        onBackPressed = onBackPressed2;
                        Modifier modifier$iv2 = WindowInsetsPadding_androidKt.navigationBarsPadding(PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(24), 0.0f, 2, (Object) null), 0.0f, Dp.constructor-impl(32), 0.0f, 0.0f, 13, (Object) null));
                        Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getCenterHorizontally();
                        ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                        MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer2, ((BR.negativeBtnVisible >> 3) & 14) | ((BR.negativeBtnVisible >> 3) & BR.containerVisible));
                        int $changed$iv$iv2 = (BR.negativeBtnVisible << 3) & BR.containerVisible;
                        ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                        CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                        Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer2.startReusableNode();
                        if ($composer2.getInserting()) {
                            factory$iv$iv$iv2 = factory$iv$iv$iv4;
                            $composer2.createNode(factory$iv$iv$iv2);
                        } else {
                            factory$iv$iv$iv2 = factory$iv$iv$iv4;
                            $composer2.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                        int i18 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                        int i19 = ((BR.negativeBtnVisible >> 6) & BR.containerVisible) | 6;
                        ColumnScope $this$SmsLoginPage_u24lambda_u2412_u240 = columnScope2;
                        ComposerKt.sourceInformationMarkerStart($composer2, 636851925, "C133@5805L21,135@5930L44,126@5454L539,140@6222L70,141@6329L44,137@6010L382,160@7093L38,166@7362L344,162@7149L576,176@7742L41,178@7850L57,177@7800L165,181@7982L41:SmsLoginPage.kt#gqoihp");
                        String phone = pageState.getPhone();
                        String smsCode = pageState.getSmsCode();
                        PhoneCountryCode selectedCountry = pageState.getSelectedCountry();
                        ComposerKt.sourceInformationMarkerStart($composer2, -395089702, "CC(remember):SmsLoginPage.kt#9igjgp");
                        boolean invalid$iv5 = (234881024 & $dirty2) == 67108864;
                        Object it$iv15 = $composer2.rememberedValue();
                        if (invalid$iv5) {
                        }
                        Object value$iv14 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda24
                            public final Object invoke() {
                                Unit SmsLoginPage$lambda$12$0$0$0;
                                SmsLoginPage$lambda$12$0$0$0 = SmsLoginPageKt.SmsLoginPage$lambda$12$0$0$0(onSendCodeClick2);
                                return SmsLoginPage$lambda$12$0$0$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv14);
                        it$iv15 = value$iv14;
                        Function0 function07 = (Function0) it$iv15;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerStart($composer2, -395085679, "CC(remember):SmsLoginPage.kt#9igjgp");
                        boolean invalid$iv6 = (($dirty2 & 7168) == 2048) | $composer2.changedInstance(pageState);
                        onSendCodeClick = onSendCodeClick2;
                        Object value$iv15 = $composer2.rememberedValue();
                        if (!invalid$iv6 && value$iv15 != Composer.Companion.getEmpty()) {
                            onLoginClick4 = onLoginClick3;
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            SmsInputGroup(phone, selectedCountry, smsCode, counting, onPhoneInput, onSmsCodeInput, function07, onCountryCodeSwitchClick, value$iv15, $composer2, (($dirty2 >> 6) & 57344) | (($dirty2 >> 6) & 458752) | (($dirty1 << 21) & 29360128));
                            Modifier modifier = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(32), 0.0f, Dp.constructor-impl(24), 5, (Object) null);
                            boolean z3 = StringsKt.isBlank(pageState.getPhone()) && !StringsKt.isBlank(pageState.getSmsCode());
                            String stringResource2 = StringResources_androidKt.stringResource(bili.resource.common.R.string.common_global_string_290, $composer2, 0);
                            ComposerKt.sourceInformationMarkerStart($composer2, -395072911, "CC(remember):SmsLoginPage.kt#9igjgp");
                            invalid$iv = (($dirty2 & 7168) != 2048) | $composer2.changedInstance(pageState);
                            Object it$iv16 = $composer2.rememberedValue();
                            if (invalid$iv) {
                            }
                            Object value$iv16 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda26
                                public final Object invoke() {
                                    Unit SmsLoginPage$lambda$12$0$2$0;
                                    SmsLoginPage$lambda$12$0$2$0 = SmsLoginPageKt.SmsLoginPage$lambda$12$0$2$0(onLoginClick4, pageState);
                                    return SmsLoginPage$lambda$12$0$2$0;
                                }
                            };
                            $composer2.updateRememberedValue(value$iv16);
                            it$iv16 = value$iv16;
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            CommonKt.LoginButton(stringResource2, z3, modifier, (Function0) it$iv16, $composer2, BR.negativeBtnVisible, 0);
                            if (!Intrinsics.areEqual(pageState.getNetCodeState(), NetCodeIdle.INSTANCE) || isNetCodeBinding) {
                                $composer2.startReplaceGroup(631360925);
                            } else {
                                $composer2.startReplaceGroup(637798695);
                                ComposerKt.sourceInformation($composer2, "146@6546L77,145@6501L270");
                                CommonKt.SwitchLogin(StringResources_androidKt.stringResource(R.string.account_global_string_419, $composer2, 0), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(24), 7, (Object) null), onNetCodeClick, $composer2, (($dirty2 >> 6) & 896) | 48, 0);
                            }
                            $composer2.endReplaceGroup();
                            if (isNetCodeBinding) {
                                $composer2.startReplaceGroup(638149646);
                                ComposerKt.sourceInformation($composer2, "154@6902L76,153@6857L199");
                                CommonKt.SwitchLogin(StringResources_androidKt.stringResource(R.string.account_global_string_72, $composer2, 0), null, onSwitchClick, $composer2, ($dirty2 >> 9) & 896, 2);
                            } else {
                                $composer2.startReplaceGroup(631360925);
                            }
                            $composer2.endReplaceGroup();
                            SpacerKt.Spacer(ColumnScope.-CC.weight$default($this$SmsLoginPage_u24lambda_u2412_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer2, 0);
                            boolean agreementChecked = pageState.getAgreementChecked();
                            ComposerKt.sourceInformationMarkerStart($composer2, -395039555, "CC(remember):SmsLoginPage.kt#9igjgp");
                            invalid$iv2 = ($dirty2 & BR.containerVisible) != 32;
                            Object it$iv17 = $composer2.rememberedValue();
                            if (invalid$iv2) {
                                onLoginClick = onLoginClick4;
                                if (it$iv17 != Composer.Companion.getEmpty()) {
                                    value$iv = it$iv17;
                                    function17 = function1;
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    CommonKt.LoginAgreement(null, agreementChecked, null, onLoginAgreementChecked, routeTo3, (Function3) value$iv, null, $composer2, (($dirty2 >> 18) & 7168) | (57344 & ($dirty1 << 3)), 69);
                                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(40)), $composer2, 6);
                                    ComposerKt.sourceInformationMarkerStart($composer2, -395024226, "CC(remember):SmsLoginPage.kt#9igjgp");
                                    invalid$iv3 = ($dirty2 & BR.containerVisible) == 32;
                                    it$iv = $composer2.rememberedValue();
                                    if (!invalid$iv3 || it$iv == Composer.Companion.getEmpty()) {
                                        Object value$iv17 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda28
                                            public final Object invoke() {
                                                Unit SmsLoginPage$lambda$12$0$4$0;
                                                SmsLoginPage$lambda$12$0$4$0 = SmsLoginPageKt.SmsLoginPage$lambda$12$0$4$0(function17);
                                                return SmsLoginPage$lambda$12$0$4$0;
                                            }
                                        };
                                        $composer2.updateRememberedValue(value$iv17);
                                        it$iv = value$iv17;
                                    }
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    routeTo2 = routeTo3;
                                    CommonKt.LoginHelp((Function0) it$iv, routeTo2, $composer2, ($dirty1 >> 6) & BR.containerVisible);
                                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), $composer2, 6);
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    $composer2.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    $composer2.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
                                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object consume = $composer2.consume(this_$iv);
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    Context context = (Context) consume;
                                    NetCodeState netCodeState = pageState.getNetCodeState();
                                    ComposerKt.sourceInformationMarkerStart($composer2, -2082022261, "CC(remember):SmsLoginPage.kt#9igjgp");
                                    invalid$iv4 = $composer2.changedInstance(pageState) | $composer2.changedInstance(context) | (($dirty2 & BR.containerVisible) == 32);
                                    it$iv2 = $composer2.rememberedValue();
                                    if (!invalid$iv4 || it$iv2 == Composer.Companion.getEmpty()) {
                                        Object value$iv18 = (Function2) new SmsLoginPageKt$SmsLoginPage$14$1(pageState, context, function17, null);
                                        $composer2.updateRememberedValue(value$iv18);
                                        it$iv2 = value$iv18;
                                    }
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    z = false;
                                    EffectsKt.LaunchedEffect(netCodeState, (Function2) it$iv2, $composer2, 0);
                                    $composer2.endReplaceGroup();
                                    z2 = true;
                                }
                            } else {
                                onLoginClick = onLoginClick4;
                            }
                            function17 = function1;
                            Object obj = new Function3() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda27
                                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                                    Unit SmsLoginPage$lambda$12$0$3$0;
                                    SmsLoginPage$lambda$12$0$3$0 = SmsLoginPageKt.SmsLoginPage$lambda$12$0$3$0(function17, (EulaLinkType) obj2, ((Boolean) obj3).booleanValue(), (EulaTriggerType) obj4);
                                    return SmsLoginPage$lambda$12$0$3$0;
                                }
                            };
                            $composer2.updateRememberedValue(obj);
                            value$iv = obj;
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            CommonKt.LoginAgreement(null, agreementChecked, null, onLoginAgreementChecked, routeTo3, (Function3) value$iv, null, $composer2, (($dirty2 >> 18) & 7168) | (57344 & ($dirty1 << 3)), 69);
                            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(40)), $composer2, 6);
                            ComposerKt.sourceInformationMarkerStart($composer2, -395024226, "CC(remember):SmsLoginPage.kt#9igjgp");
                            if (($dirty2 & BR.containerVisible) == 32) {
                            }
                            it$iv = $composer2.rememberedValue();
                            if (!invalid$iv3) {
                            }
                            Object value$iv172 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda28
                                public final Object invoke() {
                                    Unit SmsLoginPage$lambda$12$0$4$0;
                                    SmsLoginPage$lambda$12$0$4$0 = SmsLoginPageKt.SmsLoginPage$lambda$12$0$4$0(function17);
                                    return SmsLoginPage$lambda$12$0$4$0;
                                }
                            };
                            $composer2.updateRememberedValue(value$iv172);
                            it$iv = value$iv172;
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            routeTo2 = routeTo3;
                            CommonKt.LoginHelp((Function0) it$iv, routeTo2, $composer2, ($dirty1 >> 6) & BR.containerVisible);
                            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), $composer2, 6);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            $composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            $composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            CompositionLocal this_$iv2 = AndroidCompositionLocals_androidKt.getLocalContext();
                            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume2 = $composer2.consume(this_$iv2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            Context context2 = (Context) consume2;
                            NetCodeState netCodeState2 = pageState.getNetCodeState();
                            ComposerKt.sourceInformationMarkerStart($composer2, -2082022261, "CC(remember):SmsLoginPage.kt#9igjgp");
                            invalid$iv4 = $composer2.changedInstance(pageState) | $composer2.changedInstance(context2) | (($dirty2 & BR.containerVisible) == 32);
                            it$iv2 = $composer2.rememberedValue();
                            if (!invalid$iv4) {
                            }
                            Object value$iv182 = (Function2) new SmsLoginPageKt$SmsLoginPage$14$1(pageState, context2, function17, null);
                            $composer2.updateRememberedValue(value$iv182);
                            it$iv2 = value$iv182;
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            z = false;
                            EffectsKt.LaunchedEffect(netCodeState2, (Function2) it$iv2, $composer2, 0);
                            $composer2.endReplaceGroup();
                            z2 = true;
                        }
                        onLoginClick4 = onLoginClick3;
                        value$iv15 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda25
                            public final Object invoke() {
                                Unit SmsLoginPage$lambda$12$0$1$0;
                                SmsLoginPage$lambda$12$0$1$0 = SmsLoginPageKt.SmsLoginPage$lambda$12$0$1$0(onLoginClick4, pageState);
                                return SmsLoginPage$lambda$12$0$1$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv15);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        SmsInputGroup(phone, selectedCountry, smsCode, counting, onPhoneInput, onSmsCodeInput, function07, onCountryCodeSwitchClick, value$iv15, $composer2, (($dirty2 >> 6) & 57344) | (($dirty2 >> 6) & 458752) | (($dirty1 << 21) & 29360128));
                        Modifier modifier2 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(32), 0.0f, Dp.constructor-impl(24), 5, (Object) null);
                        if (StringsKt.isBlank(pageState.getPhone())) {
                        }
                        String stringResource22 = StringResources_androidKt.stringResource(bili.resource.common.R.string.common_global_string_290, $composer2, 0);
                        ComposerKt.sourceInformationMarkerStart($composer2, -395072911, "CC(remember):SmsLoginPage.kt#9igjgp");
                        invalid$iv = (($dirty2 & 7168) != 2048) | $composer2.changedInstance(pageState);
                        Object it$iv162 = $composer2.rememberedValue();
                        if (invalid$iv) {
                        }
                        Object value$iv162 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda26
                            public final Object invoke() {
                                Unit SmsLoginPage$lambda$12$0$2$0;
                                SmsLoginPage$lambda$12$0$2$0 = SmsLoginPageKt.SmsLoginPage$lambda$12$0$2$0(onLoginClick4, pageState);
                                return SmsLoginPage$lambda$12$0$2$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv162);
                        it$iv162 = value$iv162;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        CommonKt.LoginButton(stringResource22, z3, modifier2, (Function0) it$iv162, $composer2, BR.negativeBtnVisible, 0);
                        if (Intrinsics.areEqual(pageState.getNetCodeState(), NetCodeIdle.INSTANCE)) {
                        }
                        $composer2.startReplaceGroup(631360925);
                        $composer2.endReplaceGroup();
                        if (isNetCodeBinding) {
                        }
                        $composer2.endReplaceGroup();
                        SpacerKt.Spacer(ColumnScope.-CC.weight$default($this$SmsLoginPage_u24lambda_u2412_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer2, 0);
                        boolean agreementChecked2 = pageState.getAgreementChecked();
                        ComposerKt.sourceInformationMarkerStart($composer2, -395039555, "CC(remember):SmsLoginPage.kt#9igjgp");
                        if (($dirty2 & BR.containerVisible) != 32) {
                        }
                        Object it$iv172 = $composer2.rememberedValue();
                        if (invalid$iv2) {
                        }
                        function17 = function1;
                        Object obj2 = new Function3() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda27
                            public final Object invoke(Object obj22, Object obj3, Object obj4) {
                                Unit SmsLoginPage$lambda$12$0$3$0;
                                SmsLoginPage$lambda$12$0$3$0 = SmsLoginPageKt.SmsLoginPage$lambda$12$0$3$0(function17, (EulaLinkType) obj22, ((Boolean) obj3).booleanValue(), (EulaTriggerType) obj4);
                                return SmsLoginPage$lambda$12$0$3$0;
                            }
                        };
                        $composer2.updateRememberedValue(obj2);
                        value$iv = obj2;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        CommonKt.LoginAgreement(null, agreementChecked2, null, onLoginAgreementChecked, routeTo3, (Function3) value$iv, null, $composer2, (($dirty2 >> 18) & 7168) | (57344 & ($dirty1 << 3)), 69);
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(40)), $composer2, 6);
                        ComposerKt.sourceInformationMarkerStart($composer2, -395024226, "CC(remember):SmsLoginPage.kt#9igjgp");
                        if (($dirty2 & BR.containerVisible) == 32) {
                        }
                        it$iv = $composer2.rememberedValue();
                        if (!invalid$iv3) {
                        }
                        Object value$iv1722 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda28
                            public final Object invoke() {
                                Unit SmsLoginPage$lambda$12$0$4$0;
                                SmsLoginPage$lambda$12$0$4$0 = SmsLoginPageKt.SmsLoginPage$lambda$12$0$4$0(function17);
                                return SmsLoginPage$lambda$12$0$4$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv1722);
                        it$iv = value$iv1722;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        routeTo2 = routeTo3;
                        CommonKt.LoginHelp((Function0) it$iv, routeTo2, $composer2, ($dirty1 >> 6) & BR.containerVisible);
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), $composer2, 6);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        CompositionLocal this_$iv22 = AndroidCompositionLocals_androidKt.getLocalContext();
                        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object consume22 = $composer2.consume(this_$iv22);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        Context context22 = (Context) consume22;
                        NetCodeState netCodeState22 = pageState.getNetCodeState();
                        ComposerKt.sourceInformationMarkerStart($composer2, -2082022261, "CC(remember):SmsLoginPage.kt#9igjgp");
                        invalid$iv4 = $composer2.changedInstance(pageState) | $composer2.changedInstance(context22) | (($dirty2 & BR.containerVisible) == 32);
                        it$iv2 = $composer2.rememberedValue();
                        if (!invalid$iv4) {
                        }
                        Object value$iv1822 = (Function2) new SmsLoginPageKt$SmsLoginPage$14$1(pageState, context22, function17, null);
                        $composer2.updateRememberedValue(value$iv1822);
                        it$iv2 = value$iv1822;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        z = false;
                        EffectsKt.LaunchedEffect(netCodeState22, (Function2) it$iv2, $composer2, 0);
                        $composer2.endReplaceGroup();
                        z2 = true;
                    } else {
                        onBackPressed = onBackPressed2;
                        onSendCodeClick = onSendCodeClick2;
                        onLoginAgreementChecked = onLoginAgreementChecked2;
                        onSmsCodeInput = onSmsCodeInput2;
                        onCountryCodeSwitchClick = onCountryCodeSwitchClick2;
                        onCountryCodeSelected3 = onCountryCodeSelected2;
                        onPhoneInput = onPhoneInput2;
                        onLoginClick = onLoginClick3;
                        z = false;
                        $composer2.startReplaceGroup(-116554482);
                        ComposerKt.sourceInformation($composer2, "227@9839L38");
                        z2 = true;
                        BoxKt.Box(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer2, 6);
                        $composer2.endReplaceGroup();
                    }
                    if (page instanceof SmsLoginSelectCountryCodeState) {
                        $dirty = $dirty2;
                        onCountryCodeCancel4 = onCountryCodeCancel3;
                        onCountryCodeSelected4 = onCountryCodeSelected3;
                        $composer2.startReplaceGroup(-126307516);
                    } else {
                        $composer2.startReplaceGroup(-116445796);
                        ComposerKt.sourceInformation($composer2, "234@10100L48,231@9943L216");
                        List<PhoneCountryCode> list = ((SmsLoginSelectCountryCodeState) page).getAllAvailableCountryCode().getList();
                        ComposerKt.sourceInformationMarkerStart($composer2, -2081961138, "CC(remember):SmsLoginPage.kt#9igjgp");
                        boolean z4 = ($dirty1 & BR.containerVisible) == 32 ? z2 : z;
                        if (($dirty2 & 14) != 4 && (($dirty2 & 8) == 0 || !$composer2.changedInstance(page))) {
                            z2 = z;
                        }
                        boolean invalid$iv7 = z2 | z4;
                        Object it$iv18 = $composer2.rememberedValue();
                        if (invalid$iv7 || it$iv18 == Composer.Companion.getEmpty()) {
                            $dirty = $dirty2;
                            onCountryCodeSelected4 = onCountryCodeSelected3;
                            Object value$iv19 = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda29
                                public final Object invoke(Object obj3) {
                                    Unit SmsLoginPage$lambda$14$0;
                                    SmsLoginPage$lambda$14$0 = SmsLoginPageKt.SmsLoginPage$lambda$14$0(onCountryCodeSelected4, page, (PhoneCountryCode) obj3);
                                    return SmsLoginPage$lambda$14$0;
                                }
                            };
                            $composer2.updateRememberedValue(value$iv19);
                            it$iv18 = value$iv19;
                        } else {
                            $dirty = $dirty2;
                            onCountryCodeSelected4 = onCountryCodeSelected3;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        onCountryCodeCancel4 = onCountryCodeCancel3;
                        SelectCountryCodePage(onCountryCodeCancel4, list, (Function1) it$iv18, $composer2, ($dirty1 >> 6) & 14);
                    }
                    $composer2.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    onCountryCodeSelected = onCountryCodeSelected4;
                    onCountryCodeCancel = onCountryCodeCancel4;
                    routeTo = routeTo2;
                }
            } else {
                onCountryCodeCancel3 = onCountryCodeCancel2;
            }
            isNetCodeBinding = false;
            if (pageState == null) {
            }
            if (page instanceof SmsLoginSelectCountryCodeState) {
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            onCountryCodeSelected = onCountryCodeSelected4;
            onCountryCodeCancel = onCountryCodeCancel4;
            routeTo = routeTo2;
        } else {
            $dirty = $dirty2;
            $composer2.skipToGroupEnd();
            onBackPressed = function0;
            onLoginClick = function12;
            onNetCodeClick = function02;
            onSwitchClick = function03;
            onPhoneInput = function13;
            onSmsCodeInput = function14;
            onSendCodeClick = function04;
            onLoginAgreementChecked = function15;
            onCountryCodeSwitchClick = function05;
            onCountryCodeSelected = function2;
            onCountryCodeCancel = function06;
            routeTo = function16;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Function0 function08 = onBackPressed;
            final Function1 function18 = onLoginClick;
            final Function0 function09 = onNetCodeClick;
            final Function0 function010 = onSwitchClick;
            final Function1 function19 = onPhoneInput;
            final Function1 function110 = onSmsCodeInput;
            final Function0 function011 = onSendCodeClick;
            final Function1 function111 = onLoginAgreementChecked;
            final Function0 function012 = onCountryCodeSwitchClick;
            final Function2 function22 = onCountryCodeSelected;
            final Function0 function013 = onCountryCodeCancel;
            final Function1 function112 = routeTo;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj3, Object obj4) {
                    Unit SmsLoginPage$lambda$15;
                    SmsLoginPage$lambda$15 = SmsLoginPageKt.SmsLoginPage$lambda$15(ISmsLoginPageState.this, function1, function08, function18, function09, function010, function19, function110, function011, function111, function012, function22, function013, function112, $changed, $changed1, i, (Composer) obj3, ((Integer) obj4).intValue());
                    return SmsLoginPage$lambda$15;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmsLoginPage$lambda$12$0$0$0(Function0 $onSendCodeClick) {
        $onSendCodeClick.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmsLoginPage$lambda$12$0$1$0(Function1 $onLoginClick, SmsLoginInput $pageState) {
        $onLoginClick.invoke(Boolean.valueOf($pageState.getAgreementChecked()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmsLoginPage$lambda$12$0$2$0(Function1 $onLoginClick, SmsLoginInput $pageState) {
        $onLoginClick.invoke(Boolean.valueOf($pageState.getAgreementChecked()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmsLoginPage$lambda$12$0$3$0(Function1 $onAction, EulaLinkType type, boolean inDialog, EulaTriggerType triggerType) {
        Intrinsics.checkNotNullParameter(type, "type");
        $onAction.invoke(new IFullscreenLoginReportAction.EulaLinkClicked(type, inDialog, triggerType));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmsLoginPage$lambda$12$0$4$0(Function1 $onAction) {
        $onAction.invoke(IFullscreenLoginReportAction.LoginHelpClick.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmsLoginPage$lambda$14$0(Function2 $onCountryCodeSelected, ISmsLoginPageState $page, PhoneCountryCode it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $onCountryCodeSelected.invoke(((SmsLoginSelectCountryCodeState) $page).getCurrentInput(), it);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x01fb, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SelectCountryCodePage(final Function0<Unit> function0, final List<PhoneCountryCode> list, final Function1<? super PhoneCountryCode, Unit> function1, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(function0, "onCountryCodeCancel");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(function1, "onSelected");
        Composer $composer2 = $composer.startRestartGroup(-905477259);
        ComposerKt.sourceInformation($composer2, "C(SelectCountryCodePage)N(onCountryCodeCancel,list,onSelected)245@10352L37,245@10340L49,248@10394L878:SmsLoginPage.kt#gqoihp");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 32 : 16;
        }
        if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? BR.hallEnterHotText : BR.cover;
        }
        if (!$composer2.shouldExecute(($dirty & BR.danmakuNumIcon) != 146, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-905477259, $dirty, -1, "tv.danmaku.bili.fullscreen.page.SelectCountryCodePage (SmsLoginPage.kt:244)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1714720410, "CC(remember):SmsLoginPage.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda15
                    public final Object invoke() {
                        Unit SelectCountryCodePage$lambda$0$0;
                        SelectCountryCodePage$lambda$0$0 = SmsLoginPageKt.SelectCountryCodePage$lambda$0$0(function0);
                        return SelectCountryCodePage$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            BackHandlerKt.BackHandler(false, (Function0) it$iv, $composer2, 0, 1);
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv$iv = Modifier.Companion;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & BR.containerVisible));
            int $changed$iv$iv = (0 << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
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
            int i2 = ((0 >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1985830061, "C250@10441L72,249@10411L160,253@10626L640,253@10580L686:SmsLoginPage.kt#gqoihp");
            String stringResource = StringResources_androidKt.stringResource(R.string.account_global_string_148, $composer2, 0);
            int compositeKeyHash$iv$iv2 = ($dirty << 3) & BR.containerVisible;
            CommonKt.PageHead(stringResource, function0, $composer2, compositeKeyHash$iv$iv2, 0);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -74481633, "CC(remember):SmsLoginPage.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(list) | (($dirty & 896) == 256);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj) {
                    Unit SelectCountryCodePage$lambda$1$0$0;
                    SelectCountryCodePage$lambda$1$0$0 = SmsLoginPageKt.SelectCountryCodePage$lambda$1$0$0(list, function1, (LazyListScope) obj);
                    return SelectCountryCodePage$lambda$1$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyDslKt.LazyColumn(fillMaxSize$default, (LazyListState) null, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv2, $composer2, 6, (int) BR.roleName);
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
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda17
                public final Object invoke(Object obj, Object obj2) {
                    Unit SelectCountryCodePage$lambda$2;
                    SelectCountryCodePage$lambda$2 = SmsLoginPageKt.SelectCountryCodePage$lambda$2(function0, list, function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return SelectCountryCodePage$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectCountryCodePage$lambda$0$0(Function0 $onCountryCodeCancel) {
        $onCountryCodeCancel.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectCountryCodePage$lambda$1$0$0(final List $list, final Function1 $onSelected, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        final Function1 key$iv = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda22
            public final Object invoke(Object obj) {
                Object SelectCountryCodePage$lambda$1$0$0$0;
                SelectCountryCodePage$lambda$1$0$0$0 = SmsLoginPageKt.SelectCountryCodePage$lambda$1$0$0$0((PhoneCountryCode) obj);
                return SelectCountryCodePage$lambda$1$0$0$0;
            }
        };
        final Function1 contentType$iv = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$SelectCountryCodePage$lambda$1$0$0$$inlined$items$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return m1089invoke((PhoneCountryCode) p1);
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final Void m1089invoke(PhoneCountryCode phoneCountryCode) {
                return null;
            }
        };
        $this$LazyColumn.items($list.size(), new Function1<Integer, Object>() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$SelectCountryCodePage$lambda$1$0$0$$inlined$items$default$2
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return key$iv.invoke($list.get(index));
            }
        }, new Function1<Integer, Object>() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$SelectCountryCodePage$lambda$1$0$0$$inlined$items$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return contentType$iv.invoke($list.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$SelectCountryCodePage$lambda$1$0$0$$inlined$items$default$4
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:36:0x018b, code lost:
                if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L33;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                Function0 factory$iv$iv$iv;
                ComposerKt.sourceInformation($composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if ($composer.shouldExecute(($dirty & BR.danmakuNumIcon) != 146, $dirty & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(802480018, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                    }
                    int $changed2 = $dirty & 14;
                    PhoneCountryCode code = (PhoneCountryCode) $list.get(it);
                    $composer.startReplaceGroup(790424413);
                    ComposerKt.sourceInformation($composer, "CN(code)*255@10695L547:SmsLoginPage.kt#gqoihp");
                    ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Modifier modifier$iv = Modifier.Companion;
                    Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv = (0 << 3) & BR.containerVisible;
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
                    int i2 = ((0 >> 6) & BR.containerVisible) | 6;
                    BoxScope $this$SelectCountryCodePage_u24lambda_u241_u240_u240_u241_u240 = boxScope;
                    ComposerKt.sourceInformationMarkerStart($composer, 1952170819, "C258@10813L18,256@10721L133,262@10927L6,261@10876L348:SmsLoginPage.kt#gqoihp");
                    ComposerKt.sourceInformationMarkerStart($composer, -75571621, "CC(remember):SmsLoginPage.kt#9igjgp");
                    boolean invalid$iv = $composer.changed($onSelected);
                    Object it$iv = $composer.rememberedValue();
                    if (invalid$iv) {
                    }
                    final Function1 function1 = $onSelected;
                    Object value$iv = (Function1) new Function1<PhoneCountryCode, Unit>() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$SelectCountryCodePage$2$1$1$2$1$1$1
                        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                            invoke((PhoneCountryCode) p1);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(PhoneCountryCode it2) {
                            Intrinsics.checkNotNullParameter(it2, "it");
                            function1.invoke(it2);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    SmsLoginPageKt.CountryCodeItem(code, (Function1) it$iv, $composer, ($changed2 >> 3) & 14);
                    DividerKt.Divider-oMI9zvI($this$SelectCountryCodePage_u24lambda_u241_u240_u240_u241_u240.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_regular-0d7_KjU(), Dp.constructor-impl((float) 0.5d), Dp.constructor-impl(12), $composer, 3456, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer.skipToGroupEnd();
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object SelectCountryCodePage$lambda$1$0$0$0(PhoneCountryCode it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Long.valueOf(it.getId());
    }

    public static final void SmsInputGroup(final String phone, final PhoneCountryCode countryCode, final String smsCode, final int counting, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function12, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        Intrinsics.checkNotNullParameter(smsCode, "smsCode");
        Intrinsics.checkNotNullParameter(function1, "onPhoneInput");
        Intrinsics.checkNotNullParameter(function12, "onSmsCodeInput");
        Intrinsics.checkNotNullParameter(function0, "onSendCodeClick");
        Intrinsics.checkNotNullParameter(function02, "onCountryCodeClick");
        Intrinsics.checkNotNullParameter(function03, "onLoginClick");
        Composer $composer3 = $composer.startRestartGroup(-430596084);
        ComposerKt.sourceInformation($composer3, "C(SmsInputGroup)N(phone,countryCode,smsCode,counting,onPhoneInput,onSmsCodeInput,onSendCodeClick,onCountryCodeClick,onLoginClick)288@11582L554:SmsLoginPage.kt#gqoihp");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(phone) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= ($changed & 64) == 0 ? $composer3.changed(countryCode) : $composer3.changedInstance(countryCode) ? 32 : 16;
        }
        if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty |= $composer3.changed(smsCode) ? BR.hallEnterHotText : BR.cover;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(counting) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? RingBuffer.CONSUME_SIZE : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function12) ? 131072 : AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function02) ? 8388608 : 4194304;
        }
        if ((100663296 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function03) ? 67108864 : 33554432;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute((38347923 & $dirty2) != 38347922, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-430596084, $dirty2, -1, "tv.danmaku.bili.fullscreen.page.SmsInputGroup (SmsLoginPage.kt:287)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & BR.containerVisible));
            int $changed$iv$iv = (0 << 3) & BR.containerVisible;
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
            int i2 = ((0 >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1335472518, "C289@11599L179,295@11813L6,295@11787L44,296@11840L237,304@12112L6,304@12086L44:SmsLoginPage.kt#gqoihp");
            PhoneRow(phone, countryCode, function1, function02, $composer3, ($dirty2 & 14) | ($dirty2 & BR.containerVisible) | (($dirty2 >> 6) & 896) | (($dirty2 >> 12) & 7168));
            DividerKt.Divider-oMI9zvI((Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getLine_light-0d7_KjU(), 0.0f, 0.0f, $composer3, 0, 13);
            $composer2 = $composer3;
            SmsRow(phone, smsCode, counting, function12, function0, function03, $composer3, ($dirty2 & 14) | (($dirty2 >> 3) & BR.containerVisible) | (($dirty2 >> 3) & 896) | (($dirty2 >> 6) & 7168) | (($dirty2 >> 6) & 57344) | (($dirty2 >> 9) & 458752));
            DividerKt.Divider-oMI9zvI((Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getLine_light-0d7_KjU(), 0.0f, 0.0f, $composer3, 0, 13);
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
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit SmsInputGroup$lambda$1;
                    SmsInputGroup$lambda$1 = SmsLoginPageKt.SmsInputGroup$lambda$1(phone, countryCode, smsCode, counting, function1, function12, function0, function02, function03, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return SmsInputGroup$lambda$1;
                }
            });
        }
    }

    private static final void PhoneRow(final String phone, final PhoneCountryCode countryCode, final Function1<? super String, Unit> function1, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer2 = $composer.startRestartGroup(269492561);
        ComposerKt.sourceInformation($composer2, "C(PhoneRow)N(phone,countryCode,onPhoneInput,onCountryCodeClick)315@12308L1763:SmsLoginPage.kt#gqoihp");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(phone) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= ($changed & 64) == 0 ? $composer2.changed(countryCode) : $composer2.changedInstance(countryCode) ? 32 : 16;
        }
        if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? BR.hallEnterHotText : BR.cover;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(269492561, $dirty2, -1, "tv.danmaku.bili.fullscreen.page.PhoneRow (SmsLoginPage.kt:314)");
            }
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(12), Dp.constructor-impl(16), Dp.constructor-impl(10), 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & BR.containerVisible));
            int $changed$iv$iv = (0 << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
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
            int i2 = ((0 >> 6) & BR.containerVisible) | 6;
            RowScope $this$PhoneRow_u24lambda_u240 = rowScope;
            ComposerKt.sourceInformationMarkerStart($composer2, -1030393478, "C321@12469L1009,355@13675L72,357@13825L9,349@13487L578:SmsLoginPage.kt#gqoihp");
            Modifier modifier$iv2 = ModifierUtilsKt.clickableNoInteraction$default(SizeKt.widthIn-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(65), 0.0f, 2, (Object) null), false, function0, 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer2, ((BR.negativeBtnVisible >> 3) & 14) | ((BR.negativeBtnVisible >> 3) & BR.containerVisible));
            int $changed$iv$iv2 = (BR.negativeBtnVisible << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            int i4 = ((BR.negativeBtnVisible >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1619426479, "C330@12817L6,331@12865L9,328@12723L170,337@13080L7,335@12958L274,333@12906L562:SmsLoginPage.kt#gqoihp");
            TextKt.Text--4IGK_g("+" + countryCode.getCountryCode(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT16(), $composer2, 0, 0, 65530);
            CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            IconKt.Icon-ww6aTOc(DrawablePainterKt.rememberDrawablePainter(AppCompatResources.getDrawable((Context) consume, com.bilibili.iconfont.R.drawable.ref_arrow_forward_right_line_500), $composer2, 0), (String) null, RotateKt.rotate(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(4), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl(16)), 90.0f), 0L, $composer2, Painter.$stable | BR.pendentVisible, 8);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SimpleTextFieldKt.SimpleTextField(phone, StringResources_androidKt.stringResource(R.string.account_global_string_134, $composer2, 0), function1, RowScope.-CC.weight$default($this$PhoneRow_u24lambda_u240, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 0.0f, 0.0f, 14, (Object) null), 1.0f, false, 2, (Object) null), BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT16(), (TextStyle) null, false, true, 0, new KeyboardOptions(0, (Boolean) null, KeyboardType.Companion.getPhone-PjHm6EE(), ImeAction.Companion.getNext-eUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, (int) BR.contentBackground, (DefaultConstructorMarker) null), (KeyboardActions) null, (VisualTransformation) null, (Function1) null, (TextFieldColors) null, $composer2, ($dirty2 & 14) | 817889280 | ($dirty2 & 896), 0, 15712);
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
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit PhoneRow$lambda$1;
                    PhoneRow$lambda$1 = SmsLoginPageKt.PhoneRow$lambda$1(phone, countryCode, function1, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return PhoneRow$lambda$1;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x02e4, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0552, code lost:
        if (r12 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L92;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void SmsRow(final String phone, final String smsCode, final int counting, final Function1<? super String, Unit> function1, final Function0<Unit> function0, final Function0<Unit> function02, Composer $composer, final int $changed) {
        int $dirty;
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Object it$iv;
        Function0 factory$iv$iv$iv2;
        long j;
        Composer $composer3 = $composer.startRestartGroup(-857664847);
        ComposerKt.sourceInformation($composer3, "C(SmsRow)N(phone,smsCode,counting,onSmsCodeInput,onSendClick,onLoginClick)377@14271L2718:SmsLoginPage.kt#gqoihp");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(phone) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(smsCode) ? 32 : 16;
        }
        if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty2 |= $composer3.changed(counting) ? BR.hallEnterHotText : BR.cover;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changedInstance(function1) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer3.changedInstance(function0) ? RingBuffer.CONSUME_SIZE : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= $composer3.changedInstance(function02) ? 131072 : AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR;
        }
        int $dirty3 = $dirty2;
        if ($composer3.shouldExecute((74899 & $dirty3) != 74898, $dirty3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-857664847, $dirty3, -1, "tv.danmaku.bili.fullscreen.page.SmsRow (SmsLoginPage.kt:376)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(10), 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((BR.nickTextColor >> 3) & 14) | ((BR.nickTextColor >> 3) & BR.containerVisible));
            int $changed$iv$iv = (BR.nickTextColor << 3) & BR.containerVisible;
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
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i2 = ((BR.nickTextColor >> 6) & BR.containerVisible) | 6;
            RowScope $this$SmsRow_u24lambda_u240 = rowScope;
            ComposerKt.sourceInformationMarkerStart($composer3, 528640735, "C384@14485L29,387@14549L72,389@14720L6,390@14764L9,386@14524L264,400@15040L71,403@15222L9,409@15478L18,393@14798L710,411@15517L50,413@15577L1406:SmsLoginPage.kt#gqoihp");
            ComposerKt.sourceInformationMarkerStart($composer3, 1263977098, "CC(remember):SmsLoginPage.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object focusRequester = new FocusRequester();
                $composer3.updateRememberedValue(focusRequester);
                it$iv = focusRequester;
            } else {
                it$iv = it$iv2;
            }
            final FocusRequester focusRequester2 = (FocusRequester) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            TextKt.Text--4IGK_g(StringResources_androidKt.stringResource(R.string.account_global_string_101, $composer3, 0), SizeKt.widthIn-VpY3zN4(Modifier.Companion, Dp.constructor-impl(65), Dp.constructor-impl(90)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16(), $composer3, 48, 0, 65528);
            Modifier weight$default = RowScope.-CC.weight$default($this$SmsRow_u24lambda_u240, PaddingKt.padding-qDBjuR0$default(FocusRequesterModifierKt.focusRequester(Modifier.Companion, focusRequester2), Dp.constructor-impl(12), 0.0f, 0.0f, 0.0f, 14, (Object) null), 1.0f, false, 2, (Object) null);
            String stringResource = StringResources_androidKt.stringResource(R.string.account_global_string_86, $composer3, 0);
            TextStyle t16 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16();
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, KeyboardType.Companion.getNumber-PjHm6EE(), ImeAction.Companion.getDone-eUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, (int) BR.contentBackground, (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1264008863, "CC(remember):SmsLoginPage.kt#9igjgp");
            boolean invalid$iv = (458752 & $dirty3) == 131072;
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda18
                public final Object invoke(Object obj) {
                    Unit SmsRow$lambda$0$1$0;
                    SmsRow$lambda$0$1$0 = SmsLoginPageKt.SmsRow$lambda$0$1$0(function02, (KeyboardActionScope) obj);
                    return SmsRow$lambda$0$1$0;
                }
            };
            $composer3.updateRememberedValue(value$iv);
            it$iv3 = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SimpleTextFieldKt.SimpleTextField(smsCode, stringResource, function1, weight$default, t16, (TextStyle) null, false, true, 0, keyboardOptions, new KeyboardActions((Function1) it$iv3, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, 62, (DefaultConstructorMarker) null), (VisualTransformation) null, (Function1) null, (TextFieldColors) null, $composer3, (($dirty3 >> 3) & 14) | 817889280 | (($dirty3 >> 3) & 896), 0, 14688);
            SpacerKt.Spacer(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(16), 0.0f, 0.0f, 0.0f, 14, (Object) null), $composer3, 6);
            Modifier modifier$iv2 = SizeKt.sizeIn-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(80), 0.0f, Dp.constructor-impl((float) BR.currentEpisodeListIsReversed), 0.0f, 10, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (0 << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
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
            int i4 = ((0 >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 129395035, "C:SmsLoginPage.kt#gqoihp");
            if (counting > 0) {
                $composer3.startReplaceGroup(129404892);
                ComposerKt.sourceInformation($composer3, "417@15753L210,424@16091L6,425@16143L9,415@15696L479");
                TextKt.Text--4IGK_g(StringResources_androidKt.pluralStringResource(R.plurals.account_global_string_418, counting, new Object[]{Integer.valueOf(counting)}, $composer3, ($dirty3 >> 3) & BR.containerVisible), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText4-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 3, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16(), $composer3, 0, 3120, 55290);
                $composer3.endReplaceGroup();
                $dirty = $dirty3;
            } else {
                $composer3.startReplaceGroup(129909169);
                ComposerKt.sourceInformation($composer3, "430@16294L71,434@16562L139,441@16927L9,429@16261L698");
                boolean enable = !StringsKt.isBlank(phone);
                String stringResource2 = StringResources_androidKt.stringResource(R.string.account_global_string_21, $composer3, 0);
                Modifier modifier = SizeKt.widthIn-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(100), 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, -1381271598, "CC(remember):SmsLoginPage.kt#9igjgp");
                boolean invalid$iv2 = (57344 & $dirty3) == 16384;
                Object it$iv4 = $composer3.rememberedValue();
                if (invalid$iv2) {
                    $dirty = $dirty3;
                } else {
                    $dirty = $dirty3;
                }
                Object value$iv2 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda19
                    public final Object invoke() {
                        Unit SmsRow$lambda$0$2$0$0;
                        SmsRow$lambda$0$2$0$0 = SmsLoginPageKt.SmsRow$lambda$0$2$0$0(focusRequester2, function0);
                        return SmsRow$lambda$0$2$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv4 = value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier clickableNoInteraction = ModifierUtilsKt.clickableNoInteraction(modifier, enable, (Function0) it$iv4);
                int i5 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
                if (enable) {
                    $composer3.startReplaceGroup(-1381262543);
                    ComposerKt.sourceInformation($composer3, "440@16842L6");
                    j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                } else {
                    $composer3.startReplaceGroup(-1381261492);
                    ComposerKt.sourceInformation($composer3, "440@16875L6");
                    j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText4-0d7_KjU();
                }
                $composer3.endReplaceGroup();
                TextKt.Text--4IGK_g(stringResource2, clickableNoInteraction, j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, i5, false, 3, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16(), $composer3, 0, 3120, 55288);
                $composer3.endReplaceGroup();
            }
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
        } else {
            $dirty = $dirty3;
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda20
                public final Object invoke(Object obj, Object obj2) {
                    Unit SmsRow$lambda$1;
                    SmsRow$lambda$1 = SmsLoginPageKt.SmsRow$lambda$1(phone, smsCode, counting, function1, function0, function02, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return SmsRow$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmsRow$lambda$0$1$0(Function0 $onLoginClick, KeyboardActionScope $this$KeyboardActions) {
        Intrinsics.checkNotNullParameter($this$KeyboardActions, "$this$KeyboardActions");
        $onLoginClick.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmsRow$lambda$0$2$0$0(FocusRequester $focusRequester, Function0 $onSendClick) {
        FocusRequester.requestFocus-3ESFkO8$default($focusRequester, 0, 1, (Object) null);
        $onSendClick.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CountryCodeItem(final PhoneCountryCode code, final Function1<? super PhoneCountryCode, Unit> function1, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(1447404440);
        ComposerKt.sourceInformation($composer2, "C(CountryCodeItem)N(code,onItemClick)458@17263L21,453@17115L777:SmsLoginPage.kt#gqoihp");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(code) : $composer2.changedInstance(code) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1447404440, $dirty, -1, "tv.danmaku.bili.fullscreen.page.CountryCodeItem (SmsLoginPage.kt:452)");
            }
            Modifier modifier = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(44));
            ComposerKt.sourceInformationMarkerStart($composer2, -613729043, "CC(remember):SmsLoginPage.kt#9igjgp");
            boolean invalid$iv = (($dirty & BR.containerVisible) == 32) | (($dirty & 14) == 4 || (($dirty & 8) != 0 && $composer2.changedInstance(code)));
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda13
                    public final Object invoke() {
                        Unit CountryCodeItem$lambda$0$0;
                        CountryCodeItem$lambda$0$0 = SmsLoginPageKt.CountryCodeItem$lambda$0$0(function1, code);
                        return CountryCodeItem$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = PaddingKt.padding-3ABfNKs(ModifierUtilsKt.clickableNoInteraction$default(modifier, false, (Function0) it$iv, 1, (Object) null), Dp.constructor-impl(12));
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
            int i2 = ((BR.negativeBtnVisible >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 972872933, "C464@17462L6,465@17506L9,462@17396L206,473@17746L6,474@17790L9,470@17612L274:SmsLoginPage.kt#gqoihp");
            TextKt.Text--4IGK_g(code.getName(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), $composer2, 0, 3120, 55290);
            TextKt.Text--4IGK_g("+" + code.getCountryCode(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(6), 0.0f, 0.0f, 0.0f, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), $composer2, 48, 3120, 55288);
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
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj, Object obj2) {
                    Unit CountryCodeItem$lambda$2;
                    CountryCodeItem$lambda$2 = SmsLoginPageKt.CountryCodeItem$lambda$2(PhoneCountryCode.this, function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return CountryCodeItem$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CountryCodeItem$lambda$0$0(Function1 $onItemClick, PhoneCountryCode $code) {
        $onItemClick.invoke($code);
        return Unit.INSTANCE;
    }
}