package tv.danmaku.bili.appwidget.hotlist.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.bilibili.commons.security.DigestUtils;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.hotlist.model.HotListWidgetItemModel;

/* compiled from: ImageUtil.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a,\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\n\u001a*\u0010\u0002\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\u000e\u001a*\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\u000e\u001a\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\tH\u0002\u001a$\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001\u001a\u0010\u0010\u0016\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"TAG", "", "downloadHotListCover", "Ljava/io/File;", "context", "Landroid/content/Context;", "item", "Ltv/danmaku/bili/appwidget/hotlist/model/HotListWidgetItemModel;", "index", "", "(Landroid/content/Context;Ltv/danmaku/bili/appwidget/hotlist/model/HotListWidgetItemModel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/graphics/Bitmap;", "url", "desiredWidthSize", "(Landroid/content/Context;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadHotListCoverFile", "getBitmapFromFile", "file", "desiredSize", "saveFileToProvider", "Landroid/net/Uri;", "sourceFile", "getFileName", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ImageUtilKt {
    private static final String TAG = "HotListImageUtil";

    public static /* synthetic */ Object downloadHotListCover$default(Context context, HotListWidgetItemModel hotListWidgetItemModel, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            hotListWidgetItemModel = null;
        }
        return downloadHotListCover(context, hotListWidgetItemModel, i, continuation);
    }

    public static final Object downloadHotListCover(Context context, HotListWidgetItemModel item, int index, Continuation<? super File> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ImageUtilKt$downloadHotListCover$2(context, item, index, null), continuation);
    }

    public static final Object downloadHotListCover(Context context, String url, int desiredWidthSize, Continuation<? super Bitmap> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ImageUtilKt$downloadHotListCover$4(url, context, desiredWidthSize, null), continuation);
    }

    public static final Object downloadHotListCoverFile(Context context, String url, int desiredWidthSize, Continuation<? super File> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ImageUtilKt$downloadHotListCoverFile$2(url, context, desiredWidthSize, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap getBitmapFromFile(File file, int desiredSize) {
        if (file == null || file.length() <= 0) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getPath(), options);
            if (options.outHeight != 0 && options.outWidth != 0) {
                options.inSampleSize = BitmapLoadUtils.calculateInSampleSize(options, desiredSize, desiredSize);
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

    public static final Uri saveFileToProvider(Context context, File sourceFile, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (sourceFile != null) {
            String str = url;
            if (!(str == null || StringsKt.isBlank(str))) {
                try {
                    File file = new File(context.getCacheDir(), "op_cover_image");
                    file.mkdirs();
                    File drawableFile = new File(file, getFileName(url));
                    FilesKt.copyTo$default(sourceFile, drawableFile, true, 0, 4, (Object) null);
                    return FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", drawableFile);
                } catch (Exception e) {
                    BLog.e(TAG, "save bitmap to file error,", e);
                    return null;
                }
            }
        }
        return null;
    }

    private static final String getFileName(String url) {
        String md5 = DigestUtils.md5(url);
        Intrinsics.checkNotNullExpressionValue(md5, "md5(...)");
        return md5;
    }
}