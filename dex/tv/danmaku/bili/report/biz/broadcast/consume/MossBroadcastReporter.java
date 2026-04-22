package tv.danmaku.bili.report.biz.broadcast.consume;

import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.rpc.report.broadcast.BroadcastReporter;
import com.bilibili.lib.rpc.track.model.broadcast.BroadcastEvent;
import com.bilibili.lib.rpc.track.model.broadcast.Event;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.broadcast.consume.consumer.misaka.apm.model.MisakaModelAdapter;

/* compiled from: MossBroadcastReporter.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/report/biz/broadcast/consume/MossBroadcastReporter;", "Lcom/bilibili/lib/rpc/report/broadcast/BroadcastReporter;", "<init>", "()V", "report", "", "event", "Lcom/bilibili/lib/rpc/track/model/broadcast/BroadcastEvent;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MossBroadcastReporter implements BroadcastReporter {
    public static final int $stable = 0;
    public static final MossBroadcastReporter INSTANCE = new MossBroadcastReporter();

    private MossBroadcastReporter() {
    }

    public void report(BroadcastEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Event event2 = event.getEvent();
        Intrinsics.checkNotNullExpressionValue(event2, "getEvent(...)");
        String targePath = event.getTargePath();
        Intrinsics.checkNotNullExpressionValue(targePath, "getTargePath(...)");
        Pair broadcastMisakaSample = MossBroadcastSamplerKt.broadcastMisakaSample(event2, targePath, event.getShared());
        final boolean sample = ((Boolean) broadcastMisakaSample.component1()).booleanValue();
        float rate = ((Number) broadcastMisakaSample.component2()).floatValue();
        Neurons.trackT$default(false, "ops.misaka.app-broadcast", MisakaModelAdapter.INSTANCE.adapt(event, rate), 0, new Function0() { // from class: tv.danmaku.bili.report.biz.broadcast.consume.MossBroadcastReporter$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean report$lambda$0;
                report$lambda$0 = MossBroadcastReporter.report$lambda$0(sample);
                return Boolean.valueOf(report$lambda$0);
            }
        }, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean report$lambda$0(boolean $sample) {
        return $sample;
    }
}