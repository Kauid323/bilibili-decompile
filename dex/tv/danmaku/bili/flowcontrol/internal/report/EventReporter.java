package tv.danmaku.bili.flowcontrol.internal.report;

import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.rpc.flowcontrol.FlowControlReporter;
import com.bilibili.lib.rpc.track.model.flowcontrol.Event;
import com.bilibili.lib.rpc.track.model.flowcontrol.FlowControlEvent;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.flowcontrol.internal.report.sample.FlowControlSamplerKt;

/* compiled from: EventReporter.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/flowcontrol/internal/report/EventReporter;", "Lcom/bilibili/lib/rpc/flowcontrol/FlowControlReporter;", "<init>", "()V", "report", "", "event", "Lcom/bilibili/lib/rpc/track/model/flowcontrol/FlowControlEvent;", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class EventReporter implements FlowControlReporter {
    public void report(FlowControlEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Event event2 = event.getEvent();
        Intrinsics.checkNotNullExpressionValue(event2, "getEvent(...)");
        Pair<Boolean, Float> flowControlSample = FlowControlSamplerKt.flowControlSample(event2);
        final boolean sample = ((Boolean) flowControlSample.component1()).booleanValue();
        float rate = ((Number) flowControlSample.component2()).floatValue();
        Neurons.trackT$default(false, "net.flowcontrol.tracker", ModelAdapter.INSTANCE.adapt(event, rate), 0, new Function0() { // from class: tv.danmaku.bili.flowcontrol.internal.report.EventReporter$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean report$lambda$0;
                report$lambda$0 = EventReporter.report$lambda$0(sample);
                return Boolean.valueOf(report$lambda$0);
            }
        }, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean report$lambda$0(boolean $sample) {
        return $sample;
    }
}