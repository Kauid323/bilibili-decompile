package tv.danmaku.bili.splash.ad.utils;

import android.net.NetworkInfo;
import com.bilibili.base.BiliContext;
import com.bilibili.base.connectivity.Connectivity;
import kotlin.Metadata;
import tv.danmaku.android.ConnectivityManagerHelper;
import tv.danmaku.bili.BR;

/* compiled from: NetworkUtils.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\b\u0010\u0002\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"isWifiConnected", "", "isMobileConnected", "NETWORK_TYPE_WIFI", "", "NETWORK_TYPE_MOBILE", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NetworkUtilsKt {
    public static final String NETWORK_TYPE_MOBILE = "mobile";
    public static final String NETWORK_TYPE_WIFI = "wifi";

    public static final boolean isWifiConnected() {
        return Connectivity.isConnected(Connectivity.getWifiNetworkInfo(BiliContext.application()));
    }

    public static final boolean isMobileConnected() {
        NetworkInfo info = Connectivity.getActiveNetworkInfo(BiliContext.application());
        if (info == null || !ConnectivityManagerHelper.isActiveNetworkMetered(BiliContext.application())) {
            return false;
        }
        int networkClass = ConnectivityManagerHelper.getNetworkClass(info.getSubtype());
        return networkClass == 3 || networkClass == 4;
    }
}