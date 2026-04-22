package tv.danmaku.bili.ui.tag.api;

import android.content.Context;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import java.util.List;
import retrofit2.http.QueryMap;
import tv.danmaku.bili.ui.tag.api.VideoTagService;

public class TagDetailApiManager {
    public static void getTagList(Context context, @QueryMap VideoTagService.TagParamsMap paramsMap, BiliApiDataCallback<List<Tagv2>> callback) {
        String accessKey = BiliAccounts.get(context).getAccessKey();
        BiliCall<GeneralResponse<List<Tagv2>>> call = ((VideoTagService) ServiceGenerator.createService(VideoTagService.class)).getTagList(paramsMap, accessKey);
        call.enqueue(callback);
    }
}