package tv.danmaku.bili.splash.ad.model;

import android.graphics.Bitmap;
import com.bilibili.adcommon.data.IAdInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.flowcontrol.internal.config.FlowControlConfig;

/* compiled from: SplashExtra.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\u001a\u0010+\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\u001c\u0010.\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u0010\u0016R\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\bR\u001a\u0010:\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0006\"\u0004\b<\u0010\bR\u001c\u0010=\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0014\"\u0004\b?\u0010\u0016¨\u0006@"}, d2 = {"Ltv/danmaku/bili/splash/ad/model/SplashExtra;", "", "<init>", "()V", "isFromCalledUp", "", "()Z", "setFromCalledUp", "(Z)V", "isEggVideoPlayed", "setEggVideoPlayed", "realTimeSplashBitmap", "Landroid/graphics/Bitmap;", "getRealTimeSplashBitmap", "()Landroid/graphics/Bitmap;", "setRealTimeSplashBitmap", "(Landroid/graphics/Bitmap;)V", "imageFrom", "", "getImageFrom", "()Ljava/lang/String;", "setImageFrom", "(Ljava/lang/String;)V", "videoFrom", "getVideoFrom", "setVideoFrom", "localSplashImageSize", "", "getLocalSplashImageSize", "()J", "setLocalSplashImageSize", "(J)V", "localSplashVideoSize", "getLocalSplashVideoSize", "setLocalSplashVideoSize", "originRealTimeShowIndex", "", "getOriginRealTimeShowIndex", "()I", "setOriginRealTimeShowIndex", "(I)V", "isHotSplash", "setHotSplash", "localSecondPageButtonDegraded", "getLocalSecondPageButtonDegraded", "setLocalSecondPageButtonDegraded", "splashRequestId", "getSplashRequestId", "setSplashRequestId", "adInfoData", "Lcom/bilibili/adcommon/data/IAdInfo;", "getAdInfoData", "()Lcom/bilibili/adcommon/data/IAdInfo;", "setAdInfoData", "(Lcom/bilibili/adcommon/data/IAdInfo;)V", "realtimeMaterialLoadSuccess", "getRealtimeMaterialLoadSuccess", "setRealtimeMaterialLoadSuccess", "fromRealShow", "getFromRealShow", "setFromRealShow", "bindBanner", "getBindBanner", "setBindBanner", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashExtra {
    public static final int $stable = 8;
    private transient IAdInfo adInfoData;
    private transient String bindBanner;
    private transient boolean fromRealShow;
    private transient boolean isEggVideoPlayed;
    private transient boolean isFromCalledUp;
    private transient boolean isHotSplash;
    private transient boolean localSecondPageButtonDegraded;
    private transient long localSplashImageSize;
    private transient long localSplashVideoSize;
    private transient Bitmap realTimeSplashBitmap;
    private transient boolean realtimeMaterialLoadSuccess;
    private transient String splashRequestId;
    private transient String imageFrom = "local";
    private transient String videoFrom = "local";
    private transient int originRealTimeShowIndex = FlowControlConfig.RETRY_MAX_TIMES;

    public final boolean isFromCalledUp() {
        return this.isFromCalledUp;
    }

    public final void setFromCalledUp(boolean z) {
        this.isFromCalledUp = z;
    }

    public final boolean isEggVideoPlayed() {
        return this.isEggVideoPlayed;
    }

    public final void setEggVideoPlayed(boolean z) {
        this.isEggVideoPlayed = z;
    }

    public final Bitmap getRealTimeSplashBitmap() {
        return this.realTimeSplashBitmap;
    }

    public final void setRealTimeSplashBitmap(Bitmap bitmap) {
        this.realTimeSplashBitmap = bitmap;
    }

    public final String getImageFrom() {
        return this.imageFrom;
    }

    public final void setImageFrom(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imageFrom = str;
    }

    public final String getVideoFrom() {
        return this.videoFrom;
    }

    public final void setVideoFrom(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoFrom = str;
    }

    public final long getLocalSplashImageSize() {
        return this.localSplashImageSize;
    }

    public final void setLocalSplashImageSize(long j) {
        this.localSplashImageSize = j;
    }

    public final long getLocalSplashVideoSize() {
        return this.localSplashVideoSize;
    }

    public final void setLocalSplashVideoSize(long j) {
        this.localSplashVideoSize = j;
    }

    public final int getOriginRealTimeShowIndex() {
        return this.originRealTimeShowIndex;
    }

    public final void setOriginRealTimeShowIndex(int i) {
        this.originRealTimeShowIndex = i;
    }

    public final boolean isHotSplash() {
        return this.isHotSplash;
    }

    public final void setHotSplash(boolean z) {
        this.isHotSplash = z;
    }

    public final boolean getLocalSecondPageButtonDegraded() {
        return this.localSecondPageButtonDegraded;
    }

    public final void setLocalSecondPageButtonDegraded(boolean z) {
        this.localSecondPageButtonDegraded = z;
    }

    public final String getSplashRequestId() {
        return this.splashRequestId;
    }

    public final void setSplashRequestId(String str) {
        this.splashRequestId = str;
    }

    public final IAdInfo getAdInfoData() {
        return this.adInfoData;
    }

    public final void setAdInfoData(IAdInfo iAdInfo) {
        this.adInfoData = iAdInfo;
    }

    public final boolean getRealtimeMaterialLoadSuccess() {
        return this.realtimeMaterialLoadSuccess;
    }

    public final void setRealtimeMaterialLoadSuccess(boolean z) {
        this.realtimeMaterialLoadSuccess = z;
    }

    public final boolean getFromRealShow() {
        return this.fromRealShow;
    }

    public final void setFromRealShow(boolean z) {
        this.fromRealShow = z;
    }

    public final String getBindBanner() {
        return this.bindBanner;
    }

    public final void setBindBanner(String str) {
        this.bindBanner = str;
    }
}