package tv.danmaku.bili.ui.clipboard;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.call.BiliCall;
import kotlin.Metadata;
import retrofit2.http.BaseUrl;
import retrofit2.http.GET;
import retrofit2.http.Query;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.core.LoginSceneProcessor;

/* compiled from: ClipboardChecker.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\ba\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u0003H'JN\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00040\u00032\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010\n\u001a\u00020\u000b2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/clipboard/ClipboardApi;", "", "fetchRegexRules", "Lcom/bilibili/okretro/call/BiliCall;", "Lcom/bilibili/okretro/GeneralResponse;", "Ltv/danmaku/bili/ui/clipboard/RegexData;", "fetchJumpResult", "Ltv/danmaku/bili/ui/clipboard/ClipboardResult;", "accessKey", "", "startType", "", LoginSceneProcessor.BIZ_KEY, "data", "timestamp", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@BaseUrl("https://api.bilibili.com")
public interface ClipboardApi {
    @GET("x/share/clipboardMeta")
    BiliCall<GeneralResponse<ClipboardResult>> fetchJumpResult(@Query("access_key") String str, @Query("start_pattern") int i, @Query("business") String str2, @Query("data") String str3, @Query("first_launch_timestamp") long j);

    @GET("x/share/clipboardRules")
    BiliCall<GeneralResponse<RegexData>> fetchRegexRules();
}