package tv.danmaku.bili.report.biz.api.consume.consumer.track.apm;

import com.bilibili.lib.rpc.track.model.BizEvent;
import com.bilibili.lib.rpc.track.model.NetworkEvent;
import com.bilibili.lib.rpc.track.model.Tunnel;
import com.bilibili.lib.rpc.track.util.HttpUtilsKt;
import com.bilibili.lib.rpc.track.util.TunnelUtilsKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.core.OnePassLoginReportManagerKt;
import tv.danmaku.bili.utils.ImageUriUtilWrapper;

/* compiled from: TrackModelAdapter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ(\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00060\u00060\r*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/report/biz/api/consume/consumer/track/apm/TrackModelAdapter;", "", "<init>", "()V", "toNet", "", "", "event", "Lcom/bilibili/lib/rpc/track/model/NetworkEvent;", "rate", "", "toImageoNet", "constructBasicNetMap", "", "kotlin.jvm.PlatformType", "toNetError", "Lcom/bilibili/lib/rpc/track/model/BizEvent;", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TrackModelAdapter {
    public static final TrackModelAdapter INSTANCE = new TrackModelAdapter();

    private TrackModelAdapter() {
    }

    public final Map<String, String> toNet(NetworkEvent event, float rate) {
        Intrinsics.checkNotNullParameter(event, "event");
        Map $this$toNet_u24lambda_u240_u240 = INSTANCE.constructBasicNetMap(event, rate);
        String it = event.getMetrics().getCNetKb();
        if (it != null) {
            $this$toNet_u24lambda_u240_u240.put("speed", it);
        }
        String it2 = event.getMetrics().getCNetSuccessRate();
        if (it2 != null) {
            $this$toNet_u24lambda_u240_u240.put("api_success_rate", it2);
        }
        String it3 = event.getMetrics().getCNetKbTime();
        if (it3 != null) {
            $this$toNet_u24lambda_u240_u240.put("speed_timestamp", it3);
        }
        String it4 = event.getNetType();
        if (it4 != null) {
            $this$toNet_u24lambda_u240_u240.put(OnePassLoginReportManagerKt.EVENT_KEY_NET_TYPE, it4);
        }
        String it5 = event.getMetrics().getExtraFlag();
        if (it5 != null) {
            $this$toNet_u24lambda_u240_u240.put("extra_flag", it5);
        }
        return $this$toNet_u24lambda_u240_u240;
    }

    public final Map<String, String> toImageoNet(NetworkEvent event, float rate) {
        Intrinsics.checkNotNullParameter(event, "event");
        Map $this$toImageoNet_u24lambda_u240_u240 = INSTANCE.constructBasicNetMap(event, rate);
        String realUrl = event.getRealUrl();
        Intrinsics.checkNotNullExpressionValue(realUrl, "getRealUrl(...)");
        $this$toImageoNet_u24lambda_u240_u240.put("style", ImageUriUtilWrapper.getImageStyle(HttpUtilsKt.urlRemoveQuery(realUrl)));
        return $this$toImageoNet_u24lambda_u240_u240;
    }

    private final Map<String, String> constructBasicNetMap(NetworkEvent $this$constructBasicNetMap, float rate) {
        String realUrl = $this$constructBasicNetMap.getRealUrl();
        Intrinsics.checkNotNullExpressionValue(realUrl, "getRealUrl(...)");
        String method = $this$constructBasicNetMap.getMethod();
        Intrinsics.checkNotNullExpressionValue(method, "getMethod(...)");
        Tunnel tunnel = $this$constructBasicNetMap.getTunnel();
        Intrinsics.checkNotNullExpressionValue(tunnel, "getTunnel(...)");
        String netExceptionName = $this$constructBasicNetMap.getNetExceptionName();
        Intrinsics.checkNotNullExpressionValue(netExceptionName, "getNetExceptionName(...)");
        String netExceptionMessage = $this$constructBasicNetMap.getNetExceptionMessage();
        Intrinsics.checkNotNullExpressionValue(netExceptionMessage, "getNetExceptionMessage(...)");
        Tunnel tunnel2 = $this$constructBasicNetMap.getTunnel();
        Intrinsics.checkNotNullExpressionValue(tunnel2, "getTunnel(...)");
        List hostResolveIpsList = $this$constructBasicNetMap.getMetrics().getHostResolveIpsList();
        Intrinsics.checkNotNullExpressionValue(hostResolveIpsList, "getHostResolveIpsList(...)");
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("command", ProtocolsKt.command($this$constructBasicNetMap)), TuplesKt.to("real_request_url", HttpUtilsKt.urlRemoveQuery(realUrl)), TuplesKt.to("traceid", $this$constructBasicNetMap.getHeader().getTraceId()), TuplesKt.to("idc", $this$constructBasicNetMap.getHeader().getIdc()), TuplesKt.to("via", $this$constructBasicNetMap.getHeader().getVia()), TuplesKt.to("x_cache", $this$constructBasicNetMap.getHeader().getXcache()), TuplesKt.to("x_cache_webcdn", $this$constructBasicNetMap.getHeader().getXcacheWebcdn()), TuplesKt.to("server_ip", $this$constructBasicNetMap.getMetrics().getRemoteIp()), TuplesKt.to("negotiated_protocol", $this$constructBasicNetMap.getProtocol()), TuplesKt.to("http_code", String.valueOf($this$constructBasicNetMap.getHttpCode())), TuplesKt.to("grpc_status", $this$constructBasicNetMap.getHeader().getGrpcStatus().toString()), TuplesKt.to("request_method", ProtocolsKt.methodToIntStr(method)), TuplesKt.to("tunnel", ProtocolsKt.booleanToInStr($this$constructBasicNetMap.getPersistent())), TuplesKt.to("tunnel_sdk", ProtocolsKt.tunnelToIntString(tunnel)), TuplesKt.to("socket_reused", ProtocolsKt.booleanToInStr($this$constructBasicNetMap.getMetrics().getSocketReuse())), TuplesKt.to("req_size", String.valueOf($this$constructBasicNetMap.getMetrics().getReqPackageSize())), TuplesKt.to("recv_size", String.valueOf($this$constructBasicNetMap.getMetrics().getRespPackageSize())), TuplesKt.to("connect_time", String.valueOf($this$constructBasicNetMap.getMetrics().getConnectCost())), TuplesKt.to("dns_time", String.valueOf($this$constructBasicNetMap.getMetrics().getDnsCost())), TuplesKt.to("request_time", String.valueOf($this$constructBasicNetMap.getMetrics().getReqCost())), TuplesKt.to("response_time", String.valueOf($this$constructBasicNetMap.getMetrics().getRespCost())), TuplesKt.to("tls_time", String.valueOf($this$constructBasicNetMap.getMetrics().getTlsCost())), TuplesKt.to("total_time", String.valueOf($this$constructBasicNetMap.getMetrics().getCost())), TuplesKt.to("downgrade", ProtocolsKt.booleanToInStr($this$constructBasicNetMap.getDowngrade())), TuplesKt.to("request_traceid", $this$constructBasicNetMap.getLocalRpcTraceId()), TuplesKt.to("rate", String.valueOf(rate)), TuplesKt.to("exception_msg", ProtocolsKt.exception(netExceptionName, netExceptionMessage)), TuplesKt.to("biz_code", $this$constructBasicNetMap.getHeader().getBizCode()), TuplesKt.to("domain_downgrade", ProtocolsKt.booleanToInStr($this$constructBasicNetMap.getDomainDowngrade())), TuplesKt.to("engine", TunnelUtilsKt.tunnelName(tunnel2)), TuplesKt.to("cronet_error_code", String.valueOf($this$constructBasicNetMap.getCrNetError().getErrorCode())), TuplesKt.to("cronet_internal_error_code", String.valueOf($this$constructBasicNetMap.getCrNetError().getInternalErrorCode())), TuplesKt.to("cronet_quic_detailed_error_code", String.valueOf($this$constructBasicNetMap.getCrNetError().getQuicDetailedErrorCode())), TuplesKt.to("dns_provider", $this$constructBasicNetMap.getMetrics().getDnsProvider()), TuplesKt.to("host_resolve_ips", CollectionsKt.joinToString$default(hostResolveIpsList, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)), TuplesKt.to("error_records", $this$constructBasicNetMap.getMetrics().getErrorRecords()), TuplesKt.to("job_type", $this$constructBasicNetMap.getMetrics().getJobType()), TuplesKt.to("content_encoding", $this$constructBasicNetMap.getHeader().getContentEncoding()), TuplesKt.to("cronet_version", $this$constructBasicNetMap.getCrVersion().getVersion()), TuplesKt.to("cronet_last_change", $this$constructBasicNetMap.getCrVersion().getLastChange()), TuplesKt.to("cronet_bili_last_change", $this$constructBasicNetMap.getCrVersion().getBiliLastChange()), TuplesKt.to("proxy", $this$constructBasicNetMap.getProxy()), TuplesKt.to("nq_effective_connection_type", String.valueOf($this$constructBasicNetMap.getMetrics().getCrNq().getEct())), TuplesKt.to("nq_http_rtt_ms", String.valueOf($this$constructBasicNetMap.getMetrics().getCrNq().getHttpRttMs())), TuplesKt.to("nq_transport_rtt_ms", String.valueOf($this$constructBasicNetMap.getMetrics().getCrNq().getTransportRttMs())), TuplesKt.to("nq_downstream_throughtput_kbps", String.valueOf($this$constructBasicNetMap.getMetrics().getCrNq().getDownstreamThroughputKbps())), TuplesKt.to("iquic_stream_protocol", $this$constructBasicNetMap.getMetrics().getStreamProtocl()), TuplesKt.to("iquic_using_quic", ProtocolsKt.booleanToInStr($this$constructBasicNetMap.getMetrics().getUsingQuic())), TuplesKt.to("iquic_quic_protocol_id", $this$constructBasicNetMap.getMetrics().getQuicProtocolId()), TuplesKt.to("xtraceid", $this$constructBasicNetMap.getXtraceId()), TuplesKt.to("req_zone", $this$constructBasicNetMap.getZone()), TuplesKt.to("xticket", $this$constructBasicNetMap.getXticket()), TuplesKt.to("resp_path_route", $this$constructBasicNetMap.getHeader().getAuroraPathRoute()), TuplesKt.to("resp_zone", $this$constructBasicNetMap.getHeader().getAuroraZone()), TuplesKt.to("gaia_vvoucher", $this$constructBasicNetMap.getHeader().getVVoucher())});
    }

    public final Map<String, String> toNetError(BizEvent event, float rate) {
        Intrinsics.checkNotNullParameter(event, "event");
        String scheme = event.getScheme();
        Intrinsics.checkNotNullExpressionValue(scheme, "getScheme(...)");
        String host = event.getHost();
        Intrinsics.checkNotNullExpressionValue(host, "getHost(...)");
        String path = event.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        Tunnel tunnel = event.getTunnel();
        Intrinsics.checkNotNullExpressionValue(tunnel, "getTunnel(...)");
        String bizExceptionName = event.getBizExceptionName();
        Intrinsics.checkNotNullExpressionValue(bizExceptionName, "getBizExceptionName(...)");
        String bizExceptionName2 = event.getBizExceptionName();
        Intrinsics.checkNotNullExpressionValue(bizExceptionName2, "getBizExceptionName(...)");
        String bizExceptionMessage = event.getBizExceptionMessage();
        Intrinsics.checkNotNullExpressionValue(bizExceptionMessage, "getBizExceptionMessage(...)");
        Tunnel tunnel2 = event.getTunnel();
        Intrinsics.checkNotNullExpressionValue(tunnel2, "getTunnel(...)");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("command", HttpUtilsKt.url(scheme, host, path)), TuplesKt.to("request_traceid", event.getLocalRpcTraceId()), TuplesKt.to("tunnel_sdk", ProtocolsKt.tunnelToIntString(tunnel)), TuplesKt.to("response_code", String.valueOf(event.getBizCode())), TuplesKt.to("biz_code", ProtocolsKt.bizCode(!StringsKt.isBlank(bizExceptionName))), TuplesKt.to("exception_msg", ProtocolsKt.exception(bizExceptionName2, bizExceptionMessage)), TuplesKt.to("engine", TunnelUtilsKt.tunnelName(tunnel2)), TuplesKt.to("grpc_status", String.valueOf(event.getGrpcStatus())), TuplesKt.to("rate", String.valueOf(rate))});
    }
}