package tv.danmaku.bili.httpdns.internal.configs;

import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;

/* compiled from: HttpDnsConfig.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\b¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/httpdns/internal/configs/HttpDnsConfig;", "", "<init>", "()V", "OKHTTP_ENABLED", "", "okhttpEnabled", "getOkhttpEnabled", "()Ljava/lang/Boolean;", "HOST", "", "", "getHOST", "()[Ljava/lang/String;", "[Ljava/lang/String;", ReportEvent.Tag.HOST, "getHost", "()Ljava/lang/String;", "PREFETCH", "getPREFETCH", "prefetch", "getPrefetch", "FF_HTTP_DNS", "ffHttpDns", "getFfHttpDns", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HttpDnsConfig {
    public static final boolean FF_HTTP_DNS = true;
    public static final boolean OKHTTP_ENABLED = true;
    public static final HttpDnsConfig INSTANCE = new HttpDnsConfig();
    private static final String[] HOST = {"app.bilibili.com", "api.bilibili.com"};
    private static final String[] PREFETCH = HOST;

    private HttpDnsConfig() {
    }

    public final Boolean getOkhttpEnabled() {
        return (Boolean) Contract.-CC.get$default(ConfigManager.Companion.ab(), "httpdns_enable", (Object) null, 2, (Object) null);
    }

    public final String[] getHOST() {
        return HOST;
    }

    public final String getHost() {
        return (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "net.httpdns_list", (Object) null, 2, (Object) null);
    }

    public final String[] getPREFETCH() {
        return PREFETCH;
    }

    public final String getPrefetch() {
        return (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "net.httpdns_prefetch", (Object) null, 2, (Object) null);
    }

    public final Boolean getFfHttpDns() {
        return (Boolean) Contract.-CC.get$default(ConfigManager.Companion.ab(), "ff_http_dns", (Object) null, 2, (Object) null);
    }
}