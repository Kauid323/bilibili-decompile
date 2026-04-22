package tv.danmaku.bili.fullscreen.stat;

import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.stat.LoginWay;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: LoginWay.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/fullscreen/stat/Sms;", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "SmsLogin", "SmsRegisterLogin", "SmsWithNetCode", "SmsWithNetCodeRegister", "Ltv/danmaku/bili/fullscreen/stat/Sms$SmsLogin;", "Ltv/danmaku/bili/fullscreen/stat/Sms$SmsRegisterLogin;", "Ltv/danmaku/bili/fullscreen/stat/Sms$SmsWithNetCode;", "Ltv/danmaku/bili/fullscreen/stat/Sms$SmsWithNetCodeRegister;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface Sms extends LoginWay {

    /* compiled from: LoginWay.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/fullscreen/stat/Sms$SmsLogin;", "Ltv/danmaku/bili/fullscreen/stat/Sms;", "<init>", "()V", "succeedMethod", "", "getSucceedMethod", "()Ljava/lang/String;", "onRegister", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class SmsLogin implements Sms {
        public static final int $stable = 0;
        public static final SmsLogin INSTANCE = new SmsLogin();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SmsLogin) {
                SmsLogin smsLogin = (SmsLogin) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 645294283;
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public /* synthetic */ LoginWay onGeeCaptcha() {
            return LoginWay.CC.$default$onGeeCaptcha(this);
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public /* synthetic */ LoginWay onImageCaptcha() {
            return LoginWay.CC.$default$onImageCaptcha(this);
        }

        public String toString() {
            return "SmsLogin";
        }

        private SmsLogin() {
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public String getSucceedMethod() {
            return LoginReporterV2.Show.LOGIN_SUCCEED_SMS_NO_IDENTITY_FROM_SMS_LOGIN_DIALOG;
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public LoginWay onRegister() {
            return SmsRegisterLogin.INSTANCE;
        }
    }

    /* compiled from: LoginWay.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/fullscreen/stat/Sms$SmsRegisterLogin;", "Ltv/danmaku/bili/fullscreen/stat/Sms;", "<init>", "()V", "succeedMethod", "", "getSucceedMethod", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class SmsRegisterLogin implements Sms {
        public static final int $stable = 0;
        public static final SmsRegisterLogin INSTANCE = new SmsRegisterLogin();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SmsRegisterLogin) {
                SmsRegisterLogin smsRegisterLogin = (SmsRegisterLogin) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1760332312;
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public /* synthetic */ LoginWay onGeeCaptcha() {
            return LoginWay.CC.$default$onGeeCaptcha(this);
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public /* synthetic */ LoginWay onImageCaptcha() {
            return LoginWay.CC.$default$onImageCaptcha(this);
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public /* synthetic */ LoginWay onRegister() {
            return LoginWay.CC.$default$onRegister(this);
        }

        public String toString() {
            return "SmsRegisterLogin";
        }

        private SmsRegisterLogin() {
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public String getSucceedMethod() {
            return LoginReporterV2.Show.LOGIN_SUCCEED_NO_ACCOUNT_FROM_SMS_LOGIN_DIALOG;
        }
    }

    /* compiled from: LoginWay.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/fullscreen/stat/Sms$SmsWithNetCode;", "Ltv/danmaku/bili/fullscreen/stat/Sms;", "<init>", "()V", "succeedMethod", "", "getSucceedMethod", "()Ljava/lang/String;", "onRegister", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class SmsWithNetCode implements Sms {
        public static final int $stable = 0;
        public static final SmsWithNetCode INSTANCE = new SmsWithNetCode();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SmsWithNetCode) {
                SmsWithNetCode smsWithNetCode = (SmsWithNetCode) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1382136166;
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public /* synthetic */ LoginWay onGeeCaptcha() {
            return LoginWay.CC.$default$onGeeCaptcha(this);
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public /* synthetic */ LoginWay onImageCaptcha() {
            return LoginWay.CC.$default$onImageCaptcha(this);
        }

        public String toString() {
            return "SmsWithNetCode";
        }

        private SmsWithNetCode() {
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public String getSucceedMethod() {
            return "36";
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public LoginWay onRegister() {
            return SmsWithNetCodeRegister.INSTANCE;
        }
    }

    /* compiled from: LoginWay.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/fullscreen/stat/Sms$SmsWithNetCodeRegister;", "Ltv/danmaku/bili/fullscreen/stat/Sms;", "<init>", "()V", "succeedMethod", "", "getSucceedMethod", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class SmsWithNetCodeRegister implements Sms {
        public static final int $stable = 0;
        public static final SmsWithNetCodeRegister INSTANCE = new SmsWithNetCodeRegister();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SmsWithNetCodeRegister) {
                SmsWithNetCodeRegister smsWithNetCodeRegister = (SmsWithNetCodeRegister) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1013742039;
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public /* synthetic */ LoginWay onGeeCaptcha() {
            return LoginWay.CC.$default$onGeeCaptcha(this);
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public /* synthetic */ LoginWay onImageCaptcha() {
            return LoginWay.CC.$default$onImageCaptcha(this);
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public /* synthetic */ LoginWay onRegister() {
            return LoginWay.CC.$default$onRegister(this);
        }

        public String toString() {
            return "SmsWithNetCodeRegister";
        }

        private SmsWithNetCodeRegister() {
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public String getSucceedMethod() {
            return "37";
        }
    }
}