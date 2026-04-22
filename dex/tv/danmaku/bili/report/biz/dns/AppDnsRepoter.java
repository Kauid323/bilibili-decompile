package tv.danmaku.bili.report.biz.dns;

import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.rpc.report.dns.DnsReporter;
import com.bilibili.lib.rpc.track.model.dns.DnsEvent;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.dns.misaka.model.DnsMisakaModel;
import tv.danmaku.bili.report.biz.dns.misaka.sample.DnsMisakaSample;

/* compiled from: AppDnsRepoter.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/report/biz/dns/AppDnsRepoter;", "Lcom/bilibili/lib/rpc/report/dns/DnsReporter;", "<init>", "()V", "report", "", "event", "Lcom/bilibili/lib/rpc/track/model/dns/DnsEvent;", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AppDnsRepoter implements DnsReporter {
    public static final AppDnsRepoter INSTANCE = new AppDnsRepoter();

    private AppDnsRepoter() {
    }

    public void report(DnsEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Pair<Boolean, Float> dnsMisakaSample = DnsMisakaSample.INSTANCE.dnsMisakaSample(event);
        final boolean sample = ((Boolean) dnsMisakaSample.component1()).booleanValue();
        float rate = ((Number) dnsMisakaSample.component2()).floatValue();
        Neurons.trackT$default(false, "ops.misaka.app-httpdns-resolve", DnsMisakaModel.INSTANCE.adapt(event, rate), 0, new Function0() { // from class: tv.danmaku.bili.report.biz.dns.AppDnsRepoter$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean report$lambda$0;
                report$lambda$0 = AppDnsRepoter.report$lambda$0(sample);
                return Boolean.valueOf(report$lambda$0);
            }
        }, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean report$lambda$0(boolean $sample) {
        return $sample;
    }
}