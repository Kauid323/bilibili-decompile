package tv.danmaku.bili.splash.ad.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.bili.BR;

/* compiled from: ImageUtils.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0080@¢\u0006\u0002\u0010\u0007\u001a \u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u000b"}, d2 = {"decodeBitmap", "Landroid/graphics/Bitmap;", "imagePath", "", "reqWidth", "", "reqHeight", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateInSampleSize", "options", "Landroid/graphics/BitmapFactory$Options;", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ImageUtilsKt {
    public static final Object decodeBitmap(String imagePath, int reqWidth, int reqHeight, Continuation<? super Bitmap> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ImageUtilsKt$decodeBitmap$2(imagePath, reqWidth, reqHeight, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        if (height <= reqHeight && width <= reqWidth) {
            return 1;
        }
        int heightRatio = Math.round(height / reqHeight);
        int widthRatio = Math.round(width / reqWidth);
        int inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        return inSampleSize;
    }
}