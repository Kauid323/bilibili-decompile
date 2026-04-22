package tv.danmaku.bili.flowcontrol.internal.model;

import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: RetryAfterPolicy.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/flowcontrol/internal/model/RetryAfterPolicy;", "", "valueInSeconds", "", "<init>", "(I)V", "delay", "", "getDelay", "()J", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RetryAfterPolicy {
    private final long delay;

    public RetryAfterPolicy(int valueInSeconds) {
        this.delay = valueInSeconds * 1000;
    }

    public final long getDelay() {
        return this.delay;
    }
}