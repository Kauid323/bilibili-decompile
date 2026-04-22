package tv.danmaku.bili.httpdns.api.impl.java;

import bolts.Task;
import com.bilibili.api.base.util.NetworkManager;
import com.bilibili.httpdns.HttpDNSManager;
import com.bilibili.lib.httpdns.CacheEntry;
import com.bilibili.lib.httpdns.DNSRecord;
import com.bilibili.lib.httpdns.HttpDNS;
import com.bilibili.lib.httpdns.Params;
import com.bilibili.lib.rpc.track.model.dns.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dns;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.httpdns.api.ConstsKt;
import tv.danmaku.bili.httpdns.api.HttpDns;
import tv.danmaku.bili.httpdns.internal.configs.HttpDnsConfig;
import tv.danmaku.bili.httpdns.internal.host.ParseKt;
import tv.danmaku.bili.httpdns.internal.track.JavaDnsTrack;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.report.biz.httpdns.HttpDnsReporter;

/* compiled from: JavaHolder.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0016\u0010\u0011\u001a\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H\u0016J\b\u0010\u0014\u001a\u00020\fH\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001e\u0018\u00010\u001dJ\u0013\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050 H\u0002¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050 H\u0002¢\u0006\u0002\u0010!J\b\u0010#\u001a\u00020\u000eH\u0002J\u0010\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u000eH\u0016J\b\u0010&\u001a\u00020\u000eH\u0016J\n\u0010'\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010(\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006*"}, d2 = {"Ltv/danmaku/bili/httpdns/api/impl/java/JavaHolder;", "Ltv/danmaku/bili/httpdns/api/HttpDns;", "<init>", "()V", "TAG", "", "provider", "getProvider", "()Ljava/lang/String;", "setProvider", "(Ljava/lang/String;)V", "init", "", "enabled", "", "contains", ReportEvent.Tag.HOST, "add", "hosts", "", "prefetch", "resolve", "Lokhttp3/Dns$Record;", "fallback", "hit", "clearCache", "applyIPv6Policy", "record", "getCache", "Ljava/util/HashMap;", "Ljava/util/ArrayList;", "initHost", "", "()[Ljava/lang/String;", "prefetchHost", "aliProvider", "runtimeEnable", "enable", "isRuntimeEnable", "getRuntimeProvider", "setRuntimeProvider", "getClientIp", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class JavaHolder implements HttpDns {
    private static final String TAG = "httpdns.holder.java";
    public static String provider;
    public static final JavaHolder INSTANCE = new JavaHolder();
    public static final int $stable = 8;

    private JavaHolder() {
    }

    public final String getProvider() {
        String str = provider;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("provider");
        return null;
    }

    public final void setProvider(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        provider = str;
    }

    @Override // tv.danmaku.bili.httpdns.api.HttpDns
    public void init() {
        boolean ali = aliProvider();
        setProvider(ali ? ConstsKt.SP_ALI : ConstsKt.SP_TENCENT);
        HttpDNS.initialize(new Params.Builder().manager(new HttpDNSManager(HttpDnsReporter.newInstance(), ali)).executor(NetworkManager.getNetWorkExecutor()).hosts(initHost()).build());
        BLog.ifmt(TAG, "Init java httpdns with provider %s.", getProvider());
    }

    @Override // tv.danmaku.bili.httpdns.api.HttpDns
    public boolean enabled() {
        return true;
    }

    @Override // tv.danmaku.bili.httpdns.api.HttpDns
    public String provider() {
        return getProvider();
    }

    @Override // tv.danmaku.bili.httpdns.api.HttpDns
    public boolean contains(String host) {
        List hosts;
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        HttpDNS httpDNS = HttpDNS.getInstance();
        if (httpDNS == null || (hosts = httpDNS.getHosts()) == null) {
            return false;
        }
        return hosts.contains(host);
    }

    @Override // tv.danmaku.bili.httpdns.api.HttpDns
    public void add(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "hosts");
        HttpDNS httpDNS = HttpDNS.getInstance();
        if (httpDNS != null) {
            httpDNS.addHosts(list);
        }
    }

    @Override // tv.danmaku.bili.httpdns.api.HttpDns
    public void prefetch() {
        final HttpDNS it = HttpDNS.getInstance();
        if (it != null) {
            Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.httpdns.api.impl.java.JavaHolder$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Boolean prefetch$lambda$0$0;
                    prefetch$lambda$0$0 = JavaHolder.prefetch$lambda$0$0(it);
                    return prefetch$lambda$0$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean prefetch$lambda$0$0(HttpDNS $it) {
        String[] hosts = INSTANCE.prefetchHost();
        $it.addHosts(new ArrayList(Arrays.asList(Arrays.copyOf(hosts, hosts.length))));
        $it.prefetch(hosts);
        return true;
    }

    @Override // tv.danmaku.bili.httpdns.api.HttpDns
    public Dns.Record resolve(String host) {
        List emptyList;
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        HttpDNS it = HttpDNS.getInstance();
        if (it != null) {
            CacheEntry cacheEntry = it.resolve(host);
            DNSRecord record = cacheEntry != null ? (DNSRecord) cacheEntry.get() : null;
            boolean hit = record != null;
            long ttl = record != null ? record.ttl : 0L;
            if (record == null || (emptyList = record.ips) == null) {
                emptyList = CollectionsKt.emptyList();
            }
            List ips = emptyList;
            JavaDnsTrack.INSTANCE.onResolve(host, Source.HTTPDNS_JAVA, INSTANCE.provider(), hit, ttl, ips, false, ConstsKt.TAG_OKHTTP);
            return it.handleCacheRecord(host, cacheEntry);
        }
        return null;
    }

    @Override // tv.danmaku.bili.httpdns.api.HttpDns
    public Dns.Record fallback(String host) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        return null;
    }

    @Override // tv.danmaku.bili.httpdns.api.HttpDns
    public boolean hit(String host) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        HttpDNS it = HttpDNS.getInstance();
        return (it == null || it.resolve(host) == null) ? false : true;
    }

    @Override // tv.danmaku.bili.httpdns.api.HttpDns
    public void clearCache() {
        HttpDNS httpDNS = HttpDNS.getInstance();
        if (httpDNS != null) {
            httpDNS.clearCache();
        }
    }

    @Override // tv.danmaku.bili.httpdns.api.HttpDns
    public Dns.Record applyIPv6Policy(Dns.Record record) {
        return record;
    }

    public final HashMap<String, ArrayList<String>> getCache() {
        HttpDNS httpDNS = HttpDNS.getInstance();
        if (httpDNS != null) {
            return httpDNS.getCache();
        }
        return null;
    }

    private final String[] initHost() {
        Collection parse = ParseKt.parse(HttpDnsConfig.INSTANCE.getHost());
        if (parse != null) {
            Collection $this$toTypedArray$iv = parse;
            String[] strArr = (String[]) $this$toTypedArray$iv.toArray(new String[0]);
            if (strArr != null) {
                return strArr;
            }
        }
        return HttpDnsConfig.INSTANCE.getHOST();
    }

    private final String[] prefetchHost() {
        Collection parse = ParseKt.parse(HttpDnsConfig.INSTANCE.getPrefetch());
        if (parse != null) {
            Collection $this$toTypedArray$iv = parse;
            String[] strArr = (String[]) $this$toTypedArray$iv.toArray(new String[0]);
            if (strArr != null) {
                return strArr;
            }
        }
        return HttpDnsConfig.INSTANCE.getPREFETCH();
    }

    private final boolean aliProvider() {
        Boolean ffHttpDns = HttpDnsConfig.INSTANCE.getFfHttpDns();
        if (ffHttpDns != null) {
            return ffHttpDns.booleanValue();
        }
        return true;
    }

    @Override // tv.danmaku.bili.httpdns.api.HttpDns
    public void runtimeEnable(boolean enable) {
    }

    @Override // tv.danmaku.bili.httpdns.api.HttpDns
    public boolean isRuntimeEnable() {
        return true;
    }

    @Override // tv.danmaku.bili.httpdns.api.HttpDns
    public String getRuntimeProvider() {
        return getProvider();
    }

    @Override // tv.danmaku.bili.httpdns.api.HttpDns
    public void setRuntimeProvider(String provider2) {
        Intrinsics.checkNotNullParameter(provider2, "provider");
    }

    @Override // tv.danmaku.bili.httpdns.api.HttpDns
    public String getClientIp() {
        return "";
    }
}