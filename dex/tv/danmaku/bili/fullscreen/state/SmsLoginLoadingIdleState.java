package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.EulaDisplayInfo;
import tv.danmaku.bili.fullscreen.service.IAccountRedirect;
import tv.danmaku.bili.fullscreen.service.LoginCaptchaInfo;
import tv.danmaku.bili.fullscreen.service.ToastInfo;

/* compiled from: SmsLoginPageState.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u0015\u001a\u00020\u00012\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0017¢\u0006\u0002\b\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J\u0011\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$H\u0096\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0012\u0010%\u001a\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b&\u0010\u0010R\u0014\u0010'\u001a\u0004\u0018\u00010(X\u0096\u0005¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0012\u0010+\u001a\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b,\u0010\u0010R\u0014\u0010-\u001a\u00020!8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0012\u00100\u001a\u000201X\u0096\u0005¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u0004\u0018\u000105X\u0096\u0005¢\u0006\u0006\u001a\u0004\b6\u00107R\u0012\u0010#\u001a\u00020$X\u0096\u0005¢\u0006\u0006\u001a\u0004\b8\u00109¨\u0006:"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/SmsLoginLoadingIdleState;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginPageState;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginLoadingState;", "original", "Ltv/danmaku/bili/fullscreen/state/SmsLoginPageInputIdleState;", "<init>", "(Ltv/danmaku/bili/fullscreen/state/SmsLoginPageInputIdleState;)V", "getOriginal", "()Ltv/danmaku/bili/fullscreen/state/SmsLoginPageInputIdleState;", "input", "Ltv/danmaku/bili/fullscreen/state/SmsLoginInput;", "getInput", "()Ltv/danmaku/bili/fullscreen/state/SmsLoginInput;", "showLoading", "", "getShowLoading", "()Z", "eulaDisplay", "Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "getEulaDisplay", "()Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "mutateInput", "mutate", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "toast", "toastInfo", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "agreementChecked", "getAgreementChecked", "captchaDisplay", "Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "getCaptchaDisplay", "()Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "loggedIn", "getLoggedIn", "loginType", "getLoginType", "()Ljava/lang/String;", "netCodeState", "Ltv/danmaku/bili/fullscreen/state/NetCodeState;", "getNetCodeState", "()Ltv/danmaku/bili/fullscreen/state/NetCodeState;", "redirect", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "getRedirect", "()Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "getToastInfo", "()Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SmsLoginLoadingIdleState implements ISmsLoginPageState, ISmsLoginLoadingState {
    public static final int $stable = 8;
    private final SmsLoginPageInputIdleState original;

    public static /* synthetic */ SmsLoginLoadingIdleState copy$default(SmsLoginLoadingIdleState smsLoginLoadingIdleState, SmsLoginPageInputIdleState smsLoginPageInputIdleState, int i, Object obj) {
        if ((i & 1) != 0) {
            smsLoginPageInputIdleState = smsLoginLoadingIdleState.original;
        }
        return smsLoginLoadingIdleState.copy(smsLoginPageInputIdleState);
    }

    public final SmsLoginPageInputIdleState component1() {
        return this.original;
    }

    public final SmsLoginLoadingIdleState copy(SmsLoginPageInputIdleState smsLoginPageInputIdleState) {
        Intrinsics.checkNotNullParameter(smsLoginPageInputIdleState, "original");
        return new SmsLoginLoadingIdleState(smsLoginPageInputIdleState);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SmsLoginLoadingIdleState) && Intrinsics.areEqual(this.original, ((SmsLoginLoadingIdleState) obj).original);
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginPageState
    public boolean getAgreementChecked() {
        return this.original.getAgreementChecked();
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public LoginCaptchaInfo getCaptchaDisplay() {
        return this.original.getCaptchaDisplay();
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public boolean getLoggedIn() {
        return this.original.getLoggedIn();
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginPageState, tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public String getLoginType() {
        return this.original.getLoginType();
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginPageState
    public NetCodeState getNetCodeState() {
        return this.original.getNetCodeState();
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public IAccountRedirect getRedirect() {
        return this.original.getRedirect();
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public ToastInfo getToastInfo() {
        return this.original.getToastInfo();
    }

    public int hashCode() {
        return this.original.hashCode();
    }

    public String toString() {
        return "SmsLoginLoadingIdleState(original=" + this.original + ")";
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginPageState
    public ISmsLoginPageState toast(ToastInfo toastInfo) {
        Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
        return this.original.toast(toastInfo);
    }

    public SmsLoginLoadingIdleState(SmsLoginPageInputIdleState original) {
        Intrinsics.checkNotNullParameter(original, "original");
        this.original = original;
    }

    public final SmsLoginPageInputIdleState getOriginal() {
        return this.original;
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginLoadingState
    public SmsLoginInput getInput() {
        return this.original.getInput();
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public boolean getShowLoading() {
        return true;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public EulaDisplayInfo getEulaDisplay() {
        return getInput().getEulaDisplayInfo();
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginPageState
    public ISmsLoginPageState mutateInput(Function1<? super SmsLoginInput, SmsLoginInput> function1) {
        Intrinsics.checkNotNullParameter(function1, "mutate");
        return copy(SmsLoginPageInputIdleState.copy$default(this.original, (SmsLoginInput) function1.invoke(this.original.getInput()), false, 2, null));
    }
}