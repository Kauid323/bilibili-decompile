package kntr.base.net.comm.flowcontrol;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.GFlowControls;
import kntr.base.net.comm.flowcontrol.internal.FlowControls;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FlowControlsProducer.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007¨\u0006\u0002"}, d2 = {"producerFlowControls", "Lkntr/base/net/comm/GFlowControls;", "flow_control_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FlowControlsProducerKt {
    public static final GFlowControls producerFlowControls() {
        return new GFlowControls() { // from class: kntr.base.net.comm.flowcontrol.FlowControlsProducerKt$producerFlowControls$1
            @Override // kntr.base.net.comm.GFlowControls
            public boolean hiltFlowControl(String host, String path) {
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(path, "path");
                return FlowControls.INSTANCE.onRequest(host, path);
            }

            @Override // kntr.base.net.comm.GFlowControls
            public void updateFlowControl(String host, String path, int httpCode, Integer after) {
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(path, "path");
                FlowControls.INSTANCE.onResponse(host, path, httpCode, after);
            }
        };
    }
}