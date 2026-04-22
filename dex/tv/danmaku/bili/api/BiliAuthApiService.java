package tv.danmaku.bili.api;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.call.BiliCall;
import java.util.List;
import java.util.Map;
import okhttp3.RequestBody;
import retrofit2.http.BaseUrl;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import tv.danmaku.bili.api.bean.ApplyStatusBean;
import tv.danmaku.bili.api.bean.AuthConfBean;
import tv.danmaku.bili.api.bean.AuthContentCheckBean;
import tv.danmaku.bili.api.bean.CaptchaGeeBean;
import tv.danmaku.bili.api.bean.CardPictureBean;
import tv.danmaku.bili.api.bean.CardTypeBean;
import tv.danmaku.bili.api.bean.ChangeRealnamePersonBean;
import tv.danmaku.bili.api.bean.ChannelBean;
import tv.danmaku.bili.api.bean.CheckIDCradBean;
import tv.danmaku.bili.api.bean.ConfirmGeeBean;
import tv.danmaku.bili.api.bean.ConfirmZhiMaBean;
import tv.danmaku.bili.api.bean.ModifyAllowBean;
import tv.danmaku.bili.api.bean.ModifyStatusBean;
import tv.danmaku.bili.api.bean.OverrideSummary;
import tv.danmaku.bili.api.bean.TelInfoBean;
import tv.danmaku.bili.api.bean.ZhiMaAuthBizBean;

@BaseUrl("https://api.bilibili.com")
public interface BiliAuthApiService {
    @FormUrlEncoded
    @POST("/x/member/realname/alipay/apply")
    BiliCall<GeneralResponse<ZhiMaAuthBizBean>> applyAuth(@Query("access_key") String str, @Field("real_name") String str2, @Field("card_num") String str3, @Field("capture") String str4, @Field("img_token") String str5);

    @POST("/x/member/realname/tel/capture")
    BiliCall<GeneralResponse<Void>> captureGet(@Query("access_key") String str);

    @POST("/x/member/realname/change/person")
    BiliCall<GeneralResponse<ChangeRealnamePersonBean>> changeRealnamePerson(@Query("token_new") String str, @Query("token_old") String str2, @Query("reason") String str3, @Query("old_img_token_1") String str4, @Query("old_img_token_2") String str5, @Query("old_img_token_3") String str6, @Query("new_img_token_1") String str7, @Query("new_img_token_2") String str8, @Query("new_img_token_3") String str9, @Query("other_img_token_1") String str10, @Query("other_img_token_2") String str11, @Query("other_img_token_3") String str12);

    @GET("/x/member/realname/change/check")
    BiliCall<GeneralResponse<CheckIDCradBean>> checkIDCardDigits(@Query("last_digits") String str);

    @GET("/x/member/realname/change/gray")
    BiliCall<GeneralResponse<ModifyAllowBean>> checkModifyAllow();

    @GET("/x/member/realname/change/condition")
    BiliCall<GeneralResponse<ModifyStatusBean>> checkModifyStatus(@Query("action") int i);

    @GET("/x/member/realname/alipay/confirm")
    BiliCall<GeneralResponse<ConfirmZhiMaBean>> confirmAliAuth(@Query("access_key") String str);

    @GET("/x/member/realname/captcha/confirm")
    BiliCall<GeneralResponse<ConfirmGeeBean>> confirmGeeCaptcha(@Query("access_key") String str, @Query("remote") int i, @QueryMap Map<String, String> map);

    @GET("/x/member/realname/captcha/confirm")
    BiliCall<GeneralResponse<ConfirmGeeBean>> confirmLocalCaptcha(@Query("access_key") String str, @Query("remote") int i);

    @GET("x/member/web/content/check")
    BiliCall<GeneralResponse<AuthContentCheckBean>> contentCheck(@Query("content") String str, @Query("scene") String str2);

    @GET("/x/member/realname/apply/status")
    BiliCall<GeneralResponse<ApplyStatusBean>> getAuthApplyStatus(@Query("access_key") String str, @Query("tmp_code") String str2);

    @GET("/x/member/realname/channel")
    BiliCall<GeneralResponse<List<ChannelBean>>> getAuthChannel(@Query("access_key") String str);

    @GET("/x/member/faceid/realname/conf")
    BiliCall<GeneralResponse<AuthConfBean>> getAuthConf(@Query("tmp_code") String str);

    @GET("/x/member/realname/status")
    BiliCall<GeneralResponse<Void>> getAuthStatus(@Query("access_key") String str);

    @GET("/x/member/realname/v2/card/types")
    BiliCall<GeneralResponse<List<CardTypeBean>>> getCardTypes(@Query("scene") String str, @Query("tmp_code") String str2);

    @GET("/x/member/realname/captcha")
    BiliCall<GeneralResponse<CaptchaGeeBean>> getGeeCaptcha(@Query("access_key") String str);

    @GET("/x/member/faceid/realname/override/summary")
    BiliCall<GeneralResponse<OverrideSummary>> getOverrideSummary(@Query("request_id") String str, @Query("override_mid") String str2);

    @GET("/x/member/realname/tel/info")
    BiliCall<GeneralResponse<TelInfoBean>> getTelInfo(@Query("access_key") String str);

    @POST("/x/member/faceid/realname/override")
    BiliCall<GeneralResponse<Void>> overrideRealName(@Query("request_id") String str, @Query("override_mid") String str2);

    @POST("http://api.bilibili.com/x/member/realname/upload")
    @Multipart
    BiliCall<GeneralResponse<CardPictureBean>> uploadAuthFile(@Query("access_key") String str, @Part("img") RequestBody requestBody);
}