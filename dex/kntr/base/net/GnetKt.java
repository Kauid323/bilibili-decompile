package kntr.base.net;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Gnet.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u0006\u0010\b\u001a\u00020\u0001\u001a\u001a\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001\u001a\u001a\u0010\t\u001a\u00020\n*\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"DD_KEY_NEW_INTERCEPTOR", "", "DD_KEY_NEW_PUBLIC_PARAM", "DD_KEY_NEW_INTERCEPTOR_PARAM_HOSTS", "TAG_PREF", "enableNewInterceptor", "", "enableNewPublicParam", "enableNewInterceptorParamHosts", "log", "", "Lkntr/base/net/Request;", "tag", "msg", "Lkntr/base/net/Response;", "net_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class GnetKt {
    public static final String DD_KEY_NEW_INTERCEPTOR = "kn.new.interceptor";
    public static final String DD_KEY_NEW_INTERCEPTOR_PARAM_HOSTS = "kn.new.interceptor.param.hosts";
    public static final String DD_KEY_NEW_PUBLIC_PARAM = "kn.new.net.param";
    public static final String TAG_PREF = "net.";

    public static final boolean enableNewInterceptor() {
        return IPlatformConfig.CC.ff$default(KConfig.INSTANCE, DD_KEY_NEW_INTERCEPTOR, false, 2, null);
    }

    public static final boolean enableNewPublicParam() {
        return IPlatformConfig.CC.ff$default(KConfig.INSTANCE, DD_KEY_NEW_PUBLIC_PARAM, false, 2, null);
    }

    public static final String enableNewInterceptorParamHosts() {
        String config$default = IPlatformConfig.CC.config$default(KConfig.INSTANCE, DD_KEY_NEW_INTERCEPTOR_PARAM_HOSTS, null, 2, null);
        return config$default == null ? "(?:[a-zA-Z0-9-]+\\.)*(bilibili|biliapi|biligame)\\.(com|co|net|tv)" : config$default;
    }

    public static final void log(Request $this$log, String tag, String msg) {
        Intrinsics.checkNotNullParameter($this$log, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        KLog_androidKt.getKLog().v(TAG_PREF + tag, msg);
    }

    public static final void log(Response $this$log, String tag, String msg) {
        Intrinsics.checkNotNullParameter($this$log, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        KLog_androidKt.getKLog().v(TAG_PREF + tag, msg);
    }
}