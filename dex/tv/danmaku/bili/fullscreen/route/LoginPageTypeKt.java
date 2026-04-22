package tv.danmaku.bili.fullscreen.route;

import android.content.Context;
import android.os.Bundle;
import com.bilibili.lib.blrouter.RouteRequest;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: LoginPageType.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\"\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a6\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0080@¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"toLoginPage", "Ltv/danmaku/bili/fullscreen/route/LoginPageType;", "Ltv/danmaku/bili/fullscreen/route/ValidLoginType;", "list", "", "display", "Ltv/danmaku/bili/fullscreen/route/LoginPageDisplay;", "buildPhoneBinding", "Lcom/bilibili/lib/blrouter/RouteRequest;", "context", "Landroid/content/Context;", "phoneBindingFrom", "Ltv/danmaku/bili/fullscreen/route/PhoneBindingFrom;", "platform", "", "appId", "openId", "(Landroid/content/Context;Ltv/danmaku/bili/fullscreen/route/PhoneBindingFrom;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountui_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginPageTypeKt {
    public static final LoginPageType toLoginPage(ValidLoginType $this$toLoginPage, List<? extends ValidLoginType> list, LoginPageDisplay display) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter($this$toLoginPage, "<this>");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(display, "display");
        if ($this$toLoginPage == ValidLoginType.PwdLogin && display == LoginPageDisplay.FullscreenOld) {
            if (list.contains(ValidLoginType.SmsLogin)) {
                return LoginPageType.PwdLoginPage;
            }
            return LoginPageType.PwdNoSmsLoginPage;
        }
        Iterator it = LoginPageType.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            LoginPageType it2 = (LoginPageType) obj;
            if (it2.getType() == $this$toLoginPage && it2.getDisplay() == display) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        return (LoginPageType) obj;
    }

    public static final Object buildPhoneBinding(Context context, PhoneBindingFrom phoneBindingFrom, String platform, String appId, String openId, Continuation<? super RouteRequest> continuation) {
        Bundle extra = new Bundle();
        extra.putString("binding_open_id", openId);
        extra.putString("binding_sns_platform", platform);
        extra.putString("binding_sns_app_id", appId);
        extra.putParcelable("phone_binding_from", phoneBindingFrom);
        return LoginPageType.SmsFullscreen.buildLoginRequest(context, "netcode_sns", CollectionsKt.listOf(ValidLoginType.SmsLogin), extra, continuation);
    }
}