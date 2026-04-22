package tv.danmaku.bili.httpdns.api;

import java.util.List;
import kotlin.Metadata;
import okhttp3.Dns;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;

/* compiled from: HttpDns.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H&J\u0016\u0010\n\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fH&J\b\u0010\r\u001a\u00020\u0003H&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\u0007H&J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\u0007H&J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H&J\b\u0010\u0012\u001a\u00020\u0003H&J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fH&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0005H&J\b\u0010\u0017\u001a\u00020\u0005H&J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\u001a\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/httpdns/api/HttpDns;", "", "init", "", "enabled", "", "provider", "", "contains", ReportEvent.Tag.HOST, "add", "hosts", "", "prefetch", "resolve", "Lokhttp3/Dns$Record;", "fallback", "hit", "clearCache", "applyIPv6Policy", "record", "runtimeEnable", "enable", "isRuntimeEnable", "getRuntimeProvider", "setRuntimeProvider", "getClientIp", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface HttpDns {
    void add(List<String> list);

    Dns.Record applyIPv6Policy(Dns.Record record);

    void clearCache();

    boolean contains(String str);

    boolean enabled();

    Dns.Record fallback(String str);

    String getClientIp();

    String getRuntimeProvider();

    boolean hit(String str);

    void init();

    boolean isRuntimeEnable();

    void prefetch();

    String provider();

    Dns.Record resolve(String str);

    void runtimeEnable(boolean z);

    void setRuntimeProvider(String str);
}