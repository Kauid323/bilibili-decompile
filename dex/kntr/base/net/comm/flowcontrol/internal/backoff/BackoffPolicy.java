package kntr.base.net.comm.flowcontrol.internal.backoff;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.random.Random;

/* compiled from: BackoffPolicy.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkntr/base/net/comm/flowcontrol/internal/backoff/BackoffPolicy;", "", "maxTimes", "", "initialDelay", "maxDelay", "factor", "", "jitter", "<init>", "(IIIFF)V", "min", "max", "rdm", "Lkotlin/random/Random$Default;", "current", "", "times", "toJsonString", "", "flow_control_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BackoffPolicy {
    private long current;
    private final float factor;
    private final int initialDelay;
    private final float jitter;
    private final int max;
    private final int maxTimes;
    private final int min;
    private final Random.Default rdm;
    private int times;

    public BackoffPolicy() {
        this(0, 0, 0, 0.0f, 0.0f, 31, null);
    }

    public BackoffPolicy(int maxTimes, int initialDelay, int maxDelay, float factor, float jitter) {
        this.maxTimes = maxTimes;
        this.initialDelay = initialDelay;
        float it = Math.abs(factor);
        this.factor = it <= 1.0f ? 1.0f + it : it;
        this.jitter = Math.min(this.factor, Math.abs(jitter));
        this.min = this.initialDelay * Math.max(600, MathKt.roundToInt((this.factor - this.jitter) * ((float) MediaAttrUtils.TYPE_PAY_SEASON)));
        this.max = maxDelay * MediaAttrUtils.TYPE_PAY_SEASON;
        this.rdm = Random.Default;
        this.current = this.initialDelay * 1000;
    }

    public /* synthetic */ BackoffPolicy(int i, int i2, int i3, float f, float f2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 3 : i, (i4 & 2) == 0 ? i2 : 3, (i4 & 4) != 0 ? 120 : i3, (i4 & 8) != 0 ? 1.6f : f, (i4 & 16) != 0 ? 0.2f : f2);
    }

    public final String toJsonString() {
        int i = this.maxTimes;
        int i2 = this.initialDelay;
        int i3 = this.min;
        return "max_times:" + i + " initial_delay:" + i2 + " min:" + i3 + " max:" + this.max;
    }
}