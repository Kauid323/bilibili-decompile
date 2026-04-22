package tv.danmaku.bili.category;

import com.bilibili.okretro.call.BiliCall;
import retrofit2.http.BaseUrl;
import retrofit2.http.GET;
import retrofit2.http.Query;

@BaseUrl("https://app.bilibili.com")
interface RegionService {
    @GET("/x/v2/region/index")
    BiliCall<CategoryMeta> getRegionV2List(@Query("ver") String str);
}