package tv.danmaku.bili.fullscreen.service;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.stat.LoginWay;
import tv.danmaku.bili.fullscreen.state.IFullscreenAction;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: LoginResultService.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012D\b\u0002\u0010\u0006\u001a>\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003JE\u0010\u0017\u001a>\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\f0\u0007HÆ\u0003Jc\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052D\b\u0002\u0010\u0006\u001a>\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\f0\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012RM\u0010\u0006\u001a>\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "", "loginWay", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "captchaUrl", "", "afterAction", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "captcha", "Ltv/danmaku/bili/fullscreen/state/IFullscreenAction;", "<init>", "(Ltv/danmaku/bili/fullscreen/stat/LoginWay;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "getLoginWay", "()Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "getCaptchaUrl", "()Ljava/lang/String;", "getAfterAction", "()Lkotlin/jvm/functions/Function2;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginCaptchaInfo {
    public static final int $stable = 8;
    private final Function2<Map<String, String>, LoginWay, IFullscreenAction> afterAction;
    private final String captchaUrl;
    private final LoginWay loginWay;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LoginCaptchaInfo copy$default(LoginCaptchaInfo loginCaptchaInfo, LoginWay loginWay, String str, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            loginWay = loginCaptchaInfo.loginWay;
        }
        if ((i & 2) != 0) {
            str = loginCaptchaInfo.captchaUrl;
        }
        if ((i & 4) != 0) {
            function2 = loginCaptchaInfo.afterAction;
        }
        return loginCaptchaInfo.copy(loginWay, str, function2);
    }

    public final LoginWay component1() {
        return this.loginWay;
    }

    public final String component2() {
        return this.captchaUrl;
    }

    public final Function2<Map<String, String>, LoginWay, IFullscreenAction> component3() {
        return this.afterAction;
    }

    public final LoginCaptchaInfo copy(LoginWay loginWay, String str, Function2<? super Map<String, String>, ? super LoginWay, ? extends IFullscreenAction> function2) {
        Intrinsics.checkNotNullParameter(loginWay, "loginWay");
        Intrinsics.checkNotNullParameter(str, "captchaUrl");
        Intrinsics.checkNotNullParameter(function2, "afterAction");
        return new LoginCaptchaInfo(loginWay, str, function2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LoginCaptchaInfo) {
            LoginCaptchaInfo loginCaptchaInfo = (LoginCaptchaInfo) obj;
            return Intrinsics.areEqual(this.loginWay, loginCaptchaInfo.loginWay) && Intrinsics.areEqual(this.captchaUrl, loginCaptchaInfo.captchaUrl) && Intrinsics.areEqual(this.afterAction, loginCaptchaInfo.afterAction);
        }
        return false;
    }

    public int hashCode() {
        return (((this.loginWay.hashCode() * 31) + this.captchaUrl.hashCode()) * 31) + this.afterAction.hashCode();
    }

    public String toString() {
        LoginWay loginWay = this.loginWay;
        String str = this.captchaUrl;
        return "LoginCaptchaInfo(loginWay=" + loginWay + ", captchaUrl=" + str + ", afterAction=" + this.afterAction + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LoginCaptchaInfo(LoginWay loginWay, String captchaUrl, Function2<? super Map<String, String>, ? super LoginWay, ? extends IFullscreenAction> function2) {
        Intrinsics.checkNotNullParameter(loginWay, "loginWay");
        Intrinsics.checkNotNullParameter(captchaUrl, "captchaUrl");
        Intrinsics.checkNotNullParameter(function2, "afterAction");
        this.loginWay = loginWay;
        this.captchaUrl = captchaUrl;
        this.afterAction = function2;
    }

    public /* synthetic */ LoginCaptchaInfo(LoginWay loginWay, String str, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(loginWay, str, (i & 4) != 0 ? new Function2() { // from class: tv.danmaku.bili.fullscreen.service.LoginCaptchaInfo$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                IFullscreenLoginAction.LoginAction _init_$lambda$0;
                _init_$lambda$0 = LoginCaptchaInfo._init_$lambda$0((Map) obj, (LoginWay) obj2);
                return _init_$lambda$0;
            }
        } : function2);
    }

    public final LoginWay getLoginWay() {
        return this.loginWay;
    }

    public final String getCaptchaUrl() {
        return this.captchaUrl;
    }

    public final Function2<Map<String, String>, LoginWay, IFullscreenAction> getAfterAction() {
        return this.afterAction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IFullscreenLoginAction.LoginAction _init_$lambda$0(Map captcha, LoginWay afterLoginWay) {
        Intrinsics.checkNotNullParameter(captcha, "captcha");
        Intrinsics.checkNotNullParameter(afterLoginWay, "afterLoginWay");
        return new IFullscreenLoginAction.LoginAction(afterLoginWay, true, captcha);
    }
}