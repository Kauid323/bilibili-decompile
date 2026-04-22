package tv.danmaku.bili.ui.main2.api;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.call.BiliCall;
import retrofit2.http.BaseUrl;
import retrofit2.http.GET;
import retrofit2.http.Query;

@BaseUrl("https://app.bilibili.com")
public interface AccountApiService {
    @GET("/x/v2/account/mine")
    BiliCall<GeneralResponse<AccountMine>> getMine(@Query("access_key") String str, @Query("bili_link_new") String str2, @Query("from") String str3, @Query("creative_info") String str4);

    @GET("/x/v2/family/teen_guard")
    BiliCall<GeneralResponse<TeenGuardData>> getTeenGuardType();
}