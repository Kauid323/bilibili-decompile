package tv.danmaku.bili.flowcontrol.internal.protocol;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.flowcontrol.internal.config.FlowControlConfig;
import tv.danmaku.bili.flowcontrol.internal.model.RetryAfterPolicy;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;

/* compiled from: RetryAfter.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006\u001a\b\u0010\u0007\u001a\u00020\u0006H\u0002\u001a\b\u0010\b\u001a\u00020\u0006H\u0002¨\u0006\t"}, d2 = {"blockPolicy", "Ltv/danmaku/bili/flowcontrol/internal/model/RetryAfterPolicy;", ReportEvent.Tag.HOST, "", FileChooserActivity.PATH, "retryAter", "", "minRetryAfter", "maxRetryAfter", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RetryAfterKt {
    public static final RetryAfterPolicy blockPolicy(String host, String path, int retryAter) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        int min = minRetryAfter();
        int max = maxRetryAfter();
        if (retryAter < min) {
            return new RetryAfterPolicy(min);
        }
        if (retryAter > max) {
            return new RetryAfterPolicy(max);
        }
        return new RetryAfterPolicy(retryAter);
    }

    private static final int minRetryAfter() {
        Integer minRetryAfter = FlowControlConfig.INSTANCE.getMinRetryAfter();
        if (minRetryAfter != null) {
            return minRetryAfter.intValue();
        }
        return 3;
    }

    private static final int maxRetryAfter() {
        Integer maxRetryAfter = FlowControlConfig.INSTANCE.getMaxRetryAfter();
        if (maxRetryAfter != null) {
            return maxRetryAfter.intValue();
        }
        return 15;
    }
}