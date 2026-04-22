package tv.danmaku.bili.ui.topic.api;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.anno.CacheControl;
import com.bilibili.okretro.call.BiliCall;
import kotlin.Metadata;
import retrofit2.http.BaseUrl;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: TopicApiService.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H'J*\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H'J*\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H'J4\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u000fH'J4\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u000fH'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/topic/api/TopicApiService;", "", "queryFavorStatus", "Lcom/bilibili/okretro/call/BiliCall;", "Lcom/bilibili/okretro/GeneralResponse;", "Ltv/danmaku/bili/ui/topic/api/FavouredStatus;", "accesskey", "", "topicId", "unFavorTopic", "Ljava/lang/Void;", "favorTopic", "loadActivity", "Ltv/danmaku/bili/ui/topic/api/BiliTopicList;", "page", "", "pageSize", "loadTopics", "topic_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@BaseUrl("https://api.bilibili.com")
public interface TopicApiService {
    @POST("/x/v2/fav/topic/add")
    BiliCall<GeneralResponse<Void>> favorTopic(@Query("access_key") String str, @Query("tpid") String str2);

    @Headers({"Connection: close"})
    @GET("/event/getlist")
    @CacheControl
    BiliCall<GeneralResponse<BiliTopicList>> loadActivity(@Query("access_key") String str, @Query("page") int i, @Query("pageSize") int i2);

    @Headers({"Connection: close"})
    @GET("/topic/getlist")
    @CacheControl
    BiliCall<GeneralResponse<BiliTopicList>> loadTopics(@Query("access_key") String str, @Query("page") int i, @Query("pageSize") int i2);

    @GET("/x/v2/fav/topic/favoured")
    BiliCall<GeneralResponse<FavouredStatus>> queryFavorStatus(@Query("access_key") String str, @Query("tpid") String str2);

    @POST("/x/v2/fav/topic/del")
    BiliCall<GeneralResponse<Void>> unFavorTopic(@Query("access_key") String str, @Query("tpid") String str2);
}