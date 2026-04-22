package tv.danmaku.bili.report.biz.api.consume.consumer.misaka.apm.internal.model;

import com.bilibili.lib.rpc.track.model.BizEvent;
import com.bilibili.lib.rpc.track.model.Header;
import com.bilibili.lib.rpc.track.model.Metrics;
import com.bilibili.lib.rpc.track.model.NetworkEvent;
import com.bilibili.lib.rpc.track.model.Tunnel;
import com.bilibili.lib.rpc.track.util.HttpUtilsKt;
import com.bilibili.lib.rpc.track.util.TunnelUtilsKt;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.api.produce.model.EventsKt;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;

/* compiled from: MisakaModelAdapter.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J4\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\"\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0019j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u001aH\u0002J4\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\"\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0019j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u001aH\u0002¨\u0006\u001d"}, d2 = {"Ltv/danmaku/bili/report/biz/api/consume/consumer/misaka/apm/internal/model/MisakaModelAdapter;", "", "<init>", "()V", "toNet", "", "", "event", "Lcom/bilibili/lib/rpc/track/model/NetworkEvent;", "toBiz", "Lcom/bilibili/lib/rpc/track/model/BizEvent;", "errorCode", "", "error", "", "tunnel", "Lcom/bilibili/lib/rpc/track/model/Tunnel;", "getType", "getDomain", "getCode", "fill", "", "header", "Lcom/bilibili/lib/rpc/track/model/Header;", "map", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "metrics", "Lcom/bilibili/lib/rpc/track/model/Metrics;", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MisakaModelAdapter {
    public static final MisakaModelAdapter INSTANCE = new MisakaModelAdapter();

    /* compiled from: MisakaModelAdapter.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Tunnel.values().length];
            try {
                iArr[Tunnel.OKHTTP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Tunnel.MOSS_CRONET.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Tunnel.MOSS_OKHTTP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Tunnel.MOSS_DOWNGRADE_OKHTTP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[Tunnel.HTTPDNS_CHROMIUM_NET.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private MisakaModelAdapter() {
    }

    public final Map<String, String> toNet(NetworkEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        boolean error = HttpUtilsKt.httpError(event.getHttpCode());
        HashMap map = new HashMap();
        String scheme = event.getScheme();
        Intrinsics.checkNotNullExpressionValue(scheme, "getScheme(...)");
        String host = event.getHost();
        Intrinsics.checkNotNullExpressionValue(host, "getHost(...)");
        String path = event.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        map.put("request_uri", HttpUtilsKt.url(scheme, host, path));
        map.put("start_request_ts", String.valueOf(event.getRequestTime() / 1000));
        map.put("negotiated_protocol", event.getProtocol());
        map.put("http_code", String.valueOf(event.getHttpCode()));
        if (error) {
            String url = event.getUrl();
            Intrinsics.checkNotNullExpressionValue(url, "getUrl(...)");
            map.put("request_args", HttpUtilsKt.encodedQuery(url));
        }
        MisakaModelAdapter misakaModelAdapter = INSTANCE;
        Tunnel tunnel = event.getTunnel();
        Intrinsics.checkNotNullExpressionValue(tunnel, "getTunnel(...)");
        map.put("biz_errcode", String.valueOf(misakaModelAdapter.errorCode(error, tunnel)));
        String netExceptionName = event.getNetExceptionName();
        Intrinsics.checkNotNullExpressionValue(netExceptionName, "getNetExceptionName(...)");
        if (!StringsKt.isBlank(netExceptionName)) {
            map.put("exception_name", event.getNetExceptionName());
        }
        String netExceptionMessage = event.getNetExceptionMessage();
        Intrinsics.checkNotNullExpressionValue(netExceptionMessage, "getNetExceptionMessage(...)");
        if (!StringsKt.isBlank(netExceptionMessage)) {
            map.put("exception_message", event.getNetExceptionMessage());
        }
        Metrics it = event.getMetrics();
        if (it != null) {
            INSTANCE.fill(it, map);
        }
        Header it2 = event.getHeader();
        if (it2 != null) {
            INSTANCE.fill(it2, map);
        }
        map.put("response_code", event.getHeader().getGrpcStatus());
        Tunnel tunnel2 = event.getTunnel();
        Intrinsics.checkNotNullExpressionValue(tunnel2, "getTunnel(...)");
        map.put("engine", TunnelUtilsKt.tunnelName(tunnel2));
        map.put("request_traceid", event.getLocalRpcTraceId());
        map.put("cronet_error_code", String.valueOf(event.getCrNetError().getErrorCode()));
        map.put("cronet_internal_error_code", String.valueOf(event.getCrNetError().getInternalErrorCode()));
        return map;
    }

    public final Map<String, String> toBiz(BizEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        boolean rpcError = EventsKt.isError(event);
        HashMap map = new HashMap();
        String scheme = event.getScheme();
        Intrinsics.checkNotNullExpressionValue(scheme, "getScheme(...)");
        String host = event.getHost();
        Intrinsics.checkNotNullExpressionValue(host, "getHost(...)");
        String path = event.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        map.put("request_uri", HttpUtilsKt.url(scheme, host, path));
        map.put("start_request_ts", String.valueOf(event.getRequestTime() / 1000));
        map.put("http_code", String.valueOf(event.getNetSuccess() ? 200 : -1));
        if (rpcError) {
            String url = event.getUrl();
            Intrinsics.checkNotNullExpressionValue(url, "getUrl(...)");
            map.put("request_args", HttpUtilsKt.encodedQuery(url));
        }
        MisakaModelAdapter misakaModelAdapter = INSTANCE;
        Tunnel tunnel = event.getTunnel();
        Intrinsics.checkNotNullExpressionValue(tunnel, "getTunnel(...)");
        map.put("biz_errcode", String.valueOf(misakaModelAdapter.errorCode(rpcError, tunnel)));
        if (rpcError) {
            if (!event.getNetSuccess()) {
                map.put("exception_name", event.getNetExceptionName());
                map.put("exception_message", event.getNetExceptionMessage());
            } else {
                map.put("exception_name", event.getBizExceptionName());
                map.put("exception_message", event.getBizExceptionMessage());
            }
        }
        Header it = event.getHeader();
        if (it != null) {
            INSTANCE.fill(it, map);
        }
        map.put("total_time", String.valueOf(event.getTotalTime()));
        map.put("status_code", String.valueOf(event.getBizCode()));
        map.put("status_message", event.getBizMessage());
        Tunnel tunnel2 = event.getTunnel();
        Intrinsics.checkNotNullExpressionValue(tunnel2, "getTunnel(...)");
        map.put("engine", TunnelUtilsKt.tunnelName(tunnel2));
        map.put("response_code", String.valueOf(event.getGrpcStatus()));
        map.put("request_traceid", event.getLocalRpcTraceId());
        return map;
    }

    private final int errorCode(boolean error, Tunnel tunnel) {
        StringBuilder builder = new StringBuilder();
        if (error) {
            builder.append(MineReporter.LIVE_TYPE_UPPER_NO_LIVE);
        } else {
            builder.append(MineReporter.LIVE_TYPE_NOT_UPPER_NO_LIVE);
        }
        builder.append(getType(tunnel));
        builder.append(getDomain(error));
        builder.append(getCode());
        String code = builder.toString();
        Intrinsics.checkNotNullExpressionValue(code, "toString(...)");
        BLog.vfmt("misaka.eventfactory", "Misaka error code = %s.", CollectionsKt.joinToString$default(StringsKt.chunked(code, 8), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null));
        try {
            return Integer.parseInt(code, 2);
        } catch (Exception e) {
            return 0;
        }
    }

    private final String getType(Tunnel tunnel) {
        switch (WhenMappings.$EnumSwitchMapping$0[tunnel.ordinal()]) {
            case 1:
            default:
                return "000001";
            case 2:
                return "000010";
            case 3:
                return "000011";
            case 4:
                return "000101";
            case 5:
                return "000110";
        }
    }

    private final String getDomain(boolean error) {
        if (error) {
            return "00000001";
        }
        return "00000000";
    }

    private final String getCode() {
        return "0000000000000000";
    }

    private final void fill(Header header, HashMap<String, String> hashMap) {
        hashMap.put("traceid", header.getTraceId());
        hashMap.put("idc", header.getIdc());
        hashMap.put("via", header.getVia());
        hashMap.put("xcache", header.getXcache());
        hashMap.put("xcache_webcdn", header.getXcacheWebcdn());
    }

    private final void fill(Metrics metrics, HashMap<String, String> hashMap) {
        hashMap.put("request_package_size", String.valueOf(metrics.getReqPackageSize()));
        hashMap.put("response_package_size", String.valueOf(metrics.getRespPackageSize()));
        hashMap.put("dns_time", String.valueOf(metrics.getDnsCost()));
        hashMap.put("tls_time", String.valueOf(metrics.getTlsCost()));
        hashMap.put("connect_time", String.valueOf(metrics.getConnectCost()));
        hashMap.put("request_time", String.valueOf(metrics.getReqCost()));
        hashMap.put("response_time", String.valueOf(metrics.getRespCost()));
        hashMap.put("consumer_time", String.valueOf(metrics.getCost()));
        hashMap.put("socket_reused", ProtocolsKt.booleanToInStr(metrics.getSocketReuse()));
        HashMap<String, String> hashMap2 = hashMap;
        String remoteIp = metrics.getRemoteIp();
        if (remoteIp == null) {
            remoteIp = "";
        }
        hashMap2.put("cdn_addr", remoteIp);
        HashMap<String, String> hashMap3 = hashMap;
        String dnsProvider = metrics.getDnsProvider();
        hashMap3.put("dns_provider", dnsProvider != null ? dnsProvider : "");
    }
}