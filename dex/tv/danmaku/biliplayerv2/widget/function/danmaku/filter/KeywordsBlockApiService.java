package tv.danmaku.biliplayerv2.widget.function.danmaku.filter;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.call.BiliCall;
import java.util.List;
import retrofit2.http.BaseUrl;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

@BaseUrl("https://api.bilibili.com")
public interface KeywordsBlockApiService {
    public static final int ERROR_CODE_ALREADY_EXIST = 36005;
    public static final int ERROR_CODE_NO_ENOUGH_SPACE = 36003;

    @FormUrlEncoded
    @POST("/x/dm/filter/user/add")
    BiliCall<GeneralResponse<String>> add(@Field("access_key") String str, @Field("type") int i, @Field("filter") String str2);

    @FormUrlEncoded
    @POST("/x/dm/filter/user/add")
    BiliCall<GeneralResponse<String>> add(@Field("access_key") String str, @Field("type") int i, @Field("filter") String str2, @Field("comment") String str3);

    @FormUrlEncoded
    @POST("/x/dm/assist/banned")
    BiliCall<GeneralResponse<String>> banned(@Field("access_key") String str, @Field("cid") String str2, @Field("dmids") String str3);

    @FormUrlEncoded
    @POST("/x/dm/filter/user/add2")
    BiliCall<GeneralResponse<List<UserKeywordItem>>> block(@Field("access_key") String str, @Field("type") int i, @Field("filters") String str2, @Field("filters") String str3);

    @GET("/x/dm/up/banned/users")
    BiliCall<GeneralResponse<List<String>>> block_user(@Query("access_key") String str, @Query("aid") String str2);

    @FormUrlEncoded
    @POST("x/dm/report/cmd/add")
    BiliCall<GeneralResponse<String>> commandDanmakuReport(@Field("access_key") String str, @Field("cid") long j, @Field("spmid") String str2, @Field("from_spmid") String str3, @Field("dmid") String str4, @Field("reason") String str5);

    @FormUrlEncoded
    @POST("/x/dm/filter/user/del")
    BiliCall<GeneralResponse<String>> delete(@Field("access_key") String str, @Field("ids") String str2);

    @GET("/x/dm/filter/user")
    BiliCall<GeneralResponse<BlockedKeywords<UserKeywordItem>>> getBlockedData(@Query("access_key") String str);

    @FormUrlEncoded
    @POST("/x/dm/report/add")
    BiliCall<GeneralResponse<String>> report(@Field("access_key") String str, @Field("cid") long j, @Field("spmid") String str2, @Field("from_spmid") String str3, @Field("dmid") String str4, @Field("reason") String str5, @Field("block") Boolean bool, @Field("action_id") String str6);

    @FormUrlEncoded
    @POST("/x/v2/dm/subtitle/report/add")
    BiliCall<GeneralResponse<String>> reportSubtitle(@Field("access_key") String str, @Field("oid") long j, @Field("subtitle_id") long j2, @Field("tid") long j3, @Field("from") float f, @Field("to") float f2, @Field("content") String str2);

    @FormUrlEncoded
    @POST("/x/dm/up/banned/del")
    BiliCall<GeneralResponse<String>> unbanned(@Field("access_key") String str, @Field("aid") String str2, @Field("hashes") String str3);

    @FormUrlEncoded
    @POST("/x/v2/dm/filter/up/black")
    BiliCall<GeneralResponse<String>> upAddBlacklist(@Field("type") int i, @Field("oid") long j, @Field("dmid") long j2);

    @FormUrlEncoded
    @POST("x/dm/assist/del")
    BiliCall<GeneralResponse<String>> up_delete(@Field("access_key") String str, @Field("cid") String str2, @Field("dmids") String str3);
}