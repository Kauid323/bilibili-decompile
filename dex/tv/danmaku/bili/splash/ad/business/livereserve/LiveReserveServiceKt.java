package tv.danmaku.bili.splash.ad.business.livereserve;

import com.bilibili.base.BiliContext;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.model.CookieInfo;
import com.bilibili.lib.arch.lifecycle.Resource;
import com.bilibili.lib.coroutineextension.BiliCallExtKt;
import com.bilibili.okretro.ServiceGenerator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: LiveReserveService.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u001e\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0080@¢\u0006\u0002\u0010\u0005\u001a\b\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\b"}, d2 = {"reserveLiveBySid", "Lcom/bilibili/lib/arch/lifecycle/Resource;", "", "sid", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCsrfValueFromCookie", "", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LiveReserveServiceKt {
    public static final Object reserveLiveBySid(long sid, Continuation<? super Resource<? extends Object>> continuation) {
        String csrf = getCsrfValueFromCookie();
        String accessKey = BiliAccounts.get(BiliContext.application()).getAccessKey();
        return BiliCallExtKt.getResult(((LiveReserveService) ServiceGenerator.createService(LiveReserveService.class)).reserve(accessKey, sid, csrf), continuation);
    }

    private static final String getCsrfValueFromCookie() {
        CookieInfo accountCookie = BiliAccounts.get(BiliContext.application()).getAccountCookie();
        List<CookieInfo.CookieBean> cookies = accountCookie != null ? accountCookie.cookies : null;
        if (cookies != null) {
            for (CookieInfo.CookieBean cookie : cookies) {
                if (Intrinsics.areEqual(cookie.name, "bili_jct")) {
                    String str = cookie.value;
                    Intrinsics.checkNotNullExpressionValue(str, "value");
                    return str;
                }
            }
            return "";
        }
        return "";
    }
}