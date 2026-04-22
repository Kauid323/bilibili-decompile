package kntr.base.net.comm.flowcontrol.internal.protocol;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.flowcontrol.internal.backoff.PathRule;
import kntr.base.net.comm.flowcontrol.internal.config.FlowControlConfig;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Trigger.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\"\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"isHttpFlowControl", "", "httpCode", "", "disableList", "", "Lkntr/base/net/comm/flowcontrol/internal/backoff/PathRule;", "bizEnabled", "host", "", "patch", "flow_control_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TriggerKt {
    private static final List<PathRule> disableList;

    public static final boolean isHttpFlowControl(int httpCode) {
        return httpCode == 429 || httpCode == 503;
    }

    static {
        PathRule.Companion companion = PathRule.Companion;
        String disableList2 = FlowControlConfig.INSTANCE.getDisableList();
        if (disableList2 == null) {
            disableList2 = "[]";
        }
        List<PathRule> parse = companion.parse(disableList2);
        if (parse == null) {
            parse = CollectionsKt.emptyList();
        }
        disableList = parse;
    }

    public static final boolean bizEnabled(String host, String patch) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(patch, "patch");
        return !PathRule.Companion.matches(host, patch, disableList);
    }
}