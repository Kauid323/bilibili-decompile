package tv.danmaku.bili.ui.splash;

import kotlin.Metadata;
import tv.danmaku.bili.ui.splash.ad.util.BusinessSplashResHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashLite.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020)R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001c\u0010%\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018¨\u0006+"}, d2 = {"Ltv/danmaku/bili/ui/splash/SplashLite;", "", "<init>", "()V", "id", "", "getId", "()J", "setId", "(J)V", "cardType", "", "getCardType", "()I", "setCardType", "(I)V", "type", "getType", "setType", "imageHash", "", "getImageHash", "()Ljava/lang/String;", "setImageHash", "(Ljava/lang/String;)V", "videoHash", "getVideoHash", "setVideoHash", "exposeCount", "getExposeCount", "setExposeCount", "lastExposeTime", "getLastExposeTime", "setLastExposeTime", "beginTime", "getBeginTime", "setBeginTime", "endTime", "getEndTime", "setEndTime", "isImageExists", "", "isVideoExists", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashLite {
    public static final int $stable = 8;
    private String beginTime;
    private int cardType;
    private String endTime;
    private int exposeCount;
    private long id;
    private String imageHash;
    private String lastExposeTime;
    private int type;
    private String videoHash;

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final int getCardType() {
        return this.cardType;
    }

    public final void setCardType(int i) {
        this.cardType = i;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final String getImageHash() {
        return this.imageHash;
    }

    public final void setImageHash(String str) {
        this.imageHash = str;
    }

    public final String getVideoHash() {
        return this.videoHash;
    }

    public final void setVideoHash(String str) {
        this.videoHash = str;
    }

    public final int getExposeCount() {
        return this.exposeCount;
    }

    public final void setExposeCount(int i) {
        this.exposeCount = i;
    }

    public final String getLastExposeTime() {
        return this.lastExposeTime;
    }

    public final void setLastExposeTime(String str) {
        this.lastExposeTime = str;
    }

    public final String getBeginTime() {
        return this.beginTime;
    }

    public final void setBeginTime(String str) {
        this.beginTime = str;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final void setEndTime(String str) {
        this.endTime = str;
    }

    public final boolean isImageExists() {
        return BusinessSplashResHelper.isResourceExistByHash(this.imageHash);
    }

    public final boolean isVideoExists() {
        return BusinessSplashResHelper.isResourceExistByHash(this.videoHash);
    }
}