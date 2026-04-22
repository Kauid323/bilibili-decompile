package tv.danmaku.biliplayerv2.service.interact.core.api;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.anno.RequestInterceptor;
import com.bilibili.okretro.anno.Timeout;
import com.bilibili.okretro.call.BiliCall;
import com.bilibili.okretro.interceptor.SignOnUrlRequestInterceptor;
import kotlin.Metadata;
import retrofit2.http.BaseUrl;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;
import tv.danmaku.biliplayerv2.service.interact.core.command.CommandsPanel;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: InteractApiService.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0094\u0001\u0010\u0002\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\u00052\b\b\u0001\u0010\n\u001a\u00020\u00052\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0005H'J2\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00040\u00032\b\b\u0001\u0010\u0013\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0005H'Jp\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00040\u00032\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0016\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0017\u001a\u00020\u00052\b\b\u0001\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\u001a\u001a\u00020\u001b2\b\b\u0001\u0010\u001c\u001a\u00020\u00052\b\b\u0001\u0010\u001d\u001a\u00020\u001e2\b\b\u0001\u0010\u001f\u001a\u00020\u001bH'JH\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0016\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0017\u001a\u00020\u00052\b\b\u0001\u0010!\u001a\u00020\u0005H'J`\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00040\u00032\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010#\u001a\u00020\u00192\b\b\u0001\u0010$\u001a\u00020\u00052\b\b\u0001\u0010%\u001a\u00020\u00052\b\b\u0001\u0010&\u001a\u00020\u00192\n\b\u0003\u0010'\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010(\u001a\u0004\u0018\u00010\u0005H'J6\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u00052\b\b\u0001\u0010+\u001a\u00020\u00192\b\b\u0001\u0010\u0007\u001a\u00020\u00192\b\b\u0001\u0010\u0006\u001a\u00020\u0019H'J8\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u00032\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010.\u001a\u00020\u00052\b\b\u0003\u0010\u001a\u001a\u00020\u001bH'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006/À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/core/api/InteractApiService;", "", "reportSubtitleV2", "Lcom/bilibili/okretro/call/BiliCall;", "Lcom/bilibili/okretro/GeneralResponse;", "", "cid", "aid", "subtitleType", "subtitleId", "tagId", "reasons", "content", "fixContent", "rowId", "from", "to", "getDanmakuCommandPanelList", "Ltv/danmaku/biliplayerv2/service/interact/core/command/CommandsPanel;", "accessKey", "sendCommandDanmaku", "Ltv/danmaku/biliplayerv2/service/interact/biz/sender/ChronosDanmakuSender$CommandDanmakuSendResponse;", "avid", "plat", "progress", "", "type", "", "data", "autoCreate", "", "countDown", "deleteCommandDanmaku", "danmakuId", "sendCommandDanmakuV2", LoginSceneProcessor.SCENE_KEY, "spmid", "fromSpmid", "post_type", "text", "cmd", "exposureReport", "Ljava/lang/Void;", RankRouter.BundleKey.AUTHOR_SPACE_MID, "recall", "Ltv/danmaku/biliplayerv2/service/interact/core/api/InteractApiResponse;", "dmid", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@BaseUrl("https://api.bilibili.com")
public interface InteractApiService {
    @POST("/x/v2/dm/command/del")
    @RequestInterceptor(SignOnUrlRequestInterceptor.class)
    @Timeout(conn = PlayerToastConfig.DURATION_2, read = PlayerToastConfig.DURATION_2, write = PlayerToastConfig.DURATION_2)
    BiliCall<GeneralResponse<String>> deleteCommandDanmaku(@Query("access_key") String str, @Query("aid") String str2, @Query("oid") String str3, @Query("plat") String str4, @Query("dmid") String str5);

    @POST("/x/v2/dm/exposure/report")
    BiliCall<Void> exposureReport(@Query("from") String str, @Query("mid") long j, @Query("aid") long j2, @Query("cid") long j3);

    @GET("/x/v2/dm/command/panel")
    BiliCall<GeneralResponse<CommandsPanel>> getDanmakuCommandPanelList(@Query("access_key") String str, @Query("aid") String str2, @Query("oid") String str3);

    @FormUrlEncoded
    @POST("/x/v2/dm/recall")
    BiliCall<InteractApiResponse> recall(@Field("access_key") String str, @Field("cid") String str2, @Field("dmid") String str3, @Field("type") int i);

    @FormUrlEncoded
    @POST("/x/v2/dm/subtitle/report/v2/add")
    @Timeout(conn = PlayerToastConfig.DURATION_2, read = PlayerToastConfig.DURATION_2, write = PlayerToastConfig.DURATION_2)
    BiliCall<GeneralResponse<String>> reportSubtitleV2(@Field("cid") String str, @Field("aid") String str2, @Field("subtitle_type") String str3, @Field("subtitle_id") String str4, @Field("tag_id") String str5, @Field("reason") String str6, @Field("content") String str7, @Field("description") String str8, @Field("row_id") String str9, @Field("from") String str10, @Field("to") String str11);

    @POST("/x/v2/dm/command/post")
    @RequestInterceptor(SignOnUrlRequestInterceptor.class)
    @Timeout(conn = PlayerToastConfig.DURATION_2, read = PlayerToastConfig.DURATION_2, write = PlayerToastConfig.DURATION_2)
    BiliCall<GeneralResponse<ChronosDanmakuSender.CommandDanmakuSendResponse>> sendCommandDanmaku(@Query("access_key") String str, @Query("aid") String str2, @Query("cid") String str3, @Query("plat") String str4, @Query("progress") long j, @Query("type") int i, @Query("data") String str5, @Query("auto_create") boolean z, @Query("count_down") int i2);

    @RequestInterceptor(SignOnUrlRequestInterceptor.class)
    @Timeout(conn = PlayerToastConfig.DURATION_2, read = PlayerToastConfig.DURATION_2, write = PlayerToastConfig.DURATION_2)
    @FormUrlEncoded
    @POST("/x/v2/dm/post2")
    BiliCall<GeneralResponse<ChronosDanmakuSender.CommandDanmakuSendResponse>> sendCommandDanmakuV2(@Field("access_key") String str, @Field("scene") long j, @Field("spmid") String str2, @Field("from_spmid") String str3, @Field("post_type") long j2, @Field("text") String str4, @Field("cmd") String str5);

    /* compiled from: InteractApiService.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.interact.core.api.InteractApiService$-CC */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ BiliCall sendCommandDanmakuV2$default(InteractApiService interactApiService, String str, long j, String str2, String str3, long j2, String str4, String str5, int i, Object obj) {
            String str6;
            String str7;
            if (obj == null) {
                if ((i & 32) == 0) {
                    str6 = str4;
                } else {
                    str6 = "";
                }
                if ((i & 64) == 0) {
                    str7 = str5;
                } else {
                    str7 = "";
                }
                return interactApiService.sendCommandDanmakuV2(str, j, str2, str3, j2, str6, str7);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendCommandDanmakuV2");
        }

        public static /* synthetic */ BiliCall recall$default(InteractApiService interactApiService, String str, String str2, String str3, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 8) != 0) {
                    i = 1;
                }
                return interactApiService.recall(str, str2, str3, i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recall");
        }
    }
}