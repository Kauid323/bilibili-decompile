package tv.danmaku.bili.ui.main.deeplink;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Base64;
import com.bilibili.api.BiliApiException;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import com.bilibili.lib.foundation.Foundation;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.video.main.UtilKt;

/* compiled from: RedirectDeeplinkHelper.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0012\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0012\u0010\u0019\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J7\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052#\u0010\u001d\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u001b0\u001eH\u0007J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050#H\u0002J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050#H\u0002J\u0006\u0010%\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006&"}, d2 = {"Ltv/danmaku/bili/ui/main/deeplink/RedirectDeeplinkHelper;", "", "<init>", "()V", "TAG", "", "DIRECT_QUERY", "H5_AWAKEN_PARAM", "DEFAULT_PREFIX", "OPEN_APP_FROM_TYPE", "DEFAULT_OPEN_TYPE", "OVER_TIME_ERROR_CODE", "", "EVENT_ID", "isFirstDeepLinkRequest", "", "originUrl", "getOriginUrl", "()Ljava/lang/String;", "setOriginUrl", "(Ljava/lang/String;)V", "canDirect", AudioIntentHelper.ARGS_URI, "Landroid/net/Uri;", "hitSpmid", "hitOpenType", "fetchRedirectDeeplink", "", "origin", "onResult", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "result", "getDirectPrefixListConfig", "", "getRedirectOpenType", "directDeeplinkEnable", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RedirectDeeplinkHelper {
    private static final String DEFAULT_OPEN_TYPE = "and,ios";
    private static final String DEFAULT_PREFIX = "out_open_deeplink_";
    private static final String DIRECT_QUERY = "from_spmid";
    private static final String EVENT_ID = "app.active.growth_deeplink.sys";
    private static final String H5_AWAKEN_PARAM = "h5awaken";
    private static final String OPEN_APP_FROM_TYPE = "open_app_from_type";
    private static final int OVER_TIME_ERROR_CODE = 77400;
    private static final String TAG = "RedirectDeeplinkHelper";
    public static final RedirectDeeplinkHelper INSTANCE = new RedirectDeeplinkHelper();
    private static boolean isFirstDeepLinkRequest = true;
    private static String originUrl = "";
    public static final int $stable = 8;

    private RedirectDeeplinkHelper() {
    }

    public final String getOriginUrl() {
        return originUrl;
    }

    public final void setOriginUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        originUrl = str;
    }

    @JvmStatic
    public static final boolean canDirect(Uri uri) {
        if (uri == null || !INSTANCE.directDeeplinkEnable()) {
            UtilKt.deepLinkTrack("deeplink direct disable.");
            return false;
        } else if (!hitSpmid(uri) && !hitOpenType(uri)) {
            return false;
        } else {
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
        if ((r3.length() > 0) != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009b A[RETURN] */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean hitSpmid(Uri uri) {
        boolean hitSpmid;
        String it;
        if (uri != null && (it = uri.getQueryParameter("from_spmid")) != null) {
        }
        String it2 = null;
        if (it2 != null) {
            String spmid = it2.length() > 0 ? it2 : null;
            if (spmid != null) {
                Iterable $this$any$iv = INSTANCE.getDirectPrefixListConfig();
                if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                    Iterator<T> it3 = $this$any$iv.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            Object element$iv = it3.next();
                            String it4 = (String) element$iv;
                            if ((it4.length() > 0) && StringsKt.startsWith$default(spmid, it4, false, 2, (Object) null)) {
                                it = 1;
                                continue;
                            } else {
                                it = null;
                                continue;
                            }
                            if (it != null) {
                                hitSpmid = true;
                                break;
                            }
                        } else {
                            hitSpmid = false;
                            break;
                        }
                    }
                } else {
                    hitSpmid = false;
                }
                UtilKt.deepLinkTrack("deeplink direct hit fromSpmid: " + hitSpmid);
                return !hitSpmid;
            }
        }
        hitSpmid = false;
        UtilKt.deepLinkTrack("deeplink direct hit fromSpmid: " + hitSpmid);
        if (!hitSpmid) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00da A[SYNTHETIC] */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean hitOpenType(Uri uri) {
        String it;
        String it2;
        String it3;
        boolean hitOpenType = false;
        if (uri != null && (it = uri.getQueryParameter(H5_AWAKEN_PARAM)) != null) {
            if (!(it.length() > 0)) {
                it = null;
            }
            if (it != null) {
                try {
                    byte[] decode = Base64.decode(it, 0);
                    Intrinsics.checkNotNullExpressionValue(decode, "decode(...)");
                    it2 = new String(decode, Charsets.UTF_8);
                } catch (Exception e) {
                    it2 = "";
                }
                String it4 = it2.length() > 0 ? it2 : null;
                if (it4 != null) {
                    String h5AwakenDecode = it4;
                    String decodeUrl = uri + "&" + h5AwakenDecode;
                    UtilKt.deepLinkTrack("deeplink decode url: " + decodeUrl);
                    String openType = Uri.parse(decodeUrl).getQueryParameter(OPEN_APP_FROM_TYPE);
                    Iterable $this$any$iv = INSTANCE.getRedirectOpenType();
                    if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                        Iterator<T> it5 = $this$any$iv.iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                break;
                            }
                            Object element$iv = it5.next();
                            String it6 = (String) element$iv;
                            if (it6.length() > 0) {
                                if (openType != null && StringsKt.contains(openType, it6, true)) {
                                    it3 = 1;
                                    continue;
                                    if (it3 != null) {
                                        hitOpenType = true;
                                        break;
                                    }
                                }
                            }
                            it3 = null;
                            continue;
                            if (it3 != null) {
                            }
                        }
                    }
                    UtilKt.deepLinkTrack("deeplink direct hit open_app_from_type: " + hitOpenType);
                    return hitOpenType;
                }
            }
        }
        return false;
    }

    @JvmStatic
    public static final void fetchRedirectDeeplink(final String origin, final Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onResult");
        UtilKt.deepLinkTrack("start fetch direct deeplink, origin: " + origin);
        final long start = SystemClock.elapsedRealtime();
        long firstLaunchTimeStamp = EnvironmentManager.getInstance().getFirstRunTime() * 1000;
        isFirstDeepLinkRequest = false;
        ((DirectDeeplinkApi) ServiceGenerator.createService(DirectDeeplinkApi.class)).fetchRedirectDeeplink(origin, firstLaunchTimeStamp).enqueue(new BiliApiDataCallback<RedirectDeeplink>() { // from class: tv.danmaku.bili.ui.main.deeplink.RedirectDeeplinkHelper$fetchRedirectDeeplink$1
            public void onError(Throwable t) {
                function1.invoke(origin);
                UtilKt.deepLinkTrack("fetchRedirectDeeplink error", t == null ? new Throwable() : t);
                BiliApiException biliApiException = t instanceof BiliApiException ? (BiliApiException) t : null;
                boolean isOverTime = biliApiException != null && biliApiException.mCode == 77400;
                Pair[] pairArr = new Pair[4];
                pairArr[0] = TuplesKt.to("deeplink_id", "");
                pairArr[1] = TuplesKt.to("session_id", Foundation.Companion.instance().getApps().getSessionId());
                pairArr[2] = TuplesKt.to("deeplink_type", isOverTime ? "1" : "3");
                pairArr[3] = TuplesKt.to("time", String.valueOf(SystemClock.elapsedRealtime() - start));
                Neurons.report$default(false, 4, "app.active.growth_deeplink.sys", MapsKt.mapOf(pairArr), (String) null, 0, 48, (Object) null);
            }

            public void onDataSuccess(RedirectDeeplink data) {
                function1.invoke(data != null ? data.getDeeplink() : null);
                UtilKt.deepLinkTrack("fetchRedirectDeeplink success, deeplink is " + (data != null ? data.getDeeplink() : null));
                Pair[] pairArr = new Pair[4];
                boolean z = false;
                pairArr[0] = TuplesKt.to("deeplink_id", (data == null || (r2 = data.getDeeplink()) == null) ? "" : "");
                pairArr[1] = TuplesKt.to("session_id", Foundation.Companion.instance().getApps().getSessionId());
                String deeplink = data != null ? data.getDeeplink() : null;
                if (deeplink == null || deeplink.length() == 0) {
                    z = true;
                }
                pairArr[2] = TuplesKt.to("deeplink_type", z ? "2" : "0");
                pairArr[3] = TuplesKt.to("time", String.valueOf(SystemClock.elapsedRealtime() - start));
                Neurons.report$default(false, 4, "app.active.growth_deeplink.sys", MapsKt.mapOf(pairArr), (String) null, 0, 48, (Object) null);
            }
        });
    }

    private final List<String> getDirectPrefixListConfig() {
        List<String> split$default;
        String str = (String) ConfigManager.Companion.config().get("main.direct_deeplink_prefix", DEFAULT_PREFIX);
        return (str == null || (split$default = StringsKt.split$default(str, new String[]{","}, false, 0, 6, (Object) null)) == null) ? CollectionsKt.arrayListOf(new String[]{DEFAULT_PREFIX}) : split$default;
    }

    private final List<String> getRedirectOpenType() {
        Contract config = ConfigManager.Companion.config();
        String str = DEFAULT_OPEN_TYPE;
        String it = (String) config.get("main.redirect_deeplink_open_type", DEFAULT_OPEN_TYPE);
        if (it != null) {
            if (!(it.length() > 0)) {
                it = null;
            }
            if (it != null) {
                str = it;
            }
        }
        String openTypeConfig = str;
        return StringsKt.split$default(openTypeConfig, new String[]{","}, false, 0, 6, (Object) null);
    }

    public final boolean directDeeplinkEnable() {
        return ConfigManager.Companion.isHitFF("ff_direct_deeplink_enable");
    }
}