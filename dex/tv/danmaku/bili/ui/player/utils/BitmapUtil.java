package tv.danmaku.bili.ui.player.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import com.bilibili.lib.okhttp.OkHttpClientWrapper;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import okhttp3.Request;
import okhttp3.Response;
import tv.danmaku.android.log.BLog;

public class BitmapUtil {
    private static final int MAX_READ_LIMIT_PER_IMG = 1048576;
    private static final String REPORT_FILE = "/reportImage/";
    private static final String TAG = "BitmapUtil";

    public static Bitmap decodeFile(String path, float width, float height) {
        int inSampleSize = getInSampleSize(path, width, height);
        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        newOpts.inSampleSize = inSampleSize;
        newOpts.inJustDecodeBounds = false;
        newOpts.inPreferredConfig = Bitmap.Config.RGB_565;
        return BitmapFactory.decodeFile(path, newOpts);
    }

    private static int getInSampleSize(String path, float width, float height) {
        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        newOpts.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, newOpts);
        int outWidth = newOpts.outWidth;
        int outHeight = newOpts.outHeight;
        int be = (int) getScale(width, height, outWidth, outHeight);
        return be;
    }

    public static double getScale(float targetWidth, float targetHeight, float bmpWidth, float bmpHeight) {
        double be;
        if (bmpWidth >= bmpHeight) {
            float widthScale = bmpWidth / targetHeight;
            float heigthScale = bmpHeight / targetWidth;
            if (widthScale >= heigthScale) {
                be = Math.rint(widthScale);
            } else {
                be = Math.rint(heigthScale);
            }
        } else {
            float widthScale2 = bmpWidth / targetWidth;
            float heigthScale2 = bmpHeight / targetHeight;
            if (widthScale2 >= heigthScale2) {
                be = widthScale2;
            } else {
                be = heigthScale2;
            }
        }
        if (be <= 0.0d) {
            return 1.0d;
        }
        return be;
    }

    public static Bitmap scaleBitmap(Bitmap src, int maxWidth, int maxHeight) {
        if (src == null) {
            return null;
        }
        double scaleFactor = Math.min(maxWidth / src.getWidth(), maxHeight / src.getHeight());
        return Bitmap.createScaledBitmap(src, (int) (src.getWidth() * scaleFactor), (int) (src.getHeight() * scaleFactor), false);
    }

    public static Bitmap scaleBitmap(int scaleFactor, InputStream is) {
        if (is == null) {
            return null;
        }
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        return BitmapFactory.decodeStream(is, null, bmOptions);
    }

    public static int findScaleFactor(int targetW, int targetH, InputStream is) {
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(is, null, bmOptions);
        int actualW = bmOptions.outWidth;
        int actualH = bmOptions.outHeight;
        return Math.min(actualW / targetW, actualH / targetH);
    }

    public static Bitmap fetchAndRescaleBitmap(String uri, int width, int height) throws IOException {
        BufferedInputStream is = null;
        try {
            try {
                Request request = new Request.Builder().url(uri).get().build();
                Response response = OkHttpClientWrapper.get().newBuilder().build().newCall(request).execute();
                if (response == null || !response.isSuccessful() || response.body() == null) {
                }
                is = new BufferedInputStream(response.body().byteStream());
                is.mark(MAX_READ_LIMIT_PER_IMG);
                int scaleFactor = findScaleFactor(width, height, is);
                is.reset();
                Bitmap scaleBitmap = scaleBitmap(scaleFactor, is);
                is.close();
                return scaleBitmap;
            } catch (RuntimeException e) {
                BLog.e(TAG, "Exception happened:" + e);
                throw new IOException(e);
            }
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    public static Bitmap createBitmapFromColor(int width, int heigh, int color) {
        Bitmap bmp = Bitmap.createBitmap(width, heigh, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bmp);
        canvas.drawColor(color);
        return bmp;
    }

    public static File saveBitmapToExternal(Context context, Bitmap bitmap, int maxSize) {
        File targetFileDir = getImageCacheFileDir(context);
        if (bitmap == null || bitmap.isRecycled() || targetFileDir == null) {
            return null;
        }
        if (!targetFileDir.exists()) {
            targetFileDir.mkdirs();
        }
        File targetFile = new File(targetFileDir, UUID.randomUUID().toString());
        if (targetFile.exists()) {
            return null;
        }
        byte[] bmpBytes = bmpToByteArray(bitmap, maxSize, true);
        FileOutputStream fos = null;
        try {
            try {
                fos = new FileOutputStream(targetFile);
                try {
                    fos.write(bmpBytes);
                    try {
                        fos.flush();
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return targetFile;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    try {
                        fos.flush();
                        fos.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    return null;
                }
            } catch (FileNotFoundException e4) {
                e4.printStackTrace();
                if (fos != null) {
                    try {
                        fos.flush();
                        fos.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Throwable th) {
            if (fos != null) {
                try {
                    fos.flush();
                    fos.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    private static File getImageCacheFileDir(Context context) {
        File extCacheFile = context.getExternalCacheDir();
        if (extCacheFile == null) {
            return null;
        }
        return new File(extCacheFile.getPath() + REPORT_FILE);
    }

    public static byte[] bmpToByteArray(Bitmap bmp, int maxSize, boolean needRecycle) {
        if (bmp == null) {
            return null;
        }
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        int options = 90;
        bmp.compress(Bitmap.CompressFormat.JPEG, 90, output);
        for (int outputLength = output.toByteArray().length; outputLength > maxSize; outputLength = output.toByteArray().length) {
            if (outputLength > maxSize * 10) {
                options -= 50;
            } else if (outputLength > maxSize * 2) {
                options -= 20;
            } else {
                options -= 10;
            }
            output.reset();
            bmp.compress(Bitmap.CompressFormat.JPEG, options, output);
        }
        if (needRecycle) {
            bmp.recycle();
        }
        byte[] result = output.toByteArray();
        try {
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}