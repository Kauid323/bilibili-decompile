package tv.danmaku.bili.report.biz.api.consume;

import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.rpc.report.HttpReporter;
import com.bilibili.lib.rpc.track.model.CallType;
import com.bilibili.lib.rpc.track.model.NetworkEvent;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.api.consume.consumer.neuron.ApiNeuronAdapter;
import tv.danmaku.bili.report.biz.api.consume.consumer.neuron.ApiNeuronPolicy;
import tv.danmaku.bili.report.biz.api.consume.consumer.track.apm.TrackModelAdapter;
import tv.danmaku.bili.report.biz.api.produce.model.EventsKt;
import tv.danmaku.bili.report.biz.api.track.apm.sample.api.ImageSampleKt;
import tv.danmaku.bili.report.biz.api.track.apm.sample.api.NetSampleKt;
import tv.danmaku.bili.report.platform.neuron.NeuronEventId;

/* compiled from: OkHttpReporter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/report/biz/api/consume/OkHttpReporter;", "Lcom/bilibili/lib/rpc/report/HttpReporter;", "<init>", "()V", "report", "", "event", "Lcom/bilibili/lib/rpc/track/model/NetworkEvent;", "reportApi", "reportImage", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OkHttpReporter implements HttpReporter {
    public void report(NetworkEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!EventsKt.isValid(event)) {
            return;
        }
        if (event.getCallType() == CallType.IMAGE) {
            reportImage(event);
        } else {
            reportApi(event);
        }
    }

    private final void reportApi(NetworkEvent event) {
        if (ApiNeuronPolicy.INSTANCE.shouldReport(event)) {
            Neurons.report$default(false, 5, NeuronEventId.API_ERROR, ApiNeuronAdapter.INSTANCE.adapt(event), (String) null, 0, 48, (Object) null);
        }
        String host = event.getHost();
        Intrinsics.checkNotNullExpressionValue(host, "getHost(...)");
        String path = event.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        String protocol = event.getProtocol();
        Intrinsics.checkNotNullExpressionValue(protocol, "getProtocol(...)");
        Pair<Boolean, Float> netTrackSample = NetSampleKt.netTrackSample(host, path, protocol);
        final boolean sample = ((Boolean) netTrackSample.component1()).booleanValue();
        float rate = ((Number) netTrackSample.component2()).floatValue();
        Neurons.trackNet(TrackModelAdapter.INSTANCE.toNet(event, rate), new Function0() { // from class: tv.danmaku.bili.report.biz.api.consume.OkHttpReporter$$ExternalSyntheticLambda1
            public final Object invoke() {
                boolean reportApi$lambda$0;
                reportApi$lambda$0 = OkHttpReporter.reportApi$lambda$0(sample);
                return Boolean.valueOf(reportApi$lambda$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean reportApi$lambda$0(boolean $sample) {
        return $sample;
    }

    private final void reportImage(NetworkEvent event) {
        String host = event.getHost();
        Intrinsics.checkNotNullExpressionValue(host, "getHost(...)");
        String path = event.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        Pair<Boolean, Float> imageTrackSample = ImageSampleKt.imageTrackSample(host, path);
        final boolean sample = ((Boolean) imageTrackSample.component1()).booleanValue();
        float rate = ((Number) imageTrackSample.component2()).floatValue();
        Neurons.trackImage(TrackModelAdapter.INSTANCE.toImageoNet(event, rate), new Function0() { // from class: tv.danmaku.bili.report.biz.api.consume.OkHttpReporter$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean reportImage$lambda$0;
                reportImage$lambda$0 = OkHttpReporter.reportImage$lambda$0(sample);
                return Boolean.valueOf(reportImage$lambda$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean reportImage$lambda$0(boolean $sample) {
        return $sample;
    }
}