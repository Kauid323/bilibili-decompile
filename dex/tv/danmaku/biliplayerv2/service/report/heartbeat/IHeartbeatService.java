package tv.danmaku.biliplayerv2.service.report.heartbeat;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.service.IPlayerService;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IHeartbeatService.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/report/heartbeat/IHeartbeatService;", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "notifyMiniPlayerSwitch", "", "isMiniPlayer", "", "notifyMetaInfoChanged", "metaInfo", "Ltv/danmaku/biliplayerv2/service/report/heartbeat/ReportMetaInfo;", "notifyPlayModeChanged", "playMode", "", "notifyAutoPlay", "autoPlay", "", "notifyLifecycleChanged", "event", "Landroidx/lifecycle/Lifecycle$Event;", "notifyMetaEnd", "setEnable", "enable", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IHeartbeatService extends IPlayerService {
    void notifyAutoPlay(int i);

    void notifyLifecycleChanged(Lifecycle.Event event);

    void notifyMetaEnd();

    void notifyMetaInfoChanged(ReportMetaInfo reportMetaInfo);

    void notifyMiniPlayerSwitch(boolean z);

    void notifyPlayModeChanged(String str);

    void setEnable(boolean z);
}