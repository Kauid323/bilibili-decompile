package tv.danmaku.bili.ui.splash.brand.model;

import android.graphics.Bitmap;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandShowInfo.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000f\u001a\u00020\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/model/SplashImageCache;", "", "<init>", "()V", "splashBitmap", "Landroid/graphics/Bitmap;", "getSplashBitmap", "()Landroid/graphics/Bitmap;", "setSplashBitmap", "(Landroid/graphics/Bitmap;)V", "isPreloaded", "", "()Z", "setPreloaded", "(Z)V", "clear", "", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashImageCache {
    private static boolean isPreloaded;
    private static Bitmap splashBitmap;
    public static final SplashImageCache INSTANCE = new SplashImageCache();
    public static final int $stable = 8;

    private SplashImageCache() {
    }

    public final Bitmap getSplashBitmap() {
        return splashBitmap;
    }

    public final void setSplashBitmap(Bitmap bitmap) {
        splashBitmap = bitmap;
    }

    public final boolean isPreloaded() {
        return isPreloaded;
    }

    public final void setPreloaded(boolean z) {
        isPreloaded = z;
    }

    public final void clear() {
        splashBitmap = null;
        isPreloaded = false;
    }
}