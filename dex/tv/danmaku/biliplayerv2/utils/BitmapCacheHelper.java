package tv.danmaku.biliplayerv2.utils;

import android.graphics.Bitmap;
import com.bilibili.cache.CacheManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BitmapCacheHelper.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Ltv/danmaku/biliplayerv2/utils/BitmapCacheHelper;", "", "<init>", "()V", "getBitmap", "Landroid/graphics/Bitmap;", "key", "", "saveBitmap", "", "bmp", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BitmapCacheHelper {
    public static final BitmapCacheHelper INSTANCE = new BitmapCacheHelper();

    private BitmapCacheHelper() {
    }

    public final Bitmap getBitmap(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return CacheManager.get(key);
    }

    public final void saveBitmap(String key, Bitmap bmp) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(bmp, "bmp");
        CacheManager.put(key, bmp);
    }
}