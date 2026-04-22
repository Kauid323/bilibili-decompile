package tv.danmaku.bili.splash.ad.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.bilibili.adcommon.basic.Motion;
import com.bilibili.adcommon.data.IAdInfo;
import com.bilibili.base.BiliContext;
import com.bilibili.gripper.api.ad.core.GAdCoreKt;
import com.bilibili.gripper.api.ad.core.GAdReport;
import com.bilibili.lib.ui.IDrawerHost;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import shark.AndroidResourceIdNames;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.adsplash.BuildConfig;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.page.HotSplashActivityKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: SplashUtils.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a(\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0000\u001a&\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0002\u001a\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0000\"\u0014\u0010\u0000\u001a\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0002\"\u001b\u0010\u0011\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0011\u0010\u0002¨\u0006\u0014"}, d2 = {"isSplashShowing", "", "()Z", "buildThirdIntent", "Landroid/content/Intent;", UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH, "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "schema", "", "pkgName", "getThirdAppIntent", "context", "Landroid/content/Context;", AudioIntentHelper.ARGS_URI, "removeUriParameter", "Landroid/net/Uri;", "paramKeyToRemove", "isDebug", "isDebug$delegate", "Lkotlin/Lazy;", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashUtilsKt {
    private static final Lazy isDebug$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.splash.ad.utils.SplashUtilsKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean z;
            z = BuildConfig.DEBUG;
            return Boolean.valueOf(z);
        }
    });

    public static final boolean isSplashShowing() {
        IDrawerHost iDrawerHost = BiliContext.topActivity();
        IDrawerHost iDrawerHost2 = iDrawerHost instanceof IDrawerHost ? iDrawerHost : null;
        return (iDrawerHost2 != null && iDrawerHost2.isSplashShowing()) || HotSplashActivityKt.isHotSplashShowing;
    }

    public static final Intent buildThirdIntent(SplashOrder splash, String schema, String pkgName) {
        if (schema == null || pkgName == null || splash == null) {
            return null;
        }
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        IAdInfo adInfo = ExtSplashOrderKt.adInfo(splash);
        String appLinkRpl = gAdReport.replaceDirect(schema, adInfo != null ? adInfo.getReportInfo() : null, (Motion) null);
        return getThirdAppIntent(BiliContext.application(), pkgName, appLinkRpl);
    }

    private static final Intent getThirdAppIntent(Context context, String pkgName, String uri) {
        PackageManager packageManager;
        if (context != null && !StringsKt.isBlank(pkgName)) {
            String str = uri;
            if ((str == null || StringsKt.isBlank(str)) || (packageManager = context.getPackageManager()) == null) {
                return null;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setPackage(pkgName);
            intent.setData(Uri.parse(uri));
            intent.addFlags(268435456);
            List list = packageManager.queryIntentActivities(intent, AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR);
            Intrinsics.checkNotNullExpressionValue(list, "queryIntentActivities(...)");
            if (list.isEmpty()) {
                return null;
            }
            return intent;
        }
        return null;
    }

    public static final Uri removeUriParameter(Uri uri, String paramKeyToRemove) {
        Intrinsics.checkNotNullParameter(uri, AudioIntentHelper.ARGS_URI);
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

    public static final boolean isDebug() {
        return ((Boolean) isDebug$delegate.getValue()).booleanValue();
    }
}