package tv.danmaku.biliplayerv2.service.report;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IReporterService.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerv2/service/report/ReportStrategy;", "", "<init>", "()V", "CUSTOMIZED", "DEFAULT", "Ltv/danmaku/biliplayerv2/service/report/ReportStrategy$CUSTOMIZED;", "Ltv/danmaku/biliplayerv2/service/report/ReportStrategy$DEFAULT;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class ReportStrategy {
    public /* synthetic */ ReportStrategy(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ReportStrategy() {
    }

    /* compiled from: IReporterService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/biliplayerv2/service/report/ReportStrategy$CUSTOMIZED;", "Ltv/danmaku/biliplayerv2/service/report/ReportStrategy;", "<init>", "()V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class CUSTOMIZED extends ReportStrategy {
        public static final CUSTOMIZED INSTANCE = new CUSTOMIZED();

        private CUSTOMIZED() {
            super(null);
        }
    }

    /* compiled from: IReporterService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/biliplayerv2/service/report/ReportStrategy$DEFAULT;", "Ltv/danmaku/biliplayerv2/service/report/ReportStrategy;", "<init>", "()V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DEFAULT extends ReportStrategy {
        public static final DEFAULT INSTANCE = new DEFAULT();

        private DEFAULT() {
            super(null);
        }
    }
}