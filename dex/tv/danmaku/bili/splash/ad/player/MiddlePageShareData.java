package tv.danmaku.bili.splash.ad.player;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.SplashMiddlePageInfo;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: SplashMediaPlayerManager.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\u001f\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006/"}, d2 = {"Ltv/danmaku/bili/splash/ad/player/MiddlePageShareData;", "", "<init>", "()V", "jumpUrl", "", "getJumpUrl", "()Ljava/lang/String;", "setJumpUrl", "(Ljava/lang/String;)V", "schema", "getSchema", "setSchema", UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH, "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "getSplash", "()Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "setSplash", "(Ltv/danmaku/bili/splash/ad/model/SplashOrder;)V", "playerWidth", "", "getPlayerWidth", "()I", "setPlayerWidth", "(I)V", "playerHeight", "getPlayerHeight", "setPlayerHeight", "videoWidth", "getVideoWidth", "setVideoWidth", "videoHeight", "getVideoHeight", "setVideoHeight", "middlePageInfo", "Ltv/danmaku/bili/splash/ad/model/SplashMiddlePageInfo;", "getMiddlePageInfo", "()Ltv/danmaku/bili/splash/ad/model/SplashMiddlePageInfo;", "setMiddlePageInfo", "(Ltv/danmaku/bili/splash/ad/model/SplashMiddlePageInfo;)V", "takeLatestScreenshot", "Lkotlin/Function0;", "Landroid/graphics/Bitmap;", "getTakeLatestScreenshot", "()Lkotlin/jvm/functions/Function0;", "setTakeLatestScreenshot", "(Lkotlin/jvm/functions/Function0;)V", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MiddlePageShareData {
    public static final int $stable = 8;
    private String jumpUrl;
    private SplashMiddlePageInfo middlePageInfo;
    private String schema;
    private SplashOrder splash;
    private int playerWidth = 1080;
    private int playerHeight = 1920;
    private int videoWidth = 1080;
    private int videoHeight = 1920;
    private Function0<Bitmap> takeLatestScreenshot = new Function0() { // from class: tv.danmaku.bili.splash.ad.player.MiddlePageShareData$takeLatestScreenshot$1
        public final Void invoke() {
            return null;
        }
    };

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final void setSchema(String str) {
        this.schema = str;
    }

    public final SplashOrder getSplash() {
        return this.splash;
    }

    public final void setSplash(SplashOrder splashOrder) {
        this.splash = splashOrder;
    }

    public final int getPlayerWidth() {
        return this.playerWidth;
    }

    public final void setPlayerWidth(int i) {
        this.playerWidth = i;
    }

    public final int getPlayerHeight() {
        return this.playerHeight;
    }

    public final void setPlayerHeight(int i) {
        this.playerHeight = i;
    }

    public final int getVideoWidth() {
        return this.videoWidth;
    }

    public final void setVideoWidth(int i) {
        this.videoWidth = i;
    }

    public final int getVideoHeight() {
        return this.videoHeight;
    }

    public final void setVideoHeight(int i) {
        this.videoHeight = i;
    }

    public final SplashMiddlePageInfo getMiddlePageInfo() {
        return this.middlePageInfo;
    }

    public final void setMiddlePageInfo(SplashMiddlePageInfo splashMiddlePageInfo) {
        this.middlePageInfo = splashMiddlePageInfo;
    }

    public final Function0<Bitmap> getTakeLatestScreenshot() {
        return this.takeLatestScreenshot;
    }

    public final void setTakeLatestScreenshot(Function0<Bitmap> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.takeLatestScreenshot = function0;
    }
}