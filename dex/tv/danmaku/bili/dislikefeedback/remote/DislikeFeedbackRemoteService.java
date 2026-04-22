package tv.danmaku.bili.dislikefeedback.remote;

import com.bilibili.okretro.call.BiliCall;
import java.util.Map;
import kotlin.Metadata;
import retrofit2.http.BaseUrl;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import tv.danmaku.bili.BR;

/* compiled from: DislikeFeedbackRemoteService.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/dislikefeedback/remote/DislikeFeedbackRemoteService;", "", "dislikeOrFeedback", "Lcom/bilibili/okretro/call/BiliCall;", "", "map", "", "dislike-feedback_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@BaseUrl("https://app.bilibili.com")
public interface DislikeFeedbackRemoteService {
    @GET("/x/feed/dislike")
    BiliCall<String> dislikeOrFeedback(@QueryMap Map<String, String> map);
}