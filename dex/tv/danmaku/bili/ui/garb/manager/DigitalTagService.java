package tv.danmaku.bili.ui.garb.manager;

import com.bilibili.okretro.call.rxjava.SplitGeneralResponse;
import com.bilibili.okretro.response.BiliApiResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.http.BaseUrl;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import tv.danmaku.bili.BR;

/* compiled from: CollectionSideManager.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/garb/manager/DigitalTagService;", "", "reportMenuTagRemove", "Lcom/bilibili/okretro/response/BiliApiResponse;", "", "parts", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@BaseUrl("http://api.bilibili.com")
public interface DigitalTagService {
    @FormUrlEncoded
    @POST("/x/garb/user/preview/new/del")
    @SplitGeneralResponse
    Object reportMenuTagRemove(@Field("parts") String str, Continuation<? super BiliApiResponse<Unit>> continuation);
}