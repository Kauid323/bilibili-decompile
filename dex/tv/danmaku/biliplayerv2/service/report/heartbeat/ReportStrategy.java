package tv.danmaku.biliplayerv2.service.report.heartbeat;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IHeartbeatService.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerv2/service/report/heartbeat/ReportStrategy;", "", "<init>", "()V", "NORMAL", "LIVE", "Ltv/danmaku/biliplayerv2/service/report/heartbeat/ReportStrategy$LIVE;", "Ltv/danmaku/biliplayerv2/service/report/heartbeat/ReportStrategy$NORMAL;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class ReportStrategy {
    public /* synthetic */ ReportStrategy(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: IHeartbeatService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/biliplayerv2/service/report/heartbeat/ReportStrategy$NORMAL;", "Ltv/danmaku/biliplayerv2/service/report/heartbeat/ReportStrategy;", "<init>", "()V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class NORMAL extends ReportStrategy {
        public static final NORMAL INSTANCE = new NORMAL();

        private NORMAL() {
            super(null);
        }
    }

    private ReportStrategy() {
    }

    /* compiled from: IHeartbeatService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/biliplayerv2/service/report/heartbeat/ReportStrategy$LIVE;", "Ltv/danmaku/biliplayerv2/service/report/heartbeat/ReportStrategy;", "<init>", "()V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class LIVE extends ReportStrategy {
        public static final LIVE INSTANCE = new LIVE();

        private LIVE() {
            super(null);
        }
    }
}