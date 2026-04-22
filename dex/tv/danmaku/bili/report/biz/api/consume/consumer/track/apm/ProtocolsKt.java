package tv.danmaku.bili.report.biz.api.consume.consumer.track.apm;

import com.bilibili.lib.rpc.track.model.NetworkEvent;
import com.bilibili.lib.rpc.track.model.Tunnel;
import com.bilibili.lib.rpc.track.util.HttpUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: Protocols.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u000e\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001\u001a\u000e\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006\u001a\u0016\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001\u001a\u000e\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0011"}, d2 = {"tunnelToIntString", "", "engine", "Lcom/bilibili/lib/rpc/track/model/Tunnel;", "booleanToInStr", "v", "", "methodToIntStr", "method", "bizCode", "bizError", "exception", ChannelRoutes.CHANNEL_NAME, "message", "command", "event", "Lcom/bilibili/lib/rpc/track/model/NetworkEvent;", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ProtocolsKt {

    /* compiled from: Protocols.kt */
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
                iArr[Tunnel.BBC_SOCKET.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Tunnel.OKHTTP_CRONET.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Tunnel.MOSS_CRONET.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[Tunnel.MOSS_OKHTTP.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[Tunnel.MOSS_DOWNGRADE_OKHTTP.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[Tunnel.MOSS_STREAM_CRONET.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[Tunnel.MOSS_OKHTTP_CRONET.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[Tunnel.MOSS_DOWNGRADE_OKHTTP_CRONET.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[Tunnel.HTTPDNS_CHROMIUM_NET.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[Tunnel.CRONET.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[Tunnel.CRONET_JAVA.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr[Tunnel.IJK_HTTP.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr[Tunnel.IJK_P2P.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                iArr[Tunnel.MOSS_REST_OKHTTP.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                iArr[Tunnel.MOSS_REST_OKHTTP_CRONET.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                iArr[Tunnel.OKHTTP_IGNET.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                iArr[Tunnel.MOSS_GRPC_IGNET.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
            try {
                iArr[Tunnel.MOSS_STREAM_IGNET.ordinal()] = 19;
            } catch (NoSuchFieldError e19) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String tunnelToIntString(Tunnel engine) {
        TunnelSdk t;
        Intrinsics.checkNotNullParameter(engine, "engine");
        switch (WhenMappings.$EnumSwitchMapping$0[engine.ordinal()]) {
            case 1:
                t = TunnelSdk.OKHTTP;
                break;
            case 2:
                t = TunnelSdk.BBC_SOCKET;
                break;
            case 3:
                t = TunnelSdk.OKHTTP_CRONET;
                break;
            case 4:
                t = TunnelSdk.MOSS_CRONET;
                break;
            case 5:
                t = TunnelSdk.MOSS_OKHTTP;
                break;
            case 6:
                t = TunnelSdk.MOSS_DOWNGRADE_OKHTTP;
                break;
            case 7:
                t = TunnelSdk.MOSS_STREAM_CRONET;
                break;
            case 8:
                t = TunnelSdk.MOSS_OKHTTP_CRONET;
                break;
            case 9:
                t = TunnelSdk.MOSS_DOWNGRADE_OKHTTP_CRONET;
                break;
            case 10:
                t = TunnelSdk.HTTPDNS_CHROMIUM_NET;
                break;
            case 11:
                t = TunnelSdk.CRONET;
                break;
            case 12:
                t = TunnelSdk.CRONET_JAVA;
                break;
            case 13:
                t = TunnelSdk.IJK_HTTP;
                break;
            case 14:
                t = TunnelSdk.IJK_P2P;
                break;
            case 15:
                t = TunnelSdk.MOSS_REST_OKHTTP;
                break;
            case 16:
                t = TunnelSdk.MOSS_REST_OKHTTP_CRONET;
                break;
            case 17:
                t = TunnelSdk.OKHTTP_IGNET;
                break;
            case 18:
                t = TunnelSdk.MOSS_GRPC_IGNET;
                break;
            case 19:
                t = TunnelSdk.MOSS_STREAM_IGNET;
                break;
            default:
                t = TunnelSdk.OKHTTP;
                break;
        }
        return t.getValue();
    }

    public static final String booleanToInStr(boolean v) {
        if (v) {
            return "1";
        }
        return "0";
    }

    public static final String methodToIntStr(String method) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -531492226:
                return !method.equals("OPTIONS") ? "0" : "6";
            case 70454:
                if (!method.equals("GET")) {
                }
                return "0";
            case 79599:
                return !method.equals("PUT") ? "0" : "3";
            case 2213344:
                return !method.equals("HEAD") ? "0" : "2";
            case 2461856:
                return !method.equals("POST") ? "0" : "1";
            case 80083237:
                return !method.equals("TRACE") ? "0" : LoginReporterV2.Show.LOGIN_SUCCEED_NA_PHONE_REGISTER;
            case 1669334218:
                return !method.equals("CONNECT") ? "0" : "5";
            case 2012838315:
                return !method.equals("DELETE") ? "0" : "4";
            default:
                return "0";
        }
    }

    public static final String bizCode(boolean bizError) {
        return bizError ? "1001" : "0";
    }

    public static final String exception(String name, String message) {
        Intrinsics.checkNotNullParameter(name, ChannelRoutes.CHANNEL_NAME);
        Intrinsics.checkNotNullParameter(message, "message");
        return name + " " + message;
    }

    public static final String command(NetworkEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String logicalUrl = event.getLogicalUrl();
        if (!(logicalUrl == null || StringsKt.isBlank(logicalUrl))) {
            String logicalScheme = event.getLogicalScheme();
            Intrinsics.checkNotNullExpressionValue(logicalScheme, "getLogicalScheme(...)");
            String logicalHost = event.getLogicalHost();
            Intrinsics.checkNotNullExpressionValue(logicalHost, "getLogicalHost(...)");
            String logicalPath = event.getLogicalPath();
            Intrinsics.checkNotNullExpressionValue(logicalPath, "getLogicalPath(...)");
            return HttpUtilsKt.url(logicalScheme, logicalHost, logicalPath);
        }
        String scheme = event.getScheme();
        Intrinsics.checkNotNullExpressionValue(scheme, "getScheme(...)");
        String host = event.getHost();
        Intrinsics.checkNotNullExpressionValue(host, "getHost(...)");
        String path = event.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        return HttpUtilsKt.url(scheme, host, path);
    }
}