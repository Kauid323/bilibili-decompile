package tv.danmaku.bili.ui.splash.utils;

import android.net.Uri;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.ui.IDrawerHost;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.BuildConfig;
import tv.danmaku.bili.ui.splash.ad.page.HotSplashActivityKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashUtils.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a$\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0000\"\u0014\u0010\u000b\u001a\u00020\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\r\"\u001b\u0010\u000e\u001a\u00020\f8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000e\u0010\r\"\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"removeUriParameter", "Landroid/net/Uri;", "uri", "paramKeyToRemove", "", "getFloatValue", "", "jsonObject", "Lcom/alibaba/fastjson/JSONObject;", "key", "defaultValue", "isSplashShowing", "", "()Z", "isDebug", "isDebug$delegate", "Lkotlin/Lazy;", "TAG", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashUtilsKt {
    private static final String TAG = "[Splash]SplashUtils";
    private static final Lazy isDebug$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashUtilsKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean z;
            z = BuildConfig.DEBUG;
            return Boolean.valueOf(z);
        }
    });

    public static final Uri removeUriParameter(Uri uri, String paramKeyToRemove) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(paramKeyToRemove, "paramKeyToRemove");
        Set params = uri.getQueryParameterNames();
        Uri.Builder newUri = uri.buildUpon().clearQuery();
        for (String param : params) {
            if (!Intrinsics.areEqual(param, paramKeyToRemove)) {
                newUri.appendQueryParameter(param, uri.getQueryParameter(param));
            }
        }
        return newUri.build();
    }

    public static final float getFloatValue(JSONObject jsonObject, String key, float defaultValue) {
        Map map = (Map) jsonObject;
        if (map == null || map.isEmpty()) {
            return defaultValue;
        }
        try {
            Float value = jsonObject.getFloat(key);
            return value != null ? value.floatValue() : defaultValue;
        } catch (Exception e) {
            BLog.i(TAG, "getIntValue exception = " + e.getMessage());
            return defaultValue;
        }
    }

    public static final boolean isSplashShowing() {
        IDrawerHost iDrawerHost = BiliContext.topActivitiy();
        IDrawerHost iDrawerHost2 = iDrawerHost instanceof IDrawerHost ? iDrawerHost : null;
        return (iDrawerHost2 != null && iDrawerHost2.isSplashShowing()) || HotSplashActivityKt.isHotSplashShowing;
    }

    public static final boolean isDebug() {
        return ((Boolean) isDebug$delegate.getValue()).booleanValue();
    }
}