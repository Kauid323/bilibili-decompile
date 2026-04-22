package tv.danmaku.bili.ui.splash.ad.model;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import tv.danmaku.bili.videopage.common.callback.ShareIconObserverKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BezierParam.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/model/BezierParam;", "", "<init>", "()V", "start", "Ltv/danmaku/bili/ui/splash/ad/model/BezierPoint;", "getStart", "()Ltv/danmaku/bili/ui/splash/ad/model/BezierPoint;", "setStart", "(Ltv/danmaku/bili/ui/splash/ad/model/BezierPoint;)V", ShareIconObserverKt.SHARE_FROM_END, "getEnd", "setEnd", "control1", "getControl1", "setControl1", "control2", "getControl2", "setControl2", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BezierParam {
    public static final int $stable = 8;
    @JSONField(name = "control1")
    private BezierPoint control1;
    @JSONField(name = "control2")
    private BezierPoint control2;
    @JSONField(name = ShareIconObserverKt.SHARE_FROM_END)
    private BezierPoint end;
    @JSONField(name = "start")
    private BezierPoint start;

    public final BezierPoint getStart() {
        return this.start;
    }

    public final void setStart(BezierPoint bezierPoint) {
        this.start = bezierPoint;
    }

    public final BezierPoint getEnd() {
        return this.end;
    }

    public final void setEnd(BezierPoint bezierPoint) {
        this.end = bezierPoint;
    }

    public final BezierPoint getControl1() {
        return this.control1;
    }

    public final void setControl1(BezierPoint bezierPoint) {
        this.control1 = bezierPoint;
    }

    public final BezierPoint getControl2() {
        return this.control2;
    }

    public final void setControl2(BezierPoint bezierPoint) {
        this.control2 = bezierPoint;
    }
}