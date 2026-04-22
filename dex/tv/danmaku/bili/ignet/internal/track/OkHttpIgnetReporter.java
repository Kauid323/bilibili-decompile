package tv.danmaku.bili.ignet.internal.track;

import android.net.Uri;
import android.os.SystemClock;
import com.bilibili.base.BiliContext;
import com.bilibili.gripper.api.network.GNetQuality;
import com.bilibili.lib.ighttp.IgHttpReportInfo;
import com.bilibili.lib.ighttp.IgHttpReporter;
import com.bilibili.lib.ighttp.IgHttpResponse;
import com.bilibili.lib.ighttp.Protocol;
import com.bilibili.lib.rpc.aurora.AuroraRoute;
import com.bilibili.lib.rpc.flowcontrol.FlowControl;
import com.bilibili.lib.rpc.gaia.Gaia;
import com.bilibili.lib.rpc.report.HttpReporter;
import com.bilibili.lib.rpc.ticket.Ticket;
import com.bilibili.lib.rpc.track.model.CallType;
import com.bilibili.lib.rpc.track.model.CrNetError;
import com.bilibili.lib.rpc.track.model.DomainDowngrade;
import com.bilibili.lib.rpc.track.model.Header;
import com.bilibili.lib.rpc.track.model.Metrics;
import com.bilibili.lib.rpc.track.model.NetworkEvent;
import com.bilibili.lib.rpc.track.model.RpcExtra;
import com.bilibili.lib.rpc.track.model.RpcSample;
import com.bilibili.lib.rpc.track.model.Tunnel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: OkHttpIgnetReporter.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001a\u0010 \u001a\u0004\u0018\u00010!2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#H\u0002J\u001a\u0010%\u001a\u0004\u0018\u00010&2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#H\u0002J\u001a\u0010'\u001a\u0004\u0018\u00010(2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Ltv/danmaku/bili/ignet/internal/track/OkHttpIgnetReporter;", "Lcom/bilibili/lib/ighttp/IgHttpReporter;", "consumer", "Lcom/bilibili/lib/rpc/report/HttpReporter;", "netQuality", "Lcom/bilibili/gripper/api/network/GNetQuality;", "flowControl", "Lcom/bilibili/lib/rpc/flowcontrol/FlowControl;", "auroraRoute", "Lcom/bilibili/lib/rpc/aurora/AuroraRoute;", "ticket", "Lcom/bilibili/lib/rpc/ticket/Ticket;", "gaia", "Lcom/bilibili/lib/rpc/gaia/Gaia;", "<init>", "(Lcom/bilibili/lib/rpc/report/HttpReporter;Lcom/bilibili/gripper/api/network/GNetQuality;Lcom/bilibili/lib/rpc/flowcontrol/FlowControl;Lcom/bilibili/lib/rpc/aurora/AuroraRoute;Lcom/bilibili/lib/rpc/ticket/Ticket;Lcom/bilibili/lib/rpc/gaia/Gaia;)V", "getConsumer", "()Lcom/bilibili/lib/rpc/report/HttpReporter;", "getNetQuality", "()Lcom/bilibili/gripper/api/network/GNetQuality;", "getFlowControl", "()Lcom/bilibili/lib/rpc/flowcontrol/FlowControl;", "getAuroraRoute", "()Lcom/bilibili/lib/rpc/aurora/AuroraRoute;", "getTicket", "()Lcom/bilibili/lib/rpc/ticket/Ticket;", "getGaia", "()Lcom/bilibili/lib/rpc/gaia/Gaia;", "report", "", "info", "Lcom/bilibili/lib/ighttp/IgHttpReportInfo;", "findRpcExtra", "Lcom/bilibili/lib/rpc/track/model/RpcExtra;", "annotations", "", "", "findCallType", "Lcom/bilibili/lib/rpc/track/model/CallType;", "findDomainDowngradeType", "Lcom/bilibili/lib/rpc/track/model/DomainDowngrade;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
final class OkHttpIgnetReporter extends IgHttpReporter {
    private final AuroraRoute auroraRoute;
    private final HttpReporter consumer;
    private final FlowControl flowControl;
    private final Gaia gaia;
    private final GNetQuality netQuality;
    private final Ticket ticket;

    public OkHttpIgnetReporter(HttpReporter consumer, GNetQuality netQuality, FlowControl flowControl, AuroraRoute auroraRoute, Ticket ticket, Gaia gaia) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Intrinsics.checkNotNullParameter(flowControl, "flowControl");
        Intrinsics.checkNotNullParameter(auroraRoute, "auroraRoute");
        Intrinsics.checkNotNullParameter(ticket, "ticket");
        Intrinsics.checkNotNullParameter(gaia, "gaia");
        this.consumer = consumer;
        this.netQuality = netQuality;
        this.flowControl = flowControl;
        this.auroraRoute = auroraRoute;
        this.ticket = ticket;
        this.gaia = gaia;
    }

    public final AuroraRoute getAuroraRoute() {
        return this.auroraRoute;
    }

    public final HttpReporter getConsumer() {
        return this.consumer;
    }

    public final FlowControl getFlowControl() {
        return this.flowControl;
    }

    public final Gaia getGaia() {
        return this.gaia;
    }

    public final GNetQuality getNetQuality() {
        return this.netQuality;
    }

    public final Ticket getTicket() {
        return this.ticket;
    }

    public void report(IgHttpReportInfo info) {
        List emptyList;
        Intrinsics.checkNotNullParameter(info, "info");
        NetworkEvent.Builder eventBuilder = NetworkEvent.newBuilder().setHttpCode(-1);
        IgHttpResponse response = info.getResponse();
        if (response == null) {
            eventBuilder.setHttpCode(info.getHttpCode());
            eventBuilder.setProtocol(info.getHttpProtocol());
            eventBuilder.setMethod(info.getHttpMethod());
        }
        if (response != null) {
            eventBuilder.setHttpCode(response.httpCode());
            Protocol protocol = response.protocol();
            eventBuilder.setProtocol((protocol == null || (r7 = protocol.toString()) == null) ? "" : "");
            eventBuilder.setMethod(response.request().method());
            Map it = response.reportHeaders();
            if (it != null) {
                Header.Builder builder = Header.newBuilder();
                String str = (String) it.get("BILI-TRACE-ID");
                if (str == null) {
                    str = "";
                }
                builder.setTraceId(str);
                String str2 = (String) it.get("IDC");
                if (str2 == null) {
                    str2 = "";
                }
                builder.setIdc(str2);
                String str3 = (String) it.get("Via");
                if (str3 == null) {
                    str3 = "";
                }
                builder.setVia(str3);
                String str4 = (String) it.get("X-Cache");
                if (str4 == null) {
                    str4 = "";
                }
                builder.setXcache(str4);
                String str5 = (String) it.get("X-Cache-Webcdn");
                if (str5 == null) {
                    str5 = "";
                }
                builder.setXcacheWebcdn(str5);
                String str6 = (String) it.get("content-encoding");
                if (str6 == null) {
                    str6 = "";
                }
                builder.setContentEncoding(str6);
                String str7 = (String) it.get("x-bili-aurora-path-route");
                if (str7 == null) {
                    str7 = "";
                }
                builder.setAuroraPathRoute(str7);
                String str8 = (String) it.get("x-bili-aurora-zone");
                if (str8 == null) {
                    str8 = "";
                }
                builder.setAuroraZone(str8);
                String str9 = (String) it.get("x-bili-gaia-vvoucher");
                if (str9 == null) {
                    str9 = "";
                }
                builder.setVVoucher(str9);
                String str10 = (String) it.get("x-ticket-status");
                if (str10 == null) {
                    str10 = "";
                }
                builder.setTicketStatus(str10);
                String str11 = (String) it.get("grpc-status");
                if (str11 == null) {
                    str11 = "";
                }
                builder.setGrpcStatus(str11);
                String str12 = (String) it.get("Bili-Status-Code");
                if (str12 == null) {
                    str12 = "";
                }
                builder.setBizCode(str12);
                String str13 = (String) it.get("x-bili-retry-after");
                if (str13 == null) {
                    str13 = "";
                }
                builder.setFlowControl(str13);
                eventBuilder.setHeader(builder.build());
            }
            eventBuilder.setProxy("");
        }
        if (info.getErrCode() != 0) {
            eventBuilder.setNetExceptionName("");
            eventBuilder.setNetExceptionMessage(info.getErrMsg());
            CrNetError.Builder $this$report_u24lambda_u241 = CrNetError.newBuilder();
            $this$report_u24lambda_u241.setErrorCode(info.getErrCode());
            $this$report_u24lambda_u241.setInternalErrorCode(info.getErrCode());
            String errMsg = info.getErrMsg();
            if (errMsg == null) {
                errMsg = "";
            }
            $this$report_u24lambda_u241.setDetailMessage(errMsg);
            $this$report_u24lambda_u241.setRetryable(false);
            eventBuilder.setCrNetError($this$report_u24lambda_u241.build());
        }
        Metrics.Builder builder2 = Metrics.newBuilder();
        GNetQuality it2 = this.netQuality;
        if (it2 != null) {
            builder2.setCNetSuccessRate(String.valueOf(it2.getSuccessRate()));
            builder2.setCNetKb(String.valueOf(it2.getSpeed()));
            builder2.setCNetKbTime(String.valueOf(it2.getSpeedTimestamp()));
        }
        if (SystemClock.elapsedRealtime() - BiliContext.getStartElapsedRealtime() < 30000) {
            builder2.setExtraFlag("cool-start");
        }
        builder2.setDnsStart(info.getDnsStart());
        builder2.setDnsEnd(info.getDnsEnd());
        builder2.setDnsCost(info.getDnsCost());
        builder2.setConnectStart(info.getConnectStart());
        builder2.setTlsStart(info.getRealRespStart());
        builder2.setTlsEnd(info.getRespEnd());
        builder2.setTlsCost(info.getRealRespCost());
        builder2.setConnectEnd(info.getConnectEnd());
        builder2.setConnectCost(info.getConnectCost());
        builder2.setReqStart(info.getReqStart());
        builder2.setReqEnd(info.getReqEnd());
        builder2.setReqCost(info.getReqCost());
        builder2.setReqPackageSize(info.getReqPackageSize());
        builder2.setRespStart(info.getRespStart());
        builder2.setRespEnd(info.getRespEnd());
        builder2.setRespCost(info.getRespCost());
        builder2.setRespPackageSize(info.getRespPackageSize());
        builder2.setEnd(info.getEnd());
        builder2.setCost(info.getCost());
        builder2.setSocketReuse(info.getSocketReuse());
        String remoteIp = info.getRemoteIp();
        if (remoteIp == null) {
            remoteIp = "";
        }
        builder2.setRemoteIp(remoteIp);
        String dnsProvider = info.getDnsProvider();
        if (dnsProvider == null) {
            dnsProvider = "";
        }
        builder2.setDnsProvider(dnsProvider);
        String hostResolveIps = info.getHostResolveIps();
        Intrinsics.checkNotNullExpressionValue(hostResolveIps, "getHostResolveIps(...)");
        List ipList = StringsKt.split$default(hostResolveIps, new String[]{";"}, false, 0, 6, (Object) null);
        if (ipList == null || (emptyList = CollectionsKt.toList(ipList)) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        builder2.addAllHostResolveIps(emptyList);
        String errorRecords = info.getErrorRecords();
        if (errorRecords == null) {
            errorRecords = "";
        }
        builder2.setErrorRecords(errorRecords);
        String jobType = info.getJobType();
        if (jobType == null) {
            jobType = "";
        }
        builder2.setJobType(jobType);
        eventBuilder.setMetrics(builder2.build());
        eventBuilder.setUrl(info.getUrl());
        Uri uri = Uri.parse(eventBuilder.getUrl());
        String scheme = uri.getScheme();
        if (scheme == null) {
            scheme = "";
        }
        eventBuilder.setScheme(scheme);
        String host = uri.getHost();
        if (host == null) {
            host = "";
        }
        eventBuilder.setHost(host);
        String path = uri.getPath();
        if (path == null) {
            path = "";
        }
        eventBuilder.setPath(path);
        eventBuilder.setRealUrl(eventBuilder.getUrl());
        String scheme2 = uri.getScheme();
        if (scheme2 == null) {
            scheme2 = "";
        }
        eventBuilder.setRealScheme(scheme2);
        String host2 = uri.getHost();
        if (host2 == null) {
            host2 = "";
        }
        eventBuilder.setRealHost(host2);
        String path2 = uri.getPath();
        if (path2 == null) {
            path2 = "";
        }
        eventBuilder.setRealPath(path2);
        eventBuilder.setRequestTime(eventBuilder.getMetrics().getStart());
        eventBuilder.setFinishTime(eventBuilder.getMetrics().getEnd());
        eventBuilder.setTotalTime(eventBuilder.getMetrics().getCost());
        GNetQuality it3 = this.netQuality;
        if (it3 != null) {
            eventBuilder.setNetType(String.valueOf(it3.getNetworkDetail()));
        }
        RpcExtra option = findRpcExtra(info.getAnnotations());
        if (option == null) {
            option = new RpcExtra(Tunnel.OKHTTP_IGNET, (String) null, false, false, (RpcSample) null, (String) null, (String) null, (String) null, (String) null, (int) BR.roleName, (DefaultConstructorMarker) null);
        }
        eventBuilder.setTunnel(option.getTunnel());
        eventBuilder.setLocalRpcTraceId(option.getTraceId());
        eventBuilder.setDowngrade(option.getDowngrade());
        eventBuilder.setPersistent(option.getPersistent());
        if (option.getSample() != null) {
            eventBuilder.setSample(option.getSample());
        }
        String logicalUrl = option.getLogicalUrl();
        if (!(logicalUrl == null || StringsKt.isBlank(logicalUrl))) {
            eventBuilder.setLogicalUrl(option.getLogicalUrl());
            Uri parsed = Uri.parse(eventBuilder.getLogicalUrl());
            String scheme3 = parsed.getScheme();
            if (scheme3 == null) {
                scheme3 = "";
            }
            eventBuilder.setLogicalScheme(scheme3);
            String host3 = parsed.getHost();
            if (host3 == null) {
                host3 = "";
            }
            eventBuilder.setLogicalHost(host3);
            String path3 = parsed.getPath();
            eventBuilder.setLogicalPath(path3 != null ? path3 : "");
        }
        eventBuilder.setXtraceId(option.getXtraceId());
        eventBuilder.setZone(option.getZone());
        eventBuilder.setXticket(option.getXBiliTicket());
        CallType findCallType = findCallType(info.getAnnotations());
        if (findCallType == null) {
            findCallType = CallType.API;
        }
        CallType callType = findCallType;
        eventBuilder.setCallType(callType);
        DomainDowngrade findDomainDowngradeType = findDomainDowngradeType(info.getAnnotations());
        if (findDomainDowngradeType == null) {
            findDomainDowngradeType = new DomainDowngrade(false);
        }
        DomainDowngrade domainDowngradeObj = findDomainDowngradeType;
        eventBuilder.setDomainDowngrade(domainDowngradeObj.getDowngrade());
        if (!eventBuilder.getConsumed()) {
            eventBuilder.setConsumed(true);
            NetworkEvent event = eventBuilder.build();
            try {
                HttpReporter httpReporter = this.consumer;
                Intrinsics.checkNotNull(event);
                httpReporter.report(event);
                this.flowControl.onResponse(event);
                this.auroraRoute.onAuroraResp(event);
                this.ticket.onTicketResp(event);
                this.gaia.onGaiaResp(event);
                GNetQuality gNetQuality = this.netQuality;
                if (gNetQuality != null) {
                    gNetQuality.report(event);
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Exception e) {
                BLog.w("okhttp.ignet.track", e);
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    private final RpcExtra findRpcExtra(Collection<? extends Object> collection) {
        Object element$iv;
        if (collection == null) {
            element$iv = null;
        } else {
            Collection<? extends Object> $this$firstOrNull$iv = collection;
            Iterator<T> it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    element$iv = it.next();
                    if (element$iv instanceof RpcExtra) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
        }
        if (element$iv instanceof RpcExtra) {
            return (RpcExtra) element$iv;
        }
        return null;
    }

    private final CallType findCallType(Collection<? extends Object> collection) {
        Object element$iv;
        if (collection == null) {
            element$iv = null;
        } else {
            Collection<? extends Object> $this$firstOrNull$iv = collection;
            Iterator<T> it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    element$iv = it.next();
                    if (element$iv instanceof CallType) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
        }
        if (element$iv instanceof CallType) {
            return (CallType) element$iv;
        }
        return null;
    }

    private final DomainDowngrade findDomainDowngradeType(Collection<? extends Object> collection) {
        Object element$iv;
        if (collection == null) {
            element$iv = null;
        } else {
            Collection<? extends Object> $this$firstOrNull$iv = collection;
            Iterator<T> it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    element$iv = it.next();
                    if (element$iv instanceof DomainDowngrade) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
        }
        if (element$iv instanceof DomainDowngrade) {
            return (DomainDowngrade) element$iv;
        }
        return null;
    }
}