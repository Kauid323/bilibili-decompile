package tv.danmaku.bili.ui.splash.ad.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import java.io.File;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import tv.danmaku.bili.ui.splash.ad.config.BusinessSplashDefine;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BusinessSplashResHelper.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0001H\u0000\"\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u0004\u0018\u00010\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u001a\u0010\u0006\u001a\u00020\u0007*\u0004\u0018\u00010\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"md5ToFileUri", "", "md5ToFile", "Ljava/io/File;", "getMd5ToFile", "(Ljava/lang/String;)Ljava/io/File;", "md5ToImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "getMd5ToImageBitmap", "(Ljava/lang/String;)Landroidx/compose/ui/graphics/ImageBitmap;", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BusinessSplashResHelperKt {
    public static final String md5ToFileUri(String $this$md5ToFileUri) {
        File $this$md5ToFileUri_u24lambda_u240;
        String str = $this$md5ToFileUri;
        if ((str == null || StringsKt.isBlank(str)) || ($this$md5ToFileUri_u24lambda_u240 = BusinessSplashResHelper.fetchResourceFileByHash($this$md5ToFileUri)) == null) {
            return null;
        }
        return BusinessSplashDefine.FILE_URI_PREFIX + $this$md5ToFileUri_u24lambda_u240.getAbsolutePath();
    }

    public static final File getMd5ToFile(String $this$md5ToFile) {
        String str = $this$md5ToFile;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        return BusinessSplashResHelper.fetchResourceFileByHash($this$md5ToFile);
    }

    public static final ImageBitmap getMd5ToImageBitmap(String $this$md5ToImageBitmap) {
        File md5ToFile;
        String $this$_get_md5ToImageBitmap__u24lambda_u240;
        if ($this$md5ToImageBitmap != null && (md5ToFile = getMd5ToFile($this$md5ToImageBitmap)) != null && ($this$_get_md5ToImageBitmap__u24lambda_u240 = md5ToFile.getPath()) != null) {
            ImageBitmap imageBitmap = null;
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile($this$_get_md5ToImageBitmap__u24lambda_u240);
                if (decodeFile != null) {
                    imageBitmap = AndroidImageBitmap_androidKt.asImageBitmap(decodeFile);
                }
            } catch (Exception e) {
            }
            if (imageBitmap != null) {
                return imageBitmap;
            }
        }
        return ImageBitmapKt.ImageBitmap-x__-hDU$default(1, 1, 0, false, (ColorSpace) null, 28, (Object) null);
    }
}