package tv.danmaku.bili.ui.favorite.api;

import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;

public class FavoriteApiManager {
    public static final int PAGE_SIZE = 20;

    public static void getFavTopic(String accessKey, int pn, BiliApiDataCallback<FavTopicData> callback) {
        ((FavoriteService) ServiceGenerator.createService(FavoriteService.class)).getFavTopic(accessKey, pn, 20).enqueue(callback);
    }

    public static void getSecondTab(String accessKey, String tab, BiliApiDataCallback<FavSecondTabData> callback) {
        ((FavoriteService) ServiceGenerator.createService(FavoriteService.class)).getSecondTab(accessKey, tab).enqueue(callback);
    }
}