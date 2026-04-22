package tv.danmaku.bili.ui.tag.api;

import com.bilibili.api.base.util.ParamsMap;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.call.BiliCall;
import java.util.List;
import retrofit2.http.BaseUrl;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplashDataKt;

@BaseUrl("https://api.bilibili.com")
public interface VideoTagService {
    @FormUrlEncoded
    @POST("/x/tag/archive/del")
    BiliCall<GeneralResponse<Void>> deleteTag(@Field("access_key") String str, @Field("aid") long j, @Field("tag_id") long j2);

    @GET("/x/tag/subscribe/tags")
    BiliCall<GeneralResponse<List<Tagv2>>> getTagList(@QueryMap TagParamsMap tagParamsMap, @Query("access_key") String str);

    @FormUrlEncoded
    @POST("/x/tag/archive/hate2")
    BiliCall<GeneralResponse<Void>> hateTag(@Field("access_key") String str, @Field("aid") long j, @Field("tag_id") long j2);

    @FormUrlEncoded
    @POST("/x/tag/archive/like2")
    BiliCall<GeneralResponse<Void>> likeTag(@Field("access_key") String str, @Field("aid") long j, @Field("tag_id") long j2);

    @FormUrlEncoded
    @POST("/x/tag/archive/report")
    BiliCall<GeneralResponse<Void>> reportTag(@Field("access_key") String str, @Field("aid") long j, @Field("tag_id") long j2, @Field("reason") String str2);

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class TagParamsMap extends ParamsMap {
        public TagParamsMap(int page) {
            super(5);
            putParams(new String[]{"pn", String.valueOf(page)});
        }

        public TagParamsMap(int page, int quantity) {
            super(5);
            putParams(new String[]{"pn", String.valueOf(page), "ps", String.valueOf(quantity)});
        }

        public TagParamsMap(int page, int quantity, long vmid) {
            this(5, page, quantity, vmid, 1);
        }

        public TagParamsMap(int capacity, int page, int quantity, long vmid, int order) {
            super(capacity);
            putParams(new String[]{"pn", String.valueOf(page), "ps", String.valueOf(quantity), "vmid", String.valueOf(vmid), BrandSplashDataKt.ORDER_RULE, String.valueOf(order)});
        }
    }
}