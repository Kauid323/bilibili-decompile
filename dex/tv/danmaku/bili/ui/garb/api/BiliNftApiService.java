package tv.danmaku.bili.ui.garb.api;

import com.alibaba.fastjson.JSONObject;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.anno.RequestInterceptor;
import com.bilibili.okretro.call.BiliCall;
import com.bilibili.okretro.interceptor.SignOnUrlRequestInterceptor;
import kotlin.Metadata;
import okhttp3.RequestBody;
import retrofit2.http.BaseUrl;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.api.collection.BiliCollectionAllData;
import tv.danmaku.bili.ui.garb.api.collection.BiliCollectionData;

/* compiled from: BiliNftApiService.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001JH\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\u000b2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\rH'J(\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u000b2\b\b\u0001\u0010\u0010\u001a\u00020\u0007H'J(\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u000b2\b\b\u0001\u0010\u0010\u001a\u00020\u0007H'J9\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u000b2\b\b\u0001\u0010\b\u001a\u00020\u00072\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u000bH'¢\u0006\u0002\u0010\u0015J8\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00032\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0010\u001a\u00020\r2\b\b\u0001\u0010\u0018\u001a\u00020\r2\b\b\u0001\u0010\u0019\u001a\u00020\rH'J$\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00032\b\b\u0001\u0010\u0018\u001a\u00020\u001b2\b\b\u0001\u0010\u001c\u001a\u00020\u001bH'J(\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u000b2\b\b\u0001\u0010\u0018\u001a\u00020\u0007H'JE\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00040\u00032\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\u0018\u001a\u00020\u00072\b\b\u0001\u0010\"\u001a\u00020\u000bH'¢\u0006\u0002\u0010#J1\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00040\u00032\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\u0007H'¢\u0006\u0002\u0010&J\u001e\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u00040\u00032\b\b\u0001\u0010)\u001a\u00020\u000bH'Ja\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\u00040\u00032\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010,\u001a\u0004\u0018\u00010\r2\n\b\u0001\u0010-\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010.\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010/\u001a\u0004\u0018\u00010\u000bH'¢\u0006\u0002\u00100ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00061À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/BiliNftApiService;", "", "drawDLCItem", "Lcom/bilibili/okretro/call/BiliCall;", "Lcom/bilibili/okretro/GeneralResponse;", "Ltv/danmaku/bili/ui/garb/api/BillDLCRespInfo;", "actionId", "", "mid", "lotteryId", "lotteryNum", "", "bizInfo", "", "loadCardDetail", "Ltv/danmaku/bili/ui/garb/api/BiliCardDetail;", "cardTypeId", "loadDLCCardDetail", "loadDrawCard", "Ltv/danmaku/bili/ui/garb/api/BiliDrawCard;", "roundIndex", "(IJLjava/lang/Integer;)Lcom/bilibili/okretro/call/BiliCall;", "bgEdit", "Lcom/alibaba/fastjson/JSONObject;", "cardId", "actId", "uploadFace", "Lokhttp3/RequestBody;", "file", "isAllowTransfer", "Ltv/danmaku/bili/ui/garb/api/BiliNftTransfer;", "detailInfo", "Ltv/danmaku/bili/ui/garb/api/DigitalCardDetail;", "vmid", "useScene", "(Ljava/lang/Long;Ljava/lang/Long;JI)Lcom/bilibili/okretro/call/BiliCall;", "getCollectionData", "Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionData;", "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/bilibili/okretro/call/BiliCall;", "setCollectionVisible", "Ltv/danmaku/bili/ui/garb/api/CollectionSetting;", "collectionPublic", "getCollectionPageData", "Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionAllData;", "source", "ps", "lastId", "lastType", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;)Lcom/bilibili/okretro/call/BiliCall;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@BaseUrl("http://api.bilibili.com")
public interface BiliNftApiService {
    @FormUrlEncoded
    @POST("/x/garb/comment/bg/edit")
    BiliCall<JSONObject> bgEdit(@Field("mid") long j, @Field("card_type_id") String str, @Field("card_id") String str2, @Field("act_id") String str3);

    @GET("/x/garb/digital/card/detail")
    BiliCall<GeneralResponse<DigitalCardDetail>> detailInfo(@Query("mid") Long l, @Query("vmid") Long l2, @Query("card_id") long j, @Query("use_scene") int i);

    @FormUrlEncoded
    @POST("/x/vas/dlc_act/lottery/draw_item")
    BiliCall<GeneralResponse<BillDLCRespInfo>> drawDLCItem(@Field("act_id") long j, @Field("mid") long j2, @Field("lottery_id") long j3, @Field("lottery_num") int i, @Field("biz_info") String str);

    @GET("/x/garb/right/collection/aggregation_info")
    BiliCall<GeneralResponse<BiliCollectionData>> getCollectionData(@Query("mid") Long l, @Query("vmid") Long l2);

    @GET("/x/garb/right/collection/simple_list")
    BiliCall<GeneralResponse<BiliCollectionAllData>> getCollectionPageData(@Query("mid") Long l, @Query("vmid") Long l2, @Query("source") String str, @Query("ps") Integer num, @Query("last_id") Long l3, @Query("last_type") Integer num2);

    @GET("/x/vas/nftcard/isallowtransfer")
    BiliCall<GeneralResponse<BiliNftTransfer>> isAllowTransfer(@Query("act_id") int i, @Query("card_id") long j);

    @GET("/x/vas/nftcard/carddetail")
    BiliCall<GeneralResponse<BiliCardDetail>> loadCardDetail(@Query("act_id") int i, @Query("card_type_id") long j);

    @GET("/x/vas/dlc_act/act/card/detail")
    BiliCall<GeneralResponse<BiliCardDetail>> loadDLCCardDetail(@Query("act_id") int i, @Query("card_type_id") long j);

    @GET("/x/vas/nftcard/drawcard")
    BiliCall<GeneralResponse<BiliDrawCard>> loadDrawCard(@Query("act_id") int i, @Query("mid") long j, @Query("round_index") Integer num);

    @FormUrlEncoded
    @POST("/x/garb/right/collection/preference_set")
    BiliCall<GeneralResponse<CollectionSetting>> setCollectionVisible(@Field("collection_public") int i);

    @POST("/x/member/app/face/digitalKit/update")
    @RequestInterceptor(SignOnUrlRequestInterceptor.class)
    @Multipart
    BiliCall<JSONObject> uploadFace(@Part("digital_kit_id") RequestBody requestBody, @Part("face") RequestBody requestBody2);
}