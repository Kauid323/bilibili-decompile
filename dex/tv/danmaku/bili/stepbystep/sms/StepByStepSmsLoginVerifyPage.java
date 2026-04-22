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
import tv.danmaku.bili.fullscreen.service.EulaDisplayInfo;
import tv.danmaku.bili.fullscreen.service.IAccountRedirect;
import tv.danmaku.bili.fullscreen.service.LoginCaptchaInfo;
import tv.danmaku.bili.fullscreen.service.SmsCaptchaStatus;
import tv.danmaku.bili.fullscreen.service.ToastInfo;
import tv.danmaku.bili.fullscreen.stat.Sms;
import tv.danmaku.bili.report.misaka.MisakaHelper;

/* compiled from: StepByStepSmsLoginPageState.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010;\u001a\u00020\u0001H\u0016J\u0017\u0010<\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\u0015H\u0016¢\u0006\u0004\b>\u0010?J\u0012\u0010@\u001a\u00020\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0006HÆ\u0003J\t\u0010D\u001a\u00020\bHÆ\u0003J\t\u0010E\u001a\u00020\nHÆ\u0003J\t\u0010F\u001a\u00020\fHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010H\u001a\u00020\u0010HÆ\u0003J\t\u0010I\u001a\u00020\nHÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0010\u0010K\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\bL\u0010/J\u000b\u0010M\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u009a\u0001\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÆ\u0001¢\u0006\u0004\bP\u0010QJ\u0013\u0010R\u001a\u00020\n2\b\u0010S\u001a\u0004\u0018\u00010THÖ\u0003J\t\u0010U\u001a\u00020\u0006HÖ\u0001J\t\u0010V\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0011\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b+\u0010$R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0016\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0014\u00105\u001a\u0002068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0011\u00109\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b:\u0010$¨\u0006W"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginVerifyPage;", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "smsCode", "", "exceptionMessage", "exceptionMessageResourceId", "", "phoneInputState", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginPhoneInputState;", "loggedIn", "", "toastInfo", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "eulaDisplay", "Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "pageOffsetTarget", "", "verifying", "redirect", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "counting", "Lkotlin/time/Duration;", "captchaStatus", "Ltv/danmaku/bili/fullscreen/service/SmsCaptchaStatus;", "focusState", "Landroidx/compose/ui/focus/FocusState;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILtv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginPhoneInputState;ZLtv/danmaku/bili/fullscreen/service/ToastInfo;Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;FZLtv/danmaku/bili/fullscreen/service/IAccountRedirect;JLtv/danmaku/bili/fullscreen/service/SmsCaptchaStatus;Landroidx/compose/ui/focus/FocusState;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSmsCode", "()Ljava/lang/String;", "getExceptionMessage", "getExceptionMessageResourceId", "()I", "getPhoneInputState", "()Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginPhoneInputState;", "getLoggedIn", "()Z", "getToastInfo", "()Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "getEulaDisplay", "()Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "getPageOffsetTarget", "()F", "getVerifying", "getRedirect", "()Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "getCounting-UwyO8pc", "()J", "J", "getCaptchaStatus", "()Ltv/danmaku/bili/fullscreen/service/SmsCaptchaStatus;", "getFocusState", "()Landroidx/compose/ui/focus/FocusState;", "captchaDisplay", "Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "getCaptchaDisplay", "()Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "confirmButtonEnable", "getConfirmButtonEnable", "next", "countDown", "diff", "countDown-LRDsOJo", "(J)Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "onFocusChanged", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component11-UwyO8pc", "component12", "component13", "copy", "copy-vXyW-Bk", "(Ljava/lang/String;Ljava/lang/String;ILtv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginPhoneInputState;ZLtv/danmaku/bili/fullscreen/service/ToastInfo;Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;FZLtv/danmaku/bili/fullscreen/service/IAccountRedirect;JLtv/danmaku/bili/fullscreen/service/SmsCaptchaStatus;Landroidx/compose/ui/focus/FocusState;)Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginVerifyPage;", "equals", "other", "", "hashCode", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class StepByStepSmsLoginVerifyPage implements IStepByStepSmsLoginPageState {
    public static final int $stable = 8;
    private final SmsCaptchaStatus captchaStatus;
    private final long counting;
    private final EulaDisplayInfo eulaDisplay;
    private final String exceptionMessage;
    private final int exceptionMessageResourceId;
    private final FocusState focusState;
    private final boolean loggedIn;
    private final float pageOffsetTarget;
    private final StepByStepSmsLoginPhoneInputState phoneInputState;
    private final IAccountRedirect redirect;
    private final String smsCode;
    private final ToastInfo toastInfo;
    private final boolean verifying;

    public /* synthetic */ StepByStepSmsLoginVerifyPage(String str, String str2, int i, StepByStepSmsLoginPhoneInputState stepByStepSmsLoginPhoneInputState, boolean z, ToastInfo toastInfo, EulaDisplayInfo eulaDisplayInfo, float f, boolean z2, IAccountRedirect iAccountRedirect, long j, SmsCaptchaStatus smsCaptchaStatus, FocusState focusState, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, stepByStepSmsLoginPhoneInputState, z, toastInfo, eulaDisplayInfo, f, z2, iAccountRedirect, j, smsCaptchaStatus, focusState);
    }

    /* renamed from: copy-vXyW-Bk$default */
    public static /* synthetic */ StepByStepSmsLoginVerifyPage m1531copyvXyWBk$default(StepByStepSmsLoginVerifyPage stepByStepSmsLoginVerifyPage, String str, String str2, int i, StepByStepSmsLoginPhoneInputState stepByStepSmsLoginPhoneInputState, boolean z, ToastInfo toastInfo, EulaDisplayInfo eulaDisplayInfo, float f, boolean z2, IAccountRedirect iAccountRedirect, long j, SmsCaptchaStatus smsCaptchaStatus, FocusState focusState, int i2, Object obj) {
        return stepByStepSmsLoginVerifyPage.m1533copyvXyWBk((i2 & 1) != 0 ? stepByStepSmsLoginVerifyPage.smsCode : str, (i2 & 2) != 0 ? stepByStepSmsLoginVerifyPage.exceptionMessage : str2, (i2 & 4) != 0 ? stepByStepSmsLoginVerifyPage.exceptionMessageResourceId : i, (i2 & 8) != 0 ? stepByStepSmsLoginVerifyPage.phoneInputState : stepByStepSmsLoginPhoneInputState, (i2 & 16) != 0 ? stepByStepSmsLoginVerifyPage.loggedIn : z, (i2 & 32) != 0 ? stepByStepSmsLoginVerifyPage.toastInfo : toastInfo, (i2 & 64) != 0 ? stepByStepSmsLoginVerifyPage.eulaDisplay : eulaDisplayInfo, (i2 & BR.cover) != 0 ? stepByStepSmsLoginVerifyPage.pageOffsetTarget : f, (i2 & BR.hallEnterHotText) != 0 ? stepByStepSmsLoginVerifyPage.verifying : z2, (i2 & BR.roleType) != 0 ? stepByStepSmsLoginVerifyPage.redirect : iAccountRedirect, (i2 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? stepByStepSmsLoginVerifyPage.counting : j, (i2 & 2048) != 0 ? stepByStepSmsLoginVerifyPage.captchaStatus : smsCaptchaStatus, (i2 & 4096) != 0 ? stepByStepSmsLoginVerifyPage.focusState : focusState);
    }

    public final String component1() {
        return this.smsCode;
    }

    public final IAccountRedirect component10() {
        return this.redirect;
    }

    /* renamed from: component11-UwyO8pc */
    public final long m1532component11UwyO8pc() {
        return this.counting;
    }

    public final SmsCaptchaStatus component12() {
        return this.captchaStatus;
    }

    public final FocusState component13() {
        return this.focusState;
    }

    public final String component2() {
        return this.exceptionMessage;
    }

    public final int component3() {
        return this.exceptionMessageResourceId;
    }

    public final StepByStepSmsLoginPhoneInputState component4() {
        return this.phoneInputState;
    }

    public final boolean component5() {
        return this.loggedIn;
    }

    public final ToastInfo component6() {
        return this.toastInfo;
    }

    public final EulaDisplayInfo component7() {
        return this.eulaDisplay;
    }

    public final float component8() {
        return this.pageOffsetTarget;
    }

    public final boolean component9() {
        return this.verifying;
    }

    /* renamed from: copy-vXyW-Bk */
    public final StepByStepSmsLoginVerifyPage m1533copyvXyWBk(String str, String str2, int i, StepByStepSmsLoginPhoneInputState stepByStepSmsLoginPhoneInputState, boolean z, ToastInfo toastInfo, EulaDisplayInfo eulaDisplayInfo, float f, boolean z2, IAccountRedirect iAccountRedirect, long j, SmsCaptchaStatus smsCaptchaStatus, FocusState focusState) {
        Intrinsics.checkNotNullParameter(str, "smsCode");
        Intrinsics.checkNotNullParameter(str2, "exceptionMessage");
        Intrinsics.checkNotNullParameter(stepByStepSmsLoginPhoneInputState, "phoneInputState");
        Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
        return new StepByStepSmsLoginVerifyPage(str, str2, i, stepByStepSmsLoginPhoneInputState, z, toastInfo, eulaDisplayInfo, f, z2, iAccountRedirect, j, smsCaptchaStatus, focusState, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StepByStepSmsLoginVerifyPage) {
            StepByStepSmsLoginVerifyPage stepByStepSmsLoginVerifyPage = (StepByStepSmsLoginVerifyPage) obj;
            return Intrinsics.areEqual(this.smsCode, stepByStepSmsLoginVerifyPage.smsCode) && Intrinsics.areEqual(this.exceptionMessage, stepByStepSmsLoginVerifyPage.exceptionMessage) && this.exceptionMessageResourceId == stepByStepSmsLoginVerifyPage.exceptionMessageResourceId && Intrinsics.areEqual(this.phoneInputState, stepByStepSmsLoginVerifyPage.phoneInputState) && this.loggedIn == stepByStepSmsLoginVerifyPage.loggedIn && Intrinsics.areEqual(this.toastInfo, stepByStepSmsLoginVerifyPage.toastInfo) && Intrinsics.areEqual(this.eulaDisplay, stepByStepSmsLoginVerifyPage.eulaDisplay) && Float.compare(this.pageOffsetTarget, stepByStepSmsLoginVerifyPage.pageOffsetTarget) == 0 && this.verifying == stepByStepSmsLoginVerifyPage.verifying && Intrinsics.areEqual(this.redirect, stepByStepSmsLoginVerifyPage.redirect) && Duration.equals-impl0(this.counting, stepByStepSmsLoginVerifyPage.counting) && Intrinsics.areEqual(this.captchaStatus, stepByStepSmsLoginVerifyPage.captchaStatus) && Intrinsics.areEqual(this.focusState, stepByStepSmsLoginVerifyPage.focusState);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.smsCode.hashCode() * 31) + this.exceptionMessage.hashCode()) * 31) + this.exceptionMessageResourceId) * 31) + this.phoneInputState.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.loggedIn)) * 31) + this.toastInfo.hashCode()) * 31) + (this.eulaDisplay == null ? 0 : this.eulaDisplay.hashCode())) * 31) + Float.floatToIntBits(this.pageOffsetTarget)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.verifying)) * 31) + (this.redirect == null ? 0 : this.redirect.hashCode())) * 31) + Duration.hashCode-impl(this.counting)) * 31) + (this.captchaStatus == null ? 0 : this.captchaStatus.hashCode())) * 31) + (this.focusState != null ? this.focusState.hashCode() : 0);
    }

    public String toString() {
        String str = this.smsCode;
        String str2 = this.exceptionMessage;
        int i = this.exceptionMessageResourceId;
        StepByStepSmsLoginPhoneInputState stepByStepSmsLoginPhoneInputState = this.phoneInputState;
        boolean z = this.loggedIn;
        ToastInfo toastInfo = this.toastInfo;
        EulaDisplayInfo eulaDisplayInfo = this.eulaDisplay;
        float f = this.pageOffsetTarget;
        boolean z2 = this.verifying;
        IAccountRedirect iAccountRedirect = this.redirect;
        String str3 = Duration.toString-impl(this.counting);
        SmsCaptchaStatus smsCaptchaStatus = this.captchaStatus;
        return "StepByStepSmsLoginVerifyPage(smsCode=" + str + ", exceptionMessage=" + str2 + ", exceptionMessageResourceId=" + i + ", phoneInputState=" + stepByStepSmsLoginPhoneInputState + ", loggedIn=" + z + ", toastInfo=" + toastInfo + ", eulaDisplay=" + eulaDisplayInfo + ", pageOffsetTarget=" + f + ", verifying=" + z2 + ", redirect=" + iAccountRedirect + ", counting=" + str3 + ", captchaStatus=" + smsCaptchaStatus + ", focusState=" + this.focusState + ")";
    }

    private StepByStepSmsLoginVerifyPage(String smsCode, String exceptionMessage, int exceptionMessageResourceId, StepByStepSmsLoginPhoneInputState phoneInputState, boolean loggedIn, ToastInfo toastInfo, EulaDisplayInfo eulaDisplay, float pageOffsetTarget, boolean verifying, IAccountRedirect redirect, long counting, SmsCaptchaStatus captchaStatus, FocusState focusState) {
        Intrinsics.checkNotNullParameter(smsCode, "smsCode");
        Intrinsics.checkNotNullParameter(exceptionMessage, "exceptionMessage");
        Intrinsics.checkNotNullParameter(phoneInputState, "phoneInputState");
        Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
        this.smsCode = smsCode;
        this.exceptionMessage = exceptionMessage;
        this.exceptionMessageResourceId = exceptionMessageResourceId;
        this.phoneInputState = phoneInputState;
        this.loggedIn = loggedIn;
        this.toastInfo = toastInfo;
        this.eulaDisplay = eulaDisplay;
        this.pageOffsetTarget = pageOffsetTarget;
        this.verifying = verifying;
        this.redirect = redirect;
        this.counting = counting;
        this.captchaStatus = captchaStatus;
        this.focusState = focusState;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ StepByStepSmsLoginVerifyPage(String str, String str2, int i, StepByStepSmsLoginPhoneInputState stepByStepSmsLoginPhoneInputState, boolean z, ToastInfo toastInfo, EulaDisplayInfo eulaDisplayInfo, float f, boolean z2, IAccountRedirect iAccountRedirect, long j, SmsCaptchaStatus smsCaptchaStatus, FocusState focusState, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(r4, r5, r6, stepByStepSmsLoginPhoneInputState, r8, r9, r10, r11, r12, r13, r14, (i2 & 2048) != 0 ? null : smsCaptchaStatus, focusState, null);
        long j2;
        String str3 = (i2 & 1) != 0 ? "" : str;
        String str4 = (i2 & 2) != 0 ? "" : str2;
        int i3 = (i2 & 4) != 0 ? 0 : i;
        boolean z3 = (i2 & 16) != 0 ? false : z;
        ToastInfo toastInfo2 = (i2 & 32) != 0 ? new ToastInfo(null, 0L, 3, null) : toastInfo;
        EulaDisplayInfo eulaDisplayInfo2 = (i2 & 64) != 0 ? null : eulaDisplayInfo;
        float f2 = (i2 & BR.cover) != 0 ? 0.0f : f;
        boolean z4 = (i2 & BR.hallEnterHotText) != 0 ? false : z2;
        IAccountRedirect iAccountRedirect2 = (i2 & BR.roleType) != 0 ? null : iAccountRedirect;
        if ((i2 & MisakaHelper.MAX_REPORT_SIZE) != 0) {
            Duration.Companion companion = Duration.Companion;
            j2 = DurationKt.toDuration(0, DurationUnit.SECONDS);
        } else {
            j2 = j;
        }
    }

    public final String getSmsCode() {
        return this.smsCode;
    }

    public final String getExceptionMessage() {
        return this.exceptionMessage;
    }

    public final int getExceptionMessageResourceId() {
        return this.exceptionMessageResourceId;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public StepByStepSmsLoginPhoneInputState getPhoneInputState() {
        return this.phoneInputState;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public boolean getLoggedIn() {
        return this.loggedIn;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public ToastInfo getToastInfo() {
        return this.toastInfo;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public EulaDisplayInfo getEulaDisplay() {
        return this.eulaDisplay;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public float getPageOffsetTarget() {
        return this.pageOffsetTarget;
    }

    public final boolean getVerifying() {
        return this.verifying;
    }

    public final IAccountRedirect getRedirect() {
        return this.redirect;
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

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public LoginCaptchaInfo getCaptchaDisplay() {
        Sms.SmsLogin smsLogin = Sms.SmsLogin.INSTANCE;
        SmsCaptchaStatus captchaStatus = getCaptchaStatus();
        String captchaUrl = captchaStatus != null ? captchaStatus.getCaptchaUrl() : null;
        if (captchaUrl == null) {
            captchaUrl = "";
        }
        return new LoginCaptchaInfo(smsLogin, captchaUrl, null, 4, null);
    }

    public final boolean getConfirmButtonEnable() {
        return this.smsCode.length() == 6;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public IStepByStepSmsLoginPageState next() {
        return new StepByStepSmsLoginPhonePage(getPhoneInputState(), null, false, null, null, 0.0f, mo1508getCountingUwyO8pc(), getCaptchaStatus(), null, 62, null);
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    /* renamed from: countDown-LRDsOJo */
    public IStepByStepSmsLoginPageState mo1507countDownLRDsOJo(long j) {
        return m1531copyvXyWBk$default(this, null, null, 0, null, false, null, null, 0.0f, false, null, RangesKt.coerceAtLeast(Duration.box-impl(Duration.minus-LRDsOJo(mo1508getCountingUwyO8pc(), j)), Duration.box-impl(Duration.Companion.getZERO-UwyO8pc())).unbox-impl(), null, null, 7167, null);
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public IStepByStepSmsLoginPageState onFocusChanged(FocusState focusState) {
        return m1531copyvXyWBk$default(this, null, null, 0, null, false, null, null, 0.0f, false, null, 0L, null, focusState, 4095, null);
    }
}