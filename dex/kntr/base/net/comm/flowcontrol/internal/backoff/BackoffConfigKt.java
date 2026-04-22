package kntr.base.net.comm.flowcontrol.internal.backoff;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BackoffConfig.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"RETRY_MAX_TIMES", "", "INITIAL_DELAY_SECONDS", "MAX_DELAY_SECONDS", "FACTOR", "", "JITTER", "newPolicy", "Lkntr/base/net/comm/flowcontrol/internal/backoff/BackoffPolicy;", "Lkntr/base/net/comm/flowcontrol/internal/backoff/BackoffConfig;", "flow_control_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BackoffConfigKt {
    public static final float FACTOR = 1.6f;
    public static final int INITIAL_DELAY_SECONDS = 3;
    public static final float JITTER = 0.2f;
    public static final int MAX_DELAY_SECONDS = 120;
    public static final int RETRY_MAX_TIMES = 3;

    public static final BackoffPolicy newPolicy(BackoffConfig $this$newPolicy) {
        Intrinsics.checkNotNullParameter($this$newPolicy, "<this>");
        return new BackoffPolicy($this$newPolicy.getMaxTimes(), $this$newPolicy.getInitialDelay(), $this$newPolicy.getMaxDelay(), $this$newPolicy.getFactor(), $this$newPolicy.getJitter());
    }
}