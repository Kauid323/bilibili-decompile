package tv.danmaku.bili.fullscreen.state;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.EulaDisplayInfo;
import tv.danmaku.bili.fullscreen.service.IAccountRedirect;
import tv.danmaku.bili.fullscreen.service.LoginCaptchaInfo;
import tv.danmaku.bili.fullscreen.service.ToastInfo;
import tv.danmaku.bili.fullscreen.state.ISmsLoginPageState;
import tv.danmaku.bili.report.misaka.MisakaHelper;

/* compiled from: SmsLoginPageState.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J!\u0010&\u001a\u00020'2\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040)¢\u0006\u0002\b*H\u0016J\u0010\u0010+\u001a\u00020'2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\t\u0010,\u001a\u00020\u0004HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\u001d\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010/\u001a\u00020\u00062\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u000205HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\f¨\u00066"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/SmsLoginPageInputIdleState;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginValidState;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginIdleState;", "input", "Ltv/danmaku/bili/fullscreen/state/SmsLoginInput;", "loggedIn", "", "<init>", "(Ltv/danmaku/bili/fullscreen/state/SmsLoginInput;Z)V", "getInput", "()Ltv/danmaku/bili/fullscreen/state/SmsLoginInput;", "getLoggedIn", "()Z", "copyState", "showLoading", "getShowLoading", "redirect", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "getRedirect", "()Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "captchaDisplay", "Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "getCaptchaDisplay", "()Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "toastInfo", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "getToastInfo", "()Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "eulaDisplay", "Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "getEulaDisplay", "()Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "netCodeState", "Ltv/danmaku/bili/fullscreen/state/NetCodeState;", "getNetCodeState", "()Ltv/danmaku/bili/fullscreen/state/NetCodeState;", "agreementChecked", "getAgreementChecked", "mutateInput", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginPageState;", "mutate", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "toast", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SmsLoginPageInputIdleState implements ISmsLoginValidState, ISmsLoginIdleState {
    public static final int $stable = 8;
    private final SmsLoginInput input;
    private final boolean loggedIn;

    public static /* synthetic */ SmsLoginPageInputIdleState copy$default(SmsLoginPageInputIdleState smsLoginPageInputIdleState, SmsLoginInput smsLoginInput, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            smsLoginInput = smsLoginPageInputIdleState.input;
        }
        if ((i & 2) != 0) {
            z = smsLoginPageInputIdleState.loggedIn;
        }
        return smsLoginPageInputIdleState.copy(smsLoginInput, z);
    }

    public final SmsLoginInput component1() {
        return this.input;
    }

    public final boolean component2() {
        return this.loggedIn;
    }

    public final SmsLoginPageInputIdleState copy(SmsLoginInput smsLoginInput, boolean z) {
        Intrinsics.checkNotNullParameter(smsLoginInput, "input");
        return new SmsLoginPageInputIdleState(smsLoginInput, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SmsLoginPageInputIdleState) {
            SmsLoginPageInputIdleState smsLoginPageInputIdleState = (SmsLoginPageInputIdleState) obj;
            return Intrinsics.areEqual(this.input, smsLoginPageInputIdleState.input) && this.loggedIn == smsLoginPageInputIdleState.loggedIn;
        }
        return false;
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginPageState, tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public /* synthetic */ String getLoginType() {
        return ISmsLoginPageState.CC.$default$getLoginType(this);
    }

    public int hashCode() {
        return (this.input.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.loggedIn);
    }

    public String toString() {
        SmsLoginInput smsLoginInput = this.input;
        return "SmsLoginPageInputIdleState(input=" + smsLoginInput + ", loggedIn=" + this.loggedIn + ")";
    }

    public SmsLoginPageInputIdleState(SmsLoginInput input, boolean loggedIn) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.input = input;
        this.loggedIn = loggedIn;
    }

    public /* synthetic */ SmsLoginPageInputIdleState(SmsLoginInput smsLoginInput, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(smsLoginInput, (i & 2) != 0 ? false : z);
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginValidState, tv.danmaku.bili.fullscreen.state.ISmsLoginCountingState, tv.danmaku.bili.fullscreen.state.ISmsLoginLoadingState
    public SmsLoginInput getInput() {
        return this.input;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public boolean getLoggedIn() {
        return this.loggedIn;
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginValidState
    public SmsLoginPageInputIdleState copyState(SmsLoginInput input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return copy$default(this, input, false, 2, null);
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public boolean getShowLoading() {
        return getInput().getShowLoading();
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public IAccountRedirect getRedirect() {
        return getInput().getRedirected();
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public LoginCaptchaInfo getCaptchaDisplay() {
        return getInput().getCaptchaDisplay();
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public ToastInfo getToastInfo() {
        return getInput().getToastInfo();
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public EulaDisplayInfo getEulaDisplay() {
        return getInput().getEulaDisplayInfo();
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginPageState
    public NetCodeState getNetCodeState() {
        return getInput().getNetCodeState();
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginPageState
    public boolean getAgreementChecked() {
        return getInput().getAgreementChecked();
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginPageState
    public ISmsLoginPageState mutateInput(Function1<? super SmsLoginInput, SmsLoginInput> function1) {
        Intrinsics.checkNotNullParameter(function1, "mutate");
        return copy$default(this, (SmsLoginInput) function1.invoke(getInput()), false, 2, null);
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginPageState
    public ISmsLoginPageState toast(ToastInfo toastInfo) {
        SmsLoginInput copy;
        Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
        copy = r1.copy((r26 & 1) != 0 ? r1.phone : null, (r26 & 2) != 0 ? r1.smsCode : null, (r26 & 4) != 0 ? r1.agreementChecked : false, (r26 & 8) != 0 ? r1.availableCountryCode : null, (r26 & 16) != 0 ? r1.selectedCountry : null, (r26 & 32) != 0 ? r1.showCountryCodeSelect : false, (r26 & 64) != 0 ? r1.captchaStatus : null, (r26 & BR.cover) != 0 ? r1.redirected : null, (r26 & BR.hallEnterHotText) != 0 ? r1.toastInfo : toastInfo, (r26 & BR.roleType) != 0 ? r1.eulaDisplayInfo : null, (r26 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? r1.loginWay : null, (r26 & 2048) != 0 ? getInput().netCodeState : null);
        return copy$default(this, copy, false, 2, null);
    }
}