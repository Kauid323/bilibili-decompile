package tv.danmaku.bili.ui.appeal;

import com.alibaba.fastjson.JSONObject;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.anno.RequestInterceptor;
import com.bilibili.okretro.call.BiliCall;
import com.bilibili.okretro.interceptor.SignOnUrlRequestInterceptor;
import java.util.List;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.BaseUrl;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

@BaseUrl("https://app.bilibili.com")
public interface VideoAppealApi {
    @FormUrlEncoded
    @POST("/x/v2/view/report/add")
    BiliCall<GeneralResponse<Void>> add(@Field("mid") long j, @Field("access_key") String str, @Field("aid") String str2, @Field("type") String str3, @Field("reason") String str4, @Field("pics") String str5);

    @POST("/x/v2/view/report/upload")
    @RequestInterceptor(SignOnUrlRequestInterceptor.class)
    @Multipart
    BiliCall<JSONObject> appealImageUpload(@Query("access_key") String str, @Part("aid") RequestBody requestBody, @Part("mid") RequestBody requestBody2, @Part MultipartBody.Part part);

    @GET("/x/v2/view/report")
    BiliCall<GeneralResponse<List<BiliVideoAppeal>>> init(@Query("mid") long j, @Query("access_key") String str, @Query("aid") String str2);
}