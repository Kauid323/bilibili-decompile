package tv.danmaku.bili.videopage.common.api;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.call.BiliCall;
import retrofit2.http.BaseUrl;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

@BaseUrl("https://api.bilibili.com")
public interface VideoTagService {
    @FormUrlEncoded
    @POST("/x/tag/archive/report")
    BiliCall<GeneralResponse<Void>> reportTag(@Field("access_key") String str, @Field("aid") long j, @Field("tag_id") long j2, @Field("reason") String str2);
}