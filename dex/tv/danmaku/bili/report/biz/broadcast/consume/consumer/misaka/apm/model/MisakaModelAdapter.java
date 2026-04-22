package tv.danmaku.bili.report.biz.broadcast.consume.consumer.misaka.apm.model;

import com.bilibili.lib.moss.internal.stream.internal.tracker.ProtocolsKt;
import com.bilibili.lib.rpc.track.model.Tunnel;
import com.bilibili.lib.rpc.track.model.broadcast.BroadcastEvent;
import com.bilibili.lib.rpc.track.model.broadcast.Event;
import com.bilibili.lib.rpc.track.util.TunnelUtilsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: MisakaModelAdapter.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/report/biz/broadcast/consume/consumer/misaka/apm/model/MisakaModelAdapter;", "", "<init>", "()V", "adapt", "", "", "event", "Lcom/bilibili/lib/rpc/track/model/broadcast/BroadcastEvent;", "rate", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MisakaModelAdapter {
    public static final int $stable = 0;
    public static final MisakaModelAdapter INSTANCE = new MisakaModelAdapter();

    private MisakaModelAdapter() {
    }

    public final Map<String, String> adapt(BroadcastEvent event, float rate) {
        Intrinsics.checkNotNullParameter(event, "event");
        Pair[] pairArr = new Pair[38];
        Tunnel tunnel = event.getTunnel();
        Intrinsics.checkNotNullExpressionValue(tunnel, "getTunnel(...)");
        pairArr[0] = TuplesKt.to("engine", TunnelUtilsKt.tunnelName(tunnel));
        pairArr[1] = TuplesKt.to("session", event.getSession());
        pairArr[2] = TuplesKt.to("start", String.valueOf(event.getStart()));
        pairArr[3] = TuplesKt.to("time", String.valueOf(event.getTime()));
        pairArr[4] = TuplesKt.to("rate", String.valueOf(rate));
        pairArr[5] = TuplesKt.to("sn", String.valueOf(event.getSn()));
        pairArr[6] = TuplesKt.to("process", event.getProcess());
        pairArr[7] = TuplesKt.to("thread", event.getThread());
        pairArr[8] = TuplesKt.to("event_id", event.getEvent().toString());
        Event event2 = event.getEvent();
        Intrinsics.checkNotNullExpressionValue(event2, "getEvent(...)");
        pairArr[9] = TuplesKt.to("event", ProtocolsKt.eventToString(event2));
        pairArr[10] = TuplesKt.to("target_path", event.getTargePath());
        pairArr[11] = TuplesKt.to(LoginReporterV2.Show.SIGNUP_KEY_CODE, event.getStatusCode());
        pairArr[12] = TuplesKt.to("message", event.getStatusMessage());
        pairArr[13] = TuplesKt.to("error_name", event.getExceptionName());
        pairArr[14] = TuplesKt.to("error_message", event.getExceptionMessage());
        pairArr[15] = TuplesKt.to("message_id", event.getMessageId());
        pairArr[16] = TuplesKt.to("delay", event.getRetryDelay());
        pairArr[17] = TuplesKt.to("new_network", event.getNewNetwork());
        pairArr[18] = TuplesKt.to("new_login", event.getNewLogin());
        pairArr[19] = TuplesKt.to("heartbeat_lost", event.getHeartbeatLost());
        pairArr[20] = TuplesKt.to("restart_delay", event.getRestartDelay());
        pairArr[21] = TuplesKt.to("guid", event.getGuid());
        pairArr[22] = TuplesKt.to("connection_id", event.getConnectionId());
        pairArr[23] = TuplesKt.to("stats", event.getStatsJson());
        pairArr[24] = TuplesKt.to("retry_policy", event.getRetryPolicyJson());
        pairArr[25] = TuplesKt.to("restart_policy", event.getRestartPolicyJson());
        pairArr[26] = TuplesKt.to("enabled", String.valueOf(event.getEnabled()));
        pairArr[27] = TuplesKt.to("enabled_config", String.valueOf(event.getEnabledConfig()));
        pairArr[28] = TuplesKt.to("enabled_device", String.valueOf(event.getEnabledDevice()));
        pairArr[29] = TuplesKt.to("biz_enabled", String.valueOf(event.getBizEnabled()));
        pairArr[30] = TuplesKt.to("biz_enabled_config", String.valueOf(event.getBizEnabledConfig()));
        pairArr[31] = TuplesKt.to("biz_enabled_tunnel", String.valueOf(event.getBizEnabledTunnel()));
        pairArr[32] = TuplesKt.to("upstream_ack_message_id", String.valueOf(event.getUpstreamAckMessageId()));
        pairArr[33] = TuplesKt.to("shared", event.getShared() ? "1" : "0");
        pairArr[34] = TuplesKt.to("hp", event.getHp() ? "1" : "0");
        pairArr[35] = TuplesKt.to(AppConfig.HOST_TAG, event.getTag());
        pairArr[36] = TuplesKt.to(ReportEvent.Tag.HOST, event.getHost());
        pairArr[37] = TuplesKt.to("port", String.valueOf(event.getPort()));
        return MapsKt.mapOf(pairArr);
    }
}