package tv.danmaku.biliplayerimpl.report.heartbeat;

import com.bilibili.base.BiliContext;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.service.report.NormalDataModel;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: HeartbeatDataModel.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001a\u0010\"\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001a\u0010%\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR\u001a\u0010(\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u0010\t¨\u00064"}, d2 = {"Ltv/danmaku/biliplayerimpl/report/heartbeat/HeartbeatDataModel;", "", "<init>", "()V", "appRunningState", "", "getAppRunningState", "()Ljava/lang/String;", "setAppRunningState", "(Ljava/lang/String;)V", "fromSpmid", "getFromSpmid", "setFromSpmid", "spmid", "getSpmid", "setSpmid", LoginSceneProcessor.SCENE_KEY, "getScene", "setScene", "avid", "getAvid", "setAvid", "cid", "getCid", "setCid", "seasonid", "getSeasonid", "setSeasonid", "epid", "getEpid", "setEpid", "playbackStatus", "getPlaybackStatus", "setPlaybackStatus", "playbackTime", "getPlaybackTime", "setPlaybackTime", "playbackRate", "getPlaybackRate", "setPlaybackRate", "videoQuality", "getVideoQuality", "setVideoQuality", "isBuffering", "", "()I", "setBuffering", "(I)V", "trackid", "getTrackid", "setTrackid", "Companion", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class HeartbeatDataModel {
    public static final Companion Companion = new Companion(null);
    private int isBuffering;
    private String appRunningState = "";
    private String fromSpmid = "";
    private String spmid = "";
    private String scene = "";
    private String avid = "";
    private String cid = "";
    private String seasonid = "";
    private String epid = "";
    private String playbackStatus = "";
    private String playbackTime = "";
    private String playbackRate = "";
    private String videoQuality = "";
    private String trackid = "";

    public final String getAppRunningState() {
        return this.appRunningState;
    }

    public final void setAppRunningState(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appRunningState = str;
    }

    public final String getFromSpmid() {
        return this.fromSpmid;
    }

    public final void setFromSpmid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fromSpmid = str;
    }

    public final String getSpmid() {
        return this.spmid;
    }

    public final void setSpmid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.spmid = str;
    }

    public final String getScene() {
        return this.scene;
    }

    public final void setScene(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.scene = str;
    }

    public final String getAvid() {
        return this.avid;
    }

    public final void setAvid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.avid = str;
    }

    public final String getCid() {
        return this.cid;
    }

    public final void setCid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cid = str;
    }

    public final String getSeasonid() {
        return this.seasonid;
    }

    public final void setSeasonid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.seasonid = str;
    }

    public final String getEpid() {
        return this.epid;
    }

    public final void setEpid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.epid = str;
    }

    public final String getPlaybackStatus() {
        return this.playbackStatus;
    }

    public final void setPlaybackStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.playbackStatus = str;
    }

    public final String getPlaybackTime() {
        return this.playbackTime;
    }

    public final void setPlaybackTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.playbackTime = str;
    }

    public final String getPlaybackRate() {
        return this.playbackRate;
    }

    public final void setPlaybackRate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.playbackRate = str;
    }

    public final String getVideoQuality() {
        return this.videoQuality;
    }

    public final void setVideoQuality(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoQuality = str;
    }

    public final int isBuffering() {
        return this.isBuffering;
    }

    public final void setBuffering(int i) {
        this.isBuffering = i;
    }

    public final String getTrackid() {
        return this.trackid;
    }

    public final void setTrackid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.trackid = str;
    }

    /* compiled from: HeartbeatDataModel.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Ltv/danmaku/biliplayerimpl/report/heartbeat/HeartbeatDataModel$Companion;", "", "<init>", "()V", "generateFromReportInfo", "Ltv/danmaku/biliplayerimpl/report/heartbeat/HeartbeatDataModel;", "normalDataModel", "Ltv/danmaku/biliplayerv2/service/report/NormalDataModel;", "isBuffering", "", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HeartbeatDataModel generateFromReportInfo(NormalDataModel normalDataModel, boolean isBuffering) {
            Intrinsics.checkNotNullParameter(normalDataModel, "normalDataModel");
            HeartbeatDataModel heartbeatDataModel = new HeartbeatDataModel();
            heartbeatDataModel.setAppRunningState(BiliContext.isVisible() ? "foreground" : BusinessSplashDefineKt.SPLASH_OPEN_EVENT_BACKGROUND);
            heartbeatDataModel.setFromSpmid(normalDataModel.getFromSpmid());
            heartbeatDataModel.setSpmid(normalDataModel.getSpmid());
            heartbeatDataModel.setScene(normalDataModel.getSceneHb());
            heartbeatDataModel.setAvid(normalDataModel.getAvid());
            heartbeatDataModel.setCid(normalDataModel.getCid());
            heartbeatDataModel.setSeasonid(normalDataModel.getSeasonId());
            heartbeatDataModel.setEpid(normalDataModel.getEpId());
            heartbeatDataModel.setPlaybackStatus(normalDataModel.getPlayStateHb());
            heartbeatDataModel.setPlaybackTime(normalDataModel.getProgress());
            heartbeatDataModel.setPlaybackRate(normalDataModel.getSpeed());
            heartbeatDataModel.setVideoQuality(normalDataModel.getPlayerClarity());
            heartbeatDataModel.setBuffering(isBuffering ? 1 : 0);
            heartbeatDataModel.setTrackid(normalDataModel.getTrackId());
            return heartbeatDataModel;
        }
    }
}