package tv.danmaku.bili.ui.garb.api;

import com.bilibili.okretro.response.BiliApiResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.http.BaseUrl;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import tv.danmaku.bili.BR;

/* compiled from: CollectionRoomNoticeApiService.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/CollectionRoomNoticeApiService;", "", "requestNotice", "Lcom/bilibili/okretro/response/BiliApiResponse;", "Ltv/danmaku/bili/ui/garb/api/Notice;", "vmid", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "noticeClose", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@BaseUrl("https://api.bilibili.com")
public interface CollectionRoomNoticeApiService {
    @FormUrlEncoded
    @POST("/x/vas/collection/close_tip_message")
    Object noticeClose(@Field("vmid") long j, Continuation<? super BiliApiResponse<Unit>> continuation);

    @GET("/x/vas/collection/tip_message")
    Object requestNotice(@Query("vmid") long j, Continuation<? super BiliApiResponse<Notice>> continuation);
}