package tv.danmaku.bili.stepbystep.sms;

import BottomSheetItemData$;
import androidx.compose.ui.focus.FocusState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.data.PhoneCountryCode;
import tv.danmaku.bili.fullscreen.service.EulaDisplayInfo;
import tv.danmaku.bili.fullscreen.service.LoginCaptchaInfo;
import tv.danmaku.bili.fullscreen.service.SmsCaptchaStatus;
import tv.danmaku.bili.fullscreen.service.ToastInfo;
import tv.danmaku.bili.fullscreen.stat.LoginWay;
import tv.danmaku.bili.fullscreen.stat.Sms;
import tv.danmaku.bili.normal.ui.EulaTriggerType;

/* compiled from: StepByStepSmsLoginPageState.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\b\u00105\u001a\u00020\u0001H\u0016J\u0017\u00106\u001a\u00020\u00012\u0006\u00107\u001a\u00020\u000fH\u0016¢\u0006\u0004\b8\u00109J\u0012\u0010:\u001a\u00020\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0007HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010?\u001a\u00020\u000bHÆ\u0003J\t\u0010@\u001a\u00020\rHÆ\u0003J\u0010\u0010A\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\bB\u0010#J\u000b\u0010C\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0013HÆ\u0003Jp\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0004\bF\u0010GJ\u0013\u0010H\u001a\u00020\u00072\b\u0010I\u001a\u0004\u0018\u00010JHÖ\u0003J\t\u0010K\u001a\u000200HÖ\u0001J\t\u0010L\u001a\u00020MHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010-\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b.\u0010\u001bR\u0011\u0010/\u001a\u0002008F¢\u0006\u0006\u001a\u0004\b1\u00102R\u0011\u00103\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b4\u0010\u001b¨\u0006N"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginPhonePage;", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "phoneInputState", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginPhoneInputState;", "eulaDisplay", "Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "loggedIn", "", "captchaDisplay", "Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "toastInfo", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "pageOffsetTarget", "", "counting", "Lkotlin/time/Duration;", "captchaStatus", "Ltv/danmaku/bili/fullscreen/service/SmsCaptchaStatus;", "focusState", "Landroidx/compose/ui/focus/FocusState;", "<init>", "(Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginPhoneInputState;Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;ZLtv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;Ltv/danmaku/bili/fullscreen/service/ToastInfo;FJLtv/danmaku/bili/fullscreen/service/SmsCaptchaStatus;Landroidx/compose/ui/focus/FocusState;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPhoneInputState", "()Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginPhoneInputState;", "getEulaDisplay", "()Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "getLoggedIn", "()Z", "getCaptchaDisplay", "()Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "getToastInfo", "()Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "getPageOffsetTarget", "()F", "getCounting-UwyO8pc", "()J", "J", "getCaptchaStatus", "()Ltv/danmaku/bili/fullscreen/service/SmsCaptchaStatus;", "getFocusState", "()Landroidx/compose/ui/focus/FocusState;", "loginWay", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "getLoginWay", "()Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "confirmButtonEnable", "getConfirmButtonEnable", "phoneLimitLength", "", "getPhoneLimitLength", "()I", "agreementChecked", "getAgreementChecked", "next", "countDown", "diff", "countDown-LRDsOJo", "(J)Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "onFocusChanged", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component7-UwyO8pc", "component8", "component9", "copy", "copy-zIkEtRU", "(Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginPhoneInputState;Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;ZLtv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;Ltv/danmaku/bili/fullscreen/service/ToastInfo;FJLtv/danmaku/bili/fullscreen/service/SmsCaptchaStatus;Landroidx/compose/ui/focus/FocusState;)Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginPhonePage;", "equals", "other", "", "hashCode", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class StepByStepSmsLoginPhonePage implements IStepByStepSmsLoginPageState {
    public static final int $stable = 8;
    private final LoginCaptchaInfo captchaDisplay;
    private final SmsCaptchaStatus captchaStatus;
    private final long counting;
    private final EulaDisplayInfo eulaDisplay;
    private final FocusState focusState;
    private final boolean loggedIn;
    private final LoginWay loginWay;
    private final float pageOffsetTarget;
    private final StepByStepSmsLoginPhoneInputState phoneInputState;
    private final ToastInfo toastInfo;

    public /* synthetic */ StepByStepSmsLoginPhonePage(StepByStepSmsLoginPhoneInputState stepByStepSmsLoginPhoneInputState, EulaDisplayInfo eulaDisplayInfo, boolean z, LoginCaptchaInfo loginCaptchaInfo, ToastInfo toastInfo, float f, long j, SmsCaptchaStatus smsCaptchaStatus, FocusState focusState, DefaultConstructorMarker defaultConstructorMarker) {
        this(stepByStepSmsLoginPhoneInputState, eulaDisplayInfo, z, loginCaptchaInfo, toastInfo, f, j, smsCaptchaStatus, focusState);
    }

    /* renamed from: copy-zIkEtRU$default  reason: not valid java name */
    public static /* synthetic */ StepByStepSmsLoginPhonePage m1519copyzIkEtRU$default(StepByStepSmsLoginPhonePage stepByStepSmsLoginPhonePage, StepByStepSmsLoginPhoneInputState stepByStepSmsLoginPhoneInputState, EulaDisplayInfo eulaDisplayInfo, boolean z, LoginCaptchaInfo loginCaptchaInfo, ToastInfo toastInfo, float f, long j, SmsCaptchaStatus smsCaptchaStatus, FocusState focusState, int i, Object obj) {
        return stepByStepSmsLoginPhonePage.m1521copyzIkEtRU((i & 1) != 0 ? stepByStepSmsLoginPhonePage.phoneInputState : stepByStepSmsLoginPhoneInputState, (i & 2) != 0 ? stepByStepSmsLoginPhonePage.eulaDisplay : eulaDisplayInfo, (i & 4) != 0 ? stepByStepSmsLoginPhonePage.loggedIn : z, (i & 8) != 0 ? stepByStepSmsLoginPhonePage.captchaDisplay : loginCaptchaInfo, (i & 16) != 0 ? stepByStepSmsLoginPhonePage.toastInfo : toastInfo, (i & 32) != 0 ? stepByStepSmsLoginPhonePage.pageOffsetTarget : f, (i & 64) != 0 ? stepByStepSmsLoginPhonePage.counting : j, (i & BR.cover) != 0 ? stepByStepSmsLoginPhonePage.captchaStatus : smsCaptchaStatus, (i & BR.hallEnterHotText) != 0 ? stepByStepSmsLoginPhonePage.focusState : focusState);
    }

    public final StepByStepSmsLoginPhoneInputState component1() {
        return this.phoneInputState;
    }

    public final EulaDisplayInfo component2() {
        return this.eulaDisplay;
    }

    public final boolean component3() {
        return this.loggedIn;
    }

    public final LoginCaptchaInfo component4() {
        return this.captchaDisplay;
    }

    public final ToastInfo component5() {
        return this.toastInfo;
    }

    public final float component6() {
        return this.pageOffsetTarget;
    }

    /* renamed from: component7-UwyO8pc  reason: not valid java name */
    public final long m1520component7UwyO8pc() {
        return this.counting;
    }

    public final SmsCaptchaStatus component8() {
        return this.captchaStatus;
    }

    public final FocusState component9() {
        return this.focusState;
    }

    /* renamed from: copy-zIkEtRU  reason: not valid java name */
    public final StepByStepSmsLoginPhonePage m1521copyzIkEtRU(StepByStepSmsLoginPhoneInputState stepByStepSmsLoginPhoneInputState, EulaDisplayInfo eulaDisplayInfo, boolean z, LoginCaptchaInfo loginCaptchaInfo, ToastInfo toastInfo, float f, long j, SmsCaptchaStatus smsCaptchaStatus, FocusState focusState) {
        Intrinsics.checkNotNullParameter(stepByStepSmsLoginPhoneInputState, "phoneInputState");
        Intrinsics.checkNotNullParameter(eulaDisplayInfo, "eulaDisplay");
        Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
        return new StepByStepSmsLoginPhonePage(stepByStepSmsLoginPhoneInputState, eulaDisplayInfo, z, loginCaptchaInfo, toastInfo, f, j, smsCaptchaStatus, focusState, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StepByStepSmsLoginPhonePage) {
            StepByStepSmsLoginPhonePage stepByStepSmsLoginPhonePage = (StepByStepSmsLoginPhonePage) obj;
            return Intrinsics.areEqual(this.phoneInputState, stepByStepSmsLoginPhonePage.phoneInputState) && Intrinsics.areEqual(this.eulaDisplay, stepByStepSmsLoginPhonePage.eulaDisplay) && this.loggedIn == stepByStepSmsLoginPhonePage.loggedIn && Intrinsics.areEqual(this.captchaDisplay, stepByStepSmsLoginPhonePage.captchaDisplay) && Intrinsics.areEqual(this.toastInfo, stepByStepSmsLoginPhonePage.toastInfo) && Float.compare(this.pageOffsetTarget, stepByStepSmsLoginPhonePage.pageOffsetTarget) == 0 && Duration.equals-impl0(this.counting, stepByStepSmsLoginPhonePage.counting) && Intrinsics.areEqual(this.captchaStatus, stepByStepSmsLoginPhonePage.captchaStatus) && Intrinsics.areEqual(this.focusState, stepByStepSmsLoginPhonePage.focusState);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((this.phoneInputState.hashCode() * 31) + this.eulaDisplay.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.loggedIn)) * 31) + (this.captchaDisplay == null ? 0 : this.captchaDisplay.hashCode())) * 31) + this.toastInfo.hashCode()) * 31) + Float.floatToIntBits(this.pageOffsetTarget)) * 31) + Duration.hashCode-impl(this.counting)) * 31) + (this.captchaStatus == null ? 0 : this.captchaStatus.hashCode())) * 31) + (this.focusState != null ? this.focusState.hashCode() : 0);
    }

    public String toString() {
        StepByStepSmsLoginPhoneInputState stepByStepSmsLoginPhoneInputState = this.phoneInputState;
        EulaDisplayInfo eulaDisplayInfo = this.eulaDisplay;
        boolean z = this.loggedIn;
        LoginCaptchaInfo loginCaptchaInfo = this.captchaDisplay;
        ToastInfo toastInfo = this.toastInfo;
        float f = this.pageOffsetTarget;
        String str = Duration.toString-impl(this.counting);
        SmsCaptchaStatus smsCaptchaStatus = this.captchaStatus;
        return "StepByStepSmsLoginPhonePage(phoneInputState=" + stepByStepSmsLoginPhoneInputState + ", eulaDisplay=" + eulaDisplayInfo + ", loggedIn=" + z + ", captchaDisplay=" + loginCaptchaInfo + ", toastInfo=" + toastInfo + ", pageOffsetTarget=" + f + ", counting=" + str + ", captchaStatus=" + smsCaptchaStatus + ", focusState=" + this.focusState + ")";
    }

    private StepByStepSmsLoginPhonePage(StepByStepSmsLoginPhoneInputState phoneInputState, EulaDisplayInfo eulaDisplay, boolean loggedIn, LoginCaptchaInfo captchaDisplay, ToastInfo toastInfo, float pageOffsetTarget, long counting, SmsCaptchaStatus captchaStatus, FocusState focusState) {
        Intrinsics.checkNotNullParameter(phoneInputState, "phoneInputState");
        Intrinsics.checkNotNullParameter(eulaDisplay, "eulaDisplay");
        Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
        this.phoneInputState = phoneInputState;
        this.eulaDisplay = eulaDisplay;
        this.loggedIn = loggedIn;
        this.captchaDisplay = captchaDisplay;
        this.toastInfo = toastInfo;
        this.pageOffsetTarget = pageOffsetTarget;
        this.counting = counting;
        this.captchaStatus = captchaStatus;
        this.focusState = focusState;
        this.loginWay = Sms.SmsLogin.INSTANCE;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ StepByStepSmsLoginPhonePage(StepByStepSmsLoginPhoneInputState stepByStepSmsLoginPhoneInputState, EulaDisplayInfo eulaDisplayInfo, boolean z, LoginCaptchaInfo loginCaptchaInfo, ToastInfo toastInfo, float f, long j, SmsCaptchaStatus smsCaptchaStatus, FocusState focusState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(stepByStepSmsLoginPhoneInputState, r12, r13, r14, r15, r16, r17, (i & BR.cover) != 0 ? null : smsCaptchaStatus, focusState, null);
        long j2;
        EulaDisplayInfo eulaDisplayInfo2 = (i & 2) != 0 ? new EulaDisplayInfo(StepByStepSmsLoginPageStateKt.SmsLoginType, false, false, null, EulaTriggerType.GetSms, 12, null) : eulaDisplayInfo;
        boolean z2 = (i & 4) != 0 ? false : z;
        LoginCaptchaInfo loginCaptchaInfo2 = (i & 8) != 0 ? null : loginCaptchaInfo;
        ToastInfo toastInfo2 = (i & 16) != 0 ? new ToastInfo(null, 0L, 3, null) : toastInfo;
        float f2 = (i & 32) != 0 ? 0.0f : f;
        if ((i & 64) != 0) {
            Duration.Companion companion = Duration.Companion;
            j2 = DurationKt.toDuration(0, DurationUnit.SECONDS);
        } else {
            j2 = j;
        }
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public StepByStepSmsLoginPhoneInputState getPhoneInputState() {
        return this.phoneInputState;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public EulaDisplayInfo getEulaDisplay() {
        return this.eulaDisplay;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public boolean getLoggedIn() {
        return this.loggedIn;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public LoginCaptchaInfo getCaptchaDisplay() {
        return this.captchaDisplay;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public ToastInfo getToastInfo() {
        return this.toastInfo;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public float getPageOffsetTarget() {
        return this.pageOffsetTarget;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    /* renamed from: getCounting-UwyO8pc */
    public long mo1508getCountingUwyO8pc() {
        return this.counting;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public SmsCaptchaStatus getCaptchaStatus() {
        return this.captchaStatus;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public FocusState getFocusState() {
        return this.focusState;
    }

    public final LoginWay getLoginWay() {
        return this.loginWay;
    }

    public final boolean getConfirmButtonEnable() {
        StepByStepSmsLoginPhoneInputState $this$_get_confirmButtonEnable__u24lambda_u240 = getPhoneInputState();
        boolean is86Code = Intrinsics.areEqual($this$_get_confirmButtonEnable__u24lambda_u240.getSelectedCountry().getCountryCode(), PhoneCountryCode.Companion.getDefaultCountryCode().getCountryCode());
        return is86Code ? $this$_get_confirmButtonEnable__u24lambda_u240.getPhone().length() == getPhoneLimitLength() : $this$_get_confirmButtonEnable__u24lambda_u240.getPhone().length() > 0;
    }

    public final int getPhoneLimitLength() {
        return Intrinsics.areEqual(getPhoneInputState().getSelectedCountry().getCountryCode(), PhoneCountryCode.Companion.getDefaultCountryCode().getCountryCode()) ? 11 : 16;
    }

    public final boolean getAgreementChecked() {
        return getPhoneInputState().getAgreementChecked();
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public IStepByStepSmsLoginPageState next() {
        return new StepByStepSmsLoginVerifyPage(null, null, 0, getPhoneInputState(), false, null, null, 0.0f, false, null, mo1508getCountingUwyO8pc(), getCaptchaStatus(), null, 1015, null);
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    /* renamed from: countDown-LRDsOJo */
    public IStepByStepSmsLoginPageState mo1507countDownLRDsOJo(long j) {
        return m1519copyzIkEtRU$default(this, null, null, false, null, null, 0.0f, RangesKt.coerceAtLeast(Duration.box-impl(Duration.minus-LRDsOJo(mo1508getCountingUwyO8pc(), j)), Duration.box-impl(Duration.Companion.getZERO-UwyO8pc())).unbox-impl(), null, null, BR.playingLottieVisible, null);
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public IStepByStepSmsLoginPageState onFocusChanged(FocusState focusState) {
        return m1519copyzIkEtRU$default(this, null, null, false, null, null, 0.0f, 0L, null, focusState, BR.hallCover, null);
    }
}