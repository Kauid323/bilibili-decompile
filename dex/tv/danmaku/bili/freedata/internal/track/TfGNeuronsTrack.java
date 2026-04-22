package tv.danmaku.bili.freedata.internal.track;

import com.bilibili.gripper.api.neuron.GNeurons;
import com.bilibili.lib.rpc.track.model.NetworkEvent;
import com.bilibili.lib.tf.TfActivateEvent;
import com.bilibili.lib.tf.TfSwitchEvent;
import com.bilibili.lib.tf.TfTrack;
import com.bilibili.lib.tf.TfTransformEvent;
import com.bilibili.lib.tf.TfTypeExt;
import com.bilibili.lib.tf.freedata.util.log.TfLog;
import java.nio.ByteBuffer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.api.consume.consumer.track.apm.TrackModelAdapter;
import tv.danmaku.bili.report.biz.api.produce.model.EventsKt;
import tv.danmaku.bili.report.biz.api.track.apm.sample.api.NetSampleKt;

/* compiled from: TfTrack.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0017J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0017J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0011H\u0017J\u0012\u0010\u0012\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0013H\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/freedata/internal/track/TfGNeuronsTrack;", "Lcom/bilibili/lib/tf/TfTrack;", "neurons", "Lcom/bilibili/gripper/api/neuron/GNeurons;", "<init>", "(Lcom/bilibili/gripper/api/neuron/GNeurons;)V", "getNeurons", "()Lcom/bilibili/gripper/api/neuron/GNeurons;", "setNeurons", "trackActivate", "", "event", "Lcom/bilibili/lib/tf/TfActivateEvent;", "trackNetwork", "eventByteBuffer", "Ljava/nio/ByteBuffer;", "trackSwitch", "Lcom/bilibili/lib/tf/TfSwitchEvent;", "trackTransform", "Lcom/bilibili/lib/tf/TfTransformEvent;", "network-ignet-ctr_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TfGNeuronsTrack extends TfTrack {
    private GNeurons neurons;

    public TfGNeuronsTrack(GNeurons neurons) {
        Intrinsics.checkNotNullParameter(neurons, "neurons");
        this.neurons = neurons;
    }

    public final GNeurons getNeurons() {
        return this.neurons;
    }

    public final void setNeurons(GNeurons gNeurons) {
        Intrinsics.checkNotNullParameter(gNeurons, "<set-?>");
        this.neurons = gNeurons;
    }

    public void trackActivate(TfActivateEvent event) {
        if (event != null) {
            Pair[] pairArr = new Pair[4];
            pairArr[0] = TuplesKt.to("order", event.getIsSuccess() ? "success" : "failure");
            pairArr[1] = TuplesKt.to("method", event.getIsAuto() ? "auto" : "manual");
            pairArr[2] = TuplesKt.to("data", event.getRawStatus());
            TfTypeExt typeExt = event.getTypeExt();
            Intrinsics.checkNotNullExpressionValue(typeExt, "getTypeExt(...)");
            pairArr[3] = TuplesKt.to("type", TfTrackModelAdapterKt.getTypeString(typeExt));
            Map extra = MapsKt.mapOf(pairArr);
            GNeurons.-CC.trackT$default(this.neurons, true, "public.bandwidth.activation.track", extra, 0, new Function0() { // from class: tv.danmaku.bili.freedata.internal.track.TfGNeuronsTrack$$ExternalSyntheticLambda2
                public final Object invoke() {
                    boolean trackActivate$lambda$0;
                    trackActivate$lambda$0 = TfGNeuronsTrack.trackActivate$lambda$0();
                    return Boolean.valueOf(trackActivate$lambda$0);
                }
            }, 8, (Object) null);
            return;
        }
        TfLog.Companion.e("tf.app.track", "trackActivate event=null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean trackActivate$lambda$0() {
        return true;
    }

    public void trackNetwork(ByteBuffer eventByteBuffer) {
        if (eventByteBuffer == null) {
            TfLog.Companion.e("tf.app.track", "trackNetwork eventByteBuffer=null");
            return;
        }
        try {
            NetworkEvent event = NetworkEvent.parseFrom(eventByteBuffer);
            Intrinsics.checkNotNull(event);
            if (!EventsKt.isValid(event)) {
                TfLog.Companion.e("tf.app.track", "trackNetwork event invalid");
            } else {
                String host = event.getHost();
                Intrinsics.checkNotNullExpressionValue(host, "getHost(...)");
                String path = event.getPath();
                Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                String protocol = event.getProtocol();
                Intrinsics.checkNotNullExpressionValue(protocol, "getProtocol(...)");
                Pair<Boolean, Float> netTrackSample = NetSampleKt.netTrackSample(host, path, protocol);
                final boolean sample = ((Boolean) netTrackSample.component1()).booleanValue();
                float rate = ((Number) netTrackSample.component2()).floatValue();
                this.neurons.trackNet(TrackModelAdapter.INSTANCE.toNet(event, rate), new Function0() { // from class: tv.danmaku.bili.freedata.internal.track.TfGNeuronsTrack$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        boolean trackNetwork$lambda$0;
                        trackNetwork$lambda$0 = TfGNeuronsTrack.trackNetwork$lambda$0(sample);
                        return Boolean.valueOf(trackNetwork$lambda$0);
                    }
                });
            }
        } catch (Exception e) {
            TfLog.Companion.e("tf.app.track", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean trackNetwork$lambda$0(boolean $sample) {
        return $sample;
    }

    public void trackSwitch(TfSwitchEvent event) {
        if (event != null) {
            TfTypeExt typeExt = event.getTypeExt();
            Intrinsics.checkNotNullExpressionValue(typeExt, "getTypeExt(...)");
            Map extra = MapsKt.mapOf(new Pair[]{TuplesKt.to("type", TfTrackModelAdapterKt.getTypeString(typeExt)), TuplesKt.to("enabled", String.valueOf(event.getEnabled()))});
            GNeurons.-CC.trackT$default(this.neurons, true, "public.bandwidth.switch.track", extra, 0, new Function0() { // from class: tv.danmaku.bili.freedata.internal.track.TfGNeuronsTrack$$ExternalSyntheticLambda3
                public final Object invoke() {
                    boolean trackSwitch$lambda$0;
                    trackSwitch$lambda$0 = TfGNeuronsTrack.trackSwitch$lambda$0();
                    return Boolean.valueOf(trackSwitch$lambda$0);
                }
            }, 8, (Object) null);
            return;
        }
        TfLog.Companion.e("tf.app.track", "trackSwitch event=null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean trackSwitch$lambda$0() {
        return true;
    }

    public void trackTransform(TfTransformEvent event) {
        if (event != null) {
            if (event.getIsAuto()) {
                return;
            }
            Pair[] pairArr = new Pair[9];
            pairArr[0] = TuplesKt.to("resource", event.getResource().name());
            pairArr[1] = TuplesKt.to("originURL", event.getUrl());
            pairArr[2] = TuplesKt.to("error", String.valueOf(event.getCode().getNumber()));
            pairArr[3] = TuplesKt.to("message", event.getMessage());
            pairArr[4] = TuplesKt.to("resultURL", event.getOutUrl());
            TfTypeExt typeExt = event.getTypeExt();
            Intrinsics.checkNotNullExpressionValue(typeExt, "getTypeExt(...)");
            pairArr[5] = TuplesKt.to("type", TfTrackModelAdapterKt.getTypeString(typeExt));
            pairArr[6] = TuplesKt.to("method", event.getMethod().name());
            pairArr[7] = TuplesKt.to("is_tf", event.getTf() ? "true" : "false");
            pairArr[8] = TuplesKt.to("is_auto", event.getIsAuto() ? "true" : "false");
            Map extra = MapsKt.mapOf(pairArr);
            GNeurons.-CC.trackT$default(this.neurons, true, "public.bandwidth.transform.track", extra, 0, new Function0() { // from class: tv.danmaku.bili.freedata.internal.track.TfGNeuronsTrack$$ExternalSyntheticLambda1
                public final Object invoke() {
                    boolean trackTransform$lambda$0;
                    trackTransform$lambda$0 = TfGNeuronsTrack.trackTransform$lambda$0();
                    return Boolean.valueOf(trackTransform$lambda$0);
                }
            }, 8, (Object) null);
            return;
        }
        TfLog.Companion.e("tf.app.track", "trackTransform event=null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean trackTransform$lambda$0() {
        return true;
    }
}