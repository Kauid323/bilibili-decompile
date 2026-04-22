package tv.danmaku.bili.utils;

import android.content.Intent;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Environment;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.UriCompatUtils;
import com.bilibili.lib.ui.BaseFragment;
import java.io.File;
import tv.danmaku.android.log.BLog;

public class PhotoUtil {
    public static final int GALLERY_REQUEST_CODE = 202;
    public static final String PHOTO_FILE_NAME = "temp_photo.jpg";
    public static final int PHOTO_REQUEST_CAREMA = 301;

    public static void startGallery(BaseFragment fragment) {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        fragment.startActivityForResult(intent, (int) GALLERY_REQUEST_CODE);
    }

    public static void startCamera(BaseFragment fragment) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (hasSdcard()) {
            try {
                File tempFile = new File(fragment.getContext().getExternalFilesDir(null), PHOTO_FILE_NAME);
                Uri uri = UriCompatUtils.fromFile(BiliContext.application(), tempFile);
                intent.putExtra("output", uri);
            } catch (Exception e) {
                BLog.d("PhotoUtil", "create file error from uri", e);
            }
        }
        fragment.startActivityForResult(intent, 301);
    }

    public static File getTempFile() {
        if (!hasSdcard()) {
            return null;
        }
        File tempFile = new File(BiliContext.application().getExternalFilesDir(null), PHOTO_FILE_NAME);
        return tempFile;
    }

    public static boolean hasSdcard() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0019, code lost:
        if (0 == 0) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x001c, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000a, code lost:
        if (r1 != null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000c, code lost:
        r1.release();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isCameraValid() {
        boolean isValid = false;
        Camera camera = null;
        try {
            camera = Camera.open();
            if (camera != null) {
                isValid = true;
            }
        } catch (Exception e) {
            isValid = false;
        } catch (Throwable th) {
            if (0 != 0) {
                camera.release();
            }
            throw th;
        }
    }
}