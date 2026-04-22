package tv.danmaku.bili.ui.garb.nft.api;

import com.bilibili.okretro.anno.RequestInterceptor;
import com.bilibili.okretro.response.BiliApiResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import retrofit2.http.BaseUrl;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.digital.lockcard.DigitalCommonParamToUrlRequestInterceptor;
import tv.danmaku.bili.ui.garb.nft.model.DLCSplashCardInfo;

/* compiled from: DLCApiService.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/api/DLCApiService;", "", "getDlcSplashInfo", "Lcom/bilibili/okretro/response/BiliApiResponse;", "Ltv/danmaku/bili/ui/garb/nft/model/DLCSplashCardInfo;", "actId", "", "cardTypeId", "", "screenWidth", "screenHeight", "(IJIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toggleDlcLockCard", "", "body", "Lokhttp3/RequestBody;", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@BaseUrl("https://api.bilibili.com")
public interface DLCApiService {
    @GET("/x/vas/dlc_act/card/splash_info")
    Object getDlcSplashInfo(@Query("act_id") int i, @Query("card_type_id") long j, @Query("screen_width") int i2, @Query("screen_height") int i3, Continuation<? super BiliApiResponse<DLCSplashCardInfo>> continuation);

    @POST("/x/vas/smelt/my_decompose/lock")
    @RequestInterceptor(DigitalCommonParamToUrlRequestInterceptor.class)
    Object toggleDlcLockCard(@Body RequestBody requestBody, Continuation<? super BiliApiResponse<Unit>> continuation);
}