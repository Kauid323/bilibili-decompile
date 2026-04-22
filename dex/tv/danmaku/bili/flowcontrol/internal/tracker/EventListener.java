package tv.danmaku.bili.flowcontrol.internal.tracker;

import com.bilibili.lib.rpc.flowcontrol.FlowControlReporter;
import com.bilibili.lib.rpc.track.model.flowcontrol.Event;
import com.bilibili.lib.rpc.track.model.flowcontrol.FlowControlEvent;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;

/* compiled from: EventListener.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007J&\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/flowcontrol/internal/tracker/EventListener;", "", "consumer", "Lcom/bilibili/lib/rpc/flowcontrol/FlowControlReporter;", "<init>", "(Lcom/bilibili/lib/rpc/flowcontrol/FlowControlReporter;)V", "uuid", "", "onBlocked", "", ReportEvent.Tag.HOST, FileChooserActivity.PATH, "block", "duration", "", ReportUtilKt.POS_UPDATE, "", "unblock", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class EventListener {
    private final FlowControlReporter consumer;
    private final String uuid;

    public EventListener(FlowControlReporter consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        this.consumer = consumer;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        this.uuid = uuid;
    }

    public final void onBlocked(String host, String path) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        FlowControlEvent.Builder $this$onBlocked_u24lambda_u240 = FlowControlEvent.newBuilder();
        $this$onBlocked_u24lambda_u240.setEvent(Event.BLOCKED);
        $this$onBlocked_u24lambda_u240.setHost(host);
        $this$onBlocked_u24lambda_u240.setPath(path);
        $this$onBlocked_u24lambda_u240.setGuid(this.uuid);
        FlowControlEvent event = $this$onBlocked_u24lambda_u240.build();
        FlowControlReporter flowControlReporter = this.consumer;
        Intrinsics.checkNotNull(event);
        flowControlReporter.report(event);
    }

    public final void block(String host, String path, long duration, int update) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        FlowControlEvent.Builder $this$block_u24lambda_u240 = FlowControlEvent.newBuilder();
        $this$block_u24lambda_u240.setEvent(Event.BLOCK);
        $this$block_u24lambda_u240.setHost(host);
        $this$block_u24lambda_u240.setPath(path);
        $this$block_u24lambda_u240.setGuid(this.uuid);
        $this$block_u24lambda_u240.setBlockDuration(duration);
        $this$block_u24lambda_u240.setBlockUpdate(update);
        FlowControlEvent event = $this$block_u24lambda_u240.build();
        FlowControlReporter flowControlReporter = this.consumer;
        Intrinsics.checkNotNull(event);
        flowControlReporter.report(event);
    }

    public final void unblock(String host, String path) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        FlowControlEvent.Builder $this$unblock_u24lambda_u240 = FlowControlEvent.newBuilder();
        $this$unblock_u24lambda_u240.setEvent(Event.UNBLOCK);
        $this$unblock_u24lambda_u240.setHost(host);
        $this$unblock_u24lambda_u240.setPath(path);
        $this$unblock_u24lambda_u240.setGuid(this.uuid);
        FlowControlEvent event = $this$unblock_u24lambda_u240.build();
        FlowControlReporter flowControlReporter = this.consumer;
        Intrinsics.checkNotNull(event);
        flowControlReporter.report(event);
    }
}