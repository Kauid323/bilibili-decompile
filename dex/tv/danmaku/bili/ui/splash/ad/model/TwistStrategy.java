package tv.danmaku.bili.ui.splash.ad.model;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: TwistStrategy.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/model/TwistStrategy;", "", "<init>", "()V", "xType", "", "getXType", "()I", "setXType", "(I)V", "yType", "getYType", "setYType", "zType", "getZType", "setZType", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class TwistStrategy {
    public static final int $stable = 8;
    @JSONField(name = "twist_x_type")
    private int xType;
    @JSONField(name = "twist_y_type")
    private int yType;
    @JSONField(name = "twist_z_type")
    private int zType;

    public final int getXType() {
        return this.xType;
    }

    public final void setXType(int i) {
        this.xType = i;
    }

    public final int getYType() {
        return this.yType;
    }

    public final void setYType(int i) {
        this.yType = i;
    }

    public final int getZType() {
        return this.zType;
    }

    public final void setZType(int i) {
        this.zType = i;
    }
}