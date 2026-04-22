package tv.danmaku.bili.appwidget.upcard.utils;

import com.bilibili.okretro.call.BiliCall;
import kotlin.Metadata;
import kotlin.Unit;
import retrofit2.http.BaseUrl;
import retrofit2.http.GET;
import retrofit2.http.Query;
import tv.danmaku.bili.BR;

/* compiled from: ReportUtil.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/appwidget/upcard/utils/TaskProcessService;", "", "notify", "Lcom/bilibili/okretro/call/BiliCall;", "", "isWidget", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@BaseUrl("https://api.bilibili.com")
public interface TaskProcessService {
    @GET("/x/operational_activity/cny/task_process/notify")
    BiliCall<Unit> notify(@Query("is_widget") boolean z);
}