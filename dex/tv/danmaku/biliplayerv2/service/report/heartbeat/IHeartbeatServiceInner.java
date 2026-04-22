package tv.danmaku.biliplayerv2.service.report.heartbeat;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IHeartbeatService.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J(\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\bH&J(\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\bH&J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\bH&J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0005H&J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH&J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0019À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/report/heartbeat/IHeartbeatServiceInner;", "Ltv/danmaku/biliplayerv2/service/report/heartbeat/IHeartbeatService;", "getSession", "", "resetSession", "", "notifyVideoStart", "qualityId", "", "duration", "currentPosition", "isAutoQn", "", "notifyVideoPlay", "notifyVideoPause", "notifyVideoSeekStart", "notifyVideoSeekCompleted", "notifyVideoBufferingStart", "notifyVideoBufferingEnd", "notifyVideoSpeedChanged", "speed", "", "notifyActivityResume", "notifyActivityPause", "notifyVideoEnd", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IHeartbeatServiceInner extends IHeartbeatService {
    String getSession();

    void notifyActivityPause(int i, int i2);

    void notifyActivityResume();

    void notifyVideoBufferingEnd(int i);

    void notifyVideoBufferingStart(int i);

    void notifyVideoEnd(int i, int i2);

    void notifyVideoPause();

    void notifyVideoPlay();

    void notifyVideoSeekCompleted(int i, int i2, int i3, boolean z);

    void notifyVideoSeekStart(int i);

    void notifyVideoSpeedChanged(float f);

    void notifyVideoStart(int i, int i2, int i3, boolean z);

    void resetSession();
}