package kntr.base.net.comm;

import java.io.IOException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: GFlowControls.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkntr/base/net/comm/FlowControlException;", "Ljava/io/IOException;", "Lkotlinx/io/IOException;", "<init>", "()V", "flow_control_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FlowControlException extends IOException {
    public FlowControlException() {
        super("Flow control exception", new RuntimeException("Blocked by flow control"));
    }
}