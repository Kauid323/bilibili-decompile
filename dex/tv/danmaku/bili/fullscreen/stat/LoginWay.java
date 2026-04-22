package tv.danmaku.bili.fullscreen.stat;

import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: LoginWay.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0000H\u0016J\b\u0010\u0007\u001a\u00020\u0000H\u0016J\b\u0010\b\u001a\u00020\u0000H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\b\t\n\u000b\f\r\u000e\u000f\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "", "succeedMethod", "", "getSucceedMethod", "()Ljava/lang/String;", "onRegister", "onGeeCaptcha", "onImageCaptcha", "Ltv/danmaku/bili/fullscreen/stat/Facebook;", "Ltv/danmaku/bili/fullscreen/stat/Fast;", "Ltv/danmaku/bili/fullscreen/stat/Google;", "Ltv/danmaku/bili/fullscreen/stat/Password;", "Ltv/danmaku/bili/fullscreen/stat/Phone;", "Ltv/danmaku/bili/fullscreen/stat/Sms;", "Ltv/danmaku/bili/fullscreen/stat/ThirdParty;", "Ltv/danmaku/bili/fullscreen/stat/Unspecified;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface LoginWay {
    String getSucceedMethod();

    LoginWay onGeeCaptcha();

    LoginWay onImageCaptcha();

    LoginWay onRegister();

    /* compiled from: LoginWay.kt */
    /* renamed from: tv.danmaku.bili.fullscreen.stat.LoginWay$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final /* synthetic */ class CC {
        public static LoginWay $default$onRegister(LoginWay _this) {
            return _this;
        }

        public static LoginWay $default$onGeeCaptcha(LoginWay _this) {
            return _this;
        }

        public static LoginWay $default$onImageCaptcha(LoginWay _this) {
            return _this;
        }
    }
}