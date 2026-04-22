package tv.danmaku.bili.flowcontrol.internal.protocol;

import com.bilibili.lib.moss.utils.ConstsKt;
import com.bilibili.lib.rpc.track.model.Header;
import com.bilibili.lib.rpc.track.model.NetworkEvent;
import com.bilibili.lib.rpc.track.model.Tunnel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.flowcontrol.internal.config.FlowControlConfig;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.report.sample.rule.path.PathRule;

/* compiled from: Trigger.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003\u001a\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0003\u001a\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003\u001a\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0003\u001a\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0007\"\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"isFlowControl", "Ltv/danmaku/bili/flowcontrol/internal/protocol/FlowControlModel;", "event", "Lcom/bilibili/lib/rpc/track/model/NetworkEvent;", "isHttpFlowControl", "", "httpCode", "", "isMossFlowControl", "grpcStatus", "", "hasResponse", "hasHeader", "Lkotlin/Pair;", "header", "Lcom/bilibili/lib/rpc/track/model/Header;", "disableList", "", "Ltv/danmaku/bili/report/sample/rule/path/PathRule;", "bizEnabled", ReportEvent.Tag.HOST, "patch", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TriggerKt {
    private static final List<PathRule> disableList;

    /* compiled from: Trigger.kt */
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
                iArr[Tunnel.OKHTTP_CRONET.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Tunnel.OKHTTP_IGNET.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Tunnel.MOSS_REST_OKHTTP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[Tunnel.MOSS_REST_OKHTTP_CRONET.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[Tunnel.MOSS_CRONET.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[Tunnel.MOSS_OKHTTP.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[Tunnel.MOSS_DOWNGRADE_OKHTTP.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[Tunnel.MOSS_STREAM_CRONET.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[Tunnel.MOSS_OKHTTP_CRONET.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[Tunnel.MOSS_DOWNGRADE_OKHTTP_CRONET.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[Tunnel.MOSS_GRPC_IGNET.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr[Tunnel.MOSS_STREAM_IGNET.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final FlowControlModel isFlowControl(NetworkEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Tunnel tunnel = event.getTunnel();
        switch (tunnel == null ? -1 : WhenMappings.$EnumSwitchMapping$0[tunnel.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return isHttpFlowControl(event);
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                return isMossFlowControl(event);
            default:
                return new FlowControlModel(false, 0);
        }
    }

    private static final FlowControlModel isHttpFlowControl(NetworkEvent event) {
        if (isHttpFlowControl(event.getHttpCode()) && bizEnabled(event)) {
            Header header = event.getHeader();
            Intrinsics.checkNotNullExpressionValue(header, "getHeader(...)");
            Pair<Boolean, Integer> hasHeader = hasHeader(header);
            boolean hasHeader2 = ((Boolean) hasHeader.component1()).booleanValue();
            int retryAfter = ((Number) hasHeader.component2()).intValue();
            return new FlowControlModel(hasHeader2, retryAfter);
        }
        return new FlowControlModel(false, 0);
    }

    public static final boolean isHttpFlowControl(int httpCode) {
        return httpCode == 429 || httpCode == 503;
    }

    private static final FlowControlModel isMossFlowControl(NetworkEvent event) {
        String grpcStatus = event.getHeader().getGrpcStatus();
        Intrinsics.checkNotNullExpressionValue(grpcStatus, "getGrpcStatus(...)");
        if (isMossFlowControl(grpcStatus) && bizEnabled(event)) {
            Header header = event.getHeader();
            Intrinsics.checkNotNullExpressionValue(header, "getHeader(...)");
            Pair<Boolean, Integer> hasHeader = hasHeader(header);
            boolean hasHeader2 = ((Boolean) hasHeader.component1()).booleanValue();
            int retryAfter = ((Number) hasHeader.component2()).intValue();
            return new FlowControlModel(hasHeader2, retryAfter);
        }
        return new FlowControlModel(false, 0);
    }

    private static final boolean isMossFlowControl(String grpcStatus) {
        return Intrinsics.areEqual(String.valueOf(ConstsKt.getGRPC_STATUS_RESOURCE_EXHAUSTED()), grpcStatus) || Intrinsics.areEqual(String.valueOf(ConstsKt.getGRPC_STATUS_UNAVAILABLE()), grpcStatus);
    }

    public static final boolean hasResponse(NetworkEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return event.getHttpCode() != -1;
    }

    private static final Pair<Boolean, Integer> hasHeader(Header header) {
        String flowControl = header.getFlowControl();
        Intrinsics.checkNotNullExpressionValue(flowControl, "getFlowControl(...)");
        Integer value = StringsKt.toIntOrNull(flowControl);
        if (value != null) {
            return new Pair<>(Boolean.valueOf(value.intValue() > 0), value);
        }
        return new Pair<>(false, 0);
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

    private static final boolean bizEnabled(NetworkEvent event) {
        PathRule.Companion companion = PathRule.Companion;
        String realHost = event.getRealHost();
        Intrinsics.checkNotNullExpressionValue(realHost, "getRealHost(...)");
        String realPath = event.getRealPath();
        Intrinsics.checkNotNullExpressionValue(realPath, "getRealPath(...)");
        return !companion.matches(realHost, realPath, disableList);
    }

    public static final boolean bizEnabled(String host, String patch) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(patch, "patch");
        return !PathRule.Companion.matches(host, patch, disableList);
    }
}