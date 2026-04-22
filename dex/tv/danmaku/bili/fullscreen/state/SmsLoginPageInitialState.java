package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.EulaDisplayInfo;
import tv.danmaku.bili.fullscreen.service.IAccountRedirect;
import tv.danmaku.bili.fullscreen.service.LoginCaptchaInfo;
import tv.danmaku.bili.fullscreen.service.ToastInfo;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage;
import tv.danmaku.bili.fullscreen.state.ISmsLoginPageState;

/* compiled from: SmsLoginPageState.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u001e\u001a\u00020\u00012\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0 ¢\u0006\u0002\b\"H\u0016J\u0010\u0010#\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u0013\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0007R\u0014\u0010\u001c\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000b¨\u0006-"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/SmsLoginPageInitialState;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginPageState;", "initNetCodeState", "Ltv/danmaku/bili/fullscreen/state/NetCodeState;", "<init>", "(Ltv/danmaku/bili/fullscreen/state/NetCodeState;)V", "getInitNetCodeState", "()Ltv/danmaku/bili/fullscreen/state/NetCodeState;", "loggedIn", "", "getLoggedIn", "()Z", "showLoading", "getShowLoading", "redirect", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "getRedirect", "()Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "captchaDisplay", "Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "getCaptchaDisplay", "()Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "toastInfo", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "getToastInfo", "()Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "netCodeState", "getNetCodeState", "agreementChecked", "getAgreementChecked", "mutateInput", "mutate", "Lkotlin/Function1;", "Ltv/danmaku/bili/fullscreen/state/SmsLoginInput;", "Lkotlin/ExtensionFunctionType;", "toast", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SmsLoginPageInitialState implements ISmsLoginPageState {
    public static final int $stable = 8;
    private final NetCodeState initNetCodeState;
    private final ToastInfo toastInfo;

    public SmsLoginPageInitialState() {
        this(null, 1, null);
    }

    public static /* synthetic */ SmsLoginPageInitialState copy$default(SmsLoginPageInitialState smsLoginPageInitialState, NetCodeState netCodeState, int i, Object obj) {
        if ((i & 1) != 0) {
            netCodeState = smsLoginPageInitialState.initNetCodeState;
        }
        return smsLoginPageInitialState.copy(netCodeState);
    }

    public final NetCodeState component1() {
        return this.initNetCodeState;
    }

    public final SmsLoginPageInitialState copy(NetCodeState netCodeState) {
        Intrinsics.checkNotNullParameter(netCodeState, "initNetCodeState");
        return new SmsLoginPageInitialState(netCodeState);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SmsLoginPageInitialState) && Intrinsics.areEqual(this.initNetCodeState, ((SmsLoginPageInitialState) obj).initNetCodeState);
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public /* synthetic */ EulaDisplayInfo getEulaDisplay() {
        return IFullscreenLoginPage.CC.$default$getEulaDisplay(this);
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginPageState, tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public /* synthetic */ String getLoginType() {
        return ISmsLoginPageState.CC.$default$getLoginType(this);
    }

    public int hashCode() {
        return this.initNetCodeState.hashCode();
    }

    public String toString() {
        return "SmsLoginPageInitialState(initNetCodeState=" + this.initNetCodeState + ")";
    }

    public SmsLoginPageInitialState(NetCodeState initNetCodeState) {
        Intrinsics.checkNotNullParameter(initNetCodeState, "initNetCodeState");
        this.initNetCodeState = initNetCodeState;
        this.toastInfo = new ToastInfo(null, 0L, 3, null);
    }

    public /* synthetic */ SmsLoginPageInitialState(NetCodeInit netCodeInit, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? NetCodeInit.INSTANCE : netCodeInit);
    }

    public final NetCodeState getInitNetCodeState() {
        return this.initNetCodeState;
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
        return null;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public LoginCaptchaInfo getCaptchaDisplay() {
        return null;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public ToastInfo getToastInfo() {
        return this.toastInfo;
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginPageState
    public NetCodeState getNetCodeState() {
        return this.initNetCodeState;
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginPageState
    public boolean getAgreementChecked() {
        return false;
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginPageState
    public ISmsLoginPageState mutateInput(Function1<? super SmsLoginInput, SmsLoginInput> function1) {
        Intrinsics.checkNotNullParameter(function1, "mutate");
        return this;
    }

    @Override // tv.danmaku.bili.fullscreen.state.ISmsLoginPageState
    public ISmsLoginPageState toast(ToastInfo toastInfo) {
        Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
        return this;
    }
}