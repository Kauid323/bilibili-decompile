package tv.danmaku.bili.ui.watchlater.api;

import com.bilibili.okretro.BaseResponse;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.call.BiliCall;
import kotlin.Metadata;
import retrofit2.http.BaseUrl;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import tv.danmaku.bili.ui.watchlater.data.WatchLaterAddToast;
import tv.danmaku.bili.ui.watchlater.data.WatchLaterResponse;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WatchLaterApiService.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u0007H'J\u001e\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u0007H'J\u001e\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u000bH'JB\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00040\u00032\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\u0016\u001a\u00020\u00072\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0007H'J8\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00040\u00032\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0007H'J6\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00040\u00032\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\u0016\u001a\u00020\u00072\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0007H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/api/WatchLaterApiService;", "", "getWatchLaterList", "Lcom/bilibili/okretro/call/BiliCall;", "Lcom/bilibili/okretro/GeneralResponse;", "Ltv/danmaku/bili/ui/watchlater/data/WatchLaterResponse;", "startKey", "", "asc", "", "sortField", "", "splitKey", "deleteWatchLater", "Lcom/bilibili/okretro/BaseResponse;", "resources", "cleanWatchLater", "cleanType", "addV2", "Ltv/danmaku/bili/ui/watchlater/data/WatchLaterAddToast;", "aid", "from", "spmid", "toviewVersion", "batchAddV3", "batchAdd", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@BaseUrl("https://api.bilibili.com")
public interface WatchLaterApiService {
    @FormUrlEncoded
    @POST("/x/v2/history/toview/add")
    BiliCall<GeneralResponse<WatchLaterAddToast>> addV2(@Field("aid") String str, @Field("from") String str2, @Field("spmid") String str3, @Field("toview_version") String str4);

    @FormUrlEncoded
    @POST("/x/v2/history/toview/add")
    BiliCall<GeneralResponse<WatchLaterAddToast>> batchAdd(@Field("resources") String str, @Field("spm_id") String str2, @Field("toview_version") String str3);

    @FormUrlEncoded
    @POST("/x/v3/fav/toview/adds")
    BiliCall<GeneralResponse<WatchLaterAddToast>> batchAddV3(@Field("resources") String str, @Field("toview_version") String str2, @Field("spmid") String str3);

    @FormUrlEncoded
    @POST("/x/v2/history/toview/clear")
    BiliCall<GeneralResponse<BaseResponse>> cleanWatchLater(@Field("clean_type") int i);

    @FormUrlEncoded
    @POST("/x/v2/history/toview/v2/dels")
    BiliCall<GeneralResponse<BaseResponse>> deleteWatchLater(@Field("resources") String str);

    @GET("/x/v2/history/toview/v2/list")
    BiliCall<GeneralResponse<WatchLaterResponse>> getWatchLaterList(@Query("start_key") String str, @Query("asc") boolean z, @Query("sort_field") int i, @Query("split_key") String str2);
}