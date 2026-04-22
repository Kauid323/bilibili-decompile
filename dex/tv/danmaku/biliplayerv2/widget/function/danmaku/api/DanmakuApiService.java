package tv.danmaku.biliplayerv2.widget.function.danmaku.api;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.anno.RequestInterceptor;
import com.bilibili.okretro.anno.Timeout;
import com.bilibili.okretro.call.BiliCall;
import com.bilibili.okretro.interceptor.SignOnUrlRequestInterceptor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import retrofit2.http.BaseUrl;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.utils.DanmakuSendHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DanmakuApiService.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J^\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u00072\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH'Jv\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\u0010\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u00072\b\b\u0001\u0010\u0011\u001a\u00020\t2\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0014\b\u0003\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH'J>\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\u0018\u001a\u00020\u0017H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0019À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/widget/function/danmaku/api/DanmakuApiService;", "", "sendDanmaku", "Lcom/bilibili/okretro/call/BiliCall;", "Lcom/bilibili/okretro/GeneralResponse;", "Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper$DanmakuSendResponse;", "accessKey", "", "avid", "", "cid", "spmid", "fromSpmid", "map", "", "sendDanmakuV2", LoginSceneProcessor.SCENE_KEY, "post_type", "text", "cmd", "updateDanmakuState", "Ljava/lang/Void;", "type", "", "state", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@BaseUrl("https://api.bilibili.com")
public interface DanmakuApiService {
    @RequestInterceptor(SignOnUrlRequestInterceptor.class)
    @Timeout(conn = PlayerToastConfig.DURATION_2, read = PlayerToastConfig.DURATION_2, write = PlayerToastConfig.DURATION_2)
    @FormUrlEncoded
    @POST("/x/v2/dm/post")
    BiliCall<GeneralResponse<DanmakuSendHelper.DanmakuSendResponse>> sendDanmaku(@Query("access_key") String str, @Query("aid") long j, @Query("oid") long j2, @Query("spmid") String str2, @Query("from_spmid") String str3, @FieldMap Map<String, String> map);

    @RequestInterceptor(SignOnUrlRequestInterceptor.class)
    @Timeout(conn = PlayerToastConfig.DURATION_2, read = PlayerToastConfig.DURATION_2, write = PlayerToastConfig.DURATION_2)
    @FormUrlEncoded
    @POST("/x/v2/dm/post2")
    BiliCall<GeneralResponse<DanmakuSendHelper.DanmakuSendResponse>> sendDanmakuV2(@Field("access_key") String str, @Field("scene") long j, @Field("spmid") String str2, @Field("from_spmid") String str3, @Field("post_type") long j2, @Field("text") String str4, @Field("cmd") String str5, @FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("/x/v2/dm/subject/state/update")
    @Timeout(conn = PlayerToastConfig.DURATION_2, read = PlayerToastConfig.DURATION_2, write = PlayerToastConfig.DURATION_2)
    BiliCall<GeneralResponse<Void>> updateDanmakuState(@Field("access_key") String str, @Field("type") int i, @Field("aid") long j, @Field("state") int i2);

    /* compiled from: DanmakuApiService.kt */
    /* renamed from: tv.danmaku.biliplayerv2.widget.function.danmaku.api.DanmakuApiService$-CC */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ BiliCall sendDanmakuV2$default(DanmakuApiService danmakuApiService, String str, long j, String str2, String str3, long j2, String str4, String str5, Map map, int i, Object obj) {
            if (obj == null) {
                return danmakuApiService.sendDanmakuV2(str, j, str2, str3, j2, (i & 32) != 0 ? "" : str4, (i & 64) != 0 ? "" : str5, (i & 128) != 0 ? MapsKt.emptyMap() : map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendDanmakuV2");
        }
    }
}