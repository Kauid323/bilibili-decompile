package tv.danmaku.bili.fullscreen.state;

import BottomSheetItemData$;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.data.AvailableCountryCode;
import tv.danmaku.bili.fullscreen.data.PhoneCountryCode;
import tv.danmaku.bili.fullscreen.service.EulaDisplayInfo;
import tv.danmaku.bili.fullscreen.service.IAccountRedirect;
import tv.danmaku.bili.fullscreen.service.LoginCaptchaInfo;
import tv.danmaku.bili.fullscreen.service.SmsCaptchaStatus;
import tv.danmaku.bili.fullscreen.service.ToastInfo;
import tv.danmaku.bili.fullscreen.stat.LoginWay;
import tv.danmaku.bili.fullscreen.stat.Sms;
import tv.danmaku.bili.fullscreen.state.ISmsLoginAction;
import tv.danmaku.bili.report.misaka.MisakaHelper;

/* compiled from: SmsLoginPageState.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0006HÆ\u0003J\t\u0010:\u001a\u00020\bHÆ\u0003J\t\u0010;\u001a\u00020\nHÆ\u0003J\t\u0010<\u001a\u00020\u0006HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010?\u001a\u00020\u0011HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u0010A\u001a\u00020\u0015HÆ\u0003J\t\u0010B\u001a\u00020\u0017HÆ\u0003J\u0087\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017HÆ\u0001J\u0013\u0010D\u001a\u00020\u00062\b\u0010E\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010F\u001a\u00020GHÖ\u0001J\t\u0010H\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u00100\u001a\u0004\u0018\u0001018F¢\u0006\u0006\u001a\u0004\b2\u00103R\u0011\u00104\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b4\u0010\u001eR\u0011\u00105\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b6\u0010\u001e¨\u0006I"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/SmsLoginInput;", "", "phone", "", "smsCode", "agreementChecked", "", "availableCountryCode", "Ltv/danmaku/bili/fullscreen/data/AvailableCountryCode;", "selectedCountry", "Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;", "showCountryCodeSelect", "captchaStatus", "Ltv/danmaku/bili/fullscreen/service/SmsCaptchaStatus;", "redirected", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "toastInfo", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "eulaDisplayInfo", "Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "loginWay", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "netCodeState", "Ltv/danmaku/bili/fullscreen/state/NetCodeState;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLtv/danmaku/bili/fullscreen/data/AvailableCountryCode;Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;ZLtv/danmaku/bili/fullscreen/service/SmsCaptchaStatus;Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;Ltv/danmaku/bili/fullscreen/service/ToastInfo;Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;Ltv/danmaku/bili/fullscreen/stat/LoginWay;Ltv/danmaku/bili/fullscreen/state/NetCodeState;)V", "getPhone", "()Ljava/lang/String;", "getSmsCode", "getAgreementChecked", "()Z", "getAvailableCountryCode", "()Ltv/danmaku/bili/fullscreen/data/AvailableCountryCode;", "getSelectedCountry", "()Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;", "getShowCountryCodeSelect", "getCaptchaStatus", "()Ltv/danmaku/bili/fullscreen/service/SmsCaptchaStatus;", "getRedirected", "()Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "getToastInfo", "()Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "getEulaDisplayInfo", "()Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "getLoginWay", "()Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "getNetCodeState", "()Ltv/danmaku/bili/fullscreen/state/NetCodeState;", "captchaDisplay", "Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "getCaptchaDisplay", "()Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "isPhoneBindingForNetCodeLogin", "showLoading", "getShowLoading", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SmsLoginInput {
    public static final int $stable = 8;
    private final boolean agreementChecked;
    private final AvailableCountryCode availableCountryCode;
    private final SmsCaptchaStatus captchaStatus;
    private final EulaDisplayInfo eulaDisplayInfo;
    private final LoginWay loginWay;
    private final NetCodeState netCodeState;
    private final String phone;
    private final IAccountRedirect redirected;
    private final PhoneCountryCode selectedCountry;
    private final boolean showCountryCodeSelect;
    private final String smsCode;
    private final ToastInfo toastInfo;

    public SmsLoginInput() {
        this(null, null, false, null, null, false, null, null, null, null, null, null, 4095, null);
    }

    public static /* synthetic */ SmsLoginInput copy$default(SmsLoginInput smsLoginInput, String str, String str2, boolean z, AvailableCountryCode availableCountryCode, PhoneCountryCode phoneCountryCode, boolean z2, SmsCaptchaStatus smsCaptchaStatus, IAccountRedirect iAccountRedirect, ToastInfo toastInfo, EulaDisplayInfo eulaDisplayInfo, LoginWay loginWay, NetCodeState netCodeState, int i, Object obj) {
        return smsLoginInput.copy((i & 1) != 0 ? smsLoginInput.phone : str, (i & 2) != 0 ? smsLoginInput.smsCode : str2, (i & 4) != 0 ? smsLoginInput.agreementChecked : z, (i & 8) != 0 ? smsLoginInput.availableCountryCode : availableCountryCode, (i & 16) != 0 ? smsLoginInput.selectedCountry : phoneCountryCode, (i & 32) != 0 ? smsLoginInput.showCountryCodeSelect : z2, (i & 64) != 0 ? smsLoginInput.captchaStatus : smsCaptchaStatus, (i & BR.cover) != 0 ? smsLoginInput.redirected : iAccountRedirect, (i & BR.hallEnterHotText) != 0 ? smsLoginInput.toastInfo : toastInfo, (i & BR.roleType) != 0 ? smsLoginInput.eulaDisplayInfo : eulaDisplayInfo, (i & MisakaHelper.MAX_REPORT_SIZE) != 0 ? smsLoginInput.loginWay : loginWay, (i & 2048) != 0 ? smsLoginInput.netCodeState : netCodeState);
    }

    public final String component1() {
        return this.phone;
    }

    public final EulaDisplayInfo component10() {
        return this.eulaDisplayInfo;
    }

    public final LoginWay component11() {
        return this.loginWay;
    }

    public final NetCodeState component12() {
        return this.netCodeState;
    }

    public final String component2() {
        return this.smsCode;
    }

    public final boolean component3() {
        return this.agreementChecked;
    }

    public final AvailableCountryCode component4() {
        return this.availableCountryCode;
    }

    public final PhoneCountryCode component5() {
        return this.selectedCountry;
    }

    public final boolean component6() {
        return this.showCountryCodeSelect;
    }

    public final SmsCaptchaStatus component7() {
        return this.captchaStatus;
    }

    public final IAccountRedirect component8() {
        return this.redirected;
    }

    public final ToastInfo component9() {
        return this.toastInfo;
    }

    public final SmsLoginInput copy(String str, String str2, boolean z, AvailableCountryCode availableCountryCode, PhoneCountryCode phoneCountryCode, boolean z2, SmsCaptchaStatus smsCaptchaStatus, IAccountRedirect iAccountRedirect, ToastInfo toastInfo, EulaDisplayInfo eulaDisplayInfo, LoginWay loginWay, NetCodeState netCodeState) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(str2, "smsCode");
        Intrinsics.checkNotNullParameter(availableCountryCode, "availableCountryCode");
        Intrinsics.checkNotNullParameter(phoneCountryCode, "selectedCountry");
        Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
        Intrinsics.checkNotNullParameter(loginWay, "loginWay");
        Intrinsics.checkNotNullParameter(netCodeState, "netCodeState");
        return new SmsLoginInput(str, str2, z, availableCountryCode, phoneCountryCode, z2, smsCaptchaStatus, iAccountRedirect, toastInfo, eulaDisplayInfo, loginWay, netCodeState);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SmsLoginInput) {
            SmsLoginInput smsLoginInput = (SmsLoginInput) obj;
            return Intrinsics.areEqual(this.phone, smsLoginInput.phone) && Intrinsics.areEqual(this.smsCode, smsLoginInput.smsCode) && this.agreementChecked == smsLoginInput.agreementChecked && Intrinsics.areEqual(this.availableCountryCode, smsLoginInput.availableCountryCode) && Intrinsics.areEqual(this.selectedCountry, smsLoginInput.selectedCountry) && this.showCountryCodeSelect == smsLoginInput.showCountryCodeSelect && Intrinsics.areEqual(this.captchaStatus, smsLoginInput.captchaStatus) && Intrinsics.areEqual(this.redirected, smsLoginInput.redirected) && Intrinsics.areEqual(this.toastInfo, smsLoginInput.toastInfo) && Intrinsics.areEqual(this.eulaDisplayInfo, smsLoginInput.eulaDisplayInfo) && Intrinsics.areEqual(this.loginWay, smsLoginInput.loginWay) && Intrinsics.areEqual(this.netCodeState, smsLoginInput.netCodeState);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.phone.hashCode() * 31) + this.smsCode.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.agreementChecked)) * 31) + this.availableCountryCode.hashCode()) * 31) + this.selectedCountry.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showCountryCodeSelect)) * 31) + (this.captchaStatus == null ? 0 : this.captchaStatus.hashCode())) * 31) + (this.redirected == null ? 0 : this.redirected.hashCode())) * 31) + this.toastInfo.hashCode()) * 31) + (this.eulaDisplayInfo != null ? this.eulaDisplayInfo.hashCode() : 0)) * 31) + this.loginWay.hashCode()) * 31) + this.netCodeState.hashCode();
    }

    public String toString() {
        String str = this.phone;
        String str2 = this.smsCode;
        boolean z = this.agreementChecked;
        AvailableCountryCode availableCountryCode = this.availableCountryCode;
        PhoneCountryCode phoneCountryCode = this.selectedCountry;
        boolean z2 = this.showCountryCodeSelect;
        SmsCaptchaStatus smsCaptchaStatus = this.captchaStatus;
        IAccountRedirect iAccountRedirect = this.redirected;
        ToastInfo toastInfo = this.toastInfo;
        EulaDisplayInfo eulaDisplayInfo = this.eulaDisplayInfo;
        LoginWay loginWay = this.loginWay;
        return "SmsLoginInput(phone=" + str + ", smsCode=" + str2 + ", agreementChecked=" + z + ", availableCountryCode=" + availableCountryCode + ", selectedCountry=" + phoneCountryCode + ", showCountryCodeSelect=" + z2 + ", captchaStatus=" + smsCaptchaStatus + ", redirected=" + iAccountRedirect + ", toastInfo=" + toastInfo + ", eulaDisplayInfo=" + eulaDisplayInfo + ", loginWay=" + loginWay + ", netCodeState=" + this.netCodeState + ")";
    }

    public SmsLoginInput(String phone, String smsCode, boolean agreementChecked, AvailableCountryCode availableCountryCode, PhoneCountryCode selectedCountry, boolean showCountryCodeSelect, SmsCaptchaStatus captchaStatus, IAccountRedirect redirected, ToastInfo toastInfo, EulaDisplayInfo eulaDisplayInfo, LoginWay loginWay, NetCodeState netCodeState) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(smsCode, "smsCode");
        Intrinsics.checkNotNullParameter(availableCountryCode, "availableCountryCode");
        Intrinsics.checkNotNullParameter(selectedCountry, "selectedCountry");
        Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
        Intrinsics.checkNotNullParameter(loginWay, "loginWay");
        Intrinsics.checkNotNullParameter(netCodeState, "netCodeState");
        this.phone = phone;
        this.smsCode = smsCode;
        this.agreementChecked = agreementChecked;
        this.availableCountryCode = availableCountryCode;
        this.selectedCountry = selectedCountry;
        this.showCountryCodeSelect = showCountryCodeSelect;
        this.captchaStatus = captchaStatus;
        this.redirected = redirected;
        this.toastInfo = toastInfo;
        this.eulaDisplayInfo = eulaDisplayInfo;
        this.loginWay = loginWay;
        this.netCodeState = netCodeState;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ SmsLoginInput(String str, String str2, boolean z, AvailableCountryCode availableCountryCode, PhoneCountryCode phoneCountryCode, boolean z2, SmsCaptchaStatus smsCaptchaStatus, IAccountRedirect iAccountRedirect, ToastInfo toastInfo, EulaDisplayInfo eulaDisplayInfo, LoginWay loginWay, NetCodeState netCodeState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r2, r3, r5, (i & 16) != 0 ? r5.getDefaultCountry() : phoneCountryCode, (i & 32) == 0 ? z2 : false, (i & 64) != 0 ? null : smsCaptchaStatus, (i & BR.cover) != 0 ? null : iAccountRedirect, (i & BR.hallEnterHotText) != 0 ? new ToastInfo(null, 0L, 3, null) : toastInfo, (i & BR.roleType) == 0 ? eulaDisplayInfo : null, (i & MisakaHelper.MAX_REPORT_SIZE) != 0 ? Sms.SmsLogin.INSTANCE : loginWay, (i & 2048) != 0 ? NetCodeInit.INSTANCE : netCodeState);
        String str3 = (i & 1) != 0 ? "" : str;
        String str4 = (i & 2) == 0 ? str2 : "";
        boolean z3 = (i & 4) != 0 ? false : z;
        AvailableCountryCode availableCountryCode2 = (i & 8) != 0 ? new AvailableCountryCode(null, null, 3, null) : availableCountryCode;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getSmsCode() {
        return this.smsCode;
    }

    public final boolean getAgreementChecked() {
        return this.agreementChecked;
    }

    public final AvailableCountryCode getAvailableCountryCode() {
        return this.availableCountryCode;
    }

    public final PhoneCountryCode getSelectedCountry() {
        return this.selectedCountry;
    }

    public final boolean getShowCountryCodeSelect() {
        return this.showCountryCodeSelect;
    }

    public final SmsCaptchaStatus getCaptchaStatus() {
        return this.captchaStatus;
    }

    public final IAccountRedirect getRedirected() {
        return this.redirected;
    }

    public final ToastInfo getToastInfo() {
        return this.toastInfo;
    }

    public final EulaDisplayInfo getEulaDisplayInfo() {
        return this.eulaDisplayInfo;
    }

    public final LoginWay getLoginWay() {
        return this.loginWay;
    }

    public final NetCodeState getNetCodeState() {
        return this.netCodeState;
    }

    public final LoginCaptchaInfo getCaptchaDisplay() {
        String captchaUrl;
        String it;
        SmsCaptchaStatus smsCaptchaStatus = this.captchaStatus;
        if (smsCaptchaStatus == null || (captchaUrl = smsCaptchaStatus.getCaptchaUrl()) == null || (it = ListExtentionsKt.takeIfNotBlank(captchaUrl)) == null) {
            return null;
        }
        return new LoginCaptchaInfo(this.loginWay, it, new Function2() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginInput$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                IFullscreenAction _get_captchaDisplay_$lambda$0$0;
                _get_captchaDisplay_$lambda$0$0 = SmsLoginInput._get_captchaDisplay_$lambda$0$0((Map) obj, (LoginWay) obj2);
                return _get_captchaDisplay_$lambda$0$0;
            }
        });
    }

    public static final IFullscreenAction _get_captchaDisplay_$lambda$0$0(Map captcha, LoginWay afterLoginWay) {
        Intrinsics.checkNotNullParameter(captcha, "captcha");
        Intrinsics.checkNotNullParameter(afterLoginWay, "afterLoginWay");
        return new ISmsLoginAction.SendSmsAction(afterLoginWay, captcha);
    }

    public final boolean isPhoneBindingForNetCodeLogin() {
        return this.netCodeState instanceof BindingPage;
    }

    public final boolean getShowLoading() {
        return this.netCodeState instanceof NetCodeLoadingState;
    }
}