package tv.danmaku.bili.ui.notice.api;

import com.bilibili.okretro.call.BiliCall;
import retrofit2.http.BaseUrl;
import retrofit2.http.GET;
import retrofit2.http.Query;

@BaseUrl("https://app.bilibili.com")
public interface NoticeService {
    @GET("/x/v2/notice?plat=0")
    BiliCall<BiliNotice> getNotice(@Query("channel") String str, @Query("type") int i, @Query("ver") String str2);
}