package tv.danmaku.bili.httpdns.internal.track;

import com.bilibili.base.BiliContext;
import com.bilibili.lib.rpc.track.model.dns.DnsEvent;
import com.bilibili.lib.rpc.track.model.dns.Event;
import com.bilibili.lib.rpc.track.model.dns.Source;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.report.biz.dns.AppDnsRepoter;

/* compiled from: JavaDnsTrack.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JV\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/httpdns/internal/track/JavaDnsTrack;", "", "<init>", "()V", "consumer", "Ltv/danmaku/bili/report/biz/dns/AppDnsRepoter;", "getConsumer", "()Ltv/danmaku/bili/report/biz/dns/AppDnsRepoter;", "onResolve", "", ReportEvent.Tag.HOST, "", "source", "Lcom/bilibili/lib/rpc/track/model/dns/Source;", "provider", "hit", "", "ttl", "", "ips", "", "fallback", AppConfig.HOST_TAG, "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class JavaDnsTrack {
    public static final JavaDnsTrack INSTANCE = new JavaDnsTrack();
    private static final AppDnsRepoter consumer = AppDnsRepoter.INSTANCE;

    private JavaDnsTrack() {
    }

    public final AppDnsRepoter getConsumer() {
        return consumer;
    }

    public final void onResolve(String host, Source source, String provider, boolean hit, long ttl, List<String> list, boolean fallback, String tag) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(list, "ips");
        Intrinsics.checkNotNullParameter(tag, AppConfig.HOST_TAG);
        DnsEvent.Builder $this$onResolve_u24lambda_u240 = DnsEvent.newBuilder();
        $this$onResolve_u24lambda_u240.setEvent(Event.RESOLVE);
        $this$onResolve_u24lambda_u240.setResolveHost(host);
        $this$onResolve_u24lambda_u240.setSource(source);
        $this$onResolve_u24lambda_u240.setProvider(provider);
        $this$onResolve_u24lambda_u240.setResolveHit(hit);
        $this$onResolve_u24lambda_u240.setResolveTtl(ttl);
        $this$onResolve_u24lambda_u240.addAllResolveIps(list);
        $this$onResolve_u24lambda_u240.setResolveFallback(fallback);
        $this$onResolve_u24lambda_u240.setResolveTag(tag);
        $this$onResolve_u24lambda_u240.setProcess(BiliContext.currentProcessName());
        $this$onResolve_u24lambda_u240.setThread(Thread.currentThread().getName());
    }
}