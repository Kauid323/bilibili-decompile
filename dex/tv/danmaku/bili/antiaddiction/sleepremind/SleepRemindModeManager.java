package tv.danmaku.bili.antiaddiction.sleepremind;

import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Callback;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.antiaddiction.AntiAddictionConfigService;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;

/* compiled from: SleepRemindModeManager.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/antiaddiction/sleepremind/SleepRemindModeManager;", "", "<init>", "()V", ReportEvent.Tag.API, "Ltv/danmaku/bili/antiaddiction/AntiAddictionConfigService;", "setSleepRemindConfig", "", "switch", "", "startTime", "", "endTime", AuthResultCbHelper.ARGS_CALLBACK, "Lcom/bilibili/okretro/BiliApiDataCallback;", "antiaddiction_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SleepRemindModeManager {
    public static final SleepRemindModeManager INSTANCE = new SleepRemindModeManager();
    private static final AntiAddictionConfigService api;

    private SleepRemindModeManager() {
    }

    static {
        Object createService = ServiceGenerator.createService(AntiAddictionConfigService.class);
        Intrinsics.checkNotNullExpressionValue(createService, "createService(...)");
        api = (AntiAddictionConfigService) createService;
    }

    public final void setSleepRemindConfig(boolean z, String startTime, String endTime, BiliApiDataCallback<Object> biliApiDataCallback) {
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(biliApiDataCallback, AuthResultCbHelper.ARGS_CALLBACK);
        api.setSleepRemindConfig(z, startTime, endTime).enqueue((Callback) biliApiDataCallback);
    }
}