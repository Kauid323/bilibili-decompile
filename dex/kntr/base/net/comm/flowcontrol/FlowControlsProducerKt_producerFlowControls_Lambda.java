package kntr.base.net.comm.flowcontrol;

import com.bilibili.lib.gripper.api.internal.ProducerBase;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.GFlowControls;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: FlowControlsProducerKt_producerFlowControls_Lambda.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0000H\u0016J\u000e\u0010\b\u001a\u00020\u0002H\u0094@¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkntr/base/net/comm/flowcontrol/FlowControlsProducerKt_producerFlowControls_Lambda;", "Lcom/bilibili/lib/gripper/api/internal/ProducerBase;", "Lkntr/base/net/comm/GFlowControls;", "compatJavaParam", "", "<init>", "(Lkotlin/Unit;)V", "create", "invokeProducer", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flow_control_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FlowControlsProducerKt_producerFlowControls_Lambda extends ProducerBase<GFlowControls> {
    public FlowControlsProducerKt_producerFlowControls_Lambda(Unit compatJavaParam) {
    }

    public FlowControlsProducerKt_producerFlowControls_Lambda create() {
        return new FlowControlsProducerKt_producerFlowControls_Lambda(null);
    }

    protected Object invokeProducer(Continuation<? super GFlowControls> continuation) {
        return FlowControlsProducerKt.producerFlowControls();
    }
}