package tv.danmaku.bili.ui.splash.brand.model;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.resmanager.ResManager;
import com.bilibili.lib.resmanager.ResResponse;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.ui.splash.brand.config.BrandSplashStorage;
import tv.danmaku.bili.ui.splash.utils.ResManagerExtentionKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandShowInfo.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0002\u001a\u000e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u0004\u0018\u00010\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"uniqueId", "", "Ltv/danmaku/bili/ui/splash/brand/model/BrandShowInfo;", "getUniqueId", "(Ltv/danmaku/bili/ui/splash/brand/model/BrandShowInfo;)Ljava/lang/String;", "isForceShowValid", "", "getBitmap", "Landroid/graphics/Bitmap;", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandShowInfoKt {
    public static final String getUniqueId(BrandShowInfo $this$uniqueId) {
        Intrinsics.checkNotNullParameter($this$uniqueId, "<this>");
        long id = $this$uniqueId.getId();
        return id + "-" + $this$uniqueId.getSource();
    }

    public static final boolean isForceShowValid(BrandShowInfo $this$isForceShowValid) {
        Intrinsics.checkNotNullParameter($this$isForceShowValid, "<this>");
        Application context = BiliContext.application();
        return context != null && $this$isForceShowValid.isForce() && BrandSplashStorage.INSTANCE.isBrandSplashShowCountNotLimit(context, $this$isForceShowValid.getForceShowTimes(), $this$isForceShowValid.getId());
    }

    public static final Bitmap getBitmap(BrandShowInfo $this$getBitmap) {
        Application context;
        if ($this$getBitmap == null || (context = BiliContext.application()) == null) {
            return null;
        }
        if ($this$getBitmap.isDefault()) {
            if (!SplashImageCache.INSTANCE.isPreloaded()) {
                SplashImageCache.INSTANCE.setSplashBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_splash_default));
                SplashImageCache.INSTANCE.setPreloaded(true);
                Log.w("StartupOptimize", "Fail to use splash image preloaded");
            } else {
                Log.i("StartupOptimize", "Sucess to use splash image preloaded");
            }
            Bitmap it = SplashImageCache.INSTANCE.getSplashBitmap();
            if (it == null || it.isRecycled()) {
                return null;
            }
            return it;
        }
        ResResponse splashRes = ResManagerExtentionKt.getSplashRes(ResManager.INSTANCE, $this$getBitmap.getThumbHash());
        File file = splashRes != null ? splashRes.getFile() : null;
        BLog.i("BrandShowInfo", "get getBitmap url" + $this$getBitmap.getThumb() + " hash:" + $this$getBitmap.getThumbHash());
        if (file == null) {
            return null;
        }
        return BitmapFactory.decodeFile(file.getAbsolutePath());
    }
}