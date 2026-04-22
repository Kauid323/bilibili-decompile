package tv.danmaku.bili.splash.ad.services;

import android.app.Application;
import com.bilibili.adcommon.config.DDConfig;
import com.bilibili.app.comm.list.common.api.ListPlayerPreloadUtilKt;
import com.bilibili.base.BiliContext;
import com.bilibili.okretro.interceptor.DefaultRequestInterceptor;
import com.bilibili.xpref.Xpref;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;

/* compiled from: SplashShowInterceptor.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bH\u0014R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/splash/ad/services/SplashShowInterceptor;", "Lcom/bilibili/okretro/interceptor/DefaultRequestInterceptor;", "<init>", "()V", "httpsUrlReq", "", "getHttpsUrlReq", "()Ljava/lang/String;", "addCommonParam", "", "params", "", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashShowInterceptor extends DefaultRequestInterceptor {
    public static final int $stable = 8;

    private final String getHttpsUrlReq() {
        Application application = BiliContext.application();
        Intrinsics.checkNotNull(application);
        boolean enableHttps = Xpref.getSharedPreferences(application, "bili_main_settings_preferences").getBoolean("pref_player_https_safe_key", false);
        return enableHttps ? "1" : "0";
    }

    protected void addCommonParam(Map<String, String> map) {
        String str;
        super.addCommonParam(map);
        if (map != null) {
            if (DDConfig.INSTANCE.getSplashTopViewBannerMixinExp()) {
                boolean z = false;
                if (map.get("topview_ids") != null && (!StringsKt.isBlank(str))) {
                    z = true;
                }
                if (z) {
                    map.put("https_url_req", getHttpsUrlReq());
                    map.put("fnval", String.valueOf(ListPlayerPreloadUtilKt.getPlayerPreloadFnVal()));
                }
                map.put("mixin_banner", "1");
                return;
            }
            map.put("mixin_banner", "0");
        }
    }
}