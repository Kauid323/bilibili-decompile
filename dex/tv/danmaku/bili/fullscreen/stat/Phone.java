package tv.danmaku.bili.fullscreen.stat;

import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.stat.LoginWay;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: LoginWay.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/fullscreen/stat/Phone;", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "PhoneLogin", "PhoneRegister", "Ltv/danmaku/bili/fullscreen/stat/Phone$PhoneLogin;", "Ltv/danmaku/bili/fullscreen/stat/Phone$PhoneRegister;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface Phone extends LoginWay {

    /* compiled from: LoginWay.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/fullscreen/stat/Phone$PhoneLogin;", "Ltv/danmaku/bili/fullscreen/stat/Phone;", "<init>", "()V", "succeedMethod", "", "getSucceedMethod", "()Ljava/lang/String;", "onRegister", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class PhoneLogin implements Phone {
        public static final int $stable = 0;
        public static final PhoneLogin INSTANCE = new PhoneLogin();

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public /* synthetic */ LoginWay onGeeCaptcha() {
            return LoginWay.CC.$default$onGeeCaptcha(this);
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public /* synthetic */ LoginWay onImageCaptcha() {
            return LoginWay.CC.$default$onImageCaptcha(this);
        }

        private PhoneLogin() {
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public String getSucceedMethod() {
            return LoginReporterV2.Show.LOGIN_SUCCEED_QUICK_DIRECTLY;
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public LoginWay onRegister() {
            return PhoneRegister.INSTANCE;
        }
    }

    /* compiled from: LoginWay.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/fullscreen/stat/Phone$PhoneRegister;", "Ltv/danmaku/bili/fullscreen/stat/Phone;", "<init>", "()V", "succeedMethod", "", "getSucceedMethod", "()Ljava/lang/String;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class PhoneRegister implements Phone {
        public static final int $stable = 0;
        public static final PhoneRegister INSTANCE = new PhoneRegister();

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

        private PhoneRegister() {
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public String getSucceedMethod() {
            return LoginReporterV2.Show.LOGIN_SUCCEED_QUICK_AFTER_REGISTER;
        }
    }
}