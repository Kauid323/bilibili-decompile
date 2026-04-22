package tv.danmaku.bili.flowcontrol.api;

import com.bilibili.lib.rpc.flowcontrol.FlowControl;
import com.bilibili.lib.rpc.track.model.NetworkEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;

/* compiled from: FlowControls.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0017J-\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/flowcontrol/api/FlowControls;", "Lcom/bilibili/lib/rpc/flowcontrol/FlowControl;", "<init>", "()V", "onResponse", "", "event", "Lcom/bilibili/lib/rpc/track/model/NetworkEvent;", "onRequest", "", ReportEvent.Tag.HOST, "", FileChooserActivity.PATH, "httpCode", "", "after", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)V", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FlowControls implements FlowControl {
    public static final FlowControls INSTANCE = new FlowControls();

    private FlowControls() {
    }

    public void onResponse(NetworkEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        tv.danmaku.bili.flowcontrol.internal.FlowControls.INSTANCE.onResponse(event);
    }

    public boolean onRequest(String host, String path) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        return tv.danmaku.bili.flowcontrol.internal.FlowControls.INSTANCE.onRequest(host, path);
    }

    public final void onResponse(String host, String path, int httpCode, Integer after) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        tv.danmaku.bili.flowcontrol.internal.FlowControls.INSTANCE.onResponse(host, path, httpCode, after);
    }
}