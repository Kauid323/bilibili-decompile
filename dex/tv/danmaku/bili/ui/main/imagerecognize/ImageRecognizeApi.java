package tv.danmaku.bili.ui.main.imagerecognize;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.call.BiliCall;
import kotlin.Metadata;
import retrofit2.http.BaseUrl;
import retrofit2.http.GET;
import retrofit2.http.Query;
import tv.danmaku.bili.BR;

/* compiled from: ImageRecognizeHelper.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/main/imagerecognize/ImageRecognizeApi;", "", "fetchImageUrlInfo", "Lcom/bilibili/okretro/call/BiliCall;", "Lcom/bilibili/okretro/GeneralResponse;", "Ltv/danmaku/bili/ui/main/imagerecognize/ImageUrlInfo;", "url", "", "device", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@BaseUrl("https://api.bilibili.com")
public interface ImageRecognizeApi {
    @GET("/x/share/url2info")
    BiliCall<GeneralResponse<ImageUrlInfo>> fetchImageUrlInfo(@Query("url") String str, @Query("device") String str2);

    /* compiled from: ImageRecognizeHelper.kt */
    /* renamed from: tv.danmaku.bili.ui.main.imagerecognize.ImageRecognizeApi$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ BiliCall fetchImageUrlInfo$default(ImageRecognizeApi imageRecognizeApi, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = "phone";
                }
                return imageRecognizeApi.fetchImageUrlInfo(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchImageUrlInfo");
        }
    }
}