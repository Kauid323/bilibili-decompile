package kntr.base.proxy;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* compiled from: Proxy.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001\u001a\n\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002¨\u0006\u0003"}, d2 = {"getHttpProxy", "", "getSystemHttpProxy", "proxy_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Proxy_androidKt {
    public static final String getHttpProxy() {
        return getSystemHttpProxy();
    }

    private static final String getSystemHttpProxy() {
        String proxyHost = System.getProperty("http.proxyHost");
        String proxyPort = System.getProperty("http.proxyPort");
        String str = proxyHost;
        boolean z = false;
        if (!(str == null || StringsKt.isBlank(str))) {
            String str2 = proxyPort;
            if (str2 == null || StringsKt.isBlank(str2)) {
                z = true;
            }
            if (!z) {
                return "http://" + proxyHost + ":" + proxyPort + "/";
            }
        }
        return null;
    }
}