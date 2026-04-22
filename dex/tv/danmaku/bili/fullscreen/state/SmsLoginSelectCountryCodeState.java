package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.data.AvailableCountryCode;
import tv.danmaku.bili.fullscreen.service.EulaDisplayInfo;
import tv.danmaku.bili.fullscreen.service.IAccountRedirect;
import tv.danmaku.bili.fullscreen.service.LoginCaptchaInfo;
import tv.danmaku.bili.fullscreen.service.ToastInfo;
import tv.danmaku.bili.fullscreen.state.ISmsLoginPageState;
import tv.danmaku.bili.report.misaka.MisakaHelper;

/* compiled from: SmsLoginPageState.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010(\u001a\u00020\u00012\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030*¢\u0006\u0002\b+H\u0016J\u0010\u0010,\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\u001d\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u00100\u001a\u00020\r2\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u000206HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u000f¨\u00067"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/SmsLoginSelectCountryCodeState;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginPageState;", "currentInput", "Ltv/danmaku/bili/fullscreen/state/SmsLoginInput;", "allAvailableCountryCode", "Ltv/danmaku/bili/fullscreen/data/AvailableCountryCode;", "<init>", "(Ltv/danmaku/bili/fullscreen/state/SmsLoginInput;Ltv/danmaku/bili/fullscreen/data/AvailableCountryCode;)V", "getCurrentInput", "()Ltv/danmaku/bili/fullscreen/state/SmsLoginInput;", "getAllAvailableCountryCode", "()Ltv/danmaku/bili/fullscreen/data/AvailableCountryCode;", "loggedIn", "", "getLoggedIn", "()Z", "showLoading", "getShowLoading", "redirect", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "getRedirect", "()Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "captchaDisplay", "Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "getCaptchaDisplay", "()Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "toastInfo", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "getToastInfo", "()Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "eulaDisplay", "Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "getEulaDisplay", "()Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "netCodeState", "Ltv/danmaku/bili/fullscreen/state/NetCodeState;", "getNetCodeState", "()Ltv/danmaku/bili/fullscreen/state/NetCodeState;", "agreementChecked", "getAgreementChecked", "mutateInput", "mutate", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "toast", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SmsLoginSelectCountryCodeState implements ISmsLoginPageState {
    public static final int $stable = 8;
    private final AvailableCountryCode allAvailableCountryCode;
    private final SmsLoginInput currentInput;

    public static /* synthetic */ SmsLoginSelectCountryCodeState copy$default(SmsLoginSelectCountryCodeState smsLoginSelectCountryCodeState, SmsLoginInput smsLoginInput, AvailableCountryCode availableCountryCode, int i, Object obj) {
        if ((i & 1) != 0) {
            smsLoginInput = smsLoginSelectCountryCodeState.currentInput;
        }
        if ((i & 2) != 0) {
            availableCountryCode = smsLoginSelectCountryCodeState.allAvailableCountryCode;
        }
        return smsLoginSelectCountryCodeState.copy(smsLoginInput, availableCountryCode);
    }

    public final SmsLoginInput component1() {
        return this.currentInput;
    }

    public final AvailableCountryCode component2() {
        return this.allAvailableCountryCode;
    }

    public final SmsLoginSelectCountryCodeState copy(SmsLoginInput smsLoginInput, AvailableCountryCode availableCountryCode) {
        Intrinsics.checkNotNullParameter(smsLoginInput, "currentInput");
        Intrinsics.checkNotNullParameter(availableCountryCode, "allAvailableCountryCode");
        return new SmsLoginSelectCountryCodeState(smsLoginInput, availableCountryCode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SmsLoginSelectCountryCodeState) {
            SmsLoginSelectCountryCodeState smsLoginSelectCountryCodeState = (SmsLoginSelectCountryCodeState) obj;
            return Intrinsics.areEqual(this.currentInput, smsLoginSelectCountryCodeState.currentInput) && Intrinsics.areEqual(this.allAvailableCountryCode, smsLoginSelectCountryCodeState.allAvailableCountryCode);
        }
        return false;
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginPageState, tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public /* synthetic */ String getLoginType() {
        return ISmsLoginPageState.CC.$default$getLoginType(this);
    }

    public int hashCode() {
        return (this.currentInput.hashCode() * 31) + this.allAvailableCountryCode.hashCode();
    }

    public String toString() {
        SmsLoginInput smsLoginInput = this.currentInput;
        return "SmsLoginSelectCountryCodeState(currentInput=" + smsLoginInput + ", allAvailableCountryCode=" + this.allAvailableCountryCode + ")";
    }

    public SmsLoginSelectCountryCodeState(SmsLoginInput currentInput, AvailableCountryCode allAvailableCountryCode) {
        Intrinsics.checkNotNullParameter(currentInput, "currentInput");
        Intrinsics.checkNotNullParameter(allAvailableCountryCode, "allAvailableCountryCode");
        this.currentInput = currentInput;
        this.allAvailableCountryCode = allAvailableCountryCode;
    }

    public final SmsLoginInput getCurrentInput() {
        return this.currentInput;
    }

    public final AvailableCountryCode getAllAvailableCountryCode() {
        return this.allAvailableCountryCode;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public boolean getLoggedIn() {
        return false;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public boolean getShowLoading() {
        return this.currentInput.getShowLoading();
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public IAccountRedirect getRedirect() {
        return this.currentInput.getRedirected();
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public LoginCaptchaInfo getCaptchaDisplay() {
        return this.currentInput.getCaptchaDisplay();
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public ToastInfo getToastInfo() {
        return this.currentInput.getToastInfo();
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public EulaDisplayInfo getEulaDisplay() {
        return this.currentInput.getEulaDisplayInfo();
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginPageState
    public NetCodeState getNetCodeState() {
        return this.currentInput.getNetCodeState();
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginPageState
    public boolean getAgreementChecked() {
        return this.currentInput.getAgreementChecked();
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginPageState
    public ISmsLoginPageState mutateInput(Function1<? super SmsLoginInput, SmsLoginInput> function1) {
        Intrinsics.checkNotNullParameter(function1, "mutate");
        return copy$default(this, (SmsLoginInput) function1.invoke(this.currentInput), null, 2, null);
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginPageState
    public ISmsLoginPageState toast(ToastInfo toastInfo) {
        SmsLoginInput copy;
        Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
        copy = r2.copy((r26 & 1) != 0 ? r2.phone : null, (r26 & 2) != 0 ? r2.smsCode : null, (r26 & 4) != 0 ? r2.agreementChecked : false, (r26 & 8) != 0 ? r2.availableCountryCode : null, (r26 & 16) != 0 ? r2.selectedCountry : null, (r26 & 32) != 0 ? r2.showCountryCodeSelect : false, (r26 & 64) != 0 ? r2.captchaStatus : null, (r26 & BR.cover) != 0 ? r2.redirected : null, (r26 & BR.hallEnterHotText) != 0 ? r2.toastInfo : toastInfo, (r26 & BR.roleType) != 0 ? r2.eulaDisplayInfo : null, (r26 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? r2.loginWay : null, (r26 & 2048) != 0 ? this.currentInput.netCodeState : null);
        return copy$default(this, copy, null, 2, null);
    }
}