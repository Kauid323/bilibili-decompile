package tv.danmaku.bili.appwidget.upcard.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: ImageUtil.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a6\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0086@¢\u0006\u0002\u0010\n\u001a$\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"TAG", "", "downloadUpCardCover", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "url", "size", "Lkotlin/Pair;", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/Pair;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBitmapFromFile", "file", "Ljava/io/File;", "desiredWidth", "desiredHeight", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ImageUtilKt {
    private static final String TAG = "UpCardImageUtil";

    public static final Object downloadUpCardCover(Context context, String url, Pair<Integer, Integer> pair, Continuation<? super Bitmap> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ImageUtilKt$downloadUpCardCover$2(url, context, pair, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap getBitmapFromFile(File file, int desiredWidth, int desiredHeight) {
        if (file == null || file.length() <= 0) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getPath(), options);
            if (options.outHeight != 0 && options.outWidth != 0) {
                options.inSampleSize = BitmapLoadUtils.calculateInSampleSize(options, desiredWidth, desiredHeight);
                options.inJustDecodeBounds = false;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                return BitmapFactory.decodeFile(file.getPath(), options);
            }
            return null;
        } catch (Exception e) {
            BLog.e(TAG, "decodeFile error,", e);
            return null;
        }
    }
}