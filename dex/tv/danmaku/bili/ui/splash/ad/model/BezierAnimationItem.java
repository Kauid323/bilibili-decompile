package tv.danmaku.bili.ui.splash.ad.model;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BezierAnimationItem.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/model/BezierAnimationItem;", "", "<init>", "()V", "type", "", "getType", "()I", "setType", "(I)V", "delay", "", "getDelay", "()J", "setDelay", "(J)V", "duration", "getDuration", "setDuration", "param", "Ltv/danmaku/bili/ui/splash/ad/model/BezierParam;", "getParam", "()Ltv/danmaku/bili/ui/splash/ad/model/BezierParam;", "setParam", "(Ltv/danmaku/bili/ui/splash/ad/model/BezierParam;)V", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BezierAnimationItem {
    public static final int $stable = 8;
    @JSONField(name = "delay")
    private long delay;
    @JSONField(name = "duration")
    private long duration;
    @JSONField(name = "param")
    private BezierParam param;
    @JSONField(name = "type")
    private int type;

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final long getDelay() {
        return this.delay;
    }

    public final void setDelay(long j) {
        this.delay = j;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final void setDuration(long j) {
        this.duration = j;
    }

    public final BezierParam getParam() {
        return this.param;
    }

    public final void setParam(BezierParam bezierParam) {
        this.param = bezierParam;
    }
}