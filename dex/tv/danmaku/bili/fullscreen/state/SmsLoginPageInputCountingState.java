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
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J!\u0010,\u001a\u00020-2\u0017\u0010.\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040/¢\u0006\u0002\b0H\u0016J\u0010\u00101\u001a\u00020-2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\t\u00102\u001a\u00020\u0004HÆ\u0003J\t\u00103\u001a\u00020\u0006HÆ\u0003J\t\u00104\u001a\u00020\bHÆ\u0003J'\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u00106\u001a\u00020\b2\b\u00107\u001a\u0004\u0018\u000108HÖ\u0003J\t\u00109\u001a\u00020\u0006HÖ\u0001J\t\u0010:\u001a\u00020;HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0016\u0010\"\u001a\u0004\u0018\u00010#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0010¨\u0006<"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/SmsLoginPageInputCountingState;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginValidState;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginCountingState;", "input", "Ltv/danmaku/bili/fullscreen/state/SmsLoginInput;", "countDown", "", "loggedIn", "", "<init>", "(Ltv/danmaku/bili/fullscreen/state/SmsLoginInput;IZ)V", "getInput", "()Ltv/danmaku/bili/fullscreen/state/SmsLoginInput;", "getCountDown", "()I", "getLoggedIn", "()Z", "copyState", "countDownTo", "count", "showLoading", "getShowLoading", "redirect", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "getRedirect", "()Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "captchaDisplay", "Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "getCaptchaDisplay", "()Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "toastInfo", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "getToastInfo", "()Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "eulaDisplay", "Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "getEulaDisplay", "()Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "netCodeState", "Ltv/danmaku/bili/fullscreen/state/NetCodeState;", "getNetCodeState", "()Ltv/danmaku/bili/fullscreen/state/NetCodeState;", "agreementChecked", "getAgreementChecked", "mutateInput", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginPageState;", "mutate", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "toast", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SmsLoginPageInputCountingState implements ISmsLoginValidState, ISmsLoginCountingState {
    public static final int $stable = 8;
    private final int countDown;
    private final SmsLoginInput input;
    private final boolean loggedIn;

    public static /* synthetic */ SmsLoginPageInputCountingState copy$default(SmsLoginPageInputCountingState smsLoginPageInputCountingState, SmsLoginInput smsLoginInput, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            smsLoginInput = smsLoginPageInputCountingState.input;
        }
        if ((i2 & 2) != 0) {
            i = smsLoginPageInputCountingState.countDown;
        }
        if ((i2 & 4) != 0) {
            z = smsLoginPageInputCountingState.loggedIn;
        }
        return smsLoginPageInputCountingState.copy(smsLoginInput, i, z);
    }

    public final SmsLoginInput component1() {
        return this.input;
    }

    public final int component2() {
        return this.countDown;
    }

    public final boolean component3() {
        return this.loggedIn;
    }

    public final SmsLoginPageInputCountingState copy(SmsLoginInput smsLoginInput, int i, boolean z) {
        Intrinsics.checkNotNullParameter(smsLoginInput, "input");
        return new SmsLoginPageInputCountingState(smsLoginInput, i, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SmsLoginPageInputCountingState) {
            SmsLoginPageInputCountingState smsLoginPageInputCountingState = (SmsLoginPageInputCountingState) obj;
            return Intrinsics.areEqual(this.input, smsLoginPageInputCountingState.input) && this.countDown == smsLoginPageInputCountingState.countDown && this.loggedIn == smsLoginPageInputCountingState.loggedIn;
        }
        return false;
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginPageState, tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public /* synthetic */ String getLoginType() {
        return ISmsLoginPageState.CC.$default$getLoginType(this);
    }

    public int hashCode() {
        return (((this.input.hashCode() * 31) + this.countDown) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.loggedIn);
    }

    public String toString() {
        SmsLoginInput smsLoginInput = this.input;
        int i = this.countDown;
        return "SmsLoginPageInputCountingState(input=" + smsLoginInput + ", countDown=" + i + ", loggedIn=" + this.loggedIn + ")";
    }

    public SmsLoginPageInputCountingState(SmsLoginInput input, int countDown, boolean loggedIn) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.input = input;
        this.countDown = countDown;
        this.loggedIn = loggedIn;
    }

    public /* synthetic */ SmsLoginPageInputCountingState(SmsLoginInput smsLoginInput, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(smsLoginInput, (i2 & 2) != 0 ? -1 : i, (i2 & 4) != 0 ? false : z);
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginValidState, tv.danmaku.bili.fullscreen.state.ISmsLoginCountingState, tv.danmaku.bili.fullscreen.state.ISmsLoginLoadingState
    public SmsLoginInput getInput() {
        return this.input;
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginCountingState
    public int getCountDown() {
        return this.countDown;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public boolean getLoggedIn() {
        return this.loggedIn;
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginValidState
    public SmsLoginPageInputCountingState copyState(SmsLoginInput input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return copy$default(this, input, 0, false, 6, null);
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginCountingState
    public SmsLoginPageInputCountingState countDownTo(int count) {
        return copy$default(this, null, count, false, 5, null);
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
        return copy$default(this, (SmsLoginInput) function1.invoke(getInput()), 0, false, 6, null);
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginPageState
    public ISmsLoginPageState toast(ToastInfo toastInfo) {
        SmsLoginInput copy;
        Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
        copy = r1.copy((r26 & 1) != 0 ? r1.phone : null, (r26 & 2) != 0 ? r1.smsCode : null, (r26 & 4) != 0 ? r1.agreementChecked : false, (r26 & 8) != 0 ? r1.availableCountryCode : null, (r26 & 16) != 0 ? r1.selectedCountry : null, (r26 & 32) != 0 ? r1.showCountryCodeSelect : false, (r26 & 64) != 0 ? r1.captchaStatus : null, (r26 & BR.cover) != 0 ? r1.redirected : null, (r26 & BR.hallEnterHotText) != 0 ? r1.toastInfo : toastInfo, (r26 & BR.roleType) != 0 ? r1.eulaDisplayInfo : null, (r26 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? r1.loginWay : null, (r26 & 2048) != 0 ? getInput().netCodeState : null);
        return copy$default(this, copy, 0, false, 6, null);
    }
}