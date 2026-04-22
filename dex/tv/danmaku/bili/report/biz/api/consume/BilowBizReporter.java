package tv.danmaku.bili.report.biz.api.consume;

import com.bilibili.lib.rpc.report.BizReporter;
import com.bilibili.lib.rpc.track.model.BizEvent;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: BilowBizReporter.kt */
@Deprecated(message = "Network track only.")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/report/biz/api/consume/BilowBizReporter;", "Lcom/bilibili/lib/rpc/report/BizReporter;", "<init>", "()V", "report", "", "event", "Lcom/bilibili/lib/rpc/track/model/BizEvent;", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BilowBizReporter implements BizReporter {
    public void report(BizEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }
}