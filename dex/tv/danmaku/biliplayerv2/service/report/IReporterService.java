package tv.danmaku.biliplayerv2.service.report;

import java.util.Map;
import kotlin.Metadata;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.ScreenModeType;
import tv.danmaku.biliplayerv2.service.report.NeuronsEvents;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IReporterService.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u001a\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&J\u001e\u0010\u0017\u001a\u00020\u00032\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0019H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/report/IReporterService;", "", "report", "", "event", "Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$Event;", "getSession", "", "resetSession", "notifyVideoChanged", "commonField", "Ltv/danmaku/biliplayerv2/service/report/PlayerReportCommonField;", "updateVideoInfo", "videoFormat", "Ltv/danmaku/biliplayerv2/service/report/VideoFormat;", "isLocalVideo", "", "notifyScreenModeTypeChanged", "screenType", "Ltv/danmaku/biliplayerv2/ScreenModeType;", "notifySceneChange", LoginSceneProcessor.SCENE_KEY, "Ltv/danmaku/biliplayerv2/service/report/PlayScene;", "notifyExtraReportParamsChanged", "extraReportParams", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IReporterService {
    String getSession();

    void notifyExtraReportParamsChanged(Map<String, String> map);

    void notifySceneChange(PlayScene playScene);

    void notifyScreenModeTypeChanged(ScreenModeType screenModeType);

    void notifyVideoChanged(PlayerReportCommonField playerReportCommonField);

    void report(NeuronsEvents.Event event);

    void resetSession();

    void updateVideoInfo(VideoFormat videoFormat, boolean z);
}