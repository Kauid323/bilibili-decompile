package tv.danmaku.bili.fullscreen.state;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.data.PhoneCountryCode;
import tv.danmaku.bili.fullscreen.stat.LoginWay;
import tv.danmaku.bili.fullscreen.stat.Sms;

/* compiled from: SmsLoginPageState.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0007\u0002\u0003\u0004\u0005\u0006\u0007\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/ISmsLoginAction;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenAction;", "PhoneInputAction", "SmsCodeInputAction", "ClickSendSmsAction", "SendSmsAction", "SelectCountryCode", "OnCountryCodeSelectCancel", "OnCountryCodeSelected", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface ISmsLoginAction extends IFullscreenAction {

    /* compiled from: SmsLoginPageState.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/ISmsLoginAction$PhoneInputAction;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginAction;", "phone", "", "<init>", "(Ljava/lang/String;)V", "getPhone", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class PhoneInputAction implements ISmsLoginAction {
        public static final int $stable = 0;
        private final String phone;

        public static /* synthetic */ PhoneInputAction copy$default(PhoneInputAction phoneInputAction, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = phoneInputAction.phone;
            }
            return phoneInputAction.copy(str);
        }

        public final String component1() {
            return this.phone;
        }

        public final PhoneInputAction copy(String str) {
            Intrinsics.checkNotNullParameter(str, "phone");
            return new PhoneInputAction(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PhoneInputAction) && Intrinsics.areEqual(this.phone, ((PhoneInputAction) obj).phone);
        }

        public int hashCode() {
            return this.phone.hashCode();
        }

        public String toString() {
            return "PhoneInputAction(phone=" + this.phone + ")";
        }

        public PhoneInputAction(String phone) {
            Intrinsics.checkNotNullParameter(phone, "phone");
            this.phone = phone;
        }

        public final String getPhone() {
            return this.phone;
        }
    }

    /* compiled from: SmsLoginPageState.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/ISmsLoginAction$SmsCodeInputAction;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginAction;", "smsCode", "", "<init>", "(Ljava/lang/String;)V", "getSmsCode", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class SmsCodeInputAction implements ISmsLoginAction {
        public static final int $stable = 0;
        private final String smsCode;

        public static /* synthetic */ SmsCodeInputAction copy$default(SmsCodeInputAction smsCodeInputAction, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = smsCodeInputAction.smsCode;
            }
            return smsCodeInputAction.copy(str);
        }

        public final String component1() {
            return this.smsCode;
        }

        public final SmsCodeInputAction copy(String str) {
            Intrinsics.checkNotNullParameter(str, "smsCode");
            return new SmsCodeInputAction(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SmsCodeInputAction) && Intrinsics.areEqual(this.smsCode, ((SmsCodeInputAction) obj).smsCode);
        }

        public int hashCode() {
            return this.smsCode.hashCode();
        }

        public String toString() {
            return "SmsCodeInputAction(smsCode=" + this.smsCode + ")";
        }

        public SmsCodeInputAction(String smsCode) {
            Intrinsics.checkNotNullParameter(smsCode, "smsCode");
            this.smsCode = smsCode;
        }

        public final String getSmsCode() {
            return this.smsCode;
        }
    }

    /* compiled from: SmsLoginPageState.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/ISmsLoginAction$ClickSendSmsAction;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginAction;", "newLoginWay", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "captcha", "", "", "<init>", "(Ltv/danmaku/bili/fullscreen/stat/LoginWay;Ljava/util/Map;)V", "getNewLoginWay", "()Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "getCaptcha", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ClickSendSmsAction implements ISmsLoginAction {
        public static final int $stable = 8;
        private final Map<String, String> captcha;
        private final LoginWay newLoginWay;

        public ClickSendSmsAction() {
            this(null, null, 3, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ClickSendSmsAction copy$default(ClickSendSmsAction clickSendSmsAction, LoginWay loginWay, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                loginWay = clickSendSmsAction.newLoginWay;
            }
            if ((i & 2) != 0) {
                map = clickSendSmsAction.captcha;
            }
            return clickSendSmsAction.copy(loginWay, map);
        }

        public final LoginWay component1() {
            return this.newLoginWay;
        }

        public final Map<String, String> component2() {
            return this.captcha;
        }

        public final ClickSendSmsAction copy(LoginWay loginWay, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(loginWay, "newLoginWay");
            Intrinsics.checkNotNullParameter(map, "captcha");
            return new ClickSendSmsAction(loginWay, map);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ClickSendSmsAction) {
                ClickSendSmsAction clickSendSmsAction = (ClickSendSmsAction) obj;
                return Intrinsics.areEqual(this.newLoginWay, clickSendSmsAction.newLoginWay) && Intrinsics.areEqual(this.captcha, clickSendSmsAction.captcha);
            }
            return false;
        }

        public int hashCode() {
            return (this.newLoginWay.hashCode() * 31) + this.captcha.hashCode();
        }

        public String toString() {
            LoginWay loginWay = this.newLoginWay;
            return "ClickSendSmsAction(newLoginWay=" + loginWay + ", captcha=" + this.captcha + ")";
        }

        public ClickSendSmsAction(LoginWay newLoginWay, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(newLoginWay, "newLoginWay");
            Intrinsics.checkNotNullParameter(map, "captcha");
            this.newLoginWay = newLoginWay;
            this.captcha = map;
        }

        public /* synthetic */ ClickSendSmsAction(Sms.SmsLogin smsLogin, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Sms.SmsLogin.INSTANCE : smsLogin, (i & 2) != 0 ? MapsKt.emptyMap() : map);
        }

        public final LoginWay getNewLoginWay() {
            return this.newLoginWay;
        }

        public final Map<String, String> getCaptcha() {
            return this.captcha;
        }
    }

    /* compiled from: SmsLoginPageState.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/ISmsLoginAction$SendSmsAction;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginAction;", "newLoginWay", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "captcha", "", "", "<init>", "(Ltv/danmaku/bili/fullscreen/stat/LoginWay;Ljava/util/Map;)V", "getNewLoginWay", "()Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "getCaptcha", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class SendSmsAction implements ISmsLoginAction {
        public static final int $stable = 8;
        private final Map<String, String> captcha;
        private final LoginWay newLoginWay;

        public SendSmsAction() {
            this(null, null, 3, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SendSmsAction copy$default(SendSmsAction sendSmsAction, LoginWay loginWay, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                loginWay = sendSmsAction.newLoginWay;
            }
            if ((i & 2) != 0) {
                map = sendSmsAction.captcha;
            }
            return sendSmsAction.copy(loginWay, map);
        }

        public final LoginWay component1() {
            return this.newLoginWay;
        }

        public final Map<String, String> component2() {
            return this.captcha;
        }

        public final SendSmsAction copy(LoginWay loginWay, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(loginWay, "newLoginWay");
            Intrinsics.checkNotNullParameter(map, "captcha");
            return new SendSmsAction(loginWay, map);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SendSmsAction) {
                SendSmsAction sendSmsAction = (SendSmsAction) obj;
                return Intrinsics.areEqual(this.newLoginWay, sendSmsAction.newLoginWay) && Intrinsics.areEqual(this.captcha, sendSmsAction.captcha);
            }
            return false;
        }

        public int hashCode() {
            return (this.newLoginWay.hashCode() * 31) + this.captcha.hashCode();
        }

        public String toString() {
            LoginWay loginWay = this.newLoginWay;
            return "SendSmsAction(newLoginWay=" + loginWay + ", captcha=" + this.captcha + ")";
        }

        public SendSmsAction(LoginWay newLoginWay, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(newLoginWay, "newLoginWay");
            Intrinsics.checkNotNullParameter(map, "captcha");
            this.newLoginWay = newLoginWay;
            this.captcha = map;
        }

        public /* synthetic */ SendSmsAction(Sms.SmsLogin smsLogin, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Sms.SmsLogin.INSTANCE : smsLogin, (i & 2) != 0 ? MapsKt.emptyMap() : map);
        }

        public final LoginWay getNewLoginWay() {
            return this.newLoginWay;
        }

        public final Map<String, String> getCaptcha() {
            return this.captcha;
        }
    }

    /* compiled from: SmsLoginPageState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/ISmsLoginAction$SelectCountryCode;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginAction;", "<init>", "()V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class SelectCountryCode implements ISmsLoginAction {
        public static final int $stable = 0;
        public static final SelectCountryCode INSTANCE = new SelectCountryCode();

        private SelectCountryCode() {
        }
    }

    /* compiled from: SmsLoginPageState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/ISmsLoginAction$OnCountryCodeSelectCancel;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginAction;", "<init>", "()V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class OnCountryCodeSelectCancel implements ISmsLoginAction {
        public static final int $stable = 0;
        public static final OnCountryCodeSelectCancel INSTANCE = new OnCountryCodeSelectCancel();

        private OnCountryCodeSelectCancel() {
        }
    }

    /* compiled from: SmsLoginPageState.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/ISmsLoginAction$OnCountryCodeSelected;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginAction;", "currentInput", "Ltv/danmaku/bili/fullscreen/state/SmsLoginInput;", "countryCode", "Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;", "<init>", "(Ltv/danmaku/bili/fullscreen/state/SmsLoginInput;Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;)V", "getCurrentInput", "()Ltv/danmaku/bili/fullscreen/state/SmsLoginInput;", "getCountryCode", "()Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class OnCountryCodeSelected implements ISmsLoginAction {
        public static final int $stable = 8;
        private final PhoneCountryCode countryCode;
        private final SmsLoginInput currentInput;

        public static /* synthetic */ OnCountryCodeSelected copy$default(OnCountryCodeSelected onCountryCodeSelected, SmsLoginInput smsLoginInput, PhoneCountryCode phoneCountryCode, int i, Object obj) {
            if ((i & 1) != 0) {
                smsLoginInput = onCountryCodeSelected.currentInput;
            }
            if ((i & 2) != 0) {
                phoneCountryCode = onCountryCodeSelected.countryCode;
            }
            return onCountryCodeSelected.copy(smsLoginInput, phoneCountryCode);
        }

        public final SmsLoginInput component1() {
            return this.currentInput;
        }

        public final PhoneCountryCode component2() {
            return this.countryCode;
        }

        public final OnCountryCodeSelected copy(SmsLoginInput smsLoginInput, PhoneCountryCode phoneCountryCode) {
            Intrinsics.checkNotNullParameter(smsLoginInput, "currentInput");
            Intrinsics.checkNotNullParameter(phoneCountryCode, "countryCode");
            return new OnCountryCodeSelected(smsLoginInput, phoneCountryCode);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof OnCountryCodeSelected) {
                OnCountryCodeSelected onCountryCodeSelected = (OnCountryCodeSelected) obj;
                return Intrinsics.areEqual(this.currentInput, onCountryCodeSelected.currentInput) && Intrinsics.areEqual(this.countryCode, onCountryCodeSelected.countryCode);
            }
            return false;
        }

        public int hashCode() {
            return (this.currentInput.hashCode() * 31) + this.countryCode.hashCode();
        }

        public String toString() {
            SmsLoginInput smsLoginInput = this.currentInput;
            return "OnCountryCodeSelected(currentInput=" + smsLoginInput + ", countryCode=" + this.countryCode + ")";
        }

        public OnCountryCodeSelected(SmsLoginInput currentInput, PhoneCountryCode countryCode) {
            Intrinsics.checkNotNullParameter(currentInput, "currentInput");
            Intrinsics.checkNotNullParameter(countryCode, "countryCode");
            this.currentInput = currentInput;
            this.countryCode = countryCode;
        }

        public final SmsLoginInput getCurrentInput() {
            return this.currentInput;
        }

        public final PhoneCountryCode getCountryCode() {
            return this.countryCode;
        }
    }
}