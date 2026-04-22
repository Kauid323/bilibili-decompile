package tv.danmaku.bili.ui.splash.ad.model;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashVideoInfo.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/model/SplashVideoInfo;", "", "<init>", "()V", "avid", "", "getAvid", "()J", "setAvid", "(J)V", "cid", "getCid", "setCid", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashVideoInfo {
    public static final int $stable = 8;
    @JSONField(name = "avid")
    private long avid;
    @JSONField(name = "cid")
    private long cid;

    public final long getAvid() {
        return this.avid;
    }

    public final void setAvid(long j) {
        this.avid = j;
    }

    public final long getCid() {
        return this.cid;
    }

    public final void setCid(long j) {
        this.cid = j;
    }
}