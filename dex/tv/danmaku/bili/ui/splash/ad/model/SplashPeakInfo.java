package tv.danmaku.bili.ui.splash.ad.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.List;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashPeakInfo.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/model/SplashPeakInfo;", "", "<init>", "()V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "taskList", "", "Ltv/danmaku/bili/ui/splash/ad/model/SplashPeakTask;", "getTaskList", "()Ljava/util/List;", "setTaskList", "(Ljava/util/List;)V", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashPeakInfo {
    public static final int $stable = 8;
    @JSONField(name = "enable")
    private boolean enable;
    @JSONField(name = "task_list")
    private List<SplashPeakTask> taskList;

    public final boolean getEnable() {
        return this.enable;
    }

    public final void setEnable(boolean z) {
        this.enable = z;
    }

    public final List<SplashPeakTask> getTaskList() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.taskList);
    }

    public final void setTaskList(List<SplashPeakTask> list) {
        this.taskList = list;
    }
}