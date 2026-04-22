package tv.danmaku.bili.videopage.common.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.TypedValue;
import com.bilibili.droid.MediaUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public class ImageUtils {
    public static Bitmap compositeScreenShot(Bitmap chronosBitmap, Rect videoRenderRect, Bitmap videoBitmap, Drawable logo, String detailText, DisplayMetrics metrics, boolean mirror) {
        if (videoRenderRect != null) {
            if (videoRenderRect.width() <= 0 && videoRenderRect.height() <= 0) {
                return null;
            }
            Rect videoDisplayRect = new Rect();
            videoDisplayRect.left = Math.max(videoRenderRect.left, 0);
            videoDisplayRect.right = Math.max(videoRenderRect.right, 0);
            videoDisplayRect.top = Math.max(videoRenderRect.top, 0);
            videoDisplayRect.bottom = Math.max(videoRenderRect.bottom, 0);
            Bitmap bitmap = Bitmap.createBitmap(videoDisplayRect.width(), videoDisplayRect.height(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            canvas.drawColor(-16777216);
            Paint p = new Paint();
            p.setAntiAlias(true);
            p.setFilterBitmap(true);
            p.setDither(true);
            if (videoBitmap != null && !videoBitmap.isRecycled()) {
                int width = videoBitmap.getWidth();
                int height = videoBitmap.getHeight();
                float scaleWidth = videoDisplayRect.width() / width;
                float scaleHeight = videoDisplayRect.height() / height;
                Matrix matrix = new Matrix();
                matrix.postScale(scaleWidth, scaleHeight);
                if (mirror) {
                    matrix.postScale(-1.0f, 1.0f);
                    matrix.postTranslate(width * scaleWidth, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                }
                canvas.drawBitmap(videoBitmap, matrix, p);
            }
            if (chronosBitmap != null && !chronosBitmap.isRecycled()) {
                drawBitmapInset(chronosBitmap, videoDisplayRect, canvas, p);
            }
            if (logo != null && !TextUtils.isEmpty(detailText)) {
                int sixDP = (int) TypedValue.applyDimension(1, 6.0f, metrics);
                int top = (canvas.getHeight() - logo.getIntrinsicHeight()) - sixDP;
                int bottom = logo.getIntrinsicHeight() + top;
                logo.setBounds(sixDP, top, logo.getIntrinsicWidth() + sixDP, bottom);
                logo.draw(canvas);
                int twDP = (int) TypedValue.applyDimension(1, 12.0f, metrics);
                p.setTextSize(twDP);
                p.setColor(DanmakuConfig.COLOR_DEFAULT);
                p.setAlpha(63);
                Rect rect = logo != null ? logo.getBounds() : null;
                float ttop = (((canvas.getHeight() - p.getTextSize()) - p.ascent()) - sixDP) - 7.0f;
                canvas.drawText(detailText, rect.right, ttop, p);
                return bitmap;
            }
            return bitmap;
        }
        return null;
    }

    private static void drawBitmapInset(Bitmap drawBitmap, Rect insetRect, Canvas canvas, Paint p) {
        int width = drawBitmap.getWidth();
        int height = drawBitmap.getHeight();
        Rect displayDanmakuRect = new Rect(0, 0, width, height);
        boolean intersect = displayDanmakuRect.intersect(insetRect);
        if (intersect) {
            canvas.drawBitmap(drawBitmap, displayDanmakuRect, new Rect(0, 0, displayDanmakuRect.width(), displayDanmakuRect.height()), p);
        }
    }

    public static Pair<Boolean, Uri> writeBitmapToFile(Context context, Bitmap src, String path) {
        String publicDirectoryName = getPublicDirectoryName(path);
        if (Build.VERSION.SDK_INT >= 29 && !TextUtils.isEmpty(publicDirectoryName) && context != null) {
            Uri uri = MediaUtils.insertMediaToPictureFolderSync(context, src, publicDirectoryName, path);
            return new Pair<>(Boolean.valueOf(uri != null), uri);
        }
        File file = new File(path);
        FileOutputStream fOut = null;
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            fOut = new FileOutputStream(file);
            src.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            fOut.flush();
            return new Pair<>(true, null);
        } catch (IOException e) {
            return new Pair<>(false, null);
        } finally {
            closeSilently(fOut);
        }
    }

    private static String getPublicDirectoryName(String path) {
        if (path.contains(Environment.DIRECTORY_PICTURES)) {
            String directory = Environment.DIRECTORY_PICTURES;
            return directory;
        } else if (!path.contains(Environment.DIRECTORY_DCIM)) {
            return null;
        } else {
            String directory2 = Environment.DIRECTORY_DCIM;
            return directory2;
        }
    }

    public static String bitmapToBase64(Bitmap bitmap) {
        String result = "";
        ByteArrayOutputStream baos = null;
        try {
            try {
                if (bitmap != null) {
                    try {
                        if (!bitmap.isRecycled()) {
                            baos = new ByteArrayOutputStream();
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                            baos.flush();
                            baos.close();
                            byte[] bitmapBytes = baos.toByteArray();
                            result = Base64.encodeToString(bitmapBytes, 0);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        if (baos != null) {
                            baos.flush();
                            baos.close();
                        }
                    }
                }
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return result;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    baos.flush();
                    baos.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    private static void closeSilently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Bitmap createCircleBitmap(Bitmap resource) {
        int width = resource.getWidth();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap circleBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(circleBitmap);
        canvas.drawCircle(width / 2.0f, width / 2.0f, width / 2.0f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(resource, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, paint);
        return circleBitmap;
    }
}