package kntr.base.net.comm;

import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FFProxy.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J\b\u0010\f\u001a\u0004\u0018\u00010\u0006J\b\u0010\r\u001a\u0004\u0018\u00010\u0006J\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006J\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\u0010\u001a\u00020\nH\u0007R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lkntr/base/net/comm/ProxyConfigManager;", "", "<init>", "()V", "currentHeaders", "", "", "isFFProxyEnabled", "", "updateConfig", "", "headers", "getProxyId", "getProxyEnv", "getProxyColor", "getExtraHeaders", "clearConfig", "PROXY_HOST", "TARGET_HOST_HEADER", "PROXY_ID_HEADER", "PROXY_ENV_HEADER", "PROXY_COLOR_HEADER", "PROXY_HEADERS", "ffproxy_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ProxyConfigManager {
    public static final ProxyConfigManager INSTANCE = new ProxyConfigManager();
    public static final String PROXY_COLOR_HEADER = "x1-bilispy-color";
    public static final String PROXY_ENV_HEADER = "x-ff-proxy-env";
    public static final String PROXY_HEADERS = "x-ff-headers";
    public static final String PROXY_HOST = "ff-proxy.bilibili.com";
    public static final String PROXY_ID_HEADER = "x-ff-proxy-id";
    public static final String TARGET_HOST_HEADER = "x-ff-proxy-target-host";
    private static Map<String, String> currentHeaders;
    private static boolean isFFProxyEnabled;

    private ProxyConfigManager() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0041, code lost:
        if (r0 == false) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateConfig(Map<String, String> map) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(map, "headers");
        currentHeaders = map;
        String str = map.get(PROXY_ID_HEADER);
        boolean z3 = true;
        if (str != null) {
            if (str.length() > 0) {
                z = true;
                if (z) {
                    String str2 = map.get(PROXY_ENV_HEADER);
                    if (str2 != null) {
                        if (str2.length() > 0) {
                            z2 = true;
                        }
                    }
                    z2 = false;
                }
                z3 = false;
                isFFProxyEnabled = z3;
            }
        }
        z = false;
        if (z) {
        }
        z3 = false;
        isFFProxyEnabled = z3;
    }

    public final String getProxyId() {
        Map<String, String> map = currentHeaders;
        if (map != null) {
            return map.get(PROXY_ID_HEADER);
        }
        return null;
    }

    public final String getProxyEnv() {
        Map<String, String> map = currentHeaders;
        if (map != null) {
            return map.get(PROXY_ENV_HEADER);
        }
        return null;
    }

    public final String getProxyColor() {
        Map<String, String> map = currentHeaders;
        if (map != null) {
            return map.get(PROXY_COLOR_HEADER);
        }
        return null;
    }

    public final String getExtraHeaders() {
        Map<String, String> map = currentHeaders;
        if (map != null) {
            return map.get(PROXY_HEADERS);
        }
        return null;
    }

    public final boolean isFFProxyEnabled() {
        return isFFProxyEnabled;
    }

    public final void clearConfig() {
        currentHeaders = null;
        isFFProxyEnabled = false;
    }
}