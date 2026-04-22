package tv.danmaku.bili.ui.splash.ad.model;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import tv.danmaku.biliplayerimpl.toast.left.viewholder.ActionMessageWithAnimationVH;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: SplashShowStrategy.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010+\u001a\u00020\u0017H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\"\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020)8G¢\u0006\u0006\u001a\u0004\b(\u0010*¨\u0006,"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/model/SplashShowStrategy;", "", "<init>", "()V", "originIndex", "", "getOriginIndex", "()I", "setOriginIndex", "(I)V", "id", "", "getId", "()J", "setId", "(J)V", "stime", "getStime", "setStime", "etime", "getEtime", "setEtime", PeakTaskDefine.AD_CB, "", "getAdCb", "()Ljava/lang/String;", "setAdCb", "(Ljava/lang/String;)V", "splashContent", "Ltv/danmaku/bili/ui/splash/ad/model/Splash;", "getSplashContent", "()Ltv/danmaku/bili/ui/splash/ad/model/Splash;", "setSplashContent", "(Ltv/danmaku/bili/ui/splash/ad/model/Splash;)V", "banner", "Lcom/alibaba/fastjson/JSONObject;", "getBanner", "()Lcom/alibaba/fastjson/JSONObject;", "setBanner", "(Lcom/alibaba/fastjson/JSONObject;)V", "isValid", "", "()Z", "toString", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashShowStrategy {
    public static final int $stable = 8;
    @JSONField(name = "ad_cb")
    private String adCb;
    @JSONField(name = "banner")
    private JSONObject banner;
    @JSONField(name = "etime")
    private long etime;
    @JSONField(name = "id")
    private long id;
    @JSONField(deserialize = false, serialize = false)
    private int originIndex = ActionMessageWithAnimationVH.INVALID_COLOR_INT;
    @JSONField(name = "splash_content")
    private Splash splashContent;
    @JSONField(name = "stime")
    private long stime;

    public final int getOriginIndex() {
        return this.originIndex;
    }

    public final void setOriginIndex(int i) {
        this.originIndex = i;
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final long getStime() {
        return this.stime;
    }

    public final void setStime(long j) {
        this.stime = j;
    }

    public final long getEtime() {
        return this.etime;
    }

    public final void setEtime(long j) {
        this.etime = j;
    }

    public final String getAdCb() {
        return this.adCb;
    }

    public final void setAdCb(String str) {
        this.adCb = str;
    }

    public final Splash getSplashContent() {
        return this.splashContent;
    }

    public final void setSplashContent(Splash splash) {
        this.splashContent = splash;
    }

    public final JSONObject getBanner() {
        return this.banner;
    }

    public final void setBanner(JSONObject jSONObject) {
        this.banner = jSONObject;
    }

    @JSONField(deserialize = false, serialize = false)
    public final boolean isValid() {
        long currentTime = System.currentTimeMillis() / ((long) IjkMediaCodecInfo.RANK_MAX);
        return currentTime <= this.etime && this.stime <= currentTime;
    }

    public String toString() {
        int i = this.originIndex;
        long j = this.id;
        long j2 = this.stime;
        long j3 = this.etime;
        String str = this.adCb;
        return "SplashShowStrategy(originIndex=" + i + ", id=" + j + ", stime=" + j2 + ", etime=" + j3 + ", adCb=" + str + ", splashContent=" + this.splashContent + ")";
    }
}