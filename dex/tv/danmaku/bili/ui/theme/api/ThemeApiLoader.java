package tv.danmaku.bili.ui.theme.api;

import com.bilibili.okretro.BiliApiCallback;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;

public class ThemeApiLoader {
    public static void getList(String accessKey, BiliApiCallback<BiliSkinList> callback) {
        ((BiliThemeApiService) ServiceGenerator.createService(BiliThemeApiService.class)).getThemeList(accessKey).enqueue(callback);
    }

    public static void addOrder(String accessKey, int id, BiliApiDataCallback<OrderResult> callback) {
        ((BiliThemeApiService) ServiceGenerator.createService(BiliThemeApiService.class)).addOrder(accessKey, id).enqueue(callback);
    }

    public static void cancelOrder(String accessKey, int id, BiliApiDataCallback<OrderResult> callback) {
        ((BiliThemeApiService) ServiceGenerator.createService(BiliThemeApiService.class)).cancelOrder(accessKey, id).enqueue(callback);
    }
}