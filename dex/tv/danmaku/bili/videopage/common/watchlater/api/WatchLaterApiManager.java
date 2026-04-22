package tv.danmaku.bili.videopage.common.watchlater.api;

import androidx.lifecycle.LifecycleOwner;
import com.bilibili.app.comm.list.common.utils.BiliCallLifeCycleObserverKt;
import com.bilibili.okretro.BiliApiCallback;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import java.util.List;

public class WatchLaterApiManager {
    private WatchLaterApiManager() {
    }

    public static BiliCall<GeneralResponse<Void>> addToWatchLater(String accessKey, String avid, String from, BiliApiCallback<GeneralResponse<Void>> callback) {
        BiliCall<GeneralResponse<Void>> call = ((WatchLaterService) ServiceGenerator.createService(WatchLaterService.class)).add(accessKey, avid, from);
        call.enqueue(callback);
        return call;
    }

    public static BiliCall<GeneralResponse<WatchLaterList>> getWatchLaterList(LifecycleOwner lifecycleOwner, String accessKey, BiliApiDataCallback<WatchLaterList> callback) {
        BiliCall<GeneralResponse<WatchLaterList>> call = ((WatchLaterService) ServiceGenerator.createService(WatchLaterService.class)).getWatchLaterList(accessKey);
        BiliCallLifeCycleObserverKt.enqueue(call, lifecycleOwner, callback);
        return call;
    }

    public static BiliCall<GeneralResponse<Void>> deleteItem(String accessKey, List<Long> avidList) {
        StringBuilder avidBuilder = new StringBuilder();
        int n = avidList.size();
        for (int i = 0; i < n; i++) {
            avidBuilder.append(avidList.get(i));
            if (i != n - 1) {
                avidBuilder.append(",");
            }
        }
        String avidStr = avidBuilder.toString();
        BiliCall<GeneralResponse<Void>> call = ((WatchLaterService) ServiceGenerator.createService(WatchLaterService.class)).deleteItem(accessKey, avidStr, false);
        call.enqueue();
        return call;
    }

    public static BiliCall<GeneralResponse<Void>> clearWatchedItems(LifecycleOwner lifecycleOwner, String accessKey, BiliApiDataCallback<Void> callback) {
        BiliCall<GeneralResponse<Void>> call = ((WatchLaterService) ServiceGenerator.createService(WatchLaterService.class)).deleteItem(accessKey, null, true);
        BiliCallLifeCycleObserverKt.enqueue(call, lifecycleOwner, callback);
        return call;
    }

    public static BiliCall<Void> clearAll(String accessKey) {
        BiliCall<Void> call = ((WatchLaterService) ServiceGenerator.createService(WatchLaterService.class)).clearAll(accessKey);
        call.enqueue();
        return call;
    }
}