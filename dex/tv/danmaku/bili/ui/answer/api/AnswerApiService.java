package tv.danmaku.bili.ui.answer.api;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.call.BiliCall;
import retrofit2.http.BaseUrl;
import retrofit2.http.GET;
import retrofit2.http.Query;

@BaseUrl("https://api.bilibili.com")
public interface AnswerApiService {
    @GET("/x/answer/v4/guide")
    BiliCall<GeneralResponse<AnswerGuideData>> getAnswerGuide(@Query("access_key") String str, @Query("business") String str2, @Query("spmid") String str3, @Query("oid") String str4, @Query("sid") String str5);
}