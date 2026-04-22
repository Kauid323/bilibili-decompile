package tv.danmaku.android.util;

import com.bilibili.lib.blconfig.ConfigManager;

public class AppResUtil {
    private static String CACHED_IMAGE_URL_PREFIX = null;

    public static String getImageUrl(String imageName) {
        return getImageUrlPrefix() + imageName;
    }

    public static String getImageUrlPrefix() {
        if (CACHED_IMAGE_URL_PREFIX == null) {
            synchronized (AppResUtil.class) {
                if (CACHED_IMAGE_URL_PREFIX == null) {
                    CACHED_IMAGE_URL_PREFIX = (String) ConfigManager.config().get("base_app_big_image_url_prefix", "https://i0.hdslb.com/bfs/app-res/android/");
                }
            }
        }
        return CACHED_IMAGE_URL_PREFIX;
    }
}