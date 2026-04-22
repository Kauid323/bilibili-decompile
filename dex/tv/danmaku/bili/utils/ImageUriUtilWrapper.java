package tv.danmaku.bili.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.bilibili.lib.image2.ImageLog;
import com.bilibili.lib.image2.common.UrlUtil;

public class ImageUriUtilWrapper {
    public static String getImageStyle(Uri uri) {
        if (uri != null) {
            return UrlUtil.getImageStyle(uri);
        }
        return null;
    }

    public static String getImageStyle(String url) {
        try {
            if (!TextUtils.isEmpty(url)) {
                return getImageStyle(Uri.parse(url));
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    @Deprecated
    public static boolean isBfsImageUrlByLegacyRule(Uri uri) {
        return UrlUtil.isBfsImageUrlByLegacyRule(uri);
    }

    public static boolean isBfsImageUrl(String url) {
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        try {
            return UrlUtil.isBfsImageUrl(Uri.parse(url));
        } catch (Throwable t) {
            ImageLog.INSTANCE.w("ImageUriUtilWrapper", "isBfsImageUrl: " + t.getMessage());
            return false;
        }
    }
}