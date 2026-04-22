package tv.danmaku.bili.fullscreen.stat;

import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.stat.LoginWay;

/* compiled from: LoginWay.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/fullscreen/stat/Unspecified;", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "<init>", "()V", "succeedMethod", "", "getSucceedMethod", "()Ljava/lang/String;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class Unspecified implements LoginWay {
    public static final int $stable = 0;
    public static final Unspecified INSTANCE = new Unspecified();

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

    private Unspecified() {
    }

    @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
    public String getSucceedMethod() {
        return "";
    }
}