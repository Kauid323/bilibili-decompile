package tv.danmaku.bili.report.biz.moss;

import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.rpc.report.BizReporter;
import com.bilibili.lib.rpc.report.HttpReporter;
import com.bilibili.lib.rpc.track.model.BizEvent;
import com.bilibili.lib.rpc.track.model.NetworkEvent;
import com.bilibili.lib.rpc.track.model.Tunnel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.api.consume.consumer.track.apm.TrackModelAdapter;
import tv.danmaku.bili.report.biz.api.track.apm.sample.api.NetSampleKt;

/* compiled from: MossReporter.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/report/biz/moss/MossReporter;", "Lcom/bilibili/lib/rpc/report/HttpReporter;", "Lcom/bilibili/lib/rpc/report/BizReporter;", "<init>", "()V", "report", "", "event", "Lcom/bilibili/lib/rpc/track/model/NetworkEvent;", "Lcom/bilibili/lib/rpc/track/model/BizEvent;", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MossReporter implements HttpReporter, BizReporter {
    public static final MossReporter INSTANCE = new MossReporter();

    private MossReporter() {
    }

    public void report(final NetworkEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.hasSample()) {
            if (event.getTunnel() == Tunnel.MOSS_CRONET) {
                String protocol = event.getProtocol();
                Intrinsics.checkNotNullExpressionValue(protocol, "getProtocol(...)");
                if (!StringsKt.isBlank(protocol)) {
                    String host = event.getHost();
                    Intrinsics.checkNotNullExpressionValue(host, "getHost(...)");
                    String path = event.getPath();
                    Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                    String protocol2 = event.getProtocol();
                    Intrinsics.checkNotNullExpressionValue(protocol2, "getProtocol(...)");
                    Pair<Boolean, Float> netTrackSample = NetSampleKt.netTrackSample(host, path, protocol2);
                    final boolean sample = ((Boolean) netTrackSample.component1()).booleanValue();
                    float rate = ((Number) netTrackSample.component2()).floatValue();
                    Neurons.trackNet(TrackModelAdapter.INSTANCE.toNet(event, rate), new Function0() { // from class: tv.danmaku.bili.report.biz.moss.MossReporter$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            boolean report$lambda$0;
                            report$lambda$0 = MossReporter.report$lambda$0(sample);
                            return Boolean.valueOf(report$lambda$0);
                        }
                    });
                    return;
                }
            }
            Neurons.trackNet(TrackModelAdapter.INSTANCE.toNet(event, event.getSample().getRate()), new Function0() { // from class: tv.danmaku.bili.report.biz.moss.MossReporter$$ExternalSyntheticLambda1
                public final Object invoke() {
                    boolean report$lambda$1;
                    report$lambda$1 = MossReporter.report$lambda$1(event);
                    return Boolean.valueOf(report$lambda$1);
                }
            });
            return;
        }
        String host2 = event.getHost();
        Intrinsics.checkNotNullExpressionValue(host2, "getHost(...)");
        String path2 = event.getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
        String protocol3 = event.getProtocol();
        Intrinsics.checkNotNullExpressionValue(protocol3, "getProtocol(...)");
        Pair<Boolean, Float> netTrackSample2 = NetSampleKt.netTrackSample(host2, path2, protocol3);
        final boolean sample2 = ((Boolean) netTrackSample2.component1()).booleanValue();
        float rate2 = ((Number) netTrackSample2.component2()).floatValue();
        Neurons.trackNet(TrackModelAdapter.INSTANCE.toNet(event, rate2), new Function0() { // from class: tv.danmaku.bili.report.biz.moss.MossReporter$$ExternalSyntheticLambda2
            public final Object invoke() {
                boolean report$lambda$2;
                report$lambda$2 = MossReporter.report$lambda$2(sample2);
                return Boolean.valueOf(report$lambda$2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean report$lambda$0(boolean $sample) {
        return $sample;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean report$lambda$1(NetworkEvent $event) {
        return $event.getSample().getSample();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean report$lambda$2(boolean $sample) {
        return $sample;
    }

    public void report(BizEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }
}