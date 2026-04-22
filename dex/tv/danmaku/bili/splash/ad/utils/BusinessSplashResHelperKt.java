package tv.danmaku.bili.splash.ad.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import com.bilibili.commons.security.DigestUtils;
import com.bilibili.lib.resmanager.ResManager;
import com.bilibili.lib.resmanager.ResRequest;
import com.bilibili.lib.resmanager.ResResponse;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.util.AppResUtil;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefine;

/* compiled from: BusinessSplashResHelper.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0000\"\u0014\u0010\u0000\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003\"\u001a\u0010\f\u001a\u00020\r*\u0004\u0018\u00010\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000e\"\u001c\u0010\u000f\u001a\u0004\u0018\u00010\t*\u0004\u0018\u00010\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"\u001a\u0010\u0012\u001a\u00020\u0013*\u0004\u0018\u00010\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"backupBirthdayResourceUrl", "", "getBackupBirthdayResourceUrl", "()Ljava/lang/String;", "backupBirthdayResourceKey", "getBackupBirthdayResourceKey", "fetchResourceLocalPathByHash", "key", "fetchResourceFileByHash", "Ljava/io/File;", "hash", "fetchResourceLocalUriPathByHash", "isFileExistByMd5", "", "(Ljava/lang/String;)Z", "md5ToFile", "getMd5ToFile", "(Ljava/lang/String;)Ljava/io/File;", "md5ToImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "getMd5ToImageBitmap", "(Ljava/lang/String;)Landroidx/compose/ui/graphics/ImageBitmap;", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BusinessSplashResHelperKt {
    public static final /* synthetic */ String access$getBackupBirthdayResourceKey() {
        return getBackupBirthdayResourceKey();
    }

    private static final String getBackupBirthdayResourceUrl() {
        String imageUrl = AppResUtil.getImageUrl("core_ic_splash_birth.webp");
        Intrinsics.checkNotNullExpressionValue(imageUrl, "getImageUrl(...)");
        return imageUrl;
    }

    public static final String getBackupBirthdayResourceKey() {
        return "birthday_image_" + DigestUtils.md5(getBackupBirthdayResourceUrl());
    }

    public static final String fetchResourceLocalPathByHash(String key) {
        ResResponse fetch;
        if (key == null || (fetch = ResManager.fetch(new ResRequest((String) null, key))) == null) {
            return null;
        }
        return fetch.getPath();
    }

    public static final File fetchResourceFileByHash(String hash) {
        ResResponse fetch;
        File it;
        String str = hash;
        if ((str == null || StringsKt.isBlank(str)) || (fetch = ResManager.fetch(new ResRequest((String) null, hash))) == null || (it = fetch.getFile()) == null || !it.exists()) {
            return null;
        }
        return it;
    }

    public static final String fetchResourceLocalUriPathByHash(String hash) {
        File $this$fetchResourceLocalUriPathByHash_u24lambda_u240;
        String str = hash;
        if ((str == null || StringsKt.isBlank(str)) || ($this$fetchResourceLocalUriPathByHash_u24lambda_u240 = fetchResourceFileByHash(hash)) == null) {
            return null;
        }
        return BusinessSplashDefine.FILE_URI_PREFIX + $this$fetchResourceLocalUriPathByHash_u24lambda_u240.getAbsolutePath();
    }

    public static final boolean isFileExistByMd5(String $this$isFileExistByMd5) {
        if ($this$isFileExistByMd5 == null) {
            return false;
        }
        return BusinessSplashResHelper.INSTANCE.isResourceExistByHash($this$isFileExistByMd5);
    }

    public static final File getMd5ToFile(String $this$md5ToFile) {
        String str = $this$md5ToFile;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        return fetchResourceFileByHash($this$md5ToFile);
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