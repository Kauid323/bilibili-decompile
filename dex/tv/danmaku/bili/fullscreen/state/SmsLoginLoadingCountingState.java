package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.EulaDisplayInfo;
import tv.danmaku.bili.fullscreen.service.IAccountRedirect;
import tv.danmaku.bili.fullscreen.service.LoginCaptchaInfo;
import tv.danmaku.bili.fullscreen.service.ToastInfo;
import tv.danmaku.bili.fullscreen.state.ISmsLoginPageState;
import tv.danmaku.bili.report.misaka.MisakaHelper;

/* compiled from: SmsLoginPageState.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J!\u00100\u001a\u00020\u00012\u0017\u00101\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b02¢\u0006\u0002\b3H\u0016J\u0010\u00104\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#H\u0016J\t\u00105\u001a\u00020\u0005HÆ\u0003J\u0013\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u00107\u001a\u00020\u00152\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\u000fHÖ\u0001J\t\u0010;\u001a\u00020<HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010&\u001a\u0004\u0018\u00010'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u0017¨\u0006="}, d2 = {"Ltv/danmaku/bili/fullscreen/state/SmsLoginLoadingCountingState;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginPageState;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginCountingState;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginLoadingState;", "original", "Ltv/danmaku/bili/fullscreen/state/SmsLoginPageInputCountingState;", "<init>", "(Ltv/danmaku/bili/fullscreen/state/SmsLoginPageInputCountingState;)V", "getOriginal", "()Ltv/danmaku/bili/fullscreen/state/SmsLoginPageInputCountingState;", "input", "Ltv/danmaku/bili/fullscreen/state/SmsLoginInput;", "getInput", "()Ltv/danmaku/bili/fullscreen/state/SmsLoginInput;", "countDown", "", "getCountDown", "()I", "countDownTo", "count", "loggedIn", "", "getLoggedIn", "()Z", "showLoading", "getShowLoading", "redirect", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "getRedirect", "()Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "captchaDisplay", "Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "getCaptchaDisplay", "()Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "toastInfo", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "getToastInfo", "()Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "eulaDisplay", "Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "getEulaDisplay", "()Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "netCodeState", "Ltv/danmaku/bili/fullscreen/state/NetCodeState;", "getNetCodeState", "()Ltv/danmaku/bili/fullscreen/state/NetCodeState;", "agreementChecked", "getAgreementChecked", "mutateInput", "mutate", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "toast", "component1", "copy", "equals", "other", "", "hashCode", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SmsLoginLoadingCountingState implements ISmsLoginPageState, ISmsLoginCountingState, ISmsLoginLoadingState {
    public static final int $stable = 8;
    private final SmsLoginPageInputCountingState original;

    public static /* synthetic */ SmsLoginLoadingCountingState copy$default(SmsLoginLoadingCountingState smsLoginLoadingCountingState, SmsLoginPageInputCountingState smsLoginPageInputCountingState, int i, Object obj) {
        if ((i & 1) != 0) {
            smsLoginPageInputCountingState = smsLoginLoadingCountingState.original;
        }
        return smsLoginLoadingCountingState.copy(smsLoginPageInputCountingState);
    }

    public final SmsLoginPageInputCountingState component1() {
        return this.original;
    }

    public final SmsLoginLoadingCountingState copy(SmsLoginPageInputCountingState smsLoginPageInputCountingState) {
        Intrinsics.checkNotNullParameter(smsLoginPageInputCountingState, "original");
        return new SmsLoginLoadingCountingState(smsLoginPageInputCountingState);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SmsLoginLoadingCountingState) && Intrinsics.areEqual(this.original, ((SmsLoginLoadingCountingState) obj).original);
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginPageState, tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public /* synthetic */ String getLoginType() {
        return ISmsLoginPageState.CC.$default$getLoginType(this);
    }

    public int hashCode() {
        return this.original.hashCode();
    }

    public String toString() {
        return "SmsLoginLoadingCountingState(original=" + this.original + ")";
    }

    public SmsLoginLoadingCountingState(SmsLoginPageInputCountingState original) {
        Intrinsics.checkNotNullParameter(original, "original");
        this.original = original;
    }

    public final SmsLoginPageInputCountingState getOriginal() {
        return this.original;
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginCountingState, tv.danmaku.bili.fullscreen.state.ISmsLoginLoadingState
    public SmsLoginInput getInput() {
        return this.original.getInput();
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginCountingState
    public int getCountDown() {
        return this.original.getCountDown();
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginCountingState
    public ISmsLoginCountingState countDownTo(int count) {
        return copy(this.original.countDownTo(getCountDown()));
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public boolean getLoggedIn() {
        return false;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public boolean getShowLoading() {
        return true;
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
        return this.original.getToastInfo();
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
        return copy(SmsLoginPageInputCountingState.copy$default(this.original, (SmsLoginInput) function1.invoke(this.original.getInput()), 0, false, 6, null));
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginPageState
    public ISmsLoginPageState toast(ToastInfo toastInfo) {
        SmsLoginInput copy;
        Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
        SmsLoginPageInputCountingState smsLoginPageInputCountingState = this.original;
        copy = r2.copy((r26 & 1) != 0 ? r2.phone : null, (r26 & 2) != 0 ? r2.smsCode : null, (r26 & 4) != 0 ? r2.agreementChecked : false, (r26 & 8) != 0 ? r2.availableCountryCode : null, (r26 & 16) != 0 ? r2.selectedCountry : null, (r26 & 32) != 0 ? r2.showCountryCodeSelect : false, (r26 & 64) != 0 ? r2.captchaStatus : null, (r26 & BR.cover) != 0 ? r2.redirected : null, (r26 & BR.hallEnterHotText) != 0 ? r2.toastInfo : toastInfo, (r26 & BR.roleType) != 0 ? r2.eulaDisplayInfo : null, (r26 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? r2.loginWay : null, (r26 & 2048) != 0 ? this.original.getInput().netCodeState : null);
        return copy(SmsLoginPageInputCountingState.copy$default(smsLoginPageInputCountingState, copy, 0, false, 6, null));
    }
}