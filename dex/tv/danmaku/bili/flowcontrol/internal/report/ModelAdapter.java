package tv.danmaku.bili.flowcontrol.internal.report;

import com.bilibili.lib.rpc.track.model.flowcontrol.FlowControlEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;

/* compiled from: ModelAdapter.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/flowcontrol/internal/report/ModelAdapter;", "", "<init>", "()V", "adapt", "", "", "event", "Lcom/bilibili/lib/rpc/track/model/flowcontrol/FlowControlEvent;", "rate", "", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ModelAdapter {
    public static final ModelAdapter INSTANCE = new ModelAdapter();

    private ModelAdapter() {
    }

    public final Map<String, String> adapt(FlowControlEvent event, float rate) {
        Intrinsics.checkNotNullParameter(event, "event");
        String lowerCase = event.getEvent().toString().toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("event", lowerCase), TuplesKt.to(ReportEvent.Tag.HOST, event.getHost()), TuplesKt.to(FileChooserActivity.PATH, event.getPath()), TuplesKt.to("guid", event.getGuid()), TuplesKt.to("block_duration", String.valueOf(event.getBlockDuration())), TuplesKt.to("block_update", String.valueOf(event.getBlockUpdate())), TuplesKt.to("rate", String.valueOf(rate))});
    }
}