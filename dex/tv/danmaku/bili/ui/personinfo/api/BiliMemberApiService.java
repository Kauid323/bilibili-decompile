package tv.danmaku.bili.ui.personinfo.api;

import com.alibaba.fastjson.JSONObject;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.anno.RequestInterceptor;
import com.bilibili.okretro.call.BiliCall;
import com.bilibili.okretro.interceptor.SignOnUrlRequestInterceptor;
import okhttp3.RequestBody;
import retrofit2.http.BaseUrl;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

@BaseUrl("https://api.bilibili.com")
public interface BiliMemberApiService {
    @GET("/x/member/app/birthday/changed")
    BiliCall<GeneralResponse<BirthdayModified>> birthdayModified();

    @GET("/x/member/app/nickfree")
    BiliCall<GeneralResponse<JSONObject>> getNickFree(@Query("access_key") String str);

    @GET("/x/member/app/point/flag")
    BiliCall<GeneralResponse<PointFlagBean>> getPointFlag(@Query("access_key") String str);

    @FormUrlEncoded
    @POST("/x/member/app/birthday/update")
    BiliCall<GeneralResponse<Void>> modifyBirthday(@Query("access_key") String str, @Field("birthday") String str2);

    @FormUrlEncoded
    @POST("/x/member/app/sex/update")
    BiliCall<GeneralResponse<Void>> modifySex(@Query("access_key") String str, @Field("sex") int i);

    @FormUrlEncoded
    @POST("/x/member/app/sign/update")
    BiliCall<GeneralResponse<Void>> modifySignature(@Query("access_key") String str, @Field("user_sign") String str2);

    @FormUrlEncoded
    @POST("/x/member/app/uname/update")
    BiliCall<GeneralResponse<PersonInfoModifyNameBean>> modifyUserName(@Query("access_key") String str, @Field("uname") String str2);

    @GET("/x/member/app/school")
    BiliCall<GeneralResponse<BiliSchool>> school();

    @POST("/x/member/app/face/update")
    @RequestInterceptor(SignOnUrlRequestInterceptor.class)
    @Multipart
    BiliCall<JSONObject> uploadFace(@Query("access_key") String str, @Part("face") RequestBody requestBody);
}