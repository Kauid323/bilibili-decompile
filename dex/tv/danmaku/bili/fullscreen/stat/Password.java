package tv.danmaku.bili.fullscreen.stat;

import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.stat.LoginWay;

/* compiled from: LoginWay.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/fullscreen/stat/Password;", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "PasswordLogin", "PasswordGeeLogin", "PasswordImageCaptcha", "Ltv/danmaku/bili/fullscreen/stat/Password$PasswordGeeLogin;", "Ltv/danmaku/bili/fullscreen/stat/Password$PasswordImageCaptcha;", "Ltv/danmaku/bili/fullscreen/stat/Password$PasswordLogin;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface Password extends LoginWay {

    /* compiled from: LoginWay.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/fullscreen/stat/Password$PasswordLogin;", "Ltv/danmaku/bili/fullscreen/stat/Password;", "<init>", "()V", "succeedMethod", "", "getSucceedMethod", "()Ljava/lang/String;", "onGeeCaptcha", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "onImageCaptcha", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class PasswordLogin implements Password {
        public static final int $stable = 0;
        public static final PasswordLogin INSTANCE = new PasswordLogin();

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public /* synthetic */ LoginWay onRegister() {
            return LoginWay.CC.$default$onRegister(this);
        }

        private PasswordLogin() {
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public String getSucceedMethod() {
            return "1";
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public LoginWay onGeeCaptcha() {
            return PasswordGeeLogin.INSTANCE;
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public LoginWay onImageCaptcha() {
            return PasswordImageCaptcha.INSTANCE;
        }
    }

    /* compiled from: LoginWay.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/fullscreen/stat/Password$PasswordGeeLogin;", "Ltv/danmaku/bili/fullscreen/stat/Password;", "<init>", "()V", "succeedMethod", "", "getSucceedMethod", "()Ljava/lang/String;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class PasswordGeeLogin implements Password {
        public static final int $stable = 0;
        public static final PasswordGeeLogin INSTANCE = new PasswordGeeLogin();

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

        private PasswordGeeLogin() {
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public String getSucceedMethod() {
            return "2";
        }
    }

    /* compiled from: LoginWay.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/fullscreen/stat/Password$PasswordImageCaptcha;", "Ltv/danmaku/bili/fullscreen/stat/Password;", "<init>", "()V", "succeedMethod", "", "getSucceedMethod", "()Ljava/lang/String;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class PasswordImageCaptcha implements Password {
        public static final int $stable = 0;
        public static final PasswordImageCaptcha INSTANCE = new PasswordImageCaptcha();

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

        private PasswordImageCaptcha() {
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public String getSucceedMethod() {
            return "3";
        }
    }
}